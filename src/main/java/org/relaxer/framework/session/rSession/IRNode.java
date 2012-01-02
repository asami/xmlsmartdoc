package org.relaxer.framework.session.rSession;

/**
 * @version session.rng 1.0 (Tue Sep 09 06:58:49 GMT+09:00 2003)
 * @author  Relaxer 1.0rc3b (http://www.relaxer.org)
 */
public interface IRNode {
    /**
     * Sets parent RNode.
     *
     * @param parent
     */
    void rSetParentRNode(IRNode parent);

    /**
     * Gets parent RNode.
     *
     * @return IRNode
     */
    IRNode rGetParentRNode();

    /**
     * Gets child RNodes.
     *
     * @return IRNode[]
     */
    IRNode[] rGetRNodes();
}
