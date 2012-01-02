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

package org.xmlsmartdoc.SmartDoc.latex2e.handler;

import org.xmlsmartdoc.SmartDoc.latex2e.*;

/**
 * PlainLaTeX2eBoxHandler
 *
 * @since   Oct. 23, 1998
 * @version Jun.  6, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class PlainLaTeX2eBoxHandler implements LaTeX2eBoxHandler {
    // LaTeX2eBoxHandler
    public String[] getPackages() {
	return (null);
    }

    // LaTeX2eBoxHandler
    public String makeConsoleBegin() {
	return (null);
    }

    // LaTeX2eBoxHandler
    public String makeConsoleEnd() {
	return (null);
    }

    // LaTeX2eBoxHandler
    public String makeFYIBegin(String title) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\underline{\\bfseries ");
	buffer.append(title);
	buffer.append("}\n");
	buffer.append("\\bigskip\n");
	buffer.append("\n");
	return (new String(buffer));
    }

    // LaTeX2eBoxHandler
    public String makeFYIEnd() {
	return (null);
    }

    // LaTeX2eBoxHandler
    public String makeCommentBegin() {
	return (null);
    }

    // LaTeX2eBoxHandler
    public String makeCommentEnd() {
	return (null);
    }
}
