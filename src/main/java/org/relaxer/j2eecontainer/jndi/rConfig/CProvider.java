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
 * <b>CProvider</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="provider">
 *       <attribute name="name">
 *         <data type="token"/>
 *       </attribute>
 *       <ref name="children"/>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="provider"&gt;
 *       &lt;attribute name="name"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;ref name="children"/&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 17:31:26 GMT+09:00 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class CProvider implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework/j2ee");
    private String name_;
    // List<ICChildrenChoice>
    private java.util.List children_ = new java.util.ArrayList();
    private IRNode parentRNode_;
    private java.util.Map $property$ = new java.util.HashMap();;

    /**
     * Creates a <code>CProvider</code>.
     *
     */
    public CProvider() {
        name_ = "";
    }

    /**
     * Creates a <code>CProvider</code>.
     *
     * @param source
     */
    public CProvider(CProvider source) {
        setup(source);
    }

    /**
     * Creates a <code>CProvider</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public CProvider(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>CProvider</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public CProvider(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>CProvider</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public CProvider(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>CProvider</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CProvider(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>CProvider</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CProvider(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>CProvider</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CProvider(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>CProvider</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CProvider(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>CProvider</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CProvider(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>CProvider</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CProvider(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>CProvider</code> by the CProvider <code>source</code>.
     *
     * @param source
     */
    public void setup(CProvider source) {
        int size;
        name_ = source.name_;
        this.children_.clear();
        size = source.children_.size();
        for (int i = 0;i < size;i++) {
            addChildren((ICChildrenChoice)source.getChildren(i).clone());
        }
    }

    /**
     * Initializes the <code>CProvider</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>CProvider</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>CProvider</code> by the Stack <code>stack</code>
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
        name_ = URelaxer.getAttributePropertyAsString(element, "name");
        children_.clear();
        while (true) {
            if (CDataSource.isMatch(stack)) {
                addChildren(new CDataSource(stack));
            } else if (CXADataSource.isMatch(stack)) {
                addChildren(new CXADataSource(stack));
            } else if (CBean.isMatch(stack)) {
                addChildren(new CBean(stack));
            } else if (CContext.isMatch(stack)) {
                addChildren(new CContext(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new CProvider((CProvider)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework/j2ee", "provider");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.name_ != null) {
            URelaxer.setAttributePropertyByString(element, "name", this.name_);
        }
        size = this.children_.size();
        for (int i = 0;i < size;i++) {
            ICChildrenChoice value = (ICChildrenChoice)this.children_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>CProvider</code> by the File <code>file</code>.
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
     * Initializes the <code>CProvider</code>
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
     * Initializes the <code>CProvider</code> by the URL <code>url</code>.
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
     * Initializes the <code>CProvider</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>CProvider</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>CProvider</code> by the Reader <code>reader</code>.
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
     * Gets the ICChildrenChoice property <b>children</b>.
     *
     * @return ICChildrenChoice[]
     */
    public ICChildrenChoice[] getChildren() {
        ICChildrenChoice[] array = new ICChildrenChoice[children_.size()];
        return ((ICChildrenChoice[])children_.toArray(array));
    }

    /**
     * Sets the ICChildrenChoice property <b>children</b>.
     *
     * @param children
     */
    public void setChildren(ICChildrenChoice[] children) {
        this.children_.clear();
        for (int i = 0;i < children.length;i++) {
            addChildren(children[i]);
        }
        for (int i = 0;i < children.length;i++) {
            children[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the ICChildrenChoice property <b>children</b>.
     *
     * @param children
     */
    public void setChildren(ICChildrenChoice children) {
        this.children_.clear();
        addChildren(children);
        if (children != null) {
            children.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ICChildrenChoice property <b>children</b>.
     *
     * @param children
     */
    public void addChildren(ICChildrenChoice children) {
        this.children_.add(children);
        if (children != null) {
            children.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ICChildrenChoice property <b>children</b>.
     *
     * @param children
     */
    public void addChildren(ICChildrenChoice[] children) {
        for (int i = 0;i < children.length;i++) {
            addChildren(children[i]);
        }
        for (int i = 0;i < children.length;i++) {
            children[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the ICChildrenChoice property <b>children</b>.
     *
     * @return int
     */
    public int sizeChildren() {
        return (children_.size());
    }

    /**
     * Gets the ICChildrenChoice property <b>children</b> by index.
     *
     * @param index
     * @return ICChildrenChoice
     */
    public ICChildrenChoice getChildren(int index) {
        return ((ICChildrenChoice)children_.get(index));
    }

    /**
     * Sets the ICChildrenChoice property <b>children</b> by index.
     *
     * @param index
     * @param children
     */
    public void setChildren(int index, ICChildrenChoice children) {
        this.children_.set(index, children);
        if (children != null) {
            children.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ICChildrenChoice property <b>children</b> by index.
     *
     * @param index
     * @param children
     */
    public void addChildren(int index, ICChildrenChoice children) {
        this.children_.add(index, children);
        if (children != null) {
            children.rSetParentRNode(this);
        }
    }

    /**
     * Remove the ICChildrenChoice property <b>children</b> by index.
     *
     * @param index
     */
    public void removeChildren(int index) {
        this.children_.remove(index);
    }

    /**
     * Remove the ICChildrenChoice property <b>children</b> by object.
     *
     * @param children
     */
    public void removeChildren(ICChildrenChoice children) {
        this.children_.remove(children);
    }

    /**
     * Clear the ICChildrenChoice property <b>children</b>.
     *
     */
    public void clearChildren() {
        this.children_.clear();
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
        URelaxer.makeQName(prefix, "provider", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.append(" ");
            buffer.append("name");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
        size = this.children_.size();
        for (int i = 0;i < size;i++) {
            ICChildrenChoice value = (ICChildrenChoice)this.children_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.children_.size();
        for (int i = 0;i < size;i++) {
            ICChildrenChoice value = (ICChildrenChoice)this.children_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "provider", buffer);
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
        URelaxer.makeQName(prefix, "provider", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.write(" ");
            buffer.write("name");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
        size = this.children_.size();
        for (int i = 0;i < size;i++) {
            ICChildrenChoice value = (ICChildrenChoice)this.children_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.children_.size();
        for (int i = 0;i < size;i++) {
            ICChildrenChoice value = (ICChildrenChoice)this.children_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "provider", buffer);
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
        URelaxer.makeQName(prefix, "provider", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.print(" ");
            buffer.print("name");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
        size = this.children_.size();
        for (int i = 0;i < size;i++) {
            ICChildrenChoice value = (ICChildrenChoice)this.children_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.children_.size();
        for (int i = 0;i < size;i++) {
            ICChildrenChoice value = (ICChildrenChoice)this.children_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "provider", buffer);
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
     * Sets the property value by String.
     *
     * @param string
     */
    public void setNameByString(String string) {
        setName(string);
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
        classNodes.addAll(children_);
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
     * for the <code>CProvider</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework/j2ee", "provider")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "name")) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (CDataSource.isMatchHungry(target)) {
                $match$ = true;
            } else if (CXADataSource.isMatchHungry(target)) {
                $match$ = true;
            } else if (CBean.isMatchHungry(target)) {
                $match$ = true;
            } else if (CContext.isMatchHungry(target)) {
                $match$ = true;
            } else {
                break;
            }
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>CProvider</code>.
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
     * is valid for the <code>CProvider</code>.
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
