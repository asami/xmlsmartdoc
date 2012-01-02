/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
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
 * CBox
 *
 * @since   Oct. 14, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class CBox extends CNode {
    protected String text_;
    protected String[] lines_ = null;
    protected String align_ = "left";
    protected boolean adjustable_ = true;
    protected boolean natural_ = false;

    public CBox(String text) {
	text_ = text;
    }

    public void setAlign(String align) {
	align_ = align;
    }

    public String getText() {
	return (text_);
    }

    public final void setAdjustable(boolean adjustable) {
	adjustable_ = adjustable;
    }

    public final void setNatural(boolean natural) {
	natural_ = natural;
    }

    public void layout(int width) {
	if (natural_) {
	    lines_ = UString.makeStringList(text_);
	} else {
	    lines_ = UCUI.getLines(text_, width);
	}
	height_ = lines_.length;
	if (width_ == 0) {
	    if (adjustable_) {
		width_ = UCUI.getWidth(lines_);
	    } else {
		width_ = width;
	    }
	}
    }

/*
    public void layout0(int width) {
	String[] chunks = UCUI.getChunks(text_);
	List list = new ArrayList();
	StringBuffer buffer = new StringBuffer();
	int cp = 0;
	for (int i = 0;i < chunks.length;i++) {
	    String chunk = chunks[i];
	    int length = UString.getHalfLength(chunk);
	    if (UCUI.isGyotoKinsoku(chunk)) {
		buffer.append(chunk);
	    } else if (UCUI.isGyomatsuKinsoku(chunk)) {
		if (cp + 1 > width) {
		    list.add(new String(buffer));
		    buffer = new StringBuffer();
		    cp = 0;
		}
		buffer.append(chunk);
		cp += length;
	    } else {
		if (cp + length >= width) {
		    list.add(new String(buffer));
		    buffer = new StringBuffer();
		    cp = 0;
		}
		buffer.append(chunk);
		cp += length;
	    }
	}
	if (buffer.length() > 0) {
	    list.add(new String(buffer));
	}
	lines_ = new String[list.size()];
	lines_ = (String[])list.toArray(lines_);
	height_ = lines_.length;
	if (width_ == 0) {
	    width_ = UCUI.getWidth(lines_);
	}
    }
*/

    public void draw(ICBoard board) {
	for (int y = 0;y < lines_.length;y++) {
	    String line = lines_[y];
	    int left;
	    int length = UString.getHalfLength(line);
            if (width_ <= length) {
                left = 0;
            } else if ("left".equals(align_)) {
		left = 0;
	    } else if ("right".equals(align_)) {
		left = width_ - length;
	    } else if ("center".equals(align_)) {
		left = (width_ - length) / 2;
	    } else {
		throw (new InternalError());
	    }
	    board.put(left, y, line);
	}
    }
}
