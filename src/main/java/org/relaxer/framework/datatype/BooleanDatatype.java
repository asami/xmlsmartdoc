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

import org.relaxer.runtime.URVerify;
import org.w3c.dom.Node;

/**
 * StringDatatype
 *
 * @since   Feb. 23, 2003
 * @version Feb. 23, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class BooleanDatatype extends AbstractDatatype {
    public BooleanDatatype() {
        super("boolean");
    }
    
    public Class getJavaClass() {
        return (Boolean.class);
    }

    public boolean isValid(String text) {
        return (URVerify.isValidInt(text, null) == null);
    }

    public boolean isValid(Node xml) {
        return (URVerify.isValidInt(getTextByXml(xml), null) == null);
    }

    public boolean isValid(Object object) {
        return (URVerify.isValidInt(object, null) == null);
    }

    public Object getObjectByText(String text) {
        return (Integer.valueOf(text));
    }
}
