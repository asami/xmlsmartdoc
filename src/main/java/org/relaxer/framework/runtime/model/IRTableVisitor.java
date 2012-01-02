/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

/**
 * IRTableVisitor
 *
 * @since   2004/03/18
 * @version 2004/03/18
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRTableVisitor {
    void visit(IRModelNode node, int x, int y) throws RModelException;
}
