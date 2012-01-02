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

package org.xmlsmartdoc.goldenport.evaluater;

import org.w3c.dom.Element;
import org.xmlsmartdoc.goldenport.engine.GoldenportException;
import org.xmlsmartdoc.goldenport.engine.PortContext;
import org.xmlsmartdoc.goldenport.engine.PortNodeList;
import org.xmlsmartdoc.goldenport.evaluater.pattern.*;

/**
 * Atom
 *
 * @since   Jul.  6, 2002
 * @version Apr. 10, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class Atom {
    private String name_;
    private IPattern pattern_;

    public Atom(String name) {
        name_ = name;
    }

    public final String getName() {
        return (name_);
    }

    public final void setPattern(IPattern pattern) {
        pattern_ = pattern;
    }

    public final IPattern getPattern() {
        return (pattern_);
    }

    public int startElement(
        Element element,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        return (pattern_.startElement(element, context, result));
    }

    public void endElement(
        Element element,
        PortNodeList children,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        pattern_.endElement(element, children, context, result);
    }
}
