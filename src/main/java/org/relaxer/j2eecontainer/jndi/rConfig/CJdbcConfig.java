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
 * <b>CJdbcConfig</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="jdbc">
 * 		  <element name="driver">
 *    		  <data type="token"/>
 *       </element>
 *       <optional>
 *  	      <element name="classpath">
 *    	      <data type="token"/>
 *         </element>
 *       </optional>
 * 		</element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="jdbc"&gt;
 * 		  &lt;element name="driver"&gt;
 *    		  &lt;data type="token"/&gt;
 *       &lt;/element&gt;
 *       &lt;optional&gt;
 *  	      &lt;element name="classpath"&gt;
 *    	      &lt;data type="token"/&gt;
 *         &lt;/element&gt;
 *       &lt;/optional&gt;
 * 		&lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 17:31:27 GMT+09:00 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class CJdbcConfig implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework/j2ee");
    private String driver_;
    private String classpath_;
    private IRNode parentRNode_;
    private java.util.Map $property$ = new java.util.HashMap();;

    /**
     * Creates a <code>CJdbcConfig</code>.
     *
     */
    public CJdbcConfig() {
        driver_ = "";
    }

    /**
     * Creates a <code>CJdbcConfig</code>.
     *
     * @param source
     */
    public CJdbcConfig(CJdbcConfig source) {
        setup(source);
    }

    /**
     * Creates a <code>CJdbcConfig</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public CJdbcConfig(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>CJdbcConfig</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public CJdbcConfig(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>CJdbcConfig</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public CJdbcConfig(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>CJdbcConfig</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CJdbcConfig(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>CJdbcConfig</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CJdbcConfig(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>CJdbcConfig</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CJdbcConfig(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>CJdbcConfig</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CJdbcConfig(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>CJdbcConfig</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CJdbcConfig(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>CJdbcConfig</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CJdbcConfig(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>CJdbcConfig</code> by the CJdbcConfig <code>source</code>.
     *
     * @param source
     */
    public void setup(CJdbcConfig source) {
        int size;
        driver_ = source.driver_;
        classpath_ = source.classpath_;
    }

    /**
     * Initializes the <code>CJdbcConfig</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>CJdbcConfig</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>CJdbcConfig</code> by the Stack <code>stack</code>
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
        driver_ = URelaxer.getElementPropertyAsString(stack.popElement());
        classpath_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.relaxer.org/xmlns/framework/j2ee", "classpath");
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new CJdbcConfig((CJdbcConfig)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework/j2ee", "jdbc");
        rNSContext_.setupNamespace(element);
        int size;
        URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework/j2ee", "driver", this.driver_, rNSContext_);
        if (this.classpath_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework/j2ee", "classpath", this.classpath_, rNSContext_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>CJdbcConfig</code> by the File <code>file</code>.
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
     * Initializes the <code>CJdbcConfig</code>
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
     * Initializes the <code>CJdbcConfig</code> by the URL <code>url</code>.
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
     * Initializes the <code>CJdbcConfig</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>CJdbcConfig</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>CJdbcConfig</code> by the Reader <code>reader</code>.
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
        URelaxer.makeQName(prefix, "jdbc", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.append(">");
        buffer.append("<");
        URelaxer.makeQName(prefix, "driver", buffer);
        buffer.append(">");
        buffer.append(URelaxer.escapeCharData(URelaxer.getString(getDriver())));
        buffer.append("</");
        URelaxer.makeQName(prefix, "driver", buffer);
        buffer.append(">");
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
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/j2ee");
        buffer.write("<");
        URelaxer.makeQName(prefix, "jdbc", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.write(">");
        buffer.write("<");
        URelaxer.makeQName(prefix, "driver", buffer);
        buffer.write(">");
        buffer.write(URelaxer.escapeCharData(URelaxer.getString(getDriver())));
        buffer.write("</");
        URelaxer.makeQName(prefix, "driver", buffer);
        buffer.write(">");
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
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/j2ee");
        buffer.print("<");
        URelaxer.makeQName(prefix, "jdbc", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.print(">");
        buffer.print("<");
        URelaxer.makeQName(prefix, "driver", buffer);
        buffer.print(">");
        buffer.print(URelaxer.escapeCharData(URelaxer.getString(getDriver())));
        buffer.print("</");
        URelaxer.makeQName(prefix, "driver", buffer);
        buffer.print(">");
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
     * for the <code>CJdbcConfig</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework/j2ee", "jdbc")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        child = target.popElement();
        if (child == null) {
            return (false);
        }
        if (!URelaxer2.isTargetElement(child, "http://www.relaxer.org/xmlns/framework/j2ee", "driver")) {
            return (false);
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
     * is valid for the <code>CJdbcConfig</code>.
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
     * is valid for the <code>CJdbcConfig</code>.
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
