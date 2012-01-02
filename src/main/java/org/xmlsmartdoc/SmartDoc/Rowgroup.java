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

import java.util.*;
import org.w3c.dom.*;
import com.AsamiOffice.text.UString;

/**
 * Rowgroup
 *
 * @since   Jan. 28, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class Rowgroup extends Container {
    protected Table table_;
    protected String align_;
    protected int[] spans_;

    public Rowgroup() {
    }

    public Rowgroup(Element element) {
	super(element);
	align_ = UString.checkNull(element.getAttribute("align"));
	String spansValue = element.getAttribute("spans");
	StringTokenizer st = new StringTokenizer(spansValue, ":");
	spans_ = new int[st.countTokens()];
	int i = 0;
	while (st.hasMoreTokens()) {
	    spans_[i++] = Integer.parseInt(st.nextToken());
	}
    }

    public Rowgroup(String align) {
	align_ = align;
    }

    // Content
    public int getEntityType() {
	return (ENTITY_BLOCK);
    }

    public void setTable(Table table) {
	table_ = table;
    }

    public void setAlign(String align) {
	align_ = align;
    }

    public void addColgroup(Colgroup colgroup) {
	addContent(colgroup);
    }

    public Table getTable() {
	return (table_);
    }

    public String getAlign() {
	return (align_);
    }

    public int[] getSpans() {
	return ((int[])spans_.clone());
    }

    public Colgroup[] getColgroup() {
	Colgroup[] contents = new Colgroup[contents_.size()];
	return ((Colgroup[])contents_.toArray(contents));
    }
}
