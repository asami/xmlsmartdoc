/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.workspace;

import org.relaxer.framework.runtime.model.AbstractRTreeModelNode;
import org.relaxer.framework.runtime.model.IRTreeModel;

/**
 * WorkspaceNode
 *
 * @since   Mar. 18, 2004
 * @version Aug. 16, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class WorkspaceNode extends AbstractRTreeModelNode {
    public WorkspaceNode(IRTreeModel model) {
        super(model);
    }
    
    public WorkspaceNode(IRTreeModel model, String name) {
        super(name, model);
    }
}
