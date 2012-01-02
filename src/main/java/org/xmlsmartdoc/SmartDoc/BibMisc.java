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

package org.xmlsmartdoc.SmartDoc;

import java.util.*;
import org.w3c.dom.*;
import com.AsamiOffice.text.UString;

/**
 * BibMisc
 *
 * @since   Mar. 18, 2002
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class BibMisc extends Bibitem {
    protected List authors_ = new ArrayList();
    protected List editors_ = new ArrayList();
    protected String subtitle_;
    protected String howpublished_;
    protected String month_;
    protected String year_;

    public BibMisc(Element element) {
	super(element, null);
	_init(element);
    }

    public BibMisc(Element element, BibliographyDatabase bibDB) {
	super(element, bibDB);
	String idref = getIdref();
	if (UString.notNull(idref)) {
	    Bibitem ref = bibDB.get(idref);
	    if (ref != null) {
		if (ref instanceof BibMisc) {
		    BibMisc refBibMisc = (BibMisc)ref;
		    UDoc.copyAttr(refBibMisc, this);
		    authors_.addAll(refBibMisc.authors_);
		    editors_.addAll(refBibMisc.editors_);
		    subtitle_ = refBibMisc.subtitle_;
		    howpublished_ = refBibMisc.howpublished_;
		    month_ = refBibMisc.month_;
		    year_ = refBibMisc.year_;
		} else {
		    _warning("no misc = " + idref);
		}
	    } else {
		_warning("no misc = " + idref);
	    }
	}
	_init(element);
    }

    private void _init(Element element) {
	NodeList nodes = element.getChildNodes();
	int size = nodes.getLength();
	for (int i = 0;i < size;i++) {
	    Node node = nodes.item(i);
	    switch (node.getNodeType()) {

	    case Node.ELEMENT_NODE:
		Element child = (Element)node;
		String tagName = child.getTagName();
		try {
		    if ("author".equals(tagName)) {
			authors_.add(USmartDoc.getString(child));
		    } else if ("editor".equals(tagName)) {
			editors_.add(USmartDoc.getString(child));
		    } else if ("title".equals(tagName)) {
			setTitle(USmartDoc.getString(child));
		    } else if ("subtitle".equals(tagName)) {
			subtitle_ = USmartDoc.getString(child);
		    } else if ("howpublished".equals(tagName)) {
			howpublished_ = USmartDoc.getString(child);
		    } else if ("month".equals(tagName)) {
			month_ = USmartDoc.getString(child);
		    } else if ("year".equals(tagName)) {
			year_ = USmartDoc.getString(child);
//		    } else {
//			_warning("bad tag : " + tagName);
		    }
		} catch (NumberFormatException e) {
		    // XXX : warning
		}
		break;
	    case Node.TEXT_NODE:
	    case Node.ENTITY_REFERENCE_NODE:
	    case Node.COMMENT_NODE:
		// do nothing
		break;
	    default:
		throw (new InternalError("bad node type = " +
					 node.getNodeType())); // XXX : debug
	    }
	}
    }

    public String[] getAuthors() {
	int size = authors_.size();
	if (size == 0) {
	    return (null);
	}
	String[] authors = new String[size];
	return ((String[])authors_.toArray(authors));
    }

    public String[] getEditors() {
	int size = editors_.size();
	if (size == 0) {
	    return (null);
	}
	String[] editors = new String[size];
	return ((String[])editors_.toArray(editors));
    }

    public String getSubTitle() {
	return (subtitle_);
    }

    public String getHowpublished() {
	return (howpublished_);
    }

    public String getMonth() {
	return (month_);
    }

    public String getYear() {
	return (year_);
    }

    public String getUri() {
	return (uri_);
    }
}
