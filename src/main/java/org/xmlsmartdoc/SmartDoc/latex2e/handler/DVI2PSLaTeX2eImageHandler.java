/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2002  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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
 * DVI2PSLaTeX2eImageHandler
 *
 * @since   Oct. 19, 1998
 * @version Jan.  7, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class DVI2PSLaTeX2eImageHandler extends AbstractLaTeX2eImageHandler {
    // LaTeX2eImageHandler
    public LaTeX2ePackage[] getPackages() {
	return (new LaTeX2ePackage[] { new LaTeX2ePackage("eclepsf") });
    }

    // LaTeX2eImageHandler
    public String[] getImageCandidates() {
	return (new String[] { "eps", "ps" });
    }

    protected String _makeImageTag(
	String filename,
	CSSStyle style,
	boolean adjust
    ) {
	CSSLength cssWidth = null;
	String width;
	CSSLength cssHeight = null;
	String height;
	float scale = 1.0f;
	if (style != null) {
	    cssWidth = style.getWidth();
	    cssHeight = style.getHeight();
	}
	if (cssWidth == null) {
	    width = null;
	} else {
	    switch (cssWidth.getUnit()) {

	    case CSSLength.PERCENT:
		width = "\\textwidth";
		scale = cssWidth.getValue();
		break;
	    default:
		width = ULaTeX2e.getLengthString(cssWidth);
	    }
	}
	if (cssHeight == null) {
	    height = null;
	} else {
	    switch (cssHeight.getUnit()) {

	    case CSSLength.PERCENT:
		height = "\\textheight";
		scale = cssHeight.getValue();
		break;
	    default:
		height = ULaTeX2e.getLengthString(cssHeight);
	    }
	}
	if (scale != 1.0f) {
	    throw (new IllegalArgumentException("DVI2PSLaTeX2eImageHandler does not support scale parameter"));
	} else {
	    if (width == null && height == null) {
		if (adjust) {
		    return (
			"\\epsfile{file=" +
			filename +
			",width=\\textwidth}"
		    );
		} else {
		    return (
			"\\epsfile{file=" +
			filename +
			"}"
		    );
		}
	    } else if (width != null && height == null) {
		return (
		    "\\epsfile{file=" +
		    filename +
		    ",width=" +
		    width +
		    "}"
		);
	    } else if (width == null && height != null) {
		return (
		    "\\epsfile{file=" +
		    filename +
		    ",height=" +
		    height +
		    "}"
		);
	    } else {
		return (
		    "\\epsfile{file=" +
		    filename +
		    ",width=" +
		    width +
		    ",height=" +
		    height +
		    "}"
		);
	    }
	}
    }

    public String makeStyleBegin(CSSStyle style) {
	return ("");
    }

    public String makeStyleEnd(CSSStyle style) {
	return ("");
    }
}
