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
import org.w3c.dom.Node;

/**
 * IDatatype
 *
 * @since   Jan.  5, 2003
 * @version Jan. 23, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IDatatype {
    String getName();
    Class getJavaClass();
    boolean isValid(String text);
    boolean isValid(Node xml);
    boolean isValid(Object object);
    String getTextByXml(Node xml);
    String getTextByObject(Object object);
    Node getXmlByText(String text, Document factory);
    Node getXmlByObject(Object value, Document factory);
    Object getObjectByText(String text);
    Object getObjectByXml(Node xml);
}
