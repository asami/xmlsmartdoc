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
 * <b>FhSection</b> is generated from howto_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="section">
 *             <ref name="section.attlist"/>
 *             <ref name="title"/>
 *             <zeroOrMore>
 *                 <choice>
 *                     <ref name="sections"/>
 *                     <ref name="blocks"/>
 *                 </choice>
 *             </zeroOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="section"&gt;
 *             &lt;ref name="section.attlist"/&gt;
 *             &lt;ref name="title"/&gt;
 *             &lt;zeroOrMore&gt;
 *                 &lt;choice&gt;
 *                     &lt;ref name="sections"/&gt;
 *                     &lt;ref name="blocks"/&gt;
 *                 &lt;/choice&gt;
 *             &lt;/zeroOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version howto_v12.rng (Wed Mar 03 11:15:34 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FhSection implements java.io.Serializable, Cloneable, IFhSectionChoice, IFhBodyChoice, IFhPrerequisitesChoice, IFhStepsChoice, IFhTipsChoice, IFhReferencesChoice {
    private String id_;
    private String xmlLang_;
    private FhTitle title_;
    // List<IFhSectionChoice>
    private java.util.List content_ = new java.util.ArrayList();

    /**
     * Creates a <code>FhSection</code>.
     *
     */
    public FhSection() {
    }

    /**
     * Creates a <code>FhSection</code>.
     *
     * @param source
     */
    public FhSection(FhSection source) {
        setup(source);
    }

    /**
     * Creates a <code>FhSection</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FhSection(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FhSection</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FhSection(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FhSection</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FhSection(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FhSection</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhSection(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FhSection</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhSection(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FhSection</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhSection(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FhSection</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhSection(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FhSection</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhSection(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FhSection</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhSection(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FhSection</code> by the FhSection <code>source</code>.
     *
     * @param source
     */
    public void setup(FhSection source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        if (source.title_ != null) {
            setTitle((FhTitle)source.getTitle().clone());
        }
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((IFhSectionChoice)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>FhSection</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FhSection</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FhSection</code> by the Stack <code>stack</code>
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
            } else if (FhSection.isMatch(stack)) {
                addContent(new FhSection(stack));
            } else if (FhDl.isMatch(stack)) {
                addContent(new FhDl(stack));
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
        return (new FhSection(this));
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
        Element element = doc.createElement("section");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        this.title_.makeElement(element);
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhSectionChoice value = (IFhSectionChoice)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FhSection</code> by the File <code>file</code>.
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
     * Initializes the <code>FhSection</code>
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
     * Initializes the <code>FhSection</code> by the URL <code>url</code>.
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
     * Initializes the <code>FhSection</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FhSection</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FhSection</code> by the Reader <code>reader</code>.
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
     * Gets the IFhSectionChoice property <b>content</b>.
     *
     * @return IFhSectionChoice[]
     */
    public IFhSectionChoice[] getContent() {
        IFhSectionChoice[] array = new IFhSectionChoice[content_.size()];
        return ((IFhSectionChoice[])content_.toArray(array));
    }

    /**
     * Sets the IFhSectionChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFhSectionChoice[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Sets the IFhSectionChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFhSectionChoice content) {
        this.content_.clear();
        addContent(content);
    }

    /**
     * Adds the IFhSectionChoice property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFhSectionChoice content) {
        this.content_.add(content);
    }

    /**
     * Adds the IFhSectionChoice property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFhSectionChoice[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Gets number of the IFhSectionChoice property <b>content</b>.
     *
     * @return int
     */
    public int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the IFhSectionChoice property <b>content</b> by index.
     *
     * @param index
     * @return IFhSectionChoice
     */
    public IFhSectionChoice getContent(int index) {
        return ((IFhSectionChoice)content_.get(index));
    }

    /**
     * Sets the IFhSectionChoice property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void setContent(int index, IFhSectionChoice content) {
        this.content_.set(index, content);
    }

    /**
     * Adds the IFhSectionChoice property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void addContent(int index, IFhSectionChoice content) {
        this.content_.add(index, content);
    }

    /**
     * Remove the IFhSectionChoice property <b>content</b> by index.
     *
     * @param index
     */
    public void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the IFhSectionChoice property <b>content</b> by object.
     *
     * @param content
     */
    public void removeContent(IFhSectionChoice content) {
        this.content_.remove(content);
    }

    /**
     * Clear the IFhSectionChoice property <b>content</b>.
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
        buffer.append("<section");
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
            IFhSectionChoice value = (IFhSectionChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        title_.makeTextElement(buffer);
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhSectionChoice value = (IFhSectionChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</section>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<section");
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
            IFhSectionChoice value = (IFhSectionChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        title_.makeTextElement(buffer);
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhSectionChoice value = (IFhSectionChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</section>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<section");
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
            IFhSectionChoice value = (IFhSectionChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        title_.makeTextElement(buffer);
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFhSectionChoice value = (IFhSectionChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</section>");
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
     * for the <code>FhSection</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "section")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!FhTitle.isMatchHungry(target)) {
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
            } else if (FhSection.isMatchHungry(target)) {
                $match$ = true;
            } else if (FhDl.isMatchHungry(target)) {
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
     * is valid for the <code>FhSection</code>.
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
     * is valid for the <code>FhSection</code>.
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
