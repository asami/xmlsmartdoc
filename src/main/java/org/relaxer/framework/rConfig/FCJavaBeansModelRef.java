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
 * <b>FCJavaBeansModelRef</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="model">
 *       <attribute name="role">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="java.beans">
 *         <data type="token"/>
 *       </attribute>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="model"&gt;
 *       &lt;attribute name="role"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="java.beans"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:40 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCJavaBeansModelRef extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode, IFCModelRefChoice {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    private String role_;
    private String javaBeans_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCJavaBeansModelRef</code>.
     *
     */
    public FCJavaBeansModelRef() {
        role_ = "";
        javaBeans_ = "";
    }

    /**
     * Creates a <code>FCJavaBeansModelRef</code>.
     *
     * @param source
     */
    public FCJavaBeansModelRef(FCJavaBeansModelRef source) {
        setup(source);
    }

    /**
     * Creates a <code>FCJavaBeansModelRef</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCJavaBeansModelRef(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCJavaBeansModelRef</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJavaBeansModelRef(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCJavaBeansModelRef</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJavaBeansModelRef(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCJavaBeansModelRef</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJavaBeansModelRef(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCJavaBeansModelRef</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJavaBeansModelRef(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCJavaBeansModelRef</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJavaBeansModelRef(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCJavaBeansModelRef</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJavaBeansModelRef(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCJavaBeansModelRef</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJavaBeansModelRef(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCJavaBeansModelRef</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJavaBeansModelRef(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCJavaBeansModelRef</code> by the FCJavaBeansModelRef <code>source</code>.
     *
     * @param source
     */
    public void setup(FCJavaBeansModelRef source) {
        int size;
        role_ = source.role_;
        javaBeans_ = source.javaBeans_;
    }

    /**
     * Initializes the <code>FCJavaBeansModelRef</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCJavaBeansModelRef</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCJavaBeansModelRef</code> by the Stack <code>stack</code>
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
        role_ = URelaxer.getAttributePropertyAsString(element, "role");
        javaBeans_ = URelaxer.getAttributePropertyAsString(element, "java.beans");
    }

    /**
     * @return Object
     */
    public Object clone() {
        IConfigFactory factory = ConfigFactory.getFactory();
        return (factory.createFCJavaBeansModelRef((FCJavaBeansModelRef)this));
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
        if (this.role_ != null) {
            URelaxer.setAttributePropertyByString(element, "role", this.role_);
        }
        if (this.javaBeans_ != null) {
            URelaxer.setAttributePropertyByString(element, "java.beans", this.javaBeans_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCJavaBeansModelRef</code> by the File <code>file</code>.
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
     * Initializes the <code>FCJavaBeansModelRef</code>
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
     * Initializes the <code>FCJavaBeansModelRef</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCJavaBeansModelRef</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCJavaBeansModelRef</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCJavaBeansModelRef</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>javaBeans</b>.
     *
     * @return String
     */
    public String getJavaBeans() {
        return (javaBeans_);
    }

    /**
     * Sets the String property <b>javaBeans</b>.
     *
     * @param javaBeans
     */
    public void setJavaBeans(String javaBeans) {
        this.javaBeans_ = javaBeans;
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
        if (role_ != null) {
            buffer.append(" ");
            buffer.append("role");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getRole())));
            buffer.append("\"");
        }
        if (javaBeans_ != null) {
            buffer.append(" ");
            buffer.append("java.beans");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getJavaBeans())));
            buffer.append("\"");
        }
        buffer.append(">");
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
        if (role_ != null) {
            buffer.write(" ");
            buffer.write("role");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getRole())));
            buffer.write("\"");
        }
        if (javaBeans_ != null) {
            buffer.write(" ");
            buffer.write("java.beans");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getJavaBeans())));
            buffer.write("\"");
        }
        buffer.write(">");
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
        if (role_ != null) {
            buffer.print(" ");
            buffer.print("role");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getRole())));
            buffer.print("\"");
        }
        if (javaBeans_ != null) {
            buffer.print(" ");
            buffer.print("java.beans");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getJavaBeans())));
            buffer.print("\"");
        }
        buffer.print(">");
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
    public String getRoleAsString() {
        return (URelaxer.getString(getRole()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getJavaBeansAsString() {
        return (URelaxer.getString(getJavaBeans()));
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
    public void setJavaBeansByString(String string) {
        setJavaBeans(string);
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
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>FCJavaBeansModelRef</code>.
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
        if (!URelaxer.hasAttributeHungry(target, "role")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer.hasAttributeHungry(target, "java.beans")) {
            return (false);
        }
        $match$ = true;
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FCJavaBeansModelRef</code>.
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
     * is valid for the <code>FCJavaBeansModelRef</code>.
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
