/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2001  ASAMI, Tomoharu (asami@zeomtech.com)
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

import com.AsamiOffice.jaba2.j2fw.generator.*;
import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.latex2e.*;

/**
 * PlainLaTeX2eImageFloatHandler
 *
 * @since   Mar. 10, 2001
 * @version Mar. 10, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class PlainLaTeX2eImageFloatHandler
    implements LaTeX2eImageFloatHandler {

    // LaTeX2eImageFloatHandler
    public String[] getPackages() {
	return (null);
    }

    // LaTeX2eImageFloatHandler
    public String getBegin(ImageFigure image, String loc) {
	return (
	    "\\begin{figure}[" + loc + "]\n" +
	    "\\begin{center}\n"
	);
    }

    // LaTeX2eImageFloatHandler
    public String getEnd(ImageFigure image) {
	return (
	    "\\end{center}\n" +
	    "\\end{figure}\n"
	);
    }
}
