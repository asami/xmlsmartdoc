/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998,1999  ASAMI, Tomoharu (tasami@ibm.net)
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

package org.xmlsmartdoc.SmartDoc.latex2e;

/**
 * LaTeX2ePackage
 *
 * @since   Jan. 31, 1998
 *  version Jan. 31, 1999
 * @version Jan. 19, 2012
 * @author  ASAMI, Tomoharu (asami@xmlsmartdoc.org)
 */
public class LaTeX2ePackage {
    public String name;
    public String[] options;
    public String aux;

    public LaTeX2ePackage(String name) {
        this.name = name;
    }

    public LaTeX2ePackage(String name, String[] options) {
        this.name = name;
        this.options = options;
    }

    public LaTeX2ePackage(String name, String[] options, String aux) {
        this.name = name;
        this.options = options;
        this.aux = aux;
    }
}
