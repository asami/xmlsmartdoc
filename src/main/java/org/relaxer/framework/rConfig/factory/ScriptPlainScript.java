/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.rConfig.factory;

import org.relaxer.framework.rConfig.FCPlainScript;
import org.relaxer.framework.script.ScriptSpace;

/**
 * ScriptPlainScript
 *
 * @since   Jan.  9, 2004
 * @version Jan.  9, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptPlainScript extends FCPlainScript {
    public ScriptPlainScript(ScriptSpace scriptSpace) {
        _setScriptSpace(scriptSpace);
    }
}
