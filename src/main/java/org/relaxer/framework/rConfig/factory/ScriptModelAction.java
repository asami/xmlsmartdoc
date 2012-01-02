/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.rConfig.factory;

import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.rConfig.FCModelAction;
import org.relaxer.framework.rConfig.IREvaluationContext;
import org.relaxer.framework.rConfig.REvaluationException;
import org.relaxer.framework.script.ScriptParameter;
import org.relaxer.framework.script.ScriptSpace;

/**
 * ScriptModelAction
 *
 * @since   Jan.  9, 2004
 * @version Jan. 10, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptModelAction extends FCModelAction {
    public ScriptModelAction(ScriptSpace scriptSpace) {
        _setScriptSpace(scriptSpace);
    }
    
    public Object eval(Object[] params, IREvaluationContext context)
        throws REvaluationException {

        String modelName = getRef();
        ScriptSpace space = getScriptSpace();
        IRModel model = space.getModel(modelName);
        setInSlots_(params, model);
        try {
            stimulateModel_(model);
        } catch (RModelException e) {
            throw (new REvaluationException(e));
        }
        return (null);
    }

    private void setInSlots_(Object[] params, IRModel model) {
        for (int i = 0; i < params.length; i++) {
            Object param = params[i];
            if (param instanceof ScriptParameter.Entry) {
                ScriptParameter.Entry entry = (ScriptParameter.Entry)param;
                model.setProperty(entry.name, entry.value.getObject());
            }
        }
    }

    private void stimulateModel_(IRModel model) throws RModelException {
        String event = getEvent();
        if ("open".equals(event)) {
            model.open();
        } else if ("close".equals(event)) {
            model.close();
        } else if ("commit".equals(event)) {
            model.commit();
        } else if ("abort".equals(event)) {
            model.rollback();
        } else if ("destroy".equals(event)) {
            model.delete();
        } else {
            throw (new UnsupportedOperationException());
        }
    }
}
