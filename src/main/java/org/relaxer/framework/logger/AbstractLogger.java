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

/**
 * AbstractLogger
 *
 * @since   Apr. 11, 2002
 * @version Dec. 13, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractLogger implements IRFrameworkLogger {
    protected int level_ = LOG_INFO;
    protected IRFrameworkLogFormatter formatter_;

    protected AbstractLogger() {
        formatter_ = new PlainLogFormatter();
    }

    public void setup(Properties properties) {
    }

    public void setLevel(int level) {
        level_ = level;
    }
    
    public int getLevel() {
        return (level_);
    }

    public void setFormatter(IRFrameworkLogFormatter formatter) {
        formatter_ = formatter;
    }

    protected void _loggingError(Exception e) {
        // XXX
    }
}
