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
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

/**
 * PDocument is a DOM Node to persist.
 *
 * @since   Apr. 24, 1998
 * @version Aug. 11, 2004
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public class PDocument extends PNode implements org.w3c.dom.Document {
    protected String doctype_ = null;
    protected PDocumentType dtd_ = null;

    public PDocument() {
    }

    public PDocument(String doctype) {
	doctype_ = doctype;
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public short getNodeType() {
	return (Node.DOCUMENT_NODE);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Document
     */
    public DocumentType getDoctype() {
	return (dtd_);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Document
     */
    public DOMImplementation getImplementation() {
	throw (new UnsupportedOperationException());
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Document
     */
    public Element getDocumentElement() {
	return ((Element)children_.get(0)); // XXX
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Document
     */
    public Element createElement(String tagName) throws DOMException {
	return (new PElement(tagName, this));
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Document
     */
    public DocumentFragment createDocumentFragment()  {
	throw (new UnsupportedOperationException());
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Document
     */
    public Text createTextNode(String data) {
	return (new PText(data, this));
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Document
     */
    public Comment createComment(String data) {
	return (new PComment(data, this));
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Document
     */
    public CDATASection createCDATASection(String data) throws DOMException {
	throw (new UnsupportedOperationException());
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Document
     */
    public ProcessingInstruction createProcessingInstruction(
	String target,
	String data
    ) throws DOMException {
	throw (new UnsupportedOperationException());
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Document
     */
    public Attr createAttribute(String name) throws DOMException {
	return (new PAttr(name, this));
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Document
     */
    public EntityReference createEntityReference(String name)
	throws DOMException {

	throw (new UnsupportedOperationException());
    }

    public void setDocumentType(DocumentType dtd) {
	dtd_ = (PDocumentType)dtd;
    }

    // DOM 2
    public Node importNode(Node importedNode, boolean deep)
	throws DOMException {

	throw (new UnsupportedOperationException());
    }

    public Element createElementNS(String namespaceURI, 
                                   String qualifiedName)
	throws DOMException {

	throw (new UnsupportedOperationException());
    }

    public Attr createAttributeNS(String namespaceURI, 
                                  String qualifiedName)
	throws DOMException {

	throw (new UnsupportedOperationException());
    }

    public NodeList getElementsByTagNameNS(String namespaceURI, 
                                           String localName) {

	throw (new UnsupportedOperationException());
    }

    public Element getElementById(String elementId) {
	throw (new UnsupportedOperationException());
    }

    // DOM3
	public String getInputEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getXmlEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getXmlStandalone() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setXmlStandalone(boolean arg0) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public String getXmlVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setXmlVersion(String arg0) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public boolean getStrictErrorChecking() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setStrictErrorChecking(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getDocumentURI() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDocumentURI(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public Node adoptNode(Node arg0) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	public DOMConfiguration getDomConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public void normalizeDocument() {
		// TODO Auto-generated method stub
		
	}

	public Node renameNode(Node arg0, String arg1, String arg2) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}
}
