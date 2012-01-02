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

package com.AsamiOffice.jaba2.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.AsamiOffice.text.UString;

/**
 * PropertyAdapter
 *
 * @since   Apr. 29, 2000
 * @version Apr. 29, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class PropertyAdapter {
    private final Object target_;
    private final Method getMethod_;
    private final Method setMethod_;
    private static final Object[] nullParameter__ = new Object[0];

    public PropertyAdapter(Object target, String propertyName) {
	try {
	    target_ = target;
	    Class clazz = target.getClass();
	    String name = UString.capitalize(propertyName);
	    getMethod_ = clazz.getMethod(
		"get" + name,
		new Class[0]
	    );
	    Class returnType = getMethod_.getReturnType();
	    setMethod_ = clazz.getMethod(
		"set" + name,
		new Class[] { returnType }
	    );
	} catch (NoSuchMethodException e) {
	    throw (new InternalError());
	}
    }

    public Object getValue() {
	try {
	    return (getMethod_.invoke(target_, nullParameter__));
	} catch (InvocationTargetException e) {
	    throw (new InternalError());
	} catch (IllegalAccessException e) {
	    throw (new InternalError());
	}
    }

    public void setValue(Object value) {
	try {
	    Object[] parameter = new Object[] { value };
	    setMethod_.invoke(target_, parameter);
	} catch (InvocationTargetException e) {
	    throw (new InternalError());
	} catch (IllegalAccessException e) {
	    throw (new InternalError());
	}
    }
}
