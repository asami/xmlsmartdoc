/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2002  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.runtime;

import java.util.StringTokenizer;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.AttributeListImpl;
import org.w3c.dom.*;

/**
 * URVerifyReport
 *
 * @since   Jan. 29, 2002
 * @version Dec. 29, 2002
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class URVerifyReport implements IRVerifyReportConstants {
    public static String getTextDocument(RVerifyReport report) {
	StringBuffer buffer = new StringBuffer();
	makeTextDocument(report, buffer);
	return (new String(buffer));
    }

    public static String getMessage(RVerifyReport report) {
	StringBuffer buffer = new StringBuffer();
	makeTextDocument(report, "", buffer);
	return (new String(buffer));
    }

    public static void makeTextDocument(
	RVerifyReport report,
	StringBuffer buffer
    ) {
	makeTextDocument(report, "\n", buffer);
    }

    public static void makeTextDocument(
	RVerifyReport report,
	String newline,
	StringBuffer buffer
    ) {
	buffer.append("<report");
	buffer.append(" xmlns=\"");
	buffer.append(VERIFY_REPORT_NS);
	buffer.append("\"");
	buffer.append(">");
	buffer.append(newline);
	RVerifyReport.Item[] items = report.getItems();
	for (int i = 0;i < items.length;i++) {
	    makeElement(items[i], newline, buffer);
	}
	buffer.append("</report>");
	buffer.append(newline);
    }

    public static void makeElement(
	RVerifyReport.Item item,
	String newline,
	StringBuffer buffer
    ) {
	buffer.append("<error>");
	buffer.append(newline);
	_makeElementSlot("path", item.path, newline, buffer);
	_makeElementSlot("parent", item.parent, newline, buffer);
	_makeElementSlot("leaf", item.leaf, newline, buffer);
	if (item.index != -1) {
	    _makeElementSlot("index", item.index + 1, newline, buffer);
	}
	_makeElementSlot("status", item.status, newline, buffer);
	_makeElementSlot("value", item.value, newline, buffer);
	_makeTypeInformation(item.type, newline, buffer);
	_makeElementSlot("message", item.message, newline, buffer);
	buffer.append("</error>");
	buffer.append(newline);
    }

    public static void _makeTypeInformation(
	String type,
	String newline,
	StringBuffer buffer
    ) {
	String name = getTypeName(type);
	String[][] facets = getFacetsAsStringArrays(type);
	buffer.append("<type>");
	buffer.append(newline);
	_makeElementSlot("name", name, newline, buffer);
	if (facets != null) {
	    for (int i = 0;i < facets.length;i++) {
		_makeElementSlot(facets[i][0], facets[i][1], newline, buffer);
	    }
	}
	buffer.append("</type>");
	buffer.append(newline);
    }

    private static void _makeElementSlot(
	String tagName,
	Object value,
	String newline,
	StringBuffer buffer
    ) {
	buffer.append("<");
	buffer.append(tagName);
	buffer.append(">");
	if (value != null) {
	    buffer.append(value.toString());
	}
	buffer.append("</");
	buffer.append(tagName);
	buffer.append(">");
	buffer.append(newline);
    }

    private static void _makeElementSlot(
	String tagName,
	int value,
	String newline,
	StringBuffer buffer
    ) {
	_makeElementSlot(tagName, Integer.toString(value), newline, buffer);
    }

    public static Document getDocument(RVerifyReport report)
	throws ParserConfigurationException {

        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
	Document doc = builder.newDocument();
	makeDocument(report, doc);
	return (doc);
    }

    public static void makeDocument(RVerifyReport report, Document doc) {
	if (true) {
	    makeDocument1(report, doc);
	} else {
	    makeDocument2(report, doc);
	}
    }

    public static void makeDocument1(RVerifyReport report, Document doc) {
	Element root = doc.createElement("report");
	doc.appendChild(root);
	RVerifyReport.Item[] items = report.getItems();
	for (int i = 0;i < items.length;i++) {
	    makeElement1(root, items[i]);
	}
    }

    public static void makeElement1(Element root, RVerifyReport.Item item) {
	_makeElementSlot(root, "path", item.path);
	_makeElementSlot(root, "parent", item.parent);
	_makeElementSlot(root, "leaf", item.leaf);
	if (item.index != -1) {
	    _makeElementSlot(root, "index", item.index + 1);
	}
	_makeElementSlot(root, "status", item.status);
	_makeElementSlot(root, "value", item.value);
	_makeElementSlot(root, "type", item.type);
	_makeElementSlot(root, "message", item.message);
    }

    private static void _makeElementSlot(
	Element parent,
	String tagName,
	Object value
    ) {
	Document doc = parent.getOwnerDocument();
	Element slot = doc.createElement(tagName);
	slot.appendChild(doc.createTextNode(value.toString()));
	parent.appendChild(slot);
    }

    private static void _makeElementSlot(
	Element parent,
	String tagName,
	int value
    ) {
	_makeElementSlot(parent, tagName, Integer.toString(value));
    }    

    public static void makeDocument2(RVerifyReport report, Document doc) {
	Element root = doc.createElement("report");
	doc.appendChild(root);
	RVerifyReport.Item[] items = report.getItems();
	for (int i = 0;i < items.length;i++) {
	    makeElement2(root, items[i]);
	}
    }

    public static void makeElement2(Element root, RVerifyReport.Item item) {
	throw (new UnsupportedOperationException());
    }

    public static void makeDocument(
	RVerifyReport report,
	DocumentHandler handler
    ) throws SAXException {
	handler.startElement("report", __getNopAttributeList());
	RVerifyReport.Item[] items = report.getItems();
	for (int i = 0;i < items.length;i++) {
	    makeElement(items[i], handler);
	}
	handler.endElement("report");
    }

    public static void makeElement(
	RVerifyReport.Item item,
	DocumentHandler handler
    ) throws SAXException {
	handler.startElement("error", __getNopAttributeList());
	_makeElementSlot("path", item.path, handler);
	_makeElementSlot("parent", item.parent, handler);
	_makeElementSlot("leaf", item.leaf, handler);
	if (item.index != -1) {
	    _makeElementSlot("index", item.index + 1, handler);
	}
	_makeElementSlot("status", item.status, handler);
	_makeElementSlot("value", item.value, handler);
	_makeElementSlot("type", item.type, handler);
	_makeElementSlot("message", item.message, handler);
	handler.endElement("error");
    }

    private static void _makeElementSlot(
	String tagName,
	Object value,
	DocumentHandler handler
    ) throws SAXException {
	char[] data = value.toString().toCharArray();
	handler.startElement(tagName, __getNopAttributeList());
	handler.characters(data, data.length, 0);
	handler.endElement(tagName);
    }

    private static void _makeElementSlot(
	String tagName,
	int value,
	DocumentHandler handler
    ) throws SAXException {
	_makeElementSlot(tagName, Integer.toString(value), handler);
    }    

    public static void makeDocument(
	RVerifyReport report,
	ContentHandler handler
    ) {
	throw (new UnsupportedOperationException());
    }

    public static String getTypeName(String type) {
	StringTokenizer st = new StringTokenizer(type, " {");
	return (st.nextToken());
    }

    public static String[][] getFacetsAsStringArrays(String type) {
	int start = type.indexOf("{");
	if (start == - 1) {
	    return (null);
	}
	int end = type.indexOf("}");
	String facetsString;
	if (end == -1) {
	    facetsString = type.substring(start + 1);
	} else {
	    facetsString = type.substring(start + 1, end);
	}
	StringTokenizer st = new StringTokenizer(facetsString, ";");
	String[][] facets = new String[st.countTokens()][];
	for (int i = 0;i < facets.length;i++) {
	    String[] facet = new String[2];
	    String text = st.nextToken();
	    int index = text.indexOf(":");
	    facet[0] = text.substring(0, index).trim();
	    facet[1] = text.substring(index + 1).trim();
	    facets[i] = facet;
	}
	return (facets);
    }

    //
    private static AttributeList nopAttributeList__ = null;

    private static AttributeList __getNopAttributeList() {
        if (nopAttributeList__ == null) {
            nopAttributeList__ = new AttributeListImpl();
        }
	return (nopAttributeList__);
    }
}


