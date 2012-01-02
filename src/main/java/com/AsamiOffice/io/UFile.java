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

package com.AsamiOffice.io;

import java.util.*;
import java.io.*;
import java.net.*;
import com.AsamiOffice.text.UString;

/**
 * Utilites for File manipulation
 *
 * @since   Jul.  7, 1998
 * @version Feb. 17, 2004
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public final class UFile {
    public static void createFile(File file, InputStream is)
        throws IOException {

        OutputStream os = null;
        try {
            createParentDirectory(file);
            int chunk = 8192;
            byte[] buffer = new byte[chunk];
            os = new FileOutputStream(file);
            int rsize;
            while ((rsize = is.read(buffer)) != -1) {
                os.write(buffer, 0, rsize);
            }
            os.flush();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static void createFile(File file, String string)
        throws IOException {

        createParentDirectory(file);
        Writer writer = new FileWriter(file);
        writer.write(string, 0, string.length());
        writer.flush();
        writer.close();
    }

    public static void createFile(File file, String string, String encoding)
        throws IOException {

        createParentDirectory(file);
        Writer writer =
            new OutputStreamWriter(new FileOutputStream(file), encoding);
        writer.write(string, 0, string.length());
        writer.flush();
        writer.close();
    }

    public static void createFile(File file, byte[] data) throws IOException {

        createParentDirectory(file);
        OutputStream out = new FileOutputStream(file);
        out.write(data);
        out.close();
    }

    public static void copyFile(File src, File dest) throws IOException {
        FileInputStream in = null;
        try {
            if (isIdentical(src, dest)) {
                throw (new IOException("same file = " + src.toString()));
            }
            in = new FileInputStream(src);
            createFile(dest, in);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static void copyAllFiles(File src, File dest) throws IOException {
        if (!(src.isDirectory() && dest.isDirectory())) {
            throw (new IllegalArgumentException("not directory"));
        }
        String[] files = src.list(new FileFilenameFilter());
        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            copyFile(new File(src, files[i]), new File(dest, files[i]));
        }
    }

    public static void createDirectory(File dir) throws IOException {
        dir.mkdirs();
    }

    public static void createParentDirectory(File file) throws IOException {
        File dir = file.getParentFile();
        if (dir != null) {
            createDirectory(dir);
        }
    }

    /**
     * Makes new File object to create output file with new suffix.
     */
    public static File makeOutputFile(String filename, String suffix) {
        return (makeOutputFile(new File(filename), suffix));
    }

    /**
     * Makes new File object to create output file with new suffix.
     */
    public static File makeOutputFile(File file, String suffix) {
        File parent = file.getParentFile();
        String name = file.getName();
        String nameBody;
        int index = name.lastIndexOf(".");
        if (index == -1) {
            nameBody = name;
        } else {
            nameBody = name.substring(0, index);
        }
        return (new File(parent, nameBody + "." + suffix));
    }

    /**
     * Makes new File object to create output file with new suffix.
     */
    public static File makeOutputFile(URL url, String suffix) {
        if (!url.getProtocol().equals("file")) {
            throw (new IllegalArgumentException());
        }
        return (makeOutputFile(url.getFile(), suffix));
    }

    /**
     * Makes new File object to create output file with new suffix.
     */
    public static File makeOutputFile(
        String filename,
        String suffix,
        Locale locale) {
        return (makeOutputFile(new File(filename), suffix, locale));
    }

    /**
     * Makes new File object to create output file with new suffix.
     */
    public static File makeOutputFile(
        File file,
        String suffix,
        Locale locale) {
        File parent = file.getParentFile();
        String name = file.getName();
        String nameBody;
        int index = name.lastIndexOf(".");
        if (index == -1) {
            nameBody = name;
        } else {
            nameBody = name.substring(0, index);
        }
        return (new File(parent, nameBody + "_" + locale + "." + suffix));
    }

    /**
     * Makes new File object to create output file with new suffix.
     */
    public static File makeOutputFile(URL url, String suffix, Locale locale) {
        if (!url.getProtocol().equals("file")) {
            throw (new IllegalArgumentException());
        }
        return (makeOutputFile(url.getFile(), suffix, locale));
    }

    public static boolean isAbsolutePath(String child) {
        File file = new File(child);
        return (file.isAbsolute());
    }

    public static boolean isExist(String src) {
        try {
            URL url = UURL.getURLFromFileOrURLName(src);
            return (isExist(url));
        } catch (MalformedURLException e) {
            return (false);
        }
    }

    public static boolean isExist(URL url) {
        try {
            InputStream in = url.openStream();
            in.close();
            return (true);
        } catch (IOException e) {
            return (false);
        }
    }

    public static boolean isIdentical(File lhs, File rhs) throws IOException {

        return (lhs.getCanonicalPath().equals(rhs.getCanonicalPath()));
    }

    public static File[] listFilesAsFile(File dir) {
        String[] names = dir.list();
        if (names == null) {
            return (new File[0]);
        }
        return (listFilesAsFile(dir, names));
    }

    public static File[] listFilesAsFile(File dir, FilenameFilter filter) {
        String[] names = dir.list(filter);
        if (names == null) {
            return (new File[0]);
        }
        return (listFilesAsFile(dir, names));
    }

    public static File[] listFilesAsFile(File dir, String[] names) {
        File[] files = new File[names.length];
        for (int i = 0; i < names.length; i++) {
            files[i] = new File(dir, names[i]);
        }
        return (files);
    }

    /**
     * @deprecated
     * @see UString
     */
    public static String getSuffix(String file) {
        int index = file.lastIndexOf(".");
        if (index == -1) {
            return (null);
        }
        return (file.substring(index + 1));
    }

    public static File changeSuffix(File file, String suffix) {
        return (new File(UString.changeSuffix(file.getPath(), suffix)));
    }

    public static String getRelativePathname(String uri) {
        String dir = System.getProperty("user.dir");
        if (dir == null) {
            throw (new InternalError());
        }
        dir = dir.replace('\\', '/'); // XXX
        if (!dir.endsWith("/")) {
            dir = dir + "/";
        }
        int index = uri.indexOf(dir);
        if (index == -1) {
            return (UString.getLastComponent(uri)); // XXX
        } else {
            return (uri.substring(index + dir.length()));
        }
    }

    public static File createTempDir(String prefix) throws IOException {
        File dir = File.createTempFile(prefix, ".d");
        dir.delete();
        dir.mkdir();
        dir.deleteOnExit();
        return (dir);
    }

    public static File createTempDir(String prefix, File parent) throws IOException {
        File dir = File.createTempFile(prefix, ".d", parent);
        dir.delete();
        dir.mkdir();
        dir.deleteOnExit();
        return (dir);
    }

    public static void deleteWholeFiles(File file) throws IOException {
        File[] children = file.listFiles();
        if (children != null) {
            for (int i = 0; i < children.length; i++) {
                deleteWholeFiles(children[i]);
            }
        }
        file.deleteOnExit();
        file.delete();
    }

    public static void deleteWholeFilesInTempDir(File file) throws IOException {
        File dummy = File.createTempFile("dummy", ".temp");
        File tempDir = dummy.getParentFile();
        if (!file.getAbsolutePath().startsWith(tempDir.getAbsolutePath())) {
            throw (new IllegalArgumentException(file + "/" + tempDir));
        }
        deleteWholeFiles(file);
        dummy.delete();
    }
}
