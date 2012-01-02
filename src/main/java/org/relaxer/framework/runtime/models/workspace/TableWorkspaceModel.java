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

import java.util.Map;

import org.relaxer.framework.runtime.model.AbstractRTableModel;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * TableWorkFileModel
 *
 * @since   Mar. 20, 2004
 * @version Aug. 12, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class TableWorkspaceModel extends AbstractRTableModel {
    public TableWorkspaceModel(IRModelContext context) throws RModelException {
        super(context);
    }

    public TableWorkspaceModel(Map properties, IRModelContext context) throws RModelException {
		super(properties, context);
	}
}
