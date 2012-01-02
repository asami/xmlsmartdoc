/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@asamiOffice.com)
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

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

/**
 * PElement is a DOM Node to persist.
 *
 * @since   Apr. 24, 1998
 * @version Aug. 11, 2004
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public class PElement extends PNode implements org.w3c.dom.Element {
    protected String tagName_;
    protected PMap attrs_ = new PMap();	// Map<String, Attr>

    public PElement(String tagName) {
	tagName_ = tagName;
    }

    public PElement(String tagName, PNode parent) {
	super(parent);
	tagName_ = tagName;
    }

    public PElement(String tagName, PDocument owner) {
	super(owner);
	tagName_ = tagName;
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public short getNodeType() {
	return (Node.ELEMENT_NODE);
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Element
     */
    public String getTagName() {
	return (tagName_);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Element
     */
    public NamedNodeMap getAttributes() {
	return (new MapNamedNodeMap(attrs_));
    }

    /**
     * @since WD-DOM-19980416
     * @see org.w3c.dom.Element
     */
    public String getAttribute(String name) {
	Attr attr = (Attr)attrs_.get(name);
	if (attr != null) {
	    return (attr.getValue());
	} else {
	    return (null);
	}
    }

    /**
     * @since WD-DOM-19980416
     * @see org.w3c.dom.Element
     */
    public void setAttribute(String name, String value) {
	attrs_.put(name, new PAttr(name, value));
    }

    /**
     * @since WD-DOM-19980416
     * @see org.w3c.dom.Element
     */
    public void removeAttribute(String name) throws DOMException {
	throw (new InternalError("not supported"));	
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Element
     */
    public Attr getAttributeNode(String name) {
	throw (new InternalError("not supported"));
    }

    /**
     * @since WD-DOM-19980416
     * @see org.w3c.dom.Element
     */
    public Attr setAttributeNode(Attr newAttr) throws DOMException {
	throw (new InternalError("not supported"));	
    }

    /**
     * @since WD-DOM-19980416
     * @see org.w3c.dom.Element
     */
    public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
	throw (new InternalError("not supported"));	
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @deprecated
     * @see org.w3c.dom.Element
     */
    public void setAttribute(Attr newAttr) {
	throw (new InternalError("not supported"));	
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Element
     */
    public void normalize() {
	throw (new InternalError("not supported"));	
    }

    /**
     * @since DOM2
     */
    public String getAttributeNS(String namespaceURI, String localName) {
	throw (new UnsupportedOperationException());
    }

    /**
     * @since DOM2
     */
    public void setAttributeNS(
	String namespaceURI,
	String qualifiedName,
	String localName
    ) {
	throw (new UnsupportedOperationException());
    }

    /**
     * @since DOM2
     */
    public void removeAttributeNS(
	String namespaceURI,
	String localName
    ) {
	throw (new UnsupportedOperationException());
    }

    /**
     * @since DOM2
     */
    public Attr getAttributeNodeNS(
	String namespaceURI,
	String qualifiedName
    ) {
	throw (new UnsupportedOperationException());
    }

    /**
     * @since DOM2
     */
    public Attr setAttributeNodeNS(Attr attr) {
	throw (new UnsupportedOperationException());
    }
    
    /**
     * @since DOM2
     */
    public NodeList getElementsByTagNameNS(
	String namespaceURI,
	String localName
    ) {
	throw (new UnsupportedOperationException());
    }

    /**
     * @since DOM2
     */
    public boolean hasAttribute(String name) {
	throw (new UnsupportedOperationException());
    }

    /**
     * @since DOM2
     */
    public boolean hasAttributeNS(String namespaceURI, String localName) {
	throw (new UnsupportedOperationException());
    }

    // DOM3
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
}
