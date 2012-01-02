/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2000  ASAMI, Tomoharu (asami@zeomtech.com)
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

import org.w3c.dom.Text;
import com.AsamiOffice.jaba2.text.UString;
import com.AsamiOffice.jaba2.text.cui.*;

/**
 * TFrameDiv
 *
 * @since   Jul. 16, 2000
 * @version Jul. 11, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class TFrameDiv extends TDiv {
    private String title_;
    private String keisenStyle_;

    public TFrameDiv() {
	this("ascii");
    }

    public TFrameDiv(String keisenStyle) {
	super("tframediv");
	keisenStyle_ = keisenStyle;
    }

    public final void setTitle(String title) {
	title_ = title;
    }

    public void format(CPanel node) {
	CFramePanel frame = new CFramePanel();
	frame.setKeisenStyle(keisenStyle_);
	frame.setTitle(title_);
        super.format(frame);
	node.append(frame);
    }

    public void format0(CPanel node) {
	StringBuffer buffer = new StringBuffer();
	TNode[] tnodes = getChildren();
	for (int i = 0;i < tnodes.length;i++) {
	    tnodes[i].format(buffer); // XXX
	}
	CFrameBox frame = new CFrameBox(new String(buffer));
	frame.setKeisenStyle(keisenStyle_);
	frame.setAdjustable(false);
	frame.setTitle(title_);
	node.append(frame);
    }
}
