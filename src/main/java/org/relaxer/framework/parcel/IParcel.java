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
package org.relaxer.framework.parcel;

import java.io.File;
import java.util.Collection;
import java.util.Map;


/**
 * IParcel
 *
 * @since   Oct.  1, 2003
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IParcel {
    void close();
    //
    Collection getCollection() throws ParcelException;
    Map getMap() throws ParcelException;
    IRTable getTable();
    IRTree getTree();
    //
    IContent[] getContents() throws ParcelException;
    Object getProperty(String key);
    void setProperty(String key, Object value);
    //
    IContent getContent(String path);
    void setContent(String path, IContent content);
    void setTextContents(String path, Object content);
    //
    void setNameVariable(String name, String value);
    //
    Object getProperty(String path, String key);
    void setProperty(String path, String key, Object value);
    //
    void moveFiles(File dir) throws ParcelException;
    void moveFiles(File dir, IParcelNodeFilter filter) throws ParcelException;
    void copyFiles(File dir) throws ParcelException;
    void copyFiles(File dir, IParcelNodeFilter filter) throws ParcelException;
}
