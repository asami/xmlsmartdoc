package org.relaxer.framework.runtime.models.excel;

import org.relaxer.framework.runtime.model.AbstractRModelSpace;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * ExcelBookModelSpace
 *
 * @since   Aug. 12, 2005
 * @version Aug. 15, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ExcelBookModelSpace extends AbstractRModelSpace {
    public ExcelBookModelSpace() {
        super();
    }

    public boolean isMatch(IRModelNode node) {
        try {
            return "xls".equals(node.getSuffix());
        } catch (RModelException e) {
            return false;
        }
    }

    public IRModel getModel(IRModelNode node, IRModelContext context) throws RModelException {
        return new ExcelBookModel(node, context);
    }
}
