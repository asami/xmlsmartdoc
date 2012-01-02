package org.relaxer.framework.runtime.value;

/**
 * IRTreeVisitor
 *
 * @since   Oct. 29, 2005
 * @version Jan. 24, 2006
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRTreeVisitor {
    boolean start(IRTreeNode node);
    void end(IRTreeNode node);
    boolean enter(IRTreeNode node);
    boolean stay(IRTreeNode node, int index, IRTreeNode prev, IRTreeNode next);
    void leave(IRTreeNode node);
}
