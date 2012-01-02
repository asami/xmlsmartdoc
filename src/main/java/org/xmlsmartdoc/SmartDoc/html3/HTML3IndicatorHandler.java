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

package org.xmlsmartdoc.SmartDoc.html3;

import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.xhtml.*;

/**
 * HTML3IndicatorHandler
 *
 * @since   Sep. 28, 1999
 * @version Sep. 28, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class HTML3IndicatorHandler implements IXHTMLIndicatorHandler {
    public String getTopIndicator(
	Pointer current,
	Pointer[] path,
	Pointer prev,
	Pointer next
    ) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("<div align=\"center\">\n");
	_getIndicator(current, path, prev, next, buffer);
	buffer.append("</div>\n");
	return (new String(buffer));
    }

    public String getBottomIndicator(
	Pointer current,
	Pointer[] path,
	Pointer prev,
	Pointer next
    ) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("<div align=\"center\">\n");
	_getIndicator(current, path, prev, next, buffer);
	buffer.append("</div>\n");
	return (new String(buffer));
    }

    protected void _getIndicator(
	Pointer current,
	Pointer[] path,
	Pointer prev,
	Pointer next,
	StringBuffer buffer
    ) {
	buffer.append("<table border=\"1\">\n");
	buffer.append("<tr>\n");
	buffer.append("<td>");
	if (prev != null) {
	    embedRefTag(
		prev,
		"&lt;&lt;",
		buffer
	    );
	}
	buffer.append("</td>\n");
	buffer.append("<td>");
	if (path.length > 0) {
	    if (path.length == 1) {
		buffer.append(path[0].title);
	    } else {
		embedRefTag(path[0], path[0].title, buffer);
	    }
	    for (int i = 1;i < path.length;i++) {
		buffer.append("/");
		if (path.length == i + 1) {
		    buffer.append(path[i].title);
		} else {
		    embedRefTag(path[i], path[i].title, buffer);
		}
	    }
	}
	buffer.append("</td>\n");
	buffer.append("<td>");
	if (next != null) {
	    embedRefTag(
		next,
		"&gt;&gt;",
		buffer
	    );
	}
	buffer.append("</td>\n");
	buffer.append("</tr>\n");
	buffer.append("</table>\n");
    }

    public static void embedRefTag(Pointer pointer, StringBuffer buffer) {
	embedRefTag(pointer, pointer.title, buffer);
    }

    public static void embedRefTag(
	Pointer pointer,
	String title,
	StringBuffer buffer
    ) {
	buffer.append(pointer.prologue);
	buffer.append(title);
	buffer.append(pointer.epilogue);
    }
}
