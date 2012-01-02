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
package org.relaxer.framework.runtime.model.content;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.FileDataSource;

/**
 * FileContent
 *
 * @since   Jan.  3, 2004
 * @version Aug. 20, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FileContent extends AbstractRModelContent {
    private final File file_;

    public FileContent(File file, IRModelContext context) {
        super(new FileDataSource(file, context), context);
        file_ = file;
    }

    public boolean isValue() {
        return false;
    }

    public Object getValue() {
        return null;
    }

    public boolean isBinary() {
        return (true);
    }
    
    protected long _getSize() {
        return file_.length();
    }

    protected InputStream _openInputStream() throws RModelException {
        try {
            return _dataSource.openInputStream();
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }
/*
    public InputStream getInputStream() throws RModelException {
        try {
            return (new FileInputStream(file_));
        } catch (FileNotFoundException e) {
            throw (new RModelException(e));
        }
    }
*/
    public Object getSource() {
        return (file_);
    }

    protected long _getHintSize() {
        return (file_.length());
    }

    public File getFile() {
        return file_;
    }
}
