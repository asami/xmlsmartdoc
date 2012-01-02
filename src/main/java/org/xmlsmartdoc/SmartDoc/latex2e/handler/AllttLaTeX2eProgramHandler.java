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
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 */
public class AllttLaTeX2eProgramHandler implements LaTeX2eProgramHandler {
    protected String[] packages_ = { "alltt" };

    // LaTeX2eProgramHandler
    public String[] getPackages() {
	// XXX : alltt always defined.
	return (null);
    }

    // LaTeX2eProgramHandler
    public String format(String url, String text, DocContext context) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("{\\hrule\\endgraf\\vspace*{1pt}\\hrule}\n");
	buffer.append("\\nobreak\n");
	buffer.append("\\begin{alltt}\n");
	if (url != null) {
	    buffer.append(
		_decorateProgramText(
		    ULaTeX2e.escapeAlltt(
			USmartDoc.expandTab(USmartDoc.importText(url, context))
		    )
		)
	    );
	}
	if (text != null) {
	    buffer.append(
		_decorateProgramText(
		    ULaTeX2e.escapeAlltt(
			USmartDoc.expandTab(text)
		    )
		)
	    );
	    buffer.append("\\end{alltt}\n");
	    buffer.append("\\nobreak\n");
	    buffer.append("{\\hrule\\endgraf\\vspace*{1pt}\\hrule}\n");
	}
	return (new String(buffer));
    }

    protected String _decorateProgramText(String text) {
	StringBuffer buffer = new StringBuffer();
	String[] lines = UString.makeStringList(text);
	String em = null;
	for (int i = 0;i < lines.length;i++) {
	    String line = lines[i];
	    if (line.equals("// <em>")) {
		buffer.append("\\underline{");
	    } else if (line.equals("// </em>")) {
		buffer.append("}");
	    } else if (line.startsWith("// <em>")) {
		em = line.substring("// <em>".length(), line.indexOf("</em>"));
	    } else {
		if (em != null) {
		    int index = line.indexOf(em);
		    buffer.append(line.substring(0, index));
		    buffer.append("\\underline{");
		    buffer.append(line.substring(index, index + em.length()));
		    buffer.append("}");
		    buffer.append(line.substring(index + em.length()));
		    buffer.append("\n");
		    em = null;
		} else {
		    buffer.append(line);
		    buffer.append("\n");
		}
	    }
	}
	return (new String(buffer));
    }

    // XXX
    protected String _escapeAlltt0(String string) {
	StringBuffer buffer = new StringBuffer();
	int size = string.length();
	for (int i = 0;i < size;i++) {
	    char c = string.charAt(i);
	    switch (c) {

	    case '\\':
		buffer.append("\\(\\backslash\\)");
		break;
	    case '{':
		buffer.append("{\\{}");
		break;
	    case '}':
		buffer.append("{\\}}");
		break;
	    default:
		buffer.append(c);
	    }
	}
	return (new String(buffer));
    }
}
