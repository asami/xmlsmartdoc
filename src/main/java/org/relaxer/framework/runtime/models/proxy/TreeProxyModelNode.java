/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.proxy;

import org.relaxer.framework.runtime.model.AbstractRTreeModelNode;
import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;

/**
 * TreeProxyModelNode
 *
 * @since   Aug.  9, 2005
 * @version Aug. 16, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class TreeProxyModelNode extends AbstractRTreeModelNode {
    private final TreeProxyModel treeProxyModel_;
    private final IRTreeModelNode original_;

    public TreeProxyModelNode(IRTreeModelNode original, TreeProxyModel model) {
        super(original.getName(), model);
        original_ = original;
        treeProxyModel_ = model;
    }

    protected IRDataSource _getDataSource() throws RModelException {
        return original_.getDataSource();
    }

    protected String _getSuffix() throws RModelException {
        return original_.getSuffix();
    }

    protected IRModelContent _loadContent() throws RModelException {
        return original_.getContent();
    }

    protected void _commitDirtyTree() throws RModelException {
        original_.setContent(getContent());
        original_.commit();
    }

    protected IRTreeModelNode[] _loadChildren() throws RModelException {
        IRTreeModelNode[] children = original_.getChildren();
        IRTreeModelNode[] result = new IRTreeModelNode[children.length];
        for (int i = 0;i < children.length;i++) {
            result[i] = new TreeProxyModelNode(children[i], treeProxyModel_);
        }
//        mount(); 
        return result;
    }
}
