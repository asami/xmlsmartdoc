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
 * TAsciiKeisen
 *
 * @since   May. 21, 2001
 * @version May. 21, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class TAsciiKeisen implements ITKeisen {
    public String getTopLeft() {
	return ("+");
    }

    public String getTopRight() {
	return ("+");
    }

    public String getBottomLeft() {
	return ("+");
    }

    public String getBottomRight() {
	return ("+");
    }

    public String getTop() {
	return ("-");
    }

    public String getBottom() {
	return ("-");
    }

    public String getLeft() {
	return ("|");
    }

    public String getRight() {
	return ("|");
    }

    public String getLeftThickJoint() {
	return ("|");
    }

    public String getRightThickJoint() {
	return ("|");
    }

    public String getLeftThinJoint() {
	return ("|");
    }

    public String getRightThinJoint() {
	return ("|");
    }

    public String getThickHLine() {
	return ("=");
    }

    public String getThickVLine() {
	return ("||");
    }

    public String getThinHLine() {
	return ("-");
    }

    public String getThinVLine() {
	return ("|");
    }

    public String getTopThickJoint() {
	return ("+");
    }

    public String getBottomThickJoint() {
	return ("+");
    }

    public String getTopThinJoint() {
	return ("+");
    }

    public String getBottomThinJoint() {
	return ("+");
    }

    public String getHThickVThickJoint() {
	return ("=");
    }

    public String getHThickVThinJoint() {
	return ("=");
    }

    public String getHThinVThickJoint() {
	return ("||");
    }

    public String getHThinVThinJoint() {
	return ("+");
    }
}
