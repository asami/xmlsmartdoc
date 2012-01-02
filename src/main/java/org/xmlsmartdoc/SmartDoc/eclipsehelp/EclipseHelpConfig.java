/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.eclipsehelp;

import java.io.File;
import java.io.IOException;

import org.xmlsmartdoc.SmartDoc.AbstractSmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.html4.HTML4Config;
import org.xmlsmartdoc.SmartDoc.html4.HTML4Generator;

import com.AsamiOffice.jaba2.util.AppParameterInfo;
import com.AsamiOffice.jaba2.util.ParameterInfo;

/**
 * EclipseHelpConfig
 *
 * @since   Apr. 26, 2004
 * @version May.  9, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class EclipseHelpConfig extends AbstractSmartDocFormatConfig {
    protected HTML4Config html4Config_;
    protected HTML4Generator html4Generator_;
    protected boolean makeContext_;

    public void setup(SmartDocConfig config, String[] args)
        throws IOException {

        ParameterInfo info = new AppParameterInfo(
            "org.xmlsmartdoc.SmartDoc",
            args,
            "org.xmlsmartdoc.SmartDoc.eclipsehelp.EclipseHelpDefaults",
            new File("SmartDoc.properties")
        );
        info.addPackage("org.xmlsmartdoc.SmartDoc.eclipsehelp");
        info.addPackage("org.xmlsmartdoc.SmartDoc.eclipsehelp.handler");
        html4Config_ = new HTML4Config();
        try {
             html4Config_.setup(
                config,
                new String[] {
                    "-html4.encoding:UTF-8",
                    "-html4.strictDTD:false"
                }
            );
        } catch (IOException e) {
            throw (new InternalError()); // XXX
        }
        html4Generator_ = new HTML4Generator();
        html4Generator_.init(config, html4Config_);
        makeContext_ = info.getParameterAsBoolean("eclipsehelp.context");
        _init(config, "eclipsehelp", info);
    }

    // SmartDocFormatConfig
    public String getID() {
        return ("eclipsehelp");
    }

    // SmartDocFormatConfig
    public String getName() {
        return ("EclipseHelp");
    }

    // SmartDocFormatConfig
    public String[] getImageCandidates() {
        return (html4Config_.getImageCandidates());
    }

    public HTML4Generator getHTML4Generator() {
        return (html4Generator_);
    }

    public boolean makeContext() {
        return (makeContext_);
    }
}
