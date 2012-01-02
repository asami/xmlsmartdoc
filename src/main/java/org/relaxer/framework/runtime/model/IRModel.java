/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
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
package org.relaxer.framework.runtime.model;

import java.util.Map;

import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * IRModel
 *
 * @since   Dec. 25, 2003
 * @version Aug. 17, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRModel {
    String PROPERTY_NODE = "node"; 
    String PROPERTY_CONTENT = "content";
    String PROPERTY_DATASOURCE = "datasource";
    String PROPERTY_FILE = "file"; 
    String PROPERTY_URL = "url";

    String getName();
    void open() throws RModelException;
    void close() throws RModelException;
    void commit() throws RModelException;
    void rollback() throws RModelException;
    void create() throws RModelException;
    void delete() throws RModelException;
    IRModelContent getModelContent() throws RModelException;
    boolean isDirty();
    //
    IRModelContext getModelContext();
//    void setTextEncoding(String encoding);
//    String getTextEncoding();
    //
    void setProperty(String name, Object value);
    Object getProperty(String name);
	String getProperty_String(String name);
    Map getProperties();
    void setProperties(Map properties);
}
