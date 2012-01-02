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

import java.util.*;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.D2Array;

import org.xmlsmartdoc.SmartDoc.*;

/**
 * SpaceAdapter
 *
 * @since   Nov. 14, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 */
public class SpaceAdapter extends AbstractAdapter implements ITableAdapter {
    // AbstractAdapter
    protected Content[] _expand(
	String[] srcs,
	String param,
	Content content,
	Content[] contents,
	DocContext context
    ) {
	return (UDoc.table2Tr(getTable(srcs[0], param, context), content));
    }

    /**
     * @param query  adapter specific query
     */
    public SmartDocTableModel getTable(
	String src,
	String query,
	DocContext context
    ) {
	return (parseTable(USmartDoc.importText(src, context), query));
    }

    public SmartDocTableModel parseTable(String text, String query) {
	query = null;		// XXX
	D2Array data = new D2Array();
	String[] list = UString.makeStringListFromString(text);
	for (int y = 0;y < list.length;y++) {
	    StringTokenizer st = new StringTokenizer(list[y]);
	    int size = st.countTokens();
	    for (int x = 0;x < size;x++) {
		data.put(x, y, st.nextToken());
	    }
	}
	return (new SimpleSmartDocTableModel(data));
    }
}
