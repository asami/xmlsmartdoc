/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2002  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

package com.AsamiOffice.jaba2.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.util.property.Domain;
import com.AsamiOffice.jaba2.util.property.PropertyValue;

/**
 * PropertyList
 *
 * @since   Apr. 10, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class PropertyList extends Observable implements Cloneable {
    protected List entries_ = new ArrayList(); // List<Entry>
    protected Map index_ = new HashMap();
    protected PropertyChangeSupport support_ = null;

    public PropertyList() {
    }

    public PropertyList(String string) {
	String[] pairs = UString.getTokens(string, ";");
	for (int i = 0;i < pairs.length;i++) {
	    String[] pair = UString.getPairTokens(pairs[i], ":");
	    switch (pair.length) {

	    case 0:
		// do nothing
		break;
	    case 1:
		put("_default_", pair[0].trim());
		break;
	    case 2:
		put(pair[0].trim(), pair[1].trim());
		break;
	    default:
		throw (new InternalError());
	    }
	}
    }

    public PropertyList(PropertyList properties) {
	int size = properties.entries_.size();
	for (int i = 0;i < size;i++) {
	    Entry entry = (Entry)properties.entries_.get(i);
	    String key = entry.key;
	    Object value = entry.value;
	    if (value instanceof Immutable) {
		// do nothing
	    } else if (value instanceof PropertyValue) {
		value = ((PropertyValue)value).clone(this);
	    } else if (value instanceof Cloneable) {
		// XXX : do clone
	    } else {
		// do nothing
	    }
	    put(key,
		value,
		entry.type,
		entry.constant,
		entry.domain);
	    Iterator iter = entry.attrs.keySet().iterator();
	    while (iter.hasNext()) {
		String attr = (String)iter.next();
		Object avalue = entry.attrs.get(attr);
		setAttr(key, attr, avalue);
	    }
	}
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
	if (support_ == null) {
	    support_ = new PropertyChangeSupport(this);
	}
	support_.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(
	String propertyName,
	PropertyChangeListener listener
    ) {
	if (support_ == null) {
	    support_ = new PropertyChangeSupport(this);
	}
	support_.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
	support_.removePropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(
	String propertyName,
	PropertyChangeListener listener
    ) {
	support_.removePropertyChangeListener(propertyName, listener);
    }

    public boolean isValid(String key, Object value) {
	Entry entry = (Entry)index_.get(key);
	if (entry == null) {
	    return (false);
	}
	return (entry.domain.isValid(value));
    }

    protected void _firePropertyChange(
	String propertyName,
	Object oldValue,
	Object newValue
    ) {
	if (support_ != null) {
	    support_.firePropertyChange(propertyName, oldValue, newValue);
	}
    }

    /**
     * Setups property list.
     */
    public void put(String key, Object value) {
	Entry entry = (Entry)index_.get(key);
	Class clazz;
	if (value != null) {
	    clazz = value.getClass();
	} else {
	    clazz = null;
	}
	Object oldValue = null;
	if (entry != null) {
	    oldValue = entry.value;
	    if (entry.constant == true) {
		throw (new InternalError("constant"));
	    }
	    entry.value = value;
	    entry.type = clazz;
	} else {
	    boolean constant = false; // XXX : change default
	    entry = new Entry(key, value, clazz, constant);
	    entries_.add(entry);
	    index_.put(key, entry);
	}
	setChanged();
	notifyObservers(key);
	_firePropertyChange(key, oldValue, value);
    }

    public void put(String key, Object value, Class clazz) {
	Entry entry = (Entry)index_.get(key);
	Object oldValue = null;
	if (entry != null) {
	    oldValue = entry.value;
	    if (entry.constant == true) {
		throw (new InternalError("constant"));
	    }
	    entry.value = value;
	    entry.type = clazz;
	} else {
	    boolean constant = true;
	    entry = new Entry(key, value, clazz, constant);
	    entries_.add(entry);
	    index_.put(key, entry);
	}
	setChanged();
	notifyObservers(key);
	_firePropertyChange(key, oldValue, value);
    }

    public void put(String key, Object value, Class clazz, boolean constant) {
	Entry entry = (Entry)index_.get(key);
	Object oldValue = null;
	if (entry != null) {
	    oldValue = entry.value;
	    if (entry.constant == true) {
		throw (new InternalError("constant"));
	    }
	    entry.value = value;
	    entry.type = clazz;
	    entry.constant = constant;
	} else {
	    entry = new Entry(key, value, clazz, constant);
	    entries_.add(entry);
	    index_.put(key, entry);
	}
	setChanged();
	notifyObservers(key);
	_firePropertyChange(key, oldValue, value);
    }

    public void put(
	String key,
	Object value,
	Class clazz,
	boolean constant,
	Domain domain
    ) {
	Entry entry = (Entry)index_.get(key);
	Object oldValue = null;
	if (entry != null) {
	    oldValue = entry.value;
	    if (entry.constant == true) {
		throw (new InternalError("constant"));
	    }
	    entry.value = value;
	    entry.type = clazz;
	    entry.constant = constant;
	    entry.domain = domain;
	} else {
	    entry = new Entry(key, value, clazz, constant, domain);
	    entries_.add(entry);
	    index_.put(key, entry);
	}
	setChanged();
	notifyObservers(key);
	_firePropertyChange(key, oldValue, value);
    }

    public String[] getKeys() {
	int size = entries_.size();
	String[] keys = new String[size];
	for (int i = 0;i < size;i++) {
	    Entry entry = (Entry)entries_.get(i);
	    keys[i] = entry.key;
	}
	return (keys);
    }

    /**
     * Updates value of the property list.
     */
    public void set(String key, Object value) throws IllegalArgumentException {
	Entry entry = (Entry)index_.get(key);
	if (entry == null) {
	    throw (new IllegalArgumentException("non exist key"));
	}
	if (!entry.domain.isValid(value)) {
	    throw (new IllegalArgumentException("invalid value : " + value));
	}
	Object oldValue = entry.value;
	entry.value = value;
	setChanged();
	notifyObservers(key);
	_firePropertyChange(key, oldValue, value);
    }

    public Object get(String key) {
	Entry entry = (Entry)index_.get(key);
	if (entry == null) {
	    return (null);
	} else {
	    return (entry.value);
	}
    }

    public Object get(String key, Object defaultObject) {
	Object object = get(key);
	if (object != null) {
	    return (object);
	} else {
	    return (defaultObject);
	}
    }

    public Object getPrimary() {
	return (get("_default_"));
    }

    public Object getPrimary(Object defaultObject) {
	return (get("_default_", defaultObject));
    }

    public String getString(String key) {
	return ((String)get(key));
    }

    public String getString(String key, String defaultString) {
	return ((String)get(key, defaultString));
    }

    public Class getType(String key) {
	Entry entry = (Entry)index_.get(key);
	if (entry == null) {
	    return (null);
	} else {
	    return (entry.type);
	}
    }

    public boolean isConstant(String key) {
	Entry entry = (Entry)index_.get(key);
	if (entry == null) {
	    return (false);
	} else {
	    return (entry.constant);
	}
    }

    public void setAttr(String key, String attr, Object value) {
	Entry entry = (Entry)index_.get(key);
	if (entry == null) {
	    throw (new IllegalArgumentException("non exist key"));
	}
	entry.attrs.put(attr, value);
    }

    public Object getAttr(String key, String attr) {
	Entry entry = (Entry)index_.get(key);
	if (entry == null) {
	    return (null);
	} else {
	    return (entry.attrs.get(attr));
	}
    }

    public String getAttrString(String key, String attr) {
	return ((String)getAttr(key, attr));
    }

    public void setLabel(String key, String label)
	throws IllegalArgumentException {

	Entry entry = (Entry)index_.get(key);
	if (entry == null) {
	    throw (new IllegalArgumentException("non exist key"));
	}
	entry.attrs.put("label", label);
    }

    public String getLabel(String key) {
	Entry entry = (Entry)index_.get(key);
	if (entry == null) {
	    return (null);
	} else {
	    String label = (String)entry.attrs.get("label");
	    if (label == null) {
		return (entry.key);
	    } else {
		return (label);
	    }
	}
    }

    public PropertyList makeEditableList() {
	PropertyList properties = new PropertyList(this);
	int size = properties.entries_.size();
	for (int i = 0;i < size;i++) {
	    Entry entry = (Entry)properties.entries_.get(i);
	    entry.constant = false;
	}
	return (properties);
    }

    public PropertyList makeImmutableList() {
	PropertyList properties = new PropertyList(this);
	int size = properties.entries_.size();
	for (int i = 0;i < size;i++) {
	    Entry entry = (Entry)properties.entries_.get(i);
	    entry.constant = true;
	}
	return (properties);
    }

    // Object
    public Object clone() {
	return (new PropertyList(this));
    }

    // Object
    public String toString() {
	StringBuffer buffer = new StringBuffer();
	buffer.append(getClass().getName());
	buffer.append("[");
	int size = entries_.size();
	if (size > 0) {
	    Entry entry;
	    entry = (Entry)entries_.get(0);
	    buffer.append(entry.key);
	    buffer.append('=');
	    buffer.append(entry.value.toString());
	    for (int i = 1;i < size;i++) {
		entry = (Entry)entries_.get(i);
		buffer.append(',');
		buffer.append(entry.key);
		buffer.append('=');
		buffer.append(
		    entry.value != null ? entry.value.toString() : "null"
		);
	    }
	}
	buffer.append("]");
	return (buffer.toString());
    }

    // on debug
    /**
     * Makes a <code>PropertyList</code> from the object properties using
     * JavaBeans property facility.
     * <br>
     * All properties in the list are editable.
     */
    public static PropertyList makePropertyList(Object obj) {
	try {
	    BeanInfo info = Introspector.getBeanInfo(obj.getClass());
	    PropertyDescriptor[] properties = info.getPropertyDescriptors();
	    PropertyList list = new PropertyList();
	    Object[] args = new Object[0];
	    for (int i = 0;i < properties.length;i++) {
		PropertyDescriptor desc = properties[i];
		list.put(
		    desc.getName(),
		    desc.getReadMethod().invoke(obj, args),
		    desc.getPropertyType(),
		    true
		);
	    }
	    return (list);
	} catch (IntrospectionException e) {
	    return (new PropertyList());
	} catch (IllegalAccessException e) {
	    return (new PropertyList());
	} catch (InvocationTargetException e) {
	    return (new PropertyList());
	}
    }

    // on debug
    /**
     * Makes a <code>PropertyList</code> from the object properties using
     * JavaBeans property facility.
     * <br>
     * Only properties which has a write method are editable.
     */
    public static PropertyList makePropertyListForEdit(Object obj) {
	try {
	    BeanInfo info = Introspector.getBeanInfo(obj.getClass());
	    PropertyDescriptor[] properties = info.getPropertyDescriptors();
	    PropertyList list = new PropertyList();
	    Object[] args = new Object[0];
	    for (int i = 0;i < properties.length;i++) {
		PropertyDescriptor desc = properties[i];
		list.put(
		    desc.getName(),
		    desc.getReadMethod().invoke(obj, args),
		    desc.getPropertyType(),
		    desc.getWriteMethod() == null
		);
	    }
	    return (list);
	} catch (IntrospectionException e) {
	    return (new PropertyList());
	} catch (IllegalAccessException e) {
	    return (new PropertyList());
	} catch (InvocationTargetException e) {
	    return (new PropertyList());
	}
    }

    static class Entry {
	String key;
	Object value;
	Class type;
	boolean constant;
	Domain domain;
	Map attrs = new HashMap(); // Map<String, Object>

	public Entry(String key, Object value, Class type, boolean constant) {
	    this.key = key;
	    this.value = value;
	    this.type = type;
	    this.constant = constant;
	    this.domain = null;
	}

	public Entry(
	    String key,
	    Object value,
	    Class type,
	    boolean constant,
	    Domain domain
	) {
	    this.key = key;
	    this.value = value;
	    this.type = type;
	    this.constant = constant;
	    this.domain = domain;
	}

	public void putAttr(String key, Object value) {
	    attrs.put(key, value);
	}

	public Object getAttr(String key) {
	    return (attrs.get(key));
	}
    }
}
