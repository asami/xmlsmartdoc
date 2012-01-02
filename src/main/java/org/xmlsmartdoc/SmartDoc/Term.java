/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
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

import org.w3c.dom.*;
import com.AsamiOffice.text.UString;

/**
 * Span
 *
 * @since   Apr.  7, 2000
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 */
public class Term extends Container {
    protected String ruby_;	// XXX : temp

    public Term() {
    }

    public Term(Element element) {
	super(element);
	ruby_ = UString.checkNull(element.getAttribute("ruby"));
    }

    // Content
    public int getEntityType() {
	return (ENTITY_INLINE);
    }

    public String getRuby() {
	return (ruby_);
    }
}
