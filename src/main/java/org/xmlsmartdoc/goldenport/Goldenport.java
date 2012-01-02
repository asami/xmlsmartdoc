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
import org.relaxer.framework.RelaxerFramework;
import org.xmlsmartdoc.goldenport.lib.*;

/**
 * A RelaxerFramework application object for a component 'goldenport'.
 *
 * @version goldenport.rcdl 1.0 (Fri Jul 29 11:55:14 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class Goldenport implements IGoldenport {
    private RelaxerFramework framework_;

    /**
     * Application front end for component goldenport.
     *
     * @exception RemoteException
     */
    public Goldenport() throws RemoteException {
        this(new String[0]);
    }

    /**
     * Application front end for component goldenport.
     *
     * @param args
     * @exception RemoteException
     */
    public Goldenport(String[] args) throws RemoteException {
        framework_ = new RelaxerFramework(Goldenport.class , args);
    }

    /**
     * Application front end for component goldenport.
     *
     * @param args
     * @exception RemoteException
     */
    public static void main(String[] args) throws RemoteException {
        Goldenport app = null;
        try {
            app = new Goldenport(args);
            app.rExecute();
        } catch (Throwable e) {
            app.rGetFramework().handleCommandError(e);
        } finally {
            if (app != null) {
                app.rClose();
            }
        }
    }

    /**
     * Application front end for component goldenport.
     *
     * @exception RemoteException
     */
    public void rExecute() throws RemoteException {
        framework_.execute();
    }

    /**
     * Application front end for component goldenport.
     *
     * @exception RemoteException
     */
    public void rClose() throws RemoteException {
        framework_.close();
    }

    /**
     * Get a framework.
     *
     * @return RelaxerFramework
     */
    public RelaxerFramework rGetFramework() {
        return (framework_);
    }

    /**
     * Import context.
     *
     * @param context
     */
    public void rImportContext(String context) {
        framework_.importContext(context);
    }

    /**
     * Export context.
     *
     * @return String
     */
    public String rExportContext() {
        return (framework_.exportContext());
    }

    /**
     * Stimulate lifecycle create.
     *
     */
    public void rCreate() {
        framework_.create();
    }

    /**
     * Stimulate lifecycle activate.
     *
     */
    public void rActivate() {
        framework_.activate();
    }

    /**
     * Stimulate lifecycle passivate.
     *
     */
    public void rPassivate() {
        framework_.passivate();
    }

    /**
     * Stimulate lifecycle remove.
     *
     */
    public void rRemove() {
        framework_.remove();
    }

    /**
     * @param source
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document eval(String source) throws RemoteException {
        Object service = framework_.getService("eval");
        if (service instanceof org.xmlsmartdoc.goldenport.IGoldenport) {
            org.xmlsmartdoc.goldenport.IGoldenport comp = (org.xmlsmartdoc.goldenport.IGoldenport)service;
            return (comp.eval(source));
        } else {
            return ((org.w3c.dom.Document)framework_.invokeService("eval", new Object[] {source}));
        }
    }

    /**
     * @param source
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document evalDocument(org.w3c.dom.Document source) throws RemoteException {
        Object service = framework_.getService("evalDocument");
        if (service instanceof org.xmlsmartdoc.goldenport.IGoldenport) {
            org.xmlsmartdoc.goldenport.IGoldenport comp = (org.xmlsmartdoc.goldenport.IGoldenport)service;
            return (comp.evalDocument(source));
        } else {
            return ((org.w3c.dom.Document)framework_.invokeService("evalDocument", new Object[] {source}));
        }
    }

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    public org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getSystemConfig() throws RemoteException {
        Object service = framework_.getOption("systemConfig");
        if (service instanceof org.xmlsmartdoc.goldenport.IGoldenport) {
            org.xmlsmartdoc.goldenport.IGoldenport comp = (org.xmlsmartdoc.goldenport.IGoldenport)service;
            return (comp.getSystemConfig());
        } else {
            return ((org.xmlsmartdoc.goldenport.config.GcGoldenportConfig)framework_.getOptionValue("systemConfig"));
        }
    }

    /**
     * @param value
     * @exception RemoteException
     */
    public void setSystemConfig(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig value) throws RemoteException {
        Object service = framework_.getOption("systemConfig");
        if (service instanceof org.xmlsmartdoc.goldenport.IGoldenport) {
            org.xmlsmartdoc.goldenport.IGoldenport comp = (org.xmlsmartdoc.goldenport.IGoldenport)service;
            comp.setSystemConfig(value);
        } else {
            framework_.setOptionValue("systemConfig", value);
        }
    }

    /**
     * @exception RemoteException
     * @return org.xmlsmartdoc.goldenport.config.GcGoldenportConfig
     */
    public org.xmlsmartdoc.goldenport.config.GcGoldenportConfig getConfig() throws RemoteException {
        Object service = framework_.getOption("config");
        if (service instanceof org.xmlsmartdoc.goldenport.IGoldenport) {
            org.xmlsmartdoc.goldenport.IGoldenport comp = (org.xmlsmartdoc.goldenport.IGoldenport)service;
            return (comp.getConfig());
        } else {
            return ((org.xmlsmartdoc.goldenport.config.GcGoldenportConfig)framework_.getOptionValue("config"));
        }
    }

    /**
     * @param value
     * @exception RemoteException
     */
    public void setConfig(org.xmlsmartdoc.goldenport.config.GcGoldenportConfig value) throws RemoteException {
        Object service = framework_.getOption("config");
        if (service instanceof org.xmlsmartdoc.goldenport.IGoldenport) {
            org.xmlsmartdoc.goldenport.IGoldenport comp = (org.xmlsmartdoc.goldenport.IGoldenport)service;
            comp.setConfig(value);
        } else {
            framework_.setOptionValue("config", value);
        }
    }

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document getSystemMacro() throws RemoteException {
        Object service = framework_.getOption("systemMacro");
        if (service instanceof org.xmlsmartdoc.goldenport.IGoldenport) {
            org.xmlsmartdoc.goldenport.IGoldenport comp = (org.xmlsmartdoc.goldenport.IGoldenport)service;
            return (comp.getSystemMacro());
        } else {
            return ((org.w3c.dom.Document)framework_.getOptionValue("systemMacro"));
        }
    }

    /**
     * @param value
     * @exception RemoteException
     */
    public void setSystemMacro(org.w3c.dom.Document value) throws RemoteException {
        Object service = framework_.getOption("systemMacro");
        if (service instanceof org.xmlsmartdoc.goldenport.IGoldenport) {
            org.xmlsmartdoc.goldenport.IGoldenport comp = (org.xmlsmartdoc.goldenport.IGoldenport)service;
            comp.setSystemMacro(value);
        } else {
            framework_.setOptionValue("systemMacro", value);
        }
    }

    /**
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document getMacro() throws RemoteException {
        Object service = framework_.getOption("macro");
        if (service instanceof org.xmlsmartdoc.goldenport.IGoldenport) {
            org.xmlsmartdoc.goldenport.IGoldenport comp = (org.xmlsmartdoc.goldenport.IGoldenport)service;
            return (comp.getMacro());
        } else {
            return ((org.w3c.dom.Document)framework_.getOptionValue("macro"));
        }
    }

    /**
     * @param value
     * @exception RemoteException
     */
    public void setMacro(org.w3c.dom.Document value) throws RemoteException {
        Object service = framework_.getOption("macro");
        if (service instanceof org.xmlsmartdoc.goldenport.IGoldenport) {
            org.xmlsmartdoc.goldenport.IGoldenport comp = (org.xmlsmartdoc.goldenport.IGoldenport)service;
            comp.setMacro(value);
        } else {
            framework_.setOptionValue("macro", value);
        }
    }

    /**
     * @exception RemoteException
     * @return String
     */
    public String getXmlBase() throws RemoteException {
        Object service = framework_.getOption("xmlBase");
        if (service instanceof org.xmlsmartdoc.goldenport.IGoldenport) {
            org.xmlsmartdoc.goldenport.IGoldenport comp = (org.xmlsmartdoc.goldenport.IGoldenport)service;
            return (comp.getXmlBase());
        } else {
            return ((String)framework_.getOptionValue("xmlBase"));
        }
    }

    /**
     * @param value
     * @exception RemoteException
     */
    public void setXmlBase(String value) throws RemoteException {
        Object service = framework_.getOption("xmlBase");
        if (service instanceof org.xmlsmartdoc.goldenport.IGoldenport) {
            org.xmlsmartdoc.goldenport.IGoldenport comp = (org.xmlsmartdoc.goldenport.IGoldenport)service;
            comp.setXmlBase(value);
        } else {
            framework_.setOptionValue("xmlBase", value);
        }
    }
}
