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

/**
 * CDiv
 *
 * @since   Jul. 10, 2000
 * @version Jul. 10, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
// XXX : under construction
public class CDiv extends CNode {
    protected List nodes_ = new ArrayList(); // List<CNode>

    public void append(CNode node) {
	nodes_.add(node);
    }

    public void layout(int width) {
	width_ = width;
	int y = 0;
	int size = nodes_.size();
	for (int i = 0;i < size;i++) {
	    CNode node = (CNode)nodes_.get(i);
	    node.layout(width_);
	    node.setX(0);
	    node.setY(y);
	    y += node.getHeight();
	}
	height_ = y;
    }

    public void draw(ICBoard board) {
	int size = nodes_.size();
	for (int i = 0;i < size;i++) {
	    CNode node = (CNode)nodes_.get(i);
	    CBoardView clip
		= new CBoardView(board, node.getX(), node.getY());
	    node.draw(clip);
	}
    }
}
