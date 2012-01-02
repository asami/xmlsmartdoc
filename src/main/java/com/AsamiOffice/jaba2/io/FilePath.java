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

package com.AsamiOffice.jaba2.io;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.AsamiOffice.io.UFile;

/**
 * FilePath
 *
 * FilePath is immutable.
 *
 * @since   Feb. 12, 1998
 * @version Oct. 19, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class FilePath implements Cloneable, Comparable {
    protected List path_ = new ArrayList(); // List<String>
    protected boolean isAbsolute_ = false;

    public FilePath() {
        _init();
    }

    /**
     * FilePath detects file path type automatically.
     *
     * <ol>
     * <li> if the path contains backslash, windows style
     * <li> otherwise, unix style (includes jaba2 style)
     * </ol>
     */
    public FilePath(String file) {
        _init();
        if (file.indexOf("\\") != -1) {
            _initWindowsStyle(file);
        } else {
            _initUNIXStyle(file);
        }
    }

    public FilePath(File file) {
        this(file.getPath());
    }

    public FilePath(File dir, String file) {
        this(dir);
        path_.add(file);
    }

    public FilePath(FilePath dir, String file) {
        _init();
        int size = dir.path_.size();
        for (int i = 0; i < size; i++) {
            path_.add(dir.path_.get(i));
        }
        path_.add(file);
    }

    private void _init() {
    }

    private void _initWindowsStyle(String file) {
        int index = file.indexOf(":");
        if (index == -1) {
            if (file.charAt(0) == '\\') {
                isAbsolute_ = true;
            } else {
                isAbsolute_ = false;
            }
        } else {
            isAbsolute_ = true;
            String drive = file.substring(0, index);
            file = file.substring(index + 1);
            path_.add(drive);
        }
        _addPath(file, "\\");
    }

    private void _initUNIXStyle(String file) {
        if (file.charAt(0) == '/') {
            isAbsolute_ = true;
        } else {
            isAbsolute_ = false;
        }
        _addPath(file, "/");
    }

    private void _addPath(String file, String separator) {
        StringTokenizer st = new StringTokenizer(file, separator);
        while (st.hasMoreTokens()) {
            path_.add(st.nextToken());
        }
    }

    public FilePath getParent() {
        FilePath parent = new FilePath();
        int size = path_.size() - 1;
        for (int i = 0; i < size; i++) {
            parent.path_.add(path_.get(i));
        }
        parent.isAbsolute_ = isAbsolute_;
        return (parent);
    }

    public String getPath() {
        return (getPath(System.getProperty("file.separator")));
    }

    public FilePath[] getFilePaths() {
        int size = path_.size();
        FilePath[] paths = new FilePath[size];
        if (size > 0) {
            FilePath path = new FilePath((String)path_.get(0));
            paths[0] = path;
            for (int i = 1; i < size; i++) {
                path = new FilePath(path, (String)path_.get(i));
                paths[i] = path;
            }
        }
        return (paths);
    }

    public File[] getFiles() {
        FilePath[] paths = getFilePaths();
        File[] files = new File[paths.length];
        for (int i = 0; i < paths.length; i++) {
            files[i] = paths[i].getFile();
        }
        return (files);
    }

    public File getFile() {
        String separator = System.getProperty("file.separator"); // XXX
        if ("/".equals(separator)) {
            return (new File(getPathAsUNIX()));
        } else if ("\\".equals(separator)) {
            return (new File(getPathAsWindows()));
        } else {
            return (new File(getPathAsUNIX()));
        }
    }

    public String getPath(String separator) {
        StringBuffer buffer = new StringBuffer();
        int size = path_.size();
        if (size > 0) {
            if (isAbsolute_) {
                buffer.append(separator);
            }
            buffer.append(path_.get(0));
            for (int i = 1; i < size; i++) {
                buffer.append(separator);
                buffer.append(path_.get(i));
            }
        }
        return (new String(buffer));
    }

    public String getPathAsUNIX() {
        return (getPath("/"));
    }

    public String getPathAsWindows() {
        StringBuffer buffer = new StringBuffer();
        int size = path_.size();
        if (size > 0) {
            if (isAbsolute_) {
                String first = (String)path_.get(0);
                if (first.length() == 1) {
                    buffer.append(first);
                    buffer.append(":");
                } else {
                    buffer.append("C:\\");
                    buffer.append(first);
                }
            } else {
                buffer.append(path_.get(0));
            }
            for (int i = 1; i < size; i++) {
                buffer.append("\\");
                buffer.append(path_.get(i));
            }
        }
        return (new String(buffer));
    }

    public String getPathAsWindowsWithQuote() {
        StringBuffer buffer = new StringBuffer();
        int size = path_.size();
        if (size > 0) {
            if (isAbsolute_) {
                buffer.append(path_.get(0));
                buffer.append(":");
            }
            for (int i = 1; i < size; i++) {
                buffer.append("\\\\");
                buffer.append(path_.get(i));
            }
        }
        return (new String(buffer));
    }

    public URL getURL() throws MalformedURLException {
        return (getFile().toURL());
    }

    public String getLastComponent() {
        return ((String)path_.get(path_.size() - 1));
    }

    public String getLastComponentBody() {
        String filename = getLastComponent();
        return (filename.substring(0, filename.lastIndexOf(".")));
    }

    public String getSuffix() {
        return (UFile.getSuffix(getLastComponent()));
    }

    public FilePath changeSuffix(String suffix) {
        FilePath newPath = (FilePath)clone();
        List list = newPath.path_;
        int size = list.size();
        String filename = (String)list.get(size - 1); // XXX : Use UString
        int index = filename.lastIndexOf(".");
        if (index != -1) {
            filename = filename.substring(0, index);
        }
        filename = filename + "." + suffix;
        list.set(size - 1, filename);
        return (newPath);
    }

    public FilePath changeLastComponent(String component) {
        FilePath newPath = (FilePath)clone();
        List list = newPath.path_;
        list.set(list.size() - 1, component);
        return (newPath);
    }

    // Object
    public String toString() {
        return (getPath());
    }

    // Cloneable
    public Object clone() {
        FilePath cloned = null;
        try {
            cloned = (FilePath)super.clone();
            cloned.path_ = new ArrayList(path_);
        } catch (CloneNotSupportedException e) {
        }
        return (cloned);
    }

    // Comparable
    public int compareTo(Object o) {
        return (toString().compareTo(o.toString()));
    }
}
