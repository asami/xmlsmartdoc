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
 * <b>FCRealization</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="realization">
 *       <zeroOrMore>
 *         <ref name="property"/>
 *       </zeroOrMore>
 *       <optional>
 *         <ref name="constructor"/>
 *       </optional>
 *       <zeroOrMore>
 *         <ref name="method"/>
 *       </zeroOrMore>
 *       <zeroOrMore>
 *         <ref name="componentRef"/>
 *       </zeroOrMore>
 *       <zeroOrMore>
 *         <ref name="modelRef"/>
 *       </zeroOrMore>
 *       <zeroOrMore>
 *         <ref name="resourceRef"/>
 *       </zeroOrMore>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="realization"&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="property"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;optional&gt;
 *         &lt;ref name="constructor"/&gt;
 *       &lt;/optional&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="method"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="componentRef"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="modelRef"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="resourceRef"/&gt;
 *       &lt;/zeroOrMore&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:39 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCRealization extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    // List<FCProperty>
    private java.util.List property_ = new java.util.ArrayList();
    private FCConstructor constructor_;
    // List<FCMethod>
    private java.util.List method_ = new java.util.ArrayList();
    // List<IFCComponentRefChoice>
    private java.util.List componentRef_ = new java.util.ArrayList();
    // List<IFCModelRefChoice>
    private java.util.List modelRef_ = new java.util.ArrayList();
    // List<IFCResourceRefChoice>
    private java.util.List resourceRef_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCRealization</code>.
     *
     */
    public FCRealization() {
    }

    /**
     * Creates a <code>FCRealization</code>.
     *
     * @param source
     */
    public FCRealization(FCRealization source) {
        setup(source);
    }

    /**
     * Creates a <code>FCRealization</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCRealization(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCRealization</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCRealization(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCRealization</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCRealization(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCRealization</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCRealization(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCRealization</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCRealization(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCRealization</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCRealization(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCRealization</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCRealization(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCRealization</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCRealization(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCRealization</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCRealization(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCRealization</code> by the FCRealization <code>source</code>.
     *
     * @param source
     */
    public void setup(FCRealization source) {
        int size;
        this.property_.clear();
        size = source.property_.size();
        for (int i = 0;i < size;i++) {
            addProperty((FCProperty)source.getProperty(i).clone());
        }
        if (source.constructor_ != null) {
            setConstructor((FCConstructor)source.getConstructor().clone());
        }
        this.method_.clear();
        size = source.method_.size();
        for (int i = 0;i < size;i++) {
            addMethod((FCMethod)source.getMethod(i).clone());
        }
        this.componentRef_.clear();
        size = source.componentRef_.size();
        for (int i = 0;i < size;i++) {
            addComponentRef((IFCComponentRefChoice)source.getComponentRef(i).clone());
        }
        this.modelRef_.clear();
        size = source.modelRef_.size();
        for (int i = 0;i < size;i++) {
            addModelRef((IFCModelRefChoice)source.getModelRef(i).clone());
        }
        this.resourceRef_.clear();
        size = source.resourceRef_.size();
        for (int i = 0;i < size;i++) {
            addResourceRef((IFCResourceRefChoice)source.getResourceRef(i).clone());
        }
    }

    /**
     * Initializes the <code>FCRealization</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCRealization</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCRealization</code> by the Stack <code>stack</code>
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
        property_.clear();
        while (true) {
            if (FCProperty.isMatch(stack)) {
                addProperty(factory.createFCProperty(stack));
            } else {
                break;
            }
        }
        if (FCConstructor.isMatch(stack)) {
            setConstructor(factory.createFCConstructor(stack));
        }
        method_.clear();
        while (true) {
            if (FCMethod.isMatch(stack)) {
                addMethod(factory.createFCMethod(stack));
            } else {
                break;
            }
        }
        componentRef_.clear();
        while (true) {
            if (FCJndiComponentRef.isMatch(stack)) {
                addComponentRef(factory.createFCJndiComponentRef(stack));
            } else if (FCConfigComponentRef.isMatch(stack)) {
                addComponentRef(factory.createFCConfigComponentRef(stack));
            } else if (FCJavaBeansComponentRef.isMatch(stack)) {
                addComponentRef(factory.createFCJavaBeansComponentRef(stack));
            } else {
                break;
            }
        }
        modelRef_.clear();
        while (true) {
            if (FCJndiModelRef.isMatch(stack)) {
                addModelRef(factory.createFCJndiModelRef(stack));
            } else if (FCConfigModelRef.isMatch(stack)) {
                addModelRef(factory.createFCConfigModelRef(stack));
            } else if (FCJavaBeansModelRef.isMatch(stack)) {
                addModelRef(factory.createFCJavaBeansModelRef(stack));
            } else {
                break;
            }
        }
        resourceRef_.clear();
        while (true) {
            if (FCJndiResourceRef.isMatch(stack)) {
                addResourceRef(factory.createFCJndiResourceRef(stack));
            } else if (FCConfigResourceRef.isMatch(stack)) {
                addResourceRef(factory.createFCConfigResourceRef(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        IConfigFactory factory = ConfigFactory.getFactory();
        return (factory.createFCRealization((FCRealization)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework", "realization");
        rNSContext_.setupNamespace(element);
        int size;
        size = this.property_.size();
        for (int i = 0;i < size;i++) {
            FCProperty value = (FCProperty)this.property_.get(i);
            value.makeElement(element);
        }
        if (this.constructor_ != null) {
            this.constructor_.makeElement(element);
        }
        size = this.method_.size();
        for (int i = 0;i < size;i++) {
            FCMethod value = (FCMethod)this.method_.get(i);
            value.makeElement(element);
        }
        size = this.componentRef_.size();
        for (int i = 0;i < size;i++) {
            IFCComponentRefChoice value = (IFCComponentRefChoice)this.componentRef_.get(i);
            value.makeElement(element);
        }
        size = this.modelRef_.size();
        for (int i = 0;i < size;i++) {
            IFCModelRefChoice value = (IFCModelRefChoice)this.modelRef_.get(i);
            value.makeElement(element);
        }
        size = this.resourceRef_.size();
        for (int i = 0;i < size;i++) {
            IFCResourceRefChoice value = (IFCResourceRefChoice)this.resourceRef_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCRealization</code> by the File <code>file</code>.
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
     * Initializes the <code>FCRealization</code>
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
     * Initializes the <code>FCRealization</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCRealization</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCRealization</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCRealization</code> by the Reader <code>reader</code>.
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
     * Gets the FCProperty property <b>property</b>.
     *
     * @return FCProperty[]
     */
    public FCProperty[] getProperty() {
        FCProperty[] array = new FCProperty[property_.size()];
        return ((FCProperty[])property_.toArray(array));
    }

    /**
     * Sets the FCProperty property <b>property</b>.
     *
     * @param property
     */
    public void setProperty(FCProperty[] property) {
        this.property_.clear();
        for (int i = 0;i < property.length;i++) {
            addProperty(property[i]);
        }
        for (int i = 0;i < property.length;i++) {
            property[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCProperty property <b>property</b>.
     *
     * @param property
     */
    public void setProperty(FCProperty property) {
        this.property_.clear();
        addProperty(property);
        if (property != null) {
            property.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCProperty property <b>property</b>.
     *
     * @param property
     */
    public void addProperty(FCProperty property) {
        this.property_.add(property);
        if (property != null) {
            property.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCProperty property <b>property</b>.
     *
     * @param property
     */
    public void addProperty(FCProperty[] property) {
        for (int i = 0;i < property.length;i++) {
            addProperty(property[i]);
        }
        for (int i = 0;i < property.length;i++) {
            property[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCProperty property <b>property</b>.
     *
     * @return int
     */
    public int sizeProperty() {
        return (property_.size());
    }

    /**
     * Gets the FCProperty property <b>property</b> by index.
     *
     * @param index
     * @return FCProperty
     */
    public FCProperty getProperty(int index) {
        return ((FCProperty)property_.get(index));
    }

    /**
     * Sets the FCProperty property <b>property</b> by index.
     *
     * @param index
     * @param property
     */
    public void setProperty(int index, FCProperty property) {
        this.property_.set(index, property);
        if (property != null) {
            property.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCProperty property <b>property</b> by index.
     *
     * @param index
     * @param property
     */
    public void addProperty(int index, FCProperty property) {
        this.property_.add(index, property);
        if (property != null) {
            property.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCProperty property <b>property</b> by index.
     *
     * @param index
     */
    public void removeProperty(int index) {
        this.property_.remove(index);
    }

    /**
     * Remove the FCProperty property <b>property</b> by object.
     *
     * @param property
     */
    public void removeProperty(FCProperty property) {
        this.property_.remove(property);
    }

    /**
     * Clear the FCProperty property <b>property</b>.
     *
     */
    public void clearProperty() {
        this.property_.clear();
    }

    /**
     * Gets the FCConstructor property <b>constructor</b>.
     *
     * @return FCConstructor
     */
    public FCConstructor getConstructor() {
        return (constructor_);
    }

    /**
     * Sets the FCConstructor property <b>constructor</b>.
     *
     * @param constructor
     */
    public void setConstructor(FCConstructor constructor) {
        this.constructor_ = constructor;
        if (constructor != null) {
            constructor.rSetParentRNode(this);
        }
    }

    /**
     * Gets the FCMethod property <b>method</b>.
     *
     * @return FCMethod[]
     */
    public FCMethod[] getMethod() {
        FCMethod[] array = new FCMethod[method_.size()];
        return ((FCMethod[])method_.toArray(array));
    }

    /**
     * Sets the FCMethod property <b>method</b>.
     *
     * @param method
     */
    public void setMethod(FCMethod[] method) {
        this.method_.clear();
        for (int i = 0;i < method.length;i++) {
            addMethod(method[i]);
        }
        for (int i = 0;i < method.length;i++) {
            method[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCMethod property <b>method</b>.
     *
     * @param method
     */
    public void setMethod(FCMethod method) {
        this.method_.clear();
        addMethod(method);
        if (method != null) {
            method.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCMethod property <b>method</b>.
     *
     * @param method
     */
    public void addMethod(FCMethod method) {
        this.method_.add(method);
        if (method != null) {
            method.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCMethod property <b>method</b>.
     *
     * @param method
     */
    public void addMethod(FCMethod[] method) {
        for (int i = 0;i < method.length;i++) {
            addMethod(method[i]);
        }
        for (int i = 0;i < method.length;i++) {
            method[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCMethod property <b>method</b>.
     *
     * @return int
     */
    public int sizeMethod() {
        return (method_.size());
    }

    /**
     * Gets the FCMethod property <b>method</b> by index.
     *
     * @param index
     * @return FCMethod
     */
    public FCMethod getMethod(int index) {
        return ((FCMethod)method_.get(index));
    }

    /**
     * Sets the FCMethod property <b>method</b> by index.
     *
     * @param index
     * @param method
     */
    public void setMethod(int index, FCMethod method) {
        this.method_.set(index, method);
        if (method != null) {
            method.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCMethod property <b>method</b> by index.
     *
     * @param index
     * @param method
     */
    public void addMethod(int index, FCMethod method) {
        this.method_.add(index, method);
        if (method != null) {
            method.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCMethod property <b>method</b> by index.
     *
     * @param index
     */
    public void removeMethod(int index) {
        this.method_.remove(index);
    }

    /**
     * Remove the FCMethod property <b>method</b> by object.
     *
     * @param method
     */
    public void removeMethod(FCMethod method) {
        this.method_.remove(method);
    }

    /**
     * Clear the FCMethod property <b>method</b>.
     *
     */
    public void clearMethod() {
        this.method_.clear();
    }

    /**
     * Gets the IFCComponentRefChoice property <b>componentRef</b>.
     *
     * @return IFCComponentRefChoice[]
     */
    public IFCComponentRefChoice[] getComponentRef() {
        IFCComponentRefChoice[] array = new IFCComponentRefChoice[componentRef_.size()];
        return ((IFCComponentRefChoice[])componentRef_.toArray(array));
    }

    /**
     * Sets the IFCComponentRefChoice property <b>componentRef</b>.
     *
     * @param componentRef
     */
    public void setComponentRef(IFCComponentRefChoice[] componentRef) {
        this.componentRef_.clear();
        for (int i = 0;i < componentRef.length;i++) {
            addComponentRef(componentRef[i]);
        }
        for (int i = 0;i < componentRef.length;i++) {
            componentRef[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the IFCComponentRefChoice property <b>componentRef</b>.
     *
     * @param componentRef
     */
    public void setComponentRef(IFCComponentRefChoice componentRef) {
        this.componentRef_.clear();
        addComponentRef(componentRef);
        if (componentRef != null) {
            componentRef.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCComponentRefChoice property <b>componentRef</b>.
     *
     * @param componentRef
     */
    public void addComponentRef(IFCComponentRefChoice componentRef) {
        this.componentRef_.add(componentRef);
        if (componentRef != null) {
            componentRef.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCComponentRefChoice property <b>componentRef</b>.
     *
     * @param componentRef
     */
    public void addComponentRef(IFCComponentRefChoice[] componentRef) {
        for (int i = 0;i < componentRef.length;i++) {
            addComponentRef(componentRef[i]);
        }
        for (int i = 0;i < componentRef.length;i++) {
            componentRef[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the IFCComponentRefChoice property <b>componentRef</b>.
     *
     * @return int
     */
    public int sizeComponentRef() {
        return (componentRef_.size());
    }

    /**
     * Gets the IFCComponentRefChoice property <b>componentRef</b> by index.
     *
     * @param index
     * @return IFCComponentRefChoice
     */
    public IFCComponentRefChoice getComponentRef(int index) {
        return ((IFCComponentRefChoice)componentRef_.get(index));
    }

    /**
     * Sets the IFCComponentRefChoice property <b>componentRef</b> by index.
     *
     * @param index
     * @param componentRef
     */
    public void setComponentRef(int index, IFCComponentRefChoice componentRef) {
        this.componentRef_.set(index, componentRef);
        if (componentRef != null) {
            componentRef.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCComponentRefChoice property <b>componentRef</b> by index.
     *
     * @param index
     * @param componentRef
     */
    public void addComponentRef(int index, IFCComponentRefChoice componentRef) {
        this.componentRef_.add(index, componentRef);
        if (componentRef != null) {
            componentRef.rSetParentRNode(this);
        }
    }

    /**
     * Remove the IFCComponentRefChoice property <b>componentRef</b> by index.
     *
     * @param index
     */
    public void removeComponentRef(int index) {
        this.componentRef_.remove(index);
    }

    /**
     * Remove the IFCComponentRefChoice property <b>componentRef</b> by object.
     *
     * @param componentRef
     */
    public void removeComponentRef(IFCComponentRefChoice componentRef) {
        this.componentRef_.remove(componentRef);
    }

    /**
     * Clear the IFCComponentRefChoice property <b>componentRef</b>.
     *
     */
    public void clearComponentRef() {
        this.componentRef_.clear();
    }

    /**
     * Gets the IFCModelRefChoice property <b>modelRef</b>.
     *
     * @return IFCModelRefChoice[]
     */
    public IFCModelRefChoice[] getModelRef() {
        IFCModelRefChoice[] array = new IFCModelRefChoice[modelRef_.size()];
        return ((IFCModelRefChoice[])modelRef_.toArray(array));
    }

    /**
     * Sets the IFCModelRefChoice property <b>modelRef</b>.
     *
     * @param modelRef
     */
    public void setModelRef(IFCModelRefChoice[] modelRef) {
        this.modelRef_.clear();
        for (int i = 0;i < modelRef.length;i++) {
            addModelRef(modelRef[i]);
        }
        for (int i = 0;i < modelRef.length;i++) {
            modelRef[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the IFCModelRefChoice property <b>modelRef</b>.
     *
     * @param modelRef
     */
    public void setModelRef(IFCModelRefChoice modelRef) {
        this.modelRef_.clear();
        addModelRef(modelRef);
        if (modelRef != null) {
            modelRef.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCModelRefChoice property <b>modelRef</b>.
     *
     * @param modelRef
     */
    public void addModelRef(IFCModelRefChoice modelRef) {
        this.modelRef_.add(modelRef);
        if (modelRef != null) {
            modelRef.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCModelRefChoice property <b>modelRef</b>.
     *
     * @param modelRef
     */
    public void addModelRef(IFCModelRefChoice[] modelRef) {
        for (int i = 0;i < modelRef.length;i++) {
            addModelRef(modelRef[i]);
        }
        for (int i = 0;i < modelRef.length;i++) {
            modelRef[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the IFCModelRefChoice property <b>modelRef</b>.
     *
     * @return int
     */
    public int sizeModelRef() {
        return (modelRef_.size());
    }

    /**
     * Gets the IFCModelRefChoice property <b>modelRef</b> by index.
     *
     * @param index
     * @return IFCModelRefChoice
     */
    public IFCModelRefChoice getModelRef(int index) {
        return ((IFCModelRefChoice)modelRef_.get(index));
    }

    /**
     * Sets the IFCModelRefChoice property <b>modelRef</b> by index.
     *
     * @param index
     * @param modelRef
     */
    public void setModelRef(int index, IFCModelRefChoice modelRef) {
        this.modelRef_.set(index, modelRef);
        if (modelRef != null) {
            modelRef.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCModelRefChoice property <b>modelRef</b> by index.
     *
     * @param index
     * @param modelRef
     */
    public void addModelRef(int index, IFCModelRefChoice modelRef) {
        this.modelRef_.add(index, modelRef);
        if (modelRef != null) {
            modelRef.rSetParentRNode(this);
        }
    }

    /**
     * Remove the IFCModelRefChoice property <b>modelRef</b> by index.
     *
     * @param index
     */
    public void removeModelRef(int index) {
        this.modelRef_.remove(index);
    }

    /**
     * Remove the IFCModelRefChoice property <b>modelRef</b> by object.
     *
     * @param modelRef
     */
    public void removeModelRef(IFCModelRefChoice modelRef) {
        this.modelRef_.remove(modelRef);
    }

    /**
     * Clear the IFCModelRefChoice property <b>modelRef</b>.
     *
     */
    public void clearModelRef() {
        this.modelRef_.clear();
    }

    /**
     * Gets the IFCResourceRefChoice property <b>resourceRef</b>.
     *
     * @return IFCResourceRefChoice[]
     */
    public IFCResourceRefChoice[] getResourceRef() {
        IFCResourceRefChoice[] array = new IFCResourceRefChoice[resourceRef_.size()];
        return ((IFCResourceRefChoice[])resourceRef_.toArray(array));
    }

    /**
     * Sets the IFCResourceRefChoice property <b>resourceRef</b>.
     *
     * @param resourceRef
     */
    public void setResourceRef(IFCResourceRefChoice[] resourceRef) {
        this.resourceRef_.clear();
        for (int i = 0;i < resourceRef.length;i++) {
            addResourceRef(resourceRef[i]);
        }
        for (int i = 0;i < resourceRef.length;i++) {
            resourceRef[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the IFCResourceRefChoice property <b>resourceRef</b>.
     *
     * @param resourceRef
     */
    public void setResourceRef(IFCResourceRefChoice resourceRef) {
        this.resourceRef_.clear();
        addResourceRef(resourceRef);
        if (resourceRef != null) {
            resourceRef.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCResourceRefChoice property <b>resourceRef</b>.
     *
     * @param resourceRef
     */
    public void addResourceRef(IFCResourceRefChoice resourceRef) {
        this.resourceRef_.add(resourceRef);
        if (resourceRef != null) {
            resourceRef.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCResourceRefChoice property <b>resourceRef</b>.
     *
     * @param resourceRef
     */
    public void addResourceRef(IFCResourceRefChoice[] resourceRef) {
        for (int i = 0;i < resourceRef.length;i++) {
            addResourceRef(resourceRef[i]);
        }
        for (int i = 0;i < resourceRef.length;i++) {
            resourceRef[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the IFCResourceRefChoice property <b>resourceRef</b>.
     *
     * @return int
     */
    public int sizeResourceRef() {
        return (resourceRef_.size());
    }

    /**
     * Gets the IFCResourceRefChoice property <b>resourceRef</b> by index.
     *
     * @param index
     * @return IFCResourceRefChoice
     */
    public IFCResourceRefChoice getResourceRef(int index) {
        return ((IFCResourceRefChoice)resourceRef_.get(index));
    }

    /**
     * Sets the IFCResourceRefChoice property <b>resourceRef</b> by index.
     *
     * @param index
     * @param resourceRef
     */
    public void setResourceRef(int index, IFCResourceRefChoice resourceRef) {
        this.resourceRef_.set(index, resourceRef);
        if (resourceRef != null) {
            resourceRef.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCResourceRefChoice property <b>resourceRef</b> by index.
     *
     * @param index
     * @param resourceRef
     */
    public void addResourceRef(int index, IFCResourceRefChoice resourceRef) {
        this.resourceRef_.add(index, resourceRef);
        if (resourceRef != null) {
            resourceRef.rSetParentRNode(this);
        }
    }

    /**
     * Remove the IFCResourceRefChoice property <b>resourceRef</b> by index.
     *
     * @param index
     */
    public void removeResourceRef(int index) {
        this.resourceRef_.remove(index);
    }

    /**
     * Remove the IFCResourceRefChoice property <b>resourceRef</b> by object.
     *
     * @param resourceRef
     */
    public void removeResourceRef(IFCResourceRefChoice resourceRef) {
        this.resourceRef_.remove(resourceRef);
    }

    /**
     * Clear the IFCResourceRefChoice property <b>resourceRef</b>.
     *
     */
    public void clearResourceRef() {
        this.resourceRef_.clear();
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
        URelaxer.makeQName(prefix, "realization", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.componentRef_.size();
        for (int i = 0;i < size;i++) {
            IFCComponentRefChoice value = (IFCComponentRefChoice)this.componentRef_.get(i);
            value.makeTextAttribute(buffer);
        }
        size = this.modelRef_.size();
        for (int i = 0;i < size;i++) {
            IFCModelRefChoice value = (IFCModelRefChoice)this.modelRef_.get(i);
            value.makeTextAttribute(buffer);
        }
        size = this.resourceRef_.size();
        for (int i = 0;i < size;i++) {
            IFCResourceRefChoice value = (IFCResourceRefChoice)this.resourceRef_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.property_.size();
        for (int i = 0;i < size;i++) {
            FCProperty value = (FCProperty)this.property_.get(i);
            value.makeTextElement(buffer);
        }
        if (constructor_ != null) {
            constructor_.makeTextElement(buffer);
        }
        size = this.method_.size();
        for (int i = 0;i < size;i++) {
            FCMethod value = (FCMethod)this.method_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.componentRef_.size();
        for (int i = 0;i < size;i++) {
            IFCComponentRefChoice value = (IFCComponentRefChoice)this.componentRef_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.modelRef_.size();
        for (int i = 0;i < size;i++) {
            IFCModelRefChoice value = (IFCModelRefChoice)this.modelRef_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.resourceRef_.size();
        for (int i = 0;i < size;i++) {
            IFCResourceRefChoice value = (IFCResourceRefChoice)this.resourceRef_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "realization", buffer);
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
        URelaxer.makeQName(prefix, "realization", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.componentRef_.size();
        for (int i = 0;i < size;i++) {
            IFCComponentRefChoice value = (IFCComponentRefChoice)this.componentRef_.get(i);
            value.makeTextAttribute(buffer);
        }
        size = this.modelRef_.size();
        for (int i = 0;i < size;i++) {
            IFCModelRefChoice value = (IFCModelRefChoice)this.modelRef_.get(i);
            value.makeTextAttribute(buffer);
        }
        size = this.resourceRef_.size();
        for (int i = 0;i < size;i++) {
            IFCResourceRefChoice value = (IFCResourceRefChoice)this.resourceRef_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.property_.size();
        for (int i = 0;i < size;i++) {
            FCProperty value = (FCProperty)this.property_.get(i);
            value.makeTextElement(buffer);
        }
        if (constructor_ != null) {
            constructor_.makeTextElement(buffer);
        }
        size = this.method_.size();
        for (int i = 0;i < size;i++) {
            FCMethod value = (FCMethod)this.method_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.componentRef_.size();
        for (int i = 0;i < size;i++) {
            IFCComponentRefChoice value = (IFCComponentRefChoice)this.componentRef_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.modelRef_.size();
        for (int i = 0;i < size;i++) {
            IFCModelRefChoice value = (IFCModelRefChoice)this.modelRef_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.resourceRef_.size();
        for (int i = 0;i < size;i++) {
            IFCResourceRefChoice value = (IFCResourceRefChoice)this.resourceRef_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "realization", buffer);
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
        URelaxer.makeQName(prefix, "realization", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.componentRef_.size();
        for (int i = 0;i < size;i++) {
            IFCComponentRefChoice value = (IFCComponentRefChoice)this.componentRef_.get(i);
            value.makeTextAttribute(buffer);
        }
        size = this.modelRef_.size();
        for (int i = 0;i < size;i++) {
            IFCModelRefChoice value = (IFCModelRefChoice)this.modelRef_.get(i);
            value.makeTextAttribute(buffer);
        }
        size = this.resourceRef_.size();
        for (int i = 0;i < size;i++) {
            IFCResourceRefChoice value = (IFCResourceRefChoice)this.resourceRef_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.property_.size();
        for (int i = 0;i < size;i++) {
            FCProperty value = (FCProperty)this.property_.get(i);
            value.makeTextElement(buffer);
        }
        if (constructor_ != null) {
            constructor_.makeTextElement(buffer);
        }
        size = this.method_.size();
        for (int i = 0;i < size;i++) {
            FCMethod value = (FCMethod)this.method_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.componentRef_.size();
        for (int i = 0;i < size;i++) {
            IFCComponentRefChoice value = (IFCComponentRefChoice)this.componentRef_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.modelRef_.size();
        for (int i = 0;i < size;i++) {
            IFCModelRefChoice value = (IFCModelRefChoice)this.modelRef_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.resourceRef_.size();
        for (int i = 0;i < size;i++) {
            IFCResourceRefChoice value = (IFCResourceRefChoice)this.resourceRef_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "realization", buffer);
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
        classNodes.addAll(property_);
        if (constructor_ != null) {
            classNodes.add(constructor_);
        }
        classNodes.addAll(method_);
        classNodes.addAll(componentRef_);
        classNodes.addAll(modelRef_);
        classNodes.addAll(resourceRef_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCRealization</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework", "realization")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        IConfigFactory factory = ConfigFactory.getFactory();
        Element child;
        while (true) {
            if (!FCProperty.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (FCConstructor.isMatchHungry(target)) {
        }
        while (true) {
            if (!FCMethod.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (FCJndiComponentRef.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCConfigComponentRef.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCJavaBeansComponentRef.isMatchHungry(target)) {
                $match$ = true;
            } else {
                break;
            }
        }
        while (true) {
            if (FCJndiModelRef.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCConfigModelRef.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCJavaBeansModelRef.isMatchHungry(target)) {
                $match$ = true;
            } else {
                break;
            }
        }
        while (true) {
            if (FCJndiResourceRef.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCConfigResourceRef.isMatchHungry(target)) {
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
     * is valid for the <code>FCRealization</code>.
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
     * is valid for the <code>FCRealization</code>.
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
