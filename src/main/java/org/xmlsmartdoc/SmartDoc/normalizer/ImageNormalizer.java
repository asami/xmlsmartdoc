/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2001  ASAMI, Tomoharu (asami@zeomtech.com)
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
import com.AsamiOffice.jaba2.text.UString;
import com.AsamiOffice.util.UArray;

import org.xmlsmartdoc.SmartDoc.*;

/**
 * ImageNormalizer
 *
 * @since   May.  8, 1999
 * @version Oct. 17, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class ImageNormalizer extends AbstractNormalizer {
    protected Content[] _normalize(
	Content[] contents,
	Content image,
	DocContext context
    ) {
	String[] srcs = image.getSrcList();
	if (srcs == null) {
	    return (contents);
	}
/*
	if (image.getSrc().lastIndexOf(".") != -1) {
	    return (contents);
	}
*/
	String filename = USmartDoc.getImageFilename(
	    srcs,
	    context.getImageCandidates(),
	    context
	);
	if (filename != null) {
	    image.setSrc(filename);
	}
	return (contents);
    }
}
