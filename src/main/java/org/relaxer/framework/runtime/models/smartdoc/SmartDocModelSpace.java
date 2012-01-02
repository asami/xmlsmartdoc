package org.relaxer.framework.runtime.models.smartdoc;

import org.relaxer.framework.runtime.model.AbstractRModelSpace;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * SmartDocModelSpace
 *
 * @since   Sep. 27, 2005
 * @version Sep. 27, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class SmartDocModelSpace extends AbstractRModelSpace {
    public SmartDocModelSpace() {
        super();
    }

    public boolean isMatch(IRModelNode node) {
        try {
            if (!"sdoc".equals(node.getSuffix())) {
                return false;
            }
            return true;
        } catch (RModelException e) {
            return false;
        }
    }

    public IRModel getModel(IRModelNode node, IRModelContext context) throws RModelException {
        return new SmartDocModel(node, context);
    }
}
