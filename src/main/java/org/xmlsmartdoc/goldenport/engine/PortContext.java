/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2002  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.xmlsmartdoc.goldenport.engine;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;

import org.relaxer.framework.logger.IRFrameworkLogger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.AsamiOffice.io.UURL;
import com.AsamiOffice.text.UString;

/**
 * PortContext
 *
 * @since   Feb.  9, 2002
 * @version May.  8, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class PortContext {
    private PortEngine engine_;
    private String baseUri_;
    private File baseFile_;
    private IPort port_;
    private Stack stack_ = new Stack();
    private Map properties_ = new HashMap();
    private PortContext parent_ = null;
    private String contextPrefix_ = "";
    private static int counter__ = 0;
    //
    private ClassLoader classLoader_ = null;
    private DocumentBuilder builder_ = null;
    private IRFrameworkLogger logger_ = null;
    private DataSource datasource_ = null;
    
    public PortContext() {
    }

    public PortContext(PortContext parent) {
        parent_ = parent;
        engine_ = parent.engine_;
        baseUri_ = parent.baseUri_;
        baseFile_ = parent.baseFile_;
        port_ = parent.port_;
        contextPrefix_ = "doc" + (++counter__) + "_";
    }

    public final void setEngine(PortEngine engine) {
        engine_ = engine;
    }

    public final PortEngine getEngine() {
        return (engine_);
    }

    public final void setPort(IPort port) {
        port_ = port;
    }

    public final IPort getPort() {
        return (port_);
    }

    public final void setBaseUri(String uri) {
        if (UURL.isURL(uri)) {
            baseUri_ = normalizeBaseUri_(uri);
        } else {
            if (baseFile_ != null) {
                try {
                    baseUri_ = normalizeBaseUri_(
                        baseFile_.toURL().toExternalForm()
                    );
                } catch (MalformedURLException e) {
                    throw (new UnsupportedOperationException());
                }
            }
            baseUri_ = baseUri_ + normalizeBaseUri_(uri);
        }
        baseFile_ = null;
    }

    private String normalizeBaseUri_(String uri) {
        if (uri.endsWith("/")) {
            return (uri);
        } else {
            uri = UString.getContainerPathname(uri);
            if (uri != null) {
                return (uri + "/"); 
            } else {
                return ("");
            }
        }
    }

    public final void setBaseFile(File file) {
        baseFile_ = file;
        baseUri_ = null;
    }
    
    public final String getBaseUri() throws MalformedURLException {
        if (baseUri_ != null) {
            return (baseUri_);
        } else if (baseFile_ != null) {
            return (baseFile_.toURL().toExternalForm());
        } else {
            return (null);
        }
    }

    public final File getBaseDirectory() {
        if (baseFile_.isDirectory()) {
            return (baseFile_);
        } else {
            return (baseFile_.getParentFile());
        }
    }

    public final void pushElement(Element element) {
        stack_.push(element);
    }

    public final Element popElement() {
        return ((Element)stack_.pop());
    }

    public final Element peekElement() {
        return ((Element)stack_.peek());
    }

    public final Element peekParentElement() {
        return ((Element)stack_.get(stack_.size() - 2));        
    }

    public final void setProperty(String key, Object value) {
        properties_.put(key, value);
    }

    public final Object getProperty(String key) {
        return (properties_.get(key));
    }
    
    //
    public final ClassLoader getClassLoader() {
        if (classLoader_ == null) {
            classLoader_ = engine_.getContext().getClassLoader();
        }
        return (classLoader_);
    }

    public final DocumentBuilder getDocumentBuilder() {
        if (builder_ == null) {
            builder_ = engine_.getContext().getDocumentBuilder();
        }
        return (builder_);
    }
    
    public final DataSource getDataSource() {
        if (datasource_ == null) {
            datasource_ = engine_.getContext().getDataSource();
        }
        return (datasource_);
    }
    
    public final DataSource getDataSource(String name) {
        return (engine_.getContext().getDataSource(name));
    }
    
    public final IRFrameworkLogger getLogger() {
        if (logger_ == null) {
            logger_ = engine_.getContext().getLogger();
        }
        return (logger_);
    }

    public Document loadDocument(String uri) throws SAXException, IOException {
        DocumentBuilder builder = getDocumentBuilder();
        try {
            URL url = new URL(uri);
            return (builder.parse(uri));
        } catch (MalformedURLException e) {
        }
        File file = new File(uri);
        if (file.isAbsolute()) {
            return (builder.parse(file));
        }
        String baseUri = getBaseUri();
        uri = baseUri + "/" + uri;
        return (builder.parse(uri));
    }

    public String getAdjustedId(String id) {
        return (contextPrefix_ + id);
    }

    public String getAdjustedUri(String uri) throws MalformedURLException {
        if (UURL.isURL(uri)) {
            return (uri);
        }
        if (parent_ == null) {
            return (uri);
        }
        String baseUri = getBaseUri();
        String parentBaseUri = getRoot_().getBaseUri();
//        System.out.println(baseUri + " === " + parentBaseUri);
        baseUri = baseUri.substring(parentBaseUri.length());
        return (UString.concatPathname(baseUri, uri));
    }

    private PortContext getRoot_() {
        if (parent_ == null) {
            return (this);
        } else {
            return (parent_.getRoot_());
        }
    }
}
