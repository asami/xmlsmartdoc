package org.xmlsmartdoc.SmartDoc.mathml.rParts;

import java.util.*;
import org.w3c.dom.*;

/**
 * IRVisitable
 *
 * @since   Apr. 30, 2000
 * @version Apr. 30, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public final class URVisitor {
    public static void traverse(IRNode node, IRVisitor visitor) {
	traverseDepth(node, visitor);
    }

    public static void traverseDepth(IRNode node, IRVisitor visitor) {
	IRVisitable visitable = (IRVisitable)node;
	visitable.enter(visitor);
	IRNode[] children = node.getRNodes();
	for (int i = 0;i < children.length;i++) {
	    traverseDepth(children[i], visitor);
	}
	visitable.leave(visitor);
    }

    public static void traverseBreadth(IRNode node, IRVisitor visitor) {
	IRVisitable visitable = (IRVisitable)node;
	visitable.enter(visitor);
	traverseBreadthChildren(node, visitor);
	visitable.leave(visitor);
    }

    public static void traverseBreadthChildren(
	IRNode node,
	IRVisitor visitor
    ) {
	IRNode[] children = node.getRNodes();
	for (int i = 0;i < children.length;i++) {
	    IRVisitable visitable = (IRVisitable)children[i];
	    visitable.enter(visitor);
	    visitable.leave(visitor);
	}
	for (int i = 0;i < children.length;i++) {
	    IRNode child = children[i];
	    traverseBreadth(child, visitor);
	}
    }
}
