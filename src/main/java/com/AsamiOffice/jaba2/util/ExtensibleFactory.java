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

package com.AsamiOffice.jaba2.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.xml.IProcessor;
import com.AsamiOffice.jaba2.xml.ProcessorFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.AsamiOffice.io.UURL;
import com.AsamiOffice.util.*;
import com.AsamiOffice.xml.UDOM;

/**
 * ExtensibleFactory
 *
 * @since   Jul. 22, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class ExtensibleFactory {
    protected ArrayMap entries_ = new ArrayMap();
    protected ClassLoader loader_ = null;

    protected ExtensibleFactory() {
    }

    public ExtensibleFactory(String resource, Class clazz)
        throws IOException {

        _setup(clazz.getResource(resource));
    }

    public ExtensibleFactory(String filename) throws IOException {
        _setup(UURL.getURLFromFileOrURLName(filename));
    }

    public ExtensibleFactory(URL url) throws IOException {
        _setup(url);
    }

    protected void _setup(URL url) throws IOException {
        append(url);
    }

    public void addClassLoader(ClassLoader loader) {
        loader_ = loader;
    }

    public void append(URL url) throws IOException {
/*
  Parser parser = new Parser(url.toString());
  Document doc = parser.readStream(url.openStream());
*/
        IProcessor processor = ProcessorFactory.getProcessor();
        Document doc = processor.parseDocument(url);
        NodeList nodes = doc.getDocumentElement().getChildNodes();
        int size = nodes.getLength();
        for (int i = 0;i < size;i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element= (Element)node;
                String tagName = element.getTagName();
                if ("entry".equals(tagName)) {
                    Entry entry = new Entry();
                    entry.name = UDOM.findData(element, "name");
                    String className = UDOM.findData(element, "class");
                    if (UString.isNull(className)) {
                        entry.clazz = null;
                    } else {
                        String loaderName = UDOM.findData(
                            element,
                            "classpath"
                        );
                        if (UString.isNull(loaderName)) {
                            try {
                                entry.clazz = Class.forName(className);
                            } catch (ClassNotFoundException e) {
                                try {
                                    if (loader_ != null) {
                                        entry.clazz = Class.forName(
                                            className,
                                            true,
                                            loader_
                                        );
                                    } else {
                                        entry.error = e.getMessage();
                                    }
                                } catch (ClassNotFoundException ee) {
                                    entry.error = ee.getMessage();
                                } catch (NoClassDefFoundError ee) {
                                    entry.error = ee.getMessage();
                                }
                            } catch (NoClassDefFoundError ee) {
                                entry.error = ee.getMessage();
                            }
                        } else {
                            URL loaderURL = UURL.getURLFromFileOrURLName(
                                loaderName
                            );
                            ClassLoader loader = new URLClassLoader(
                                new URL[] { loaderURL }
                            );
                            try {
                                entry.clazz = Class.forName(
                                    className,
                                    true,
                                    loader
                                );
                            } catch (ClassNotFoundException ee) {
                                entry.error = ee.getMessage();
                            } catch (NoClassDefFoundError ee) {
                                entry.error = ee.getMessage();
                            }
                        }
                    }
                    entries_.put(entry.name, entry);
                } else {
                    throw (new InternalError());
                }
            }
        }
    }

    public Class getTargetClass(String name) {
        Entry entry = (Entry)entries_.get(name);
        if (entry == null) {
            try {
                return (Class.forName(name));
            } catch (ClassNotFoundException e) {
                return (null);
            } catch (NoClassDefFoundError ee) {
                return (null);
            }
        }
        return (entry.clazz);
    }

    public Object getTargetObject(String name) {
        Class clazz = getTargetClass(name);
        if (clazz == null) {
            return (null);
        }
        Object object = null;
        try {
            object = clazz.newInstance();
        } catch (InstantiationException e) {
            throw (new InternalError());
        } catch (IllegalAccessException e) {
            throw (new InternalError());
        }
        return (object);
    }

    public Object[] getTargetObjects() {
        List list = new ArrayList();
        int size = entries_.size();
        for (int i = 0;i < size;i++) {
            Entry entry = (Entry)entries_.get(i);
            try {
                if (entry.clazz != null) {
                    list.add(entry.clazz.newInstance());
                }
            } catch (InstantiationException e) {
                throw (new InternalError());
            } catch (IllegalAccessException e) {
                throw (new InternalError());
            }
        }
        return (list.toArray());
    }

    static class Entry {
        public String name;
        public Class clazz;
        public String error;
    }
}
