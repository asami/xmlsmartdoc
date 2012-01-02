/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package org.relaxer.framework.runtime.models.proxy;

import org.relaxer.framework.runtime.model.AbstractRTreeModel;
import org.relaxer.framework.runtime.model.IRTreeModel;
import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.models.workspace.WorkspaceNode;

/**
 * TreeProxyModel
 *
 * @since   Aug.  9, 2005
 * @version Aug. 19, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class TreeProxyModel extends AbstractRTreeModel {
    private final IRTreeModel original_;

    public TreeProxyModel(IRTreeModel original, IRModelContext context) throws RModelException {
		super(context);
        original_ = original;
	}

    protected IRTreeModelNode _newRootNode() throws RModelException {
        return new TreeProxyModelNode(original_.getRoot(), this);
    }

    protected IRTreeModelNode _newNode(String name) {
        return null; // XXX
    }
}
