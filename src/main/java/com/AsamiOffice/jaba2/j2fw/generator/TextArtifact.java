/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@asamiOffice.com)
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

package com.AsamiOffice.jaba2.j2fw.generator;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.AsamiOffice.io.UFile;

/**
 * TextArtifact
 *
 * @since   Aug.  2, 1999
 * @version Feb.  4, 2004
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public class TextArtifact extends GeneratorArtifact {
    protected String content_;
    protected String encoding_;

    public TextArtifact(String name, String content) {
        super(name);
        if (name == null) {
            throw (new IllegalArgumentException());
        }
        if (content == null) {
            throw (new IllegalArgumentException());
        }
        content_ = content;
        encoding_ = "UTF-8";
    }

    public TextArtifact(String name, String content, String encoding) {
        super(name);
        if (name == null) {
            throw (new IllegalArgumentException());
        }
        if (content == null) {
            throw (new IllegalArgumentException());
        }
        if (encoding == null) {
            throw (new IllegalArgumentException());
        }
        content_ = content;
        encoding_ = encoding;
        if (encoding.equals("link")) { // XXX
            throw (new InternalError());
        }
    }

/*
    public File makeFile(File dir) throws IOException {
        File file = new File(dir, name_);
        UFile.createFile(file, content_, encoding_);
        return (file);
    }
*/  

    protected void _createFile(File file) throws IOException {
        UFile.createFile(file, content_, encoding_);
    }

    public void outputStream(OutputStream out) throws IOException {
        OutputStreamWriter writer;
        if (encoding_ != null) {
            writer = new OutputStreamWriter(out, encoding_);
        } else {
            writer = new OutputStreamWriter(out);
        }
        out.write(content_.getBytes());
        out.flush();
    }

    public byte[] getBytes() throws IOException {
        return (content_.getBytes(encoding_));
    }

    public String getEncoding() {
        return (encoding_);
    }

    public String getString() {
        return (content_);
    }

    public void addCopyright(String copyright) {
        content_ = copyright + content_;
    }
}
