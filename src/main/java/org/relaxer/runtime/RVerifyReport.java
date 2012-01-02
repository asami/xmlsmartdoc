/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2002  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.runtime;

import java.util.*;

/**
 * RVerifyReport
 *
 * @since   Aug. 26, 2001
 * @version Dec. 27, 2002
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RVerifyReport implements IRVerifyConstants {
    private RVerifyReport parent_;
    private List children_ = new ArrayList();
    private String context_ = "/";
    private List items_ = new ArrayList();

    public RVerifyReport newContext(String context) {
	RVerifyReport newReport = new RVerifyReport();
	newReport.parent_ = this;
	if (context_.equals("/")) {
	    newReport.context_ = "/" + context;
	} else {
	    newReport.context_ = context_ + "/" + context;
	}
	children_.add(newReport);
	return (newReport);
    }

    public boolean isValid() {
	if (items_.size() > 0) {
	    return (false);
	}
	int size = children_.size();
	for (int i = 0;i < size;i++) {
	    RVerifyReport child = (RVerifyReport)children_.get(i);
	    if (!child.isValid()) {
		return (false);
	    }
	}
	return (true);
    }

    public void addError(
	String path,
	String status,
	Object value,
	String type,
	String message
    ) {
	items_.add(new Item(context_, path, status, value, type, message));
    }

    public void addError(
	String path,
	String status,
	boolean value,
	String type,
	String message
    ) {
	addError(path, status, new Boolean(value), type, message);
    }

    public void addError(
	String path,
	String status,
	byte value,
	String type,
	String message
    ) {
	addError(path, status, new Byte(value), type, message);
    }

    public void addError(
	String path,
	String status,
	short value,
	String type,
	String message
    ) {
	addError(path, status, new Short(value), type, message);
    }

    public void addError(
	String path,
	String status,
	int value,
	String type,
	String message
    ) {
	addError(path, status, new Integer(value), type, message);
    }

    public void addError(
	String path,
	String status,
	long value,
	String type,
	String message
    ) {
	addError(path, status, new Long(value), type, message);
    }

    public void addError(
	String path,
	String status,
	float value,
	String type,
	String message
    ) {
	addError(path, status, new Float(value), type, message);
    }

    public void addError(
	String path,
	String status,
	double value,
	String type,
	String message
    ) {
	addError(path, status, new Double(value), type, message);
    }

    public void addError(
	String path,
	int index,
	String status,
	Object value,
	String type,
	String message
    ) {
	if (index == -1) {
	    items_.add(
		new Item(context_, path, status, value, type, message)
	    );
	} else {
	    items_.add(
		new Item(context_, path, index, status, value, type, message)
	    );
	}
    }

    public void addError(
	String path,
	int index,
	String status,
	boolean value,
	String type,
	String message
    ) {
	addError(path, index, status, new Boolean(value), type, message);
    }

    public void addError(
	String path,
	int index,
	String status,
	byte value,
	String type,
	String message
    ) {
	addError(path, index, status, new Byte(value), type, message);
    }

    public void addError(
	String path,
	int index,
	String status,
	short value,
	String type,
	String message
    ) {
	addError(path, index, status, new Short(value), type, message);
    }

    public void addError(
	String path,
	int index,
	String status,
	int value,
	String type,
	String message
    ) {
	addError(path, index, status, new Integer(value), type, message);
    }

    public void addError(
	String path,
	int index,
	String status,
	long value,
	String type,
	String message
    ) {
	addError(path, index, status, new Long(value), type, message);
    }

    public void addError(
	String path,
	int index,
	String status,
	float value,
	String type,
	String message
    ) {
	addError(path, index, status, new Float(value), type, message);
    }

    public void addError(
	String path,
	int index,
	String status,
	double value,
	String type,
	String message
    ) {
	addError(path, index, status, new Double(value), type, message);
    }

    public void addError(RVerifyReport report) {
	Item[] items = report.getItems();
	for (int i = 0;i < items.length;i++) {
	    items_.add(items[i]);
	}
    }

    public Item[] getItems() {
	List list = new ArrayList();
	_getItems(list);
	Item[] items = new Item[list.size()];
	return ((Item[])list.toArray(items));
    }

    protected final void _getItems(List list) {
	list.addAll(items_);
	int size = children_.size();
	for (int i = 0;i < size;i++) {
	    RVerifyReport child = (RVerifyReport)children_.get(i);
	    child._getItems(list);
	}
    }

    // Object
    public String toString() {
	return (URVerifyReport.getMessage(this));
    }
/*
    // Object
    public String toString() {
	StringBuffer buffer = new StringBuffer();
	List list = new ArrayList();
	_getItems(list);
	int size = list.size();
	for (int i = 0;i < size;i++) {
	    Item item = (Item)list.get(i);
	    buffer.append(item.toString());
	    buffer.append("\n");
	}
	return (new String(buffer));
    }
*/

    public static class Item {
	public String path;
	public String parent;
	public String leaf;
	public int index;
	public String status;
	public Object value;
	public String type;
	public String message;

	public Item(
	    String parent,
	    String leaf,
	    String status,
	    Object value,
	    String type,
	    String message
	) {
	    this(parent, leaf, -1, status, value, type, message);
	}

	public Item(
	    String parent,
	    String leaf,
	    int index,
	    String status,
	    Object value,
	    String type,
	    String message
	) {
	    if (index == -1) {	// -1 means N/A
		if (leaf != null) {
		    this.path = parent + "/" + leaf;
		} else {
		    this.path = parent;
		}
	    } else {
		if (leaf != null) {
		    this.path = parent + "/" + leaf + "[" + (index + 1) + "]";
		} else {
		    this.path = parent + "[" + (index + 1) + "]";
		}
	    }
	    this.parent = parent;
	    this.leaf = leaf;
	    this.index = index;
	    this.status = status;
	    this.value = value;
	    this.type = type;
	    this.message = message;
	}

	// Object
	public String toString() {
	    StringBuffer buffer = new StringBuffer();
	    buffer.append("[");
	    buffer.append(status);
	    buffer.append("] ");
	    buffer.append(path);
	    if (value != null) {
		buffer.append("=");
		buffer.append(value);
	    }
	    if (type != null) {
		buffer.append(" (");
		buffer.append(type);
		buffer.append(")");
	    }
	    if (message != null) {
		buffer.append(" : ");
		buffer.append(message);
	    }
	    return (new String(buffer));
	}
    }
}
