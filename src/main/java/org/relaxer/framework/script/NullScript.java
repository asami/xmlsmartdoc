/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.script;

/**
 * NullScript
 *
 * @since   Jan.  6, 2004
 * @version Jan.  6, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class NullScript extends AbstractScript {
    private static NullScript singleton__ = new NullScript();

    public static NullScript getSingleton() {
        return (singleton__);
    }

    public void execute(ScriptContext context) throws ScriptException {
        // do nothing        
    }
}
