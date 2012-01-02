package org.relaxer.framework.runtime.model;

import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * IRModelSpace
 *
 * @since   Aug. 10, 2005
 * @version Aug. 16, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRModelSpace {
    boolean isMatch(IRModelNode node);
    IRModel getModel(IRModelNode node, IRModelContext context) throws RModelException;
}
