/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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
 * TDDesc
 *
 * @since   Jun. 12, 2000
 * @version Aug. 21, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class TDDesc extends AbstractTTextBox {
    public TDDesc() {
	super("tddesc");
    }

    public void format00(CPanel cnode) { // XXX : hack
	StringBuffer buffer = new StringBuffer();
	TNode[] nodes = getChildren();
	for (int i = 0;i < nodes.length;i++) {
	    TNode node = nodes[i];
	    node.format(buffer);
	}
	CBox box = new CBox(new String(buffer));
	cnode.append(box);
    }

    public void format0(CPanel cnode) {
	TNode[] nodes = getChildren(); // XXX : same as TItem
	for (int i = 0;i < nodes.length;i++) {
	    TNode node = nodes[i];
	    if (false) {
		throw (new UnsupportedOperationException());
	    } else {
		if (node instanceof TText) {
		    TText text = (TText)node;
		    CBox box = new CBox(text.getData());
		    cnode.append(box);
		} else {
		    node.format(cnode);
		}
	    }
	}
    }
}
