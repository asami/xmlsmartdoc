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
package org.relaxer.framework.runtime.model.content;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;

import org.relaxer.framework.URelaxerObject;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.w3c.dom.Document;

/**
 * RelaxerObjectContent
 *
 * @since   Sep. 21, 2004
 * @version Aug. 20, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RelaxerObjectContent extends AbstractRModelContent {
    private final Object object_;
    private XmlContent xml_ = null;
    
    public RelaxerObjectContent(Object object, IRModelContext context) {
        super(context);
        if (object == null) {
            throw (new IllegalArgumentException("Null object"));
        }
        object_ = object;
    }

    private XmlContent getXmlContent() throws RModelException {
        if (xml_ == null) {
            try {
                Document doc = URelaxerObject.makeDocument(object_);
                xml_ = new XmlContent(doc, _context);
            } catch (NoSuchMethodException e) {
                throw (new RModelException(e));
            } catch (IllegalAccessException e) {
                throw (new RModelException(e));
            } catch (InvocationTargetException e) {
                throw (new RModelException(e));
            }
        }
        return (xml_);
    }

    public boolean isValue() {
        return false;
    }

    public Object getValue() {
        return null;
    }

    public boolean isBinary() {
        return (true);
    }

    protected InputStream _openInputStream() throws RModelException {
        XmlContent xml = getXmlContent();
        return (xml.openInputStream());
    }

    protected byte[] _getBinary() throws RModelException {
        return (xml_.getBinary());
    }

    protected Boolean _isText() {
        return (Boolean.TRUE);
    }

    protected Reader _openReader() throws RModelException {
        XmlContent xml = getXmlContent();
        return (xml.openReader());
    }

    protected String _getText() throws RModelException {
        XmlContent xml = getXmlContent();
        return (xml.getText());
    }

    protected Boolean _isXml() {
        return (Boolean.TRUE);
    }
    
    public Document getDocument() throws RModelException {
        XmlContent xml = getXmlContent();
        return (xml.getDocument());
    }

    public Object getSource() {
        return (object_);
    }

    public void setVisible(boolean visible) throws RModelException {
        XmlContent xml = getXmlContent();
        xml.setVisual(visible);
    }
}
