/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

/**
 * IRTreeModelVisitor
 *
 * @since   Mar. 18, 2004
 * @version Oct. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRTreeModelVisitor {
    boolean start(IRTreeModelNode root) throws RModelException;
    void end(IRTreeModelNode root) throws RModelException;
    boolean enter(IRTreeModelNode node) throws RModelException;
    boolean stay(IRTreeModelNode node, 
        int index, IRTreeModelNode prev, IRTreeModelNode next);
    void leave(IRTreeModelNode node) throws RModelException;
}
