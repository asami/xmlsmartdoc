package org.relaxer.framework.session.rSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * <b>IRSOtherAnyElementMixedChoice</b> is generated from session.rng by Relaxer.
 * Concrete classes of the interface are RSOtherAnyElementAnyAttr and RSAny.
 *
 * @version session.rng (Tue Sep 09 06:58:49 GMT+09:00 2003)
 * @author  Relaxer 1.0rc3b (http://www.relaxer.org)
 */
public interface IRSOtherAnyElementMixedChoice extends IRNode, IRSOtherAnyElementMixed {
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
     * @return RNSContext
     */
    RNSContext rGetRNSContext();

    /**
     * @param rNSContext
     */
    void rSetRNSContext(RNSContext rNSContext);

    /**
     * @return String
     */
    String makeTextDocument();
}
