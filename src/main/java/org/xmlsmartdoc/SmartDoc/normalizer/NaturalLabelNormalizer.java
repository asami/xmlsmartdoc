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

package org.xmlsmartdoc.SmartDoc.normalizer;

import java.util.*;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * NaturalNormalizer
 *
 * @since   May. 28, 1999
 * @version Jun. 22, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class NaturalLabelNormalizer extends NaturalNormalizer {
    protected Content[] _normalize(
	Content[] contents,
	Content parent,
	DocContext context
    ) {
	contents = super._normalize(contents, parent, context);
	Paragraph p = null;
	for (int i = 0;i < contents.length;i++) {
	    Content child = contents[i];
	    if (child instanceof Paragraph) {
		if (p != null) {
		    return (contents);
		}
		p = (Paragraph)child;
	    }
	}
	if (p == null) {
	    return (contents);
	}
	// p is only Paragraph in contents
	List list = new ArrayList();
	Content[] children = p.getContents();
	for (int i = 0;i < children.length;i++) {
	    list.add(children[i]);
	}
	for (int i = 0;i < contents.length;i++) {
	    Content child = contents[i];
	    if (child == p) {
		continue;
	    }
	    list.add(child);
	}
	Content[] result = new Content[list.size()];
	return ((Content[])list.toArray(result));
    }
}
