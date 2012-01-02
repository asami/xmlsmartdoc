/*
 * SmartTable
 *  Copyright (C) 1999-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartTable;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.AsamiOffice.jaba2.j2fw.translator.TranslatorConfig;
import com.AsamiOffice.jaba2.util.AppParameterInfo;
import com.AsamiOffice.jaba2.util.ParameterInfo;
import com.AsamiOffice.jaba2.xml.ConverterFactory;
import com.AsamiOffice.jaba2.xml.IConverter;

/**
 * SmartTableConfig
 *
 * @since   Jul. 24, 1999
 * @version Oct. 22, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SmartTableConfig extends TranslatorConfig {
    protected ConverterFactory converterFactory_;
    protected URL metadataURL_;
    protected URL metadataInURL_;
    protected URL metadataOutURL_;
    protected String[] inputs_;

    public SmartTableConfig(String[] args)
        throws IOException, MalformedURLException {

        ParameterInfo info = new AppParameterInfo(
            "org.xmlsmartdoc.SmartTable",
            args,
            "org.xmlsmartdoc.SmartTable.SmartTableDefaults",
            new File("SmartTable.properties")
        );
        converterFactory_ = new ConverterFactory();
        metadataURL_ = info.getParameterAsURLFromFileOrURL("metadata");
        metadataInURL_ = info.getParameterAsURLFromFileOrURL("metadata.in");
        metadataOutURL_ = info.getParameterAsURLFromFileOrURL("metadata.out");
        _setup(info);
    }

    // J2Config
    public String getName() {
        return ("SmartTable");
    }

    // J2Config
    public String getVersion() {
        return ("0.1b");
    }

    // J2Config
    public String getBuild() {
        return ("20000117");
    }

    // J2Config
    public String[] getVersionMessage() {
        String[] message = {
            "Copyright(c) 1999,2000 ASAMI,Tomoharu. All rights reserved.",
            "SmartTable Version " + getVersion() +
            " (" + getBuild() + ") by ASAMI@Yokohama",
        };
        return (message);
    }

    // J2Config
    public String[] getUsageMessage() {
        String[] message = {
            "Usage: stable [-options] [args...]",
            "  for more information, use -help option"
        };
        return (message);
    }

    // J2Config
    public String[] getHelpMessage() {
        String[] message = {
            "Usage: stable [-options] [args...]",
            "",
            "where options include:",
            "[common]",
            "  -version",
            "\tshow version",
            "  -help",
            "  -?",
            "\tshow help. (this message)",
            "  -verbose[:true|false]",
            "\tenbale verbose output"
        };
        return (message);
    }

    public IConverter getConverter(String id) {
        return (converterFactory_.getConverter(id));
    }

    public URL getMetadataURL() {
        return (metadataURL_);
    }

    public URL getMetadataInURL() {
        return (metadataInURL_);
    }

    public URL getMetadataOutURL() {
        return (metadataOutURL_);
    }
}
