/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models;

import java.io.File;
import java.io.FilenameFilter;

import org.relaxer.framework.runtime.model.IRTreeModel;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.models.fs.FileNode;

/**
 * CvsFileNode
 *
 * @since   Mar. 22, 2004
 * @version Aug.  9, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class CvsFileNode extends FileNode {
    public CvsFileNode(File file, IRTreeModel model) {
        super(model, file);
    }

    public CvsFileNode(String fileName, IRTreeModel model) {
        super(fileName, model);
    }

    protected FilenameFilter _getFilenameFilter() {
        if (filter__ == null) {
            filter__ = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return (!"CVS".equals(name));
                }
            };
        }
        return (filter__);
    }

    protected void _removeFile(File file) throws RModelException {
        // TODO Use cvs command
        throw (new UnsupportedOperationException());
    }

    //
    private static FilenameFilter filter__;
}
