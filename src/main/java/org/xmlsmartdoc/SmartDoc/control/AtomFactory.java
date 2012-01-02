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
import org.w3c.dom.*;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * AtomFactory
 *
 * @since   May.  4, 1999
 * @version Aug.  7, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class AtomFactory {
    protected Map atoms_ = new HashMap(); // Map<String, Atom>

    public void put(Atom atom) {
	atoms_.put(atom.getName(), atom);
    }

    public Atom create(String name) {
	Atom atom = (Atom)atoms_.get(name);
	if (atom == null) {
	    atom = new Atom(name);
	    atoms_.put(name, atom);
	}
	return (atom);
    }

    public Atom get(String name) {
	return ((Atom)atoms_.get(name));
    }
}
