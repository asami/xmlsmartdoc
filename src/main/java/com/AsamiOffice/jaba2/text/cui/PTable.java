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

import java.util.*;
import com.AsamiOffice.jaba2.text.UString;
import com.AsamiOffice.util.D2Array;

/**
 * PTable
 *
 * @since   Nov.  5, 1999
 * @version Nov. 29, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class PTable {
    public static final int LINE_THIN = 1;
    public static final int LINE_THICK = 2;

    protected D2Array data_ = new D2Array();
    protected int headHeight_;
    protected int footHeight_;
    protected int dataHeight_;

    public PTable(D2Array head, D2Array foot, D2Array body) {
	headHeight_ = head.getHeight();
	footHeight_ = foot.getHeight();
	dataHeight_ = body.getHeight();
	appendData(head);
	appendData(body);
	appendData(foot);
    }

    protected void appendData(D2Array data) {
	int cy = data_.getHeight();
	int width = data.getWidth();
	int height = data.getHeight();
	for (int y = 0;y < height;y++) {
	    for (int x = 0;x < width;x++) {
		data_.put(0, cy, new Cell((CTD)data.get(x, y))); // XXX
	    }
	    cy++;
	}
    }

    public void layout() {
	int width = data_.getWidth();
	int height = data_.getHeight();
	Cell cell;
	cell = (Cell)data_.get(0, 0);
	cell.topline = LINE_THICK;
	cell.leftline = LINE_THICK;
	cell = (Cell)data_.get(width - 1, 0);
	cell.topline = LINE_THICK;
	cell.rightline = LINE_THICK;
	for (int x = 0;x < width;x++) {
	    cell = (Cell)data_.get(x, 0);
	    cell.topline = LINE_THICK;
	}
    }

    class Cell {
	protected CTD cell;
	protected int topline;
	protected int bottomline;
	protected int leftline;
	protected int rightline;

	Cell(CTD cell) {
	    this.cell = cell;
	}

	public int getWidth() {
	    return (cell.getWidth());
	}

	public int getHeight() {
	    return (cell.getHeight());
	}
    }
}
