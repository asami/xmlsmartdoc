/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
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

import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.text.cui.*;

/**
 * UPlain
 *
 * @since   Aug. 11, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 */
public final class UPlain {
    public static String makeScreen(TNode node) {
        node.normalize();
        CPanel root = new CPanel();
        node.format(root);
        CBoardBase screen = new CBoardBase();
        root.layout(70); // XXX
        root.draw(screen);
        return (screen.makeScreen());
    }

    public static void makeScreen(TNode node, StringBuffer buffer) {
        CPanel root = new CPanel();
        node.format(root);
        CBoardBase screen = new CBoardBase();
        root.layout(70); // XXX
        root.draw(screen);
        screen.makeScreen(buffer);
    }

    // XXX
    public static void printTNode(TNode node, StringBuffer buffer) {
        node.format(buffer);
    }

    public static void printCenterWithNL(
        String text,
        int width,
        StringBuffer buffer) {
        int length = UString.getHalfLength(text);
        int left = (width / 2) - (length / 2);
        while (left-- > 0) {
            buffer.append(" ");
        }
        buffer.append(text);
        buffer.append("\n");
    }
}
