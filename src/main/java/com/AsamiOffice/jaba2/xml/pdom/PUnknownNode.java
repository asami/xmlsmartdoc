/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1999  ASAMI, Tomoharu (tasami@ibm.net)
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

import java.util.*;
import org.w3c.dom.*;

/**
 * PUnkonwnNode is a DOM Node to persist.
 *
 * @since   Apr. 27, 1998
 * @version Sep. 15, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class PUnknownNode extends PNode {
    protected short type_;

    public PUnknownNode(short type, PNode parent) {
	super(parent);
	type_ = type;
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public short getNodeType() {
	return (type_);
    }
}

