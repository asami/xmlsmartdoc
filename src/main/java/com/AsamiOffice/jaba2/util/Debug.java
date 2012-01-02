/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1998  ASAMI, Tomoharu (tasami@ibm.net)
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

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

import com.AsamiOffice.util.*;

/**
 * Debug utility
 *
 * @since   Jan.  1, 1998
 * @version Jul. 15, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class Debug {
    public static final int LEVEL_NONE = 0;
    public static final int LEVEL_EMERGENCY = 1;
    public static final int LEVEL_METHOD_ENTER = 11;
    public static final int LEVEL_METHOD_LEAVE = 12;
    public static final int LEVEL_NOTICE = 21;
    public static final int LEVEL_MAX = LEVEL_NOTICE;

    private static boolean isActive_ = false;
    // Container<String>
    private static Map targetNames__ = new HashMap();
    // Container<Class>
    private static Map targetClasses__ = new HashMap();
    private static int level__ = LEVEL_NONE;
    private static PrintWriter log__ = null;

    public static void log(int level, String message) {
	if (isActive_ == false) {
	    return;
	}
	if (level < getLevel()) {
	    System.err.println(message);
	    if (log__ != null) {
		log__.println(message);
	    }
	}
    }

    /**
     * @param obj  debug class
     */
    public static void log(int level, Object obj, String message) {
	if (isActive_ == false) {
	    return;
	}
	if (level < getLevel(obj)) {
	    String logMessage = obj + " : " + message;
	    System.err.println(logMessage);
	    if (log__ != null) {
		log__.println(logMessage);
	    }
	}
    }

    public static final void setClass(String name) {
	isActive_ = true;
	targetNames__.put(name, new Integer(LEVEL_MAX + 1));
    }

    public static final void setClass(String name, int level) {
	isActive_ = true;
	targetNames__.put(name, new Integer(level));
    }

    public static final void setClass(Object object) {
	isActive_ = true;
	targetClasses__.put(object.getClass(), new Integer(LEVEL_MAX + 1));
    }

    public static final void setClass(Object object, int level) {
	isActive_ = true;
	targetClasses__.put(object.getClass(), new Integer(level));
    }

    public static final void setLevel(int level) {
	isActive_ = true;
	level__ = level;
    }

    public static final void setLogFile(OutputStream output) {
	isActive_ = true;
	log__ = new PrintWriter(new OutputStreamWriter(output));
    }

    public static final void setLogFile(File file) throws IOException {
	isActive_ = true;
	log__ = new PrintWriter(
	    new BufferedWriter(
		new FileWriter(file)
	    )
	);
    }

    private static final int getLevel(Object obj) {
	try {
	    Object match = targetClasses__.get(obj.getClass());
	    if (match != null) {
		return (((Integer)match).intValue());
	    }
	    String className = obj.getClass().getName();
	    Iterator iter = targetNames__.keySet().iterator();
	    while (iter.hasNext()) {
		String key = (String)iter.next();
		if (className.indexOf(key) != -1) {
		    Integer value = (Integer)targetNames__.get(key);
		    return (value.intValue());
		}
	    }
	} catch (Exception e) {
	}
	return (level__);
    }

    private static final int getLevel() {
	return (level__);
    }

    /**
     * just helper
     */
    public static final String a2s(Object[] array) {
	return (UArray.array2String(array));
    }
}
