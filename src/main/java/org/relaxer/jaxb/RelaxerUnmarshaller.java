/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
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

import java.util.*;
import java.lang.reflect.*;
import java.io.IOException;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.bind.JAXBException;
import javax.xml.bind.helpers.*;
import javax.xml.transform.Result;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.*;
import org.w3c.dom.*;

import com.AsamiOffice.xml.sax.DOMMakerContentHandler;

/**
 * RelaxerUnmarshaller
 *
 * @since   Feb. 17, 2003
 * @version Feb. 25, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RelaxerUnmarshaller extends AbstractUnmarshallerImpl {
    private RelaxerJaxbContext context_;
    private UnmarshallerHandler handler_;

    public RelaxerUnmarshaller(RelaxerJaxbContext context)
	throws ParserConfigurationException {

	context_ = context;
	handler_ = _makeHandler();
    }

    public UnmarshallerHandler getUnmarshallerHandler() {
	return (handler_);
    }

    public Object unmarshal(Node node) throws JAXBException {
	if (node instanceof Document) {
	    return (_unmarshal((Document)node));
	} else if (node instanceof Element) {
	    return (_unmarshal((Element)node));
	} else {
	    throw (new JAXBException(""));
	}
    }

    private Object _unmarshal(Document doc) throws JAXBException {
	Object factory = context_.getRelaxerFactory();
	Class clazz = factory.getClass();
	try {
	    Class[] params = new Class[] { Document.class };
	    Method method = clazz.getMethod("create", params);
	    Object[] args = new Object[] { doc };
	    return (method.invoke(factory, args));
	} catch (NoSuchMethodException e) {
	    throw (new JAXBException(e.getMessage()));
	} catch (IllegalAccessException e) {
	    throw (new JAXBException(e.getMessage()));
	} catch (InvocationTargetException e) {
	    throw (new JAXBException(e.getMessage()));
	}
    }

    private Object _unmarshal(Element element) throws JAXBException {
	Object factory = context_.getRelaxerFactory();
	Class clazz = factory.getClass();
	try {
	    Class[] params = new Class[] { Element.class };
	    Method method = clazz.getMethod("create", params);
	    Object[] args = new Object[] { element };
	    return (method.invoke(factory, args));
	} catch (NoSuchMethodException e) {
	    throw (new JAXBException(e.getMessage()));
	} catch (IllegalAccessException e) {
	    throw (new JAXBException(e.getMessage()));
	} catch (InvocationTargetException e) {
	    throw (new JAXBException(e.getMessage()));
	}
    }

    public Object unmarshal(XMLReader reader, InputSource is)
	throws JAXBException {

	try {
	    return (_unmarshalSax(reader, is));
	} catch (NoSuchMethodException e) {
	    return (_unmarshalDom(reader, is));
	} catch (IllegalAccessException e) {
	    return (_unmarshalDom(reader, is));
	} catch (InvocationTargetException e) {
	    return (_unmarshalDom(reader, is));
	} catch (IOException e) {
	    throw (new JAXBException(e.getMessage()));
	} catch (SAXException e) {
	    throw (new JAXBException(e.getMessage()));
	}
    }

    private Object _unmarshalSax(XMLReader reader, InputSource is)
	throws NoSuchMethodException, IllegalAccessException,
	       InvocationTargetException, IOException, SAXException {

	Object factory = context_.getRelaxerFactory();
	ContentHandler handler = _getSaxHandler(factory);
	reader.setContentHandler(handler);
	reader.parse(is);
	return (_getSaxResult(handler));
    }

    private ContentHandler _getSaxHandler(Object factory)
	throws NoSuchMethodException, IllegalAccessException,
	       InvocationTargetException {

	Class clazz = factory.getClass();
	Class[] params = new Class[] {};
	Method method = clazz.getMethod("getSaxHandler", params);
	Object[] args = new Object[] {};
	return ((ContentHandler)method.invoke(factory, args));
    }

    private Object _getSaxResult(Object handler)
	throws NoSuchMethodException, IllegalAccessException,
	       InvocationTargetException {

	Class clazz = handler.getClass();
	Class[] params = new Class[] {};
	Method method = clazz.getMethod("get", params);
	Object[] args = new Object[] {};
	return (method.invoke(handler, args));
    }

    private Object _unmarshalDom(XMLReader reader, InputSource is)
	throws JAXBException {

	try {
	    DOMMakerContentHandler maker = new DOMMakerContentHandler();
	    reader.setContentHandler(maker);
	    reader.parse(is);
	    return (_unmarshal(maker.getDocument()));
	} catch (ParserConfigurationException e) {
	    throw (new JAXBException(e.getMessage()));
	} catch (SAXException e) {
	    throw (new JAXBException(e.getMessage()));
	} catch (IOException e) {
	    throw (new JAXBException(e.getMessage()));
	}
    }

    private UnmarshallerHandler _makeHandler()
	throws ParserConfigurationException{

	try {
	    Object factory = context_.getRelaxerFactory();
	    ContentHandler handler = _getSaxHandler(factory);
	    return (new SAXUnmarshallerHandler(handler));
	} catch (NoSuchMethodException e) {
	    return (new DOMMakerUnmarshallerHandler());
	} catch (IllegalAccessException e) {
	    return (new DOMMakerUnmarshallerHandler());
	} catch (InvocationTargetException e) {
	    return (new DOMMakerUnmarshallerHandler());
	}
    }

    class DOMMakerUnmarshallerHandler extends Handler {
	DOMMakerUnmarshallerHandler() throws ParserConfigurationException {
	    super(new DOMMakerContentHandler());
	}

	public void endDocument() throws SAXException {
	    super.endDocument();
	    try {
		DOMMakerContentHandler domHandler
		    = (DOMMakerContentHandler)saxHandler_;
		result_ = _unmarshal(domHandler.getDocument());
	    } catch (JAXBException e) {
		throw (new SAXException(e.getMessage()));
	    }
	}
    }

    class SAXUnmarshallerHandler extends Handler {
	SAXUnmarshallerHandler(ContentHandler handler) {
	    super(handler);
	}

	public void endDocument() throws SAXException {
	    super.endDocument();
	    try {
		result_ = _getSaxResult(saxHandler_);
	    } catch (NoSuchMethodException e) {
		throw (new SAXException(e.getMessage()));
	    } catch (IllegalAccessException e) {
		throw (new SAXException(e.getMessage()));
	    } catch (InvocationTargetException e) {
		throw (new SAXException(e.getMessage()));
	    }
	}
    }

    abstract class Handler implements UnmarshallerHandler {
	protected ContentHandler saxHandler_;
	protected Object result_;

	public Handler(ContentHandler handler) {
	    saxHandler_ = handler;
	}

	public Object getResult() {
	    return (result_);
	}

	public void setDocumentLocator(Locator locator) {
	    saxHandler_.setDocumentLocator(locator);
	}

	public void startDocument() throws SAXException {
	    saxHandler_.startDocument();
	}

	public void endDocument() throws SAXException {
	    saxHandler_.endDocument();
	}

	public void startPrefixMapping(String prefix, String uri)
	    throws SAXException {

	    saxHandler_.startPrefixMapping(prefix, uri);
	}

	public void endPrefixMapping(String prefix) throws SAXException {
	    saxHandler_.endPrefixMapping(prefix);
	}

	public void startElement(
	    String uri,
	    String localName,
	    String qName,
	    Attributes attrs
	) throws SAXException {
	    saxHandler_.startElement(uri, localName, qName, attrs);
	}

	public void endElement(
	    String uri,
	    String localName,
	    String qName
	) throws SAXException {
	    saxHandler_.endElement(uri, localName, qName);
	}

	public void characters(char[] chars, int start, int length)
	    throws SAXException {

	    saxHandler_.characters(chars, start, length);
	}

	public void ignorableWhitespace(char[] chars, int start, int length)
	    throws SAXException {

	    saxHandler_.ignorableWhitespace(chars, start, length);
	}

	public void processingInstruction(String target, String data)
	    throws SAXException  {

	    saxHandler_.processingInstruction(target, data);
	}

	public void skippedEntity(String name) throws SAXException {
	    saxHandler_.skippedEntity(name);
	}
    }
}
