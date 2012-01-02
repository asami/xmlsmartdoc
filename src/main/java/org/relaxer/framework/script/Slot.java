/*
 * The RelaxerOrg class library
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

package org.relaxer.framework.script;

import org.relaxer.framework.datatype.DatatypeFactory;
import org.relaxer.framework.datatype.IDatatype;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.AsamiOffice.text.UString;

/**
 * Slot
 *
 * @since   Jan.  5, 2003
 * @version Feb. 13, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class Slot {
    private String name_;
    private IDatatype datatype_;
    private ScriptValue data_;

    public Slot(String name) {
        this (name, DatatypeFactory.getStringDatatype());        
    }

    public Slot(String name, IDatatype datatype) {
        if (UString.isNull(name)) {
            throw (new IllegalArgumentException("name = " + name));
        }
        name_ = name;
        datatype_ = datatype;
    }

    public Slot(Slot slot) {
        name_ = slot.name_;
        datatype_ = slot.datatype_;
        data_ = slot.data_;
    }

    public final String getName() {
        return (name_);
    }

    public final IDatatype getDatatype() {
        return (datatype_);
    }

    public void setObject(Object value) {
        if (value == null) {
            data_ = null;
        } else {
            data_ = new ScriptValue(value);
        }
    }
    
    public void setObjects(Object[] values) {
        data_ = new ScriptValue(values);
    }

    public void setText(String text) {
        data_ = new ScriptValue(text);
    }
    
    public void setTexts(String[] texts) {
        data_ = new ScriptValue(texts);
    }

    public void setXml(Node xml) {
        data_ = new ScriptValue(xml);
    }

    public void setXmls(Node[] xmls) {
        data_ = new ScriptValue(xmls);
    }

    public Object[] getObjects() {
        if (data_ == null) {
            return (new Object[0]); 
        }
        return (data_.getObjects());
    }

    public Object peekObject() {
        if (data_ == null) {
            return (null); 
        }
        return (data_.getObject());
    }

    public Object popObject() throws ScriptException {
        if (data_ == null) {
            return (null);
        }
        Object value = data_.getObject();
        data_ = data_.makePopedData();
        return (value);
    }

    public String[] getTexts() {
        if (data_ == null) {
            return (null); 
        }
        return (data_.getTexts());
    }

    public String peekText() {
        if (data_ == null) {
            return (null); 
        }
        return (data_.getText());
    }

    public String popText() throws ScriptException {
        if (data_ == null) {
            return (null);
        }
        String text = data_.getText();
        data_ = data_.makePopedData();
        return (text);
    }

    public Node[] getXmls(Document factory) {
        if (data_ == null) {
            return (null); 
        }
        return (data_.getXmls(factory));
    }

    public Node[] getXmls() {
        if (data_ == null) {
            return (null); 
        }
        return (data_.checkXmls());
    }

    public Node peekXml(Document factory) {
        if (data_ == null) {
            return (null); 
        }
        return (data_.getXml(factory));
    }

    public Node peekXml() {
        if (data_ == null) {
            return (null); 
        }
        return (data_.checkXml());
    }

    public Node popXml(Document factory) throws ScriptException {
        if (data_ == null) {
            return (null);
        }
        Node node = data_.getXml(factory);
        data_ = data_.makePopedData();
        return (node);
    }

/*
    public Node popXml() {
        if (data_ == null) {
            return (null);
        }
        return (data_.popXml());
    }
*/

    public ScriptValue getValue() {
        return (data_);
    }

    public void setValue(ScriptValue data) {
        data_ = data;
    }
}
