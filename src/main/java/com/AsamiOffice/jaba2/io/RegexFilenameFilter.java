/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2001  ASAMI, Tomoharu (asami@zeomtech.com)
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
package com.AsamiOffice.jaba2.io;

import java.io.*;
import org.apache.oro.text.regex.*;

/**
 * RegexFilenameFilter
 *
 * @since   Feb. 11, 1998
 * @version Aug. 30, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class RegexFilenameFilter implements FilenameFilter {
    public RegexFilenameFilter(String regex) {
	try {
	    matcher_ = new Perl5Matcher();
	    PatternCompiler compiler = new Perl5Compiler();
	    pattern_ = compiler.compile(regex);
	} catch (MalformedPatternException e) {
	    throw (new IllegalArgumentException(e.getMessage()));
	}
    }

    public boolean accept(File dir, String name) {
	PatternMatcherInput input = new PatternMatcherInput(name);
	return (matcher_.matches(input, pattern_));
    }

    PatternMatcher matcher_;
    Pattern pattern_;

    // test driver
    public static void main(String[] args) {
	String dirname = args[0];
	String regex = args[1];
	File dir = new File(dirname);
	String[] files = dir.list(new RegexFilenameFilter(regex));
	for (int i = 0;i < files.length;i++) {
	    System.out.println(files[i]);
	}
    }
}
