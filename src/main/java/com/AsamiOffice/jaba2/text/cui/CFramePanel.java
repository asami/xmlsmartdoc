/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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
 * CFramePanel
 *
 * @since   Aug. 25, 2003
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class CFramePanel extends CPanel {
    protected String title_;
    private ICKeisen keisen_;

    public void setTitle(String title) {
	title_ = title;
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
	int leftWidth = UString.getHalfLength(_getLeftLine());
	int rightWidth = UString.getHalfLength(_getRightLine());
	int topHeight = 1;
	int bottomHeight = 1;
	int gap = leftWidth + rightWidth;
        int contentWidth = width - gap;
	int y = 0;
	int size = nodes_.size();
	for (int i = 0;i < size;i++) {
	    CNode node = (CNode)nodes_.get(i);
	    node.layout(contentWidth);
	    node.setX(leftWidth);
	    node.setY(topHeight + y);
	    y += node.getHeight();
	}
	height_ = y + topHeight + bottomHeight;
    }

    public void draw(ICBoard board) {
	_drawFrameLine(board);
	int size = nodes_.size();
	for (int i = 0;i < size;i++) {
	    CNode node = (CNode)nodes_.get(i);
	    CBoardView clip
		= new CBoardView(board, node.getX(), node.getY());
	    node.draw(clip);
	}
    }

    private void _drawFrameLine(ICBoard board) {
	_drawTopLine(board);
	_drawBottomLine(board);
	_drawLeftLine(board);
	_drawRightLine(board);
	_drawTopLeftJoint(board);
	_drawTopRightJoint(board);
	_drawBottomLeftJoint(board);
	_drawBottomRightJoint(board);
    }

    private void _drawTopLine(ICBoard board) {
	String line = _getTopLine();
	int leftWidth = UString.getHalfLength(_getLeftLine());
	int rightWidth = UString.getHalfLength(_getRightLine());
	int width = width_ - (leftWidth + rightWidth);
	_drawHLine(line, leftWidth, 0, width, board);
	if (title_ != null) {
	    String title = " " + title_ + " ";
	    int length = UString.getHalfLength(title);
	    board.put(leftWidth + 6, 0, title);
	}
    }

    private void _drawBottomLine(ICBoard board) {
	String line = _getTopLine();
	int leftWidth = UString.getHalfLength(_getLeftLine());
	int rightWidth = UString.getHalfLength(_getRightLine());
	int width = width_ - (leftWidth + rightWidth);
	_drawHLine(line, leftWidth, height_ - 1, width, board);
    }

    private void _drawHLine(
	String line,
	int x,
	int y,
	int width,
	ICBoard board
    ) {
	int lineWidth = UString.getHalfLength(line);
	while (width > 0) {
	    board.put(x, y, line);
	    x += lineWidth;
	    width -= lineWidth;
	}
    }

    private void _drawLeftLine(ICBoard board) {
	String line = _getLeftLine();
	int heigth = height_ - 2;
	_drawVLine(line, 0, 1, height_ - 2, board);
    }

    private void _drawRightLine(ICBoard board) {
	String line = _getRightLine();
	int lineWidth = UString.getHalfLength(line);
	int heigth = height_ - 2;
	_drawVLine(line, width_ - lineWidth, 1, height_ - 2, board);
    }

    private void _drawVLine(
	String line,
	int x,
	int y,
	int height,
	ICBoard board
    ) {
	while (height > 0) {
	    board.put(x, y, line);
	    y++;
	    height--;
	}
    }

    private void _drawTopLeftJoint(ICBoard board) {
	board.put(0, 0, _getTopLeftJoint());
    }

    private void _drawTopRightJoint(ICBoard board) {
	String joint = _getTopRightJoint();
	int jointWidth = UString.getHalfLength(joint);
	board.put(width_ - jointWidth, 0, joint);
    }

    private void _drawBottomLeftJoint(ICBoard board) {
	board.put(0, height_ - 1, _getBottomLeftJoint());
    }

    private void _drawBottomRightJoint(ICBoard board) {
	String joint = _getBottomRightJoint();
	int jointWidth = UString.getHalfLength(joint);
	board.put(width_ - jointWidth, height_ - 1, joint);
    }

    protected String _getLeftLine() {
	return (keisen_.getPlainLeft());
    }

    protected String _getRightLine() {
	return (keisen_.getPlainRight());
    }

    protected String _getTopLine() {
	return (keisen_.getPlainTop());
    }

    protected String _getBottomLine() {
	return (keisen_.getPlainBottom());
    }

    protected String _getTopLeftJoint() {
	return (keisen_.getPlainTopLeft());
    }

    protected String _getTopRightJoint() {
	return (keisen_.getPlainTopRight());
    }

    protected String _getBottomLeftJoint() {
	return (keisen_.getPlainBottomLeft());
    }

    protected String _getBottomRightJoint() {
	return (keisen_.getPlainBottomRight());
    }
}
