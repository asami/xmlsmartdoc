package org.xmlsmartdoc.SmartDoc.mathml.rParts;

import org.w3c.dom.*;

/**
 * <b>IMMsqrtContent</b> is generated by Relaxer based on MathML.rlx.
 *
 * @version MathML.rlx 1.0 (Sat Sep 09 10:48:42 JST 2000)
 * @author  Relaxer 0.11b (by ASAMI@Yokohama)
 */
public interface IMMsqrtContent extends IRVisitable, IRNode {
    /**
     * Creates a DOM representation of the object.
     * Result is appended to the Node <code>parent</code>.
     *
     * @param parent
     */
    void makeElement(Node parent);
}
