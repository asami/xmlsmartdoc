/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

package com.AsamiOffice.jaba2.xml;

import java.util.*;
import java.io.*;
import java.net.URL;
import com.AsamiOffice.jaba2.util.*;

/**
 * ConverterFactory
 *
 * @since   Aug.  6, 1999
 * @version Nov. 16, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public final class ConverterFactory extends ExtensibleFactory {
    public ConverterFactory() {
        try {
            _setup(getClass().getResource(
                "/com/AsamiOffice/jaba2/xml/Converter.xml"
            ));
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    public ConverterFactory(URL data) {
        try {
            _setup(data);
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    public IConverter getConverter(String id) {
        return ((IConverter)getTargetObject(id));
    }

    public IConverter[] getConverters() {
        Object[] objects = getTargetObjects();
        IConverter[] converters = new IConverter[objects.length];
        for (int i = 0;i < objects.length;i++) {
            converters[i] = (IConverter)objects[i];
        }
        return (converters);
    }
}
