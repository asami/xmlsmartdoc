/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2005  ASAMI, Tomoharu (asami@asamiOffice.com)
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ArrayListMap
 *
 * @since   Dec. 28, 1998
 * @version Aug. 15, 2005
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public class ArrayMap extends AbstractMap {
    protected List list_ = new ArrayList(); // List<Map.Entry>
    protected Set entrySet_;

    public ArrayMap() {
        entrySet_ = new AbstractSet() {
            public int size() {
                return (list_.size());
            }

            public Iterator iterator() {
                return (list_.iterator());
            }
        };
    }

    public Object get(int index) {
        Map.Entry entry = (Map.Entry)list_.get(index);
        return (entry.getValue());
    }

    // AbstractMap
    public Object put(Object key, Object value) {
        Map.Entry oldEntry = _getEntry(key);
        Object oldValue;
        if (oldEntry == null) {
            oldValue = null;
            list_.add(new SimpleMapEntry(key, value));
        } else {
            oldValue = oldEntry.getValue();
            oldEntry.setValue(value);
        }
        return (oldValue);
    }

    // AbstractMap
    public Set entrySet() {
        return (entrySet_);
    }

    protected Map.Entry _getEntry(Object key) {
        int size = list_.size();
        if (key == null) {
            for (int i = 0; i < size; i++) {
                Map.Entry entry = (Map.Entry)list_.get(i);
                if (entry.getKey() == null) {
                    return (entry);
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                Map.Entry entry = (Map.Entry)list_.get(i);
                if (key.equals(entry.getKey())) {
                    return (entry);
                }
            }
        }
        return (null);
    }

    public Object[] toValueArray(Object[] result) {
        Object[] entries = list_.toArray();
        for (int i = 0;i < entries.length;i++) {
            Map.Entry entry = (Map.Entry)entries[i];
            result[i] = entry.getValue();
        }
        return (result);
    }

    public Object[] toValueArray() {
        Object[] array = new Object[size()];
        return toValueArray(array);
    }

    /*
        public Comparator comparator() {
    	return (comparator_);
        }
    
        public SortedMap subMap(Object fromkey, Object toKey) {
        }
    
        public SortedMap headMap(Object toKey) {
        }
    
        public SortedMap tailMap(Object fromKey) {
        }
    
        public Object firstKey() {
        }
    
        public Object lastKey() {
        }
    */
}
