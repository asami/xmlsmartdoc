/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.framework.runtime;

import java.util.ArrayList;
import java.util.List;

import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.framework.logger.StderrLogger;
import org.relaxer.framework.runtime.messager.IRFrameworkMessager;
import org.relaxer.framework.runtime.messager.StderrMessager;
import org.relaxer.framework.runtime.reporter.IRFrameworkReporter;
import org.relaxer.framework.runtime.reporter.PlainReporter;

/**
 * RSystemContext
 *
 * @since   Sep.  1, 2003
 * @version Aug. 27, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RSystemContext {
    private IRFrameworkLogger logger_;
    private IRFrameworkMessager messager_;
    private IRFrameworkReporter reporter_;
    private List runtimeContexts_ = new ArrayList();

    public RSystemContext() {
        logger_ = new StderrLogger();
        messager_ = new StderrMessager();
        reporter_ = new PlainReporter();
    }

    public final void setLogger(IRFrameworkLogger logger) {
        logger_ = logger;
    }

    public final IRFrameworkLogger getLogger() {
        return (logger_);
    }
    
    public final void setMessager(IRFrameworkMessager messager) {
        messager_ = messager;
    }

    public final IRFrameworkMessager getMessager() {
        return messager_;
    }

    public final void setReporter(IRFrameworkReporter reporter) {
        reporter_ = reporter;
    }

    public final IRFrameworkReporter getReporter() {
        return reporter_;
    }

    public void addRuntimeContext(RRuntimeContext runtimeContext) {
        runtimeContexts_.add(runtimeContext);
        runtimeContext.setSystemContext(this);
    }

    public void close() {
        Object[] children = runtimeContexts_.toArray();
        for (int i = 0; i < children.length; i++) {
            RRuntimeContext context = (RRuntimeContext)children[i];
            context.close();
        }
        
    }
}
