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

import java.io.PrintWriter;

import org.relaxer.framework.parcel.IParcel;
import org.relaxer.framework.runtime.model.IRListModel;
import org.relaxer.framework.runtime.model.IRTableModel;
import org.relaxer.framework.runtime.model.IRTreeModel;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * AutoExporter
 *
 * @since   Oct.  6, 2003
 * @version Aug.  3, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class AutoExporter extends FileExporter {
    private PrintWriter writer_;

    public AutoExporter(IRModelContext context) {
        super(context);
        writer_ = new PrintWriter(System.out, true);
    }

    protected void _exportObject(
        Object object, 
        ExportResource resource
    ) throws ExporterException {
        if (object instanceof IParcel) {
            super._exportObject(object, resource);
        } else if (object instanceof IRTreeModel) {
            super._exportObject(object, resource);
        } else if (object instanceof IRTableModel) {
            super._exportObject(object, resource);
        } else if (object instanceof IRListModel) {
            super._exportObject(object, resource);
        } else {
            writer_.println(StdOutExporter.makeString(object));
        }
    }
    
    protected void _flush() {
        writer_.flush();
    }
}
