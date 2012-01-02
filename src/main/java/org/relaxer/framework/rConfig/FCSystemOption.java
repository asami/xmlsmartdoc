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
 * <b>FCSystemOption</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="option">
 *       <attribute java:mapKey="true" name="name">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="system">
 *         <data type="token"/>
 *       </attribute>
 *       <ref name="helps"/>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="option"&gt;
 *       &lt;attribute java:mapKey="true" name="name"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="system"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;ref name="helps"/&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:39 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCSystemOption extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode, IFCOptionsChoice, IFCOptionSetChoice {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    private String name_;
    private String system_;
    // List<FCHelp>
    private java.util.List help_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCSystemOption</code>.
     *
     */
    public FCSystemOption() {
        name_ = "";
        system_ = "";
    }

    /**
     * Creates a <code>FCSystemOption</code>.
     *
     * @param source
     */
    public FCSystemOption(FCSystemOption source) {
        setup(source);
    }

    /**
     * Creates a <code>FCSystemOption</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCSystemOption(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCSystemOption</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCSystemOption(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCSystemOption</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCSystemOption(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCSystemOption</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCSystemOption(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCSystemOption</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCSystemOption(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCSystemOption</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCSystemOption(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCSystemOption</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCSystemOption(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCSystemOption</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCSystemOption(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCSystemOption</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCSystemOption(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCSystemOption</code> by the FCSystemOption <code>source</code>.
     *
     * @param source
     */
    public void setup(FCSystemOption source) {
        int size;
        name_ = source.name_;
        system_ = source.system_;
        this.help_.clear();
        size = source.help_.size();
        for (int i = 0;i < size;i++) {
            addHelp((FCHelp)source.getHelp(i).clone());
        }
    }

    /**
     * Initializes the <code>FCSystemOption</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCSystemOption</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCSystemOption</code> by the Stack <code>stack</code>
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
        system_ = URelaxer.getAttributePropertyAsString(element, "system");
        help_.clear();
        while (true) {
            if (FCHelp.isMatch(stack)) {
                addHelp(factory.createFCHelp(stack));
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
        return (factory.createFCSystemOption((FCSystemOption)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework", "option");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.name_ != null) {
            URelaxer.setAttributePropertyByString(element, "name", this.name_);
        }
        if (this.system_ != null) {
            URelaxer.setAttributePropertyByString(element, "system", this.system_);
        }
        size = this.help_.size();
        for (int i = 0;i < size;i++) {
            FCHelp value = (FCHelp)this.help_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCSystemOption</code> by the File <code>file</code>.
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
     * Initializes the <code>FCSystemOption</code>
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
     * Initializes the <code>FCSystemOption</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCSystemOption</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCSystemOption</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCSystemOption</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>system</b>.
     *
     * @return String
     */
    public String getSystem() {
        return (system_);
    }

    /**
     * Sets the String property <b>system</b>.
     *
     * @param system
     */
    public void setSystem(String system) {
        this.system_ = system;
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
        URelaxer.makeQName(prefix, "option", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.append(" ");
            buffer.append("name");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
        if (system_ != null) {
            buffer.append(" ");
            buffer.append("system");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getSystem())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.help_.size();
        for (int i = 0;i < size;i++) {
            FCHelp value = (FCHelp)this.help_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "option", buffer);
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
        URelaxer.makeQName(prefix, "option", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.write(" ");
            buffer.write("name");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
        if (system_ != null) {
            buffer.write(" ");
            buffer.write("system");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getSystem())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.help_.size();
        for (int i = 0;i < size;i++) {
            FCHelp value = (FCHelp)this.help_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "option", buffer);
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
        URelaxer.makeQName(prefix, "option", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.print(" ");
            buffer.print("name");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
        if (system_ != null) {
            buffer.print(" ");
            buffer.print("system");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getSystem())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.help_.size();
        for (int i = 0;i < size;i++) {
            FCHelp value = (FCHelp)this.help_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "option", buffer);
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
    public String getSystemAsString() {
        return (URelaxer.getString(getSystem()));
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
    public void setSystemByString(String string) {
        setSystem(string);
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
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCSystemOption</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework", "option")) {
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
        if (!URelaxer.hasAttributeHungry(target, "system")) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!FCHelp.isMatchHungry(target)) {
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
     * is valid for the <code>FCSystemOption</code>.
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
     * is valid for the <code>FCSystemOption</code>.
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
