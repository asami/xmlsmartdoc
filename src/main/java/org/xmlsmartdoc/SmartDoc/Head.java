/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998,1999  ASAMI, Tomoharu (asami@zeomtech.com)
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

/**
 * Head
 *
 * @since   Sep. 19, 1998
 * @version May. 25, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class Head extends Container {
    protected Title docTitle_;
    protected Title docSubTitle_;
    protected String author_;
    protected List authors_ = new ArrayList();
    protected String org_;
    protected DocDate date_;
    protected String email_;
    protected String hp_;
    protected Summary summary_;
    protected Header header_;
    protected Footer footer_;
    protected Prologue prologue_;
    protected Indexdef indexdef_;
    protected Native native_;

    public Head() {
    }

    public Head(Element element) {
	super(element);
    }

    // Content
    public int getEntityType() {
	return (ENTITY_CONTAINER);
    }

    // Container
    public void format() {
	super.format();
	int size = contents_.size();
	for (int i = 0;i < size;i++) {
	    Content content = (Content)contents_.get(i);
	    if (content instanceof Generic) {
		Generic generic = (Generic)content;
		String name = generic.getName();
		if ("subtitle".equals(name)) {
		    Title title = new Title(UDoc.distillText(generic));
		    setDocSubTitle(title);
//		} else if ("author".equals(name)) {
//		    addAuthor(generic);
//		    setAuthor(UDoc.distillText(generic));
		} else if ("org".equals(name)) {
		    setOrg(UDoc.distillText(generic));
		} else if ("hp".equals(name)) {
		    setHP(UDoc.distillText(generic));
		} else if ("email".equals(name)) {
		    setEMail(UDoc.distillText(generic));
		} else {
		    throw (new InternalError("bad name : " + name));
		}
	    } else if (content instanceof Title) {
		setDocTitle((Title)content);
	    } else if (content instanceof DocAuthor) {
		DocAuthor author = (DocAuthor)content;
		addAuthor(author);
		setAuthor(UDoc.distillText(author));
	    } else if (content instanceof DocDate) {
		setDate((DocDate)content);
	    } else if (content instanceof Summary) {
		setSummary((Summary)content);
	    } else if (content instanceof Header) {
		setHeader((Header)content);
	    } else if (content instanceof Footer) {
		setFooter((Footer)content);
	    } else if (content instanceof Prologue) {
		setPrologue((Prologue)content);
	    } else if (content instanceof Indexdef) {
		setIndexdef((Indexdef)content);
	    } else if (content instanceof Native) {
		setNative((Native)content);
	    } else if (content instanceof CharBlock) {
		// do nothing
	    } else {
		throw (new InternalError("bad tag : " + content));
	    }
	}
    }

    public void setDocTitle(String title) {
	docTitle_ = new Title(title);
    }

    public void setDocTitle(Title title) {
	docTitle_ = title;
    }

    public void setDocSubTitle(Title title) {
	docSubTitle_ = title;
    }

    public void setAuthor(String author) {
	author_ = author;
    }

    public void addAuthor(DocAuthor author) {
	authors_.add(author);
    }

    public void setOrg(String org) {
	org_ = org;
    }

    public void setDate() {
	date_ = new DocDate();
    }

    public void setDate(DocDate date) {
	date_ = date;
    }

    public void setEMail(String email) {
	email_ = email;
    }

    public void setHP(String hp) {
	hp_ = hp;
    }

    public void setSummary(Summary summary) {
	summary_ = summary;
    }

    public void setHeader(Header header) {
	header_ = header;
    }

    public void setFooter(Footer footer) {
	footer_ = footer;
    }

    public void setPrologue(Prologue prologue) {
	prologue_ = prologue;
    }

    public void setIndexdef(Indexdef indexdef) {
	indexdef_ = indexdef;
    }

    public void setNative(Native nativeValue) {
	native_ = nativeValue;
    }

    public Title getDocTitle() {
	return (docTitle_);
    }

    public Title getDocSubTitle() {
	return (docSubTitle_);
    }

    public String getAuthor() {
	return (author_);
    }

    public DocAuthor[] getAuthors() {
	DocAuthor[] result = new DocAuthor[authors_.size()];
	return ((DocAuthor[])authors_.toArray(result));
    }

    public String getOrg() {
	return (org_);
    }

    public boolean getPreOrg() {
	return (false);
    }

    public DocDate getDate() {
	return (date_);
    }

    public String getEMail() {
	return (email_);
    }

    public String getHP() {
	return (hp_);
    }

    public Summary getSummary() {
	return (summary_);
    }

    public Header getHeader() {
	return (header_);
    }

    public Footer getFooter() {
	return (footer_);
    }

    public Prologue getPrologue() {
	return (prologue_);
    }

    public Indexdef getIndexdef() {
	return (indexdef_);
    }

    public Native getNative() {
	return (native_);
    }
}
