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

import java.io.IOException;
import java.io.PrintWriter;

import org.relaxer.framework.parcel.IContent;
import org.relaxer.framework.parcel.IParcel;
import org.relaxer.framework.parcel.ParcelException;
import org.relaxer.framework.runtime.model.IRListModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.IRTableModel;
import org.relaxer.framework.runtime.model.IRTreeModel;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * SystemOutExporter
 *
 * @since   Oct.  2, 2003
 * @version Aug. 13, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class StdOutExporter extends AbstractExporter {
    private PrintWriter writer_;

    public StdOutExporter(IRModelContext context) {
        super(context);
        writer_ = new PrintWriter(System.out, true);
    }

    protected void _exportObject(
        Object object, 
        ExportResource resource
    ) throws ExporterException {
        if (object instanceof IParcel) {
            try {
                IParcel parcel = (IParcel)object;
                IContent[] contents = parcel.getContents();
                for (int i = 0; i < contents.length; i++) {
                    IContent content = contents[i];
                    writer_.println(content.getString());
                }
            } catch (ParcelException e) {
                throw (_export_error(e));
            } catch (IOException e) {
                throw (_export_error(e));
            }
        } else if (object instanceof IRTreeModel) {
            _exportTreeModel((IRTreeModel)object);
        } else if (object instanceof IRTableModel) {
            _exportTableModel((IRTableModel)object);
        } else if (object instanceof IRListModel) {
            _exportListModel((IRListModel)object);
        } else {
            writer_.println(StdOutExporter.makeString(object));
        }
    }
    
    protected void _exportListModel(IRListModel model) 
      throws ExporterException {
        try {
            IRModelNode[] nodes = model.getNodes();
            for (int i = 0; i < nodes.length; i++) {
                IRModelNode node = nodes[i];
                IRModelContent content = node.getContent();
                if (content != null) {
                    writer_.println(content.getText());
                }
            }
        } catch (RModelException e) {
            throw (_export_error(e));
        }
    }

    protected void _exportTableModel(IRTableModel model) 
      throws ExporterException {
//        _exportListModel(model);
        throw new UnsupportedOperationException();
    }

    protected void _exportTreeModel(IRTreeModel model) 
      throws ExporterException {
//        _exportListModel(model);
        throw new UnsupportedOperationException();
    }

    protected void _flush() {
        writer_.flush();
    }

    public static String makeString(Object object) {
        return (object.toString());
    }
}
