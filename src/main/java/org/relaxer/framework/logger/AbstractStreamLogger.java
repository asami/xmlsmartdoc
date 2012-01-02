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

import java.io.*;

/**
 * AbstractStreamLogger
 *
 * @since   Apr. 12, 2002
 * @version Feb.  5, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractStreamLogger extends AbstractLogger {
    protected Writer out_;

    protected AbstractStreamLogger() {
    }

    protected AbstractStreamLogger(PrintWriter out) {
        _setup(out);
    }

    protected AbstractStreamLogger(Writer out) {
        _setup(out);
    }

    protected AbstractStreamLogger(OutputStream out) {
        _setup(out);
    }

    protected void _setup(Writer out) {
        if (out == null) {
            throw (new IllegalArgumentException());
        }
        out_ = out;
    }

    protected void _setup(OutputStream out) {
        out_ = new OutputStreamWriter(out);
    }

    // fatal
    public void fatal(String message) {
        if (level_ < LOG_FATAL) {
            return;
        }
        try {
            formatter_.fatal(message, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void fatal(String message, Throwable e) {
        if (level_ < LOG_FATAL) {
            return;
        }
        try {
            formatter_.fatal(message, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void fatal(String message, Object arg1) {
        if (level_ < LOG_FATAL) {
            return;
        }
        try {
            formatter_.fatal(message, arg1, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void fatal(String message, Object arg1, Throwable e) {
        if (level_ < LOG_FATAL) {
            return;
        }
        try {
            formatter_.fatal(message, arg1, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void fatal(String message, Object arg1, Object arg2) {
        if (level_ < LOG_FATAL) {
            return;
        }
        try {
            formatter_.fatal(message, arg1, arg2, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void fatal(String message, Object arg1, Object arg2, Throwable e) {
        if (level_ < LOG_FATAL) {
            return;
        }
        try {
            formatter_.fatal(message, arg1, arg2, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void fatal(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        if (level_ < LOG_FATAL) {
            return;
        }
        try {
            formatter_.fatal(message, arg1, arg2, arg3, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void fatal(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    ) {
        if (level_ < LOG_FATAL) {
            return;
        }
        try {
            formatter_.fatal(message, arg1, arg2, arg3, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void fatal(String message, Object[] args) {
        if (level_ < LOG_FATAL) {
            return;
        }
        try {
            formatter_.fatal(message, args, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void fatal(String message, Object[] args, Throwable e) {
        if (level_ < LOG_FATAL) {
            return;
        }
        try {
            formatter_.fatal(message, args, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    // error
    public void error(String message) {
        if (level_ < LOG_ERROR) {
            return;
        }
        try {
            formatter_.error(message, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void error(String message, Throwable e) {
        if (level_ < LOG_ERROR) {
            return;
        }
        try {
            formatter_.error(message, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void error(String message, Object arg1) {
        if (level_ < LOG_ERROR) {
            return;
        }
        try {
            formatter_.error(message, arg1, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void error(String message, Object arg1, Throwable e) {
        if (level_ < LOG_ERROR) {
            return;
        }
        try {
            formatter_.error(message, arg1, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void error(String message, Object arg1, Object arg2) {
        if (level_ < LOG_ERROR) {
            return;
        }
        try {
            formatter_.error(message, arg1, arg2, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void error(String message, Object arg1, Object arg2, Throwable e) {
        if (level_ < LOG_ERROR) {
            return;
        }
        try {
            formatter_.error(message, arg1, arg2, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void error(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        if (level_ < LOG_ERROR) {
            return;
        }
        try {
            formatter_.error(message, arg1, arg2, arg3, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void error(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    ) {
        if (level_ < LOG_ERROR) {
            return;
        }
        try {
            formatter_.error(message, arg1, arg2, arg3, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void error(String message, Object[] args) {
        if (level_ < LOG_ERROR) {
            return;
        }
        try {
            formatter_.error(message, args, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void error(String message, Object[] args, Throwable e) {
        if (level_ < LOG_ERROR) {
            return;
        }
        try {
            formatter_.error(message, args, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    // warning
    public void warning(String message) {
        if (level_ < LOG_WARNING) {
            return;
        }
        try {
            formatter_.warning(message, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void warning(String message, Throwable e) {
        if (level_ < LOG_WARNING) {
            return;
        }
        try {
            formatter_.warning(message, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void warning(String message, Object arg1) {
        if (level_ < LOG_WARNING) {
            return;
        }
        try {
            formatter_.warning(message, arg1, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void warning(String message, Object arg1, Throwable e) {
        if (level_ < LOG_WARNING) {
            return;
        }
        try {
            formatter_.warning(message, arg1, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void warning(String message, Object arg1, Object arg2) {
        if (level_ < LOG_WARNING) {
            return;
        }
        try {
            formatter_.warning(message, arg1, arg2, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void warning(String message, Object arg1, Object arg2, Throwable e) {
        if (level_ < LOG_WARNING) {
            return;
        }
        try {
            formatter_.warning(message, arg1, arg2, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void warning(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        if (level_ < LOG_WARNING) {
            return;
        }
        try {
            formatter_.warning(message, arg1, arg2, arg3, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void warning(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    ) {
        if (level_ < LOG_WARNING) {
            return;
        }
        try {
            formatter_.warning(message, arg1, arg2, arg3, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void warning(String message, Object[] args) {
        if (level_ < LOG_WARNING) {
            return;
        }
        try {
            formatter_.warning(message, args, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void warning(String message, Object[] args, Throwable e) {
        if (level_ < LOG_WARNING) {
            return;
        }
        try {
            formatter_.warning(message, args, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    // info
    public void info(String message) {
        if (level_ < LOG_INFO) {
            return;
        }
        try {
            formatter_.info(message, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void info(String message, Throwable e) {
        if (level_ < LOG_INFO) {
            return;
        }
        try {
            formatter_.info(message, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void info(String message, Object arg1) {
        if (level_ < LOG_INFO) {
            return;
        }
        try {
            formatter_.info(message, arg1, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void info(String message, Object arg1, Throwable e) {
        if (level_ < LOG_INFO) {
            return;
        }
        try {
            formatter_.info(message, arg1, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void info(String message, Object arg1, Object arg2) {
        if (level_ < LOG_INFO) {
            return;
        }
        try {
            formatter_.info(message, arg1, arg2, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void info(String message, Object arg1, Object arg2, Throwable e) {
        if (level_ < LOG_INFO) {
            return;
        }
        try {
            formatter_.info(message, arg1, arg2, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void info(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        if (level_ < LOG_INFO) {
            return;
        }
        try {
            formatter_.info(message, arg1, arg2, arg3, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void info(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    ) {
        if (level_ < LOG_INFO) {
            return;
        }
        try {
            formatter_.info(message, arg1, arg2, arg3, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void info(String message, Object[] args) {
        if (level_ < LOG_INFO) {
            return;
        }
        try {
            formatter_.info(message, args, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void info(String message, Object[] args, Throwable e) {
        if (level_ < LOG_INFO) {
            return;
        }
        try {
            formatter_.info(message, args, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }
    
    // config
    public void config(String message) {
        if (level_ < LOG_CONFIG) {
            return;
        }
        try {
            formatter_.config(message, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void config(String message, Throwable e) {
        if (level_ < LOG_CONFIG) {
            return;
        }
        try {
            formatter_.config(message, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void config(String message, Object arg1) {
        if (level_ < LOG_CONFIG) {
            return;
        }
        try {
            formatter_.config(message, arg1, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void config(String message, Object arg1, Throwable e) {
        if (level_ < LOG_CONFIG) {
            return;
        }
        try {
            formatter_.config(message, arg1, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void config(String message, Object arg1, Object arg2) {
        if (level_ < LOG_CONFIG) {
            return;
        }
        try {
            formatter_.config(message, arg1, arg2, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void config(String message, Object arg1, Object arg2, Throwable e) {
        if (level_ < LOG_CONFIG) {
            return;
        }
        try {
            formatter_.config(message, arg1, arg2, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void config(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        if (level_ < LOG_CONFIG) {
            return;
        }
        try {
            formatter_.config(message, arg1, arg2, arg3, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void config(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    ) {
        if (level_ < LOG_CONFIG) {
            return;
        }
        try {
            formatter_.config(message, arg1, arg2, arg3, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void config(String message, Object[] args) {
        if (level_ < LOG_CONFIG) {
            return;
        }
        try {
            formatter_.config(message, args, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void config(String message, Object[] args, Throwable e) {
        if (level_ < LOG_CONFIG) {
            return;
        }
        try {
            formatter_.config(message, args, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    // entering
    public void entering(Object object, String method) {
        if (level_ < LOG_TRACE) {
            return;
        }
        try {
            formatter_.entering(object, method, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void entering(Object object, String method, Object arg) {
        if (level_ < LOG_TRACE) {
            return;
        }
        try {
            formatter_.entering(object, method, arg, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void entering(
        Object object,
        String method,
        Object arg1,
        Object arg2) {
        if (level_ < LOG_TRACE) {
            return;
        }
        try {
            formatter_.entering(object, method, arg1, arg2, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void entering(
        Object object,
        String method,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        if (level_ < LOG_TRACE) {
            return;
        }
        try {
            formatter_.entering(object, method, arg1, arg2, arg3, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void entering(Object object, String method, Object[] args) {
        if (level_ < LOG_TRACE) {
            return;
        }
        try {
            formatter_.entering(object, method, args, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void exiting(Object object, String method) {
        if (level_ < LOG_TRACE) {
            return;
        }
        try {
            formatter_.exiting(object, method, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void exiting(Object object, String method, Object result) {
        if (level_ < LOG_TRACE) {
            return;
        }
        try {
            formatter_.exiting(object, method, result, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void exiting(Object object, String method, Throwable e) {
        if (level_ < LOG_TRACE) {
            return;
        }
        try {
            formatter_.exiting(object, method, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    // debug
    public void debug(String message) {
        if (level_ < LOG_DEBUG) {
            return;
        }
        try {
            formatter_.debug(message, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void debug(String message, Throwable e) {
        if (level_ < LOG_DEBUG) {
            return;
        }
        try {
            formatter_.debug(message, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void debug(String message, Object arg1) {
        if (level_ < LOG_DEBUG) {
            return;
        }
        try {
            formatter_.debug(message, arg1, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void debug(String message, Object arg1, Throwable e) {
        if (level_ < LOG_DEBUG) {
            return;
        }
        try {
            formatter_.debug(message, arg1, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void debug(String message, Object arg1, Object arg2) {
        if (level_ < LOG_DEBUG) {
            return;
        }
        try {
            formatter_.debug(message, arg1, arg2, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void debug(String message, Object arg1, Object arg2, Throwable e) {
        if (level_ < LOG_DEBUG) {
            return;
        }
        try {
            formatter_.debug(message, arg1, arg2, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void debug(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        if (level_ < LOG_DEBUG) {
            return;
        }
        try {
            formatter_.debug(message, arg1, arg2, arg3, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void debug(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    ) {
        if (level_ < LOG_DEBUG) {
            return;
        }
        try {
            formatter_.debug(message, arg1, arg2, arg3, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void debug(String message, Object[] args) {
        if (level_ < LOG_DEBUG) {
            return;
        }
        try {
            formatter_.debug(message, args, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }

    public void debug(String message, Object[] args, Throwable e) {
        if (level_ < LOG_DEBUG) {
            return;
        }
        try {
            formatter_.debug(message, args, e, out_);
        } catch (IOException le) {
            _loggingError(le);
        }
    }
}
