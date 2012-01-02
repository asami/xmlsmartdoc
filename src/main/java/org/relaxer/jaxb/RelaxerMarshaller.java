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

package org.relaxer.jaxb;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.helpers.AbstractMarshallerImpl;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import com.AsamiOffice.xml.XMLMaker;
import com.AsamiOffice.xml.sax.DOMSAXProducer;
import com.AsamiOffice.xml.visitor.UDOMVisitor;

/**
 * RelaxerMarshaller
 *
 * @since   Feb. 17, 2003
 * @version Feb.  4, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RelaxerMarshaller extends AbstractMarshallerImpl {
    public final static String RELAXER_LINE_SEPARATOR = "org.relaxer.jaxb.line_separator"; 
    public final static String RELAXER_PUBLIC_ID = "org.relaxer.jaxb.public_id"; 
    public final static String RELAXER_SYSTEM_ID = "org.relaxer.jaxb.system_id"; 
    public final static String RELAXER_INDENT = "org.relaxer.jaxb.indent"; 

    private RelaxerJaxbContext context_;
    private String lineSeparator_ = null;
    private String publicId_ = null;
    private String systemId_ = null;
    private int indent_ = -1;

    public RelaxerMarshaller(RelaxerJaxbContext context) {
        context_ = context;
    }

    public void marshal(Object ro, Result result) throws JAXBException {
        if (result instanceof StreamResult) {
            marshal_(ro, (StreamResult)result);
        } else if (result instanceof DOMResult) {
            marshal_(ro, (DOMResult)result);
        } else if (result instanceof SAXResult) {
            marshal_(ro, (SAXResult)result);
        } else {
            throw (new JAXBException(""));
        }
    }

    public Object getProperty(String name) throws PropertyException {
        if (RELAXER_LINE_SEPARATOR.equals(name)) {
            return (lineSeparator_);
        } else if (RELAXER_PUBLIC_ID.equals(name)) {
            return (publicId_);
        } else if (RELAXER_SYSTEM_ID.equals(name)) {
            return (systemId_);
        } else if (RELAXER_INDENT.equals(name)) {
            if (indent_ < 0) {
                return (null);
            } else {
                return (new Integer(indent_));
            }
        } else {
            return (super.getProperty(name));
        }
    }

    public void setProperty(String name, Object value)
      throws PropertyException {
        if (RELAXER_LINE_SEPARATOR.equals(name)) {
            lineSeparator_ = (String)value;
        } else if (RELAXER_PUBLIC_ID.equals(name)) {
            publicId_ = (String)value;
        } else if (RELAXER_SYSTEM_ID.equals(name)) {
            systemId_ = (String)value;
        } else if (RELAXER_INDENT.equals(name)) {
            indent_ = Integer.parseInt(value.toString());
        } else {
            super.setProperty(name, value);
        }
    }

    private void marshal_(Object ro, StreamResult result)
        throws JAXBException {

        OutputStream out = result.getOutputStream();
        if (out != null) {
            marshal_(ro, out);
        } else {
            Writer writer = result.getWriter();
            if (writer != null) {
                marshal_(ro, writer);
            } else {
                throw (new JAXBException(""));
            }
        }
    }

    private void marshal_(Object ro, OutputStream out) throws JAXBException {
        try {
            OutputStreamWriter writer
                = new OutputStreamWriter(out, getEncoding());
            marshal_(ro, writer);
            out.flush();
        } catch (IOException e) {
            throw (new JAXBException(e.getMessage()));
        }
    }

    private void marshal_(Object ro, Writer writer) throws JAXBException {
        if (isFormattedOutput()) {
            marshalFormatted_(ro, writer);
        } else {
            marshalPlain_(ro, writer);
        }
    }

    private void marshalPlain_(Object ro, Writer writer)
      throws JAXBException {
        try {
            String encoding = getEncoding();
            if (encoding != null && !"utf-8".equalsIgnoreCase(encoding)) {
                writer.write("<?xml version=\"1.0\" encoding=\"");
                writer.write(encoding);
                writer.write("\"?>");
            }
            Class clazz = ro.getClass();
            Class[] params = new Class[] { Writer.class };
            Method method = clazz.getMethod("makeTextElement", params);
            Object[] args = new Object[] { writer };
            method.invoke(ro, args);
            writer.flush();
        } catch (IOException e) {
            throw (new JAXBException(e.getMessage()));
        } catch (NoSuchMethodException e) {
            throw (new JAXBException(e.getMessage()));
        } catch (IllegalAccessException e) {
            throw (new JAXBException(e.getMessage()));
        } catch (InvocationTargetException e) {
            throw (new JAXBException(e.getMessage()));
        }
    }

    private void marshalFormatted_(Object ro, Writer writer)
      throws JAXBException {
        XMLMaker maker = new XMLMaker(writer);
        maker.setDOM2(isDom2_(ro));
        maker.setEmptyElementTag(true);
        maker.setVisual(true);
        String encoding = getEncoding();
        if (encoding != null) {
            maker.setEncoding(encoding);
        }
        if (lineSeparator_ != null) {
            maker.setLineSeparator(lineSeparator_);
        }
        if (publicId_ != null) {
            maker.setPublicId(publicId_);
        }
        if (systemId_ != null) {
            maker.setSystemId(systemId_);
        }
        if (indent_ >= 0) {
            maker.setIndent(indent_);
        }
        try {
            Class clazz = ro.getClass();
            Class[] params = new Class[] {};
            Method method = clazz.getMethod("makeDocument", params);
            Object[] args = new Object[] {};
            Document doc = (Document)method.invoke(ro, args);
            UDOMVisitor.traverse(doc, maker);
            writer.flush();
        } catch (IOException e) {
            throw (new JAXBException(e.getMessage()));
        } catch (NoSuchMethodException e) {
            throw (new JAXBException(e.getMessage()));
        } catch (IllegalAccessException e) {
            throw (new JAXBException(e.getMessage()));
        } catch (InvocationTargetException e) {
            throw (new JAXBException(e.getMessage()));
        }
    }

    private boolean isDom2_(Object ro) {
        try {
            Class clazz = ro.getClass();
            Class[] params = new Class[] {};
            Method method = clazz.getMethod("rGetRNSContext", new Class[0]);
            return (method != null);
        } catch (SecurityException e) {
            return (false);
        } catch (NoSuchMethodException e) {
            return (false);
        }
    }

    private void marshal_(Object ro, DOMResult result) throws JAXBException {
        try {
            Node node = result.getNode();
            if (node == null) {
                Document doc = makeDomDocument_(ro);
                result.setNode(doc);
            } else if (node instanceof Document) {
                Document doc = (Document)node;
                node.appendChild(makeElement_(ro, doc));
            } else {
                Document doc = node.getOwnerDocument();
                node.appendChild(makeElement_(ro, doc));
            }
        } catch (NoSuchMethodException e) {
            throw (new JAXBException(e.getMessage()));
        } catch (IllegalAccessException e) {
            throw (new JAXBException(e.getMessage()));
        } catch (InvocationTargetException e) {
            throw (new JAXBException(e.getMessage()));
        }
    }

    private Document makeDomDocument_(Object ro)
        throws
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException {

        Class clazz = ro.getClass();
        Class[] params = new Class[] {};
        Method method = clazz.getMethod("makeDocument", params);
        Object[] args = new Object[] {};
        return ((Document)method.invoke(ro, args));
    }

    private org.w3c.dom.Element makeElement_(Object ro, Document doc)
        throws
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException {

        Class clazz = ro.getClass();
        Class[] params = new Class[] { Document.class };
        Method method = clazz.getMethod("makeElement", params);
        Object[] args = new Object[] { doc };
        return ((org.w3c.dom.Element)method.invoke(ro, args));
    }

    private void marshal_(Object ro, SAXResult result) throws JAXBException {
        ContentHandler saxHandler = result.getHandler();
        try {
            Class clazz = ro.getClass();
            Class[] params = new Class[] { ContentHandler.class };
            Method method = clazz.getMethod("makeDocument", params);
            Object[] args = new Object[] { saxHandler };
            method.invoke(ro, args);
        } catch (NoSuchMethodException e) {
            try {
                Document doc = makeDomDocument_(ro);
                DOMSAXProducer producer = new DOMSAXProducer(doc);
                producer.setContentHandler(saxHandler);
                producer.makeEvent();
            } catch (NoSuchMethodException ee) {
                throw (new JAXBException(ee.getMessage()));
            } catch (IllegalAccessException ee) {
                throw (new JAXBException(ee.getMessage()));
            } catch (InvocationTargetException ee) {
                throw (new JAXBException(ee.getMessage()));
            } catch (SAXException ee) {
                throw (new JAXBException(e.getMessage()));
            }
        } catch (IllegalAccessException e) {
            throw (new JAXBException(e.getMessage()));
        } catch (InvocationTargetException e) {
            throw (new JAXBException(e.getMessage()));
        }
    }
}
