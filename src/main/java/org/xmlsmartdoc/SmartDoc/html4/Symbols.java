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

package org.xmlsmartdoc.SmartDoc.html4;

import java.util.*;

/**
 * Symbols
 *
 * @since   Oct. 15, 1999
 * @version Oct. 15, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class Symbols {
    protected String[] symbols_ = {
	"&nbsp;",		// 160
	"&iexcl;",
	"&cent;",
	"&pound;",
	"&curren;",
	"&yen;",
	"&brvbar;",
	"&sect;",
	"&uml;",
	"&copy;",
	"&ordf;",		// 170
	"&laquo;",
	"&not;",
	"&shy;",
	"&reg;",
	"&macr;",
	"&deg;",
	"&plusmn;",
	"&sup2;",
	"&sup3;",
	"&acute;",		// 180
	"&micro;",
	"&para;",
	"&middot;",
	"&cedil;",
	"&sup1;",
	"&ordm;",
	"&raquo;",
	"&frac14;",
	"&frac12;",
	"&frac34;",		// 190
	"&iquest;",
	"&Agrave;",
	"&Aacute;",
	"&Acirc;",
	"&Atilde;",
	"&Auml;",
	"&Aring;",
	"&AElig;",
	"&Ccedil;",
	"&Egrave;",		// 200
	"&Eacute;",
	"&Ecirc;",
	"&Euml;",
	"&Igrave;",
	"&Iacute;",
	"&Icirc;",
	"&Iuml;",
	"&ETH;",
	"&NTilde;",
	"&Ograve;",		// 210
	"&OAccute;",
	"&Ocirc;",
	"&Otilde;",
	"&Ouml;",
	"&times;",
	"&Oslash;",
	"&Ugrave;",
	"&Uacute;",
	"&Ucirc;",
	"&Uuml;",		// 220
	"&Yacute;",
	"&THORN;",
	"&szlig;",
	"&agrave;",
	"&aacute;",
	"&acirc;",
	"&atilde;",
	"&auml;",
	"&aring;",
	"&aelig;",		// 230
	"&ccedil;",
	"&egrave;",
	"&eacute;",
	"&ecirc;",
	"&euml;",
	"&igrave;",
	"&iacute;",
	"&icirc;",
	"&iuml;",
	"&eth;",		// 240
	"&ntilde;",
	"&ograve;",
	"&oacute;",
	"&ocirc;",
	"&otilde;",
	"&ouml;",
	"&divide;",
	"&oslash;",
	"&ugrave;",
	"&uacute;",		// 250
	"&ucirc;",
	"&uuml;",
	"&yacute;",
	"&thorn;",
	"&yuml;"
    };

    public Symbols() {
    }

    public String getSymbol(char c) {
	int code = (int)c;
	if (160 <= c && c <= 255) {
	    return (symbols_[c - 160]);
	}
	return (null);
    }
}
