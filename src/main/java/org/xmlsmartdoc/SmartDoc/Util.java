/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998  ASAMI, Tomoharu (tasami@ibm.net)
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

package org.xmlsmartdoc.SmartDoc;

import java.util.*;
import org.w3c.dom.*;

/**
 * Util
 *
 * XXX: should move to the Jaba2 library.
 *
 * @since   Sep. 25, 1998
 * @version Sep. 25, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class Util {
    public static String[] collectData(Element element, String tagName) {
	List list = new ArrayList();
	NodeList nodes = element.getChildNodes();
	int size = nodes.getLength();
	for (int i = 0;i < size;i++) {
	    Node node = nodes.item(i);
	    switch (node.getNodeType()) {

	    case Node.ELEMENT_NODE:
		Element e = (Element)node;
		if (tagName.equals(e.getTagName())) {
		    list.add(getString(e));
		}
		break;
	    }
	}
	String[] result = new String[list.size()];
	return ((String[])list.toArray(result));
    }

    public static String getString(Element element) {
	StringBuffer buffer = new StringBuffer();
	_getString(element, buffer);
	return (new String(buffer));
    }

    protected static void _getString(Element element, StringBuffer buffer) {
	NodeList list = element.getChildNodes();
	int size = list.getLength();
	for (int i = 0;i < size;i++) {
	    Node node = list.item(i);
	    switch (node.getNodeType()) {

	    case Node.ELEMENT_NODE:
		_getString(element, buffer);
		break;
	    case Node.TEXT_NODE:
		buffer.append(((Text)node).getData());
		break;
	    }
	}
    }
}
