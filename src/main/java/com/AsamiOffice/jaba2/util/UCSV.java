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

package com.AsamiOffice.jaba2.util;

import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.D2Array;

/**
 * UCSV
 *
 * @since   Jul. 30, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public final class UCSV {
    public static String data2CSV(D2Array data) {
        int height = data.getHeight();
        int width = data.getWidth();
        StringBuffer buffer = new StringBuffer();
        for (int y = 0; y < height; y++) {
            if (width > 0) {
                _makeCell(data.get(0, y).toString(), buffer);
                for (int x = 1; x < width; x++) {
                    buffer.append(",");
                    _makeCell(data.get(x, y).toString(), buffer);
                }
            }
            buffer.append("\n");
        }
        return (new String(buffer));
    }

    protected static void _makeCell(String data, StringBuffer buffer) {
        if (data.indexOf(",") != -1) {
            buffer.append("\"");
            buffer.append(data);
            buffer.append("\"");
        } else {
            buffer.append(data);
        }
    }

    public static D2Array csv2Data(String csv) {
        D2Array d2 = new D2Array();
        String[] rows = UString.makeStringListFromString(csv);
        for (int y = 0; y < rows.length; y++) {
            String[] columns = UString.makeStringListFromCSVLine(rows[y]);
            for (int x = 0; x < columns.length; x++) {
                d2.put(x, y, columns[x]);
            }
        }
        return (d2);
    }
}
