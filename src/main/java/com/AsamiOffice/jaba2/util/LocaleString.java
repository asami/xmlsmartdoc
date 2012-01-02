/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1999  ASAMI, Tomoharu (tasami@ibm.net)
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

package com.AsamiOffice.jaba2.util;

import java.util.*;

import com.AsamiOffice.util.*;

/**
 * LocaleString
 *
 * @since   Mar. 27, 1999
 * @version Mar. 27, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class LocaleString {
    protected LocaleMap map_ = new LocaleMap();

    public void putDefault(String data) {
	map_.putDefault(data);
    }

    public void put(String key, String data) {
	map_.put(ULocale.makeLocale(key), data);
    }

    public void put(Locale key, String data) {
	map_.put(key, data);
    }

    public String getDefault() {
	return ((String)map_.getDefault());
    }

    public String get(Locale key) {
	return ((String)map_.get(key));
    }
}
