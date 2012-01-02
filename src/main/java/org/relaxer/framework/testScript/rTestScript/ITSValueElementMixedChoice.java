package org.relaxer.framework.testScript.rTestScript;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * <b>ITSValueElementMixedChoice</b> is generated from testScript.rng by Relaxer.
 * Concrete classes of the interface are TSValueElementAnyAttr and TSAny.
 *
 * @version testScript.rng (Mon Sep 29 12:19:24 JST 2003)
 * @author  Relaxer 1.0b (http://www.relaxer.org)
 */
public interface ITSValueElementMixedChoice extends IREvaluatable, IRNode, ITSValueElementMixed {
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
     * @param text
     */
    void setContentByString(String text);

    /**
     * @return String
     */
    String makeTextDocument();
}
