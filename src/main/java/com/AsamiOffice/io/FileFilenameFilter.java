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
package com.AsamiOffice.io;

import java.io.*;

/**
 * The FileFilenameFilter is a FilenameFilter to filter regular files.
 *
 * @since   Feb. 11, 1998
 * @version Jun. 25, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class FileFilenameFilter implements FilenameFilter {
    /**
     * Tests if a specified file is a regular file.
     *
     * @param dir  the direcotry in which the file was found
     * @param name  the name of the file
     * @see java.io.FilenameFilter
     */
    public boolean accept(File dir, String name) {
	return (new File(dir, name).isFile());
    }
}
