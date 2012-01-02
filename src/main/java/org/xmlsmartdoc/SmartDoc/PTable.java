/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998,1999  ASAMI, Tomoharu (tasami@ibm.net)
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

package org.xmlsmartdoc.SmartDoc;

import java.util.*;
import org.w3c.dom.Element;

import com.AsamiOffice.util.D2Array;

import org.xmlsmartdoc.SmartDoc.adapter.CSVAdapter;

/**
 * PTable is a representation of table to specify physical structure.
 *
 * @since   Jan. 29, 1999
 * @version May. 11, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class PTable {
    protected Table table_;
    protected D2Array head_ = new D2Array(); // D2Array<HeadCell>
    protected D2Array data_ = new D2Array(); // D2Array<DataCell>
    protected D2Array foot_ = new D2Array(); // D2Array<FootCell>

    public PTable(Table table) {
	table_ = table;
	Rowgroup[] rowgroups = table.getRowgroups();
	int[][] layout = new int[rowgroups.length][];
	for (int i = 0;i < rowgroups.length;i++) {
	    layout[i] = rowgroups[i].getSpans();
	}
	_buildHead(layout);
	_buildFoot(layout);
	_buildData(layout);
    }

    public int getHeadWidth() {
	return (head_.getWidth());
    }

    public int getHeadHeight() {
	return (head_.getHeight());
    }

    public HeadCell getHead(int x, int y) {
	return ((HeadCell)head_.get(x, y));
    }

    public int getFootWidth() {
	return (foot_.getWidth());
    }

    public int getFootHeight() {
	return (foot_.getHeight());
    }

    public FootCell getFoot(int x, int y) {
	return ((FootCell)foot_.get(x, y));
    }

    public int getDataWidth() {
	return (data_.getWidth());
    }

    public int getDataHeight() {
	return (data_.getHeight());
    }

    public DataCell getData(int x, int y) {
	return ((DataCell)data_.get(x, y));
    }

    protected void _buildHead(int[][] layout) {
	D2Array temp = new D2Array();
	int width = table_.getWidth();
	int height = 1;		// XXX
	// build temp table
	for (int y = 0;y < height;y++) {
	    for (int x = 0;x < width;x++) {
		if (temp.get(x, y) != null) {
		    continue;
		}
		Th th = table_.getTh(x, y);
		int colspan = th.getColSpan();
		int rowspan = th.getRowSpan();
		HeadCell cell = new HeadCell();
		cell.data = th;
		temp.put(x, y, cell);
		for (int i = x + 1;i < x + colspan;i++) {
		    temp.put(i, y, new StubHeadCell(cell));
		}
		for (int i = y + 1;i < y + rowspan;i++) {
		    temp.put(x, i, new StubHeadCell(cell));
		}
	    }
	}
	// pack cell
	int py = 0;		// head_
	int px = 0;		// head_
	int layouty = 0;	// layout
	int layoutx = 0;	// layout
	for (int y = 0;y < height;y++) { // temp
	    for (int x = 0;x < width;x++) { // temp
		HeadCell cell = (HeadCell)temp.get(x, y); // XXX : Stub
		Th th = cell.data;
		int lcolspan = th.getColSpan();
		if (lcolspan == 0) {
		    lcolspan = 1;
		}
		int pcolspan = 0;
		for (int i = 0;i < lcolspan;i++) {
		    pcolspan += layout[layouty][layoutx++];
		    if (layoutx == layout[layouty].length) {
			layoutx = 0;
			layouty++;
			if (layouty == layout.length) {
			    layouty = 0;
			}
		    }
		}
		cell.colspan = pcolspan;
		cell.rowspan = 1; // XXX
		head_.put(px, py, cell);
		if (layoutx == 0) {
		    px = 0;
		    py++;
		} else {
		    px += pcolspan;
		}
	    }
	}
    }

    protected void _buildData(int[][] layout) {
	D2Array temp = new D2Array();
	int width = table_.getWidth();
	int height = table_.getHeight();
	// build temp table
	for (int y = 0;y < height;y++) {
	    for (int x = 0;x < width;x++) {
		if (temp.get(x, y) != null) {
		    continue;
		}
		Td td = table_.getTd(x, y);
		int colspan = td.getColSpan();
		int rowspan = td.getRowSpan();
		DataCell cell = new DataCell();
		cell.data = td;
		temp.put(x, y, cell);
		for (int i = x + 1;i < x + colspan;i++) {
		    temp.put(i, y, new StubDataCell(cell));
		}
		for (int i = y + 1;i < y + rowspan;i++) {
		    temp.put(x, i, new StubDataCell(cell));
		}
	    }
	}
	// pack cell
	int py = 0;		// data_
	int px = 0;		// data_
	int layouty = 0;	// layout
	int layoutx = 0;	// layout
	for (int y = 0;y < height;y++) { // temp
	    for (int x = 0;x < width;x++) { // temp
		DataCell cell = (DataCell)temp.get(x, y); // XXX : Stub
		Td td = cell.data;
		int lcolspan = td.getColSpan();
		if (lcolspan == 0) {
		    lcolspan = 1;
		}
		int pcolspan = 0;
		for (int i = 0;i < lcolspan;i++) {
		    pcolspan += layout[layouty][layoutx++];
		    if (layoutx == layout[layouty].length) {
			layoutx = 0;
			layouty++;
			if (layouty == layout.length) {
			    layouty = 0;
			}
		    }
		}
		cell.colspan = pcolspan;
		cell.rowspan = 1; // XXX
		data_.put(px, py, cell);
		if (layoutx == 0) {
		    px = 0;
		    py++;
		} else {
		    px += pcolspan;
		}
	    }
	}
/*
	// pack cell
	int xx = 0;
	int yy = 0;
	int nRows = layout.length;
	for (int y = 0;y < height;y++) {
	    int row = 0;
	    int column = 0;
	    int nColumns = layout[0].length;
	    int columnCount = 0;
	    for (int x = 0;x < width;x++) {
		if (columnCount == 0) {
		    columnCount = layout[row][column];
		}
		DataCell cell = (DataCell)temp.get(x, y);
		data_.put(xx, yy, cell);
		if (--columnCount == 0) {
		    column++;
		    if (column == nColumns) {
			row++;
			nColumns = layout[row].length;
			column = 0;
			yy++;
			xx = 0;
		    }
		}
	    }
	    yy++;
	}
*/
    }

    protected void _buildFoot(int[][] layout) {
    }

    public static class HeadCell {
	public int colspan;
	public int rowspan;
	public Th data;
    }

    public static class FootCell {
	public int colspan;
	public int rowspan;
	public Th data;
    }

    public static class DataCell {
	public int colspan;
	public int rowspan;
	public Td data;
    }

    public static class StubHeadCell {
	public HeadCell origin;

	public StubHeadCell(HeadCell origin) {
	    this.origin = origin;
	}
    }

    public static class StubFootCell {
	public FootCell origin;

	public StubFootCell(FootCell origin) {
	    this.origin = origin;
	}
    }

    public static class StubDataCell {
	public DataCell origin;

	public StubDataCell(DataCell origin) {
	    this.origin = origin;
	}
    }
}
