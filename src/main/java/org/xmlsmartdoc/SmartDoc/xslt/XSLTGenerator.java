/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.xslt;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xmlsmartdoc.SmartDoc.AbstractSmartDocGenerator;
import org.xmlsmartdoc.SmartDoc.GeneratorParameter;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.USmartDoc;
import org.xmlsmartdoc.SmartDoc.pure.PureGenerator;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.IGeneratorParameter;
import com.AsamiOffice.jaba2.j2fw.generator.TextArtifact;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.text.updater.UUpdater;
import com.AsamiOffice.jaba2.xml.IProcessor;
import com.AsamiOffice.jaba2.xml.ProcessorFactory;
import com.AsamiOffice.jaba2.xml.XSLTBeans;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.AsamiOffice.xml.UXMLMaker;

/**
 * XSLTGenerator
 *
 * @since   Aug.  5, 2000
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class XSLTGenerator extends AbstractSmartDocGenerator {
    protected XSLTConfig xsltConfig_;
    protected PureGenerator pureGenerator_;
    protected XSLTBeans xslt_ = new XSLTBeans();

    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        super.init(config, fconfig);
        xsltConfig_ = (XSLTConfig)fconfig;
        pureGenerator_ = (PureGenerator)xsltConfig_.getDelegationGenerator();
    }

    // AbstractYaGenerator
    public GeneratorResult generate(IGeneratorParameter iparam) {
        GeneratorParameter param = (GeneratorParameter)iparam;
        GeneratorResult result = pureGenerator_.generate(param);
        try {
            GeneratorResult finalResult = new GeneratorResult();
            xslt_.setXSLURI(xsltConfig_.getXSLURI());
            String suffix = xsltConfig_.getSuffix();
            String encoding = xsltConfig_.getEncoding(param.doc);
            xslt_.setOutputEncoding(encoding);
            GeneratorArtifact[] artifacts = result.getArtifacts();
            for (int i = 0; i < artifacts.length; i++) {
                GeneratorArtifact artifact = artifacts[i];
                if (artifact instanceof TextArtifact) {
                    TextArtifact text = (TextArtifact)artifact;
                    String target = text.getString();
                    target = _applyPreRegex(target);
                    target = _applyPreTextRegex(target);
                    xslt_.setInputSource(target);
                    target = xslt_.getTargetDocumentAsString();
                    target = _applyRegex(target);
                    String fileName = text.getName();
                    finalResult.addArtifact(
                        UString.changeSuffix(fileName, suffix),
                        target,
                        encoding);
                } else {
                    finalResult.addArtifact(artifact);
                }
            }
            return (finalResult);
        } catch (MalformedURLException e) {
            USmartDoc.error(e.getMessage());
        } catch (IOException e) {
            USmartDoc.error(e.getMessage());
        } catch (SAXException e) {
            USmartDoc.error(e.getMessage());
        } catch (ParserConfigurationException e) {
            USmartDoc.error(e.getMessage());
        } catch (TransformerException e) {
            USmartDoc.error(e.getMessage());
        }
        return (result);
    }

    protected String _applyPreRegex(String text)
        throws MalformedURLException, IOException {

        String uri = xsltConfig_.getPreRegexRule();
        if (uri == null) {
            return (text);
        }
        return (UUpdater.replace(text, uri));
    }

    protected String _applyPreTextRegex(String text)
        throws MalformedURLException, IOException {

        String uri = xsltConfig_.getPreTextRegexRule();
        if (uri == null) {
            return (text);
        }
        IProcessor processor = ProcessorFactory.getProcessor();
        Document doc = processor.parseDocumentByText(text);
        _replaceTextNode(doc, uri);
        return (UXMLMaker.getXMLText(doc));
    }

    protected String _applyRegex(String text)
        throws MalformedURLException, IOException {

        String uri = xsltConfig_.getRegexRule();
        if (uri == null) {
            return (text);
        }
        return (UUpdater.replace(text, uri));
    }

    private void _replaceTextNode(Document doc, String uri) {
        return; // XXX
    }
}
