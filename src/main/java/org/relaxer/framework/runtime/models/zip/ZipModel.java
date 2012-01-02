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
package org.relaxer.framework.runtime.models.zip;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipFile;

import org.relaxer.framework.runtime.model.AbstractRTreeModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;

/**
 * ZipModel
 *
 * @since   Aug.  8, 2004
 * @version Aug. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ZipModel extends AbstractRTreeModel {
	public ZipModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

    public ZipModel(IRDataSource dataSource, IRModelContext context) throws RModelException {
        super(dataSource, context);
    }

    protected void _open_tree() throws RModelException {
        try {
            IRDataSource ds = _getDataSource();
            File file = ds.getFile();
            if (file.exists()) {
                ZipFile zipFile = new ZipFile(file);
                ZipBuilder builder = new ZipBuilder(zipFile, getRoot());
                builder.build();
            }
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    protected void _create_tree() throws RModelException {
    }

    protected void _commitDirty_tree() throws RModelException {
    }

    protected void _writeContent_tree(OutputStream out) throws RModelException {
        ZipMaker maker = new ZipMaker(out);
        traverse(maker);
        maker.close();
    }

    protected IRTreeModelNode _newNode(String name) throws RModelException {
        return new ZipNode(name, this);
    }

    protected IRTreeModelNode _newRootNode() throws RModelException {
        return new ZipNode(this);
    }
}
