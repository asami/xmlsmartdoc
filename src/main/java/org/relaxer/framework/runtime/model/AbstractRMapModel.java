/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

import java.io.OutputStream;
import java.util.Map;

import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;

import com.AsamiOffice.util.ArrayMap;

/**
 * AbstractRMapModel
 *
 * @since   Aug. 13, 2005
 * @version Aug. 15, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRMapModel extends AbstractRModel implements IRMapModel {
    private Map map_ = new ArrayMap();

    protected AbstractRMapModel(IRModelContext context) throws RModelException {
        super(context);
    }

    protected AbstractRMapModel(IRModelContent content, IRModelContext context) throws RModelException {
        super(content, context);
    }

    protected AbstractRMapModel(Map properties, IRModelContext context) throws RModelException {
        super(properties, context);
    }

    public AbstractRMapModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

    protected final void _commitAlways() throws RModelException {
        _commitAlways_map();
    }

    protected void _commitAlways_map() throws RModelException {
    }

    protected final void _commitDirty() throws RModelException {
        _commitDirty_map();
    }

    protected void _commitDirty_map() throws RModelException {
    }

    protected final IRModelContent _getModelContent() throws RModelException {
        return _getModelContent_map();
    }

    protected IRModelContent _getModelContent_map() throws RModelException {
        return null;
    }

    protected final void _writeContent(OutputStream out) throws RModelException {
        _writeContent_map(out);
    }

    protected void _writeContent_map(OutputStream out) throws RModelException {
    }

    public final void set(String key, IRModelNode value) throws RModelException {
        map_ .put(key, value);
    }

    public final IRModelNode get(String key) throws RModelException {
        return (IRModelNode)map_.get(key);
    }
}
