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

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import org.relaxer.framework.URelaxerObject;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * ObjectContent
 *
 * @since   Aug.  7, 2004
 * @version Aug. 20, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ObjectContent extends AbstractRModelContent {
    private final Object object_;
    private IRModelContent delegate_ = null;

    public ObjectContent(Object object, IRModelContext context) {
        super(context);
        if (object == null) {
            throw (new IllegalArgumentException("Null object"));
        }
        object_ = object;
        if (URelaxerObject.isRelaxerObject(object)) {
            delegate_ = new RelaxerObjectContent(object, context);
        }
    }

    public boolean isValue() {
        if (delegate_ != null) {
            return delegate_.isValue();
        } else {
            return false;
        }
    }

    public Object getValue() {
        if (delegate_ != null) {
            return delegate_.getValue();
        } else {
            return null;
        }
    }

    public boolean isBinary() {
        if (delegate_ != null) {
            return (delegate_.isBinary());
        } else {
            return (false);
        }
    }

    protected InputStream _openInputStream() throws RModelException {
        if (delegate_ != null) {
            return (delegate_.openInputStream());
        } else {
            throw (new UnsupportedOperationException());
        }
    }

    protected byte[] _getBinary() throws RModelException {
        if (delegate_ != null) {
            return (delegate_.getBinary());
        } else {
            throw (new UnsupportedOperationException());
        }
    }

    protected Boolean _isText() {
        if (delegate_ != null) {
            return Boolean.valueOf(delegate_.isText());
        } else {
            return (null);
        }
    }

    protected Reader _openReader() throws RModelException {
        if (delegate_ != null) {
            return (delegate_.openReader());
        } else {
            StringReader reader = new StringReader(object_.toString());
            return (reader);
        }
    }

    protected String _getText() throws RModelException {
        if (delegate_ != null) {
            return (delegate_.getText());
        } else {
            return (object_.toString());
        }
    }

    protected Boolean _isXml() {
        if (delegate_ != null) {
            return (Boolean.valueOf(delegate_.isXml()));
        } else {
            return (null);
        }
    }

    public Object getSource() {
        return (object_);
    }

/*
    public boolean isList() {
        if (delegate_ != null) {
            return delegate_.isList();
        } else {
            return false;
        }
    }

    public IRListModel getList() throws RModelException {
        if (delegate_ != null) {
            return delegate_.getList();
        } else {
            return null;
        }
    }

    public boolean isTable() {
        if (delegate_ != null) {
            return delegate_.isTable();
        } else {
            return false;
        }
    }

    public IRTableModel getTable() throws RModelException {
        if (delegate_ != null) {
            return delegate_.getTable();
        } else {
            return null;
        }
    }

    public boolean isTree() {
        if (delegate_ != null) {
            return delegate_.isTree();
        } else {
            return false;
        }
    }

    public IRTreeModel getTree() throws RModelException {
        if (delegate_ != null) {
            return delegate_.getTree();
        } else {
            return null;
        }
    }
*/
}
