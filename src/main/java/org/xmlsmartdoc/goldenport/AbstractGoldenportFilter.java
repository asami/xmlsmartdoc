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
import org.relaxer.framework.runtime.RComponentContext;

public abstract class AbstractGoldenportFilter implements IGoldenportFilter {
    private IGoldenportFilter rReference$Goldenport_;
    private Object rMaster_;
    private GoldenportContext rContext_;

    /**
     * @param master
     * @param context
     */
    public AbstractGoldenportFilter(Object master, GoldenportContext context) {
        rSetMaster(master);
        rSetContext(context);
    }

    /**
     * @param reference$Goldenport
     */
    public void rSetReference$Goldenport(IGoldenportFilter reference$Goldenport) {
        rReference$Goldenport_ = reference$Goldenport;
    }

    /**
     * @return IGoldenportFilter
     */
    public IGoldenportFilter rGetReference$Goldenport() {
        return (rReference$Goldenport_);
    }

    /**
     * @param master
     */
    public void rSetMaster(Object master) {
        rMaster_ = master;
    }

    /**
     * @return Object
     */
    public Object rGetMaster() {
        return (rMaster_);
    }

    /**
     * Informs a name of the service provider.
     *
     * @return String
     */
    protected String rGetServiceName() {
        return (rGetMaster().getClass().getName());
    }

    /**
     * @param context
     */
    public void rSetContext(GoldenportContext context) {
        rContext_ = context;
    }

    /**
     * @return GoldenportContext
     */
    public GoldenportContext rGetContext() {
        return (rContext_);
    }

    /**
     * @param context
     */
    public void rImportContext(String context) {
        rContext_.importContext(context);
    }

    /**
     * Logs a message for a fatal condition.
     *
     * @param message
     */
    protected void rLogFatal(String message) {
        RComponentContext context = rGetContext();
        context.logFatal(message);
    }

    /**
     * Logs a message for a fatal condition.
     *
     * @param message
     * @param e
     */
    protected void rLogFatal(String message, Throwable e) {
        RComponentContext context = rGetContext();
        context.logFatal(message, e);
    }

    /**
     * Logs a message for a fatal condition.
     *
     * @param message
     * @param arg
     */
    protected void rLogFatal(String message, Object arg) {
        RComponentContext context = rGetContext();
        context.logFatal(message, arg);
    }

    /**
     * Logs a message for a fatal condition.
     *
     * @param message
     * @param arg
     * @param e
     */
    protected void rLogFatal(String message, Object arg, Throwable e) {
        RComponentContext context = rGetContext();
        context.logFatal(message, arg, e);
    }

    /**
     * Logs a message for a fatal condition.
     *
     * @param message
     * @param arg1
     * @param arg2
     */
    protected void rLogFatal(String message, Object arg1, Object arg2) {
        RComponentContext context = rGetContext();
        context.logFatal(message, arg1, arg2);
    }

    /**
     * Logs a message for a fatal condition.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param e
     */
    protected void rLogFatal(String message, Object arg1, Object arg2, Throwable e) {
        RComponentContext context = rGetContext();
        context.logFatal(message, arg1, arg2, e);
    }

    /**
     * Logs a message for a fatal condition.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param arg3
     */
    protected void rLogFatal(String message, Object arg1, Object arg2, Object arg3) {
        RComponentContext context = rGetContext();
        context.logFatal(message, arg1, arg2, arg3);
    }

    /**
     * Logs a message for a fatal condition.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param arg3
     * @param e
     */
    protected void rLogFatal(String message, Object arg1, Object arg2, Object arg3, Throwable e) {
        RComponentContext context = rGetContext();
        context.logFatal(message, arg1, arg2, arg3, e);
    }

    /**
     * Logs a message for a fatal condition.
     *
     * @param message
     * @param args
     */
    protected void rLogFatal(String message, Object[] args) {
        RComponentContext context = rGetContext();
        context.logFatal(message, args);
    }

    /**
     * Logs a message for a fatal condition.
     *
     * @param message
     * @param args
     * @param e
     */
    protected void rLogFatal(String message, Object[] args, Throwable e) {
        RComponentContext context = rGetContext();
        context.logFatal(message, args, e);
    }

    /**
     * Logs a message for a error condition.
     *
     * @param message
     */
    protected void rLogError(String message) {
        RComponentContext context = rGetContext();
        context.logError(message);
    }

    /**
     * Logs a message for a error condition.
     *
     * @param message
     * @param e
     */
    protected void rLogError(String message, Throwable e) {
        RComponentContext context = rGetContext();
        context.logError(message, e);
    }

    /**
     * Logs a message for a error condition.
     *
     * @param message
     * @param arg
     */
    protected void rLogError(String message, Object arg) {
        RComponentContext context = rGetContext();
        context.logError(message, arg);
    }

    /**
     * Logs a message for a error condition.
     *
     * @param message
     * @param arg
     * @param e
     */
    protected void rLogError(String message, Object arg, Throwable e) {
        RComponentContext context = rGetContext();
        context.logError(message, arg, e);
    }

    /**
     * Logs a message for a error condition.
     *
     * @param message
     * @param arg1
     * @param arg2
     */
    protected void rLogError(String message, Object arg1, Object arg2) {
        RComponentContext context = rGetContext();
        context.logError(message, arg1, arg2);
    }

    /**
     * Logs a message for a error condition.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param e
     */
    protected void rLogError(String message, Object arg1, Object arg2, Throwable e) {
        RComponentContext context = rGetContext();
        context.logError(message, arg1, arg2, e);
    }

    /**
     * Logs a message for a error condition.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param arg3
     */
    protected void rLogError(String message, Object arg1, Object arg2, Object arg3) {
        RComponentContext context = rGetContext();
        context.logError(message, arg1, arg2, arg3);
    }

    /**
     * Logs a message for a error condition.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param arg3
     * @param e
     */
    protected void rLogError(String message, Object arg1, Object arg2, Object arg3, Throwable e) {
        RComponentContext context = rGetContext();
        context.logError(message, arg1, arg2, arg3, e);
    }

    /**
     * Logs a message for a error condition.
     *
     * @param message
     * @param args
     */
    protected void rLogError(String message, Object[] args) {
        RComponentContext context = rGetContext();
        context.logError(message, args);
    }

    /**
     * Logs a message for a error condition.
     *
     * @param message
     * @param args
     * @param e
     */
    protected void rLogError(String message, Object[] args, Throwable e) {
        RComponentContext context = rGetContext();
        context.logError(message, args, e);
    }

    /**
     * Logs a message for a warning condition.
     *
     * @param message
     */
    protected void rLogWarning(String message) {
        RComponentContext context = rGetContext();
        context.logWarning(message);
    }

    /**
     * Logs a message for a warning condition.
     *
     * @param message
     * @param e
     */
    protected void rLogWarning(String message, Throwable e) {
        RComponentContext context = rGetContext();
        context.logWarning(message, e);
    }

    /**
     * Logs a message for a warning condition.
     *
     * @param message
     * @param arg
     */
    protected void rLogWarning(String message, Object arg) {
        RComponentContext context = rGetContext();
        context.logWarning(message, arg);
    }

    /**
     * Logs a message for a warning condition.
     *
     * @param message
     * @param arg
     * @param e
     */
    protected void rLogWarning(String message, Object arg, Throwable e) {
        RComponentContext context = rGetContext();
        context.logWarning(message, arg, e);
    }

    /**
     * Logs a message for a warning condition.
     *
     * @param message
     * @param arg1
     * @param arg2
     */
    protected void rLogWarning(String message, Object arg1, Object arg2) {
        RComponentContext context = rGetContext();
        context.logWarning(message, arg1, arg2);
    }

    /**
     * Logs a message for a warning condition.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param e
     */
    protected void rLogWarning(String message, Object arg1, Object arg2, Throwable e) {
        RComponentContext context = rGetContext();
        context.logWarning(message, arg1, arg2, e);
    }

    /**
     * Logs a message for a warning condition.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param arg3
     */
    protected void rLogWarning(String message, Object arg1, Object arg2, Object arg3) {
        RComponentContext context = rGetContext();
        context.logWarning(message, arg1, arg2, arg3);
    }

    /**
     * Logs a message for a warning condition.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param arg3
     * @param e
     */
    protected void rLogWarning(String message, Object arg1, Object arg2, Object arg3, Throwable e) {
        RComponentContext context = rGetContext();
        context.logWarning(message, arg1, arg2, arg3, e);
    }

    /**
     * Logs a message for a warning condition.
     *
     * @param message
     * @param args
     */
    protected void rLogWarning(String message, Object[] args) {
        RComponentContext context = rGetContext();
        context.logWarning(message, args);
    }

    /**
     * Logs a message for a warning condition.
     *
     * @param message
     * @param args
     * @param e
     */
    protected void rLogWarning(String message, Object[] args, Throwable e) {
        RComponentContext context = rGetContext();
        context.logWarning(message, args, e);
    }

    /**
     * Logs a message for information.
     *
     * @param message
     */
    protected void rLogInfo(String message) {
        RComponentContext context = rGetContext();
        context.logInfo(message);
    }

    /**
     * Logs a message for information.
     *
     * @param message
     * @param e
     */
    protected void rLogInfo(String message, Throwable e) {
        RComponentContext context = rGetContext();
        context.logInfo(message, e);
    }

    /**
     * Logs a message for information.
     *
     * @param message
     * @param arg
     */
    protected void rLogInfo(String message, Object arg) {
        RComponentContext context = rGetContext();
        context.logInfo(message, arg);
    }

    /**
     * Logs a message for information.
     *
     * @param message
     * @param arg
     * @param e
     */
    protected void rLogInfo(String message, Object arg, Throwable e) {
        RComponentContext context = rGetContext();
        context.logInfo(message, arg, e);
    }

    /**
     * Logs a message for information.
     *
     * @param message
     * @param arg1
     * @param arg2
     */
    protected void rLogInfo(String message, Object arg1, Object arg2) {
        RComponentContext context = rGetContext();
        context.logInfo(message, arg1, arg2);
    }

    /**
     * Logs a message for information.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param e
     */
    protected void rLogInfo(String message, Object arg1, Object arg2, Throwable e) {
        RComponentContext context = rGetContext();
        context.logInfo(message, arg1, arg2, e);
    }

    /**
     * Logs a message for information.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param arg3
     */
    protected void rLogInfo(String message, Object arg1, Object arg2, Object arg3) {
        RComponentContext context = rGetContext();
        context.logInfo(message, arg1, arg2, arg3);
    }

    /**
     * Logs a message for information.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param arg3
     * @param e
     */
    protected void rLogInfo(String message, Object arg1, Object arg2, Object arg3, Throwable e) {
        RComponentContext context = rGetContext();
        context.logInfo(message, arg1, arg2, arg3, e);
    }

    /**
     * Logs a message for information.
     *
     * @param message
     * @param args
     */
    protected void rLogInfo(String message, Object[] args) {
        RComponentContext context = rGetContext();
        context.logInfo(message, args);
    }

    /**
     * Logs a message for information.
     *
     * @param message
     * @param args
     * @param e
     */
    protected void rLogInfo(String message, Object[] args, Throwable e) {
        RComponentContext context = rGetContext();
        context.logInfo(message, args, e);
    }

    /**
     * Logs a message for config settings.
     *
     * @param message
     */
    protected void rLogConfig(String message) {
        RComponentContext context = rGetContext();
        context.logConfig(message);
    }

    /**
     * Logs a message for config settings.
     *
     * @param message
     * @param e
     */
    protected void rLogConfig(String message, Throwable e) {
        RComponentContext context = rGetContext();
        context.logConfig(message, e);
    }

    /**
     * Logs a message for config settings.
     *
     * @param message
     * @param arg
     */
    protected void rLogConfig(String message, Object arg) {
        RComponentContext context = rGetContext();
        context.logConfig(message, arg);
    }

    /**
     * Logs a message for config settings.
     *
     * @param message
     * @param arg
     * @param e
     */
    protected void rLogConfig(String message, Object arg, Throwable e) {
        RComponentContext context = rGetContext();
        context.logConfig(message, arg, e);
    }

    /**
     * Logs a message for config settings.
     *
     * @param message
     * @param arg1
     * @param arg2
     */
    protected void rLogConfig(String message, Object arg1, Object arg2) {
        RComponentContext context = rGetContext();
        context.logConfig(message, arg1, arg2);
    }

    /**
     * Logs a message for config settings.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param e
     */
    protected void rLogConfig(String message, Object arg1, Object arg2, Throwable e) {
        RComponentContext context = rGetContext();
        context.logConfig(message, arg1, arg2, e);
    }

    /**
     * Logs a message for config settings.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param arg3
     */
    protected void rLogConfig(String message, Object arg1, Object arg2, Object arg3) {
        RComponentContext context = rGetContext();
        context.logConfig(message, arg1, arg2, arg3);
    }

    /**
     * Logs a message for config settings.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param arg3
     * @param e
     */
    protected void rLogConfig(String message, Object arg1, Object arg2, Object arg3, Throwable e) {
        RComponentContext context = rGetContext();
        context.logConfig(message, arg1, arg2, arg3, e);
    }

    /**
     * Logs a message for config settings.
     *
     * @param message
     * @param args
     */
    protected void rLogConfig(String message, Object[] args) {
        RComponentContext context = rGetContext();
        context.logConfig(message, args);
    }

    /**
     * Logs a message for config settings.
     *
     * @param message
     * @param args
     * @param e
     */
    protected void rLogConfig(String message, Object[] args, Throwable e) {
        RComponentContext context = rGetContext();
        context.logConfig(message, args, e);
    }

    /**
     * Logs a message.
     *
     * @param method
     * @param arg
     */
    protected void rLogEntering(String method, String arg) {
        GoldenportContext context = rGetContext();
        context.logEntering(rGetMaster(), method, arg);
    }

    /**
     * Logs a message.
     *
     * @param method
     * @param arg1
     * @param arg2
     */
    protected void rLogEntering(String method, String arg1, String arg2) {
        GoldenportContext context = rGetContext();
        context.logEntering(rGetMaster(), method, arg1, arg2);
    }

    /**
     * Logs a message.
     *
     * @param method
     * @param arg1
     * @param arg2
     * @param arg3
     */
    protected void rLogEntering(String method, String arg1, String arg2, String arg3) {
        GoldenportContext context = rGetContext();
        context.logEntering(rGetMaster(), method, arg1, arg2, arg3);
    }

    /**
     * Logs a message.
     *
     * @param method
     * @param args
     */
    protected void rLogEntering(String method, String[] args) {
        GoldenportContext context = rGetContext();
        context.logEntering(rGetMaster(), method, args);
    }

    /**
     * Logs a message.
     *
     * @param method
     */
    protected void rLogExiting(String method) {
        GoldenportContext context = rGetContext();
        context.logExiting(rGetMaster(), method);
    }

    /**
     * Logs a message.
     *
     * @param method
     * @param result
     */
    protected void rLogExiting(String method, String result) {
        GoldenportContext context = rGetContext();
        context.logExiting(rGetMaster(), method, result);
    }

    /**
     * Logs a message.
     *
     * @param method
     * @param e
     */
    protected void rLogExiting(String method, Exception e) {
        GoldenportContext context = rGetContext();
        context.logExiting(rGetMaster(), method, e);
    }

    /**
     * Logs a message for debug information.
     *
     * @param message
     */
    protected void rLogDebug(String message) {
        RComponentContext context = rGetContext();
        context.logDebug(message);
    }

    /**
     * Logs a message for debug information.
     *
     * @param message
     * @param e
     */
    protected void rLogDebug(String message, Throwable e) {
        RComponentContext context = rGetContext();
        context.logDebug(message, e);
    }

    /**
     * Logs a message for debug information.
     *
     * @param message
     * @param arg
     */
    protected void rLogDebug(String message, Object arg) {
        RComponentContext context = rGetContext();
        context.logDebug(message, arg);
    }

    /**
     * Logs a message for debug information.
     *
     * @param message
     * @param arg
     * @param e
     */
    protected void rLogDebug(String message, Object arg, Throwable e) {
        RComponentContext context = rGetContext();
        context.logDebug(message, arg, e);
    }

    /**
     * Logs a message for debug information.
     *
     * @param message
     * @param arg1
     * @param arg2
     */
    protected void rLogDebug(String message, Object arg1, Object arg2) {
        RComponentContext context = rGetContext();
        context.logDebug(message, arg1, arg2);
    }

    /**
     * Logs a message for debug information.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param e
     */
    protected void rLogDebug(String message, Object arg1, Object arg2, Throwable e) {
        RComponentContext context = rGetContext();
        context.logDebug(message, arg1, arg2, e);
    }

    /**
     * Logs a message for debug information.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param arg3
     */
    protected void rLogDebug(String message, Object arg1, Object arg2, Object arg3) {
        RComponentContext context = rGetContext();
        context.logDebug(message, arg1, arg2, arg3);
    }

    /**
     * Logs a message for debug information.
     *
     * @param message
     * @param arg1
     * @param arg2
     * @param arg3
     * @param e
     */
    protected void rLogDebug(String message, Object arg1, Object arg2, Object arg3, Throwable e) {
        RComponentContext context = rGetContext();
        context.logDebug(message, arg1, arg2, arg3, e);
    }

    /**
     * Logs a message for debug information.
     *
     * @param message
     * @param args
     */
    protected void rLogDebug(String message, Object[] args) {
        RComponentContext context = rGetContext();
        context.logDebug(message, args);
    }

    /**
     * Logs a message for debug information.
     *
     * @param message
     * @param args
     * @param e
     */
    protected void rLogDebug(String message, Object[] args, Throwable e) {
        RComponentContext context = rGetContext();
        context.logDebug(message, args, e);
    }

    /**
     * Forwards request of the operation eval$Goldenport.
     *
     * @param source
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document eval$Goldenport(String source) throws RemoteException {
        IGoldenportFilter $reference$ = rGetReference$Goldenport();
        try {
            return ($reference$.eval$Goldenport(source));
        } catch (RemoteException e) {
            throw (e);
        } catch (Exception e) {
            throw (new RemoteException(e.getMessage(), e));
        }
    }

    /**
     * Forwards request of the operation evalDocument$Goldenport.
     *
     * @param source
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document evalDocument$Goldenport(org.w3c.dom.Document source) throws RemoteException {
        IGoldenportFilter $reference$ = rGetReference$Goldenport();
        try {
            return ($reference$.evalDocument$Goldenport(source));
        } catch (RemoteException e) {
            throw (e);
        } catch (Exception e) {
            throw (new RemoteException(e.getMessage(), e));
        }
    }

    /**
     * @param systemConfig
     * @exception RemoteException
     */
    public void setSystemConfig$Goldenport(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig systemConfig) throws RemoteException {
        rReference$Goldenport_.setSystemConfig$Goldenport(systemConfig);
    }

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    public org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getSystemConfig$Goldenport() throws RemoteException {
        return (rReference$Goldenport_.getSystemConfig$Goldenport());
    }

    /**
     * @param config
     * @exception RemoteException
     */
    public void setConfig$Goldenport(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig config) throws RemoteException {
        rReference$Goldenport_.setConfig$Goldenport(config);
    }

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    public org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getConfig$Goldenport() throws RemoteException {
        return (rReference$Goldenport_.getConfig$Goldenport());
    }

    /**
     * @param systemMacro
     * @exception RemoteException
     */
    public void setSystemMacro$Goldenport(org.w3c.dom.Document systemMacro) throws RemoteException {
        rReference$Goldenport_.setSystemMacro$Goldenport(systemMacro);
    }

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document getSystemMacro$Goldenport() throws RemoteException {
        return (rReference$Goldenport_.getSystemMacro$Goldenport());
    }

    /**
     * @param macro
     * @exception RemoteException
     */
    public void setMacro$Goldenport(org.w3c.dom.Document macro) throws RemoteException {
        rReference$Goldenport_.setMacro$Goldenport(macro);
    }

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document getMacro$Goldenport() throws RemoteException {
        return (rReference$Goldenport_.getMacro$Goldenport());
    }

    /**
     * @param xmlBase
     * @exception RemoteException
     */
    public void setXmlBase$Goldenport(String xmlBase) throws RemoteException {
        rReference$Goldenport_.setXmlBase$Goldenport(xmlBase);
    }

    /**
     * @exception RemoteException
     * @return String
     */
    public String getXmlBase$Goldenport() throws RemoteException {
        return (rReference$Goldenport_.getXmlBase$Goldenport());
    }
}
