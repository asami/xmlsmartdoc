/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.w3c.dom.Node;

/**
 * IRTreeModelNode
 *
 * @since   Mar.  3, 2004
 * @version Sep. 30, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRTreeModelNode extends IRModelNode {
    String getPathName() throws RModelException;
    boolean isRoot() throws RModelException;
    boolean isContainer() throws RModelException;
    //
    IRTreeModelNode getParent() throws RModelException;
    IRTreeModelNode setParent(IRTreeModelNode parent) throws RModelException;
    IRTreeModel getModel() throws RModelException;
    //
    int getLength();
    IRTreeModelNode[] getChildren() throws RModelException;
    IRTreeModelNode addChild() throws RModelException;
    IRTreeModelNode addChild(String name) throws RModelException;
    IRTreeModelNode addChild(IRTreeModelNode node) throws RModelException;
    IRTreeModelNode getNode(String pathName) throws RModelException;
    IRTreeModelNode addNode(String pathName) throws RModelException;
    IRTreeModelNode addNode(String pathName, IRModelContent content)
        throws RModelException;
    IRTreeModelNode addNodeBinary(String pathName, byte[] content)
        throws RModelException;
    IRTreeModelNode addNodeString(String pathName, String content)
        throws RModelException;
    IRTreeModelNode addNodeXml(String pathName, Node content)
        throws RModelException;
    IRTreeModelNode addNodeObject(String pathName, Object content)
        throws RModelException;
    IRTreeModelNode removeChild(String pathName) throws RModelException;
    IRTreeModelNode removeChild(IRTreeModelNode child) throws RModelException;
    void removeChildren() throws RModelException;
    //
    IRTreeModelNode copyChild(IRTreeModelNode child) throws RModelException;
    IRTreeModelNode copyNode(String pathName, IRTreeModelNode child)
       throws RModelException;
    //
    boolean start(IRTreeModelVisitor visitor) throws RModelException;
    void end(IRTreeModelVisitor visitor) throws RModelException;
    boolean enter(IRTreeModelVisitor visitor) throws RModelException;
    boolean visit(IRTreeModelVisitor visitor, 
        int index, IRTreeModelNode prev, IRTreeModelNode next) throws RModelException;
    void leave(IRTreeModelVisitor visitor) throws RModelException;
}
