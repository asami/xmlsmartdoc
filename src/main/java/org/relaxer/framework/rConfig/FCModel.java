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
 * <b>FCModel</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="model">
 *       <attribute java:mapKey="true" name="name">
 *         <data type="token"/>
 *       </attribute>
 *       <choice>
 *         <attribute name="type">
 *           <data type="token"/>
 *         </attribute>
 *         <attribute name="java.class">
 *           <data type="token"/>
 *         </attribute>
 *       </choice>
 *       <zeroOrMore>
 *         <ref name="slot"/>
 *       </zeroOrMore>
 *       <zeroOrMore>
 *         <element name="mapper">
 *           <attribute name="java.class">
 *             <data type="token"/>
 *           </attribute>
 *         </element>
 *       </zeroOrMore>
 *       <optional>
 *         <element name="repository">
 *           <attribute name="java.class">
 *             <data type="token"/>
 *           </attribute>
 *         </element>
 *       </optional>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="model"&gt;
 *       &lt;attribute java:mapKey="true" name="name"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;choice&gt;
 *         &lt;attribute name="type"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *         &lt;attribute name="java.class"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/choice&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="slot"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;element name="mapper"&gt;
 *           &lt;attribute name="java.class"&gt;
 *             &lt;data type="token"/&gt;
 *           &lt;/attribute&gt;
 *         &lt;/element&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;optional&gt;
 *         &lt;element name="repository"&gt;
 *           &lt;attribute name="java.class"&gt;
 *             &lt;data type="token"/&gt;
 *           &lt;/attribute&gt;
 *         &lt;/element&gt;
 *       &lt;/optional&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:40 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCModel extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    private String name_;
    private IFCModelChoice content_;
    // List<FCSlot>
    private java.util.List slot_ = new java.util.ArrayList();
    private java.util.Map slot_$map = new java.util.HashMap();
    // List<FCModelMapper>
    private java.util.List modelMapper_ = new java.util.ArrayList();
    private FCModelRepository modelRepository_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCModel</code>.
     *
     */
    public FCModel() {
        name_ = "";
    }

    /**
     * Creates a <code>FCModel</code>.
     *
     * @param source
     */
    public FCModel(FCModel source) {
        setup(source);
    }

    /**
     * Creates a <code>FCModel</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCModel(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCModel</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModel(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCModel</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModel(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCModel</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModel(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCModel</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModel(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCModel</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModel(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCModel</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModel(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCModel</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModel(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCModel</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModel(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCModel</code> by the FCModel <code>source</code>.
     *
     * @param source
     */
    public void setup(FCModel source) {
        int size;
        name_ = source.name_;
        if (source.content_ != null) {
            setContent((IFCModelChoice)source.getContent().clone());
        }
        this.slot_.clear();
        size = source.slot_.size();
        for (int i = 0;i < size;i++) {
            addSlot((FCSlot)source.getSlot(i).clone());
        }
        this.modelMapper_.clear();
        size = source.modelMapper_.size();
        for (int i = 0;i < size;i++) {
            addModelMapper((FCModelMapper)source.getModelMapper(i).clone());
        }
        if (source.modelRepository_ != null) {
            setModelRepository((FCModelRepository)source.getModelRepository().clone());
        }
    }

    /**
     * Initializes the <code>FCModel</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCModel</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCModel</code> by the Stack <code>stack</code>
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
        if (FCModelType.isMatch(stack)) {
            setContent(factory.createFCModelType(stack));
        } else if (FCModelJavaClass.isMatch(stack)) {
            setContent(factory.createFCModelJavaClass(stack));
        } else {
            throw (new IllegalArgumentException());
        }
        slot_.clear();
        while (true) {
            if (FCSlot.isMatch(stack)) {
                addSlot(factory.createFCSlot(stack));
            } else {
                break;
            }
        }
        modelMapper_.clear();
        while (true) {
            if (FCModelMapper.isMatch(stack)) {
                addModelMapper(factory.createFCModelMapper(stack));
            } else {
                break;
            }
        }
        if (FCModelRepository.isMatch(stack)) {
            setModelRepository(factory.createFCModelRepository(stack));
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        IConfigFactory factory = ConfigFactory.getFactory();
        return (factory.createFCModel((FCModel)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework", "model");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.name_ != null) {
            URelaxer.setAttributePropertyByString(element, "name", this.name_);
        }
        this.content_.makeElement(element);
        size = this.slot_.size();
        for (int i = 0;i < size;i++) {
            FCSlot value = (FCSlot)this.slot_.get(i);
            value.makeElement(element);
        }
        size = this.modelMapper_.size();
        for (int i = 0;i < size;i++) {
            FCModelMapper value = (FCModelMapper)this.modelMapper_.get(i);
            value.makeElement(element);
        }
        if (this.modelRepository_ != null) {
            this.modelRepository_.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCModel</code> by the File <code>file</code>.
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
     * Initializes the <code>FCModel</code>
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
     * Initializes the <code>FCModel</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCModel</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCModel</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCModel</code> by the Reader <code>reader</code>.
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
     * Gets the IFCModelChoice property <b>content</b>.
     *
     * @return IFCModelChoice
     */
    public IFCModelChoice getContent() {
        return (content_);
    }

    /**
     * Sets the IFCModelChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFCModelChoice content) {
        this.content_ = content;
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Gets the FCSlot property <b>slot</b>.
     *
     * @return FCSlot[]
     */
    public FCSlot[] getSlot() {
        FCSlot[] array = new FCSlot[slot_.size()];
        return ((FCSlot[])slot_.toArray(array));
    }

    /**
     * Sets the FCSlot property <b>slot</b>.
     *
     * @param slot
     */
    public void setSlot(FCSlot[] slot) {
        this.slot_.clear();
        for (int i = 0;i < slot.length;i++) {
            addSlot(slot[i]);
        }
        for (int i = 0;i < slot.length;i++) {
            slot[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCSlot property <b>slot</b>.
     *
     * @param slot
     */
    public void setSlot(FCSlot slot) {
        this.slot_.clear();
        addSlot(slot);
        if (slot != null) {
            slot.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCSlot property <b>slot</b>.
     *
     * @param slot
     */
    public void addSlot(FCSlot slot) {
        Object $key$ = slot.getName();
        if ($key$ != null) {
            Object $value$ = this.slot_$map.get($key$);
            if ($value$ != null) {
                this.slot_.remove($value$);
        }
            this.slot_$map.put($key$, slot);
        }
        this.slot_.add(slot);
        if (slot != null) {
            slot.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCSlot property <b>slot</b>.
     *
     * @param slot
     */
    public void addSlot(FCSlot[] slot) {
        for (int i = 0;i < slot.length;i++) {
            addSlot(slot[i]);
        }
        for (int i = 0;i < slot.length;i++) {
            slot[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCSlot property <b>slot</b>.
     *
     * @return int
     */
    public int sizeSlot() {
        return (slot_.size());
    }

    /**
     * Gets the FCSlot property <b>slot</b> by index.
     *
     * @param index
     * @return FCSlot
     */
    public FCSlot getSlot(int index) {
        return ((FCSlot)slot_.get(index));
    }

    /**
     * Sets the FCSlot property <b>slot</b> by index.
     *
     * @param index
     * @param slot
     */
    public void setSlot(int index, FCSlot slot) {
        Object $key$ = slot.getName();
        if ($key$ != null) {
            Object $value$ = this.slot_$map.get($key$);
            if ($value$ != null) {
                this.slot_.remove($value$);
        }
            this.slot_$map.put($key$, slot);
        }
        this.slot_.set(index, slot);
        if (slot != null) {
            slot.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCSlot property <b>slot</b> by index.
     *
     * @param index
     * @param slot
     */
    public void addSlot(int index, FCSlot slot) {
        Object $key$ = slot.getName();
        if ($key$ != null) {
            Object $value$ = this.slot_$map.get($key$);
            if ($value$ != null) {
                this.slot_.remove($value$);
        }
            this.slot_$map.put($key$, slot);
        }
        this.slot_.add(index, slot);
        if (slot != null) {
            slot.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCSlot property <b>slot</b> by index.
     *
     * @param index
     */
    public void removeSlot(int index) {
        FCSlot $value$ = (FCSlot)slot_.get(index);
        if ($value$ != null) {
            removeSlot($value$);
        }
        this.slot_.remove(index);
    }

    /**
     * Remove the FCSlot property <b>slot</b> by object.
     *
     * @param slot
     */
    public void removeSlot(FCSlot slot) {
        Object $key$ = slot.getName();
        this.slot_$map.remove($key$);
        this.slot_.remove(slot);
    }

    /**
     * Clear the FCSlot property <b>slot</b>.
     *
     */
    public void clearSlot() {
        this.slot_$map.clear();
        this.slot_.clear();
    }

    /**
     * Gets the FCSlot property <b>slot</b> by key.
     *
     * @param key
     * @return FCSlot
     */
    public FCSlot getSlotByName(String key) {
        return ((FCSlot)slot_$map.get(key));
    }

    /**
     * Gets the FCModelMapper property <b>modelMapper</b>.
     *
     * @return FCModelMapper[]
     */
    public FCModelMapper[] getModelMapper() {
        FCModelMapper[] array = new FCModelMapper[modelMapper_.size()];
        return ((FCModelMapper[])modelMapper_.toArray(array));
    }

    /**
     * Sets the FCModelMapper property <b>modelMapper</b>.
     *
     * @param modelMapper
     */
    public void setModelMapper(FCModelMapper[] modelMapper) {
        this.modelMapper_.clear();
        for (int i = 0;i < modelMapper.length;i++) {
            addModelMapper(modelMapper[i]);
        }
        for (int i = 0;i < modelMapper.length;i++) {
            modelMapper[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCModelMapper property <b>modelMapper</b>.
     *
     * @param modelMapper
     */
    public void setModelMapper(FCModelMapper modelMapper) {
        this.modelMapper_.clear();
        addModelMapper(modelMapper);
        if (modelMapper != null) {
            modelMapper.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCModelMapper property <b>modelMapper</b>.
     *
     * @param modelMapper
     */
    public void addModelMapper(FCModelMapper modelMapper) {
        this.modelMapper_.add(modelMapper);
        if (modelMapper != null) {
            modelMapper.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCModelMapper property <b>modelMapper</b>.
     *
     * @param modelMapper
     */
    public void addModelMapper(FCModelMapper[] modelMapper) {
        for (int i = 0;i < modelMapper.length;i++) {
            addModelMapper(modelMapper[i]);
        }
        for (int i = 0;i < modelMapper.length;i++) {
            modelMapper[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCModelMapper property <b>modelMapper</b>.
     *
     * @return int
     */
    public int sizeModelMapper() {
        return (modelMapper_.size());
    }

    /**
     * Gets the FCModelMapper property <b>modelMapper</b> by index.
     *
     * @param index
     * @return FCModelMapper
     */
    public FCModelMapper getModelMapper(int index) {
        return ((FCModelMapper)modelMapper_.get(index));
    }

    /**
     * Sets the FCModelMapper property <b>modelMapper</b> by index.
     *
     * @param index
     * @param modelMapper
     */
    public void setModelMapper(int index, FCModelMapper modelMapper) {
        this.modelMapper_.set(index, modelMapper);
        if (modelMapper != null) {
            modelMapper.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCModelMapper property <b>modelMapper</b> by index.
     *
     * @param index
     * @param modelMapper
     */
    public void addModelMapper(int index, FCModelMapper modelMapper) {
        this.modelMapper_.add(index, modelMapper);
        if (modelMapper != null) {
            modelMapper.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCModelMapper property <b>modelMapper</b> by index.
     *
     * @param index
     */
    public void removeModelMapper(int index) {
        this.modelMapper_.remove(index);
    }

    /**
     * Remove the FCModelMapper property <b>modelMapper</b> by object.
     *
     * @param modelMapper
     */
    public void removeModelMapper(FCModelMapper modelMapper) {
        this.modelMapper_.remove(modelMapper);
    }

    /**
     * Clear the FCModelMapper property <b>modelMapper</b>.
     *
     */
    public void clearModelMapper() {
        this.modelMapper_.clear();
    }

    /**
     * Gets the FCModelRepository property <b>modelRepository</b>.
     *
     * @return FCModelRepository
     */
    public FCModelRepository getModelRepository() {
        return (modelRepository_);
    }

    /**
     * Sets the FCModelRepository property <b>modelRepository</b>.
     *
     * @param modelRepository
     */
    public void setModelRepository(FCModelRepository modelRepository) {
        this.modelRepository_ = modelRepository;
        if (modelRepository != null) {
            modelRepository.rSetParentRNode(this);
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
        URelaxer.makeQName(prefix, "model", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.append(" ");
            buffer.append("name");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
        content_.makeTextAttribute(buffer);
        buffer.append(">");
        content_.makeTextElement(buffer);
        size = this.slot_.size();
        for (int i = 0;i < size;i++) {
            FCSlot value = (FCSlot)this.slot_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.modelMapper_.size();
        for (int i = 0;i < size;i++) {
            FCModelMapper value = (FCModelMapper)this.modelMapper_.get(i);
            value.makeTextElement(buffer);
        }
        if (modelRepository_ != null) {
            modelRepository_.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "model", buffer);
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
        URelaxer.makeQName(prefix, "model", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.write(" ");
            buffer.write("name");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
        content_.makeTextAttribute(buffer);
        buffer.write(">");
        content_.makeTextElement(buffer);
        size = this.slot_.size();
        for (int i = 0;i < size;i++) {
            FCSlot value = (FCSlot)this.slot_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.modelMapper_.size();
        for (int i = 0;i < size;i++) {
            FCModelMapper value = (FCModelMapper)this.modelMapper_.get(i);
            value.makeTextElement(buffer);
        }
        if (modelRepository_ != null) {
            modelRepository_.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "model", buffer);
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
        URelaxer.makeQName(prefix, "model", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.print(" ");
            buffer.print("name");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
        content_.makeTextAttribute(buffer);
        buffer.print(">");
        content_.makeTextElement(buffer);
        size = this.slot_.size();
        for (int i = 0;i < size;i++) {
            FCSlot value = (FCSlot)this.slot_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.modelMapper_.size();
        for (int i = 0;i < size;i++) {
            FCModelMapper value = (FCModelMapper)this.modelMapper_.get(i);
            value.makeTextElement(buffer);
        }
        if (modelRepository_ != null) {
            modelRepository_.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "model", buffer);
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
        if (content_ != null) {
            classNodes.add(content_);
        }
        classNodes.addAll(slot_);
        classNodes.addAll(modelMapper_);
        if (modelRepository_ != null) {
            classNodes.add(modelRepository_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCModel</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework", "model")) {
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
        if (FCModelType.isMatchHungry(target)) {
            $match$ = true;
        } else if (FCModelJavaClass.isMatchHungry(target)) {
            $match$ = true;
        } else {
            return (false);
        }
        while (true) {
            if (!FCSlot.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!FCModelMapper.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (FCModelRepository.isMatchHungry(target)) {
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FCModel</code>.
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
     * is valid for the <code>FCModel</code>.
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
