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
 * <b>FCModelAction</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="model">
 *       <attribute name="ref">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="event">
 *         <data type="token"/>
 *       </attribute>
 *       <zeroOrMore>
 *         <ref name="action-in"/>
 *       </zeroOrMore>
 *       <zeroOrMore>
 *         <ref name="action-out"/>
 *       </zeroOrMore>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="model"&gt;
 *       &lt;attribute name="ref"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="event"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="action-in"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="action-out"/&gt;
 *       &lt;/zeroOrMore&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:39 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCModelAction extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode, IFCPlainScriptBodyContentChoice, IFCScenarioScriptContentChoice {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    private String ref_;
    private String event_;
    // List<FCActionIn>
    private java.util.List actionIn_ = new java.util.ArrayList();
    // List<FCActionOut>
    private java.util.List actionOut_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCModelAction</code>.
     *
     */
    public FCModelAction() {
        ref_ = "";
        event_ = "";
    }

    /**
     * Creates a <code>FCModelAction</code>.
     *
     * @param source
     */
    public FCModelAction(FCModelAction source) {
        setup(source);
    }

    /**
     * Creates a <code>FCModelAction</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCModelAction(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCModelAction</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModelAction(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCModelAction</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModelAction(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCModelAction</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModelAction(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCModelAction</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModelAction(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCModelAction</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModelAction(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCModelAction</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModelAction(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCModelAction</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModelAction(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCModelAction</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCModelAction(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCModelAction</code> by the FCModelAction <code>source</code>.
     *
     * @param source
     */
    public void setup(FCModelAction source) {
        int size;
        ref_ = source.ref_;
        event_ = source.event_;
        this.actionIn_.clear();
        size = source.actionIn_.size();
        for (int i = 0;i < size;i++) {
            addActionIn((FCActionIn)source.getActionIn(i).clone());
        }
        this.actionOut_.clear();
        size = source.actionOut_.size();
        for (int i = 0;i < size;i++) {
            addActionOut((FCActionOut)source.getActionOut(i).clone());
        }
    }

    /**
     * Initializes the <code>FCModelAction</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCModelAction</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCModelAction</code> by the Stack <code>stack</code>
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
        ref_ = URelaxer.getAttributePropertyAsString(element, "ref");
        event_ = URelaxer.getAttributePropertyAsString(element, "event");
        actionIn_.clear();
        while (true) {
            if (FCActionIn.isMatch(stack)) {
                addActionIn(factory.createFCActionIn(stack));
            } else {
                break;
            }
        }
        actionOut_.clear();
        while (true) {
            if (FCActionOut.isMatch(stack)) {
                addActionOut(factory.createFCActionOut(stack));
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
        return (factory.createFCModelAction((FCModelAction)this));
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
        if (this.ref_ != null) {
            URelaxer.setAttributePropertyByString(element, "ref", this.ref_);
        }
        if (this.event_ != null) {
            URelaxer.setAttributePropertyByString(element, "event", this.event_);
        }
        size = this.actionIn_.size();
        for (int i = 0;i < size;i++) {
            FCActionIn value = (FCActionIn)this.actionIn_.get(i);
            value.makeElement(element);
        }
        size = this.actionOut_.size();
        for (int i = 0;i < size;i++) {
            FCActionOut value = (FCActionOut)this.actionOut_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCModelAction</code> by the File <code>file</code>.
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
     * Initializes the <code>FCModelAction</code>
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
     * Initializes the <code>FCModelAction</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCModelAction</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCModelAction</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCModelAction</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>ref</b>.
     *
     * @return String
     */
    public String getRef() {
        return (ref_);
    }

    /**
     * Sets the String property <b>ref</b>.
     *
     * @param ref
     */
    public void setRef(String ref) {
        this.ref_ = ref;
    }

    /**
     * Gets the String property <b>event</b>.
     *
     * @return String
     */
    public String getEvent() {
        return (event_);
    }

    /**
     * Sets the String property <b>event</b>.
     *
     * @param event
     */
    public void setEvent(String event) {
        this.event_ = event;
    }

    /**
     * Gets the FCActionIn property <b>actionIn</b>.
     *
     * @return FCActionIn[]
     */
    public FCActionIn[] getActionIn() {
        FCActionIn[] array = new FCActionIn[actionIn_.size()];
        return ((FCActionIn[])actionIn_.toArray(array));
    }

    /**
     * Sets the FCActionIn property <b>actionIn</b>.
     *
     * @param actionIn
     */
    public void setActionIn(FCActionIn[] actionIn) {
        this.actionIn_.clear();
        for (int i = 0;i < actionIn.length;i++) {
            addActionIn(actionIn[i]);
        }
        for (int i = 0;i < actionIn.length;i++) {
            actionIn[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCActionIn property <b>actionIn</b>.
     *
     * @param actionIn
     */
    public void setActionIn(FCActionIn actionIn) {
        this.actionIn_.clear();
        addActionIn(actionIn);
        if (actionIn != null) {
            actionIn.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCActionIn property <b>actionIn</b>.
     *
     * @param actionIn
     */
    public void addActionIn(FCActionIn actionIn) {
        this.actionIn_.add(actionIn);
        if (actionIn != null) {
            actionIn.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCActionIn property <b>actionIn</b>.
     *
     * @param actionIn
     */
    public void addActionIn(FCActionIn[] actionIn) {
        for (int i = 0;i < actionIn.length;i++) {
            addActionIn(actionIn[i]);
        }
        for (int i = 0;i < actionIn.length;i++) {
            actionIn[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCActionIn property <b>actionIn</b>.
     *
     * @return int
     */
    public int sizeActionIn() {
        return (actionIn_.size());
    }

    /**
     * Gets the FCActionIn property <b>actionIn</b> by index.
     *
     * @param index
     * @return FCActionIn
     */
    public FCActionIn getActionIn(int index) {
        return ((FCActionIn)actionIn_.get(index));
    }

    /**
     * Sets the FCActionIn property <b>actionIn</b> by index.
     *
     * @param index
     * @param actionIn
     */
    public void setActionIn(int index, FCActionIn actionIn) {
        this.actionIn_.set(index, actionIn);
        if (actionIn != null) {
            actionIn.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCActionIn property <b>actionIn</b> by index.
     *
     * @param index
     * @param actionIn
     */
    public void addActionIn(int index, FCActionIn actionIn) {
        this.actionIn_.add(index, actionIn);
        if (actionIn != null) {
            actionIn.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCActionIn property <b>actionIn</b> by index.
     *
     * @param index
     */
    public void removeActionIn(int index) {
        this.actionIn_.remove(index);
    }

    /**
     * Remove the FCActionIn property <b>actionIn</b> by object.
     *
     * @param actionIn
     */
    public void removeActionIn(FCActionIn actionIn) {
        this.actionIn_.remove(actionIn);
    }

    /**
     * Clear the FCActionIn property <b>actionIn</b>.
     *
     */
    public void clearActionIn() {
        this.actionIn_.clear();
    }

    /**
     * Gets the FCActionOut property <b>actionOut</b>.
     *
     * @return FCActionOut[]
     */
    public FCActionOut[] getActionOut() {
        FCActionOut[] array = new FCActionOut[actionOut_.size()];
        return ((FCActionOut[])actionOut_.toArray(array));
    }

    /**
     * Sets the FCActionOut property <b>actionOut</b>.
     *
     * @param actionOut
     */
    public void setActionOut(FCActionOut[] actionOut) {
        this.actionOut_.clear();
        for (int i = 0;i < actionOut.length;i++) {
            addActionOut(actionOut[i]);
        }
        for (int i = 0;i < actionOut.length;i++) {
            actionOut[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCActionOut property <b>actionOut</b>.
     *
     * @param actionOut
     */
    public void setActionOut(FCActionOut actionOut) {
        this.actionOut_.clear();
        addActionOut(actionOut);
        if (actionOut != null) {
            actionOut.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCActionOut property <b>actionOut</b>.
     *
     * @param actionOut
     */
    public void addActionOut(FCActionOut actionOut) {
        this.actionOut_.add(actionOut);
        if (actionOut != null) {
            actionOut.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCActionOut property <b>actionOut</b>.
     *
     * @param actionOut
     */
    public void addActionOut(FCActionOut[] actionOut) {
        for (int i = 0;i < actionOut.length;i++) {
            addActionOut(actionOut[i]);
        }
        for (int i = 0;i < actionOut.length;i++) {
            actionOut[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCActionOut property <b>actionOut</b>.
     *
     * @return int
     */
    public int sizeActionOut() {
        return (actionOut_.size());
    }

    /**
     * Gets the FCActionOut property <b>actionOut</b> by index.
     *
     * @param index
     * @return FCActionOut
     */
    public FCActionOut getActionOut(int index) {
        return ((FCActionOut)actionOut_.get(index));
    }

    /**
     * Sets the FCActionOut property <b>actionOut</b> by index.
     *
     * @param index
     * @param actionOut
     */
    public void setActionOut(int index, FCActionOut actionOut) {
        this.actionOut_.set(index, actionOut);
        if (actionOut != null) {
            actionOut.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCActionOut property <b>actionOut</b> by index.
     *
     * @param index
     * @param actionOut
     */
    public void addActionOut(int index, FCActionOut actionOut) {
        this.actionOut_.add(index, actionOut);
        if (actionOut != null) {
            actionOut.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCActionOut property <b>actionOut</b> by index.
     *
     * @param index
     */
    public void removeActionOut(int index) {
        this.actionOut_.remove(index);
    }

    /**
     * Remove the FCActionOut property <b>actionOut</b> by object.
     *
     * @param actionOut
     */
    public void removeActionOut(FCActionOut actionOut) {
        this.actionOut_.remove(actionOut);
    }

    /**
     * Clear the FCActionOut property <b>actionOut</b>.
     *
     */
    public void clearActionOut() {
        this.actionOut_.clear();
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
        if (ref_ != null) {
            buffer.append(" ");
            buffer.append("ref");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getRef())));
            buffer.append("\"");
        }
        if (event_ != null) {
            buffer.append(" ");
            buffer.append("event");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getEvent())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.actionIn_.size();
        for (int i = 0;i < size;i++) {
            FCActionIn value = (FCActionIn)this.actionIn_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.actionOut_.size();
        for (int i = 0;i < size;i++) {
            FCActionOut value = (FCActionOut)this.actionOut_.get(i);
            value.makeTextElement(buffer);
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
        if (ref_ != null) {
            buffer.write(" ");
            buffer.write("ref");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getRef())));
            buffer.write("\"");
        }
        if (event_ != null) {
            buffer.write(" ");
            buffer.write("event");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getEvent())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.actionIn_.size();
        for (int i = 0;i < size;i++) {
            FCActionIn value = (FCActionIn)this.actionIn_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.actionOut_.size();
        for (int i = 0;i < size;i++) {
            FCActionOut value = (FCActionOut)this.actionOut_.get(i);
            value.makeTextElement(buffer);
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
        if (ref_ != null) {
            buffer.print(" ");
            buffer.print("ref");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getRef())));
            buffer.print("\"");
        }
        if (event_ != null) {
            buffer.print(" ");
            buffer.print("event");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getEvent())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.actionIn_.size();
        for (int i = 0;i < size;i++) {
            FCActionIn value = (FCActionIn)this.actionIn_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.actionOut_.size();
        for (int i = 0;i < size;i++) {
            FCActionOut value = (FCActionOut)this.actionOut_.get(i);
            value.makeTextElement(buffer);
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
    public String getRefAsString() {
        return (URelaxer.getString(getRef()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getEventAsString() {
        return (URelaxer.getString(getEvent()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setRefByString(String string) {
        setRef(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setEventByString(String string) {
        setEvent(string);
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
        classNodes.addAll(actionIn_);
        classNodes.addAll(actionOut_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCModelAction</code>.
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
        if (!URelaxer.hasAttributeHungry(target, "ref")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer.hasAttributeHungry(target, "event")) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!FCActionIn.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!FCActionOut.isMatchHungry(target)) {
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
     * is valid for the <code>FCModelAction</code>.
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
     * is valid for the <code>FCModelAction</code>.
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
