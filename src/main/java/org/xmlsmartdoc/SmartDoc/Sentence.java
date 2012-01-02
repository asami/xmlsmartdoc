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

import org.w3c.dom.*;

/**
 * Sentence
 *
 * really paragraph?
 *
 * @since   Sep. 19, 1998
 * @version Nov.  4, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class Sentence extends Container {
    protected static final int INIT = 1; // XXX : no needs
    protected static final int IN_SENTENCE = 2; // XXX : no needs
    protected static final int AFTER_NL = 3; // XXX : no needs
    protected static final int AFTER_CR = 4; // XXX : no needs
    protected static final int AFTER_CRLF = 5; // XXX : no needs
    protected static final int DONE = 6; // XXX : no needs

    protected int state_ = INIT;
    protected StringBuffer buffer_ = null;

    public Sentence() {
    }

    public Sentence(Element element) {
	super(element);
    }

    public int getEntityType() {
	return (ENTITY_INLINE);
    }

/*
    // Container
    public void format() {
	if (state_ != DONE) {
	    throw (new InternalError());
	}
	super.format();
	int prevLang = 0;	// INIT
	Content[] contents = getContents();
	clearContents();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (prevLang == 1) {
		char firstc = content.getFirstChar();
		if (firstc != 0) {
		    if (firstc != ' ' && firstc != '\n') {
			if (USmartDoc.isWordSeparateLang(firstc)) {
			    super.addContent(new CharBlock(" "));
			}
		    }
		}
	    }
	    super.addContent(content);
	    char lastc = content.getLastChar();
	    if (lastc != 0) {
		if (USmartDoc.isWordSeparateLang(lastc)) {
		    prevLang = 1; // word separete
		} else {
		    prevLang = 0;
		}
	    }
	}
    }
*/

    public boolean isDone() {
	return (state_ == DONE);
    }

    public void addChar(char c) {
	if (buffer_ == null) {
	    buffer_ = new StringBuffer();
	}
	switch (state_) {

	case INIT:
	    switch (c) {

	    case '\n':
		break;
	    case '\r':
		break;
	    default:
		buffer_.append(c);
		state_ = IN_SENTENCE;
		break;
	    }
	    break;
	case IN_SENTENCE:
	    switch (c) {

	    case '\n':
		state_ = AFTER_NL;
		break;
	    case '\r':
		state_ = AFTER_CR;
		break;
	    default:
		buffer_.append(c);
		state_ = IN_SENTENCE;
		break;
	    }
	    break;
	case AFTER_NL:
	    switch (c) {

	    case '\n':
		state_ = DONE;
		break;
	    case '\r':
		state_ = AFTER_CR;
		break;
	    default:
		buffer_.append(c);
		state_ = IN_SENTENCE;
		break;
	    }
	    break;
	case AFTER_CR:
	    switch (c) {

	    case '\n':
		state_ = AFTER_CRLF;
		break;
	    case '\r':
		state_ = DONE;
		break;
	    default:
		buffer_.append(c);
		state_ = IN_SENTENCE;
		break;
	    }
	    break;
	case AFTER_CRLF:
	    switch (c) {

	    case '\n':
		state_ = DONE;
		break;
	    case '\r':
		state_ = DONE;
		break;
	    default:
		buffer_.append(c);
		state_ = IN_SENTENCE;
		break;
	    }
	    break;
	default:
	    throw (new InternalError());
	}
	if (state_ == DONE) {
	    super.addContent(new CharBlock(new String(buffer_)));
	    buffer_ = null;
	}
    }

    public void addString(String string) {
	int size = string.length();
	for (int i = 0;i < size;i++) {
	    addChar(string.charAt(i));
	}
    }

    public void addPropertyText(Element element) {
	throw (new UnsupportedOperationException());
    }

    // Container
    public void addContent(Content content) {
	if (buffer_ != null) {
	    super.addContent(new CharBlock(new String(buffer_)));
	    buffer_ = null;
	}
	super.addContent(content);
    }

    public void fill() {
	if (buffer_ != null) {
	    super.addContent(new CharBlock(new String(buffer_)));
	    buffer_ = null;
	}
	state_ = IN_SENTENCE;
    }

    public void setDone() {
	if (buffer_ != null) {
	    super.addContent(new CharBlock(new String(buffer_)));
	    buffer_ = null;
	}
	state_ = DONE;
    }

/*
    public void embedAnchor(String word, Indexdef indexdef) {
	int wordLength = word.length();
	Content[] contents = getContents();
	clearContents();
	int id = indexdef.calcNextRefNo(word);
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof CharBlock) {
		CharBlock block = (CharBlock)content;
		String text = block.getText();
		int textLength = text.length();
		int cur = text.indexOf(word); // XXX : I18N BreakIterator
		if (cur == -1) {
		    super.addContent(block);
		} else {
		    int prev = 0;
		    for (;;) {
			if (prev != cur) {
			    super.addContent(
				new CharBlock(
				    text.substring(prev, cur)
				)
			    );
			}
			Anchor anchor = new Anchor(
			    text.substring(cur, cur + wordLength),
			    word + id
			);
			id++;
			indexdef.addAnchor(anchor);
			super.addContent(anchor);
			prev = cur + wordLength;
			if (prev == textLength) {
			    break;
			}
			cur = text.indexOf(word, prev);
			if (cur == -1) {
			    super.addContent(
				new CharBlock(text.substring(prev))
			    );
			    break;
			}
		    }
		}
	    } else {
		super.addContent(content);
	    }
	}
    }

    public void embedAnchor(String[] words, Indexdef indexdef) {
	for (int i = 0;i < words.length;i++) {
	    embedAnchor(words[i], indexdef);
	}
    }
*/
}
