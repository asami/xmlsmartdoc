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

package org.xmlsmartdoc.SmartDoc.pdf;

import java.io.*;
import com.AsamiOffice.jaba2.util.ParameterInfo;
import com.AsamiOffice.jaba2.util.AppParameterInfo;
import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.latex2e.*;

/**
 * PDFConfig
 *
 * @since   Sep. 30, 2003
 * @version Sep. 30, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class PDFConfig extends AbstractSmartDocDelegationFormatConfig {
    // SmartDocFormatConfig
    public void setup(SmartDocConfig config, String[] args)
	throws IOException {

	ParameterInfo info = new AppParameterInfo(
	    "org.xmlsmartdoc.SmartDoc",
	    args,
	    "org.xmlsmartdoc.SmartDoc.pdf.PDFDefaults",
	    new File("SmartDoc.properties")
	);
	info.addPackage("org.xmlsmartdoc.SmartDoc.pdf");
	info.addPackage("org.xmlsmartdoc.SmartDoc.pdf.handler");
	LaTeX2eConfig latex2eConfig = new LaTeX2eConfig();
	try {
	    latex2eConfig.setup(
		config,
		new String[] {
	        }
	    );
	} catch (IOException e) {
	    throw (new InternalError()); // XXX
	}
	LaTeX2eGenerator latex2eGenerator = new LaTeX2eGenerator();
	_init(config, "pdf", info, latex2eConfig, latex2eGenerator);
    }

    // SmartDocFormatConfig
    public String getID() {
	return ("pdf");
    }

    // SmartDocFormatConfig
    public String getName() {
	return ("PDF");
    }
}
