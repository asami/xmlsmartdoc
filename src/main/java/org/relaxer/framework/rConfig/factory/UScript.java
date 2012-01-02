/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.rConfig.factory;

import org.relaxer.framework.script.ScriptContext;
import org.relaxer.framework.script.ScriptException;
import org.relaxer.framework.script.Slot;

import com.AsamiOffice.text.UString;

/**
 * UScript
 *
 * @since   Jan. 10, 2004
 * @version Jan. 10, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class UScript {
    public static Object peekValue(
        ScriptContext scriptContext, 
        String path
    ) {
        Context context = findContext(path, scriptContext);
        if (context == null) {
            throw (new UnsupportedOperationException());
        }
        if (context.slot == null) {
            throw (new UnsupportedOperationException());
        }
        return (context.slot.peekObject());
    }

    public static Object popValue(
        ScriptContext scriptContext,
        String path
    ) throws ScriptException {
        Context context = findContext(path, scriptContext);
        if (context == null) {
            throw (new UnsupportedOperationException());
        }
        if (context.slot == null) {
            throw (new UnsupportedOperationException());
        }
        return (context.slot.popObject());
    }

    public static Context findContext(String path, ScriptContext scriptContext) {
        Context context = new Context();
        String[] components = UString.getTokens(path, "/");
        for (int i = 0; i < components.length; i++) {
            String component = components[i];
            int index = component.indexOf("[");
            String name;
            if (index == -1) {
                name = component;
                context.fragment = null;
            } else {
                name = component.substring(0, index);
                int closing = component.indexOf("]");
                if (closing == -1) {
                    throw (new UnsupportedOperationException());
                }
                context.fragment = component.substring(index + 1, closing); 
            }
            Slot slot = scriptContext.getSlot(name);
            if (slot == null) {
                throw (new UnsupportedOperationException());
            }
            context.slot = slot;
        }
        return (context);
    }

    private static class Context {
        public Slot slot;
        public String fragment;
    }
}
