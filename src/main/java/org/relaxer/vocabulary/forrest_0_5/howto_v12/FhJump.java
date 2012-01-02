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
 * <b>FhJump</b> is generated from howto_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="jump">
 *             <ref name="jump.attlist"/>
 *             <zeroOrMore>
 *                 <ref name="link-content.mix"/>
 *             </zeroOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="jump"&gt;
 *             &lt;ref name="jump.attlist"/&gt;
 *             &lt;zeroOrMore&gt;
 *                 &lt;ref name="link-content.mix"/&gt;
 *             &lt;/zeroOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version howto_v12.rng (Wed Mar 03 11:15:33 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FhJump implements java.io.Serializable, Cloneable, IFhContentMixMixed, IFhContentMixMixedChoice, IFhTitleMixed, IFhTitleMixedChoice, IFhFlowMixed, IFhFlowMixedChoice {
    private String id_;
    private String xmlLang_;
    private String href_;
    private String role_;
    private String title_;
    // List<IFhLinkContentMixMixed>
    private java.util.List content_ = new java.util.ArrayList();

    /**
     * Creates a <code>FhJump</code>.
     *
     */
    public FhJump() {
        href_ = "";
    }

    /**
     * Creates a <code>FhJump</code>.
     *
     * @param source
     */
    public FhJump(FhJump source) {
        setup(source);
    }

    /**
     * Creates a <code>FhJump</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FhJump(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FhJump</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FhJump(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FhJump</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FhJump(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FhJump</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhJump(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FhJump</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhJump(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FhJump</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhJump(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FhJump</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhJump(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FhJump</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhJump(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FhJump</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhJump(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FhJump</code> by the FhJump <code>source</code>.
     *
     * @param source
     */
    public void setup(FhJump source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        setHref(source.getHref());
        setRole(source.getRole());
        setTitle(source.getTitle());
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((IFhLinkContentMixMixed)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>FhJump</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FhJump</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FhJump</code> by the Stack <code>stack</code>
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
        href_ = URelaxer.getAttributePropertyAsString(element, "href");
        role_ = URelaxer.getAttributePropertyAsString(element, "role");
        title_ = URelaxer.getAttributePropertyAsString(element, "title");
        this.content_.clear();
        while (true) {
            if (RString.isMatch(stack)) {
                addContent(new RString(stack));
            } else if (FhStrong.isMatch(stack)) {
                addContent(new FhStrong(stack));
            } else if (FhEm.isMatch(stack)) {
                addContent(new FhEm(stack));
            } else if (FhCode.isMatch(stack)) {
                addContent(new FhCode(stack));
            } else if (FhSub.isMatch(stack)) {
                addContent(new FhSub(stack));
            } else if (FhSup.isMatch(stack)) {
                addContent(new FhSup(stack));
            } else if (FhBr.isMatch(stack)) {
                addContent(new FhBr(stack));
            } else if (FhImg.isMatch(stack)) {
                addContent(new FhImg(stack));
            } else if (FhIcon.isMatch(stack)) {
                addContent(new FhIcon(stack));
            } else if (FhAcronym.isMatch(stack)) {
                addContent(new FhAcronym(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FhJump(this));
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
        Element element = doc.createElement("jump");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        if (this.href_ != null) {
            URelaxer.setAttributePropertyByString(element, "href", this.href_);
        }
        if (this.role_ != null) {
            URelaxer.setAttributePropertyByString(element, "role", this.role_);
        }
        if (this.title_ != null) {
            URelaxer.setAttributePropertyByString(element, "title", this.title_);
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhLinkContentMixMixed value = (IFhLinkContentMixMixed)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FhJump</code> by the File <code>file</code>.
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
     * Initializes the <code>FhJump</code>
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
     * Initializes the <code>FhJump</code> by the URL <code>url</code>.
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
     * Initializes the <code>FhJump</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FhJump</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FhJump</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>href</b>.
     *
     * @return String
     */
    public String getHref() {
        return (href_);
    }

    /**
     * Sets the String property <b>href</b>.
     *
     * @param href
     */
    public void setHref(String href) {
        this.href_ = href;
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
     * Gets the String property <b>title</b>.
     *
     * @return String
     */
    public String getTitle() {
        return (title_);
    }

    /**
     * Sets the String property <b>title</b>.
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title_ = title;
    }

    /**
     * Gets the IFhLinkContentMixMixed property <b>content</b>.
     *
     * @return IFhLinkContentMixMixed[]
     */
    public IFhLinkContentMixMixed[] getContent() {
        IFhLinkContentMixMixed[] array = new IFhLinkContentMixMixed[content_.size()];
        return ((IFhLinkContentMixMixed[])content_.toArray(array));
    }

    /**
     * Sets the IFhLinkContentMixMixed property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFhLinkContentMixMixed[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Sets the IFhLinkContentMixMixed property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFhLinkContentMixMixed content) {
        this.content_.clear();
        addContent(content);
    }

    /**
     * Adds the IFhLinkContentMixMixed property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFhLinkContentMixMixed content) {
        this.content_.add(content);
    }

    /**
     * Adds the IFhLinkContentMixMixed property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFhLinkContentMixMixed[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Gets number of the IFhLinkContentMixMixed property <b>content</b>.
     *
     * @return int
     */
    public int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the IFhLinkContentMixMixed property <b>content</b> by index.
     *
     * @param index
     * @return IFhLinkContentMixMixed
     */
    public IFhLinkContentMixMixed getContent(int index) {
        return ((IFhLinkContentMixMixed)content_.get(index));
    }

    /**
     * Sets the IFhLinkContentMixMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void setContent(int index, IFhLinkContentMixMixed content) {
        this.content_.set(index, content);
    }

    /**
     * Adds the IFhLinkContentMixMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void addContent(int index, IFhLinkContentMixMixed content) {
        this.content_.add(index, content);
    }

    /**
     * Remove the IFhLinkContentMixMixed property <b>content</b> by index.
     *
     * @param index
     */
    public void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the IFhLinkContentMixMixed property <b>content</b> by object.
     *
     * @param content
     */
    public void removeContent(IFhLinkContentMixMixed content) {
        this.content_.remove(content);
    }

    /**
     * Clear the IFhLinkContentMixMixed property <b>content</b>.
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
        buffer.append("<jump");
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
        if (href_ != null) {
            buffer.append(" href=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getHref())));
            buffer.append("\"");
        }
        if (role_ != null) {
            buffer.append(" role=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getRole())));
            buffer.append("\"");
        }
        if (title_ != null) {
            buffer.append(" title=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getTitle())));
            buffer.append("\"");
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhLinkContentMixMixed value = (IFhLinkContentMixMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhLinkContentMixMixed value = (IFhLinkContentMixMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</jump>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<jump");
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
        if (href_ != null) {
            buffer.write(" href=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getHref())));
            buffer.write("\"");
        }
        if (role_ != null) {
            buffer.write(" role=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getRole())));
            buffer.write("\"");
        }
        if (title_ != null) {
            buffer.write(" title=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getTitle())));
            buffer.write("\"");
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhLinkContentMixMixed value = (IFhLinkContentMixMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhLinkContentMixMixed value = (IFhLinkContentMixMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</jump>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<jump");
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
        if (href_ != null) {
            buffer.print(" href=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getHref())));
            buffer.print("\"");
        }
        if (role_ != null) {
            buffer.print(" role=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getRole())));
            buffer.print("\"");
        }
        if (title_ != null) {
            buffer.print(" title=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getTitle())));
            buffer.print("\"");
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhLinkContentMixMixed value = (IFhLinkContentMixMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhLinkContentMixMixed value = (IFhLinkContentMixMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</jump>");
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
    public String getHrefAsString() {
        return (URelaxer.getString(getHref()));
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
    public String getTitleAsString() {
        return (URelaxer.getString(getTitle()));
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
    public void setHrefByString(String string) {
        setHref(string);
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
    public void setTitleByString(String string) {
        setTitle(string);
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
     * for the <code>FhJump</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "jump")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "href")) {
            return (false);
        }
        $match$ = true;
        if (RString.isMatch(target)) {
            $match$ = true;
        }
        while (true) {
            if (FhStrong.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhEm.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhCode.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhSub.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhSup.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhBr.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhImg.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhIcon.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhAcronym.isMatchHungry(target)) {
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
     * is valid for the <code>FhJump</code>.
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
     * is valid for the <code>FhJump</code>.
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
