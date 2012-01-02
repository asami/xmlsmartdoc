/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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
import java.util.ArrayList;
import java.util.List;

import com.AsamiOffice.io.UFile;

/**
 * GeneratorArtifact
 *
 * @since   Apr. 29, 1999
 * @version Feb.  4, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class GeneratorArtifact {
    public String name_;
    private boolean force_ = true;
    private String sample_;
    List generatedFiles_ = new ArrayList();

    protected GeneratorArtifact(String name) {
        name_ = name;
    }

    public String getName() {
        return (name_);
    }

    public File makeFile() throws IOException {
        return (makeFile(new File(".")));
    }

    public File makeFile(File dir) throws IOException {
//System.out.println("makeFile:" + name_ + ", " + force_ + ", " + sample_);
        File file = new File(dir, name_);
        if (!file.exists() || force_) { 
//System.out.println("createFile:" + file);
            _createFile(file);
            generatedFiles_.add(file);
        } else {
            file = null;
        }
        if (sample_ != null) {
            File sample = new File(dir, name_ + "." + sample_);
//System.out.println("createSample:" + sample);
            _createFile(sample);
            generatedFiles_.add(sample);
            if (file == null) {
                file = sample;
            }
        }
        return (file);
    }

    protected void _createFile(File file) throws IOException {
        UFile.createFile(file, getBytes());
    }

    public void outputStream(OutputStream out) throws IOException {
        out.write(getBytes());
        out.flush();
    }

    public abstract byte[] getBytes() throws IOException;

    public void setForce(boolean force) {
        force_ = force;
    }

    public void setSample(String sample) {
        sample_ = sample;
    }

    public String[] generatedNames() {
        String[] names = new String[generatedFiles_.size()];
        for (int i = 0; i < names.length; i++) {
            File file = (File)generatedFiles_.get(i);
            names[i] = file.getName();
        }
        return (names);
    }
}
