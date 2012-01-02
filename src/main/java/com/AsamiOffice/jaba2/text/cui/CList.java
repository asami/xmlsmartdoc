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

/**
 * CList
 *
 * @since   Mar.  1, 2001
 * @version Mar.  4, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class CList extends CNode {
    private List terms_ = new ArrayList(); // List<CBox>
    private List marks_ = new ArrayList(); // List<CBox>
    private List descs_ = new ArrayList(); // List<CNode>
    private int indent_ = 2;
    private String mark_ = "  ";
    private String termAlign_ = "right";

    public final void addEntry(CBox term, CNode desc) {
	terms_.add(term);
	descs_.add(desc);
    }

    public final void setIndent(int indent) {
	indent_ = indent;
    }

    public final void setMark(String mark) {
	mark_ = mark;
    }

    public void layout(int width) {
	int termWidth = _getTermWidth(width);
	int markWidth = UCUI.getWidth(mark_);
	int descWidth = width - (indent_ + termWidth + markWidth);
	int termX = indent_;
	int descX = indent_ + markWidth + termWidth;
	width_ = width;
	int y = 0;
	int size = terms_.size();
	for (int i = 0;i < size;i++) {
	    CBox term = (CBox)terms_.get(i);
	    CPanel desc = (CPanel)descs_.get(i);
	    desc.layout(descWidth);
	    term.setX(termX);
	    term.setY(y);
	    term.setAlign(termAlign_);
	    // XXX : mark
	    desc.setX(descX);
	    desc.setY(y);
	    y += Math.max(term.getHeight(), desc.getHeight());
	}
	height_ = y;
    }

    private int _getTermWidth(int width) {
	int maxWidth = 0;
	int size = terms_.size();
	for (int i = 0;i < size;i++) {
	    CBox box = (CBox)terms_.get(i);
	    box.layout(width);
	    maxWidth = Math.max(box.getWidth(), maxWidth);
	}
	return (maxWidth);
    }

    public void draw(ICBoard board) {
	int size = terms_.size();
	for (int i = 0;i < size;i++) {
	    CBox term = (CBox)terms_.get(i);
	    CPanel desc = (CPanel)descs_.get(i);
	    CBoardView clip
		= new CBoardView(board, term.getX(), term.getY());
	    term.draw(clip);
	    clip = new CBoardView(board, desc.getX(), desc.getY());
	    desc.draw(clip);
	}
    }
}
