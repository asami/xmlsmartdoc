/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package com.AsamiOffice.jaba2.j2fw;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.AsamiOffice.jaba2.util.ParameterInfo;
import com.AsamiOffice.jaba2.util.PropertyList;
import com.AsamiOffice.jaba2.xml.IProcessor;
import com.AsamiOffice.jaba2.xml.ProcessorFactory;

/**
 * J2Config
 *
 * @since   Nov. 21, 1998
 * @version Oct. 19, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class J2Config {
    protected ParameterInfo info_;
    protected J2Resource resource_ = null;
    //    protected MessageMap messages_; // XXX : LocaleMap / unify SmartDoc
    protected boolean terse_;
    protected boolean verbose_;
    protected boolean showHelp_;
    protected boolean showVersion_;
    protected boolean debug_;
    protected boolean gui_;
    protected String propertyFile_;
    protected Locale locale_;
    protected IProcessor xmlProcessor_;

    protected J2Config() {
    }

    protected J2Config(ParameterInfo info)
        throws IOException, UnsupportedEncodingException {

        _init(info);
    }

    protected void _setup(ParameterInfo info)
        throws IOException, UnsupportedEncodingException {

        _init(info);
    }

    private void _init(ParameterInfo info)
        throws IOException, UnsupportedEncodingException {

        info_ = info;
        ResourceBundle resource = info_.getResourceBundle();
        if (resource != null && resource instanceof J2Resource) {
            resource_ = (J2Resource)resource;
        }
        /*
        	URL url = getClass().getResource(
        	    info_.getParameterAsString("message")
        	);
        	messages_ = new MessageMap(url);
        */
        showVersion_ = info_.getParameterAsBoolean("version");
        showHelp_ =
            info_.getParameterAsBoolean("help")
                || info_.getParameterAsBoolean("?");
        verbose_ = info_.getParameterAsBoolean("verbose");
        terse_ = info_.getParameterAsBoolean("terse");
        gui_ = info_.getParameterAsBoolean("gui");
        debug_ = info_.getParameterAsBoolean("debug");
        propertyFile_ = info_.getParameterAsString("properties");
        locale_ = info_.getParameterAsLocale("locale");
        String jdbcClassName = info_.getParameterAsString("jdbc.driver");
        // XXX : multiple classes?
        if (jdbcClassName != null) {
            ClassLoader jdbcLoader =
                info_.getParameterAsURLClassLoader("jdbc.cp");
            // XXX : real work?
            try {
                if (jdbcLoader == null) {
                    Class.forName(jdbcClassName);
                } else {
                    Class.forName(jdbcClassName, true, jdbcLoader);
                }
            } catch (ClassNotFoundException e) {
                // XXX : warning
                throw (new InternalError());
            }
        }
        String xmlName = info.getParameterAsString("xml.processor");
        if (xmlName != null) {
            ClassLoader xmlLoader =
                info_.getParameterAsURLClassLoader("xml.cp");
            URL xmlConfig = info_.getParameterAsURLFromFileOrURL("xml.config");
            ProcessorFactory factory = ProcessorFactory.getFactory();
            if (xmlLoader != null) {
                factory.addClassLoader(xmlLoader);
            }
            if (xmlConfig != null) {
                factory.append(xmlConfig);
            }
            if ("default".equals(xmlName)) {
                xmlProcessor_ = ProcessorFactory.getProcessor();
            } else {
                xmlProcessor_ = ProcessorFactory.getProcessor(xmlName);
            }
        }
    }

    public String[] getArguments() {
        return (info_.getArgumentsAsString());
    }

    public PropertyList getProperties() {
        PropertyList pl = new PropertyList();
        return (pl);
    }

    public void setPropertyList(PropertyList pl) {
    }

    public abstract String getName();
    public abstract String getVersion();

    public String getBuild() {
        return (null);
    }

    public abstract String[] getVersionMessage();
    public abstract String[] getUsageMessage();
    public abstract String[] getHelpMessage();

    public boolean showUsage() {
        return (info_.getArgumentCount() == 0);
    }

    public boolean showVersion() {
        return (showVersion_);
    }

    public boolean showHelp() {
        return (showHelp_);
    }

    public boolean isVerbose() {
        return (verbose_);
    }

    public boolean isTerse() {
        return (terse_);
    }

    public boolean isDebug() {
        return (debug_);
    }

    public String getPropertyFile() {
        return (propertyFile_);
    }

    public String getLabel(String key) {
        if (resource_ == null) {
            return (key);
        }
        return (resource_.getLabel(key));
        /*
        	String message;
        	if ((message = messages_.getMessage(key)) != null) {
        	    return (message);
        	}
        	return (key);
        */
    }

    public String getLabel(String key, Locale locale) {
        throw (new UnsupportedOperationException());
    }

    public Locale getLocale() {
        return (locale_);
    }

    public IProcessor getXMLProcessor() {
        return (xmlProcessor_);
    }
}
