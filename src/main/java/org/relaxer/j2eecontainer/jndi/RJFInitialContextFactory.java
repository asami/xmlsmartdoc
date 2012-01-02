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

package org.relaxer.j2eecontainer.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

import org.relaxer.j2eecontainer.J2eeContainer;
import org.relaxer.j2eecontainer.jndi.rConfig.CConfig;
import org.relaxer.j2eecontainer.jndi.rConfig.CProvider;

/**
 * RJFInitialContextFactory
 *
 * @since   Apr. 26, 2003
 * @version Dec.  8, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RJFInitialContextFactory implements InitialContextFactory {
    private CConfig config_;
    private J2eeContainer container_;

    public RJFInitialContextFactory(
        CConfig config,
        J2eeContainer container
    ) {
        config_ = config;
        container_ = container;
    }

    public Context getInitialContext(Hashtable environment)
        throws NamingException {

        CProvider[] providers = config_.getProvider();
        return (new RJFRootContext(providers[0], container_));
    }
}
