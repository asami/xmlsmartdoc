/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.relaxer.framework.runtime.model.content.BinaryContent;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.content.ObjectContent;
import org.relaxer.framework.runtime.model.content.StringContent;
import org.relaxer.framework.runtime.model.content.XmlContent;
import org.w3c.dom.Node;

import com.AsamiOffice.text.UString;

/**
 * AbstractRTreeModelNode
 *
 * @since   Mar. 22, 2004
 * @version Oct.  5, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRTreeModelNode extends AbstractRModelNode
  implements IRTreeModelNode {
    private IRTreeModelNode parent_;
    private List children_ = new ArrayList();
    protected final IRTreeModel _treeModel;
    //
//    private Map updates_ = new HashMap();
    private Map removes_ = new HashMap();

    public AbstractRTreeModelNode(IRTreeModel model) {
        super(model);
        _treeModel = model;
    }

    public AbstractRTreeModelNode(String name, IRTreeModel model) {
        super(name, model);
        _treeModel = model;
/*
        if (UString.isNull(name)) {
            throw (new RelaxerFrameworkErrorException());
        }
*/
    }

    protected String _getAdjustedName() {
        if (_name == null) {
            return (null);
        }
        int start = _name.indexOf("${");
        if (start == -1) {
            return (_name); 
        }
        int last = _name.lastIndexOf("}");
        if (last == -1) {
            return (_name);
        }
        String name = _name.substring(start + 2, last);
        String value = _treeModel.getProperty_String(name);
        if (value == null) {
            return (_name);
        }
        return (_name.substring(0, start) + value + _name.substring(last + 1));
    }

    public String getPathName() throws RModelException {
        List list = new ArrayList();
        IRTreeModelNode node = this;
        for (;;) {
            String name = node.getName();
            if (name == null) {
                break;
            }
            list.add(name);
            node = node.getParent();
            if (node == null) {
                throw (new RModelException("Internal Error"));
            }
        }
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = size - 1;i >=0;i--) {
            sb.append("/");
            sb.append((String)list.get(i));
        }
        return (new String(sb));
    }
    
    public boolean isRoot() throws RModelException {
        return (_name == null);
    }

    public boolean isContainer() throws RModelException {
        _fillNode();
        Boolean container = _isContainer();
        if (container != null) {
            return (container.booleanValue());
        }
        return (getContent() == null);
    }

    protected Boolean _isContainer() throws RModelException {
        return (null);
    }

    public final IRTreeModelNode setParent(IRTreeModelNode parent)
      throws RModelException {
        if (parent_ != null) {
            throw (new IllegalStateException());
        }
        parent_ = parent;
        return (parent);
    }

    public final IRTreeModelNode getParent() throws RModelException {
        return (parent_);
    }
    
    public final IRTreeModel getModel() throws RModelException {
        return (_treeModel);
    }

    public int getLength() {
        return (children_.size());
    }

    public final IRTreeModelNode[] getChildren() throws RModelException {
        _fillNode();
        IRTreeModelNode[] result = new IRTreeModelNode[children_.size()];
        return ((IRTreeModelNode[])children_.toArray(result));
    }

    public IRTreeModelNode addChild() throws RModelException {
        return addChild(_treeModel.newNode());
    }

    public IRTreeModelNode addChild(String name) throws RModelException {
        return addChild(_treeModel.newNode(name));
    }

    public IRTreeModelNode addChild(IRTreeModelNode node) throws RModelException {
        if (node.getParent() != null) {
            throw (new RModelException("??"));
        }
        _fillNode();
        _notifyAddChild(node);
        _addChild(node);
        _setDirty();
        return (node);
    }

    public IRTreeModelNode getNode(String pathName) throws RModelException {
        String[] path = UString.getTokens(pathName, "/");
        IRTreeModelNode current = this;
        for (int i = 0;i < path.length;i++) {
            String name = path[i];
            IRTreeModelNode child = getNode_(current, name);
            if (child == null) {
                return (null);
            }
            current = child;
        }
        return (current);
    }
    
    private IRTreeModelNode getNode_(
        IRTreeModelNode node, 
        String name
    ) throws RModelException {
        IRTreeModelNode[] children = node.getChildren();
        for (int i = 0;i < children.length;i++) {
            IRTreeModelNode child = children[i];
            if (name.equals(child.getName())) {
                return (child);
            }
        }
        return (null);
    }

    public IRTreeModelNode addNode(String pathName) throws RModelException {
        String[] path = UString.getTokens(pathName, "/");
        IRTreeModelNode current = this;
        for (int i = 0;i < path.length;i++) {
            String name = path[i];
            IRTreeModelNode child = current.getNode(name);
            if (child == null) {
                child = _treeModel.newNode(name);
                current.addChild(child);
            }
            current = child;
        }
        return (current);
    }

/*
    private void addChildren(IRTreeModelNode[] children)
      throws RModelException {
        if (children == null) {
            return;
        }
        for (int i = 0;i < children.length;i++) {
            addNode(children[i]);
        }
    }
*/

    public IRTreeModelNode addNode(String pathName, IRModelContent content)
      throws RModelException {
        IRTreeModelNode node = addNode(pathName);
        node.setContent(content);
        return (node);
    }

    public IRTreeModelNode addNodeBinary(String pathName, byte[] content)
        throws RModelException {
        
        return (addNode(pathName, new BinaryContent(content, _model.getModelContext())));
    }

    public IRTreeModelNode addNodeString(String pathName, String content)
        throws RModelException {

        return (addNode(pathName, new StringContent(content, _model.getModelContext())));
    }

    public IRTreeModelNode addNodeXml(String pathName, Node content)
        throws RModelException {

        return (addNode(pathName, new XmlContent(content, _model.getModelContext())));
    }

    public IRTreeModelNode addNodeObject(String pathName, Object content)
        throws RModelException {

        return (addNode(pathName, new ObjectContent(content, _model.getModelContext())));
    }

    public final IRTreeModelNode copyChild(IRTreeModelNode child) 
      throws RModelException {
        if (child.getParent() != null) {
            child = importNode(child);
        }
        return (addChild(child));
    }

    public IRTreeModelNode copyNode(String pathName, IRTreeModelNode node)
      throws RModelException {
        IRTreeModelNode newNode = addNode(pathName);
        newNode.setContent(node.getContent());
        IRTreeModelNode[] children = node.getChildren();
        for (int i = 0;i < children.length;i++) {
            newNode.addChild(importNode(children[i]));
        }
        return (newNode);
    }

    protected final void _addChild(IRTreeModelNode child)
      throws RModelException {
        children_.add(child);
        child.setParent(this);
//        updates_.put(child.getName(), child);
        removes_.remove(child.getName());
    }

    protected void _notifyAddChild(IRTreeModelNode child) {
    }

    public IRTreeModelNode importNode(IRTreeModelNode node)
      throws RModelException {
        IRTreeModelNode newNode = _treeModel.newNode(node.getName());
        newNode.setContent(node.getContent());
        IRTreeModelNode[] children = node.getChildren();
        for (int i = 0;i < children.length;i++) {
            newNode.addChild(importNode(children[i]));
        }
        return (newNode);
    }

    public final IRTreeModelNode removeChild(String name) throws RModelException {
        Object[] children = children_.toArray();
        for (int i = 0;i < children.length;i++) {
            IRTreeModelNode child = (IRTreeModelNode)children[i];
            if (name.equals(child.getName())) {
                return (removeChild(child));
            }
        }
        return (null);
    }

    public final IRTreeModelNode removeChild(IRTreeModelNode child)
      throws RModelException {
        boolean result = children_.remove(child);
        if (!result) {
            return (null);
        }
//        updates_.remove(child.getName());
        removes_.put(child.getName(), child);
        _setDirty();
        return (child);
    }
    
    public final void removeChildren() throws RModelException {
        Object[] children = children_.toArray();
        for (int i = 0;i < children.length;i++) {
            IRTreeModelNode child = (IRTreeModelNode)children[i];
            removeChild(child);
        }
    }

/*
    protected final void _commitTree() {
        // XXX : debug - should remove
    }
*/

    protected final void _delete() throws RModelException {
        Object[] children = children_.toArray();
        for (int i = 0; i < children.length; i++) {
            IRTreeModelNode child = (IRTreeModelNode)children[i];
            child.delete();
        }
    }

    protected final void _commitAlways() throws RModelException {
        _commitAlwaysTree();
        Object[] children = children_.toArray();
        for (int i = 0; i < children.length; i++) {
            IRTreeModelNode child = (IRTreeModelNode)children[i];
            child.commit();
        }
    }
    
    protected void _commitAlwaysTree() {
    }

    protected final void _commitDirty() throws RModelException {
        _commitDirtyTree();
    }

    protected void _commitDirtyTree() throws RModelException {
    }

//    protected final IRTreeModelNode[] _getUpdates() {
//        IRTreeModelNode[] result = new IRTreeModelNode[updates_.size()];
//        return ((IRTreeModelNode[])updates_.values().toArray(result));
//    }

    protected final IRTreeModelNode[] _getRemoves() {
        IRTreeModelNode[] result = new IRTreeModelNode[removes_.size()];
        return ((IRTreeModelNode[])removes_.values().toArray(result));
    }

    protected void _rollbackAlways() throws RModelException {
        Object[] children = children_.toArray();
        for (int i = 0; i < children.length; i++) {
            IRTreeModelNode child = (IRTreeModelNode)children[i];
            child.rollback();
        }
    }

    protected void _rollbackDirty() {
    }

    protected final void _dispose() throws RModelException {
        Object[] children = children_.toArray();
        for (int i = 0; i < children.length; i++) {
            IRTreeModelNode child = (IRTreeModelNode)children[i];
            child.dispose();
        }
        removes_.clear();
        _dispose_tree();
    }

    protected void _dispose_tree() {
    }

    public boolean start(IRTreeModelVisitor visitor) throws RModelException {
        return visitor.start(this);
    }

    public void end(IRTreeModelVisitor visitor) throws RModelException {
        visitor.end(this);
    }

    public final boolean enter(IRTreeModelVisitor visitor) throws RModelException {
        return visitor.enter(this);
    }

    public final boolean visit(
        IRTreeModelVisitor visitor, int index, 
        IRTreeModelNode prev, IRTreeModelNode next
    ) throws RModelException {
        return visitor.stay(this, index, prev, next);
    }

    public final void leave(IRTreeModelVisitor visitor) throws RModelException {
        visitor.leave(this);
    }

    protected void _fillSpecificContent() throws RModelException {
        IRTreeModelNode[] children = _loadChildren();
        if (children != null) {
            for (int i = 0;i < children.length;i++) {
                IRTreeModelNode child = children[i];
                _addChild(child);
            }
        } 
    }

    protected IRTreeModelNode[] _loadChildren() throws RModelException {
        return (null);
    }
}
