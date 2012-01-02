package org.relaxer.framework.runtime.value;

import org.relaxer.framework.runtime.model.IRNodeFilter;

/**
 * AbstractRTree
 *
 * @since   Oct. 17, 2005
 * @version Jan. 24, 2006
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRTree implements IRTree {
    public final void traverse(IRTreeVisitor visitor) {
        IRTreeNode root = getRoot();
        root.start(visitor);
        traverse_(root, visitor);
        root.end(visitor);
    }

    private void traverse_(IRTreeNode node, IRTreeVisitor visitor) {
        IRTreeNode[] children = node.getChildren();
        if (children.length == 0) {
            return;
        }
        IRTreeNode child = children[0];
        if (child.enter(visitor)) {
            traverse_(child, visitor);
            child.leave(visitor);
        }
        for (int i = 1;i < children.length - 1;i++) {
            IRTreeNode prev = child;
            IRTreeNode next = children[i + 1];
            child = children[i];
            child.stay(visitor, i, prev, next);
            if (child.enter(visitor)) {
                traverse_(child, visitor);
                child.leave(visitor);
            }
        }
        child = children[children.length - 1];
        if (child.enter(visitor)) {
            traverse_(child, visitor);
            child.leave(visitor);
        }
    }

    public final void traverse(IRTreeVisitor visitor, IRNodeFilter filter) {
        throw new UnsupportedOperationException("AbstractRTree.traverse");
    }
}
