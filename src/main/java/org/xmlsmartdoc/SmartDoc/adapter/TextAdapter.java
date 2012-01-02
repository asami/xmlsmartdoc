/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2000  ASAMI, Tomoharu (tasami@ibm.net)
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
import com.AsamiOffice.util.D2Array;

import org.xmlsmartdoc.SmartDoc.*;

/**
 * TextAdapter
 *
 * @since   May. 12, 1999
 * @version Jan. 30, 2000
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class TextAdapter extends AbstractAdapter {
    // AbstractAdapter
    protected Content[] _expand(
	String[] srcs,
	String param,
	Content content,
	Content[] contents,
	DocContext context
    ) {
	try {
	    String encoding = content.getEncoding();
	    String text = content.getText();
	    if (text == null) {
		text = "";
	    }
	    if (encoding != null) {
		text += USmartDoc.importText(srcs[0], encoding, context);
	    } else {
		text += USmartDoc.importText(srcs[0], context);
	    }
	    content.setText(text);
	    Content[] result = new Content[contents.length + 1];
	    for (int i = 0;i < contents.length;i++) {
		result[i] = contents[i];
	    }
	    result[contents.length] = new CharBlock(text);
	    return (result);
	} catch (SmartDocWarningException e) {
	    return (
		new Content[] {
		    new CharBlock(
			"Can not access : " + srcs[0] + "\n"
		    )
		}
	    );
	}
    }
}
