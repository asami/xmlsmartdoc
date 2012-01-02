/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1999  ASAMI, Tomoharu (tasami@ibm.net)
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

import java.util.*;
import java.io.IOException;
import java.net.URL;
import org.w3c.dom.*;

/**
 * PDOM is a DOM object to persist.
 *
 * @since   Apr. 24, 1998
 * @version Sep. 15, 1999
 + @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public abstract class AbstractPDOMFactory implements PDOMFactory {

    protected PNode _generatePNode(Node node, PNode parent) {
	PNode pnode;
	short type = node.getNodeType();
	switch (type) {

	case Node.DOCUMENT_NODE:
	    pnode = _generatePDocument((Document)node);
	    break;
	case Node.ELEMENT_NODE:
	    pnode = _generatePElement((Element)node, parent);
	    break;
	case Node.ATTRIBUTE_NODE:
	    throw (new UnsupportedOperationException("not supported yet"));
	case Node.COMMENT_NODE:
	    pnode = _generatePComment((Comment)node, parent);
	    break;
	case Node.TEXT_NODE:
	    pnode = _generatePText((Text)node, parent);
	    break;
	default:
	    pnode = new PUnknownNode(type, parent);
	}
	return (pnode);
    }

    protected PDocumentType _generatePDocumentType(DocumentType dtd) {
	String name = dtd.getName();
	PDocumentType pdtd = new PDocumentType(name);
	return (pdtd);
    }

    protected PAttr _generatePAttr(Attr attr) {
	String name = attr.getName();
	return (new PAttr(name, ""));
    }

    protected PDocument _generatePDocument(Document doc) {
	PDocument pdoc = new PDocument();
	DocumentType dtd = doc.getDoctype();
	if (dtd != null) {
	    PDocumentType pdtd = _generatePDocumentType(dtd);
	    pdoc.setDocumentType(pdtd);
	}
	PElement pelement = _generatePElement(
	    doc.getDocumentElement(), pdoc
	);
	pdoc.appendChild(pelement);
	return (pdoc);
    }

    protected PElement _generatePElement(Element element, PNode parent) {
	String tagName = element.getTagName();
	PElement pelement = new PElement(tagName, parent);
	NamedNodeMap attrs = element.getAttributes();
	int nAttrs = attrs.getLength();
	for (int i = 0;i < nAttrs;i++) {
	    Attr attr = (Attr)attrs.item(i);
	    pelement.setAttribute(attr.getName(), attr.getValue());
	}
	NodeList nodes  = element.getChildNodes();
	int nNodes = nodes.getLength();
	for (int i = 0;i < nNodes;i++) {
	    Node node = nodes.item(i);
	    pelement.addNode(_generatePNode(node, pelement));
	}
	return (pelement);
    }

    protected PComment _generatePComment(Comment comment, PNode parent) {
	String data = comment.getData();
	return (new PComment(data, parent));
    }

    protected PText _generatePText(Text text, PNode parent) {
	String data = text.getData();
	return (new PText(data, parent));
    }
}
