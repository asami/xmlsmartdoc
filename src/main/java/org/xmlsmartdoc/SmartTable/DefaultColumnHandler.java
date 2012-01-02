/*
 * SmartTable
 *  Copyright (C) 1999-2003  ASAMI, Tomoharu (asami@XMLSmartdoc.org)
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

package org.xmlsmartdoc.SmartTable;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.AsamiOffice.xml.UDOM;
import com.AsamiOffice.xml.UElement;

/**
 * DefaultColumnHandler
 *
 * @since   Aug.  5, 1999
 * @version Oct. 19, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class DefaultColumnHandler implements IColumnHandler {
    public void find(Element record, List list) {
        Element[] columns = UElement.getElements(record);
        for (int i = 0; i < columns.length; i++) {
            String text = UDOM.getDataValue(columns[i]);
            USmartTable.addList(list, text);
        }
    }

    public String getColumnName() {
        return (null);
    }

    public int getColumnNumber() {
        return (-1);
    }

    public boolean match(int x) {
        return (true);
    }

    /*
        public Element makeElement(Document doc) {
    	return (doc.createElement("td"));
        }
    */

    public Element makeElement(Document doc, String text) {
        Element element = doc.createElement("td");
        element.appendChild(doc.createTextNode(text));
        return (element);
    }

    public Node[] makeData(Document doc, String text) {
        return (new Node[] { doc.createTextNode(text)});
    }
}
