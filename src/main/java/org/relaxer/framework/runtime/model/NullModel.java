package org.relaxer.framework.runtime.model;

import java.util.Map;

import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.context.NullModelContext;

/**
 * NullModel
 *
 * @since   Aug.  2. 2005
 * @version Aug. 29. 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class NullModel extends AbstractRModel {
    private NullModel() throws RModelException {
        super(NullModelContext.getContext());
    }

    protected NullModel(Map properties, IRModelContext context) throws RModelException {
        super(properties, context);
    }

    //
    private static IRModel shared__;

    public static IRModel getModel() throws RModelException {
        if (shared__ == null) {
            shared__ = new NullModel();
        }
        return shared__;
    }
}
