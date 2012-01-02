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

import java.security.Principal;
import org.w3c.dom.Element;
import org.relaxer.framework.auth.rAccount.*;

/**
 * RAuthPrincipal
 *
 * @since   Aug. 31, 2002
 * @version Sep.  9, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RAuthPrincipal implements Principal {
    private String name_;
    private transient RAccount account_;

    public RAuthPrincipal(Element element) {
        _init(new RAccount(element));
    }

    public RAuthPrincipal(RAccount account) {
        _init(account);
    }

    private void _init(RAccount account) {
        account_ = account;
        name_ = account_.getName();
    }

    public boolean equals(Object another) {
        if (!(another instanceof RAuthPrincipal)) {
            return (false);
        }
        return (name_.equals(((RAuthPrincipal)another).name_));
    }

    public String toString() {
        return (name_);
    }

    public int hashCode() {
        return (name_.hashCode());
    }

    public String getName() {
        return (name_);
    }

    public boolean isValid(String password) {
        return (password.equals(account_.getPassword()));
    }

    public Element[] getAddOnAccounts() {
        ROtherAnyElement[] addons = account_.getOtherAnyElement();
        Element[] result = new Element[addons.length];
        for (int i = 0; i < addons.length; i++) {
            result[i] = addons[i].rGetElement();
        }
        return (result);
    }
}
