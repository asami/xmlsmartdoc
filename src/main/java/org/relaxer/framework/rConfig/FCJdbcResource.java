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
 * <b>FCJdbcResource</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="jdbc">
 *       <ref name="jdbc.model"/>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="jdbc"&gt;
 *       &lt;ref name="jdbc.model"/&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 10:36:40 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FCJdbcResource extends org.relaxer.framework.rConfig.factory.ConfigNode implements java.io.Serializable, Cloneable, IRNSContainer, IREvaluatable, IRNode, IFCResourceChoice {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework");
    private String url_;
    private String userName_;
    private String password_;
    private String driver_;
    private String classpath_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>FCJdbcResource</code>.
     *
     */
    public FCJdbcResource() {
        url_ = "";
    }

    /**
     * Creates a <code>FCJdbcResource</code>.
     *
     * @param source
     */
    public FCJdbcResource(FCJdbcResource source) {
        setup(source);
    }

    /**
     * Creates a <code>FCJdbcResource</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FCJdbcResource(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FCJdbcResource</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJdbcResource(Document doc) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FCJdbcResource</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJdbcResource(Element element) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(element);
    }

    /**
     * Creates a <code>FCJdbcResource</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJdbcResource(File file) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FCJdbcResource</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJdbcResource(String uri) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FCJdbcResource</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJdbcResource(URL url) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FCJdbcResource</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJdbcResource(InputStream in) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FCJdbcResource</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJdbcResource(InputSource is) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FCJdbcResource</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @exception org.iso_relax.verifier.VerifierConfigurationException
     */
    public FCJdbcResource(Reader reader) throws IOException, SAXException, ParserConfigurationException, org.iso_relax.verifier.VerifierConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FCJdbcResource</code> by the FCJdbcResource <code>source</code>.
     *
     * @param source
     */
    public void setup(FCJdbcResource source) {
        int size;
        url_ = source.url_;
        userName_ = source.userName_;
        password_ = source.password_;
        driver_ = source.driver_;
        classpath_ = source.classpath_;
    }

    /**
     * Initializes the <code>FCJdbcResource</code> by the Document <code>doc</code>.
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
     * Initializes the <code>FCJdbcResource</code> by the Element <code>element</code>.
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
     * Initializes the <code>FCJdbcResource</code> by the Stack <code>stack</code>
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
        url_ = URelaxer.getElementPropertyAsString(stack.popElement());
        userName_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.relaxer.org/xmlns/framework", "userName");
        password_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.relaxer.org/xmlns/framework", "password");
        driver_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.relaxer.org/xmlns/framework", "driver");
        classpath_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.relaxer.org/xmlns/framework", "classpath");
    }

    /**
     * @return Object
     */
    public Object clone() {
        IConfigFactory factory = ConfigFactory.getFactory();
        return (factory.createFCJdbcResource((FCJdbcResource)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework", "jdbc");
        rNSContext_.setupNamespace(element);
        int size;
        URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework", "url", this.url_, rNSContext_);
        if (this.userName_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework", "userName", this.userName_, rNSContext_);
        }
        if (this.password_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework", "password", this.password_, rNSContext_);
        }
        if (this.driver_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework", "driver", this.driver_, rNSContext_);
        }
        if (this.classpath_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework", "classpath", this.classpath_, rNSContext_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FCJdbcResource</code> by the File <code>file</code>.
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
     * Initializes the <code>FCJdbcResource</code>
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
     * Initializes the <code>FCJdbcResource</code> by the URL <code>url</code>.
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
     * Initializes the <code>FCJdbcResource</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FCJdbcResource</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FCJdbcResource</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>url</b>.
     *
     * @return String
     */
    public String getUrl() {
        return (url_);
    }

    /**
     * Sets the String property <b>url</b>.
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url_ = url;
    }

    /**
     * Gets the String property <b>userName</b>.
     *
     * @return String
     */
    public String getUserName() {
        return (userName_);
    }

    /**
     * Sets the String property <b>userName</b>.
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName_ = userName;
    }

    /**
     * Gets the String property <b>password</b>.
     *
     * @return String
     */
    public String getPassword() {
        return (password_);
    }

    /**
     * Sets the String property <b>password</b>.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password_ = password;
    }

    /**
     * Gets the String property <b>driver</b>.
     *
     * @return String
     */
    public String getDriver() {
        return (driver_);
    }

    /**
     * Sets the String property <b>driver</b>.
     *
     * @param driver
     */
    public void setDriver(String driver) {
        this.driver_ = driver;
    }

    /**
     * Gets the String property <b>classpath</b>.
     *
     * @return String
     */
    public String getClasspath() {
        return (classpath_);
    }

    /**
     * Sets the String property <b>classpath</b>.
     *
     * @param classpath
     */
    public void setClasspath(String classpath) {
        this.classpath_ = classpath;
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
        URelaxer.makeQName(prefix, "jdbc", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.append(">");
        buffer.append("<");
        URelaxer.makeQName(prefix, "url", buffer);
        buffer.append(">");
        buffer.append(URelaxer.escapeCharData(URelaxer.getString(getUrl())));
        buffer.append("</");
        URelaxer.makeQName(prefix, "url", buffer);
        buffer.append(">");
        if (userName_ != null) {
            buffer.append("<");
            URelaxer.makeQName(prefix, "userName", buffer);
            buffer.append(">");
            buffer.append(URelaxer.escapeCharData(URelaxer.getString(getUserName())));
            buffer.append("</");
            URelaxer.makeQName(prefix, "userName", buffer);
            buffer.append(">");
        }
        if (password_ != null) {
            buffer.append("<");
            URelaxer.makeQName(prefix, "password", buffer);
            buffer.append(">");
            buffer.append(URelaxer.escapeCharData(URelaxer.getString(getPassword())));
            buffer.append("</");
            URelaxer.makeQName(prefix, "password", buffer);
            buffer.append(">");
        }
        if (driver_ != null) {
            buffer.append("<");
            URelaxer.makeQName(prefix, "driver", buffer);
            buffer.append(">");
            buffer.append(URelaxer.escapeCharData(URelaxer.getString(getDriver())));
            buffer.append("</");
            URelaxer.makeQName(prefix, "driver", buffer);
            buffer.append(">");
        }
        if (classpath_ != null) {
            buffer.append("<");
            URelaxer.makeQName(prefix, "classpath", buffer);
            buffer.append(">");
            buffer.append(URelaxer.escapeCharData(URelaxer.getString(getClasspath())));
            buffer.append("</");
            URelaxer.makeQName(prefix, "classpath", buffer);
            buffer.append(">");
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "jdbc", buffer);
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
        URelaxer.makeQName(prefix, "jdbc", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.write(">");
        buffer.write("<");
        URelaxer.makeQName(prefix, "url", buffer);
        buffer.write(">");
        buffer.write(URelaxer.escapeCharData(URelaxer.getString(getUrl())));
        buffer.write("</");
        URelaxer.makeQName(prefix, "url", buffer);
        buffer.write(">");
        if (userName_ != null) {
            buffer.write("<");
            URelaxer.makeQName(prefix, "userName", buffer);
            buffer.write(">");
            buffer.write(URelaxer.escapeCharData(URelaxer.getString(getUserName())));
            buffer.write("</");
            URelaxer.makeQName(prefix, "userName", buffer);
            buffer.write(">");
        }
        if (password_ != null) {
            buffer.write("<");
            URelaxer.makeQName(prefix, "password", buffer);
            buffer.write(">");
            buffer.write(URelaxer.escapeCharData(URelaxer.getString(getPassword())));
            buffer.write("</");
            URelaxer.makeQName(prefix, "password", buffer);
            buffer.write(">");
        }
        if (driver_ != null) {
            buffer.write("<");
            URelaxer.makeQName(prefix, "driver", buffer);
            buffer.write(">");
            buffer.write(URelaxer.escapeCharData(URelaxer.getString(getDriver())));
            buffer.write("</");
            URelaxer.makeQName(prefix, "driver", buffer);
            buffer.write(">");
        }
        if (classpath_ != null) {
            buffer.write("<");
            URelaxer.makeQName(prefix, "classpath", buffer);
            buffer.write(">");
            buffer.write(URelaxer.escapeCharData(URelaxer.getString(getClasspath())));
            buffer.write("</");
            URelaxer.makeQName(prefix, "classpath", buffer);
            buffer.write(">");
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "jdbc", buffer);
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
        URelaxer.makeQName(prefix, "jdbc", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.print(">");
        buffer.print("<");
        URelaxer.makeQName(prefix, "url", buffer);
        buffer.print(">");
        buffer.print(URelaxer.escapeCharData(URelaxer.getString(getUrl())));
        buffer.print("</");
        URelaxer.makeQName(prefix, "url", buffer);
        buffer.print(">");
        if (userName_ != null) {
            buffer.print("<");
            URelaxer.makeQName(prefix, "userName", buffer);
            buffer.print(">");
            buffer.print(URelaxer.escapeCharData(URelaxer.getString(getUserName())));
            buffer.print("</");
            URelaxer.makeQName(prefix, "userName", buffer);
            buffer.print(">");
        }
        if (password_ != null) {
            buffer.print("<");
            URelaxer.makeQName(prefix, "password", buffer);
            buffer.print(">");
            buffer.print(URelaxer.escapeCharData(URelaxer.getString(getPassword())));
            buffer.print("</");
            URelaxer.makeQName(prefix, "password", buffer);
            buffer.print(">");
        }
        if (driver_ != null) {
            buffer.print("<");
            URelaxer.makeQName(prefix, "driver", buffer);
            buffer.print(">");
            buffer.print(URelaxer.escapeCharData(URelaxer.getString(getDriver())));
            buffer.print("</");
            URelaxer.makeQName(prefix, "driver", buffer);
            buffer.print(">");
        }
        if (classpath_ != null) {
            buffer.print("<");
            URelaxer.makeQName(prefix, "classpath", buffer);
            buffer.print(">");
            buffer.print(URelaxer.escapeCharData(URelaxer.getString(getClasspath())));
            buffer.print("</");
            URelaxer.makeQName(prefix, "classpath", buffer);
            buffer.print(">");
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "jdbc", buffer);
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
    public String getUrlAsString() {
        return (URelaxer.getString(getUrl()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getUserNameAsString() {
        return (URelaxer.getString(getUserName()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getPasswordAsString() {
        return (URelaxer.getString(getPassword()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getDriverAsString() {
        return (URelaxer.getString(getDriver()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getClasspathAsString() {
        return (URelaxer.getString(getClasspath()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setUrlByString(String string) {
        setUrl(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setUserNameByString(String string) {
        setUserName(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setPasswordByString(String string) {
        setPassword(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setDriverByString(String string) {
        setDriver(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setClasspathByString(String string) {
        setClasspath(string);
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
     * for the <code>FCJdbcResource</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework", "jdbc")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        IConfigFactory factory = ConfigFactory.getFactory();
        Element child;
        child = target.popElement();
        if (child == null) {
            return (false);
        }
        if (!URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework", "url")) {
            return (false);
        }
        $match$ = true;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework", "userName")) {
                target.popElement();
            }
        }
        $match$ = true;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework", "password")) {
                target.popElement();
            }
        }
        $match$ = true;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework", "driver")) {
                target.popElement();
            }
        }
        $match$ = true;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework", "classpath")) {
                target.popElement();
            }
        }
        $match$ = true;
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FCJdbcResource</code>.
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
     * is valid for the <code>FCJdbcResource</code>.
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
