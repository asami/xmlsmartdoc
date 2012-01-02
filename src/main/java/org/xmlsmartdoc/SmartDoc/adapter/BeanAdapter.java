/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.adapter;

import java.beans.Beans;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.DocContext;
import org.xmlsmartdoc.SmartDoc.SmartDoc;
import org.xmlsmartdoc.SmartDoc.UDoc;
import com.AsamiOffice.jaba2.beans.UBean;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.util.PropertyList;

import com.AsamiOffice.io.UURL;

/**
 * BeanAdapter
 *
 * @since   Jun. 28, 2000
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class BeanAdapter extends AbstractAdapter {
    // AbstractAdapter
    protected Content[] _expand(
        String[] srcs,
        String param,
        Content content,
        Content[] contents,
        DocContext context
    ) {
        String beanName = srcs[0];
        String beanProperties = UString.checkNull(
            content.getAttribute("beanProperties")
        );
        String beanTargetProperty = UString.checkNull(
            content.getAttribute("beanTargetProperty")
        );
        String beanClasspath = UString.checkNull(
            content.getAttribute("beanClasspath")
        );
        String beanSmartDoc = UString.checkNull(
            content.getAttribute("beanSmartDoc")
        );
        boolean moreSmartDoc = "true".equals(beanSmartDoc);
        ClassLoader loader = null;
        if (beanClasspath != null) {
            try {
                URL[] urls = _makeUrls(beanClasspath);
                loader = new URLClassLoader(urls);
            } catch (MalformedURLException e) {
                // XXX
            }
        } else {
            loader = context.getConfig().getClassLoader();
        }
        if (loader == null) {
            loader = SmartDoc.class.getClassLoader();
        }
        if (beanName == null) {
            return (null);
        }
        try {
            Object bean = Beans.instantiate(loader, beanName);
            if (beanProperties != null) {
                PropertyList pl = new PropertyList(beanProperties);
                UBean.setProperties(bean, pl);
            }
            Object value;
            if (beanTargetProperty != null) {
                value = UBean.getProperty(bean, beanTargetProperty);
            } else {
                value = bean.toString();
            }
            if (moreSmartDoc) {
                contents = UDoc.makeContentsSmartDoc(value);
            } else {
                contents = UDoc.makeContents(value);
            }
        } catch (IllegalAccessException e) {
            return (UDoc.makeContentsFromException(e));
        } catch (InvocationTargetException e) {
            return (UDoc.makeContentsFromException(e));
        } catch (IntrospectionException e) {
            return (UDoc.makeContentsFromException(e));
        } catch (IOException e) {
            return (UDoc.makeContentsFromException(e));
        } catch (ClassNotFoundException e) {
            return (UDoc.makeContentsFromException(e));
        }
        return (contents);
    }

    // XXX same as JDBCAdapter
    private URL[] _makeUrls(String classpath) throws MalformedURLException {
        String[] tokens = UString.getTokens(classpath, ";");
        URL[] urls = new URL[tokens.length];
        for (int i = 0;i < tokens.length;i++) {
            String token = tokens[i];
            urls[i] = UURL.getURLFromFileOrURLName(token);
        }
        return (urls);
    }
}
