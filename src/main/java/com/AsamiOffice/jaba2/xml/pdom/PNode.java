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

package com.AsamiOffice.jaba2.xml.pdom;

import java.io.Serializable;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

import com.AsamiOffice.xml.UXMLMaker;

/**
 * PNode is a DOM Node to persist.
 *
 * @since   Apr. 24, 1998
 * @version Aug. 11, 2004
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public abstract class PNode implements org.w3c.dom.Node, Serializable {
    protected PDocument owner_;
    protected String localName_;
    protected String namespaceURI_;
    protected String prefix_;
    protected PNode parent_;
    protected PList children_ = new PList(); // PList<PNode>

    protected PNode() {
        parent_ = null;
    }

    protected PNode(PNode parent) {
        parent_ = parent;
        owner_ = parent.owner_;
    }

    protected PNode(PDocument owner) {
        owner_ = owner;
    }

    // Object
    public String toString() {
        return (UXMLMaker.getXMLText(this));
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public String getNodeName() {
        throw (new UnsupportedOperationException());
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public String getNodeValue() throws DOMException {
        throw (new UnsupportedOperationException());
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public void setNodeValue(String nodeValue) throws DOMException {
        throw (new UnsupportedOperationException());
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public abstract short getNodeType();

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Node
     */
    public Node getParentNode() {
        return (parent_);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public NodeList getChildNodes() {
        return (new ListNodeList(children_));
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Node
     */
    public Node getFirstChild() {
        if (children_.size() == 0) {
            return (null);
        } else {
            return ((Node)children_.get(0));
        }
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public Node getLastChild() {
        int nChildren = children_.size();
        if (nChildren == 0) {
            return (null);
        } else {
            return ((Node)children_.get(nChildren - 1));
        }
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Node
     */
    public Node getPreviousSibling() {
        throw (new InternalError("not supported"));
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Node
     */
    public Node getNextSibling() {
        throw (new InternalError("not supported"));
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public NamedNodeMap getAttributes() {
        throw (new UnsupportedOperationException());
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public Document getOwnerDocument() {
        return (owner_);
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Node
     */
    public Node insertBefore(Node newChild, Node refChild)
        throws DOMException {

        if (!(newChild instanceof PNode)) {
            throw (new InternalError());
        }
        PNode node = (PNode)newChild;
        if (refChild == null) {
            children_.add(node);
            node.parent_ = this;
        } else {
            int index = children_.indexOf(refChild);
            if (index == -1) {
                throw (new NotFoundErrException("refChild doesn't exist"));
            }
            children_.add(index, node);
            node.parent_ = this;
        }
        return (node);
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Node
     */
    public Node replaceChild(Node newChild, Node oldChild)
        throws DOMException {

        if (!(newChild instanceof PNode)) {
            throw (new InternalError());
        }
        PNode node = (PNode)newChild;
        int index = children_.indexOf(oldChild);
        if (index == -1) {
            throw (new NotFoundErrException("refChild doesn't exist"));
        }
        children_.set(index, node);
        node.parent_ = this;
        return (node);
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Node
     */
    public Node removeChild(Node oldChild) {
        int index = children_.indexOf(oldChild);
        if (index == -1) {
            throw (new NotFoundErrException("refChild doesn't exist"));
        }
        children_.remove(index);
        return (oldChild);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public Node appendChild(Node newChild) throws DOMException {
        if (!(newChild instanceof PNode)) {
            throw (new InternalError());
        }
        PNode node = (PNode)newChild;
        children_.add(node);
        node.parent_ = this;
        return (newChild);
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.Node
     */
    public boolean hasChildNodes() {
        return (children_.size() > 0);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public Node cloneNode(boolean deep) {
        throw (new UnsupportedOperationException());
    }

    /**
     * @since DOM2
     */
    public void normalize() {
        throw (new InternalError());
    }

    /**
     * @since DOM2
     */
    public boolean supports(String feature, String version) {
        throw (new InternalError());
    }

    /**
     * @since DOM2
     */
    public String getNamespaceURI() {
        return (namespaceURI_);
    }

    /**
     * @since DOM2
     */
    public String getPrefix() {
        return (prefix_);
    }

    /**
     * @since DOM2
     */
    public void setPrefix(String prefix) {
        prefix_ = prefix;
    }

    public void addNode(PNode node) {
        children_.add(node);
    }

    /**
     * @since DOM2
     */
    public String getLocalName() {
        return (localName_);
    }

    /**
     * @since DOM2
     */
    public boolean hasAttributes() {
        throw (new InternalError());
    }

    /**
     * @since DOM2
     */
    public boolean isSupported(String feature, String version) {
        throw (new InternalError());
    }

    /**
     * This method is automatically ensuring role of Document and Element.
     */
    public NodeList getElementsByTagName(String name) {
        PList elements = new PList();
        int size = children_.size();
        for (int i = 0; i < size; i++) {
            PNode node = (PNode)children_.get(i);
            if (node instanceof PElement) {
                if (name.equals(((PElement)node).tagName_)) {
                    elements.add(node);
                }
            }
        }
        return (new ListNodeList(elements));
    }

    public int size() {
        return (children_.size());
    }

    public Object[] toArray(Object[] array) {
        return (children_.toArray(array));
    }

    public void clear() {
        children_.clear();
    }

    // DOM3
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
