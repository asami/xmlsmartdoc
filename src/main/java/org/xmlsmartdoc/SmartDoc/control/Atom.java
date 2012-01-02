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

package org.xmlsmartdoc.SmartDoc.control;

import java.util.*;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * Atom
 *
 * @since   May.  4, 1999
 * @version Aug.  7, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class Atom {
    protected String name_;
    protected Content[] value_;

    public Atom(String name) {
	name_ = name;
    }

    public String getName() {
	return (name_);
    }

    public Content[] getValue() {
	return (UDoc.cloneContents(value_));
    }

    public void setValue(Content[] value) {
	value_ = value;
    }

/*
    public Content[] macroExpand(DocContext context) {
	return (UDoc.cloneContents(value_));
    }

    public Content[] normalize(DocContext context) {
	throw (new UnsupportedOperationException());
    }

    public Content[] eval(DocContext context) {
	throw (new UnsupportedOperationException());
    }
*/
}
