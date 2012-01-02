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

import java.net.MalformedURLException;
import java.net.URL;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

import com.AsamiOffice.text.UString;

/**
 * SmartElement
 *
 * @since   Aug. 18, 1999
 * @version Aug. 11, 2004
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class SmartElement implements Element {
    protected Element element_;
    protected String localName_;
    protected String prefix_;
    protected String namespaceURI_;

    public SmartElement(Element element) {
        if (element == null) {
            throw (new IllegalArgumentException());
        }
        element_ = element;
    }

    // Node
    public String getNodeName() {
        return (element_.getNodeName());
    }

    // Node
    public String getNodeValue() throws DOMException {
        return (element_.getNodeValue());
    }

    // Node
    public void setNodeValue(String nodeValue) throws DOMException {
        element_.setNodeValue(nodeValue);
    }

    // Node
    public short getNodeType() {
        return (element_.getNodeType());
    }

    // Node
    public Node getParentNode() {
        return (element_.getParentNode());
    }

    // Node
    public NodeList getChildNodes() {
        return (element_.getChildNodes());
    }

    // Node
    public Node getFirstChild() {
        return (element_.getFirstChild());
    }

    // Node
    public Node getLastChild() {
        return (element_.getLastChild());
    }

    // Node
    public Node getPreviousSibling() {
        return (element_.getPreviousSibling());
    }

    // Node
    public Node getNextSibling() {
        return (element_.getNextSibling());
    }

    // Node
    public NamedNodeMap getAttributes() {
        return (element_.getAttributes());
    }

    // Node
    public Document getOwnerDocument() {
        return (element_.getOwnerDocument());
    }

    // Node
    public Node insertBefore(Node newChild, Node refChild)
        throws DOMException {

        return (element_.insertBefore(newChild, refChild));
    }

    // Node
    public Node replaceChild(Node newChild, Node oldChild)
        throws DOMException {

        return (element_.replaceChild(newChild, oldChild));
    }

    // Node
    public Node removeChild(Node oldChild) throws DOMException {
        return (element_.removeChild(oldChild));
    }

    // Node
    public Node appendChild(Node newChild) throws DOMException {
        return (element_.appendChild(newChild));
    }

    // Node
    public boolean hasChildNodes() {
        return (element_.hasChildNodes());
    }

    // Node
    public Node cloneNode(boolean deep) {
        return (element_.cloneNode(deep));
    }

    // Node
    public boolean isSupported(String feature, String version) {
        return (element_.isSupported(feature, version));
    }

    // Element
    public String getTagName() {
        return (element_.getTagName());
    }

    // Element
    public String getAttribute(String name) {
        return (element_.getAttribute(name));
    }

    // Element
    public void setAttribute(String name, String value) throws DOMException {
        element_.setAttribute(name, value);
    }

    // Element
    public void removeAttribute(String name) throws DOMException {
        element_.removeAttribute(name);
    }

    // Element
    public Attr getAttributeNode(String name) {
        return (element_.getAttributeNode(name));
    }

    // Element
    public Attr setAttributeNode(Attr newAttr) throws DOMException {
        return (element_.setAttributeNode(newAttr));
    }

    // Element
    public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
        return (element_.removeAttributeNode(oldAttr));
    }

    // Element
    public NodeList getElementsByTagName(String name) {
        return (element_.getElementsByTagName(name));
    }

    // Element
    public void normalize() {
        element_.normalize();
    }

    // DOM2
    public String getAttributeNS(String namespaceURI, String localName) {
        throw (new UnsupportedOperationException());
    }

    public boolean supports(String feature, String version) {
        throw (new UnsupportedOperationException());
    }

    public Attr getAttributeNodeNS(String namespaceURI, String localName) {
        throw (new UnsupportedOperationException());
    }

    public void removeAttributeNS(String namespaceURI, String localName) {
        throw (new UnsupportedOperationException());
    }

    public void setAttributeNS(
        String namespaceURI,
        String localName,
        String value
    ) {
        throw (new UnsupportedOperationException());
    }

    public void setPrefix(String prefix) {
        throw (new UnsupportedOperationException());
    }

    public NodeList getElementsByTagNameNS(
        String namespaceURI,
        String tagName
    ) {
        String displayName = getDisplayName(namespaceURI, tagName);
        return (element_.getElementsByTagName(displayName));
    }

    public Attr setAttributeNodeNS(Attr attr) {
        throw (new UnsupportedOperationException());
    }

    public boolean hasAttributes() {
        throw (new UnsupportedOperationException());
    }        

    public boolean hasAttribute(String name) {
        throw (new UnsupportedOperationException());
    }        

    public boolean hasAttributeNS(String namespaceURI, String name) {
        throw (new UnsupportedOperationException());
    }        

    // namespace operation

    public boolean isTag(String namespaceURI, String localName) {
        _setupNamespace();
        return (
            namespaceURI.equals(namespaceURI_) &&
            localName.equals(localName_)
        );
    }

    public String getPrefix() {
        _setupNamespace();
        return (prefix_);
    }

    public String getLocalName() {
        _setupNamespace();
        return (localName_);
    }

    public String getNamespaceURI() {
        _setupNamespace();
        return (namespaceURI_);
    }

    public String getDisplayName(
        String namespaceURI,
        String tagName
    ) {
        String prefix = _findPrefixByNamespaceURI(namespaceURI, element_);
        if (prefix == null) {
            return (tagName);
        } else if ("".equals(prefix)) { // default namespace
            return (tagName);
        } else {
            return (prefix + ":" + tagName);
        }
    }

    private void _setupNamespace() {
        if (localName_ != null) {
            return;
        }
        String tagName = element_.getTagName();
        String[] tokens = UString.getPairTokens(tagName, ":");
        if (tokens.length == 1) {
            localName_ = tokens[0];
            prefix_ = "";
            namespaceURI_ = _findDefaultNamespaceURI(element_);
        } else {
            prefix_ = tokens[0];
            localName_ = tokens[1];
            namespaceURI_ = _findNamespaceURI(prefix_, element_);
        }
    }

    private String _findDefaultNamespaceURI(Element element) {
        return (_findNamespaceURIByAttributeName("xmlns", element));
    }

    private String _findNamespaceURI(String prefix, Element element) {
        return (_findNamespaceURIByAttributeName("xmlns:" + prefix, element));
    }

    private String _findNamespaceURIByAttributeName(
        String name,
        Element element
    ) {
        for (;;) {
            String attr = UString.checkNull(element.getAttribute(name));
            if (attr != null) {
                return (attr);
            }
            Node parent = element.getParentNode();
            if (parent == null) {
                return (null);
            }
            if (parent.getNodeType() != Node.ELEMENT_NODE) {
                return (null);
            }
            element = (Element)parent;
        }
    }

    public String getAttributeAsString(
        String namespaceURI,
        String localName
    ) {
        String prefix = _findPrefixByNamespaceURI(namespaceURI, element_);
        if (prefix == null) {
            return (null);
        } else if ("".equals(prefix)) {        // default namespace
            return (UString.checkNull(element_.getAttribute(localName)));
        } else {
            return (
                UString.checkNull(
                    element_.getAttribute(prefix + ":" + localName)
                )
            );
        }
    }

    private String _findPrefixByNamespaceURI(
        String namespaceURI,
        Element element
    ) {
        if (namespaceURI == null) {
            namespaceURI = "";
        }
        for (;;) {
            NamedNodeMap attrs = element.getAttributes();
            int size = attrs.getLength();
            for (int i = 0;i < size;i++) {
                Attr attr = (Attr)attrs.item(i);
                String value = attr.getValue();
                if (namespaceURI.equals(value)) {
                    String name = attr.getName();
                    if ("xmlns".equals(name)) {
                        return ("");
                    }
                    if (name.startsWith("xmlns:")) {
                        return (name.substring("xmlns:".length()));
                    }
                }
            }
            Node parent = element.getParentNode();
            if (parent == null) {
                return (null);
            }
            if (parent.getNodeType() != Node.ELEMENT_NODE) {
                return (null);
            }
            element = (Element)parent;
        }
    }

    // XML Base

    public String getXMLBaseAsString() {
        return (UElement.getXMLBaseAsString(element_));
    }

    // element operation

    public Element getElement() {
        return (element_);
    }

    public Element[] getElements() {
        return (UElement.getElements(element_));
    }

    public Element[] getElements(String name) {
        return (UElement.getElements(element_, name));
    }

    public Element[] getElements(String namespaceURI, String localName) {
        return (UElement.getElements(element_, namespaceURI, localName));
    }

    public Element[] getElementsRecursive(String name) {
        return (UElement.getElementsRecursive(element_, name));
    }

    public Element getOnlyElement(String name)
        throws IllegalArgumentException {

        return (UElement.getOnlyElement(element_, name));
    }

    public Element getOnlyElement(String namespaceURI, String localName)
        throws IllegalArgumentException {

        return (UElement.getOnlyElement(element_, namespaceURI, localName));
    }

    public Element getOnlyElementRecursive(String name)
        throws IllegalArgumentException {

        return (UElement.getOnlyElementRecursive(element_, name));
    }

    // attribute operation

    public String getAttributeAsCDATA(String name) {
        return (UElement.getAttributeAsCDATA(element_, name));
    }

    public String getAttributeAsNMTOKEN(String name) {
        return (UElement.getAttributeAsNMTOKEN(element_, name));
    }

    public String[] getAttributeAsNMTOKENS(String name) {
        return (UElement.getAttributeAsNMTOKENS(element_, name));
    }

    public String getAttributeAsString(String name) {
        return (UElement.getAttributeAsString(element_, name));
    }

    public boolean getAttributeAsBoolean(String name) {
        return (UElement.getAttributeAsBoolean(element_, name));
    }

    public boolean getAttributeAsBoolean(String name, boolean defaultValue) {
        return (UElement.getAttributeAsBoolean(element_, name, defaultValue));
    }

    public Number getAttributeAsNumber(String name) {
        return (UElement.getAttributeAsNumber(element_, name));
    }

    public Number getAttributeAsNumber(String name, Number defaultValue) {
        return (UElement.getAttributeAsNumber(element_, name, defaultValue));
    }

    public URL getAttributeAsURL(String name) throws MalformedURLException {
        return (UElement.getAttributeAsURL(element_, name));
    }

    public URL getAttributeAsURLByFileOrURLName(String name)
        throws IllegalArgumentException {

        return (UElement.getAttributeAsURLByFileOrURLName(element_, name));
    }

    public int getAttributeAsEnumerationNumber(
        String name,
        String[] candidates,
        int base
    ) {
        return (
            UElement.getAttributeAsEnumerationNumber(
                element_,
                name,
                candidates,
                base
            )
        );
    }

    public int getAttributeAsEnumerationNumber(
        String name,
        String[] candidates,
        int base,
        String defaultValue
    ) {
        return (
            UElement.getAttributeAsEnumerationNumber(
                element_,
                name,
                candidates,
                base,
                defaultValue
            )
        );
    }

    // method and attribute

    public String getAttributeOfOnlyElementAsString(
        String tagName,
        String attrName
    ) throws IllegalArgumentException {
        return (
            UElement.getAttributeOfOnlyElementAsString(
                element_,
                tagName,
                attrName
            )
        );
    }

    public String getAttributeOfOnlyElementRecursiveAsString(
        String tagName,
        String attrName
    ) throws IllegalArgumentException {
        return (
            UElement.getAttributeOfOnlyElementRecursiveAsString(
                element_,
                tagName,
                attrName
            )
        );
    }

    public Integer getAttributeOfOnlyElementAsInteger(
        String tagName,
        String attrName
    ) throws IllegalArgumentException {
        return (
            UElement.getAttributeOfOnlyElementAsInteger(
                element_,
                tagName,
                attrName
            )
        );
    }

    public Float getAttributeOfOnlyElementAsFloat(
        String tagName,
        String attrName
    ) throws IllegalArgumentException {
        return (
            UElement.getAttributeOfOnlyElementAsFloat(
                element_,
                tagName,
                attrName
            )
        );
    }

    public Double getAttributeOfOnlyElementAsDouble(
        String tagName,
        String attrName
    ) throws IllegalArgumentException {
        return (
            UElement.getAttributeOfOnlyElementAsDouble(
                element_,
                tagName,
                attrName
            )
        );
    }

    // data operation

    public Number getDataAsNumber() {
        return (UElement.getDataAsNumber(element_));
    }

    public Number getDataAsNumber(String name) {
        return (UElement.getDataAsNumber(element_, name));
    }

    public Long getDataAsLong() {
        return (UElement.getDataAsLong(element_));
    }

    public Long getDataAsLong(String name) {
        return (UElement.getDataAsLong(element_, name));
    }

    // DOM 3
	public TypeInfo getSchemaTypeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setIdAttribute(String arg0, boolean arg1) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public void setIdAttributeNS(String arg0, String arg1, boolean arg2) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public void setIdAttributeNode(Attr arg0, boolean arg1) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public String getBaseURI() {
		// TODO Auto-generated method stub
		return null;
	}

	public short compareDocumentPosition(Node arg0) throws DOMException {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getTextContent() throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTextContent(String arg0) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public boolean isSameNode(Node arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public String lookupPrefix(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isDefaultNamespace(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public String lookupNamespaceURI(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEqualNode(Node arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getFeature(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object setUserData(String arg0, Object arg1, UserDataHandler arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUserData(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
