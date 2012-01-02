/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2000  ASAMI, Tomoharu (asami@zeomtech.com)
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

package com.AsamiOffice.jaba2.xml.pdom;

import org.w3c.dom.*;

/**
 * MapNamedNodeMap
 *
 * @since   Oct. 14, 1998
 * @version Nov. 16, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class MapNamedNodeMap implements NamedNodeMap {
    protected PMap map_;	// Map<String, Node>
    protected Object[] keys_;

    public MapNamedNodeMap(PMap map) {
	map_ = map;
	keys_ = map_.keySet().toArray();
    }

    // NamedNodeMap
    public Node getNamedItem(String name) {
	return ((Node)map_.get(name));
    }

    // NamedNodeMap
    public Node setNamedItem(Node arg) throws DOMException {
	throw (new UnsupportedOperationException());
    }

    // NamedNodeMap
    public Node removeNamedItem(String name) throws DOMException {
	throw (new UnsupportedOperationException());
    }

    // NamedNodeMap
    public Node item(int index) {
	return ((Node)map_.get(keys_[index]));
    }

    // NamedNodeMap
    public int getLength() {
	return (keys_.length);
    }

    // DOM2
    public Node getNamedItemNS(String uri, String name) {
	throw (new UnsupportedOperationException());
    }

    public Node setNamedItemNS(Node arg) {
	throw (new UnsupportedOperationException());
    }

    public Node removeNamedItemNS(String uri, String name) {
	throw (new UnsupportedOperationException());
    }
}
