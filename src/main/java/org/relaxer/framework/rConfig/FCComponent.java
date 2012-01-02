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
package org.relaxer.framework.rConfig;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>FCComponent</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="component">
 *       <attribute java:mapKey="true" name="name">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="java.class">
 *         <data type="token"/>
 *       </attribute>
 *       <optional>
 *         <attribute name="java.type">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <optional>
 *         <attribute name="jndi.name">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <zeroOrMore>
 *         <ref name="attribute"/>
 *       </zeroOrMore>
 *       <zeroOrMore>
 *         <ref name="operation"/>
 *       </zeroOrMore>
 *       <optional>
 *         <ref name="extension"/>
 *       </optional>
 *       <optional>
 *         <ref name="realization"/>
 *       </optional>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="component"&gt;
 *       &lt;attribute java:mapKey="true" name="name"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="java.class"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="java.type"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="jndi.name"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="attribute"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="operation"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;optional&gt;
 *         &lt;ref name="extension"/&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;ref name="realization"/&gt;
 *       &lt;/optional&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:39 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCComponent extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    private String name_;
    private String javaClass_;
    private String javaType_;
    private String jndiName_;
    // List<FCAttribute>
    private java.util.List attribute_ = new java.util.ArrayList();
    private java.util.Map attribute_$map = new java.util.HashMap();
    // List<FCOperation>
    private java.util.List operation_ = new java.util.ArrayList();
    private java.util.Map operation_$map = new java.util.HashMap();
    private FCExtension extension_;
    private FCRealization realization_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCComponent</code>.
     *
     */
    public FCComponent() {
        name_ = "";
        javaClass_ = "";
    }

    /**
     * Creates a <code>FCComponent</code>.
     *
     * @param source
     */
    public FCComponent(FCComponent source) {
        setup(source);
    }

    /**
     * Creates a <code>FCComponent</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCComponent(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCComponent</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponent(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCComponent</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponent(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCComponent</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponent(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCComponent</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponent(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCComponent</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponent(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCComponent</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponent(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCComponent</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponent(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCComponent</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponent(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCComponent</code> by the FCComponent <code>source</code>.
     *
     * @param source
     */
    public void setup(FCComponent source) {
        int size;
        name_ = source.name_;
        javaClass_ = source.javaClass_;
        javaType_ = source.javaType_;
        jndiName_ = source.jndiName_;
        this.attribute_.clear();
        size = source.attribute_.size();
        for (int i = 0;i < size;i++) {
            addAttribute((FCAttribute)source.getAttribute(i).clone());
        }
        this.operation_.clear();
        size = source.operation_.size();
        for (int i = 0;i < size;i++) {
            addOperation((FCOperation)source.getOperation(i).clone());
        }
        if (source.extension_ != null) {
            setExtension((FCExtension)source.getExtension().clone());
        }
        if (source.realization_ != null) {
            setRealization((FCRealization)source.getRealization().clone());
        }
    }

    /**
     * Initializes the <code>FCComponent</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public void setup(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FCComponent</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public void setup(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        IConfigFactory factory = ConfigFactory.getFactory();
        org.iso_relax.verifier.Verifier verifier = factory.getVerifier();
        if (verifier != null) {
            verifier.verify(element);
        } else {
            UIsoRelax.verifyElementByResource("/org/relaxer/framework/rConfig/config.rng", element, factory.getErrorHandler());
        }
        init(element);
    }

    /**
     * Initializes the <code>FCComponent</code> by the Stack <code>stack</code>
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
        IConfigFactory factory = ConfigFactory.getFactory();
        RStack stack = new RStack(element);
        rNSContext_.declareNamespace(element);
        name_ = URelaxer.getAttributePropertyAsString(element, "name");
        javaClass_ = URelaxer.getAttributePropertyAsString(element, "java.class");
        javaType_ = URelaxer.getAttributePropertyAsString(element, "java.type");
        jndiName_ = URelaxer.getAttributePropertyAsString(element, "jndi.name");
        attribute_.clear();
        while (true) {
            if (FCAttribute.isMatch(stack)) {
                addAttribute(factory.createFCAttribute(stack));
            } else {
                break;
            }
        }
        operation_.clear();
        while (true) {
            if (FCOperation.isMatch(stack)) {
                addOperation(factory.createFCOperation(stack));
            } else {
                break;
            }
        }
        if (FCExtension.isMatch(stack)) {
            setExtension(factory.createFCExtension(stack));
        }
        if (FCRealization.isMatch(stack)) {
            setRealization(factory.createFCRealization(stack));
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        IConfigFactory factory = ConfigFactory.getFactory();
        return (factory.createFCComponent((FCComponent)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework", "component");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.name_ != null) {
            URelaxer.setAttributePropertyByString(element, "name", this.name_);
        }
        if (this.javaClass_ != null) {
            URelaxer.setAttributePropertyByString(element, "java.class", this.javaClass_);
        }
        if (this.javaType_ != null) {
            URelaxer.setAttributePropertyByString(element, "java.type", this.javaType_);
        }
        if (this.jndiName_ != null) {
            URelaxer.setAttributePropertyByString(element, "jndi.name", this.jndiName_);
        }
        size = this.attribute_.size();
        for (int i = 0;i < size;i++) {
            FCAttribute value = (FCAttribute)this.attribute_.get(i);
            value.makeElement(element);
        }
        size = this.operation_.size();
        for (int i = 0;i < size;i++) {
            FCOperation value = (FCOperation)this.operation_.get(i);
            value.makeElement(element);
        }
        if (this.extension_ != null) {
            this.extension_.makeElement(element);
        }
        if (this.realization_ != null) {
            this.realization_.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCComponent</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public void setup(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file.toURL());
    }

    /**
     * Initializes the <code>FCComponent</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public void setup(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(UJAXP.getDocument(uri, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>FCComponent</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public void setup(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(UJAXP.getDocument(url, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>FCComponent</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public void setup(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(UJAXP.getDocument(in, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>FCComponent</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public void setup(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(UJAXP.getDocument(is, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>FCComponent</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public void setup(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
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
     * Gets the String property <b>javaType</b>.
     *
     * @return String
     */
    public String getJavaType() {
        return (javaType_);
    }

    /**
     * Sets the String property <b>javaType</b>.
     *
     * @param javaType
     */
    public void setJavaType(String javaType) {
        this.javaType_ = javaType;
    }

    /**
     * Gets the String property <b>jndiName</b>.
     *
     * @return String
     */
    public String getJndiName() {
        return (jndiName_);
    }

    /**
     * Sets the String property <b>jndiName</b>.
     *
     * @param jndiName
     */
    public void setJndiName(String jndiName) {
        this.jndiName_ = jndiName;
    }

    /**
     * Gets the FCAttribute property <b>attribute</b>.
     *
     * @return FCAttribute[]
     */
    public FCAttribute[] getAttribute() {
        FCAttribute[] array = new FCAttribute[attribute_.size()];
        return ((FCAttribute[])attribute_.toArray(array));
    }

    /**
     * Sets the FCAttribute property <b>attribute</b>.
     *
     * @param attribute
     */
    public void setAttribute(FCAttribute[] attribute) {
        this.attribute_.clear();
        for (int i = 0;i < attribute.length;i++) {
            addAttribute(attribute[i]);
        }
        for (int i = 0;i < attribute.length;i++) {
            attribute[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCAttribute property <b>attribute</b>.
     *
     * @param attribute
     */
    public void setAttribute(FCAttribute attribute) {
        this.attribute_.clear();
        addAttribute(attribute);
        if (attribute != null) {
            attribute.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCAttribute property <b>attribute</b>.
     *
     * @param attribute
     */
    public void addAttribute(FCAttribute attribute) {
        Object $key$ = attribute.getName();
        if ($key$ != null) {
            Object $value$ = this.attribute_$map.get($key$);
            if ($value$ != null) {
                this.attribute_.remove($value$);
        }
            this.attribute_$map.put($key$, attribute);
        }
        this.attribute_.add(attribute);
        if (attribute != null) {
            attribute.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCAttribute property <b>attribute</b>.
     *
     * @param attribute
     */
    public void addAttribute(FCAttribute[] attribute) {
        for (int i = 0;i < attribute.length;i++) {
            addAttribute(attribute[i]);
        }
        for (int i = 0;i < attribute.length;i++) {
            attribute[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCAttribute property <b>attribute</b>.
     *
     * @return int
     */
    public int sizeAttribute() {
        return (attribute_.size());
    }

    /**
     * Gets the FCAttribute property <b>attribute</b> by index.
     *
     * @param index
     * @return FCAttribute
     */
    public FCAttribute getAttribute(int index) {
        return ((FCAttribute)attribute_.get(index));
    }

    /**
     * Sets the FCAttribute property <b>attribute</b> by index.
     *
     * @param index
     * @param attribute
     */
    public void setAttribute(int index, FCAttribute attribute) {
        Object $key$ = attribute.getName();
        if ($key$ != null) {
            Object $value$ = this.attribute_$map.get($key$);
            if ($value$ != null) {
                this.attribute_.remove($value$);
        }
            this.attribute_$map.put($key$, attribute);
        }
        this.attribute_.set(index, attribute);
        if (attribute != null) {
            attribute.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCAttribute property <b>attribute</b> by index.
     *
     * @param index
     * @param attribute
     */
    public void addAttribute(int index, FCAttribute attribute) {
        Object $key$ = attribute.getName();
        if ($key$ != null) {
            Object $value$ = this.attribute_$map.get($key$);
            if ($value$ != null) {
                this.attribute_.remove($value$);
        }
            this.attribute_$map.put($key$, attribute);
        }
        this.attribute_.add(index, attribute);
        if (attribute != null) {
            attribute.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCAttribute property <b>attribute</b> by index.
     *
     * @param index
     */
    public void removeAttribute(int index) {
        FCAttribute $value$ = (FCAttribute)attribute_.get(index);
        if ($value$ != null) {
            removeAttribute($value$);
        }
        this.attribute_.remove(index);
    }

    /**
     * Remove the FCAttribute property <b>attribute</b> by object.
     *
     * @param attribute
     */
    public void removeAttribute(FCAttribute attribute) {
        Object $key$ = attribute.getName();
        this.attribute_$map.remove($key$);
        this.attribute_.remove(attribute);
    }

    /**
     * Clear the FCAttribute property <b>attribute</b>.
     *
     */
    public void clearAttribute() {
        this.attribute_$map.clear();
        this.attribute_.clear();
    }

    /**
     * Gets the FCAttribute property <b>attribute</b> by key.
     *
     * @param key
     * @return FCAttribute
     */
    public FCAttribute getAttributeByName(String key) {
        return ((FCAttribute)attribute_$map.get(key));
    }

    /**
     * Gets the FCOperation property <b>operation</b>.
     *
     * @return FCOperation[]
     */
    public FCOperation[] getOperation() {
        FCOperation[] array = new FCOperation[operation_.size()];
        return ((FCOperation[])operation_.toArray(array));
    }

    /**
     * Sets the FCOperation property <b>operation</b>.
     *
     * @param operation
     */
    public void setOperation(FCOperation[] operation) {
        this.operation_.clear();
        for (int i = 0;i < operation.length;i++) {
            addOperation(operation[i]);
        }
        for (int i = 0;i < operation.length;i++) {
            operation[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCOperation property <b>operation</b>.
     *
     * @param operation
     */
    public void setOperation(FCOperation operation) {
        this.operation_.clear();
        addOperation(operation);
        if (operation != null) {
            operation.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCOperation property <b>operation</b>.
     *
     * @param operation
     */
    public void addOperation(FCOperation operation) {
        Object $key$ = operation.getName();
        if ($key$ != null) {
            Object $value$ = this.operation_$map.get($key$);
            if ($value$ != null) {
                this.operation_.remove($value$);
        }
            this.operation_$map.put($key$, operation);
        }
        this.operation_.add(operation);
        if (operation != null) {
            operation.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCOperation property <b>operation</b>.
     *
     * @param operation
     */
    public void addOperation(FCOperation[] operation) {
        for (int i = 0;i < operation.length;i++) {
            addOperation(operation[i]);
        }
        for (int i = 0;i < operation.length;i++) {
            operation[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCOperation property <b>operation</b>.
     *
     * @return int
     */
    public int sizeOperation() {
        return (operation_.size());
    }

    /**
     * Gets the FCOperation property <b>operation</b> by index.
     *
     * @param index
     * @return FCOperation
     */
    public FCOperation getOperation(int index) {
        return ((FCOperation)operation_.get(index));
    }

    /**
     * Sets the FCOperation property <b>operation</b> by index.
     *
     * @param index
     * @param operation
     */
    public void setOperation(int index, FCOperation operation) {
        Object $key$ = operation.getName();
        if ($key$ != null) {
            Object $value$ = this.operation_$map.get($key$);
            if ($value$ != null) {
                this.operation_.remove($value$);
        }
            this.operation_$map.put($key$, operation);
        }
        this.operation_.set(index, operation);
        if (operation != null) {
            operation.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCOperation property <b>operation</b> by index.
     *
     * @param index
     * @param operation
     */
    public void addOperation(int index, FCOperation operation) {
        Object $key$ = operation.getName();
        if ($key$ != null) {
            Object $value$ = this.operation_$map.get($key$);
            if ($value$ != null) {
                this.operation_.remove($value$);
        }
            this.operation_$map.put($key$, operation);
        }
        this.operation_.add(index, operation);
        if (operation != null) {
            operation.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCOperation property <b>operation</b> by index.
     *
     * @param index
     */
    public void removeOperation(int index) {
        FCOperation $value$ = (FCOperation)operation_.get(index);
        if ($value$ != null) {
            removeOperation($value$);
        }
        this.operation_.remove(index);
    }

    /**
     * Remove the FCOperation property <b>operation</b> by object.
     *
     * @param operation
     */
    public void removeOperation(FCOperation operation) {
        Object $key$ = operation.getName();
        this.operation_$map.remove($key$);
        this.operation_.remove(operation);
    }

    /**
     * Clear the FCOperation property <b>operation</b>.
     *
     */
    public void clearOperation() {
        this.operation_$map.clear();
        this.operation_.clear();
    }

    /**
     * Gets the FCOperation property <b>operation</b> by key.
     *
     * @param key
     * @return FCOperation
     */
    public FCOperation getOperationByName(String key) {
        return ((FCOperation)operation_$map.get(key));
    }

    /**
     * Gets the FCExtension property <b>extension</b>.
     *
     * @return FCExtension
     */
    public FCExtension getExtension() {
        return (extension_);
    }

    /**
     * Sets the FCExtension property <b>extension</b>.
     *
     * @param extension
     */
    public void setExtension(FCExtension extension) {
        this.extension_ = extension;
        if (extension != null) {
            extension.rSetParentRNode(this);
        }
    }

    /**
     * Gets the FCRealization property <b>realization</b>.
     *
     * @return FCRealization
     */
    public FCRealization getRealization() {
        return (realization_);
    }

    /**
     * Sets the FCRealization property <b>realization</b>.
     *
     * @param realization
     */
    public void setRealization(FCRealization realization) {
        this.realization_ = realization;
        if (realization != null) {
            realization.rSetParentRNode(this);
        }
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
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework");
        buffer.append("<");
        URelaxer.makeQName(prefix, "component", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.append(" ");
            buffer.append("name");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
        if (javaClass_ != null) {
            buffer.append(" ");
            buffer.append("java.class");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getJavaClass())));
            buffer.append("\"");
        }
        if (javaType_ != null) {
            buffer.append(" ");
            buffer.append("java.type");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getJavaType())));
            buffer.append("\"");
        }
        if (jndiName_ != null) {
            buffer.append(" ");
            buffer.append("jndi.name");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getJndiName())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.attribute_.size();
        for (int i = 0;i < size;i++) {
            FCAttribute value = (FCAttribute)this.attribute_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.operation_.size();
        for (int i = 0;i < size;i++) {
            FCOperation value = (FCOperation)this.operation_.get(i);
            value.makeTextElement(buffer);
        }
        if (extension_ != null) {
            extension_.makeTextElement(buffer);
        }
        if (realization_ != null) {
            realization_.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "component", buffer);
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
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework");
        buffer.write("<");
        URelaxer.makeQName(prefix, "component", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.write(" ");
            buffer.write("name");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
        if (javaClass_ != null) {
            buffer.write(" ");
            buffer.write("java.class");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getJavaClass())));
            buffer.write("\"");
        }
        if (javaType_ != null) {
            buffer.write(" ");
            buffer.write("java.type");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getJavaType())));
            buffer.write("\"");
        }
        if (jndiName_ != null) {
            buffer.write(" ");
            buffer.write("jndi.name");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getJndiName())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.attribute_.size();
        for (int i = 0;i < size;i++) {
            FCAttribute value = (FCAttribute)this.attribute_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.operation_.size();
        for (int i = 0;i < size;i++) {
            FCOperation value = (FCOperation)this.operation_.get(i);
            value.makeTextElement(buffer);
        }
        if (extension_ != null) {
            extension_.makeTextElement(buffer);
        }
        if (realization_ != null) {
            realization_.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "component", buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework");
        buffer.print("<");
        URelaxer.makeQName(prefix, "component", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.print(" ");
            buffer.print("name");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
        if (javaClass_ != null) {
            buffer.print(" ");
            buffer.print("java.class");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getJavaClass())));
            buffer.print("\"");
        }
        if (javaType_ != null) {
            buffer.print(" ");
            buffer.print("java.type");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getJavaType())));
            buffer.print("\"");
        }
        if (jndiName_ != null) {
            buffer.print(" ");
            buffer.print("jndi.name");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getJndiName())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.attribute_.size();
        for (int i = 0;i < size;i++) {
            FCAttribute value = (FCAttribute)this.attribute_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.operation_.size();
        for (int i = 0;i < size;i++) {
            FCOperation value = (FCOperation)this.operation_.get(i);
            value.makeTextElement(buffer);
        }
        if (extension_ != null) {
            extension_.makeTextElement(buffer);
        }
        if (realization_ != null) {
            realization_.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "component", buffer);
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
    public String getJavaTypeAsString() {
        return (URelaxer.getString(getJavaType()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getJndiNameAsString() {
        return (URelaxer.getString(getJndiName()));
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
    public void setJavaTypeByString(String string) {
        setJavaType(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setJndiNameByString(String string) {
        setJndiName(string);
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
     * Evaluates the node.
     *
     * @exception REvaluationException
     * @return Object
     */
    public Object eval() throws REvaluationException {
        return (eval(new RSimpleEvaluationContext()));
    }

    /**
     * Evaluates the node with the evaluation context.
     *
     * @param context
     * @exception REvaluationException
     * @return Object
     */
    public Object eval(IREvaluationContext context) throws REvaluationException {
        IRNode[] children = rGetRNodes();
        Object[] params = new Object[children.length];
        for (int i = 0;i < children.length;i++) {
            IRNode child = children[i];
            if (child instanceof IREvaluatable) {
                params[i] = ((IREvaluatable)child).eval(context);
            } else {
                params[i] = child;
            }
        }
        return (eval(params, context));
    }

    /**
     * Evaluates against the params.
     *
     * @param params
     * @param context
     * @exception REvaluationException
     * @return Object
     */
    public Object eval(Object[] params, IREvaluationContext context) throws REvaluationException {
        return (this);
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
        classNodes.addAll(attribute_);
        classNodes.addAll(operation_);
        if (extension_ != null) {
            classNodes.add(extension_);
        }
        if (realization_ != null) {
            classNodes.add(realization_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCComponent</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework", "component")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        IConfigFactory factory = ConfigFactory.getFactory();
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
            if (!FCAttribute.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!FCOperation.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (FCExtension.isMatchHungry(target)) {
        }
        if (FCRealization.isMatchHungry(target)) {
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FCComponent</code>.
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
     * is valid for the <code>FCComponent</code>.
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
