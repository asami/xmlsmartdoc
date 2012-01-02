/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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
 * Colgroup
 *
 * @since   Oct.  3, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class Colgroup extends Container {
    protected Table table_;
    protected String align_;
    protected CSSLength width_;
    protected int span_;

    public Colgroup() {
    }

    public Colgroup(Element element) {
	super(element);
	align_ = UString.checkNull(element.getAttribute("align"));
	String widthString
	    = UString.checkNull(element.getAttribute("width"));
	if (widthString != null) {
	    width_ = new CSSLength(widthString);
	}	    
	String spanArg = UString.checkNull(element.getAttribute("span"));
	if (spanArg == null) {
	    span_ = 0;		// means any
	} else {
	    span_ = Integer.parseInt(spanArg);
	}
    }

    public Colgroup(String align) {
	align_ = align;
    }

    // Content
    public int getEntityType() {
	return (ENTITY_BLOCK);
    }

    public void setTable(Table table) {
	table_ = table;
	setParent(table_);
    }

    public void setAlign(String align) {
	align_ = align;
    }

    public void addCol(Col col) {
	col.setColgroup(this);
	addContent(col);
    }

    public Table getTable() {
	return (table_);
    }

    public String getAlign() {
	return (align_);
    }

    public CSSLength getWidth() {
	return (width_);
    }

    public int getSpan() {
	return (span_);
    }

    public Col[] getCols() {
	Col[] contents = new Col[contents_.size()];
	return ((Col[])contents_.toArray(contents));
    }
}
