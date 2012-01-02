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

public class GoldenportContainer implements IGoldenportFilter {
    private GoldenportContext rContext_;
    private IGoldenportService rReference_;
    private IGoldenportFilter rReference$Goldenport_;

    /**
     * Creates a container for a service provider of the interface IGoldenportService.
     *
     */
    public GoldenportContainer() {
        this(new org.xmlsmartdoc.goldenport.service.GoldenportService());
    }

    /**
     * Creates a container for a service provider of the interface IGoldenportService.
     *
     * @param provider
     */
    public GoldenportContainer(IGoldenportService provider) {
        // XXX
        // RComponentContext context = RComponentContext.getContext(this);
        // rSetContext(context);
        // provider.rSetContext(context);
        // XXX
        rSetReference(provider);
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
     * @param reference
     */
    public void rSetReference(IGoldenportService reference) {
        rReference_ = reference;
    }

    /**
     * @return IGoldenportService
     */
    public IGoldenportService rGetReference() {
        return (rReference_);
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
     * Server proxy implementation of the operation eval.
     *
     * @param source
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document eval$Goldenport(String source) throws RemoteException {
        try {
            org.w3c.dom.Document $result$ = rGetReference().eval(source);
            return ($result$);
        } catch (RemoteException e) {
            throw (e);
        } catch (Exception e) {
            throw (new RemoteException(e.getMessage(), e));
        }
    }

    /**
     * Server proxy implementation of the operation evalDocument.
     *
     * @param source
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document evalDocument$Goldenport(org.w3c.dom.Document source) throws RemoteException {
        try {
            org.w3c.dom.Document $result$ = rGetReference().evalDocument(source);
            return ($result$);
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
        rReference_.setSystemConfig(systemConfig);
    }

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    public org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getSystemConfig$Goldenport() throws RemoteException {
        return (rReference_.getSystemConfig());
    }

    /**
     * @param config
     * @exception RemoteException
     */
    public void setConfig$Goldenport(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig config) throws RemoteException {
        rReference_.setConfig(config);
    }

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    public org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getConfig$Goldenport() throws RemoteException {
        return (rReference_.getConfig());
    }

    /**
     * @param systemMacro
     * @exception RemoteException
     */
    public void setSystemMacro$Goldenport(org.w3c.dom.Document systemMacro) throws RemoteException {
        rReference_.setSystemMacro(systemMacro);
    }

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document getSystemMacro$Goldenport() throws RemoteException {
        return (rReference_.getSystemMacro());
    }

    /**
     * @param macro
     * @exception RemoteException
     */
    public void setMacro$Goldenport(org.w3c.dom.Document macro) throws RemoteException {
        rReference_.setMacro(macro);
    }

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document getMacro$Goldenport() throws RemoteException {
        return (rReference_.getMacro());
    }

    /**
     * @param xmlBase
     * @exception RemoteException
     */
    public void setXmlBase$Goldenport(String xmlBase) throws RemoteException {
        rReference_.setXmlBase(xmlBase);
    }

    /**
     * @exception RemoteException
     * @return String
     */
    public String getXmlBase$Goldenport() throws RemoteException {
        return (rReference_.getXmlBase());
    }
}
