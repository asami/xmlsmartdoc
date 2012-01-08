/*
 * The Relaxer artifact
 * Copyright (c) 2000-2004, ASAMI Tomoharu, All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer. 
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.xmlsmartdoc.goldenport.lib;

import java.util.*;
import java.io.IOException;
import java.rmi.RemoteException;
import java.beans.Beans;
import java.lang.reflect.*;

/**
 * URComponent
 *
 * @since   Mar. 23, 2002
 * @version Feb. 13, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class URComponent {
    public static Object makeBean(String beanName) throws RemoteException {
        try {
            return (Beans.instantiate(null, beanName));
        } catch (ClassNotFoundException e) {
            return (new RemoteException(e.getMessage(), e));
        } catch (IOException e) {
            return (new RemoteException(e.getMessage(), e));
        }
    }

    public static Object makeProvider(
        String provider,
        String providerParam
    ) throws RemoteException {
        try {
            Class clazz = Class.forName(provider);
            Constructor constructor = clazz.getConstructor(
                new Class[] { String.class }
            );
            Object object = constructor.newInstance(
                new Object[] { providerParam }
            );
            return (object);
        } catch (ClassNotFoundException e) {
            return (new RemoteException(e.getMessage(), e));
        } catch (InstantiationException e) {
            return (new RemoteException(e.getMessage(), e));
        } catch (NoSuchMethodException e) {
            return (new RemoteException(e.getMessage(), e));
        } catch (IllegalAccessException e) {
            return (new RemoteException(e.getMessage(), e));
        } catch (IllegalArgumentException e) {
            return (new RemoteException(e.getMessage(), e));
        } catch (InvocationTargetException e) {
            Throwable cause = e.getTargetException();
            if (cause != null) {
                return (new RemoteException(cause.getMessage(), cause));
            } else {
                return (new RemoteException(e.getMessage(), e));
            }
        }
    }

    public static Object makeProvider(String config) throws RemoteException {
        Map params = _getParams(config);
        String providerName = (String)params.get("provider");
        String providerParam = (String)params.get("provider.params");
        return (makeProvider(providerName, providerParam));
    }

    private static final int INIT = 1;
    private static final int NAME = 2;
    private static final int VALUE = 3;
    private static final int BLOCK = 4;

    private static Map _getParams(String config) {
        Map map = new HashMap();
        StringBuffer buffer = new StringBuffer();
        String name = null;
        String value = null;
        int blockCount = 0;
        int size = config.length();
        int state = INIT;
        for (int i = 0;i < size;i++) {
            char c = config.charAt(i);
            switch (state) {
            case INIT:
                switch (c) {
                case ':':
                    // syntax error
                    break;
                case ';':
                    // syntax error
                    break;
                case '[':
                    // syntax error
                    break;
                case ']':
                    // syntax error
                    break;
                default:
                    buffer.append(c);
                    state = NAME;
                }
                break;
            case NAME:
                switch (c) {
                case ':':
                    name = new String(buffer);
                    buffer = new StringBuffer();
                    state = VALUE;
                    break;
                case ';':
                    name = new String(buffer);
                    buffer = new StringBuffer();
                    value = "";
                    map.put(name, value);
                    state = INIT;
                    break;
                case '[':
                    // syntax error
                    break;
                case ']':
                    // syntax error
                    break;
                default:
                    buffer.append(c);
                    state = NAME;
                }
                break;
            case VALUE:
                switch (c) {
                case ':':
                    buffer.append(c);
                    state = VALUE;
                    break;
                case ';':
                    value = new String(buffer);
                    buffer = new StringBuffer();
                    map.put(name, value);
                    state = INIT;
                    break;
                case '[':
                    state = BLOCK;
                    blockCount = 1;
                    break;
                case ']':
                    // syntax error
                    break;
                default:
                    buffer.append(c);
                    state = VALUE;
                }
                break;
            case BLOCK:
                switch (c) {
                case ':':
                    buffer.append(c);
                    state = BLOCK;
                    break;
                case ';':
                    buffer.append(c);
                    state = BLOCK;
                    break;
                case '[':
                    blockCount++;
                    state = BLOCK;
                    break;
                case ']':
                    blockCount--;
                    if (blockCount > 0) {
                        state = BLOCK;
                    } else {
                        state = VALUE;
                    }
                    break;
                default:
                    buffer.append(c);
                    state = BLOCK;
                }
                break;
            default:
                throw (new InternalError());
            }
        }
        return (map);
    }

    public static String encodeValue(
        String name,
        String xmlType,
        Object object
    ) {
        return (name + "[" + xmlType + "]:" + object);
    }

    public static String encodeValue(
        String name,
        String xmlType,
        boolean value
    ) {
        return (name + "[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String name,
        String xmlType,
        byte value
    ) {
        return (name + "[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String name,
        String xmlType,
        short value
    ) {
        return (name + "[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String name,
        String xmlType,
        int value
    ) {
        return (name + "[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String name,
        String xmlType,
        long value
    ) {
        return (name + "[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String name,
        String xmlType,
        float value
    ) {
        return (name + "[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String name,
        String xmlType,
        double value
    ) {
        return (name + "[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String xmlType,
        Object object
    ) {
        return ("[" + xmlType + "]:" + object);
    }

    public static String encodeValue(
        String xmlType,
        boolean value
    ) {
        return ("[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String xmlType,
        byte value
    ) {
        return ("[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String xmlType,
        short value
    ) {
        return ("[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String xmlType,
        int value
    ) {
        return ("[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String xmlType,
        long value
    ) {
        return ("[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String xmlType,
        float value
    ) {
        return ("[" + xmlType + "]:" + value);
    }

    public static String encodeValue(
        String xmlType,
        double value
    ) {
        return ("[" + xmlType + "]:" + value);
    }

    //
    public static String getProvider(String[] args) {
        for (int i = 0;i < args.length;i++) {
            if (args[i].startsWith("-provider:")) {
                return (args[i].substring("-provider:".length()));
            }
        }
        return (null);
    }

    public static String getProviderParams(String[] args) {
        for (int i = 0;i < args.length;i++) {
            if (args[i].startsWith("-provider.params:")) {
                return (args[i].substring("-provider.params:".length()));
            }
        }
        return (null);
    }

    public static boolean isSecurity(String[] args) {
        for (int i = 0;i < args.length;i++) {
            if (args[i].startsWith("-security:false")) {
                return (false);
            }
        }
        return (true);
    }

    public static String[] getArgs(String[] args) {
        List list = new ArrayList();
        for (int i = 0;i < args.length;i++) {
            if (!args[i].startsWith("-")) {
                list.add(args[i]);
            }
        }
        String[] result = new String[list.size()];
        return ((String[])list.toArray(result));
    }

    // URelaxer
    public static Object getPropertyObject(String value) {
        return (value);
    }

    public static Object getPropertyObject(boolean value) {
        return (new Boolean(value));
    }

    public static Object getPropertyObject(byte value) {
        return (new Byte(value));
    }

    public static Object getPropertyObject(short value) {
        return (new Short(value));
    }

    public static Object getPropertyObject(int value) {
        return (new Integer(value));
    }

    public static Object getPropertyObject(long value) {
        return (new Long(value));
    }

    public static Object getPropertyObject(float value) {
        return (new Float(value));
    }

    public static Object getPropertyObject(double value) {
        return (new Double(value));
    }

    public static Object getPropertyObject(Object value) {
        return (value);
    }

    public static Object getPropertyObject(Collection value) {
        return (value.toArray());
    }

    public static boolean getBooleanValue(Object value) {
        Boolean object;
        if (value instanceof Boolean) {
            object = (Boolean)value;
            return (object.booleanValue());
        } else {
            String string = value.toString();
            return ("true".equals(string) || "1".equals(string));
        }
    }

    public static byte getByteValue(Object value) {
        try {
            Number object;
            if (value instanceof Number) {
                object = (Number)value;
            } else {
                object = new Byte(value.toString());
            }
            return (object.byteValue());
        } catch (Exception e) {
            return (_invalidByteValue(e));
        }
    }

    public static short getShortValue(Object value) {
        try {
            Number object;
            if (value instanceof Number) {
                object = (Number)value;
            } else {
                object = new Short(value.toString());
            }
            return (object.shortValue());
        } catch (Exception e) {
            return (_invalidShortValue(e));
        }
    }

    public static int getIntValue(Object value) {
        try {
            Number object;
            if (value instanceof Number) {
                object = (Number)value;
            } else {
                object = new Integer(value.toString());
            }
            return (object.intValue());
        } catch (Exception e) {
            return (_invalidIntValue(e));
        }
    }

    public static long getLongValue(Object value) {
        try {
            Number object;
            if (value instanceof Number) {
                object = (Number)value;
            } else {
                object = new Long(value.toString());
            }
            return (object.longValue());
        } catch (Exception e) {
            return (_invalidLongValue(e));
        }
    }

    public static float getFloatValue(Object value) {
        try {
            Number object;
            if (value instanceof Number) {
                object = (Number)value;
            } else {
                object = new Float(value.toString());
            }
            return (object.floatValue());
        } catch (Exception e) {
            return (_invalidFloatValue(e));
        }
    }

    public static double getDoubleValue(Object value) {
        try {
            Number object;
            if (value instanceof Number) {
                object = (Number)value;
            } else {
                object = new Double(value.toString());
            }
            return (object.doubleValue());
        } catch (Exception e) {
            return (_invalidDoubleValue(e));
        }
    }

    //
    static boolean isRigid__ = true;
    static boolean isBadNumber__ = true;

    private static boolean _invalidBooleanValue(Object value) {
        if (isRigid__) {
            throw (new IllegalArgumentException(value.toString()));
        } else {
            return (false);
        }
    }

    private static byte _invalidByteValue(Object value) {
        if (isRigid__) {
            throw (new IllegalArgumentException(value.toString()));
        } else {
            if (isBadNumber__) {
                return (-1);
            } else {
                return (0);
            }
        }
    }

    private static short _invalidShortValue(Object value) {
        if (isRigid__) {
            throw (new IllegalArgumentException(value.toString()));
        } else {
            if (isBadNumber__) {
                return (-1);
            } else {
                return (0);
            }
        }
    }

    private static int _invalidIntValue(Object value) {
        if (isRigid__) {
            throw (new IllegalArgumentException(value.toString()));
        } else {
            if (isBadNumber__) {
                return (-1);
            } else {
                return (0);
            }
        }
    }

    private static long _invalidLongValue(Object value) {
        if (isRigid__) {
            throw (new IllegalArgumentException(value.toString()));
        } else {
            if (isBadNumber__) {
                return (-1);
            } else {
                return (0);
            }
        }
    }

    private static float _invalidFloatValue(Object value) {
        if (isRigid__) {
            throw (new IllegalArgumentException(value.toString()));
        } else {
            if (isBadNumber__) {
                return (Float.NaN);
            } else {
                return (0);
            }
        }
    }

    private static double _invalidDoubleValue(Object value) {
        if (isRigid__) {
            throw (new IllegalArgumentException(value.toString()));
        } else {
            if (isBadNumber__) {
                return (Double.NaN);
            } else {
                return (0);
            }
        }
    }
}
