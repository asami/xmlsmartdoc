/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
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

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.relaxer.framework.parcel.IParcel;
import org.relaxer.framework.parcel.UrlParcel;
import org.relaxer.framework.runtime.model.IRListModel;
import org.relaxer.framework.runtime.model.IRTableModel;
import org.relaxer.framework.runtime.model.IRTreeModel;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.models.csv.CsvModel;
import org.relaxer.framework.runtime.models.fs.FileStoreModel;
import org.relaxer.framework.runtime.models.workspace.ListWorkspaceModel;
import org.relaxer.framework.script.Slot;

import com.AsamiOffice.text.UString;

/**
 * UImporter
 *
 * @since   Dec. 22, 2003
 * @version Aug. 13, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class UImporter {
    public static Object importObject(Slot slot, Class type) 
      throws ImporterException {
        if (type.isArray()) {
            if (type.equals(slot.getDatatype().getJavaClass())) {
                return (slot.getObjects());
            } else {
                throw (new UnsupportedOperationException());
            }
        } else {
            if (type.equals(slot.getDatatype().getJavaClass())) {
                return (slot.peekObject());
            } else {
                return (getParameter(slot.peekObject(), type));
            }
        }
    }

    public static Object[] importParameter(
        Class[] types, 
        Object[] objects,
        IRModelContext context
    ) throws ImporterException {
        LinkedList typeList = new LinkedList(Arrays.asList(types));
        LinkedList from = new LinkedList(Arrays.asList(objects));
        List to = new ArrayList();
        importParameter(typeList, from, to, context);
        return (to.toArray());
    }

    public static void importParameter(
        LinkedList types, 
        LinkedList from, 
        List to,
        IRModelContext context
    ) throws ImporterException {
        while (!from.isEmpty() && !types.isEmpty()) {
            Class type = (Class)types.removeFirst();
            importParameter(type, from, to, context);
        }
    }

    public static void importParameter(
        Class type, 
        LinkedList from, 
        List to,
        IRModelContext context
    ) throws ImporterException {
        if (type.isArray()) {
            Class compType = type.getComponentType();
            to.add(getArrayParameter(from, compType, context));
        } else if (type == IParcel.class) {
            to.add(getParcelParameter(from, type, context));
        } else if (type == IRTreeModel.class) {
            to.add(getRTreeParameter(from, type, context));
        } else if (type == IRTableModel.class) {
            to.add(getRTableParameter(from, type, context));
        } else if (type == IRListModel.class) {
            to.add(getRListParameter(from, type, context));
        } else {
            to.add(getParameter(from.removeFirst(), type));
        }
    }

    public static Object[] getArrayParameter(LinkedList from, Class type, IRModelContext context) 
      throws ImporterException {
        List list = new ArrayList();
        while (!from.isEmpty()) {
            list.add(getParameter(from.removeFirst(), type));
        }
        Object array = Array.newInstance(type, list.size());
        return (list.toArray((Object[])array));
    }

    public static IParcel getParcelParameter(LinkedList from, Class type, IRModelContext context) 
      throws ImporterException {
        List list = new ArrayList();
        while (!from.isEmpty()) {
            list.add(getParameter(from.removeFirst(), String.class));
        }
        String[] names = new String[list.size()];
        try {
            return (new UrlParcel((String[])list.toArray(names)));
        } catch (MalformedURLException e) {
            throw (new ImporterException("Invalid url", e)); // TODO
        }
    }

    public static IRListModel getRListParameter(
            LinkedList from, 
            Class type,
            IRModelContext context
     ) throws ImporterException {
        try {
            ListWorkspaceModel listModel = new ListWorkspaceModel(context);
            while (!from.isEmpty()) {
                Map properties = new HashMap();
                properties.put(FileStoreModel.PROPERTY_FILE, getParameter(from.removeFirst(), String.class)); 
                IRTreeModel tree = new FileStoreModel(properties, context);
                tree.open(); // TODO read-only
                listModel.addModel(tree);
            }
            return listModel;
        } catch (RModelException e) {
            throw (new ImporterException("Invalid url", e)); // TODO
        }
    }

/*
    public static IRListModel getRListParameter(
    		LinkedList from, 
    		Class type,
    		IRModelContext context
     ) throws ImporterException {
        List list = new ArrayList();
        while (!from.isEmpty()) {
            list.add(getParameter(from.removeFirst(), String.class));
        }
        try {
        	Map properties = new HashMap();
        	properties.put(FileStoreModel.FILE, list);
            IRTreeModel model = new FileStoreModel(properties, context);
            model.open(); // TODO read-only
            return (model);
        } catch (RModelException e) {
            throw (new ImporterException("Invalid url", e)); // TODO
        }
    }
*/

    public static IRTableModel getRTableParameter(LinkedList from, Class type, IRModelContext context)
        throws ImporterException {
    	if (from.isEmpty()) {
    		throw (new ImporterException("no parameter"));
    	}
    	String param = (String)from.removeFirst();
    	if (param.endsWith(".csv")) {
            IRTableModel model = null;
            try {
    	        model = new CsvModel(param, context);
                model.open();
                return (model);
            } catch (RModelException e) {
                throw (new ImporterException(e));
            } finally {
                try {
                    model.rollback();
                    model.close();
                } catch (RModelException e1) {
                }
            }
    	} else {
    		throw (new UnsupportedOperationException());
    	}
    }

    public static IRTreeModel getRTreeParameter(LinkedList from, Class type, IRModelContext context)
      throws ImporterException {
        String name = (String)getParameter(from.removeFirst(), String.class);
        try {
            IRTreeModel model = new FileStoreModel(name, context);
            model.open(); // TODO read-only
            return (model);
        } catch (RModelException e) {
            throw (new ImporterException("Invalid url", e)); // TODO
        }
    }

    public static Object getParameter(Object value, Class type)
      throws ImporterException {
        Constructor constructor = getConstructor_(type, value);
        if (constructor == null) {
            return (getParameter(value.toString(), type));
        } else {
            try {
                return (constructor.newInstance(new Object[] { value }));
            } catch (IllegalArgumentException e) {
                throw (getParameter_error_new_(e, type, value));
            } catch (InstantiationException e) {
                throw (getParameter_error_new_(e, type, value));
            } catch (IllegalAccessException e) {
                throw (getParameter_error_new_(e, type, value));
            } catch (InvocationTargetException e) {
                throw (getParameter_error_new_(e, type, value));
            }
        }
    }
 
    private static Constructor getConstructor_(Class type, Object value) {
        Class valueClass = value.getClass();
        try {
            return (type.getConstructor(new Class[] { valueClass }));
        } catch (SecurityException e) {
            return (null);
        } catch (NoSuchMethodException e) {
            return (null);
        }
    }

    private static ImporterException getParameter_error_new_(
        Throwable e,
        Class type,
        Object value
    ) {
        String message = "Can't instantiate " + type + " with " + 
                         value + "(" + value.getClass() + ")";
        return (new ImporterException(message, e));
    }

    public static Object getParameter(String value, Class type)
      throws ImporterException {
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
                throw (new IllegalArgumentException("Illegal locale: " + value));
            }
        } else if (type == IParcel.class) {
            try {
                return (new UrlParcel(value));
            } catch (MalformedURLException e) {
                throw (new ImporterException("Invalid url", e)); // TODO
            }
        } else {
            try {
                Constructor constructor = type.getConstructor(new Class[] { String.class });
                try {
                    return (constructor.newInstance(new Object[] { value }));
                } catch (IllegalArgumentException ee) {
                    throw (getParameter_error_new_(ee, type, value));
                } catch (InstantiationException ee) {
                    throw (getParameter_error_new_(ee, type, value));
                } catch (IllegalAccessException ee) {
                    throw (getParameter_error_new_(ee, type, value));
                } catch (InvocationTargetException ee) {
                    throw (getParameter_error_new_(ee, type, value));
                }
            } catch (SecurityException e) {
                throw (getParameter_error_constructor_(e, type, value));
            } catch (NoSuchMethodException e) {
                throw (getParameter_error_constructor_(e, type, value));
            }
        }
    }

    private static ImporterException getParameter_error_constructor_(
        Throwable e, 
        Class type, 
        String value
    ) {
        String message = "Can't find constructor of " + type + " with " + 
                         value;
        return (new ImporterException(message, e));
    }

    public static Object getArrayParameter(String[] texts, Class clazz) {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

}
