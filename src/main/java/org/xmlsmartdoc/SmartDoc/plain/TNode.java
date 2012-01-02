/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2001  ASAMI, Tomoharu (asami@zeomtech.com)
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

import org.w3c.dom.Node;
import com.AsamiOffice.jaba2.xml.pdom.PElement;
import com.AsamiOffice.jaba2.text.cui.CPanel;

/**
 * TNode
 *
 * @since   Jul. 15, 1999
 * @version Mar.  1, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public interface TNode extends Node {
    void normalize();
    String format();
    void format(StringBuffer buffer);
    void format(CPanel cnode);
    int getTopGap();
    int getBottomGap();
}
