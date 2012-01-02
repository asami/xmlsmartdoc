/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2005  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.value.IRList;
import org.relaxer.framework.runtime.values.PlainList;

/**
 * AbstractRListModel
 *
 * @since   Mar. 18, 2004
 * @version Nov. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRListModel extends AbstractRModel
  implements IRListModel {
    private final List nodes_;
    
    protected AbstractRListModel(IRModelContext context) throws RModelException {
        this(Collections.EMPTY_MAP, context);
    }

    protected AbstractRListModel(Map properties, IRModelContext context) throws RModelException {
        this(new ArrayList(), properties, context);
    }

/*    
        protected AbstractRListModel(IRModelContent content, IRModelContext context) {
        this(content, Collections.EMPTY_MAP, context);
    }

    protected AbstractRListModel(IRModelContent content, Map properties, IRModelContext context) {
        super(content, properties, context);
        nodes_ = new ArrayList();
    }
*/

    protected AbstractRListModel(List container, Map properties, IRModelContext context) throws RModelException {
        super(properties, context);
        nodes_ = container;
    }

    public IRModelNode[] getNodes() throws RModelException {
        IRModelNode[] result = new IRModelNode[nodes_.size()];
        return ((IRModelNode[])nodes_.toArray(result));
    }

    public void addNode(IRModelNode node) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
        
    }
    public void addContent(IRModelContent content) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
    }

    public void addModel(IRModel model) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
    }

    public IRList getList() throws RModelException {
        return new PlainList(nodes_);
    }

    public void setListModel(IRListModel list) throws RModelException {
        _setDirty();
        nodes_.clear();
        addListModel(list);
    }

    private void addListModel(IRListModel list) throws RModelException {
        _setDirty();
        nodes_.addAll(list.getList());
    }

    public void traverse(IRListVisitor visitor) throws RModelException {
        Object[] nodes = nodes_.toArray();
        for (int i = 0;i < nodes.length;i++) {
            IRModelNode node = (IRModelNode)nodes[i];
            node.accept(visitor, i);
        }
    }

    public void traverse(IRListVisitor visitor, IRNodeFilter filter)
      throws RModelException {
        Object[] nodes = nodes_.toArray();
        for (int i = 0;i < nodes.length;i++) {
            IRModelNode node = (IRModelNode)nodes[i];
            if (filter.accept(node)) {
                node.accept(visitor, i);
            }
        }
    }
}
