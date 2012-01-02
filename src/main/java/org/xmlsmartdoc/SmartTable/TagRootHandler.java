/*
 * SmartTable
 *  Copyright (C) 1999-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartTable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.AsamiOffice.xml.UDOM;

/**
 * TagRootHandler
 *
 * @since   Aug.  5, 1999
 * @version Oct. 19, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class TagRootHandler implements IRootHandler {
    protected String path_;

    public TagRootHandler(Element element) {
	path_ = UDOM.getDataValue(element);
    }

    public Element find(Document doc) {
	return (UDOM.findElement(doc, path_));
    }

    public Element makeElement(Document doc) {
	return (doc.createElement(path_));
    }
}
