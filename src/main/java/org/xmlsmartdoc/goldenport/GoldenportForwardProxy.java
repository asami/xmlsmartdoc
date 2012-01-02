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

/**
 * A forward proxy object for a interface 'goldenport'.
 *
 * @version goldenport.rcdl 1.0 (Fri Jul 29 11:55:14 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public abstract class GoldenportForwardProxy implements IGoldenport {
    private GoldenportContext rContext_;
    private IGoldenportFilter rReference_;

    /**
     * @param context
     */
    public void rSetContext(GoldenportContext context) {
        rContext_ = context;
        if (rReference_ != null) {
            rReference_.rSetContext(context);
        }
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
     * @param filter
     */
    public void rPushFilter(IGoldenportFilter filter) {
        filter.rSetReference$Goldenport(rReference_);
        rReference_ = filter;
    }

    /**
     * @return IGoldenportFilter
     */
    public IGoldenportFilter rPopFilter() {
        IGoldenportFilter filter = rReference_;
        rReference_ = filter.rGetReference$Goldenport();
        return (filter);
    }

    /**
     * @param reference
     */
    public void rSetReference(IGoldenportFilter reference) {
        rReference_ = reference;
    }

    /**
     * @return IGoldenportFilter
     */
    public IGoldenportFilter rGetReference() {
        return (rReference_);
    }

    /**
     * Forwards a request of the operation eval.
     *
     * @param source
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document eval(String source) throws RemoteException {
        IGoldenportFilter $reference$ = rReference_;
        try {
            return ($reference$.eval$Goldenport(source));
        } catch (RemoteException e) {
            throw (e);
        } catch (Exception e) {
            throw (new RemoteException(e.getMessage(), e));
        }
    }

    /**
     * Forwards a request of the operation evalDocument.
     *
     * @param source
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document evalDocument(org.w3c.dom.Document source) throws RemoteException {
        IGoldenportFilter $reference$ = rReference_;
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
    public void setSystemConfig(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig systemConfig) throws RemoteException {
        rReference_.setSystemConfig$Goldenport(systemConfig);
    }

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    public org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getSystemConfig() throws RemoteException {
        return (rReference_.getSystemConfig$Goldenport());
    }

    /**
     * @param config
     * @exception RemoteException
     */
    public void setConfig(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig config) throws RemoteException {
        rReference_.setConfig$Goldenport(config);
    }

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    public org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getConfig() throws RemoteException {
        return (rReference_.getConfig$Goldenport());
    }

    /**
     * @param systemMacro
     * @exception RemoteException
     */
    public void setSystemMacro(org.w3c.dom.Document systemMacro) throws RemoteException {
        rReference_.setSystemMacro$Goldenport(systemMacro);
    }

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document getSystemMacro() throws RemoteException {
        return (rReference_.getSystemMacro$Goldenport());
    }

    /**
     * @param macro
     * @exception RemoteException
     */
    public void setMacro(org.w3c.dom.Document macro) throws RemoteException {
        rReference_.setMacro$Goldenport(macro);
    }

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document getMacro() throws RemoteException {
        return (rReference_.getMacro$Goldenport());
    }

    /**
     * @param xmlBase
     * @exception RemoteException
     */
    public void setXmlBase(String xmlBase) throws RemoteException {
        rReference_.setXmlBase$Goldenport(xmlBase);
    }

    /**
     * @exception RemoteException
     * @return String
     */
    public String getXmlBase() throws RemoteException {
        return (rReference_.getXmlBase$Goldenport());
    }
}
