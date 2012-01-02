/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
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
package org.relaxer.framework.exporter;

import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * ExporterFactory
 *
 * @since   Oct.  2, 2003
 * @version Aug.  3, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ExporterFactory {
    private IRModelContext context_;

    public static ExporterFactory newInstance(IRModelContext context) {
        return (new ExporterFactory(context));
    }
    
    public ExporterFactory(IRModelContext context) {
        context_ = context;
    }

    public IExporter getExporter(String name) {
        if ("stdout".equals(name)) {
            return (new StdOutExporter(context_));
        } else if ("file".equals(name)) {
            return (new FileExporter(context_));
        } else if ("jar".equals(name)) {
            return (new JarExporter(context_));
        } else if ("null".equals(name)) {
            return (new NullExporter(context_));
        } else {
            return (new AutoExporter(context_));
        }
    }
}
