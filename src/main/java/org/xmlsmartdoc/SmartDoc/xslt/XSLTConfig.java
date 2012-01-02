/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2000  ASAMI, Tomoharu (asami@zeomtech.com)
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

package org.xmlsmartdoc.SmartDoc.xslt;

import java.io.*;
import com.AsamiOffice.jaba2.util.ParameterInfo;
import com.AsamiOffice.jaba2.util.AppParameterInfo;
import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.pure.*;

/**
 * XSLTConfig
 *
 * @since   Aug.  5, 2000
 * @version Dec.  3, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class XSLTConfig extends AbstractSmartDocDelegationFormatConfig {
    private String xslURI_;
    private String preRegexRuleURI_;
    private String preTextRegexRuleURI_;
    private String regexRuleURI_;

    // SmartDocFormatConfig
    public void setup(SmartDocConfig config, String[] args)
	throws IOException {

	ParameterInfo info = new AppParameterInfo(
	    "org.xmlsmartdoc.SmartDoc",
	    args,
	    "org.xmlsmartdoc.SmartDoc.xslt.XSLTDefaults",
	    new File("SmartDoc.properties")
	);
	info.addPackage("org.xmlsmartdoc.SmartDoc.xslt");
	PureConfig pureConfig = new PureConfig();
	try {
	    pureConfig.setup(
		config,
		new String[] {
		    "-pure.dtd.use:false",
		    "-pure.dtd.copy:false"
	        }
	    );
	} catch (IOException e) {
	    throw (new InternalError()); // XXX
	}
	PureGenerator pureGenerator = new PureGenerator();
	xslURI_ = info.getParameterAsString("xslt.xsl");
	preRegexRuleURI_
	    = info.getParameterAsString("xslt.preRegexRule");
	preTextRegexRuleURI_
	    = info.getParameterAsString("xslt.preTextRegexRule");
	regexRuleURI_ = info.getParameterAsString("xslt.regexRule");
	_init(config, "xslt", info, pureConfig, pureGenerator);
    }

    // SmartDocFormatConfig
    public String getID() {
	return ("xslt");
    }

    // SmartDocFormatConfig
    public String getName() {
	return ("Xslt");
    }

    public final String getXSLURI() {
	return (xslURI_);
    }

    public final String getPreRegexRule() {
	return (preRegexRuleURI_);
    }

    public final String getPreTextRegexRule() {
	return (preTextRegexRuleURI_);
    }

    public final String getRegexRule() {
	return (regexRuleURI_);
    }
}
