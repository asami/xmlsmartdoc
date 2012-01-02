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

package com.AsamiOffice.jaba2.j2fw.generator;

import java.util.*;
import java.io.*;
import java.net.URL;
import com.AsamiOffice.jaba2.util.*;

/**
 * GeneratorFactory
 *
 * @since   Aug.  2, 1999
 * @version Aug. 30, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public final class GeneratorFactory extends ExtensibleFactory {
    public GeneratorFactory(URL data) {
	try {
	    _setup(data);
	} catch (IOException e) {
	    throw (new InternalError());
	}
    }

    public IGenerator getGenerator(String id) {
	Object object = getTargetObject(id);
	if (object == null) {
	    return (null);
	} else if (object instanceof IGenerator) {
	    return ((IGenerator)object);
	} else if (object instanceof IGeneratorConfig) {
	    return (((IGeneratorConfig)object).getGenerator());
	} else {
	    throw (new InternalError());
	}
    }

    public IGeneratorConfig[] getConfigs() {
	Object[] objects = getTargetObjects();
	List list = new ArrayList();
	for (int i = 0;i < objects.length;i++) {
	    Object object = objects[i];
	    if (object instanceof IGeneratorConfig) {
		list.add(object);
	    }
	}
	IGeneratorConfig[] configs = new IGeneratorConfig[list.size()];
	list.toArray(configs);
	return (configs);
    }

    public IGenerator[] getGenerators() {
	Object[] objects = getTargetObjects();
	IGenerator[] generators = new IGenerator[objects.length];
	for (int i = 0;i < objects.length;i++) {
	    Object object = objects[i];
	    if (object instanceof IGenerator) {
		generators[i] = (IGenerator)object;
	    } else if (object instanceof IGeneratorConfig) {
		generators[i] = ((IGeneratorConfig)object).getGenerator();
	    } else {
		throw (new InternalError());
	    }
	}
	return (generators);
    }
}
