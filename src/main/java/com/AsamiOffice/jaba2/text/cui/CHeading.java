/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2001  ASAMI, Tomoharu (asami@zeomtech.com)
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

package com.AsamiOffice.jaba2.text.cui;

import com.AsamiOffice.text.UString;

/**
 * CHeading
 *
 * @since   Oct. 22, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class CHeading extends CBox {
    protected String underline_ = null;

    public CHeading(String text) {
	super(text);
    }

    public void setUnderline(String underline) {
	underline_ = underline;
    }

    public void layout(int width) {
	super.layout(width);
	width_ = width;
	int titleWidth = 0;
	for (int i = 0;i < lines_.length;i++) {
	    titleWidth = Math.max(
		titleWidth,
		UString.getHalfLength(lines_[i])
	    );
	}
	if (underline_ != null) {
	    String[] lines = new String[lines_.length + 1];
	    System.arraycopy(lines_, 0, lines, 0, lines_.length);
	    StringBuffer underlineBuffer = new StringBuffer();
	    int underlineWidth_ = UString.getHalfLength(underline_);
	    int loop = (titleWidth / underlineWidth_) +
		       (titleWidth % underlineWidth_); // XXX : but 1 or 2
	    while (loop-- > 0) {
		underlineBuffer.append(underline_);
	    }
	    lines[lines_.length] = new String(underlineBuffer);
	    lines_ = lines;
	    height_++;
	}
    }
}
