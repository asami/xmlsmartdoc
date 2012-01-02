package org.relaxer.framework.testScript.rTestScript;

/**
 * IREvaluatable
 *
 * @since   Dec. 31, 2001
 * @version Aug. 31, 2002
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IREvaluatable {
    Object eval() throws REvaluationException;
    Object eval(IREvaluationContext context) throws REvaluationException;
    Object eval(Object[] params, IREvaluationContext context) throws REvaluationException;
}
