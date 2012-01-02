/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2000  ASAMI, Tomoharu (asami@zeomtech.com)
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

package org.xmlsmartdoc.SmartDoc;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * SmartDocServlet
 *
 * @since   Jun. 27, 2000
 * @version Jul. 12, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class SmartDocServlet extends HttpServlet {
    public void doGet(
	HttpServletRequest req,
	HttpServletResponse res
    ) throws ServletException, IOException {
	doIt(req, res);
    }

    public void doPost(
	HttpServletRequest req,
	HttpServletResponse res
    ) throws ServletException, IOException {
	doIt(req, res);
    }

    public void doIt(
	HttpServletRequest req,
	HttpServletResponse res
    ) throws ServletException, IOException {
	try {
	    String uri = req.getParameter("source");
	    String encoding = req.getParameter("encoding");
	    if (encoding == null || "".equals(encoding)) {
		encoding = "UTF-8";
	    }
	    String format = req.getParameter("format");
	    if (format == null || "".equals(format)) {
		format = "html4";
	    }
	    SmartDocBeans sdoc = new SmartDocBeans();
	    sdoc.setEncoding(encoding);
	    sdoc.setFormat(format);
	    sdoc.setInputURI(uri);
	    String mimeType;
	    if ("html3".equals(format) || "html4".equals(format)) {
		mimeType = "text/html";
	    } else if ("plain".equals(format)) {
		mimeType = "text/plain";
	    } else {
		mimeType = "text/plain";
	    }
	    res.setContentType(mimeType + "; charset=" + encoding);
	    OutputStream out = res.getOutputStream();
	    out.write(sdoc.getTargetDocument());
	    out.close();
	} finally {
	}
    }
}
