/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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
import com.AsamiOffice.text.UString;
import org.xmlsmartdoc.SmartDoc.*;

/**
 * ProgramNormalizer
 *
 * @since   Aug. 11, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class ProgramNormalizer extends AbstractNormalizer {
    protected transient Em em_;
    protected transient String emString_;
    protected transient boolean available_;
    protected transient List list_;

    protected Content[] _normalize(
	Content[] contents,
	Content parent,
	DocContext context
    ) {
	String startString = UString.checkNull(
	    parent.getAttribute("start")
	);
	String finishString = UString.checkNull(
	    parent.getAttribute("finish")
	);
	int width = 75;
	try {
	    String widthAttr = UString.checkNull(
		parent.getAttribute("programWidth")
	    );
	    if (widthAttr != null) {
		width = Integer.parseInt(widthAttr);
	    }
	} catch (NumberFormatException e) {
	    // do nothing
	}
	String contSymbol = UString.checkNull(
		parent.getAttribute("programContSymbol")
	);
	if (contSymbol == null) {
	    contSymbol = " \\";
	}
	String text = UDoc.distillText((Container)parent);
	text = UNormalizer.makeWrappedLines(text, width, contSymbol);
	String[] lines = UString.makeTrimedStringList(text);
	list_ = new ArrayList();
	em_ = null;
	emString_ = null;
	available_ = (startString == null);
	for (int i = 0;i < lines.length;i++) {
	    String line = lines[i];
	    if (startString != null) {
		if (line.indexOf(startString) != -1) {
		    available_ = true;
		    continue;
		}
	    }
	    if (finishString != null) {
		if (line.indexOf(finishString) != -1) {
		    available_ = false;
		    continue;
		}
	    }
	    if (line.equals("// <em>")) {
		em_ = new Em();
	    } else if (line.equals("// </em>")) {
		_addContent(em_);
		em_ = null;
	    } else if (line.startsWith("// <em>")) {
		emString_ = line.substring(
		    "// <em>".length(),
		    line.indexOf("</em>")
		);
	    } else {
		if (emString_ != null) {
		    int index = line.indexOf(emString_);
		    _addContent(new CharBlock(line.substring(0, index)));
		    em_ = new Em();
		    em_.addContent(
			new CharBlock(
			    line.substring(index, index + emString_.length())
			)
		    );
		    _addContent(em_);
		    _addContent(
			new CharBlock(
			    line.substring(index + emString_.length()) + "\n"
			)
		    );
		    em_ = null;
		    emString_ = null;
		} else {
		    if (em_ != null) {
			em_.addContent(new CharBlock(line + "\n"));
		    } else {
			_addContent(new CharBlock(line + "\n"));
		    }
		}
	    }
	}
	parent.setText(null);
	Content[] result = UDoc.list2Contents(list_);
	return (result);
    }

    protected void _addContent(Content content) {
	if (available_) {
	    list_.add(content);
	}
    }
}
