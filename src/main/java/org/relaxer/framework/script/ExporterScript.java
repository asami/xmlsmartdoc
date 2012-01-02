/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.relaxer.framework.RelaxerFramework;
import org.relaxer.framework.importer.ImporterException;
import org.relaxer.framework.importer.UImporter;

/**
 * ExporterScript
 *
 * @since   Jan.  6, 2004
 * @version Aug.  9, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ExporterScript extends AbstractScript {
    private RelaxerFramework framework_;

    public ExporterScript(RelaxerFramework framework) {
        framework_ = framework;
    }

    public void execute(ScriptContext context) throws ScriptException {
        try {
            ScriptSpace space = _getScriptSpace();
            ScriptClass main = space.getScriptClass("main");
            ScriptParameter in = getInParameter_(main, context);
            ScriptParameter out = getOutParameter_(main, context);
            main.execute(in, out, context);
        } finally {
        }
    }

    private ScriptParameter getInParameter_(
        ScriptClass scriptClass,
        ScriptContext context
    ) throws ScriptException {
        ScriptParameter in = new ScriptParameter();
        List slots = new ArrayList(Arrays.asList(scriptClass.getSlots()));
        Slot argument = context.getSlot(SYSTEM_ARGUMENT);
        if (argument != null) {
            String[] args = argument.getTexts();
            int size = Math.min(args.length, slots.size());
            Class[] types = new Class[size];
            for (int i = 0;i < size;i++) {
                Slot slot = (Slot)slots.get(i);
                types[i] = slot.getDatatype().getJavaClass();
            }
            try {
                Object[] imported = UImporter.importParameter(types, args, framework_.getModelContext());
                for (int i = 0; i < imported.length; i++) {
                    Slot slot = (Slot)slots.get(i);
                    in.addEntryObject(slot.getName(), imported[i]);
                }
            } catch (ImporterException e) {
                String message = "import error";
                framework_.getLogger().error(message, e);
                throw (new ScriptException(message, e));
            }
        }
        return (in);
    }

    private ScriptParameter getOutParameter_(
        ScriptClass scriptClass,
        ScriptContext context
    ) {
        ScriptParameter out = new ScriptParameter();
        Slot result = scriptClass.getSlot(SYSTEM_RESULT);
        if (result != null) {
            out.addEntryValue(result.getName(), result.getValue());
        }
        return (out);
    }
}
