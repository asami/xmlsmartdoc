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

package org.xmlsmartdoc.SmartDoc;

import java.util.*;
import org.w3c.dom.Element;

/**
 * Ul
 *
 * @since   Sep. 23, 1998
 * @version Jun. 16, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class Ul extends Container {
    public Ul() {
    }

    public Ul(Element element) {
	super(element);
    }

    // Content
    public int getEntityType() {
	return (ENTITY_BLOCK);
    }

    // Container
    public void format() {
	super.format();
	if (!"children".equals(getClazz())) { // XXX
	    return;
	}
	Container container = getParent();
	for (;;) {
	    if (container instanceof Doc) {
		throw (new UnsupportedOperationException());
	    }
	    if (container instanceof Body) {
		throw (new UnsupportedOperationException());
	    }
	    if (container instanceof Part) {
		throw (new UnsupportedOperationException());
	    }
	    if (container instanceof Chapter) {
		throw (new UnsupportedOperationException());
	    }
	    if (container instanceof Section) {
		List list = new ArrayList();
		_CollectSubSections(container, list);
		_buildRefList(list);
		return;
	    }
	    if (container instanceof SubSection) {
		List list = new ArrayList();
		_CollectSubSubSections(container, list);
		_buildRefList(list);
		return;
	    }
	    if (container instanceof SubSubSection) {
		throw (new UnsupportedOperationException());
	    }
	    container = container.getParent();
	}
    }

    protected void _buildRefList(List list) {
	int size = list.size();
	for (int i = 0;i < size;i++) {
	    Content content = (Content)list.get(i);
	    Li li = new Li();
	    Ref ref = new Ref(content);
	    li.addContent(ref);
	    addContent(li);
	}
    }

    protected void _CollectSubSections(Container container, List list) {
	if (container instanceof SubSection) {
	    list.add(container);
	}
	Content[] contents = container.getContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Container) {
		_CollectSubSections((Container)content, list);
	    }
	}
    }

    protected void _CollectSubSubSections(Container container, List list) {
	if (container instanceof SubSubSection) {
	    list.add(container);
	}
	Content[] contents = container.getContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Container) {
		_CollectSubSubSections((Container)content, list);
	    }
	}
    }
}
