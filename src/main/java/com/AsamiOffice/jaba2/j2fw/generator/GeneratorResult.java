/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

import java.util.*;
import java.io.*;
import com.AsamiOffice.jaba2.util.PropertyList;

/**
 * GeneratorResult
 *
 * @since   Apr. 19, 1999
 * @version Sep. 30, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class GeneratorResult {
    private List temporaryFiles_ = new ArrayList();
    public Object packageArgument;
    public List artifacts = new ArrayList();
    public PropertyList properties = new PropertyList();

    public void addArtifact(String name, String content) {
	addArtifact(new TextArtifact(name, content));
    }

    public void addArtifact(String name, String content, String encoding) {
	addArtifact(new TextArtifact(name, content, encoding));
    }

    public void addArtifact(String name, byte[] content) {
	addArtifact(new BinaryArtifact(name, content));
    }

    public void addArtifact(GeneratorArtifact artifact) {
	String name = artifact.getName();
	if (getArtifact(name) != null) {
	    return;
	}
	artifacts.add(artifact);
    }

    public void addArtifacts(GeneratorArtifact[] artifacts) {
	for (int i = 0;i < artifacts.length;i++) {
	    addArtifact(artifacts[i]);
	}
    }

    public GeneratorArtifact[] getArtifacts() {
	GeneratorArtifact[] result = new GeneratorArtifact[artifacts.size()];
	return ((GeneratorArtifact[])artifacts.toArray(result));
    }

    public GeneratorArtifact getArtifact(String name) {
	int size = artifacts.size();
	for (int i = 0;i < size;i++) {
	    GeneratorArtifact artifact = (GeneratorArtifact)artifacts.get(i);
	    if (name.equals(artifact.getName())) {
		return (artifact);
	    }
	}
	return (null);
    }

    public void addTemporaryFile(File file) {
        temporaryFiles_.add(file);
    }

    public void cleanup() throws IOException {
        Object[] files = temporaryFiles_.toArray();
        for (int i = 0;i < files.length;i++) {
            File file = (File)files[i];
            _removeFile(file);
        }
    }

    private void _removeFile(File parent) throws IOException {
        File[] children = parent.listFiles();
        if (children != null) {
            for (int i = 0;i < children.length;i++) {
                _removeFile(children[i]);
            }
        }
        parent.deleteOnExit();
        parent.delete();
    }

    public void addProperty(String name, Object value) {
	properties.put(name, value);
    }

    public Object getProperty(String name) {
	return (properties.get(name));
    }
}
