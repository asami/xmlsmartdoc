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
package org.relaxer.framework.runtime.model;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.relaxer.framework.RelaxerFrameworkErrorException;
import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.framework.runtime.messager.IRFrameworkMessager;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.FileDataSource;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;
import org.relaxer.framework.runtime.model.datasource.NullDataSource;
import org.relaxer.framework.runtime.models.workspace.WorkspaceBag;
import org.relaxer.framework.runtime.models.workspace.WorkspaceContent;
import org.relaxer.framework.runtime.reporter.IRFrameworkReporter;

import com.AsamiOffice.io.UURL;

/**
 * AbstractRModel
 *
 * @since   Jan.  2, 2004
 * @version Oct. 16, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRModel implements IRModel {
    private String name_;
    protected final IRModelContext _context;
    protected final IRFrameworkLogger _logger;
    protected final IRFrameworkMessager _messager;
    protected final IRFrameworkReporter _reporter;
    private final Map properties_ = new HashMap();
    private IRDataSource dataSource_;
    private int openCount_ = 0;
    private boolean dirty_ = false;

/*
    protected AbstractRModel() {
        context_ = new NullModelContext();
        logger_ = new NoneLogger();
    }
*/

    protected AbstractRModel(IRModelContext context) throws RModelException {
        _context = context;
        _logger = _context.getLogger();
        _messager = _context.getMessager();
        _reporter = _context.getReporter();
    }

    protected AbstractRModel(IRModelContent content, IRModelContext context) throws RModelException {
        this(context);
        setProperty(PROPERTY_CONTENT, content);
    }

    protected AbstractRModel(IRModelNode node, IRModelContext context) throws RModelException {
        this(context);
        setProperty(PROPERTY_NODE, node);
    }

    protected AbstractRModel(File file, IRModelContext context) throws RModelException {
        this(context);
        setProperty(PROPERTY_FILE, file);
    }

    protected AbstractRModel(URL url, IRModelContext context) throws RModelException {
        this(context);
        setProperty(PROPERTY_URL, url);
    }

    public AbstractRModel(IRDataSource dataSource, IRModelContext context) throws RModelException {
        this(context);
        setProperty(PROPERTY_DATASOURCE, dataSource);
    }

    protected AbstractRModel(Map properties, IRModelContext context) throws RModelException {
        this(context);
        if (properties != null) {
            properties_.putAll(properties);
        }
    }

    protected void _setupOptions() {
    }

    public final void setName(String name) {
        name_ = name;
    }

    public final String getName() {
        return name_;
    }

    public final IRModelContent getModelContent() throws RModelException {
        IRModelContent content = _getModelContent();
        if (content != null) {
            return content;
        }
        WorkspaceBag bag = new WorkspaceBag();
        OutputStream out = null;
        try {
            out = bag.openOutputStream();
            _writeContent(out);
            out.flush();
        } catch (IOException e) {
            throw new RModelException(e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        content = new WorkspaceContent(bag, _context);
        return content;
    }

    protected IRModelContent _getModelContent() throws RModelException {
        return null;
    }

    // _writeContent must not close the OutputStream.
    protected void _writeContent(OutputStream out) throws RModelException {
    }

    protected final IRDataSource _getDataSource() {
        return dataSource_;
    }

    public final void open() throws RModelException {
        if (openCount_++ > 0) {
            return;
        }
        dataSource_ = createDataSource_();
        _open();
        _context.openModel(this);
    }

    protected void _open() throws RModelException {
    }

    public final void close() throws RModelException {
        if (openCount_ <= 0) {
            throw new RelaxerFrameworkErrorException();
        }
        if (--openCount_ > 0) {
            return;
        }
        _close();
        dataSource_ = null;
        _context.closeModel(this);
    }

    protected void _close() throws RModelException {
    }
    
    protected final void _setDirty() {
        dirty_ = true;
    }
    
    public final boolean isDirty() {
        if (dirty_) {
            return true;
        }
        return _isDirty();
    }

    protected boolean _isDirty() {
        return false;
    }

    public final void commit() throws RModelException {
        _commitAlways();
        if (dirty_) {
            _commitDirty();
            dirty_ = false;
        }
    }

    protected void _commitAlways() throws RModelException {
    }

    protected void _commitDirty() throws RModelException {
    }

    public final void rollback() throws RModelException {
        _rollback();
        dirty_ = false;
    }

    protected void _rollback() throws RModelException {
    }

    public final void create() throws RModelException {
        if (openCount_++ != 0) {
            throw new RModelException("Illegal state exception");
        }
        dataSource_ = createDataSource_();
        _create();
        _context.createModel(this);
    }

    protected void _create() throws RModelException {
    }

    public final void delete() throws RModelException {
        _delete();
    }

    protected void _delete() throws RModelException {
    }

/*
    public final IRModelContent getContent() {
        return _getContent();
    }

    protected IRModelContent _getContent() {
        return null;
    }
*/

    public final IRModelContext getModelContext() {
        return _context;
    }
    
//    public final String getTextEncoding() {
//        return (textEncoding_);
//    }
    
//    public final void setTextEncoding(String textEncoding) {
//        textEncoding_ = textEncoding;
//    }

    public final Object getProperty(String name) {
        return (properties_.get(name));
    }
    
    public final String getProperty_String(String name) {
    	Object value = getProperty(name);
    	if (value == null) {
    		return null;
    	}
    	return value.toString();
    }

    public final void setProperty(String name, Object value) {
        properties_.put(name, value);
    }
    
    public final Map getProperties() {
    	return Collections.unmodifiableMap(properties_);
    }
    
    public final void setProperties(Map properties) {
    	properties_.putAll(properties);
    }

    protected final RModelException _modelUsageError(String message) {
        _logger.warning(message);
        return (new RModelException(message));
    }

    protected final RModelException _ioError(String message, IOException e) {
        _logger.warning(message, e);
        return (new RModelException(e));
    }

    private IRDataSource createDataSource_() throws RModelException {
        IRDataSource ds = null;
        Object value = getProperty(PROPERTY_NODE);
        if (value != null) {
            ds = createDataSource_((IRModelNode)value);
            if (ds != null) {
                return ds;
            }
        }
        value = getProperty(PROPERTY_CONTENT);
        if (value != null) { 
            ds = createDataSource_((IRModelContent)value);
            if (ds != null) {
                return ds;
            }
        }
        value = getProperty(PROPERTY_DATASOURCE);
        if (value != null) { 
            ds = createDataSource_((IRDataSource)value);
            if (ds != null) {
                return ds;
            }
        }
        value = getProperty(PROPERTY_FILE);
        if (value != null) {
            ds = createDataSource_((File)_getFileByPropertyValue(value));
            if (ds != null) {
                return ds;
            }
        }
        value = getProperty(PROPERTY_URL);
        if (value != null) {
            throw new UnsupportedOperationException(); // TODO
        }
        if (ds == null) {
            ds = NullDataSource.getDataSource(); 
        }
        return ds; 
    }

    private IRDataSource createDataSource_(IRModelNode node) throws RModelException {
        IRDataSource ds = node.getDataSource();
        if (ds instanceof NullDataSource) {
            return null;
        }
        return ds;
    }

    private IRDataSource createDataSource_(IRModelContent content) throws RModelException {
        IRDataSource ds = content.getDataSource();
        if (ds instanceof NullDataSource) {
            return null;
        }
        return ds;
/*
        if (content instanceof FileContent) {
            FileContent fileContent = (FileContent)content;
            return new FileDataSource(fileContent.getFile(), _context);
        } else if (content instanceof UrlContent) {
            UrlContent urlContent = (UrlContent)content;
            return new UrlDataSource(urlContent.getUrl(), _context);
        } else {
            return null;
        }
*/
    }

    private IRDataSource createDataSource_(IRDataSource dataSource) {
        return dataSource;
    }

    private IRDataSource createDataSource_(File file) {
        return new FileDataSource(file, _context);
    }

    protected final File _getFilePropertyValue() throws RModelException {
        Object fileValue = getProperty(PROPERTY_FILE);
        return _getFileByPropertyValue(fileValue);
    }

    protected final File _getFileByPropertyValue(Object fileValue) throws RModelException {
        if (fileValue == null) {
            throw (_modelUsageError("Slot 'file' is not specified."));
        }
        if (fileValue instanceof String) {
            if ("".equals(fileValue)) {
                throw (_modelUsageError("Slot 'file' is empty."));
            }
            File file = UURL.getFileFromFileOrURLName((String)fileValue);
            if (file == null) {
                throw (_modelUsageError("Slot 'file' is invalid value : " + fileValue));
            }
            return file;
        } else if (fileValue instanceof File) {
            return (File)fileValue;
        } else if (fileValue instanceof URL) {
            URL url = (URL)fileValue;
            File file = UURL.getActiveFile(url);
            if (file == null) {
                throw (_modelUsageError("Slot 'file' is invalid URL as file: '" + 
                                        url.toExternalForm() + '"'));
            }
            return file;
        } else {
            throw (_modelUsageError("Slot 'file' is invalid class: '" + 
                                    fileValue.getClass() + '"'));
        }
    }
}
