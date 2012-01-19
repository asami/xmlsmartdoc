/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2002  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import java.util.*;
import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.latex2e.*;

/**
 * HyperRefLaTeX2eRefHandler
 *
 * @since   Jan. 31, 1999
 *  version Mar. 22, 2002
 * @version Jan. 19, 2012
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class HyperRefLaTeX2eRefHandler implements LaTeX2eRefHandler {
    String[] options_;
    String aux_ = 
        "\\ifnum 42146=\\euc\"A4A2 \\AtBeginDvi{\\special{pdf:tounicode EUC-UCS2}}\\else\n" +
        " \\AtBeginDvi{\\special{pdf:tounicode 90ms-RKSJ-UCS2}}\\fi\n";

    public void setup(LaTeX2eConfig config) {
	List options = new ArrayList();
	if ("dvipdfm".equals(config.getDriver())) {
	    options.add("dvipdfm");
	}
	if (config.getSmartDocConfig().makeToc()) {
	    options.add("bookmarks=true");
	    options.add("bookmarksnumbered=true");
	    options.add("bookmarkstype=toc");
	}
	if (options.size() > 0) {
	    options_ = (String[])options.toArray(new String[options.size()]);
	}
    }

    public LaTeX2ePackage[] getPackages() {
	LaTeX2ePackage[] packages = new LaTeX2ePackage[1];
	if (options_ != null) {
	    packages[0] = new LaTeX2ePackage("hyperref", options_, aux_);
	} else {
	    packages[0] = new LaTeX2ePackage("hyperref");
	}
	return (packages);
    }

    public String getLinkTarget(String anchor, String label) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\hypertarget{hyperref");
//	buffer.append(ULaTeX2e.escapeHyperRef(anchor));
	buffer.append(anchor);
	buffer.append("}{");
	buffer.append(label);
	buffer.append("}");
	return (new String(buffer));
    }

    public String getSelfLinkFloat(String href, String prefix) {
	StringBuffer buffer = new StringBuffer();
	buffer.append(prefix);
	buffer.append("\\ref{");
	buffer.append(href);
	buffer.append("}");
	return (new String(buffer));
    }

    public String getSelfLinkFloat(String href, String prefix, String label) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\hyperlink{hyperref");
	buffer.append(href);
	buffer.append("}{");
	buffer.append(label);
	buffer.append("}");
	return (new String(buffer));
    }

    public String getSelfLinkFloat(String href, String[] parts) {
	StringBuffer buffer = new StringBuffer();
	if (parts[0] != null) {
	    buffer.append(parts[0]);
	}
	buffer.append("\\ref{");
	buffer.append(href);
	buffer.append("}");
	if (parts[1] != null) {
	    buffer.append(parts[1]);
	}
	return (new String(buffer));
    }

    public String getSelfLinkFloat(String href, String[] parts, String label) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\hyperlink{hyperref");
	buffer.append(href);
	buffer.append("}{");
	buffer.append(label);
	buffer.append("}");
	return (new String(buffer));
    }

    public String getSelfLinkTitle(String href) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\hyperlink{hyperref");
	buffer.append(href);
	buffer.append("}{");
	buffer.append(href);
	buffer.append("}");
	return (new String(buffer));
    }

    public String getSelfLinkTitle(String href, String label) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\hyperlink{hyperref");
	buffer.append(href);
	buffer.append("}{");
	buffer.append(label);
	buffer.append("}");
	return (new String(buffer));
    }

    public String getSelfLinkCite(String href) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\cite");
	buffer.append("{");
	buffer.append(href);
	buffer.append("}");
	return (new String(buffer));
    }

    public String getSelfLinkCite(String href, String label) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\cite");
	buffer.append("[");
	buffer.append(label);
	buffer.append("]");
	buffer.append("{");
	buffer.append(href);
	buffer.append("}");
	return (new String(buffer));
    }

    public String getHyperLink(String href) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\href{");
	buffer.append(href);
	buffer.append("}{");
	if (false) {
	    buffer.append("\\underline{");
	}
//	buffer.append(href);	// XXX : escape?
	buffer.append(ULaTeX2e.escapeHyperRef(href));
	if (false) {
	    buffer.append("}");
	}
	buffer.append("}");
	return (new String(buffer));
    }

    public String getHyperLink(String href, String label) {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\\href{");
	buffer.append(href);
	buffer.append("}{");
	if (false) {
	    buffer.append("\\underline{");
	}
	buffer.append(label);
	if (false) {
	    buffer.append("}");
	}
	buffer.append("}");
	return (new String(buffer));
    }

    public String getHyperLinkTitle(String href) {
	return (getHyperLink(href));
    }

    public String getHyperLinkTitle(String href, String label) {
	return (getHyperLink(href, label));
    }
}
