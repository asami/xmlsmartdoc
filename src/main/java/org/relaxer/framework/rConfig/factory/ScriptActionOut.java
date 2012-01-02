/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.rConfig.factory;

import org.relaxer.framework.rConfig.FCActionOut;
import org.relaxer.framework.script.ScriptSpace;

/**
 * ScriptSystemOut
 *
 * @since   2004/01/09
 * @version 2004/01/09
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptActionOut extends FCActionOut {
    public ScriptActionOut(ScriptSpace scriptSpace) {
        _setScriptSpace(scriptSpace);
    }

}
