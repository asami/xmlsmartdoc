/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2000  ASAMI, Tomoharu (asami@yk.fujitsu.co.jp)
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

package com.AsamiOffice.jaba2.beans;

import java.util.*;
import java.lang.reflect.*;
import java.beans.*;
import com.AsamiOffice.jaba2.util.PropertyList;
import com.AsamiOffice.jaba2.util.UType;

/**
 * UBean
 *
 * @since   Aug.  2, 2000
 * @version Aug.  3, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public final class UBean {
    public static void setProperties(
	Object bean,
	PropertyList pl
    ) throws IntrospectionException,
	     InvocationTargetException,
	     IllegalAccessException {

	BeanInfo info = Introspector.getBeanInfo(bean.getClass());
	setProperties(bean, info, pl);
    }

    public static void setProperties(
	Object bean,
	BeanInfo info,
	PropertyList pl
    ) throws IntrospectionException,
	     InvocationTargetException,
	     IllegalAccessException {

	PropertyDescriptor[] propertyDescs = info.getPropertyDescriptors();
	String[] keys = pl.getKeys();
	for (int i = 0;i < keys.length;i++) {
	    String propertyName = keys[i];
	    Object propertyValue = pl.get(propertyName);
	    _setProperty(bean, propertyDescs, propertyName, propertyValue);
	}
    }

    private static void _setProperty(
	Object bean,
	PropertyDescriptor[] descs,
	String propertyName,
	Object propertyValue
    ) throws InvocationTargetException, IllegalAccessException {
	for (int i = 0;i < descs.length;i++) {
	    PropertyDescriptor desc = descs[i];
	    String name = desc.getName();
	    if (name.equals(propertyName)) {
		_setProperty(bean, desc, propertyValue);
		return;
	    }
	}
    }

    private static void _setProperty(
	Object bean,
	PropertyDescriptor desc,
	Object value
    ) throws InvocationTargetException, IllegalAccessException {
	Class type = desc.getPropertyType();
	Method method = desc.getWriteMethod();
	if (value instanceof String) {
	    value = UType.asValueOrNull((String)value, type);
	}
	method.invoke(bean, new Object[] { value });
    }

    public static Object getPropertyOrNull(Object bean, String name) {
	try {
	    return (getProperty(bean, name));
	} catch (IntrospectionException e) {
	    return (null);
	} catch (InvocationTargetException e) {
	    return (null);
	} catch (IllegalAccessException e) {
	    return (null);
	}
    }

    public static Object getProperty(
	Object bean,
	String name
    ) throws IntrospectionException,
	     InvocationTargetException,
	     IllegalAccessException {
	Method method = getReadMethod(bean, name);
	if (method == null) {
	    return (null);
	}
	return (method.invoke(bean, new Object[0]));
    }

    public static PropertyDescriptor getPropertyDescriptor(
	Object bean,
	String name
    ) throws IntrospectionException {
	BeanInfo info = Introspector.getBeanInfo(bean.getClass());
	PropertyDescriptor[] descs = info.getPropertyDescriptors();
	for (int i = 0;i < descs.length;i++) {
	    PropertyDescriptor desc = descs[i];
	    if (name.equals(desc.getName())) {
		return (desc);
	    }
	}
	return (null);
    }

    public static Method getReadMethod(Object bean, String name)
	throws IntrospectionException {

	PropertyDescriptor desc = getPropertyDescriptor(bean, name);
	if (desc == null) {
	    return (null);
	}
	return (desc.getReadMethod());
    }

    public static Method getWriteMethod(Object bean, String name)
	throws IntrospectionException {

	PropertyDescriptor desc = getPropertyDescriptor(bean, name);
	if (desc == null) {
	    return (null);
	}
	return (desc.getWriteMethod());
    }
}
