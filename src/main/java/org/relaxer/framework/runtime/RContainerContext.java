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

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.SAXParser;

import org.relaxer.framework.RelaxerFramework;
import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.framework.runtime.messager.IRFrameworkMessager;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.reporter.IRFrameworkReporter;
import org.xml.sax.XMLReader;

/**
 * RContainerContext
 *
 * @since   Aug. 30, 2003
 * @version Aug. 27, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RContainerContext {
    private RelaxerFramework framework_;
    private RRuntimeContext runtimeContext_;
    private RSessionContext sessionContext_;
    private IRModelContext modelContext_ = null;
    private String textEncoding_;
    private String newLine_;
    private IRFrameworkLogger logger_ = null;
    private IRFrameworkMessager messager_ = null;
    private IRFrameworkReporter reporter_ = null;
    private DataSource datasource_;
    private IJdbcConfig jdbcConfig_;
    private String jdbcUsername_;
    private String jdbcPassword_;
    private List componentContexts_ = new ArrayList();

    public RContainerContext(RelaxerFramework framework) {
        framework_ = framework;
    }

    public void setRuntimeContext(RRuntimeContext runtimeContext) {
        runtimeContext_ = runtimeContext;
    }

    public void addComponentContext(RComponentContext componentContext) {
        componentContexts_.add(componentContext);
        componentContext.setContainerContext(this);
    }

    public void setSessionContext(RSessionContext sessionContext) {
        sessionContext_ = sessionContext;
    }

    public RSessionContext getSessionContext() {
        return (sessionContext_);
    }

    public IRModelContext getModelContext() {
        if (modelContext_ != null) {
            return modelContext_;
        } else {
            return framework_.getModelContext();
        }
    }

    public void setTextEncoding(String textEncoding) {
        textEncoding_ = textEncoding;
    }

    public void setNewLine(String newLine) {
        newLine_ = newLine;
    }

    public String getTextEncoding() {
        if (textEncoding_ == null) {
            return "UTF-8";
        }
        return textEncoding_;
    }
    
    public String getNewLine() {
        if (newLine_ == null) {
            return "\n";
        }
        return newLine_;
    }

    public ClassLoader getClassLoader() {
        return (framework_.getClassLoader());
    }

    public DocumentBuilder getDocumentBuilder() {
        return (framework_.getDocumentBuilder());
    }

    public SAXParser getSAXParser() {
        return framework_.getSAXParser();
    }

    public XMLReader getXMLReader() {
        return framework_.getXMLReader();
    }

    public final void setLogger(IRFrameworkLogger logger) {
        logger_ = logger;
    }

    public final IRFrameworkLogger getLogger() {
        if (logger_ != null) {
            return (logger_);
        } else {
            return (runtimeContext_.getLogger());
        }
    }

    public final void setMessager(IRFrameworkMessager messager) {
        messager_ = messager;
    }

    public final IRFrameworkMessager getMessager() {
        if (messager_ != null) {
            return (messager_);
        } else {
            return (runtimeContext_.getMessager());
        }
    }

    public final void setReporter(IRFrameworkReporter reporter) {
        reporter_ = reporter;
    }

    public final IRFrameworkReporter getReporter() {
        if (reporter_ != null) {
            return (reporter_);
        } else {
            return (runtimeContext_.getReporter());
        }
    }
    
    public final void setJdbcConfig(IJdbcConfig config) {
        jdbcConfig_ = config;
    }
    
    public final IJdbcConfig getJdbcConfig() {
        return (jdbcConfig_);
    }

    public void setJdbcUsername(String username) {
        jdbcUsername_ = username;
    }

    public void setJdbcPassword(String password) {
        jdbcPassword_ = password;
    }

    public void setDataSource(DataSource ds) {
        datasource_ = ds;
    }
    
    public DataSource getDataSource() {
        return (datasource_);
    }
    
    public DataSource getDataSource(String name) {
        throw (new UnsupportedOperationException());
    }
    
    public Connection openDataSourceConnection() throws SQLException {
        if (datasource_ == null) {
            return (null);
        }
        if (jdbcUsername_ != null) {
            return (datasource_.getConnection(jdbcUsername_, jdbcPassword_));
        } else {
            return (datasource_.getConnection());
        }
    }

    public void close() {
        sessionContext_.close();
    }

    // Relaxer Table Object
    public void rtoSetup(Object rto) throws RelaxerRuntimeException {
        if (jdbcConfig_ == null) {
            return;
        }
        framework_.rtoSetup(rto, jdbcConfig_);
    }
}
