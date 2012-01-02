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

package org.xmlsmartdoc.SmartDoc.normalizer;

import java.util.*;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * LineNumberNormalizer
 *
 * @since   Aug. 11, 1999
 * @version Nov. 24, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class LineNumberNormalizer extends AbstractNormalizer {
    protected Content[] _normalize(
        Content[] contents,
        Content parent,
        DocContext context
    ) {
        List lines = new ArrayList();
        List chunks = new ArrayList();
        for (int i = 0; i < contents.length; i++) {
            Content content = contents[i];
            if (content instanceof CharBlock) {
                String text = content.getText();
                StringBuffer buffer = new StringBuffer();
                int size = text.length();
                for (int j = 0; j < size; j++) {
                    char c = text.charAt(j);
                    if (c == '\n') {
                        buffer.append(c);
                        chunks.add(new CharBlock(new String(buffer)));
                        lines.add(chunks);
                        chunks = new ArrayList();
                        buffer = new StringBuffer();
                    } else {
                        buffer.append(c);
                    }
                }
                if (buffer.length() > 0) {
                    chunks.add(new CharBlock(new String(buffer)));
                }
            } else {
                chunks.add(content);
            }
        }
        if (chunks.size() > 0) {
            lines.add(chunks);
        }
        int nLines = lines.size();
        int width = _displayWidth(nLines);
        List result = new ArrayList();
        for (int i = 0; i < nLines; i++) {
            result.add(new CharBlock(_makeNumber(i + 1, width)));
            chunks = (List)lines.get(i);
            int nChunks = chunks.size();
            for (int j = 0; j < nChunks; j++) {
                result.add(chunks.get(j));
            }
        }
        return (UDoc.list2Contents(result));
    }

    protected int _displayWidth(int number) {
        String text = Integer.toString(number);
        return (text.length());
    }

    private String _makeNumber(int number, int width) {
        String text = Integer.toString(number);
        int nSpaces = width - text.length();
        StringBuffer buffer = new StringBuffer();
        if (nSpaces > 0) {
            while (nSpaces-- > 0) {
                buffer.append(" ");
            }
        }
        buffer.append(text);
        buffer.append(": ");
        return (new String(buffer));
    }
}
