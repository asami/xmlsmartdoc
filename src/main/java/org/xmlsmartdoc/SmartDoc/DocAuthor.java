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

import org.w3c.dom.Element;
import com.AsamiOffice.text.UString;

/**
 * DocAuthor
 *
 * @since   May. 24, 2001
 * @version Jan. 24, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class DocAuthor extends Container {
    private String email_;
    private String hp_;
    private String org_;

    public DocAuthor() {
    }

    public DocAuthor(Element element) {
	super(element);
	email_ = UString.checkNull(element.getAttribute("email"));
	hp_ = UString.checkNull(element.getAttribute("hp"));
	org_ = UString.checkNull(element.getAttribute("org"));
    }

    public int getEntityType() {
	return (ENTITY_CONTAINER);
    }

    public final String getEMail() {
	return (email_);
    }

    public final String getHP() {
	return (hp_);
    }

    public final String getOrg() {
	return (org_);
    }
}
