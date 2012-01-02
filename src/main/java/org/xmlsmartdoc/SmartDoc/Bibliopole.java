/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2001  ASAMI, Tomoharu (asami@zeomtech.com)
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
 * Bibliopole
 *
 * @since   Aug.  6, 2001
 * @version Aug.  6, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class Bibliopole extends TitledBlock {
    public Bibliopole(Element element) {
	super(element);
	NodeList nodes = element.getChildNodes();
	int size = nodes.getLength();
	for (int i = 0;i < size;i++) {
	    Node node = nodes.item(i);
	    switch (node.getNodeType()) {

	    case Node.ELEMENT_NODE:
		Element child = (Element)node;
		addContent(Bibitem.getBibitem(child));
		break;
	    case Node.TEXT_NODE:
	    case Node.ENTITY_REFERENCE_NODE:
	    case Node.COMMENT_NODE:
		// do nothing
		break;
	    default:
		throw (new InternalError("bad node type = " +
					 node.getNodeType())); // XXX : debug
	    }
	}
    }

    // Content
    public int getEntityType() {
	return (ENTITY_BLOCK);
    }

    // Container
    public Content[] normalize(DocContext context) {
	if (title_ == null) {
	    SmartDocModel model = SmartDocContext.getContext().getModel();
	    title_ = model.getLabel("bibliography", this);
	}
	return (super.normalize(context));
    }

    public String[] getIDs() {
	Content[] contents = getContents();
	String[] keys = new String[contents.length];
	for (int i = 0;i < contents.length;i++) {
	    keys[i] = contents[i].getID();
	}
	return (keys);
    }
}
