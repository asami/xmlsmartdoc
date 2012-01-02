/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
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

package org.xmlsmartdoc.SmartDoc.latex2e.handler;

import com.AsamiOffice.text.UString;
import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.latex2e.*;

/**
 * AllttLaTeX2eProgramHandler
 *
 * @since   Nov.  2, 1998
 * @version Sep. 16, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class VerbatimLaTeX2eProgramHandler implements LaTeX2eProgramHandler {
    // LaTeX2eProgramHandler
    public String[] getPackages() {
	return (null);
    }

    // LaTeX2eProgramHandler
    public String format(String url, String text, DocContext context) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("{\\hrule\\endgraf\\vspace*{1pt}\\hrule}\n");
	buffer.append("\\nobreak\n");
	buffer.append("\\begin{verbatim}\n");
	if (url != null) {
	    buffer.append(USmartDoc.expandTab(
		_decorateProgramText(USmartDoc.importText(url, context)))
	    );
	}
	if (text != null) {
	    buffer.append(USmartDoc.expandTab(
		_decorateProgramText(text))
	    );
	}
	buffer.append("\\end{verbatim}\n");
	buffer.append("\\nobreak\n");
	buffer.append("{\\hrule\\endgraf\\vspace*{1pt}\\hrule}\n");
	return (new String(buffer));
    }

    protected String _decorateProgramText(String text) {
	StringBuffer buffer = new StringBuffer();
	String[] lines = UString.makeStringList(text);
	String em = null;
	for (int i = 0;i < lines.length;i++) {
	    String line = lines[i];
	    if (line.equals("// <em>")) {
	    } else if (line.equals("// </em>")) {
	    } else if (line.startsWith("// <em>")) {
	    } else {
		buffer.append(line);
		buffer.append("\n");
	    }
	}
	return (new String(buffer));
    }
}
