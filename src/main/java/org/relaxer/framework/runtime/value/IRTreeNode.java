package org.relaxer.framework.runtime.value;

/**
 * IRTreeNode
 *
 * @since   Oct. 29, 2005
 * @version Oct. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRTreeNode {
    String getPathName();
    boolean isRoot();
    boolean isContainer();
    boolean isLeaf();
    //
    IRTreeNode getParent();
    Object getContent();
    //
    int getLength();
    IRTreeNode[] getChildren();
    IRTreeNode addChild();
    IRTreeNode addChild(String name);
    IRTreeNode addChild(IRTreeNode node);
    IRTreeNode getNode(String pathName);
    IRTreeNode addNode(String pathName);
    IRTreeNode addNode(String pathName, Object content);
    IRTreeNode removeChild(String pathName);
    IRTreeNode removeChild(IRTreeNode child);
    void removeChildren();
    // move
    //
    IRTreeNode copyChild(IRTreeNode child);
    IRTreeNode copyNode(String pathName, IRTreeNode child);
    //
    boolean start(IRTreeVisitor visitor);
    void end(IRTreeVisitor visitor);
    boolean enter(IRTreeVisitor visitor);
    boolean stay(IRTreeVisitor visitor, 
            int index, IRTreeNode prev, IRTreeNode next);
    void leave(IRTreeVisitor visitor);
}
