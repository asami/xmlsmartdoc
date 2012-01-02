package com.AsamiOffice.jaba2.io;

import java.io.*;
import org.apache.oro.text.regex.*;
import org.apache.oro.text.*;

/**
 * WildcardFilenameFilter
 *
 * @since   Feb. 11, 1998
 * @version Mar. 16, 2001
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class WildcardFilenameFilter implements FilenameFilter {
    public WildcardFilenameFilter(String regex) {
	try {
	    matcher_ = new Perl5Matcher();
	    PatternCompiler compiler = new GlobCompiler();
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
	String[] files = dir.list(new WildcardFilenameFilter(regex));
	for (int i = 0;i < files.length;i++) {
	    System.out.println(files[i]);
	}
    }
}
