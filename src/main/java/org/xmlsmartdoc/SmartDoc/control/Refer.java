/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
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

package org.xmlsmartdoc.SmartDoc.control;

import org.w3c.dom.Element;
import org.xmlsmartdoc.SmartDoc.CharBlock;
import org.xmlsmartdoc.SmartDoc.Container;
import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.DocContext;

import com.AsamiOffice.text.UString;

/**
 * Refer
 *
 * @since   Aug. 13, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 */
public class Refer extends Container {
    protected String attrID_;

    public Refer(Element element) {
	super(element);
	attrID_ = UString.checkNull(element.getAttribute("attr"));
    }

    // Content
    public int getEntityType() {
	return (ENTITY_CONTROL);
    }

    // Container
    public Content[] macroExpand(DocContext context) {
	Content macroContext = context.getMacroContext();
	if (attrID_ != null) {
	    return (
		new Content[] {
		    new CharBlock(macroContext.getAttribute(attrID_))
		}
	    );
	}
	if (macroContext instanceof Container) {
	    Container cloned = (Container)macroContext.deepClone();
	    return (cloned.getContents());
	} else {
	    return (null);	// XXX
	}
    }
}
