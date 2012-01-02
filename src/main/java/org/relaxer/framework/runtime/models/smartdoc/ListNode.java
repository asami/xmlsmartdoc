package org.relaxer.framework.runtime.models.smartdoc;

import java.util.List;

import org.relaxer.framework.runtime.model.IRTreeModel;

/**
 * ListNode
 *
 * @since   Sep. 28, 2005
 * @version Sep. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ListNode extends ContentNode {
    public ListNode(String name, IRTreeModel model) {
        super(name, model);
    }

    public List getList() {
        throw new UnsupportedOperationException("ListNode.getList");
    }
}
