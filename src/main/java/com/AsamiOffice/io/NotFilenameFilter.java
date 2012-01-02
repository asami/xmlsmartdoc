package com.AsamiOffice.io;

import java.io.*;

/**
 * The NotFilenameFilter is a FilenameFilter to filter opposite files.
 *
 * @since   Feb. 16, 1998
 * @version Apr.  7, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class NotFilenameFilter implements FilenameFilter {
    /**
     * Creates a NotFilenameFilter out of a FilenameFilter.
     *
     * @param filter  a FilenameFilter
     */
    public NotFilenameFilter(FilenameFilter filter) {
	filter_ = filter;
    }

    /**
     * Test if a specified file satisfies any conditions registered.
     *
     * @param dir  the direcotry in which the file was found
     * @param name  the name of the file
     * @see java.io.FilenameFilter
     */
    public boolean accept(File dir, String name) {
	return (!filter_.accept(dir, name));
    }

    private FilenameFilter filter_;
}
