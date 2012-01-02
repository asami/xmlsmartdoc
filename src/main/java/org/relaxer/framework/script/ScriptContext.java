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

import org.relaxer.framework.RelaxerFrameworkException;

/**
 * ScriptContext
 *
 * @since   Jan.  5, 2003
 * @version Feb. 12, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptContext {
    private ScriptClass scriptClass_;
    private ScriptContext parent_;
    // Map<String, Slot>
    private Map slots_ = new HashMap();

    public ScriptContext(
        ScriptClass scriptClass,
        ScriptContext parent
    ) {
        scriptClass_ = scriptClass;
        parent_ = parent;
    }

    public void addSlot(Slot slot) {
        slots_.put(slot.getName(), slot);
    }

    public Slot getSlot(String name) {
        return ((Slot)slots_.get(name));
    }

    public void setSlot(String name, ScriptValue value) {
        Slot slot = (Slot)slots_.get(name);
        if (slot == null) {
            slot = new Slot(name);
            slots_.put(name, slot);
        }
        slot.setValue(value);
    }

    public void setSlot(String name, Object object) throws RelaxerFrameworkException {
        Slot slot = (Slot)slots_.get(name);
        if (slot == null) {
            slot = new Slot(name);
            slots_.put(name, slot);
        }
        slot.setObject(object);
    }
}
