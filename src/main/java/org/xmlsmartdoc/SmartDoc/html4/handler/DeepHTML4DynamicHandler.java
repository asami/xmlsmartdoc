/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2002  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import java.io.*;
import com.AsamiOffice.jaba2.text.UString;
import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.html4.*;

/**
 * DeepHTML4DynamicHandler
 *
 * @since   Nov. 17, 1998
 * @version May.  8, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class DeepHTML4DynamicHandler extends ShallowHTML4DynamicHandler {
    public String getStyle(String key) {
	String style = null;
	if ("hide".equals(key)) {
	    style = "display:none";
	}
	if (style != null) {
	    return (style);
	} else {
	    return (super.getStyle(key));
	}
    }

    public String getEvent(String key) {
	String event = null;
	if ("body".equals(key)) { // XXX : need?
	    event = "onClick=\"adjustView()\"";
	} else if ("expandshow".equals(key)) {
	    event = "";
	} else if ("expandhide".equals(key)) {
	    event = "class=\"dynamic\" style=\"display:none\"";
	}
	if (event != null) {
	    return (event);
	} else {
	    return (super.getEvent(key));
	}
    }

    public String getToggle() {
	return ("<span class=\"toggle\" onmousedown=\"toggleDynamic(this.parentElement)\" onmouseover=\"hilightString(this, 'red')\" onmouseout=\"normal(this)\">&gt;&gt;</span>");
    }
}
