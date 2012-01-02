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
package org.relaxer.vocabulary.forrest_0_5.faq_v12;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>FfDd</b> is generated from faq_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="dd">
 *             <ref name="dd.attlist"/>
 *             <zeroOrMore>
 *                 <ref name="flow"/>
 *             </zeroOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="dd"&gt;
 *             &lt;ref name="dd.attlist"/&gt;
 *             &lt;zeroOrMore&gt;
 *                 &lt;ref name="flow"/&gt;
 *             &lt;/zeroOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version faq_v12.rng (Wed Mar 03 11:15:15 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FfDd implements java.io.Serializable, Cloneable {
    private String id_;
    private String xmlLang_;
    // List<IFfFlowMixed>
    private java.util.List content_ = new java.util.ArrayList();

    /**
     * Creates a <code>FfDd</code>.
     *
     */
    public FfDd() {
    }

    /**
     * Creates a <code>FfDd</code>.
     *
     * @param source
     */
    public FfDd(FfDd source) {
        setup(source);
    }

    /**
     * Creates a <code>FfDd</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FfDd(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FfDd</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FfDd(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FfDd</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FfDd(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FfDd</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfDd(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FfDd</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfDd(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FfDd</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfDd(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FfDd</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfDd(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FfDd</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfDd(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FfDd</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfDd(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FfDd</code> by the FfDd <code>source</code>.
     *
     * @param source
     */
    public void setup(FfDd source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((IFfFlowMixed)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>FfDd</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FfDd</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FfDd</code> by the Stack <code>stack</code>
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
        this.content_.clear();
        while (true) {
            if (RString.isMatch(stack)) {
                addContent(new RString(stack));
            } else if (FfFigure.isMatch(stack)) {
                addContent(new FfFigure(stack));
            } else if (FfImg.isMatch(stack)) {
                addContent(new FfImg(stack));
            } else if (FfIcon.isMatch(stack)) {
                addContent(new FfIcon(stack));
            } else if (FfLink.isMatch(stack)) {
                addContent(new FfLink(stack));
            } else if (FfJump.isMatch(stack)) {
                addContent(new FfJump(stack));
            } else if (FfFork.isMatch(stack)) {
                addContent(new FfFork(stack));
            } else if (FfUl.isMatch(stack)) {
                addContent(new FfUl(stack));
            } else if (FfP.isMatch(stack)) {
                addContent(new FfP(stack));
            } else if (FfFixme.isMatch(stack)) {
                addContent(new FfFixme(stack));
            } else if (FfTable.isMatch(stack)) {
                addContent(new FfTable(stack));
            } else if (FfOl.isMatch(stack)) {
                addContent(new FfOl(stack));
            } else if (FfSource.isMatch(stack)) {
                addContent(new FfSource(stack));
            } else if (FfNote.isMatch(stack)) {
                addContent(new FfNote(stack));
            } else if (FfWarning.isMatch(stack)) {
                addContent(new FfWarning(stack));
            } else if (FfAcronym.isMatch(stack)) {
                addContent(new FfAcronym(stack));
            } else if (FfStrong.isMatch(stack)) {
                addContent(new FfStrong(stack));
            } else if (FfEm.isMatch(stack)) {
                addContent(new FfEm(stack));
            } else if (FfDl.isMatch(stack)) {
                addContent(new FfDl(stack));
            } else if (FfCode.isMatch(stack)) {
                addContent(new FfCode(stack));
            } else if (FfSub.isMatch(stack)) {
                addContent(new FfSub(stack));
            } else if (FfSup.isMatch(stack)) {
                addContent(new FfSup(stack));
            } else if (FfBr.isMatch(stack)) {
                addContent(new FfBr(stack));
            } else if (FfAnchor.isMatch(stack)) {
                addContent(new FfAnchor(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FfDd(this));
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
        Element element = doc.createElement("dd");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFfFlowMixed value = (IFfFlowMixed)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FfDd</code> by the File <code>file</code>.
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
     * Initializes the <code>FfDd</code>
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
     * Initializes the <code>FfDd</code> by the URL <code>url</code>.
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
     * Initializes the <code>FfDd</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FfDd</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FfDd</code> by the Reader <code>reader</code>.
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
     * Gets the IFfFlowMixed property <b>content</b>.
     *
     * @return IFfFlowMixed[]
     */
    public IFfFlowMixed[] getContent() {
        IFfFlowMixed[] array = new IFfFlowMixed[content_.size()];
        return ((IFfFlowMixed[])content_.toArray(array));
    }

    /**
     * Sets the IFfFlowMixed property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFfFlowMixed[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Sets the IFfFlowMixed property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFfFlowMixed content) {
        this.content_.clear();
        addContent(content);
    }

    /**
     * Adds the IFfFlowMixed property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFfFlowMixed content) {
        this.content_.add(content);
    }

    /**
     * Adds the IFfFlowMixed property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFfFlowMixed[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Gets number of the IFfFlowMixed property <b>content</b>.
     *
     * @return int
     */
    public int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the IFfFlowMixed property <b>content</b> by index.
     *
     * @param index
     * @return IFfFlowMixed
     */
    public IFfFlowMixed getContent(int index) {
        return ((IFfFlowMixed)content_.get(index));
    }

    /**
     * Sets the IFfFlowMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void setContent(int index, IFfFlowMixed content) {
        this.content_.set(index, content);
    }

    /**
     * Adds the IFfFlowMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void addContent(int index, IFfFlowMixed content) {
        this.content_.add(index, content);
    }

    /**
     * Remove the IFfFlowMixed property <b>content</b> by index.
     *
     * @param index
     */
    public void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the IFfFlowMixed property <b>content</b> by object.
     *
     * @param content
     */
    public void removeContent(IFfFlowMixed content) {
        this.content_.remove(content);
    }

    /**
     * Clear the IFfFlowMixed property <b>content</b>.
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
        buffer.append("<dd");
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
            IFfFlowMixed value = (IFfFlowMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFfFlowMixed value = (IFfFlowMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</dd>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<dd");
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
            IFfFlowMixed value = (IFfFlowMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFfFlowMixed value = (IFfFlowMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</dd>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<dd");
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
            IFfFlowMixed value = (IFfFlowMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFfFlowMixed value = (IFfFlowMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</dd>");
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
     * for the <code>FfDd</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "dd")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (RString.isMatch(target)) {
            $match$ = true;
        }
        while (true) {
            if (FfFigure.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfImg.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfIcon.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfLink.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfJump.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfFork.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfUl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfP.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfFixme.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfTable.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfOl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfSource.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfNote.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfWarning.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfAcronym.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfStrong.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfEm.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfDl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfCode.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfSub.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfSup.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfBr.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfAnchor.isMatchHungry(target)) {
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
     * is valid for the <code>FfDd</code>.
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
     * is valid for the <code>FfDd</code>.
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
