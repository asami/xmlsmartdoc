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
 * MacroContent
 *
 * @since   Jun.  9, 2000
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class MacroContent extends Container {
    private String path_;

    public MacroContent(Element element) {
        super(element);
        path_ = UString.checkNull(element.getAttribute("valueOf"));
    }

    // Content
    public int getEntityType() {
        return (ENTITY_CONTAINER);
    }

    /*
        public Content[] macroExpand(DocContext context) {
    	Content macroContext = context.getMacroContext();
    	if (macroContext == null) { // XXX
    	    macroContext = getParent();
    	}
    	Content[] contents;
    	if (path_ != null) {	// XXX 
    	    contents = UDoc.getContentsByPath(macroContext, path_);
    	} else {
    	    contents = eval(context);
    	}
    	return (contents);
        }
    */
    public Content[] macroExpand(DocContext context) {
        Content[] contents = getContents();
        List attributes = new ArrayList();
        List elements = new ArrayList();
        for (int i = 0; i < contents.length; i++) {
            Content content = contents[i];
            if (content instanceof MacroAttribute) {
                attributes.add(content);
            } else {
                elements.add(content);
            }
        }
        if (elements.size() == 0) {
            return (null);
        }
        Content[] elementContents =
            (Content[])elements.toArray(new Content[elements.size()]);
        Container first = _getFirstContainer(elementContents);
        if (first != null) {
            Content[] attributeContents =
                (Content[])attributes.toArray(new Content[attributes.size()]);
            first.addContents(attributeContents);
        }
        contents_.clear();
        addContents(elementContents);
        Content[] resultRoot = super.eval(context);
        if (resultRoot == null) {
            return (null);
        }
        MacroContent mc = (MacroContent)resultRoot[0];
        Content[] mcContents = mc.getContents();
        Container resultFirst = _getFirstContainer(mcContents);
        // XXX : take over
        if (resultFirst != null) {
            Title title = mc.getTitleNode(); // XXX : locale
            if (title != null) {
                resultFirst.setTitle(title);
            }
        }
        return (mcContents);
    }

    private Container _getFirstContainer(Content[] elements) {
        for (int i = 0; i < elements.length; i++) {
            Content element = elements[i];
            if (element instanceof Container) {
                return ((Container)element);
            }
        }
        return (null);
    }
}
