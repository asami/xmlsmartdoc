/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.script;

/**
 * AbstractScript
 *
 * @since   Dec.  6, 2004
 * @version Jan. 30, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractScript implements IScript, IScriptConstants{
    private ScriptClass scriptClass_;
    private ScriptSpace scriptSpace_;

    public void setScriptClass(ScriptClass scriptClass) {
        scriptClass_ = scriptClass;
        scriptSpace_ = scriptClass.getScriptSpace();
    }
    
    protected final ScriptClass _getSciprtClass() {
        return (scriptClass_);
    }
    
    protected final ScriptSpace _getScriptSpace() {
        return (scriptSpace_);
    }
}
