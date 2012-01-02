/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

/**
 * IRListVisitor
 *
 * @since   2004/03/18
 * @version 2004/03/18
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRListVisitor {
    void visit(IRModelNode node, int index) throws RModelException;
}
