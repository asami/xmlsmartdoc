package com.AsamiOffice.io;

import java.io.*;

/**
 * The AndFilenameFilter is a FilenameFilter to combine multiple conditions
 * using logical 'and' operation.
 *
 * @since   Feb. 11, 1998
 * @version May.  6, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class AndFilenameFilter implements FilenameFilter {
    /**
     * Creates a AndFilenameFilter out of two FilenameFilters.
     *
     * @param one  first FilenameFilter
     * @param two  second FilenameFilter
     */
    public AndFilenameFilter(FilenameFilter one, FilenameFilter two) {
	filters_ = new FilenameFilter[2];
	filters_[0] = one;
	filters_[1] = two;
    }

    /**
     * Creates a AndFilenameFilter out of multiple FilenameFilters.
     *
     * @param filters  array of FilenameFilters
     */
    public AndFilenameFilter(FilenameFilter[] filters) {
	filters_ = (FilenameFilter[])filters.clone();
    }

    /**
     * Test if a specified file satisfies all conditions registered.
     *
     * @param dir  the direcotry in which the file was found
     * @param name  the name of the file
     * @see java.io.FilenameFilter
     */
    public boolean accept(File dir, String name) {
	for (int i = 0;i < filters_.length;i++) {
	    if (!filters_[i].accept(dir, name)) {
		return (false);
	    }
	}
	return (true);
    }

    private FilenameFilter[] filters_;

    // test dirver
    public static void main(String[] args) {
	File dir = new File(args[0]);
	String[] files = dir.list(new AndFilenameFilter(
	    new FileFilenameFilter(),
	    new SuffixFilenameFilter("java")
	));
	for (int i = 0;i < files.length;i++) {
	    System.out.println(files[i]);
	}
    }
}
