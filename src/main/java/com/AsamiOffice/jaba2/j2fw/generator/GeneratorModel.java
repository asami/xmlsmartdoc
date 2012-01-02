/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2000  ASAMI, Tomoharu (tasami@ibm.net)
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
import java.io.File;
import com.AsamiOffice.jaba2.j2fw.*;

/**
 * GeneratorModel
 *
 * @since   Jul. 25, 1999
 * @version Jan. 18, 2000
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public abstract class GeneratorModel extends J2Model {
    protected GeneratorConfig config_;
    protected Map generators_ = new HashMap(); // Map<String, IGenerator>

    protected GeneratorModel(GeneratorConfig config) {
	super(config);
	config_ = config;
	IGenerator[] generators = config_.getGenerators();
	for (int i = 0;i < generators.length;i++) {
	    IGenerator generator = generators[i];
	    generator.setup(this);
	    generators_.put(generator.getID(), generator);
	}
    }

    public String getCommand() {
	return (config_.getCommand());
    }

    public String getProject() {
	return (config_.getProject());
    }

    public File getDestination() {
	return (config_.getDestination());
    }

    public String getEncoding() {
	return (getEncoding(getLocale()));
    }

    public String getEncoding(Locale locale) {
	String encoding = config_.getEncoding(locale);
	if (encoding == null) {
	    return ("UTF-8");
	} else {
	    return (encoding);
	}
    }

    public IGenerator getGenerator(String id) {
	return ((IGenerator)generators_.get(id));
    }

    public IGenerator[] getGenerators() {
	Collection values = generators_.values();
	IGenerator[] generators = new IGenerator[values.size()];
	return ((IGenerator[])values.toArray(generators));
    }
}
