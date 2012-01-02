/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package org.relaxer.framework.runtime.model;

import java.io.OutputStream;
import java.util.Map;

import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;
import org.relaxer.framework.runtime.model.visitors.TreeNodeCollector;
import org.w3c.dom.Node;

/**
 * AbstractRTreeModel
 *
 * @since   Jan.  7, 2004
 * @version Sep. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRTreeModel extends AbstractRModel
  implements IRTreeModel {
    protected IRTreeModelNode _root;
//    private Map nameVariables_ = new HashMap();

    public AbstractRTreeModel(IRModelContext context) throws RModelException {
        super(context);
    }

    public AbstractRTreeModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

    public AbstractRTreeModel(IRDataSource dataSource, IRModelContext context) throws RModelException {
        super(dataSource, context);
    }

    protected AbstractRTreeModel(Map properties, IRModelContext context) throws RModelException {
        super(properties, context);
    }

    // same as IRListModel
    public IRModelNode[] getNodes() throws RModelException {
        TreeNodeCollector collector = new TreeNodeCollector();
        traverse(collector);
        return (collector.getNodes());
    }

    protected final IRModelContent _getModelContent() throws RModelException {
        return _getModelContent_tree();
    }

    protected IRModelContent _getModelContent_tree() throws RModelException {
        return null;
    }

    protected final void _writeContent(OutputStream out) throws RModelException {
        _writeContent_tree(out);
    }

    protected void _writeContent_tree(OutputStream out) throws RModelException {
    }

    protected final void _open() throws RModelException {
        _root = makeNewRootNode_();
        _open_tree();
    }

    protected void _open_tree() throws RModelException {
    }
    
    protected final boolean _isDirty() {
        if (_isDirty_tree()) {
            return true;
        }
        if (_root.isDirty()) {
            return true;
        }
        return false;
    }

    protected boolean _isDirty_tree() {
        return false;
    }

    protected final void _commitAlways() throws RModelException {
        _root.commit();
        _commitAlways_tree();
    }

    protected void _commitAlways_tree() throws RModelException {
    }

    protected final void _commitDirty() throws RModelException {
        _commitDirty_tree();
    }

    protected void _commitDirty_tree() throws RModelException {
    }

    protected final void _rollback() throws RModelException {
        _root.rollback();
        _rollback_tree();
    }

    protected void _rollback_tree() throws RModelException {
    }

    protected final void _close() throws RModelException {
        _root.dispose();
        _root = null;
        _close_tree();
    }

    protected void _close_tree() throws RModelException {
    }

    protected final void _create() throws RModelException {
        _root = makeNewRootNode_();
        _create_tree();
    }

    protected void _create_tree() throws RModelException {
    }

    protected final void _delete() throws RModelException {
        _root.delete();
    }

    protected void _delete_tree() throws RModelException {
    }

    // IRTreeModel
    public final IRTreeModelNode getRoot() throws RModelException {
        return (_root);
    }

    public final IRTreeModelNode getNode(String path) throws RModelException {
        if ("/".equals(path)) {
            return (_root);
        } else {
            return (_root.getNode(path));
        }
    }
    
    public final void setTree(IRTreeModel treeModel) throws RModelException {
        _setDirty();
        setupTree_(treeModel);
    }

    private void setupTree_(IRTreeModel source) throws RModelException {
        IRTreeModelNode sourceRoot = source.getRoot();
        IRTreeModelNode targetRoot = getRoot();
        setupTree_(sourceRoot, targetRoot);
    }

    private void setupTree_(IRTreeModelNode source, IRTreeModelNode target) throws RModelException {
        IRTreeModelNode[] sourceChildren = source.getChildren();
        for (int i = 0;i < sourceChildren.length;i++) {
            IRTreeModelNode sourceChild = sourceChildren[i];
            IRTreeModelNode targetChild = target.addNode(sourceChild.getName(), sourceChild.getContent());
            setupTree_(sourceChild, targetChild);
        }
    }

    public final IRTreeModelNode addNode(String path) throws RModelException {
        _setDirty();
        return (_root.addNode(path));
    }

    public final IRTreeModelNode copyNode(IRTreeModelNode node) throws RModelException {
        _setDirty();
        return (_root.copyNode(node.getPathName(), node));
    }

    public final IRTreeModelNode addNode(String path, IRModelContent content) throws RModelException {
        _setDirty();
        return (_root.addNode(path, content));
    }

    public final IRTreeModelNode addNode(String path, IRTreeModelNode node) throws RModelException {
        _setDirty();
        throw (new UnsupportedOperationException());
    }

    public final IRTreeModelNode addNode(String path, byte[] content) throws RModelException {
        _setDirty();
        return (_root.addNodeBinary(path, content));
    }

    public final IRTreeModelNode addNode(String path, String content) throws RModelException {
        _setDirty();
        return (_root.addNodeString(path, content));
    }

    public final IRTreeModelNode addNode(String path, Node content) throws RModelException {
        _setDirty();
        return (_root.addNodeXml(path, content));
    }

    public final IRTreeModelNode removeNode(String path) throws RModelException {
        _setDirty();
        IRTreeModelNode node = getNode(path);
        if (node == null) {
            return (null);
        }
//        System.out.println("removeNode = " + path);
        IRTreeModelNode parent = node.getParent();
        return (parent.removeChild(node));
    }
    
    public final IRTreeModelNode newNode() throws RModelException {
        return newNode("node" + ++counter__);
    }
    
    private static int counter__ = 0;

    public final IRTreeModelNode newNode(String name) throws RModelException {
        IRTreeModelNode newNode = _newNode(name);
        if (newNode != null) {
            return newNode;
        }
        return new SimpleRTreeModelNode(name, this);
    }

    protected  IRTreeModelNode _newNode(String name) throws RModelException {
        return null;
    }

    private IRTreeModelNode makeNewRootNode_() throws RModelException {
        IRTreeModelNode rootNode = _newRootNode();
        if (rootNode != null) {
            return rootNode;
        }
        return new SimpleRTreeModelNode(this);
    }

    protected IRTreeModelNode _newRootNode() throws RModelException {
        return null;
    }

    //
    public final void traverse(IRListVisitor visitor) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public final void traverse(IRListVisitor visitor, IRNodeFilter filter)
        throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public final void traverse(IRTableVisitor visitor) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public final void traverse(IRTableVisitor visitor, IRNodeFilter filter)
        throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public final void traverse(IRTreeModelVisitor visitor) throws RModelException {
        traverseChildren(_root, visitor);
    }

    public final void traverse(IRTreeModelVisitor visitor, IRNodeFilter filter)
      throws RModelException {
        traverseChildren(_root, visitor, filter);
    }

    public final void traverseChildren(IRTreeModelNode node, IRTreeModelVisitor visitor) throws RModelException {
        traverseChildren(node, visitor, null);
    }

    public final void traverseChildren(
        IRTreeModelNode node, 
        IRTreeModelVisitor visitor,
        IRNodeFilter filter
    ) throws RModelException {
        if (filter != null) {
            if (!filter.accept(node)) {
                return;
            }
        }
        if (!node.start(visitor)) {
            return;
        }
        IRTreeModelNode[] children = node.getChildren();
        if (children.length > 0) {
            IRTreeModelNode child = children[0];
            traverse(child, visitor, filter);
            for (int i = 1;i < children.length;i++) {
                IRTreeModelNode prev = child;
                child = children[i];
                if (!node.visit(visitor, i, prev, child)) {
                    return;
                }
                traverse(child, visitor, filter);
            }
        }
        node.end(visitor);
    }

    public final void traverse(IRTreeModelNode node, IRTreeModelVisitor visitor) throws RModelException {
        traverse(node, visitor, null);
    }

    public final void traverse(
        IRTreeModelNode node, 
        IRTreeModelVisitor visitor,
        IRNodeFilter filter
    ) throws RModelException {
        if (filter != null) {
            if (!filter.accept(node)) {
                return;
            }
        }
        if (!node.enter(visitor)) {
            return;
        }
        IRTreeModelNode[] children = node.getChildren();
        if (children.length > 0) {
            IRTreeModelNode child = children[0];
            traverse(child, visitor, filter);
            for (int i = 1;i < children.length;i++) {
                IRTreeModelNode prev = child;
                child = children[i];
                if (!node.visit(visitor, i, prev, child)) {
                    return;
                }
                traverse(child, visitor, filter);
            }
        }
        node.leave(visitor);
    }

    // TODO
    public final void addRecord(IRModelRecord record) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public final IRModelRecord getRecord(int x) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public final void put(int x, int y, IRModelContent content) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public final void putBinary(int x, int y, byte[] content) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public final void putObject(int x, int y, Object content) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public final void putRecord(int x, IRModelRecord record) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public final void putString(int x, int y, String content) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public final void putXml(int x, int y, Node content) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public final void addHead(IRModelRecord record) throws RModelException {
        _setDirty();
        // TODO Auto-generated method stub
    }
/*
    public void setNameVariable(String name, String value) {
        nameVariables_.put(name, value);
    }

    public String getNameVariableValue(String name) {
        return ((String)nameVariables_.get(name));
    }
    
    public String[] getNameVariables() {
        Set keys = nameVariables_.keySet();
        String[] result = new String[keys.size()];
        return ((String[])keys.toArray(result));
    }
*/
    
}
