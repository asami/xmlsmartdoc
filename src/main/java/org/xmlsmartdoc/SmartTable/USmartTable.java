/*
 * SmartTable
 *  Copyright (C) 1999-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartTable;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.AsamiOffice.text.UString;

import com.AsamiOffice.xml.UXML;

/**
 * USmartTable
 *
 * @since   Aug.  1, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public final class USmartTable {
    public static boolean isXMLFile(URL url) {
        try {
            String suffix = UString.getSuffix(url.toExternalForm());
            if (suffix == null) {
                return (false);
            }
            if (suffix.equals("xml")) {
                return (true);
            }
            return (UXML.hasXMLDeclaration(url));
        } catch (IOException e) {
            return (false);
        }
    }

    public static boolean isCSVFile(URL url) {
        String suffix = UString.getSuffix(url.toExternalForm());
        return ("csv".equals(suffix));
    }

    public static boolean isJDBCFile(URL url) {
        return ("jdbc".equals(url.getProtocol()));
    }

    public static void addList(List list, Object data) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == null) {
                list.set(i, data);
                return;
            }
        }
        list.add(data);
    }
}
