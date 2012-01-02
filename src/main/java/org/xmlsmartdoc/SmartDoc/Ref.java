/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2005  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import org.w3c.dom.*;
import com.AsamiOffice.text.UString;

/**
 * Ref
 * 
 * @since Oct. 25, 1998
 * @version Jun. 10, 2005
 * @author ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class Ref extends Container {
    public static final int SELF_LINK = 1;
    public static final int HYPER_LINK = 2;
    public static final int SITE_LINK = 3;
    public static final int UNKNOWN_LINK = -1;

    protected int type_;
    protected String href_;
    protected String labelPrefix_;
    protected String labelSuffix_;
    protected String documentV12Href_;

    public Ref(Element element) {
        super(element);
        String href = UString.checkNull(element.getAttribute("href"));
        if (href != null) {
            setHref(href);
        } else if (idref_ != null) {
            setSelfLink(idref_);
        } else {
            type_ = UNKNOWN_LINK;
        }
        Attr prefixAttr = element.getAttributeNode("label.prefix");
        if (prefixAttr == null) {
            labelPrefix_ = null;
        } else {
            labelPrefix_ = prefixAttr.getValue();
        }
        Attr suffixAttr = element.getAttributeNode("label.suffix");
        if (suffixAttr == null) {
            labelSuffix_ = null;
        } else {
            labelSuffix_ = suffixAttr.getValue();
        }
        documentV12Href_ = getAttributeString_(element, "document-v12.href");
    }

    private String getAttributeString_(Element element, String name) {
        Attr suffixAttr = element.getAttributeNode(name);
        if (suffixAttr == null) {
            return null;
        } else {
            return suffixAttr.getValue();
        }
    }

    public Ref(String href) {
        setHref(href);
    }

    public Ref(Content content) {
        setLink(content);
    }

    // Content
    public int getEntityType() {
        return (ENTITY_INLINE);
    }

    public void setHref(String href) {
        if (href.charAt(0) == '#') {
            setSelfLink(href.substring(1)); // XXX : modify
        } else if (href.startsWith("site:")) {
            setSiteLink(href.substring("site:".length()));
        } else {
            setHyperLink(href);
        }
    }

    public void setSelfLink(String idref) {
        type_ = SELF_LINK;
        href_ = idref;
    }

    public void setHyperLink(String href) {
        type_ = HYPER_LINK;
        href_ = href;
    }
    
    public void setSiteLink(String href) {
        type_ = SITE_LINK;
        href_ = href;
    }

    public void setLink(Content link) {
        super.setLink(link);
        //	href_ = "#" + link.getID(); XXX : really ok
        href_ = link.getID();
        type_ = SELF_LINK;
    }

    public int getType() {
        return (type_);
    }

    public String getHref() {
        return (href_);
    }

    public String getLabelPrefix() {
        return (labelPrefix_);
    }

    public String getLabelSuffix() {
        return (labelSuffix_);
    }
    
    public String getDocumentV12Href() {
        return documentV12Href_;
    }
}