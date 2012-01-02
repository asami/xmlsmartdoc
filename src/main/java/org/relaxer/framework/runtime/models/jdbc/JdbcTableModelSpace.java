package org.relaxer.framework.runtime.models.jdbc;

import org.relaxer.framework.runtime.model.AbstractRModelSpace;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * JdbcModelSpace
 *
 * @since   Sep.  1, 2005
 * @version Sep.  1, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class JdbcTableModelSpace extends AbstractRModelSpace {
    public JdbcTableModelSpace() {
        super();
    }

    public boolean isMatch(IRModelNode node) {
        try {
            if ("ods".equals(node.getSuffix())) {
                return true;
            }
            return false;
        } catch (RModelException e) {
            return false;
        }
    }

    public IRModel getModel(IRModelNode node, IRModelContext context) throws RModelException {
        return new JdbcTableModel(node, context);
    }
}
