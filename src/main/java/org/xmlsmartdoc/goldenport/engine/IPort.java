/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
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

import org.w3c.dom.*;
import org.xmlsmartdoc.goldenport.selecter.ISelecter;

/**
 * IPort
 *
 * @since   Feb.  9, 2002
 * @version Apr. 12, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public interface IPort extends IPortConstants {
    void setSelecter(ISelecter selecter);
    ISelecter getSelecter();
    void setProperty(String name, String value);
    String getProperty(String name);
    void setup(Element element);
    boolean isAccept(Element element);
    int startElement(
        Element element, 
        PortContext context, 
        PortNodeList result
    ) throws GoldenportException;
    void endElement(
        Element element,
        PortNodeList children,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException;
}
