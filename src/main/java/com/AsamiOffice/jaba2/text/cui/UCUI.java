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

package com.AsamiOffice.jaba2.text.cui;

import java.util.*;
import com.AsamiOffice.text.UString;

/**
 * UCUI
 *
 * @since   Oct. 19, 1999
 * @version Sep.  1, 2004
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public final class UCUI {
    private static String[] gyotoKinsoku__ = {",",
                                              ")",
                                              "\u3001",
                                              "\u3002",
                                              "\uff0c"};
    private static String[] gyomatsuKinsoku__ = {"(",
                                                 "[",
                                                 "\uff3b",
                                                 "\uff08"};

    public static String[] getChunks(String text) {
        StringBuffer buffer = null;
        List list = new ArrayList();
        int size = text.length();
        for (int i = 0;i < size;i++) {
            char c = text.charAt(i);
            if (Character.isWhitespace(c)) {
                if (buffer != null) {
                    list.add(new String(buffer));
                    buffer = null;
                }
                list.add(new String(new char[] { c }));
            } else if (isWordSeparateLang(c)) {
                if (buffer == null) {
                    buffer = new StringBuffer();
                }
                buffer.append(c);
            } else {
                if (buffer != null) {
                    list.add(new String(buffer));
                    buffer = null;
                }
                list.add(new String(new char[] { c }));
            }
        }
        if (buffer != null) {
            list.add(new String(buffer));
        }
        String[] result = new String[list.size()];
        return ((String[])list.toArray(result));
    }

    public static String[] getLines(String text, int width) {
        String[] lines = UString.makeStringList(text);
        List list = new ArrayList();
        int size = lines.length;
        for (int i = 0;i < size;i++) {
            String[] chunks = UCUI.getChunks(lines[i]);
            _getLines(chunks, width, list);
        }
        String[] result = new String[list.size()];
        return ((String[])list.toArray(result));
    }

    private static void _getLines(
        String[] chunks,
        int width,
        List list
    ) {
        _getLines(chunks, width, false, list);
    }

    private static void _getLines(
        String[] chunks,
        int width,
        boolean useMargin,
        List list
    ) {
        List temp = new ArrayList();
        StringBuffer buffer = new StringBuffer();
        boolean isSpace = false;
        boolean isStartup = true;
        int cp = 0;
        for (int i = 0;i < chunks.length;i++) {
            String chunk = chunks[i];
            int length = UString.getHalfLength(chunk);
            if (UCUI.isSpace(chunk)) {
                if (isStartup) {
                    buffer.append(chunk);
                    cp += length;
                } else {
                    isSpace = true;
                }
            } else if (UCUI.isGyotoKinsoku(chunk)) {
                isStartup = false;
                if (cp == 0 || cp + length > width) {
                    if (!useMargin) {
                        _getLinesWithKinsoku(chunks, width, list);
                        return;
                    }
                }
                if (isSpace) {
                    buffer.append(" ");
                    cp++;
                }
                buffer.append(chunk);
                cp += length;
                isSpace = false;
            } else if (UCUI.isGyomatsuKinsoku(chunk)) {
                isStartup = false;
                if ((isSpace && cp + 1 + 1 + 1 > width) ||
                    (cp + 1 + 1 > width)) {

                    temp.add(new String(buffer));
                    buffer = new StringBuffer();
                    cp = 0;
                }
                if (isSpace && cp != 0) {
                    buffer.append(" ");
                    cp++;
                }
                buffer.append(chunk);
                cp += length;
                isSpace = false;
            } else {
                isStartup = false;
                if ((isSpace?1:0) + cp + length > width && cp != 0) {
                    temp.add(new String(buffer));
                    buffer = new StringBuffer();
                    cp = 0;
                }
                if (isSpace && cp != 0) {
                    buffer.append(" ");
                    cp++;
                }
                buffer.append(chunk);
                cp += length;
                isSpace = false;
            }
        }
        if (buffer.length() > 0) {
            temp.add(new String(buffer));
        }
        list.addAll(temp);
    }

    private static void _getLinesWithKinsoku(
        String[] chunks,
        int width,
        List list
    ) {
        int realWidth = width - 2;
        _getLines(chunks, realWidth, true, list);
    }

    public static int getWidth(String text) {
        return (getWidth(UString.makeStringList(text)));
    }

    public static int getWidth(String[] lines) {
        int width = 0;
        for (int i = 0;i < lines.length;i++) {
            width = Math.max(width, UString.getHalfLength(lines[i]));
        }
        return (width);
    }

    public static boolean isGyotoKinsoku(String c) {
        for (int i = 0;i < gyotoKinsoku__.length;i++) {
            if (c.equals(gyotoKinsoku__[i])) {
                return (true);
            }
        }
        return (false);
    }

    public static boolean isGyomatsuKinsoku(String c) {
        for (int i = 0;i < gyomatsuKinsoku__.length;i++) {
            if (c.equals(gyomatsuKinsoku__[i])) {
                return (true);
            }
        }
        return (false);
    }

    public static boolean isSpace(String text) {
        int size = text.length();
        for (int i = 0;i < size;i++) {
            if (!Character.isWhitespace(text.charAt(i))) {
                return (false);
            }
        }
        return (true);
    }

    public static boolean isWordSeparateLang(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub.equals(Character.UnicodeBlock.BASIC_LATIN) ||
            ub.equals(Character.UnicodeBlock.LATIN_1_SUPPLEMENT) ||
            ub.equals(Character.UnicodeBlock.LATIN_EXTENDED_A) ||
            ub.equals(Character.UnicodeBlock.LATIN_EXTENDED_B)) {

            return (true);
        } else {
            return (false);
        }
    }

    public static int calcHLineLoopCount(int width, int lineWidth) {
        return ((width / lineWidth) + (width % lineWidth));
    }

    public static void drawHLine(
        ICBoard board,
        int width,
        String line,
        int x,
        int y
    ) {
        int lineWidth = UString.getHalfLength(line);
        int loop = calcHLineLoopCount(width, lineWidth);
        while (loop-- > 0) {
            board.put(x, y, line);
            x += lineWidth;
        }
    }
}
