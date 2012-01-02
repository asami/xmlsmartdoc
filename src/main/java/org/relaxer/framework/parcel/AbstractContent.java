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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.w3c.dom.Document;

import com.AsamiOffice.io.UIO;

/**
 * AbstractContents
 *
 * @since   Oct.  1, 2003
 * @version Dec. 17, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractContent implements IContent {
    protected String encoding_ = "UTF-8";
    
    protected AbstractContent() {
    }

    protected AbstractContent(String encoding) {
        encoding_ = encoding;
    }

    public byte[] getBinary() throws IOException, ParcelException {
        InputStream in = null;
        try {
            in = getInputStream();
            return (UIO.stream2Bytes(in));
        } catch (UnsupportedEncodingException e) {
            throw (new ParcelException(e));
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public Reader getReader() throws IOException, ParcelException {
        return (new InputStreamReader(getInputStream(), encoding_));
    }

    public String getString() throws IOException, ParcelException {
        InputStream in = null;
        try {
            in = getInputStream();
            return (UIO.stream2String(in, encoding_));
        } catch (UnsupportedEncodingException e) {
            throw (new ParcelException(e));
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public Document getDocument() {
        throw (new UnsupportedOperationException());
    }
}
