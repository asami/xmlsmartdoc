package org.relaxer.framework.runtime.models.html;

import org.relaxer.framework.runtime.model.AbstractRModelSpace;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * HtmlTableModelSpace
 *
 * @since   Aug. 16, 2005
 * @version Sep.  3, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class Html_4_0_TableModelSpace extends AbstractRModelSpace {
    public Html_4_0_TableModelSpace() {
        super();
    }

    public boolean isMatch(IRModelNode node) {
        try {
            if ("html".equals(node.getSuffix())) {
                return true;
            }
            return false;
        } catch (RModelException e) {
            return false;
        }
    }

    public IRModel getModel(IRModelNode node, IRModelContext context) throws RModelException {
        return new Html_4_0_TableModel(node, context);
    }
}
