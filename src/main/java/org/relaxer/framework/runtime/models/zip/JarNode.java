package org.relaxer.framework.runtime.models.zip;

import org.relaxer.framework.runtime.model.AbstractRTreeModelNode;
import org.relaxer.framework.runtime.model.IRTreeModel;

/**
 * JarNode
 *
 * @since   Aug. 20, 2005
 * @version Aug. 20, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class JarNode extends AbstractRTreeModelNode {
    public JarNode(IRTreeModel model) {
        super(model);
    }

    public JarNode(String name, JarModel model) {
        super(name, model);
    }
}
