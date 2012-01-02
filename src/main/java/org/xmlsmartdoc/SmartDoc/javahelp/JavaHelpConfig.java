/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.javahelp;

import java.io.File;
import java.io.IOException;

import org.xmlsmartdoc.SmartDoc.AbstractSmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.html3.HTML3Config;
import org.xmlsmartdoc.SmartDoc.html3.HTML3Generator;
import com.AsamiOffice.jaba2.util.AppParameterInfo;
import com.AsamiOffice.jaba2.util.ParameterInfo;

/**
 * JavaHelpConfig
 *
 * @since   Apr. 26, 1999
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class JavaHelpConfig extends AbstractSmartDocFormatConfig {
    protected HTML3Config html3Config_;
    protected HTML3Generator html3Generator_;
    protected boolean makeToc_;
    protected boolean makeIndex_;
    protected boolean makeSearch_;

    public void setup(SmartDocConfig config, String[] args)
        throws IOException {

        ParameterInfo info = new AppParameterInfo(
            "org.xmlsmartdoc.SmartDoc",
            args,
            "org.xmlsmartdoc.SmartDoc.javahelp.JavaHelpDefaults",
            new File("SmartDoc.properties")
        );
        info.addPackage("org.xmlsmartdoc.SmartDoc.javahelp");
        info.addPackage("org.xmlsmartdoc.SmartDoc.javahelp.handler");
        html3Config_ = new HTML3Config();
        try {
             html3Config_.setup(
                config,
                new String[] {
                    "-html3.encoding:UTF-8",
                    "-html3.strictDTD:false"
                }
            );
        } catch (IOException e) {
            throw (new InternalError()); // XXX
        }
        html3Generator_ = new HTML3Generator();
        html3Generator_.init(config, html3Config_);
        makeToc_ = info.getParameterAsBoolean("javahelp.toc");
        makeIndex_ = info.getParameterAsBoolean("javahelp.index");
        makeSearch_ = info.getParameterAsBoolean("javahelp.search");
        _init(config, "javahelp", info);
    }

    // SmartDocFormatConfig
    public String getID() {
        return ("javahelp");
    }

    // SmartDocFormatConfig
    public String getName() {
        return ("JavaHelp1.0");
    }

    // SmartDocFormatConfig
    public String[] getImageCandidates() {
        return (html3Config_.getImageCandidates());
    }

    public HTML3Generator getHTML3Generator() {
        return (html3Generator_);
    }

    public boolean makeToc() {
        return (makeToc_);
    }

    public boolean makeIndex() {
        return (makeIndex_);
    }

    public boolean makeSearch() {
        return (makeSearch_);
    }
}
