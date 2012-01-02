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
 * <b>FtAction</b> is generated from todo_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="action">
 *             <ref name="action.attlist"/>
 *             <zeroOrMore>
 *                 <ref name="content.mix"/>
 *             </zeroOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="action"&gt;
 *             &lt;ref name="action.attlist"/&gt;
 *             &lt;zeroOrMore&gt;
 *                 &lt;ref name="content.mix"/&gt;
 *             &lt;/zeroOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version todo_v12.rng (Wed Mar 03 11:15:51 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FtAction implements java.io.Serializable, Cloneable {
    private String id_;
    private String xmlLang_;
    private String dev_;
    private String type_;
    private String context_;
    private String dueTo_;
    private String dueToEmail_;
    private String fixesBug_;
    // List<IFtContentMixMixed>
    private java.util.List content_ = new java.util.ArrayList();

    /**
     * Creates a <code>FtAction</code>.
     *
     */
    public FtAction() {
        dev_ = "";
    }

    /**
     * Creates a <code>FtAction</code>.
     *
     * @param source
     */
    public FtAction(FtAction source) {
        setup(source);
    }

    /**
     * Creates a <code>FtAction</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FtAction(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FtAction</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FtAction(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FtAction</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FtAction(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FtAction</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtAction(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FtAction</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtAction(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FtAction</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtAction(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FtAction</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtAction(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FtAction</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtAction(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FtAction</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtAction(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FtAction</code> by the FtAction <code>source</code>.
     *
     * @param source
     */
    public void setup(FtAction source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        setDev(source.getDev());
        setType(source.getType());
        setContext(source.getContext());
        setDueTo(source.getDueTo());
        setDueToEmail(source.getDueToEmail());
        setFixesBug(source.getFixesBug());
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((IFtContentMixMixed)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>FtAction</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FtAction</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FtAction</code> by the Stack <code>stack</code>
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
        dev_ = URelaxer.getAttributePropertyAsString(element, "dev");
        type_ = URelaxer.getAttributePropertyAsString(element, "type");
        context_ = URelaxer.getAttributePropertyAsString(element, "context");
        dueTo_ = URelaxer.getAttributePropertyAsString(element, "due-to");
        dueToEmail_ = URelaxer.getAttributePropertyAsString(element, "due-to-email");
        fixesBug_ = URelaxer.getAttributePropertyAsString(element, "fixes-bug");
        this.content_.clear();
        while (true) {
            if (RString.isMatch(stack)) {
                addContent(new RString(stack));
            } else if (FtImg.isMatch(stack)) {
                addContent(new FtImg(stack));
            } else if (FtLink.isMatch(stack)) {
                addContent(new FtLink(stack));
            } else if (FtJump.isMatch(stack)) {
                addContent(new FtJump(stack));
            } else if (FtAcronym.isMatch(stack)) {
                addContent(new FtAcronym(stack));
            } else if (FtStrong.isMatch(stack)) {
                addContent(new FtStrong(stack));
            } else if (FtCode.isMatch(stack)) {
                addContent(new FtCode(stack));
            } else if (FtSub.isMatch(stack)) {
                addContent(new FtSub(stack));
            } else if (FtSup.isMatch(stack)) {
                addContent(new FtSup(stack));
            } else if (FtEm.isMatch(stack)) {
                addContent(new FtEm(stack));
            } else if (FtBr.isMatch(stack)) {
                addContent(new FtBr(stack));
            } else if (FtIcon.isMatch(stack)) {
                addContent(new FtIcon(stack));
            } else if (FtFork.isMatch(stack)) {
                addContent(new FtFork(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FtAction(this));
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
        Element element = doc.createElement("action");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        if (this.dev_ != null) {
            URelaxer.setAttributePropertyByString(element, "dev", this.dev_);
        }
        if (this.type_ != null) {
            URelaxer.setAttributePropertyByString(element, "type", this.type_);
        }
        if (this.context_ != null) {
            URelaxer.setAttributePropertyByString(element, "context", this.context_);
        }
        if (this.dueTo_ != null) {
            URelaxer.setAttributePropertyByString(element, "due-to", this.dueTo_);
        }
        if (this.dueToEmail_ != null) {
            URelaxer.setAttributePropertyByString(element, "due-to-email", this.dueToEmail_);
        }
        if (this.fixesBug_ != null) {
            URelaxer.setAttributePropertyByString(element, "fixes-bug", this.fixesBug_);
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFtContentMixMixed value = (IFtContentMixMixed)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FtAction</code> by the File <code>file</code>.
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
     * Initializes the <code>FtAction</code>
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
     * Initializes the <code>FtAction</code> by the URL <code>url</code>.
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
     * Initializes the <code>FtAction</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FtAction</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FtAction</code> by the Reader <code>reader</code>.
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
     * Sets a mixed content by <code>String</code>.
     *
     * @param value
     */
    public void setContent(String value) {
        setContent(new RString(value));
    }

    /**
     * Adds a mixed content by <code>String</code>.
     *
     * @param value
     */
    public void addContent(String value) {
        addContent(new RString(value));
    }

    /**
     * Sets a mixed content by <code>String</code>.
     *
     * @param value
     */
    public void setContentByString(String value) {
        setContent(new RString(value));
    }

    /**
     * Adds a mixed content by <code>String</code>.
     *
     * @param value
     */
    public void addContentByString(String value) {
        addContent(new RString(value));
    }

    /**
     * Sets a mixed content by <code>org.w3c.dom.Node</code>.
     *
     * @param value
     */
    public void setContent(org.w3c.dom.Node value) {
        setContent(new RString(value));
    }

    /**
     * Adds a mixed content by <code>org.w3c.dom.Node</code>.
     *
     * @param value
     */
    public void addContent(org.w3c.dom.Node value) {
        addContent(new RString(value));
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
     * Gets the String property <b>dev</b>.
     *
     * @return String
     */
    public String getDev() {
        return (dev_);
    }

    /**
     * Sets the String property <b>dev</b>.
     *
     * @param dev
     */
    public void setDev(String dev) {
        this.dev_ = dev;
    }

    /**
     * Gets the String property <b>type</b>.
     *
     * @return String
     */
    public String getType() {
        return (type_);
    }

    /**
     * Sets the String property <b>type</b>.
     *
     * @param type
     */
    public void setType(String type) {
        this.type_ = type;
    }

    /**
     * Gets the String property <b>context</b>.
     *
     * @return String
     */
    public String getContext() {
        return (context_);
    }

    /**
     * Sets the String property <b>context</b>.
     *
     * @param context
     */
    public void setContext(String context) {
        this.context_ = context;
    }

    /**
     * Gets the String property <b>dueTo</b>.
     *
     * @return String
     */
    public String getDueTo() {
        return (dueTo_);
    }

    /**
     * Sets the String property <b>dueTo</b>.
     *
     * @param dueTo
     */
    public void setDueTo(String dueTo) {
        this.dueTo_ = dueTo;
    }

    /**
     * Gets the String property <b>dueToEmail</b>.
     *
     * @return String
     */
    public String getDueToEmail() {
        return (dueToEmail_);
    }

    /**
     * Sets the String property <b>dueToEmail</b>.
     *
     * @param dueToEmail
     */
    public void setDueToEmail(String dueToEmail) {
        this.dueToEmail_ = dueToEmail;
    }

    /**
     * Gets the String property <b>fixesBug</b>.
     *
     * @return String
     */
    public String getFixesBug() {
        return (fixesBug_);
    }

    /**
     * Sets the String property <b>fixesBug</b>.
     *
     * @param fixesBug
     */
    public void setFixesBug(String fixesBug) {
        this.fixesBug_ = fixesBug;
    }

    /**
     * Gets the IFtContentMixMixed property <b>content</b>.
     *
     * @return IFtContentMixMixed[]
     */
    public IFtContentMixMixed[] getContent() {
        IFtContentMixMixed[] array = new IFtContentMixMixed[content_.size()];
        return ((IFtContentMixMixed[])content_.toArray(array));
    }

    /**
     * Sets the IFtContentMixMixed property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFtContentMixMixed[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Sets the IFtContentMixMixed property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFtContentMixMixed content) {
        this.content_.clear();
        addContent(content);
    }

    /**
     * Adds the IFtContentMixMixed property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFtContentMixMixed content) {
        this.content_.add(content);
    }

    /**
     * Adds the IFtContentMixMixed property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFtContentMixMixed[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Gets number of the IFtContentMixMixed property <b>content</b>.
     *
     * @return int
     */
    public int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the IFtContentMixMixed property <b>content</b> by index.
     *
     * @param index
     * @return IFtContentMixMixed
     */
    public IFtContentMixMixed getContent(int index) {
        return ((IFtContentMixMixed)content_.get(index));
    }

    /**
     * Sets the IFtContentMixMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void setContent(int index, IFtContentMixMixed content) {
        this.content_.set(index, content);
    }

    /**
     * Adds the IFtContentMixMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void addContent(int index, IFtContentMixMixed content) {
        this.content_.add(index, content);
    }

    /**
     * Remove the IFtContentMixMixed property <b>content</b> by index.
     *
     * @param index
     */
    public void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the IFtContentMixMixed property <b>content</b> by object.
     *
     * @param content
     */
    public void removeContent(IFtContentMixMixed content) {
        this.content_.remove(content);
    }

    /**
     * Clear the IFtContentMixMixed property <b>content</b>.
     *
     */
    public void clearContent() {
        this.content_.clear();
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
        buffer.append("<action");
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
        if (dev_ != null) {
            buffer.append(" dev=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getDev())));
            buffer.append("\"");
        }
        if (type_ != null) {
            buffer.append(" type=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getType())));
            buffer.append("\"");
        }
        if (context_ != null) {
            buffer.append(" context=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getContext())));
            buffer.append("\"");
        }
        if (dueTo_ != null) {
            buffer.append(" due-to=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getDueTo())));
            buffer.append("\"");
        }
        if (dueToEmail_ != null) {
            buffer.append(" due-to-email=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getDueToEmail())));
            buffer.append("\"");
        }
        if (fixesBug_ != null) {
            buffer.append(" fixes-bug=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getFixesBug())));
            buffer.append("\"");
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFtContentMixMixed value = (IFtContentMixMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFtContentMixMixed value = (IFtContentMixMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</action>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<action");
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
        if (dev_ != null) {
            buffer.write(" dev=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getDev())));
            buffer.write("\"");
        }
        if (type_ != null) {
            buffer.write(" type=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getType())));
            buffer.write("\"");
        }
        if (context_ != null) {
            buffer.write(" context=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getContext())));
            buffer.write("\"");
        }
        if (dueTo_ != null) {
            buffer.write(" due-to=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getDueTo())));
            buffer.write("\"");
        }
        if (dueToEmail_ != null) {
            buffer.write(" due-to-email=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getDueToEmail())));
            buffer.write("\"");
        }
        if (fixesBug_ != null) {
            buffer.write(" fixes-bug=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getFixesBug())));
            buffer.write("\"");
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFtContentMixMixed value = (IFtContentMixMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFtContentMixMixed value = (IFtContentMixMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</action>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<action");
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
        if (dev_ != null) {
            buffer.print(" dev=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getDev())));
            buffer.print("\"");
        }
        if (type_ != null) {
            buffer.print(" type=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getType())));
            buffer.print("\"");
        }
        if (context_ != null) {
            buffer.print(" context=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getContext())));
            buffer.print("\"");
        }
        if (dueTo_ != null) {
            buffer.print(" due-to=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getDueTo())));
            buffer.print("\"");
        }
        if (dueToEmail_ != null) {
            buffer.print(" due-to-email=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getDueToEmail())));
            buffer.print("\"");
        }
        if (fixesBug_ != null) {
            buffer.print(" fixes-bug=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getFixesBug())));
            buffer.print("\"");
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFtContentMixMixed value = (IFtContentMixMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFtContentMixMixed value = (IFtContentMixMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</action>");
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
     * Gets the property value as String.
     *
     * @return String
     */
    public String getDevAsString() {
        return (URelaxer.getString(getDev()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getTypeAsString() {
        return (URelaxer.getString(getType()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getContextAsString() {
        return (URelaxer.getString(getContext()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getDueToAsString() {
        return (URelaxer.getString(getDueTo()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getDueToEmailAsString() {
        return (URelaxer.getString(getDueToEmail()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getFixesBugAsString() {
        return (URelaxer.getString(getFixesBug()));
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
     * Sets the property value by String.
     *
     * @param string
     */
    public void setDevByString(String string) {
        setDev(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setTypeByString(String string) {
        setType(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setContextByString(String string) {
        setContext(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setDueToByString(String string) {
        setDueTo(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setDueToEmailByString(String string) {
        setDueToEmail(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setFixesBugByString(String string) {
        setFixesBug(string);
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
     * for the <code>FtAction</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "action")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "dev")) {
            return (false);
        }
        $match$ = true;
        if (RString.isMatch(target)) {
            $match$ = true;
        }
        while (true) {
            if (FtImg.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtLink.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtJump.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtAcronym.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtStrong.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtCode.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtSub.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtSup.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtEm.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtBr.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtIcon.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtFork.isMatchHungry(target)) {
                $match$ = true;
            } else {
                break;
            }
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FtAction</code>.
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
     * is valid for the <code>FtAction</code>.
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
