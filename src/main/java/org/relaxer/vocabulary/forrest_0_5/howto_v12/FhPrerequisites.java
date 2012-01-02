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
 * <b>FhPrerequisites</b> is generated from howto_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="prerequisites">
 *             <ref name="prerequisites.attlist"/>
 *             <zeroOrMore>
 *                 <choice>
 *                     <ref name="section"/>
 *                     <ref name="blocks"/>
 *                 </choice>
 *             </zeroOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="prerequisites"&gt;
 *             &lt;ref name="prerequisites.attlist"/&gt;
 *             &lt;zeroOrMore&gt;
 *                 &lt;choice&gt;
 *                     &lt;ref name="section"/&gt;
 *                     &lt;ref name="blocks"/&gt;
 *                 &lt;/choice&gt;
 *             &lt;/zeroOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version howto_v12.rng (Wed Mar 03 11:15:34 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FhPrerequisites implements java.io.Serializable, Cloneable {
    private String title_;
    private String id_;
    private String xmlLang_;
    // List<IFhPrerequisitesChoice>
    private java.util.List content_ = new java.util.ArrayList();

    /**
     * Creates a <code>FhPrerequisites</code>.
     *
     */
    public FhPrerequisites() {
        title_ = "";
    }

    /**
     * Creates a <code>FhPrerequisites</code>.
     *
     * @param source
     */
    public FhPrerequisites(FhPrerequisites source) {
        setup(source);
    }

    /**
     * Creates a <code>FhPrerequisites</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FhPrerequisites(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FhPrerequisites</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FhPrerequisites(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FhPrerequisites</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FhPrerequisites(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FhPrerequisites</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhPrerequisites(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FhPrerequisites</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhPrerequisites(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FhPrerequisites</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhPrerequisites(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FhPrerequisites</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhPrerequisites(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FhPrerequisites</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhPrerequisites(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FhPrerequisites</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhPrerequisites(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FhPrerequisites</code> by the FhPrerequisites <code>source</code>.
     *
     * @param source
     */
    public void setup(FhPrerequisites source) {
        int size;
        setTitle(source.getTitle());
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((IFhPrerequisitesChoice)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>FhPrerequisites</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FhPrerequisites</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FhPrerequisites</code> by the Stack <code>stack</code>
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
        title_ = URelaxer.getAttributePropertyAsString(element, "title");
        id_ = URelaxer.getAttributePropertyAsString(element, "id");
        xmlLang_ = URelaxer.getAttributePropertyAsString(element, "xml:lang");
        content_.clear();
        while (true) {
            if (FhFigure.isMatch(stack)) {
                addContent(new FhFigure(stack));
            } else if (FhP.isMatch(stack)) {
                addContent(new FhP(stack));
            } else if (FhSource.isMatch(stack)) {
                addContent(new FhSource(stack));
            } else if (FhNote.isMatch(stack)) {
                addContent(new FhNote(stack));
            } else if (FhWarning.isMatch(stack)) {
                addContent(new FhWarning(stack));
            } else if (FhFixme.isMatch(stack)) {
                addContent(new FhFixme(stack));
            } else if (FhTable.isMatch(stack)) {
                addContent(new FhTable(stack));
            } else if (FhOl.isMatch(stack)) {
                addContent(new FhOl(stack));
            } else if (FhUl.isMatch(stack)) {
                addContent(new FhUl(stack));
            } else if (FhDl.isMatch(stack)) {
                addContent(new FhDl(stack));
            } else if (FhSection.isMatch(stack)) {
                addContent(new FhSection(stack));
            } else if (FhAnchor.isMatch(stack)) {
                addContent(new FhAnchor(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FhPrerequisites(this));
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
        Element element = doc.createElement("prerequisites");
        int size;
        if (this.title_ != null) {
            URelaxer.setAttributePropertyByString(element, "title", this.title_);
        }
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhPrerequisitesChoice value = (IFhPrerequisitesChoice)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FhPrerequisites</code> by the File <code>file</code>.
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
     * Initializes the <code>FhPrerequisites</code>
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
     * Initializes the <code>FhPrerequisites</code> by the URL <code>url</code>.
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
     * Initializes the <code>FhPrerequisites</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FhPrerequisites</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FhPrerequisites</code> by the Reader <code>reader</code>.
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
     * Gets the IFhPrerequisitesChoice property <b>content</b>.
     *
     * @return IFhPrerequisitesChoice[]
     */
    public IFhPrerequisitesChoice[] getContent() {
        IFhPrerequisitesChoice[] array = new IFhPrerequisitesChoice[content_.size()];
        return ((IFhPrerequisitesChoice[])content_.toArray(array));
    }

    /**
     * Sets the IFhPrerequisitesChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFhPrerequisitesChoice[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Sets the IFhPrerequisitesChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFhPrerequisitesChoice content) {
        this.content_.clear();
        addContent(content);
    }

    /**
     * Adds the IFhPrerequisitesChoice property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFhPrerequisitesChoice content) {
        this.content_.add(content);
    }

    /**
     * Adds the IFhPrerequisitesChoice property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFhPrerequisitesChoice[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Gets number of the IFhPrerequisitesChoice property <b>content</b>.
     *
     * @return int
     */
    public int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the IFhPrerequisitesChoice property <b>content</b> by index.
     *
     * @param index
     * @return IFhPrerequisitesChoice
     */
    public IFhPrerequisitesChoice getContent(int index) {
        return ((IFhPrerequisitesChoice)content_.get(index));
    }

    /**
     * Sets the IFhPrerequisitesChoice property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void setContent(int index, IFhPrerequisitesChoice content) {
        this.content_.set(index, content);
    }

    /**
     * Adds the IFhPrerequisitesChoice property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void addContent(int index, IFhPrerequisitesChoice content) {
        this.content_.add(index, content);
    }

    /**
     * Remove the IFhPrerequisitesChoice property <b>content</b> by index.
     *
     * @param index
     */
    public void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the IFhPrerequisitesChoice property <b>content</b> by object.
     *
     * @param content
     */
    public void removeContent(IFhPrerequisitesChoice content) {
        this.content_.remove(content);
    }

    /**
     * Clear the IFhPrerequisitesChoice property <b>content</b>.
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
        buffer.append("<prerequisites");
        if (title_ != null) {
            buffer.append(" title=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getTitle())));
            buffer.append("\"");
        }
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
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhPrerequisitesChoice value = (IFhPrerequisitesChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhPrerequisitesChoice value = (IFhPrerequisitesChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</prerequisites>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<prerequisites");
        if (title_ != null) {
            buffer.write(" title=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getTitle())));
            buffer.write("\"");
        }
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
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhPrerequisitesChoice value = (IFhPrerequisitesChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhPrerequisitesChoice value = (IFhPrerequisitesChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</prerequisites>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<prerequisites");
        if (title_ != null) {
            buffer.print(" title=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getTitle())));
            buffer.print("\"");
        }
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
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhPrerequisitesChoice value = (IFhPrerequisitesChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhPrerequisitesChoice value = (IFhPrerequisitesChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</prerequisites>");
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
    public String getTitleAsString() {
        return (URelaxer.getString(getTitle()));
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
    public void setTitleByString(String string) {
        setTitle(string);
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
     * for the <code>FhPrerequisites</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "prerequisites")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "title")) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (FhFigure.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhP.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhSource.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhNote.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhWarning.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhFixme.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhTable.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhOl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhUl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhDl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhSection.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhAnchor.isMatchHungry(target)) {
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
     * is valid for the <code>FhPrerequisites</code>.
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
     * is valid for the <code>FhPrerequisites</code>.
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
