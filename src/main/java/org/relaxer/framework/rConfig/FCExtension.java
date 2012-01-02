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
 * <b>FCExtension</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="extension">
 *       <zeroOrMore>
 *         <ref name="provider"/>
 *       </zeroOrMore>
 *       <zeroOrMore>
 *         <ref name="variable"/>
 *       </zeroOrMore>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="extension"&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="provider"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="variable"/&gt;
 *       &lt;/zeroOrMore&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:39 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCExtension extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    // List<FCProvider>
    private java.util.List provider_ = new java.util.ArrayList();
    // List<FCVariable>
    private java.util.List variable_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCExtension</code>.
     *
     */
    public FCExtension() {
    }

    /**
     * Creates a <code>FCExtension</code>.
     *
     * @param source
     */
    public FCExtension(FCExtension source) {
        setup(source);
    }

    /**
     * Creates a <code>FCExtension</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCExtension(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCExtension</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCExtension(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCExtension</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCExtension(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCExtension</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCExtension(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCExtension</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCExtension(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCExtension</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCExtension(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCExtension</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCExtension(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCExtension</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCExtension(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCExtension</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCExtension(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCExtension</code> by the FCExtension <code>source</code>.
     *
     * @param source
     */
    public void setup(FCExtension source) {
        int size;
        this.provider_.clear();
        size = source.provider_.size();
        for (int i = 0;i < size;i++) {
            addProvider((FCProvider)source.getProvider(i).clone());
        }
        this.variable_.clear();
        size = source.variable_.size();
        for (int i = 0;i < size;i++) {
            addVariable((FCVariable)source.getVariable(i).clone());
        }
    }

    /**
     * Initializes the <code>FCExtension</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCExtension</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCExtension</code> by the Stack <code>stack</code>
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
        provider_.clear();
        while (true) {
            if (FCProvider.isMatch(stack)) {
                addProvider(factory.createFCProvider(stack));
            } else {
                break;
            }
        }
        variable_.clear();
        while (true) {
            if (FCVariable.isMatch(stack)) {
                addVariable(factory.createFCVariable(stack));
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
        return (factory.createFCExtension((FCExtension)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework", "extension");
        rNSContext_.setupNamespace(element);
        int size;
        size = this.provider_.size();
        for (int i = 0;i < size;i++) {
            FCProvider value = (FCProvider)this.provider_.get(i);
            value.makeElement(element);
        }
        size = this.variable_.size();
        for (int i = 0;i < size;i++) {
            FCVariable value = (FCVariable)this.variable_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCExtension</code> by the File <code>file</code>.
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
     * Initializes the <code>FCExtension</code>
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
     * Initializes the <code>FCExtension</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCExtension</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCExtension</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCExtension</code> by the Reader <code>reader</code>.
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
     * Gets the FCProvider property <b>provider</b>.
     *
     * @return FCProvider[]
     */
    public FCProvider[] getProvider() {
        FCProvider[] array = new FCProvider[provider_.size()];
        return ((FCProvider[])provider_.toArray(array));
    }

    /**
     * Sets the FCProvider property <b>provider</b>.
     *
     * @param provider
     */
    public void setProvider(FCProvider[] provider) {
        this.provider_.clear();
        for (int i = 0;i < provider.length;i++) {
            addProvider(provider[i]);
        }
        for (int i = 0;i < provider.length;i++) {
            provider[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCProvider property <b>provider</b>.
     *
     * @param provider
     */
    public void setProvider(FCProvider provider) {
        this.provider_.clear();
        addProvider(provider);
        if (provider != null) {
            provider.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCProvider property <b>provider</b>.
     *
     * @param provider
     */
    public void addProvider(FCProvider provider) {
        this.provider_.add(provider);
        if (provider != null) {
            provider.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCProvider property <b>provider</b>.
     *
     * @param provider
     */
    public void addProvider(FCProvider[] provider) {
        for (int i = 0;i < provider.length;i++) {
            addProvider(provider[i]);
        }
        for (int i = 0;i < provider.length;i++) {
            provider[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCProvider property <b>provider</b>.
     *
     * @return int
     */
    public int sizeProvider() {
        return (provider_.size());
    }

    /**
     * Gets the FCProvider property <b>provider</b> by index.
     *
     * @param index
     * @return FCProvider
     */
    public FCProvider getProvider(int index) {
        return ((FCProvider)provider_.get(index));
    }

    /**
     * Sets the FCProvider property <b>provider</b> by index.
     *
     * @param index
     * @param provider
     */
    public void setProvider(int index, FCProvider provider) {
        this.provider_.set(index, provider);
        if (provider != null) {
            provider.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCProvider property <b>provider</b> by index.
     *
     * @param index
     * @param provider
     */
    public void addProvider(int index, FCProvider provider) {
        this.provider_.add(index, provider);
        if (provider != null) {
            provider.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCProvider property <b>provider</b> by index.
     *
     * @param index
     */
    public void removeProvider(int index) {
        this.provider_.remove(index);
    }

    /**
     * Remove the FCProvider property <b>provider</b> by object.
     *
     * @param provider
     */
    public void removeProvider(FCProvider provider) {
        this.provider_.remove(provider);
    }

    /**
     * Clear the FCProvider property <b>provider</b>.
     *
     */
    public void clearProvider() {
        this.provider_.clear();
    }

    /**
     * Gets the FCVariable property <b>variable</b>.
     *
     * @return FCVariable[]
     */
    public FCVariable[] getVariable() {
        FCVariable[] array = new FCVariable[variable_.size()];
        return ((FCVariable[])variable_.toArray(array));
    }

    /**
     * Sets the FCVariable property <b>variable</b>.
     *
     * @param variable
     */
    public void setVariable(FCVariable[] variable) {
        this.variable_.clear();
        for (int i = 0;i < variable.length;i++) {
            addVariable(variable[i]);
        }
        for (int i = 0;i < variable.length;i++) {
            variable[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the FCVariable property <b>variable</b>.
     *
     * @param variable
     */
    public void setVariable(FCVariable variable) {
        this.variable_.clear();
        addVariable(variable);
        if (variable != null) {
            variable.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCVariable property <b>variable</b>.
     *
     * @param variable
     */
    public void addVariable(FCVariable variable) {
        this.variable_.add(variable);
        if (variable != null) {
            variable.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCVariable property <b>variable</b>.
     *
     * @param variable
     */
    public void addVariable(FCVariable[] variable) {
        for (int i = 0;i < variable.length;i++) {
            addVariable(variable[i]);
        }
        for (int i = 0;i < variable.length;i++) {
            variable[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the FCVariable property <b>variable</b>.
     *
     * @return int
     */
    public int sizeVariable() {
        return (variable_.size());
    }

    /**
     * Gets the FCVariable property <b>variable</b> by index.
     *
     * @param index
     * @return FCVariable
     */
    public FCVariable getVariable(int index) {
        return ((FCVariable)variable_.get(index));
    }

    /**
     * Sets the FCVariable property <b>variable</b> by index.
     *
     * @param index
     * @param variable
     */
    public void setVariable(int index, FCVariable variable) {
        this.variable_.set(index, variable);
        if (variable != null) {
            variable.rSetParentRNode(this);
        }
    }

    /**
     * Adds the FCVariable property <b>variable</b> by index.
     *
     * @param index
     * @param variable
     */
    public void addVariable(int index, FCVariable variable) {
        this.variable_.add(index, variable);
        if (variable != null) {
            variable.rSetParentRNode(this);
        }
    }

    /**
     * Remove the FCVariable property <b>variable</b> by index.
     *
     * @param index
     */
    public void removeVariable(int index) {
        this.variable_.remove(index);
    }

    /**
     * Remove the FCVariable property <b>variable</b> by object.
     *
     * @param variable
     */
    public void removeVariable(FCVariable variable) {
        this.variable_.remove(variable);
    }

    /**
     * Clear the FCVariable property <b>variable</b>.
     *
     */
    public void clearVariable() {
        this.variable_.clear();
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
        URelaxer.makeQName(prefix, "extension", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.append(">");
        size = this.provider_.size();
        for (int i = 0;i < size;i++) {
            FCProvider value = (FCProvider)this.provider_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.variable_.size();
        for (int i = 0;i < size;i++) {
            FCVariable value = (FCVariable)this.variable_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "extension", buffer);
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
        URelaxer.makeQName(prefix, "extension", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.write(">");
        size = this.provider_.size();
        for (int i = 0;i < size;i++) {
            FCProvider value = (FCProvider)this.provider_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.variable_.size();
        for (int i = 0;i < size;i++) {
            FCVariable value = (FCVariable)this.variable_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "extension", buffer);
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
        URelaxer.makeQName(prefix, "extension", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.print(">");
        size = this.provider_.size();
        for (int i = 0;i < size;i++) {
            FCProvider value = (FCProvider)this.provider_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.variable_.size();
        for (int i = 0;i < size;i++) {
            FCVariable value = (FCVariable)this.variable_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "extension", buffer);
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
        classNodes.addAll(provider_);
        classNodes.addAll(variable_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCExtension</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework", "extension")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        IConfigFactory factory = ConfigFactory.getFactory();
        Element child;
        while (true) {
            if (!FCProvider.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!FCVariable.isMatchHungry(target)) {
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
     * is valid for the <code>FCExtension</code>.
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
     * is valid for the <code>FCExtension</code>.
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
