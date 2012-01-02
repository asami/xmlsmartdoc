/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import java.util.*;

/**
 * Symbols
 *
 * @since   Sep.  5, 1999
 * @version Mar. 10, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class Symbols {
    protected Map entries_ = new HashMap();

    public Symbols() {
/*
	setEntry((char)0x003A, "{\\colon}");
	setEntry((char)0x005B, "{\\lbrack}");
	setEntry((char)0x005D, "{\\rbrack}");
	setEntry((char)0x007B, "{\\lbrace}");
	setEntry((char)0x007C, "{\\vert}");
	setEntry((char)0x007D, "{\\rbrace}");
*/
	setEntry((char)0x00A7, "{\\S}");
	setEntry((char)0x00A9, "{\\copyright}");
	setEntry((char)0x00AC, "{\\neg}");
	setEntry((char)0x00B1, "{$\\pm$}");
	setEntry((char)0x00B6, "{\\P}");
	setEntry((char)0x00B7, "$\\cdotp$");
	setEntry((char)0x00C0, "{\\`A}");
	setEntry((char)0x00C1, "{\\'A}");
	setEntry((char)0x00C2, "{\\^A}");
	setEntry((char)0x00C3, "{\\~A}");
	setEntry((char)0x00C4, "{\\\"A}");
	setEntry((char)0x00C5, "{\\AA}");
	setEntry((char)0x00C6, "{\\AE}");
	setEntry((char)0x00C7, "{\\c C}");
	setEntry((char)0x00C8, "{\\`E}");
	setEntry((char)0x00C9, "{\\'E}");
	setEntry((char)0x00CA, "{\\^E}");
	setEntry((char)0x00CB, "{\\\"E}");
	setEntry((char)0x00CC, "{\\`I}");
	setEntry((char)0x00CD, "{\\'I}");
	setEntry((char)0x00CE, "{\\^I}");
	setEntry((char)0x00CF, "{\\\"I}");
	setEntry((char)0x00D1, "{\\~N}");
	setEntry((char)0x00D2, "{\\`O}");
	setEntry((char)0x00D3, "{\\'O}");
	setEntry((char)0x00D4, "{\\^O}");
	setEntry((char)0x00D5, "{\\~O}");
	setEntry((char)0x00D6, "{\\\"O}");
	setEntry((char)0x00D7, "{$\\times$}");
	setEntry((char)0x00D8, "{\\O}");
	setEntry((char)0x00D9, "{\\`U}");
	setEntry((char)0x00DA, "{\\'U}");
	setEntry((char)0x00DB, "{\\^U}");
	setEntry((char)0x00DC, "{\\\"U}");
	setEntry((char)0x00DD, "{\\'Y}");
	setEntry((char)0x00DF, "{\\ss}");
	setEntry((char)0x00E0, "{\\`a}");
	setEntry((char)0x00E1, "{\\'a}");
	setEntry((char)0x00E2, "{\\^a}");
	setEntry((char)0x00E3, "{\\~a}");
	setEntry((char)0x00E4, "{\\\"a}");
	setEntry((char)0x00E5, "{\\aa}");
	setEntry((char)0x00E6, "{\\ae}");
	setEntry((char)0x00E7, "{\\c c}");
	setEntry((char)0x00E8, "{\\`e}");
	setEntry((char)0x00E9, "{\\'e}");
	setEntry((char)0x00EA, "{\\^e}");
	setEntry((char)0x00EB, "{\\\"e}");
	setEntry((char)0x00EC, "{\\`i}");
	setEntry((char)0x00ED, "{\\'i}");
	setEntry((char)0x00EE, "{\\^i}");
	setEntry((char)0x00EF, "{\\\"i}");
	setEntry((char)0x00F1, "{\\~n}");
	setEntry((char)0x00F2, "{\\`o}");
	setEntry((char)0x00F3, "{\\'o}");
	setEntry((char)0x00F4, "{\\^o}");
	setEntry((char)0x00F5, "{\\~o}");
	setEntry((char)0x00F6, "{\\\"o}");
	setEntry((char)0x00F7, "{\\div}");
	setEntry((char)0x00F8, "{\\o}");
	setEntry((char)0x00F9, "{\\`u}");
	setEntry((char)0x00FA, "{\\'u}");
	setEntry((char)0x00FB, "{\\^u}");
	setEntry((char)0x00FC, "{\\\"u}");
	setEntry((char)0x00FD, "{\\'y}");
	setEntry((char)0x0141, "{\\L}");
	setEntry((char)0x0142, "{\\l}");
	setEntry((char)0x0152, "{\\OE}");
	setEntry((char)0x0153, "{\\oe}");
	setEntry((char)0x2013, "-");
	setEntry((char)0x2014, "--");
	setEntry((char)0x201C, "``");
	setEntry((char)0x201D, "''");
	setEntry((char)0x2024, "{\\.}");
	// for japanese encoding
	setEntry((char)0x005C, "{$\\setminus$}");
	setEntry((char)0x2015, null);
	setEntry((char)0x007E, "{\\~{}}");
	setEntry((char)0x301C, null);
	setEntry((char)0x2016, null);
	setEntry((char)0xFFE3, null);
	setEntry((char)0xFF3C, "{$\\setminus$}"); // 005C
	setEntry((char)0xFF5E, "{$\\sim$}");
	setEntry((char)0x2225, "{$\\Vert$}");
	setEntry((char)0xFF0D, null);
	setEntry((char)0xFFE0, null);
	setEntry((char)0xFFE1, null);
	setEntry((char)0xFFE5, null);
	setEntry((char)0xFFE2, "{$\\neg$}");
	setEntry((char)0xFFE4, null);
	// for math fonts (http://www.ams.org/STIX/)
	// under construction...
    }

    public void setEntry(char c, String symbol) {
	entries_.put(new Integer((int)c), symbol);
    }

    public String getSymbol(char c) {
	return ((String)entries_.get(new Integer((int)c)));
    }
}
