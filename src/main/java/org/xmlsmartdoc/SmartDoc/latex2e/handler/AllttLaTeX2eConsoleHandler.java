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
 * AllttLaTeX2eConsoleHandler
 *
 * @since   Nov.  2, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 */
public class AllttLaTeX2eConsoleHandler implements LaTeX2eConsoleHandler {
    // LaTeX2eConsoleHandler
    public String[] getPackages() {
	return (null);
    }

    // LaTeX2eConsoleHandler
    public String format(String url, String text, DocContext context) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\begin{alltt}\n");
	if (url != null) {
	    buffer.append(
		_decorateConsoleText(
		    ULaTeX2e.escapeAlltt(
			USmartDoc.expandTab(USmartDoc.importText(url, context))
		    )
		)
	    );
	}
	if (text != null) {
	    buffer.append(
		_decorateConsoleText(
		    ULaTeX2e.escapeAlltt(
			USmartDoc.expandTab(text)
		    )
		)
	    );
	    buffer.append("\\end{alltt}\n");
	}
	return (new String(buffer));
    }

    protected String _decorateConsoleText(String text) {
	String prompt = ">";
	StringBuffer buffer = new StringBuffer();
	String[] lines = UString.makeStringList(text);
	String em = null;
	for (int i = 0;i < lines.length;i++) {
	    String line = lines[i];
	    if (i == 0) {
		int index = line.indexOf(prompt);
		if (index != -1) {
		    buffer.append(line.substring(0, index + prompt.length()));
		    buffer.append("\\underline{");
		    buffer.append(line.substring(index + prompt.length()));
		    buffer.append("}");
		    buffer.append("\n");
		} else {
		    buffer.append(line);
		    buffer.append("\n");
		}
	    } else {
		buffer.append(line);
		buffer.append("\n");
	    }
	}
	return (new String(buffer));
    }

    protected String _escapeAlltt(String string) {
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
