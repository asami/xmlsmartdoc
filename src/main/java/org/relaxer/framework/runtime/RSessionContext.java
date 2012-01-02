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

package org.relaxer.framework.runtime;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.relaxer.framework.auth.RAuthManager;
import org.relaxer.framework.auth.RAuthPrincipal;
import org.relaxer.framework.session.rSession.*;
import org.xml.sax.SAXException;

/**
 * RSessionContext
 *
 * @since   Aug. 22, 2002
 * @version Dec. 25, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RSessionContext {
    private RSSession rsSession_;
    private RAuthPrincipal principal_;
    private RSecurityContext securityContext_;
    private RTransactionContext transactionContext_;
    private Map properties_ = new HashMap();
    private Map sessions_ = new HashMap();

    public RSessionContext() {
        rsSession_ = null;
    }

    public RSessionContext(String xml)
        throws IOException, SAXException, ParserConfigurationException {

        rsSession_ = new RSSession(new StringReader(xml));
    }

    public RSessionContext(RSSession rsSession) {
        rsSession_ = rsSession;
    }

    public String toString() {
        return (getXml());
    }

    public String getXml() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<session xmlns=\"http://www.relaxer.org/xmlns/framework/session\">");
        buffer.append("<subject>");
        RAuthPrincipal principal = getPrincipal();
        if (principal != null) {
            buffer.append("<principal");
            buffer.append(" name=\"");
            buffer.append(principal.getName());
            buffer.append("\">");
            buffer.append("</principal>");
        }
        buffer.append("</subject>");
        buffer.append("</session>");
        return (new String(buffer));
    }

    public RAuthPrincipal getPrincipal() {
        return (principal_);
    }

    public Object getAppPrincipal(String key) {
        return (null);
    }

    public Object getProperty(String key) {
        return (properties_.get(key));
    }

    public Object getAppSession(String ns) {
        return (sessions_.get(ns));
    }

    public RSSession getRSSession() {
        return (rsSession_);
    }

    public RSPrincipal getRSPrincipal() {
        return (rsSession_.getSubject().getPrincipal());
    }

    public void authenticate(RAuthManager auth) {
        RSPrincipal principal = getRSPrincipal();
        String name = principal.getName();
        String password = principal.getPassword();
        principal_ = auth.login(name, password);
    }

    public void authenticate(RAuthManager auth, String name, String password) {
        principal_ = auth.login(name, password);
    }

    public void close() {
    }
}
