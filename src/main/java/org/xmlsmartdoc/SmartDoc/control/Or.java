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
 * Or
 *
 * @since   Nov. 14, 1998
 * @version Aug.  7, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class Or extends Container {
    public Or(Element element) {
	super(element);
    }

    // Content
    public int getEntityType() {
	return (ENTITY_CONTROL);
    }

    // Container
    public Content[] eval(DocContext context) {
/*
	if (super.eval(context) == null) {
	    return (null);
	}
*/
	int size = contents_.size();
	for (int i = 0;i < size;i++) {
	    Content arg = (Content)contents_.get(i);
	    Content[] result = arg.eval(context);
	    if (result != null) {
		return (result);
	    }
	}
	return (null);
    }
}
