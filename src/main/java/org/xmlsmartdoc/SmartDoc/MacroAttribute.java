/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
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

import com.AsamiOffice.text.UString;

/**
 * MacroAttribute
 *
 * @since   Jun.  9, 2000
 * @version Aug. 26, 2000
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class MacroAttribute extends Container {
    private String attrName_;
    private String path_;

    public MacroAttribute(Element element) {
	super(element);
	attrName_ = UString.checkNull(element.getAttribute("name"));
	path_ = UString.checkNull(element.getAttribute("valueOf"));
    }

    // Content
    public int getEntityType() {
	return (ENTITY_CONTAINER);
    }

/*
    public Content[] macroExpand(DocContext context) {
	Content macroContext = context.getMacroContext();
	if (macroContext == null) {
	    macroContext = getParent();
	}
	Content[] contents;
	if (path_ != null) {
	    contents = UDoc.getContentsByPath(macroContext, path_);
	} else {
	    contents = eval(context);
	}
	if (contents == null) {
	    return (null);
	}
	String text = UDoc.distillText(contents);
	macroContext.setAttribute(attrName_, text);
	return (null);
    }
*/

    public Content[] eval(DocContext context) {
	Content parent = getParent();
	Content[] contents = super.eval(context);
	if (contents == null) {
	    return (null);
	}
	String text = UDoc.distillText(contents);
	parent.setAttribute(attrName_, text);
	return (null);
    }
}
