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

package org.xmlsmartdoc.SmartDoc.normalizer;

import java.util.*;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * NaturalNormalizer
 *
 * @since   Mar. 31, 1999
 * @version Jun. 23, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class NaturalNormalizer extends AbstractNormalizer {
    protected final static int INIT = 0;
    protected final static int AFTER_CR = 1;
    protected final static int AFTER_LF = 2;
    protected final static int AFTER_CRLF = 3;
    protected final static int AFTER_SPACE = 4;
    protected final static int BEFORE_SENTENCE = 5;
    protected final static int BEFORE_PARAGRAPH = 6;

    protected final static int LANG_INIT = 0;
    protected final static int LANG_WORD_SEPARATE = 1;
    protected final static int LANG_OTHER = 2;

    transient protected int langState_ = LANG_INIT;

    protected Content[] _normalize(
	Content[] contents,
	Content parent,
	DocContext context
    ) {
	if ("preserve".equals(parent.getSpace())) {
	    return (contents);
	}
	Paragraph paragraph = null;
	Sentence sentence = null;
	int state = INIT;
	List list = new ArrayList();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof Sentence) {
		if (paragraph == null) {
		    paragraph = new Paragraph();
		}
		if (sentence != null) {
		    sentence.setDone();
		    paragraph.addContent(sentence);
		    sentence = null;
		}
		paragraph.addContent(content);
	    } else if (content instanceof CharBlock) {
		CharBlock cblock = (CharBlock)content;
		String text = cblock.getText();
		if (cblock.isPreserve()) {
		    if (sentence == null) {
			sentence = new Sentence();
		    }
		    sentence.addString(text);
		    continue;
		}
		int tsize = text.length();
		for (int ti = 0;ti < tsize;ti++) {
		    char c = text.charAt(ti);
		    switch (state) {

		    case INIT:
			switch (c) {

			case '\r':
			    state = AFTER_CR;
			    break;
			case '\n':
			    state = AFTER_LF;
			    break;
			case ' ':
			case '\t':
//			    state = INIT;
			    state = AFTER_SPACE;
			    break;
			default:
			    if (paragraph == null) {
				paragraph = new Paragraph();
			    }
			    if (sentence == null) {
				sentence = new Sentence();
			    }
/*
			    if (sentence.isDone()) {
				list.add(sentence);
				sentence = new Sentence();
			    }
*/
			    sentence.addChar(c);
			    _setLangState(c);
			}
			break;
		    case AFTER_CR:
			switch (c) {

			case '\r':
			    if (sentence != null) {
				sentence.setDone();
				if (paragraph == null) {
				    paragraph = new Paragraph();
				}
				paragraph.addContent(sentence);
				list.add(paragraph);
				paragraph = null;
				sentence = null;
			    }
			    state = BEFORE_PARAGRAPH;
			    break;
			case '\n':
			    state = AFTER_CRLF;
			    break;
			case ' ':
			case '\t':
			    state = AFTER_CR;
//			    state = AFTER_SPACE;
			    break;
			default:
			    if (sentence == null) {
				sentence = new Sentence();
			    } else {
				if (_isWordSeparate(c)) {
				    sentence.addChar(' ');
				}
			    }
			    sentence.addChar(c);
			    _setLangState(c);
			    state = INIT;
			}
			break;
		    case AFTER_LF:
			switch (c) {

			case '\r':
			    state = BEFORE_PARAGRAPH;
			    break;
			case '\n':
			    if (sentence != null) {
				sentence.setDone();
				if (paragraph == null) {
				    paragraph = new Paragraph();
				}
				paragraph.addContent(sentence);
				list.add(paragraph);
				paragraph = null;
				sentence = null;
			    }
			    break;
			case ' ':
			case '\t':
			    state = AFTER_LF;
//			    state = AFTER_SPACE;
			    break;
			default:
			    if (sentence == null) {
				sentence = new Sentence();
			    } else {
				if (_isWordSeparate(c)) {
				    sentence.addChar(' ');
				}
			    }
			    sentence.addChar(c);
			    _setLangState(c);
			    state = INIT;
			}
			break;
		    case AFTER_SPACE:
			switch (c) {

			case '\r':
			    state = AFTER_CR;
			    break;
			case '\n':
			    state = AFTER_LF;
			    break;
			case ' ':
			case '\t':
			    // do nothing
			    break;
			default:
			    if (paragraph == null) {
				paragraph = new Paragraph();
			    }
			    if (sentence == null) {
				sentence = new Sentence();
			    } else if (_isWordSeparate(c)) {
				sentence.addChar(' ');
			    }
			    sentence.addChar(c);
			    _setLangState(c);
			    state = INIT;
			}
			break;
		    case BEFORE_PARAGRAPH:
			switch (c) {

			case '\r':
			case '\n':
			case ' ':
			case '\t':
			    // do nothing
			    break;
			default:
			    if (paragraph == null) {
				paragraph = new Paragraph();
			    }
			    if (sentence == null) {
				sentence = new Sentence();
			    } else {
				if (_isWordSeparate(c)) {
				    sentence.addChar(' ');
				}
			    }
			    sentence.addChar(c);
			    _setLangState(c);
			    state = INIT;
			}
			break;
		    default:
			throw (new InternalError());
		    }
		}
	    } else {
		switch (content.getEntityType()) {

		case Content.ENTITY_BLOCK: // continue
		case Content.ENTITY_CONTAINER:
		    if (sentence != null) {
			if (paragraph == null) {
			    paragraph = new Paragraph();
			}
			sentence.setDone();
			paragraph.addContent(sentence);
			sentence = null;
		    }
		    if (paragraph != null) {
			list.add(paragraph);
			paragraph = null;
		    }
		    list.add(content);
		    langState_ = LANG_INIT;
		    state = INIT;
		    break;
		case Content.ENTITY_INLINE: // continue
		case Content.ENTITY_CONTROL:
		    if (sentence == null) {
			sentence = new Sentence();
		    }
		    switch (state) {

		    case INIT:
			break;
		    case AFTER_CR: // continue
		    case AFTER_LF: // continue
		    case AFTER_SPACE:
			if (_isWordSeparate(content.getFirstChar())) {
			    sentence.addChar(' ');
			}
			break;
		    case BEFORE_PARAGRAPH:
			break;
		    default:
			throw (new InternalError());
		    }
		    sentence.addContent(content);
		    _setLangState(content.getLastChar());
		    state = INIT;
		    break;
		default:
		    throw (new InternalError());
		}
		state = INIT;
	    }
	}
	if (sentence != null) {
	    sentence.setDone();
	    if (paragraph == null) {
		paragraph = new Paragraph();
	    }
	    paragraph.addContent(sentence);
	    list.add(paragraph);
	}
	Content[] result = new Content[list.size()];
	return ((Content[])list.toArray(result));
    }

    protected void _setLangState(char c) {
	if (Character.isISOControl(c)) {
	    return;
	}
	if (USmartDoc.isWordSeparateLang(c)) {
	    langState_ = LANG_WORD_SEPARATE;
	} else {
	    langState_ = LANG_OTHER;
	}
    }

    protected boolean _isWordSeparate(char c) {
	if (langState_ == LANG_WORD_SEPARATE &&
	    USmartDoc.isWordSeparateLang(c)) {

	    return (true);
	} else {
	    return (false);
	}
    }
}
