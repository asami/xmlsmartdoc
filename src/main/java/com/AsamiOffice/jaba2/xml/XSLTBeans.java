/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
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
package com.AsamiOffice.jaba2.xml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.AsamiOffice.io.UURL;

/**
 * XSLTBeans
 *
 * @since   Jul. 10, 2000
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class XSLTBeans implements Cloneable, java.io.Serializable {
    private String inputURI_;
    private String inputSource_;
    private Document inputDocument_;
    private String xslURI_;
    private Document xslDocument_;
    private String encoding_;
    private Map params_ = new HashMap();

    public XSLTBeans() {
    }

    public void setInputURI(String uri) {
        inputURI_ = uri;
    }

    public String getInputURI() {
        return (inputURI_);
    }

    public final void setInputSource(String source) {
        inputSource_ = source;
    }

    public final String getInputSource() {
        return (inputSource_);
    }

    public void setInputDocument(Document doc) {
        inputDocument_ = doc;
    }

    public Document getInputDocument() {
        return (inputDocument_);
    }

    public void setXSLURI(String uri) {
        xslURI_ = uri;
    }

    public String getXSLURI() {
        return (xslURI_);
    }

    public void setStylesheetParam(String name, String value) {
        params_.put(name, value);
    }

    public Document getTargetDocument() throws SAXException, IOException, ParserConfigurationException, TransformerException {
        return (_generate());
    }

    public String getTargetDocumentAsString()
        throws SAXException, IOException, ParserConfigurationException, TransformerException {

        return (_generateString());
    }

    public String toString() {
        try {
            return (_generateString());
        } catch (SAXException e) {
            return ("XSLTBeans : " + e.getMessage());
        } catch (IOException e) {
            return ("XSLTBeans : " + e.getMessage());
        } catch (ParserConfigurationException e) {
            return ("XSLTBeans : " + e.getMessage());
        } catch (TransformerException e) {
            return ("XSLTBeans : " + e.getMessage());
        }
    }

    public String getOutputEncoding() throws SAXException, IOException, ParserConfigurationException {
        Document doc = _getXslDocument();
        return (UXSL.getEncoding(doc));
    }

    public void setOutputEncoding(String encoding)
        throws SAXException, IOException, ParserConfigurationException {

        UXSL.setEncoding(_getXslDocument(), encoding);
    }

    private String _generateString() throws SAXException, IOException, ParserConfigurationException, TransformerException {
        DOMSource input = new DOMSource(_getInputDocument());
        Document xslDoc = _getXslDocument();
        String encoding = UXSL.getEncoding(xslDoc);
        DOMSource xsl = new DOMSource(xslDoc);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        StreamResult target = new StreamResult(out);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer processor = factory.newTransformer(xsl);
        _setParams(processor);
        processor.transform(input, target);
        return (out.toString(encoding));
    }

    private Document _generate() throws SAXException, IOException, ParserConfigurationException, TransformerException {
        DOMSource input = new DOMSource(_getInputDocument());
        Document xslDoc = _getXslDocument();
        String encoding = UXSL.getEncoding(xslDoc);
        DOMSource xsl = new DOMSource(xslDoc);
        DOMResult target = new DOMResult();
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer processor = factory.newTransformer(xsl);
        _setParams(processor);
        processor.transform(input, target);
        return ((Document)target.getNode());
    }

    private void _setParams(Transformer processor) {
        Set keys = params_.keySet();
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            String key = (String)iter.next();
            String value = (String)params_.get(key);
            processor.setParameter(key, value);
        }
    }

    private Document _getInputDocument() throws SAXException, IOException, ParserConfigurationException {
        Document doc = inputDocument_;
        if (doc == null) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            if (inputSource_ != null) {
                doc = builder.parse(inputSource_);
            } else if (inputURI_ != null) {
                URL url = UURL.getURLFromFileOrURLName(inputURI_);
                doc = builder.parse(url.toExternalForm());
            } else {
                throw (new IOException("no document"));
            }
        }
        return (doc);
    }

    private Document _getXslDocument() throws SAXException, IOException, ParserConfigurationException {
        if (xslDocument_ == null) {
            xslDocument_ = _getDocument(xslURI_);
        }
        return (xslDocument_);
    }

    private Document _getDocument(String uri)
        throws SAXException, IOException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return (builder.parse(uri));
    }

    private String _getInputInfo() {
        if (inputURI_ != null) {
            return (inputURI_);
        } else if (inputSource_ != null) {
            return ("source");
        } else if (inputDocument_ != null) {
            return ("doc");
        } else {
            return ("unknown");
        }
    }

    // test driver
    public static void main(String[] args) throws Exception {
        String in = args[0];
        String xsl = args[1];
        XSLTBeans beans = new XSLTBeans();
        beans.setInputURI(in);
        beans.setXSLURI(xsl);
        PrintWriter out = new PrintWriter(System.out);
        out.println(beans.getTargetDocumentAsString());
        out.flush();

        out.println(beans.getTargetDocument());
        out.flush();
    }
}
