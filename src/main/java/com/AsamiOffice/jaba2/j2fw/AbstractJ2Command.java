/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1999  ASAMI, Tomoharu (tasami@ibm.net)
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

package com.AsamiOffice.jaba2.j2fw;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * AbstractJ2Command
 *
 * @since   Dec.  9, 1998
 * @version May. 17, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public abstract class AbstractJ2Command extends AbstractAction
    implements J2Command {

    protected AbstractJ2Command(String name) {
	putValue(NAME, name);
    }

    public String getName() {
	if (true) {		// XXX : show config
	    return ((String)getValue(NAME));
	}
	return (null);
    }

    public String getID() {
	return ((String)getValue(ID));
    }

    public void actionPerformed(ActionEvent evt) {
	doAction();
    }
}
