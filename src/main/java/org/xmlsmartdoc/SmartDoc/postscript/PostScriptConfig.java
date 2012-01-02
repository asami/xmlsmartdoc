/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998,1999  ASAMI, Tomoharu (tasami@ibm.net)
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

package org.xmlsmartdoc.SmartDoc.postscript;

import java.io.*;
import com.AsamiOffice.jaba2.util.ParameterInfo;
import com.AsamiOffice.jaba2.util.AppParameterInfo;
import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.latex2e.*;

/**
 * PostScriptConfig
 *
 * @since   May. 21, 1999
 * @version Aug. 30, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.com)
 */
public class PostScriptConfig extends AbstractSmartDocDelegationFormatConfig {
    // SmartDocFormatConfig
    public void setup(SmartDocConfig config, String[] args)
	throws IOException {

	ParameterInfo info = new AppParameterInfo(
	    "org.xmlsmartdoc.SmartDoc",
	    args,
	    "org.xmlsmartdoc.SmartDoc.postscript.PostScriptDefaults",
	    new File("SmartDoc.properties")
	);
	info.addPackage("org.xmlsmartdoc.SmartDoc.postscript");
	info.addPackage("org.xmlsmartdoc.SmartDoc.postscript.handler");
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
	_init(config, "postscript", info, latex2eConfig, latex2eGenerator);
    }

    // SmartDocFormatConfig
    public String getID() {
	return ("postscript");
    }

    // SmartDocFormatConfig
    public String getName() {
	return ("PostScript");
    }
}
