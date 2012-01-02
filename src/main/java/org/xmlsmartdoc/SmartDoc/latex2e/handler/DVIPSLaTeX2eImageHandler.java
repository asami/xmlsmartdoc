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

import java.util.*;
import com.AsamiOffice.jaba2.j2fw.generator.*;
import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.latex2e.*;

/**
 * DVIPSLaTeX2eImageHandler
 *
 * @since   Oct. 19, 1998
 * @version Jan. 16, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class DVIPSLaTeX2eImageHandler extends AbstractLaTeX2eImageHandler {
    String package_;
    String[] options_;

    public void setup(LaTeX2eConfig config) {
	super.setup(config);
/*
	package_ = config.getDvipsPackage();
	if (package_ == null || "".equals(package_)) {
	    package_ = "graphics";
	}
	options_ = config.getDvipsOptions();
*/
    }

    // LaTeX2eImageHandler
    public LaTeX2ePackage[] getPackages() {
	List packages = new ArrayList();
	String dvipsPackage = latex2eConfig_.getDvipsPackage();
	String[] dvipsOptions = latex2eConfig_.getDvipsOptions();
	String graphicPackage = latex2eConfig_.getGraphicPackage();
	String[] graphicOptions = latex2eConfig_.getGraphicOptions();
	if (dvipsPackage != null) {
	    if (dvipsOptions != null && dvipsOptions.length > 0) {
		packages.add(new LaTeX2ePackage(dvipsPackage, dvipsOptions));
	    } else {
		packages.add(new LaTeX2ePackage(dvipsPackage));
	    }
	}
	if (graphicPackage != null) {
	    if (graphicOptions != null && graphicOptions.length > 0) {
		packages.add(
		    new LaTeX2ePackage(graphicPackage, graphicOptions)
		);
	    } else {
		packages.add(new LaTeX2ePackage(graphicPackage));
	    }
	}
	if (packages.size() == 0) {
	    packages.add(new LaTeX2ePackage("graphics"));
	}
	LaTeX2ePackage[] result = new LaTeX2ePackage[packages.size()];
	return ((LaTeX2ePackage[])packages.toArray(result));
/*
	if (options_ != null && options_.length > 0) {
	    return (
		new LaTeX2ePackage[] {
		    new LaTeX2ePackage(package_, options_)
		}
	    );
	} else {
	    return (new LaTeX2ePackage[] { new LaTeX2ePackage(package_) });
	}
*/
    }

    // LaTeX2eImageHandler
    public String[] getImageCandidates() {
	return (new String[] { "eps", "ps", "gif", "jpg", "jpeg", "png" });
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
		scale = cssWidth.getValue() / 100.0f;
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
		scale = cssHeight.getValue() / 100.0f; // XXX : should use only resizebox
		break;
	    default:
		height = ULaTeX2e.getLengthString(cssHeight);
	    }
	}
	StringBuffer buffer = new StringBuffer();
	if (scale != 1.0f) {
	    buffer.append("\\scalebox{");
	    buffer.append(scale);
	    buffer.append("}{");
	}
	if (width == null && height == null) {
	    if (adjust) {
		buffer.append("\\resizebox{\\textwidth}{!}{");
		buffer.append("\\includegraphics{");
		buffer.append(filename);
		buffer.append("}}");
	    } else {
		buffer.append("\\includegraphics{");
		buffer.append(filename);
		buffer.append("}");
	    }
	} else if (width != null && height == null) {
	    buffer.append("\\resizebox{");
	    buffer.append(width);
	    buffer.append("}{!}{");
	    buffer.append("\\includegraphics{");
	    buffer.append(filename);
	    buffer.append("}}");
	} else if (width == null && height != null) {
	    buffer.append("\\resizebox{!}{");
	    buffer.append(height);
	    buffer.append("}{");
	    buffer.append("\\includegraphics{");
	    buffer.append(filename);
	    buffer.append("}}");
	} else {
	    buffer.append("\\resizebox{");
	    buffer.append(width);
	    buffer.append("}{");
	    buffer.append(height);
	    buffer.append("}{");
	    buffer.append("\\includegraphics{");
	    buffer.append(filename);
	    buffer.append("}}");
	}
	if (scale != 1.0f) {
	    buffer.append("}");
	}
	return (new String(buffer));
    }

    public String makeStyleBegin(CSSStyle style) {
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
		scale = cssWidth.getValue() / 100.0f;
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
		scale = cssHeight.getValue() / 100.0f; // XXX
		break;
	    default:
		height = ULaTeX2e.getLengthString(cssHeight);
	    }
	}
	StringBuffer buffer = new StringBuffer();
	if (scale != 1.0f) {
	    buffer.append("\\scalebox{");
	    buffer.append(scale);
	    buffer.append("}{");
	}
	if (width == null && height == null) {
	} else if (width != null && height == null) {
	    buffer.append("\\resizebox{");
	    buffer.append(width);
	    buffer.append("}{!}{");
	} else if (width == null && height != null) {
	    buffer.append("\\resizebox{!}{");
	    buffer.append(height);
	    buffer.append("}{");
	} else {
	    buffer.append("\\resizebox{");
	    buffer.append(width);
	    buffer.append("}{");
	    buffer.append(height);
	    buffer.append("}{");
	}
	return (new String(buffer));
    }

    public String makeStyleEnd(CSSStyle style) {
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
		scale = cssWidth.getValue() / 100.0f;
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
		scale = cssHeight.getValue() / 100.0f; // XXX
		break;
	    default:
		height = ULaTeX2e.getLengthString(cssHeight);
	    }
	}
	StringBuffer buffer = new StringBuffer();
	if (width == null && height == null) {
	} else if (width != null && height == null) {
	    buffer.append("}");
	} else if (width == null && height != null) {
	    buffer.append("}");
	} else {
	    buffer.append("}");
	}
	if (scale != 1.0f) {
	    buffer.append("}");
	}
	return (new String(buffer));
    }

    public GeneratorArtifact[] generateArtifacts(ImageFigure image) {
	return (_generateImageArtifacts(image));
    }

    public GeneratorArtifact[] generateArtifacts(Img image) {
	return (_generateImageArtifacts(image));
    }

    private GeneratorArtifact[] _generateImageArtifacts(Content image) {
	String filename;
	filename = image.getSrc();
	if (filename == null) {
	    return (new GeneratorArtifact[0]);
	}
	if (filename.endsWith(".gif") ||
	    filename.endsWith(".png") ||
	    filename.endsWith(".jpeg") ||
	    filename.endsWith(".jpg"))  {

	    return (
		new GeneratorArtifact[] {
		    ULaTeX2e.generateImageBoundingBox(filename)
		}
	    );
	}
	return (new GeneratorArtifact[0]);
    }
}
