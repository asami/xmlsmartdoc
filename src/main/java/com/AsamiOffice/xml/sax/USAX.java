/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

package com.AsamiOffice.xml.sax;

import org.xml.sax.*;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.io.UFile;

/**
 * USAX
 *
 * @since   Apr. 30, 2000
 * @version Jun. 25, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public final class USAX {
    public static String getMessage(SAXException e) {
	if (e instanceof SAXParseException) {
	    return (getMessage((SAXParseException)e));
	} else {
	    return (e.getMessage());
	}
    }

    public static String getMessage(SAXParseException e) {
	String id = e.getSystemId();
	String name;
	if (id != null) {
	    name = UString.getLastComponent(id);
	} else {
	    name = "unknown";
	}
	int line = e.getLineNumber();
	int column = e.getColumnNumber();
	String message = e.getMessage();
	return (
	    name + ":" + line + ":" + column + " " + message
	);
    }

    public static String getEmacsMessage(SAXParseException e, String level) {
	String systemId = e.getSystemId();
	String name;
	if (systemId == null) {
	    name = "unknown";
	} else {
	    name = UFile.getRelativePathname(systemId);
	}
	int line = e.getLineNumber();
	int column = e.getColumnNumber();
	String message = e.getMessage();
	if (column > 0) {
	    return (
		name + ":" + line + ":" + column + " " + level + " " + message
	    );
	} else {
	    return (
		name + ":" + line + ":" + " " + level + " " + message
	    );
	}
    }
}
