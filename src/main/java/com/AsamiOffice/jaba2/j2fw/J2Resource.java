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

package com.AsamiOffice.jaba2.j2fw;

import java.io.IOException;
import java.net.URL;
import java.util.PropertyResourceBundle;

import com.AsamiOffice.jaba2.util.MessageMap;

/**
 * J2Resource
 *
 * @since   Aug. 23, 1999
 * @version Oct. 15, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class J2Resource extends PropertyResourceBundle {
    protected MessageMap messages_;

    protected J2Resource(URL properties, URL messages) throws IOException {
        super(properties.openStream());
        messages_ = new MessageMap(messages);
    }

    public String getLabel(String key) {
        return (messages_.getMessage(key));
    }
}
