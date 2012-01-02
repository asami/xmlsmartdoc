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
import org.w3c.dom.*;
import com.AsamiOffice.text.UString;

/**
 * Container
 *
 * @since   Sep. 19, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public abstract class Container extends Content {
    protected List contents_ = new ArrayList();
    protected IAdapter adapter_;
    protected String adapterParam_;
    protected INormalizer[] normalizers_;
    protected TOCNode root_ = null;

    protected Container() {
	super();
	adapter_ = AdapterFactory.getFactory().getDefaultAdapter(this);
	normalizers_
	    = NormalizerFactory.getFactory().getDefaultNormalizers(this);
    }

    protected Container(Element element) {
	super(element);
	String adapterName = UString.checkNull(
	    element.getAttribute("adapter")
	);
	if (adapterName != null) {
	    adapter_ = AdapterFactory.getFactory().getAdapter(adapterName);
	} else {
	    adapter_ = AdapterFactory.getFactory().getDefaultAdapter(this);
	}
	adapterParam_ = UString.checkNull(element.getAttribute("aparam"));
	String normalizerName = UString.checkNull(
	    element.getAttribute("normalizer")
	);
	NormalizerFactory factory = NormalizerFactory.getFactory();
	if (normalizerName != null) {
	    String[] names = UString.getTokens(normalizerName, " ,");
	    normalizers_ = factory.getNormalizers(names);
	} else {
	    normalizers_ = factory.getDefaultNormalizers(this);
	}
    }

    public void setAttribute(String name, String value) {
	super.setAttribute(name, value);
	if ("adapter".equals(name)) {
	    adapter_ = AdapterFactory.getFactory().getAdapter(value);
	} else if ("normalizer".equals(name)) {
	    String[] names = UString.getTokens(value, " ,");
	    normalizers_
		= NormalizerFactory.getFactory().getNormalizers(names);
	}
    }

    // Content
    public Content deepClone() {
	Container cloned = (Container)super.deepClone();
	Content[] contents = getContents();
	cloned.contents_ = new ArrayList();
	cloned.addContents(contents);
	return (cloned);
    }

    // Content
    public Content[] expand(DocContext context) {
	try {
	    Content[] contents = getContents();
	    contents_.clear();
	    for (int i = 0;i < contents.length;i++) {
		try {
		    Content[] expanded = contents[i].expand(context);
		    if (expanded != null) {
			for (int j = 0;j < expanded.length;j++) {
			    addContent(expanded[j]);
			}
		    }
		} catch (SmartDocWarningException e) {
		    // content that causes exception is removed
		}
	    }
	    if (srcList_ == null) {
		return (new Content[] {this});
	    }
	    if (adapter_ != null) {
		adapter_.expand(srcList_, adapterParam_, this, context);
	    }
	} catch (SmartDocWarningException e) {
	}
	return (new Content[] {this});
    }

    // Content
    public Content[] metaEval(DocContext context) {
	try {
	    Content[] contents = getContents();
	    contents_.clear();
	    for (int i = 0;i < contents.length;i++) {
		try {
		    Content[] result = contents[i].metaEval(context);
		    if (result != null) {
			for (int j = 0;j < result.length;j++) {
			    addContent(result[j]);
			}
		    }
		} catch (SmartDocWarningException e) {
		    // content that causes exception is removed
		}
	    }
	} catch (SmartDocWarningException e) {
	}
	return (new Content[] {this});
    }

    // Content
    public Content[] macroExpand(DocContext context) {
	try {
	    Content[] contents = getContents();
	    contents_.clear();
	    for (int i = 0;i < contents.length;i++) {
		try {
		    Content[] expanded = contents[i].macroExpand(context);
		    if (expanded != null) {
			for (int j = 0;j < expanded.length;j++) {
			    addContent(expanded[j]);
			}
		    }
		} catch (SmartDocWarningException e) {
		    // content that causes exception is removed
		}
	    }
	} catch (SmartDocWarningException e) {
	}
	return (new Content[] {this});
    }

    // Content
    public Content[] normalize(DocContext context) {
	try {
	    Content[] contents = getContents();
	    contents_.clear();
	    for (int i = 0;i < contents.length;i++) {
		try {
		    Content[] normalized = contents[i].normalize(context);
		    if (normalized != null) {
			for (int j = 0;j < normalized.length;j++) {
			    addContent(normalized[j]);
			}
		    }
		} catch (SmartDocWarningException e) {
		    // content that causes exception is removed
		}
	    }
	    if (normalizers_ != null) {
		for (int i = 0;i < normalizers_.length;i++) {
		    normalizers_[i].normalize(this, context);
		}
	    }
	    if ("preserve".equals(getSpace())) {
		for (int i = 0;i < contents.length;i++) {
		    Content child = contents[i];
		    if (child instanceof CharBlock) {
			CharBlock chars = (CharBlock)child;
			chars.setPreserve(true);
		    }
		}
	    }
	} catch (SmartDocWarningException e) {
	}
	return (new Content[] {this});
    }

    // Content
    public Content[] eval(DocContext context) {
	try {
	    if (super.eval(context) == null) {
		return (null);
	    }
	    Content[] contents = getContents();
	    contents_.clear();
	    for (int i = 0;i < contents.length;i++) {
		Content arg = (Content)contents[i];
		try {
		    Content[] result = arg.eval(context);
		    if (result != null) {
			for (int j = 0;j < result.length;j++) {
			    addContent(result[j]);
			}
		    }
		} catch (SmartDocWarningException e) {
		    // content that causes exception is removed
		}
	    }
	} catch (SmartDocWarningException e) {
	}
	return (new Content[] {this});
    }

    // Content
    public void format() {
	super.format();
	int size = contents_.size();
	for (int i = 0;i < size;i++) {
	    try {
		Content content = (Content)contents_.get(i);
		content.format();
	    } catch (SmartDocWarningException e) {
	    }
	}
    }

    // Content
    public String getText() {
	if (text_ == null) {
	    StringBuffer buffer = new StringBuffer();
	    int size = contents_.size();
	    for (int i = 0;i < size;i++) {
		Content content = (Content)contents_.get(i);
		String text = content.getText();
		if (text != null) {
		    buffer.append(text);
		}
	    }
	    text_ = new String(buffer);
	}
	return (text_);
    }

    // Container
    public char getFirstChar() {
	int size = contents_.size();
	for (int i = 0;i < size;i++) {
	    Content content = (Content)contents_.get(i);
	    char c = content.getFirstChar();
	    if (c != 0) {
		return (c);
	    }
	}
	return (0);
    }

    // Container
    public char getLastChar() {
	int size = contents_.size();
	for (int i = size - 1;i >= 0;i--) {
	    Content content = (Content)contents_.get(i);
	    char c = content.getLastChar();
	    if (c != 0) {
		return (c);
	    }
	}
	return (0);
    }

    public void addContent(Content content) {
	contents_.add(content);
	content.setParent(this);
    }

    public void addContents(Content[] contents) {
	for (int i = 0;i < contents.length;i++) {
	    addContent(contents[i]);
	}
    }

    public Content getContent(int i) {
	return ((Content)contents_.get(i));
    }

    public Content[] getContents() {
	Content[] contents = new Content[contents_.size()];
	return ((Content[])contents_.toArray(contents));
    }

    public void removeContent(Content content) {
	contents_.remove(content);
    }

    public void removeContent(int i) {
	contents_.remove(i);
    }

    public void clearContents() {
	contents_.clear();
    }

    public TOCNode getTOCTree() {
	if (root_ == null) {
	    root_ = UDoc.getTOCTree(this);
	}
	return (root_);
    }
}
