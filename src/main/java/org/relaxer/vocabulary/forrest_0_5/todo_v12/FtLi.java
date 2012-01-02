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
 * <b>FtLi</b> is generated from todo_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="li">
 *             <ref name="li.attlist"/>
 *             <zeroOrMore>
 *                 <ref name="flow"/>
 *             </zeroOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="li"&gt;
 *             &lt;ref name="li.attlist"/&gt;
 *             &lt;zeroOrMore&gt;
 *                 &lt;ref name="flow"/&gt;
 *             &lt;/zeroOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version todo_v12.rng (Wed Mar 03 11:15:51 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FtLi implements java.io.Serializable, Cloneable, IFtOlChoice, IFtUlChoice {
    private String id_;
    private String xmlLang_;
    // List<IFtFlowMixed>
    private java.util.List content_ = new java.util.ArrayList();

    /**
     * Creates a <code>FtLi</code>.
     *
     */
    public FtLi() {
    }

    /**
     * Creates a <code>FtLi</code>.
     *
     * @param source
     */
    public FtLi(FtLi source) {
        setup(source);
    }

    /**
     * Creates a <code>FtLi</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FtLi(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FtLi</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FtLi(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FtLi</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FtLi(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FtLi</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtLi(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FtLi</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtLi(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FtLi</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtLi(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FtLi</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtLi(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FtLi</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtLi(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FtLi</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtLi(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FtLi</code> by the FtLi <code>source</code>.
     *
     * @param source
     */
    public void setup(FtLi source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((IFtFlowMixed)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>FtLi</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FtLi</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FtLi</code> by the Stack <code>stack</code>
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
            } else if (FtFigure.isMatch(stack)) {
                addContent(new FtFigure(stack));
            } else if (FtImg.isMatch(stack)) {
                addContent(new FtImg(stack));
            } else if (FtLink.isMatch(stack)) {
                addContent(new FtLink(stack));
            } else if (FtJump.isMatch(stack)) {
                addContent(new FtJump(stack));
            } else if (FtIcon.isMatch(stack)) {
                addContent(new FtIcon(stack));
            } else if (FtFork.isMatch(stack)) {
                addContent(new FtFork(stack));
            } else if (FtP.isMatch(stack)) {
                addContent(new FtP(stack));
            } else if (FtSource.isMatch(stack)) {
                addContent(new FtSource(stack));
            } else if (FtNote.isMatch(stack)) {
                addContent(new FtNote(stack));
            } else if (FtWarning.isMatch(stack)) {
                addContent(new FtWarning(stack));
            } else if (FtFixme.isMatch(stack)) {
                addContent(new FtFixme(stack));
            } else if (FtTable.isMatch(stack)) {
                addContent(new FtTable(stack));
            } else if (FtUl.isMatch(stack)) {
                addContent(new FtUl(stack));
            } else if (FtOl.isMatch(stack)) {
                addContent(new FtOl(stack));
            } else if (FtAcronym.isMatch(stack)) {
                addContent(new FtAcronym(stack));
            } else if (FtStrong.isMatch(stack)) {
                addContent(new FtStrong(stack));
            } else if (FtEm.isMatch(stack)) {
                addContent(new FtEm(stack));
            } else if (FtDl.isMatch(stack)) {
                addContent(new FtDl(stack));
            } else if (FtCode.isMatch(stack)) {
                addContent(new FtCode(stack));
            } else if (FtSub.isMatch(stack)) {
                addContent(new FtSub(stack));
            } else if (FtSup.isMatch(stack)) {
                addContent(new FtSup(stack));
            } else if (FtBr.isMatch(stack)) {
                addContent(new FtBr(stack));
            } else if (FtAnchor.isMatch(stack)) {
                addContent(new FtAnchor(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FtLi(this));
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
        Element element = doc.createElement("li");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFtFlowMixed value = (IFtFlowMixed)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FtLi</code> by the File <code>file</code>.
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
     * Initializes the <code>FtLi</code>
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
     * Initializes the <code>FtLi</code> by the URL <code>url</code>.
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
     * Initializes the <code>FtLi</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FtLi</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FtLi</code> by the Reader <code>reader</code>.
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
     * Gets the IFtFlowMixed property <b>content</b>.
     *
     * @return IFtFlowMixed[]
     */
    public IFtFlowMixed[] getContent() {
        IFtFlowMixed[] array = new IFtFlowMixed[content_.size()];
        return ((IFtFlowMixed[])content_.toArray(array));
    }

    /**
     * Sets the IFtFlowMixed property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFtFlowMixed[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Sets the IFtFlowMixed property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFtFlowMixed content) {
        this.content_.clear();
        addContent(content);
    }

    /**
     * Adds the IFtFlowMixed property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFtFlowMixed content) {
        this.content_.add(content);
    }

    /**
     * Adds the IFtFlowMixed property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFtFlowMixed[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Gets number of the IFtFlowMixed property <b>content</b>.
     *
     * @return int
     */
    public int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the IFtFlowMixed property <b>content</b> by index.
     *
     * @param index
     * @return IFtFlowMixed
     */
    public IFtFlowMixed getContent(int index) {
        return ((IFtFlowMixed)content_.get(index));
    }

    /**
     * Sets the IFtFlowMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void setContent(int index, IFtFlowMixed content) {
        this.content_.set(index, content);
    }

    /**
     * Adds the IFtFlowMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void addContent(int index, IFtFlowMixed content) {
        this.content_.add(index, content);
    }

    /**
     * Remove the IFtFlowMixed property <b>content</b> by index.
     *
     * @param index
     */
    public void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the IFtFlowMixed property <b>content</b> by object.
     *
     * @param content
     */
    public void removeContent(IFtFlowMixed content) {
        this.content_.remove(content);
    }

    /**
     * Clear the IFtFlowMixed property <b>content</b>.
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
        buffer.append("<li");
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
            IFtFlowMixed value = (IFtFlowMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFtFlowMixed value = (IFtFlowMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</li>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<li");
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
            IFtFlowMixed value = (IFtFlowMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFtFlowMixed value = (IFtFlowMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</li>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<li");
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
            IFtFlowMixed value = (IFtFlowMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFtFlowMixed value = (IFtFlowMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</li>");
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
     * for the <code>FtLi</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "li")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (RString.isMatch(target)) {
            $match$ = true;
        }
        while (true) {
            if (FtFigure.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtImg.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtLink.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtJump.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtIcon.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtFork.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtP.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtSource.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtNote.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtWarning.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtFixme.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtTable.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtUl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtOl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtAcronym.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtStrong.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtEm.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtDl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtCode.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtSub.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtSup.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtBr.isMatchHungry(target)) {
                $match$ = true;
            } else if (FtAnchor.isMatchHungry(target)) {
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
     * is valid for the <code>FtLi</code>.
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
     * is valid for the <code>FtLi</code>.
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
