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

import com.AsamiOffice.text.UString;
import org.w3c.dom.*;

/**
 * Col
 *
 * @since   Oct.  3, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class Col extends Content {
    protected String align_;
    protected CSSLength width_;
    protected Colgroup colgroup_;

    public Col() {
    }

/*
    public Col(String align) {
	align_ = align;
    }
*/

    public Col(Colgroup colgroup) {
	setColgroup(colgroup);
    }

    public Col(Element element, Colgroup colgroup) {
	super(element);
	align_ = UString.checkNull(element.getAttribute("align"));
	String widthString
	    = UString.checkNull(element.getAttribute("width"));
	if (widthString != null) {
	    width_ = new CSSLength(widthString);
	}
	setColgroup(colgroup);
    }

    // Content
    public int getEntityType() {
	return (ENTITY_BLOCK);
    }

    public void setColgroup(Colgroup colgroup) {
	colgroup_ = colgroup;
    }

    public Colgroup getColgroup() {
	return (colgroup_);
    }

    public void setAlign(String align) {
	align_ = align;
    }

    public String getAlign() {
	return (align_);
    }

    public String getAlignFinal() {
	if (align_ != null) {
	    return (align_);
	}
	return (colgroup_.getAlign());
    }

    public CSSLength getWidth() {
	return (width_);
    }

    public CSSLength getWidthFinal() {
	if (width_ != null) {
	    return (width_);
	}
	return (colgroup_.getWidth());
    }
}
