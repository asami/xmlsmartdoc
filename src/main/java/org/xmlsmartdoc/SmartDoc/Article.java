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

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.AsamiOffice.text.UString;

/**
 * Article
 *
 * @since   Nov.  3, 1998
 * @version Oct. 15, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class Article extends Bibitem {
    protected List authors_ = new ArrayList();
    protected String subtitle_;
    protected String pages_;
    protected Journal journal_;

    public Article(Element element) {
        super(element, null);
        _init(element);
    }

    public Article(Element element, BibliographyDatabase bibDB) {
        super(element, bibDB);
        String idref = getIdref();
        if (UString.notNull(idref)) {
            Bibitem ref = bibDB.get(idref);
            if (ref != null) {
                if (ref instanceof Article) {
                    Article refArticle = (Article)ref;
                    authors_.addAll(refArticle.authors_);
                    subtitle_ = refArticle.subtitle_;
                    pages_ = refArticle.pages_;
                    if (refArticle.journal_ != null) {
                        journal_ = new Journal(refArticle.journal_);
                        addContent(journal_);
                    }
                } else {
                    throw (new InternalError()); // XXX
                }
            } else {
                _warning("no article = " + idref);
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
                if ("author".equals(tagName)) {
                    authors_.add(USmartDoc.getString(child));
                } else if ("title".equals(tagName)) {
                    setTitle(USmartDoc.getString(child));
                } else if ("subtitle".equals(tagName)) {
                    subtitle_ = USmartDoc.getString(child);
                } else if ("journal".equals(tagName)) {
                    journal_ = new Journal(child);
                    addContent(journal_);
                } else if ("pages".equals(tagName)) {
                    pages_ = USmartDoc.getString(child);
                } else if ("a".equals(tagName)) { // XXX
                    uri_ = child.getAttribute("href");
//                } else {
//                    _warning("bad tag : " + tagName);
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
        String[] authors = new String[authors_.size()];
        return ((String[])authors_.toArray(authors));
    }

    public String getSubTitle() {
        return (subtitle_);
    }

    public String getPages() {
        return (pages_);
    }

    public Journal getJournal() {
        return (journal_);
    }
}
