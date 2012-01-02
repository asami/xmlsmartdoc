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
package com.AsamiOffice.jaba2.xml;

import com.AsamiOffice.text.UString;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.AsamiOffice.xml.SmartElement;

/**
 * UXSL
 *
 * @since   Aug.  5, 2000
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public final class UXSL {
    public static String getEncoding(Document doc) {
        SmartElement root = new SmartElement(doc.getDocumentElement());
        NodeList nodes =
            root.getElementsByTagNameNS(
                "http://www.w3.org/1999/XSL/Transform",
                "output");
        if (nodes.getLength() == 0) {
            return ("UTF-8");
        } else {
            Element output = (Element)nodes.item(0);
            String encoding =
                UString.checkNull(output.getAttribute("encoding"));
            if (encoding != null) {
                return (encoding);
            } else {
                return ("UTF-8");
            }
        }
    }

    public static void setEncoding(Document doc, String encoding) {
        SmartElement root = new SmartElement(doc.getDocumentElement());
        NodeList nodes =
            root.getElementsByTagNameNS(
                "http://www.w3.org/1999/XSL/Transform",
                "output");
        if (nodes.getLength() == 0) {
            String prefix = root.getPrefix();
            String tagname;
            if (prefix != null) {
                tagname = prefix + ":" + "output";
            } else {
                tagname = "output";
            }
            Element output = doc.createElement(tagname);
            output.setAttribute("encoding", encoding);
            root.appendChild(output);
        } else {
            Element output = (Element)nodes.item(0);
            output.setAttribute("encoding", encoding);
        }
    }
}
