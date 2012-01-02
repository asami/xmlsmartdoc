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

package org.relaxer.framework.logger;

import java.util.*;
import java.io.Writer;
import java.io.IOException;

/**
 * IRFrameworkLogFormatter
 *
 * @since   Jan. 19, 2003
 * @version Dec. 13, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRFrameworkLogFormatter {
    void setup(Properties properties);
    void fatal(String message, Writer writer) throws IOException;
    void fatal(String message, Throwable e, Writer writer) throws IOException;
    void fatal(String message, Object arg1, Writer writer) throws IOException;
    void fatal(String message, Object arg1, Throwable e, Writer writer)
        throws IOException;
    void fatal(String message, Object arg1, Object arg2, Writer writer)
        throws IOException;
    void fatal(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException;
    void fatal(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException;
    void fatal(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException;
    void fatal(String message, String[] args, Writer writer)
        throws IOException;
    void fatal(String message, String[] args, Throwable e, Writer writer)
        throws IOException;
    void error(String message, Writer writer) throws IOException;
    void error(String message, Throwable e, Writer writer) throws IOException;
    void error(String message, Object arg1, Writer writer) throws IOException;
    void error(String message, Object arg1, Throwable e, Writer writer)
        throws IOException;
    void error(String message, Object arg1, Object arg2, Writer writer)
        throws IOException;
    void error(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException;
    void error(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException;
    void error(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException;
    void error(String message, String[] args, Writer writer)
        throws IOException;
    void error(String message, String[] args, Throwable e, Writer writer)
        throws IOException;
    void warning(String message, Writer writer) throws IOException;
    void warning(String message, Throwable e, Writer writer)
        throws IOException;
    void warning(String message, Object arg1, Writer writer)
        throws IOException;
    void warning(String message, Object arg1, Throwable e, Writer writer)
        throws IOException;
    void warning(String message, Object arg1, Object arg2, Writer writer)
        throws IOException;
    void warning(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException;
    void warning(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException;
    void warning(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException;
    void warning(String message, String[] args, Writer writer)
        throws IOException;
    void warning(String message, String[] args, Throwable e, Writer writer)
        throws IOException;
    void info(String message, Writer writer) throws IOException;
    void info(String message, Throwable e, Writer writer) throws IOException;
    void info(String message, Object arg1, Writer writer) throws IOException;
    void info(String message, Object arg1, Throwable e, Writer writer)
        throws IOException;
    void info(String message, Object arg1, Object arg2, Writer writer)
        throws IOException;
    void info(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException;
    void info(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException;
    void info(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException;
    void info(String message, String[] args, Writer writer) throws IOException;
    void info(String message, String[] args, Throwable e, Writer writer)
        throws IOException;
    void config(String message, Writer writer) throws IOException;
    void config(String message, Throwable e, Writer writer) throws IOException;
    void config(String message, Object arg1, Writer writer) throws IOException;
    void config(String message, Object arg1, Throwable e, Writer writer)
        throws IOException;
    void config(String message, Object arg1, Object arg2, Writer writer)
        throws IOException;
    void config(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException;
    void config(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException;
    void config(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException;
    void config(String message, String[] args, Writer writer)
        throws IOException;
    void config(String message, String[] args, Throwable e, Writer writer)
        throws IOException;
    void entering(Object object, String method, Writer writer)
        throws IOException;
    void entering(Object object, String method, Object arg, Writer writer)
        throws IOException;
    void entering(
        Object object,
        String method,
        Object arg1,
        Object arg2,
        Writer writer
    ) throws IOException;
    void entering(
        Object object, 
        String method,
        Object arg1, 
        Object arg2, 
        Object arg3,
        Writer writer
    ) throws IOException;
    void entering(Object object, String name, Object[] args, Writer writer)
        throws IOException;
    void exiting(Object object, String name, Writer writer) throws IOException;
    void exiting(Object object, String name, Object result, Writer writer)
        throws IOException;
    void exiting(Object object, String name, Throwable e, Writer writer)
        throws IOException;
    void debug(String message, Writer writer) throws IOException;
    void debug(String message, Throwable e, Writer writer) throws IOException;
    void debug(String message, Object arg1, Writer writer) throws IOException;
    void debug(String message, Object arg1, Throwable e, Writer writer)
        throws IOException;
    void debug(String message, Object arg1, Object arg2, Writer writer)
        throws IOException;
    void debug(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException;
    void debug(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException;
    void debug(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException;
    void debug(String message, String[] args, Writer writer)
        throws IOException;
    void debug(String message, String[] args, Throwable e, Writer writer)
        throws IOException;
}
