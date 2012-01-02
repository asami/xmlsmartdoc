/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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
 * Bibitem
 *
 * @since   Nov.  1, 1998
 * @version Oct. 15, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class Bibitem extends Container {
    protected String note_;
    protected String yomi_;
    protected String uri_;

    protected Bibitem(Element element, BibliographyDatabase bibDB) {
        super(element);
        if (sequenceNumber_ == null) {
            sequenceNumber_ = new SequenceNumber("bibitem");
        }
        if (idref_ == null) {
            String href = element.getAttribute("href");
            if (UString.notNull(href)) {
                if (href.startsWith("#")) {
                    idref_ = href.substring(1);
                }
            }
        }
        if (UString.notNull(idref_)) {
            if (bibDB != null) {
                Bibitem ref = bibDB.get(idref_);
                if (ref != null) {
                    UDoc.copyAttr(ref, this);
                    note_ = ref.note_;
                    yomi_ = ref.yomi_;
                    uri_ = ref.uri_;
                } else {
                    _warning("no bib item = " + idref_);
                }
            }
        }
        NodeList nodes = element.getChildNodes();
        int size = nodes.getLength();
        for (int i = 0;i < size;i++) {
            Node node = nodes.item(i);
            switch (node.getNodeType()) {

            case Node.ELEMENT_NODE:
                Element child = (Element)node;
                String tagName = child.getTagName();
                try {
                    if ("note".equals(tagName)) {
                        note_ = USmartDoc.getString(child);
                    } else if ("yomi".equals(tagName)) {
                        yomi_ = USmartDoc.getString(child);
                    } else if ("uri".equals(tagName)) {
                        uri_ = USmartDoc.getString(child);
                    }
                } catch (NumberFormatException e) {
                    // XXX : warning
                }
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

    protected Bibitem(Bibitem refItem) {
        //
        title_ = refItem.title_;
        idref_ = refItem.idref_;
        link_ = refItem.link_;        // XXX : deep copy?
        //
        note_ = refItem.note_;
        yomi_ = refItem.yomi_;
        uri_ = refItem.uri_;
    }

    // Content
    public int getEntityType() {
        return (ENTITY_BLOCK);
    }

    public String getNote() {
        return (note_);
    }

    public String getYomi() {
        return (yomi_);
    }

    public String getUri() {
        return (uri_);
    }

    //
    public static Bibitem getBibitem(Element element) {
        String tagName = element.getTagName();
        if ("book".equals(tagName)) {
            return (new Book(element));
        } else if ("journal".equals(tagName)) {
            return (new Journal(element));
        } else if ("article".equals(tagName)) {
            return (new Article(element));
        } else if ("misc".equals(tagName)) {
            return (new BibMisc(element));
        } else {
            USmartDoc.warning("bad tag : " + tagName);
            return (null);
        }
    }

    public static Bibitem getBibitem(
        Element element,
        BibliographyDatabase bibDB
    ) {
        String tagName = element.getTagName();
        if ("book".equals(tagName)) {
            return (new Book(element, bibDB));
        } else if ("journal".equals(tagName)) {
            return (new Journal(element, bibDB));
        } else if ("article".equals(tagName)) {
            return (new Article(element, bibDB));
        } else if ("misc".equals(tagName)) {
            return (new BibMisc(element, bibDB));
        } else {
            USmartDoc.warning("bad tag : " + tagName);
            return (null);
        }
    }
}
