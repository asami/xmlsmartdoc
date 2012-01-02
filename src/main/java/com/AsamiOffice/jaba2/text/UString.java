/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@asamiOffice.com)
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

package com.AsamiOffice.jaba2.text;

import java.util.*;
import java.io.*;
import java.net.URL;

/**
 * String utility
 *
 * @since   Apr. 18, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public class UString {
/*
    private static final int INIT = 0;
    private static final int TEXT = 1;
    private static final int DOUBLEQUOTE = 2;
    private static final int DOUBLEQUOTETEXT = 3;

    public static boolean isNull(String string) {
	return (string == null || string.equals(""));
    }

    public static boolean notNull(String string) {
	return (string != null && !string.equals(""));
    }

    /**
     * Null string Canonicalization
     **
    public static String checkNull(String string) {
	if (string == null || string.equals("")) {
	    return (null);
	} else {
	    return (string);
	}
    }

    public static boolean isEmpty(String string) {
	int size = string.length();
	for (int i = 0;i < size;i++) {
	    if (!Character.isWhitespace(string.charAt(i))) {
//		System.out.println("isEmpty [" + string + "] -> false");
		return (false);
	    }
	}
//	System.out.println("isEmpty [" + string + "] -> true");
	return (true);
    }

    public static boolean isWideCharacter(char c) {
	if (c == 0xd7) {	// XXX : locale sensitive
	    return (true);
	}
	Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
	if (ub.equals(Character.UnicodeBlock.BASIC_LATIN) ||
	    ub.equals(Character.UnicodeBlock.LATIN_1_SUPPLEMENT) ||
	    ub.equals(Character.UnicodeBlock.LATIN_EXTENDED_A) ||
	    ub.equals(Character.UnicodeBlock.LATIN_EXTENDED_B)) {

	    return (false);
	} else {
	    return (true);
	}
    }

    public static int getHalfLength(String string) {
	int length = 0;
	int size = string.length();
	for (int i = 0;i < size;i++) {
	    if (isWideCharacter(string.charAt(i))) {
		length += 2;
	    } else {
		length++;
	    }
	}
	return (length);
    }

    /**
     * @deprecated
     * @see makeStringList
     **
    public static String[] makeStringArray(String string) {
	return (makeStringArrayFromString(string));
    }

    /**
     * @deprecated
     * @see makeStringList
     **
    public static String[] makeStringArrayFromString(String string) {
	return(getTokensByDelimiter(string, "\r\n"));
    }

    public static String[] getTokensByDelimiter(String text, String delim) {
	return (getTokens(text, delim));
    }

    public static String[] getTokens(String text) {
	return (getTokens(text, " \t\n\r"));
    }

    public static String[] getTokens(String text, String delim) {
	StringTokenizer st = new StringTokenizer(text, delim);
	String[] list = new String[st.countTokens()];
	int i = 0;
	while (st.hasMoreTokens()) {
	    list[i++] = st.nextToken();
	}
	return (list);
    }

    public static String[] getPairTokens(String text, String delim) {
	int index = text.indexOf(delim);
	if (index == -1) {
	    return (new String[] { text });
	} else {
	    return (new String[] {
		text.substring(0, index),
		text.substring(index + 1)
	    });
	}
    }

    public static String[] makeStringListFromString(String string) {
	return(makeStringList(string));
    }

    public static String[] makeStringList(String string) {
	// 0 : init
	// 1 : after cr
	// 2 : after lf
	// 3 : after crlf
	// 4 : after normal
	int status = 0;
	List list = new ArrayList();
	int size = string.length();
	StringBuffer buffer = new StringBuffer();
	for (int i = 0;i < size;i++) {
	    char c = string.charAt(i);
	    switch (status) {

	    case 0:
		if (c == '\r') {
		    status = 1;
		} else if (c == '\n') {
		    status = 2;
		} else {
		    buffer.append(c);
		    status = 4;
		}
		break;
	    case 1:
		if (c == '\r') {
		    list.add(new String(buffer));
		    buffer = new StringBuffer();
		    status = 1;
		} else if (c == '\n') {
		    status = 3;
		} else {
		    list.add(new String(buffer));
		    buffer = new StringBuffer();
		    buffer.append(c);
		    status = 4;
		}
		break;
	    case 2:
		if (c == '\r') {
		    // illegal sequence
		    status = 1;
		    throw (new InternalError("debug"));
		} else if (c == '\n') {
		    list.add(new String(buffer));
		    buffer = new StringBuffer();
		    status = 2;
		} else {
		    list.add(new String(buffer));
		    buffer = new StringBuffer();
		    buffer.append(c);
		    status = 4;
		}
		break;
	    case 3:
		if (c == '\r') {
		    list.add(new String(buffer));
		    buffer = new StringBuffer();
		    status = 1;
		} else if (c == '\n') {
		    // illegal sequence
		    status = 2;
		    throw (new InternalError("debug"));
		} else {
		    list.add(new String(buffer));
		    buffer = new StringBuffer();
		    buffer.append(c);
		    status = 4;
		}
		break;
	    case 4:
		if (c == '\r') {
		    status = 1;
		} else if (c == '\n') {
		    status = 2;
		} else {
		    buffer.append(c);
		    status = 4;
		}
		break;
	    default:
		throw (new InternalError());
	    }
	}
	if (status != 0) {
	    list.add(new String(buffer));
	}
	String[] strings = new String[list.size()];
	return ((String[])list.toArray(strings));
    }

    public static String[] makeTrimedStringList(String string) {
	return (makeStringList(trimEmptyLines(string)));
    }

    public static String trimEmptyLines(String string) {
	StringBuffer buffer = new StringBuffer();
	int size = string.length();
	int start;
	for (int i = 0;;i++) {
	    if (i == size) {
		return ("");
	    }
	    char c = string.charAt(i);
	    if (!(c == '\n' || c == '\r')) {
		start = i;
		break;
	    }
	}
	int end = size - 1;
	for (int i = size - 1;i > start;i--) {
	    char c = string.charAt(i);
	    if (!(c == '\n' || c == '\r')) {
		end = i;
		break;
	    }
	}
	if (end + 1 < size) {
	    char c = string.charAt(end + 1);
	    switch (c) {

	    case '\n':
		end = end + 1;	// Unix style 'LF'
		break;
	    case '\r':
		if (end + 2 <= size) {
		    if (string.charAt(end + 2) == '\r') {
			end = end + 2; // DOS style 'CRLF'
		    } else {
			end = end + 1; // Mac style 'CR'
		    }
		} else {
		    end = end + 1; // Mac style 'CR'
		}
		break;
	    default:
		throw (new InternalError());
	    }
	}
	if (start == 0 && end + 1 == size) {
	    return (string);
	} else {
	    return (string.substring(start, end + 1));
	}
    }

    public static String trimEmptyLines(String[] list) {
	int last;
	for (last = list.length - 1;last >= 0;last--) {
	    if (!isEmpty(list[last])) {
		break;
	    }
	}
	List result = new ArrayList();
	int i = 0;
	for (;i <= last;i++) {
	    if (!isEmpty(list[i])) {
		break;
	    }
	}
	for (;i <= last;i++) {
	    result.add(list[i]);
	}
	return (makeCanonicalString(result));
    }

    public static String makeCanonicalString(List list) {
//	System.out.println("canon -> " + list.size());
	int size = list.size();
	StringBuffer buffer = new StringBuffer();
	for (int i = 0;i < size;i++) {
	    buffer.append(list.get(i));
	    buffer.append("\n"); // Jaba2 rule
	}
	return (new String(buffer));
    }

    public static String makeCanonicalString(String[] list) {
	StringBuffer buffer = new StringBuffer();
	for (int i = 0;i < list.length;i++) {
	    buffer.append(list[i]);
	    buffer.append("\n"); // Jaba2 rule
	}
	return (new String(buffer));
    }

    public static String makeCanonicalString(String string) {
	if (string.indexOf("\r") == -1) {
	    return (string);
	}
	int state = 0;
	StringBuffer buffer = new StringBuffer();
	int size = string.length();
	for (int i = 0;i < size;i++) {
	    char ch = string.charAt(i);
	    switch (state) {

	    case 0: // normal
		switch (ch) {

		case '\n':
		    buffer.append('\n');
		    state = 0;
		    break;
		case '\r':
		    state = 1;
		    break;
		default:
		    buffer.append(ch);
		}
		break;
	    case 1: // after cr
		switch (ch) {

		case '\n':
		    buffer.append('\n');
		    state = 0;
		    break;
		case '\r':
		    buffer.append('\n');
		    state = 1;
		    break;
		default:
		    buffer.append('\n');
		    buffer.append(ch);
		    state = 0;
		}
		break;
	    default:
		throw (new InternalError());
	    }
	}
	return (new String(buffer));
    }

    public static String makeCanonicalStringFromURL(URL url)
	throws IOException {

	String[] list = makeStringListFromURL(url);
	StringBuffer buffer = new StringBuffer();
	for (int i = 0;i < list.length;i++) {
	    buffer.append(list[i]);
	    buffer.append("\n"); // Jaba2 rule
	}
	return (new String(buffer));
    }

    public static String makeCanonicalStringFromURL(URL url, String encoding)
	throws IOException {

	String[] list = makeStringListFromURL(url, encoding);
	StringBuffer buffer = new StringBuffer();
	for (int i = 0;i < list.length;i++) {
	    buffer.append(list[i]);
	    buffer.append("\n"); // Jaba2 rule
	}
	return (new String(buffer));
    }

    public static String[] makeStringListFromURL(URL url)
	throws IOException {

	InputStream in = url.openStream();
	if (in == null) {
	    return (null);
	}
	try {
	    return (makeStringListFromInputStream(in));
	} finally {
	    try {
		in.close();
	    } catch (IOException e) {
	    }
	}
    }

    public static String[] makeStringListFromURL(URL url, String encoding)
	throws IOException {

	InputStream in = url.openStream();
	if (in == null) {
	    return (null);
	}
	try {
	    return (makeStringListFromInputStream(in, encoding));
	} finally {
	    try {
		in.close();
	    } catch (IOException e) {
	    }
	}
    }

    public static String[] makeStringListFromInputStream(InputStream in)
	throws IOException {

	return (makeStringListFromReader(new InputStreamReader(in)));
    }

    public static String[] makeStringListFromInputStream(
	InputStream in,
	String encoding) throws IOException {

	return (makeStringListFromReader(new InputStreamReader(in, encoding)));
    }

    public static String[] makeStringListFromReader(Reader reader)
	throws IOException {

	BufferedReader breader = null;
	List lines = new ArrayList();
	if (reader instanceof BufferedReader) {
	    breader = (BufferedReader)reader;
	} else {
	    breader = new BufferedReader(reader);
	}
	String line;
	while ((line = breader.readLine()) != null) {
	    lines.add(line);
	}
	String[] result = new String[lines.size()];
	return ((String[])lines.toArray(result));
    }

    public static String makeStringFromFile(File file)
	throws IOException {

	Reader in = null;
	try {
	    in = new FileReader(file);
	    return (makeStringFromReader(in));
	} finally {
	    try {
		if (in != null) {
		    in.close();
		}
	    } catch (IOException e) {
	    }
	}
    }

    public static String makeStringFromFile(File file, String encoding)
	throws IOException {

	InputStream in = null;
	try {
	    in = new FileInputStream(file);
	    return (makeStringFromReader(new InputStreamReader(in, encoding)));
	} finally {
	    try {
		if (in != null) {
		    in.close();
		}
	    } catch (IOException e) {
	    }
	}
    }

    public static String makeStringFromResource(String resource, Object base)
	throws IOException {

	InputStream in = null;
	in = base.getClass().getResourceAsStream(resource);
	if (in == null) {
	    return (null);
	}
	try {
	    return (makeStringFromInputStream(in));
	} finally {
	    try {
		in.close();
	    } catch (IOException e) {
	    }
	}
    }

    public static String makeStringFromResource(
	String resource,
	Object base,
	String encoding
    ) throws IOException {
	InputStream in = null;
	in = base.getClass().getResourceAsStream(resource);
	if (in == null) {
	    return (null);
	}
	try {
	    return (makeStringFromInputStream(in, encoding));
	} finally {
	    try {
		in.close();
	    } catch (IOException e) {
	    }
	}
    }

    public static String makeStringFromURL(URL url)
	throws IOException {

	InputStream in = url.openStream();
	if (in == null) {
	    return (null);
	}
	try {
	    return (makeStringFromInputStream(in));
	} finally {
	    try {
		in.close();
	    } catch (IOException e) {
	    }
	}
    }

    public static String makeStringFromURL(URL url, String encoding)
	throws IOException {

	InputStream in = url.openStream();
	if (in == null) {
	    return (null);
	}
	try {
	    return (makeStringFromInputStream(in, encoding));
	} finally {
	    try {
		in.close();
	    } catch (IOException e) {
	    }
	}
    }

    public static String makeStringFromInputStream0(InputStream in)
	throws IOException {

	Reader reader = null;
	StringWriter writer = null;
	String result = null;
	try {
	    reader = new BufferedReader(new InputStreamReader(in));
	    writer = new StringWriter();
	    int c;
	    while ((c = reader.read()) != -1) {
		writer.write(c);
	    }
	    writer.flush();
	    result = new String(writer.getBuffer());
	} finally {
	    if (writer != null) {
		writer.close();
	    }
	}
	return (result);
    }

    public static String makeStringFromInputStream(InputStream in)
	throws IOException {

	return (makeStringFromReader(new InputStreamReader(in)));
    }

    public static String makeStringFromInputStream(
	InputStream in,
	String encoding
    ) throws IOException {

	return (makeStringFromReader(new InputStreamReader(in, encoding)));
    }

    public static String makeStringFromReader(Reader reader)
	throws IOException {

	BufferedReader breader = null;
	String result = null;
	if (reader instanceof BufferedReader) {
	    breader = (BufferedReader)reader;
	} else {
	    breader = new BufferedReader(reader);
	}
	StringBuffer buffer = new StringBuffer();
	int c;
	while ((c = breader.read()) != -1) {
	    buffer.append((char)c);
	}
	result = new String(buffer);
	return (result);
    }

    public static String[] makeStringListFromCSVLine(String string) {
	int state = 0;
	StringBuffer buffer = new StringBuffer();
	List list = new ArrayList();
	int size = string.length();
	for (int i = 0;i < size;i++) {
	    char c = string.charAt(i);
	    switch (state) {

	    case INIT:
		switch (c) {

		case ',':
		    list.add("");
		    break;
		case '"':
		    state = DOUBLEQUOTE;
		    break;
		default:
		    buffer.append(c);
		    state = TEXT;
		}
		break;
	    case TEXT:
		switch (c) {

		case ',':
		    list.add(new String(buffer));
		    buffer = new StringBuffer();
		    state = INIT;
		    break;
		case '"':
		    state = DOUBLEQUOTE;
		    break;
		default:
		    buffer.append(c);
		    state = TEXT;
		}
		break;
	    case DOUBLEQUOTE:
		switch (c) {

		case ',':
		    buffer.append(c);
		    state = DOUBLEQUOTETEXT;
		    break;
		case '"':
		    buffer.append("\"");
		    state = TEXT;
		    break;
		default:
		    buffer.append(c);
		    state = DOUBLEQUOTETEXT;
		}
		break;
	    case DOUBLEQUOTETEXT:
		switch (c) {

		case ',':
		    buffer.append(c);
		    state = DOUBLEQUOTETEXT;
		    break;
		case '"':
		    state = TEXT;
		    break;
		default:
		    buffer.append(c);
		    state = DOUBLEQUOTETEXT;
		}
		break;
	    default:
		throw (new InternalError());
	    }
	}
	if (state != INIT) {
	    list.add(new String(buffer));
	}
	String[] array = new String[list.size()];
	return ((String[])list.toArray(array));
    }

    public static String[] makeStringListFromTabLine(String string) {
	StringTokenizer st = new StringTokenizer(string, "\t");
	int size = st.countTokens();
	String[] list = new String[size];
	for (int i = 0;i < size;i++) {
	    list[i] = st.nextToken();
	}
	return (list);
    }

    public static String[] makeStringListFromSpaceLine(String string) {
	return (
	    makeStringListFromStringTokenizer(new StringTokenizer(string))
	);
    }

    public static String[] makeStringListFromStringWithDelimiters(
	String string,
	String delimiters
    ) {
	return (
	    makeStringListFromStringTokenizer(
		new StringTokenizer(string, delimiters)
	    )
	);
    }	

    public static String[] makeStringListFromStringTokenizer(
	StringTokenizer st
    ) {
	int size = st.countTokens();
	String[] list = new String[size];
	for (int i = 0;i < size;i++) {
	    list[i] = st.nextToken();
	}
	return (list);
    }	

    public static String getLastComponent(String path) {
	return (getLastComponent(path, "/"));
    }

    public static String getLastComponent(String path, String delimiter) {
	int delimSize = delimiter.length();
	if (path.endsWith(delimiter)) {
	    path = path.substring(0, path.length() - delimSize);
	}
	int index = path.lastIndexOf(delimiter);
	if (index == -1) {
	    return (path);
	} else {
	    return (path.substring(index + delimSize));
	}
    }

    public static String getLastComponentBody(String path) {
	return (getLastComponentBody(path, "/"));
    }

    public static String getLastComponentBody(String path, String delimiter) {
	int delimSize = delimiter.length();
	if (path.endsWith(delimiter)) {
	    path = path.substring(0, path.length() - delimSize);
	}
	int first;
	int last;
	first = path.lastIndexOf(delimiter);
	if (first == -1) {
	    first = 0;
	} else {
	    first++;
	}
	last = path.lastIndexOf(".");
	if (last == -1) {
	    return (path.substring(first));
	} else {
	    return (path.substring(first, last));
	}
    }

    public static String getContainerPathname(String path) {
	return (getContainerPathname(path, "/"));
    }

    public static String getContainerPathname(
	String path,
	String delimiter
    ) {
	int delimSize = delimiter.length();
	if (path.endsWith(delimiter)) {
	    path = path.substring(0, path.length() - delimSize);
	}
	int index = path.lastIndexOf(delimiter);
	if (index == -1) {
	    return (null);
	} else {
	    return (path.substring(0, index));
	}
    }

    public static boolean isSuffix(String file, String suffix) {
	return (suffix.equals(getSuffix(file)));
    }

    public static boolean isSuffix(String file, String[] suffixes) {
	for (int i = 0;i < suffixes.length;i++) {
	    if (isSuffix(file, suffixes[i])) {
		return (true);
	    }
	}
	return (false);
    }

    public static String getSuffix(String file) {
	int index = file.lastIndexOf(".");
	if (index == -1) {
	    return (null);
	}
	return (file.substring(index + 1));
    }

    public static String changeSuffix(String string, String suffix) {
	StringBuffer buffer = new StringBuffer(string);
	int index = string.lastIndexOf(".");
	if (index != -1) {
	    buffer.delete(index, string.length());
	}
	buffer.append(".");
	buffer.append(suffix);
	return (new String(buffer));
    }

    // compare
    public static boolean compareList(String string, String[] list) {
	if (string == null) {
	    return (list == null);
	}
	if (list == null) {
	    return (false);
	}
	for (int i = 0;i < list.length;i++) {
	    if (string.equals(list[i])) {
		return (true);
	    }
	}
	return (false);
    }

    public static String replace(
	String template,
	String pattern,
	String replacer
    ) {
	int start = template.indexOf(pattern);
	if (start == -1) {
	    return (template);
	}
	StringBuffer buffer = new StringBuffer(template);
	buffer.replace(start, start + pattern.length(), replacer);
	return (new String(buffer));
    }

    public static String truncate(String template, String pattern) {
	int start = template.indexOf(pattern);
	if (start == -1) {
	    return (template);
	}
	StringBuffer buffer = new StringBuffer(template);
	buffer.delete(start, start + pattern.length());
	return (new String(buffer));
    }

    public static String capitalize(String name) {
	if (name.length() == 0) {
	    return (name);
	}
	if (Character.isUpperCase(name.charAt(0))) {
	    return (name);
	}
	char[] data = name.toCharArray();
	data[0] = Character.toUpperCase(data[0]);
	return (new String(data));
    }

    public static String uncapitalize(String name) {
	if (name.length() == 0) {
	    return (name);
	}
	if (Character.isLowerCase(name.charAt(0))) {
	    return (name);
	}
	char[] data = name.toCharArray();
	data[0] = Character.toLowerCase(data[0]);
	return (new String(data));
    }

    public static String makeClassName(String name) {
	return (capitalize(makeJavaName(name)));
    }

    public static String makeVariableName(String name) {
	char[] data = name.toCharArray();
	if (data.length == 0) {
	    return (name);
	}
	boolean allUpperCase = true;
	for (int i = 0;i < data.length;i++) {
	    char c = data[i];
	    if (c == '-' || c == ':' || c == '.') {
		data[i] = '_';
	    } else if (c == '_') {
		// do nothing
	    } else if (!Character.isUpperCase(c)) {
		allUpperCase = false;
	    }
	}
	if (allUpperCase) {
	    return (new String(data));
	}
	data[0] = Character.toLowerCase(data[0]);
	return (new String(data));
    }

    public static String makeJavaName(String name) {
	char[] data = name.toCharArray();
	if (data.length == 0) {
	    return (name);
	}
	for (int i = 0;i < data.length;i++) {
	    char c = data[i];
	    if (c == '-' || c == ':' || c == '.') {
		data[i] = '_';
	    }
	}
	return (new String(data));
    }

    public static String escape(String text) {
	if (text.indexOf('\n') == -1 &&
	    text.indexOf('\r') == -1 &&
	    text.indexOf('\t') == -1) {

	    return (text);
	}
	StringBuffer buffer = new StringBuffer();
	int size = text.length();
	for (int i = 0;i < size;i++) {
	    char c = text.charAt(i);
	    switch (c) {

	    case '\n':
		buffer.append("\\n");
		break;
	    case '\r':
		buffer.append("\\r");
		break;
	    case '\t':
		buffer.append("\\t");
		break;
	    default:
		buffer.append(c);
	    }
	}
	return (new String(buffer));
    }

    public static boolean isAscii(char c) {
	return (
	    Character.UnicodeBlock.of(c) == Character.UnicodeBlock.BASIC_LATIN
	);
    }
*/
}
