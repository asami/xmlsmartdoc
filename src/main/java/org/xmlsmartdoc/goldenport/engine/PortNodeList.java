/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
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

package org.xmlsmartdoc.goldenport.engine;

import java.util.*;
import org.w3c.dom.*;

/**
 * PortNodeList
 *
 * @since   Mar. 11, 2002
 * @version May.  9, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class PortNodeList {
    private Document doc_;
    private String ns_ = null;
    private Element element_ = null;
    private List list_ = new ArrayList();

    public PortNodeList(Document doc) {
        doc_ = doc;
    }

    public Document getFactoryDocument() {
        return (doc_);
    }

    public void setup(Element element) {
        setElement(element);
        addChildren(element);
    }

    public void setup(PortNodeList list) {
        setElement(list.getElement());
        addChildren(list.getChildren());
    }

    public void setElement(Element element) {
        if (element == null) {
            element_ = null;
        } else {
            element_ = (Element)doc_.importNode(element, false);
        }
    }

    public void setAttribute(String name, String value) {
        element_.setAttribute(name, value);
    }

    public void addString(String string) {
        list_.add(doc_.createTextNode(string));
    }

    public void addChild(Node node) {
        list_.add(importNode_(node));
    }

    public void addChildren(Node node) {
        NodeList children = node.getChildNodes();
        int size = children.getLength();
        for (int i = 0; i < size; i++) {
            addChild(children.item(i));
        }
    }

    public void addChildren(Node[] nodes) {
        for (int i = 0;i < nodes.length;i++) {
            addChild(nodes[i]);
        }
    }

    public void removeAttribute(String name) {
        if (element_ == null) {
            throw (new IllegalArgumentException("No element"));
        }
        element_.removeAttribute(name);
    }

    private Node importNode_(Node child) {
       try {
           return (doc_.importNode(child, true));
       } catch (Exception e) { // J2SE 1.4 problem
           return (importNodeImpl_(child));
       }
    }

    private Node importNodeImpl_(Node node) {
        if (node instanceof Element) {
            String ns = node.getNamespaceURI();
            String tagName = ((Element)node).getTagName();
            Element element;
            if (ns != null) {
                element = doc_.createElementNS(ns, tagName);
            } else {
                element = doc_.createElement(tagName);
            }
            NamedNodeMap attrs = node.getAttributes();
            int nAttrs = attrs.getLength();
            for (int i = 0; i < nAttrs; i++) {
                Attr attr = (Attr)attrs.item(i);
                String attrNs = attr.getNamespaceURI();
                String attrName = attr.getName();
                String value = attr.getValue();
                if (attrNs != null) {
                    element.setAttributeNS(attrNs, attrName, value);
                } else {
                    element.setAttribute(attrName, value);
                }
            }
            NodeList children = node.getChildNodes();
            int nChildren = children.getLength();
            for (int i = 0; i < nChildren; i++) {
                element.appendChild(importNodeImpl_(children.item(i)));
            }
            return (element);
        } else if (node instanceof Text) {
            return (doc_.createTextNode(node.getNodeValue()));
        } else {
            throw (new InternalError());
        }
    }

    public int size() {
        return (list_.size());
    }

    public Element getElement() {
        return (element_);
    }

    public Node getChild(int index) {
        return ((Node)list_.get(index));
    }

    public DocumentFragment getChildren() {
        DocumentFragment frag = doc_.createDocumentFragment();
        int size = list_.size();
        for (int i = 0; i < size; i++) {
            Node child = (Node)list_.get(i);
            frag.appendChild(child);
        }
        return (frag);
    }

    public Node makeNode() {
        if (element_ != null) {
            element_.appendChild(getChildren());
            return (element_);
        } else {
            return (getChildren());
        }
    }

    public void setNamespace(String ns) {
        ns_ = ns;
    }
    
    private String getNamespace() {
        if (ns_ != null) {
            return (ns_);
        } else if (element_ != null) {
            return (element_.getNamespaceURI());
        } else {
            return (null);
        }
    }

    public Element createElement(String name) {
        return (createElement(getNamespace(), name));
    }

    public Element createElement(String ns, String name) {
        if (ns == null) {
            return (doc_.createElement(name));
        } else {
            return (doc_.createElementNS(ns, name));
        }
    }

    public Element addElement(String name) {
        Element element = createElement(name);
        list_.add(element);
        return (element);
    }

    public Element addElement(Element parent, String name) {
        Element element = createElement(name);
        parent.appendChild(element);
        return (element);
    }

    public void addString(Element element, String string) {
        element.appendChild(doc_.createTextNode(string));
    }

    public Node addChild(Element parent, Node node) {
        Node child = importNode_(node);
        parent.appendChild(child);
        return (child);
    }

    public void addChildren(Element parent, Node node) {
        NodeList children = node.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = importNode_(children.item(i));
            parent.appendChild(child);
        }
    }
}
