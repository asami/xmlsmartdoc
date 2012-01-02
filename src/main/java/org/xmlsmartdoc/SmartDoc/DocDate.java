/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
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
import org.w3c.dom.Element;
import com.AsamiOffice.text.UString;

/**
 * DocDate
 *
 * @since   Dec. 31, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class DocDate extends Content {
    protected Date date_ = null;
    protected String template_ = null;

    public DocDate() {
	date_ = new Date();	// current time
    }

    public DocDate(String text) {
	text_ = text;
    }

    public DocDate(Element element) {
	super(element);
	date_ = new Date();	// current time
	String template = UString.checkNull(element.getAttribute("template"));
	if (template != null) {
	    template_ = template;
	}
    }

    public int getEntityType() {
	return (ENTITY_INLINE);	// XXX
    }

    public String getText() {	// XXX : integrate normalization
	if (text_ == null && date_ == null) {
	    throw (new InternalError());
	}
	if (text_ != null) {
	    return (text_);
	}
	if (date_ != null) {
	    if (template_ == null) {
		return (date_.toString());
	    } else {
		if (false) {
		    // XXX : handle embedded date template
		    throw (new InternalError());
		} else {
		    return (template_ + date_.toString());
		}
	    }
	} else {
	    throw (new InternalError());
	}
    }
}
