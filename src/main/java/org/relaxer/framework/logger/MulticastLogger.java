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

import java.util.List;

/**
 * MulticastLogger
 *
 * @since   Dec. 13, 2003
 * @version Mar. 15, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class MulticastLogger extends AbstractLogger {
    private IRFrameworkLogger[] loggers_;

    public MulticastLogger(List loggers) {
        loggers_ = new IRFrameworkLogger[loggers.size()];
        loggers_ = (IRFrameworkLogger[])loggers.toArray(loggers_);
    }
    
    public int getLevel() {
        int level = LOG_OFF;
        for (int i = 0;i < loggers_.length;i++) {
            level = Math.max(loggers_[i].getLevel(), level);
        }
        return (level);
    }

    // fatal
    public void fatal(String message) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].fatal(message);
        }
    }

    public void fatal(String message, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].fatal(message, e);
        }
    }

    public void fatal(String message, Object arg) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].fatal(message, arg);
        }
    }

    public void fatal(String message, Object arg, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].fatal(message, arg, e);
        }
    }

    public void fatal(String message, Object arg1, Object arg2) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].fatal(message, arg1, arg2);
        }
    }

    public void fatal(String message, Object arg1, Object arg2, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].fatal(message, arg1, arg2, e);
        }
    }

    public void fatal(String message, Object arg1, Object arg2, Object arg3) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].fatal(message, arg1, arg2, arg3);
        }
    }

    public void fatal(String message, Object arg1, Object arg2, Object arg3, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].fatal(message, arg1, arg2, arg3, e);
        }
    }

    public void fatal(String message, Object[] args) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].fatal(message, args);
        }
    }

    public void fatal(String message, Object[] args, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].fatal(message, args, e);
        }
    }

    // error
    public void error(String message) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].error(message);
        }
    }

    public void error(String message, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].error(message, e);
        }
    }

    public void error(String message, Object arg) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].error(message, arg);
        }
    }

    public void error(String message, Object arg, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].error(message, arg, e);
        }
    }

    public void error(String message, Object arg1, Object arg2) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].error(message, arg1, arg2);
        }
    }

    public void error(String message, Object arg1, Object arg2, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].error(message, arg1, arg2, e);
        }
    }

    public void error(String message, Object arg1, Object arg2, Object arg3) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].error(message, arg1, arg2, arg3);
        }
    }

    public void error(String message, Object arg1, Object arg2, Object arg3, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].error(message, arg1, arg2, arg3, e);
        }
    }

    public void error(String message, Object[] args) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].error(message, args);
        }
    }

    public void error(String message, Object[] args, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].error(message, args, e);
        }
    }

    // warning
    public void warning(String message) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].warning(message);
        }
    }

    public void warning(String message, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].warning(message, e);
        }
    }

    public void warning(String message, Object arg) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].warning(message, arg);
        }
    }

    public void warning(String message, Object arg, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].warning(message, arg, e);
        }
    }

    public void warning(String message, Object arg1, Object arg2) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].warning(message, arg1, arg2);
        }
    }

    public void warning(String message, Object arg1, Object arg2, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].warning(message, arg1, arg2, e);
        }
    }

    public void warning(String message, Object arg1, Object arg2, Object arg3) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].warning(message, arg1, arg2, arg3);
        }
    }

    public void warning(String message, Object arg1, Object arg2, Object arg3, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].warning(message, arg1, arg2, arg3, e);
        }
    }

    public void warning(String message, Object[] args) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].warning(message, args);
        }
    }

    public void warning(String message, Object[] args, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].warning(message, args, e);
        }
    }

    // info
    public void info(String message) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].info(message);
        }
    }

    public void info(String message, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].info(message, e);
        }
    }

    public void info(String message, Object arg) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].info(message, arg);
        }
    }

    public void info(String message, Object arg, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].info(message, arg, e);
        }
    }

    public void info(String message, Object arg1, Object arg2) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].info(message, arg1, arg2);
        }
    }

    public void info(String message, Object arg1, Object arg2, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].info(message, arg1, arg2, e);
        }
    }

    public void info(String message, Object arg1, Object arg2, Object arg3) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].info(message, arg1, arg2, arg3);
        }
    }

    public void info(String message, Object arg1, Object arg2, Object arg3, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].info(message, arg1, arg2, arg3, e);
        }
    }

    public void info(String message, Object[] args) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].info(message, args);
        }
    }

    public void info(String message, Object[] args, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].info(message, args, e);
        }
    }

    // config
    public void config(String message) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].config(message);
        }
    }

    public void config(String message, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].config(message, e);
        }
    }

    public void config(String message, Object arg) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].config(message, arg);
        }
    }

    public void config(String message, Object arg, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].config(message, arg, e);
        }
    }

    public void config(String message, Object arg1, Object arg2) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].config(message, arg1, arg2);
        }
    }

    public void config(String message, Object arg1, Object arg2, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].config(message, arg1, arg2, e);
        }
    }

    public void config(String message, Object arg1, Object arg2, Object arg3) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].config(message, arg1, arg2, arg3);
        }
    }

    public void config(String message, Object arg1, Object arg2, Object arg3, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].config(message, arg1, arg2, arg3, e);
        }
    }

    public void config(String message, Object[] args) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].config(message, args);
        }
    }

    public void config(String message, Object[] args, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].config(message, args, e);
        }
    }

    // entering
    public void entering(Object object, String method) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].entering(object, method);
        }
    }

    public void entering(Object object, String method, Object arg) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].entering(object, method, arg);
        }
    }

    public void entering(Object object, String method, Object arg1, Object arg2) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].entering(object, method, arg1, arg2);
        }
    }

    public void entering(Object object, String method, Object arg1, Object arg2, Object arg3) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].entering(object, method, arg1, arg2, arg3);
        }
    }

    public void entering(Object object, String method, Object[] args) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].entering(object, method, args);
        }
    }

    // exiting
    public void exiting(Object object, String method) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].exiting(object, method);
        }
    }

    public void exiting(Object object, String method, Object result) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].exiting(object, method, result);
        }
    }

    public void exiting(Object object, String method, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].exiting(object, method, e);
        }
    }

    // debug
    public void debug(String message) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].debug(message);
        }
    }

    public void debug(String message, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].debug(message, e);
        }
    }

    public void debug(String message, Object arg) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].debug(message, arg);
        }
    }

    public void debug(String message, Object arg, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].debug(message, arg, e);
        }
    }

    public void debug(String message, Object arg1, Object arg2) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].debug(message, arg1, arg2);
        }
    }

    public void debug(String message, Object arg1, Object arg2, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].debug(message, arg1, arg2, e);
        }
    }

    public void debug(String message, Object arg1, Object arg2, Object arg3) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].debug(message, arg1, arg2, arg3);
        }
    }

    public void debug(String message, Object arg1, Object arg2, Object arg3, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].debug(message, arg1, arg2, arg3, e);
        }
    }

    public void debug(String message, Object[] args) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].debug(message, args);
        }
    }

    public void debug(String message, Object[] args, Throwable e) {
        for (int i = 0;i < loggers_.length;i++) {
            loggers_[i].debug(message, args, e);
        }
    }
}
