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
package org.relaxer.vocabulary.forrest_0_5.changes_v12;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>FcBody</b> is generated from changes_v12.rng by Relaxer.
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
 * @version changes_v12.rng (Wed Mar 03 11:14:24 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FcBody implements java.io.Serializable, Cloneable {
    private String id_;
    private String xmlLang_;
    // List<IFcBodyChoice>
    private java.util.List content_ = new java.util.ArrayList();

    /**
     * Creates a <code>FcBody</code>.
     *
     */
    public FcBody() {
    }

    /**
     * Creates a <code>FcBody</code>.
     *
     * @param source
     */
    public FcBody(FcBody source) {
        setup(source);
    }

    /**
     * Creates a <code>FcBody</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FcBody(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FcBody</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FcBody(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FcBody</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FcBody(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FcBody</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcBody(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FcBody</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcBody(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FcBody</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcBody(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FcBody</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcBody(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FcBody</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcBody(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FcBody</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcBody(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FcBody</code> by the FcBody <code>source</code>.
     *
     * @param source
     */
    public void setup(FcBody source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((IFcBodyChoice)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>FcBody</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FcBody</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FcBody</code> by the Stack <code>stack</code>
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
            if (FcFigure.isMatch(stack)) {
                addContent(new FcFigure(stack));
            } else if (FcOl.isMatch(stack)) {
                addContent(new FcOl(stack));
            } else if (FcUl.isMatch(stack)) {
                addContent(new FcUl(stack));
            } else if (FcP.isMatch(stack)) {
                addContent(new FcP(stack));
            } else if (FcSource.isMatch(stack)) {
                addContent(new FcSource(stack));
            } else if (FcNote.isMatch(stack)) {
                addContent(new FcNote(stack));
            } else if (FcWarning.isMatch(stack)) {
                addContent(new FcWarning(stack));
            } else if (FcFixme.isMatch(stack)) {
                addContent(new FcFixme(stack));
            } else if (FcSection.isMatch(stack)) {
                addContent(new FcSection(stack));
            } else if (FcTable.isMatch(stack)) {
                addContent(new FcTable(stack));
            } else if (FcDl.isMatch(stack)) {
                addContent(new FcDl(stack));
            } else if (FcAnchor.isMatch(stack)) {
                addContent(new FcAnchor(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FcBody(this));
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
            IFcBodyChoice value = (IFcBodyChoice)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FcBody</code> by the File <code>file</code>.
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
     * Initializes the <code>FcBody</code>
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
     * Initializes the <code>FcBody</code> by the URL <code>url</code>.
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
     * Initializes the <code>FcBody</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FcBody</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FcBody</code> by the Reader <code>reader</code>.
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
     * Gets the IFcBodyChoice property <b>content</b>.
     *
     * @return IFcBodyChoice[]
     */
    public IFcBodyChoice[] getContent() {
        IFcBodyChoice[] array = new IFcBodyChoice[content_.size()];
        return ((IFcBodyChoice[])content_.toArray(array));
    }

    /**
     * Sets the IFcBodyChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFcBodyChoice[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Sets the IFcBodyChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFcBodyChoice content) {
        this.content_.clear();
        addContent(content);
    }

    /**
     * Adds the IFcBodyChoice property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFcBodyChoice content) {
        this.content_.add(content);
    }

    /**
     * Adds the IFcBodyChoice property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFcBodyChoice[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Gets number of the IFcBodyChoice property <b>content</b>.
     *
     * @return int
     */
    public int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the IFcBodyChoice property <b>content</b> by index.
     *
     * @param index
     * @return IFcBodyChoice
     */
    public IFcBodyChoice getContent(int index) {
        return ((IFcBodyChoice)content_.get(index));
    }

    /**
     * Sets the IFcBodyChoice property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void setContent(int index, IFcBodyChoice content) {
        this.content_.set(index, content);
    }

    /**
     * Adds the IFcBodyChoice property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void addContent(int index, IFcBodyChoice content) {
        this.content_.add(index, content);
    }

    /**
     * Remove the IFcBodyChoice property <b>content</b> by index.
     *
     * @param index
     */
    public void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the IFcBodyChoice property <b>content</b> by object.
     *
     * @param content
     */
    public void removeContent(IFcBodyChoice content) {
        this.content_.remove(content);
    }

    /**
     * Clear the IFcBodyChoice property <b>content</b>.
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
            IFcBodyChoice value = (IFcBodyChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFcBodyChoice value = (IFcBodyChoice)this.content_.get(i);
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
            IFcBodyChoice value = (IFcBodyChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFcBodyChoice value = (IFcBodyChoice)this.content_.get(i);
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
            IFcBodyChoice value = (IFcBodyChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFcBodyChoice value = (IFcBodyChoice)this.content_.get(i);
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
     * for the <code>FcBody</code>.
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
        if (FcFigure.isMatchHungry(target)) {
            $match$ = true;
        } else if (FcOl.isMatchHungry(target)) {
            $match$ = true;
        } else if (FcUl.isMatchHungry(target)) {
            $match$ = true;
        } else if (FcP.isMatchHungry(target)) {
            $match$ = true;
        } else if (FcSource.isMatchHungry(target)) {
            $match$ = true;
        } else if (FcNote.isMatchHungry(target)) {
            $match$ = true;
        } else if (FcWarning.isMatchHungry(target)) {
            $match$ = true;
        } else if (FcFixme.isMatchHungry(target)) {
            $match$ = true;
        } else if (FcSection.isMatchHungry(target)) {
            $match$ = true;
        } else if (FcTable.isMatchHungry(target)) {
            $match$ = true;
        } else if (FcDl.isMatchHungry(target)) {
            $match$ = true;
        } else if (FcAnchor.isMatchHungry(target)) {
            $match$ = true;
        } else {
            return (false);
        }
        while (true) {
            if (FcFigure.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcOl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcUl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcP.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcSource.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcNote.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcWarning.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcFixme.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcSection.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcTable.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcDl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcAnchor.isMatchHungry(target)) {
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
     * is valid for the <code>FcBody</code>.
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
     * is valid for the <code>FcBody</code>.
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
