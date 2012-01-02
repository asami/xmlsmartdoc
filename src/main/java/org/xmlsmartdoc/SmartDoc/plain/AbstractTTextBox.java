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
 * AbstractTTextBox
 *
 * @since   Aug. 21, 2003
 * @version Aug. 21, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class AbstractTTextBox extends AbstractTElement {
    protected AbstractTTextBox(String name) {
	super(name);
    }

    public void format0(CPanel cnode) {
        StringBuffer buffer = null;
	TNode[] nodes = getChildren();
	for (int i = 0;i < nodes.length;i++) {
	    TNode node = nodes[i];
            if (node instanceof TParagraph) {
                if (buffer != null) {
                    CBox box = new CBox(new String(buffer));
                    cnode.append(box);
                    buffer = null;
                }
                node.format(cnode);
            } else if (node instanceof TText) {
                if (buffer == null) {
                    buffer = new StringBuffer();
                }
                node.format(buffer);
            } else {
                if (buffer != null) {
                    CBox box = new CBox(new String(buffer));
                    cnode.append(box);
                    buffer = null;
                }
                node.format(cnode);
            }
	}
        if (buffer != null) {
            CBox box = new CBox(new String(buffer));
            cnode.append(box);
        }
    }
}
