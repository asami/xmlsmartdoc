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

package org.xmlsmartdoc.SmartDoc.html3;

import java.io.File;
import java.io.IOException;

import org.xmlsmartdoc.SmartDoc.AbstractSmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import com.AsamiOffice.jaba2.util.AppParameterInfo;
import com.AsamiOffice.jaba2.util.ParameterInfo;

/**
 * HTML3Config
 *
 * @since   Apr. 24, 1999
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class HTML3Config extends AbstractSmartDocFormatConfig {
    protected boolean strictDTD_;
    protected String[] imageCandidates_;

    // SmartDocFormatConfig
    public void setup(SmartDocConfig config, String[] args)
        throws IOException {

        ParameterInfo info =
            new AppParameterInfo(
                "org.xmlsmartdoc.SmartDoc",
                args,
                "org.xmlsmartdoc.SmartDoc.html3.HTML3Defaults",
                new File("SmartDoc.properties"));
        info.addPackage("org.xmlsmartdoc.SmartDoc.html3");
        info.addPackage("org.xmlsmartdoc.SmartDoc.html3.handler");
        strictDTD_ = info.getParameterAsBoolean("html3.strictDTD");
        imageCandidates_ = info.getParameterAsStringList("html3.imageFormat");
        _init(config, "html3", info);
    }

    // SmartDocFormatConfig
    public String getID() {
        return ("html3");
    }

    // SmartDocFormatConfig
    public String getName() {
        return ("HTML3.2");
    }

    // SmartDocFormatConfig
    public String[] getImageCandidates() {
        return (imageCandidates_);
    }

    public boolean isStrictDTD() {
        return (strictDTD_);
    }
}
