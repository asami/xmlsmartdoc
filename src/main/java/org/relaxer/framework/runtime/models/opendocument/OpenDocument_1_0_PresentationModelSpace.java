package org.relaxer.framework.runtime.models.opendocument;

import org.relaxer.framework.runtime.model.AbstractRModelSpace;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * OpenDocument_1_0_PresentationModelSpace
 *
 * @since   Aug. 19, 2005
 * @version Aug. 19, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class OpenDocument_1_0_PresentationModelSpace extends AbstractRModelSpace {
    public OpenDocument_1_0_PresentationModelSpace() {
        super();
    }

    public boolean isMatch(IRModelNode node) {
        try {
            if ("odp".equals(node.getSuffix())) {
                return true;
            }
            return false;
        } catch (RModelException e) {
            return false;
        }
    }

    public IRModel getModel(IRModelNode node, IRModelContext context) throws RModelException {
        return new OpenDocument_1_0_PresentationModel(node, context);
    }
}
