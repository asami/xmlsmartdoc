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

import java.util.ArrayList;
import java.util.List;

import com.AsamiOffice.text.UString;

/**
 * UNormalizer
 *
 * @since   Jun. 23, 2002
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public final class UNormalizer {
    public static String makeWrappedLines(
        String text,
        int width,
        String contSymbol) {
        int size = text.length();
        if (size <= width) {
            return (text);
        }
        List list = new ArrayList();
        String[] lines = UString.makeStringList(text);
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (line.length() <= width) {
                list.add(line + "\n");
            } else {
                _makeWrappedLine(line, width, list, contSymbol);
            }
        }
        StringBuffer buffer = new StringBuffer();
        int nList = list.size();
        for (int i = 0; i < nList; i++) {
            buffer.append(list.get(i).toString());
        }
        return (new String(buffer));
    }

    private static void _makeWrappedLine(
        String line,
        int width,
        List list,
        String contSymbol) {
        String[] tokens = UString.getTokens(line, " ");
        int pos = 0;
        StringBuffer buffer = new StringBuffer();
        if (tokens.length > 0) {
            String token = tokens[0];
            buffer.append(token);
            pos = token.length();
            for (int i = 1; i < tokens.length; i++) {
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
}
