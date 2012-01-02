package com.AsamiOffice.io;

import java.io.*;

/**
 * The DirectoryFilenameFilter is a FilenameFilter to filter directory files.
 *
 * @since   Feb. 11, 1998
 * @version Apr. 27, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class DirectoryFilenameFilter implements FilenameFilter {
    /**
     * Tests if a specified file is a directory file.
     *
     * @param dir  the direcotry in which the file was found
     * @param name  the name of the file
     * @see java.io.FilenameFilter
     */
    public boolean accept(File dir, String name) {
	return (new File(dir, name).isDirectory());
    }
}
