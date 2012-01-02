/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2000  ASAMI, Tomoharu (asami@zeomtech.com)
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

package org.xmlsmartdoc.SmartDoc.plain;

import org.w3c.dom.Text;
import com.AsamiOffice.jaba2.text.UString;
import com.AsamiOffice.jaba2.text.cui.*;

/**
 * THr
 *
 * @since   Jun. 19, 2000
 * @version May. 23, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class THr extends AbstractTElement {
    private String keisenStyle_;

    public THr() {
	this("ascii");
    }

    public THr(String keisenStyle) {
	super("thr");
	keisenStyle_ = keisenStyle;
    }

    public boolean isVerticalGap() {
	return (false);
    }

    public void format(CPanel node) {
	CHr hr = new CHr();
	hr.setKeisenStyle(keisenStyle_);
	node.append(hr);
    }
}
