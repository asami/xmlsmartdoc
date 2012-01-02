/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2002  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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
import com.AsamiOffice.jaba2.text.UString;

/**
 * MacroAttribute
 *
 * @since   Jan. 27, 2002
 * @version Jan. 27, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class MacroTitle extends Container {
    public MacroTitle(Element element) {
	super(element);
    }

    // Content
    public int getEntityType() {
	return (ENTITY_CONTAINER);
    }

    public Content[] eval(DocContext context) {
	Content parent = getParent();
	Content[] contents = super.eval(context);
	if (contents == null) {
	    return (null);
	}
	if (contents.length == 0) {
	    return (null);
	}
	if (contents.length != 1) {
	    throw (new InternalError());
	}
	MacroTitle src = (MacroTitle)contents[0];
	Locale locale = src.getLocale();
	Title title = new Title();
	title.setFormat(src.getFormat());
	title.setLocale(locale);
	title.addContents(src.getContents());
	if (locale == null) {
	    parent.setTitle(title);
	} else {
	    parent.setTitle(title, locale);
	}
	return (null);
    }
}
