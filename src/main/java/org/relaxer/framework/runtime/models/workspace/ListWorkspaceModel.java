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
package org.relaxer.framework.runtime.models.workspace;

import org.relaxer.framework.runtime.model.AbstractRListModel;
import org.relaxer.framework.runtime.model.IRTreeModel;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.context.NullModelContext;

/**
 * ListWorkspaceModel
 *
 * @since   Aug. 13, 2005
 * @version Aug. 13, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ListWorkspaceModel extends AbstractRListModel {
    public ListWorkspaceModel() throws RModelException {
        super(NullModelContext.getContext());
    }

    public ListWorkspaceModel(IRModelContext context) throws RModelException {
		super(context);
	}

    public void add(IRTreeModel tree) {
        // TODO Auto-generated method stub
        
    }
}
