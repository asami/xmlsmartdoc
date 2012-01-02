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
 * <b>GcAdapter</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="adapter">
 *       <ref name="port.common"/>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="adapter"&gt;
 *       &lt;ref name="port.common"/&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Fri Jul 29 11:55:13 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class GcAdapter implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.xmlsmartdoc.org/xmlns/goldenport");
    private String name_;
    private String javaClass_;
    // List<GcSelecter>
    private java.util.List selecter_ = new java.util.ArrayList();
    // List<GcProperty>
    private java.util.List property_ = new java.util.ArrayList();
    private Element xmlElement;
    private IRNode parentRNode_;

    /**
     * Creates a <code>GcAdapter</code>.
     *
     */
    public GcAdapter() {
        name_ = "";
        javaClass_ = "";
    }

    /**
     * Creates a <code>GcAdapter</code>.
     *
     * @param source
     */
    public GcAdapter(GcAdapter source) {
        setup(source);
    }

    /**
     * Creates a <code>GcAdapter</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public GcAdapter(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>GcAdapter</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public GcAdapter(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>GcAdapter</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public GcAdapter(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>GcAdapter</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcAdapter(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>GcAdapter</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcAdapter(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>GcAdapter</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcAdapter(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>GcAdapter</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcAdapter(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>GcAdapter</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcAdapter(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>GcAdapter</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public GcAdapter(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>GcAdapter</code> by the GcAdapter <code>source</code>.
     *
     * @param source
     */
    public void setup(GcAdapter source) {
        int size;
        name_ = source.name_;
        javaClass_ = source.javaClass_;
        this.selecter_.clear();
        size = source.selecter_.size();
        for (int i = 0;i < size;i++) {
            addSelecter((GcSelecter)source.getSelecter(i).clone());
        }
        this.property_.clear();
        size = source.property_.size();
        for (int i = 0;i < size;i++) {
            addProperty((GcProperty)source.getProperty(i).clone());
        }
    }

    /**
     * Initializes the <code>GcAdapter</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>GcAdapter</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>GcAdapter</code> by the Stack <code>stack</code>
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
        name_ = URelaxer.getAttributePropertyAsString(element, "name");
        javaClass_ = URelaxer.getAttributePropertyAsString(element, "java.class");
        selecter_.clear();
        while (true) {
            if (GcSelecter.isMatch(stack)) {
                addSelecter(new GcSelecter(stack));
            } else {
                break;
            }
        }
        property_.clear();
        while (true) {
            if (GcProperty.isMatch(stack)) {
                addProperty(new GcProperty(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new GcAdapter((GcAdapter)this));
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
        Element element = doc.createElementNS("http://www.xmlsmartdoc.org/xmlns/goldenport", "adapter");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.name_ != null) {
            URelaxer.setAttributePropertyByString(element, "name", this.name_);
        }
        if (this.javaClass_ != null) {
            URelaxer.setAttributePropertyByString(element, "java.class", this.javaClass_);
        }
        size = this.selecter_.size();
        for (int i = 0;i < size;i++) {
            GcSelecter value = (GcSelecter)this.selecter_.get(i);
            value.makeElement(element);
        }
        size = this.property_.size();
        for (int i = 0;i < size;i++) {
            GcProperty value = (GcProperty)this.property_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>GcAdapter</code> by the File <code>file</code>.
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
     * Initializes the <code>GcAdapter</code>
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
     * Initializes the <code>GcAdapter</code> by the URL <code>url</code>.
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
     * Initializes the <code>GcAdapter</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>GcAdapter</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>GcAdapter</code> by the Reader <code>reader</code>.
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
     * Gets the GcSelecter property <b>selecter</b>.
     *
     * @return GcSelecter[]
     */
    public GcSelecter[] getSelecter() {
        GcSelecter[] array = new GcSelecter[selecter_.size()];
        return ((GcSelecter[])selecter_.toArray(array));
    }

    /**
     * Sets the GcSelecter property <b>selecter</b>.
     *
     * @param selecter
     */
    public void setSelecter(GcSelecter[] selecter) {
        this.selecter_.clear();
        for (int i = 0;i < selecter.length;i++) {
            addSelecter(selecter[i]);
        }
        for (int i = 0;i < selecter.length;i++) {
            selecter[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the GcSelecter property <b>selecter</b>.
     *
     * @param selecter
     */
    public void setSelecter(GcSelecter selecter) {
        this.selecter_.clear();
        addSelecter(selecter);
        if (selecter != null) {
            selecter.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcSelecter property <b>selecter</b>.
     *
     * @param selecter
     */
    public void addSelecter(GcSelecter selecter) {
        this.selecter_.add(selecter);
        if (selecter != null) {
            selecter.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcSelecter property <b>selecter</b>.
     *
     * @param selecter
     */
    public void addSelecter(GcSelecter[] selecter) {
        for (int i = 0;i < selecter.length;i++) {
            addSelecter(selecter[i]);
        }
        for (int i = 0;i < selecter.length;i++) {
            selecter[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the GcSelecter property <b>selecter</b>.
     *
     * @return int
     */
    public int sizeSelecter() {
        return (selecter_.size());
    }

    /**
     * Gets the GcSelecter property <b>selecter</b> by index.
     *
     * @param index
     * @return GcSelecter
     */
    public GcSelecter getSelecter(int index) {
        return ((GcSelecter)selecter_.get(index));
    }

    /**
     * Sets the GcSelecter property <b>selecter</b> by index.
     *
     * @param index
     * @param selecter
     */
    public void setSelecter(int index, GcSelecter selecter) {
        this.selecter_.set(index, selecter);
        if (selecter != null) {
            selecter.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcSelecter property <b>selecter</b> by index.
     *
     * @param index
     * @param selecter
     */
    public void addSelecter(int index, GcSelecter selecter) {
        this.selecter_.add(index, selecter);
        if (selecter != null) {
            selecter.rSetParentRNode(this);
        }
    }

    /**
     * Remove the GcSelecter property <b>selecter</b> by index.
     *
     * @param index
     */
    public void removeSelecter(int index) {
        this.selecter_.remove(index);
    }

    /**
     * Remove the GcSelecter property <b>selecter</b> by object.
     *
     * @param selecter
     */
    public void removeSelecter(GcSelecter selecter) {
        this.selecter_.remove(selecter);
    }

    /**
     * Clear the GcSelecter property <b>selecter</b>.
     *
     */
    public void clearSelecter() {
        this.selecter_.clear();
    }

    /**
     * Gets the GcProperty property <b>property</b>.
     *
     * @return GcProperty[]
     */
    public GcProperty[] getProperty() {
        GcProperty[] array = new GcProperty[property_.size()];
        return ((GcProperty[])property_.toArray(array));
    }

    /**
     * Sets the GcProperty property <b>property</b>.
     *
     * @param property
     */
    public void setProperty(GcProperty[] property) {
        this.property_.clear();
        for (int i = 0;i < property.length;i++) {
            addProperty(property[i]);
        }
        for (int i = 0;i < property.length;i++) {
            property[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the GcProperty property <b>property</b>.
     *
     * @param property
     */
    public void setProperty(GcProperty property) {
        this.property_.clear();
        addProperty(property);
        if (property != null) {
            property.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcProperty property <b>property</b>.
     *
     * @param property
     */
    public void addProperty(GcProperty property) {
        this.property_.add(property);
        if (property != null) {
            property.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcProperty property <b>property</b>.
     *
     * @param property
     */
    public void addProperty(GcProperty[] property) {
        for (int i = 0;i < property.length;i++) {
            addProperty(property[i]);
        }
        for (int i = 0;i < property.length;i++) {
            property[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the GcProperty property <b>property</b>.
     *
     * @return int
     */
    public int sizeProperty() {
        return (property_.size());
    }

    /**
     * Gets the GcProperty property <b>property</b> by index.
     *
     * @param index
     * @return GcProperty
     */
    public GcProperty getProperty(int index) {
        return ((GcProperty)property_.get(index));
    }

    /**
     * Sets the GcProperty property <b>property</b> by index.
     *
     * @param index
     * @param property
     */
    public void setProperty(int index, GcProperty property) {
        this.property_.set(index, property);
        if (property != null) {
            property.rSetParentRNode(this);
        }
    }

    /**
     * Adds the GcProperty property <b>property</b> by index.
     *
     * @param index
     * @param property
     */
    public void addProperty(int index, GcProperty property) {
        this.property_.add(index, property);
        if (property != null) {
            property.rSetParentRNode(this);
        }
    }

    /**
     * Remove the GcProperty property <b>property</b> by index.
     *
     * @param index
     */
    public void removeProperty(int index) {
        this.property_.remove(index);
    }

    /**
     * Remove the GcProperty property <b>property</b> by object.
     *
     * @param property
     */
    public void removeProperty(GcProperty property) {
        this.property_.remove(property);
    }

    /**
     * Clear the GcProperty property <b>property</b>.
     *
     */
    public void clearProperty() {
        this.property_.clear();
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
        URelaxer.makeQName(prefix, "adapter", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("", "name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
        if (javaClass_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("", "java.class", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getJavaClass())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.selecter_.size();
        for (int i = 0;i < size;i++) {
            GcSelecter value = (GcSelecter)this.selecter_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.property_.size();
        for (int i = 0;i < size;i++) {
            GcProperty value = (GcProperty)this.property_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "adapter", buffer);
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
        URelaxer.makeQName(prefix, "adapter", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("", "name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
        if (javaClass_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("", "java.class", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getJavaClass())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.selecter_.size();
        for (int i = 0;i < size;i++) {
            GcSelecter value = (GcSelecter)this.selecter_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.property_.size();
        for (int i = 0;i < size;i++) {
            GcProperty value = (GcProperty)this.property_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "adapter", buffer);
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
        URelaxer.makeQName(prefix, "adapter", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("", "name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
        if (javaClass_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("", "java.class", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getJavaClass())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.selecter_.size();
        for (int i = 0;i < size;i++) {
            GcSelecter value = (GcSelecter)this.selecter_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.property_.size();
        for (int i = 0;i < size;i++) {
            GcProperty value = (GcProperty)this.property_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "adapter", buffer);
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
        classNodes.addAll(selecter_);
        classNodes.addAll(property_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>GcAdapter</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.xmlsmartdoc.org/xmlns/goldenport", "adapter")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "name")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer.hasAttributeHungry(target, "java.class")) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!GcSelecter.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!GcProperty.isMatchHungry(target)) {
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
     * is valid for the <code>GcAdapter</code>.
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
     * is valid for the <code>GcAdapter</code>.
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
