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

package org.xmlsmartdoc.goldenport.selecters;

import java.util.*;
import org.w3c.dom.*;
import org.xmlsmartdoc.goldenport.selecter.AbstractSelecter;

/**
 * NamespaceSelecter
 *
 * @since   Jul.  8, 2002
 * @version Jul.  8, 2002
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class NamespaceSelecter extends AbstractSelecter {
    private boolean isNullNs_ = false;
    private Set namespaces_ = new HashSet();

    public NamespaceSelecter(String namespace) {
	_addNamespace(namespace);
    }

    public NamespaceSelecter(String[] namespaces) {
	for (int i = 0;i < namespaces.length;i++) {
	    _addNamespace(namespaces[i]);
	}
    }

    private void _addNamespace(String ns) {
	if (ns == null || "".equals(ns)) {
	    isNullNs_ = true;
	} else {
	    namespaces_.add(ns);
	}
    }

    public boolean isMatch(Element element) {
	String namespace = element.getNamespaceURI();
	if (namespace == null || "".equals(namespace)) {
	    return (isNullNs_);
	}
	return (namespaces_.contains(namespace));
    }
}
