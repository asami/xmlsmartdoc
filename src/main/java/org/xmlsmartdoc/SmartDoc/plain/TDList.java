/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2001  ASAMI, Tomoharu (asami@zeomtech.com)
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

package org.xmlsmartdoc.SmartDoc.plain;

import com.AsamiOffice.jaba2.text.cui.*;

/**
 * TDList
 *
 * @since   Jun. 12, 2000
 * @version Mar. 19, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class TDList extends TList {
    private String delimiter_ = "  ";
    private int indent_ = 2;

    public TDList() {
	super("tdlist");
    }

    protected String _mark(int i, TItem item) {
	throw (new InternalError());
    }

    public final void setIndent(int indent) {
	indent_ = indent;
    }

    public final void setDelimiter(String delimiter) {
	delimiter_ = delimiter;
    }

    public void format(CPanel cnode) {
	CList cList = new CList();
	cList.setIndent(indent_);
	cList.setMark(delimiter_);
	TNode[] tnodes = getChildren();
	CBox term = null;
	for (int i = 0;i < tnodes.length;i++) {
	    TNode child = tnodes[i];
	    if (child instanceof TDTerm) {
		term = new CBox(child.format());
	    } else if (child instanceof TDDesc) {
		if (term != null) {
		    CPanel desc = new CPanel();
		    child.format(desc);
		    cList.addEntry(term, desc);
		    term = null;
		}
	    } else {
		// do nothing
	    }
	}
	cnode.append(cList);
    }
}
