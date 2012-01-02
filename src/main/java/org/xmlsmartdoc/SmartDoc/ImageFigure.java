/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
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

import java.util.*;
import org.w3c.dom.Element;
import com.AsamiOffice.text.UString;

/**
 * ImageFigure
 *
 * @since   Sep. 23, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class ImageFigure extends Figure {
    protected String gifURL_;
    protected String jpegURL_;
    protected String psURL_;
    protected String srcURL_;

    public ImageFigure(Element element) {
	super(element);
	setGIFURL(UString.checkNull(element.getAttribute("gif")));
	setPSURL(UString.checkNull(element.getAttribute("ps")));
	setJPEGURL(UString.checkNull(element.getAttribute("jpeg")));
	setSrcURL(UString.checkNull(element.getAttribute("src")));
    }

    public int getEntityType() {
	return (ENTITY_BLOCK);
    }

    public void setGIFURL(String url) {
	gifURL_ = url;
    }

    public void setPSURL(String url) {
	psURL_ = url;
    }

    public void setJPEGURL(String url) {
	jpegURL_ = url;
    }

    public void setSrcURL(String url) {
	if (url == null) {
	    return;
	}
	StringTokenizer st = new StringTokenizer(url, " ,;"); // XXX
	while (st.hasMoreTokens()) {
	    String src = st.nextToken();
	    int index = src.lastIndexOf(".");
	    if (index != -1) {
		String suffix = src.substring(index + 1);
		if ("ps".equals(suffix)) {
		    setPSURL(src);
		} else if ("eps".equals(suffix)) {
		    setPSURL(src);
		} else if ("gif".equals(suffix)) {
		    setGIFURL(src);
		} else if ("jpeg".equals(suffix)) {
		    setJPEGURL(src);
		}
	    } else {
		srcURL_ = src;
	    }
	}
    }

    /**
     * @deprecated
     */
    public String getGIFURL() {
	return (gifURL_);
    }

    /**
     * @deprecated
     */
    public String getPSURL() {
	return (psURL_);
    }

    /**
     * @deprecated
     */
    public String getJPEGURL() {
	return (jpegURL_);
    }

    /**
     * @deprecated
     */
    public String getSrcURL() {
	return (srcURL_);
    }
}
