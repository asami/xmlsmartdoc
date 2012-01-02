package org.relaxer.framework.runtime.value;

/**
 * IRMutableTree
 *
 * @since   Oct. 18, 2005
 * @version Oct. 30, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRMutableTree extends IRTree {
    void setTree(IRTree tree);
    IRTreeNode addNode(String path);
    IRTreeNode addNode(String path, Object content);
    IRTreeNode removeNode(String path);
    //
    IRTreeNode newNode(String name);
}
