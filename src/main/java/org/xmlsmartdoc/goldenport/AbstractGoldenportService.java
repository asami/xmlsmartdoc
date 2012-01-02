/*
 * The Relaxer artifact
 * Copyright (c) 2000-2004, ASAMI Tomoharu, All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer. 
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.xmlsmartdoc.goldenport;

import java.rmi.RemoteException;
import java.util.Map;

/**
 * A abstract service object for a interface 'goldenport'.
 *
 * @version goldenport.rcdl 1.0 (Fri Jul 29 11:55:14 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public abstract class AbstractGoldenportService implements IGoldenportService {
    private GoldenportContext context_;

    /**
     * @param systemConfig
     * @exception RemoteException
     */
    public void setSystemConfig(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig systemConfig) throws RemoteException {
        context_.setSystemConfig(systemConfig);
    }

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    public org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getSystemConfig() throws RemoteException {
        return (context_.getSystemConfig());
    }

    /**
     * @param config
     * @exception RemoteException
     */
    public void setConfig(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig config) throws RemoteException {
        context_.setConfig(config);
    }

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    public org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getConfig() throws RemoteException {
        return (context_.getConfig());
    }

    /**
     * @param systemMacro
     * @exception RemoteException
     */
    public void setSystemMacro(org.w3c.dom.Document systemMacro) throws RemoteException {
        context_.setSystemMacro(systemMacro);
    }

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document getSystemMacro() throws RemoteException {
        return (context_.getSystemMacro());
    }

    /**
     * @param macro
     * @exception RemoteException
     */
    public void setMacro(org.w3c.dom.Document macro) throws RemoteException {
        context_.setMacro(macro);
    }

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document getMacro() throws RemoteException {
        return (context_.getMacro());
    }

    /**
     * @param xmlBase
     * @exception RemoteException
     */
    public void setXmlBase(String xmlBase) throws RemoteException {
        context_.setXmlBase(xmlBase);
    }

    /**
     * @exception RemoteException
     * @return String
     */
    public String getXmlBase() throws RemoteException {
        return (context_.getXmlBase());
    }

    /**
     * Constructor.
     *
     */
    public AbstractGoldenportService() {
    }

    /**
     * Sets a ralaxer component context.
     *
     * @param context
     */
    public void rSetContext(GoldenportContext context) {
        context_ = context;
    }

    /**
     * Gets a ralaxer component context.
     *
     * @return GoldenportContext
     */
    public GoldenportContext rGetContext() {
        return (context_);
    }

    /**
     * Gets a session context.
     *
     * @return org.relaxer.framework.runtime.RSessionContext
     */
    public org.relaxer.framework.runtime.RSessionContext rGetSession() {
        return (context_.getSessionContext());
    }

    /**
     * Gets the default ClassLoader.
     *
     * @return ClassLoader
     */
    public ClassLoader rGetClassLoader() {
        return (context_.getClassLoader());
    }

    /**
     * Gets the default DocumentBuilder.
     *
     * @return javax.xml.parsers.DocumentBuilder
     */
    public javax.xml.parsers.DocumentBuilder rGetDocumentBuilder() {
        return (context_.getDocumentBuilder());
    }

    /**
     * Gets the default Logger.
     *
     * @return org.relaxer.framework.logger.IRFrameworkLogger
     */
    public org.relaxer.framework.logger.IRFrameworkLogger rGetLogger() {
        return (context_.getLogger());
    }

    /**
     * Gets a session context.
     *
     * @return org.relaxer.framework.parcel.IParcel
     */
    public org.relaxer.framework.parcel.IParcel rMakeParcel() {
        return (context_.makeParcel());
    }

    /**
     * Gets the default DataSource.
     *
     * @return javax.sql.DataSource
     */
    public javax.sql.DataSource rGetDataSource() {
        return (context_.getDataSource());
    }

    /**
     * Opens a jdbc connection from the default DataSource.
     *
     * @exception java.sql.SQLException
     * @return java.sql.Connection
     */
    public java.sql.Connection rOpenDataSourceConnection() throws java.sql.SQLException {
        return (context_.openDataSourceConnection());
    }

    /**
     * Setups the Relaxer Table Object for the container.
     *
     * @param rto
     * @exception org.relaxer.framework.runtime.RelaxerRuntimeException
     */
    public void rtoSetup(Object rto) throws org.relaxer.framework.runtime.RelaxerRuntimeException {
        context_.rtoSetup(rto);
    }

    /**
     * Sets properties.
     *
     * @param properties
     */
    public void rSetProperties(Map properties) {
    }

    /**
     * Notifies the create event.
     *
     * @exception RemoteException
     */
    public void rCreate() throws RemoteException {
    }

    /**
     * Notifies the activate event.
     *
     * @exception RemoteException
     */
    public void rActivate() throws RemoteException {
    }

    /**
     * Notifies the passivate event.
     *
     * @exception RemoteException
     */
    public void rPassivate() throws RemoteException {
    }

    /**
     * Notifies the remove event.
     *
     * @exception RemoteException
     */
    public void rRemove() throws RemoteException {
    }

    /**
     * Sets the context of the current container architecture.
     *
     * @param key
     * @param context
     * @exception RemoteException
     */
    public void rSetContext(String key, Object context) throws RemoteException {
    }
}
