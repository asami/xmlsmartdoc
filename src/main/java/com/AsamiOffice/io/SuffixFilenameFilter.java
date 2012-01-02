/*
 * The AsamiOffice class library
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

package com.AsamiOffice.io;

import java.io.*;

/**
 * The SuffixFilenameFilter is a FilenameFilter to filter a file name by
 * the specified suffixes.
 *
 * @since   Feb. 11, 1998
 * @version Sep.  4, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class SuffixFilenameFilter implements FilenameFilter {
    private String[] suffixes_;

    /**
     * Create a SuffixFilenameFilter to filter the file that has the
     * specified suffix.
     *
     * @param suffix  suffix name to filter
     */
    public SuffixFilenameFilter(String suffix) {
	suffixes_ = new String[1];
	suffixes_[0] = suffix;
    }

    /**
     * Create a SuffixFilenameFilter to filter the file that has one
     * of the specified suffix.
     *
     * @param suffixes  array of suffix name to filter
     */
    public SuffixFilenameFilter(String[] suffixes) {
	suffixes_ = new String[suffixes.length];
	System.arraycopy(suffixes, 0, suffixes_, 0, suffixes.length);
    }

    /**
     * Tests if a specified file has one of the registered suffix.
     *
     * @param dir  the direcotry in which the file was found
     * @param name  the name of the file
     * @see java.io.FilenameFilter
     */
    public boolean accept(File dir, String name) {
	for (int i = 0;i < suffixes_.length;i++) {
	    if (name.endsWith(suffixes_[i])) {
		return (true);
	    }
	}
	return (false);
    }

    /**
     * Test Driver
     *
     * @param args[0]  the directory name
     * @param args[1...]  the suffix list
     */
    public static void main(String[] args) {
	String dirname = args[0];
	FilenameFilter filter;
	if (args.length == 2) {
	    filter = new SuffixFilenameFilter(args[1]);
	} else {
	    String[] suffixes = new String[args.length - 1];
	    for (int i = 1;i < args.length;i++) {
		suffixes[i - 1] = "." + args[i];
	    }
	    filter = new SuffixFilenameFilter(suffixes);
	}
	File dir = new File(dirname);
	String[] files = dir.list(filter);
	for (int i = 0;i < files.length;i++) {
	    System.out.println(files[i]);
	}
    }
}
