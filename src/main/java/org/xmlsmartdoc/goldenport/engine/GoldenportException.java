/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
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
package org.xmlsmartdoc.goldenport.engine;

/**
 * GoldenportException
 *
 * @since   Oct. 11, 2003
 * @version Oct. 11, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class GoldenportException extends Exception {
    /**
     * 
     */
    public GoldenportException() {
        super();
    }

    /**
     * @param arg0
     */
    public GoldenportException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public GoldenportException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * @param arg0
     */
    public GoldenportException(Throwable arg0) {
        super(arg0);
    }
}
