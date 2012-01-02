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
 * <b>FCScriptService</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="service">
 *       <attribute name="name">
 *         <data type="token"/>
 *       </attribute>
 *       <optional>
 *         <attribute name="role">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <attribute name="debug">
 *         <data type="token"/>
 *       </attribute>
 *       <ref name="helps"/>
 *       <ref name="plain-script.model"/>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="service"&gt;
 *       &lt;attribute name="name"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="role"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;attribute name="debug"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;ref name="helps"/&gt;
 *       &lt;ref name="plain-script.model"/&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:39 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCScriptService extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode, IFCServiceChoice {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    private String name_;
    private String role_;
    private String debug_;
    // List<FCHelp>
    private java.util.List help_ = new java.util.ArrayList();
    // List<FCSlot>
    private java.util.List slot_ = new java.util.ArrayList();
    private java.util.Map slot_$map = new java.util.HashMap();
    private FCPrologue prologue_;
    private FCEpilogue epilogue_;
    // List<IFCPlainScriptBodyContentChoice>
    private java.util.List plainScriptBodyContent_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCScriptService</code>.
     *
     */
    public FCScriptService() {
        name_ = "";
        debug_ = "";
    }

    /**
     * Creates a <code>FCScriptService</code>.
     *
     * @param source
     */
    public FCScriptService(FCScriptService source) {
        setup(source);
    }

    /**
     * Creates a <code>FCScriptService</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCScriptService(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCScriptService</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScriptService(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCScriptService</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScriptService(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCScriptService</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScriptService(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCScriptService</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScriptService(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCScriptService</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScriptService(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCScriptService</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScriptService(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCScriptService</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScriptService(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCScriptService</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCScriptService(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCScriptService</code> by the FCScriptService <code>source</code>.
     *
     * @param source
     */
    public void setup(FCScriptService source) {
        int size;
        name_ = source.name_;
        role_ = source.role_;
        debug_ = source.debug_;
        this.help_.clear();
        size = source.help_.size();
        for (int i = 0;i < size;i++) {
            addHelp((FCHelp)source.getHelp(i).clone());
        }
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
        this.plainScriptBodyContent_.clear();
        size = source.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            addPlainScriptBodyContent((IFCPlainScriptBodyContentChoice)source.getPlainScriptBodyContent(i).clone());
        }
    }

    /**
     * Initializes the <code>FCScriptService</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCScriptService</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCScriptService</code> by the Stack <code>stack</code>
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
        role_ = URelaxer.getAttributePropertyAsString(element, "role");
        debug_ = URelaxer.getAttributePropertyAsString(element, "debug");
        help_.clear();
        while (true) {
            if (FCHelp.isMatch(stack)) {
                addHelp(factory.createFCHelp(stack));
            } else {
                break;
            }
        }
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
        plainScriptBodyContent_.clear();
        while (true) {
            if (FCComponentAction.isMatch(stack)) {
                addPlainScriptBodyContent(factory.createFCComponentAction(stack));
            } else if (FCModelAction.isMatch(stack)) {
                addPlainScriptBodyContent(factory.createFCModelAction(stack));
            } else if (FCServiceAction.isMatch(stack)) {
                addPlainScriptBodyContent(factory.createFCServiceAction(stack));
            } else if (FCResourceAction.isMatch(stack)) {
                addPlainScriptBodyContent(factory.createFCResourceAction(stack));
            } else if (FCSystemAction.isMatch(stack)) {
                addPlainScriptBodyContent(factory.createFCSystemAction(stack));
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
        return (factory.createFCScriptService((FCScriptService)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework", "service");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.name_ != null) {
            URelaxer.setAttributePropertyByString(element, "name", this.name_);
        }
        if (this.role_ != null) {
            URelaxer.setAttributePropertyByString(element, "role", this.role_);
        }
        if (this.debug_ != null) {
            URelaxer.setAttributePropertyByString(element, "debug", this.debug_);
        }
        size = this.help_.size();
        for (int i = 0;i < size;i++) {
            FCHelp value = (FCHelp)this.help_.get(i);
            value.makeElement(element);
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
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCScriptService</code> by the File <code>file</code>.
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
     * Initializes the <code>FCScriptService</code>
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
     * Initializes the <code>FCScriptService</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCScriptService</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCScriptService</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCScriptService</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>role</b>.
     *
     * @return String
     */
    public String getRole() {
        return (role_);
    }

    /**
     * Sets the String property <b>role</b>.
     *
     * @param role
     */
    public void setRole(String role) {
        this.role_ = role;
    }

    /**
     * Gets the String property <b>debug</b>.
     *
     * @return String
     */
    public String getDebug() {
        return (debug_);
    }

    /**
     * Sets the String property <b>debug</b>.
     *
     * @param debug
     */
    public void setDebug(String debug) {
        this.debug_ = debug;
    }

    /**
     * Gets the FCHelp property <b>help</b>.
     *
     * @return FCHelp[]
     */
    public FCHelp[] getHelp() {
        FCHelp[] array = new FCHelp[help_.size()];
        return ((FCHelp[])help_.toArray(array));
    }

    /**
     * Sets the FCHelp property <b>help</b>.
     *
     * @param help
     */
    public void setHelp(FCHelp[] help) {
        this.help_.clear();
        for (int i = 0;i < help.length;i++) {
            addHelp(help[i]);
        }
        for (int i = 0;i < help.length;i++) {
            help[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCHelp property <b>help</b>.
     *
     * @param help
     */
    public void setHelp(FCHelp help) {
        this.help_.clear();
        addHelp(help);
        if (help != null) {
            help.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCHelp property <b>help</b>.
     *
     * @param help
     */
    public void addHelp(FCHelp help) {
        this.help_.add(help);
        if (help != null) {
            help.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCHelp property <b>help</b>.
     *
     * @param help
     */
    public void addHelp(FCHelp[] help) {
        for (int i = 0;i < help.length;i++) {
            addHelp(help[i]);
        }
        for (int i = 0;i < help.length;i++) {
            help[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCHelp property <b>help</b>.
     *
     * @return int
     */
    public int sizeHelp() {
        return (help_.size());
    }

    /**
     * Gets the FCHelp property <b>help</b> by index.
     *
     * @param index
     * @return FCHelp
     */
    public FCHelp getHelp(int index) {
        return ((FCHelp)help_.get(index));
    }

    /**
     * Sets the FCHelp property <b>help</b> by index.
     *
     * @param index
     * @param help
     */
    public void setHelp(int index, FCHelp help) {
        this.help_.set(index, help);
        if (help != null) {
            help.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCHelp property <b>help</b> by index.
     *
     * @param index
     * @param help
     */
    public void addHelp(int index, FCHelp help) {
        this.help_.add(index, help);
        if (help != null) {
            help.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCHelp property <b>help</b> by index.
     *
     * @param index
     */
    public void removeHelp(int index) {
        this.help_.remove(index);
    }

    /**
     * Remove the FCHelp property <b>help</b> by object.
     *
     * @param help
     */
    public void removeHelp(FCHelp help) {
        this.help_.remove(help);
    }

    /**
     * Clear the FCHelp property <b>help</b>.
     *
     */
    public void clearHelp() {
        this.help_.clear();
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
     * Gets the IFCPlainScriptBodyContentChoice property <b>plainScriptBodyContent</b>.
     *
     * @return IFCPlainScriptBodyContentChoice[]
     */
    public IFCPlainScriptBodyContentChoice[] getPlainScriptBodyContent() {
        IFCPlainScriptBodyContentChoice[] array = new IFCPlainScriptBodyContentChoice[plainScriptBodyContent_.size()];
        return ((IFCPlainScriptBodyContentChoice[])plainScriptBodyContent_.toArray(array));
    }

    /**
     * Sets the IFCPlainScriptBodyContentChoice property <b>plainScriptBodyContent</b>.
     *
     * @param plainScriptBodyContent
     */
    public void setPlainScriptBodyContent(IFCPlainScriptBodyContentChoice[] plainScriptBodyContent) {
        this.plainScriptBodyContent_.clear();
        for (int i = 0;i < plainScriptBodyContent.length;i++) {
            addPlainScriptBodyContent(plainScriptBodyContent[i]);
        }
        for (int i = 0;i < plainScriptBodyContent.length;i++) {
            plainScriptBodyContent[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the IFCPlainScriptBodyContentChoice property <b>plainScriptBodyContent</b>.
     *
     * @param plainScriptBodyContent
     */
    public void setPlainScriptBodyContent(IFCPlainScriptBodyContentChoice plainScriptBodyContent) {
        this.plainScriptBodyContent_.clear();
        addPlainScriptBodyContent(plainScriptBodyContent);
        if (plainScriptBodyContent != null) {
            plainScriptBodyContent.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCPlainScriptBodyContentChoice property <b>plainScriptBodyContent</b>.
     *
     * @param plainScriptBodyContent
     */
    public void addPlainScriptBodyContent(IFCPlainScriptBodyContentChoice plainScriptBodyContent) {
        this.plainScriptBodyContent_.add(plainScriptBodyContent);
        if (plainScriptBodyContent != null) {
            plainScriptBodyContent.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCPlainScriptBodyContentChoice property <b>plainScriptBodyContent</b>.
     *
     * @param plainScriptBodyContent
     */
    public void addPlainScriptBodyContent(IFCPlainScriptBodyContentChoice[] plainScriptBodyContent) {
        for (int i = 0;i < plainScriptBodyContent.length;i++) {
            addPlainScriptBodyContent(plainScriptBodyContent[i]);
        }
        for (int i = 0;i < plainScriptBodyContent.length;i++) {
            plainScriptBodyContent[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the IFCPlainScriptBodyContentChoice property <b>plainScriptBodyContent</b>.
     *
     * @return int
     */
    public int sizePlainScriptBodyContent() {
        return (plainScriptBodyContent_.size());
    }

    /**
     * Gets the IFCPlainScriptBodyContentChoice property <b>plainScriptBodyContent</b> by index.
     *
     * @param index
     * @return IFCPlainScriptBodyContentChoice
     */
    public IFCPlainScriptBodyContentChoice getPlainScriptBodyContent(int index) {
        return ((IFCPlainScriptBodyContentChoice)plainScriptBodyContent_.get(index));
    }

    /**
     * Sets the IFCPlainScriptBodyContentChoice property <b>plainScriptBodyContent</b> by index.
     *
     * @param index
     * @param plainScriptBodyContent
     */
    public void setPlainScriptBodyContent(int index, IFCPlainScriptBodyContentChoice plainScriptBodyContent) {
        this.plainScriptBodyContent_.set(index, plainScriptBodyContent);
        if (plainScriptBodyContent != null) {
            plainScriptBodyContent.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCPlainScriptBodyContentChoice property <b>plainScriptBodyContent</b> by index.
     *
     * @param index
     * @param plainScriptBodyContent
     */
    public void addPlainScriptBodyContent(int index, IFCPlainScriptBodyContentChoice plainScriptBodyContent) {
        this.plainScriptBodyContent_.add(index, plainScriptBodyContent);
        if (plainScriptBodyContent != null) {
            plainScriptBodyContent.rSetParentRNode(this);
        }
    }

    /**
     * Remove the IFCPlainScriptBodyContentChoice property <b>plainScriptBodyContent</b> by index.
     *
     * @param index
     */
    public void removePlainScriptBodyContent(int index) {
        this.plainScriptBodyContent_.remove(index);
    }

    /**
     * Remove the IFCPlainScriptBodyContentChoice property <b>plainScriptBodyContent</b> by object.
     *
     * @param plainScriptBodyContent
     */
    public void removePlainScriptBodyContent(IFCPlainScriptBodyContentChoice plainScriptBodyContent) {
        this.plainScriptBodyContent_.remove(plainScriptBodyContent);
    }

    /**
     * Clear the IFCPlainScriptBodyContentChoice property <b>plainScriptBodyContent</b>.
     *
     */
    public void clearPlainScriptBodyContent() {
        this.plainScriptBodyContent_.clear();
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
        URelaxer.makeQName(prefix, "service", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.append(" ");
            buffer.append("name");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
        if (role_ != null) {
            buffer.append(" ");
            buffer.append("role");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getRole())));
            buffer.append("\"");
        }
        if (debug_ != null) {
            buffer.append(" ");
            buffer.append("debug");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getDebug())));
            buffer.append("\"");
        }
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.help_.size();
        for (int i = 0;i < size;i++) {
            FCHelp value = (FCHelp)this.help_.get(i);
            value.makeTextElement(buffer);
        }
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
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "service", buffer);
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
        URelaxer.makeQName(prefix, "service", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.write(" ");
            buffer.write("name");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
        if (role_ != null) {
            buffer.write(" ");
            buffer.write("role");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getRole())));
            buffer.write("\"");
        }
        if (debug_ != null) {
            buffer.write(" ");
            buffer.write("debug");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getDebug())));
            buffer.write("\"");
        }
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.help_.size();
        for (int i = 0;i < size;i++) {
            FCHelp value = (FCHelp)this.help_.get(i);
            value.makeTextElement(buffer);
        }
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
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "service", buffer);
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
        URelaxer.makeQName(prefix, "service", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.print(" ");
            buffer.print("name");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
        if (role_ != null) {
            buffer.print(" ");
            buffer.print("role");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getRole())));
            buffer.print("\"");
        }
        if (debug_ != null) {
            buffer.print(" ");
            buffer.print("debug");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getDebug())));
            buffer.print("\"");
        }
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.help_.size();
        for (int i = 0;i < size;i++) {
            FCHelp value = (FCHelp)this.help_.get(i);
            value.makeTextElement(buffer);
        }
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
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "service", buffer);
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
    public String getRoleAsString() {
        return (URelaxer.getString(getRole()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getDebugAsString() {
        return (URelaxer.getString(getDebug()));
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
    public void setRoleByString(String string) {
        setRole(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setDebugByString(String string) {
        setDebug(string);
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
        classNodes.addAll(help_);
        classNodes.addAll(slot_);
        if (prologue_ != null) {
            classNodes.add(prologue_);
        }
        if (epilogue_ != null) {
            classNodes.add(epilogue_);
        }
        classNodes.addAll(plainScriptBodyContent_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCScriptService</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework", "service")) {
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
        if (!URelaxer.hasAttributeHungry(target, "debug")) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!FCHelp.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
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
            if (FCComponentAction.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCModelAction.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCServiceAction.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCResourceAction.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCSystemAction.isMatchHungry(target)) {
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
     * is valid for the <code>FCScriptService</code>.
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
     * is valid for the <code>FCScriptService</code>.
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
