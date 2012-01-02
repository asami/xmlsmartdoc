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

package org.xmlsmartdoc.goldenport.evaluater.pattern;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.xmlsmartdoc.goldenport.engine.IPortConstants;
import org.xmlsmartdoc.goldenport.engine.PortContext;
import org.xmlsmartdoc.goldenport.engine.PortNodeList;

import com.AsamiOffice.xml.UXML;

/**
 * ExprPattern
 *
 * @since   Jul.  6, 2002
 * @version Apr. 12, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class ExprPattern extends AbstractPattern {
    private Element define_;

    public ExprPattern(Element define) {
        define_ = normalize_(define);
    }

    private Element normalize_(Element element) {
        if ("preserve".equals(element.getAttribute("xml:space"))) {
            return (element);
        }
        if (PORT_NS.equals(element.getNamespaceURI()) &&
            "text".equals(element.getLocalName())) {
            return (element);
        }
        Document doc = element.getOwnerDocument();
        Element newElement = (Element)doc.importNode(element, false);
        NodeList children = element.getChildNodes();
        int size = children.getLength();
        boolean inStart = true;
        boolean afterSpace = false;
        StringBuffer sb = null;
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.TEXT_NODE) {
                Text text = (Text)child;
                if (sb == null) {
                    sb = new StringBuffer();
                }
                char[] chars = text.getNodeValue().toCharArray();
                for (int j = 0;j < chars.length;j++) {
                    char c = chars[j];
                    if (UXML.isXmlSpace(c)) {
                        afterSpace = true;
                    } else {
                        if (!inStart && afterSpace) {
                            sb.append(' ');
                        }
                        sb.append(c);
                        inStart = false;
                        afterSpace = false;
                    }
                }
            } else {
                if (sb != null) {
                    if (!inStart && afterSpace) {
                        sb.append(' ');
                    }
                    newElement.appendChild(doc.createTextNode(new String(sb)));
                    sb = null;
                    inStart = true;
                    afterSpace = false;
                }
                switch (child.getNodeType()) {
                  case Node.ELEMENT_NODE:
                    newElement.appendChild(normalize_((Element)child));
                    break;
                  case Node.ATTRIBUTE_NODE:
                    break;
                  case Node.TEXT_NODE:
                    break;
                  case Node.CDATA_SECTION_NODE:
                    newElement.appendChild(normalize_((CDATASection)child));
                    break;
                  case Node.ENTITY_REFERENCE_NODE:
                    break;
                  case Node.ENTITY_NODE:
                    break;
                  case Node.PROCESSING_INSTRUCTION_NODE:
                    newElement.appendChild(normalize_((ProcessingInstruction)child));
                    break;
                  case Node.COMMENT_NODE:
                    newElement.appendChild(normalize_((Comment)child));
                    break;
                  case Node.DOCUMENT_NODE:
                    break;
                  case Node.DOCUMENT_TYPE_NODE:
                    break;
                  case Node.DOCUMENT_FRAGMENT_NODE:
                    break;
                  case Node.NOTATION_NODE:
                    break;
                }
            }
        }
        if (sb != null) {
            newElement.appendChild(doc.createTextNode(new String(sb)));
        }
        return (newElement);
    }

    private Node normalize_(CDATASection cdata) {
        return (cdata);
    }

    private ProcessingInstruction normalize_(ProcessingInstruction pi) {
        Document doc = pi.getOwnerDocument();
        return ((ProcessingInstruction)doc.importNode(pi, false));
    }

    private Comment normalize_(Comment comment) {
        Document doc = comment.getOwnerDocument();
        return ((Comment)doc.importNode(comment, false));
    }

    public int startElement(
        Element element,
        PortContext context,
        PortNodeList result
    ) {
        context.pushElement(element);
        result.addChildren(define_);
        return (IPortConstants.EVAL_CHILDREN);
    }

    public void endElement(
        Element element,
        PortNodeList children,
        PortContext context,
        PortNodeList result
    ) {
        result.setup(children);
        context.popElement();
    }
}
