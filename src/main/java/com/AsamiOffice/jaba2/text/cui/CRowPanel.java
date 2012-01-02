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

/**
 * CRowPanel
 *
 * @since   Oct. 29, 1999
 * @version Oct. 29, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class CRowPanel extends CPanel {
    public void layout(int width) {
	width_ = width;
	int maxHeight = 0;
	int x = 0;
	int size = nodes_.size();
	for (int i = 0;i < size;i++) {
	    CNode node = (CNode)nodes_.get(i);
	    node.layout(width_ - x);
	    node.setX(x);
	    node.setY(0);
	    x += node.getWidth();
	    maxHeight = Math.max(maxHeight, node.getHeight());
	}
	height_ = maxHeight;
    }
}
