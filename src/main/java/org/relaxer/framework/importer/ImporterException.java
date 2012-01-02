/*
 * Relaxer class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.importer;

import org.relaxer.framework.RelaxerFrameworkException;

/**
 * ImporterException
 *
 * @since   Feb. 28, 2004
 * @version Aug.  9, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ImporterException extends RelaxerFrameworkException {
	private static final long serialVersionUID = -1390675082834461715L;

	public ImporterException(String message) {
        super(message);
    }

    public ImporterException(Throwable e) {
        super(e);
    }

    public ImporterException(String message, Throwable e) {
        super(message, e);
    }
}
