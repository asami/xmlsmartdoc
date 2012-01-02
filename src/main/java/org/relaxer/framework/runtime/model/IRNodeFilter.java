/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

/**
 * IRFilter
 *
 * @since   2004/03/18
 * @version 2004/03/18
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRNodeFilter {
    boolean accept(IRModelNode node) throws RModelException;
}
