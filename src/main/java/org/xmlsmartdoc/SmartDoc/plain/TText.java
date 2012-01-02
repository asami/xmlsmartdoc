/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import com.AsamiOffice.jaba2.text.cui.CBox;
import com.AsamiOffice.jaba2.text.cui.CPanel;
import com.AsamiOffice.jaba2.xml.pdom.PText;

/**
 * TText
 *
 * @since   Oct.  8, 1999
 * @version Dec.  8, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class TText extends PText implements TNode {
    public TText(String text) {
        super(text);
    }

    public boolean isVerticalGap() {
        return (false);
    }

    public void normalize() {
    }

    public String format() {
        return (getData());
    }

    public void format(StringBuffer buffer) {
        buffer.append(getData());
    }

    public void format(CPanel node) {
        CBox text = new CBox(getData());
        text.setNatural(true);
        node.append(text);
    }

    public int getTopGap() {
        return (0);
    }

    public int getBottomGap() {
        return (0);
    }
}
