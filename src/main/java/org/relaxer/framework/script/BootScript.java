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
import org.relaxer.framework.logger.IRFrameworkLogger;

/**
 * BootScript
 *
 * @since   Jan.  6, 2004
 * @version Aug.  9, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class BootScript extends AbstractScript {
    private RelaxerFramework framework_;
    private IRFrameworkLogger logger_;

    public BootScript(RelaxerFramework framework) {
        framework_ = framework;
        logger_ = framework_.getLogger();
    }

    public void execute(ScriptContext context) throws ScriptException {
        try {
            ScriptSpace space = _getScriptSpace();
            String service = context.getSlot(SYSTEM_SERVICE).peekText();
            if (service == null) {
                logger_.error("No service");
                return;
            }
            ScriptClass main = space.getScriptClass(service);
            if (main == null) {
                logger_.error("Service is unavailable : " + service);
                return;
            }
            ScriptParameter in = getInParameter_(main, context);
            ScriptParameter out = getOutParameter_(main, context);
            main.execute(in, out, context);
        } catch (ScriptException e) {
        	throw (e);
        } catch (Exception e) {
        	throw (new ScriptException(e));
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
                throw (getInParameter_error_(e));
            }
        }
        return (in);
    }

    private ScriptException getInParameter_error_(ImporterException e) {
        String message = "import parameters";
        logger_.error(message, e);
        return (new ScriptException(message, e));
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
