/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.normalizer;

import java.util.*;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.perl.Perl5Util;
import com.AsamiOffice.text.UString;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * JavaSourceNormalizer
 *
 * @since   Mar. 31, 2000
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 * @author  SAKURAI, Masashi
 */
public class JavaSourceNormalizer extends AbstractNormalizer {
    protected Content[] _normalize(
	Content[] contents,
	Content parent,
	DocContext context
    ) {
	String keywordRegex = UString.checkNull(
	    parent.getAttribute("javasrcKeyword")
	);
	String keywordCount = UString.checkNull(
	    parent.getAttribute("javasrcCount")
	);
	String hilightRegex = UString.checkNull(
	    parent.getAttribute("javasrcHilight")
	);
	String syntaxHilight = UString.checkNull(
	    parent.getAttribute("javasrcSyntaxHilight")
	);
	String text = UDoc.makeInlineText((Container)parent);
	Perl5Util util = new Perl5Util();
	if (keywordRegex != null) {
	    int count = 1;
	    if (keywordCount != null) {
		try {
		    count = Integer.parseInt(keywordCount);
		} catch (NumberFormatException e) {
		}
	    }
	    if (_isMatch(util, keywordRegex, text, count)) {
		String matched = util.toString();
		int start = _getStart(text, matched, count);
		if (start == -1) {
		    throw (new InternalError());
		}
		int finish = start + matched.length();
		start = RegexNormalizer.adjustStart(text, start);
		finish = adjustBody(text, start);
		finish = RegexNormalizer.adjustFinish(text, finish);
		text = text.substring(start, finish);
	    } else {
		text = "JavaSource normalizer : no match [" +
		    keywordRegex + "]";
	    }
	}
	parent.setText(null);	// XXX
	List list = new ArrayList();
// modified by SAKURAI, Masashi
	if ("true".equals(syntaxHilight)) {
	    makeJavaHilight(text,list);
	} else {
	    RegexNormalizer.makeHilight(hilightRegex, text, list);
	}
// modified end
	return (UDoc.list2Contents(list));
    }

    private static boolean _isMatch(
	Perl5Util util,
	String keywordRegex,
	String text,
	int count
    ) {
	PatternMatcherInput input = new PatternMatcherInput(text);
	String expr = "#" + keywordRegex + "#m";
	while (util.match(expr, input)) {
	    if (--count == 0) {
		return (true);
	    }
	}
	return (false);
    }

    private static int _getStart(String text, String matched, int count) {
	int index = 0;
	for (;;) {
	    index = text.indexOf(matched, index);
	    if (index == -1) {
		return (-1);
	    }
	    if (--count == 0) {
		return (index);
	    }
	    index += matched.length();
	}
    }

    public static int adjustBody(String text, int position) {
	int size = text.length();
	int lines = 0;
	int point;
	boolean inParentheses = false;
	for (point = position;point < size;point++) {
	    int c = text.charAt(point);
	    if (c == '\n') {
		if (!inParentheses) {
		    lines++;
		}
		if (lines == 2) {
		    return (position);
		}
	    }
	    if (c == '{') {
		break;
	    }
	    if (c == '(') {
		inParentheses = true;
	    } else if (c == ')') {
		inParentheses = false;
	    }
	}
	if (point == size) {
	    return (position);
	}
	int count = 1;
	// XXX : String, comment
	for (point++;point < size;point++) {
	    int c = text.charAt(point);
	    if (c == '}') {
		count--;
		if (count == 0) {
		    return (point);
		}
	    } else if (c == '{') {
		count++;
	    }
	}
	return (point);
    }

// 
// created by SAKURAI, Masashi
//
    /** make hilight for java syntax */
    protected static void makeJavaHilight(String text,List list) {
	if (hilighter == null) {
	    String [][] keymatrix = {keywords,primitives,comments,quotes};
	    hilighter = new HilightMaker(keymatrix,isRegex,classes);
	}
	hilighter.makeHilight(text,list);
    }
    // Hilight Maker
    protected static HilightMaker hilighter = null;
    // Target node class name and CSS class name
	// # {keywords, primitives, comments, quotes}
    protected static String [] classes = {
	"org.xmlsmartdoc.SmartDoc.Span#keyword",
	"org.xmlsmartdoc.SmartDoc.Span#primitive",
	"org.xmlsmartdoc.SmartDoc.Span#comment",
	"org.xmlsmartdoc.SmartDoc.Span#quote"};
    // regex or just keyword switch
	// # if keyword-searching needs regex search, set true.
	// # this switch exists for just performance improvement.
	// # {keywords, primitives, comments, quotes}
    protected static boolean [] isRegex = {false,false,true,true};
    // array of keywords for coloring
    protected static String [] keywords = {
	"public","protected","private","abstract","final","transient","native",
	"class","interface","extends","implements","static","import",
	"for","while","if","do","else","swith","case","throws","package",
	"try","catch","finally","synchronized","default","new","return"};
    protected static String [] primitives = {
	"short","byte","int","long","float","double","char","String",
	"boolean","void","null","false","true"};
    // regex for single, multiple line, formal comment
    protected static String [] comments = {"//.*$", "/\\*[^/](.|\\s)*?\\*/","/\\*\\*[^/](.|\\s)*?\\*/"};
    // regex for string literal
    protected static String [] quotes = {"\\\".*?\\\""};
//
// created end
//
}
