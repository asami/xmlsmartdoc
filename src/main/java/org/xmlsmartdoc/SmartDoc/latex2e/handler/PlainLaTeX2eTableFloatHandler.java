/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2001  ASAMI, Tomoharu (asami@zeomtech.com)
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

package org.xmlsmartdoc.SmartDoc.latex2e.handler;

import com.AsamiOffice.jaba2.j2fw.generator.*;
import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.latex2e.*;

/**
 * PlainLaTeX2eTableFloatHandler
 *
 * @since   Mar. 10, 2001
 * @version Mar.  6, 2006
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class PlainLaTeX2eTableFloatHandler
    implements LaTeX2eTableFloatHandler {

    // LaTeX2eTableFloatHandler
    public String[] getPackages() {
        return (null);
    }

    // LaTeX2eTableFloatHandler
    public String getBegin(Table table, String loc) {
        String value = table.getAttribute("latex2e.floatable");
//        System.out.println("latex2e.floatable = " + value);
        if ("false".equals(value)) {
            loc = "!ht";
        }
        return "\\begin{table}[" + loc + "]\n" + "\\begin{center}\n";
    }

    // LaTeX2eTableFloatHandler
    public String getEnd(Table table) {
        return "\\end{center}\n" + "\\end{table}\n";
    }
}
