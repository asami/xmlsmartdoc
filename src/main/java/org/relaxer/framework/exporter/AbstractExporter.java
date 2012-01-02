/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
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
 * AbstractExporter
 *
 * @since   Oct.  2, 2003
 * @version Aug.  3, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractExporter implements IExporter {
    protected final IRModelContext _context;

    protected AbstractExporter(IRModelContext context) {
        _context = context;
    }

    public void exportResource(ExportResource resource) throws ExporterException {
        Object[] objects = resource.getObjects();
        for (int i = 0;i < objects.length;i++) {
            _exportObject(objects[i], resource);
        }
        _flush();
    }

    abstract protected void _exportObject(
        Object object, 
        ExportResource resource
    ) throws ExporterException;

    protected void _flush() throws ExporterException {
    }

    protected final void _warning(String message) {
        _context.getLogger().warning(message);
    }

    protected final void _error(String message) {
        _context.getLogger().error(message);
    }

    protected final void _error(String message, Throwable e) {
        _context.getLogger().error(message, e);
    }

    protected final ExporterException _export_error(Throwable e) {
        String message = "export error"; // TODO
        _error(message);
        return (new ExporterException(message, e));
    }
}
