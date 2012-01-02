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
import java.util.ArrayList;
import java.util.List;

/**
 * ExporterResource
 *
 * @since   Oct.  2, 2003
 * @version Aug.  7, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ExportResource {
    private List resources_ = new ArrayList();
    private File targetDir_;
    private String project_;
    private String name_;
    private String suffix_;
    private String output_;
    private String textEncoding_;

    public final void addObject(Object resource) {
        resources_.add(resource);
    }

    public final Object[] getObjects() {
        return (resources_.toArray());
    }

    public final File getDirectory() {
        return (targetDir_);
    }

    public final void setDirectory(File dir) {
        targetDir_ = dir;
    }
    
    public final String getProject() {
        return (project_);
    }

    public final void setProject(String projectName) {
        project_ = projectName;
    }
    
    public final String getTextEncoding() {
        return (textEncoding_);
    }

    public final void setTextEncoding(String textEncoding) {
        textEncoding_ = textEncoding;
    }

    public final String getName() {
        return name_;
    }

    public final void setName(String name) {
        name_ = name;
    }

    public final String getSuffix() {
        return suffix_;
    }

    public final void setSuffix(String suffix) {
        suffix_ = suffix;
    }

    public final String getOutput() {
        return output_;
    }

    public final void setOutput(String output) {
        output_ = output;
    }
}
