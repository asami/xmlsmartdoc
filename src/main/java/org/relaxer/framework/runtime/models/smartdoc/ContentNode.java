package org.relaxer.framework.runtime.models.smartdoc;

import org.relaxer.framework.runtime.model.AbstractRTreeModelNode;
import org.relaxer.framework.runtime.model.IRTreeModel;

/**
 * ContentNode
 *
 * @since   Sep. 28, 2005
 * @version Oct.  5, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ContentNode extends AbstractRTreeModelNode {
    public ContentNode(String name, IRTreeModel model) {
        super(name, model);
    }

    protected final void _dispose_tree() {
        _dispose_content();
    }

    protected void _dispose_content() {
    }
}
