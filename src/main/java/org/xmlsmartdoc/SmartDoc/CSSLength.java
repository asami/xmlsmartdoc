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

package org.xmlsmartdoc.SmartDoc;

import java.util.*;

/**
 * CSSLength
 *
 * @since   Feb. 11, 1999
 * @version Aug. 12, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class CSSLength {
    public static final int UNKNOWN = -1;
    public static final int IN = 1;
    public static final int CM = 2;
    public static final int MM = 3;
    public static final int PT = 4;
    public static final int PC = 5;
    public static final int EM = 6;
    public static final int EX = 7;
    public static final int PX = 8;
    public static final int PERCENT = 9;

    protected String string_;
    protected int unit_;
    protected float value_;

    public CSSLength(String string) {
	string_ = string;
	string = string.toUpperCase();
	try {
	    if (string.endsWith("IN")) {
		unit_ = IN;
		value_ = Float.parseFloat(
		    string.substring(0, string.length() - 2)
		);
	    } else if (string.endsWith("CM")) {
		unit_ = CM;
		value_ = Float.parseFloat(
		    string.substring(0, string.length() - 2)
		);
	    } else if (string.endsWith("MM")) {
		unit_ = MM;
		value_ = Float.parseFloat(
		    string.substring(0, string.length() - 2)
		);
	    } else if (string.endsWith("PT")) {
		unit_ = PT;
		value_ = Float.parseFloat(
		    string.substring(0, string.length() - 2)
		);
	    } else if (string.endsWith("PC")) {
		unit_ = PC;
		value_ = Float.parseFloat(
		    string.substring(0, string.length() - 2)
		);
	    } else if (string.endsWith("EM")) {
		unit_ = EM;
		value_ = Float.parseFloat(
		    string.substring(0, string.length() - 2)
		);
	    } else if (string.endsWith("EX")) {
		unit_ = EX;
		value_ = Float.parseFloat(
		    string.substring(0, string.length() - 2)
		);
	    } else if (string.endsWith("PX")) {
		unit_ = PX;
		value_ = Float.parseFloat(
		    string.substring(0, string.length() - 2)
		);
	    } else if (string.endsWith("%")) {
		unit_ = PERCENT;
		value_ = Float.parseFloat(
		    string.substring(0, string.length() - 1)
		);
	    } else {
		unit_ = UNKNOWN;
//		USmartDoc.warning("bad unit name : " + string);
	    }
	} catch (NumberFormatException e) {
	    USmartDoc.warning("bad length : " + string);
	}
    }

    public int getUnit() {
	return (unit_);
    }

    public float getValue() {
	return (value_);
    }

    public int getValueAsPixel() {
	switch (unit_) {

	case IN:
	    throw (new UnsupportedOperationException());
	case CM:
	    throw (new UnsupportedOperationException());
	case MM:
	    throw (new UnsupportedOperationException());
	case PT:
	    throw (new UnsupportedOperationException());
	case PC:
	    throw (new UnsupportedOperationException());
	case EM:
	    return ((int)(value_ * 10)); // XXX
	case EX:
	    return ((int)(value_ * 8)); // XXX
	case PX:
	    throw (new UnsupportedOperationException());
	case PERCENT:
	    throw (new IllegalArgumentException());
	case UNKNOWN:
	    throw (new IllegalArgumentException());
	default:
	    throw (new InternalError());
	}
    }

    public String getString() {
	return (string_);
    }

    // Object
    public String toString() {
	return (string_);
    }
}
