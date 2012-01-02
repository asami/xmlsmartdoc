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
 * TNoteList
 *
 * @since   Jan. 30, 2001
 * @version Mar. 16, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class TNoteList extends TList {
    public TNoteList() {
	super("tnotelist");
	setIndent(0);
    }

    public void format(CPanel cnode) {
	CList cList = new CList();
	cList.setIndent(0);
	cList.setMark(" ");
	TNode[] tnodes = getChildren();
	for (int i = 0;i < tnodes.length;i++) {
	    TItem child = (TItem)tnodes[i];
	    CBox mark = new CBox(_mark(i + 1, child));
	    CPanel desc = new CPanel();
	    child.format(desc);
	    cList.addEntry(mark, desc);
	}
	cnode.append(cList);
    }

    public int getTopGap() {
	return (0);
    }

    public int getBottomGap() {
	return (0);
    }

    protected String _mark(int i, TItem item) {
	return (item.getMark());
    }
}
