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

import javax.naming.*;

import org.relaxer.j2eecontainer.J2eeContainer;
import org.relaxer.j2eecontainer.jndi.rConfig.*;

/**
 * RJFContext
 *
 * @since   Apr. 26, 2003
 * @version Aug.  8, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RJFContext extends AbstractRJFContext {
    CContext context_;

    public RJFContext(CContext context, J2eeContainer container) {
        super(container);
        context_ = context;
        context_.rSetProperty("j2eefw", this);
    }

    public Object lookup(Name name) throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public void bind(Name name, Object obj) throws NamingException {
    }

    public void rebind(Name name, Object obj) throws NamingException {
    }

    public void unbind(Name name) throws NamingException {
    }

    public void rename(Name oldName, Name newName) throws NamingException {
    }

    public NamingEnumeration list(Name name) throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public NamingEnumeration listBindings(Name name) throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public void destroySubcontext(Name name) throws NamingException {
    }

    public Context createSubcontext(Name name) throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public Object lookupLink(Name name) throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public NameParser getNameParser(Name name) throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public Name composeName(Name name, Name prefix) throws NamingException {
        throw (new UnsupportedOperationException());
    }
}
