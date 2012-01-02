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
import org.apache.oro.text.perl.Perl5Util;
import com.AsamiOffice.jaba2.util.RangeManager;
import com.AsamiOffice.text.UString;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * ConsoleNormalizer
 *
 * @since   Aug. 13, 1999
 * @version Jul.  4. 2007
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class ConsoleNormalizer extends AbstractNormalizer {
    protected Content[] _normalize(
        Content[] contents,
        Content parent,
        DocContext context) {
        int width = 65;
        try {
            String widthAttr =
                UString.checkNull(parent.getAttribute("consoleWidth"));
            if (widthAttr != null) {
                width = Integer.parseInt(widthAttr);
            }
        } catch (NumberFormatException e) {
            // do nothing
        }
        String contSymbol = getContSymbol_(parent);
        //	String text = UDoc.makeInlineText((Container)parent);
        String text = UDoc.distillText((Container)parent); // XXX
        text = UNormalizer.makeWrappedLines(text, width, contSymbol);
        String prompt = UString.checkNull(parent.getAttribute("consolePrompt"));
        if (prompt == null) {
            prompt = ">";
        }
        String promptRegex =
            UString.checkNull(parent.getAttribute("consolePromptRegex"));
        String promptRange =
            UString.checkNull(parent.getAttribute("consolePromptRange"));
        if (promptRange == null) {
            promptRange = "1";
        }
        RangeManager range = new RangeManager(promptRange);
        if (promptRegex != null) {
            parent.setText(null);
            return (_makeConsoleByPromptRegex(parent, text, promptRegex, range));
        } else {
            parent.setText(null);
            return (_makeConsoleByPrompt(parent, text, prompt, range));
        }
    }

    private Content[] _makeConsoleByPromptRegex(
        Content parent,
        String text,
        String regex,
        RangeManager range) {
        regex = "#" + regex + "#m";
        Perl5Util util = new Perl5Util();
        List list = new ArrayList();
        String[] lines = UString.makeTrimedStringList(text);
        boolean isKbd = false;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (range.isValid(i + 1)) {
                if (util.match(regex, line)) {
                    String prompt = util.toString();
                    int index = line.indexOf(prompt);
                    if (index == -1) {
                        throw (new InternalError());
                    }
                    int inputIndex = index + prompt.length();
                    list.add(new CharBlock(line.substring(index, inputIndex)));
                    addKbdLine_(list, line.substring(inputIndex));
                    isKbd = isContinueLine_(parent, line); 
                    list.add(new CharBlock("\n"));
                } else {
                    if (isKbd) {
                        addKbdLine_(list, line);
                        list.add(new CharBlock("\n"));
                        isKbd = isContinueLine_(parent, line);
                    } else {
                        list.add(new CharBlock(line + "\n"));
                    }
                }
            } else {
                if (isKbd) {
                    addKbdLine_(list, line);
                    list.add(new CharBlock("\n"));
                    isKbd = isContinueLine_(parent, line);
                } else {
                    list.add(new CharBlock(line + "\n"));
                }
            }
        }
        return ((Content[])UDoc.list2Contents(list));
    }

    private Content[] _makeConsoleByPrompt(
        Content parent,
        String text,
        String prompt,
        RangeManager range) {
        List list = new ArrayList();
        String[] lines = UString.makeTrimedStringList(text);
        boolean isKbd = false;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (range.isValid(i + 1)) {
                int index = line.indexOf(prompt);
                if (index != -1) {
                    int inputIndex = index + prompt.length();
                    int lineLength = line.length();
                    for (;;) {
                        if (inputIndex >= lineLength) {
                            break;
                        }
                        if (line.charAt(inputIndex) == ' ') {
                            inputIndex++;
                        } else {
                            break;
                        }
                    }
                    list.add(new CharBlock(line.substring(0, inputIndex)));
                    if (inputIndex < lineLength) {
                        addKbdLine_(list, line.substring(inputIndex));
                        isKbd = isContinueLine_(parent, line); 
                    }
                    list.add(new CharBlock("\n"));
                } else {
                    if (isKbd) {
                        addKbdLine_(list, line);
                        list.add(new CharBlock("\n"));
                        isKbd = isContinueLine_(parent, line);
                    } else {
                        list.add(new CharBlock(line + "\n"));
                    }
                }
            } else {
                if (isKbd) {
                    addKbdLine_(list, line);
                    list.add(new CharBlock("\n"));
                    isKbd = isContinueLine_(parent, line);
                } else {
                    list.add(new CharBlock(line + "\n"));
                }
            }
        }
        return ((Content[])UDoc.list2Contents(list));
    }

    private void addKbdLine_(List list, String line) {
        String indent = getIndentText_(line);
        String body = getBodyText_(line);
        if (indent != null) {
            list.add(new CharBlock(indent));
        }
        Span span = new Span();
        span.setClazz("kbd");
        span.addContent(new CharBlock(body));
        list.add(span);
    }

    private String getIndentText_(String line) {
        if (line.length() == 0) {
            return null;
        }
        if (line.charAt(0) != ' ') {
            return null;
        }
        StringBuffer indent = new StringBuffer();
        char[] chars = line.toCharArray();
        for (int i = 0;i < chars.length;i++) {
            if (chars[i] != ' ') {
                break;
            }
            indent.append(' ');
        }
        return indent.toString();
    }

    private String getBodyText_(String line) {
        if (line.length() == 0) {
            return line;
        }
        char[] chars = line.toCharArray();
        for (int i = 0;i < chars.length;i++) {
            if (chars[i] != ' ') {
                return new String(chars, i, chars.length - i);
            }
        }
        return "";
    }

    private boolean isContinueLine_(Content parent, String line) {
        return line.endsWith(getContSymbol_(parent));
    }

    private String getContSymbol_(Content parent) {
        String contSymbol =
            UString.checkNull(parent.getAttribute("consoleContSymbol"));
        if (contSymbol == null) {
            contSymbol = " \\";
        }
        return contSymbol;
    }

    /*
        private String _makeWrappedLines(
    	String text,
    	int width,
    	String contSymbol
        ) {
    	int size = text.length();
    	if (size <= width) {
    	    return (text);
    	}
    	List list = new ArrayList();
    	String[] lines = UString.makeStringList(text);
    	for (int i = 0;i < lines.length;i++) {
    	    String line = lines[i];
    	    if (line.length() <= width) {
    		list.add(line + "\n");
    	    } else {
    		_makeWrappedLine(line, width, list, contSymbol);
    	    }
    	}
    	StringBuffer buffer = new StringBuffer();
    	int nList = list.size();
    	for (int i = 0;i < nList;i++) {
    	    buffer.append(list.get(i).toString());
    	}
    	return (new String(buffer));
        }
    
        private void _makeWrappedLine(
    	String line,
    	int width,
    	List list,
    	String contSymbol
        ) {
    	String[] tokens = UString.getTokens(line, " ");
    	int pos = 0;
    	StringBuffer buffer = new StringBuffer();
    	if (tokens.length > 0) {
    	    String token = tokens[0];
    	    buffer.append(token);
    	    pos = token.length();
    	    for (int i = 1;i < tokens.length;i++) {
    		token = tokens[i];
    		int tokenLength = token.length();
    		if (pos + tokenLength + 1 <= width) {
    		    if (pos == 0) {
    			buffer.append("    ");
    			buffer.append(token);
    			pos = tokenLength + 1;
    		    } else {
    			buffer.append(" ");
    			buffer.append(token);
    			pos = pos + tokenLength + 1;
    		    }
    		} else {
    		    buffer.append(contSymbol);
    		    buffer.append("\n");
    		    list.add(new String(buffer));
    		    buffer = new StringBuffer();
    		    if (tokenLength >= width) {
    			list.add("    ");
    			list.add(token);
    			buffer.append(contSymbol);
    			buffer.append("\n");
    			pos = 0;
    		    } else {
    			buffer.append("    ");
    			buffer.append(token);
    			pos = 4 + tokenLength;
    		    }
    		}
    	    }
    	}
    	if (buffer.length() > 0) {
    	    if (buffer.charAt(buffer.length() - 1) != '\n') {
    		buffer.append("\n");
    	    }
    	    list.add(new String(buffer));
    	}
        }
    */
}
