/*
 * SmartTable
 *  Copyright (C) 1999-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.util.UList;
import com.AsamiOffice.jaba2.xml.IConverter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.AsamiOffice.xml.UDOM;

/**
 * TagColumnHandler
 *
 * @since   Jul. 28, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class TagColumnHandler implements IColumnHandler {
    protected String path_;
    protected String type_; // no or any
    protected int columnNo_ = -1; // N/A
    protected IConverter converter_;

    public TagColumnHandler(Element element, int x) {
        path_ = UDOM.getDataValue(element);
        String columnNoAttr = element.getAttribute("columnNo");
        if (UString.isNull(columnNoAttr)) {
            type_ = "no";
            columnNo_ = x;
        } else if (columnNoAttr.equals("any")) {
            type_ = "any";
        } else {
            try {
                columnNo_ = Integer.parseInt(columnNoAttr) - 1;
                type_ = "no";
            } catch (NumberFormatException e) {
                type_ = null;
            }
        }
        String converter = element.getAttribute("converter");
        if (UString.isNull(converter)) {
            converter = "text";
        }
        SmartTableModel model = SmartTableContext.getContext().getModel();
        converter_ = model.getConverter(converter);
    }

    /**
     * @deprecated
     */
    public String getTagName() {
        return (path_); // XXX
    }

    /**
     * @deprecated
     */
    public String getType() {
        return (type_);
    }

    public String getColumnName() {
        return (path_); // XXX
    }

    public int getColumnNumber() {
        return (columnNo_);
    }

    public void find(Element element, List list) {
        Element data = UDOM.findElement(element, path_);
        String text = converter_.nodes2String(data).trim();
        if ("any".equals(type_)) {
            USmartTable.addList(list, text);
        } else {
            UList.put(list, columnNo_, text);
        }
    }

    /**
     * @deprecated
     */
    public boolean match(Element element) {
        return (path_.equals(element.getTagName()));
    }

    public boolean match(int x) {
        if ("any".equals(type_)) {
            return (true);
        }
        return (x == columnNo_);
    }

    /*
        public Element makeElement(Document doc) {
    	return (doc.createElement(path_));
        }
    */

    public Element makeElement(Document doc, String text) {
        Element element = doc.createElement(path_);
        Node[] nodes = converter_.string2Nodes(doc, text);
        for (int i = 0; i < nodes.length; i++) {
            element.appendChild(nodes[i]);
        }
        return (element);
    }

    public Node[] makeData(Document doc, String text) {
        return (converter_.string2Nodes(doc, text));
    }
}
