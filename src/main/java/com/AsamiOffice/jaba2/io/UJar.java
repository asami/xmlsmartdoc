/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1999  ASAMI, Tomoharu (tasami@ibm.net)
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

package com.AsamiOffice.jaba2.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

import com.AsamiOffice.io.UFile;
import com.AsamiOffice.io.UIO;

/**
 * UJar
 *
 * @since   Aug. 22, 1999
 * @version Sep.  5, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public final class UJar {

    public static byte[] makeAsBytes(File[] files) throws IOException {
	return (makeAsBytes(files, new File(".")));
    }

    public static byte[] makeAsBytes(File[] files, File root)
    throws IOException {

    	Manifest manifest = new Manifest();
	ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	JarOutputStream archive = new JarOutputStream(
	    buffer,
	    manifest
	);
	append(archive, files, root);
	archive.close();
	return (buffer.toByteArray());
    }

    public static void append(JarOutputStream jar, File[] files)
	throws IOException {

	append(jar, files, new File("."));
    }

    public static void append(JarOutputStream jar, File[] files, File root)
	throws IOException {

	for (int i = 0;i < files.length;i++) {
	    File file = files[i];
	    String path = file.getPath();
	    file = new File(root, path);
	    if (file.isDirectory()) {
		path += "/";
	    }
	    path = path.replace('\\', '/');
// System.out.println(path);
// System.out.println(file);
	    ZipEntry entry = new ZipEntry(path);
	    if (file.isFile()) {
		byte[] content = UIO.file2Bytes(file);
		entry.setSize(content.length);
		jar.putNextEntry(entry);
		jar.write(content);
	    } else {
		jar.putNextEntry(entry);
	    }
	}
	jar.flush();
    }

    public static void append(JarOutputStream out, JarInputStream in)
	throws IOException {

	JarEntry entry;
	while ((entry = in.getNextJarEntry()) != null) {
	    String name = entry.getName();
	    if (!name.endsWith("/")) {
		byte[] data = UIO.stream2Bytes(in);
		entry.setSize(data.length);
		out.putNextEntry(entry);
		out.write(data);
	    } else {
		out.putNextEntry(entry);
	    }
	}
	out.flush();
    }

    public static void extract(InputStream in) throws IOException {
	extract(in, new File("."));
    }

    public static void extract(InputStream in, File dir) throws IOException {
	if (!(in instanceof BufferedInputStream)) { // idiom
	    in = new BufferedInputStream(in);
	}
	extract(new JarInputStream(in), dir);
    }

    public static void extract(JarInputStream jar, File dir)
	throws IOException {

	dir.mkdirs();
	JarEntry entry;
	while ((entry = jar.getNextJarEntry()) != null) {
	    String name = entry.getName();
	    File target = new File(dir, name);
	    if (name.endsWith("/")) {
		target.mkdir();
	    } else {
		UFile.createParentDirectory(target);
		OutputStream out = new FileOutputStream(target);
		byte[] data = UIO.stream2Bytes(jar);
		out.write(data);
		out.close();
	    }
	}
    }
}
