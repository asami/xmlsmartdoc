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

import java.util.Iterator;
import java.util.List;

import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.value.IRTree;
import org.w3c.dom.Node;

import com.AsamiOffice.util.TreeTable;

/**
 * IRTreeModel
 *
 * @since   Jan.  7, 2004
 * @version Oct. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRTableModel extends IRModel {
    int getWidth() throws RModelException;
    int getHeight() throws RModelException;
    IRModelNode get(int x, int y) throws RModelException;
    Iterator getRecordIterator(int y) throws RModelException;
    List getRecordList(int y) throws RModelException;
    Object[] getRecordArray(int y) throws RModelException;
    // XXX
    IRModelRecord getRecord(int y) throws RModelException;
    //
    void set(int x, int y, IRModelNode node) throws RModelException;
    void setContent(int x, int y, IRModelContent content) throws RModelException;
    void setBinary(int x, int y, byte[] content) throws RModelException;
    void setString(int x, int y, String content) throws RModelException;
    void setXml(int x, int y, Node content) throws RModelException;
    void setObject(int x, int y, Object content) throws RModelException;
    void setRecordList(int y, List record) throws RModelException;
    void addRecordList(List record) throws RModelException;
    void setRecordArray(int y, Object[] record) throws RModelException;
    void addRecordArray(Object[] record) throws RModelException;
    // XXX
    void setRecord(int y, IRModelRecord record) throws RModelException;
    // XXX
    void addRecord(IRModelRecord record) throws RModelException;
    // void addList(IRModelList list) throws RModelException;
    void setHead(IRTree head) throws RModelException;
    void setHead(String[] head) throws RModelException;
    void setHead(List head) throws RModelException;
    IRTree getHead() throws RModelException;
//    void addHeadList(List head) throws RModelException;
//    void addHeadArray(Object[] head) throws RModelException;
    // XXX
//    void setHead(IRModelRecord record) throws RModelException;
    // XXX
//    void addHead(IRModelRecord record) throws RModelException;
    void setTable(IRTableModel tableModel) throws RModelException;
    void traverse(IRTableVisitor visitor) throws RModelException;
    void traverse(IRTableVisitor visitor, IRNodeFilter filter)
      throws RModelException;
}
