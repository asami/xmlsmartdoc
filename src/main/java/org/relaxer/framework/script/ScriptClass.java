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

import com.AsamiOffice.util.ArrayMap;

/**
 * ScriptClass
 *
 * @since   Jan.  5, 2003
 * @version Jan. 30, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptClass implements IScriptConstants {
    private ScriptSpace space_;
    private String name_;
    // Map<String, Slot>
    private ArrayMap slots_ = new ArrayMap();
    private IScript prologue_;
    private IScript epilogue_;
    private IScript body_;

    public ScriptClass(String name, ScriptSpace space) {
        space_ = space;
        name_ = name;
        prologue_ = NullScript.getSingleton();
        epilogue_ = NullScript.getSingleton();
        body_ = NullScript.getSingleton();
    }

    public final String getName() {
        return (name_);
    }
    
    public final ScriptSpace getScriptSpace() {
        return (space_);
    }

    public void addSlot(Slot slot) {
        slots_.put(slot.getName(), slot);
    }
    
    public Slot getSlot(String name) {
        return ((Slot)slots_.get(name));
    }

    public Slot[] getSlots() {
        Slot[] result = new Slot[slots_.size()];
        return ((Slot[])slots_.values().toArray(result));
    }

    public void setPrologue(IScript prologue) {
        prologue.setScriptClass(this);
        prologue_ = prologue;
    }

    public void setEpilogue(IScript epilogue) {
        epilogue.setScriptClass(this);
        epilogue_ = epilogue;
    }

    public void setBody(IScript body) {
        body.setScriptClass(this);
        body_ = body;
    }

    private ScriptContext makeContext_(ScriptContext parent) {
        ScriptContext context = new ScriptContext(this, parent);
        Object[] values = slots_.values().toArray();
        for (int i = 0;i < values.length;i++) {
            Slot slot = (Slot)values[i];
            context.addSlot(new Slot(slot));
        }
        return (context);
    }

    public void execute(
        ScriptParameter in, 
        ScriptParameter out, 
        ScriptContext parentContext
    ) throws ScriptException {
        ScriptContext context = makeContext_(parentContext);
        ScriptParameter.Entry[] ins = in.getEntries();
        for (int i = 0; i < ins.length; i++) {
            ScriptParameter.Entry entry = ins[i];
            Slot slot = context.getSlot(entry.name);
            entry.toSlot(slot);
        }
        executeScript_(prologue_, context);
        executeScript_(body_, context);
        executeScript_(epilogue_, context);
        ScriptParameter.Entry[] outs = out.getEntries();
        for (int i = 0; i < outs.length; i++) {
            ScriptParameter.Entry entry = outs[i];
            Slot slot = context.getSlot(entry.name);
            entry.fromSlot(slot);
        }
        Slot resultSlot = context.getSlot(SYSTEM_RESULT);
        if (resultSlot != null) {
            parentContext.setSlot(SYSTEM_RESULT, resultSlot.getValue());
        }
    }

    private void executeScript_(
        IScript script, 
        ScriptContext context
    ) throws ScriptException {
        script.execute(context);
    }
}
