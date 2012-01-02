package org.relaxer.framework.runtime.models.xml;

import org.relaxer.framework.runtime.model.AbstractRModelSpace;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * XmlTableModelSpace
 *
 * @since   Aug. 16, 2005
 * @version Aug. 16, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class XmlTableModelSpace extends AbstractRModelSpace {
    public XmlTableModelSpace() {
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
        return new XmlTableModel(node, context);
    }
}
