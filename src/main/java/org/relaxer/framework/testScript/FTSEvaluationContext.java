package org.relaxer.framework.testScript;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.relaxer.framework.RelaxerFramework;
import org.relaxer.framework.RelaxerFrameworkException;
import org.relaxer.framework.testScript.rTestScript.RSimpleEvaluationContext;

/**
 * FTSEvaluationContext
 *
 * @since   Aug. 20, 2003
 * @version Feb. 13, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FTSEvaluationContext extends RSimpleEvaluationContext {
    private RelaxerFramework framework_;
    private Object result_ = null;
    private Throwable exception_ = null;

    public FTSEvaluationContext(RelaxerFramework framework) {
        framework_ = framework;
    }

    public void clear() {
        result_ = null;
        exception_ = null;
    }

    public void setResult(Object result) {
        result_ = result;
    }

    public Object getResult() {
        return (result_);
    }

    public void setException(Throwable exception) {
        exception_ = exception;
    }

    public Object getException() {
        return (exception_);
    }

    public Object invokeService(String name, Object[] params)
        throws RelaxerFrameworkException, IOException, InvocationTargetException {
        return (framework_.invokeService(name, params));
    }
}
