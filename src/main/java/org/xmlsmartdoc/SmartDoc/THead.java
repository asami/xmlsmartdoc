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

/**
 * THead
 *
 * @since   Sep. 29, 1998
 * @version Aug.  8, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class THead extends Container {
    protected String inlineText_;

    public THead() {
    }

    public THead(Element element) {
	super(element);
	inlineText_ = null;
    }

    // Content
    public int getEntityType() {
	return (ENTITY_BLOCK);
    }

    // Container
    public void format() {
	super.format();
	inlineText_ = UDoc.makeInlineText(this);
    }

    /**
     * @deprecated
     */
    public String getInlineText() {
	return (inlineText_);
    }

/*
    public void format() {
	Content[] contents = getContents();
	if (contents.length == 0) {
	    return;
	}
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Tr) {
		_buildTr((Tr)content);
	    } else if (content instanceof Sentence) {
		// do nothing
	    } else {
		throw (new IllegalArgumentException(content.toString()));
	    }
	}
    }

    public void _buildTr(Tr tr) {
	Content[] contents = tr.getContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Th) {
		ths_.add(content);
	    } else if (content instanceof Sentence) {
		// do nothing
	    } else {
		throw (new IllegalArgumentException());
	    }
	}
    }

    public Th[] getThs() {
	Th[] contents = new Th[contents_.size()];
	return ((Th[])ths_.toArray(contents));
    }
*/
}
