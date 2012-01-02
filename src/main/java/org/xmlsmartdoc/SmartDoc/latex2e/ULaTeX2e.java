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

package org.xmlsmartdoc.SmartDoc.latex2e;

import java.awt.Dimension;
import com.AsamiOffice.jaba2.io.FilePath;
import com.AsamiOffice.jaba2.awt.UImage;
import com.AsamiOffice.jaba2.j2fw.generator.*;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * ULaTeX2e
 *
 * @since   Jan. 31, 1999
 * @version Mar. 24, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class ULaTeX2e {
    protected static Symbols symbols__ = new Symbols();

    public static String escape(String string) {
	if (!_isEscape(string)) {
	    return (string);
	}
	StringBuffer buffer = new StringBuffer();
	int size = string.length();
	for (int i = 0;i < size;i++) {
	    char c = string.charAt(i);
	    switch (c) {

	    case '\\':
//		buffer.append("\\(\\backslash\\)");
		buffer.append("$\\backslash$");
		break;
	    case '{':
		buffer.append("{\\{}");
		break;
	    case '}':
		buffer.append("{\\}}");
		break;
	    case '$':
		buffer.append("{\\$}");
		break;
	    case '&':
		buffer.append("{\\&}");
		break;
	    case '#':
		buffer.append("{\\#}");
		break;
	    case '_':
		buffer.append("{\\_}");
		break;
	    case '^':
//		buffer.append("{\\textasciicircum}");
		buffer.append("{\\^{}}");
		break;
	    case '%':
		buffer.append("{\\%}");
		break;
	    case '~':
//		buffer.append("{\\textasciitilde}");
		buffer.append("{\\~{}}");
		break;
	    case '<':
//		buffer.append("{\\textless}");
//		buffer.append("\\(<\\)");
		buffer.append("$<$");
		break;
	    case '>':
//		buffer.append("{\\textgreater}");
		buffer.append("$>$");
		break;
	    case '|':
//		buffer.append("{\\textbar}");
		buffer.append("$|$");
		break;
	    case '/':
		buffer.append("{\\slash}");
		break;
//	    case '.':
//		buffer.append(".{}");
//		break;
	    case '[':
		buffer.append("{[}");
		break;
	    case ']':
		buffer.append("{]}");
		break;
	    default:
		String symbol = symbols__.getSymbol(c);
		if (symbol != null) {
		    buffer.append(symbol);
		} else {
		    buffer.append(c);
		}
	    }
	}
	return (new String(buffer));
    }

    private static boolean _isEscape(String string) {
	int size = string.length();
	for (int i = 0;i < size;i++) {
	    char c = string.charAt(i);
	    switch (c) {

	    case '\\':
	    case '{':
	    case '}':
	    case '$':
	    case '&':
	    case '#':
	    case '_':
	    case '^':
	    case '%':
	    case '~':
	    case '<':
	    case '>':
	    case '|':
	    case '/':
//	    case '.':
	    case '[':
	    case ']':
		return (true);
	    default:
		String symbol = symbols__.getSymbol(c);
		if (symbol != null) {
		    return (true);
		}
	    }
	}
	return (false);
    }

    public static String escapeAlltt(String string) {
	if (!_isEscapeAlltt(string)) {
	    return (string);
	}
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

    private static boolean _isEscapeAlltt(String string) {
	int size = string.length();
	for (int i = 0;i < size;i++) {
	    char c = string.charAt(i);
	    switch (c) {

	    case '\\':
	    case '{':
	    case '}':
		return (true);
	    default:
	    }
	}
	return (false);
    }

    public static String escapeHyperRef(String string) {
	if (!_isEscapeHyperRef(string)) {
	    return (string);
	}
	StringBuffer buffer = new StringBuffer();
	int size = string.length();
	for (int i = 0;i < size;i++) {
	    char c = string.charAt(i);
	    switch (c) {

	    case '#':
		buffer.append("{\\#}");
		break;
	    case '_':
		buffer.append("{\\_}");
		break;
	    case '~':
		buffer.append("{\\~{}}");
		break;
	    default:
		buffer.append(c);
	    }
	}
	return (new String(buffer));
    }

    private static boolean _isEscapeHyperRef(String string) {
	int size = string.length();
	for (int i = 0;i < size;i++) {
	    char c = string.charAt(i);
	    switch (c) {

	    case '#':
	    case '_':
	    case '~':
		return (true);
	    default:
	    }
	}
	return (false);
    }

    public static String getLengthString(CSSLength length) {
	switch (length.getUnit()) {

	case CSSLength.IN:
	    return (length.getValue() + "in");
	case CSSLength.CM:
	    return (length.getValue() + "cm");
	case CSSLength.MM:
	    return (length.getValue() + "mm");
	case CSSLength.PT:
	    return (length.getValue() + "pt");
	case CSSLength.PC:
	    return (length.getValue() + "pc");
	case CSSLength.EM:
	    return (length.getValue() + "em");
	case CSSLength.EX:
	    return (length.getValue() + "ex");
	case CSSLength.PX:
	    return (length.getValue() + "px");
	case CSSLength.PERCENT:
	    return ((length.getValue() / 100.0) + "\\textwidth"); // [641]
	case CSSLength.UNKNOWN:
	    return (length.getString());
	default:
	    throw (new IllegalArgumentException(length.toString()));
	}
    }

    public static GeneratorArtifact generateImageBoundingBox(String src) {
	Dimension size = UImage.getSize(src);
	FilePath srcpath = new FilePath(src);
	FilePath destpath = srcpath.changeSuffix("bb");
	StringBuffer buffer = new StringBuffer();
	buffer.append("%%BoundingBox: 0 0 ");
	buffer.append(size.width);
	buffer.append(" ");
	buffer.append(size.height);
	buffer.append("\n");
	buffer.append("%% ");
	buffer.append(destpath.toString());
	buffer.append("\n");
	return (
	    new TextArtifact(
		destpath.toString(),
		new String(buffer)
	    )
	);
    }
}
