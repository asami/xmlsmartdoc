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
import com.AsamiOffice.util.UArray;

import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.adapter.CSVAdapter;

/**
 * CSVNormalizer
 *
 * @since   Jun. 30, 2001
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 */
public class CSVNormalizer extends AbstractNormalizer {
    protected Content[] _normalize(
        Content[] contents,
        Content parent,
        DocContext context) {
        List list = new ArrayList();
        for (int i = 0; i < contents.length; i++) {
            Content content = contents[i];
            if (content instanceof Tr || content instanceof Ul) {
                list.add(content);
            }
        }
        if (parent instanceof THead) {
            return (makeTrTh(contents, list));
        } else if (parent instanceof TFoot) {
            return (makeTrTh(contents, list));
        } else if (parent instanceof TBody) {
            return (makeTrTd(contents, list));
        } else if (parent instanceof Table) {
            return (makeTBody(contents, list));
        } else if (parent instanceof Tr) {
            return (makeThTd(parent, contents, list));
        } else {
            return (makeTable(contents, list));
        }
    }

    public static Content[] makeTable(Content[] contents, List list) {
        Table table = new Table();
        table.addContents(makeTBody(contents, list));
        return (new Content[] { table });
    }

    public static Content[] makeTBody(Content[] contents, List list) {
        Content[] trs = makeTrTd(contents, list);
        TBody tbody = new TBody();
        tbody.addContents(trs);
        return (new Content[] { tbody });
    }

    public static Content[] makeTrTh(Content[] contents, List list) {
        String text = UDoc.makeInlineText(contents);
        if (!UString.isEmpty(text)) {
            CSVAdapter csvTable = new CSVAdapter();
            Content[] distilled = UDoc.d2Array2TrTh(csvTable.parseTable(text));
            UArray.addAll(list, distilled);
        }
        Content[] result = new Content[list.size()];
        return ((Content[])list.toArray(result));
    }

    public static Content[] makeTrTd(Content[] contents, List list) {
        String text = UDoc.makeInlineText(contents);
        if (!UString.isEmpty(text)) {
            CSVAdapter csvTable = new CSVAdapter();
            Content[] distilled = UDoc.d2Array2TrTd(csvTable.parseTable(text));
            UArray.addAll(list, distilled);
        }
        Content[] result = new Content[list.size()];
        return ((Content[])list.toArray(result));
    }

    public static Content[] makeThTd(
        Content parent,
        Content[] contents,
        List list) {
        String text = UDoc.makeInlineText(contents);
        String[] data = UString.makeStringListFromCSVLine(text.trim());
        if (UDoc.isAncestor(parent, THead.class)
            || UDoc.isAncestor(parent, TFoot.class)) {

            for (int i = 0; i < data.length; i++) {
                list.add(new Th(data[i]));
            }
        } else if (
            UDoc.isAncestor(parent, Table.class)
                || UDoc.isAncestor(parent, TBody.class)) {

            for (int i = 0; i < data.length; i++) {
                list.add(new Td(data[i]));
            }
        } else {
            throw (new InternalError());
        }
        Content[] result = new Content[list.size()];
        return ((Content[])list.toArray(result));
    }
}
