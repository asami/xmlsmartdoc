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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import com.AsamiOffice.io.UURL;

/**
 * FileParameterManager
 *
 * @since   Feb. 16, 1998
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class FileParameterManager implements ParameterManager {
    protected Properties properties_ = new Properties();

    public FileParameterManager(String prefix, String[] args) {
        try {
            String urlName = null;
            for (int i = 0;i < args.length;i++) {
                String arg = args[i];
                if (arg.startsWith("-properties:")) {
                    urlName = arg.substring("-properties:".length());
                }
            }
            if (urlName != null) {
                URL url = UURL.getURLFromFileOrURLName(urlName);
                InputStream in = url.openStream();
                _init(in);
                in.close();
            }
        } catch (IOException e) {
        }
    }

    public FileParameterManager(String prefix, String[] args, String name) {
        try {
            String urlName = null;
            for (int i = 0;i < args.length;i++) {
                String arg = args[i];
                if (arg.startsWith("-properties:")) {
                    urlName = arg.substring("-properties:".length());
                }
            }
            if (urlName == null) {
                urlName = name;
            }
            URL url = UURL.getURLFromFileOrURLName(name);
            InputStream in = url.openStream();
            _init(in);
            in.close();
        } catch (IOException e) {
        }
    }

    public FileParameterManager(String prefix, String[] args, File file) {
        try {
            String urlName = null;
            for (int i = 0;i < args.length;i++) {
                String arg = args[i];
                if (arg.startsWith("-properties:")) {
                    urlName = arg.substring("-properties:".length());
                }
            }
            if (urlName != null) {
                URL url = UURL.getURLFromFileOrURLName(urlName);
                InputStream in = url.openStream();
                _init(in);
                in.close();
            } else {
                InputStream in = new FileInputStream(file);
                _init(in);
                in.close();
            }
        } catch (IOException e) {
        }
    }

    public FileParameterManager(String prefix, String name) {
        try {
            URL url = UURL.getURLFromFileOrURLName(name);
            InputStream in = url.openStream();
            _init(in);
            in.close();
        } catch (IOException e) {
        }
    }

    public FileParameterManager(String prefix, File file) {
        try {
            InputStream in = new FileInputStream(file);
            _init(in);
            in.close();
        } catch (IOException e) {
        }
    }

    public FileParameterManager(String prefix, URL url) {
        try {
            InputStream in = url.openStream();
            _init(in);
            in.close();
        } catch (IOException e) {
        }
    }

    private void _init(InputStream in) throws IOException {
        properties_.load(in);
    }

    public boolean isParameter(String key) {
        return (properties_.keySet().contains(key));
    }

    public Object getParameter(String key) {
        return (properties_.getProperty(key));
    }

    public Enumeration getKeys() {
        return (properties_.propertyNames());
    }
}
