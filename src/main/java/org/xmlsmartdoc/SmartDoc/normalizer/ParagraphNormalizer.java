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

package org.xmlsmartdoc.SmartDoc.normalizer;

import java.util.*;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * ParagraphNormalizer
 *
 * @since   Aug. 26, 2002
 * @version Aug. 26, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class ParagraphNormalizer extends NaturalNormalizer {
    protected Content[] _normalize(
	Content[] contents,
	Content parent,
	DocContext context
    ) {
	List list = new ArrayList();
	for (int i = 0;i < contents.length;i++) {
	    Content content = contents[i];
	    if (content instanceof CharBlock) {
		CharBlock cblock = (CharBlock)content;
		if (cblock.isPreserve()) {
		    list.add(cblock);
		} else {
		    StringBuffer buffer = new StringBuffer();
		    String text = cblock.getText();
		    int tsize = text.length();
		    for (int ti = 0;ti < tsize;ti++) {
			char c = text.charAt(ti);
			switch (c) {
			case '\r':
			case '\n':
			    // in case of ul/or/dl
			    break;
			default:
			    buffer.append(c);
			}
		    }
		    list.add(new CharBlock(new String(buffer)));
		}
		String text = cblock.getText();
	    } else {
		list.add(content);
	    }
	}
	Content[] result = new Content[list.size()];
	return ((Content[])list.toArray(result));
    }
}
