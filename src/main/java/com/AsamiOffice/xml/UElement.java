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

package com.AsamiOffice.xml;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.AsamiOffice.io.UURL;
import com.AsamiOffice.text.UString;

/**
 * UElement
 *
 * @since   Jan. 17, 2000
 * @version Oct. 19, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public final class UElement {
    // element
    public static Element[] getElements(Element element) {
        NodeList children = element.getChildNodes();
        List list = new ArrayList();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                list.add(child);
            }
        }
        Element[] array = new Element[list.size()];
        return ((Element[])list.toArray(array));
    }

    public static Element[] getElements(
        Element element,
        String name
    ) {
        NodeList children = element.getChildNodes();
        List list = new ArrayList();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element candidate = (Element)child;
                if (name.equals(candidate.getTagName())) {
                    list.add(child);
                }
            }
        }
        Element[] array = new Element[list.size()];
        return ((Element[])list.toArray(array));
    }

    public static Element[] getElements(
        Element element,
        String namespaceURI,
        String localName
    ) {
        NodeList children = element.getChildNodes();
        List list = new ArrayList();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                SmartElement candidate = new SmartElement((Element)child);
                if (candidate.isTag(namespaceURI, localName)) {
                    list.add(child);
                }
            }
        }
        Element[] array = new Element[list.size()];
        return ((Element[])list.toArray(array));
    }

    public static Element getOnlyElement(Element element, String name)
        throws IllegalArgumentException {

        Element[] elements = getElements(element, name);
        switch (elements.length) {

        case 0:
            return (null);
        case 1:
            return (elements[0]);
        default:
            throw (new IllegalArgumentException());
        }
    }

    public static Element getOnlyElement(
        Element element,
        String uri,
        String name
     ) throws IllegalArgumentException {
        Element[] elements = getElements(element, uri, name);
        switch (elements.length) {

        case 0:
            return (null);
        case 1:
            return (elements[0]);
        default:
            throw (new IllegalArgumentException());
        }
    }

    public static Element[] getElementsRecursive(
        Element element,
        String name
    ) {
        NodeList nodes = element.getElementsByTagName(name);
        Element[] elements = new Element[nodes.getLength()];
        for (int i = 0;i < elements.length;i++) {
            elements[i] = (Element)nodes.item(i);
        }
        return (elements);
    }

    public static Element getOnlyElementRecursive(
        Element element,
        String name
    ) throws IllegalArgumentException {

        NodeList nodes = element.getElementsByTagName(name);
        switch (nodes.getLength()) {

        case 0:
            return (null);
        case 1:
            break;
        default:
            throw (new IllegalArgumentException());
        }
        return ((Element)nodes.item(0));
    }

    // attribute operation

    public static String getAttributeAsCDATA(Element element, String name) {
        return (UString.checkNull(element.getAttribute(name)));
    }

    public static String getAttributeAsNMTOKEN(Element element, String name) {
        String cdata = UString.checkNull(element.getAttribute(name));
        if (cdata == null) {
            return (null);
        }
        return (cdata.trim());        // XXX : check precise spec
    }

    public static String[] getAttributeAsNMTOKENS(
        Element element,
        String name
    ) {
        String cdata = UString.checkNull(element.getAttribute(name));
        if (cdata == null) {
            return (null);
        }
        return (UString.getTokens(cdata));
    }

    public static String getAttributeAsString(Element element, String name) {
        return (UString.checkNull(element.getAttribute(name)));
    }

    public static boolean getAttributeAsBoolean(
        Element element,
        String name
    ) {
        return (getAttributeAsBoolean(element, name, false));
    }

    public static boolean getAttributeAsBoolean(
        Element element,
        String name,
        boolean defaultValue
    ) {
        String value = UString.checkNull(element.getAttribute(name));
        if (value == null) {
            return (defaultValue);
        }
        if (value.equals("true")) {
            return (true);
        } else if (value.equals("false")) {
            return (false);
        } else {
            return (true);
        }
    }

    public static Number getAttributeAsNumber(Element element, String name) {
        return (getAttributeAsNumber(element, name, null));
    }

    public static Number getAttributeAsNumber(
        Element element,
        String name,
        Number defaultValue
    ) {
        String value = UString.checkNull(element.getAttribute(name));
        if (value == null) {
            return (defaultValue);
        }
        try {
            NumberFormat format = NumberFormat.getInstance();
            Number number = format.parse(value);
            return (number);        // XXX : Integer, Float
        } catch (ParseException e) {
            return (defaultValue);
        }
    }

    public static URL getAttributeAsURL(Element element, String name)
        throws MalformedURLException {

        String value = UString.checkNull(element.getAttribute(name));
        if (value == null) {
            return (null);
        }
        return (new URL(value));
    }

    public static URL getAttributeAsURLByFileOrURLName(
        Element element,
        String name
    ) throws IllegalArgumentException {
        String value = UString.checkNull(element.getAttribute(name));
        if (value == null) {
            return (null);
        }
        try {
            return (UURL.getURLFromFileOrURLName(value));
        } catch (MalformedURLException e) {
            throw (new InternalError()); // XXX
        }
    }

    public static URL getAttributeAsURLByFileOrURLNameWithXMLBase(
        Element element,
        String name
    ) throws IllegalArgumentException {
        return (
            getAttributeAsURLByFileOrURLNameWithXMLBase(element, name, null)
        );
    }

    public static URL getAttributeAsURLByFileOrURLNameWithXMLBase(
        Element element,
        String name,
        String baseURI
    ) throws IllegalArgumentException {
        String value = UString.checkNull(element.getAttribute(name));
        if (value == null) {
            return (null);
        }
        try {
            URL url = new URL(value);
            return (url);
        } catch (MalformedURLException e) {
        }
        String xmlBase = UElement.getXMLBaseAsString(element);
        if (xmlBase != null) {
            if (!xmlBase.endsWith("/")) {
                xmlBase = xmlBase + "/";
            }
            value = xmlBase + value;
        }
        try {
            URL url = new URL(value);
            return (url);
        } catch (MalformedURLException e) {
        }
        if (baseURI != null) {
            if (!baseURI.endsWith("/")) {
                baseURI = baseURI + "/";
            }
            value = baseURI + value;
        }
        try {
            return (UURL.getURLFromFileOrURLName(value));
        } catch (MalformedURLException e) {
            throw (new InternalError()); // XXX
        }
    }

    public static int getAttributeAsEnumerationNumber(
        Element element,
        String name,
        String[] candidates,
        int base
    ) {
        String value = UString.checkNull(element.getAttribute(name));
        if (value == null) {
            return (-1);
        }
        for (int i = 0;i < candidates.length;i++) {
            if (candidates[i].equals(value)) {
                return (base + i);
            }
        }
        return (-1);
    }

    public static int getAttributeAsEnumerationNumber(
        Element element,
        String name,
        String[] candidates,
        int base,
        String defaultValue
    ) {
        String value = UString.checkNull(element.getAttribute(name));
        if (value == null) {
            value = defaultValue;
        }
        for (int i = 0;i < candidates.length;i++) {
            if (candidates[i].equals(value)) {
                return (base + i);
            }
        }
        return (-1);
    }

    // method and attribute

    public static String getAttributeOfOnlyElementAsString(
        Element element,
        String tagName,
        String attrName
    ) throws IllegalArgumentException {
        Element target = getOnlyElement(element, tagName);
        if (target == null) {
            return (null);
        }
        return (UString.checkNull(target.getAttribute(attrName)));
    }

    public static String getAttributeOfOnlyElementRecursiveAsString(
        Element element,
        String tagName,
        String attrName
    ) throws IllegalArgumentException {
        Element target = getOnlyElementRecursive(element, tagName);
        if (target == null) {
            return (null);
        }
        return (UString.checkNull(target.getAttribute(attrName)));
    }

    public static Integer getAttributeOfOnlyElementAsInteger(
        Element element,
        String tagName,
        String attrName
    ) throws IllegalArgumentException {
        String data = getAttributeOfOnlyElementAsString(
            element,
            tagName,
            attrName
        );
        if (data == null) {
            return (null);
        }
        return (Integer.valueOf(data));
    }

    public static Float getAttributeOfOnlyElementAsFloat(
        Element element,
        String tagName,
        String attrName
    ) throws IllegalArgumentException {
        String data = getAttributeOfOnlyElementAsString(
            element,
            tagName,
            attrName
        );
        if (data == null) {
            return (null);
        }
        return (Float.valueOf(data));
    }

    public static Double getAttributeOfOnlyElementAsDouble(
        Element element,
        String tagName,
        String attrName
    ) throws IllegalArgumentException {
        String data = getAttributeOfOnlyElementAsString(
            element,
            tagName,
            attrName
        );
        if (data == null) {
            return (null);
        }
        return (Double.valueOf(data));
    }

    // data operation
    public static String getData(Element element) {
        return (UDOM.getDataValue(element));
    }

    public static Number getDataAsNumber(Element element) {
        String data = getData(element);
        if (UString.isNull(data)) {
            return (null);
        }
        try {
            NumberFormat format = NumberFormat.getInstance();
            Number number = format.parse(data);
            return (number);        // XXX : Integer, Float
        } catch (ParseException e) {
            return (null);
        }
    }

    public static Number getDataAsNumber(Element element, String name) {
        NodeList nodes = element.getElementsByTagName(name);
        if (nodes == null) {
            return (null);
        }
        if (nodes.getLength() == 0) {
            return (null);
        }
        return (getDataAsNumber((Element)nodes.item(0)));
    }

    public static Long getDataAsLong(Element element) {
        String data = getData(element);
        if (UString.isNull(data)) {
            return (null);
        }
        try {
            Long number = Long.valueOf(data);
            return (number);
        } catch (NumberFormatException e) {
            return (null);
        }
    }

    public static Long getDataAsLong(Element element, String name) {
        NodeList nodes = element.getElementsByTagName(name);
        if (nodes == null) {
            return (null);
        }
        if (nodes.getLength() == 0) {
            return (null);
        }
        return (getDataAsLong((Element)nodes.item(0)));
    }

    // xml base
    public static String getXMLBaseAsString(Element root) {
        String uri = null;
        Node node = root;
        for (;;) {
            Element element = (Element)node;
            uri = UString.checkNull(element.getAttribute("xml:base"));
            if (uri != null) {
                try {
                    URL url = new URL(uri);
                    return (uri);
                } catch (MalformedURLException e) {
                }
                break;
            }
            node = node.getParentNode();
            if (node == null) {
                return (null);
            }
            if (!(node instanceof Element)) {
                return (null);
            }
        }
        for (;;) {
            node = node.getParentNode();
            if (node == null) {
                return (uri);
            }
            if (!(node instanceof Element)) {
                return (uri);
            }
            Element element = (Element)node;
            String base = UString.checkNull(element.getAttribute("xml:base"));
            if (base != null) {
                uri = base + uri;
            }
            try {
                URL url = new URL(uri);
                return (uri);
            } catch (MalformedURLException e) {
            }
        }
    }

    // update
    public static void appendElement(
        Element element,
        String tagName,
        String data
    ) {
        Document doc = element.getOwnerDocument();
        Element item = doc.createElement(tagName);
        item.appendChild(doc.createTextNode(data));
        element.appendChild(item);
    }

    public static void appendElement(
        Element element,
        String tagName,
        String attrName,
        String data
    ) {
        Document doc = element.getOwnerDocument();
        Element item = doc.createElement(tagName);
        item.setAttribute(attrName, data);
        element.appendChild(item);
    }

    public static void updateElement(
        Element target,
        Element data,
        String keyAttr
    ) {
        updateElement(target, data, new String[] { keyAttr });
    }

    public static void updateElement(
        Element target,
        Element data,
        String[] keyAttrs
    ) {
        String tagName = data.getTagName();
        NodeList nodes = target.getElementsByTagName(tagName);
        int nNodes = nodes.getLength();
        for (int i = 0;i < nNodes;i++) {
            Element element = (Element)nodes.item(i);
            if (_isSameAttrs(element, data, keyAttrs)) {
                target.replaceChild(data, element);
                return;
            }
        }
        target.appendChild(data);
    }

    protected static boolean _isSameAttrs(
        Element lhs,
        Element rhs,
        String[] attrs
    ) {
        for (int i = 0;i < attrs.length;i++) {
            String attr = attrs[i];
            if (!lhs.getAttribute(attr).equals(rhs.getAttribute(attr))) {
                return (false);
            }
        }
        return (true);
    }
}
