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

/**
 * A RelaxerFramework context for a component 'goldenport'.
 *
 * @version goldenport.rcdl 1.0 (Fri Jul 29 11:55:14 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class GoldenportContext extends RComponentContext {
    private org.xmlsmartdoc.goldenport.config.GcGoldenportConfig systemConfig_;
    private org.xmlsmartdoc.goldenport.config.GcGoldenportConfig config_;
    private org.w3c.dom.Document systemMacro_;
    private org.w3c.dom.Document macro_;
    private String xmlBase_;

    /**
     * @param systemConfig
     * @exception RemoteException
     */
    public void setSystemConfig(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig systemConfig) throws RemoteException {
        systemConfig_ = systemConfig;
    }

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    public org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getSystemConfig() throws RemoteException {
        return (systemConfig_);
    }

    /**
     * @param config
     * @exception RemoteException
     */
    public void setConfig(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig config) throws RemoteException {
        config_ = config;
    }

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    public org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getConfig() throws RemoteException {
        return (config_);
    }

    /**
     * @param systemMacro
     * @exception RemoteException
     */
    public void setSystemMacro(org.w3c.dom.Document systemMacro) throws RemoteException {
        systemMacro_ = systemMacro;
    }

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document getSystemMacro() throws RemoteException {
        return (systemMacro_);
    }

    /**
     * @param macro
     * @exception RemoteException
     */
    public void setMacro(org.w3c.dom.Document macro) throws RemoteException {
        macro_ = macro;
    }

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document getMacro() throws RemoteException {
        return (macro_);
    }

    /**
     * @param xmlBase
     * @exception RemoteException
     */
    public void setXmlBase(String xmlBase) throws RemoteException {
        xmlBase_ = xmlBase;
    }

    /**
     * @exception RemoteException
     * @return String
     */
    public String getXmlBase() throws RemoteException {
        return (xmlBase_);
    }
}
