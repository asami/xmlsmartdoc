/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@relaxer.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.relaxer.framework.script;

import java.util.HashMap;
import java.util.Map;

import org.relaxer.framework.RelaxerFramework;
import org.relaxer.framework.runtime.model.IRModel;

/**
 * ScriptSpace
 *
 * @since   Jan.  5, 2004
 * @version Mar. 15, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptSpace {
    private RelaxerFramework framework_;
    // Map<String, ScriptClass>
    private Map scriptClasses_ = new HashMap();
    // Map<String, Object>
    private Map components_ = new HashMap();
    // Map<String, IRModel>
    private Map models_ = new HashMap();
    // Map<String, Object>
    private Map resource_ = new HashMap();

    public ScriptSpace(RelaxerFramework framework) {
        framework_ = framework;
    }

    public void addScriptClass(ScriptClass scriptClass) {
        scriptClasses_.put(scriptClass.getName(), scriptClass);
    }

    public ScriptClass getScriptClass(String name) {
        return ((ScriptClass)scriptClasses_.get(name));
    }

    public void addComponentSlot(String componentName, Object component) {
        components_.put(componentName, component);
    }

    public void addModelSlot(String modelName, IRModel model) {
        models_.put(modelName, model);
    }
    
    public Object getComponent(String name) {
        return (components_.get(name));
    }
    
    public IRModel getModel(String name) {
        return ((IRModel)models_.get(name));
    }

    public RelaxerFramework getFramework() {
        return (framework_);
    }
}
