/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework;

/**
 * RelaxerFrameworkErrorException
 *
 * @since   Feb. 17, 2004
 * @version Aug. 15, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RelaxerFrameworkErrorException extends RuntimeException {
    private static final long serialVersionUID = 7146524410723974551L;

    public RelaxerFrameworkErrorException() {
        super();
    }
    
    public RelaxerFrameworkErrorException(String message) {
        super(message);
    }

    public RelaxerFrameworkErrorException(Throwable e) {
        super(e);
    }
}
