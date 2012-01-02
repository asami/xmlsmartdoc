/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998,1999  ASAMI, Tomoharu (tasami@ibm.net)
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
import org.w3c.dom.Element;
import org.xmlsmartdoc.SmartDoc.control.Atom;

/**
 * Symbol
 *
 * @since   Aug.  7, 1999
 * @version Sep.  9, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class Symbol extends Container {
    protected String name_;
    protected Element element_;

    public Symbol() {
    }

    public Symbol(Element element) {
	super(element);
	name_ = element.getTagName();
	element_ = element;
    }

    public int getEntityType() {
	return (ENTITY_CONTROL);
    }

    public void setName(String name) {
	name_ = name;
    }

    public String getName() {
	return (name_);
    }

    public Content[] macroExpand(DocContext context) {
	Atom atom = context.getAtom(name_);
	if (atom == null) {
	    if (element_ != null) {
		ExternalElement ee = new ExternalElement(element_);
		return (new Content[] { ee });
	    } else {
		_warning("undefined symbol = " + name_);
	    }
	}
	Content[] contents = atom.getValue();
	List list = new ArrayList();
	context.pushMacroContext(this);
	for (int i = 0;i < contents.length;i++) {
	    Content[] expanded = contents[i].macroExpand(context);
	    if (expanded != null) {
		for (int j = 0;j < expanded.length;j++) {
		    list.add(expanded[j]);
		}
	    }
	}
	context.popMacroContext();
	Content[] result = new Content[list.size()];
	list.toArray(result);
	return (result);
    }
}
