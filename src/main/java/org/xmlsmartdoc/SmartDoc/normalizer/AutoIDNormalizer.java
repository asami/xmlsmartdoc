/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
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

import org.xmlsmartdoc.SmartDoc.Console;
import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.DocContext;
import org.xmlsmartdoc.SmartDoc.ImageFigure;
import org.xmlsmartdoc.SmartDoc.Program;
import org.xmlsmartdoc.SmartDoc.Table;

import com.AsamiOffice.text.UString;

/**
 * AutoIDSourceNormalizer
 *
 * @since   Aug. 14, 2000
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 */
public class AutoIDNormalizer extends AbstractNormalizer {
    protected Content[] _normalize(
        Content[] contents,
        Content parent,
        DocContext context) {
        String id = parent.getID();
        if (id != null) {
            return (contents);
        }
        String src = parent.getSrc();
        String name = UString.getLastComponent(src);
        String prefix = _makePrefix(parent);
        parent.setTitle(prefix + ":" + name);
        return (contents);
    }

    private String _makePrefix(Content content) {
        if (content instanceof ImageFigure) {
            return ("fig");
        } else if (content instanceof Program) {
            return ("prog");
        } else if (content instanceof Console) {
            return ("con");
        } else if (content instanceof Table) {
            return ("tab");
        } else {
            return ("id");
        }
    }
}
