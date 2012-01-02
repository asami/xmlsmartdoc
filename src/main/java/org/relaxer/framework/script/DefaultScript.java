/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.script;

import org.relaxer.framework.RelaxerFrameworkException;
import org.relaxer.framework.rConfig.ConfigFactory;
import org.relaxer.framework.rConfig.FCPlainScriptBody;
import org.relaxer.framework.rConfig.IConfigFactory;
import org.relaxer.framework.rConfig.IFCPlainScriptBodyContentChoice;
import org.relaxer.framework.rConfig.IREvaluationContext;
import org.relaxer.framework.rConfig.REvaluationException;
import org.relaxer.framework.rConfig.RSimpleEvaluationContext;


/**
 * DefaultScript
 *
 * @since   Jan.  6, 2004
 * @version Aug. 20, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class DefaultScript extends AbstractScript {
    private FCPlainScriptBody scriptBody_;

    public DefaultScript(IFCPlainScriptBodyContentChoice action) {
        this(new IFCPlainScriptBodyContentChoice[] { action });
    }

    public DefaultScript(IFCPlainScriptBodyContentChoice[] sequence) {
        IConfigFactory factory = ConfigFactory.getFactory();
        FCPlainScriptBody scriptBody = factory.createFCPlainScriptBody();
        for (int i = 0; i < sequence.length; i++) {
            IFCPlainScriptBodyContentChoice choice = sequence[i];
            scriptBody.addPlainScriptBodyContent(
                (IFCPlainScriptBodyContentChoice)choice.clone()
            );
        }
        scriptBody_ = scriptBody;
    }

    public void execute(ScriptContext context) throws ScriptException {
        try {
            IREvaluationContext evalContext = new RSimpleEvaluationContext();
            evalContext.setProperty(context);
            context.setSlot(SYSTEM_RESULT, scriptBody_.eval(evalContext));
        } catch (ScriptException e) {
        	throw (e);
        } catch (REvaluationException e) {
            Throwable cause = e.rGetParent();
            if (cause instanceof ScriptException) {
                throw ((ScriptException)cause);
            } else if (cause != null) {
                throw (new ScriptException(cause));
            } else {
                throw (new ScriptException(e));
            }
        } catch (RelaxerFrameworkException e) {
            throw (new ScriptException(e));
        } catch (Exception e) {
        	throw (new ScriptException(e));
        }
    }
}
