/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.models.fs;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

import org.relaxer.framework.runtime.model.AbstractRTreeModelNode;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.IRTreeModel;
import org.relaxer.framework.runtime.model.IRTreeModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.FileContent;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.datasource.FileDataSource;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;

import com.AsamiOffice.io.UFile;

/**
 * FileNode
 *
 * @since   Mar. 18, 2004
 * @version Aug. 15, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FileNode extends AbstractRTreeModelNode {
    private File file_;
    transient private IRDataSource dataSource_ = null;
    private FilenameFilter filenameFilter_;
    private FileFilter fileFilter_;

    public FileNode(IRTreeModel model, File file) {
        super(model);
        file_ = file;
    }

    public FileNode(String fileName, IRTreeModel model) {
        super(fileName, model);
        file_ = null;
    }

    public FileNode(String fileName, File file, IRTreeModel model) { 
        super(fileName, model);
        file_ = file;
    }
    
    
    protected String _getSuffix() throws RModelException {
        try {
            return _getDataSource().getSuffix();
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    protected IRDataSource _getDataSource() throws RModelException {
        if (dataSource_ != null) {
            return dataSource_;
        }
        ensureFile_();
        IRModelContent content = getContent();
        if (content != null) {
            return content.getDataSource();
        }
        dataSource_ = new FileDataSource(file_, _model.getModelContext()); 
        return dataSource_;
    }

    public FileFilter getFileFilter() {
        return (fileFilter_);
    }

    public FilenameFilter getFilenameFilter() {
        return (filenameFilter_);
    }

    public void setFileFilter(FileFilter filter) {
        fileFilter_ = filter;
    }

    public void setFilenameFilter(FilenameFilter filter) {
        filenameFilter_ = filter;
    }

/*
    protected Boolean _isContainer() throws RModelException {
        if (file_ != null) {
            return (Boolean.valueOf(file_.isDirectory()));
        } else {
            return (null);
        }
    }
*/

    protected IRModelContent _loadContent() throws RModelException {
        ensureFile_();
        if (!file_.exists()) {
            return (null);
        }
        if (file_.isDirectory()) {
            return (null);
        }
        return (new FileContent(file_, _model.getModelContext()));        
    }

    protected IRTreeModelNode[] _loadChildren() throws RModelException {
        ensureFile_();
        if (!file_.exists()) {
            return (null);
        }
        if (file_.isFile()) {
            return (null);
        }
        FileFilter fileFilter = _getFileFilter();
        FilenameFilter nameFilter = _getFilenameFilter();
        if (fileFilter != null) {
            File[] files = file_.listFiles(fileFilter);
            IRTreeModelNode[] children = new IRTreeModelNode[files.length];
            for (int i = 0;i < files.length;i++) {
                File file = files[i];
                children[i]= new FileNode(file.getName(), file, getModel());
            }
            return (children);
        } else {
            String[] names;
            if (nameFilter != null) {
                names = file_.list(nameFilter);
            } else {
                names = file_.list();
            }
            IRTreeModelNode[] children = new IRTreeModelNode[names.length];
            for (int i = 0;i < names.length;i++) {
                String name = names[i];
                children[i]= new FileNode(name, getModel());
            }
            return (children);
        }
    }

    protected FilenameFilter _getFilenameFilter() throws RModelException {
        if (filenameFilter_ != null) {
            return (filenameFilter_);
        }
        IRTreeModelNode parent = getParent();
        if (parent == null) {
            return (null);
        }
        if (!(parent instanceof FileNode)) {
            return (null);
        }
        return (((FileNode)parent).getFilenameFilter());
    }

    protected FileFilter _getFileFilter() throws RModelException {
        if (fileFilter_ != null) {
            return (fileFilter_);
        }
        IRTreeModelNode parent = getParent();
        if (parent == null) {
            return (null);
        }
        if (!(parent instanceof FileNode)) {
            return (null);
        }
        return (((FileNode)parent).getFileFilter());
    }

    private void ensureFile_() throws RModelException {
        if (file_ != null) {
            return;
        }
        IRModelNode parent = getParent();
        if (!(parent instanceof FileNode)) {
             throw (new RModelException(parent.toString()));
        }
        File parentFile = ((FileNode)parent).getFile();
        file_ = new File(parentFile, _getAdjustedName());
    }

    public File getFile() throws RModelException {
        ensureFile_();
        return (file_);
    }

    protected void _commitDirtyTree() throws RModelException {
//System.out.println("FileNode._commit()");
        try {
            IRTreeModelNode[] removes = _getRemoves();
            for (int i = 0;i < removes.length;i++) {
                FileNode node = (FileNode)removes[i];
                File file = node.getFile();
                _removeFile(file);
            }
            File file = getFile();
            if (isContainer()) {
                _makeDirectory(file);
            } else {
                _makeFile(file);
            }
        } catch (IOException e) {
            throw (new RModelException(e));
        } finally {
        }
    }

    protected void _makeFile(File file) throws RModelException {
        try {
            UFile.createFile(file, getContent().openInputStream());
        } catch (IOException e) {
            throw (new RModelException(e));
        }
/*        
        try {
            String encoding = _treeModel.getModelContext().getTextEncoding();
            if (encoding != null) {
                UFile.createFile(file, getContent().getInputStream(encoding));
            } else {
                UFile.createFile(file, getContent().getInputStream());
            }
        } catch (IOException e) {
            throw (new RModelException(e));
        }
*/
    }

    protected void _makeDirectory(File file) {
        file.mkdir();
    }

    protected void _removeFile(File file) throws RModelException {
        try {
//            System.out.println("_removeFile = " + file.getAbsolutePath());
            UFile.deleteWholeFiles(file);
        } catch (IOException e) {
            throw (new RModelException(e));
        }
    }
}
