/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import java.io.File;
import java.io.IOException;

import com.AsamiOffice.io.UIO;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.D2Array;

/**
 * SpaceTable
 *
 * @since   May. 25, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SpaceTable extends AbstractTable {
    public SpaceTable(String text) {
        super(parseTable(text));
    }

    public SpaceTable(File file) throws IOException {
        super(parseTable(file));
    }

    public static D2Array parseTable(File file) throws IOException {
        return (parseTable(UIO.file2String(file)));
    }

    public static D2Array parseTable(String text) {
        D2Array data = new D2Array();
        String[] list = UString.makeStringListFromString(text);
        for (int y = 0; y < list.length; y++) {
            String[] line = UString.makeStringListFromSpaceLine(list[y]);
            for (int x = 0; x < line.length; x++) {
                data.put(x, y, line[x]);
            }
        }
        return (data);
    }
}
