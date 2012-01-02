/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Locale;

import com.AsamiOffice.io.UURL;
import com.AsamiOffice.util.*;

/**
 * UType
 *
 * @since   Aug.  2, 2000
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public final class UType {
    public static Object asValueOrNull(String string, Class type) {
        try {
            return (asValue(string, type));
        } catch (NumberFormatException e) {
            return (null);
        } catch (IllegalArgumentException e) {
            return (null);
        } catch (InstantiationException e) {
            return (null);
        } catch (InvocationTargetException e) {
            return (null);
        } catch (IllegalAccessException e) {
            return (null);
        }
    }

    public static Object asValue(String string, Class type)
        throws NumberFormatException,
               IllegalArgumentException,
               InstantiationException,
               InvocationTargetException,
               IllegalAccessException {

        if (type.equals(boolean.class)) {
            return (new Boolean(string));
        } else if (type.equals(byte.class)) {
            return (new Byte(string));
        } else if (type.equals(short.class)) {
            return (new Short(string));
        } else if (type.equals(int.class)) {
            return (new Integer(string));
        } else if (type.equals(long.class)) {
            return (new Long(string));
        } else if (type.equals(float.class)) {
            return (new Float(string));
        } else if (type.equals(double.class)) {
            return (new Double(string));
        } else if (type.equals(String.class)) {
            return (string);
        } else if (type.equals(Boolean.class)) {
            return (new Boolean(string));
        } else if (type.equals(Byte.class)) {
            return (new Byte(string));
        } else if (type.equals(Short.class)) {
            return (new Short(string));
        } else if (type.equals(Integer.class)) {
            return (new Integer(string));
        } else if (type.equals(Long.class)) {
            return (new Long(string));
        } else if (type.equals(Float.class)) {
            return (new Float(string));
        } else if (type.equals(Double.class)) {
            return (new Double(string));
        } else if (type.equals(BigDecimal.class)) {
            return (new BigDecimal(string));
        } else if (type.equals(BigInteger.class)) {
            return (new BigInteger(string));
        } else if (type.equals(Date.class)) {
            return (new Date(string));
        } else if (type.equals(Locale.class)) {
            return (ULocale.makeLocale(string));
        } else if (type.equals(URL.class)) {
            try {
                return (UURL.getURLFromFileOrURLName(string));
            } catch (MalformedURLException e) {
                throw (new InternalError()); // XXX
            }
        } else if (type.equals(byte[].class)) {
            return (string.getBytes());
        } else if (type.equals(char[].class)) {
            return (string.toCharArray());
        } else {
            Constructor[] constructors = type.getConstructors();
            for (int i = 0;i < constructors.length;i++) {
                Constructor constructor = constructors[i];
                Class[] params = constructor.getParameterTypes();
                if (params.length != 0) {
                    continue;
                }
                if (String.class.equals(params[1])) {
                    return (
                        constructor.newInstance(
                            new Object[] { string }
                        )
                    );
                }
            }
            throw (new IllegalArgumentException());
        }
    }
}
