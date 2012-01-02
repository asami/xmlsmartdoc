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

package com.AsamiOffice.jaba2.j2fw.translator;

import java.util.*;
import java.io.*;
import java.net.URL;
import com.AsamiOffice.jaba2.util.*;

/**
 * ImporterFactory
 *
 * @since   Aug.  3, 1999
 * @version Aug.  3, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public final class ImporterFactory extends ExtensibleFactory {
    public ImporterFactory(URL data) {
	try {
	    _setup(data);
	} catch (IOException e) {
	    throw (new InternalError());
	}
    }

    public IImporter getImporter(String id) {
	return ((IImporter)getTargetObject(id));
    }

    public IImporter[] getImporters() {
	Object[] objects = getTargetObjects();
	IImporter[] importers = new IImporter[objects.length];
	for (int i = 0;i < objects.length;i++) {
	    importers[i] = (IImporter)objects[i];
	}
	return (importers);
    }
}
