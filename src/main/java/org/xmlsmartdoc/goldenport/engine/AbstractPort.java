/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.xmlsmartdoc.goldenport.engine;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Element;
import org.xmlsmartdoc.goldenport.selecter.ISelecter;

/**
 * AbstractPort
 *
 * @since   Feb.  9, 2002
 * @version Apr. 12, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public abstract class AbstractPort implements IPort {
    private ISelecter selecter_;
    private Map properties_ = new HashMap();

    public void setSelecter(ISelecter selecter) {
        selecter_ = selecter;
    }
    
    public ISelecter getSelecter() {
        return (selecter_);
    }

    public void setProperty(String name, String value) {
        properties_.put(name, value);
    }
    
    public String getProperty(String name) {
        return ((String)properties_.get(name));
    }
    
    public String getProperty(String name, String defaultValue) {
        String value = getProperty(name);
        if (value != null) {
            return (value);
        } else {
            return (defaultValue);
        }
    }

    public boolean getBooleanProperty(String name, boolean defaultValue) {
        String value = getProperty(name);
        if (value != null) {
            return ("true".equals(value));
        } else {
            return (defaultValue);
        }
    }

    public void setup(Element element) {
        // do nothing
    }

    public boolean isAccept(Element element) {
        return (selecter_.isMatch(element));
    }

    public int startElement(
        Element element,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        result.setup(element);
        return (IPortConstants.EVAL_CHILDREN);
    }

    public void endElement(
        Element element,
        PortNodeList halfResult,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        result.setup(halfResult);
    }
}
