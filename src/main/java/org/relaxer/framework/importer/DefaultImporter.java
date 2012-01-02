/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
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
package org.relaxer.framework.importer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.relaxer.framework.parcel.IParcel;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * DefaultImporter
 *
 * @since   Dec. 22, 2003
 * @version Aug.  9, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class DefaultImporter extends AbstractImporter {
    public DefaultImporter(IRModelContext context) {
        super(context);
    }

    public Object[] importParameters(Method method, Object[] objects) 
      throws ImporterException {
        LinkedList types = new LinkedList(
            Arrays.asList(method.getParameterTypes())
        );
        LinkedList from = new LinkedList(Arrays.asList(objects));
        List to = new ArrayList();
        importParameter_(types, from, to);
        return (to.toArray());
    }

    private void importParameter_(LinkedList types, LinkedList from, List to) 
      throws ImporterException {
        while (!from.isEmpty() && !types.isEmpty()) {
            Class type = (Class)types.removeFirst();
            importParameter_(type, from, to);
        }
    }

    private void importParameter_(Class type, LinkedList from, List to)
      throws ImporterException {
        if (type.isArray()) {
            Class compType = type.getComponentType();
            try {
                to.add(UImporter.getArrayParameter(from, compType, _context));
            } catch (ImporterException e) {
                _error(e.getMessage(), e.getCause());
                throw (e);
            }
        } else if (type == IParcel.class) {
            try {
                to.add(UImporter.getParcelParameter(from, type, _context));
            } catch (ImporterException e) {
                _error(e.getMessage(), e.getCause());
                throw (e);
            }
        } else {
            try {
                to.add(UImporter.getParameter(from.removeFirst(), type));
            } catch (ImporterException e) {
                _error(e.getMessage(), e.getCause());
                throw (e);
            }
        }
    }

/*
    private Object[] _importParameters(Method method, Object[] objects)
        throws
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {
        if (objects == null) {
            return (new Object[0]);
        }
        Object[] params = new Object[objects.length];
        Class[] types = method.getParameterTypes();
        //System.out.println(params.length + ";" + types.length);
        for (int i = 0; i < types.length; i++) {
            params[i] = _getParameter(objects[i], types[i]);
        }
        return (params);
    }

    private Object[] _getArrayParameter(LinkedList from, Class type) 
        throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        List list = new ArrayList();
        while (!from.isEmpty()) {
            list.add(_getParameter(from.removeFirst(), type));
        }
        Object array = Array.newInstance(type, list.size());
        return (list.toArray((Object[])array));
    }

    private IParcel _getParcelParameter(LinkedList from, Class type) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, MalformedURLException {
        List list = new ArrayList();
        while (!from.isEmpty()) {
            list.add(_getParameter(from.removeFirst(), String.class));
        }
        String[] names = new String[list.size()];
        return (new UrlParcel((String[])list.toArray(names)));
    }

    private Object _getParameter(Object value, Class type)
        throws
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {
        Class valueClass = value.getClass();
        if (type.isAssignableFrom(valueClass)) {
            Constructor constructor =
                type.getConstructor(new Class[] { type });
            return (constructor.newInstance(new Object[] { value }));
        } else {
            return (_getParameter(value.toString(), type));
        }
    }
 
    private Object _getParameter(String value, Class type)
        throws
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {
        if (value == null) {
            return (null);
        } else if (type == boolean.class || type == Boolean.class) {
            if ("true".equals(value.toLowerCase()) || "1".equals(value)) {

                return (Boolean.TRUE);
            } else {
                return (Boolean.FALSE);
            }
        } else if (type == byte.class || type == Byte.class) {
            return (Byte.valueOf(value));
        } else if (type == short.class || type == Short.class) {
            return (Short.valueOf(value));
        } else if (type == int.class || type == Integer.class) {
            return (Integer.valueOf(value));
        } else if (type == long.class || type == Long.class) {
            return (Long.valueOf(value));
        } else if (type == float.class || type == Float.class) {
            return (Float.valueOf(value));
        } else if (type == double.class || type == Double.class) {
            return (Double.valueOf(value));
        } else if (type == String.class) {
            return (value);
        } else if (type == Locale.class) {
            String[] elements = UString.getTokens(value, "_");
            switch (elements.length) {
            case 1:
                return (new Locale(elements[0]));
            case 2:
                return (new Locale(elements[0], elements[1]));
            case 3:
                return (new Locale(elements[0], elements[1], elements[2]));
            default:
                _warning("Illegal locale: " + value);
                throw (new IllegalArgumentException(value));
            }
        } else if (type == IParcel.class) {
            try {
                return (new UrlParcel(value));
            } catch (MalformedURLException e) {
                throw (new InvocationTargetException(e));
            }
        } else {
            Constructor constructor =
                type.getConstructor(new Class[] { String.class });
            return (constructor.newInstance(new Object[] { value }));
        }
    }
*/
}
