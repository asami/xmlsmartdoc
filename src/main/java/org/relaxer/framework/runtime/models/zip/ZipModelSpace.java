package org.relaxer.framework.runtime.models.zip;

import org.relaxer.framework.runtime.model.AbstractRModelSpace;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * JarModelSpace
 *
 * @since   Aug. 20, 2005
 * @version Aug. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ZipModelSpace extends AbstractRModelSpace {
    public ZipModelSpace() {
        super();
    }

    public boolean isMatch(IRModelNode node) {
        try {
            if ("zip".equals(node.getSuffix())) {
                return true;
            }
            return false;
        } catch (RModelException e) {
            return false;
        }
    }

    public IRModel getModel(IRModelNode node, IRModelContext context) throws RModelException {
        return new ZipModel(node, context);
    }
}
