/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package com.AsamiOffice.jaba2.xml.converter;

import com.AsamiOffice.jaba2.xml.IConverter;

import org.w3c.dom.Node;

import com.AsamiOffice.xml.UDOM;

/**
 * AbstractConverter
 *
 * @since   Aug.  6, 1999
 * @version Oct. 19, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class AbstractConverter implements IConverter {
    public String nodes2String(Node parent) {
        return (nodes2String(UDOM.getNodes(parent)));
    }
}
