   /*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2000  ASAMI, Tomoharu (asami@zeomtech.com)
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

import com.AsamiOffice.util.ULocale;
import com.AsamiOffice.xml.UElement;

import com.AsamiOffice.jaba2.text.UString;

/**
 * TitledBlock
 *
 * @since   Sep. 23, 1998
 * @version May. 31, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public abstract class TitledBlock extends Container {
    protected boolean isSequencable_ = false;
    protected int seqNumber_ = 0;

    protected TitledBlock() {
    }

    protected TitledBlock(Element element) {
	super(element);
	isSequencable_
	    = UElement.getAttributeAsBoolean(element, "sequencable", true);
    }

    public void setSeqNumber(int number) {
	seqNumber_ = number;
    }

    public final boolean isSequencable() {
	return (isSequencable_);
    }

    public final int getSeqNumber() {
	return (seqNumber_);
    }
}
