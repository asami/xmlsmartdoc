package org.relaxer.framework.runtime.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * RModelFactory
 *
 * @since   Aug.  9, 2005
 * @version Aug. 14, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RModelFactory {
    private List spaces_ = new ArrayList();

    public RModelFactory() {
        super();
    }
    
    public void addModelSpace(IRModelSpace space) {
        spaces_.add(space);
    }

    public IRModel mount(IRModelNode node, IRModelContext context) throws RModelException {
        Iterator iter = spaces_.iterator();
        while (iter.hasNext()) {
            IRModelSpace space = (IRModelSpace)iter.next();
            if (space.isMatch(node)) {
                return space.getModel(node, context);
            }
        }
        return null;
    }
}
