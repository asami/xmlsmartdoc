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

package org.xmlsmartdoc.SmartDoc;

/**
 * SmartDocVisitorBase
 *
 * @since   May. 24, 2000
 * @version Jan. 26, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SmartDocVisitorBase implements ISmartDocVisitor {
    public boolean enter(Part part) {
	return (true);
    }

    public boolean enter(Chapter chapter) {
	return (true);
    }

    public boolean enter(Section section) {
	return (true);
    }

    public boolean enter(SubSection subsection) {
	return (true);
    }

    public boolean enter(SubSubSection subsubsection) {
	return (true);
    }

    public boolean enter(Content content) {
	return (true);
    }

    public void leave(Part part) {
    }

    public void leave(Chapter chapter) {
    }

    public void leave(Section section) {
    }

    public void leave(SubSection subsection) {
    }

    public void leave(SubSubSection subsubsection) {
    }

    public void leave(Content content) {
    }
}
