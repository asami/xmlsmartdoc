/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1999  ASAMI, Tomoharu (tasami@ibm.net)
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

/**
 * CBoardView
 *
 * @since   Oct. 21, 1999
 * @version Oct. 21, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class CBoardView implements ICBoard {
    protected ICBoard base_;
    protected int offsetX_ = 0;
    protected int offsetY_ = 0;

    public CBoardView(ICBoard base, int offsetX, int offsetY) {
	base_ = base;
	offsetX_ = offsetX;
	offsetY_ = offsetY;
    }

    public void put(int x, int y, char c) {
	base_.put(x + offsetX_, y + offsetY_, c);
    }

    public void put(int x, int y, String text) {
	base_.put(x + offsetX_, y + offsetY_, text);
    }
}
