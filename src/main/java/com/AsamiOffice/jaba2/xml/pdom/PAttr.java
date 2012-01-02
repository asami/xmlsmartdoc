/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@relaxer.org)
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

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

/**
 * PAttr is a DOM Node to persist.
 *
 * @since   Apr. 24, 1998
 * @version Aug. 11, 2004
 + @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class PAttr extends PNode implements Attr {
    protected String name_;
    protected String value_;
    protected boolean specified_ = true;

    public PAttr(Attr attr) {
        name_ = attr.getName();
        value_ = attr.getValue();
    }

    public PAttr(String name) {
        name_ = name;
    }

    public PAttr(String name, String value) {
        //System.out.println("ddd = " + name + "/" + value);
        name_ = name;
        value_ = value;
    }

    public PAttr(String name, PDocument owner) {
        super(owner);
        name_ = name;
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Node
     */
    public short getNodeType() {
        return (Node.ATTRIBUTE_NODE);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Attr
     */
    public String getName() {
        return (name_);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Attr     
     */
    public String getValue() {
        return (value_);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @obsolate
     * @see org.w3c.dom.Attr
     */
    public void setValue(String value) {
        throw (new InternalError("not supported"));
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Attr
     */
    public boolean getSpecified() {
        return (specified_);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.Attr
     */
    public void setSpecified(boolean arg) {
        specified_ = arg;
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see java.lang.Object
     */
    public String toString() {
        //System.out.println("kkk = " + name_ + "/" + value_);
        return (value_.toString());
    }

    // DOM2
    public Element getOwnerElement() {
        throw (new UnsupportedOperationException());
    }

    // DOM3
	public TypeInfo getSchemaTypeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isId() {
		// TODO Auto-generated method stub
		return false;
	}
}
