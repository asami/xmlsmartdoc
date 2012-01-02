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
 * <b>FCConfig</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="config">
 *       <ref name="application-config"/>
 *       <ref name="component-config"/>
 *       <ref name="framework-config"/>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="config"&gt;
 *       &lt;ref name="application-config"/&gt;
 *       &lt;ref name="component-config"/&gt;
 *       &lt;ref name="framework-config"/&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:39 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCConfig extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    // List<FCCopyright>
    private java.util.List copyright_ = new java.util.ArrayList();
    // List<FCVersion>
    private java.util.List version_ = new java.util.ArrayList();
    // List<FCUsage>
    private java.util.List usage_ = new java.util.ArrayList();
    // List<FCSlot>
    private java.util.List slot_ = new java.util.ArrayList();
    private java.util.Map slot_$map = new java.util.HashMap();
    private FCPrologue prologue_;
    private FCEpilogue epilogue_;
    private FCDialog dialog_;
    // List<IFCServiceChoice>
    private java.util.List service_ = new java.util.ArrayList();
    // List<IFCOptionsChoice>
    private java.util.List options_ = new java.util.ArrayList();
    // List<FCComponent>
    private java.util.List component_ = new java.util.ArrayList();
    private java.util.Map component_$map = new java.util.HashMap();
    // List<FCModel>
    private java.util.List model_ = new java.util.ArrayList();
    private java.util.Map model_$map = new java.util.HashMap();
    // List<FCResource>
    private java.util.List resource_ = new java.util.ArrayList();
    private java.util.Map resource_$map = new java.util.HashMap();
    private FCFrameworkLog frameworkLog_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCConfig</code>.
     *
     */
    public FCConfig() {
    }

    /**
     * Creates a <code>FCConfig</code>.
     *
     * @param source
     */
    public FCConfig(FCConfig source) {
        setup(source);
    }

    /**
     * Creates a <code>FCConfig</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCConfig(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCConfig</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConfig(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCConfig</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConfig(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCConfig</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConfig(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCConfig</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConfig(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCConfig</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConfig(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCConfig</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConfig(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCConfig</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConfig(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCConfig</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConfig(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCConfig</code> by the FCConfig <code>source</code>.
     *
     * @param source
     */
    public void setup(FCConfig source) {
        int size;
        this.copyright_.clear();
        size = source.copyright_.size();
        for (int i = 0;i < size;i++) {
            addCopyright((FCCopyright)source.getCopyright(i).clone());
        }
        this.version_.clear();
        size = source.version_.size();
        for (int i = 0;i < size;i++) {
            addVersion((FCVersion)source.getVersion(i).clone());
        }
        this.usage_.clear();
        size = source.usage_.size();
        for (int i = 0;i < size;i++) {
            addUsage((FCUsage)source.getUsage(i).clone());
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
        if (source.dialog_ != null) {
            setDialog((FCDialog)source.getDialog().clone());
        }
        this.service_.clear();
        size = source.service_.size();
        for (int i = 0;i < size;i++) {
            addService((IFCServiceChoice)source.getService(i).clone());
        }
        this.options_.clear();
        size = source.options_.size();
        for (int i = 0;i < size;i++) {
            addOptions((IFCOptionsChoice)source.getOptions(i).clone());
        }
        this.component_.clear();
        size = source.component_.size();
        for (int i = 0;i < size;i++) {
            addComponent((FCComponent)source.getComponent(i).clone());
        }
        this.model_.clear();
        size = source.model_.size();
        for (int i = 0;i < size;i++) {
            addModel((FCModel)source.getModel(i).clone());
        }
        this.resource_.clear();
        size = source.resource_.size();
        for (int i = 0;i < size;i++) {
            addResource((FCResource)source.getResource(i).clone());
        }
        if (source.frameworkLog_ != null) {
            setFrameworkLog((FCFrameworkLog)source.getFrameworkLog().clone());
        }
    }

    /**
     * Initializes the <code>FCConfig</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCConfig</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCConfig</code> by the Stack <code>stack</code>
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
        copyright_.clear();
        while (true) {
            if (FCCopyright.isMatch(stack)) {
                addCopyright(factory.createFCCopyright(stack));
            } else {
                break;
            }
        }
        version_.clear();
        while (true) {
            if (FCVersion.isMatch(stack)) {
                addVersion(factory.createFCVersion(stack));
            } else {
                break;
            }
        }
        usage_.clear();
        while (true) {
            if (FCUsage.isMatch(stack)) {
                addUsage(factory.createFCUsage(stack));
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
        if (FCDialog.isMatch(stack)) {
            setDialog(factory.createFCDialog(stack));
        }
        service_.clear();
        while (true) {
            if (FCScriptService.isMatch(stack)) {
                addService(factory.createFCScriptService(stack));
            } else if (FCComponentService.isMatch(stack)) {
                addService(factory.createFCComponentService(stack));
            } else if (FCSystemService.isMatch(stack)) {
                addService(factory.createFCSystemService(stack));
            } else {
                break;
            }
        }
        options_.clear();
        while (true) {
            if (FCComponentOption.isMatch(stack)) {
                addOptions(factory.createFCComponentOption(stack));
            } else if (FCSystemOption.isMatch(stack)) {
                addOptions(factory.createFCSystemOption(stack));
            } else if (FCOptionSet.isMatch(stack)) {
                addOptions(factory.createFCOptionSet(stack));
            } else {
                break;
            }
        }
        component_.clear();
        while (true) {
            if (FCComponent.isMatch(stack)) {
                addComponent(factory.createFCComponent(stack));
            } else {
                break;
            }
        }
        model_.clear();
        while (true) {
            if (FCModel.isMatch(stack)) {
                addModel(factory.createFCModel(stack));
            } else {
                break;
            }
        }
        resource_.clear();
        while (true) {
            if (FCResource.isMatch(stack)) {
                addResource(factory.createFCResource(stack));
            } else {
                break;
            }
        }
        if (FCFrameworkLog.isMatch(stack)) {
            setFrameworkLog(factory.createFCFrameworkLog(stack));
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        IConfigFactory factory = ConfigFactory.getFactory();
        return (factory.createFCConfig((FCConfig)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework", "config");
        rNSContext_.setupNamespace(element);
        int size;
        size = this.copyright_.size();
        for (int i = 0;i < size;i++) {
            FCCopyright value = (FCCopyright)this.copyright_.get(i);
            value.makeElement(element);
        }
        size = this.version_.size();
        for (int i = 0;i < size;i++) {
            FCVersion value = (FCVersion)this.version_.get(i);
            value.makeElement(element);
        }
        size = this.usage_.size();
        for (int i = 0;i < size;i++) {
            FCUsage value = (FCUsage)this.usage_.get(i);
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
        if (this.dialog_ != null) {
            this.dialog_.makeElement(element);
        }
        size = this.service_.size();
        for (int i = 0;i < size;i++) {
            IFCServiceChoice value = (IFCServiceChoice)this.service_.get(i);
            value.makeElement(element);
        }
        size = this.options_.size();
        for (int i = 0;i < size;i++) {
            IFCOptionsChoice value = (IFCOptionsChoice)this.options_.get(i);
            value.makeElement(element);
        }
        size = this.component_.size();
        for (int i = 0;i < size;i++) {
            FCComponent value = (FCComponent)this.component_.get(i);
            value.makeElement(element);
        }
        size = this.model_.size();
        for (int i = 0;i < size;i++) {
            FCModel value = (FCModel)this.model_.get(i);
            value.makeElement(element);
        }
        size = this.resource_.size();
        for (int i = 0;i < size;i++) {
            FCResource value = (FCResource)this.resource_.get(i);
            value.makeElement(element);
        }
        if (this.frameworkLog_ != null) {
            this.frameworkLog_.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCConfig</code> by the File <code>file</code>.
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
     * Initializes the <code>FCConfig</code>
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
     * Initializes the <code>FCConfig</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCConfig</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCConfig</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCConfig</code> by the Reader <code>reader</code>.
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
     * Gets the FCCopyright property <b>copyright</b>.
     *
     * @return FCCopyright[]
     */
    public FCCopyright[] getCopyright() {
        FCCopyright[] array = new FCCopyright[copyright_.size()];
        return ((FCCopyright[])copyright_.toArray(array));
    }

    /**
     * Sets the FCCopyright property <b>copyright</b>.
     *
     * @param copyright
     */
    public void setCopyright(FCCopyright[] copyright) {
        this.copyright_.clear();
        for (int i = 0;i < copyright.length;i++) {
            addCopyright(copyright[i]);
        }
        for (int i = 0;i < copyright.length;i++) {
            copyright[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCCopyright property <b>copyright</b>.
     *
     * @param copyright
     */
    public void setCopyright(FCCopyright copyright) {
        this.copyright_.clear();
        addCopyright(copyright);
        if (copyright != null) {
            copyright.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCCopyright property <b>copyright</b>.
     *
     * @param copyright
     */
    public void addCopyright(FCCopyright copyright) {
        this.copyright_.add(copyright);
        if (copyright != null) {
            copyright.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCCopyright property <b>copyright</b>.
     *
     * @param copyright
     */
    public void addCopyright(FCCopyright[] copyright) {
        for (int i = 0;i < copyright.length;i++) {
            addCopyright(copyright[i]);
        }
        for (int i = 0;i < copyright.length;i++) {
            copyright[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCCopyright property <b>copyright</b>.
     *
     * @return int
     */
    public int sizeCopyright() {
        return (copyright_.size());
    }

    /**
     * Gets the FCCopyright property <b>copyright</b> by index.
     *
     * @param index
     * @return FCCopyright
     */
    public FCCopyright getCopyright(int index) {
        return ((FCCopyright)copyright_.get(index));
    }

    /**
     * Sets the FCCopyright property <b>copyright</b> by index.
     *
     * @param index
     * @param copyright
     */
    public void setCopyright(int index, FCCopyright copyright) {
        this.copyright_.set(index, copyright);
        if (copyright != null) {
            copyright.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCCopyright property <b>copyright</b> by index.
     *
     * @param index
     * @param copyright
     */
    public void addCopyright(int index, FCCopyright copyright) {
        this.copyright_.add(index, copyright);
        if (copyright != null) {
            copyright.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCCopyright property <b>copyright</b> by index.
     *
     * @param index
     */
    public void removeCopyright(int index) {
        this.copyright_.remove(index);
    }

    /**
     * Remove the FCCopyright property <b>copyright</b> by object.
     *
     * @param copyright
     */
    public void removeCopyright(FCCopyright copyright) {
        this.copyright_.remove(copyright);
    }

    /**
     * Clear the FCCopyright property <b>copyright</b>.
     *
     */
    public void clearCopyright() {
        this.copyright_.clear();
    }

    /**
     * Gets the FCVersion property <b>version</b>.
     *
     * @return FCVersion[]
     */
    public FCVersion[] getVersion() {
        FCVersion[] array = new FCVersion[version_.size()];
        return ((FCVersion[])version_.toArray(array));
    }

    /**
     * Sets the FCVersion property <b>version</b>.
     *
     * @param version
     */
    public void setVersion(FCVersion[] version) {
        this.version_.clear();
        for (int i = 0;i < version.length;i++) {
            addVersion(version[i]);
        }
        for (int i = 0;i < version.length;i++) {
            version[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCVersion property <b>version</b>.
     *
     * @param version
     */
    public void setVersion(FCVersion version) {
        this.version_.clear();
        addVersion(version);
        if (version != null) {
            version.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCVersion property <b>version</b>.
     *
     * @param version
     */
    public void addVersion(FCVersion version) {
        this.version_.add(version);
        if (version != null) {
            version.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCVersion property <b>version</b>.
     *
     * @param version
     */
    public void addVersion(FCVersion[] version) {
        for (int i = 0;i < version.length;i++) {
            addVersion(version[i]);
        }
        for (int i = 0;i < version.length;i++) {
            version[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCVersion property <b>version</b>.
     *
     * @return int
     */
    public int sizeVersion() {
        return (version_.size());
    }

    /**
     * Gets the FCVersion property <b>version</b> by index.
     *
     * @param index
     * @return FCVersion
     */
    public FCVersion getVersion(int index) {
        return ((FCVersion)version_.get(index));
    }

    /**
     * Sets the FCVersion property <b>version</b> by index.
     *
     * @param index
     * @param version
     */
    public void setVersion(int index, FCVersion version) {
        this.version_.set(index, version);
        if (version != null) {
            version.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCVersion property <b>version</b> by index.
     *
     * @param index
     * @param version
     */
    public void addVersion(int index, FCVersion version) {
        this.version_.add(index, version);
        if (version != null) {
            version.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCVersion property <b>version</b> by index.
     *
     * @param index
     */
    public void removeVersion(int index) {
        this.version_.remove(index);
    }

    /**
     * Remove the FCVersion property <b>version</b> by object.
     *
     * @param version
     */
    public void removeVersion(FCVersion version) {
        this.version_.remove(version);
    }

    /**
     * Clear the FCVersion property <b>version</b>.
     *
     */
    public void clearVersion() {
        this.version_.clear();
    }

    /**
     * Gets the FCUsage property <b>usage</b>.
     *
     * @return FCUsage[]
     */
    public FCUsage[] getUsage() {
        FCUsage[] array = new FCUsage[usage_.size()];
        return ((FCUsage[])usage_.toArray(array));
    }

    /**
     * Sets the FCUsage property <b>usage</b>.
     *
     * @param usage
     */
    public void setUsage(FCUsage[] usage) {
        this.usage_.clear();
        for (int i = 0;i < usage.length;i++) {
            addUsage(usage[i]);
        }
        for (int i = 0;i < usage.length;i++) {
            usage[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCUsage property <b>usage</b>.
     *
     * @param usage
     */
    public void setUsage(FCUsage usage) {
        this.usage_.clear();
        addUsage(usage);
        if (usage != null) {
            usage.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCUsage property <b>usage</b>.
     *
     * @param usage
     */
    public void addUsage(FCUsage usage) {
        this.usage_.add(usage);
        if (usage != null) {
            usage.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCUsage property <b>usage</b>.
     *
     * @param usage
     */
    public void addUsage(FCUsage[] usage) {
        for (int i = 0;i < usage.length;i++) {
            addUsage(usage[i]);
        }
        for (int i = 0;i < usage.length;i++) {
            usage[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCUsage property <b>usage</b>.
     *
     * @return int
     */
    public int sizeUsage() {
        return (usage_.size());
    }

    /**
     * Gets the FCUsage property <b>usage</b> by index.
     *
     * @param index
     * @return FCUsage
     */
    public FCUsage getUsage(int index) {
        return ((FCUsage)usage_.get(index));
    }

    /**
     * Sets the FCUsage property <b>usage</b> by index.
     *
     * @param index
     * @param usage
     */
    public void setUsage(int index, FCUsage usage) {
        this.usage_.set(index, usage);
        if (usage != null) {
            usage.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCUsage property <b>usage</b> by index.
     *
     * @param index
     * @param usage
     */
    public void addUsage(int index, FCUsage usage) {
        this.usage_.add(index, usage);
        if (usage != null) {
            usage.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCUsage property <b>usage</b> by index.
     *
     * @param index
     */
    public void removeUsage(int index) {
        this.usage_.remove(index);
    }

    /**
     * Remove the FCUsage property <b>usage</b> by object.
     *
     * @param usage
     */
    public void removeUsage(FCUsage usage) {
        this.usage_.remove(usage);
    }

    /**
     * Clear the FCUsage property <b>usage</b>.
     *
     */
    public void clearUsage() {
        this.usage_.clear();
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
     * Gets the FCDialog property <b>dialog</b>.
     *
     * @return FCDialog
     */
    public FCDialog getDialog() {
        return (dialog_);
    }

    /**
     * Sets the FCDialog property <b>dialog</b>.
     *
     * @param dialog
     */
    public void setDialog(FCDialog dialog) {
        this.dialog_ = dialog;
        if (dialog != null) {
            dialog.rSetParentRNode(this);
        }
    }

    /**
     * Gets the IFCServiceChoice property <b>service</b>.
     *
     * @return IFCServiceChoice[]
     */
    public IFCServiceChoice[] getService() {
        IFCServiceChoice[] array = new IFCServiceChoice[service_.size()];
        return ((IFCServiceChoice[])service_.toArray(array));
    }

    /**
     * Sets the IFCServiceChoice property <b>service</b>.
     *
     * @param service
     */
    public void setService(IFCServiceChoice[] service) {
        this.service_.clear();
        for (int i = 0;i < service.length;i++) {
            addService(service[i]);
        }
        for (int i = 0;i < service.length;i++) {
            service[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the IFCServiceChoice property <b>service</b>.
     *
     * @param service
     */
    public void setService(IFCServiceChoice service) {
        this.service_.clear();
        addService(service);
        if (service != null) {
            service.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCServiceChoice property <b>service</b>.
     *
     * @param service
     */
    public void addService(IFCServiceChoice service) {
        this.service_.add(service);
        if (service != null) {
            service.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCServiceChoice property <b>service</b>.
     *
     * @param service
     */
    public void addService(IFCServiceChoice[] service) {
        for (int i = 0;i < service.length;i++) {
            addService(service[i]);
        }
        for (int i = 0;i < service.length;i++) {
            service[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the IFCServiceChoice property <b>service</b>.
     *
     * @return int
     */
    public int sizeService() {
        return (service_.size());
    }

    /**
     * Gets the IFCServiceChoice property <b>service</b> by index.
     *
     * @param index
     * @return IFCServiceChoice
     */
    public IFCServiceChoice getService(int index) {
        return ((IFCServiceChoice)service_.get(index));
    }

    /**
     * Sets the IFCServiceChoice property <b>service</b> by index.
     *
     * @param index
     * @param service
     */
    public void setService(int index, IFCServiceChoice service) {
        this.service_.set(index, service);
        if (service != null) {
            service.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCServiceChoice property <b>service</b> by index.
     *
     * @param index
     * @param service
     */
    public void addService(int index, IFCServiceChoice service) {
        this.service_.add(index, service);
        if (service != null) {
            service.rSetParentRNode(this);
        }
    }

    /**
     * Remove the IFCServiceChoice property <b>service</b> by index.
     *
     * @param index
     */
    public void removeService(int index) {
        this.service_.remove(index);
    }

    /**
     * Remove the IFCServiceChoice property <b>service</b> by object.
     *
     * @param service
     */
    public void removeService(IFCServiceChoice service) {
        this.service_.remove(service);
    }

    /**
     * Clear the IFCServiceChoice property <b>service</b>.
     *
     */
    public void clearService() {
        this.service_.clear();
    }

    /**
     * Gets the IFCOptionsChoice property <b>options</b>.
     *
     * @return IFCOptionsChoice[]
     */
    public IFCOptionsChoice[] getOptions() {
        IFCOptionsChoice[] array = new IFCOptionsChoice[options_.size()];
        return ((IFCOptionsChoice[])options_.toArray(array));
    }

    /**
     * Sets the IFCOptionsChoice property <b>options</b>.
     *
     * @param options
     */
    public void setOptions(IFCOptionsChoice[] options) {
        this.options_.clear();
        for (int i = 0;i < options.length;i++) {
            addOptions(options[i]);
        }
        for (int i = 0;i < options.length;i++) {
            options[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the IFCOptionsChoice property <b>options</b>.
     *
     * @param options
     */
    public void setOptions(IFCOptionsChoice options) {
        this.options_.clear();
        addOptions(options);
        if (options != null) {
            options.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCOptionsChoice property <b>options</b>.
     *
     * @param options
     */
    public void addOptions(IFCOptionsChoice options) {
        this.options_.add(options);
        if (options != null) {
            options.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCOptionsChoice property <b>options</b>.
     *
     * @param options
     */
    public void addOptions(IFCOptionsChoice[] options) {
        for (int i = 0;i < options.length;i++) {
            addOptions(options[i]);
        }
        for (int i = 0;i < options.length;i++) {
            options[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the IFCOptionsChoice property <b>options</b>.
     *
     * @return int
     */
    public int sizeOptions() {
        return (options_.size());
    }

    /**
     * Gets the IFCOptionsChoice property <b>options</b> by index.
     *
     * @param index
     * @return IFCOptionsChoice
     */
    public IFCOptionsChoice getOptions(int index) {
        return ((IFCOptionsChoice)options_.get(index));
    }

    /**
     * Sets the IFCOptionsChoice property <b>options</b> by index.
     *
     * @param index
     * @param options
     */
    public void setOptions(int index, IFCOptionsChoice options) {
        this.options_.set(index, options);
        if (options != null) {
            options.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCOptionsChoice property <b>options</b> by index.
     *
     * @param index
     * @param options
     */
    public void addOptions(int index, IFCOptionsChoice options) {
        this.options_.add(index, options);
        if (options != null) {
            options.rSetParentRNode(this);
        }
    }

    /**
     * Remove the IFCOptionsChoice property <b>options</b> by index.
     *
     * @param index
     */
    public void removeOptions(int index) {
        this.options_.remove(index);
    }

    /**
     * Remove the IFCOptionsChoice property <b>options</b> by object.
     *
     * @param options
     */
    public void removeOptions(IFCOptionsChoice options) {
        this.options_.remove(options);
    }

    /**
     * Clear the IFCOptionsChoice property <b>options</b>.
     *
     */
    public void clearOptions() {
        this.options_.clear();
    }

    /**
     * Gets the FCComponent property <b>component</b>.
     *
     * @return FCComponent[]
     */
    public FCComponent[] getComponent() {
        FCComponent[] array = new FCComponent[component_.size()];
        return ((FCComponent[])component_.toArray(array));
    }

    /**
     * Sets the FCComponent property <b>component</b>.
     *
     * @param component
     */
    public void setComponent(FCComponent[] component) {
        this.component_.clear();
        for (int i = 0;i < component.length;i++) {
            addComponent(component[i]);
        }
        for (int i = 0;i < component.length;i++) {
            component[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCComponent property <b>component</b>.
     *
     * @param component
     */
    public void setComponent(FCComponent component) {
        this.component_.clear();
        addComponent(component);
        if (component != null) {
            component.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCComponent property <b>component</b>.
     *
     * @param component
     */
    public void addComponent(FCComponent component) {
        Object $key$ = component.getName();
        if ($key$ != null) {
            Object $value$ = this.component_$map.get($key$);
            if ($value$ != null) {
                this.component_.remove($value$);
        }
            this.component_$map.put($key$, component);
        }
        this.component_.add(component);
        if (component != null) {
            component.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCComponent property <b>component</b>.
     *
     * @param component
     */
    public void addComponent(FCComponent[] component) {
        for (int i = 0;i < component.length;i++) {
            addComponent(component[i]);
        }
        for (int i = 0;i < component.length;i++) {
            component[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCComponent property <b>component</b>.
     *
     * @return int
     */
    public int sizeComponent() {
        return (component_.size());
    }

    /**
     * Gets the FCComponent property <b>component</b> by index.
     *
     * @param index
     * @return FCComponent
     */
    public FCComponent getComponent(int index) {
        return ((FCComponent)component_.get(index));
    }

    /**
     * Sets the FCComponent property <b>component</b> by index.
     *
     * @param index
     * @param component
     */
    public void setComponent(int index, FCComponent component) {
        Object $key$ = component.getName();
        if ($key$ != null) {
            Object $value$ = this.component_$map.get($key$);
            if ($value$ != null) {
                this.component_.remove($value$);
        }
            this.component_$map.put($key$, component);
        }
        this.component_.set(index, component);
        if (component != null) {
            component.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCComponent property <b>component</b> by index.
     *
     * @param index
     * @param component
     */
    public void addComponent(int index, FCComponent component) {
        Object $key$ = component.getName();
        if ($key$ != null) {
            Object $value$ = this.component_$map.get($key$);
            if ($value$ != null) {
                this.component_.remove($value$);
        }
            this.component_$map.put($key$, component);
        }
        this.component_.add(index, component);
        if (component != null) {
            component.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCComponent property <b>component</b> by index.
     *
     * @param index
     */
    public void removeComponent(int index) {
        FCComponent $value$ = (FCComponent)component_.get(index);
        if ($value$ != null) {
            removeComponent($value$);
        }
        this.component_.remove(index);
    }

    /**
     * Remove the FCComponent property <b>component</b> by object.
     *
     * @param component
     */
    public void removeComponent(FCComponent component) {
        Object $key$ = component.getName();
        this.component_$map.remove($key$);
        this.component_.remove(component);
    }

    /**
     * Clear the FCComponent property <b>component</b>.
     *
     */
    public void clearComponent() {
        this.component_$map.clear();
        this.component_.clear();
    }

    /**
     * Gets the FCComponent property <b>component</b> by key.
     *
     * @param key
     * @return FCComponent
     */
    public FCComponent getComponentByName(String key) {
        return ((FCComponent)component_$map.get(key));
    }

    /**
     * Gets the FCModel property <b>model</b>.
     *
     * @return FCModel[]
     */
    public FCModel[] getModel() {
        FCModel[] array = new FCModel[model_.size()];
        return ((FCModel[])model_.toArray(array));
    }

    /**
     * Sets the FCModel property <b>model</b>.
     *
     * @param model
     */
    public void setModel(FCModel[] model) {
        this.model_.clear();
        for (int i = 0;i < model.length;i++) {
            addModel(model[i]);
        }
        for (int i = 0;i < model.length;i++) {
            model[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCModel property <b>model</b>.
     *
     * @param model
     */
    public void setModel(FCModel model) {
        this.model_.clear();
        addModel(model);
        if (model != null) {
            model.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCModel property <b>model</b>.
     *
     * @param model
     */
    public void addModel(FCModel model) {
        Object $key$ = model.getName();
        if ($key$ != null) {
            Object $value$ = this.model_$map.get($key$);
            if ($value$ != null) {
                this.model_.remove($value$);
        }
            this.model_$map.put($key$, model);
        }
        this.model_.add(model);
        if (model != null) {
            model.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCModel property <b>model</b>.
     *
     * @param model
     */
    public void addModel(FCModel[] model) {
        for (int i = 0;i < model.length;i++) {
            addModel(model[i]);
        }
        for (int i = 0;i < model.length;i++) {
            model[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCModel property <b>model</b>.
     *
     * @return int
     */
    public int sizeModel() {
        return (model_.size());
    }

    /**
     * Gets the FCModel property <b>model</b> by index.
     *
     * @param index
     * @return FCModel
     */
    public FCModel getModel(int index) {
        return ((FCModel)model_.get(index));
    }

    /**
     * Sets the FCModel property <b>model</b> by index.
     *
     * @param index
     * @param model
     */
    public void setModel(int index, FCModel model) {
        Object $key$ = model.getName();
        if ($key$ != null) {
            Object $value$ = this.model_$map.get($key$);
            if ($value$ != null) {
                this.model_.remove($value$);
        }
            this.model_$map.put($key$, model);
        }
        this.model_.set(index, model);
        if (model != null) {
            model.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCModel property <b>model</b> by index.
     *
     * @param index
     * @param model
     */
    public void addModel(int index, FCModel model) {
        Object $key$ = model.getName();
        if ($key$ != null) {
            Object $value$ = this.model_$map.get($key$);
            if ($value$ != null) {
                this.model_.remove($value$);
        }
            this.model_$map.put($key$, model);
        }
        this.model_.add(index, model);
        if (model != null) {
            model.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCModel property <b>model</b> by index.
     *
     * @param index
     */
    public void removeModel(int index) {
        FCModel $value$ = (FCModel)model_.get(index);
        if ($value$ != null) {
            removeModel($value$);
        }
        this.model_.remove(index);
    }

    /**
     * Remove the FCModel property <b>model</b> by object.
     *
     * @param model
     */
    public void removeModel(FCModel model) {
        Object $key$ = model.getName();
        this.model_$map.remove($key$);
        this.model_.remove(model);
    }

    /**
     * Clear the FCModel property <b>model</b>.
     *
     */
    public void clearModel() {
        this.model_$map.clear();
        this.model_.clear();
    }

    /**
     * Gets the FCModel property <b>model</b> by key.
     *
     * @param key
     * @return FCModel
     */
    public FCModel getModelByName(String key) {
        return ((FCModel)model_$map.get(key));
    }

    /**
     * Gets the FCResource property <b>resource</b>.
     *
     * @return FCResource[]
     */
    public FCResource[] getResource() {
        FCResource[] array = new FCResource[resource_.size()];
        return ((FCResource[])resource_.toArray(array));
    }

    /**
     * Sets the FCResource property <b>resource</b>.
     *
     * @param resource
     */
    public void setResource(FCResource[] resource) {
        this.resource_.clear();
        for (int i = 0;i < resource.length;i++) {
            addResource(resource[i]);
        }
        for (int i = 0;i < resource.length;i++) {
            resource[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCResource property <b>resource</b>.
     *
     * @param resource
     */
    public void setResource(FCResource resource) {
        this.resource_.clear();
        addResource(resource);
        if (resource != null) {
            resource.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCResource property <b>resource</b>.
     *
     * @param resource
     */
    public void addResource(FCResource resource) {
        Object $key$ = resource.getName();
        if ($key$ != null) {
            Object $value$ = this.resource_$map.get($key$);
            if ($value$ != null) {
                this.resource_.remove($value$);
        }
            this.resource_$map.put($key$, resource);
        }
        this.resource_.add(resource);
        if (resource != null) {
            resource.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCResource property <b>resource</b>.
     *
     * @param resource
     */
    public void addResource(FCResource[] resource) {
        for (int i = 0;i < resource.length;i++) {
            addResource(resource[i]);
        }
        for (int i = 0;i < resource.length;i++) {
            resource[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCResource property <b>resource</b>.
     *
     * @return int
     */
    public int sizeResource() {
        return (resource_.size());
    }

    /**
     * Gets the FCResource property <b>resource</b> by index.
     *
     * @param index
     * @return FCResource
     */
    public FCResource getResource(int index) {
        return ((FCResource)resource_.get(index));
    }

    /**
     * Sets the FCResource property <b>resource</b> by index.
     *
     * @param index
     * @param resource
     */
    public void setResource(int index, FCResource resource) {
        Object $key$ = resource.getName();
        if ($key$ != null) {
            Object $value$ = this.resource_$map.get($key$);
            if ($value$ != null) {
                this.resource_.remove($value$);
        }
            this.resource_$map.put($key$, resource);
        }
        this.resource_.set(index, resource);
        if (resource != null) {
            resource.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCResource property <b>resource</b> by index.
     *
     * @param index
     * @param resource
     */
    public void addResource(int index, FCResource resource) {
        Object $key$ = resource.getName();
        if ($key$ != null) {
            Object $value$ = this.resource_$map.get($key$);
            if ($value$ != null) {
                this.resource_.remove($value$);
        }
            this.resource_$map.put($key$, resource);
        }
        this.resource_.add(index, resource);
        if (resource != null) {
            resource.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCResource property <b>resource</b> by index.
     *
     * @param index
     */
    public void removeResource(int index) {
        FCResource $value$ = (FCResource)resource_.get(index);
        if ($value$ != null) {
            removeResource($value$);
        }
        this.resource_.remove(index);
    }

    /**
     * Remove the FCResource property <b>resource</b> by object.
     *
     * @param resource
     */
    public void removeResource(FCResource resource) {
        Object $key$ = resource.getName();
        this.resource_$map.remove($key$);
        this.resource_.remove(resource);
    }

    /**
     * Clear the FCResource property <b>resource</b>.
     *
     */
    public void clearResource() {
        this.resource_$map.clear();
        this.resource_.clear();
    }

    /**
     * Gets the FCResource property <b>resource</b> by key.
     *
     * @param key
     * @return FCResource
     */
    public FCResource getResourceByName(String key) {
        return ((FCResource)resource_$map.get(key));
    }

    /**
     * Gets the FCFrameworkLog property <b>frameworkLog</b>.
     *
     * @return FCFrameworkLog
     */
    public FCFrameworkLog getFrameworkLog() {
        return (frameworkLog_);
    }

    /**
     * Sets the FCFrameworkLog property <b>frameworkLog</b>.
     *
     * @param frameworkLog
     */
    public void setFrameworkLog(FCFrameworkLog frameworkLog) {
        this.frameworkLog_ = frameworkLog;
        if (frameworkLog != null) {
            frameworkLog.rSetParentRNode(this);
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
        URelaxer.makeQName(prefix, "config", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.service_.size();
        for (int i = 0;i < size;i++) {
            IFCServiceChoice value = (IFCServiceChoice)this.service_.get(i);
            value.makeTextAttribute(buffer);
        }
        size = this.options_.size();
        for (int i = 0;i < size;i++) {
            IFCOptionsChoice value = (IFCOptionsChoice)this.options_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.copyright_.size();
        for (int i = 0;i < size;i++) {
            FCCopyright value = (FCCopyright)this.copyright_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.version_.size();
        for (int i = 0;i < size;i++) {
            FCVersion value = (FCVersion)this.version_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.usage_.size();
        for (int i = 0;i < size;i++) {
            FCUsage value = (FCUsage)this.usage_.get(i);
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
        if (dialog_ != null) {
            dialog_.makeTextElement(buffer);
        }
        size = this.service_.size();
        for (int i = 0;i < size;i++) {
            IFCServiceChoice value = (IFCServiceChoice)this.service_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.options_.size();
        for (int i = 0;i < size;i++) {
            IFCOptionsChoice value = (IFCOptionsChoice)this.options_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.component_.size();
        for (int i = 0;i < size;i++) {
            FCComponent value = (FCComponent)this.component_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.model_.size();
        for (int i = 0;i < size;i++) {
            FCModel value = (FCModel)this.model_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.resource_.size();
        for (int i = 0;i < size;i++) {
            FCResource value = (FCResource)this.resource_.get(i);
            value.makeTextElement(buffer);
        }
        if (frameworkLog_ != null) {
            frameworkLog_.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "config", buffer);
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
        URelaxer.makeQName(prefix, "config", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.service_.size();
        for (int i = 0;i < size;i++) {
            IFCServiceChoice value = (IFCServiceChoice)this.service_.get(i);
            value.makeTextAttribute(buffer);
        }
        size = this.options_.size();
        for (int i = 0;i < size;i++) {
            IFCOptionsChoice value = (IFCOptionsChoice)this.options_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.copyright_.size();
        for (int i = 0;i < size;i++) {
            FCCopyright value = (FCCopyright)this.copyright_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.version_.size();
        for (int i = 0;i < size;i++) {
            FCVersion value = (FCVersion)this.version_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.usage_.size();
        for (int i = 0;i < size;i++) {
            FCUsage value = (FCUsage)this.usage_.get(i);
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
        if (dialog_ != null) {
            dialog_.makeTextElement(buffer);
        }
        size = this.service_.size();
        for (int i = 0;i < size;i++) {
            IFCServiceChoice value = (IFCServiceChoice)this.service_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.options_.size();
        for (int i = 0;i < size;i++) {
            IFCOptionsChoice value = (IFCOptionsChoice)this.options_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.component_.size();
        for (int i = 0;i < size;i++) {
            FCComponent value = (FCComponent)this.component_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.model_.size();
        for (int i = 0;i < size;i++) {
            FCModel value = (FCModel)this.model_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.resource_.size();
        for (int i = 0;i < size;i++) {
            FCResource value = (FCResource)this.resource_.get(i);
            value.makeTextElement(buffer);
        }
        if (frameworkLog_ != null) {
            frameworkLog_.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "config", buffer);
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
        URelaxer.makeQName(prefix, "config", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.service_.size();
        for (int i = 0;i < size;i++) {
            IFCServiceChoice value = (IFCServiceChoice)this.service_.get(i);
            value.makeTextAttribute(buffer);
        }
        size = this.options_.size();
        for (int i = 0;i < size;i++) {
            IFCOptionsChoice value = (IFCOptionsChoice)this.options_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.copyright_.size();
        for (int i = 0;i < size;i++) {
            FCCopyright value = (FCCopyright)this.copyright_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.version_.size();
        for (int i = 0;i < size;i++) {
            FCVersion value = (FCVersion)this.version_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.usage_.size();
        for (int i = 0;i < size;i++) {
            FCUsage value = (FCUsage)this.usage_.get(i);
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
        if (dialog_ != null) {
            dialog_.makeTextElement(buffer);
        }
        size = this.service_.size();
        for (int i = 0;i < size;i++) {
            IFCServiceChoice value = (IFCServiceChoice)this.service_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.options_.size();
        for (int i = 0;i < size;i++) {
            IFCOptionsChoice value = (IFCOptionsChoice)this.options_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.component_.size();
        for (int i = 0;i < size;i++) {
            FCComponent value = (FCComponent)this.component_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.model_.size();
        for (int i = 0;i < size;i++) {
            FCModel value = (FCModel)this.model_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.resource_.size();
        for (int i = 0;i < size;i++) {
            FCResource value = (FCResource)this.resource_.get(i);
            value.makeTextElement(buffer);
        }
        if (frameworkLog_ != null) {
            frameworkLog_.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "config", buffer);
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
        classNodes.addAll(copyright_);
        classNodes.addAll(version_);
        classNodes.addAll(usage_);
        classNodes.addAll(slot_);
        if (prologue_ != null) {
            classNodes.add(prologue_);
        }
        if (epilogue_ != null) {
            classNodes.add(epilogue_);
        }
        if (dialog_ != null) {
            classNodes.add(dialog_);
        }
        classNodes.addAll(service_);
        classNodes.addAll(options_);
        classNodes.addAll(component_);
        classNodes.addAll(model_);
        classNodes.addAll(resource_);
        if (frameworkLog_ != null) {
            classNodes.add(frameworkLog_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCConfig</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework", "config")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        IConfigFactory factory = ConfigFactory.getFactory();
        Element child;
        while (true) {
            if (!FCCopyright.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!FCVersion.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!FCUsage.isMatchHungry(target)) {
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
        if (FCDialog.isMatchHungry(target)) {
        }
        while (true) {
            if (FCScriptService.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCComponentService.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCSystemService.isMatchHungry(target)) {
                $match$ = true;
            } else {
                break;
            }
        }
        while (true) {
            if (FCComponentOption.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCSystemOption.isMatchHungry(target)) {
                $match$ = true;
            } else if (FCOptionSet.isMatchHungry(target)) {
                $match$ = true;
            } else {
                break;
            }
        }
        while (true) {
            if (!FCComponent.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!FCModel.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!FCResource.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (FCFrameworkLog.isMatchHungry(target)) {
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FCConfig</code>.
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
     * is valid for the <code>FCConfig</code>.
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
