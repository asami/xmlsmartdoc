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

package org.xmlsmartdoc.SmartDoc.latex2e;

import org.xmlsmartdoc.SmartDoc.*;

/**
 * LaTeX2eRefHandler
 *
 * @since   Jan. 31, 1999
 * @version Oct. 10, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public interface LaTeX2eRefHandler {
    public void setup(LaTeX2eConfig config);
    public LaTeX2ePackage[] getPackages();
    public String getLinkTarget(String anchor, String label);
    public String getSelfLinkFloat(String href, String prefix);
    public String getSelfLinkFloat(String href, String prefix, String label);
    public String getSelfLinkFloat(String href, String[] parts);
    public String getSelfLinkFloat(String href, String[] parts, String label);
    public String getSelfLinkTitle(String title);
    public String getSelfLinkTitle(String href, String title);
    public String getSelfLinkCite(String href);
    public String getSelfLinkCite(String href, String label);
    public String getHyperLink(String href);
    public String getHyperLink(String href, String label);
    public String getHyperLinkTitle(String href);
    public String getHyperLinkTitle(String href, String label);
}
