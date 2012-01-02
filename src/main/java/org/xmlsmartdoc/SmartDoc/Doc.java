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

/**
 * Doc
 *
 * @since   Sep. 19, 1998
 * @version Jan. 27, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class Doc extends Container {
//    protected DocContext context_;
    protected Macro macro_;
    protected Head head_;
    protected Body body_;
    protected TOC toc_;
    protected Indexdef indexdef_; // XXX
    protected Glossary glossary_; // XXX
    protected Bibliography bib_; // XXX

//    public void setDocContext(DocContext context) {
//	context_ = context;
//    }

    public int getEntityType() {
	return (ENTITY_CONTAINER);
    }

    public void setMacro(Macro macro) {
	macro_ = macro;
	addContent(macro);
    }

    public void setHead(Head head) {
	head_ = head;
	addContent(head);
    }

    public void setBody(Body body) {
	body_ = body;
	addContent(body);
    }

    public void setTOC(TOC toc) {
	if (toc == null) {
	    return;
	}
	toc_ = toc;
	addContent(toc);
    }

    public void setIndexdef(Indexdef indexdef) {
	if (indexdef == null) {
	    return;
	}
	indexdef_ = indexdef;
	addContent(indexdef);
    }

    public void setGlossary(Glossary glossary) {
	if (glossary == null) {
	    return;
	}
	glossary_ = glossary;
	addContent(glossary);
    }

    public void setBibliography(Bibliography bib) {
	if (bib == null) {
	    return;
	}
	bib_ = bib;
	addContent(bib);
    }

    public Head getHead() {
	return (head_);
    }

    public Body getBody() {
	return (body_);
    }

    public TOC getTOC() {
	return (toc_);
    }

    public Indexdef getIndexdef() {
	return (indexdef_);
    }

    public Glossary getGlossary() {
	return (glossary_);
    }

    public Bibliography getBibliography() {
	return (bib_);
    }

    // Content
    /**
     * Doc is root node.
     */
    public Doc getDoc() {
	return (this);
    }

    // Content
    /**
     * Doc is root node.
     */
//    public DocContext getDocContext() {
//	return (context_);
//    }

    // Content
    /**
     * Doc is root node.
     */
    public String getLanguage() {
	return (lang_);
    }

    // Content
    /**
     * Doc is root node.
     */
    public String getSpace() {
	return (space_);
    }

    // Content
    /**
     * Doc is root node.
     */
    public Locale getLocale() {
	return (locale_);
    }
}
