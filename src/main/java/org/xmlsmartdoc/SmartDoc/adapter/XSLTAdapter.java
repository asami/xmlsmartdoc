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

import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.beans.IntrospectionException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;
import org.w3c.dom.*;
import com.AsamiOffice.jaba2.util.PropertyList;
import com.AsamiOffice.jaba2.beans.UBean;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.xml.XSLTBeans;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * XSLTAdapter
 *
 * @since   Aug.  4, 2000
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class XSLTAdapter extends AbstractAdapter {
    // AbstractAdapter
    protected Content[] _expand(
        String[] srcs,
        String param,
        Content content,
        Content[] contents,
        DocContext context) {
        String inputURI = srcs[0];
        String xsltURI = UString.checkNull(content.getAttribute("xsltURI"));
        String xsltParams =
            UString.checkNull(content.getAttribute("xsltParams"));
        String xsltProperties =
            UString.checkNull(content.getAttribute("xsltProperties"));
        String xsltSmartDoc =
            UString.checkNull(content.getAttribute("xsltSmartDoc"));
        boolean moreSmartDoc = "true".equals(xsltSmartDoc);
        if (inputURI == null) {
            return (null);
        }
        try {
            XSLTBeans beans = new XSLTBeans();
            beans.setInputURI(inputURI);
            beans.setXSLURI(xsltURI);
            if (xsltParams != null) {
                PropertyList pl = new PropertyList(xsltParams);
                String[] keys = pl.getKeys();
                for (int i = 0; i < keys.length; i++) {
                    String key = keys[i];
                    beans.setStylesheetParam(key, (String)pl.get(key));
                }
            }
            if (xsltProperties != null) {
                PropertyList pl = new PropertyList(xsltProperties);
                UBean.setProperties(beans, pl);
            }
            Document doc = beans.getTargetDocument();
            if (moreSmartDoc) {
                Element root = doc.getDocumentElement();
                if ("doc".equals(root.getTagName())) {
                    SmartDocModel model =
                        SmartDocContext.getContext().getModel();
                    contents =
                        UDoc.importSmartDoc(doc, content, context, model);
                } else {
                    contents = UDoc.makeContentsSmartDoc(root);
                }
            } else {
                contents = UDoc.makeContents(doc.getDocumentElement());
            }
        } catch (IllegalAccessException e) {
            return (UDoc.makeContentsFromException(e));
        } catch (InvocationTargetException e) {
            return (UDoc.makeContentsFromException(e));
        } catch (IntrospectionException e) {
            return (UDoc.makeContentsFromException(e));
        } catch (IOException e) {
            return (UDoc.makeContentsFromException(e));
        } catch (SAXException e) {
            return (UDoc.makeContentsFromException(e));
        } catch (ParserConfigurationException e) {
            return (UDoc.makeContentsFromException(e));
        } catch (TransformerException e) {
            return (UDoc.makeContentsFromException(e));
        }
        return (contents);
    }
}
