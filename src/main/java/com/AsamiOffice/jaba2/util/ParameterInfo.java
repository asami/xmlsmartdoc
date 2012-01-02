/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004   ASAMI, Tomoharu (asami@AsamiOffice.com)
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.Vector;

import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.*;
import com.AsamiOffice.io.UURL;
import com.AsamiOffice.jaba2.io.FilePathList;

/**
 * ParameterInfo
 *
 * @since   Feb. 13, 1998
 * @version Aug. 28, 2004
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class ParameterInfo {
    public static final String ARG_PREFIX = "argument";

    protected String prefix_;
    protected ParameterManager[] managers_;
    protected List packages_ = new ArrayList();

    public ParameterInfo(String prefix) {
        prefix_ = prefix;
        managers_ = null;
    }

    public ParameterInfo(String prefix, ParameterManager[] managers) {
        prefix_ = prefix;
        managers_ = (ParameterManager[])managers.clone();
    }

    public ResourceBundle getResourceBundle() {
        for (int i = 0;i < managers_.length;i++) {
            ParameterManager manager = managers_[i];
            if (manager instanceof ResourceParameterManager) {
                ResourceParameterManager rm
                    = (ResourceParameterManager)manager;
                return (rm.getResourceBundle());
            }
        }
        return (null);
    }

    public void addParameterManagers(ParameterManager[] managers) {
        if (managers_ == null) {
            managers_ = (ParameterManager[])managers.clone();
        } else {
            ParameterManager[] newManagers
                = new ParameterManager[managers_.length + managers.length];
            System.arraycopy(managers_, 0, newManagers, 0, managers_.length);
            System.arraycopy(managers, 0, newManagers, managers_.length,
                             managers.length);
            managers_ = newManagers;
        }
    }

    public void addParameterManager(ParameterManager manager) {
        ParameterManager[] newManagers
            = new ParameterManager[managers_.length + 1];
        newManagers[managers_.length] = manager;
        System.arraycopy(managers_, 0, newManagers, 0, managers_.length);
        managers_ = newManagers;
    }

    public void addPackage(String packageName) {
        packages_.add(packageName);
    }

    public Iterator getKeys() {
        HashSet keys = new HashSet();
        for (int i = 0;i < managers_.length;i++) {
            Enumeration iter = managers_[i].getKeys();
            while (iter.hasMoreElements()) {
                keys.add(iter.nextElement());
            }
        }
        return (keys.iterator());
    }

    public boolean isParameter(String key) {
        for (int i = 0;i < managers_.length;i++) {
            boolean ok = managers_[i].isParameter(key);
            if (ok) {
                return (true);
            }
        }
        key = prefix_ + "." + key;
        for (int i = 0;i < managers_.length;i++) {
            boolean ok = managers_[i].isParameter(key);
            if (ok) {
                return (true);
            }
        }
        return (false);
    }

    public Object getParameter(String key) {
        for (int i = 0;i < managers_.length;i++) {
            Object value = managers_[i].getParameter(key);
            if (value != null) {
                if ("".equals(value)) {        // spec change
                    return (null);
                } else {
                    return (value);
                }
            }
        }
        key = prefix_ + "." + key;
        for (int i = 0;i < managers_.length;i++) {
            Object value = managers_[i].getParameter(key);
            if (value != null) {
                if ("".equals(value)) {        // spec change
                    return (null);
                } else {
                    return (value);
                }
            }
        }
        return (null);
    }

    public String getParameterAsString(String key) {
        Object value = getParameter(key);
        if (value == null) {
            return (null);
        }
        return (value.toString());
    }

    /**
     * @deprecated
     * @see getParameterAsString
     */
    public String getParameterByString(String key) {
        Object value = getParameter(key);
        if (value == null) {
            return (null);
        }
        return (value.toString());
    }

    public String[] getParameterAsStringList(String key) {
        return (getParameterAsStringList(key, ":;,"));
    }

    public String[] getParameterAsStringList(String key, String delim) {
        String string = getParameterAsString(key);
        if (string == null) {
            return (null);
        }
        StringTokenizer st = new StringTokenizer(string, delim);
        String[] list = new String[st.countTokens()];
        for (int i = 0;i < list.length;i++) {
            list[i] = st.nextToken();
        }
        return (list);
    }

    public String[] getParameterByCSVAsStringList(String key) {
        String string = getParameterAsString(key);
        if (string == null) {
            return (null);
        }
        return (UString.makeStringListFromCSVLine(string));
    }        

    public PropertyList getParameterAsPropertyList(String key) {
        String string = getParameterAsString(key);
        if (string == null) {
            return (null);
        }
        return (new PropertyList(string));
    }

    public int getParameterAsInt(String key) {
        Object value = getParameter(key);
        if (value == null) {
            return (-1);
        }
        if (value instanceof String) {
            return (Integer.parseInt((String)value));
        } else if (value instanceof Number) {
            return (((Number)value).intValue());
        } else {
            throw (new IllegalArgumentException("not number"));
        }
    }

    /**
     * @deprecated
     * @see getParameterAsString
     */
    public int getParameterByInt(String key) {
        Object value = getParameter(key);
        if (value == null) {
            return (-1);
        }
        if (value instanceof String) {
            return (Integer.parseInt((String)value));
        } else if (value instanceof Number) {
            return (((Number)value).intValue());
        } else {
            throw (new IllegalArgumentException("not number"));
        }
    }

    public boolean getParameterAsBoolean(String key) {
        Object value = getParameter(key);
        if (value == null) {
            return (isParameter(key));
        }
        String string = value.toString();
        if (string.equals("true")) {
            return (true);
        } else if (string.equals("false")) {
            return (false);
        } else {
            return (true);
        }
    }

    public Boolean getParameterAsBooleanOrNull(String key) {
        Object value = getParameter(key);
        if (value == null) {
            return (null);
        }
        String string = value.toString();
        if (string.equals("true")) {
            return (Boolean.TRUE);
        } else if (string.equals("false")) {
            return (Boolean.FALSE);
        } else {
            return (null);
        }
    }

    /**
     * @deprecated
     * @see getParameterAsString
     */
    public boolean getParameterByBoolean(String key) {
        Object value = getParameter(key);
        if (value == null) {
            return (isParameter(key));
        }
        String string = value.toString();
        if (string.equals("true")) {
            return (true);
        } else if (string.equals("false")) {
            return (false);
        } else {
            return (true);
        }
    }

    /**
     * @deprecated
     * @see getParameterAsString
     */
    public File getParameterByFile(String key) {
        String value = getParameterByString(key);
        if (value == null) {
            return (null);
        }
        return (new File(value));
    }

    public File getParameterAsFile(String key) {
        String value = getParameterByString(key);
        if (value == null) {
            return (null);
        }
        return (new File(value));
    }

    public URL getParameterAsURL(String key) throws MalformedURLException {
        String value = getParameterAsString(key);
        if (value == null) {
            return (null);
        }
        return (new URL(value));
    }

    /**
     * @deprecated
     * @see getParameterAsURL
     */
    public URL getParameterByURL(String key) throws MalformedURLException {
        String value = getParameterByString(key);
        if (value == null) {
            return (null);
        }
        return (new URL(value));
    }

    public URL getParameterAsURLFromFileOrURL(String key)
        throws MalformedURLException {

        String value = getParameterAsString(key);
        if (value == null) {
            return (null);
        }
        return (UURL.getURLFromFileOrURLName(value));
    }

    public URL[] getParameterAsURLListFromFileOrURL(String key)
        throws MalformedURLException {

        String[] values = getParameterAsStringList(key);
        if (values == null) {
            return (null);
        }
        URL[] urls = new URL[values.length];
        for (int i = 0;i < values.length;i++) {
            urls[i] = UURL.getURLFromFileOrURLName(values[i]);
        }
        return (urls);
    }

    public URL getParameterAsURLFromResource(String key, Class clazz) {
        String value = getParameterAsString(key);
        if (value == null) {
            return (null);
        }
        return (clazz.getClassLoader().getResource(value));
    }

    public InputStream getParameterAsInputStreamFromFile(String key)
        throws IOException {

        File file = getParameterByFile(key);
        if (file == null) {
            return (null);
        }
        return (new FileInputStream(file));
    }

    public InputStream getParameterAsInputStreamFromFileOrURL(String key)
        throws IOException {

        URL url = getParameterAsURLFromFileOrURL(key);
        if (url == null) {
            return (null);
        }
        return (url.openStream());
    }

    /**
     * @deprecated
     * @see getParameterAsString
     */
    public InputStream getParameterByInputStreamFromFile(String key)
        throws IOException {

        File file = getParameterByFile(key);
        if (file == null) {
            return (null);
        }
        return (new FileInputStream(file));
    }

    /**
     * @deprecated
     * @see getParameterAsString
     */
    public InputStream getParameterByInputStreamFromURL(String key)
        throws MalformedURLException, IOException {

        URL url = getParameterByURL(key);
        if (url == null) {
            return (null);
        }
        return (url.openStream());
    }

    public InputStream getParameterAsInputStreamFromResource(
        String key,
        Class clazz
    ) {
        String value = getParameterAsString(key);
        if (value == null) {
            return (null);
        }
        return (clazz.getClassLoader().getResourceAsStream(value));
    }

    /**
     * @deprecated
     * @see getParameterAsString
     */
    public Reader getParameterByReaderFromFile(String key) throws IOException {
        File file = getParameterByFile(key);
        if (file == null) {
            return (null);
        }
        return (new FileReader(file));
    }

    /**
     * @deprecated
     * @see getParameterAsString
     */
    public Reader getParameterByReaderFromURL(String key)
        throws MalformedURLException, IOException {

        URL url = getParameterByURL(key);
        if (url == null) {
            return (null);
        }
        return (new InputStreamReader(url.openStream()));
    }

    public Reader getParameterAsReaderFromResource(String key, Class clazz) {
        String value = getParameterAsString(key);
        if (value == null) {
            return (null);
        }
        return (new InputStreamReader(
            clazz.getClassLoader().getResourceAsStream(value))
        );
    }

    public Class getParameterAsClass(String key) {
        String value = (String)getParameter(key);
        if (value == null) {
            return (null);
        }
        Class clazz = null;
        try {
            clazz = Class.forName(value);
        } catch (ClassNotFoundException e) {
        }
        if (clazz != null) {
            return (clazz);
        }
        int size = packages_.size();
        for (int i = 0;i < size;i++) {
            try {
                clazz = Class.forName((String)packages_.get(i) + "." + value);
            } catch (ClassNotFoundException e) {
            }
            if (clazz != null) {
                return (clazz);
            }
        }
        return (clazz);
    }

    /**
     * @deprecated
     * @see getParameterAsClass
     */
    public Class getParameterByClass(String key) {
        String value = (String)getParameter(key);
        if (value == null) {
            return (null);
        }
        Class clazz = null;
        try {
            clazz = Class.forName(value);
        } catch (ClassNotFoundException e) {
        }
        return (clazz);
    }

    public Object getParameterAsNewInstance(String key) {
        Class clazz = getParameterAsClass(key);
        if (clazz == null) {
            return (null);
        }
        Object object = null;
        try {
            object = clazz.newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
        return (object);
    }

    /**
     * @deprecated
     * @see getParameterAsString
     */
    public Object getParameterByNewInstance(String key) {
        Class clazz = getParameterByClass(key);
        if (clazz == null) {
            return (null);
        }
        Object object = null;
        try {
            object = clazz.newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
        return (object);
    }

    public Locale getParameterAsLocale(String key) {
        String value = getParameterAsString(key);
        if (value == null || value.equals("")) {
            return (null);
        }
        return (ULocale.makeLocale(value));
    }

    public Locale[] getParameterAsLocaleList(String key) {
        String[] value = getParameterAsStringList(key);
        if (value == null || value.equals("")) {
            return (null);
        }
        Locale[] locales = new Locale[value.length];
        for (int i = 0;i < value.length;i++) {
            locales[i] = ULocale.makeLocale(value[i]);
        }
        return (locales);
    }

    public LocaleString getParameterAsLocaleString(String key) {
        String value = getParameterAsString(key);
        if (value == null) {
            return (null);
        }
        PropertyList properties = new PropertyList(value);
        LocaleString lstring = new LocaleString();
        String[] pkeys = properties.getKeys();
        for (int i = 0;i < pkeys.length;i++) {
            String pkey = pkeys[i];
            Object pvalue = properties.get(pkey);
            if ("_default_".equals(pkey)) {
                lstring.putDefault(pvalue.toString());
            } else {
                lstring.put(pkey, pvalue.toString());
            }
        }
        return (lstring);
    }

    public LocaleMap getParameterAsLocaleMap(String key) {
        String value = getParameterAsString(key);
        if (value == null) {
            return (null);
        }
        PropertyList properties = new PropertyList(value);
        LocaleMap map = new LocaleMap();
        String[] pkeys = properties.getKeys();
        for (int i = 0;i < pkeys.length;i++) {
            String pkey = pkeys[i];
            Object pvalue = properties.get(pkey);
            if ("_default_".equals(pkey)) {
                map.putDefault(pvalue.toString());
            } else {
                map.put(pkey, pvalue.toString());
            }
        }
        return (map);
    }

    public FilePathList getParameterAsFilePathList(String key) {
        String value = getParameterAsString(key);
        if (value == null) {
            return (null);
        }
        return (new FilePathList(value));
    }

    /**
     * @deprecated
     * @see getParameterAsFilePathList
     */
    public FilePathList getParameterByFilePathList(String key) {
        String value = getParameterByString(key);
        if (value == null) {
            return (null);
        }
        return (new FilePathList(value));
    }

    public URLClassLoader getParameterAsURLClassLoader(String key)
        throws MalformedURLException {

        FilePathList paths = getParameterAsFilePathList(key);
        if (paths == null) {
            return (null);
        }
        return (new URLClassLoader(paths.getURLs()));
    }

    public int getArgumentCount() { // XXX : more efficient
        int no = 0;
        for (;;) {
            Object arg = getParameter(ARG_PREFIX + no);
            if (arg == null) {
                break;
            }
            no++;
        }
        return (no);
    }

    public Object getArgument(int no) {
        return (getParameter(ARG_PREFIX + no));
    }

    public Object[] getArguments() {
        Vector args = new Vector();
        int no = 0;
        for (;;) {
            Object arg = getParameter(ARG_PREFIX + no);
            if (arg == null) {
                break;
            }
            args.addElement(arg);
            no++;
        }
        Object[] array = new Object[args.size()];
        args.copyInto(array);
        return (array);
    }

    public String getArgumentAsString(int no) {
        return (getParameterAsString(ARG_PREFIX + no));
    }

    public File getArgumentAsFile(int no) {
        String name = getArgumentAsString(no);
        if (name == null) {
            return (null);
        }
        return (new File(name));
    }

    /**
     * @deprecated
     * @see getArgumentAsString
     */
    public String getArgumentByString(int no) {
        return (getParameterByString(ARG_PREFIX + no));
    }

    public InputStream getArgumentAsInputStreamFromFile(int no)
        throws IOException {

        return (getParameterAsInputStreamFromFile(ARG_PREFIX + no));
    }

    public InputStream getArgumentAsInputStreamFromFileOrURL(int no)
        throws IOException {

        return (getParameterAsInputStreamFromFileOrURL(ARG_PREFIX + no));
    }

    /**
     * @deprecated
     * @see getParameterAsString
     */
    public InputStream getArgumentByInputStreamFromFile(int no)
        throws IOException {

        return (getParameterByInputStreamFromFile(ARG_PREFIX + no));
    }

    /**
     * @deprecated
     * @see getParameterAsString
     */
    public Reader getArgumentByReaderFromFile(int no) throws IOException {
        return (getParameterByReaderFromFile(ARG_PREFIX + no));
    }

    public URL getArgumentAsURL(int no) throws MalformedURLException {
        return (getParameterAsURL(ARG_PREFIX + no));
    }

    public URL getArgumentAsURLFromFileOrURL(int no)
        throws MalformedURLException {

        return (getParameterAsURLFromFileOrURL(ARG_PREFIX + no));
    }

    public String[] getArgumentsAsString() {
        List list = new ArrayList();
        int no = 0;
        for (;;) {
            Object arg = getParameter(ARG_PREFIX + no);
            if (arg == null) {
                break;
            }
            list.add(arg);
            no++;
        }
        String[] array = new String[list.size()];
        return ((String[])list.toArray(array));
    }

    public URL[] getArgumentsAsURLFromFileOrURL()
        throws MalformedURLException {

        Object[] args = getArguments();
        URL[] urls = new URL[args.length];
        for (int i = 0;i < args.length;i++) {
            urls[i] = UURL.getURLFromFileOrURLName(args[i].toString());
        }
        return (urls);
    }
}
