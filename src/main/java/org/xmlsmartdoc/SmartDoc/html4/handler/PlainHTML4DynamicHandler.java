/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998,1999  ASAMI, Tomoharu (tasami@ibm.net)
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

package org.xmlsmartdoc.SmartDoc.html4.handler;

import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.html4.*;
import org.xmlsmartdoc.SmartDoc.xhtml.IXHTMLDynamicHandler;

/**
 * PlainHTML4DynamicHandler
 *
 * @since   Nov. 17, 1998
 * @version Jun. 17, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class PlainHTML4DynamicHandler implements IXHTMLDynamicHandler {
    public String getScriptType() {
	return (null);
    }

    public String getScript() {
	return (null);
    }

    public String getStyle(String key) {
	return (null);
    }

    public String getEvent(String key) {
	return (null);
    }

    public String getToggle() {
	return (null);
    }
}
