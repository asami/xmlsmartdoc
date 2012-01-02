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
package org.relaxer.framework.runtime.models.fs;

import java.io.File;
import java.util.Map;

import org.relaxer.framework.runtime.model.AbstractRTreeModel;
import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

import com.AsamiOffice.io.ExcludesFilenameFilter;

/**
 * FileStoreModel
 *
 * @since   Jan.  2, 2004
 * @version Aug. 19, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FileStoreModel extends AbstractRTreeModel {
    public final static String EXCLUDES = "file.excludes"; 
    public final static String INCLUDES = "file.includes"; 

    public FileStoreModel(Map properties, IRModelContext context) throws RModelException {
        super(properties, context);
    }

    public FileStoreModel(File dir, IRModelContext context) throws RModelException {
        super(context);
        setProperty(PROPERTY_FILE, dir);
    }

    public FileStoreModel(String name, IRModelContext context) throws RModelException {
        super(context);
        setProperty(PROPERTY_FILE, name);
    }

    protected void _open_tree() throws RModelException {
//        setupFile_();
        setupFilenameFilter_();
        setupOptions_();
    }
/*
    void setupFile_() throws RModelException {
        _root = new FileNode(this, _getFilePropertyValue());
    }
*/
    void setupFilenameFilter_() {
        FileNode node = (FileNode)_root;
        node.setFilenameFilter(new ExcludesFilenameFilter("*.stamp"));
    }

    void setupOptions_() {
        _setupOptions();
    }

    protected IRTreeModelNode _newNode(String name) throws RModelException {
        return new FileNode(name, this);
    }

    protected IRTreeModelNode _newRootNode() throws RModelException {
        return new FileNode(this, _getFilePropertyValue());
    }

/*
    public IRTreeModelNode newNode(String name) throws RModelException {
        return (new FileNode(name, this));
    }
*/
}
