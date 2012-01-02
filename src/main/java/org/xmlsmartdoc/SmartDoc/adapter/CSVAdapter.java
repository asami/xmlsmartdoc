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

package org.xmlsmartdoc.SmartDoc.adapter;

import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.DocContext;
import org.xmlsmartdoc.SmartDoc.TBody;
import org.xmlsmartdoc.SmartDoc.TFoot;
import org.xmlsmartdoc.SmartDoc.THead;
import org.xmlsmartdoc.SmartDoc.Table;
import org.xmlsmartdoc.SmartDoc.Tr;
import org.xmlsmartdoc.SmartDoc.UDoc;
import org.xmlsmartdoc.SmartDoc.USmartDoc;

import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.D2Array;

/**
 * CVSAdapter
 *
 * @since   Nov. 10, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 */
public class CSVAdapter extends AbstractAdapter {
    private static final int INIT = 0;
    private static final int TEXT = 1;
    private static final int DOUBLEQUOTE = 2;
    private static final int DOUBLEQUOTETEXT = 3;

    // AbstractAdapter
    protected Content[] _expand(
	String srcs[],
	String param,
	Content parent,
	Content[] contents,
	DocContext context
    ) {
	String encoding = parent.getEncoding();
	D2Array array = getTable(srcs[0], encoding, context);
	if (parent instanceof THead) {
	    return (UDoc.d2Array2TrTh(array));
	} else if (parent instanceof TFoot) {
	    return (UDoc.d2Array2TrTh(array));
	} else if (parent instanceof TBody) {
	    return (UDoc.d2Array2TrTd(array));
	} else if (parent instanceof Table) {
	    return (new Content[] { UDoc.d2Array2TBody(array) });
	} else if (parent instanceof Tr) {
	    return (UDoc.d2Array2Tds(array));
	} else {
	    return (new Content[] { UDoc.d2Array2Table(array) });
	}
    }

    public D2Array getTable(String src, String encoding, DocContext context) {
	if (encoding != null) {
	    return (parseTable(USmartDoc.importText(src, encoding, context)));
	} else {
	    return (parseTable(USmartDoc.importText(src, context)));
	}
    }

    public D2Array parseTable(String text) {
	D2Array data = new D2Array();
	String[] list = UString.makeStringListFromString(text);
	for (int y = 0;y < list.length;y++) {
	    int state = INIT;
	    int x = 0;
	    StringBuffer buffer = new StringBuffer();
	    char[] chars = list[y].toCharArray();
	    for (int i = 0;i < chars.length;i++) {
		char c = chars[i];
		switch (state) {

		case INIT:
		    switch (c) {

		    case ',':
			data.put(x++, y, "");
			break;
		    case '"':
			state = DOUBLEQUOTE;
			break;
		    default:
			buffer.append(c);
			state = TEXT;
		    }
		    break;
		case TEXT:
		    switch (c) {

		    case ',':
			data.put(x++, y, new String(buffer));
			buffer = new StringBuffer();
			state = INIT;
			break;
		    case '"':
			state = DOUBLEQUOTE;
			break;
		    default:
			buffer.append(c);
			state = TEXT;
		    }
		    break;
		case DOUBLEQUOTE:
		    switch (c) {

		    case ',':
			buffer.append(c);
			state = DOUBLEQUOTETEXT;
			break;
		    case '"':
			buffer.append("\"");
			state = TEXT;
			break;
		    default:
			buffer.append(c);
			state = DOUBLEQUOTETEXT;
		    }
		    break;
		case DOUBLEQUOTETEXT:
		    switch (c) {

		    case ',':
			buffer.append(c);
			state = DOUBLEQUOTETEXT;
			break;
		    case '"':
			state = TEXT;
			break;
		    default:
			buffer.append(c);
			state = DOUBLEQUOTETEXT;
		    }
		    break;
		default:
		    throw (new InternalError());
		}
	    }
	    data.put(x, y, new String(buffer));
	}
	return (data);
    }
}
