/*
 * The Relaxer artifact
 * Copyright (c) 2000-2004, ASAMI Tomoharu, All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer. 
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.xmlsmartdoc.goldenport.config;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.xmlsmartdoc.goldenport.lib.*;

/**
 * <b>GcSelecter</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="selecter">
 *       <optional>
 *         <element name="name">
 *           <data type="token"/>
 *         </element>
 *       </optional>
 *       <optional>
 *         <element name="namespace">
 *           <data type="token"/>
 *         </element>
 *       </optional>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="selecter"&gt;
 *       &lt;optional&gt;
 *         &lt;element name="name"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/element&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;element name="namespace"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/element&gt;
 *       &lt;/optional&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Fri Jul 29 11:55:13 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class GcSelecter implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.xmlsmartdoc.org/xmlns/goldenport");
    private String name_;
    private String namespace_;
    private Element xmlElement;
    private IRNode parentRNode_;

    /**
     * Creates a <code>GcSelecter</code>.
     *
     */
    public GcSelecter() {
    }

    /**
     * Creates a <code>GcSelecter</code>.
     *
     * @param source
     */
    public GcSelecter(GcSelecter source) {
        setup(source);
    }

    /**
     * Creates a <code>GcSelecter</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public GcSelecter(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>GcSelecter</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public GcSelecter(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>GcSelecter</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public GcSelecter(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>GcSelecter</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcSelecter(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>GcSelecter</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcSelecter(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>GcSelecter</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcSelecter(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>GcSelecter</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcSelecter(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>GcSelecter</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcSelecter(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>GcSelecter</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcSelecter(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>GcSelecter</code> by the GcSelecter <code>source</code>.
     *
     * @param source
     */
    public void setup(GcSelecter source) {
        int size;
        name_ = source.name_;
        namespace_ = source.namespace_;
    }

    /**
     * Initializes the <code>GcSelecter</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>GcSelecter</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>GcSelecter</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public void setup(RStack stack) {
        init(stack.popElement());
    }

    /**
     * @param element
     */
    private void init(Element element) {
        xmlElement = element;
        RStack stack = new RStack(element);
        rNSContext_.declareNamespace(element);
        name_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.xmlsmartdoc.org/xmlns/goldenport", "name");
        namespace_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.xmlsmartdoc.org/xmlns/goldenport", "namespace");
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new GcSelecter((GcSelecter)this));
    }

    /**
     * Creates a DOM representation of the object.
     * Result is appended to the Node <code>parent</code>.
     *
     * @param parent
     */
    public void makeElement(Node parent) {
        Document doc;
        if (parent instanceof Document) {
            doc = (Document)parent;
        } else {
            doc = parent.getOwnerDocument();
        }
        Element element = doc.createElementNS("http://www.xmlsmartdoc.org/xmlns/goldenport", "selecter");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.name_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.xmlsmartdoc.org/xmlns/goldenport", "name", this.name_, rNSContext_);
        }
        if (this.namespace_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.xmlsmartdoc.org/xmlns/goldenport", "namespace", this.namespace_, rNSContext_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>GcSelecter</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file.toURL());
    }

    /**
     * Initializes the <code>GcSelecter</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(uri, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>GcSelecter</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(url, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>GcSelecter</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(in, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>GcSelecter</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(is, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>GcSelecter</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(reader, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Creates a DOM document representation of the object.
     *
     * @exception ParserConfigurationException
     * @return Document
     */
    public Document makeDocument() throws ParserConfigurationException {
        Document doc = UJAXP.makeDocument();
        makeElement(doc);
        return (doc);
    }

    /**
     * Gets the RNSContext property <b>RNSContext</b>.
     *
     * @return RNSContext
     */
    public RNSContext rGetRNSContext() {
        return (rNSContext_);
    }

    /**
     * Sets the RNSContext property <b>RNSContext</b>.
     *
     * @param rNSContext
     */
    public void rSetRNSContext(RNSContext rNSContext) {
        this.rNSContext_ = rNSContext;
    }

    /**
     * Gets the String property <b>name</b>.
     *
     * @return String
     */
    public String getName() {
        return (name_);
    }

    /**
     * Sets the String property <b>name</b>.
     *
     * @param name
     */
    public void setName(String name) {
        this.name_ = name;
    }

    /**
     * Gets the String property <b>namespace</b>.
     *
     * @return String
     */
    public String getNamespace() {
        return (namespace_);
    }

    /**
     * Sets the String property <b>namespace</b>.
     *
     * @param namespace
     */
    public void setNamespace(String namespace) {
        this.namespace_ = namespace;
    }

    /**
     * Gets the element to be used in the object construction.
     *
     * @return Element
     */
    public Element rGetElement() {
        return (xmlElement);
    }

    /**
     * Makes an XML text representation.
     *
     * @return String
     */
    public String makeTextDocument() {
        StringBuffer buffer = new StringBuffer();
        makeTextElement(buffer);
        return (new String(buffer));
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(StringBuffer buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("http://www.xmlsmartdoc.org/xmlns/goldenport");
        buffer.append("<");
        URelaxer.makeQName(prefix, "selecter", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.append(">");
        if (name_ != null) {
            buffer.append("<");
            URelaxer.makeQName(prefix, "name", buffer);
            buffer.append(">");
            buffer.append(URelaxer.escapeCharData(URelaxer.getString(getName())));
            buffer.append("</");
            URelaxer.makeQName(prefix, "name", buffer);
            buffer.append(">");
        }
        if (namespace_ != null) {
            buffer.append("<");
            URelaxer.makeQName(prefix, "namespace", buffer);
            buffer.append(">");
            buffer.append(URelaxer.escapeCharData(URelaxer.getString(getNamespace())));
            buffer.append("</");
            URelaxer.makeQName(prefix, "namespace", buffer);
            buffer.append(">");
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "selecter", buffer);
        buffer.append(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        String prefix = rNSContext_.getPrefixByUri("http://www.xmlsmartdoc.org/xmlns/goldenport");
        buffer.write("<");
        URelaxer.makeQName(prefix, "selecter", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.write(">");
        if (name_ != null) {
            buffer.write("<");
            URelaxer.makeQName(prefix, "name", buffer);
            buffer.write(">");
            buffer.write(URelaxer.escapeCharData(URelaxer.getString(getName())));
            buffer.write("</");
            URelaxer.makeQName(prefix, "name", buffer);
            buffer.write(">");
        }
        if (namespace_ != null) {
            buffer.write("<");
            URelaxer.makeQName(prefix, "namespace", buffer);
            buffer.write(">");
            buffer.write(URelaxer.escapeCharData(URelaxer.getString(getNamespace())));
            buffer.write("</");
            URelaxer.makeQName(prefix, "namespace", buffer);
            buffer.write(">");
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "selecter", buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("http://www.xmlsmartdoc.org/xmlns/goldenport");
        buffer.print("<");
        URelaxer.makeQName(prefix, "selecter", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.print(">");
        if (name_ != null) {
            buffer.print("<");
            URelaxer.makeQName(prefix, "name", buffer);
            buffer.print(">");
            buffer.print(URelaxer.escapeCharData(URelaxer.getString(getName())));
            buffer.print("</");
            URelaxer.makeQName(prefix, "name", buffer);
            buffer.print(">");
        }
        if (namespace_ != null) {
            buffer.print("<");
            URelaxer.makeQName(prefix, "namespace", buffer);
            buffer.print(">");
            buffer.print(URelaxer.escapeCharData(URelaxer.getString(getNamespace())));
            buffer.print("</");
            URelaxer.makeQName(prefix, "namespace", buffer);
            buffer.print(">");
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "selecter", buffer);
        buffer.print(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(StringBuffer buffer) {
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextAttribute(Writer buffer) throws IOException {
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(PrintWriter buffer) {
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getNameAsString() {
        return (URelaxer.getString(getName()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getNamespaceAsString() {
        return (URelaxer.getString(getNamespace()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setNameByString(String string) {
        setName(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setNamespaceByString(String string) {
        setNamespace(string);
    }

    /**
     * Returns a String representation of this object.
     * While this method informs as XML format representaion, 
     *  it's purpose is just information, not making 
     * a rigid XML documentation.
     *
     * @return String
     */
    public String toString() {
        try {
            return (makeTextDocument());
        } catch (Exception e) {
            return (super.toString());
        }
    }

    /**
     * Gets the IRNode property <b>parentRNode</b>.
     *
     * @return IRNode
     */
    public IRNode rGetParentRNode() {
        return (parentRNode_);
    }

    /**
     * Sets the IRNode property <b>parentRNode</b>.
     *
     * @param parentRNode
     */
    public void rSetParentRNode(IRNode parentRNode) {
        this.parentRNode_ = parentRNode;
    }

    /**
     * Gets child RNodes.
     *
     * @return IRNode[]
     */
    public IRNode[] rGetRNodes() {
        java.util.List classNodes = new java.util.ArrayList();
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>GcSelecter</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.xmlsmartdoc.org/xmlns/goldenport", "selecter")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer2.isTargetElement(child, "http://www.xmlsmartdoc.org/xmlns/goldenport", "name")) {
                target.popElement();
            }
        }
        $match$ = true;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer2.isTargetElement(child, "http://www.xmlsmartdoc.org/xmlns/goldenport", "namespace")) {
                target.popElement();
            }
        }
        $match$ = true;
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>GcSelecter</code>.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return boolean
     */
    public static boolean isMatch(RStack stack) {
        Element element = stack.peekElement();
        if (element == null) {
            return (false);
        }
        return (isMatch(element));
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>GcSelecter</code>.
     * This method consumes the stack contents during matching operation.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return boolean
     */
    public static boolean isMatchHungry(RStack stack) {
        Element element = stack.peekElement();
        if (element == null) {
            return (false);
        }
        if (isMatch(element)) {
            stack.popElement();
            return (true);
        } else {
            return (false);
        }
    }
}
