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
 * CTD
 *
 * @since   Oct. 19, 1999
 * @version Jun. 24, 2000
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class CTD extends CBox {
    protected int rowspan_ = 1;
    protected int colspan_ = 1;

    public CTD(String text) {
	super(text);
    }

    public void setRowSpan(int span) {
	rowspan_ = span;
    }

    public void setColSpan(int span) {
	colspan_ = span;
    }

    public int getRowSpan() {
	return (rowspan_);
    }

    public int getColSpan() {
	return (colspan_);
    }
}
