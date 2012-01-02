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

package com.AsamiOffice.jaba2.xml.pdom;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * The JAXPPDOMFactory is a Factory to generate PDOM objects using
 * the IBM XML for Java DOM parser.
 *
 * @since   Apr. 24, 1998
 * @version Oct. 17, 2003
 + @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class JAXPPDOMFactory extends AbstractPDOMFactory {
    public PDocument generateDoc(URL url) throws IOException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());
            return (_generatePDocument(doc));
        } catch (ParserConfigurationException e) {
            throw (new IOException(e.getMessage()));
        } catch (SAXException e) {
            throw (new IOException(e.getMessage()));
        } catch (IOException e) {
            throw (new IOException(e.getMessage()));
        }
    }

/*
    public PDocumentType generateDTD(URL url) throws IOException {
	Parser parser = new Parser(url.toString());
	DocumentType dtd = parser.readDTDStream(url.openStream());
	return (_generatePDocumentType(dtd));
    }
*/

    public PDocument generateDoc(String text) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(text));
            Document doc = builder.parse(is);
            return (_generatePDocument(doc));
        } catch (ParserConfigurationException e) {
            throw (new InternalError(e.getMessage()));
        } catch (SAXException e) {
            throw (new InternalError(e.getMessage()));
        } catch (IOException e) {
            throw (new InternalError(e.getMessage()));
        }
    }

/*
    public PDocumentType generateDTD(String text) {
	try {
	    Parser parser = new Parser("text");
	    DocumentType dtd = parser.readDTDStream(new StringReader(text));
	    return (_generatePDocumentType(dtd));
	} catch (IOException e) {
	    throw (new InternalError(e.toString()));
	}
    }
*/
}
