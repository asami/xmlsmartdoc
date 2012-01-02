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
import org.w3c.dom.*;

/**
 * RStack
 *
 * @since   Mar.  8, 2000
 * @version Nov.  5, 2002
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class RStack {
    private Element element_;
    private Object[] children_;
    private HashSet consumedAttrs_ = new HashSet();
    private HashMap pi_ = new HashMap();
    private int index_;
//    private Element lastPoppedElemnt_ = null;

    protected RStack() {
    }

    public RStack(Element element) {
	element_ = element;
	NodeList nodes = element.getChildNodes();
	List list = new ArrayList();
	_makeList(nodes, list);
	int size = list.size();
	children_ = new Object[size];
	children_ = list.toArray(children_);
	index_ = 0;
    }

    private void _makeList(NodeList nodes, List list) {
	int size = nodes.getLength();
	StringBuffer buffer = null;
	for (int i = 0;i < size;i++) {
	    Node node = nodes.item(i);
	    if (node instanceof Element) {
		if (buffer != null) {
		    list.add(new String(buffer));
		    buffer = null;
		}
		list.add(node);
	    } else if (node instanceof Text) {
		if (buffer == null) {
		    buffer = new StringBuffer();
		}
		buffer.append(((Text)node).getData());
	    } else if (node instanceof ProcessingInstruction) {
		ProcessingInstruction pi = (ProcessingInstruction)node;
		pi_.put(pi.getTarget(), pi.getData());
	    } else if (node instanceof EntityReference) {
		_makeList(node.getChildNodes(), list);
	    }
	}
	if (buffer != null) {
	    list.add(new String(buffer));
	}
    }

    public Element getContextElement() {
	return (element_);
    }

/*
    public Element getLastPoppedElement() {
	return (lastPoppedElemnt_);
    }
*/

    public boolean isEmpty() {
	return (index_ == children_.length);
    }

    public boolean isEmptyElement() {
	if (index_ == children_.length) {
	    return (true);
	}
	for (int i = index_;i < children_.length;i++) {
	    if (children_[i] instanceof Element) {
		return (false);
	    }
	}
	return (true);
    }

    public Object pop() {
	return (children_[index_++]);
    }

    public Object peek() {
	if (index_ == children_.length) {
	    return (null);
	}
	return (children_[index_]);
    }

    public Element popElement() {
	if (index_ == children_.length) {
	    return (null);
	}
	while (index_ < children_.length) {
	    Object node = children_[index_++];
	    if (node instanceof Element) {
//		lastPoppedElemnt_ = (Element)node;
//		return (lastPoppedElemnt_);
		return ((Element)node);
	    }
	}
	return (null);
    }

    public Element peekElement() {
	if (index_ == children_.length) {
	    return (null);
	}
	for (int i = index_;i < children_.length;i++) {
	    Object node = children_[i];
	    if (node instanceof Element) {
		return ((Element)node);
	    }
	}
	return (null);
    }

    public Element[] peekElements() {
	if (index_ == children_.length) {
	    return (null);
	}
	List list = new ArrayList();
	for (int i = index_;i < children_.length;i++) {
	    Object node = children_[i];
	    if (node instanceof Element) {
		list.add(node);
	    }
	}
	Element[] elements = new Element[list.size()];
	return ((Element[])list.toArray(elements));
    }

/*
    public boolean hasAttributeHungry(String name) {
	if (isConsumedAttribute(name)) {
	    return (false);
	}
	setCosumedAttribute(name);
	return (URelaxer.hasAttribute(element_, name));
    }
*/

    public boolean isConsumedAttribute(String name) {
	return (consumedAttrs_.contains(name));
    }

    public boolean isConsumedAttribute(String uri, String name) {
	return (consumedAttrs_.contains(uri + "$" + name));
    }

    public void setConsumedAttribute(String name) {
	if (isConsumedAttribute(name)) {
	    throw (new InternalError());
	}
	consumedAttrs_.add(name);
    }

    public void setConsumedAttribute(String uri, String name) {
	String fullname = uri + "$" + name;
	if (isConsumedAttribute(fullname)) {
	    throw (new InternalError());
	}
	consumedAttrs_.add(fullname);
    }

    public Map getPIMap() {
	return ((Map)pi_.clone());
    }

    public RStack makeClone() {
	RStack newStack = new RStack();
	newStack.element_ = element_;
	newStack.children_ = (Object[])children_.clone();
	newStack.consumedAttrs_ = (HashSet)consumedAttrs_.clone();
	newStack.pi_ = (HashMap)pi_.clone();
	newStack.index_ = index_;
	return (newStack);
    }

    public String toString() {
	StringBuffer buffer = new StringBuffer();
	buffer.append("[");
	if (index_ < children_.length) {
	    Object object = children_[index_];
	    buffer.append(object);
	    for (int i = index_ + 1;i < children_.length;i++) {
		buffer.append(",");
		object = children_[i];
		buffer.append(object);
	    }
	}
	buffer.append("]");
	return (new String(buffer));
    }
}
