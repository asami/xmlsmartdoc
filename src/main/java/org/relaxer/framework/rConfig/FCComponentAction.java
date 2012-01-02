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
 * <b>FCComponentAction</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="component">
 *       <attribute name="ref">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="operation">
 *         <data type="token"/>
 *       </attribute>
 *       <zeroOrMore>
 *         <ref name="action-in"/>
 *       </zeroOrMore>
 *       <optional>
 *         <ref name="action-out"/>
 *       </optional>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="component"&gt;
 *       &lt;attribute name="ref"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="operation"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="action-in"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;optional&gt;
 *         &lt;ref name="action-out"/&gt;
 *       &lt;/optional&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:39 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCComponentAction extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode, IFCPlainScriptBodyContentChoice, IFCScenarioScriptContentChoice {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    private String ref_;
    private String operation_;
    // List<FCActionIn>
    private java.util.List actionIn_ = new java.util.ArrayList();
    private FCActionOut actionOut_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCComponentAction</code>.
     *
     */
    public FCComponentAction() {
        ref_ = "";
        operation_ = "";
    }

    /**
     * Creates a <code>FCComponentAction</code>.
     *
     * @param source
     */
    public FCComponentAction(FCComponentAction source) {
        setup(source);
    }

    /**
     * Creates a <code>FCComponentAction</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCComponentAction(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCComponentAction</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponentAction(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCComponentAction</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponentAction(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCComponentAction</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponentAction(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCComponentAction</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponentAction(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCComponentAction</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponentAction(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCComponentAction</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponentAction(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCComponentAction</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponentAction(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCComponentAction</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCComponentAction(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCComponentAction</code> by the FCComponentAction <code>source</code>.
     *
     * @param source
     */
    public void setup(FCComponentAction source) {
        int size;
        ref_ = source.ref_;
        operation_ = source.operation_;
        this.actionIn_.clear();
        size = source.actionIn_.size();
        for (int i = 0;i < size;i++) {
            addActionIn((FCActionIn)source.getActionIn(i).clone());
        }
        if (source.actionOut_ != null) {
            setActionOut((FCActionOut)source.getActionOut().clone());
        }
    }

    /**
     * Initializes the <code>FCComponentAction</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCComponentAction</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCComponentAction</code> by the Stack <code>stack</code>
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
        operation_ = URelaxer.getAttributePropertyAsString(element, "operation");
        actionIn_.clear();
        while (true) {
            if (FCActionIn.isMatch(stack)) {
                addActionIn(factory.createFCActionIn(stack));
            } else {
                break;
            }
        }
        if (FCActionOut.isMatch(stack)) {
            setActionOut(factory.createFCActionOut(stack));
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        IConfigFactory factory = ConfigFactory.getFactory();
        return (factory.createFCComponentAction((FCComponentAction)this));
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
        if (this.ref_ != null) {
            URelaxer.setAttributePropertyByString(element, "ref", this.ref_);
        }
        if (this.operation_ != null) {
            URelaxer.setAttributePropertyByString(element, "operation", this.operation_);
        }
        size = this.actionIn_.size();
        for (int i = 0;i < size;i++) {
            FCActionIn value = (FCActionIn)this.actionIn_.get(i);
            value.makeElement(element);
        }
        if (this.actionOut_ != null) {
            this.actionOut_.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCComponentAction</code> by the File <code>file</code>.
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
     * Initializes the <code>FCComponentAction</code>
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
     * Initializes the <code>FCComponentAction</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCComponentAction</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCComponentAction</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCComponentAction</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>operation</b>.
     *
     * @return String
     */
    public String getOperation() {
        return (operation_);
    }

    /**
     * Sets the String property <b>operation</b>.
     *
     * @param operation
     */
    public void setOperation(String operation) {
        this.operation_ = operation;
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
     * @return FCActionOut
     */
    public FCActionOut getActionOut() {
        return (actionOut_);
    }

    /**
     * Sets the FCActionOut property <b>actionOut</b>.
     *
     * @param actionOut
     */
    public void setActionOut(FCActionOut actionOut) {
        this.actionOut_ = actionOut;
        if (actionOut != null) {
            actionOut.rSetParentRNode(this);
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
        if (ref_ != null) {
            buffer.append(" ");
            buffer.append("ref");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getRef())));
            buffer.append("\"");
        }
        if (operation_ != null) {
            buffer.append(" ");
            buffer.append("operation");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getOperation())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.actionIn_.size();
        for (int i = 0;i < size;i++) {
            FCActionIn value = (FCActionIn)this.actionIn_.get(i);
            value.makeTextElement(buffer);
        }
        if (actionOut_ != null) {
            actionOut_.makeTextElement(buffer);
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
        if (ref_ != null) {
            buffer.write(" ");
            buffer.write("ref");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getRef())));
            buffer.write("\"");
        }
        if (operation_ != null) {
            buffer.write(" ");
            buffer.write("operation");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getOperation())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.actionIn_.size();
        for (int i = 0;i < size;i++) {
            FCActionIn value = (FCActionIn)this.actionIn_.get(i);
            value.makeTextElement(buffer);
        }
        if (actionOut_ != null) {
            actionOut_.makeTextElement(buffer);
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
        if (ref_ != null) {
            buffer.print(" ");
            buffer.print("ref");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getRef())));
            buffer.print("\"");
        }
        if (operation_ != null) {
            buffer.print(" ");
            buffer.print("operation");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getOperation())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.actionIn_.size();
        for (int i = 0;i < size;i++) {
            FCActionIn value = (FCActionIn)this.actionIn_.get(i);
            value.makeTextElement(buffer);
        }
        if (actionOut_ != null) {
            actionOut_.makeTextElement(buffer);
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
    public String getRefAsString() {
        return (URelaxer.getString(getRef()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getOperationAsString() {
        return (URelaxer.getString(getOperation()));
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
    public void setOperationByString(String string) {
        setOperation(string);
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
        if (actionOut_ != null) {
            classNodes.add(actionOut_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCComponentAction</code>.
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
        if (!URelaxer.hasAttributeHungry(target, "ref")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer.hasAttributeHungry(target, "operation")) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!FCActionIn.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (FCActionOut.isMatchHungry(target)) {
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FCComponentAction</code>.
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
     * is valid for the <code>FCComponentAction</code>.
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
