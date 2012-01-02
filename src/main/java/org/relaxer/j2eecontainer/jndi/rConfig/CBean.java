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
 * <b>CBean</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="Bean">
 *       <ref name="nodeAttrs"/>
 *       <element name="java.class">
 *         <data type="token"/>
 *       </element>
 *       <optional>
 *         <element name="classpath">
 *           <data type="token"/>
 *         </element>
 *       </optional>
 *       <optional>
 *         <element name="init">
 *           <oneOrMore>
 *             <ref name="value"/>
 *           </oneOrMore>
 *         </element>
 *       </optional>
 *       <zeroOrMore>
 *         <ref name="property"/>
 *       </zeroOrMore>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="Bean"&gt;
 *       &lt;ref name="nodeAttrs"/&gt;
 *       &lt;element name="java.class"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/element&gt;
 *       &lt;optional&gt;
 *         &lt;element name="classpath"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/element&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;element name="init"&gt;
 *           &lt;oneOrMore&gt;
 *             &lt;ref name="value"/&gt;
 *           &lt;/oneOrMore&gt;
 *         &lt;/element&gt;
 *       &lt;/optional&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="property"/&gt;
 *       &lt;/zeroOrMore&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 17:31:27 GMT+09:00 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class CBean implements java.io.Serializable, Cloneable, IRNSContainer, IRNode, ICChildrenChoice {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework/j2ee");
    private String name_;
    private String javaClass_;
    private String classpath_;
    private CBeanInit beanInit_;
    // List<CProperty>
    private java.util.List property_ = new java.util.ArrayList();
    private IRNode parentRNode_;
    private java.util.Map $property$ = new java.util.HashMap();;

    /**
     * Creates a <code>CBean</code>.
     *
     */
    public CBean() {
        name_ = "";
        javaClass_ = "";
    }

    /**
     * Creates a <code>CBean</code>.
     *
     * @param source
     */
    public CBean(CBean source) {
        setup(source);
    }

    /**
     * Creates a <code>CBean</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public CBean(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>CBean</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public CBean(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>CBean</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public CBean(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>CBean</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CBean(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>CBean</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CBean(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>CBean</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CBean(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>CBean</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CBean(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>CBean</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CBean(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>CBean</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CBean(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>CBean</code> by the CBean <code>source</code>.
     *
     * @param source
     */
    public void setup(CBean source) {
        int size;
        name_ = source.name_;
        javaClass_ = source.javaClass_;
        classpath_ = source.classpath_;
        if (source.beanInit_ != null) {
            setBeanInit((CBeanInit)source.getBeanInit().clone());
        }
        this.property_.clear();
        size = source.property_.size();
        for (int i = 0;i < size;i++) {
            addProperty((CProperty)source.getProperty(i).clone());
        }
    }

    /**
     * Initializes the <code>CBean</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>CBean</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>CBean</code> by the Stack <code>stack</code>
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
        javaClass_ = URelaxer.getElementPropertyAsString(stack.popElement());
        classpath_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.relaxer.org/xmlns/framework/j2ee", "classpath");
        if (CBeanInit.isMatch(stack)) {
            setBeanInit(new CBeanInit(stack));
        }
        property_.clear();
        while (true) {
            if (CProperty.isMatch(stack)) {
                addProperty(new CProperty(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new CBean((CBean)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework/j2ee", "Bean");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.name_ != null) {
            URelaxer.setAttributePropertyByString(element, "name", this.name_);
        }
        URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework/j2ee", "java.class", this.javaClass_, rNSContext_);
        if (this.classpath_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework/j2ee", "classpath", this.classpath_, rNSContext_);
        }
        if (this.beanInit_ != null) {
            this.beanInit_.makeElement(element);
        }
        size = this.property_.size();
        for (int i = 0;i < size;i++) {
            CProperty value = (CProperty)this.property_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>CBean</code> by the File <code>file</code>.
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
     * Initializes the <code>CBean</code>
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
     * Initializes the <code>CBean</code> by the URL <code>url</code>.
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
     * Initializes the <code>CBean</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>CBean</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>CBean</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>javaClass</b>.
     *
     * @return String
     */
    public String getJavaClass() {
        return (javaClass_);
    }

    /**
     * Sets the String property <b>javaClass</b>.
     *
     * @param javaClass
     */
    public void setJavaClass(String javaClass) {
        this.javaClass_ = javaClass;
    }

    /**
     * Gets the String property <b>classpath</b>.
     *
     * @return String
     */
    public String getClasspath() {
        return (classpath_);
    }

    /**
     * Sets the String property <b>classpath</b>.
     *
     * @param classpath
     */
    public void setClasspath(String classpath) {
        this.classpath_ = classpath;
    }

    /**
     * Gets the CBeanInit property <b>BeanInit</b>.
     *
     * @return CBeanInit
     */
    public CBeanInit getBeanInit() {
        return (beanInit_);
    }

    /**
     * Sets the CBeanInit property <b>BeanInit</b>.
     *
     * @param beanInit
     */
    public void setBeanInit(CBeanInit beanInit) {
        this.beanInit_ = beanInit;
        if (beanInit != null) {
            beanInit.rSetParentRNode(this);
        }
    }

    /**
     * Gets the CProperty property <b>property</b>.
     *
     * @return CProperty[]
     */
    public CProperty[] getProperty() {
        CProperty[] array = new CProperty[property_.size()];
        return ((CProperty[])property_.toArray(array));
    }

    /**
     * Sets the CProperty property <b>property</b>.
     *
     * @param property
     */
    public void setProperty(CProperty[] property) {
        this.property_.clear();
        for (int i = 0;i < property.length;i++) {
            addProperty(property[i]);
        }
        for (int i = 0;i < property.length;i++) {
            property[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the CProperty property <b>property</b>.
     *
     * @param property
     */
    public void setProperty(CProperty property) {
        this.property_.clear();
        addProperty(property);
        if (property != null) {
            property.rSetParentRNode(this);
        }
    }

    /**
     * Adds the CProperty property <b>property</b>.
     *
     * @param property
     */
    public void addProperty(CProperty property) {
        this.property_.add(property);
        if (property != null) {
            property.rSetParentRNode(this);
        }
    }

    /**
     * Adds the CProperty property <b>property</b>.
     *
     * @param property
     */
    public void addProperty(CProperty[] property) {
        for (int i = 0;i < property.length;i++) {
            addProperty(property[i]);
        }
        for (int i = 0;i < property.length;i++) {
            property[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the CProperty property <b>property</b>.
     *
     * @return int
     */
    public int sizeProperty() {
        return (property_.size());
    }

    /**
     * Gets the CProperty property <b>property</b> by index.
     *
     * @param index
     * @return CProperty
     */
    public CProperty getProperty(int index) {
        return ((CProperty)property_.get(index));
    }

    /**
     * Sets the CProperty property <b>property</b> by index.
     *
     * @param index
     * @param property
     */
    public void setProperty(int index, CProperty property) {
        this.property_.set(index, property);
        if (property != null) {
            property.rSetParentRNode(this);
        }
    }

    /**
     * Adds the CProperty property <b>property</b> by index.
     *
     * @param index
     * @param property
     */
    public void addProperty(int index, CProperty property) {
        this.property_.add(index, property);
        if (property != null) {
            property.rSetParentRNode(this);
        }
    }

    /**
     * Remove the CProperty property <b>property</b> by index.
     *
     * @param index
     */
    public void removeProperty(int index) {
        this.property_.remove(index);
    }

    /**
     * Remove the CProperty property <b>property</b> by object.
     *
     * @param property
     */
    public void removeProperty(CProperty property) {
        this.property_.remove(property);
    }

    /**
     * Clear the CProperty property <b>property</b>.
     *
     */
    public void clearProperty() {
        this.property_.clear();
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
        URelaxer.makeQName(prefix, "Bean", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("", "name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
        buffer.append(">");
        buffer.append("<");
        URelaxer.makeQName(prefix, "java.class", buffer);
        buffer.append(">");
        buffer.append(URelaxer.escapeCharData(URelaxer.getString(getJavaClass())));
        buffer.append("</");
        URelaxer.makeQName(prefix, "java.class", buffer);
        buffer.append(">");
        if (classpath_ != null) {
            buffer.append("<");
            URelaxer.makeQName(prefix, "classpath", buffer);
            buffer.append(">");
            buffer.append(URelaxer.escapeCharData(URelaxer.getString(getClasspath())));
            buffer.append("</");
            URelaxer.makeQName(prefix, "classpath", buffer);
            buffer.append(">");
        }
        if (beanInit_ != null) {
            beanInit_.makeTextElement(buffer);
        }
        size = this.property_.size();
        for (int i = 0;i < size;i++) {
            CProperty value = (CProperty)this.property_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "Bean", buffer);
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
        URelaxer.makeQName(prefix, "Bean", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("", "name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
        buffer.write(">");
        buffer.write("<");
        URelaxer.makeQName(prefix, "java.class", buffer);
        buffer.write(">");
        buffer.write(URelaxer.escapeCharData(URelaxer.getString(getJavaClass())));
        buffer.write("</");
        URelaxer.makeQName(prefix, "java.class", buffer);
        buffer.write(">");
        if (classpath_ != null) {
            buffer.write("<");
            URelaxer.makeQName(prefix, "classpath", buffer);
            buffer.write(">");
            buffer.write(URelaxer.escapeCharData(URelaxer.getString(getClasspath())));
            buffer.write("</");
            URelaxer.makeQName(prefix, "classpath", buffer);
            buffer.write(">");
        }
        if (beanInit_ != null) {
            beanInit_.makeTextElement(buffer);
        }
        size = this.property_.size();
        for (int i = 0;i < size;i++) {
            CProperty value = (CProperty)this.property_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "Bean", buffer);
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
        URelaxer.makeQName(prefix, "Bean", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("", "name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
        buffer.print(">");
        buffer.print("<");
        URelaxer.makeQName(prefix, "java.class", buffer);
        buffer.print(">");
        buffer.print(URelaxer.escapeCharData(URelaxer.getString(getJavaClass())));
        buffer.print("</");
        URelaxer.makeQName(prefix, "java.class", buffer);
        buffer.print(">");
        if (classpath_ != null) {
            buffer.print("<");
            URelaxer.makeQName(prefix, "classpath", buffer);
            buffer.print(">");
            buffer.print(URelaxer.escapeCharData(URelaxer.getString(getClasspath())));
            buffer.print("</");
            URelaxer.makeQName(prefix, "classpath", buffer);
            buffer.print(">");
        }
        if (beanInit_ != null) {
            beanInit_.makeTextElement(buffer);
        }
        size = this.property_.size();
        for (int i = 0;i < size;i++) {
            CProperty value = (CProperty)this.property_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "Bean", buffer);
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
    public String getJavaClassAsString() {
        return (URelaxer.getString(getJavaClass()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getClasspathAsString() {
        return (URelaxer.getString(getClasspath()));
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
    public void setJavaClassByString(String string) {
        setJavaClass(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setClasspathByString(String string) {
        setClasspath(string);
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
        if (beanInit_ != null) {
            classNodes.add(beanInit_);
        }
        classNodes.addAll(property_);
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
     * for the <code>CBean</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework/j2ee", "Bean")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "name")) {
            return (false);
        }
        $match$ = true;
        child = target.popElement();
        if (child == null) {
            return (false);
        }
        if (!URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework/j2ee", "java.class")) {
            return (false);
        }
        $match$ = true;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework/j2ee", "classpath")) {
                target.popElement();
            }
        }
        $match$ = true;
        if (CBeanInit.isMatchHungry(target)) {
        }
        while (true) {
            if (!CProperty.isMatchHungry(target)) {
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
     * is valid for the <code>CBean</code>.
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
     * is valid for the <code>CBean</code>.
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
