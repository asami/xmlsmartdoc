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
package org.relaxer.vocabulary.forrest_0_5.todo_v12;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>FtHeader</b> is generated from todo_v12.rng by Relaxer.
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
 * @version todo_v12.rng (Wed Mar 03 11:15:51 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FtHeader implements java.io.Serializable, Cloneable {
    private String id_;
    private String xmlLang_;
    private FtTitle title_;
    private FtSubtitle subtitle_;
    private FtVersion version_;
    private FtType type_;
    private FtAuthors authors_;
    // List<FtNotice>
    private java.util.List notice_ = new java.util.ArrayList();
    private FtAbstract abstract_;

    /**
     * Creates a <code>FtHeader</code>.
     *
     */
    public FtHeader() {
    }

    /**
     * Creates a <code>FtHeader</code>.
     *
     * @param source
     */
    public FtHeader(FtHeader source) {
        setup(source);
    }

    /**
     * Creates a <code>FtHeader</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FtHeader(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FtHeader</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FtHeader(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FtHeader</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FtHeader(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FtHeader</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtHeader(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FtHeader</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtHeader(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FtHeader</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtHeader(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FtHeader</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtHeader(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FtHeader</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtHeader(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FtHeader</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtHeader(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FtHeader</code> by the FtHeader <code>source</code>.
     *
     * @param source
     */
    public void setup(FtHeader source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        if (source.title_ != null) {
            setTitle((FtTitle)source.getTitle().clone());
        }
        if (source.subtitle_ != null) {
            setSubtitle((FtSubtitle)source.getSubtitle().clone());
        }
        if (source.version_ != null) {
            setVersion((FtVersion)source.getVersion().clone());
        }
        if (source.type_ != null) {
            setType((FtType)source.getType().clone());
        }
        if (source.authors_ != null) {
            setAuthors((FtAuthors)source.getAuthors().clone());
        }
        this.notice_.clear();
        size = source.notice_.size();
        for (int i = 0;i < size;i++) {
            addNotice((FtNotice)source.getNotice(i).clone());
        }
        if (source.abstract_ != null) {
            setAbstract((FtAbstract)source.getAbstract().clone());
        }
    }

    /**
     * Initializes the <code>FtHeader</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FtHeader</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FtHeader</code> by the Stack <code>stack</code>
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
        setTitle(new FtTitle(stack));
        if (FtSubtitle.isMatch(stack)) {
            setSubtitle(new FtSubtitle(stack));
        }
        if (FtVersion.isMatch(stack)) {
            setVersion(new FtVersion(stack));
        }
        if (FtType.isMatch(stack)) {
            setType(new FtType(stack));
        }
        if (FtAuthors.isMatch(stack)) {
            setAuthors(new FtAuthors(stack));
        }
        notice_.clear();
        while (true) {
            if (FtNotice.isMatch(stack)) {
                addNotice(new FtNotice(stack));
            } else {
                break;
            }
        }
        if (FtAbstract.isMatch(stack)) {
            setAbstract(new FtAbstract(stack));
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FtHeader(this));
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
            FtNotice value = (FtNotice)this.notice_.get(i);
            value.makeElement(element);
        }
        if (this.abstract_ != null) {
            this.abstract_.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FtHeader</code> by the File <code>file</code>.
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
     * Initializes the <code>FtHeader</code>
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
     * Initializes the <code>FtHeader</code> by the URL <code>url</code>.
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
     * Initializes the <code>FtHeader</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FtHeader</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FtHeader</code> by the Reader <code>reader</code>.
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
     * Gets the FtTitle property <b>title</b>.
     *
     * @return FtTitle
     */
    public FtTitle getTitle() {
        return (title_);
    }

    /**
     * Sets the FtTitle property <b>title</b>.
     *
     * @param title
     */
    public void setTitle(FtTitle title) {
        this.title_ = title;
    }

    /**
     * Gets the FtSubtitle property <b>subtitle</b>.
     *
     * @return FtSubtitle
     */
    public FtSubtitle getSubtitle() {
        return (subtitle_);
    }

    /**
     * Sets the FtSubtitle property <b>subtitle</b>.
     *
     * @param subtitle
     */
    public void setSubtitle(FtSubtitle subtitle) {
        this.subtitle_ = subtitle;
    }

    /**
     * Gets the FtVersion property <b>version</b>.
     *
     * @return FtVersion
     */
    public FtVersion getVersion() {
        return (version_);
    }

    /**
     * Sets the FtVersion property <b>version</b>.
     *
     * @param version
     */
    public void setVersion(FtVersion version) {
        this.version_ = version;
    }

    /**
     * Gets the FtType property <b>type</b>.
     *
     * @return FtType
     */
    public FtType getType() {
        return (type_);
    }

    /**
     * Sets the FtType property <b>type</b>.
     *
     * @param type
     */
    public void setType(FtType type) {
        this.type_ = type;
    }

    /**
     * Gets the FtAuthors property <b>authors</b>.
     *
     * @return FtAuthors
     */
    public FtAuthors getAuthors() {
        return (authors_);
    }

    /**
     * Sets the FtAuthors property <b>authors</b>.
     *
     * @param authors
     */
    public void setAuthors(FtAuthors authors) {
        this.authors_ = authors;
    }

    /**
     * Gets the FtNotice property <b>notice</b>.
     *
     * @return FtNotice[]
     */
    public FtNotice[] getNotice() {
        FtNotice[] array = new FtNotice[notice_.size()];
        return ((FtNotice[])notice_.toArray(array));
    }

    /**
     * Sets the FtNotice property <b>notice</b>.
     *
     * @param notice
     */
    public void setNotice(FtNotice[] notice) {
        this.notice_.clear();
        for (int i = 0;i < notice.length;i++) {
            addNotice(notice[i]);
        }
    }

    /**
     * Sets the FtNotice property <b>notice</b>.
     *
     * @param notice
     */
    public void setNotice(FtNotice notice) {
        this.notice_.clear();
        addNotice(notice);
    }

    /**
     * Adds the FtNotice property <b>notice</b>.
     *
     * @param notice
     */
    public void addNotice(FtNotice notice) {
        this.notice_.add(notice);
    }

    /**
     * Adds the FtNotice property <b>notice</b>.
     *
     * @param notice
     */
    public void addNotice(FtNotice[] notice) {
        for (int i = 0;i < notice.length;i++) {
            addNotice(notice[i]);
        }
    }

    /**
     * Gets number of the FtNotice property <b>notice</b>.
     *
     * @return int
     */
    public int sizeNotice() {
        return (notice_.size());
    }

    /**
     * Gets the FtNotice property <b>notice</b> by index.
     *
     * @param index
     * @return FtNotice
     */
    public FtNotice getNotice(int index) {
        return ((FtNotice)notice_.get(index));
    }

    /**
     * Sets the FtNotice property <b>notice</b> by index.
     *
     * @param index
     * @param notice
     */
    public void setNotice(int index, FtNotice notice) {
        this.notice_.set(index, notice);
    }

    /**
     * Adds the FtNotice property <b>notice</b> by index.
     *
     * @param index
     * @param notice
     */
    public void addNotice(int index, FtNotice notice) {
        this.notice_.add(index, notice);
    }

    /**
     * Remove the FtNotice property <b>notice</b> by index.
     *
     * @param index
     */
    public void removeNotice(int index) {
        this.notice_.remove(index);
    }

    /**
     * Remove the FtNotice property <b>notice</b> by object.
     *
     * @param notice
     */
    public void removeNotice(FtNotice notice) {
        this.notice_.remove(notice);
    }

    /**
     * Clear the FtNotice property <b>notice</b>.
     *
     */
    public void clearNotice() {
        this.notice_.clear();
    }

    /**
     * Gets the FtAbstract property <b>abstract</b>.
     *
     * @return FtAbstract
     */
    public FtAbstract getAbstract() {
        return (abstract_);
    }

    /**
     * Sets the FtAbstract property <b>abstract</b>.
     *
     * @param abstractValue
     */
    public void setAbstract(FtAbstract abstractValue) {
        this.abstract_ = abstractValue;
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
            FtNotice value = (FtNotice)this.notice_.get(i);
            value.makeTextElement(buffer);
        }
        if (abstract_ != null) {
            abstract_.makeTextElement(buffer);
        }
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
            FtNotice value = (FtNotice)this.notice_.get(i);
            value.makeTextElement(buffer);
        }
        if (abstract_ != null) {
            abstract_.makeTextElement(buffer);
        }
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
            FtNotice value = (FtNotice)this.notice_.get(i);
            value.makeTextElement(buffer);
        }
        if (abstract_ != null) {
            abstract_.makeTextElement(buffer);
        }
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
     * for the <code>FtHeader</code>.
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
        if (!FtTitle.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        if (FtSubtitle.isMatchHungry(target)) {
        }
        if (FtVersion.isMatchHungry(target)) {
        }
        if (FtType.isMatchHungry(target)) {
        }
        if (FtAuthors.isMatchHungry(target)) {
        }
        while (true) {
            if (!FtNotice.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (FtAbstract.isMatchHungry(target)) {
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FtHeader</code>.
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
     * is valid for the <code>FtHeader</code>.
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
