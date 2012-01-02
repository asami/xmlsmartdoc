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

package com.AsamiOffice.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * D2Array is a 2-dimensional extensible array.
 *
 * @since   Apr. 19, 1998
 * @version Oct. 13, 2005
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class D2Array implements Cloneable {
    protected int width_;
    protected int height_;
    protected int allocWidth_;
    protected int allocHeight_;
    protected Object[][] contents_;

    public D2Array() {
        _init(0, 0);
    }

    public D2Array(int width, int height) {
        _init(width, height);
    }

    public D2Array(D2Array d2array) {
        contents_ = (Object[][])UArray.cloneArray(d2array.contents_);
    }

    private void _init(int width, int height) {
        width_ = width;
        height_ = height;
        if (width == 0) {
            allocWidth_ = 10;
        } else {
            allocWidth_ = width;
        }
        if (height == 0) {
            allocHeight_ = 10;
        } else {
            allocHeight_ = height;
        }
        contents_ = new Object[allocWidth_][allocHeight_];
    }

    public Object get(int x, int y) {
        return (contents_[x][y]);
    }

    public Object put(int x, int y, Object obj) {
        _ensureSpace(x + 1, y + 1);
        contents_[x][y] = obj;
        if (x >= width_) {
            width_ = x + 1;
        }
        if (y >= height_) {
            height_ = y + 1;
        }
        return (obj);
    }

    public Object remove(int x, int y) {
        Object obj = contents_[x][y];
        contents_[x][y] = null;
        return (obj);
    }

    public int getHeight() {
        return (height_);
    }

    public int getWidth() {
        return (width_);
    }

    // Object
    public Object clone() {
        return (new D2Array(this));
    }

    // Object
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append('[');
        for (int y = 0; y < height_; y++) {
            buffer.append('[');
            for (int x = 0; x < width_; x++) {
                buffer.append(get(x, y));
                buffer.append(',');
            }
            buffer.append(']');
        }
        buffer.append(']');
        return (buffer.toString());
    }

    public Object[][] toArray2D() {
        Object[][] newContents = new Object[width_][height_];
        for (int x = 0; x < width_; x++) {
            for (int y = 0; y < height_; y++) {
                newContents[x][y] = contents_[x][y];
            }
        }
        return (newContents);
    }

    public D2Array transpose() {
        D2Array d2array = new D2Array();
        for (int y = 0; y < height_; y++) {
            for (int x = 0; x < width_; x++) {
                d2array.put(y, x, get(x, y));
            }
        }
        return (d2array);
    }

    public D2Array rotateLeft() {
        D2Array d2array = new D2Array();
        for (int y = 0; y < height_; y++) {
            int x0 = width_;
            for (int x = 0; x < width_; x++) {
                d2array.put(y, --x0, get(x, y));
            }
        }
        return (d2array);
    }

    public D2Array rotateRight() {
        D2Array d2array = new D2Array();
        int y0 = height_;
        for (int y = 0; y < height_; y++) {
            for (int x = 0; x < width_; x++) {
                d2array.put(--y0, x, get(x, y));
            }
        }
        return (d2array);
    }

    public D2Array reverse() {
        D2Array d2array = new D2Array();
        int y0 = height_;
        for (int y = 0; y < height_; y++) {
            int x0 = width_;
            for (int x = 0; x < width_; x++) {
                d2array.put(--y0, --x0, get(x, y));
            }
        }
        return (d2array);
    }

    protected void _ensureSpace(int w, int h) {
        if ((allocWidth_ >= w) && (allocHeight_ >= h)) {
            return;
        }
        int newWidth;
        int newHeight;
        if (allocWidth_ < w) {
            newWidth = allocWidth_ * 2;
            while (newWidth < w) {
                newWidth *= 2;
            }
        } else {
            newWidth = allocWidth_;
        }
        if (allocHeight_ < h) {
            newHeight = allocHeight_ * 2;
            while (newHeight < h) {
                newHeight *= 2;
            }
        } else {
            newHeight = allocHeight_;
        }
        Object[][] newContents = new Object[newWidth][newHeight];
        for (int x = 0; x < width_; x++) {
            for (int y = 0; y < height_; y++) {
                newContents[x][y] = contents_[x][y];
            }
        }
        contents_ = newContents;
        allocWidth_ = newWidth;
        allocHeight_ = newHeight;
    }

    public Iterator getRowIterator(int y) {
        return new ArrayIterator(getRowArray(y));
    }

    public List getRowList(int y) {
        return Arrays.asList(getRowArray(y));
    }

    public Object[] getRowArray(int y) {
        Object[] array = new Object[width_];
        for (int x = 0;x < width_;x++) {
            array[x] = get(x, y);
        }
        return array;
    }

    public Iterator getColumnIterator(int x) {
        return new ArrayIterator(getColumnArray(x));
    }

    public List getColumnList(int x) {
        return Arrays.asList(getColumnArray(x));
    }

    public Object[] getColumnArray(int x) {
        Object[] array = new Object[height_];
        for (int y = 0;y < height_;y++) {
            array[y] = get(x, y);
        }
        return array;
    }

    public boolean inbound(int x, int y) {
        return 0 <= x && x < width_ && 0 <= y && y < height_;
    }
}
