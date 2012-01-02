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
 * <b>FhFeedback</b> is generated from howto_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="feedback">
 *             <ref name="feedback.attlist"/>
 *             <zeroOrMore>
 *                 <ref name="blocks"/>
 *             </zeroOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="feedback"&gt;
 *             &lt;ref name="feedback.attlist"/&gt;
 *             &lt;zeroOrMore&gt;
 *                 &lt;ref name="blocks"/&gt;
 *             &lt;/zeroOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version howto_v12.rng (Wed Mar 03 11:15:34 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FhFeedback implements java.io.Serializable, Cloneable {
    private String title_;
    private String id_;
    private String xmlLang_;
    // List<IFhBlocksChoice>
    private java.util.List blocks_ = new java.util.ArrayList();

    /**
     * Creates a <code>FhFeedback</code>.
     *
     */
    public FhFeedback() {
        title_ = "";
    }

    /**
     * Creates a <code>FhFeedback</code>.
     *
     * @param source
     */
    public FhFeedback(FhFeedback source) {
        setup(source);
    }

    /**
     * Creates a <code>FhFeedback</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FhFeedback(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FhFeedback</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FhFeedback(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FhFeedback</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FhFeedback(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FhFeedback</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhFeedback(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FhFeedback</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhFeedback(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FhFeedback</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhFeedback(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FhFeedback</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhFeedback(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FhFeedback</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhFeedback(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FhFeedback</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhFeedback(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FhFeedback</code> by the FhFeedback <code>source</code>.
     *
     * @param source
     */
    public void setup(FhFeedback source) {
        int size;
        setTitle(source.getTitle());
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        this.blocks_.clear();
        size = source.blocks_.size();
        for (int i = 0;i < size;i++) {
            addBlocks((IFhBlocksChoice)source.getBlocks(i).clone());
        }
    }

    /**
     * Initializes the <code>FhFeedback</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FhFeedback</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FhFeedback</code> by the Stack <code>stack</code>
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
        blocks_.clear();
        while (true) {
            if (FhFigure.isMatch(stack)) {
                addBlocks(new FhFigure(stack));
            } else if (FhAnchor.isMatch(stack)) {
                addBlocks(new FhAnchor(stack));
            } else if (FhP.isMatch(stack)) {
                addBlocks(new FhP(stack));
            } else if (FhSource.isMatch(stack)) {
                addBlocks(new FhSource(stack));
            } else if (FhNote.isMatch(stack)) {
                addBlocks(new FhNote(stack));
            } else if (FhWarning.isMatch(stack)) {
                addBlocks(new FhWarning(stack));
            } else if (FhFixme.isMatch(stack)) {
                addBlocks(new FhFixme(stack));
            } else if (FhTable.isMatch(stack)) {
                addBlocks(new FhTable(stack));
            } else if (FhOl.isMatch(stack)) {
                addBlocks(new FhOl(stack));
            } else if (FhUl.isMatch(stack)) {
                addBlocks(new FhUl(stack));
            } else if (FhDl.isMatch(stack)) {
                addBlocks(new FhDl(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FhFeedback(this));
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
        Element element = doc.createElement("feedback");
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
        size = this.blocks_.size();
        for (int i = 0;i < size;i++) {
            IFhBlocksChoice value = (IFhBlocksChoice)this.blocks_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FhFeedback</code> by the File <code>file</code>.
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
     * Initializes the <code>FhFeedback</code>
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
     * Initializes the <code>FhFeedback</code> by the URL <code>url</code>.
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
     * Initializes the <code>FhFeedback</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FhFeedback</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FhFeedback</code> by the Reader <code>reader</code>.
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
     * Gets the IFhBlocksChoice property <b>blocks</b>.
     *
     * @return IFhBlocksChoice[]
     */
    public IFhBlocksChoice[] getBlocks() {
        IFhBlocksChoice[] array = new IFhBlocksChoice[blocks_.size()];
        return ((IFhBlocksChoice[])blocks_.toArray(array));
    }

    /**
     * Sets the IFhBlocksChoice property <b>blocks</b>.
     *
     * @param blocks
     */
    public void setBlocks(IFhBlocksChoice[] blocks) {
        this.blocks_.clear();
        for (int i = 0;i < blocks.length;i++) {
            addBlocks(blocks[i]);
        }
    }

    /**
     * Sets the IFhBlocksChoice property <b>blocks</b>.
     *
     * @param blocks
     */
    public void setBlocks(IFhBlocksChoice blocks) {
        this.blocks_.clear();
        addBlocks(blocks);
    }

    /**
     * Adds the IFhBlocksChoice property <b>blocks</b>.
     *
     * @param blocks
     */
    public void addBlocks(IFhBlocksChoice blocks) {
        this.blocks_.add(blocks);
    }

    /**
     * Adds the IFhBlocksChoice property <b>blocks</b>.
     *
     * @param blocks
     */
    public void addBlocks(IFhBlocksChoice[] blocks) {
        for (int i = 0;i < blocks.length;i++) {
            addBlocks(blocks[i]);
        }
    }

    /**
     * Gets number of the IFhBlocksChoice property <b>blocks</b>.
     *
     * @return int
     */
    public int sizeBlocks() {
        return (blocks_.size());
    }

    /**
     * Gets the IFhBlocksChoice property <b>blocks</b> by index.
     *
     * @param index
     * @return IFhBlocksChoice
     */
    public IFhBlocksChoice getBlocks(int index) {
        return ((IFhBlocksChoice)blocks_.get(index));
    }

    /**
     * Sets the IFhBlocksChoice property <b>blocks</b> by index.
     *
     * @param index
     * @param blocks
     */
    public void setBlocks(int index, IFhBlocksChoice blocks) {
        this.blocks_.set(index, blocks);
    }

    /**
     * Adds the IFhBlocksChoice property <b>blocks</b> by index.
     *
     * @param index
     * @param blocks
     */
    public void addBlocks(int index, IFhBlocksChoice blocks) {
        this.blocks_.add(index, blocks);
    }

    /**
     * Remove the IFhBlocksChoice property <b>blocks</b> by index.
     *
     * @param index
     */
    public void removeBlocks(int index) {
        this.blocks_.remove(index);
    }

    /**
     * Remove the IFhBlocksChoice property <b>blocks</b> by object.
     *
     * @param blocks
     */
    public void removeBlocks(IFhBlocksChoice blocks) {
        this.blocks_.remove(blocks);
    }

    /**
     * Clear the IFhBlocksChoice property <b>blocks</b>.
     *
     */
    public void clearBlocks() {
        this.blocks_.clear();
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
        buffer.append("<feedback");
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
        size = this.blocks_.size();
        for (int i = 0;i < size;i++) {
            IFhBlocksChoice value = (IFhBlocksChoice)this.blocks_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.blocks_.size();
        for (int i = 0;i < size;i++) {
            IFhBlocksChoice value = (IFhBlocksChoice)this.blocks_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</feedback>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<feedback");
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
        size = this.blocks_.size();
        for (int i = 0;i < size;i++) {
            IFhBlocksChoice value = (IFhBlocksChoice)this.blocks_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.blocks_.size();
        for (int i = 0;i < size;i++) {
            IFhBlocksChoice value = (IFhBlocksChoice)this.blocks_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</feedback>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<feedback");
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
        size = this.blocks_.size();
        for (int i = 0;i < size;i++) {
            IFhBlocksChoice value = (IFhBlocksChoice)this.blocks_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.blocks_.size();
        for (int i = 0;i < size;i++) {
            IFhBlocksChoice value = (IFhBlocksChoice)this.blocks_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</feedback>");
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
     * for the <code>FhFeedback</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "feedback")) {
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
            } else if (FhAnchor.isMatchHungry(target)) {
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
     * is valid for the <code>FhFeedback</code>.
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
     * is valid for the <code>FhFeedback</code>.
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
