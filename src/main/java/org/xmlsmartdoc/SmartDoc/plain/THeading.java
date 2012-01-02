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

package org.xmlsmartdoc.SmartDoc.plain;

import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.text.cui.*;

/**
 * THeading
 *
 * @since   Jul. 16, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 */
public class THeading extends AbstractTElement {
    protected String title_;
    protected int prologueSpan_ = 2;
    protected int epilogueSpan_ = 1;
    protected String underline_ = "-";
    protected int underlineSpan_ = 1;
    protected String align_ = "left";

    public THeading(String title) {
	super("theading");
	title_ = title;
    }

    public void setPrologueSpan(int span) {
	prologueSpan_ = span;
    }

    public void setEpilogueSpan(int span) {
	epilogueSpan_ = span;
    }

    public void setUnderline(String line) {
	underline_ = line;
    }

    public void setUnderlineSpan(int span) {
	underlineSpan_ = span;
    }

    public void setAlign(String align) {
	align_ = align;
    }

    public void format(StringBuffer buffer) {
	int width = 70;		// XXX
	if ("center".equals(align_)) {
	    UPlain.printCenterWithNL(title_, width, buffer);
	} else {
	    buffer.append(title_);
	    buffer.append("\n");
	}
	int length = UString.getHalfLength(title_);
	StringBuffer underlineBuffer = new StringBuffer();
	for (int i = 0;i < length;i++) {
	    underlineBuffer.append(underline_);
	}
	String underline
	    = new String(underlineBuffer).substring(0, length);
	for (int j = 0;j < underlineSpan_;j++) {
	    if ("center".equals(align_)) {
		UPlain.printCenterWithNL(underline, width, buffer);
	    } else {
		buffer.append(underline);
		buffer.append("\n");
	    }
	}
    }

    public void format(CPanel node) {
	CHeading heading = new CHeading(title_);
	heading.setAlign(align_);
	heading.setUnderline(underline_);
	node.append(heading);
    }

    public int getTopGap() {
	return (prologueSpan_);
    }

    public int getBottomGap() {
	return (epilogueSpan_);
    }
}
