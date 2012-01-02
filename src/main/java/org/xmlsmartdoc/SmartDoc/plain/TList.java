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

import org.w3c.dom.Element;
import com.AsamiOffice.jaba2.xml.pdom.PElement;
import com.AsamiOffice.jaba2.text.cui.*;

/**
 * TList
 *
 * @since   Oct.  8, 1999
 * @version Mar. 14, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public abstract class TList extends AbstractTElement {
    public TList(String name) {
	super(name);
	setIndent(6);
    }

    public void format(StringBuffer buffer) {
	TNode[] nodes = getChildren();
	for (int i = 0;i < nodes.length;i++) {
	    TNode node = nodes[i];
	    if (node instanceof TItem) {
		TItem item = (TItem)node;
		_indentParent(buffer);
		buffer.append(_mark(i + 1, (TItem)nodes[i]));
		item.format(buffer);
	    }
	}
    }

    public void format(CPanel cnode) {
	CPanel dlItem = null;
	TNode[] tnodes = getChildren();
	for (int i = 0;i < tnodes.length;i++) {
	    TNode child = tnodes[i];
	    if (child instanceof TItem) {
		CPanel item = new CRowPanel();
		CBox mark = new CBox(_mark(i + 1, (TItem)child));
		mark.setNatural(true);
		mark.setAlign("right");
		mark.setWidth(getIndent());
		item.append(mark);
		CPanel desc = new CPanel();
		item.append(desc);
		child.format(desc);
		cnode.append(item);
	    } else if (child instanceof TList) {
		TList childList = (TList)child;
		childList.setIndent(getIndent() + 2);
		CPanel desc = new CPanel();
		childList.format(desc);
		cnode.append(desc);
	    } else {
		throw (new UnsupportedOperationException(child.toString()));
	    }
	}
    }

    public int getTopGap() {
	return (1);
    }

    public int getBottomGap() {
	return (1);
    }

    protected abstract String _mark(int i, TItem item);
}
