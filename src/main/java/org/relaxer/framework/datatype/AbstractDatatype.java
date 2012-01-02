/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.framework.datatype;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.AsamiOffice.xml.UDOM;

/**
 * Datatype
 *
 * @since   Jan.  5, 2003
 * @version Jan.  6, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractDatatype implements IDatatype {
    private String name_;

    public AbstractDatatype(String name) {
        name_ = name;
    }
    
    public final String getName() {
        return (name_);
    }

    public boolean isValid(String text) {
        return (isValid(getObjectByText(text)));
    }

    public boolean isValid(Node xml) {
        return (isValid(getTextByXml(xml)));
    }

    // extension point
    public boolean isValid(Object object) {
        return (true);
    }

    // extension point
    public String getTextByObject(Object value) {
        return (value.toString());
    }

    // extension point
    public Object getObjectByText(String text) {
        return (text);
    }

    public String getTextByXml(Node xml) {
        return (_convertText(xml));
    }

    public Node getXmlByText(String text, Document factory) {
        return (factory.createTextNode(text));
    }

    public Node getXmlByObject(Object value, Document factory) {
        return (getXmlByText(getTextByObject(value), factory));
    }

    public Object getObjectByXml(Node xml) {
        return (getObjectByText(getTextByXml(xml)));
    }

    protected final String _convertText(Node xml) {
        if (xml instanceof Text) {
            return (xml.getNodeValue());
        } else if (xml instanceof DocumentFragment){
            StringBuffer sb = new StringBuffer();
            NodeList children = xml.getChildNodes();
            int size = children.getLength();
            for (int i = 0;i < size;i++) {
                Node child = children.item(i);
                if (child instanceof Text) {
                    sb.append(child.getNodeValue());
                } else {
                    return (null);
                }
            }
            return (new String(sb));
        } else {
            return (null);
        }
    }
}
