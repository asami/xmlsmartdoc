/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@relaxer.org)
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

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;

import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.framework.parcel.IParcel;
import org.relaxer.framework.parcel.LightWeightParcel;
import org.relaxer.framework.runtime.messager.IRFrameworkMessager;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.reporter.IRFrameworkReporter;

/**
 * RComponentContext
 *
 * @since   Mar. 17, 2002
 * @version Aug. 27, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RComponentContext {
    private RContainerContext containerContext_;
    private IRModelContext modelContext_ = null;
    private IRFrameworkLogger logger_ = null;
    private IRFrameworkMessager messager_ = null;
    private IRFrameworkReporter reporter_ = null;

    public String exportContext() {
        return ("<context></context>");
    }

    public void importContext(String xml) {
        // TODO
    }

    public void setContainerContext(RContainerContext containerContext) {
        containerContext_ = containerContext;
    }

    public RSessionContext getSessionContext() {
        if (containerContext_ != null) {
            return (containerContext_.getSessionContext());
        } else {
            return (null);
        }
    }

	public IRModelContext getModelContext() {
        if (modelContext_ != null) {
            return modelContext_;
        } else if (containerContext_ != null) {
		    return containerContext_.getModelContext();
        } else {
            return null;
        }
	}
    
    public final ClassLoader getClassLoader() {
        if (containerContext_ != null) {
            return (containerContext_.getClassLoader());
        } else {
            return (null);
        }
    }

    public DocumentBuilder getDocumentBuilder() {
        if (containerContext_ != null) {
            return (containerContext_.getDocumentBuilder());
        } else {
            return (null);
        }
    }

    public final void setLogger(IRFrameworkLogger logger) {
        logger_ = logger;
    }

    public final IRFrameworkLogger getLogger() {
        if (logger_ != null) {
            return (logger_);
        } else {
            return (containerContext_.getLogger());
        }
    }

    public final IRFrameworkMessager getMessager() {
        if (messager_ != null) {
            return (messager_);
        } else {
            return (containerContext_.getMessager());
        }
    }

    public final IRFrameworkReporter getReporter() {
        if (reporter_ != null) {
            return (reporter_);
        } else {
            return (containerContext_.getReporter());
        }
    }

    public final IParcel makeParcel() {
        IParcel parcel = new LightWeightParcel();
        return (parcel);
    }

    //
/*
    public void log(String message) {
        IRFrameworkLogger logger = getLogger();
        logger.log(message);
    }
*/

    // fatal
    public void logFatal(String message) {
        IRFrameworkLogger logger = getLogger();
        logger.fatal(message);
    }

    public void logFatal(String message, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.fatal(message, e); 
   }

    public void logFatal(String message, Object arg) {
        IRFrameworkLogger logger = getLogger();
        logger.fatal(message, arg);
    }

    public void logFatal(String message, Object arg, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.fatal(message, arg, e);
    }

    public void logFatal(String message, Object arg1, Object arg2) {
        IRFrameworkLogger logger = getLogger();
        logger.fatal(message, arg1, arg2);
    }

    public void logFatal(
        String message,
        Object arg1,
        Object arg2,
        Throwable e
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.fatal(message, arg1, arg2, e);
    }

    public void logFatal(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.fatal(message, arg1, arg2, arg3);
    }

    public void logFatal(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.fatal(message, arg1, arg2, arg3, e);
    }

    public void logFatal(String message, Object[] args) {
        IRFrameworkLogger logger = getLogger();
        logger.fatal(message, args);
    }

    public void logFatal(String message, Object[] args, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.fatal(message, args, e);
    }

    // error
    public void logError(String message) {
        IRFrameworkLogger logger = getLogger();
        logger.error(message);
    }

    public void logError(String message, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.error(message, e); 
   }

    public void logError(String message, Object arg) {
        IRFrameworkLogger logger = getLogger();
        logger.error(message, arg);
    }

    public void logError(String message, Object arg, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.error(message, arg, e);
    }

    public void logError(String message, Object arg1, Object arg2) {
        IRFrameworkLogger logger = getLogger();
        logger.error(message, arg1, arg2);
    }

    public void logError(
        String message,
        Object arg1,
        Object arg2,
        Throwable e
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.error(message, arg1, arg2, e);
    }

    public void logError(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.error(message, arg1, arg2, arg3);
    }

    public void logError(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.error(message, arg1, arg2, arg3, e);
    }

    public void logError(String message, Object[] args) {
        IRFrameworkLogger logger = getLogger();
        logger.error(message, args);
    }

    public void logError(String message, Object[] args, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.error(message, args, e);
    }

    // warning
    public void logWarning(String message) {
        IRFrameworkLogger logger = getLogger();
        logger.warning(message);
    }

    public void logWarning(String message, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.warning(message, e); 
   }

    public void logWarning(String message, Object arg) {
        IRFrameworkLogger logger = getLogger();
        logger.warning(message, arg);
    }

    public void logWarning(String message, Object arg, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.warning(message, arg, e);
    }

    public void logWarning(String message, Object arg1, Object arg2) {
        IRFrameworkLogger logger = getLogger();
        logger.warning(message, arg1, arg2);
    }

    public void logWarning(
        String message,
        Object arg1,
        Object arg2,
        Throwable e
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.warning(message, arg1, arg2, e);
    }

    public void logWarning(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.warning(message, arg1, arg2, arg3);
    }

    public void logWarning(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.warning(message, arg1, arg2, arg3, e);
    }

    public void logWarning(String message, Object[] args) {
        IRFrameworkLogger logger = getLogger();
        logger.warning(message, args);
    }

    public void logWarning(String message, Object[] args, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.warning(message, args, e);
    }

    // info
    public void logInfo(String message) {
        IRFrameworkLogger logger = getLogger();
        logger.info(message);
    }

    public void logInfo(String message, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.info(message, e); 
   }

    public void logInfo(String message, Object arg) {
        IRFrameworkLogger logger = getLogger();
        logger.info(message, arg);
    }

    public void logInfo(String message, Object arg, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.info(message, arg, e);
    }

    public void logInfo(String message, Object arg1, Object arg2) {
        IRFrameworkLogger logger = getLogger();
        logger.info(message, arg1, arg2);
    }

    public void logInfo(
        String message,
        Object arg1,
        Object arg2,
        Throwable e
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.info(message, arg1, arg2, e);
    }

    public void logInfo(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.info(message, arg1, arg2, arg3);
    }

    public void logInfo(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.info(message, arg1, arg2, arg3, e);
    }

    public void logInfo(String message, Object[] args) {
        IRFrameworkLogger logger = getLogger();
        logger.info(message, args);
    }

    public void logInfo(String message, Object[] args, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.info(message, args, e);
    }

    // config
    public void logConfig(String message) {
        IRFrameworkLogger logger = getLogger();
        logger.config(message);
    }

    public void logConfig(String message, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.config(message, e); 
   }

    public void logConfig(String message, Object arg) {
        IRFrameworkLogger logger = getLogger();
        logger.config(message, arg);
    }

    public void logConfig(String message, Object arg, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.config(message, arg, e);
    }

    public void logConfig(String message, Object arg1, Object arg2) {
        IRFrameworkLogger logger = getLogger();
        logger.config(message, arg1, arg2);
    }

    public void logConfig(
        String message,
        Object arg1,
        Object arg2,
        Throwable e
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.config(message, arg1, arg2, e);
    }

    public void logConfig(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.config(message, arg1, arg2, arg3);
    }

    public void logConfig(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.config(message, arg1, arg2, arg3, e);
    }

    public void logConfig(String message, Object[] args) {
        IRFrameworkLogger logger = getLogger();
        logger.config(message, args);
    }

    public void logConfig(String message, Object[] args, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.config(message, args, e);
    }

    // entering
    public void logEntering(Object object, String name) {
        IRFrameworkLogger logger = getLogger();
        logger.entering(object, name);
    }

    public void logEntering(Object object, String name, String arg) {
        IRFrameworkLogger logger = getLogger();
        logger.entering(object, name, arg);
    }

    public void logEntering(
        Object object,
        String name,
        String arg1,
        String arg2
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.entering(object, name, arg1, arg2);
    }

    public void logEntering(
        Object object,
        String name,
        String arg1,
        String arg2,
        String arg3
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.entering(object, name, arg1, arg2, arg3);
    }

    public void logEntering(Object object, String name, String[] args) {
        IRFrameworkLogger logger = getLogger();
        logger.entering(object, name, args);
    }

    public void logExiting(Object object, String name) {
        IRFrameworkLogger logger = getLogger();
        logger.exiting(object, name);
    }

    public void logExiting(Object object, String name, String result) {
        IRFrameworkLogger logger = getLogger();
        logger.exiting(object, name, result);
    }

    public void logExiting(Object object, String name, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.exiting(object, name, e);
    }

    // debug
    public void logDebug(String message) {
        IRFrameworkLogger logger = getLogger();
        logger.debug(message);
    }

    public void logDebug(String message, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.debug(message, e); 
   }

    public void logDebug(String message, Object arg) {
        IRFrameworkLogger logger = getLogger();
        logger.debug(message, arg);
    }

    public void logDebug(String message, Object arg, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.debug(message, arg, e);
    }

    public void logDebug(String message, Object arg1, Object arg2) {
        IRFrameworkLogger logger = getLogger();
        logger.debug(message, arg1, arg2);
    }

    public void logDebug(
        String message,
        Object arg1,
        Object arg2,
        Throwable e
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.debug(message, arg1, arg2, e);
    }

    public void logDebug(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.debug(message, arg1, arg2, arg3);
    }

    public void logDebug(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e
    ) {
        IRFrameworkLogger logger = getLogger();
        logger.debug(message, arg1, arg2, arg3, e);
    }

    public void logDebug(String message, Object[] args) {
        IRFrameworkLogger logger = getLogger();
        logger.debug(message, args);
    }

    public void logDebug(String message, Object[] args, Throwable e) {
        IRFrameworkLogger logger = getLogger();
        logger.debug(message, args, e);
    }
    
    // Relaxer Table Object
    public void rtoSetup(Object rto) throws RelaxerRuntimeException {
        containerContext_.rtoSetup(rto);
    }

    public DataSource getDataSource() {
        return (containerContext_.getDataSource());
    }
    
    public DataSource getDataSource(String name) {
        return (containerContext_.getDataSource(name));
    }

    public Connection openDataSourceConnection() throws SQLException {
        return (containerContext_.openDataSourceConnection());
    }
}
