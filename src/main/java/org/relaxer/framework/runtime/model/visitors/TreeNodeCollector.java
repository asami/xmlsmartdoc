/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model.visitors;

import java.util.ArrayList;
import java.util.List;

import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.RTreeModelVisitorBase;

/**
 * TreeNodeCollector
 *
 * @since   Mar. 22, 2004
 * @version Aug. 23, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class TreeNodeCollector extends RTreeModelVisitorBase {
    List list_ = new ArrayList();

    public IRTreeModelNode[] getNodes() {
        IRTreeModelNode[] result = new IRTreeModelNode[list_.size()];
        return ((IRTreeModelNode[])list_.toArray(result));
    }

    public boolean start(IRTreeModelNode root) throws RModelException {
        enter(root);
        return true;
    }

    public boolean enter(IRTreeModelNode node) throws RModelException {
    	if (!node.isContainer()) {
    		list_.add(node);
    	}
        return (true);
    }
}
