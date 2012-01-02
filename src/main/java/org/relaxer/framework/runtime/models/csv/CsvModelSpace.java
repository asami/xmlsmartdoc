package org.relaxer.framework.runtime.models.csv;

import org.relaxer.framework.runtime.model.AbstractRModelSpace;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * CsvModelSpace
 *
 * @since   Aug. 12, 2005
 * @version Aug. 15, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class CsvModelSpace extends AbstractRModelSpace {
    public CsvModelSpace() {
        super();
    }

    public boolean isMatch(IRModelNode node) {
        try {
            if ("csv".equals(node.getSuffix())) {
                return true;
            }
            return false;
        } catch (RModelException e) {
            return false;
        }
    }

    public IRModel getModel(IRModelNode node, IRModelContext context) throws RModelException {
        return new CsvModel(node, context);
    }
}
