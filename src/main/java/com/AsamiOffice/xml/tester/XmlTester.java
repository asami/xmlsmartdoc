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

package com.AsamiOffice.xml.tester;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.AsamiOffice.xml.UXMLMaker;
import com.AsamiOffice.xml.sax.Sax1DomMaker;
import com.AsamiOffice.xml.sax.Sax2DomMaker;

/**
 * XmlTester
 *
 * @since   Nov. 20, 2002
 * @version Feb.  4, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class XmlTester {
    public static final int MESSAGE_NOT_USED = 0;
    public static final int MESSAGE_NONE = 1;
    public static final int MESSAGE_INFO = 2;
    public static final int MESSAGE_DEBUG = 3;
    // object scope
    private Class targetClass_;
    private Method setupMethod_;
    private Method makeMethod_;
    private Method makeTextMethod_;
    private Method makeSax1Method_;
    private Method makeSax2Method_;
    private Method verifyMethod_;
    // test scope
    private Object targetObject_;
    private Document targetDoc_;
    private Document generatedDoc_;
    private Document generatedTextDoc_;
    // notification
    private static int gMessageLevel__ = MESSAGE_INFO;
    //    private static int gMessageLevel__ = MESSAGE_DEBUG;
    private int messageLevel_ = MESSAGE_NOT_USED;

    public XmlTester() {
        targetClass_ = null;
    }

    public XmlTester(String relaxerObject)
        throws ClassNotFoundException, NoSuchMethodException, IOException {

        _init(relaxerObject);
    }

    public XmlTester(String relaxerObject, ClassLoader loader)
        throws ClassNotFoundException, NoSuchMethodException {

        _init(relaxerObject, loader);
    }

    public XmlTester(String relaxerObject, String[] classpath)
        throws ClassNotFoundException, NoSuchMethodException, IOException {
        _init(relaxerObject, classpath);
    }

    private void _init(String relaxerObject) throws ClassNotFoundException, NoSuchMethodException, IOException {
        _init(relaxerObject, new String[] { "." });
    }

    private void _init(String relaxerObject, String[] classpath)
	throws ClassNotFoundException, NoSuchMethodException, IOException {

        URL[] urls = new URL[classpath.length];
        for (int i = 0; i < classpath.length; i++) {
            String path = classpath[i];
            try {
                urls[i] = new URL(path);
            } catch (IOException e) {
            	File file = new File(path).getCanonicalFile();
                urls[i] = file.toURL();
            }
        }
        ClassLoader loader = new URLClassLoader(urls);
        _init(relaxerObject, loader);
    }

    private void _init(String relaxerObject, ClassLoader loader) throws ClassNotFoundException, NoSuchMethodException {
        targetClass_ = loader.loadClass(relaxerObject);
        _init();
    }

    private void _init()
	throws ClassNotFoundException, NoSuchMethodException {

        setupMethod_ =
            targetClass_.getMethod("setup", new Class[] { String.class });
        makeMethod_ = targetClass_.getMethod("makeDocument", new Class[0]);
        makeTextMethod_ =
            targetClass_.getMethod("makeTextDocument", new Class[0]);
        try {
            makeSax1Method_ =
                targetClass_.getMethod(
                    "makeDocument",
                    new Class[] { org.xml.sax.DocumentHandler.class });
        } catch (NoSuchMethodException e) {
            // ignore sax
        }
        try {
            makeSax2Method_ =
                targetClass_.getMethod(
                    "makeDocument",
                    new Class[] { org.xml.sax.ContentHandler.class });
        } catch (NoSuchMethodException e) {
            // ignore sax
        }
        try {
            verifyMethod_ = targetClass_.getMethod("verify", new Class[0]);
        } catch (NoSuchMethodException e) {
            // ignore sax
        }
    }

    public Status execute(String xmlDoc)
        throws
            SecurityException, IOException, SAXException, 
            ParserConfigurationException, InstantiationException, 
            IllegalAccessException, InvocationTargetException, 
            NoSuchMethodException {
        return (execute(xmlDoc, xmlDoc));
    }

    public Status execute(Document source, String compare)
        throws
            SecurityException, IOException, SAXException, 
            ParserConfigurationException, InstantiationException, 
            IllegalAccessException, InvocationTargetException, 
            NoSuchMethodException {
        return (_compareDocument(source, _getDocument(compare)));
    }

    public Status execute(String xmlDoc, String compareDoc)
        throws
            SecurityException, IOException, SAXException, 
            ParserConfigurationException, InstantiationException, 
            IllegalAccessException, InvocationTargetException, 
            NoSuchMethodException {
        if (targetClass_ != null) {
            return (_execute(xmlDoc, compareDoc));
        } else {
            return (_compareDocument(_getDocument(xmlDoc), _getDocument(compareDoc)));
        }
    }

    private Status _execute(String xmlDoc, String compareDoc)
        throws
            IOException,
            SAXException,
            ParserConfigurationException,
            SecurityException, InstantiationException, IllegalAccessException, 
            InvocationTargetException, NoSuchMethodException {
        targetObject_ = _makeObject(xmlDoc);
        targetDoc_ = _getDocument(compareDoc);
        _messageDebug("Target doc: ", targetDoc_);
        generatedDoc_ = _generateDoc();
        generatedTextDoc_ = _generateTextDoc();
        _messageInfo("Start DOM test...");
        Status status = _compareDocument(generatedDoc_, targetDoc_);
        if (status != null) {
            return (status);
        }
        _messageInfo("Start TEXT test...");
        status = _compareDocument(generatedTextDoc_, targetDoc_);
        if (status != null) {
            return (status);
        }
        if (makeSax1Method_ != null) {
            _messageInfo("Start SAX test...");
            Document saxDoc = _generateSax1Doc();
            status = _compareDocument(saxDoc, targetDoc_);
            if (status != null) {
                return (status);
            }
        } else if (makeSax2Method_ != null) {
            _messageInfo("Start SAX test...");
            Document saxDoc = _generateSax2Doc();
            status = _compareDocument(saxDoc, targetDoc_);
            if (status != null) {
                return (status);
            }
        }
        if (verifyMethod_ != null) {
            status = _verify();
            if (status != null) {
                return (status);
            }
        }
        _messageInfo("Done.");
        return (null);
    }

    private Object _makeObject(String xmlDoc)
        throws
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {

        Object object = targetClass_.newInstance();
        setupMethod_.invoke(object, new Object[] { xmlDoc });
        return (object);
    }

    private Document _generateDoc()
        throws
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {

        Document doc =
            (Document)makeMethod_.invoke(targetObject_, new Object[0]);
        _messageDebug("doc:", doc);
        return (doc);
    }

    private Document _generateTextDoc()
        throws
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException,
            SAXException,
            ParserConfigurationException {

        try {
            String text =
                (String)makeTextMethod_.invoke(targetObject_, new Object[0]);
            _messageDebug("text doc:" + text);
            //	    Document doc = _getDocument(
            //		new ByteArrayInputStream(text.getBytes("UTF-8"))
            //	    );
            Document doc = _getDocument(new StringReader(text));
            //	    _messageDebug("???:", doc);
            return (doc);
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    private Document _generateSax1Doc()
        throws
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {

        Sax1DomMaker maker = new Sax1DomMaker();
        makeSax1Method_.invoke(targetObject_, new Object[] { maker });
        Document doc = maker.getDocument();
        _messageDebug("sax1 doc:", doc);
        return (doc);
    }

    private Document _generateSax2Doc()
        throws
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {

        Sax2DomMaker maker = new Sax2DomMaker();
        makeSax2Method_.invoke(targetObject_, new Object[] { maker });
        Document doc = maker.getDocument();
        _messageDebug("sax2 doc:" + UXMLMaker.getXMLText(doc));
        return (doc);
    }

    private Document _getDocument(String uri)
        throws IOException, SAXException, ParserConfigurationException {

        if (uri.charAt(0) == '<') {
            return (_getDocument(new StringReader(uri))); 
        } else {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //  builder.setErrorHandler(handler);
            //  builder.setEntityResolver(getEntityResolver());
            Document doc = builder.parse(uri);
            return (doc);
        }
    }

    private Document _getDocument(Reader reader)
        throws IOException, SAXException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //	builder.setErrorHandler(handler);
        //	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(new InputSource(reader));
        return (doc);
    }

    private Document _getDocument(InputStream in)
        throws IOException, SAXException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //	builder.setErrorHandler(handler);
        //	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(in);
        return (doc);
    }

    private Status _compareDocument(Document lhs, Document rhs) {
        return (
            _compareTree(lhs.getDocumentElement(), rhs.getDocumentElement()));
    }

    private Status _compareTree(Node lhs, Node rhs) {
        Status status = _compareNode(lhs, rhs);
        if (status != null) {
            return (status);
        }
        return (_compareChildren(lhs, rhs));
    }

    private Status _compareNode(Node lhs, Node rhs) {
        short lhsType = lhs.getNodeType();
        short rhsType = rhs.getNodeType();
        if (lhsType != rhsType) {
            return (new Status("Unmatch node type"));
        }
        switch (lhsType) {
            case Node.ELEMENT_NODE :
                Element lhsElement = (Element)lhs;
                Element rhsElement = (Element)rhs;
                String lhsTagName = lhsElement.getTagName(); // Tag vs. ns
                String rhsTagName = rhsElement.getTagName();
                if (!lhsTagName.equals(rhsTagName)) {
                    Status status = new Status("No match element");
                    status.lhs = lhsElement;
                    status.rhs = rhsElement;
                    status.lhsMessage = _makeElementInfo(lhsElement);
                    status.rhsMessage = _makeElementInfo(rhsElement);
                    return (status);
                }
                Status status = _compareAttributes(lhs, rhs);
                if (status != null) {
                    return (status);
                }
                return (_compareChildren(lhsElement, rhsElement));
            case Node.ATTRIBUTE_NODE :
                return (new Status("Illegal attribute node"));
            case Node.TEXT_NODE :
                return (new Status("Illegal text node"));
            case Node.CDATA_SECTION_NODE :
                return (new Status("Illegal cdata node"));
            case Node.ENTITY_REFERENCE_NODE :
                return (new Status("Illegal entity reference node"));
            case Node.ENTITY_NODE :
                return (new Status("Illegal entity node"));
            case Node.PROCESSING_INSTRUCTION_NODE :
                return (null);
            case Node.COMMENT_NODE :
                return (null);
            case Node.DOCUMENT_NODE :
                return (null);
            case Node.DOCUMENT_TYPE_NODE :
                return (new Status("Illegal document type node"));
            case Node.DOCUMENT_FRAGMENT_NODE :
                return (new Status("Illegal fragment node"));
            case Node.NOTATION_NODE :
                return (new Status("Illegal notation node"));
            default :
                throw (new InternalError());
        }
    }

    private Status _compareAttributes(Node lhs, Node rhs) {
        List lhsAttrs = _distillAttrs(lhs);
        List rhsAttrs = _distillAttrs(rhs);
        int size = lhsAttrs.size();
        if (size != rhsAttrs.size()) {
            Status status =
                new Status("The number of attributes is different.");
            status.lhs = lhs;
            status.rhs = rhs;
            status.lhsMessage = _makeAttributeInfo(lhs);
            status.rhsMessage = _makeAttributeInfo(rhs);
            return (status);
        }
        for (int i = 0; i < size; i++) {
            Attr attr = (Attr)lhsAttrs.get(i);
            Status status = _compareAttributes(attr, rhsAttrs);
            if (status != null) {
                status.lhs = lhs;
                status.rhs = rhs;
                status.lhsMessage = _makeAttributeInfo(lhs);
                status.rhsMessage = _makeAttributeInfo(rhs);
                return (status);
            }
        }
        return (null);
    }

    private List _distillAttrs(Node element) {
        List result = new ArrayList();
        NamedNodeMap attrs = element.getAttributes();
        int size = attrs.getLength();
        for (int i = 0; i < size; i++) {
            Attr attr = (Attr)attrs.item(i);
            String attrName = attr.getName();
            if (false) {
                if ("xmlns".equals(attrName) ||
                    attrName.startsWith("xmlns:")) {
                    continue;
                }
            }
            result.add(attr);
        }
        return (result);
    }

    private Status _compareAttributes(Attr attr, List attrs) {
        //	String ns = attr.getNamespaceURI();
        //	String name = attr.getLocalName();
        String attrName = attr.getName();
        int size = attrs.size();
        for (int i = 0; i < size; i++) {
            Attr targetAttr = (Attr)attrs.get(i);
            if (attrName.equals(targetAttr.getName())) {
                Status status =
                    _compareString(attr.getValue(), targetAttr.getValue());
                return (status);
            }
        }
        return (new Status("Unmatch attribute"));
    }

    private Status _compareChildren(Node lhs, Node rhs) {
        Object[] lhsChildren = _normalizeChildren(lhs.getChildNodes());
        Object[] rhsChildren = _normalizeChildren(rhs.getChildNodes());
        if (lhsChildren.length != rhsChildren.length) {
            Status status = new Status("No match children length");
            status.lhs = lhs;
            status.rhs = rhs;
            status.lhsMessage = _makeChildrenInfo(lhsChildren);
            status.rhsMessage = _makeChildrenInfo(rhsChildren);
            return (status);
        }
        for (int i = 0; i < lhsChildren.length; i++) {
            Object lhsObj = lhsChildren[i];
            Object rhsObj = rhsChildren[i];
            if (lhsObj instanceof Element) {
                if (rhsObj instanceof Element) {
                    Status status = _compareTree(
                        (Element)lhsObj,
                        (Element)rhsObj
                    );
                    if (status != null) {
                        return (status);
                    }
                } else {
                    return (new Status("Error c")); // XXX
                }
            } else if (lhsObj instanceof String) {
                if (rhsObj instanceof String) {
                    Status status = _compareString(
                        (String)lhsObj,
                        (String)rhsObj
                    );
                    if (status != null) {
                        return (status);
                    }
                } else {
                    return (new Status("Error d")); // XXX
                }
            } else {
                return (new Status("Error b")); // XXX
            }
        }
        return (null);
    }

    private Status _compareString(String lhs, String rhs) {
        if (lhs.trim().equals(rhs.trim())) {
            return (null);
        } else {
            Status status = new Status("No match string");
            status.lhsMessage = lhs;
            status.rhsMessage = rhs;
            return (status);
        }
    }

    private Object[] _normalizeChildren(NodeList children) {
        List list = new ArrayList();
        StringBuffer buffer = null;
        int size = children.getLength();
        for (int i = 0; i < size; i++) {
            Node child = children.item(i);
            switch (child.getNodeType()) {
                case Node.ELEMENT_NODE :
                    if (buffer != null) {
                        _appendString(list, buffer);
                        buffer = null;
                    }
                    list.add(child);
                    break;
                case Node.ATTRIBUTE_NODE :
                    throw (new InternalError());
                case Node.TEXT_NODE : // continue
                case Node.CDATA_SECTION_NODE :
                    if (buffer == null) {
                        buffer = new StringBuffer();
                    }
                    buffer.append(child.getNodeValue());
                    break;
                case Node.ENTITY_REFERENCE_NODE :
                    throw (new InternalError());
                case Node.ENTITY_NODE :
                    throw (new InternalError());
                case Node.PROCESSING_INSTRUCTION_NODE :
                    // do nothing
                    break;
                case Node.COMMENT_NODE :
                    // do nothing
                    break;
                case Node.DOCUMENT_NODE :
                    throw (new InternalError());
                case Node.DOCUMENT_TYPE_NODE :
                    throw (new InternalError());
                case Node.DOCUMENT_FRAGMENT_NODE :
                    throw (new InternalError());
                case Node.NOTATION_NODE :
                    throw (new InternalError());
                default :
                    throw (new InternalError());
            }
        }
        if (buffer != null) {
            _appendString(list, buffer);
        }
        Object[] result = new Object[list.size()];
        return ((Object[])list.toArray(result));
    }

    private void _appendString(List list, StringBuffer buffer) {
        int size = buffer.length();
        if (size == 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            switch (buffer.charAt(i)) {

                case ' ' :
                case '\n' :
                case '\r' :
                case '\t' :
                    break;
                default :
                    list.add(new String(buffer));
                    return;
            }
        }
    }

    private String _makeAttributeInfo(Node node) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(node.getNodeName());
        _makeAttributeInfo(node.getAttributes(), buffer);
        return (new String(buffer));
    }

    private void _makeAttributeInfo(NamedNodeMap attrs, StringBuffer buffer) {
        int size = attrs.getLength();
        buffer.append("[");
        if (size > 0) {
            Attr attr = (Attr)attrs.item(0);
            buffer.append(attr.getName());
            buffer.append("=");
            buffer.append(attr.getValue());
            for (int i = 1; i < size; i++) {
                attr = (Attr)attrs.item(i);
                buffer.append(",");
                buffer.append(attr.getName());
                buffer.append("=");
                buffer.append(attr.getValue());
            }
        }
        buffer.append("]");
    }

    private String _makeElementInfo(Element element) {
        return (UXMLMaker.getXMLText(element));
    }

    private String _makeChildrenInfo(Object[] children) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        for (int i = 0; i < children.length; i++) {
            Object child = children[i];
            buffer.append("[");
            if (child instanceof Element) {
                buffer.append(UXMLMaker.getXMLText((Element)child));
            } else if (child instanceof String) {
                buffer.append((String)child);
            } else {
                throw (new InternalError());
            }
            buffer.append("]");
        }
        buffer.append("]");
        return (new String(buffer));
    }

    private Status _verify()
    throws SecurityException, InstantiationException, 
           IllegalAccessException, InvocationTargetException, 
           NoSuchMethodException {
        Object report = verifyMethod_.invoke(targetObject_, new Object[0]);
//                 RVerifyReport report =
//                      (RVerifyReport)verifyMethod_.invoke(targetObject_, new Object[0]);
        if (_isValidReport(report)) {
            return (null);
        } else {
            return (new Status(report.toString()));
        }
    }

    private boolean _isValidReport(Object report)
        throws InstantiationException, IllegalAccessException,
               InvocationTargetException, SecurityException, NoSuchMethodException {
        Class clazz = report.getClass();
        Method isValidMethod = clazz.getMethod("isValid", new Class[0]);
        return (Boolean.TRUE.equals(isValidMethod.invoke(report, new Object[0])));
    }

    //
    public static void main(String[] args)
        throws
            IOException,
            SAXException,
            ParserConfigurationException,
            ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {

        String relaxerObject = args[0];
        String xmlDoc = args[1];
        Status status;
        if (args.length > 2) {
            String compareDoc = args[2];
            status = test(relaxerObject, xmlDoc, compareDoc);
        } else {
            status = test(relaxerObject, xmlDoc);
        }
        if (status == null) {
            System.out.println("Success.");
        } else {
            System.out.println("Error: " + status.message);
            if (status.lhsMessage != null) {
                System.out.println("relaxer = " + status.lhsMessage);
            }
            if (status.rhsMessage != null) {
                System.out.println("original = " + status.rhsMessage);
            }
        }
    }

    public static Status test(String relaxerObject, String xmlDoc)
        throws
            IOException,
            SAXException,
            ParserConfigurationException,
            ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {

        XmlTester tester = new XmlTester(relaxerObject);
        return (tester.execute(xmlDoc));
    }

    public static Status test(
        String relaxerObject,
        String xmlDoc,
        String compareDoc)
        throws
            IOException,
            SAXException,
            ParserConfigurationException,
            ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {

        XmlTester tester = new XmlTester(relaxerObject);
        return (tester.execute(xmlDoc, compareDoc));
    }

    public static Status test(
        String relaxerObject,
        String xmlDoc,
        ClassLoader loader)
        throws
            IOException,
            SAXException,
            ParserConfigurationException,
            ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {
        XmlTester tester = new XmlTester(relaxerObject, loader);
        return (tester.execute(xmlDoc));
    }

    public static Status test(
        String relaxerObject,
        String xmlDoc,
        String compareDoc,
        ClassLoader loader)
        throws
            IOException,
            SAXException,
            ParserConfigurationException,
            ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {
        XmlTester tester = new XmlTester(relaxerObject, loader);
        return (tester.execute(xmlDoc, compareDoc));
    }

    public static Status test(
        String relaxerObject,
        String xmlDoc,
        String[] classPath)
        throws
            IOException,
            SAXException,
            ParserConfigurationException,
            ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {
        XmlTester tester = new XmlTester(relaxerObject, classPath);
        return (tester.execute(xmlDoc));
    }

    public static Status test(
        String relaxerObject,
        String xmlDoc,
        String compareDoc,
        String[] classPath)
        throws
            IOException,
            SAXException,
            ParserConfigurationException,
            ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {
        XmlTester tester = new XmlTester(relaxerObject, classPath);
        return (tester.execute(xmlDoc, compareDoc));
    }

    public static void setGlobalMessageLevel(int level) {
        gMessageLevel__ = level;
    }

    public void setMessageLevel(int level) {
        messageLevel_ = level;
    }

    private void _messageInfo(String message) {
        switch (messageLevel_) {
            case MESSAGE_NOT_USED :
                switch (gMessageLevel__) {
                    case MESSAGE_NOT_USED :
                        throw (new InternalError());
                    case MESSAGE_NONE :
                        return;
                    case MESSAGE_INFO :
                        break;
                    case MESSAGE_DEBUG :
                        break;
                    default :
                        throw (new InternalError());
                }
                break;
            case MESSAGE_NONE :
                return;
            case MESSAGE_INFO :
                break;
            case MESSAGE_DEBUG :
                break;
            default :
                throw (new InternalError());
        }
        System.out.println(message);
    }

    private void _messageDebug(String message) {
        switch (messageLevel_) {
            case MESSAGE_NOT_USED :
                switch (gMessageLevel__) {
                    case MESSAGE_NOT_USED :
                        throw (new InternalError());
                    case MESSAGE_NONE :
                        return;
                    case MESSAGE_INFO :
                        return;
                    case MESSAGE_DEBUG :
                        break;
                    default :
                        throw (new InternalError());
                }
                break;
            case MESSAGE_NONE :
                return;
            case MESSAGE_INFO :
                return;
            case MESSAGE_DEBUG :
                break;
            default :
                throw (new InternalError());
        }
        System.out.println(message);
    }

    private void _messageDebug(String message, Document doc) {
        switch (messageLevel_) {
            case MESSAGE_NOT_USED :
                switch (gMessageLevel__) {
                    case MESSAGE_NOT_USED :
                        throw (new InternalError());
                    case MESSAGE_NONE :
                        return;
                    case MESSAGE_INFO :
                        return;
                    case MESSAGE_DEBUG :
                        break;
                    default :
                        throw (new InternalError());
                }
                break;
            case MESSAGE_NONE :
                return;
            case MESSAGE_INFO :
                return;
            case MESSAGE_DEBUG :
                break;
            default :
                throw (new InternalError());
        }
        Element root = doc.getDocumentElement();
        System.out.println(message + UXMLMaker.getXMLText(root));
    }

    public static class Status {
        public String message;
        public Node lhs;
        public String lhsMessage;
        public Node rhs;
        public String rhsMessage;

        public Status(String message) {
            this.message = message;
        }
    };
}
