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
package org.relaxer.j2eecontainer.jndi.rConfig;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>CDataSource</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="DataSource">
 *       <ref name="nodeAttrs"/>
 *       <element name="url">
 *         <data type="token"/>
 *       </element>
 *       <optional>
 *         <element name="userName">
 *           <data type="token"/>
 *         </element>
 *       </optional>
 *       <optional>
 *         <element name="password">
 *           <data type="token"/>
 *         </element>
 *       </optional>
 *       <optional>
 *         <element name="driver">
 *           <data type="token"/>
 *         </element>
 *       </optional>
 *       <optional>
 *         <element name="classpath">
 *           <data type="token"/>
 *         </element>
 *       </optional>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="DataSource"&gt;
 *       &lt;ref name="nodeAttrs"/&gt;
 *       &lt;element name="url"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/element&gt;
 *       &lt;optional&gt;
 *         &lt;element name="userName"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/element&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;element name="password"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/element&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;element name="driver"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/element&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;element name="classpath"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/element&gt;
 *       &lt;/optional&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 17:31:26 GMT+09:00 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class CDataSource implements java.io.Serializable, Cloneable, IRNSContainer, IRNode, ICChildrenChoice {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework/j2ee");
    private String name_;
    private String url_;
    private String userName_;
    private String password_;
    private String driver_;
    private String classpath_;
    private IRNode parentRNode_;
    private java.util.Map $property$ = new java.util.HashMap();;

    /**
     * Creates a <code>CDataSource</code>.
     *
     */
    public CDataSource() {
        name_ = "";
        url_ = "";
    }

    /**
     * Creates a <code>CDataSource</code>.
     *
     * @param source
     */
    public CDataSource(CDataSource source) {
        setup(source);
    }

    /**
     * Creates a <code>CDataSource</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public CDataSource(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>CDataSource</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public CDataSource(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>CDataSource</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public CDataSource(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>CDataSource</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CDataSource(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>CDataSource</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CDataSource(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>CDataSource</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CDataSource(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>CDataSource</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CDataSource(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>CDataSource</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CDataSource(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>CDataSource</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CDataSource(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>CDataSource</code> by the CDataSource <code>source</code>.
     *
     * @param source
     */
    public void setup(CDataSource source) {
        int size;
        name_ = source.name_;
        url_ = source.url_;
        userName_ = source.userName_;
        password_ = source.password_;
        driver_ = source.driver_;
        classpath_ = source.classpath_;
    }

    /**
     * Initializes the <code>CDataSource</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>CDataSource</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>CDataSource</code> by the Stack <code>stack</code>
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
        RStack stack = new RStack(element);
        rNSContext_.declareNamespace(element);
        name_ = URelaxer.getAttributePropertyAsString(element, "name");
        url_ = URelaxer.getElementPropertyAsString(stack.popElement());
        userName_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.relaxer.org/xmlns/framework/j2ee", "userName");
        password_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.relaxer.org/xmlns/framework/j2ee", "password");
        driver_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.relaxer.org/xmlns/framework/j2ee", "driver");
        classpath_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.relaxer.org/xmlns/framework/j2ee", "classpath");
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new CDataSource((CDataSource)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework/j2ee", "DataSource");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.name_ != null) {
            URelaxer.setAttributePropertyByString(element, "name", this.name_);
        }
        URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework/j2ee", "url", this.url_, rNSContext_);
        if (this.userName_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework/j2ee", "userName", this.userName_, rNSContext_);
        }
        if (this.password_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework/j2ee", "password", this.password_, rNSContext_);
        }
        if (this.driver_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework/j2ee", "driver", this.driver_, rNSContext_);
        }
        if (this.classpath_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework/j2ee", "classpath", this.classpath_, rNSContext_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>CDataSource</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file.toURL());
    }

    /**
     * Initializes the <code>CDataSource</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(uri, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>CDataSource</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(url, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>CDataSource</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(in, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>CDataSource</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(is, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>CDataSource</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(Reader reader) throws IOException, SAXException, ParserConfigurationException {
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
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/j2ee");
        buffer.append("<");
        URelaxer.makeQName(prefix, "DataSource", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("", "name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
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
        URelaxer.makeQName(prefix, "DataSource", buffer);
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
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/j2ee");
        buffer.write("<");
        URelaxer.makeQName(prefix, "DataSource", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("", "name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
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
        URelaxer.makeQName(prefix, "DataSource", buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/j2ee");
        buffer.print("<");
        URelaxer.makeQName(prefix, "DataSource", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("", "name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
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
        URelaxer.makeQName(prefix, "DataSource", buffer);
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
    public void setNameByString(String string) {
        setName(string);
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
     * Gets a value of property by the key.
     *
     * @param key
     * @return Object
     */
    public Object rGetProperty(Object key) {
        return ($property$.get(key));
    }

    /**
     * Sets a value of property by the key.
     *
     * @param key
     * @param value
     * @return Object
     */
    public Object rSetProperty(Object key, Object value) {
        return ($property$.put(key, value));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>CDataSource</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework/j2ee", "DataSource")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "name")) {
            return (false);
        }
        $match$ = true;
        child = target.popElement();
        if (child == null) {
            return (false);
        }
        if (!URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework/j2ee", "url")) {
            return (false);
        }
        $match$ = true;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework/j2ee", "userName")) {
                target.popElement();
            }
        }
        $match$ = true;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework/j2ee", "password")) {
                target.popElement();
            }
        }
        $match$ = true;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework/j2ee", "driver")) {
                target.popElement();
            }
        }
        $match$ = true;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework/j2ee", "classpath")) {
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
     * is valid for the <code>CDataSource</code>.
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
     * is valid for the <code>CDataSource</code>.
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
