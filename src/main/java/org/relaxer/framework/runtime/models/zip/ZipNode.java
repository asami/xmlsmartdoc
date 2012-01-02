/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.zip;

import java.util.zip.ZipEntry;

import org.relaxer.framework.runtime.model.AbstractRTreeModelNode;
import org.relaxer.framework.runtime.model.IRTreeModel;

/**
 * ZipNode
 *
 * @since   Aug.  8, 2004
 * @version Aug. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ZipNode extends AbstractRTreeModelNode {
    private ZipEntry zipEntry_;

    public ZipNode(IRTreeModel model) {
        super(model);
    }
    
    public ZipNode(String name, IRTreeModel model) {
        super(name, model);
    }
}
