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

package org.relaxer.framework.auth;

import java.util.Map;
import javax.security.auth.spi.LoginModule;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

/**
 * RAuthLoginModule
 *
 * @since   Aug. 29, 2002
 * @version Aug. 30, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RAuthLoginModule implements LoginModule {
    public void initialize(
	Subject subject,
	CallbackHandler callbackHandler,
	Map sharedState,
	Map options
    ) {
    }

    public boolean login() throws LoginException {
	throw (new UnsupportedOperationException());
    }

    public boolean commit() throws LoginException {
	throw (new UnsupportedOperationException());
    }

    public boolean abort() throws LoginException {
	throw (new UnsupportedOperationException());
    }

    public boolean logout() throws LoginException {
	throw (new UnsupportedOperationException());
    }
}
