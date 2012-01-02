/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package com.AsamiOffice.jaba2.xml.processor;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.AsamiOffice.xml.sax.USAX;

/**
 * JAXPProcessor
 *
 * @since   Jul. 18, 2000
 * @version Oct. 15, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class JAXPProcessor extends AbstractProcessor {
    public JAXPProcessor() {
    }

    public Document parseDocument(URL url) throws IOException {
        try {
            DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(getEntityResolver());
            builder.setErrorHandler(getErrorHandler());
            Document doc = builder.parse(url.toString());
            return (doc);
        } catch (SAXParseException e) {
            throw (new IOException(USAX.getMessage(e)));
        } catch (SAXException e) {
            throw (new IOException(e.getMessage()));
        } catch (ParserConfigurationException e) {
            throw (new InternalError());
        }
    }

    public Document parseValidDocument(URL url) throws IOException {
        try {
            DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(getEntityResolver());
            builder.setErrorHandler(getErrorHandler());
            Document doc = builder.parse(url.toString());
            return (doc);
        } catch (SAXParseException e) {
            throw (new IOException(USAX.getMessage(e)));
        } catch (SAXException e) {
            throw (new IOException(e.getMessage()));
        } catch (ParserConfigurationException e) {
            throw (new InternalError());
        }
    }

    public Document parseDocumentByText(String text) throws IOException {
        try {
            DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(getEntityResolver());
            builder.setErrorHandler(getErrorHandler());
            Document doc =
                builder.parse(new InputSource(new StringReader(text)));
            return (doc);
        } catch (SAXParseException e) {
            throw (new IOException(USAX.getMessage(e)));
        } catch (SAXException e) {
            throw (new IOException(e.getMessage()));
        } catch (ParserConfigurationException e) {
            throw (new InternalError());
        }
    }

    public Document parseValidDocumentByText(String text) throws IOException {
        try {
            DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(getEntityResolver());
            builder.setErrorHandler(getErrorHandler());
            Document doc =
                builder.parse(new InputSource(new StringReader(text)));
            return (doc);
        } catch (SAXParseException e) {
            throw (new IOException(USAX.getMessage(e)));
        } catch (SAXException e) {
            throw (new IOException(e.getMessage()));
        } catch (ParserConfigurationException e) {
            throw (new InternalError());
        }
    }

    public Document newDocument() {
        try {
            DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(getEntityResolver());
            builder.setErrorHandler(getErrorHandler());
            Document doc = builder.newDocument();
            return (doc);
        } catch (ParserConfigurationException e) {
            throw (new InternalError());
        }
    }
}
