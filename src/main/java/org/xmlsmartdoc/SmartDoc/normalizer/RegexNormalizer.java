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
 * RegexNormalizer
 *
 * @since   Mar. 31, 2000
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class RegexNormalizer extends AbstractNormalizer {
    protected Content[] _normalize(
        Content[] contents,
        Content parent,
        DocContext context) {
        String extractRegex =
            UString.checkNull(parent.getAttribute("regexExtract"));
        String hilightRegex =
            UString.checkNull(parent.getAttribute("regexHilight"));
        String unit = UString.checkNull(parent.getAttribute("regexUnit"));
        if (unit == null) {
            unit = "line";
        }
        String range = UString.checkNull(parent.getAttribute("regexRange"));
        if (range == null) {
            range = "*";
        }
        String regexClass =
            UString.checkNull(parent.getAttribute("regexClass"));
        String text = UDoc.makeInlineText((Container)parent);
        Perl5Util util = new Perl5Util();
        if (extractRegex != null) {
            if (util.match("#" + extractRegex + "#m", text)) {
                String matched = util.toString();
                if ("line".equals(unit)) {
                    text = adjustByLine(text, matched);
                } else if ("spot".equals(unit)) {
                    text = matched;
                } else {
                    throw (new UnsupportedOperationException());
                }
            }
        }
        parent.setText(null); // XXX
        List list = new ArrayList();
        makeHilight(hilightRegex, text, range, regexClass, list);
        return (UDoc.list2Contents(list));
    }

    public static String adjustByLine(String text, String matched) {
        int start = text.indexOf(matched);
        if (start == -1) {
            throw (new InternalError());
        }
        int finish = start + matched.length();
        start = adjustStart(text, start);
        finish = adjustFinish(text, finish);
        return (text.substring(start, finish));
    }

    public static int adjustStart(String text, int start) {
        for (int point = start; point > 0; point--) {
            if (text.charAt(point) == '\n') {
                return (point + 1);
            }
        }
        return (0);
    }

    public static int adjustFinish(String text, int finish) {
        int size = text.length();
        for (int point = finish; point < size; point++) {
            if (text.charAt(point) == '\n') {
                return (point);
            }
        }
        return (size);
    }

    public static void makeHilight(
        String hilightRegex,
        String text,
        List list) {
        makeHilight(hilightRegex, text, "*", null, list);
    }

    public static void makeHilight(
        String hilightRegex,
        String text,
        String range,
        String regexClass,
        List list) {
        Perl5Util util = new Perl5Util();
        if (hilightRegex != null) {
            RangeManager manager = new RangeManager(range);
            String regex = "#" + hilightRegex + "#m";
            int index = 1;
            while (util.match(regex, text)) {
                String matched = util.toString();
                int start = text.indexOf(matched);
                if (start == -1) {
                    throw (new InternalError());
                }
                int finish = start + matched.length();
                if (manager.isValid(index)) {
                    if (start > 0) {
                        list.add(new CharBlock(text.substring(0, start)));
                    }
                    Em em = new Em();
                    if (regexClass != null) {
                        em.setClazz(regexClass);
                    }
                    em.addContent(new CharBlock(text.substring(start, finish)));
                    list.add(em);
                } else {
                    list.add(new CharBlock(text.substring(0, finish)));
                }
                index++;
                text = text.substring(finish);
            }
            list.add(new CharBlock(text));
        } else {
            list.add(new CharBlock(text));
        }
    }
}
