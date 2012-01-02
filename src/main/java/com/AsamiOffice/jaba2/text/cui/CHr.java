/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2000  ASAMI, Tomoharu (asami@zeomtech.com)
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

import java.util.*;
import com.AsamiOffice.jaba2.text.UString;

/**
 * CHr
 *
 * @since   Jun. 19, 2000
 * @version May. 23, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class CHr extends CNode {
    private ICKeisen keisen_;

    public CHr() {
	this(1);
    }

    public CHr(int height) {
	height_ = height;
    }

    public void setKeisenStyle(String keisenStyle) {
	if ("jis".equals(keisenStyle)) {
	    keisen_ = new CJisKeisen();
	} else {
	    keisen_ = new CAsciiKeisen();
	}
    }

    public void layout(int width) {
	width_ = width;
    }

    public void draw(ICBoard board) {
	UCUI.drawHLine(board, width_, keisen_.getThinHLine(), 0, 0);
    }
}
