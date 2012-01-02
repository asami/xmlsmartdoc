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

package org.xmlsmartdoc.goldenport.evaluater.patterns;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xmlsmartdoc.goldenport.engine.GoldenportException;
import org.xmlsmartdoc.goldenport.engine.PortContext;
import org.xmlsmartdoc.goldenport.engine.PortEngine;
import org.xmlsmartdoc.goldenport.engine.PortNodeList;
import org.xmlsmartdoc.goldenport.evaluater.pattern.SubrPattern;

/**
 * CopyOfSubrPattern
 *
 * @since   Jul.  8, 2002
 * @version Apr. 11, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class CopyOfSubrPattern extends SubrPattern {
    public void endElement(
        Element element,
        PortNodeList children,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        //System.out.println("coyp-of");
//        Element contextElement = context.peekParentElement();
        Element contextElement = context.peekElement();
        //System.out.println(org.relaxer.xml.UXMLMaker.getXMLText(contextElement));
        Document doc = contextElement.getOwnerDocument();
        PortEngine engine = context.getEngine();
        DocumentFragment evaluated = doc.createDocumentFragment();
        NodeList contextChildren = contextElement.getChildNodes();
        int size = contextChildren.getLength();
        for (int i = 0; i < size; i++) {
            Node child = contextChildren.item(i);
            if (child instanceof Text) {
                evaluated.appendChild(doc.importNode(child, true));
            } else if (child instanceof Element) {
                evaluated.appendChild(
                    doc.importNode(engine.eval((Element)child, context), true));
            }
        }
        result.addChildren(evaluated);
    }
}
