/*
 * Relaxer class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.script;

import org.relaxer.framework.RelaxerFrameworkException;

/**
 * ScriptException
 *
 * @since   Jan.  7, 2004
 * @version Jan.  8, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptException extends RelaxerFrameworkException {
    public ScriptException(String message) {
        super(message);
    }

    public ScriptException(Throwable e) {
        super(e);
    }

    public ScriptException(String message, Throwable e) {
        super(message, e);
    }
}
