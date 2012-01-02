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

import com.AsamiOffice.text.UString;

/**
 * CharBlock
 *
 * @since   Sep. 20, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class CharBlock extends Content {
    private boolean preserve_ = false;

    public CharBlock(char c) {
	text_ = new String(new char[] { c });
    }

    public CharBlock(String text) {
	text_ = text;
    }

    // Content
    public int getEntityType() {
	return (ENTITY_INLINE);
    }

    // Content
    public Content[] normalize(DocContext context) {
	text_ = UString.makeCanonicalString(text_);
	return (new Content[] {this});
    }

    // Content
    public char getFirstChar() {
	if (text_ == null) {
	    return (0);
	}
	if (text_.length() == 0) {
	    return (0);
	}
	return (text_.charAt(0));
    }

    // Content
    public char getLastChar() {
	if (text_ == null) {
	    return (0);
	}
	int length = text_.length();
	if (length == 0) {
	    return (0);
	}
	return (text_.charAt(length - 1));
    }

    public String getText() {
	return (text_);
    }

    public boolean isPreserve() {
	return (preserve_);
    }

    public void setPreserve(boolean preserve) {
	preserve_ = preserve;
    }
}
