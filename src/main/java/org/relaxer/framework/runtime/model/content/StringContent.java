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

import java.io.Reader;
import java.io.StringReader;

import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.StringDataSource;

/**
 * StringContent
 *
 * @since   Oct.  1, 2003
 * @version Oct.  5, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class StringContent extends AbstractRModelContent {
    private final String string_;

    public StringContent(String string, IRModelContext context) {
        super(new StringDataSource(string, context), context);
        if (string == null) {
            throw new IllegalArgumentException();
        }
        string_ = string;
    }

/*
    public StringContent(String string, String encoding, IRModelContext context) {
        super(encoding, context);
        string_ = string;
    }

    public StringContent(StringBuffer buffer, IRModelContext context) {
        super(new StringDataSource(buffer.toString(), context), context);
        string_ = buffer.toString();
    }

    public StringContent(StringBuffer buffer, String encoding, IRModelContext context) {
        super(encoding, context);
        string_ = new String(buffer);
    }
*/

    public boolean isValue() {
        return true;
    }

    public Object getValue() {
        return string_;
    }

    public boolean isBinary() {
        return (true);
    }

/*
    public InputStream getInputStream() throws RModelException {
        ByteArrayInputStream in = null;
        try {
            if (_encoding != null) {
                in = new ByteArrayInputStream(string_.getBytes(_encoding));
            } else {
                in = new ByteArrayInputStream(string_.getBytes());
            }
        } catch (UnsupportedEncodingException e) {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ee) {
                }
            }
            throw (new RModelException(e));
        }
        return (in);
    }

    public InputStream getInputStream(String encoding) throws RModelException {
        ByteArrayInputStream in = null;
        try {
            if (_encoding != null) {
                in = new ByteArrayInputStream(string_.getBytes(_encoding));
            } else {
                in = new ByteArrayInputStream(string_.getBytes(encoding));
            }
        } catch (UnsupportedEncodingException e) {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ee) {
                }
            }
            throw (new RModelException(e));
        }
        return (in);
    }

    public byte[] getBinary() throws RModelException {
        try {
            if (_encoding != null) {
                return (string_.getBytes(_encoding));
            } else {
                return (string_.getBytes());
            }
        } catch (UnsupportedEncodingException e) {
            throw (new RModelException(e));
        }
    }

    public byte[] getBinary(String encoding) throws RModelException {
        try {
            if (_encoding != null) {
                return (string_.getBytes(_encoding));
            } else {
                return (string_.getBytes(encoding));
            }
        } catch (UnsupportedEncodingException e) {
            throw (new RModelException(e));
        }
    }
*/

    public Boolean _isText() {
        return Boolean.TRUE;
    }

    protected Reader _openReader() {
        StringReader reader = new StringReader(string_);
        return (reader);
    }

    protected String _getText() {
        return (string_);
    }

/*
    public boolean isXml() {
        return (false);
    }
*/

    public Object getSource() {
        return (string_);
    }
}
