/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
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

package org.xmlsmartdoc.SmartDoc.normalizer;

import java.util.*;
import com.AsamiOffice.text.UString;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * CSVTrNormalizer
 *
 * @since   Mar. 31, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 */
public class CSVTrNormalizer extends AbstractNormalizer {
    protected Content[] _normalize(
	Content[] contents,
	Content parent,
	DocContext context
    ) {
	List list = new ArrayList();
	for (int i = 0;i < contents.length;i++) {
	    Content child = contents[i];
	    if (child instanceof Td ||
		child instanceof Th) {

		list.add(child);
	    }
	}
	String text = UDoc.makeInlineText(contents);
	String[] data = UString.makeStringListFromCSVLine(text.trim());
	if (UDoc.isAncestor(parent, THead.class) ||
	    UDoc.isAncestor(parent, TFoot.class)) {

	    for (int i = 0;i < data.length;i++) {
		list.add(new Th(data[i]));
	    }
	} else if (UDoc.isAncestor(parent, Table.class) ||
		   UDoc.isAncestor(parent, TBody.class)) {

	    for (int i = 0;i < data.length;i++) {
		list.add(new Td(data[i]));
	    }
	} else {
	    throw (new InternalError());
	}
	Content[] result = new Content[list.size()];
	return ((Content[])list.toArray(result));
    }
}
