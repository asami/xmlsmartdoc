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
 * ISmartDocVisitor
 *
 * @since   May. 24, 2000
 * @version Jan. 26, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public interface ISmartDocVisitor {
    boolean enter(Part part);
    boolean enter(Chapter chapter);
    boolean enter(Section section);
    boolean enter(SubSection subsection);
    boolean enter(SubSubSection subsubsection);
    boolean enter(Content content);
    void leave(Part part);
    void leave(Chapter chapter);
    void leave(Section section);
    void leave(SubSection subsection);
    void leave(SubSubSection subsubsection);
    void leave(Content content);
}
