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
 * <b>FCScene</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="scene">
 *       <optional>
 *         <attribute name="name">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <ref name="plain-script-head.model"/>
 *       <zeroOrMore>
 *         <ref name="scenario"/>
 *       </zeroOrMore>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="scene"&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="name"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;ref name="plain-script-head.model"/&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="scenario"/&gt;
 *       &lt;/zeroOrMore&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:39 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCScene extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    private String name_;
    // List<FCSlot>
    private java.util.List slot_ = new java.util.ArrayList();
    private java.util.Map slot_$map = new java.util.HashMap();
    private FCPrologue prologue_;
    private FCEpilogue epilogue_;
    // List<FCScenario>
    private java.util.List scenario_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCScene</code>.
     *
     */
    public FCScene() {
    }

    /**
     * Creates a <code>FCScene</code>.
     *
     * @param source
     */
    public FCScene(FCScene source) {
        setup(source);
    }

    /**
     * Creates a <code>FCScene</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCScene(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCScene</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScene(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCScene</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScene(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCScene</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScene(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCScene</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScene(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCScene</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScene(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCScene</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScene(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCScene</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScene(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCScene</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScene(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCScene</code> by the FCScene <code>source</code>.
     *
     * @param source
     */
    public void setup(FCScene source) {
        int size;
        name_ = source.name_;
        this.slot_.clear();
        size = source.slot_.size();
        for (int i = 0;i < size;i++) {
            addSlot((FCSlot)source.getSlot(i).clone());
        }
        if (source.prologue_ != null) {
            setPrologue((FCPrologue)source.getPrologue().clone());
        }
        if (source.epilogue_ != null) {
            setEpilogue((FCEpilogue)source.getEpilogue().clone());
        }
        this.scenario_.clear();
        size = source.scenario_.size();
        for (int i = 0;i < size;i++) {
            addScenario((FCScenario)source.getScenario(i).clone());
        }
    }

    /**
     * Initializes the <code>FCScene</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCScene</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCScene</code> by the Stack <code>stack</code>
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
        slot_.clear();
        while (true) {
            if (FCSlot.isMatch(stack)) {
                addSlot(factory.createFCSlot(stack));
            } else {
                break;
            }
        }
        if (FCPrologue.isMatch(stack)) {
            setPrologue(factory.createFCPrologue(stack));
        }
        if (FCEpilogue.isMatch(stack)) {
            setEpilogue(factory.createFCEpilogue(stack));
        }
        scenario_.clear();
        while (true) {
            if (FCScenario.isMatch(stack)) {
                addScenario(factory.createFCScenario(stack));
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
        return (factory.createFCScene((FCScene)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework", "scene");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.name_ != null) {
            URelaxer.setAttributePropertyByString(element, "name", this.name_);
        }
        size = this.slot_.size();
        for (int i = 0;i < size;i++) {
            FCSlot value = (FCSlot)this.slot_.get(i);
            value.makeElement(element);
        }
        if (this.prologue_ != null) {
            this.prologue_.makeElement(element);
        }
        if (this.epilogue_ != null) {
            this.epilogue_.makeElement(element);
        }
        size = this.scenario_.size();
        for (int i = 0;i < size;i++) {
            FCScenario value = (FCScenario)this.scenario_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCScene</code> by the File <code>file</code>.
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
     * Initializes the <code>FCScene</code>
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
     * Initializes the <code>FCScene</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCScene</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCScene</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCScene</code> by the Reader <code>reader</code>.
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
     * Gets the FCPrologue property <b>prologue</b>.
     *
     * @return FCPrologue
     */
    public FCPrologue getPrologue() {
        return (prologue_);
    }

    /**
     * Sets the FCPrologue property <b>prologue</b>.
     *
     * @param prologue
     */
    public void setPrologue(FCPrologue prologue) {
        this.prologue_ = prologue;
        if (prologue != null) {
            prologue.rSetParentRNode(this);
        }
    }

    /**
     * Gets the FCEpilogue property <b>epilogue</b>.
     *
     * @return FCEpilogue
     */
    public FCEpilogue getEpilogue() {
        return (epilogue_);
    }

    /**
     * Sets the FCEpilogue property <b>epilogue</b>.
     *
     * @param epilogue
     */
    public void setEpilogue(FCEpilogue epilogue) {
        this.epilogue_ = epilogue;
        if (epilogue != null) {
            epilogue.rSetParentRNode(this);
        }
    }

    /**
     * Gets the FCScenario property <b>scenario</b>.
     *
     * @return FCScenario[]
     */
    public FCScenario[] getScenario() {
        FCScenario[] array = new FCScenario[scenario_.size()];
        return ((FCScenario[])scenario_.toArray(array));
    }

    /**
     * Sets the FCScenario property <b>scenario</b>.
     *
     * @param scenario
     */
    public void setScenario(FCScenario[] scenario) {
        this.scenario_.clear();
        for (int i = 0;i < scenario.length;i++) {
            addScenario(scenario[i]);
        }
        for (int i = 0;i < scenario.length;i++) {
            scenario[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCScenario property <b>scenario</b>.
     *
     * @param scenario
     */
    public void setScenario(FCScenario scenario) {
        this.scenario_.clear();
        addScenario(scenario);
        if (scenario != null) {
            scenario.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCScenario property <b>scenario</b>.
     *
     * @param scenario
     */
    public void addScenario(FCScenario scenario) {
        this.scenario_.add(scenario);
        if (scenario != null) {
            scenario.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCScenario property <b>scenario</b>.
     *
     * @param scenario
     */
    public void addScenario(FCScenario[] scenario) {
        for (int i = 0;i < scenario.length;i++) {
            addScenario(scenario[i]);
        }
        for (int i = 0;i < scenario.length;i++) {
            scenario[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCScenario property <b>scenario</b>.
     *
     * @return int
     */
    public int sizeScenario() {
        return (scenario_.size());
    }

    /**
     * Gets the FCScenario property <b>scenario</b> by index.
     *
     * @param index
     * @return FCScenario
     */
    public FCScenario getScenario(int index) {
        return ((FCScenario)scenario_.get(index));
    }

    /**
     * Sets the FCScenario property <b>scenario</b> by index.
     *
     * @param index
     * @param scenario
     */
    public void setScenario(int index, FCScenario scenario) {
        this.scenario_.set(index, scenario);
        if (scenario != null) {
            scenario.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCScenario property <b>scenario</b> by index.
     *
     * @param index
     * @param scenario
     */
    public void addScenario(int index, FCScenario scenario) {
        this.scenario_.add(index, scenario);
        if (scenario != null) {
            scenario.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCScenario property <b>scenario</b> by index.
     *
     * @param index
     */
    public void removeScenario(int index) {
        this.scenario_.remove(index);
    }

    /**
     * Remove the FCScenario property <b>scenario</b> by object.
     *
     * @param scenario
     */
    public void removeScenario(FCScenario scenario) {
        this.scenario_.remove(scenario);
    }

    /**
     * Clear the FCScenario property <b>scenario</b>.
     *
     */
    public void clearScenario() {
        this.scenario_.clear();
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
        URelaxer.makeQName(prefix, "scene", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.append(" ");
            buffer.append("name");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.slot_.size();
        for (int i = 0;i < size;i++) {
            FCSlot value = (FCSlot)this.slot_.get(i);
            value.makeTextElement(buffer);
        }
        if (prologue_ != null) {
            prologue_.makeTextElement(buffer);
        }
        if (epilogue_ != null) {
            epilogue_.makeTextElement(buffer);
        }
        size = this.scenario_.size();
        for (int i = 0;i < size;i++) {
            FCScenario value = (FCScenario)this.scenario_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "scene", buffer);
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
        URelaxer.makeQName(prefix, "scene", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.write(" ");
            buffer.write("name");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.slot_.size();
        for (int i = 0;i < size;i++) {
            FCSlot value = (FCSlot)this.slot_.get(i);
            value.makeTextElement(buffer);
        }
        if (prologue_ != null) {
            prologue_.makeTextElement(buffer);
        }
        if (epilogue_ != null) {
            epilogue_.makeTextElement(buffer);
        }
        size = this.scenario_.size();
        for (int i = 0;i < size;i++) {
            FCScenario value = (FCScenario)this.scenario_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "scene", buffer);
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
        URelaxer.makeQName(prefix, "scene", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.print(" ");
            buffer.print("name");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.slot_.size();
        for (int i = 0;i < size;i++) {
            FCSlot value = (FCSlot)this.slot_.get(i);
            value.makeTextElement(buffer);
        }
        if (prologue_ != null) {
            prologue_.makeTextElement(buffer);
        }
        if (epilogue_ != null) {
            epilogue_.makeTextElement(buffer);
        }
        size = this.scenario_.size();
        for (int i = 0;i < size;i++) {
            FCScenario value = (FCScenario)this.scenario_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "scene", buffer);
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
        classNodes.addAll(slot_);
        if (prologue_ != null) {
            classNodes.add(prologue_);
        }
        if (epilogue_ != null) {
            classNodes.add(epilogue_);
        }
        classNodes.addAll(scenario_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCScene</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework", "scene")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        IConfigFactory factory = ConfigFactory.getFactory();
        Element child;
        while (true) {
            if (!FCSlot.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (FCPrologue.isMatchHungry(target)) {
        }
        if (FCEpilogue.isMatchHungry(target)) {
        }
        while (true) {
            if (!FCScenario.isMatchHungry(target)) {
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
     * is valid for the <code>FCScene</code>.
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
     * is valid for the <code>FCScene</code>.
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
