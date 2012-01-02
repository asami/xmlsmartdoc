/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@asamiOffice.com)
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

package com.AsamiOffice.jaba2.xml.pdom;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * PText is a DOM Node to persist.
 *
 * @since   Apr. 24, 1998
 * @version Aug. 11, 2004
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public class PText extends PCharacterData implements org.w3c.dom.Text {
    public PText(String text) {
	super(text);
    }

    public PText(String text, PNode parent) {
	super(text, parent);
    }

    public PText(String text, PDocument owner) {
	super(text, owner);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public short getNodeType() {
	return (Node.TEXT_NODE);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public Text splitText(int offset) throws DOMException {
	throw (new UnsupportedOperationException());
    }

    // DOM3
	public boolean isElementContentWhitespace() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getWholeText() {
		// TODO Auto-generated method stub
		return null;
	}

	public Text replaceWholeText(String arg0) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}
}

