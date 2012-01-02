/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1999  ASAMI, Tomoharu (tasami@ibm.net)
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

package com.AsamiOffice.jaba2.io;

import java.util.StringTokenizer;
import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;

/**
 * FilePathList
 *
 * @since   Mar. 12, 1998
 * @version Sep. 17, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class FilePathList {
    protected FilePath[] list_;

    /**
     * FilePathList detects file path list type automatically.
     *
     * <ol>
     * <li> if the path list contains backslash, windows style
     * <li> if the path list contains semicolon, jaba2 style
     * <li> otherwise, unix style
     * </ol>
     */
    public FilePathList(String pathlist) {
	if (pathlist.indexOf("\\") != -1) {
	    _initWindows(pathlist);
	} else if (pathlist.indexOf(";") != -1) {
	    _initJaba2(pathlist);
	} else {
	    _initUNIX(pathlist);
	}
    }

    private void _initUNIX(String pathlist) {
	_addPath(pathlist, ":");
    }

    private void _initJaba2(String pathlist) {
	_addPath(pathlist, ";");
    }

    private void _initWindows(String pathlist) {
	_addPath(pathlist, ";");
    }

    private void _addPath(String pathlist, String separator) {
	StringTokenizer st = new StringTokenizer(pathlist, separator);
	int nTokens = st.countTokens();
	list_ = new FilePath[nTokens];
	int i = 0;
	while (st.hasMoreTokens()) {
	    list_[i] = new FilePath(st.nextToken());
	    i++;
	}
    }

    public FilePath[] getFilePaths() {
	return ((FilePath[])list_.clone());
    }

    public String[] getFilePathStrings() {
	String[] strings = new String[list_.length];
	for (int i = 0;i < list_.length;i++) {
	    strings[i] = list_[i].getPath();
	}
	return (strings);
    }

    public String getFilePathString() {
	String separator = System.getProperty("file.separator");
	if ("/".equals(separator)) { // UNIX
	    return (getFilePathStringAsUNIX());
	} else if ("\\".equals(separator)) {
	    return (getFilePathStringAsWindows());
	} else {
	    return (getFilePathString(File.pathSeparator, File.separator));
	}
    }

    public String getFilePathString(String pathSeparator,
				    String fileSeparator) {
	StringBuffer list = new StringBuffer();
	int i;
	for (i = 0;i < list_.length - 1;i++) {
	    list.append(list_[i].getPath(fileSeparator));
	    list.append(pathSeparator);
	}
	if (i < list_.length) {
	    list.append(list_[i].getPath(fileSeparator));
	}
	return (list.toString());
    }

    public String[] getFilePathStringsAsUNIX() {
	String[] paths = new String[list_.length];
	for (int i = 0;i < list_.length;i++) {
	    paths[i] = list_[i].getPathAsUNIX();
	}
	return (paths);
    }

    public String getFilePathStringAsUNIX() {
	StringBuffer buffer = new StringBuffer();
	if (list_.length > 0) {
	    buffer.append(list_[0].getPathAsUNIX());
	    for (int i = 1;i < list_.length;i++) {
		buffer.append(":");
		buffer.append(list_[i].getPathAsUNIX());
	    }
	}
	return (new String(buffer));
    }

    public String[] getFilePathStringsAsWindows() {
	String[] paths = new String[list_.length];
	for (int i = 0;i < list_.length;i++) {
	    paths[i] = list_[i].getPathAsWindows();
	}
	return (paths);
    }

    public String getFilePathStringAsWindows() {
	StringBuffer buffer = new StringBuffer();
	if (list_.length > 0) {
	    buffer.append(list_[0].getPathAsWindows());
	    for (int i = 1;i < list_.length;i++) {
		buffer.append(";");
		buffer.append(list_[i].getPathAsWindows());
	    }
	}
	return (new String(buffer));
    }

    public String[] getFilePathStringsAsWindowsWithQuote() {
	String[] paths = new String[list_.length];
	for (int i = 0;i < list_.length;i++) {
	    paths[i] = list_[i].getPathAsWindowsWithQuote();
	}
	return (paths);
    }

    public String getFilePathStringAsWindowsWithQuote() {
	StringBuffer buffer = new StringBuffer();
	if (list_.length > 0) {
	    buffer.append(list_[0].getPathAsWindowsWithQuote());
	    for (int i = 1;i < list_.length;i++) {
		buffer.append(":");
		buffer.append(list_[i].getPathAsWindowsWithQuote());
	    }
	}
	return (new String(buffer));
    }

    public URL[] getURLs() throws MalformedURLException {
	URL[] urls = new URL[list_.length];
	for (int i = 0;i < list_.length;i++) {
	    urls[i] = list_[i].getURL();
	}
	return (urls);
    }

    // Object
    public String toString() {
	return (getFilePathString());
    }
}
