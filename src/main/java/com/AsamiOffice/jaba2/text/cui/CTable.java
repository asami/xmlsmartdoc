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

import java.util.*;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.D2Array;

/**
 * CTable
 *
 * @since   Oct. 19, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class CTable extends CNode {
    protected List columns_ = new ArrayList(); // List<ColumnInfo>
    protected D2Array head_ = new D2Array(); // D2Array<CTD>
    protected D2Array foot_ = new D2Array(); // D2Array<CTD>
    protected D2Array body_ = new D2Array(); // D2Array<CTD>
    protected ICKeisen keisen_;
    protected String keisenStyle_;

    public CTable(String style) {
	setKeisenStyle(style);
    }

    public void setKeisenStyle(String style) {
	keisenStyle_ = style;
	if ("jis".equals(style)) {
	    keisen_ = new CJisKeisen();
	} else {
	    keisen_ = new CAsciiKeisen();
	}
    }

    private ColumnInfo _getColumnInfo(int x) {
	if (columns_.size() > x) {
	    ColumnInfo info = (ColumnInfo)columns_.get(x);
	    return (info);
	} else {
	    ColumnInfo info = new ColumnInfo();
	    for (int i = columns_.size();i <= x;i++) {
		columns_.add(i, null);
	    }
	    columns_.set(x, info);
	    return (info);
	}
    }	

    public void setColumnWidth(int x, int width) {
	ColumnInfo info = _getColumnInfo(x);
	info.width = width;
    }

    public void setColumnAlign(int x, String align) {
	ColumnInfo info = _getColumnInfo(x);
	info.align = align;
    }

    public void setHead(int x, int y, String data) {
	setHead(x, y, new CTD(data));
    }

    public void setHead(int x, int y, CTD cell) {
	cell.setAlign("center");
	head_.put(x, y, cell);
    }

    public void setFoot(int x, int y, String data) {
	setFoot(x, y, new CTD(data));
    }

    public void setFoot(int x, int y, CTD cell) {
	cell.setAlign("center");
	foot_.put(x, y, cell);
    }

    public void setBody(int x, int y, String data) {
	body_.put(x, y, new CTD(data));
    }

    public void setBody(int x, int y, CTD cell) {
	body_.put(x, y, cell);
    }

    public void layout(int width) {
	draw(new CBoardBase());	// XXX
    }

/*
    protected void _layoutData(D2Array data, int layoutWidth) {
	int width = data.getWidth();
	int height = data.getHeight();
	for (int y = 0;y < height;y++) {
	    for (int x = 0;x < width;x++) {
		CTD cell = (CTD)data.get(x, y);
		int columnWidth = layoutWidth; // XXX
		if (cell != null) {
		    cell.layout(columnWidth);
		}
	    }
	}
    }
*/

    public void draw(ICBoard board) {
	ColumnInfo[] columns = _makeColumns();
	int width = body_.getWidth();
	int posx = 0;
	int posy = 0;
	// top
	String topleft = _getTopLeft();
	board.put(posx, posy, topleft);
	posx += UString.getHalfLength(topleft);
	String top = _getTop();
	int topWidth = UString.getHalfLength(top);
	String topthinjoint = _getTopThinJoint();
	int topthinjointWidth = UString.getHalfLength(topthinjoint);
	if (width > 0) {
	    int columnWidth = columns[0].width;
	    int loop = _calcLoopCount(columnWidth, topWidth);
	    while (loop-- > 0) {
		board.put(posx, posy, top);
		posx += topWidth;
	    }
	    for (int x = 1;x < width;x++) {
		board.put(posx, posy, topthinjoint);
		posx += topthinjointWidth;
		columnWidth = columns[x].width;
		loop = _calcLoopCount(columnWidth, topWidth);
		while (loop-- > 0) {
		    board.put(posx, posy, top);
		    posx += topWidth;
		}
	    }
	}
	String topright = _getTopRight();
	board.put(posx, posy, topright);
	//
	posx = 0;
	posy = 1;
	if (head_.getHeight() > 0) {
	    posy = _drawData(head_, posx, posy, columns, board);
	    if (body_.getHeight() > 0 || foot_.getHeight() > 0) {
		String left = _getLeftThickJoint();
		String right = _getRightThickJoint();
		String joint = _getHThickVThinJoint();
		String hline = _getThickHLine();
		posy += _drawSeparatorLine(
		    posx,
		    posy,
		    columns,
		    left,
		    right,
		    joint,
		    hline,
		    board
		);
	    }
	}
	if (body_.getHeight() > 0) {
	    posy = _drawData(body_, posx, posy, columns, board);
	    if (foot_.getHeight() > 0) {
		String left = _getLeftThickJoint();
		String right = _getRightThickJoint();
		String joint = _getHThickVThinJoint();
		String hline = _getThickHLine();
		posy += _drawSeparatorLine(
		    posx,
		    posy,
		    columns,
		    left,
		    right,
		    joint,
		    hline,
		    board
		);
	    }
	}
	if (foot_.getHeight() > 0) {
	    posy = _drawData(foot_, posx, posy, columns, board);
	}
	// bottom
	posx = 0;
	String bottomleft = _getBottomLeft();
	board.put(posx, posy, bottomleft);
	posx += UString.getHalfLength(bottomleft);
	String bottom = _getBottom();
	int bottomWidth = UString.getHalfLength(bottom);
	String bottomthinjoint = _getBottomThinJoint();
	int bottomthinjointWidth = UString.getHalfLength(bottomthinjoint);
	if (width > 0) {
	    int columnWidth = columns[0].width;
	    int loop = _calcLoopCount(columnWidth, bottomWidth);
	    while (loop-- > 0) {
		board.put(posx, posy, bottom);
		posx += bottomWidth;
	    }
	    for (int x = 1;x < width;x++) {
		board.put(posx, posy, bottomthinjoint);
		posx += bottomthinjointWidth;
		columnWidth = columns[x].width;
		loop = _calcLoopCount(columnWidth, bottomWidth);
		while (loop-- > 0) {
		    board.put(posx, posy, bottom);
		    posx += bottomWidth;
		}
	    }
	}
	String bottomright = _getBottomRight();
	board.put(posx, posy, bottomright);
	setWidth(posx);		// XXX
	setHeight(posy + 1);	// XXX
    }

    protected int _drawData(
	D2Array array,
	int posx,
	int posy,
	ColumnInfo[] columns,
	ICBoard board
    ) {
	int posy0 = posy;
	RowInfo[] rowInfos = _makeRows(array, columns);
	int width = array.getWidth();
	int height = array.getHeight();

	posy0 += _drawRow(array, 0, posx, posy0, columns, rowInfos, board);
	for (int y = 1;y < height;y++) {
	    posy0 +=
		_drawSeparatorLine(array, y - 1, posx, posy0, columns, board);
	    posy0 +=
		_drawRow(array, y, posx, posy0, columns, rowInfos, board);
	}
	return (posy0);
    }

    private int _drawRow(
	D2Array array,
	int y,
	int posx,
	int posy,
	ColumnInfo[] columns,
	RowInfo[] rows,
	ICBoard board
    ) {
	String left = _getLeft();
	int leftWidth = UString.getHalfLength(left);
	String right = _getRight();
	int rightWidth = UString.getHalfLength(right);
	String thinvline = _getThinVLine();
	int thinvlineWidth = UString.getHalfLength(thinvline);
	String thinhline = _getThinHLine();
	int thinhlineWidth = UString.getHalfLength(thinhline);

	int vLength = rows[y].height;
	int width = array.getWidth();
	// left
	_drawVLine(posx, posy, vLength, left, board);
	posx += leftWidth;
	// body
	boolean isVline = false;
	for (int x = 0;x < width;x++) {
	    if (isVline) {
		_drawVLine(posx, posy, vLength, thinvline, board);
		posx += thinvlineWidth;
	    }
	    CTD cell = (CTD)array.get(x, y);
	    if (cell != null) {
		_setWidth(cell, columns, x, thinvlineWidth);
		cell.layout(columns[x].width);
		cell.draw(new CBoardView(board, posx, posy));
		posx += columns[x].width;
//System.out.println(cell.getColSpan());
		if (cell.getColSpan() == 1) {
		    isVline = true;
		} else {
		    isVline = false;
		}
	    } else {
		posx += columns[x].width;
		isVline = _isBoundaryCell(array, x, y);
	    }
	    if (!isVline) {
		posx += thinvlineWidth;
	    }
	}
	// right
	_drawVLine(posx, posy, vLength, left, board);
	return (vLength);
    }

    private void _setWidth(
	CTD cell,
	ColumnInfo[] columns,
	int x,
	int lineWidth
    ) {
	int colspan = cell.getColSpan();
	int sum = columns[x].width;
	while (--colspan > 0) {
	    sum += lineWidth;
	    sum += columns[++x].width;
	}
	cell.setWidth(sum);
    }

    private boolean _isBoundaryCell(D2Array array, int x, int y) {
	for (int x0 = x;x0 >= 0;x0--) {
	    for (int y0 = y;y0 >= 0;y0--) {
		CTD cell = (CTD)array.get(x0, y0);
		if (cell != null) {
		    int boundsX = x0 + cell.getColSpan() - 1;
		    int boundsY = y0 + cell.getRowSpan() - 1;
//			    System.out.println("pre;x = " + x + " y = " + y + " boundsX = " + boundsX + " boundsY = " + boundsY);
		    if (boundsY >= y) {
			if (boundsX == x) {
//			    System.out.println("true;x = " + x + " y = " + y + " boundsX = " + boundsX + " boundsY = " + boundsY);
			    return (true);
			}
			if (boundsX > x) {
//			    System.out.println("false;x = " + x + " y = " + y + " boundsX = " + boundsX + " boundsY = " + boundsY);
			    return (false);
			}
		    }
		}
	    }
	}
	return (false);
//	throw (new InternalError());
    }

    private int _drawSeparatorLine(
	int posx,
	int posy,
	ColumnInfo[] columns,
	String left,
	String right,
	String joint,
	String hline,
	ICBoard board
    ) {
	board.put(posx, posy, left);
	posx += UString.getHalfLength(left);
	int lineWidth = UString.getHalfLength(hline);
	int loop = _calcLoopCount(columns[0].width, lineWidth);
	while (loop-- > 0) {
	    board.put(posx, posy, hline);
	    posx += lineWidth;
	}
	for (int i = 1;i < columns.length;i++) {
	    lineWidth = UString.getHalfLength(joint);
	    board.put(posx, posy, joint);
	    posx += lineWidth;
	    lineWidth = UString.getHalfLength(hline);
	    loop = _calcLoopCount(columns[i].width, lineWidth);
	    while (loop-- > 0) {
		board.put(posx, posy, hline);
		posx += lineWidth;
	    }
	}
	board.put(posx, posy, right);
	return (1);
    }

    private int _drawSeparatorLine(
	D2Array data,
	int y,
	int posx,
	int posy,
	ColumnInfo[] columns,
	ICBoard board
    ) {
	String left = _getLeftThinJoint();
	int leftWidth = UString.getHalfLength(left);
	String right = _getRightThinJoint();
	int rightWidth = UString.getHalfLength(right);
	String thinhline = _getThinHLine();
	int thinhlineWidth = UString.getHalfLength(thinhline);
	String joint = _getHThinVThinJoint();
	int jointWidth = UString.getHalfLength(joint);

	int width = data.getWidth();
	board.put(posx, posy, left);
	posx += leftWidth;
	if (_isVSeparate(data, 0, y)) {
	    int loop = _calcLoopCount(columns[0].width, thinhlineWidth);
	    while (loop-- > 0) {
		board.put(posx, posy, thinhline);
		posx += thinhlineWidth;
	    }
	} else {
	    posx += columns[0].width;
	}
	for (int x = 1;x < width;x++) {
	    joint = _getJoint(data, x - 1, y);
	    if (joint != null) {
		board.put(posx, posy, joint);
	    }
	    posx += jointWidth;
	    if (_isVSeparate(data, x, y)) {
		int loop = _calcLoopCount(columns[x].width, thinhlineWidth);
		while (loop-- > 0) {
		    board.put(posx, posy, thinhline);
		    posx += thinhlineWidth;
		}
	    } else {
		posx += columns[x].width;
	    }
	}
	board.put(posx, posy, right);
	return (1);
    }

    private String _getJoint(D2Array data, int x, int y) {
	if (_isBoundaryCell(data, x, y) || _isVSeparate(data, x, y)) {
	    return (_getHThinVThinJoint());
	} else {
	    return (null);
	}
    }

    private boolean _isVSeparate(D2Array data, int x, int y) {
	for (int x0 = x;x0 >= 0;x0--) {
	    for (int y0 = y;y0 >= 0;y0--) {
		CTD cell = (CTD)data.get(x0, y0);
		if (cell != null) {
		    int boundsX = x0 + cell.getColSpan() - 1;
		    int boundsY = y0 + cell.getRowSpan() - 1;
//			    System.out.println("pre;x = " + x + " y = " + y + " boundsX = " + boundsX + " boundsY = " + boundsY);
		    if (boundsX >= x) {
			if (boundsY == y) {
//			    System.out.println("true;x = " + x + " y = " + y + " boundsX = " + boundsX + " boundsY = " + boundsY);
			    return (true);
			}
			if (boundsY > y) {
//			    System.out.println("false;x = " + x + " y = " + y + " boundsX = " + boundsX + " boundsY = " + boundsY);
			    return (false);
			}
		    }
		}
	    }
	}
	return (false);
    }

    protected void _drawVLine(
	int posx,
	int posy,
	int length,
	String bar,
	ICBoard board
    ) {
	while (length-- > 0) {
	    board.put(posx, posy++, bar);
	}
    }

    protected ColumnInfo[] _makeColumns() {
	int nColumns = 0;
	if (head_ != null) {
	    nColumns = Math.max(head_.getWidth(), nColumns);
	}
	if (foot_ != null) {
	    nColumns = Math.max(foot_.getWidth(), nColumns);
	}
	if (body_ != null) {
	    nColumns = Math.max(body_.getWidth(), nColumns);
	}
	int[] columns = new int[nColumns];
	_makeColumns(head_, columns);
	_makeColumns(foot_, columns);
	_makeColumns(body_, columns);
	ColumnInfo[] infos = new ColumnInfo[nColumns];
	for (int i = 0;i < nColumns;i++) {
	    ColumnInfo info = _getColumnInfo(i);
	    if (info.width == 0) {
		info.width = columns[i];
	    }
	    infos[i] = info;
	}
	return (infos);
    }

    protected void _makeColumns(D2Array data, int[] columns) {
	int width = data.getWidth();
	int height = data.getHeight();
	for (int x = 0;x < width;x++) {
	    int columnWidth = columns[x];
	    for (int y = 0;y < height;y++) {
		CTD cell = (CTD)data.get(x, y);
		if (cell != null) {
		    String text = cell.getText();
		    columnWidth
			= Math.max(columnWidth, UCUI.getWidth(text));
		    columnWidth = _adjustWidth(columnWidth);
		}
	    }
	    columns[x] = columnWidth;
	}
    }

    protected RowInfo[] _makeRows(D2Array data, ColumnInfo[] columns) {
	int width = data.getWidth();
	int height = data.getHeight();
	RowInfo[] infos = new RowInfo[height];
	for (int y = 0;y < height;y++) {
	    RowInfo info = new RowInfo();
	    for (int x = 0;x < width;x++) {
		CTD cell = (CTD)data.get(x, y);
		if (cell != null) {
		    switch (cell.getRowSpan()) {

		    case 1:
			info.height = Math.max(
			    info.height,
			    _calcNLine(
				cell.getText(),
				_calcWidth(cell.getColSpan(), columns, x)
			    )
			);
			break;
		    default:
			// XXX
		    }
		}
	    }
	    infos[y] = info;
	}
	return (infos);
    }

    protected int _calcNLine(String text, int width) {
	String[] chunks = UCUI.getLines(text, width);
	return (chunks.length);
    }

    protected int _calcWidth(int colspan, ColumnInfo[] infos, int x) {
	int width = 0;
	if (colspan > 0) {
	    width = infos[x].width;
	    while (--colspan > 0) {
		width += UString.getHalfLength(_getThinVLine());
		width += infos[++x].width;
	    }
	}
	return (width);
    }

    protected String _getTopLeft() {
	return (keisen_.getTopLeft());
    }

    protected String _getTopRight() {
	return (keisen_.getTopRight());
    }

    protected String _getBottomLeft() {
	return (keisen_.getBottomLeft());
    }

    protected String _getBottomRight() {
	return (keisen_.getBottomRight());
    }

    protected String _getTop() {
	return (keisen_.getTop());
    }

    protected String _getBottom() {
	return (keisen_.getBottom());
    }

    protected String _getLeft() {
	return (keisen_.getLeft());
    }

    protected String _getRight() {
	return (keisen_.getRight());
    }

    protected String _getLeftThickJoint() {
	return (keisen_.getLeftThickJoint());
    }

    protected String _getRightThickJoint() {
	return (keisen_.getRightThickJoint());
    }

    protected String _getLeftThinJoint() {
	return (keisen_.getLeftThinJoint());
    }

    protected String _getRightThinJoint() {
	return (keisen_.getRightThinJoint());
    }

    protected String _getThickHLine() {
	return (keisen_.getThickHLine());
    }

    protected String _getThickVLine() {
	return (keisen_.getThickVLine());
    }

    protected String _getThinHLine() {
	return (keisen_.getThinHLine());
    }

    protected String _getThinVLine() {
	return (keisen_.getThinVLine());
    }

    protected String _getTopThickJoint() {
	return (keisen_.getTopThickJoint());
    }

    protected String _getBottomThickJoint() {
	return (keisen_.getBottomThickJoint());
    }

    protected String _getTopThinJoint() {
	return (keisen_.getTopThinJoint());
    }

    protected String _getBottomThinJoint() {
	return (keisen_.getBottomThinJoint());
    }

    protected String _getHThickVThickJoint() {
	return (keisen_.getHThickVThickJoint());
    }

    protected String _getHThickVThinJoint() {
	return (keisen_.getHThickVThinJoint());
    }

    protected String _getHThinVThickJoint() {
	return (keisen_.getHThinVThickJoint());
    }

    protected String _getHThinVThinJoint() {
	return (keisen_.getHThinVThinJoint());
    }


    private int _adjustWidth(int width) {
	if (!"jis".equals(keisenStyle_)) {
	    return (width);
	}
	return (width + (width % 2));
    }

    private int _calcLoopCount(int width, int lineWidth) {
	return (UCUI.calcHLineLoopCount(width, lineWidth));
    }

    static class ColumnInfo {
	int width;
	String align = "left";

	public String[] makeData(String data) {
	    List list = new ArrayList();
	    StringBuffer buffer = new StringBuffer();
	    String[] lines = UString.makeStringList(data);
	    int curWidth = 0;
	    for (int i = 0;i < lines.length;i++) {
		String string = lines[i];
		int size = string.length();
		for (int j = 0;j < size;j++) {
		    char c = string.charAt(j);
		    if (UString.isWideCharacter(c)) {
			if (curWidth + 1 == width) {
			    buffer.append(" ");
			    list.add(new String(buffer));
			    buffer = new StringBuffer();
			    buffer.append(c);
			    curWidth = 2;
			} else {
			    buffer.append(c);
			    if (curWidth + 2 == width) {
				list.add(new String(buffer));
				buffer = new StringBuffer();
				curWidth = 0;
			    } else {
				curWidth += 2;
			    }
			}
		    } else {
			buffer.append(c);
			if (curWidth + 1 == width) {
			    list.add(new String(buffer));
			    buffer = new StringBuffer();
			    curWidth = 0;
			} else {
			    curWidth++;
			}
		    }
		}
		int curSize = UString.getHalfLength(new String(buffer));
		if (curSize > 0) {
		    int count = width - curSize;
		    while (count-- > 0) {
			buffer.append(" ");
		    }
		    list.add(new String(buffer));
		    buffer = new StringBuffer();
		    curWidth = 0;
		}
	    }
	    String[] result = new String[list.size()];
	    return ((String[])list.toArray(result));
	}
    };

    static class RowInfo {
	int height = 0;
	String align = "right";
    };
}
