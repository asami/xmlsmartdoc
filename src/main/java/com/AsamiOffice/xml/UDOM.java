/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

package com.AsamiOffice.xml;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.AsamiOffice.xml.visitor.UDOMVisitor;
import com.AsamiOffice.io.UURL;
import com.AsamiOffice.io.UFile;

/**
 * UDOM
 *
 * @since   Jul.  1, 1998
 * @version Aug. 17, 2005
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public final class UDOM {
    public static String makeTextDocument(Node node) {
        XMLMaker maker = new XMLMaker();
        UDOMVisitor.traverse(node, maker);
        return (maker.getText());
    }

    public static String makeTextDocumentVisual(Node node) {
        XMLMaker maker = new XMLMaker();
        maker.setVisual(true);
        UDOMVisitor.traverse(node, maker);
        return (maker.getText());
    }

    public static boolean isParsedEntity(EntityReference entityRef) {
        String name = entityRef.getNodeName();
        Document doc = entityRef.getOwnerDocument();
        DocumentType doctype = doc.getDoctype();
        if (doctype == null) {
            return (false);
        }
        NamedNodeMap entities = doctype.getEntities();
        Entity entity = (Entity)entities.getNamedItem(name);
        if (entity == null) {
            return (false);
        }
        return (entity.getNotationName() == null);
    }

    public static String escape(String string) {
        if (string.indexOf('<') == -1 &&
            string.indexOf('>') == -1 &&
            string.indexOf('&') == -1 &&
            string.indexOf('"') == -1 &&
            string.indexOf('\'') == -1) {

            return (string);
        }
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            if (c == '<') {
                buffer.append("&lt;");
            } else if (c == '>') {
                buffer.append("&gt;");
            } else if (c == '&') {
                buffer.append("&amp;");
            } else if (c == '"') {
                buffer.append("&quot;");
            } else if (c == '\'') {
                buffer.append("&apos;");
            } else {
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    public static String escapeEntityQuot(String string) {
        if (string.indexOf('%') == -1 &&
            string.indexOf('&') == -1 &&
            string.indexOf('"') == -1) {

            return (string);
        }
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            if (c == '%') {
                buffer.append("&---;");
            } else if (c == '&') {
                buffer.append("&amp;");
            } else if (c == '"') {
                buffer.append("&quot;");
            } else {
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    public static String escapeEntityApos(String string) {
        if (string.indexOf('%') == -1 &&
            string.indexOf('&') == -1 &&
            string.indexOf('\'') == -1) {

            return (string);
        }
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            if (c == '%') {
                buffer.append("&#x25;");
            } else if (c == '&') {
                buffer.append("&amp;");
            } else if (c == '\'') {
                buffer.append("&apos;");
            } else {
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    public static String escapeAttrQuot(String string) {
        if (string.indexOf('<') == -1 &&
            string.indexOf('&') == -1 &&
            string.indexOf('"') == -1) {

            return (string);
        }
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            if (c == '<') {
                buffer.append("&lt;");
            } else if (c == '&') {
                buffer.append("&amp;");
            } else if (c == '"') {
                buffer.append("&quot;");
            } else {
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    public static String escapeAttrApos(String string) {
        if (string.indexOf('<') == -1 &&
            string.indexOf('&') == -1 &&
            string.indexOf('\'') == -1) {

            return (string);
        }
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            if (c == '<') {
                buffer.append("&lt;");
            } else if (c == '&') {
                buffer.append("&amp;");
            } else if (c == '\'') {
                buffer.append("&apos;");
            } else {
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    public static String escapeSystemQuot(String string) {
        if (string.indexOf('"') == -1) {
            return (string);
        }
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            if (c == '"') {
                buffer.append("&quot;");
            } else {
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    public static String escapeSystemApos(String string) {
        if (string.indexOf('\'') == -1) {
            return (string);
        }
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            if (c == '\'') {
                buffer.append("&apos;");
            } else {
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    public static String escapeCharData(String string) {
        if (string.indexOf('<') == -1 &&
            string.indexOf('&') == -1 &&
            string.indexOf('>') == -1) {

            return (string);
        }
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            if (c == '<') {
                buffer.append("&lt;");
            } else if (c == '&') {
                buffer.append("&amp;");
            } else if (c == '>') {
                buffer.append("&gt;");
            } else {
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    public static String escapeCharDataCr(String string) {
        if (string.indexOf('<') == -1 &&
            string.indexOf('&') == -1 &&
            string.indexOf('>') == -1 &&
            string.indexOf('\r') == -1) {

            return (string);
        }
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            if (c == '<') {
                buffer.append("&lt;");
            } else if (c == '&') {
                buffer.append("&amp;");
            } else if (c == '>') {
                buffer.append("&gt;");
            } else if (c == '\r') {
                buffer.append("&#xD;");
            } else {
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    public static Node[] getNodes(Node parent) {
        NodeList children = parent.getChildNodes();
        Node[] nodes = new Node[children.getLength()];
        for (int i = 0;i < nodes.length;i++) {
            nodes[i] = children.item(i);
        }
        return (nodes);
    }

    public static Element[] getElements(Node element) {
        NodeList children = element.getChildNodes();
        List list = new ArrayList();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                list.add(child);
            }
        }
        Element[] array = new Element[list.size()];
        return ((Element[])list.toArray(array));
    }

    public static Element getFirstElement(Element element) {
        NodeList children = element.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                return ((Element)child);
            }
        }
        return (null);
    }

    public static Element[] getElements(Node element, String localName) {
        NodeList children = element.getChildNodes();
        List list = new ArrayList();
        int size = children.getLength();
// System.out.println("getElements - '" + localName + "' : " + size);
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                if (localName.equals(getLocalName((Element)child))) {
                    list.add(child);
                }
            }
        }
        Element[] array = new Element[list.size()];
        return ((Element[])list.toArray(array));
    }

    public static Element[] getElements(
        Node element, 
        String ns,
        String localName
    ) {
        NodeList children = element.getChildNodes();
        List list = new ArrayList();
        int size = children.getLength();
// System.out.println("getElements - '" + localName + "' : " + size);
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                if (localName.equals(getLocalName((Element)child)) &&
                    ns.equals(child.getNamespaceURI())) {
                    list.add(child);
                }
            }
        }
        Element[] array = new Element[list.size()];
        return ((Element[])list.toArray(array));
    }

    public static Element getFirstElement(Node element, String localName) {
        NodeList children = element.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                if (localName.equals(getLocalName((Element)child))) {
                    return ((Element)child);
                }
            }
        }
        return (null);
    }

    public static Element getFirstElement(Element element, String ns, String localName) {
        NodeList children = element.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                if (isMatch(ns, localName, (Element)child)) {
                    return (Element)child;
                }
            }
        }
        return null;
    }

    private static boolean isMatch(String ns, String localName, Element element) {
        return ns.equals(element.getNamespaceURI()) &&
               localName.equals(getLocalName(element));
    }

    public static Element findElement(Document doc, String tag) {
        Element element = doc.getDocumentElement();
        if (tag.equals(element.getTagName())) {
            return (element);
        }
        return (findElement(element, tag));
    }

    public static Element findElement(Element element, String tag) {
        NodeList nodes = element.getChildNodes();
        int nNodes = nodes.getLength();
        for (int i = 0;i < nNodes;i++) {
            Node child = nodes.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element)child;
                if (tag.equals(e.getTagName())) {
                    return (e);
                }
                Element result = findElement(e, tag);
                if (result != null) {
                    return (result);
                }
            }
        }
        return (null);
    }

    public static Element[] collectElements(Element root, String tag) {
        List list = new ArrayList();
        _collectElements(root, tag, list);
        Element[] elements = new Element[list.size()];
        list.toArray(elements);
        return (elements);
    }

    protected static void _collectElements(
        Element element,
        String tag,
        List list
    ) {
        String tagName = element.getTagName();
        if (tag.equals(tagName)) {
            list.add(element);
            return;
        }
        NodeList nodes = element.getChildNodes();
        int nNodes = nodes.getLength();
        for (int i = 0;i < nNodes;i++) {
            Node child = nodes.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                _collectElements((Element)child, tag, list);
            }
        }
    }


    public static String findData(Document doc, String tag) {
        return (findData(doc.getDocumentElement(), tag));
    }

    public static String findData(Element element, String tag) {
        Element e = findElement(element, tag);
        if (e == null) {
            return (null);
        } else {
            return (getDataValue(e));
        }
    }

    public static String findAndDropData(Document doc, String tag) {
        return (findAndDropData(doc.getDocumentElement(), tag));
    }

    public static String findAndDropData(Element element, String tag) {
        NodeList nodes = element.getChildNodes();
        int nNodes = nodes.getLength();
        for (int i = 0;i < nNodes;i++) {
            Node child = nodes.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element)child;
                if (tag.equals(e.getTagName())) {
                    String data = getDataValue(e);
                    e.getParentNode().removeChild(e);           
                    return (data);
                }
                String data = findAndDropData(e, tag);
                if (data != null) {
                    return (data);
                }
            }
        }
        return (null);
    }

    public static String findData(
        Document doc,
        String tag,
        String attr,
        String value
    ) {
        return (findData(doc.getDocumentElement(), tag, attr, value));
    }

    public static String findData(
        Element element,
        String tag,
        String attr,
        String value
    ) {
        NodeList nodes = element.getChildNodes();
        int nNodes = nodes.getLength();
        for (int i = 0;i < nNodes;i++) {
            Node child = nodes.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element)child;
                if (tag.equals(e.getTagName()) &&
                    value.equals(e.getAttribute(attr))) {

                    return (getDataValue(e));
                }
                String data = findData(e, tag, attr, value);
                if (data != null) {
                    return (data);
                }
            }
        }
        return (null);
    }

    public static String findAndDropData(
        Document doc,
        String tag,
        String attr,
        String value
    ) {
        return (findAndDropData(doc.getDocumentElement(), tag, attr, value));
    }

    public static String findAndDropData(
        Element element,
        String tag,
        String attr,
        String value
    ) {
        NodeList nodes = element.getChildNodes();
        int nNodes = nodes.getLength();
        for (int i = 0;i < nNodes;i++) {
            Node child = nodes.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element)child;
                if (tag.equals(e.getTagName()) &&
                    value.equals(e.getAttribute(attr))) {

                    String data = getDataValue(e);
                    e.getParentNode().removeChild(e);
                    return (data);
                }
                String data = findAndDropData(e, tag, attr, value);
                if (data != null) {
                    return (data);
                }
            }
        }
        return (null);
    }

    public static String[] findDataList(Document doc, String tag) {
        return (findDataList(doc.getDocumentElement(), tag));
    }

    public static String[] findDataList(Element element, String tag) {
        List list = new ArrayList();
        _findDataList(element, tag, list);
        return ((String[])list.toArray(new String[list.size()]));
    }

    public static void _findDataList(
        Element element,
        String tag,
        List list
    ) {
        NodeList nodes = element.getChildNodes();
        int size = nodes.getLength();
        for (int i = 0;i < size;i++) {
            Node child = nodes.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element)child;
                if (tag.equals(e.getTagName())) {
                    list.add(getDataValue(e));
                } else {
                    _findDataList(e, tag, list);
                }
            }
        }
    }

    public static boolean hasElement(Node element) {
        NodeList children = element.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                return (true);
            }
        }
        return (false);
    }

    public static String getDataValue(Node node) {
        return (getTextValue(node).trim());
    }

    public static String getTextValue(Node node) {
        StringBuffer buffer = new StringBuffer();
        getTextValue(node, buffer);
        return (new String(buffer));
    }

    public static void getTextValue(Node node, StringBuffer buffer) {
        if (node instanceof Text) {
            buffer.append(node.getNodeValue());
            return;
        }
        NodeList children = node.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                getTextValue((Element)child, buffer);
            } else if (child instanceof Text) {
                buffer.append(child.getNodeValue());
            }
        }
    }
    
    public static String getTextValue(Node[] nodes) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i < nodes.length;i++) {
            getTextValue(nodes[i], buffer);
        }
        return (new String(buffer));
    }

    public static String getLocalName(Element element) {
        String localName = element.getLocalName();
        if (localName != null) {
            return (localName);
        } else {
            return (element.getTagName()); // XXX
        }
    }

    // I/O
    public static Document loadDocument(URL url)
      throws IOException,
             ParserConfigurationException,
             SAXException {
        return (loadDocument(url.toExternalForm()));
    }

    public static Document loadDocument(String uri)
      throws IOException,
             ParserConfigurationException,
             SAXException {
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        if (uri.startsWith("<")) {
            InputSource is = new InputSource(new StringReader(uri));
            return (builder.parse(is));
        } else {
            URL url = UURL.getURLFromUri(uri);
            return (builder.parse(url.toExternalForm()));
        }
    }

    public static Document loadDocumentNs(URL url)
      throws IOException,
             ParserConfigurationException,
             SAXException {
        return (loadDocumentNs(url.toExternalForm()));
    }

    public static Document loadDocumentNs(File file) 
      throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory factory
             = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return (builder.parse(file));
    }

    public static Document loadDocumentNs(String uri)
      throws IOException,
             ParserConfigurationException,
             SAXException {
        DocumentBuilderFactory factory
             = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        if (uri.startsWith("<")) {
            InputSource is = new InputSource(new StringReader(uri));
            return (builder.parse(is));
        } else {
            URL url = UURL.getURLFromUri(uri);
            return (builder.parse(url.toExternalForm()));
        }
    }

    public static void saveDocument(
        String uri,
        Document doc
    ) throws IOException {
        URL url = UURL.getURLFromUri(uri);
        if (!"file".equals(url.getProtocol())) {
            throw (new IOException("bad uri = " + uri));
        }
        UFile.createFile(
            new File(url.getFile()),
            makeTextDocumentVisual(doc)
        );
    }

    public static void saveDocument(
        File file,
        Document doc
    ) throws IOException {
        UFile.createFile(
            file,
            makeTextDocumentVisual(doc)
        );
    }


    // bug avoidance
    // J2SE 1.4.2_01 crimson
    public static Attr getAttributeNodeNS(
        Element element,
        String uri,
        String localName
    ) {
        NamedNodeMap attrs = element.getAttributes();
        int size = attrs.getLength();
        for (int i = 0;i < size;i++) {
            Attr attr = (Attr)attrs.item(i);
            if (attr == null) {
                continue;
            }
            if (uri.equals(attr.getNamespaceURI()) &&
                localName.equals(attr.getLocalName())) {
                return (attr);
            }
        }
        return (null);
    }
}
