/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.zip;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.JarFile;

import org.relaxer.framework.runtime.model.AbstractRTreeModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;

/**
 * JarModel
 *
 * @since   Aug. 20, 2005
 * @version Aug. 26, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class JarModel extends AbstractRTreeModel {
    public JarModel(IRModelNode node, IRModelContext context) throws RModelException {
        super(node, context);
    }

	public JarModel(String fileName, IRModelContext context) throws RModelException {
		super(context);
		setProperty(PROPERTY_FILE, fileName);
	}

    public JarModel(IRDataSource dataSource, IRModelContext _context) throws RModelException {
        super(dataSource, _context);
    }

    protected void _open_tree() throws RModelException {
        try {
            IRDataSource ds = _getDataSource();
            File file = ds.getFile();
            if (file.exists()) {
                JarFile jarFile = new JarFile(file);
                JarBuilder builder = new JarBuilder(jarFile, getRoot());
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
        JarMaker maker = new JarMaker(out);
        traverse(maker);
        maker.close();
    }

    protected IRTreeModelNode _newNode(String name) throws RModelException {
        return new JarNode(name, this);
    }

    protected IRTreeModelNode _newRootNode() throws RModelException {
        return new JarNode(this);
    }
}
