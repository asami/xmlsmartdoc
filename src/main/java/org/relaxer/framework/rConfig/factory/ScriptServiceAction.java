/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.rConfig.factory;

import org.relaxer.framework.rConfig.FCServiceAction;
import org.relaxer.framework.script.ScriptSpace;

/**
 * ScriptServiceAction
 *
 * @since   Jan.  9, 2004
 * @version Jan.  9, 2004 
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptServiceAction extends FCServiceAction {
    public ScriptServiceAction(ScriptSpace scriptSpace) {
        _setScriptSpace(scriptSpace);
    }
}
