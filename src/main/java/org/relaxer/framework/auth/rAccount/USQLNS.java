package org.relaxer.framework.auth.rAccount;

import java.util.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;

/**
 * USQLNS
 *
 * @since   Nov. 22, 2002
 * @version Sep.  5, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class USQLNS {
    public static void setBITProperty(
        ResultSet rs,
        String name,
        String path,
        Element element
    ) throws SQLException {
        String data = rs.getString(name);
        if (rs.wasNull()) {
            return;
        }
        if ("1".equals(data) ||
            "t".equalsIgnoreCase(data) ||
            "TRUE".equalsIgnoreCase(data)) {

            data = "true";
        } else {
            data = "false";
        }
        setProperty(name, path, element, data);
    }

    public static void setTIMESTAMPProperty(
        ResultSet rs,
        String name,
        String path,
        Element element
    ) throws SQLException {
        String data = rs.getString(name);
        if (rs.wasNull()) {
            return;
        }
        if (data != null) {
            data.replace(' ', 'T');
        }
        setProperty(name, path, element, data);
    }

    public static void setProperty(
        ResultSet rs,
        String name,
        String path,
        Element element
    ) throws SQLException {
        String data = rs.getString(name);
        if (rs.wasNull()) {
            return;
        }
        setProperty(name, path, element, data);
    }

    public static void setProperty(
        String name,
        String path,
        Element element,
        String data
    ) throws SQLException {
        if ("".equals(path)) {
            Document doc = element.getOwnerDocument();
            element.appendChild(doc.createTextNode(data));
        } else {
            Stack pathlist = _makePathlist(path);
            Element context = _makeContextElement(element, pathlist);
            String[] leaf = (String[])pathlist.pop();
            setPropertyInContext(context, leaf, data);
        }
    }

    private static Element _makeContextElement(
        Element element,
        Stack pathlist
    ) {
        if (pathlist.size() == 0) {
            return (element);
        }
        Document doc = element.getOwnerDocument();
        while (!(pathlist.size() == 1)) {
            String[] nodeName = (String[])pathlist.pop();
            Element target = _getTargetElement(element, nodeName);
            if (target == null) {
                target = doc.createElementNS(nodeName[0], nodeName[1]);
            }
            element.appendChild(target);
            element = target;
        }
        return (element);
    }

    private static Element _makeLeafElement(
        Element element,
        Stack pathlist
    ) {
        Document doc = element.getOwnerDocument();
        while (pathlist.size() > 0) {
            String[] nodeName = (String[])pathlist.pop();
            Element target = _getTargetElement(element, nodeName);
            if (target == null) {
                target = doc.createElementNS(nodeName[0], nodeName[1]);
            }
            element.appendChild(target);
            element = target;
        }
        return (element);
    }

    public static void setPropertyInContext(
        Element context,
        String[] leaf,
        String data
    ) {
        if (leaf[1].startsWith("@")) {
            String attrName = leaf[1].substring(1);
            if ("".equals(leaf[0])) {
                context.setAttribute(attrName, data);
            } else {
                // XXX : leaf[2]
                String prefix = _declarePrefix(context, leaf[0]);
                context.setAttributeNS(leaf[1], prefix + ":" + attrName, data);
            }
        } else {
            Document doc = context.getOwnerDocument();
            Element newElement = doc.createElementNS(leaf[0], leaf[1]);
            newElement.appendChild(doc.createTextNode(data));
            context.appendChild(newElement);
        }
    }

    private static String _declarePrefix(Element element, String ns) {
        NamedNodeMap attrs = element.getAttributes();
        int size = attrs.getLength();
        for (int i = 0;i < size;i++) {
            Attr attr = (Attr)attrs.item(i);
            String attrName = attr.getName();
            if (attrName.startsWith("xmlns:")) {
                if (ns.equals(attr.getValue())) {
                    return (attrName.substring("xmlns:".length()));
                }
            }
        }
        int counter = 1;
        for (;;) {
            String prefix = "p" + counter++;
            Attr attr = element.getAttributeNode("xmlns:" + prefix);
            if (attr == null) {
                element.setAttribute("xmlns:" + prefix, ns);
                return (prefix);
            }
        }
    }

    public static void setHedgeProperty(
        ResultSet rs,
        String name,
        String path,
        Element element
    ) throws SQLException {
        setHedgePropertyZeroOne(rs, name, path, element);
    }

    public static void setHedgePropertyZeroOne(
        ResultSet rs,
        String name,
        String path,
        Element element
    ) throws SQLException {
        try {
            String data = "<dummy>" + rs.getString(name) + "</dummy>";
            if (rs.wasNull()) {
                return;
            }
            Stack pathlist = _makePathlist(path);
            Element context = _makeContextElement(element, pathlist);
            RDomBuilder builder = new RDomBuilder(context);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();
            parser.parse(new InputSource(new StringReader(data)), builder);
        } catch (ParserConfigurationException e) {
            throw (new SQLException(e.getMessage()));
        } catch (SAXException e) {
            throw (new SQLException(e.getMessage()));
        } catch (IOException e) {
            throw (new SQLException(e.getMessage()));
        }
    }

    public static void setHedgePropertyOne(
        ResultSet rs,
        String name,
        String path,
        Element element
    ) throws SQLException {
        Stack pathlist = _makePathlist(path);
        Element context = _makeContextElement(element, pathlist);
        setHedgeProperty(rs, name, context);
    }

    public static void setHedgeProperty(
        ResultSet rs,
        String name,
        Element element
    ) throws SQLException {
        try {
            String data = "<dummy>" + rs.getString(name) + "</dummy>";
            if (rs.wasNull()) {
                return;
            }
            RDomBuilder builder = new RDomBuilder(element);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();
            parser.parse(new InputSource(new StringReader(data)), builder);
        } catch (ParserConfigurationException e) {
            throw (new SQLException(e.getMessage()));
        } catch (SAXException e) {
            throw (new SQLException(e.getMessage()));
        } catch (IOException e) {
            throw (new SQLException(e.getMessage()));
        }
    }

/*
    static class DOMBuilder extends HandlerBase { // ContentBase
        private Document doc_;
        private Element element_;
        private Stack stack_ = new Stack();
        private StringBuffer buffer_;
        private int depth_;

        DOMBuilder(Element element) {
            doc_ = element.getOwnerDocument();
            element_ = element;
        }

        public void startDocument() {
            buffer_ = new StringBuffer();
            depth_ = 0;
        }

        public void endDocument() {
            _makeString();
        }

        public void startElement(String name, AttributeList atts) {
            if (depth_++ == 0) {
                return;
            }
            _makeString();
            Element parent = element_;
            Element child = doc_.createElement(name);
            int size = atts.getLength();
            for (int i = 0;i < size;i++) {
                child.setAttribute(atts.getName(i), atts.getValue(i));
            }
            parent.appendChild(child);
            stack_.push(parent);
            element_ = child;
        }

        public void endElement(String name) {
            if (--depth_ > 0) {
                _makeString();
                element_ = (Element)stack_.pop();
            }
        }

        public void characters(char ch[], int start, int length) {
            if (buffer_ != null) {
                buffer_.append(ch, start, length);
            }
        }

        private void _makeString() {
            if (buffer_ != null && buffer_.length() > 0) {
                element_.appendChild(
                    doc_.createTextNode(new String(buffer_))
                );
            }
            buffer_ = new StringBuffer();
        }

        public void warning(SAXParseException e) {
            e.printStackTrace();
        }

        public void error(SAXParseException e) {
            e.printStackTrace();
        }

        public void fatalError(SAXParseException e) {
            e.printStackTrace();
        }
    }
*/

    public static void setBOOLEANValue(
        Element element,
        String path,
        PreparedStatement st,
        int index
    ) throws SQLException {
        String xmlString = getPropertyAsString(element, path);
        if (xmlString == null) {
            return;
        }
        if ("1".equals(xmlString) ||
            "true".equals(xmlString)) {

            st.setBoolean(index, true);
        } else {
            st.setBoolean(index, false);
        }
    }

    public static String getBITPropertyAsString(
        Element element,
        String path
    ) {
        String xmlString = getPropertyAsString(element, path);
        if (xmlString == null) {
            return (null);
        }
        if ("true".equals(xmlString) ||
            "1".equals(xmlString)) {

            return ("1");
        } else {
            return ("0");
        }
    }

    public static String getTIMESTAMPPropertyAsString(
        Element element,
        String path
    ) {
        String xmlString = getPropertyAsString(element, path);
        if (xmlString == null) {
            return (null);
        }
        return (xmlString.replace('T', ' '));
    }

    public static String getPropertyAsString(Element element, String path) {
        if ("".equals(path)) {
            return (node2Text(element));
        } else {
            Stack pathlist = _makePathlist(path);
            Element context = _getContextElement(element, pathlist);
            if (context == null) {
                return (null);
            }
            String[] leaf = (String[])pathlist.pop();
            return (getPropertyInContextAsString(context, leaf));
        }
    }

    private static Stack _makePathlist(String path) {
        if ("".equals(path)) {
            return (new Stack());
        }
        int state = 0;
        int size = path.length();
        List list = new ArrayList();
        StringBuffer ns = new StringBuffer();
        StringBuffer local = new StringBuffer();
        StringBuffer prefix = null;
        for (int i = 0;i < size;i++) {
            char c = path.charAt(i);
            switch (state) {
            case 0:
                if (c == '<') {
                    state = 1;
                } else if (c == '/') {
                    String[] name = new String[3];
                    name[0] = new String(ns);
                    name[1] = new String(local);
                    if (prefix != null) {
                        name[2] = new String(prefix);
                    }
                    ns = new StringBuffer();
                    local = new StringBuffer();
                    prefix = null;
                    list.add(name);
                } else if (c == ':') {
                    prefix = local;
                    local = new StringBuffer();
                } else {
                    local.append(c);
                }
                break;
            case 1:
                if (c == '>') {
                    state = 0;
                } else {
                    ns.append(c);
                }
                break;
            default:
                throw (new InternalError());
            }
        }
        if (local.length() > 0) {
            String[] name = new String[3];
            name[0] = new String(ns);
            name[1] = new String(local);
            if (prefix != null) {
                name[2] = new String(prefix);
            }
            list.add(name);
        }
        Stack stack = new Stack();
        size = list.size();
        for (int i = size - 1;i >= 0;i--) {
            String[] name = (String[])list.get(i);
            stack.push(name);
        }
        return (stack);
    }

    private static Element _getContextElement(
        Element element,
        Stack pathlist
    ) {
        if (pathlist.size() == 0) {
            return (element);
        }
        while (!(pathlist.size() == 1)) {
            String[] nodeName = (String[])pathlist.pop();
            Element target = _getTargetElement(element, nodeName);
            if (target == null) {
                return (null);
            }
            element = target;
        }
        return (element);
    }

    private static Element _getTargetElement(
        Element context,
        String[] nodeName
    ) {
        NodeList children = context.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (_isTargetElement(child, nodeName)) {
                return ((Element)child);
            }
        }    
        return (null);
    }

    public static String getPropertyInContextAsString(
        Element element,
        String[] leaf
    ) {
        int index = leaf[1].indexOf("@");
        if (index == -1) {
            return (getElementPropertyAsString(element, leaf));
        } else {
            return (getAttributePropertyAsString(element, leaf));
        }
    }

    public static String getAttributePropertyAsString(
        Element element,
        String[] name
    ) {
        String attrName = name[1].substring(1);
        Attr attr;
        if ("".equals(name[0])) {
            attr = element.getAttributeNode(attrName);
        } else {
            attr = element.getAttributeNodeNS(name[0], attrName);
        }
        if (attr == null) {
            return (null);
        }
        return (attr.getValue());
    }

    public static String getElementPropertyAsString(
        Element element,
        String[] name
    ) {
        NodeList children = element.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (_isTargetElement(child, name)) {
                return (node2Text(child));
            }
        }
        return (null);
    }

    public static String getHedgePropertyAsXMLString(
        Element element,
        String path
    ) {
        Stack pathlist = _makePathlist(path);
        Element context = _getContextElement(element, pathlist);
        if (context == null) {
            return (null);
        }
        String[] leaf = (String[])pathlist.pop();
        return (getHedgePropertyInContextAsXMLString(context, leaf));
    }

    public static String getHedgePropertyInContextAsXMLString(
        Element element,
        String[] name
    ) {
        StringWriter buffer = new StringWriter();
        PrintWriter out = new PrintWriter(buffer);
        NodeList children = element.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (_isTargetElement(child, name)) {
                _node2String4Data(child, out);
            }
        }
        String string = buffer.toString();
        if (string.length() == 0) {
            return (null);
        } else {
            return (string);
        }
    }

    private static boolean _isTargetElement(
        Node node,
        String[] name
    ) {
        if (!(node instanceof Element)) {
            return (false);
        }
        String ns = node.getNamespaceURI();
        if (ns == null) {
            ns = "";
        }
        String local = node.getLocalName();
        if (local == null) {
            local = node.getNodeName();
        }
        return (name[0].equals(ns) && name[1].equals(local));
    }

    public static String element2Data(Element element) {
        return (element2Text(element).trim());
    }

    public static String element2Text(Element element) {
        return (node2Text(element));
    }

    public static String nodes2Text(Node[] nodes) {
        StringBuffer buffer = new StringBuffer();
        int nNodes = nodes.length;
        for (int i = 0;i < nNodes;i++) {
            node2Text(nodes[i], buffer);
        }
        return (new String(buffer));
    }

    public static String node2Text(Node node) {
        StringBuffer buffer = new StringBuffer();
        node2Text(node, buffer);
        return (new String(buffer));
    }

    public static void node2Text(Node node, StringBuffer buffer) {
        switch(node.getNodeType()) {

        case Node.DOCUMENT_NODE:
        case Node.ELEMENT_NODE:
        case Node.ENTITY_REFERENCE_NODE:
            NodeList nodes = node.getChildNodes();
            int nNodes = nodes.getLength();
            for (int i = 0;i < nNodes;i++) {
                node2Text(nodes.item(i), buffer);
            }
            break;
        case Node.ATTRIBUTE_NODE:
            throw (new UnsupportedOperationException("not supported yet"));
        case Node.COMMENT_NODE:
        case Node.PROCESSING_INSTRUCTION_NODE:
            // do nothing
            break;
        case Node.TEXT_NODE:
        case Node.CDATA_SECTION_NODE:
            Text text = (Text)node;
            buffer.append(text.getData());
            break;
        default:
            throw (new UnsupportedOperationException("not supported yet"));
        }
    }

/*
    public static void getXMLValue(Node node, PrintWriter buffer) {
        NodeList children = node.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (child instanceof Text) {
                Text text = (Text)child;
                buffer.print(text.getData());
            }
        }
    }
*/

    public static void printXMLDocument(Node node) {
        PrintWriter out = new PrintWriter(System.out);
        _node2String4Data(node, out);
        out.println();
        out.flush();
    }

    public static String makeXMLDocument(Node node) {
        return (node2String4Data(node));
    }

    public static String node2String4Data(Node node) {
        StringWriter buffer = new StringWriter();
        PrintWriter out = new PrintWriter(buffer);
        _node2String4Data(node, out);
        return (buffer.toString());
    }

    private static void _node2String4Data(Node node, PrintWriter buffer) {
        switch(node.getNodeType()) {

        case Node.DOCUMENT_NODE:
            Document doc = (Document)node;
            _node2String4Data(doc.getDocumentElement(), buffer);
            break;
        case Node.ELEMENT_NODE:
            Element element = (Element)node;
            String tag = element.getTagName();
            buffer.print('<');
            buffer.print(tag);
            NamedNodeMap attrs = element.getAttributes();
            int size = attrs.getLength();
            for (int i = 0;i < size;i++) {
                Attr attr = (Attr)attrs.item(i);
                buffer.print(' ');
                buffer.print(attr.getName());
                buffer.print("=\"");
                buffer.print(attr.getValue());
                buffer.print('\"');
            }
            buffer.print('>');
            _node2String4DataChildren(element, buffer);
            buffer.print("</");
            buffer.print(tag);
            buffer.print('>');
            break;
        case Node.ATTRIBUTE_NODE:
            throw (new UnsupportedOperationException("not supported yet"));
        case Node.COMMENT_NODE:
            throw (new UnsupportedOperationException("not supported yet"));
        case Node.TEXT_NODE:
        case Node.CDATA_SECTION_NODE:
            Text text = (Text)node;
            buffer.print(escapeCharData(text.getData()));
            break;
        default:
            throw (new UnsupportedOperationException("not supported yet"));
        }
    }

    private static void _node2String4DataChildren(
        Node node,
        PrintWriter buffer
    ) {
        NodeList nodes = node.getChildNodes();
        int nNodes = nodes.getLength();
        for (int i = 0;i < nNodes;i++) {
            _node2String4Data(nodes.item(i), buffer);
        }
    }

    public static String escapeCharData(String string) {
        if (string.indexOf('<') == -1 &&
            string.indexOf('&') == -1 &&
            string.indexOf(">") == -1) {

            return (string);
        }
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            if (c == '<') {
                buffer.append("&lt;");
            } else if (c == '&') {
                buffer.append("&amp;");
            } else if (c == '>') {
                buffer.append("&gt;");
            } else {
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    public static Document makeDocument()
        throws ParserConfigurationException {

        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return (builder.newDocument());
    }

    public static Document makeDocument(
        ResultSet rs,
        String column
    ) throws SQLException {
        Document[] docs = makeDocuments(rs, column);
        if (docs.length == 0) {
            return (null);
        } else {
            return (docs[0]);
        }
    }

    public static Document[] makeDocuments(
        ResultSet rs,
        String column
    ) throws SQLException {
        try {
            List list = new ArrayList();
            while (rs.next()) {
                String text = rs.getString(column);
                Reader reader = new StringReader(text);
                Document doc = makeDocument(reader);
                list.add(doc);
            }
            Document[] docs = new Document[list.size()];
            return ((Document[])list.toArray(docs));
        } catch (ParserConfigurationException e) {
            throw (new SQLException(e.getMessage()));
        } catch (SAXException e) {
            throw (new SQLException(e.getMessage()));
        } catch (IOException e) {
            throw (new SQLException(e.getMessage()));
        }
    }

    public static Element[] makeElements(
        ResultSet rs,
        String column,
        Document doc
    ) throws SQLException {
        throw (new UnsupportedOperationException());
    }

    public static Document makeDocument(String uri)
        throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return (builder.parse(uri));
    }

    public static Document makeDocument(File file)
        throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return (builder.parse(file));
    }

    public static Document makeDocument(URL url)
        throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return (builder.parse(url.toExternalForm()));
    }

    public static Document makeDocument(InputStream in)
        throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return (builder.parse(in));
    }

    public static Document makeDocument(InputSource is)
        throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return (builder.parse(is));
    }

    public static Document makeDocument(Reader reader)
        throws ParserConfigurationException, SAXException, IOException {

        InputSource is = new InputSource(reader);
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return (builder.parse(is));
    }

    public static Document makeNewDocument(String ns, String name)
        throws ParserConfigurationException {
        
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElementNS(ns, name);
        root.setAttribute("xmlns", ns);
        doc.appendChild(root);
        return (doc);
    }
}
