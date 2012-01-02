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
import java.io.*;

/**
 * AbstractPrintStreamLogger
 * 
 * @deprecated
 *
 * @since   Apr. 12, 2002
 * @version Dec. 12, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractPrintStreamLogger extends AbstractStreamLogger {
    protected AbstractPrintStreamLogger() {
        super();
    }

    protected AbstractPrintStreamLogger(Writer out) {
        super(out);
    }

    protected AbstractPrintStreamLogger(OutputStream out) {
        super(out);
    }

    public void setup(Properties properties) {
    }

    public void entering(Object object, String method) {
        try {
            formatter_.entering(object, method, out_);
        } catch (IOException e) {
            _loggingError(e);
        }
    }

    public void entering(Object object, String method, String arg) {
        try {
            formatter_.entering(object, method, arg, out_);
        } catch (IOException e) {
            _loggingError(e);
        }
    }

    public void entering(
        Object object,
        String method,
        String arg1,
        String arg2) {
        try {
            formatter_.entering(object, method, arg1, arg2, out_);
        } catch (IOException e) {
            _loggingError(e);
        }
    }

    public void entering(
        Object object,
        String method,
        String arg1,
        String arg2,
        String arg3) {
        try {
            formatter_.entering(object, method, arg1, arg2, arg3, out_);
        } catch (IOException e) {
            _loggingError(e);
        }
    }

    public void entering(Object object, String method, String[] args) {
        try {
            formatter_.entering(object, method, args, out_);
        } catch (IOException e) {
            _loggingError(e);
        }
    }

    public void exiting(Object object, String method) {
        try {
            formatter_.exiting(object, method, out_);
        } catch (IOException e) {
            _loggingError(e);
        }
    }

    public void exiting(Object object, String method, String result) {
        try {
            formatter_.exiting(object, method, result, out_);
        } catch (IOException e) {
            _loggingError(e);
        }
    }

    public void exiting(Object object, String method, Exception e) {
        try {
            formatter_.exiting(object, method, e, out_);
        } catch (IOException ee) {
            _loggingError(ee);
        }
    }
    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#config(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Throwable)
     */
    public void config(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#config(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object)
     */
    public void config(String message, Object arg1, Object arg2, Object arg3) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#config(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Throwable)
     */
    public void config(String message, Object arg1, Object arg2, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#config(java.lang.String, java.lang.Object, java.lang.Object)
     */
    public void config(String message, Object arg1, Object arg2) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#config(java.lang.String, java.lang.Object, java.lang.Throwable)
     */
    public void config(String message, Object arg1, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#config(java.lang.String, java.lang.Object)
     */
    public void config(String message, Object arg1) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#config(java.lang.String, java.lang.String[], java.lang.Throwable)
     */
    public void config(String message, String[] args, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#config(java.lang.String, java.lang.String[])
     */
    public void config(String message, String[] args) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#config(java.lang.String, java.lang.Throwable)
     */
    public void config(String message, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#config(java.lang.String)
     */
    public void config(String message) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#entering(java.lang.Object, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object)
     */
    public void entering(
        Object object,
        String method,
        Object arg1,
        Object arg2,
        Object arg3) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#entering(java.lang.Object, java.lang.String, java.lang.Object, java.lang.Object)
     */
    public void entering(
        Object object,
        String method,
        Object arg1,
        Object arg2) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#entering(java.lang.Object, java.lang.String, java.lang.Object)
     */
    public void entering(Object object, String method, Object arg) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#error(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Throwable)
     */
    public void error(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#error(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object)
     */
    public void error(String message, Object arg1, Object arg2, Object arg3) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#error(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Throwable)
     */
    public void error(String message, Object arg1, Object arg2, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#error(java.lang.String, java.lang.Object, java.lang.Object)
     */
    public void error(String message, Object arg1, Object arg2) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#error(java.lang.String, java.lang.Object, java.lang.Throwable)
     */
    public void error(String message, Object arg1, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#error(java.lang.String, java.lang.Object)
     */
    public void error(String message, Object arg1) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#error(java.lang.String, java.lang.String[], java.lang.Throwable)
     */
    public void error(String message, String[] args, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#error(java.lang.String, java.lang.String[])
     */
    public void error(String message, String[] args) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#error(java.lang.String, java.lang.Throwable)
     */
    public void error(String message, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#error(java.lang.String)
     */
    public void error(String message) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#exiting(java.lang.Object, java.lang.String, java.lang.Object)
     */
    public void exiting(Object object, String name, Object result) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#exiting(java.lang.Object, java.lang.String, java.lang.Throwable)
     */
    public void exiting(Object object, String name, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#fatal(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Throwable)
     */
    public void fatal(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#fatal(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object)
     */
    public void fatal(String message, Object arg1, Object arg2, Object arg3) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#fatal(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Throwable)
     */
    public void fatal(String message, Object arg1, Object arg2, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#fatal(java.lang.String, java.lang.Object, java.lang.Object)
     */
    public void fatal(String message, Object arg1, Object arg2) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#fatal(java.lang.String, java.lang.Object, java.lang.Throwable)
     */
    public void fatal(String message, Object arg1, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#fatal(java.lang.String, java.lang.Object)
     */
    public void fatal(String message, Object arg1) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#fatal(java.lang.String, java.lang.String[], java.lang.Throwable)
     */
    public void fatal(String message, String[] args, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#fatal(java.lang.String, java.lang.String[])
     */
    public void fatal(String message, String[] args) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#fatal(java.lang.String, java.lang.Throwable)
     */
    public void fatal(String message, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#fatal(java.lang.String)
     */
    public void fatal(String message) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#info(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Throwable)
     */
    public void info(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#info(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object)
     */
    public void info(String message, Object arg1, Object arg2, Object arg3) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#info(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Throwable)
     */
    public void info(String message, Object arg1, Object arg2, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#info(java.lang.String, java.lang.Object, java.lang.Object)
     */
    public void info(String message, Object arg1, Object arg2) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#info(java.lang.String, java.lang.Object, java.lang.Throwable)
     */
    public void info(String message, Object arg1, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#info(java.lang.String, java.lang.Object)
     */
    public void info(String message, Object arg1) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#info(java.lang.String, java.lang.String[], java.lang.Throwable)
     */
    public void info(String message, String[] args, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#info(java.lang.String, java.lang.String[])
     */
    public void info(String message, String[] args) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#info(java.lang.String, java.lang.Throwable)
     */
    public void info(String message, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#info(java.lang.String)
     */
    public void info(String message) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#warning(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Throwable)
     */
    public void warning(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#warning(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object)
     */
    public void warning(
        String message,
        Object arg1,
        Object arg2,
        Object arg3) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#warning(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Throwable)
     */
    public void warning(
        String message,
        Object arg1,
        Object arg2,
        Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#warning(java.lang.String, java.lang.Object, java.lang.Object)
     */
    public void warning(String message, Object arg1, Object arg2) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#warning(java.lang.String, java.lang.Object, java.lang.Throwable)
     */
    public void warning(String message, Object arg1, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#warning(java.lang.String, java.lang.Object)
     */
    public void warning(String message, Object arg1) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#warning(java.lang.String, java.lang.String[], java.lang.Throwable)
     */
    public void warning(String message, String[] args, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#warning(java.lang.String, java.lang.String[])
     */
    public void warning(String message, String[] args) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#warning(java.lang.String, java.lang.Throwable)
     */
    public void warning(String message, Throwable e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.logger.IRFrameworkLogger#warning(java.lang.String)
     */
    public void warning(String message) {
        // TODO Auto-generated method stub

    }

}
