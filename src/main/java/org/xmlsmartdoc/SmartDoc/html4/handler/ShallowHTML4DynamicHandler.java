/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import java.io.IOException;

import org.xmlsmartdoc.SmartDoc.xhtml.IXHTMLDynamicHandler;

import com.AsamiOffice.text.UString;

/**
 * ShallowHTML4DynamicHandler
 *
 * @since   Nov. 17, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class ShallowHTML4DynamicHandler implements IXHTMLDynamicHandler {
    public String getScriptType() {
        return ("JavaScript");
    }

    public String getScript() {
        String script = null;
        try {
            script = UString.makeStringFromResource(
                "/org/xmlsmartdoc/SmartDoc/html4/lib/HTML4JavaScript.js",
                this
            );
        } catch (IOException e) {
            e.printStackTrace(); // XXX
        }
        return (script);
    }

    public String getStyle(String key) {
        return (null);
    }

    public String getEvent(String key) {
        String event = null;
        if ("link".equals(key)) {
            event = "onmouseover=\"hilight(this)\" onmouseout=\"normal(this)\"";
        } else if ("selflink".equals(key)) {
            event = "onmouseover=\"hilightSelflink(this)\" onmouseout=\"normal(this)\"";
        } else if ("hyperlink".equals(key)) {
            event = "onmouseover=\"hilightHyperlink(this)\" onmouseout=\"normal(this)\"";
        } else if ("externallink".equals(key)) {
            event = "onmouseover=\"hilightExternallink(this)\" onmouseout=\"normal(this)\"";
        }
        return (event);
    }

    public String getToggle() {
        return (null);
    }
}
