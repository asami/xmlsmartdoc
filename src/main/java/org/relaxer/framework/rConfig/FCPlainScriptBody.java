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
 * <b>FCPlainScriptBody</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="plain-script-body">
 *       <ref name="plain-script-body.model"/>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="plain-script-body"&gt;
 *       &lt;ref name="plain-script-body.model"/&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:40 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCPlainScriptBody extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    // List<IFCPlainScriptBodyContentChoice>
    private java.util.List plainScriptBodyContent_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCPlainScriptBody</code>.
     *
     */
    public FCPlainScriptBody() {
    }

    /**
     * Creates a <code>FCPlainScriptBody</code>.
     *
     * @param source
     */
    public FCPlainScriptBody(FCPlainScriptBody source) {
        setup(source);
    }

    /**
     * Creates a <code>FCPlainScriptBody</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCPlainScriptBody(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCPlainScriptBody</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCPlainScriptBody(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCPlainScriptBody</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCPlainScriptBody(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCPlainScriptBody</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCPlainScriptBody(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCPlainScriptBody</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCPlainScriptBody(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCPlainScriptBody</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCPlainScriptBody(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCPlainScriptBody</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCPlainScriptBody(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCPlainScriptBody</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCPlainScriptBody(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCPlainScriptBody</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCPlainScriptBody(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCPlainScriptBody</code> by the FCPlainScriptBody <code>source</code>.
     *
     * @param source
     */
    public void setup(FCPlainScriptBody source) {
        int size;
        this.plainScriptBodyContent_.clear();
        size = source.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            addPlainScriptBodyContent((IFCPlainScriptBodyContentChoice)source.getPlainScriptBodyContent(i).clone());
        }
    }

    /**
     * Initializes the <code>FCPlainScriptBody</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCPlainScriptBody</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCPlainScriptBody</code> by the Stack <code>stack</code>
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
        return (factory.createFCPlainScriptBody((FCPlainScriptBody)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework", "plain-script-body");
        rNSContext_.setupNamespace(element);
        int size;
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCPlainScriptBody</code> by the File <code>file</code>.
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
     * Initializes the <code>FCPlainScriptBody</code>
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
     * Initializes the <code>FCPlainScriptBody</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCPlainScriptBody</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCPlainScriptBody</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCPlainScriptBody</code> by the Reader <code>reader</code>.
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
        URelaxer.makeQName(prefix, "plain-script-body", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "plain-script-body", buffer);
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
        URelaxer.makeQName(prefix, "plain-script-body", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "plain-script-body", buffer);
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
        URelaxer.makeQName(prefix, "plain-script-body", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.plainScriptBodyContent_.size();
        for (int i = 0;i < size;i++) {
            IFCPlainScriptBodyContentChoice value = (IFCPlainScriptBodyContentChoice)this.plainScriptBodyContent_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "plain-script-body", buffer);
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
        classNodes.addAll(plainScriptBodyContent_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCPlainScriptBody</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework", "plain-script-body")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        IConfigFactory factory = ConfigFactory.getFactory();
        Element child;
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
     * is valid for the <code>FCPlainScriptBody</code>.
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
     * is valid for the <code>FCPlainScriptBody</code>.
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
