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
package org.relaxer.vocabulary.forrest_0_5.document_v12;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>FdBody</b> is generated from document_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="body">
 *             <ref name="body.attlist"/>
 *             <oneOrMore>
 *                 <choice>
 *                     <ref name="sections"/>
 *                     <ref name="blocks"/>
 *                 </choice>
 *             </oneOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="body"&gt;
 *             &lt;ref name="body.attlist"/&gt;
 *             &lt;oneOrMore&gt;
 *                 &lt;choice&gt;
 *                     &lt;ref name="sections"/&gt;
 *                     &lt;ref name="blocks"/&gt;
 *                 &lt;/choice&gt;
 *             &lt;/oneOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version document_v12.rng (Wed Mar 03 11:10:57 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FdBody implements java.io.Serializable, Cloneable {
    private String id_;
    private String xmlLang_;
    // List<IFdBodyChoice>
    private java.util.List content_ = new java.util.ArrayList();

    /**
     * Creates a <code>FdBody</code>.
     *
     */
    public FdBody() {
    }

    /**
     * Creates a <code>FdBody</code>.
     *
     * @param source
     */
    public FdBody(FdBody source) {
        setup(source);
    }

    /**
     * Creates a <code>FdBody</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FdBody(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FdBody</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FdBody(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FdBody</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FdBody(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FdBody</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FdBody(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FdBody</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FdBody(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FdBody</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FdBody(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FdBody</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FdBody(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FdBody</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FdBody(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FdBody</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FdBody(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FdBody</code> by the FdBody <code>source</code>.
     *
     * @param source
     */
    public void setup(FdBody source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((IFdBodyChoice)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>FdBody</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FdBody</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FdBody</code> by the Stack <code>stack</code>
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
        content_.clear();
        while (true) {
            if (FdFigure.isMatch(stack)) {
                addContent(new FdFigure(stack));
            } else if (FdOl.isMatch(stack)) {
                addContent(new FdOl(stack));
            } else if (FdUl.isMatch(stack)) {
                addContent(new FdUl(stack));
            } else if (FdP.isMatch(stack)) {
                addContent(new FdP(stack));
            } else if (FdNote.isMatch(stack)) {
                addContent(new FdNote(stack));
            } else if (FdWarning.isMatch(stack)) {
                addContent(new FdWarning(stack));
            } else if (FdFixme.isMatch(stack)) {
                addContent(new FdFixme(stack));
            } else if (FdSection.isMatch(stack)) {
                addContent(new FdSection(stack));
            } else if (FdTable.isMatch(stack)) {
                addContent(new FdTable(stack));
            } else if (FdDl.isMatch(stack)) {
                addContent(new FdDl(stack));
            } else if (FdAnchor.isMatch(stack)) {
                addContent(new FdAnchor(stack));
            } else if (FdSource.isMatch(stack)) {
                addContent(new FdSource(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FdBody(this));
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
        Element element = doc.createElement("body");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFdBodyChoice value = (IFdBodyChoice)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FdBody</code> by the File <code>file</code>.
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
     * Initializes the <code>FdBody</code>
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
     * Initializes the <code>FdBody</code> by the URL <code>url</code>.
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
     * Initializes the <code>FdBody</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FdBody</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FdBody</code> by the Reader <code>reader</code>.
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
     * Gets the IFdBodyChoice property <b>content</b>.
     *
     * @return IFdBodyChoice[]
     */
    public IFdBodyChoice[] getContent() {
        IFdBodyChoice[] array = new IFdBodyChoice[content_.size()];
        return ((IFdBodyChoice[])content_.toArray(array));
    }

    /**
     * Sets the IFdBodyChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFdBodyChoice[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Sets the IFdBodyChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFdBodyChoice content) {
        this.content_.clear();
        addContent(content);
    }

    /**
     * Adds the IFdBodyChoice property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFdBodyChoice content) {
        this.content_.add(content);
    }

    /**
     * Adds the IFdBodyChoice property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFdBodyChoice[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Gets number of the IFdBodyChoice property <b>content</b>.
     *
     * @return int
     */
    public int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the IFdBodyChoice property <b>content</b> by index.
     *
     * @param index
     * @return IFdBodyChoice
     */
    public IFdBodyChoice getContent(int index) {
        return ((IFdBodyChoice)content_.get(index));
    }

    /**
     * Sets the IFdBodyChoice property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void setContent(int index, IFdBodyChoice content) {
        this.content_.set(index, content);
    }

    /**
     * Adds the IFdBodyChoice property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void addContent(int index, IFdBodyChoice content) {
        this.content_.add(index, content);
    }

    /**
     * Remove the IFdBodyChoice property <b>content</b> by index.
     *
     * @param index
     */
    public void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the IFdBodyChoice property <b>content</b> by object.
     *
     * @param content
     */
    public void removeContent(IFdBodyChoice content) {
        this.content_.remove(content);
    }

    /**
     * Clear the IFdBodyChoice property <b>content</b>.
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
        buffer.append("<body");
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
            IFdBodyChoice value = (IFdBodyChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFdBodyChoice value = (IFdBodyChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</body>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<body");
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
            IFdBodyChoice value = (IFdBodyChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFdBodyChoice value = (IFdBodyChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</body>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<body");
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
            IFdBodyChoice value = (IFdBodyChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFdBodyChoice value = (IFdBodyChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</body>");
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
     * for the <code>FdBody</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "body")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (FdFigure.isMatchHungry(target)) {
            $match$ = true;
        } else if (FdOl.isMatchHungry(target)) {
            $match$ = true;
        } else if (FdUl.isMatchHungry(target)) {
            $match$ = true;
        } else if (FdP.isMatchHungry(target)) {
            $match$ = true;
        } else if (FdNote.isMatchHungry(target)) {
            $match$ = true;
        } else if (FdWarning.isMatchHungry(target)) {
            $match$ = true;
        } else if (FdFixme.isMatchHungry(target)) {
            $match$ = true;
        } else if (FdSection.isMatchHungry(target)) {
            $match$ = true;
        } else if (FdTable.isMatchHungry(target)) {
            $match$ = true;
        } else if (FdDl.isMatchHungry(target)) {
            $match$ = true;
        } else if (FdAnchor.isMatchHungry(target)) {
            $match$ = true;
        } else if (FdSource.isMatchHungry(target)) {
            $match$ = true;
        } else {
            return (false);
        }
        while (true) {
            if (FdFigure.isMatchHungry(target)) {
                $match$ = true;
            } else if (FdOl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FdUl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FdP.isMatchHungry(target)) {
                $match$ = true;
            } else if (FdNote.isMatchHungry(target)) {
                $match$ = true;
            } else if (FdWarning.isMatchHungry(target)) {
                $match$ = true;
            } else if (FdFixme.isMatchHungry(target)) {
                $match$ = true;
            } else if (FdSection.isMatchHungry(target)) {
                $match$ = true;
            } else if (FdTable.isMatchHungry(target)) {
                $match$ = true;
            } else if (FdDl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FdAnchor.isMatchHungry(target)) {
                $match$ = true;
            } else if (FdSource.isMatchHungry(target)) {
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
     * is valid for the <code>FdBody</code>.
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
     * is valid for the <code>FdBody</code>.
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
