/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import java.io.*;

/**
 * SmartDocResource_ja
 *
 * @since   Aug. 15, 1999
 * @version Oct. 22, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SmartDocResource_ja extends AbstractSmartDocResource {
    public SmartDocResource_ja() throws IOException {
	super(
	    "/org/xmlsmartdoc/SmartDoc/SmartDocDefaults_ja.properties",
	    "/org/xmlsmartdoc/SmartDoc/messages_ja"
	);
    }

    public String[] getLabelParts(String key) {
	String[] parts = new String[2];
	if ("part".equals(key) ||
	    "chapter".equals(key) ||
	    "section".equals(key)) {

	    parts[0] = null;
	    parts[1] = getLabel(key);
	} else {    
	    parts[0] = getLabel(key);
	    parts[1] = null;
	}
	return (parts);
    }

    public String getYearLabel(int year) {
	return (year + "\u5e74"); // îN
    }

    public String getMonthLabel(int month) {
	return (month + "\u6708\u53f7"); // åéçÜ
    }

    public String getEditionLabel(int edition) {
	return ("\u7b2c" + edition + "\u7248"); // ëÊ/î≈
    }

    public String getEditorLabel() {
	return ("(\u7de8)"); // ï“
    }

    public String getEditorsLabel() {
	return (getEditorLabel());
    }
}
