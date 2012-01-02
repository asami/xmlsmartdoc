/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.content.StringContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;
import org.w3c.dom.Node;

/**
 * AbstractRModelNode
 *
 * @since   Mar. 18, 2004
 * @version Sep. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRModelNode implements IRModelNode {
    protected final String _name;
    protected final IRModel _model;
    private IRModel mountedModel_ = null;
    private IRModelContent content_ = null;
    //
    private boolean filled_ = false;
    private boolean dirty_ = false;

    protected AbstractRModelNode(IRModel model) {
        this(null, model);
    }

    protected AbstractRModelNode(String name, IRModel model) {
        _name = name;
        _model = model;
    }

    public final IRModel mount() throws RModelException {
        _fillNode();
/*
        if (content_ == null) {
            return null;
        }
*/
        IRModelContext context = _model.getModelContext();
        mountedModel_ = context.mount(this);
        if (mountedModel_ != null) {
            mountedModel_.open();
        }
        return mountedModel_;
    }

    public final IRModel getMountedModel() {
        return mountedModel_;
    }

    public final void unmount() throws RModelException {
        if (mountedModel_ == null) {
            return;
        }
        setContent(mountedModel_.getModelContent());
        // unmount does not invoke the commit method
        mountedModel_.close();
        mountedModel_ = null;
    }

    public final String getSuffix() throws RModelException {
        _fillNode();
        String suffix = _getSuffix();
        if (suffix != null) {
            return suffix;
        }
        if (content_ != null) {
            suffix = content_.getSuffix();
            if (suffix != null) {
                return suffix;
            }
        }
        if (_name != null) {
            int index = _name.lastIndexOf('.');
            return _name.substring(index + 1);
        }
        if (suffix != null) {
            return suffix;
        }
        return null;
    }

    protected String _getSuffix() throws RModelException {
        return null;
    }

    protected final String _getSuffixByName() throws RModelException {
        return null;
    }

    public final IRDataSource getDataSource() throws RModelException {
        IRDataSource ds = _getDataSource();
        if (ds != null) {
            return ds;
        }
        if (content_ != null) {
            return (content_.getDataSource());
        }
        return null;
    }

    protected IRDataSource _getDataSource() throws RModelException {
        return null;
    }

    public final IRModelContent getContent() throws RModelException {
        _fillNode();
        return (content_);
    }

    public final IRModelContent setContent(IRModelContent content)
      throws RModelException {
        _notifySetContent(content);
        _setContent(content);
        _setDirty();
        return (content);
    }

    public IRModelContent setContent(byte[] content) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public IRModelContent setContent(Node content) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public IRModelContent setContent(String content) throws RModelException {
        return setContent(new StringContent(content, _model.getModelContext()));
    }

    protected void _notifySetContent(IRModelContent content) {
    }

    protected final void _setContent(IRModelContent content) throws RModelException {
        if (content_ != null) {
            content_.close();
        }
        content_ = content;
        if (content_ != null) {
            content_.open();
        }
        filled_ = true;
    }
    
    public final boolean isDirty() {
        return dirty_;
    }

    protected final void _setDirty() {
        dirty_ = true;
    }

    public final void delete() throws RModelException {
        if (mountedModel_ != null) {
            mountedModel_.delete();
        }
        _delete();
    }

    protected void _delete() throws RModelException {
    }

    public final void commit() throws RModelException {
        _commitAlways();
        if (mountedModel_ != null) {
            mountedModel_.commit();
        }
        if (dirty_) {
            _commitDirty();
            dirty_ = false;
        }
    }

    protected void _commitAlways() throws RModelException {
    }

    protected void _commitDirty() throws RModelException {
    }

    public final void rollback() throws RModelException {
        _rollbackAlways();
        if (mountedModel_ != null) {
            mountedModel_.rollback();
        }
        if (dirty_) {
            _rollbackDirty();
            dirty_ = false;
        }
    }

    protected void _rollbackAlways() throws RModelException {
    }

    protected void _rollbackDirty() throws RModelException {
    }

    public final void dispose() throws RModelException {
        unmount();
        _dispose();
    }

    protected void _dispose() throws RModelException {
    }

    public final void accept(IRListVisitor visitor, int index)
      throws RModelException {
        visitor.visit(this, index);
    }

    public final void accept(IRTableVisitor visitor, int x, int y)
      throws RModelException {
        visitor.visit(this, x, y);
    }

    protected final void _fillNode() throws RModelException {
        if (!filled_) {
            content_ = _loadContent();
            _fillSpecificContent();
            filled_ = true;
        }
    }

    protected IRModelContent _loadContent() throws RModelException {
        return (null);
    }

    protected void _fillSpecificContent() throws RModelException {
    }

    public final String getName() {
        return (_name);
    }
}
