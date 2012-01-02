/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package com.AsamiOffice.jaba2.xml.converter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.AsamiOffice.xml.UDOM;

/**
 * HRefConverter
 *
 * @since   Aug.  6, 1999
 * @version Oct. 16, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class HRefConverter extends AbstractConverter {
    public Node[] string2Nodes(Document doc, String string) {
        return (uString2Nodes(doc, string));
    }

    public String nodes2String(Node[] nodes) {
        return (uNodes2String(nodes));
    }

    public static Node[] uString2Nodes(Document doc, String string) {
        Element element = doc.createElement("a");
        element.setAttribute("href", string);
        element.appendChild(doc.createTextNode(string));
        return (new Node[] { element });
    }

    public static String uNodes2String(Node[] nodes) {
        return (UDOM.getTextValue(nodes));
    }
}
