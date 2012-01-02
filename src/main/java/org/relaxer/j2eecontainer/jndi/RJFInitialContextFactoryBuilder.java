/*
* The RelaxerOrg class library
*  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.j2eecontainer.jndi;

import java.util.*;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.naming.*;
import javax.naming.spi.*;
import org.xml.sax.SAXException;
import org.relaxer.j2eecontainer.J2eeContainer;
import org.relaxer.j2eecontainer.jndi.rConfig.*;

/**
 * RJFInitialContextFactoryBuilder
 *
 * @since   Apr. 27, 2003
 * @version Sep.  7, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RJFInitialContextFactoryBuilder
    implements InitialContextFactoryBuilder {

    private CConfig config_;
    private J2eeContainer container_;

    public RJFInitialContextFactoryBuilder(
        CConfig config,
        J2eeContainer container
    ) {
        container_ = container;
        config_ = config;
        container_.config("J2ee config: " + config);
        try {
            container_.config(config_.makeTextDocument());
        } catch (Exception e) {
            container_.error("Illegal j2ee configuration.", e);
        }
    }

	public InitialContextFactory createInitialContextFactory(Hashtable environment)
        throws NamingException {
        return (new RJFInitialContextFactory(config_, container_));
    }

    public boolean isActive() {
        return (config_.getProvider().length > 0);
    }
}
