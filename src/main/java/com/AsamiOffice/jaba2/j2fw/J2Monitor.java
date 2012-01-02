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

package com.AsamiOffice.jaba2.j2fw;

import java.io.*;

/**
 * J2Monitor
 *
 * @since   Nov. 21, 1998
 * @version Feb. 26, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class J2Monitor {
    // status
    public final int STATUS_NORMAL = 0;
    public final int STATUS_ABNORMAL = 0;
    // log level
    public final int LEVEL_NONE = 0;
    public final int LEVEL_ERROR = 1;
    public final int LEVEL_WARNING = 2;
    public final int LEVEL_INFO = 3;
    public final int LEVEL_VERBOSE = 4;
    public final int LEVEL_DEBUG = 5;

    protected int consoleLevel_ = LEVEL_WARNING;
    protected int status_ = STATUS_NORMAL;
    protected PrintWriter console_;

    public J2Monitor() {
	console_ = new PrintWriter(System.out, true);
    }

    public J2Monitor(J2Config config) {
	setConfig(config);
	console_ = new PrintWriter(System.out, true);
    }

    public void setConfig(J2Config config) {
	if (config.isVerbose()) {
	    if (consoleLevel_ < LEVEL_VERBOSE) {
		setConsoleLevel(LEVEL_VERBOSE);
	    }
	}
	if (config.isDebug()) {
	    if (consoleLevel_ < LEVEL_DEBUG) {
		setConsoleLevel(LEVEL_DEBUG);
	    }
	}
    }

    public void setConsole(PrintWriter console) {
	console_ = console;
    }

    public void setConsoleLevel(int level) {
	consoleLevel_ = level;
    }

    public void print(String message) {
	console_.print(message);
    }

    public void println(String message) {
	console_.println(message);
	console_.flush();
    }

    public void println() {
	console_.println();
	console_.flush();
    }

    public void info(String message) {
	log(LEVEL_INFO, message);
    }

    public void verbose(String message) {
	log(LEVEL_VERBOSE, message);
    }

    public void warning(String message) {
	log(LEVEL_WARNING, "Warning: " + message);
    }

    public void error(String message) {
	log(LEVEL_ERROR, "Error: " + message);
    }

    public void debug(String message) {
	log(LEVEL_DEBUG, message);
    }

    public void log(int level, String message) {
	if (consoleLevel_ >= level) {
	    console_.println(message);
	    console_.flush();
	}
    }

    public int getStatus() {
	return (status_);
    }

    public String getStatusAsString() {
	throw (new UnsupportedOperationException());
    }
}
