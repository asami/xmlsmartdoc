/*
 * SmartTable
 *  Copyright (C) 1999-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.AsamiOffice.jaba2.xml.IProcessor;
import com.AsamiOffice.jaba2.xml.ProcessorFactory;
import com.AsamiOffice.jaba2.xml.pdom.PDOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.AsamiOffice.util.D2Array;
import com.AsamiOffice.xml.UElement;

/**
 * Metadata
 *
 * @since   Jul. 28, 1999
 * @version Oct. 19, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class Metadata {
    protected IRootHandler rootHandler_;
    protected IRecordHandler recordHandler_;
    protected IColumnHandler[] columnHandlers_;
    protected Properties properties_ = new Properties();

    public Metadata() {
	rootHandler_ = new DefaultRootHandler();
	recordHandler_ = new DefaultRecordHandler();
	columnHandlers_ = new IColumnHandler[] { new DefaultColumnHandler() };
    }

    public Metadata(URL file) throws IOException {
	IProcessor processor = ProcessorFactory.getProcessor();
	Document doc = processor.parseDocument(file);
	List columns = new ArrayList();
	Element root = doc.getDocumentElement();
	NodeList nodes = root.getChildNodes();
	int size = nodes.getLength();
	int x = 0;
	for (int i = 0;i < size;i++) {
	    Node node = nodes.item(i);
	    switch (node.getNodeType()) {

	    case Node.ELEMENT_NODE:
		Element element = (Element)node;
		String tagname = element.getTagName();
		if ("root".equals(tagname)) {
		    rootHandler_ = new TagRootHandler(element);
		} else if ("record".equals(tagname)) {
		    recordHandler_ = new TagRecordHandler(element);
		} else if ("column".equals(tagname)) {
		    columns.add(new TagColumnHandler(element, x++));
		} else if ("properties".equals(tagname)) {
		    Element[] items = UElement.getElements(element);
		    for (int j = 0;j < items.length;j++) {
			Element item = items[j];
			properties_.put(
			    item.getAttribute("name"),
			    item.getAttribute("value")
			);
		    }
		} else {
		    throw (new IllegalArgumentException());
		}
		break;
	    }
	}
	columnHandlers_ = new TagColumnHandler[columns.size()];
	columns.toArray(columnHandlers_);
    }

    public IRootHandler getRootHandler() {
	return (rootHandler_);
    }

    public IRecordHandler getRecordHandler() {
	return (recordHandler_);
    }

    public IColumnHandler[] getColumnHandlers() {
	return (columnHandlers_);
    }

    public D2Array xml2D2Array(URL source) throws IOException {
	IProcessor processor = ProcessorFactory.getProcessor();
	Document doc = processor.parseDocument(source);
	Element root;
	if (rootHandler_ != null) {
	    root = rootHandler_.find(doc);
	    if (root == null) {
		throw (new InternalError()); // XXX
	    }
	} else {
	    root = doc.getDocumentElement();
	}
	Element[] records = recordHandler_.select(root);
	D2Array d2 = new D2Array();
	for (int y = 0;y < records.length;y++) {
	    Element record = records[y];
	    List list = new ArrayList();
	    for (int i = 0;i < columnHandlers_.length;i++) {
		IColumnHandler columnHandler = columnHandlers_[i];
		columnHandler.find(record, list);
	    }
	    int size = list.size();
	    for (int x = 0;x < size;x++) {
		String data = list.get(x).toString();
		d2.put(x, y, data.trim());
	    }
	}
	return (d2);
    }

    public Document d2Array2XML(D2Array d2) {
	Document doc = new PDOM().createDocument("XML");
	int width = d2.getWidth();
	int height = d2.getHeight();
	Node root;
	if (rootHandler_ != null) {
	    root = rootHandler_.makeElement(doc);
	} else {
	    root = doc;
	}
	for (int y = 0;y < height;y++) {
	    Element record = recordHandler_.makeElement(doc);
	    for (int x = 0;x < width;x++) {
		Object cell = d2.get(x, y);
		String data;
		if (cell == null) {
		    data = "";
		} else {
		    data = cell.toString();
		}
		for (int i = 0;i < columnHandlers_.length;i++) {
		    if (columnHandlers_[i].match(x)) {
			Element column
			    = columnHandlers_[i].makeElement(doc, data);
			record.appendChild(column);
			break;
		    }
		}
	    }
	    root.appendChild(record);
	}
	if (rootHandler_ != null) {
	    doc.appendChild(root);
	}
	return (doc);
    }

    public Document d2Array2HTMLTable(D2Array d2) {
	Document doc = new PDOM().createDocument("XML");
	Element table = doc.createElement("table");
	D2Array headd2 = getHeadAsD2Array();
	if (headd2 != null) {
	    int width = headd2.getWidth();
	    int height = headd2.getHeight();
	    Element thead = doc.createElement("thead");
	    for (int y = 0;y < height;y++) {
		Element tr = doc.createElement("tr");
		for (int x = 0;x < width;x++) {
		    Element td = doc.createElement("th");
		    Object data = headd2.get(x, y);
		    if (data == null) {
			data = "";
		    };
		    Text text = doc.createTextNode(data.toString());
		    td.appendChild(text);
		    tr.appendChild(td);
		}
		thead.appendChild(tr);
	    }
	    table.appendChild(thead);
	}
	int width = d2.getWidth();
	int height = d2.getHeight();
	Element tbody = doc.createElement("tbody");
	for (int y = 0;y < height;y++) {
	    Element tr = doc.createElement("tr");
	    for (int x = 0;x < width;x++) {
		Object cell = d2.get(x, y);
		String data;
		if (cell == null) {
		    data = "";
		} else {
		    data = cell.toString();
		}
		Element td = doc.createElement("td");
		for (int i = 0;i < columnHandlers_.length;i++) {
		    if (columnHandlers_[i].match(x)) {
			Node[] column
			    = columnHandlers_[i].makeData(doc, data);
			for (int j = 0;j < column.length;j++) {
			    td.appendChild(column[j]);
			}
			break;
		    }
		}
		tr.appendChild(td);
	    }
	    tbody.appendChild(tr);
	}
	table.appendChild(tbody);
	doc.appendChild(table);
	return (doc);
    }

    protected D2Array getHeadAsD2Array() {
	D2Array head = new D2Array();
/*
	if (data_.getWidth() != columns.length) {
	    return (null);
	}
*/
	for (int x = 0;x < columnHandlers_.length;x++) {
	    IColumnHandler column = columnHandlers_[x];
	    int number = column.getColumnNumber();
	    if (number == -1) {
		return (null);
	    }
	    String name = column.getColumnName();
	    if (name == null) {
		return (null);
	    }
	    head.put(x, 0, name);
	}
	return (head);
    }

    protected String[] getColumnNames() {
	String[] names = new String[columnHandlers_.length];
	for (int x = 0;x < columnHandlers_.length;x++) {
	    IColumnHandler column = columnHandlers_[x];
	    int number = column.getColumnNumber();
	    if (number == -1) {
		return (null);
	    }
	    String name = column.getColumnName();
	    if (name == null) {
		return (null);
	    }
	    names[x] = name;
	}
	return (names);
    }

    protected String getProperty(String key) {
	return ((String)properties_.get(key));
    }
}
