/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@relaxer.org)
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

package com.AsamiOffice.xml.sax;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * DOMMakerContentHandler
 *
 * @since   Feb. 20, 2003
 * @version Feb. 20, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class DOMMakerContentHandler implements ContentHandler {
    private Document doc_;
    private Element element_;

    public DOMMakerContentHandler() throws ParserConfigurationException {
	DocumentBuilderFactory factory
	    = DocumentBuilderFactory.newInstance();
	factory.setNamespaceAware(true);
	DocumentBuilder builder = factory.newDocumentBuilder();
	doc_ = builder.newDocument();
	element_ = null;
    }

    public Document getDocument() {
	return (doc_);
    }

    // ContentHandler
    public void setDocumentLocator(Locator locator) {
    }

    public void startDocument() {
    }

    public void endDocument() {
    }

    public void startPrefixMapping(String prefix, String uri) {
	//
    }

    public void endPrefixMapping(String prefix) {
	//
    }

    public void startElement(
	String namespaceURI,
	String localName,
	String qName,
	Attributes atts
    ) {
	Element element = doc_.createElementNS(namespaceURI, qName);
	if (element_ != null) {
	    element_.appendChild(element);
	} else {
	    doc_.appendChild(element);
	}
	int nAttrs = atts.getLength();
	for (int i = 0;i < nAttrs;i++) {
	    String attrUri = atts.getURI(i);
	    String attrQName = atts.getQName(i);
	    String attrValue = atts.getValue(i);
	    if ("".equals(attrUri)) {
		element.setAttribute(attrQName, attrValue);
	    } else {
		element.setAttributeNS(attrUri, attrQName, attrValue);
	    }
	}
	element_ = element;
    }

    public void endElement(
	String namespaceURI,
	String localName,
	String qName
    ) {
	Node node = element_.getParentNode();
	if (node instanceof Element) {
	    element_ = (Element)node;
	} else {
	    element_ = null;
	}
    }

    public void characters(char ch[], int start, int length) {
	if (element_ != null) {
	    element_.appendChild(
		doc_.createTextNode(new String(ch, start, length))
	    );
	}
    }

    public void ignorableWhitespace(char ch[], int start, int length) {
    }

    public void processingInstruction(String target, String data) {
    }

    public void skippedEntity(String name) {
    }
}
