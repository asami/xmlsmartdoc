package org.relaxer.framework.runtime.value;

import org.relaxer.framework.runtime.model.IRNodeFilter;

/**
 * IRTree
 *
 * @since   Oct. 17, 2005
 * @version Nov. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRTree {
    IRTreeNode getRoot();
    IRTreeNode getNode(String path);
    // TODO PathName
    String[] getLeafPathNames();
    //
    void traverse(IRTreeVisitor visitor);
    void traverse(IRTreeVisitor visitor, IRNodeFilter filter);
    ICursor getCursor();
}
