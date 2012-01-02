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
 * TJisKeisen
 *
 * @since   May. 21, 2001
 * @version May. 21, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class TJisKeisen implements ITKeisen {
    public String getTopLeft() {
	return ("\u250f");
    }

    public String getTopRight() {
	return ("\u2513");
    }

    public String getBottomLeft() {
	return ("\u2517");
    }

    public String getBottomRight() {
	return ("\u251b");
    }

    public String getTop() {
	return ("\u2501");
    }

    public String getBottom() {
	return ("\u2501");
    }

    public String getLeft() {
	return ("\u2503");
    }

    public String getRight() {
	return ("\u2503");
    }

    public String getLeftThickJoint() {
	return ("\u2523");
    }

    public String getRightThickJoint() {
	return ("\u252b");
    }

    public String getLeftThinJoint() {
	return ("\u2520");
    }

    public String getRightThinJoint() {
	return ("\u2528");
    }

    public String getThickHLine() {
	return ("\u2501");
    }

    public String getThickVLine() {
	return ("\u2503");
    }

    public String getThinHLine() {
	return ("\u2500");
    }

    public String getThinVLine() {
	return ("\u2502");
    }

    public String getTopThickJoint() {
	return ("\u2533");
    }

    public String getBottomThickJoint() {
	return ("\u253b");
    }

    public String getTopThinJoint() {
	return ("\u252f");
    }

    public String getBottomThinJoint() {
	return ("\u2537");
    }

    public String getHThickVThickJoint() {
	return ("\u254b");
    }

    public String getHThickVThinJoint() {
	return ("\u253f");
    }

    public String getHThinVThickJoint() {
	return ("\u2542");
    }

    public String getHThinVThinJoint() {
	return ("\u253c");
    }
}
