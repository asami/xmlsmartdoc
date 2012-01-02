/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2000  ASAMI, Tomoharu (tasami@ibm.net)
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
import java.io.*;
import org.w3c.dom.*;
import com.AsamiOffice.jaba2.text.UString;
import com.AsamiOffice.util.D2Array;

import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartTable.SmartTable;

/**
 * SmartTableAdapter
 *
 * @since   Aug.  1, 1999
 * @version Jan. 18, 2000
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class SmartTableAdapter extends AbstractAdapter {
    // AbstractAdapter
    protected Content[] _expand(
	String srcs[],
	String param,
	Content content,
	Content[] contents,
	DocContext context
    ) {
	String args = srcs[0];
	if (param != null) {
	    args = param + " " + args;
	}
	try {
	    SmartTable sxtab = new SmartTable(args);
	    Document doc = sxtab.getHTMLTableAsDocument();
	    SmartDocModel model = SmartDocContext.getContext().getModel();
	    Content[] subdoc = model.buildSubDoc(doc, context);
	    Table table = (Table)subdoc[0]; // XXX
	    if (content instanceof Table) {
		table.format();
		return (table.getContents());
	    } else if (content instanceof TBody) {
		table.format();
		return (table.getTBody().getContents());
	    } else {
		throw (new SmartDocWarningException("bad content"));
	    }
	} catch (IOException e) {
	    throw (new SmartDocWarningException(e));
	}
    }

/*
    // AbstractAdapter
    protected Content[] _expand(
	String srcs[],
	String param,
	Content content,
	Content[] contents,
	DocContext context
    ) {
	String args = srcs[0];
	if (param != null) {
	    args = param + " " + args;
	}
	try {
	    SXTable sxtab = new SXTable(args);
	    D2Array data = sxtab.getDataAsD2Array();
	    if (content instanceof Table) {
		D2Array head = sxtab.getHeadAsD2Array();
		D2Array foot = sxtab.getFootAsD2Array();
		List list = new ArrayList();
		if (head != null) {
		    list.add(UDoc.d2Array2THead(head));
		}
		if (foot != null) {
		    list.add(UDoc.d2Array2TFoot(foot));
		}
		list.add(UDoc.d2Array2TBody(data));
		return (UDoc.list2Contents(list));
	    } else {		// tbody
		return (UDoc.d2Array2Tr(data, content));
	    }
	} catch (IOException e) {
	    throw (new SmartDocWarningException(e));
	}
    }
*/
}
