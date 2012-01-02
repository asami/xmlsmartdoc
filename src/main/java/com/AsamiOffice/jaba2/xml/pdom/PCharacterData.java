/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;

/**
 * PText is a DOM Node to persist.
 *
 * @since   Oct. 13, 1998
 * @version Dec.  8, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public abstract class PCharacterData extends PNode implements CharacterData {
    protected String text_;

    public PCharacterData(String text) {
        text_ = text;
    }

    public PCharacterData(String text, PNode parent) {
        super(parent);
        text_ = text;
    }

    public PCharacterData(String text, PDocument owner) {
        super(owner);
        text_ = text;
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.CharacterData
     */
    public String getData() throws DOMException {
        return (text_);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.CharacterData
     */
    public void setData(String arg) throws DOMException {
        text_ = arg;
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.CharacterData
     */
    public int getLength() {
        return (text_.length());
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.CharacterData
     */
    public String substringData(int offset, int count) throws DOMException {
        return (text_.substring(offset, count));
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.CharacterData
     */
    public void appendData(String data) throws DOMException {
        text_ = text_ + data;
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.CharacterData
     */
    public void insertData(int offset, String data) throws DOMException {
        StringBuffer buffer = new StringBuffer();
        buffer.append(text_);
        buffer.insert(offset, data);
        text_ = buffer.toString();
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.CharacterData
     */
    public void deleteData(int offset, int count) throws DOMException {
        text_ = text_.substring(0, offset) + text_.substring(offset + count);
    }

    /**
     * @since REC-DOM-Level-1-19981001
     * @see org.w3c.dom.CharacterData
     */
    public void replaceData(int offset, int count, String data)
        throws DOMException {

        text_ =
            text_.substring(0, offset) + data + text_.substring(offset + count);
    }

    /* (non-Javadoc)
     * @see org.w3c.dom.Node#getNodeValue()
     */
    public String getNodeValue() throws DOMException {
        return (getData());
    }

    /* (non-Javadoc)
     * @see org.w3c.dom.Node#setNodeValue(java.lang.String)
     */
    public void setNodeValue(String nodeValue) throws DOMException {
        setData(nodeValue);
    }

}
