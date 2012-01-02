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
package org.relaxer.framework.jdbc.rModel;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>JmJdbcModel</b> is generated from rModel.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 *   </attribute>
 *   </element>
 *   </element>
 *   </element>
 *   </zeroOrMore>
 *   </zeroOrMore>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre>   &lt;/attribute&gt;
 *   &lt;/element&gt;
 *   &lt;/element&gt;
 *   &lt;/element&gt;
 *   &lt;/zeroOrMore&gt;
 *   &lt;/zeroOrMore&gt;
 * &lt;/element&gt;
 * </pre>
 *
 * @version rModel.rng (Wed Mar 10 10:25:12 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class JmJdbcModel implements java.io.Serializable, Cloneable {
    private String databaseType_;
    private String quoteId_;
    private String quoteWhere_;
    private String quoteIdInWhere_;
    // List<JmXmlDatatype>
    private java.util.List xmlDatatype_ = new java.util.ArrayList();
    private java.util.Map xmlDatatype_$map = new java.util.HashMap();
    // List<JmJavaDatatype>
    private java.util.List javaDatatype_ = new java.util.ArrayList();

    /**
     * Creates a <code>JmJdbcModel</code>.
     *
     */
    public JmJdbcModel() {
        databaseType_ = "";
        quoteId_ = "";
        quoteWhere_ = "";
        quoteIdInWhere_ = "";
    }

    /**
     * Creates a <code>JmJdbcModel</code>.
     *
     * @param source
     */
    public JmJdbcModel(JmJdbcModel source) {
        setup(source);
    }

    /**
     * Creates a <code>JmJdbcModel</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public JmJdbcModel(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>JmJdbcModel</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public JmJdbcModel(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>JmJdbcModel</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public JmJdbcModel(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>JmJdbcModel</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public JmJdbcModel(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>JmJdbcModel</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public JmJdbcModel(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>JmJdbcModel</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public JmJdbcModel(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>JmJdbcModel</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public JmJdbcModel(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>JmJdbcModel</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public JmJdbcModel(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>JmJdbcModel</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public JmJdbcModel(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>JmJdbcModel</code> by the JmJdbcModel <code>source</code>.
     *
     * @param source
     */
    public void setup(JmJdbcModel source) {
        int size;
        setDatabaseType(source.getDatabaseType());
        setQuoteId(source.getQuoteId());
        setQuoteWhere(source.getQuoteWhere());
        setQuoteIdInWhere(source.getQuoteIdInWhere());
        this.xmlDatatype_.clear();
        size = source.xmlDatatype_.size();
        for (int i = 0;i < size;i++) {
            addXmlDatatype((JmXmlDatatype)source.getXmlDatatype(i).clone());
        }
        this.javaDatatype_.clear();
        size = source.javaDatatype_.size();
        for (int i = 0;i < size;i++) {
            addJavaDatatype((JmJavaDatatype)source.getJavaDatatype(i).clone());
        }
    }

    /**
     * Initializes the <code>JmJdbcModel</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>JmJdbcModel</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>JmJdbcModel</code> by the Stack <code>stack</code>
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
        databaseType_ = URelaxer.getAttributePropertyAsString(element, "database-type");
        quoteId_ = URelaxer.getElementPropertyAsString(stack.popElement());
        quoteWhere_ = URelaxer.getElementPropertyAsString(stack.popElement());
        quoteIdInWhere_ = URelaxer.getElementPropertyAsString(stack.popElement());
        xmlDatatype_.clear();
        while (true) {
            if (JmXmlDatatype.isMatch(stack)) {
                addXmlDatatype(new JmXmlDatatype(stack));
            } else {
                break;
            }
        }
        javaDatatype_.clear();
        while (true) {
            if (JmJavaDatatype.isMatch(stack)) {
                addJavaDatatype(new JmJavaDatatype(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new JmJdbcModel(this));
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
        Element element = doc.createElement("jdbc-model");
        int size;
        if (this.databaseType_ != null) {
            URelaxer.setAttributePropertyByString(element, "database-type", this.databaseType_);
        }
        URelaxer.setElementPropertyByString(element, "quote-id", this.quoteId_);
        URelaxer.setElementPropertyByString(element, "quote-where", this.quoteWhere_);
        URelaxer.setElementPropertyByString(element, "quote-id-in-where", this.quoteIdInWhere_);
        size = this.xmlDatatype_.size();
        for (int i = 0;i < size;i++) {
            JmXmlDatatype value = (JmXmlDatatype)this.xmlDatatype_.get(i);
            value.makeElement(element);
        }
        size = this.javaDatatype_.size();
        for (int i = 0;i < size;i++) {
            JmJavaDatatype value = (JmJavaDatatype)this.javaDatatype_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>JmJdbcModel</code> by the File <code>file</code>.
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
     * Initializes the <code>JmJdbcModel</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(uri, UJAXP.FLAG_NONE));
    }

    /**
     * Initializes the <code>JmJdbcModel</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(url, UJAXP.FLAG_NONE));
    }

    /**
     * Initializes the <code>JmJdbcModel</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(in, UJAXP.FLAG_NONE));
    }

    /**
     * Initializes the <code>JmJdbcModel</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(is, UJAXP.FLAG_NONE));
    }

    /**
     * Initializes the <code>JmJdbcModel</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(reader, UJAXP.FLAG_NONE));
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
     * Gets the String property <b>databaseType</b>.
     *
     * @return String
     */
    public final String getDatabaseType() {
        return (databaseType_);
    }

    /**
     * Sets the String property <b>databaseType</b>.
     *
     * @param databaseType
     */
    public final void setDatabaseType(String databaseType) {
        this.databaseType_ = databaseType;
    }

    /**
     * Gets the String property <b>quoteId</b>.
     *
     * @return String
     */
    public final String getQuoteId() {
        return (quoteId_);
    }

    /**
     * Sets the String property <b>quoteId</b>.
     *
     * @param quoteId
     */
    public final void setQuoteId(String quoteId) {
        this.quoteId_ = quoteId;
    }

    /**
     * Gets the String property <b>quoteWhere</b>.
     *
     * @return String
     */
    public final String getQuoteWhere() {
        return (quoteWhere_);
    }

    /**
     * Sets the String property <b>quoteWhere</b>.
     *
     * @param quoteWhere
     */
    public final void setQuoteWhere(String quoteWhere) {
        this.quoteWhere_ = quoteWhere;
    }

    /**
     * Gets the String property <b>quoteIdInWhere</b>.
     *
     * @return String
     */
    public final String getQuoteIdInWhere() {
        return (quoteIdInWhere_);
    }

    /**
     * Sets the String property <b>quoteIdInWhere</b>.
     *
     * @param quoteIdInWhere
     */
    public final void setQuoteIdInWhere(String quoteIdInWhere) {
        this.quoteIdInWhere_ = quoteIdInWhere;
    }

    /**
     * Gets the JmXmlDatatype property <b>xmlDatatype</b>.
     *
     * @return JmXmlDatatype[]
     */
    public final JmXmlDatatype[] getXmlDatatype() {
        JmXmlDatatype[] array = new JmXmlDatatype[xmlDatatype_.size()];
        return ((JmXmlDatatype[])xmlDatatype_.toArray(array));
    }

    /**
     * Sets the JmXmlDatatype property <b>xmlDatatype</b>.
     *
     * @param xmlDatatype
     */
    public final void setXmlDatatype(JmXmlDatatype[] xmlDatatype) {
        this.xmlDatatype_.clear();
        for (int i = 0;i < xmlDatatype.length;i++) {
            addXmlDatatype(xmlDatatype[i]);
        }
    }

    /**
     * Sets the JmXmlDatatype property <b>xmlDatatype</b>.
     *
     * @param xmlDatatype
     */
    public final void setXmlDatatype(JmXmlDatatype xmlDatatype) {
        this.xmlDatatype_.clear();
        addXmlDatatype(xmlDatatype);
    }

    /**
     * Adds the JmXmlDatatype property <b>xmlDatatype</b>.
     *
     * @param xmlDatatype
     */
    public final void addXmlDatatype(JmXmlDatatype xmlDatatype) {
        Object $key$ = xmlDatatype.getName();
        if ($key$ != null) {
            Object $value$ = this.xmlDatatype_$map.get($key$);
            if ($value$ != null) {
                this.xmlDatatype_.remove($value$);
        }
            this.xmlDatatype_$map.put($key$, xmlDatatype);
        }
        this.xmlDatatype_.add(xmlDatatype);
    }

    /**
     * Adds the JmXmlDatatype property <b>xmlDatatype</b>.
     *
     * @param xmlDatatype
     */
    public final void addXmlDatatype(JmXmlDatatype[] xmlDatatype) {
        for (int i = 0;i < xmlDatatype.length;i++) {
            addXmlDatatype(xmlDatatype[i]);
        }
    }

    /**
     * Gets number of the JmXmlDatatype property <b>xmlDatatype</b>.
     *
     * @return int
     */
    public final int sizeXmlDatatype() {
        return (xmlDatatype_.size());
    }

    /**
     * Gets the JmXmlDatatype property <b>xmlDatatype</b> by index.
     *
     * @param index
     * @return JmXmlDatatype
     */
    public final JmXmlDatatype getXmlDatatype(int index) {
        return ((JmXmlDatatype)xmlDatatype_.get(index));
    }

    /**
     * Sets the JmXmlDatatype property <b>xmlDatatype</b> by index.
     *
     * @param index
     * @param xmlDatatype
     */
    public final void setXmlDatatype(int index, JmXmlDatatype xmlDatatype) {
        Object $key$ = xmlDatatype.getName();
        if ($key$ != null) {
            Object $value$ = this.xmlDatatype_$map.get($key$);
            if ($value$ != null) {
                this.xmlDatatype_.remove($value$);
        }
            this.xmlDatatype_$map.put($key$, xmlDatatype);
        }
        this.xmlDatatype_.set(index, xmlDatatype);
    }

    /**
     * Adds the JmXmlDatatype property <b>xmlDatatype</b> by index.
     *
     * @param index
     * @param xmlDatatype
     */
    public final void addXmlDatatype(int index, JmXmlDatatype xmlDatatype) {
        Object $key$ = xmlDatatype.getName();
        if ($key$ != null) {
            Object $value$ = this.xmlDatatype_$map.get($key$);
            if ($value$ != null) {
                this.xmlDatatype_.remove($value$);
        }
            this.xmlDatatype_$map.put($key$, xmlDatatype);
        }
        this.xmlDatatype_.add(index, xmlDatatype);
    }

    /**
     * Remove the JmXmlDatatype property <b>xmlDatatype</b> by index.
     *
     * @param index
     */
    public final void removeXmlDatatype(int index) {
        JmXmlDatatype $value$ = (JmXmlDatatype)xmlDatatype_.get(index);
        if ($value$ != null) {
            removeXmlDatatype($value$);
        }
        this.xmlDatatype_.remove(index);
    }

    /**
     * Remove the JmXmlDatatype property <b>xmlDatatype</b> by object.
     *
     * @param xmlDatatype
     */
    public final void removeXmlDatatype(JmXmlDatatype xmlDatatype) {
        Object $key$ = xmlDatatype.getName();
        this.xmlDatatype_$map.remove($key$);
        this.xmlDatatype_.remove(xmlDatatype);
    }

    /**
     * Clear the JmXmlDatatype property <b>xmlDatatype</b>.
     *
     */
    public final void clearXmlDatatype() {
        this.xmlDatatype_$map.clear();
        this.xmlDatatype_.clear();
    }

    /**
     * Gets the JmXmlDatatype property <b>xmlDatatype</b> by key.
     *
     * @param key
     * @return JmXmlDatatype
     */
    public final JmXmlDatatype getXmlDatatypeByName(String key) {
        return ((JmXmlDatatype)xmlDatatype_$map.get(key));
    }

    /**
     * Gets the JmJavaDatatype property <b>javaDatatype</b>.
     *
     * @return JmJavaDatatype[]
     */
    public final JmJavaDatatype[] getJavaDatatype() {
        JmJavaDatatype[] array = new JmJavaDatatype[javaDatatype_.size()];
        return ((JmJavaDatatype[])javaDatatype_.toArray(array));
    }

    /**
     * Sets the JmJavaDatatype property <b>javaDatatype</b>.
     *
     * @param javaDatatype
     */
    public final void setJavaDatatype(JmJavaDatatype[] javaDatatype) {
        this.javaDatatype_.clear();
        for (int i = 0;i < javaDatatype.length;i++) {
            addJavaDatatype(javaDatatype[i]);
        }
    }

    /**
     * Sets the JmJavaDatatype property <b>javaDatatype</b>.
     *
     * @param javaDatatype
     */
    public final void setJavaDatatype(JmJavaDatatype javaDatatype) {
        this.javaDatatype_.clear();
        addJavaDatatype(javaDatatype);
    }

    /**
     * Adds the JmJavaDatatype property <b>javaDatatype</b>.
     *
     * @param javaDatatype
     */
    public final void addJavaDatatype(JmJavaDatatype javaDatatype) {
        this.javaDatatype_.add(javaDatatype);
    }

    /**
     * Adds the JmJavaDatatype property <b>javaDatatype</b>.
     *
     * @param javaDatatype
     */
    public final void addJavaDatatype(JmJavaDatatype[] javaDatatype) {
        for (int i = 0;i < javaDatatype.length;i++) {
            addJavaDatatype(javaDatatype[i]);
        }
    }

    /**
     * Gets number of the JmJavaDatatype property <b>javaDatatype</b>.
     *
     * @return int
     */
    public final int sizeJavaDatatype() {
        return (javaDatatype_.size());
    }

    /**
     * Gets the JmJavaDatatype property <b>javaDatatype</b> by index.
     *
     * @param index
     * @return JmJavaDatatype
     */
    public final JmJavaDatatype getJavaDatatype(int index) {
        return ((JmJavaDatatype)javaDatatype_.get(index));
    }

    /**
     * Sets the JmJavaDatatype property <b>javaDatatype</b> by index.
     *
     * @param index
     * @param javaDatatype
     */
    public final void setJavaDatatype(int index, JmJavaDatatype javaDatatype) {
        this.javaDatatype_.set(index, javaDatatype);
    }

    /**
     * Adds the JmJavaDatatype property <b>javaDatatype</b> by index.
     *
     * @param index
     * @param javaDatatype
     */
    public final void addJavaDatatype(int index, JmJavaDatatype javaDatatype) {
        this.javaDatatype_.add(index, javaDatatype);
    }

    /**
     * Remove the JmJavaDatatype property <b>javaDatatype</b> by index.
     *
     * @param index
     */
    public final void removeJavaDatatype(int index) {
        this.javaDatatype_.remove(index);
    }

    /**
     * Remove the JmJavaDatatype property <b>javaDatatype</b> by object.
     *
     * @param javaDatatype
     */
    public final void removeJavaDatatype(JmJavaDatatype javaDatatype) {
        this.javaDatatype_.remove(javaDatatype);
    }

    /**
     * Clear the JmJavaDatatype property <b>javaDatatype</b>.
     *
     */
    public final void clearJavaDatatype() {
        this.javaDatatype_.clear();
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
        buffer.append("<jdbc-model");
        if (databaseType_ != null) {
            buffer.append(" database-type=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getDatabaseType())));
            buffer.append("\"");
        }
        buffer.append(">");
        buffer.append("<quote-id>");
        buffer.append(URelaxer.escapeCharData(URelaxer.getString(getQuoteId())));
        buffer.append("</quote-id>");
        buffer.append("<quote-where>");
        buffer.append(URelaxer.escapeCharData(URelaxer.getString(getQuoteWhere())));
        buffer.append("</quote-where>");
        buffer.append("<quote-id-in-where>");
        buffer.append(URelaxer.escapeCharData(URelaxer.getString(getQuoteIdInWhere())));
        buffer.append("</quote-id-in-where>");
        size = this.xmlDatatype_.size();
        for (int i = 0;i < size;i++) {
            JmXmlDatatype value = (JmXmlDatatype)this.xmlDatatype_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.javaDatatype_.size();
        for (int i = 0;i < size;i++) {
            JmJavaDatatype value = (JmJavaDatatype)this.javaDatatype_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</jdbc-model>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<jdbc-model");
        if (databaseType_ != null) {
            buffer.write(" database-type=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getDatabaseType())));
            buffer.write("\"");
        }
        buffer.write(">");
        buffer.write("<quote-id>");
        buffer.write(URelaxer.escapeCharData(URelaxer.getString(getQuoteId())));
        buffer.write("</quote-id>");
        buffer.write("<quote-where>");
        buffer.write(URelaxer.escapeCharData(URelaxer.getString(getQuoteWhere())));
        buffer.write("</quote-where>");
        buffer.write("<quote-id-in-where>");
        buffer.write(URelaxer.escapeCharData(URelaxer.getString(getQuoteIdInWhere())));
        buffer.write("</quote-id-in-where>");
        size = this.xmlDatatype_.size();
        for (int i = 0;i < size;i++) {
            JmXmlDatatype value = (JmXmlDatatype)this.xmlDatatype_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.javaDatatype_.size();
        for (int i = 0;i < size;i++) {
            JmJavaDatatype value = (JmJavaDatatype)this.javaDatatype_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</jdbc-model>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<jdbc-model");
        if (databaseType_ != null) {
            buffer.print(" database-type=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getDatabaseType())));
            buffer.print("\"");
        }
        buffer.print(">");
        buffer.print("<quote-id>");
        buffer.print(URelaxer.escapeCharData(URelaxer.getString(getQuoteId())));
        buffer.print("</quote-id>");
        buffer.print("<quote-where>");
        buffer.print(URelaxer.escapeCharData(URelaxer.getString(getQuoteWhere())));
        buffer.print("</quote-where>");
        buffer.print("<quote-id-in-where>");
        buffer.print(URelaxer.escapeCharData(URelaxer.getString(getQuoteIdInWhere())));
        buffer.print("</quote-id-in-where>");
        size = this.xmlDatatype_.size();
        for (int i = 0;i < size;i++) {
            JmXmlDatatype value = (JmXmlDatatype)this.xmlDatatype_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.javaDatatype_.size();
        for (int i = 0;i < size;i++) {
            JmJavaDatatype value = (JmJavaDatatype)this.javaDatatype_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</jdbc-model>");
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
    public String getDatabaseTypeAsString() {
        return (URelaxer.getString(getDatabaseType()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getQuoteIdAsString() {
        return (URelaxer.getString(getQuoteId()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getQuoteWhereAsString() {
        return (URelaxer.getString(getQuoteWhere()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getQuoteIdInWhereAsString() {
        return (URelaxer.getString(getQuoteIdInWhere()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setDatabaseTypeByString(String string) {
        setDatabaseType(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setQuoteIdByString(String string) {
        setQuoteId(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setQuoteWhereByString(String string) {
        setQuoteWhere(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setQuoteIdInWhereByString(String string) {
        setQuoteIdInWhere(string);
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
     * Tests if a Element <code>element</code> is valid
     * for the <code>JmJdbcModel</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "jdbc-model")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "database-type")) {
            return (false);
        }
        $match$ = true;
        child = target.popElement();
        if (child == null) {
            return (false);
        }
        if (!URelaxer.isTargetElement(child, "quote-id")) {
            return (false);
        }
        $match$ = true;
        child = target.popElement();
        if (child == null) {
            return (false);
        }
        if (!URelaxer.isTargetElement(child, "quote-where")) {
            return (false);
        }
        $match$ = true;
        child = target.popElement();
        if (child == null) {
            return (false);
        }
        if (!URelaxer.isTargetElement(child, "quote-id-in-where")) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!JmXmlDatatype.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        while (true) {
            if (!JmJavaDatatype.isMatchHungry(target)) {
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
     * is valid for the <code>JmJdbcModel</code>.
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
     * is valid for the <code>JmJdbcModel</code>.
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
