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
 * Book
 *
 * @since   Nov.  3, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class Book extends Bibitem {
    protected List authors_ = new ArrayList();
    protected List editors_ = new ArrayList();
    protected String subtitle_;
    protected String edition_;
    protected String publisher_;
    protected String year_;

    public Book(Element element) {
	super(element, null);
	_init(element);
    }

    public Book(Element element, BibliographyDatabase bibDB) {
	super(element, bibDB);
	String idref = getIdref();
	if (UString.notNull(idref)) {
	    Bibitem ref = bibDB.get(idref);
	    if (ref != null) {
		if (ref instanceof Book) {
		    Book refBook = (Book)ref;
		    authors_.addAll(refBook.authors_);
		    editors_.addAll(refBook.editors_);
		    subtitle_ = refBook.subtitle_;
		    edition_ = refBook.edition_;
		    publisher_ = refBook.publisher_;
		    year_ = refBook.year_;
		} else {
		    _warning("no book = " + idref);
		}
	    } else {
		_warning("no book = " + idref);
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
		    } else if ("edition".equals(tagName)) {
//			edition_ = Integer.parseInt(
//			    USmartDoc.getString(child));
			edition_ = USmartDoc.getString(child);
		    } else if ("publisher".equals(tagName)) {
			publisher_ = USmartDoc.getString(child);
		    } else if ("year".equals(tagName)) {
//			year_ = Integer.parseInt(USmartDoc.getString(child));
			year_ = USmartDoc.getString(child);
		    } else if ("a".equals(tagName)) {
			uri_ = child.getAttribute("href");
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

    public String getEdition() {
	return (edition_);
    }

    public String getPublisher() {
	return (publisher_);
    }

    public String getYear() {
	return (year_);
    }
}
