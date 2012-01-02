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
package org.relaxer.vocabulary.forrest_0_5.howto_v12;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>FhHeader</b> is generated from howto_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="header">
 *             <ref name="header.attlist"/>
 *             <ref name="title"/>
 *             <optional>
 *                 <ref name="subtitle"/>
 *             </optional>
 *             <optional>
 *                 <ref name="version"/>
 *             </optional>
 *             <optional>
 *                 <ref name="type"/>
 *             </optional>
 *             <optional>
 *                 <ref name="authors"/>
 *             </optional>
 *             <zeroOrMore>
 *                 <ref name="notice"/>
 *             </zeroOrMore>
 *             <optional>
 *                 <ref name="abstract"/>
 *             </optional>
 *             <ref name="local.headers"/>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="header"&gt;
 *             &lt;ref name="header.attlist"/&gt;
 *             &lt;ref name="title"/&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="subtitle"/&gt;
 *             &lt;/optional&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="version"/&gt;
 *             &lt;/optional&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="type"/&gt;
 *             &lt;/optional&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="authors"/&gt;
 *             &lt;/optional&gt;
 *             &lt;zeroOrMore&gt;
 *                 &lt;ref name="notice"/&gt;
 *             &lt;/zeroOrMore&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="abstract"/&gt;
 *             &lt;/optional&gt;
 *             &lt;ref name="local.headers"/&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version howto_v12.rng (Wed Mar 03 11:15:33 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FhHeader implements java.io.Serializable, Cloneable {
    private String id_;
    private String xmlLang_;
    private FhTitle title_;
    private FhSubtitle subtitle_;
    private FhVersion version_;
    private FhType type_;
    private FhAuthors authors_;
    // List<FhNotice>
    private java.util.List notice_ = new java.util.ArrayList();
    private FhAbstract abstract_;
    private FhLastModifiedContentDate lastModifiedContentDate_;

    /**
     * Creates a <code>FhHeader</code>.
     *
     */
    public FhHeader() {
    }

    /**
     * Creates a <code>FhHeader</code>.
     *
     * @param source
     */
    public FhHeader(FhHeader source) {
        setup(source);
    }

    /**
     * Creates a <code>FhHeader</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FhHeader(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FhHeader</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FhHeader(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FhHeader</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FhHeader(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FhHeader</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhHeader(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FhHeader</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhHeader(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FhHeader</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhHeader(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FhHeader</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhHeader(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FhHeader</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhHeader(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FhHeader</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhHeader(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FhHeader</code> by the FhHeader <code>source</code>.
     *
     * @param source
     */
    public void setup(FhHeader source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        if (source.title_ != null) {
            setTitle((FhTitle)source.getTitle().clone());
        }
        if (source.subtitle_ != null) {
            setSubtitle((FhSubtitle)source.getSubtitle().clone());
        }
        if (source.version_ != null) {
            setVersion((FhVersion)source.getVersion().clone());
        }
        if (source.type_ != null) {
            setType((FhType)source.getType().clone());
        }
        if (source.authors_ != null) {
            setAuthors((FhAuthors)source.getAuthors().clone());
        }
        this.notice_.clear();
        size = source.notice_.size();
        for (int i = 0;i < size;i++) {
            addNotice((FhNotice)source.getNotice(i).clone());
        }
        if (source.abstract_ != null) {
            setAbstract((FhAbstract)source.getAbstract().clone());
        }
        if (source.lastModifiedContentDate_ != null) {
            setLastModifiedContentDate((FhLastModifiedContentDate)source.getLastModifiedContentDate().clone());
        }
    }

    /**
     * Initializes the <code>FhHeader</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FhHeader</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FhHeader</code> by the Stack <code>stack</code>
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
        id_ = URelaxer.getAttributePropertyAsString(element, "id");
        xmlLang_ = URelaxer.getAttributePropertyAsString(element, "xml:lang");
        setTitle(new FhTitle(stack));
        if (FhSubtitle.isMatch(stack)) {
            setSubtitle(new FhSubtitle(stack));
        }
        if (FhVersion.isMatch(stack)) {
            setVersion(new FhVersion(stack));
        }
        if (FhType.isMatch(stack)) {
            setType(new FhType(stack));
        }
        if (FhAuthors.isMatch(stack)) {
            setAuthors(new FhAuthors(stack));
        }
        notice_.clear();
        while (true) {
            if (FhNotice.isMatch(stack)) {
                addNotice(new FhNotice(stack));
            } else {
                break;
            }
        }
        if (FhAbstract.isMatch(stack)) {
            setAbstract(new FhAbstract(stack));
        }
        setLastModifiedContentDate(new FhLastModifiedContentDate(stack));
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FhHeader(this));
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
        Element element = doc.createElement("header");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        this.title_.makeElement(element);
        if (this.subtitle_ != null) {
            this.subtitle_.makeElement(element);
        }
        if (this.version_ != null) {
            this.version_.makeElement(element);
        }
        if (this.type_ != null) {
            this.type_.makeElement(element);
        }
        if (this.authors_ != null) {
            this.authors_.makeElement(element);
        }
        size = this.notice_.size();
        for (int i = 0;i < size;i++) {
            FhNotice value = (FhNotice)this.notice_.get(i);
            value.makeElement(element);
        }
        if (this.abstract_ != null) {
            this.abstract_.makeElement(element);
        }
        this.lastModifiedContentDate_.makeElement(element);
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FhHeader</code> by the File <code>file</code>.
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
     * Initializes the <code>FhHeader</code>
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
     * Initializes the <code>FhHeader</code> by the URL <code>url</code>.
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
     * Initializes the <code>FhHeader</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FhHeader</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FhHeader</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>id</b>.
     *
     * @return String
     */
    public String getId() {
        return (id_);
    }

    /**
     * Sets the String property <b>id</b>.
     *
     * @param id
     */
    public void setId(String id) {
        this.id_ = id;
    }

    /**
     * Gets the String property <b>xmlLang</b>.
     *
     * @return String
     */
    public String getXmlLang() {
        return (xmlLang_);
    }

    /**
     * Sets the String property <b>xmlLang</b>.
     *
     * @param xmlLang
     */
    public void setXmlLang(String xmlLang) {
        this.xmlLang_ = xmlLang;
    }

    /**
     * Gets the FhTitle property <b>title</b>.
     *
     * @return FhTitle
     */
    public FhTitle getTitle() {
        return (title_);
    }

    /**
     * Sets the FhTitle property <b>title</b>.
     *
     * @param title
     */
    public void setTitle(FhTitle title) {
        this.title_ = title;
    }

    /**
     * Gets the FhSubtitle property <b>subtitle</b>.
     *
     * @return FhSubtitle
     */
    public FhSubtitle getSubtitle() {
        return (subtitle_);
    }

    /**
     * Sets the FhSubtitle property <b>subtitle</b>.
     *
     * @param subtitle
     */
    public void setSubtitle(FhSubtitle subtitle) {
        this.subtitle_ = subtitle;
    }

    /**
     * Gets the FhVersion property <b>version</b>.
     *
     * @return FhVersion
     */
    public FhVersion getVersion() {
        return (version_);
    }

    /**
     * Sets the FhVersion property <b>version</b>.
     *
     * @param version
     */
    public void setVersion(FhVersion version) {
        this.version_ = version;
    }

    /**
     * Gets the FhType property <b>type</b>.
     *
     * @return FhType
     */
    public FhType getType() {
        return (type_);
    }

    /**
     * Sets the FhType property <b>type</b>.
     *
     * @param type
     */
    public void setType(FhType type) {
        this.type_ = type;
    }

    /**
     * Gets the FhAuthors property <b>authors</b>.
     *
     * @return FhAuthors
     */
    public FhAuthors getAuthors() {
        return (authors_);
    }

    /**
     * Sets the FhAuthors property <b>authors</b>.
     *
     * @param authors
     */
    public void setAuthors(FhAuthors authors) {
        this.authors_ = authors;
    }

    /**
     * Gets the FhNotice property <b>notice</b>.
     *
     * @return FhNotice[]
     */
    public FhNotice[] getNotice() {
        FhNotice[] array = new FhNotice[notice_.size()];
        return ((FhNotice[])notice_.toArray(array));
    }

    /**
     * Sets the FhNotice property <b>notice</b>.
     *
     * @param notice
     */
    public void setNotice(FhNotice[] notice) {
        this.notice_.clear();
        for (int i = 0;i < notice.length;i++) {
            addNotice(notice[i]);
        }
    }

    /**
     * Sets the FhNotice property <b>notice</b>.
     *
     * @param notice
     */
    public void setNotice(FhNotice notice) {
        this.notice_.clear();
        addNotice(notice);
    }

    /**
     * Adds the FhNotice property <b>notice</b>.
     *
     * @param notice
     */
    public void addNotice(FhNotice notice) {
        this.notice_.add(notice);
    }

    /**
     * Adds the FhNotice property <b>notice</b>.
     *
     * @param notice
     */
    public void addNotice(FhNotice[] notice) {
        for (int i = 0;i < notice.length;i++) {
            addNotice(notice[i]);
        }
    }

    /**
     * Gets number of the FhNotice property <b>notice</b>.
     *
     * @return int
     */
    public int sizeNotice() {
        return (notice_.size());
    }

    /**
     * Gets the FhNotice property <b>notice</b> by index.
     *
     * @param index
     * @return FhNotice
     */
    public FhNotice getNotice(int index) {
        return ((FhNotice)notice_.get(index));
    }

    /**
     * Sets the FhNotice property <b>notice</b> by index.
     *
     * @param index
     * @param notice
     */
    public void setNotice(int index, FhNotice notice) {
        this.notice_.set(index, notice);
    }

    /**
     * Adds the FhNotice property <b>notice</b> by index.
     *
     * @param index
     * @param notice
     */
    public void addNotice(int index, FhNotice notice) {
        this.notice_.add(index, notice);
    }

    /**
     * Remove the FhNotice property <b>notice</b> by index.
     *
     * @param index
     */
    public void removeNotice(int index) {
        this.notice_.remove(index);
    }

    /**
     * Remove the FhNotice property <b>notice</b> by object.
     *
     * @param notice
     */
    public void removeNotice(FhNotice notice) {
        this.notice_.remove(notice);
    }

    /**
     * Clear the FhNotice property <b>notice</b>.
     *
     */
    public void clearNotice() {
        this.notice_.clear();
    }

    /**
     * Gets the FhAbstract property <b>abstract</b>.
     *
     * @return FhAbstract
     */
    public FhAbstract getAbstract() {
        return (abstract_);
    }

    /**
     * Sets the FhAbstract property <b>abstract</b>.
     *
     * @param abstractValue
     */
    public void setAbstract(FhAbstract abstractValue) {
        this.abstract_ = abstractValue;
    }

    /**
     * Gets the FhLastModifiedContentDate property <b>lastModifiedContentDate</b>.
     *
     * @return FhLastModifiedContentDate
     */
    public FhLastModifiedContentDate getLastModifiedContentDate() {
        return (lastModifiedContentDate_);
    }

    /**
     * Sets the FhLastModifiedContentDate property <b>lastModifiedContentDate</b>.
     *
     * @param lastModifiedContentDate
     */
    public void setLastModifiedContentDate(FhLastModifiedContentDate lastModifiedContentDate) {
        this.lastModifiedContentDate_ = lastModifiedContentDate;
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
        buffer.append("<header");
        if (id_ != null) {
            buffer.append(" id=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getId())));
            buffer.append("\"");
        }
        if (xmlLang_ != null) {
            buffer.append(" xml:lang=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getXmlLang())));
            buffer.append("\"");
        }
        buffer.append(">");
        title_.makeTextElement(buffer);
        if (subtitle_ != null) {
            subtitle_.makeTextElement(buffer);
        }
        if (version_ != null) {
            version_.makeTextElement(buffer);
        }
        if (type_ != null) {
            type_.makeTextElement(buffer);
        }
        if (authors_ != null) {
            authors_.makeTextElement(buffer);
        }
        size = this.notice_.size();
        for (int i = 0;i < size;i++) {
            FhNotice value = (FhNotice)this.notice_.get(i);
            value.makeTextElement(buffer);
        }
        if (abstract_ != null) {
            abstract_.makeTextElement(buffer);
        }
        lastModifiedContentDate_.makeTextElement(buffer);
        buffer.append("</header>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<header");
        if (id_ != null) {
            buffer.write(" id=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getId())));
            buffer.write("\"");
        }
        if (xmlLang_ != null) {
            buffer.write(" xml:lang=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getXmlLang())));
            buffer.write("\"");
        }
        buffer.write(">");
        title_.makeTextElement(buffer);
        if (subtitle_ != null) {
            subtitle_.makeTextElement(buffer);
        }
        if (version_ != null) {
            version_.makeTextElement(buffer);
        }
        if (type_ != null) {
            type_.makeTextElement(buffer);
        }
        if (authors_ != null) {
            authors_.makeTextElement(buffer);
        }
        size = this.notice_.size();
        for (int i = 0;i < size;i++) {
            FhNotice value = (FhNotice)this.notice_.get(i);
            value.makeTextElement(buffer);
        }
        if (abstract_ != null) {
            abstract_.makeTextElement(buffer);
        }
        lastModifiedContentDate_.makeTextElement(buffer);
        buffer.write("</header>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<header");
        if (id_ != null) {
            buffer.print(" id=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getId())));
            buffer.print("\"");
        }
        if (xmlLang_ != null) {
            buffer.print(" xml:lang=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getXmlLang())));
            buffer.print("\"");
        }
        buffer.print(">");
        title_.makeTextElement(buffer);
        if (subtitle_ != null) {
            subtitle_.makeTextElement(buffer);
        }
        if (version_ != null) {
            version_.makeTextElement(buffer);
        }
        if (type_ != null) {
            type_.makeTextElement(buffer);
        }
        if (authors_ != null) {
            authors_.makeTextElement(buffer);
        }
        size = this.notice_.size();
        for (int i = 0;i < size;i++) {
            FhNotice value = (FhNotice)this.notice_.get(i);
            value.makeTextElement(buffer);
        }
        if (abstract_ != null) {
            abstract_.makeTextElement(buffer);
        }
        lastModifiedContentDate_.makeTextElement(buffer);
        buffer.print("</header>");
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
    public String getIdAsString() {
        return (URelaxer.getString(getId()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getXmlLangAsString() {
        return (URelaxer.getString(getXmlLang()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setIdByString(String string) {
        setId(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setXmlLangByString(String string) {
        setXmlLang(string);
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
     * for the <code>FhHeader</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "header")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!FhTitle.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        if (FhSubtitle.isMatchHungry(target)) {
        }
        if (FhVersion.isMatchHungry(target)) {
        }
        if (FhType.isMatchHungry(target)) {
        }
        if (FhAuthors.isMatchHungry(target)) {
        }
        while (true) {
            if (!FhNotice.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (FhAbstract.isMatchHungry(target)) {
        }
        if (!FhLastModifiedContentDate.isMatchHungry(target)) {
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
     * is valid for the <code>FhHeader</code>.
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
     * is valid for the <code>FhHeader</code>.
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
