/*
 * Created on 2004/09/21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.relaxer.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.w3c.dom.Document;

public final class URelaxerObject {
    public static boolean isRelaxerObject(Object object) {
        try {
            Class clazz = object.getClass();
            return (clazz.getMethod("makeDocument", new Class[0]) != null);
        } catch (SecurityException e) {
            return (false);
        } catch (NoSuchMethodException e) {
            return (false);
        }
    }

    public static Document makeDocument(Object object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class clazz = object.getClass();
        Method method = clazz.getMethod("makeDocument", new Class[0]);
        Document doc = (Document)method.invoke(object, new Object[0]);
        return doc;
    }
}
