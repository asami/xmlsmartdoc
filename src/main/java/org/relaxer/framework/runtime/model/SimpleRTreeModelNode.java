package org.relaxer.framework.runtime.model;

/**
 * SimpleRTreeModelNode
 *
 * @since   Aug. 19, 2005
 * @version Aug. 19, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class SimpleRTreeModelNode extends AbstractRTreeModelNode {
    public SimpleRTreeModelNode(IRTreeModel model) {
        super(model);
    }

    public SimpleRTreeModelNode(String name, IRTreeModel model) {
        super(name, model);
    }
}
