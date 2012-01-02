/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (tasami@ibm.net)
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

package com.AsamiOffice.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * MultiValueMap
 *
 * @since   Dec. 18, 1999
 * @version Jan. 16, 2004
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class MultiValueMap extends AbstractMap {
    protected Map map_ = new HashMap();
    protected Object[] type_;

    public MultiValueMap() {
        type_ = new Object[0];
    }

    public MultiValueMap(Object[] type) {
        type_ = type;
    }

    // AbstractMap
    public Object put(Object key, Object value) {
        Object oldValue = get(key);
        List list = new ArrayList();
        list.add(value);
        map_.put(key, list);
        return (oldValue);
    }

    // AbstractMap
    public Set entrySet() {
        return (new AbstractSet() {
            public int size() {
                return (map_.size());
            }

            public Iterator iterator() {
                return (new Iterator() {
                    Iterator iter = map_.entrySet().iterator();

                    public boolean hasNext() {
                        return (iter.hasNext());
                    }

                    public Object next() {
                        Map.Entry entry = (Map.Entry)iter.next();
                        List list = (List)entry.getValue();
                        Map.Entry newEntry =
                            new SimpleMapEntry(
                                entry.getKey(),
                                list.toArray(type_));
                        return (newEntry);
                    }

                    public void remove() {
                        iter.remove();
                    }
                });
            }
        });
    }

    public void add(Object key, Object value) {
        List list = (List)map_.get(key);
        if (list == null) {
            list = new ArrayList();
        }
        list.add(value);
        map_.put(key, list);
    }
}
