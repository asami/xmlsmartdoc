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

package org.xmlsmartdoc.SmartDoc;

import org.w3c.dom.*;
import com.AsamiOffice.text.UString;

/**
 * TrContent
 *
 * @since   Nov. 14, 1998
 * @version Apr.  5, 1999
 * @author  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 */
public class TrContent extends Container {
    protected Col col_;
    protected int rowSpan_ = 1;
    protected int colSpan_ = 1;
    protected String align_;

    public TrContent() {
    }

    public TrContent(String data) {
	CharBlock block = new CharBlock(data);
	addContent(block);
    }

    public TrContent(Element element) {
	super(element);
	String value;
	value = UString.checkNull(element.getAttribute("rowspan"));
	if (value != null) {
	    rowSpan_ = Integer.parseInt(value);
	}
	value = UString.checkNull(element.getAttribute("colspan"));
	if (value != null) {
	    colSpan_ = Integer.parseInt(value);
	}
	align_ = UString.checkNull(element.getAttribute("align"));
    }

    // Content
    public int getEntityType() {
	return (ENTITY_BLOCK);
    }

    public void setCol(Col col) {
	col_ = col;
    }

    public void setRowSpan(int span) {
	rowSpan_ = span;
    }

    public void setColSpan(int span) {
	colSpan_ = span;
    }

    public Col getCol() {
	return (col_);
    }

    public int getRowSpan() {
	return (rowSpan_);
    }

    public int getColSpan() {
	return (colSpan_);
    }

    public String getAlign() {
	return (align_);
    }
}
