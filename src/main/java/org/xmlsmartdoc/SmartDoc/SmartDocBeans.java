/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.xmlsmartdoc.SmartDoc;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.TextArtifact;
import com.AsamiOffice.jaba2.util.UException;
import com.AsamiOffice.jaba2.xml.IProcessor;
import com.AsamiOffice.jaba2.xml.ProcessorFactory;
import com.AsamiOffice.jaba2.xml.XSLTBeans;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.AsamiOffice.io.UFile;
import com.AsamiOffice.io.UURL;

/**
 * SmartDocBeans
 *
 * @since   Jun. 27, 2000
 * @version Dec.  2, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class SmartDocBeans implements Serializable {
    private String inputURI_;
    private String inputSource_;
    private Document inputDocument_;
    private String encoding_ = "UTF-8";
    private String format_ = "html4";
    private String packager_ = "none";
    private List args_ = new ArrayList(); // List<String>
    private XSLTBeans preXSLTBeans_ = null;
    private XSLTBeans postXSLTBeans_ = null;

    public SmartDocBeans() {
    }

    public final void setEncoding(String encoding) {
        encoding_ = encoding;
    }

    public final void setFormat(String format) {
        format_ = format;
    }
    
    public final void setPackager(String packager) {
        packager_ = packager;
    }

    public final void setArgs(String[] args) {
        args_.addAll(Arrays.asList(args));
    }

    public final String[] getArgs() {
        List list = new ArrayList();
        int size = args_.size();
        for (int i = 0; i < size; i++) {
            String arg = (String)args_.get(i);
            if (arg.startsWith("-packager:")) {
                if (!(packager_ != null)) {
                    list.add(arg);
                }
            } else if (arg.startsWith("-encoding:")) {
                if (!(format_ != null && encoding_ != null)) {
                    list.add(arg);
                }
            } else if (arg.startsWith("-format:")) {
                if (format_ == null) {
                    list.add(arg);
                }
            } else {
                list.add(arg);
            }
        }
        if (format_ != null && encoding_ != null) {
            list.add("-" + format_ + "." + "encoding:" +  encoding_);
        }
        if (format_ != null) {
            list.add("-format:" + format_);
        }
        if (packager_ != null) {
            list.add("-packager:" + packager_);
        }
        if (inputURI_ != null) {
            list.add(inputURI_);
        }
        String[] arrayRivised = new String[list.size()];
        return ((String[])list.toArray(arrayRivised));
    }

    public final void setInputURI(String uri) {
        inputURI_ = uri;
    }

    public final String getInputURI() {
        return (inputURI_);
    }

    public final void setInputSource(String source) {
        inputSource_ = source;
    }

    public final String getInputSource() {
        return (inputSource_);
    }

    public final void setPreXSLURI(String uri) {
        preXSLTBeans_ = new XSLTBeans();
        preXSLTBeans_.setXSLURI(uri);
    }

    public final String getPreXSLURI() {
        if (preXSLTBeans_ == null) {
            return (null);
        }
        return (preXSLTBeans_.getXSLURI());
    }

    public final void setPostXSLURI(String uri) {
        postXSLTBeans_ = new XSLTBeans();
        postXSLTBeans_.setXSLURI(uri);
    }

    public final String getPostXSLURI() {
        if (postXSLTBeans_ == null) {
            return (null);
        }
        return (postXSLTBeans_.getXSLURI());
    }

    public final void setInputDocument(Document doc) {
        inputDocument_ = doc;
    }

    public final Document getInputDocument() {
        return (inputDocument_);
    }

    public final byte[] getTargetDocument() {
        try {
            GeneratorArtifact[] artifacts = _getArtifacts();
            if (artifacts.length > 0) {
                return (artifacts[0].getBytes());
            } else {
                return (null);
            }
        } catch (Exception e) {
            return (UException.getDetailInfo(e).getBytes());
        }
    }

    public final String getTargetDocumentAsString() {
        try {
            GeneratorArtifact[] artifacts = _getArtifacts();
            if (artifacts.length > 0) {
                GeneratorArtifact artifact = artifacts[0];
                if (artifact instanceof TextArtifact) {
                    return (((TextArtifact)artifact).getString());
                } else {
                    return (null);
                }
            } else {
                return (null);
            }
        } catch (Exception e) {
            return (UException.getDetailInfo(e));
        }
    }

    public GeneratorArtifact[] getArtifacts() throws Exception {
        String[] args = getArgs();
        Document doc = _getDocument();
        SmartDoc body = new SmartDoc(args);
        body.setup(doc);
        GeneratorResult[] results = body.generateFiles();
        List list = new ArrayList();
        for (int i = 0; i < results.length; i++) {
            GeneratorArtifact[] artifacts = results[i].getArtifacts();
            for (int j = 0; j < artifacts.length; j++) {
                list.add(artifacts[j]);
            }
        }
        GeneratorArtifact[] array = new GeneratorArtifact[list.size()];
        return ((GeneratorArtifact[])list.toArray(array));
    }

    public String getFirstArtifactAsString() throws Exception {
        GeneratorArtifact[] artifacts = getArtifacts();
        if (artifacts.length > 0) {
            GeneratorArtifact artifact = artifacts[0];
            if (artifact instanceof TextArtifact) {
                return (((TextArtifact)artifact).getString());
            } else {
                return (null);
            }
        } else {
            return (null);
        }
    }

    private Document _getDocument() throws SAXException, IOException, ParserConfigurationException, TransformerException {
        Document doc = inputDocument_;
        if (doc == null) {
            if (inputSource_ != null) {
                IProcessor processor = ProcessorFactory.getProcessor();
                doc = processor.parseDocumentByText(inputSource_);
            } else if (inputURI_ != null) {
                IProcessor processor = ProcessorFactory.getProcessor();
                URL url = UURL.getURLFromFileOrURLName(inputURI_);
                doc = processor.parseDocument(url);
            } else {
                throw (new IOException("no document"));
            }
        }
        if (preXSLTBeans_ != null) {
            preXSLTBeans_.setInputDocument(doc);
            return (preXSLTBeans_.getTargetDocument());
        }
        return (doc);
    }

    private GeneratorArtifact[] _getArtifacts() {
        try {
            return (getArtifacts());
        } catch (Exception e) {
            GeneratorArtifact artifact =
                new TextArtifact("error", UException.getDetailInfo(e));
            return (new GeneratorArtifact[] { artifact });
        }
    }

    public static class Artifact {
        public String name;
        public String content;
    }

    // test driver
    public static void main(String[] args) throws Exception {
        SmartDocBeans beans = new SmartDocBeans();
        beans.setArgs(args);
        IProcessor processor = ProcessorFactory.getProcessor();
        URL url = UURL.getURLFromFileOrURLName(args[0]);
        Document doc = processor.parseDocument(url);
        beans.setInputDocument(doc);
        byte[] target = beans.getTargetDocument();
        UFile.createFile(new File("junk.junk"), target);
    }
}
