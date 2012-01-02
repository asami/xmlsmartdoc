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
 * WrapfigLaTeX2eTableFloatHandler
 *
 * @since   Mar. 11, 2001
 * @version Mar. 11, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class WrapfigLaTeX2eTableFloatHandler
    extends PlainLaTeX2eTableFloatHandler {

    // LaTeX2eTableFloatHandler
    public String[] getPackages() {
	return (new String[] { "wrapfig" });
    }

    // LaTeX2eTableFloatHandler
    public String getBegin(Table table, String loc) {
	CSSStyle style = table.getStyle();
	if (style == null) {
	    return (super.getBegin(table, loc));
	}
	String floatStyle = style.getFloat();
	if (floatStyle == null) {
	    return (super.getBegin(table, loc));
	}
	String placement;
	if ("right".equals(floatStyle)) {
	    placement = "r";
	} else if ("left".equals(floatStyle)) {
	    placement = "l";
	} else {
	    return (super.getBegin(table, loc));
	}
	CSSLength width = style.getWidth();
	if (width == null) {
	    return (super.getBegin(table, loc));
	}
	if (width.getUnit() != CSSLength.CM) {
	    return (super.getBegin(table, loc));
	}
	return (
	    "\\begin{wraptable}{" + placement + "}" +
	    "{" + width.getString() + "}\n"
	);
    }

    // LaTeX2eTableFloatHandler
    public String getEnd(Table table) {
	CSSStyle style = table.getStyle();
	if (style == null) {
	    return (super.getEnd(table));
	}
	String floatStyle = style.getFloat();
	if (floatStyle == null) {
	    return (super.getEnd(table));
	}
	String placement;
	if ("right".equals(floatStyle)) {
	    placement = "r";
	} else if ("left".equals(floatStyle)) {
	    placement = "l";
	} else {
	    return (super.getEnd(table));
	}
	CSSLength width = style.getWidth();
	if (width == null) {
	    return (super.getEnd(table));
	}
	if (width.getUnit() != CSSLength.CM) {
	    return (super.getEnd(table));
	}
	return ("\\end{wraptable}\n");
    }
}
