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

package org.xmlsmartdoc.SmartDoc.adapter;

import java.util.*;
import com.AsamiOffice.jaba2.text.UString;
import com.AsamiOffice.util.UArray;

import org.xmlsmartdoc.SmartDoc.*;

/**
 * AbstractNormalizer
 *
 * @since   May. 12, 1999
 * @version Jan. 28, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class AbstractAdapter implements IAdapter {
    public void expand(
	String[] srcs,
	String param,
	Content content,
	DocContext context
    ) {
	if (content instanceof Container) {
	    Container container = (Container)content;
	    Content[] contents = container.getContents();
	    contents = _expand(
		srcs,
		param,
		container,
		container.getContents(),
		context
	    );
	    container.clearContents();
	    container.addContents(contents);
	}
    }

    protected Content[] _expand(
	String[] srcs,
	String param,
	Content content,
	Content[] contents,
	DocContext context
    ) {
	content.setSrc(srcs[0]);
	return (contents);
    }
}
