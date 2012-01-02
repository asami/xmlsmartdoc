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

package com.AsamiOffice.jaba2.j2fw.generator.packager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.IPackager;

/**
 * JarPackager
 *
 * @since   May. 10, 1999
 * @version Oct. 15, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class JarPackager implements IPackager {
    public void pack(
        GeneratorArtifact[] artifacts,
        GeneratorResult result,
        String id,
        Object arg,
        File dest)
        throws IOException {
        String jarfile = (String)arg;
        if (!jarfile.endsWith(".jar")) {
            jarfile = jarfile + ".jar";
        }
        String manifestContent = (String)result.getProperty("manifest");
        Manifest manifest;
        if (manifestContent != null) {
            InputStream in = new StringBufferInputStream(manifestContent);
            manifest = new Manifest(in);
            in.close();
        } else {
            manifest = new Manifest();
        }
        JarOutputStream jarout =
            new JarOutputStream(
                new BufferedOutputStream(
                    new FileOutputStream(new File(dest, jarfile))),
                manifest);
        for (int i = 0; i < artifacts.length; i++) {
            GeneratorArtifact artifact = artifacts[i];
            ZipEntry entry = new ZipEntry(artifact.getName());
            byte[] content = artifact.getBytes();
            entry.setSize(content.length);
            jarout.putNextEntry(entry);
            jarout.write(content, 0, content.length);
        }
        jarout.close();
    }
}
