/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

/**
 * RTreeModelVisitorBase
 *
 * @since   Mar. 22, 2004
 * @version Aug. 20, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RTreeModelVisitorBase implements IRTreeModelVisitor {
    public boolean start(IRTreeModelNode root) throws RModelException {
        return true;
    }

    public void end(IRTreeModelNode root) throws RModelException {
    }

    public boolean enter(IRTreeModelNode node) throws RModelException {
        return (true);
    }

    public boolean stay(IRTreeModelNode node, int index, 
        IRTreeModelNode prev, IRTreeModelNode next) {
        return true;
    }

    public void leave(IRTreeModelNode node) throws RModelException {
    }
}
