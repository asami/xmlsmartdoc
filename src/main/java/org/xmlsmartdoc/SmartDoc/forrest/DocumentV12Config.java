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

package org.xmlsmartdoc.SmartDoc.forrest;

import java.io.File;
import java.io.IOException;

import org.xmlsmartdoc.SmartDoc.AbstractSmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import com.AsamiOffice.jaba2.util.AppParameterInfo;
import com.AsamiOffice.jaba2.util.ParameterInfo;

/**
 * DocumentV12Config
 *
 * @since   May.  3, 2004
 * @version May.  9, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class DocumentV12Config extends AbstractSmartDocFormatConfig {
    protected boolean ie5_;
    protected boolean useDtd_;
    protected boolean copyDtd_;
    protected boolean useCSS_;
    protected String cssURL_;
    protected boolean copyCSS_;
    protected String[] imageCandidates_;

    // SmartDocFormatConfig
    public void setup(SmartDocConfig config, String[] args)
        throws IOException {

        ParameterInfo info = new AppParameterInfo(
            "org.xmlsmartdoc.SmartDoc",
            args,
            "org.xmlsmartdoc.SmartDoc.forrest.DocumentV12Defaults",
            new File("SmartDoc.properties")
        );
        info.addPackage("org.xmlsmartdoc.SmartDoc.pure");
        info.addPackage("org.xmlsmartdoc.SmartDoc.pure.handler");
        imageCandidates_ = info.getParameterAsStringList("document-v12.imageFormat");
        _init(config, "document-v12", info);
    }

    // SmartDocFormatConfig
    public String getID() {
        return ("document-v12");
    }

    // SmartDocFormatConfig
    public String getName() {
        return ("Forrest Document V12");
    }

    // SmartDocFormatConfig
    public String[] getImageCandidates() {
        return (imageCandidates_);
    }

    public boolean isUseDtd() {
        return (useDtd_);
    }

    public boolean isCopyDtd() {
        return (copyDtd_);
    }

    public boolean isUseCSS() {
        return (useCSS_);
    }

    public String getCssURL() {
        return (cssURL_);
    }

    public boolean isCopyCSS() {
        return (copyCSS_);
    }

    public boolean isIE5() {
        return (ie5_);
    }
}
