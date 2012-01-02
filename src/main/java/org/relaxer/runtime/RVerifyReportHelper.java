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
import org.xml.sax.helpers.AttributesImpl;
import org.w3c.dom.*;

/**
 * RVerifyReportHelper
 *
 * @since   Mar. 12, 2002
 * @version Mar. 13, 2002
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RVerifyReportHelper implements IRVerifyReportConstants {
    private boolean isUseNamespace_ = false;
    private boolean isUseDom2_ = true;
    private String prefix_ = null;

    public void setUseNamespace(boolean useNamespace) {
	isUseNamespace_ = useNamespace;
    }

    public void setUseDom2(boolean useDom2) {
	isUseDom2_ = useDom2;
    }

    public void setPrefix(String prefix) {
	prefix_ = prefix;
    }

    public String getTextDocument(RVerifyReport report) {
	StringBuffer buffer = new StringBuffer();
	makeTextDocument(report, buffer);
	return (new String(buffer));
    }

    public void makeTextDocument(
	RVerifyReport report,
	StringBuffer buffer
    ) {
	buffer.append("<");
	if (prefix_ != null) {
	    buffer.append(prefix_);
	    buffer.append(":");
	}
	buffer.append("report");
	if (isUseNamespace_) {
	    buffer.append(" xmlns");
	    if (prefix_ != null) {
		buffer.append(prefix_);
		buffer.append(":");
	    }
	    buffer.append("=\"");
	    buffer.append(VERIFY_REPORT_NS);
	    buffer.append("\"");
	}
	buffer.append(">\n");
	RVerifyReport.Item[] items = report.getItems();
	for (int i = 0;i < items.length;i++) {
	    makeElement(items[i], buffer);
	}
	buffer.append("</");
	if (prefix_ != null) {
	    buffer.append(prefix_);
	    buffer.append(":");
	}
	buffer.append("report>\n");
    }

    public void makeElement(
	RVerifyReport.Item item,
	StringBuffer buffer
    ) {
	buffer.append("<");
	if (prefix_ != null) {
	    buffer.append(prefix_);
	    buffer.append(":");
	}
	buffer.append("error>\n");
	_makeElementSlot("path", item.path, buffer);
	_makeElementSlot("parent", item.parent, buffer);
	_makeElementSlot("leaf", item.leaf, buffer);
	if (item.index != -1) {
	    _makeElementSlot("index", item.index + 1, buffer);
	}
	_makeElementSlot("value", item.value, buffer);
	_makeTypeInformation(item.type, buffer);
	_makeElementSlot("message", item.message, buffer);
	buffer.append("</");
	if (prefix_ != null) {
	    buffer.append(prefix_);
	    buffer.append(":");
	}
	buffer.append("error>\n");
    }

    public void _makeTypeInformation(
	String type,
	StringBuffer buffer
    ) {
	String name = getTypeName(type);
	String[][] facets = getFacetsAsStringArrays(type);
	buffer.append("<type");
	if (prefix_ != null) {
	    buffer.append(prefix_);
	    buffer.append(":");
	}
	buffer.append(">\n");
	_makeElementSlot("name", name, buffer);
	if (facets != null) {
	    for (int i = 0;i < facets.length;i++) {
		_makeElementSlot(facets[i][0], facets[i][1], buffer);
	    }
	}
	buffer.append("</");
	if (prefix_ != null) {
	    buffer.append(prefix_);
	    buffer.append(":");
	}
	buffer.append("type>\n");
    }

    private void _makeElementSlot(
	String tagName,
	Object value,
	StringBuffer buffer
    ) {
	buffer.append("<");
	if (prefix_ != null) {
	    buffer.append(prefix_);
	    buffer.append(":");
	}
	buffer.append(tagName);
	buffer.append(">");
	buffer.append(value.toString());
	buffer.append("</");
	if (prefix_ != null) {
	    buffer.append(prefix_);
	    buffer.append(":");
	}
	buffer.append(tagName);
	buffer.append(">\n");
    }

    private String _makeTagName(String name) {
	if (prefix_ != null) {
	    return (prefix_ + ":" + name);
	} else {
	    return (name);
	}
    }

    private void _makeElementSlot(
	String tagName,
	int value,
	StringBuffer buffer
    ) {
	_makeElementSlot(tagName, Integer.toString(value), buffer);
    }

    public Document getDocument(RVerifyReport report)
	throws ParserConfigurationException {

        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
	Document doc = builder.newDocument();
	makeDocument(report, doc);
	return (doc);
    }

    public void makeDocument(RVerifyReport report, Document doc) {
	Element root = _makeRootNode(doc);
	doc.appendChild(root);
	RVerifyReport.Item[] items = report.getItems();
	for (int i = 0;i < items.length;i++) {
	    makeElement(root, items[i]);
	}
    }

    private Element _makeRootNode(Document doc) {
	if (isUseDom2_) {
	    if (isUseNamespace_) {
		return (_makeRootNode2NS(doc));
	    } else {
		return (_makeRootNode2(doc));
	    }
	} else {
	    if (isUseNamespace_) {
		return (_makeRootNode1NS(doc));
	    } else {
		return (_makeRootNode1(doc));
	    }
	}
    }

    private Element _makeRootNode1(Document doc) {
	Element root = doc.createElement(_makeTagName("report"));
	return (root);
    }

    private Element _makeRootNode1NS(Document doc) {
	Element root = doc.createElement(_makeTagName("report"));
	if (isUseNamespace_) {
	    if (prefix_ != null) {
		root.setAttribute("xmlns:" + prefix_, VERIFY_REPORT_NS);
	    } else {
		root.setAttribute("xmlns", VERIFY_REPORT_NS);
	    }
	}
	return (root);
    }

    private Element _makeRootNode2(Document doc) {
	Element root = doc.createElement(_makeTagName("report"));
	return (root);
    }

    private Element _makeRootNode2NS(Document doc) {
	Element root = doc.createElementNS(
	    VERIFY_REPORT_NS, _makeTagName("report")
	);
	return (root);
    }

    public void makeElement(Element root, RVerifyReport.Item item) {
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

    private void _makeElementSlot(
	Element parent,
	String tagName,
	int value
    ) {
	_makeElementSlot(parent, tagName, Integer.toString(value));
    }    

    private void _makeElementSlot(
	Element parent,
	String tagName,
	Object value
    ) {
	Document doc = parent.getOwnerDocument();
	Element slot = _makeElement(tagName, doc);
	slot.appendChild(doc.createTextNode(value.toString()));
	parent.appendChild(slot);
    }

    private Element _makeElement(String tagName, Document doc) {
	if (isUseDom2_) {
	    if (isUseNamespace_) {
		return (
		    doc.createElementNS(
			VERIFY_REPORT_NS,
			_makeTagName(tagName)
		    )
		);
	    } else {
		return (doc.createElement(_makeTagName(tagName)));
	    }
	} else {
	    if (isUseNamespace_) {
		Element element = doc.createElement(_makeTagName(tagName));
		// namespace declaration has been already done.
		return (element);
	    } else {
		return (doc.createElement(_makeTagName(tagName)));
	    }
	}
    }

    // SAX1
    public void makeDocument(
	RVerifyReport report,
	DocumentHandler handler
    ) throws SAXException {
	handler.startDocument();
	handler.startElement(_makeTagName("report"), __getNopAttributeList());
	RVerifyReport.Item[] items = report.getItems();
	for (int i = 0;i < items.length;i++) {
	    makeElement(items[i], handler);
	}
	handler.endElement(_makeTagName("report"));
	handler.endDocument();
    }

    public void makeElement(
	RVerifyReport.Item item,
	DocumentHandler handler
    ) throws SAXException {
	handler.startElement(_makeTagName("error"), __getNopAttributeList());
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
	handler.endElement(_makeTagName("error"));
    }

    private void _makeElementSlot(
	String tagName,
	int value,
	DocumentHandler handler
    ) throws SAXException {
	_makeElementSlot(tagName, Integer.toString(value), handler);
    }    

    private void _makeElementSlot(
	String tagName,
	Object value,
	DocumentHandler handler
    ) throws SAXException {
	char[] data = value.toString().toCharArray();
	handler.startElement(_makeTagName(tagName), __getNopAttributeList());
	handler.characters(data, data.length, 0);
	handler.endElement(_makeTagName(tagName));
    }

    // SAX2
    public void makeDocument(
	RVerifyReport report,
	ContentHandler handler
    ) throws SAXException {
	handler.startDocument();
	handler.startElement(
	    VERIFY_REPORT_NS,
	    "report",
	    _makeTagName("report"),
	    __getNopAttributes()
	);
	RVerifyReport.Item[] items = report.getItems();
	for (int i = 0;i < items.length;i++) {
	    makeElement(items[i], handler);
	}
	handler.endElement(
	    VERIFY_REPORT_NS,
	    "report",
	    _makeTagName("report")
	);
	handler.endDocument();
    }

    public void makeElement(
	RVerifyReport.Item item,
	ContentHandler handler
    ) throws SAXException {
	handler.startElement(
	    VERIFY_REPORT_NS,
	    "error",
	    _makeTagName("error"),
	    __getNopAttributes()
	);
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
	handler.endElement(
	    VERIFY_REPORT_NS,
	    "error",
	    _makeTagName("error")
	);
    }

    private void _makeElementSlot(
	String tagName,
	int value,
	ContentHandler handler
    ) throws SAXException {
	_makeElementSlot(tagName, Integer.toString(value), handler);
    }    

    private void _makeElementSlot(
	String tagName,
	Object value,
	ContentHandler handler
    ) throws SAXException {
	char[] data = value.toString().toCharArray();
	handler.startElement(
	    VERIFY_REPORT_NS,
	    tagName,
	    _makeTagName(tagName),
	    __getNopAttributes()
	);
	handler.characters(data, data.length, 0);
	handler.endElement(
	    VERIFY_REPORT_NS,
	    tagName,
	    _makeTagName(tagName)
	);
    }

    //
    public String getTypeName(String type) {
	StringTokenizer st = new StringTokenizer(type, " {");
	return (st.nextToken());
    }

    public String[][] getFacetsAsStringArrays(String type) {
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
    private static Attributes nopAttributes__ = null;

    private static AttributeList __getNopAttributeList() {
        if (nopAttributeList__ == null) {
            nopAttributeList__ = new AttributeListImpl();
        }
	return (nopAttributeList__);
    }

    private static Attributes __getNopAttributes() {
        if (nopAttributes__ == null) {
            nopAttributes__ = new AttributesImpl();
        }
	return (nopAttributes__);
    }
}


