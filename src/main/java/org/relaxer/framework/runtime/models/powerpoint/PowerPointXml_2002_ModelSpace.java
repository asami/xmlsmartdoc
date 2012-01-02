package org.relaxer.framework.runtime.models.powerpoint;

import org.relaxer.framework.runtime.model.AbstractRModelSpace;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * PowerPointXmlModelSpace
 *
 * @since   Aug. 16, 2005
 * @version Aug. 16, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class PowerPointXml_2002_ModelSpace extends AbstractRModelSpace {
    public PowerPointXml_2002_ModelSpace() {
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
        return new PowerPointXml_2002_Model(node, context);
    }
}
