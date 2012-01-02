/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.framework.script;

import java.io.File;
import java.io.IOException;

import org.relaxer.framework.IParameterParser;
import org.relaxer.framework.RelaxerFramework;
import org.relaxer.framework.RelaxerFrameworkException;
import org.relaxer.framework.IParameterParser.Entry;
import org.relaxer.framework.datatype.DatatypeFactory;
import org.relaxer.framework.exporter.ExportResource;
import org.relaxer.framework.exporter.ExporterException;
import org.relaxer.framework.exporter.ExporterFactory;
import org.relaxer.framework.exporter.IExporter;
import org.relaxer.framework.parcel.IParcel;
import org.relaxer.framework.runtime.model.IRTreeModel;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * ScriptEngine
 *
 * @since   Jan.  5, 2003
 * @version Aug.  9, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptEngine implements IScriptConstants {
    private RelaxerFramework framework_;
    private ScriptSpace scriptSpace_;
    private DatatypeFactory datatypeFactory_;
    private IParameterParser parser_;
    private String exporter_;
    private String exporterDirectory_;
    private String projectName_;
    private String textEncoding_;
    private String exporterOutput_;
    private String exporterSuffix_;
    private String exporterName_;
    private String defaultService_;

    public ScriptEngine(RelaxerFramework framework) {
        framework_ = framework;
        parser_ = framework.getParameterParser();
        scriptSpace_ = framework.getScriptSpace();
        datatypeFactory_ = framework.getDatatypeFactory();
        exporter_ = framework.getExporter();
        exporterDirectory_ = framework.getExporterDirectory();
        projectName_ = framework.getProjectName();
        textEncoding_ = framework.getExporterEncoding();
        exporterName_ = framework.getExporterName();
        exporterSuffix_ = framework.getExporterSuffix();
        exporterOutput_ = framework.getExporterOutput();
        defaultService_ = framework.getMainService();
    }

    public void execute(IParameterParser parser) throws ScriptException {
        setupOptions_(parser);
        executeService_(parser);
    }

    private void setupOptions_(IParameterParser parser) throws ScriptException {
        Entry[] properties = parser.getProperties();
        for (int i = 0;i < properties.length;i++) {
            setupOption_(properties[i]);
        }
    }

    private void setupOption_(Entry entry) throws ScriptException {
        String[] parameters = new String[] { entry.value };
        ScriptClass rootClass = scriptSpace_.getScriptClass("/");
        rootClass.addSlot(new Slot(SYSTEM_SERVICE));
        rootClass.addSlot(new Slot(SYSTEM_ARGUMENT));
        ScriptContext context = new ScriptContext(rootClass, null);
        try {
            importResources(context, parameters);
        } catch (RelaxerFrameworkException e) {
            throw (new ScriptException(e));
        }
        ScriptParameter in = new ScriptParameter();
        String service = entry.key;
        if (service == null) {
            service = defaultService_;
        }
        in.addEntryText(SYSTEM_SERVICE, service);
        in.addEntryValue(SYSTEM_ARGUMENT, context.getSlot(SYSTEM_ARGUMENT).getValue());
        ScriptParameter out = new ScriptParameter();
        rootClass.execute(in, out, context);
        try {
            exportResources(context);
        } catch (IOException e) {
            throw (new ScriptException(e));
        }
    }

    private void executeService_(IParameterParser parser) throws ScriptException {
        String[] parameters = parser.getParameters();
        ScriptClass rootClass = scriptSpace_.getScriptClass("/");
        rootClass.addSlot(new Slot(SYSTEM_SERVICE));
        rootClass.addSlot(new Slot(SYSTEM_ARGUMENT));
        rootClass.addSlot(new Slot(SYSTEM_RESULT));
        ScriptContext context = new ScriptContext(rootClass, null);
        try {
            importResources(context, parameters);
        } catch (RelaxerFrameworkException e) {
            throw (new ScriptException(e));
        }
        ScriptParameter in = new ScriptParameter();
        String service = parser.getService();
        if (service == null) {
            service = defaultService_;
        }
        in.addEntryText(SYSTEM_SERVICE, service);
        in.addEntryValue(SYSTEM_ARGUMENT, context.getSlot(SYSTEM_ARGUMENT).getValue());
        ScriptParameter out = new ScriptParameter();
        out.addEntryValue(SYSTEM_RESULT, null);
        rootClass.execute(in, out, context);
        Slot resultSlot = new Slot(SYSTEM_RESULT);
        resultSlot.setValue(out.getValue(SYSTEM_RESULT));
        context.addSlot(resultSlot);
        try {
            exportResources(context);
        } catch (IOException e) {
            throw (new ScriptException(e));
        }
    }

    public void importResources(ScriptContext context, String[] parameters) throws RelaxerFrameworkException {
        Slot slot = new Slot(SYSTEM_ARGUMENT);
        slot.setTexts(parameters);
        context.addSlot(slot);
        IParameterParser.Entry[] entries = parser_.getProperties();
        for (int i = 0;i < entries.length;i++) {
            IParameterParser.Entry entry = entries[i];
            slot = new Slot(entry.key);
            if (entry.value == null) {
                slot.setText("true");
            } else {
                slot.setText(entry.value);
            }
            context.addSlot(slot);
        }
    }

    public void exportResources(ScriptContext context) throws ExporterException {
        Slot slot = context.getSlot(SYSTEM_RESULT);
        if (slot == null) {
            return;
        }
        Object[] objects = slot.getObjects();
        IRModelContext modelContext = framework_.getModelContext();
        ExporterFactory factory = ExporterFactory.newInstance(modelContext);
        ExportResource resource = new ExportResource();
        for (int i = 0;i < objects.length;i++) {
            Object object = objects[i];
            if (object instanceof IParcel) {
                adjustParcel_((IParcel)object);
            } else if (object instanceof IRTreeModel) {
                adjustTreeModel_((IRTreeModel)object);
            }
            resource.addObject(object);
        }
        resource.setProject(projectName_);
        resource.setTextEncoding(textEncoding_);
        resource.setName(exporterName_);
        resource.setSuffix(exporterSuffix_);
        resource.setOutput(exporterOutput_);
        if (exporterDirectory_ == null) {
            resource.setDirectory(new File(System.getProperty("user.dir")));
        } else {
            resource.setDirectory(new File(exporterDirectory_));
        }
        IExporter exporter = factory.getExporter(exporter_);
        exporter.exportResource(resource);
    }

    private void adjustParcel_(IParcel parcel) {
        parcel.setNameVariable("project", projectName_);
    }

    private void adjustTreeModel_(IRTreeModel model) {
        model.setProperty("project", projectName_);
    }
}
