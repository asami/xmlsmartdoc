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

package org.relaxer.j2eecontainer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Driver;

import javax.naming.*;
import javax.naming.spi.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.relaxer.j2eecontainer.jndi.*;
import org.relaxer.j2eecontainer.jndi.rConfig.CConfig;

import com.AsamiOffice.io.UIO;
// import org.relaxer.j2eecontainer.jndi.rConfig.*;

/**
 * J2eeFramework
 *
 * @since   May.  2, 2003
 * @version Sep   7, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class J2eeContainer {
    private static J2eeContainer instance__;
    
    public static J2eeContainer newInstance(String uri, IMonitor monitor) 
        throws J2eeContainerException, IOException, SAXException, 
               ParserConfigurationException, NamingException {
        instance__ = new J2eeContainer(uri, monitor);
        return (instance__);
    }

    public static J2eeContainer getContainer() {
        return (instance__);
    }

    private IMonitor monitor_;
    private CConfig config_;
    private ClassLoader classLoader_;

    public ClassLoader getConfigClassLoader() {
    	return (classLoader_);
    }

    public ClassLoader getDefaultClassLoader() {
        return (monitor_.getClassLoader());
    }

    protected J2eeContainer(String uri, IMonitor monitor)
        throws
            IOException,
            SAXException,
            ParserConfigurationException,
            NamingException, J2eeContainerException {

        monitor_ = monitor;
        config_ = new CConfig(uri);
        setupClassLoader_();
        RJFInitialContextFactoryBuilder builder =
            new RJFInitialContextFactoryBuilder(config_, this);
        if (!builder.isActive()) {
            throw (new J2eeContainerException("Jndi configuration is not found."));
        }
        NamingManager.setInitialContextFactoryBuilder(builder);
    }

	private void setupClassLoader_() throws MalformedURLException {
		String classpath = config_.getClasspath();
		if (classpath == null) {
			return;
		}
        classLoader_ = UIO.makeClasspathClassLoader(classpath);
        String loaderInfo = "CLASSPATH [" + classpath + "]";
        config("J2ee config class loader" + loaderInfo);
	}

	public void addConfig(String uri) {
        // TODO Auto-generated method stub
    }

    public void error(String string, Throwable e) {
        monitor_.error(string, e);
    }

    public void warning(String string, Throwable e) {
        monitor_.warning(string, e);
    }

    public void info(String message) {
        monitor_.info(message);
    }

    public void config(String message) {
        monitor_.config(message);
    }
}
