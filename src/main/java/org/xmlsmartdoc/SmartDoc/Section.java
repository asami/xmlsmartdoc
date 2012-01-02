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

import java.util.*;
import org.w3c.dom.*;

/**
 * Section
 *
 * @since   Sep. 19, 1998
 * @version Feb.  2, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class Section extends TitledBlock {
    public Section() {
    }

    public Section(Element element) {
	super(element);
    }

    public int getEntityType() {
	return (ENTITY_BLOCK);
    }

    public boolean enter(ISmartDocVisitor visitor) {
	visitor.enter(this);
	return (true);
    }

    public void leave(ISmartDocVisitor visitor) {
	visitor.leave(this);
    }
}
