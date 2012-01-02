/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2002  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

import java.util.*;

/**
 * J2Model
 *
 * @since   Nov. 21, 1998
 * @version May. 11, 2002
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public abstract class J2Model extends Observable {
    protected J2Config j2config_;

    protected J2Model(J2Config config) {
	j2config_ = config;
    }

    public String[] getArguments() {
	return (j2config_.getArguments());
    }

    public Locale getLocale() {
	Locale locale = j2config_.getLocale();
	if (locale != null) {
	    return (locale);
	}
	return (Locale.getDefault());
    }
}
