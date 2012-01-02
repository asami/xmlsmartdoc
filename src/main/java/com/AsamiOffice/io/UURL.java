/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

package com.AsamiOffice.io;

import java.io.*;
import java.net.*;

import com.AsamiOffice.text.UString;

/**
 * URL is a utility for URL.
 *
 * @since   Mar. 23, 1998
 * @version Arp.  9, 2005
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public final class UURL {
    public static URL getURLFromUri(String uri) throws MalformedURLException {

        try {
            return (new URL(uri));
        } catch (MalformedURLException e) {
        }
        return (getURLFromFilename(uri));
    }

    public static URL getURLFromFilename(String filename)
        throws MalformedURLException {

        return (getURLFromFile(new File(filename)));
    }

    /**
     * Convert file name or URL name to URL. Name's kind is detected
     * automatically.
     *
     * @param name  file name or URL name.
     * @return URL
     */
    public static URL getURLFromFileOrURLName(String name)
        throws MalformedURLException {

        try {
            //	    if (name.startsWith("jdbc:")) {
            //          return (new URL(null, name, new JDBCStreamHandler()));
            //	    }
            return (new URL(name));
        } catch (MalformedURLException e) {
        }
        return (getURLFromFileName(name));
    }

    /**
     * Convert URL name to URL.
     *
     * @param urlName  URL name to convert
     * @return URL
     */
    public static URL getURLFromURLName(String urlName)
        throws MalformedURLException {

        return (new URL(urlName));
    }

    /**
     * Convert file name to URL.
     *
     * @param filename  file name to convert
     * @return URL
     * @exception MalformedURLException filename is not valid file name form.
     */
    public static URL getURLFromFileName(String filename)
        throws MalformedURLException {

        return (getURLFromFile(new File(filename)));
    }

    /**
     * Convert file name to URL.
     *
     * @param file  file to convert
     * @return URL
     */
    public static URL getURLFromFile(File file) throws MalformedURLException {
        URL url = file.toURL();
        String name = url.toExternalForm();
        if (name.indexOf('%') == -1) {
            return (url);
        } else { // avoids File's bug
            StringBuffer sb = new StringBuffer();
            char[] chars = name.toCharArray();
            for (int i = 0;i < chars.length;i++) {
                char c = chars[i];
                if (c == '%') {
                    sb.append("%25");
                } else {
                    sb.append(c);
                }
            }
            return (new URL(sb.toString()));
        }
    }

    /**
     * Convert resource name to URL.
     * <br>
     * This method uses a ClassLoader specified by the parameter clazz
     * to access the resource.
     *
     * @param resourceName  resource name to convert
     * @param clazz  class related resource.
     * @return URL
     */
    public static URL getURLFromResourceName(
        String resourceName,
        ClassLoader loader
    ) {
        URL url = loader.getResource(resourceName);
        if (url != null) {
            return (url);
        }
	if (resourceName.startsWith("/")) {
	    resourceName = resourceName.substring(1);
	} else {
            resourceName = "/" + resourceName;
        }
        return (loader.getResource(resourceName));
    }

    /**
     * Convert resource name to URL.
     * <br>
     * This method uses a ClassLoader specified by the parameter clazz
     * to access the resource.
     *
     * @param resourceName  resource name to convert
     * @param clazz  class related resource.
     * @return URL
     */
    public static URL getURLFromResourceName(
        String resourceName,
        Class clazz) {
        return (getURLFromResourceName(resourceName, clazz.getClassLoader()));
    }

    /**
     * Convert resource name to URL.
     * <br>
     * This method uses a ClassLoader specified by the parameter object
     * to access the resource.
     *
     * @param resourceName  resource name to convert
     * @param object  object related resource.
     * @return URL
     */
    public static URL getURLFromResourceName(
        String resourceName,
        Object object) {
        return (getURLFromResourceName(resourceName, object.getClass()));
    }

    public static boolean isURL(String src) {
        try {
            URL url = new URL(src);
            return (true);
        } catch (MalformedURLException e) {
            return (false);
        }
    }

    public static String getLastComponent(URL url) {
        return (UString.getLastComponent(url.toExternalForm()));
    }

    public static String getBaseURI(URL url) {
        String uri = url.toExternalForm();
        return (UString.getContainerPathname(uri) + "/");
    }

    public static File getActiveFile(URL url) {
        String protocol = url.getProtocol();
        if ("file".equals(protocol)) {
            return (new File(url.getFile()));
        } else {
            return (null);
        }
    }

    public static File getActiveFile(String uri) {
        try {
            return (getActiveFile(new URL(uri)));
        } catch (MalformedURLException e) {
            return (null);
        }
    }
    
    public static File getFileFromFileOrURLName(String name) {
        File file = getActiveFile(name);
        if (file != null) {
            return (file);
        }
        return (new File(name));
    }
}
