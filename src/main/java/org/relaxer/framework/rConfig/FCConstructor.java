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
 * <b>FCConstructor</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="constructor">
 *       <ref name="parameters"/>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="constructor"&gt;
 *       &lt;ref name="parameters"/&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:39 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCConstructor extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    // List<IFCConstructorChoice>
    private java.util.List parameters_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCConstructor</code>.
     *
     */
    public FCConstructor() {
    }

    /**
     * Creates a <code>FCConstructor</code>.
     *
     * @param source
     */
    public FCConstructor(FCConstructor source) {
        setup(source);
    }

    /**
     * Creates a <code>FCConstructor</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCConstructor(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCConstructor</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConstructor(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCConstructor</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConstructor(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCConstructor</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConstructor(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCConstructor</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConstructor(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCConstructor</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConstructor(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCConstructor</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConstructor(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCConstructor</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConstructor(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCConstructor</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCConstructor(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCConstructor</code> by the FCConstructor <code>source</code>.
     *
     * @param source
     */
    public void setup(FCConstructor source) {
        int size;
        this.parameters_.clear();
        size = source.parameters_.size();
        for (int i = 0;i < size;i++) {
            addParameters((IFCConstructorChoice)source.getParameters(i).clone());
        }
    }

    /**
     * Initializes the <code>FCConstructor</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCConstructor</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCConstructor</code> by the Stack <code>stack</code>
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
        parameters_.clear();
        while (true) {
            if (FCParametersValues.isMatch(stack)) {
                addParameters(factory.createFCParametersValues(stack));
            } else if (FCValue.isMatch(stack)) {
                addParameters(factory.createFCValue(stack));
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
        return (factory.createFCConstructor((FCConstructor)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework", "constructor");
        rNSContext_.setupNamespace(element);
        int size;
        size = this.parameters_.size();
        for (int i = 0;i < size;i++) {
            IFCConstructorChoice value = (IFCConstructorChoice)this.parameters_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCConstructor</code> by the File <code>file</code>.
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
     * Initializes the <code>FCConstructor</code>
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
     * Initializes the <code>FCConstructor</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCConstructor</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCConstructor</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCConstructor</code> by the Reader <code>reader</code>.
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
     * Gets the IFCConstructorChoice property <b>parameters</b>.
     *
     * @return IFCConstructorChoice[]
     */
    public IFCConstructorChoice[] getParameters() {
        IFCConstructorChoice[] array = new IFCConstructorChoice[parameters_.size()];
        return ((IFCConstructorChoice[])parameters_.toArray(array));
    }

    /**
     * Sets the IFCConstructorChoice property <b>parameters</b>.
     *
     * @param parameters
     */
    public void setParameters(IFCConstructorChoice[] parameters) {
        this.parameters_.clear();
        for (int i = 0;i < parameters.length;i++) {
            addParameters(parameters[i]);
        }
        for (int i = 0;i < parameters.length;i++) {
            parameters[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the IFCConstructorChoice property <b>parameters</b>.
     *
     * @param parameters
     */
    public void setParameters(IFCConstructorChoice parameters) {
        this.parameters_.clear();
        addParameters(parameters);
        if (parameters != null) {
            parameters.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCConstructorChoice property <b>parameters</b>.
     *
     * @param parameters
     */
    public void addParameters(IFCConstructorChoice parameters) {
        this.parameters_.add(parameters);
        if (parameters != null) {
            parameters.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCConstructorChoice property <b>parameters</b>.
     *
     * @param parameters
     */
    public void addParameters(IFCConstructorChoice[] parameters) {
        for (int i = 0;i < parameters.length;i++) {
            addParameters(parameters[i]);
        }
        for (int i = 0;i < parameters.length;i++) {
            parameters[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the IFCConstructorChoice property <b>parameters</b>.
     *
     * @return int
     */
    public int sizeParameters() {
        return (parameters_.size());
    }

    /**
     * Gets the IFCConstructorChoice property <b>parameters</b> by index.
     *
     * @param index
     * @return IFCConstructorChoice
     */
    public IFCConstructorChoice getParameters(int index) {
        return ((IFCConstructorChoice)parameters_.get(index));
    }

    /**
     * Sets the IFCConstructorChoice property <b>parameters</b> by index.
     *
     * @param index
     * @param parameters
     */
    public void setParameters(int index, IFCConstructorChoice parameters) {
        this.parameters_.set(index, parameters);
        if (parameters != null) {
            parameters.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IFCConstructorChoice property <b>parameters</b> by index.
     *
     * @param index
     * @param parameters
     */
    public void addParameters(int index, IFCConstructorChoice parameters) {
        this.parameters_.add(index, parameters);
        if (parameters != null) {
            parameters.rSetParentRNode(this);
        }
    }

    /**
     * Remove the IFCConstructorChoice property <b>parameters</b> by index.
     *
     * @param index
     */
    public void removeParameters(int index) {
        this.parameters_.remove(index);
    }

    /**
     * Remove the IFCConstructorChoice property <b>parameters</b> by object.
     *
     * @param parameters
     */
    public void removeParameters(IFCConstructorChoice parameters) {
        this.parameters_.remove(parameters);
    }

    /**
     * Clear the IFCConstructorChoice property <b>parameters</b>.
     *
     */
    public void clearParameters() {
        this.parameters_.clear();
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
        URelaxer.makeQName(prefix, "constructor", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.parameters_.size();
        for (int i = 0;i < size;i++) {
            IFCConstructorChoice value = (IFCConstructorChoice)this.parameters_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.parameters_.size();
        for (int i = 0;i < size;i++) {
            IFCConstructorChoice value = (IFCConstructorChoice)this.parameters_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "constructor", buffer);
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
        URelaxer.makeQName(prefix, "constructor", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.parameters_.size();
        for (int i = 0;i < size;i++) {
            IFCConstructorChoice value = (IFCConstructorChoice)this.parameters_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.parameters_.size();
        for (int i = 0;i < size;i++) {
            IFCConstructorChoice value = (IFCConstructorChoice)this.parameters_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "constructor", buffer);
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
        URelaxer.makeQName(prefix, "constructor", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.parameters_.size();
        for (int i = 0;i < size;i++) {
            IFCConstructorChoice value = (IFCConstructorChoice)this.parameters_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.parameters_.size();
        for (int i = 0;i < size;i++) {
            IFCConstructorChoice value = (IFCConstructorChoice)this.parameters_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "constructor", buffer);
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
        classNodes.addAll(parameters_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCConstructor</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework", "constructor")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        IConfigFactory factory = ConfigFactory.getFactory();
        Element child;
        if (FCParametersValues.isMatchHungry(target)) {
            $match$ = true;
        } else if (FCValue.isMatchHungry(target)) {
            $match$ = true;
            while (FCValue.isMatchHungry(target)) {
            }
        } else {
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FCConstructor</code>.
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
     * is valid for the <code>FCConstructor</code>.
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
