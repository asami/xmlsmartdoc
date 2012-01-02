package org.relaxer.framework.testScript.rTestScript;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import org.w3c.dom.Node;

/**
 * <b>ITSValueExpressionChoice</b> is generated from testScript.rng by Relaxer.
 * Concrete classes of the interface are TSValueExpressionValue, TSExpression and TSValueElement.
 *
 * @version testScript.rng (Mon Sep 29 12:19:24 JST 2003)
 * @author  Relaxer 1.0b (http://www.relaxer.org)
 */
public interface ITSValueExpressionChoice extends IREvaluatable, IRNode {
    /**
     * Creates a DOM representation of the object.
     * Result is appended to the Node <code>parent</code>.
     *
     * @param parent
     */
    void makeElement(Node parent);

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    void makeTextElement(StringBuffer buffer);

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    void makeTextElement(Writer buffer) throws IOException;

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    void makeTextElement(PrintWriter buffer);

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    void makeTextAttribute(StringBuffer buffer);

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    void makeTextAttribute(Writer buffer) throws IOException;

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    void makeTextAttribute(PrintWriter buffer);

    /**
     * @param stack
     */
    void setup(RStack stack);

    /**
     * @return Object
     */
    Object clone();

    /**
     * @param text
     */
    void setContent(String text);

    /**
     * @param text
     */
    void setContentByString(String text);

    /**
     * @return String
     */
    String makeTextDocument();

    /**
     * @return String
     */
    String toString();

    /**
     * @param context
     * @exception REvaluationException
     * @return Object
     */
    Object eval(IREvaluationContext context) throws REvaluationException;

    /**
     * @param params
     * @param context
     * @exception REvaluationException
     * @return Object
     */
    Object eval(Object[] params, IREvaluationContext context) throws REvaluationException;
}
