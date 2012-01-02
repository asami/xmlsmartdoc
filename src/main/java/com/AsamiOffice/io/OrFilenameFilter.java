package com.AsamiOffice.io;

import java.io.*;

/**
 * The OrFilenameFilter is a FilenameFilter to combine multiple conditions
 * using logical 'or' operation.
 *
 * @since   Feb. 11, 1998
 * @version Apr.  7, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class OrFilenameFilter implements FilenameFilter {
    /**
     * Creates a OrFilenameFilter out of two FilenameFilters.
     *
     * @param one  first FilenameFilter
     * @param two  second FilenameFilter
     */
    public OrFilenameFilter(FilenameFilter one, FilenameFilter two) {
	filters_ = new FilenameFilter[2];
	filters_[0] = one;
	filters_[1] = two;
    }

    /**
     * Creates a AndFilenameFilter out of multiple FilenameFilters.
     *
     * @param filters  array of FilenameFilters
     */
    public OrFilenameFilter(FilenameFilter[] filters) {
	filters_ = (FilenameFilter[])filters.clone();
    }

    /**
     * Test if a specified file satisfies any conditions registered.
     *
     * @param dir  the direcotry in which the file was found
     * @param name  the name of the file
     * @see java.io.FilenameFilter
     */
    public boolean accept(File dir, String name) {
	for (int i = 0;i < filters_.length;i++) {
	    if (filters_[i].accept(dir, name)) {
		return (true);
	    }
	}
	return (false);
    }

    private FilenameFilter[] filters_;
}
