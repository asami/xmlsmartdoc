/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
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

/**
 * IRFrameworkLogger
 *
 * @since   Mar. 21, 2002
 * @version Mar. 15, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRFrameworkLogger {
    int LOG_OFF = 0;
    int LOG_FATAL = 100;
    int LOG_ERROR = 200;
    int LOG_WARNING = 300;
    int LOG_INFO = 400;
    int LOG_CONFIG = 500;
    int LOG_TRACE = 600;
    int LOG_DEBUG = 700;

    void setup(Properties properties);
    void setLevel(int level);
    int getLevel();
    void setFormatter(IRFrameworkLogFormatter formatter);
    void fatal(String message);
    void fatal(String message, Throwable e);
    void fatal(String message, Object arg1);
    void fatal(String message, Object arg1, Throwable e);
    void fatal(String message, Object arg1, Object arg2);
    void fatal(String message, Object arg1, Object arg2, Throwable e);
    void fatal(String message, Object arg1, Object arg2, Object arg3);
    void fatal(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    );
    void fatal(String message, Object[] args);
    void fatal(String message, Object[] args, Throwable e);
    void error(String message);
    void error(String message, Throwable e);
    void error(String message, Object arg1);
    void error(String message, Object arg1, Throwable e);
    void error(String message, Object arg1, Object arg2);
    void error(String message, Object arg1, Object arg2, Throwable e);
    void error(String message, Object arg1, Object arg2, Object arg3);
    void error(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    );
    void error(String message, Object[] args);
    void error(String message, Object[] args, Throwable e);
    void warning(String message);
    void warning(String message, Throwable e);
    void warning(String message, Object arg1);
    void warning(String message, Object arg1, Throwable e);
    void warning(String message, Object arg1, Object arg2);
    void warning(String message, Object arg1, Object arg2, Throwable e);
    void warning(String message, Object arg1, Object arg2, Object arg3);
    void warning(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    );
    void warning(String message, Object[] args);
    void warning(String message, Object[] args, Throwable e);
    void info(String message);
    void info(String message, Throwable e);
    void info(String message, Object arg1);
    void info(String message, Object arg1, Throwable e);
    void info(String message, Object arg1, Object arg2);
    void info(String message, Object arg1, Object arg2, Throwable e);
    void info(String message, Object arg1, Object arg2, Object arg3);
    void info(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    );
    void info(String message, Object[] args);
    void info(String message, Object[] args, Throwable e);
    void config(String message);
    void config(String message, Throwable e);
    void config(String message, Object arg1);
    void config(String message, Object arg1, Throwable e);
    void config(String message, Object arg1, Object arg2);
    void config(String message, Object arg1, Object arg2, Throwable e);
    void config(String message, Object arg1, Object arg2, Object arg3);
    void config(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    );
    void config(String message, Object[] args);
    void config(String message, Object[] args, Throwable e);
    void entering(Object object, String method);
    void entering(Object object, String method, Object arg);
    void entering(Object object, String method, Object arg1, Object arg2);
    void entering(
        Object object, 
        String method,
        Object arg1, 
        Object arg2, 
        Object arg3
    );
    void entering(Object object, String name, Object[] args);
    void exiting(Object object, String name);
    void exiting(Object object, String name, Object result);
    void exiting(Object object, String name, Throwable e);
    void debug(String message);
    void debug(String message, Throwable e);
    void debug(String message, Object arg1);
    void debug(String message, Object arg1, Throwable e);
    void debug(String message, Object arg1, Object arg2);
    void debug(String message, Object arg1, Object arg2, Throwable e);
    void debug(String message, Object arg1, Object arg2, Object arg3);
    void debug(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    );
    void debug(String message, Object[] args);
    void debug(String message, Object[] args, Throwable e);
}
