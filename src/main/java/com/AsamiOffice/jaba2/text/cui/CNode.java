/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1999  ASAMI, Tomoharu (asami@zeomtech.com)
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
 * CNode
 *
 * @since   Oct. 14, 1999
 * @version Jul. 10, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public abstract class CNode {
    protected int x_;
    protected int y_;
    protected int width_;
    protected int height_;

    public int getX() {
	return (x_);
    }

    public int getY() {
	return (y_);
    }

    public int getWidth() {
	return (width_);
    }

    public int getHeight() {
	return (height_);
    }

    public void setX(int x) {
	x_ = x;
    }

    public void setY(int y) {
	y_ = y;
    }

    public void setWidth(int width) {
	width_ = width;
    }

    public void setHeight(int height) {
	height_ = height;
    }

//    public abstract void isBlock();
    public abstract void layout(int width);
    public abstract void draw(ICBoard board);
}
