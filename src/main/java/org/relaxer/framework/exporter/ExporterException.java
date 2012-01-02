/*
 * Relaxer class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.exporter;

import org.relaxer.framework.RelaxerFrameworkException;

/**
 * ScriptException
 *
 * @since   Feb. 28, 2004
 * @version Aug.  3, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ExporterException extends RelaxerFrameworkException {
    private static final long serialVersionUID = -7521960633006454745L;

    public ExporterException(String message) {
        super(message);
    }

    public ExporterException(Throwable e) {
        super(e);
    }

    public ExporterException(String message, Throwable e) {
        super(message, e);
    }
}
