/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

/**
 * IRModelRecord
 *
 * @since   Mar. 22, 2004
 * @version Aug. 10, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRModelRecord {
    int getWidth();
    Object get(int x) throws RModelException;
}
