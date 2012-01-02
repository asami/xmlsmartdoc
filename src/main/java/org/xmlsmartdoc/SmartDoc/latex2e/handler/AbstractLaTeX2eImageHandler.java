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
 * AbstractLaTeX2eImageHandler
 *
 * @since   Oct. 14, 2000
 * @version Jun. 16, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class AbstractLaTeX2eImageHandler
    implements LaTeX2eImageHandler {

    protected LaTeX2eConfig latex2eConfig_;

    public void setup(LaTeX2eConfig config) {
	latex2eConfig_ = config;
    }

    public String makeImageTag(Img img) {
	String filename = img.getSrc();
	CSSStyle style = img.getStyle();
	if (filename == null) {
	    throw (new SmartDocWarningException(
		"file name not specified in <img>"));
	}
	return (_makeImageTag(filename, style, false));
    }

    // LaTeX2eImageHandler
    public String makeImageTag(ImageFigure image) {
	String filename = image.getSrc();
	CSSStyle style = image.getStyle();
	if (filename == null) {
	    throw (new SmartDocWarningException(
		"file name not specified in <figure> " +
		"title = " + image.getTitle() +
		" id = " + image.getID()
	    ));
	}
	return (_makeImageTag(filename, style, _isAutoResize(image)));
    }

    private boolean _isAutoResize(ImageFigure image) {
	String autoResizeValue
	    = image.getAttribute("latex2e.graphic.autoResize");
	if (autoResizeValue != null) {
	    return ("true".equals(autoResizeValue));
	}
	return (latex2eConfig_.isGraphicAutoResize());
    }

    protected abstract String _makeImageTag(
	String filename,
	CSSStyle style,
	boolean adjust
    );

    public GeneratorArtifact[] generateArtifacts(ImageFigure image) {
	return (new GeneratorArtifact[0]);
    }

    public GeneratorArtifact[] generateArtifacts(Img image) {
	return (new GeneratorArtifact[0]);
    }
}
