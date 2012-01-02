/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998  ASAMI, Tomoharu (tasami@ibm.net)
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

import com.AsamiOffice.jaba2.j2fw.J2Exception;

/**
 * SmartDocRuntimeException
 *
 * @since   Nov.  2, 1998
 * @version Jul. 27, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class SmartDocRuntimeException extends J2Exception {
    public SmartDocRuntimeException(Exception e) {
	super(e);
    }

    public SmartDocRuntimeException(String message) {
	super(message);
    }
}
