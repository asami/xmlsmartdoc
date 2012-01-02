/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.plain;

import java.util.ArrayList;
import java.util.List;

import org.xmlsmartdoc.SmartDoc.USmartDoc;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.text.cui.CPanel;
import com.AsamiOffice.jaba2.text.cui.CParagraph;

import com.AsamiOffice.xml.UDOM;

/**
 * TextParagraph
 *
 * @since   Jul. 15, 1999
 * @version May.  6, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class TParagraph extends AbstractTElement {
    protected String[] gyotoKinsoku_ = {",",
                                        "\u3002"};
    protected String[] gyomatsuKinsoku_ = {"(",
                                           "[",
                                           "\uff3b",
                                           "\uff08"};
    private String indent_ = "  ";
    private boolean natural_ = false;

    public TParagraph() {
        super("tparagraph");
    }

    public String getText() {
        return (UDOM.getTextValue(this));
    }

    public final void setIndent(String indent) {
        indent_ = indent;
    }
    
    public final void setNatural(boolean natural) {
        natural_ = natural;
    }

    public void format(StringBuffer buffer) {
        int width = 70;                // XXX
        String[] chunks = _getChunks(getText());
        int indent = getTotalIndent();
        int cp = indent;        // XXX
        buffer.append("  ");        // XXX
        cp += 2;                // XXX
        for (int i = 0;i < chunks.length;i++) {
            String chunk = chunks[i];
            int length = UString.getHalfLength(chunk);
            if (_isGyotoKinsoku(chunk)) {
                buffer.append(chunk);
            } else if (_isGyomatsuKinsoku(chunk)) {
                if (cp + 1 > width) {
                    buffer.append("\n");
                    cp = 0;
                }
                buffer.append(chunk);
                cp += length;
            } else {
                if (cp + length >= width) {
                    buffer.append("\n");
                    cp = 0;
                }
                buffer.append(chunk);
                cp += length;
            }
        }
        buffer.append("\n");
    }

    public void format(CPanel node) {
        String text = getText();
        if (text == null) {
            return;
        }
        if ("".equals(text)) {
            return;
        }
        CParagraph p = new CParagraph(text, indent_);
        p.setNatural(natural_);
        node.append(p);
    }

    protected String[] _getChunks(String text) {
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
            } else if (USmartDoc.isWordSeparateLang(c)) {
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

    protected boolean _isGyotoKinsoku(String c) {
        for (int i = 0;i < gyotoKinsoku_.length;i++) {
            if (c.equals(gyotoKinsoku_[i])) {
                return (true);
            }
        }
        return (false);
    }

    protected boolean _isGyomatsuKinsoku(String c) {
        for (int i = 0;i < gyomatsuKinsoku_.length;i++) {
            if (c.equals(gyomatsuKinsoku_[i])) {
                return (true);
            }
        }
        return (false);
    }
}
