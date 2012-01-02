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

/**
 * UTTree
 *
 * @since   Jul. 16, 1999
 * @version Mar.  5, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public final class UTTree {
    public static THeading makeSimpleCenterHeading(String title) {
	THeading heading = new THeading(title);
	heading.setPrologueSpan(0);
	heading.setEpilogueSpan(0);
	heading.setUnderlineSpan(0);
	heading.setUnderline(null);
	heading.setAlign("center");
	return (heading);
    }
}
