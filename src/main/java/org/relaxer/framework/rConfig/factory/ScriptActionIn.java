/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.rConfig.factory;

import org.relaxer.framework.rConfig.FCActionIn;
import org.relaxer.framework.rConfig.FCActionInPeek;
import org.relaxer.framework.rConfig.FCActionInPop;
import org.relaxer.framework.rConfig.FCActionInValue;
import org.relaxer.framework.rConfig.IFCActionInMixed;
import org.relaxer.framework.rConfig.IREvaluationContext;
import org.relaxer.framework.rConfig.REvaluationException;
import org.relaxer.framework.rConfig.RString;
import org.relaxer.framework.script.ScriptContext;
import org.relaxer.framework.script.ScriptException;
import org.relaxer.framework.script.ScriptParameter;
import org.relaxer.framework.script.ScriptSpace;
import org.relaxer.framework.script.ScriptValue;

/**
 * ScriptActionIn
 *
 * @since   Jan.  9, 2004
 * @version Feb. 12, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptActionIn extends FCActionIn {
    public ScriptActionIn(ScriptSpace scriptSpace) {
        _setScriptSpace(scriptSpace);
    }

    public Object eval(Object[] params, IREvaluationContext context) 
        throws REvaluationException {

        ScriptContext scriptContext = (ScriptContext)context.getProperty();
        if (scriptContext == null) {
            throw (new InternalError());
        }
        ScriptParameter.Entry entry = new ScriptParameter.Entry(getName());
        IFCActionInMixed content = getContent();
        if (content instanceof FCActionInPeek) {
            FCActionInPeek peek = (FCActionInPeek)content;
            Object value = UScript.peekValue(scriptContext, peek.getContent());
            entry.value = new ScriptValue(value); 
        } else if (content instanceof FCActionInPop) {
            FCActionInPop pop = (FCActionInPop)content;
            String slotName = pop.getContent();
            Object value;
            try {
                value = UScript.popValue(scriptContext, pop.getContent());
            } catch (ScriptException e) {
                throw (new REvaluationException(e));
            } 
            entry.value = new ScriptValue(value); 
        } else if (content instanceof FCActionInValue) {
            FCActionInValue value = (FCActionInValue)content;
            entry.value = new ScriptValue(value.getContent());
        } else if (content instanceof RString) {
            RString string = (RString)content;
            entry.value = new ScriptValue(string.getContent());
        } else {
            throw (new InternalError());
        }
        return (entry);
    }
}
