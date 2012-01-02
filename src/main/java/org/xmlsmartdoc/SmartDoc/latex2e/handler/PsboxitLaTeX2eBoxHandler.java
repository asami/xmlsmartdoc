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
 * PsboxitLaTeX2eBoxHandler
 *
 * @since   Jun.  6, 1999
 * @version Jun.  6, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class PsboxitLaTeX2eBoxHandler implements LaTeX2eBoxHandler {
    protected String[] packages_ = { "psboxit" };

    // LaTeX2eBoxHandler
    public String[] getPackages() {
	return (packages_);
    }

    // LaTeX2eBoxHandler
    public String makeConsoleBegin() {
	return ("\\begin{screen}\n");
    }

    // LaTeX2eBoxHandler
    public String makeConsoleEnd() {
	return ("\\end{screen}\n");
    }

    // LaTeX2eBoxHandler
    public String makeFYIBegin(String title) {
	return ("\\begin{boxnote}\n");
    }

    // LaTeX2eBoxHandler
    public String makeFYIEnd() {
	return ("\\end{boxnote}\n");
    }

    // LaTeX2eBoxHandler
    public String makeCommentBegin() {
	return ("\\begin{itembox}{comment}\n");
    }

    // LaTeX2eBoxHandler
    public String makeCommentEnd() {
	return ("\\end{itembox}\n");
    }
}
