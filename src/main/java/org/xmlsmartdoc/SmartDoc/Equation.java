/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2001  ASAMI, Tomoharu (asami@zeomtech.com)
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

import java.util.*;
import org.w3c.dom.Element;

/**
 * Equation
 *
 * @since   Sep.  6, 2000
 * @version Mar. 12, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class Equation extends Container {
    public Equation(Element element) {
	super(element);
	if (sequenceNumber_ == null) {
	    sequenceNumber_ = new SequenceNumber("equation");
	}
    }

    // Content
    public int getEntityType() {
	return (ENTITY_BLOCK);
    }
}
