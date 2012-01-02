/*
 * SmartDoc : Ultimate document format based on XML
 *	Copyright (C) 1998-2004	 ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.	 See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.xmlsmartdoc.SmartDoc.normalizer;

import java.util.*;
import com.AsamiOffice.text.UString;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * XMLSourceNormalizer
 *
 * @since   Mar. 31, 2000
 * @version Mar. 23, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 * @author  SAKURAI, Masashi
 */
public class XMLSourceNormalizer extends AbstractNormalizer {
    protected Content[] _normalize(
        Content[] contents,
        Content parent,
        DocContext context
    ) {
        // modified by SAKURAI, Masashi
        String syntaxHilight =
            UString.checkNull(parent.getAttribute("xmlSyntaxHilight"));
        if ("true".equals(syntaxHilight)) {
            String text = UDoc.makeInlineText((Container)parent);
            parent.setText(null); // XXX
            List list = new ArrayList();
            makeXmlHilight(text, list);
            return (UDoc.list2Contents(list));
        } else {
            return contents;
        }
        // modified end
    }

    // 
    // created by SAKURAI, Masashi
    //
    /** make hilight for xml syntax */
    protected static void makeXmlHilight(String text, List list) {
        if (hilighter == null) {
            String[][] keymatrix = { keywords, primitives, comments, quotes };
            hilighter = new HilightMaker(keymatrix, isRegex, classes);
        }
        hilighter.makeHilight(text, list);
    }
    // Hilight Maker
    protected static HilightMaker hilighter = null;
    // Target node class name and CSS class name
    // # {keywords, primitives, comments, quotes}
    protected static String[] classes = {
            "org.xmlsmartdoc.SmartDoc.Span#keyword",
            "org.xmlsmartdoc.SmartDoc.Span#primitive",
            "org.xmlsmartdoc.SmartDoc.Span#comment",
            "org.xmlsmartdoc.SmartDoc.Span#quote"
    };
    // regex or just keyword switch
    // # if keyword-searching needs regex search, set true.
    // # this switch exists for just performance improvement.
    // # {keywords, primitives, comments, quotes}
    protected static boolean[] isRegex = { true, true, true, true };
    // array of keywords for coloring
    protected static String[] keywords =
        { "<[^-?%!](\\w|\\:|-|_)*", ">", "<!\\s*[A-Z]+" };
    protected static String[] primitives = {
            "[^\\s](\\w|[\\:]|-|_)*?=",
            "<\\?(.|\\s)*?\\?>",
            "#PCDATA|NMTOKEN|#REQUIRED" 
    };
    // regex for single, multiple line, formal comment
    protected static String[] comments = { "<%(.|\\s)*?%>", "<!--(.|\\s)*?-->" };
    // regex for string literal and CDATA section
    protected static String[] quotes =
        { "\\\".*?\\\"", "<!\\[CDATA\\[(.|\\s)*?\\]\\]>" };
    //
    // created end
    //
}
