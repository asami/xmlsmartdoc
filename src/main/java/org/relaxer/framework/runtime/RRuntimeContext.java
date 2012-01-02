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
import org.relaxer.framework.runtime.messager.IRFrameworkMessager;
import org.relaxer.framework.runtime.reporter.IRFrameworkReporter;

/**
 * RRuntimeContextg
 *
 * @since   Aug. 30, 2003
 * @version Aug. 27, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RRuntimeContext {
    private RSystemContext systemContext_;
    private IRFrameworkLogger logger_ = null;
    private IRFrameworkMessager messager_ = null;
    private IRFrameworkReporter reporter_ = null;
    private List containerContexts_ = new ArrayList();

    public final void setLogger(IRFrameworkLogger logger) {
        logger_ = logger;
    }

    public final IRFrameworkLogger getLogger() {
        if (logger_ != null) {
            return (logger_);
        } else {
            return (systemContext_.getLogger());
        }
    }

    public final void setMessager(IRFrameworkMessager messager) {
        messager_ = messager;
    }

    public IRFrameworkMessager getMessager() {
        if (messager_ != null) {
            return (messager_);
        } else {
            return (systemContext_.getMessager());
        }
    }

    public final void setReporter(IRFrameworkReporter reporter) {
        reporter_ = reporter;
    }

    public IRFrameworkReporter getReporter() {
        if (reporter_ != null) {
            return (reporter_);
        } else {
            return (systemContext_.getReporter());
        }
    }

    public void setSystemContext(RSystemContext systemContext) {
        systemContext_ = systemContext;
    }

    public void addContainerContext(RContainerContext containerContext) {
        containerContexts_.add(containerContext);
        containerContext.setRuntimeContext(this);
    }

    public void close() {
        Object[] contexts = containerContexts_.toArray();
        for (int i = 0; i < contexts.length; i++) {
            RContainerContext context = (RContainerContext)contexts[i];
            context.close();
        }
    }
}
