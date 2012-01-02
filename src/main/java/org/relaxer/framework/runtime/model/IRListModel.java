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

import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.value.IRList;

/**
 * IRListModel
 *
 * @since   Jan.  7, 2004
 * @version Oct. 29, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRListModel extends IRModel {
    IRModelNode[] getNodes() throws RModelException;
    void addNode(IRModelNode node) throws RModelException;
    void addContent(IRModelContent content) throws RModelException;
    void addModel(IRModel model) throws RModelException;
    // IRList<IRModelNode>
    IRList getList() throws RModelException;
    void setListModel(IRListModel list) throws RModelException;
    void traverse(IRListVisitor visitor) throws RModelException;
    void traverse(IRListVisitor visitor, IRNodeFilter filter) throws RModelException;
}
