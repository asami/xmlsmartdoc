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

import org.xmlsmartdoc.SmartDoc.latex2e.*;

/**
 * PlainLaTeX2eRefHandler
 *
 * @since   Jan. 31, 1999
 * @version Oct. 10, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class PlainLaTeX2eRefHandler implements LaTeX2eRefHandler {
    public void setup(LaTeX2eConfig config) {
    }

    public LaTeX2ePackage[] getPackages() {
	return (null);
    }

    public String getLinkTarget(String anchor, String label) {
	return (label);
    }

    public String getSelfLinkFloat(String href, String prefix) {
	StringBuffer buffer = new StringBuffer();
	buffer.append(prefix);
	buffer.append("\\ref{");
	buffer.append(href);	// XXX : escape?
	buffer.append("}");
	return (new String(buffer));
    }

    public String getSelfLinkFloat(String href, String prefix, String label) {
	StringBuffer buffer = new StringBuffer();
	buffer.append(label);	// XXX : escape?
	buffer.append("[");
	buffer.append(prefix);	// XXX : escape?
	buffer.append("\\ref{");
	buffer.append(href);
	buffer.append("}");
	buffer.append("]");
	return (new String(buffer));
    }

    public String getSelfLinkFloat(String href, String[] parts) {
	StringBuffer buffer = new StringBuffer();
	if (parts[0] != null) {
	    buffer.append(parts[0]);
	}
	buffer.append("\\ref{");
	buffer.append(href);	// XXX : escape?
	buffer.append("}");
	if (parts[1] != null) {
	    buffer.append(parts[1]);
	}
	return (new String(buffer));
    }

    public String getSelfLinkFloat(String href, String[] parts, String label) {
	StringBuffer buffer = new StringBuffer();
	buffer.append(label);	// XXX : escape?
	buffer.append("[");
	if (parts[0] != null) {
	    buffer.append(parts[0]);
	}
	buffer.append("\\ref{");
	buffer.append(href);
	buffer.append("}");
	if (parts[1] != null) {
	    buffer.append(parts[1]);
	}
	buffer.append("]");
	return (new String(buffer));
    }

    public String getSelfLinkTitle(String href) {
	return (href);
    }

    public String getSelfLinkTitle(String href, String label) {
	return (label);
    }

    public String getSelfLinkCite(String href) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\cite");
	buffer.append("{");
	buffer.append(href);	// XXX : escape?
	buffer.append("}");
	return (new String(buffer));
    }

    public String getSelfLinkCite(String href, String label) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\cite");
	buffer.append("[");
	buffer.append(label);	// XXX : escape?
	buffer.append("]");
	buffer.append("{");
	buffer.append(href);	// XXX : escape?
	buffer.append("}");
	return (new String(buffer));
    }

    public String getHyperLink(String href) {
	StringBuffer buffer = new StringBuffer();
	if (false) {
	    buffer.append("\\underline{");
	}
//	buffer.append(href);	// XXX : escape?
	buffer.append(ULaTeX2e.escape(href));
	if (false) {
	    buffer.append("}");
	}
	return (new String(buffer));
    }

    public String getHyperLink(String href, String label) {
	StringBuffer buffer = new StringBuffer();
	buffer.append(label);	// XXX : escape?
	buffer.append("\\footnote{");
	if (false) {
	    buffer.append("\\underline{");
	}
//	buffer.append(href);	// XXX : escape?
	buffer.append(ULaTeX2e.escape(href));
	if (false) {
	    buffer.append("}");
	}
	buffer.append("}");
	return (new String(buffer));
    }

    public String getHyperLinkTitle(String href) {
	StringBuffer buffer = new StringBuffer();
	if (false) {
	    buffer.append("\\underline{");
	}
	buffer.append(ULaTeX2e.escape(href));
	if (false) {
	    buffer.append("}");
	}
	return (new String(buffer));
    }

    public String getHyperLinkTitle(String href, String label) {
	StringBuffer buffer = new StringBuffer();
	buffer.append(ULaTeX2e.escape(label));
	buffer.append("[");
	if (false) {
	    buffer.append("\\underline{");
	}
	buffer.append(ULaTeX2e.escape(href));
	if (false) {
	    buffer.append("}");
	}
	buffer.append("]");
	return (new String(buffer));
    }
}
