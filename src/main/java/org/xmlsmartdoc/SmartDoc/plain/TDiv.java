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
 * TDiv
 *
 * @since   Jun. 16, 2000
 * @version Jul. 16, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class TDiv extends AbstractTElement {
    private int topGap_ = 0;
    private int bottomGap_ = 0;

    public TDiv() {
	super("tdiv");
    }

    protected TDiv(String name) {
	super(name);
    }

    public boolean isVerticalGap() {
	return (true);
    }

    public final void setTopGap(int gap) {
	topGap_ = gap;
    }

    public final void setBottomGap(int gap) {
	bottomGap_ = gap;
    }

    public int getTopGap() {
	return (Math.max(topGap_, super.getTopGap()));
    }

    public int getBottomGap() {
	return (Math.max(bottomGap_, super.getBottomGap()));
    }
}
