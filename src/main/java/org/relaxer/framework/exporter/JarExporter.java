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

import java.io.File;

import org.relaxer.framework.parcel.IParcel;
import org.relaxer.framework.parcel.ParcelException;
import org.relaxer.framework.runtime.model.IRListModel;
import org.relaxer.framework.runtime.model.IRTableModel;
import org.relaxer.framework.runtime.model.IRTreeModel;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.context.RModelSubContext;
import org.relaxer.framework.runtime.models.fs.FileStoreModel;

/**
 * FileExporter
 *
 * @since   Oct.  2, 2003
 * @version Aug.  9, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class JarExporter extends AbstractExporter {
    public JarExporter(IRModelContext context) {
        super(context);
    }

    protected void _exportObject(
        Object object, 
        ExportResource resource
    ) throws ExporterException {
        if (object instanceof IParcel) {
            try {
                exportParcel((IParcel)object, resource);
            } catch (ParcelException e) {
                throw (_export_error(e));
            }
        } else if (object instanceof IRTreeModel) {
            try {
                exportTreeModel((IRTreeModel)object, resource);
            } catch (RModelException e) {
                throw (_export_error(e));
            }
        } else if (object instanceof IRTableModel) {
            try {
                exportTableModel((IRTableModel)object, resource);
            } catch (RModelException e) {
                throw (_export_error(e));
            }
        } else if (object instanceof IRListModel) {
            try {
                exportListModel((IRListModel)object, resource);
            } catch (RModelException e) {
                throw (_export_error(e));
            }
        } else {
            try {
                exportText_(object.toString(), resource);
            } catch (RModelException e) {
                throw (_export_error(e));
            }
        }
    }

    public static void exportListModel(
        IRListModel model, 
        ExportResource resource
    ) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public static void exportTableModel(
        IRTableModel model, 
        ExportResource resource
    ) throws RModelException {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public static void exportTreeModel(
        IRTreeModel model, 
        ExportResource resource
    ) throws RModelException {
        File dir = resource.getDirectory();
        FileStoreModel target = new FileStoreModel(dir, model.getModelContext());
        target.setProperties(model.getProperties());
/*
        String[] vars = model.getNameVariables();
        for (int i = 0;i < vars.length;i++) {
            String var = vars[i];
            target.setNameVariable(var, model.getNameVariableValue(var));
        }
*/
        target.open();
        target.copyNode(model.getRoot());
        target.commit();
        target.close();
    }

    public static void exportParcel(IParcel parcel, ExportResource resource) throws ParcelException {
        File dir = resource.getDirectory();
        parcel.moveFiles(dir);
    }
    
    private void exportText_(
        String text, 
        ExportResource resource
    ) throws RModelException {
        File dir = resource.getDirectory();
        String encoding = resource.getTextEncoding();
        RModelSubContext context = new RModelSubContext(_context);
        if (encoding != null) {
            context.setTextEncoding(encoding);
        }
        FileStoreModel target = new FileStoreModel(dir, context);
        String fileName = getFileName__(resource);
        target.open();
        target.addNode(fileName, text);
        target.commit();
        target.close();
    }

    private static String getFileName__(ExportResource resource) {
        String output = resource.getOutput();
        if (output != null) {
            return (output);
        }
        String name = resource.getName();
        if (name == null) {
            name = resource.getProject();
        }
        String suffix = resource.getSuffix();
        return (suffix != null ? name + "." + suffix : name);
    }
}
