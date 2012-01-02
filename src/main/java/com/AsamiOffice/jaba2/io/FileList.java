/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2000  ASAMI, Tomoharu (asami@zeomtech.com)
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

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import com.AsamiOffice.io.DirectoryFilenameFilter;

/**
 * FileList
 *
 * @since   Mar. 23, 1999
 * @version Aug. 29, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class FileList extends AbstractList {
    protected List files_ = new ArrayList(); // List<FilePath>

    public FileList(String dirName) throws IOException {
	this(new File(dirName));
    }

    public FileList(String dirName, Condition cond) throws IOException {
	this(new File(dirName), cond);
    }

    public FileList(File root) throws IOException {
	_searchDir(root, new Condition(), new FilePath(), files_);
    }

    public FileList(File root, Condition cond) throws IOException {
	_searchDir(root, cond, new FilePath(), files_);
    }

    public FileList(FilePath[] files) {
	for (int i = 0;i < files.length;i++) {
	    files_.add(files[i]);
	}
    }

    public int size() {
	return (files_.size());
    }

    public Object get(int index) {
	return (files_.get(index));
    }

    public File[] getAsFiles() {
	int size = files_.size();
	File[] files = new File[size];
	for (int i = 0;i < size;i++) {
	    FilePath path = (FilePath)files_.get(i);
	    files[i] = path.getFile();
	}
	return (files);
    }

    public FilePath[] getAsFilePaths() {
	FilePath[] paths = new FilePath[files_.size()];
	files_.toArray(paths);
	return (paths);
    }

    public FileList selectBySuffix(String suffix) {
	Condition cond = new Condition();
	cond.suffix = "." + suffix;
	return (select(cond));
    }

    public FileList select(Condition cond) {
	List list = new ArrayList();
	int size = files_.size();
	for (int i = 0;i < size;i++) {
	    FilePath path = (FilePath)files_.get(i);
	    File file = path.getFile();
	    if (cond.accept(file)) {
		list.add(path);
	    }
	}
	FilePath[] paths = new FilePath[list.size()];
	list.toArray(paths);
	return (new FileList(paths));
    }

    protected static void _searchDir(
	File dir,
	Condition cond,
	FilePath path,
	List names
    ) throws IOException {
	String[] files = dir.list(cond);
	String[] dirs = dir.list(new DirectoryFilenameFilter());
	for (int i = 0;i < files.length;i++) {
	    names.add(new FilePath(path, files[i]));
	}
	for (int i = 0;i < dirs.length;i++) {
	    _searchDir(
		new File(dir, dirs[i]),
		cond,
		new FilePath(path, dirs[i]),
		names
	    );
	}
    }

    public static class Condition implements FilenameFilter {
	public String suffix = null;
	public File baseDir = null;
	public FilePathList includes = null;
	public FilePathList excludes = null;

	// FilenameFilter
	public boolean accept(File dir, String name) {
	    return (accept(new File(dir, name)));
	}

	public boolean accept(File file) {
	    try {
		String target = file.getCanonicalPath();
		if (excludes != null) {
		    FilePath[] paths = excludes.getFilePaths();
		    for (int i = 0;i < paths.length;i++) {
			String check = paths[i].getFile().getCanonicalPath();
			if (target.startsWith(check)) {
			    return (false);
			}
		    }
		}
		if (includes != null) {
		    FilePath[] paths = includes.getFilePaths();
		    for (int i = 0;i < paths.length;i++) {
			String check = paths[i].getFile().getCanonicalPath();
			if (target.startsWith(check)) {
			    if (suffix != null) {
				if (target.endsWith(suffix)) {
				    return (true);
				} else {
				    return (false);
				}
			    }
			    return (true);
			}
		    }
		    return (false);
		}
		if (suffix != null) {
		    if (target.endsWith(suffix)) {
			return (true);
		    } else {
			return (false);
		    }
		}
		return (true);
	    } catch (IOException e) {
		return (false);
	    }
	}
    }

    // test driver
    public static void main(String[] args) throws Exception {
	FileList.Condition cond = new FileList.Condition();
	if (args.length > 0) {
	    cond.suffix = args[0];
	}
	if (args.length > 1) {
	    cond.includes = new FilePathList(args[1]);
	}
	if (args.length > 2) {
	    cond.excludes = new FilePathList(args[2]);
	}
	FileList list = new FileList(".", cond);
	FilePath[] files = list.getAsFilePaths();
	for (int i = 0;i < files.length;i++) {
	    System.out.println(files[i].toString());
	}
    }
}
