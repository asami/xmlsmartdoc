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

import org.w3c.dom.Element;

// Should replace span to be more generic
/**
 * Anchor
 *
 * @since   Sep. 26, 1998
 * @version Jan.  1, 2000
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class Anchor extends Container {
    protected String type_;
    protected Content[] contents_;

    public Anchor() {
    }

    public Anchor(Element element) {
	super(element);
    }

    public Anchor(String text, String id) {
	type_ = "indexReference";
	text_ = text;
	addContent(new CharBlock(text));
	id_ = id;
    }

    // Content
    public int getEntityType() {
	return (ENTITY_CONTAINER);
    }
}
