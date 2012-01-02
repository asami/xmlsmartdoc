/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998,1999  ASAMI, Tomoharu (tasami@ibm.net)
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

import org.xmlsmartdoc.SmartDoc.latex2e.*;

/**
 * PlainLaTeX2eTableHandler
 *
 * @since   Nov.  2, 1998
 * @version Jun. 28, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class PlainLaTeX2eTableHandler implements LaTeX2eTableHandler {
    public String[] getPackages() {
	return (null);
    }

    public String getPreamble() {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\n");
	buffer.append("\\def\\LEFTLINE{\\vrule width 1pt}\n");
	buffer.append("\\def\\RIGHTLINE{\\vrule width 1pt}\n");
	buffer.append("\\def\\VLINE{\\vrule width 1pt}\n");
	buffer.append("\\def\\HLINE{\\noalign{\\hrule height 1pt}}\n");
	buffer.append("\n");
	return (new String(buffer));
    }

    public String getLeftBorderLine() {
	return ("@{\\LEFTLINE}");
    }

    public String getRightBorderLine() {
	return ("@{\\RIGHTLINE}");
    }

    public String getTopBorderLine() {
	return ("\\HLINE ");
    }

    public String getBottomBorderLine() {
	return ("\\HLINE ");
    }

    public String getThinVLine() {
	return ("|");
    }

    public String getThickVLine() {
	return ("@{\\VLINE}");
    }

    public String getThinHLine() {
	return ("\\hline ");
    }

    public String getThickHLine() {
	return ("\\HLINE ");
    }
}
