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

package com.AsamiOffice.jaba2.j2fw.generator;

import java.util.*;
import java.io.*;
import com.AsamiOffice.jaba2.util.*;
import com.AsamiOffice.jaba2.j2fw.generator.IPackager;

/**
 * PackagerFactory
 *
 * @since   May. 10, 1999
 * @version Nov. 16, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public final class PackagerFactory extends ExtensibleFactory {
    protected PropertyList packagers_;
    protected String default_;
    protected Map packgerByName_ = new HashMap();

    public PackagerFactory(String string) {
        packagers_ = new PropertyList(string);
        default_ = (String)packagers_.get("_default_");
        try {
            _setup(getClass().getResource(
                "/com/AsamiOffice/jaba2/j2fw/generator/Packager.xml"
            ));
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    public IPackager getPackagerByGenerator(String id) {
        String name = (String)packagers_.get(id);
        if (name != null) {
            return (getPackagerByName(name));
        } else {
            return (getPackagerByName(default_));
        }
    }

    public IPackager getPackagerByName(String name) {
        return ((IPackager)getTargetObject(name));
    }
}
