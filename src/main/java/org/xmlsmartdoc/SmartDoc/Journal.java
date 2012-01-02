/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.AsamiOffice.text.UString;

/**
 * Journal
 *
 * @since   Nov.  3, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class Journal extends Bibitem {
    protected String year_;
    protected String month_;
    protected String volume_;
    protected String number_;
    protected String publisher_;

    public Journal(Element element) {
	super(element, null);
	_init(element);
    }

    public Journal(Element element, BibliographyDatabase bibDB) {
	super(element, bibDB);
	String idref = getIdref();
	if (UString.notNull(idref)) {
	    Bibitem ref = bibDB.get(idref);
	    if (ref != null) {
		if (ref instanceof Journal) {
		    Journal refJournal = (Journal)ref;
		    year_ = refJournal.year_;
		    month_ = refJournal.month_;
		    volume_ = refJournal.volume_;
		    number_ = refJournal.number_;
		    publisher_ = refJournal.publisher_;
		} else {
		    throw (new InternalError()); // XXX
		}
	    } else {
		_warning("no journal = " + idref);
	    }
	}
	_init(element);
    }

    public Journal(Journal refJournal) {
	super(refJournal);
	year_ = refJournal.year_;
	month_ = refJournal.month_;
	volume_ = refJournal.volume_;
	number_ = refJournal.number_;
	publisher_ = refJournal.publisher_;
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
		if ("title".equals(tagName)) {
		    setTitle(USmartDoc.getString(child));
		} else if ("year".equals(tagName)) {
		    year_ = USmartDoc.getString(child);
		} else if ("month".equals(tagName)) {
		    month_ = USmartDoc.getString(child);
		} else if ("volume".equals(tagName)) {
		    volume_ = USmartDoc.getString(child);
		} else if ("number".equals(tagName)) {
		    number_ = USmartDoc.getString(child);
		} else if ("publisher".equals(tagName)) {
		    publisher_ = USmartDoc.getString(child);
		} else if ("a".equals(tagName)) { // XXX
		    uri_ = child.getAttribute("href");
//		} else {
//		    _warning("bad tag : " + tagName);
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

    public String getTitle() {
	String title = super.getTitle();
	if (title != null) {
	    return (title);
	}
	Journal ref = getRefJournal();
	if (ref != null) {
	    return (ref.getTitle());
	}
	return (null);
    }

    public String getPublisher() {
	if (publisher_ != null) {
	    return (publisher_);
	}
	Journal ref = getRefJournal();
	if (ref != null) {
	    return (ref.getPublisher());
	}
	return (null);
    }

    public String getYear() {
	if (year_ != null) {
	    return (year_);
	}
	Journal ref = getRefJournal();
	if (ref != null) {
	    return (ref.getYear());
	}
	return (null);
    }

    public String getMonth() {
	if (month_ != null) {
	    return (month_);
	}
	Journal ref = getRefJournal();
	if (ref != null) {
	    return (ref.getMonth());
	}
	return (null);
    }

    public String getVolume() {
	if (volume_ != null) {
	    return (volume_);
	}
	Journal ref = getRefJournal();
	if (ref != null) {
	    return (ref.getVolume());
	}
	return (null);
    }

    public String getNumber() {
	if (number_ != null) {
	    return (number_);
	}
	Journal ref = getRefJournal();
	if (ref != null) {
	    return (ref.getNumber());
	}
	return (null);
    }

    public Journal getRefJournal() {
	return ((Journal)getLink());
    }
}
