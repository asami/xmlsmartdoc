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
package org.relaxer.j2eecontainer.jndi.rConfig;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>CBeanInit</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="init">
 *           <oneOrMore>
 *             <ref name="value"/>
 *           </oneOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="init"&gt;
 *           &lt;oneOrMore&gt;
 *             &lt;ref name="value"/&gt;
 *           &lt;/oneOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 17:31:27 GMT+09:00 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class CBeanInit implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework/j2ee");
    // List<CValue>
    private java.util.List value_ = new java.util.ArrayList();
    private IRNode parentRNode_;
    private java.util.Map $property$ = new java.util.HashMap();;

    /**
     * Creates a <code>CBeanInit</code>.
     *
     */
    public CBeanInit() {
    }

    /**
     * Creates a <code>CBeanInit</code>.
     *
     * @param source
     */
    public CBeanInit(CBeanInit source) {
        setup(source);
    }

    /**
     * Creates a <code>CBeanInit</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public CBeanInit(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>CBeanInit</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public CBeanInit(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>CBeanInit</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public CBeanInit(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>CBeanInit</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CBeanInit(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>CBeanInit</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CBeanInit(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>CBeanInit</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CBeanInit(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>CBeanInit</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CBeanInit(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>CBeanInit</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CBeanInit(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>CBeanInit</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CBeanInit(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>CBeanInit</code> by the CBeanInit <code>source</code>.
     *
     * @param source
     */
    public void setup(CBeanInit source) {
        int size;
        this.value_.clear();
        size = source.value_.size();
        for (int i = 0;i < size;i++) {
            addValue((CValue)source.getValue(i).clone());
        }
    }

    /**
     * Initializes the <code>CBeanInit</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>CBeanInit</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>CBeanInit</code> by the Stack <code>stack</code>
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
        RStack stack = new RStack(element);
        rNSContext_.declareNamespace(element);
        value_.clear();
        while (true) {
            if (CValue.isMatch(stack)) {
                addValue(new CValue(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new CBeanInit((CBeanInit)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework/j2ee", "init");
        rNSContext_.setupNamespace(element);
        int size;
        size = this.value_.size();
        for (int i = 0;i < size;i++) {
            CValue value = (CValue)this.value_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>CBeanInit</code> by the File <code>file</code>.
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
     * Initializes the <code>CBeanInit</code>
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
     * Initializes the <code>CBeanInit</code> by the URL <code>url</code>.
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
     * Initializes the <code>CBeanInit</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>CBeanInit</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>CBeanInit</code> by the Reader <code>reader</code>.
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
     * Gets the CValue property <b>value</b>.
     *
     * @return CValue[]
     */
    public CValue[] getValue() {
        CValue[] array = new CValue[value_.size()];
        return ((CValue[])value_.toArray(array));
    }

    /**
     * Sets the CValue property <b>value</b>.
     *
     * @param value
     */
    public void setValue(CValue[] value) {
        this.value_.clear();
        for (int i = 0;i < value.length;i++) {
            addValue(value[i]);
        }
        for (int i = 0;i < value.length;i++) {
            value[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the CValue property <b>value</b>.
     *
     * @param value
     */
    public void setValue(CValue value) {
        this.value_.clear();
        addValue(value);
        if (value != null) {
            value.rSetParentRNode(this);
        }
    }

    /**
     * Adds the CValue property <b>value</b>.
     *
     * @param value
     */
    public void addValue(CValue value) {
        this.value_.add(value);
        if (value != null) {
            value.rSetParentRNode(this);
        }
    }

    /**
     * Adds the CValue property <b>value</b>.
     *
     * @param value
     */
    public void addValue(CValue[] value) {
        for (int i = 0;i < value.length;i++) {
            addValue(value[i]);
        }
        for (int i = 0;i < value.length;i++) {
            value[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the CValue property <b>value</b>.
     *
     * @return int
     */
    public int sizeValue() {
        return (value_.size());
    }

    /**
     * Gets the CValue property <b>value</b> by index.
     *
     * @param index
     * @return CValue
     */
    public CValue getValue(int index) {
        return ((CValue)value_.get(index));
    }

    /**
     * Sets the CValue property <b>value</b> by index.
     *
     * @param index
     * @param value
     */
    public void setValue(int index, CValue value) {
        this.value_.set(index, value);
        if (value != null) {
            value.rSetParentRNode(this);
        }
    }

    /**
     * Adds the CValue property <b>value</b> by index.
     *
     * @param index
     * @param value
     */
    public void addValue(int index, CValue value) {
        this.value_.add(index, value);
        if (value != null) {
            value.rSetParentRNode(this);
        }
    }

    /**
     * Remove the CValue property <b>value</b> by index.
     *
     * @param index
     */
    public void removeValue(int index) {
        this.value_.remove(index);
    }

    /**
     * Remove the CValue property <b>value</b> by object.
     *
     * @param value
     */
    public void removeValue(CValue value) {
        this.value_.remove(value);
    }

    /**
     * Clear the CValue property <b>value</b>.
     *
     */
    public void clearValue() {
        this.value_.clear();
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
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/j2ee");
        buffer.append("<");
        URelaxer.makeQName(prefix, "init", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.append(">");
        size = this.value_.size();
        for (int i = 0;i < size;i++) {
            CValue value = (CValue)this.value_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "init", buffer);
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
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/j2ee");
        buffer.write("<");
        URelaxer.makeQName(prefix, "init", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.write(">");
        size = this.value_.size();
        for (int i = 0;i < size;i++) {
            CValue value = (CValue)this.value_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "init", buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/j2ee");
        buffer.print("<");
        URelaxer.makeQName(prefix, "init", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.print(">");
        size = this.value_.size();
        for (int i = 0;i < size;i++) {
            CValue value = (CValue)this.value_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "init", buffer);
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
        classNodes.addAll(value_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Gets a value of property by the key.
     *
     * @param key
     * @return Object
     */
    public Object rGetProperty(Object key) {
        return ($property$.get(key));
    }

    /**
     * Sets a value of property by the key.
     *
     * @param key
     * @param value
     * @return Object
     */
    public Object rSetProperty(Object key, Object value) {
        return ($property$.put(key, value));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>CBeanInit</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework/j2ee", "init")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!CValue.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!CValue.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>CBeanInit</code>.
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
     * is valid for the <code>CBeanInit</code>.
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
