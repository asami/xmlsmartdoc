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
 * <b>CConfig</b> is generated from config.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="config">
 *       <oneOrMore>
 *         <ref name="provider"/>
 *       </oneOrMore>
 *       <zeroOrMore>
 *         <ref name="jdbcConfig"/>
 *       </zeroOrMore>
 * 		  <optional>
 * 				<element name="classpath">
 * 				  <data type="token"/>
 * 				</element>
 * 		  </optional>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="config"&gt;
 *       &lt;oneOrMore&gt;
 *         &lt;ref name="provider"/&gt;
 *       &lt;/oneOrMore&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="jdbcConfig"/&gt;
 *       &lt;/zeroOrMore&gt;
 * 		  &lt;optional&gt;
 * 				&lt;element name="classpath"&gt;
 * 				  &lt;data type="token"/&gt;
 * 				&lt;/element&gt;
 * 		  &lt;/optional&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version config.rng (Tue Sep 07 17:31:26 GMT+09:00 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class CConfig implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework/j2ee");
    // List<CProvider>
    private java.util.List provider_ = new java.util.ArrayList();
    // List<CJdbcConfig>
    private java.util.List jdbcConfig_ = new java.util.ArrayList();
    private String classpath_;
    private IRNode parentRNode_;
    private java.util.Map $property$ = new java.util.HashMap();;

    /**
     * Creates a <code>CConfig</code>.
     *
     */
    public CConfig() {
    }

    /**
     * Creates a <code>CConfig</code>.
     *
     * @param source
     */
    public CConfig(CConfig source) {
        setup(source);
    }

    /**
     * Creates a <code>CConfig</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public CConfig(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>CConfig</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public CConfig(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>CConfig</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public CConfig(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>CConfig</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CConfig(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>CConfig</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CConfig(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>CConfig</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CConfig(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>CConfig</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CConfig(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>CConfig</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CConfig(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>CConfig</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public CConfig(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>CConfig</code> by the CConfig <code>source</code>.
     *
     * @param source
     */
    public void setup(CConfig source) {
        int size;
        this.provider_.clear();
        size = source.provider_.size();
        for (int i = 0;i < size;i++) {
            addProvider((CProvider)source.getProvider(i).clone());
        }
        this.jdbcConfig_.clear();
        size = source.jdbcConfig_.size();
        for (int i = 0;i < size;i++) {
            addJdbcConfig((CJdbcConfig)source.getJdbcConfig(i).clone());
        }
        classpath_ = source.classpath_;
    }

    /**
     * Initializes the <code>CConfig</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>CConfig</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>CConfig</code> by the Stack <code>stack</code>
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
        provider_.clear();
        while (true) {
            if (CProvider.isMatch(stack)) {
                addProvider(new CProvider(stack));
            } else {
                break;
            }
        }
        jdbcConfig_.clear();
        while (true) {
            if (CJdbcConfig.isMatch(stack)) {
                addJdbcConfig(new CJdbcConfig(stack));
            } else {
                break;
            }
        }
        classpath_ = URelaxer2.getElementPropertyAsStringByStack(stack, "http://www.relaxer.org/xmlns/framework/j2ee", "classpath");
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new CConfig((CConfig)this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework/j2ee", "config");
        rNSContext_.setupNamespace(element);
        int size;
        size = this.provider_.size();
        for (int i = 0;i < size;i++) {
            CProvider value = (CProvider)this.provider_.get(i);
            value.makeElement(element);
        }
        size = this.jdbcConfig_.size();
        for (int i = 0;i < size;i++) {
            CJdbcConfig value = (CJdbcConfig)this.jdbcConfig_.get(i);
            value.makeElement(element);
        }
        if (this.classpath_ != null) {
            URelaxer2.setElementPropertyByString(element, "http://www.relaxer.org/xmlns/framework/j2ee", "classpath", this.classpath_, rNSContext_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>CConfig</code> by the File <code>file</code>.
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
     * Initializes the <code>CConfig</code>
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
     * Initializes the <code>CConfig</code> by the URL <code>url</code>.
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
     * Initializes the <code>CConfig</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>CConfig</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>CConfig</code> by the Reader <code>reader</code>.
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
     * Gets the CProvider property <b>provider</b>.
     *
     * @return CProvider[]
     */
    public CProvider[] getProvider() {
        CProvider[] array = new CProvider[provider_.size()];
        return ((CProvider[])provider_.toArray(array));
    }

    /**
     * Sets the CProvider property <b>provider</b>.
     *
     * @param provider
     */
    public void setProvider(CProvider[] provider) {
        this.provider_.clear();
        for (int i = 0;i < provider.length;i++) {
            addProvider(provider[i]);
        }
        for (int i = 0;i < provider.length;i++) {
            provider[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the CProvider property <b>provider</b>.
     *
     * @param provider
     */
    public void setProvider(CProvider provider) {
        this.provider_.clear();
        addProvider(provider);
        if (provider != null) {
            provider.rSetParentRNode(this);
        }
    }

    /**
     * Adds the CProvider property <b>provider</b>.
     *
     * @param provider
     */
    public void addProvider(CProvider provider) {
        this.provider_.add(provider);
        if (provider != null) {
            provider.rSetParentRNode(this);
        }
    }

    /**
     * Adds the CProvider property <b>provider</b>.
     *
     * @param provider
     */
    public void addProvider(CProvider[] provider) {
        for (int i = 0;i < provider.length;i++) {
            addProvider(provider[i]);
        }
        for (int i = 0;i < provider.length;i++) {
            provider[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the CProvider property <b>provider</b>.
     *
     * @return int
     */
    public int sizeProvider() {
        return (provider_.size());
    }

    /**
     * Gets the CProvider property <b>provider</b> by index.
     *
     * @param index
     * @return CProvider
     */
    public CProvider getProvider(int index) {
        return ((CProvider)provider_.get(index));
    }

    /**
     * Sets the CProvider property <b>provider</b> by index.
     *
     * @param index
     * @param provider
     */
    public void setProvider(int index, CProvider provider) {
        this.provider_.set(index, provider);
        if (provider != null) {
            provider.rSetParentRNode(this);
        }
    }

    /**
     * Adds the CProvider property <b>provider</b> by index.
     *
     * @param index
     * @param provider
     */
    public void addProvider(int index, CProvider provider) {
        this.provider_.add(index, provider);
        if (provider != null) {
            provider.rSetParentRNode(this);
        }
    }

    /**
     * Remove the CProvider property <b>provider</b> by index.
     *
     * @param index
     */
    public void removeProvider(int index) {
        this.provider_.remove(index);
    }

    /**
     * Remove the CProvider property <b>provider</b> by object.
     *
     * @param provider
     */
    public void removeProvider(CProvider provider) {
        this.provider_.remove(provider);
    }

    /**
     * Clear the CProvider property <b>provider</b>.
     *
     */
    public void clearProvider() {
        this.provider_.clear();
    }

    /**
     * Gets the CJdbcConfig property <b>jdbcConfig</b>.
     *
     * @return CJdbcConfig[]
     */
    public CJdbcConfig[] getJdbcConfig() {
        CJdbcConfig[] array = new CJdbcConfig[jdbcConfig_.size()];
        return ((CJdbcConfig[])jdbcConfig_.toArray(array));
    }

    /**
     * Sets the CJdbcConfig property <b>jdbcConfig</b>.
     *
     * @param jdbcConfig
     */
    public void setJdbcConfig(CJdbcConfig[] jdbcConfig) {
        this.jdbcConfig_.clear();
        for (int i = 0;i < jdbcConfig.length;i++) {
            addJdbcConfig(jdbcConfig[i]);
        }
        for (int i = 0;i < jdbcConfig.length;i++) {
            jdbcConfig[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the CJdbcConfig property <b>jdbcConfig</b>.
     *
     * @param jdbcConfig
     */
    public void setJdbcConfig(CJdbcConfig jdbcConfig) {
        this.jdbcConfig_.clear();
        addJdbcConfig(jdbcConfig);
        if (jdbcConfig != null) {
            jdbcConfig.rSetParentRNode(this);
        }
    }

    /**
     * Adds the CJdbcConfig property <b>jdbcConfig</b>.
     *
     * @param jdbcConfig
     */
    public void addJdbcConfig(CJdbcConfig jdbcConfig) {
        this.jdbcConfig_.add(jdbcConfig);
        if (jdbcConfig != null) {
            jdbcConfig.rSetParentRNode(this);
        }
    }

    /**
     * Adds the CJdbcConfig property <b>jdbcConfig</b>.
     *
     * @param jdbcConfig
     */
    public void addJdbcConfig(CJdbcConfig[] jdbcConfig) {
        for (int i = 0;i < jdbcConfig.length;i++) {
            addJdbcConfig(jdbcConfig[i]);
        }
        for (int i = 0;i < jdbcConfig.length;i++) {
            jdbcConfig[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the CJdbcConfig property <b>jdbcConfig</b>.
     *
     * @return int
     */
    public int sizeJdbcConfig() {
        return (jdbcConfig_.size());
    }

    /**
     * Gets the CJdbcConfig property <b>jdbcConfig</b> by index.
     *
     * @param index
     * @return CJdbcConfig
     */
    public CJdbcConfig getJdbcConfig(int index) {
        return ((CJdbcConfig)jdbcConfig_.get(index));
    }

    /**
     * Sets the CJdbcConfig property <b>jdbcConfig</b> by index.
     *
     * @param index
     * @param jdbcConfig
     */
    public void setJdbcConfig(int index, CJdbcConfig jdbcConfig) {
        this.jdbcConfig_.set(index, jdbcConfig);
        if (jdbcConfig != null) {
            jdbcConfig.rSetParentRNode(this);
        }
    }

    /**
     * Adds the CJdbcConfig property <b>jdbcConfig</b> by index.
     *
     * @param index
     * @param jdbcConfig
     */
    public void addJdbcConfig(int index, CJdbcConfig jdbcConfig) {
        this.jdbcConfig_.add(index, jdbcConfig);
        if (jdbcConfig != null) {
            jdbcConfig.rSetParentRNode(this);
        }
    }

    /**
     * Remove the CJdbcConfig property <b>jdbcConfig</b> by index.
     *
     * @param index
     */
    public void removeJdbcConfig(int index) {
        this.jdbcConfig_.remove(index);
    }

    /**
     * Remove the CJdbcConfig property <b>jdbcConfig</b> by object.
     *
     * @param jdbcConfig
     */
    public void removeJdbcConfig(CJdbcConfig jdbcConfig) {
        this.jdbcConfig_.remove(jdbcConfig);
    }

    /**
     * Clear the CJdbcConfig property <b>jdbcConfig</b>.
     *
     */
    public void clearJdbcConfig() {
        this.jdbcConfig_.clear();
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
        URelaxer.makeQName(prefix, "config", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.append(">");
        size = this.provider_.size();
        for (int i = 0;i < size;i++) {
            CProvider value = (CProvider)this.provider_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.jdbcConfig_.size();
        for (int i = 0;i < size;i++) {
            CJdbcConfig value = (CJdbcConfig)this.jdbcConfig_.get(i);
            value.makeTextElement(buffer);
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
        URelaxer.makeQName(prefix, "config", buffer);
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
        URelaxer.makeQName(prefix, "config", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.write(">");
        size = this.provider_.size();
        for (int i = 0;i < size;i++) {
            CProvider value = (CProvider)this.provider_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.jdbcConfig_.size();
        for (int i = 0;i < size;i++) {
            CJdbcConfig value = (CJdbcConfig)this.jdbcConfig_.get(i);
            value.makeTextElement(buffer);
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
        URelaxer.makeQName(prefix, "config", buffer);
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
        URelaxer.makeQName(prefix, "config", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.print(">");
        size = this.provider_.size();
        for (int i = 0;i < size;i++) {
            CProvider value = (CProvider)this.provider_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.jdbcConfig_.size();
        for (int i = 0;i < size;i++) {
            CJdbcConfig value = (CJdbcConfig)this.jdbcConfig_.get(i);
            value.makeTextElement(buffer);
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
        URelaxer.makeQName(prefix, "config", buffer);
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
    public String getClasspathAsString() {
        return (URelaxer.getString(getClasspath()));
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
        classNodes.addAll(provider_);
        classNodes.addAll(jdbcConfig_);
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
     * for the <code>CConfig</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework/j2ee", "config")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!CProvider.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!CProvider.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!CJdbcConfig.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
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
     * is valid for the <code>CConfig</code>.
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
     * is valid for the <code>CConfig</code>.
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
