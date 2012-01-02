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
 * WrapfigLaTeX2eImageFloatHandler
 *
 * @since   Mar. 10, 2001
 * @version Mar. 11, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class WrapfigLaTeX2eImageFloatHandler
    extends PlainLaTeX2eImageFloatHandler {

    // LaTeX2eImageFloatHandler
    public String[] getPackages() {
	return (new String[] { "wrapfig" });
    }

    // LaTeX2eImageFloatHandler
    public String getBegin(ImageFigure image, String loc) {
	CSSStyle style = image.getStyle();
	if (style == null) {
	    return (super.getBegin(image, loc));
	}
	String floatStyle = style.getFloat();
	if (floatStyle == null) {
	    return (super.getBegin(image, loc));
	}
	String placement;
	if ("right".equals(floatStyle)) {
	    placement = "r";
	} else if ("left".equals(floatStyle)) {
	    placement = "l";
	} else {
	    return (super.getBegin(image, loc));
	}
	CSSLength width = style.getWidth();
	if (width == null) {
	    return (super.getBegin(image, loc));
	}
	if (width.getUnit() != CSSLength.CM) {
	    return (super.getBegin(image, loc));
	}
	return (
	    "\\begin{wrapfigure}{" + placement + "}" +
	    "{" + width.getString() + "}\n"
	);
    }

    // LaTeX2eImageFloatHandler
    public String getEnd(ImageFigure image) {
	CSSStyle style = image.getStyle();
	if (style == null) {
	    return (super.getEnd(image));
	}
	String floatStyle = style.getFloat();
	if (floatStyle == null) {
	    return (super.getEnd(image));
	}
	String placement;
	if ("right".equals(floatStyle)) {
	    placement = "r";
	} else if ("left".equals(floatStyle)) {
	    placement = "l";
	} else {
	    return (super.getEnd(image));
	}
	CSSLength width = style.getWidth();
	if (width == null) {
	    return (super.getEnd(image));
	}
	if (width.getUnit() != CSSLength.CM) {
	    return (super.getEnd(image));
	}
	return ("\\end{wrapfigure}\n");
    }
}
