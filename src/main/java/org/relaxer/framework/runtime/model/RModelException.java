/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model;

import org.relaxer.framework.RelaxerFrameworkException;

/**
 * RModelException
 *
 * @since   Jan. 10, 2004
 * @version Aug.  2, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RModelException extends RelaxerFrameworkException {
    private static final long serialVersionUID = -3420713492079253189L;

    public RModelException(String message) {
        super(message);
    }

    public RModelException(Throwable e) {
        super(e);
    }

    public RModelException(String message, Throwable e) {
        super(message, e);
    }
}
