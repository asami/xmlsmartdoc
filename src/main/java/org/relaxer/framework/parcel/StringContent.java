/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
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
package org.relaxer.framework.parcel;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

/**
 * StringContent
 *
 * @since   Oct.  1, 2003
 * @version Dec. 17, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class StringContent extends AbstractContent {
    private final String string_;

    public StringContent(String string) {
        string_ = string;
    }

    public StringContent(String string, String encoding) {
        super(encoding);
        string_ = string;
    }

    public StringContent(StringBuffer buffer) {
        string_ = new String(buffer);
    }

    public StringContent(StringBuffer buffer, String encoding) {
        super(encoding);
        string_ = new String(buffer);
    }

    public boolean isBinary() {
        return (true);
    }

    public InputStream getInputStream() throws ParcelException {
        ByteArrayInputStream in = null;
        try {
            in = new ByteArrayInputStream(string_.getBytes(encoding_));
        } catch (UnsupportedEncodingException e) {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ee) {
                }
            }
            throw (new ParcelException(e));
        }
        return (in);
    }

    public byte[] getBinary() throws ParcelException {
        try {
            return (string_.getBytes(encoding_));
        } catch (UnsupportedEncodingException e) {
            throw (new ParcelException(e));
        }
    }

    public boolean isText() {
        return (true);
    }

    public Reader getReader() {
        StringReader reader = new StringReader(string_);
        return (reader);
    }

    public String getString() {
        return (string_);
    }

    public boolean isXml() {
        return (false);
    }

    public Object getSource() {
        return (string_);
    }
}
