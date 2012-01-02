/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@AsamiOffice.com)
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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.AsamiOffice.io.UFile;
import com.AsamiOffice.io.UIO;

/**
 * LinkArtifact
 *
 * @since   Aug.  2, 1999
 * @version Mar. 17, 2004
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class LinkArtifact extends GeneratorArtifact {
    public String from_;
    private File destDir_;

    public LinkArtifact(String name, String from) {
        super(name);
        from_ = from;
    }

    public File makeFile(File dir) throws IOException {
        if (destDir_ != null) {
            dir = destDir_;
        }
        File to = new File(dir, name_);
        File from = new File(from_);
        if (!from.exists()) {
            return (null);
        }
        if (UFile.isIdentical(to, from)) {
            return (null);
        }
        if (from.lastModified() != to.lastModified() ||
            from.length() != to.length()) {

            UFile.copyFile(from, to);
            return (to);
        }
        return (null);
    }

    public void outputStream(OutputStream out) throws IOException {
        UIO.concatStreams(new FileInputStream(from_), out);
    }

    public byte[] getBytes() throws IOException {
        return (UIO.file2Bytes(from_));
    }

    public void setDestDir(File destDir) {
        destDir_ = destDir;
    }
}
