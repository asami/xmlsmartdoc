package org.xmlsmartdoc.SmartDoc.mathml.rParts;

/**
 * @version MathML.rlx 1.0 (Sat Sep 09 10:49:01 JST 2000)
 * @author  Relaxer 0.11b (by ASAMI@Yokohama)
 */
public interface IRNode {
    /**
     * Sets parent RNode.
     *
     * @param parent
     */
    void setParentRNode(IRNode parent);

    /**
     * Gets parent RNode.
     *
     * @return IRNode
     */
    IRNode getParentRNode();

    /**
     * Gets child RNodes.
     *
     * @return IRNode[]
     */
    IRNode[] getRNodes();
}
