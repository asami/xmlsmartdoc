/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.rConfig.factory;

import org.relaxer.framework.rConfig.FCPlainScriptBody;
import org.relaxer.framework.rConfig.IREvaluationContext;
import org.relaxer.framework.rConfig.REvaluationException;
import org.relaxer.framework.script.ScriptSpace;

/**
 * ScriptPlainScriptBody
 *
 * @since   Jan.  9, 2004
 * @version Jan. 23, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptPlainScriptBody extends FCPlainScriptBody {
    public ScriptPlainScriptBody(ScriptSpace scriptSpace) {
        _setScriptSpace(scriptSpace);
    }
    
    public Object eval(
        Object[] params, 
        IREvaluationContext context
    ) throws REvaluationException {
        if (params.length == 0) {
            return (null);
        } else {
            return (params[params.length - 1]);
        }
    }
}
