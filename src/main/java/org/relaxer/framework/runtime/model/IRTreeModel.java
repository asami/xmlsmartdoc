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
import org.w3c.dom.Node;

/**
 * IRTableModel
 *
 * @since   Jan.  7, 2004
 * @version Oct. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRTreeModel extends IRModel {
    IRTreeModelNode getRoot() throws RModelException;
    IRTreeModelNode getNode(String path) throws RModelException;
    //
    void setTree(IRTreeModel treeModel) throws RModelException;
    IRTreeModelNode addNode(String path) throws RModelException;
    IRTreeModelNode addNode(String path, IRModelContent content)
      throws RModelException;
    IRTreeModelNode addNode(String path, byte[] content)
      throws RModelException;
    IRTreeModelNode addNode(String path, String content)
      throws RModelException;
    IRTreeModelNode addNode(String path, Node content)
      throws RModelException;
    IRTreeModelNode removeNode(String path) throws RModelException;
    //
    IRTreeModelNode copyNode(IRTreeModelNode node) throws RModelException;
    //
    IRTreeModelNode newNode() throws RModelException;
    IRTreeModelNode newNode(String name) throws RModelException;
    //
    void traverse(IRTreeModelVisitor visitor) throws RModelException;
    void traverse(IRTreeModelVisitor visitor, IRNodeFilter filter)
      throws RModelException;
/*
    void setNameVariable(String name, String value);
    String getNameVariableValue(String name);
    String[] getNameVariables();
*/
    // IRListViewModel
    IRModelNode[] getNodes() throws RModelException;
}
