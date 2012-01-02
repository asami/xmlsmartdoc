/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2000  ASAMI, Tomoharu (asami@zeomtech.com)
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
 * PDocumentType is a DOM object to persist.
 *
 * @since   Apr. 27, 1998
 * @version Nov. 16, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class PDocumentType extends PNode implements DocumentType {
    protected String name_;

    public PDocumentType(String name) {
	name_ = name;
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public short getNodeType() {
	return (DOCUMENT_TYPE_NODE);
    }

    /**
     * @since WD-DOM-19980318 (or before)
     * @see org.w3c.dom.DocumentType
     */
    public String getName() {
	return (name_);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.DocumentType
     */
    public NamedNodeMap getEntities() {
	throw (new UnsupportedOperationException());
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.DocumentType
     */
    public NamedNodeMap getNotations() {
	throw (new UnsupportedOperationException());
    }

    /**
     *  The public identifier of the external subset.
     * @since DOM Level 2
     */
    public String getPublicId() {
	throw (new UnsupportedOperationException());
    }

    /**
     *  The system identifier of the external subset.
     * @since DOM Level 2
     */
    public String getSystemId() {
	throw (new UnsupportedOperationException());
    }

    /**
     *  The internal subset as a string.
     * @since DOM Level 2
     */
    public String getInternalSubset() {
	throw (new UnsupportedOperationException());
    }
}
