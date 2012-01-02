/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@asamiOffice.com)
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
import com.AsamiOffice.jaba2.j2fw.*;
import com.AsamiOffice.jaba2.util.*;

/**
 * GeneratorConfig
 *
 * @since   Jun. 25, 1999
 * @version Dec. 30, 2003
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public abstract class GeneratorConfig extends J2Config {
    protected GeneratorFactory generatorFactory_;
    protected PackagerFactory packagerFactory_;
    protected LocaleMap encodings_;
    protected String command_;
    protected String project_;
    protected File destination_;

    protected GeneratorConfig() {
    }

    protected GeneratorConfig(ParameterInfo info)
        throws IOException, UnsupportedEncodingException {

        _setup(info);
    }

    protected void _setup(ParameterInfo info)
        throws IOException, UnsupportedEncodingException {

        super._setup(info);

        String initGenerator = info_.getParameterAsString("generatorInit");
        if (initGenerator != null) {
            URL url = getClass().getResource(initGenerator); // XXX
            if (url == null) {
                throw (new InternalError(initGenerator));
            }
            generatorFactory_ = new GeneratorFactory(url);
        }
/* XXX : SmartDoc
        if (initGenerator == null) {
            throw (new InternalError());
        }
        URL url = getClass().getResource(initGenerator); // XXX
        if (url == null) {
            throw (new InternalError());
        }
        generatorFactory_ = new GeneratorFactory(url);
*/
        packagerFactory_ = new PackagerFactory(
            info.getParameterAsString("packager")
        );
        encodings_ = info_.getParameterAsLocaleMap("encoding");
        command_ = info.getParameterAsString("command");
        project_ = info_.getParameterAsString("project");
        destination_ = info_.getParameterAsFile("destination");
    }

    public IPackager getPackager(String id) {
        return (packagerFactory_.getPackagerByGenerator(id));
    }

    public String getEncoding(Locale locale) {
        if (encodings_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)encodings_.getDefault());
        }
        return ((String)encodings_.get(locale));
    }

    public IGenerator getGenerator(String id) {
        return (generatorFactory_.getGenerator(id));
    }

    public IGeneratorConfig[] getConfigs() {
        return (generatorFactory_.getConfigs());
    }

    public IGenerator[] getGenerators() {
        return (generatorFactory_.getGenerators());
    }

    public String getCommand() {
        return (command_);
    }

    public String getProject() {
        return (project_);
    }

    public File getDestination() {
        return (destination_);
    }
}
