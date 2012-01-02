/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998,1999  ASAMI, Tomoharu (tasami@ibm.net)
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

import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.DocContext;
import org.xmlsmartdoc.SmartDoc.USmartDoc;

/**
 * AutoImageAdapter
 *
 * @since   May.  8, 1999
 * @version Oct. 19, 2001
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class AutoImageAdapter extends AbstractAdapter {
//    implements IImageAdapter {

    protected String[] candidates_;

    // IAdapter
    protected Content[] _expand(
    	String[] srcs,
	   String param,
	   Content content,
	   Content[] contents,
	   DocContext context
    ) {
	   String[] candidates
	       = context.getFormatConfig().getImageCandidates();
	   String name = USmartDoc.getImageFilename(srcs, candidates, context);
	   content.setSrc(name);
	   return (contents);
    }
}
