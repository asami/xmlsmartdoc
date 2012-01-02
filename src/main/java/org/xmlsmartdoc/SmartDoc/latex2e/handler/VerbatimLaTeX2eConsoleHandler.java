/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998  ASAMI, Tomoharu (tasami@ibm.net)
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

import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.latex2e.*;

/**
 * VerbatimLaTeX2eConsoleHandler
 *
 * @since   Nov.  2, 1998
 * @version Nov. 11, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class VerbatimLaTeX2eConsoleHandler implements LaTeX2eConsoleHandler {
    // LaTeX2eConsoleHandler
    public String[] getPackages() {
	return (null);
    }

    // LaTeX2eConsoleHandler
    public String format(String url, String text, DocContext context) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\begin{verbatim}\n");
	if (url != null) {
	    buffer.append(
		USmartDoc.expandTab(USmartDoc.importText(url, context))
	    );
	}
	if (text != null) {
	    buffer.append(USmartDoc.expandTab(text));
	    buffer.append("\\end{verbatim}\n");
	}
	return (new String(buffer));
    }
}
