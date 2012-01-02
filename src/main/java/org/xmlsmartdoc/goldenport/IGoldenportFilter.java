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

import java.rmi.*;

/**
 * A filter interface a interface 'goldenport'.
 *
 * @version goldenport.rcdl 1.0 (Fri Jul 29 11:55:14 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public interface IGoldenportFilter {
    /**
     * Application interface of the operation eval.
     *
     * @param source
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    org.w3c.dom.Document eval$Goldenport(String source) throws RemoteException;

    /**
     * Application interface of the operation evalDocument.
     *
     * @param source
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    org.w3c.dom.Document evalDocument$Goldenport(org.w3c.dom.Document source) throws RemoteException;

    /**
     * @param systemConfig
     * @exception RemoteException
     */
    void setSystemConfig$Goldenport(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig systemConfig) throws RemoteException;

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getSystemConfig$Goldenport() throws RemoteException;

    /**
     * @param config
     * @exception RemoteException
     */
    void setConfig$Goldenport(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig config) throws RemoteException;

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getConfig$Goldenport() throws RemoteException;

    /**
     * @param systemMacro
     * @exception RemoteException
     */
    void setSystemMacro$Goldenport(org.w3c.dom.Document systemMacro) throws RemoteException;

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    org.w3c.dom.Document getSystemMacro$Goldenport() throws RemoteException;

    /**
     * @param macro
     * @exception RemoteException
     */
    void setMacro$Goldenport(org.w3c.dom.Document macro) throws RemoteException;

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    org.w3c.dom.Document getMacro$Goldenport() throws RemoteException;

    /**
     * @param xmlBase
     * @exception RemoteException
     */
    void setXmlBase$Goldenport(String xmlBase) throws RemoteException;

    /**
     * @exception RemoteException
     * @return String
     */
    String getXmlBase$Goldenport() throws RemoteException;

    /**
     * Sets a ralaxer component context.
     *
     * @param context
     */
    void rSetContext(GoldenportContext context);

    /**
     * Imports a ralaxer component context.
     *
     * @param context
     */
    void rImportContext(String context);

    /**
     * @param reference$Goldenport
     */
    void rSetReference$Goldenport(IGoldenportFilter reference$Goldenport);

    /**
     * @return IGoldenportFilter
     */
    IGoldenportFilter rGetReference$Goldenport();
}
