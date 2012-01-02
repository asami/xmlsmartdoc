/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.framework.datatype;

import org.relaxer.framework.parcel.IParcel;
import org.w3c.dom.Node;


/**
 * ParcelDatatype
 *
 * @since   Jan. 23, 2003
 * @version Jan. 23, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ParcelDatatype extends AbstractDatatype {
    public ParcelDatatype() {
        super("org.relaxer.framework.parcel.IParcel");
    }

    public Class getJavaClass() {
        return (IParcel.class);
    }

    public boolean isValid(String text) {
        return (true);
    }

    public boolean isValid(Node xml) {
        return (true);
    }

    public boolean isValid(Object object) {
        return (true);
    }
}
