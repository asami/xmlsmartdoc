/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.jdbc;

import org.relaxer.framework.runtime.model.AbstractRTableModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * JdbcTableModel
 *
 * @since   Sep.  1, 2005
 * @version Sep.  1, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class JdbcTableModel extends AbstractRTableModel {
    protected JdbcTableModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(context);
    }

    protected void _commitDirty_table() throws RModelException {
        throw new UnsupportedOperationException("JdbcModel._commitDirty_table");
    }
}
