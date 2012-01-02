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
 * <b>FfOl</b> is generated from faq_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="ol">
 *             <ref name="ol.attlist"/>
 *             <oneOrMore>
 *                 <choice>
 *                     <ref name="li"/>
 *                     <ref name="lists"/>
 *                 </choice>
 *             </oneOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="ol"&gt;
 *             &lt;ref name="ol.attlist"/&gt;
 *             &lt;oneOrMore&gt;
 *                 &lt;choice&gt;
 *                     &lt;ref name="li"/&gt;
 *                     &lt;ref name="lists"/&gt;
 *                 &lt;/choice&gt;
 *             &lt;/oneOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version faq_v12.rng (Wed Mar 03 11:15:15 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FfOl implements java.io.Serializable, Cloneable, IFfOlChoice, IFfFlowMixed, IFfFlowMixedChoice, IFfUlChoice, IFfBodyChoice, IFfSectionChoice {
    public static final String SPACING_NORMAL = "normal";
    public static final String SPACING_COMPACT = "compact";

    private String id_;
    private String xmlLang_;
    private String spacing_;
    // List<IFfOlChoice>
    private java.util.List content_ = new java.util.ArrayList();

    /**
     * Creates a <code>FfOl</code>.
     *
     */
    public FfOl() {
    }

    /**
     * Creates a <code>FfOl</code>.
     *
     * @param source
     */
    public FfOl(FfOl source) {
        setup(source);
    }

    /**
     * Creates a <code>FfOl</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FfOl(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FfOl</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FfOl(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FfOl</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FfOl(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FfOl</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfOl(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FfOl</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfOl(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FfOl</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfOl(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FfOl</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfOl(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FfOl</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfOl(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FfOl</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfOl(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FfOl</code> by the FfOl <code>source</code>.
     *
     * @param source
     */
    public void setup(FfOl source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        setSpacing(source.getSpacing());
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((IFfOlChoice)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>FfOl</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FfOl</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FfOl</code> by the Stack <code>stack</code>
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
        spacing_ = URelaxer.getAttributePropertyAsString(element, "spacing");
        content_.clear();
        while (true) {
            if (FfUl.isMatch(stack)) {
                addContent(new FfUl(stack));
            } else if (FfOl.isMatch(stack)) {
                addContent(new FfOl(stack));
            } else if (FfLi.isMatch(stack)) {
                addContent(new FfLi(stack));
            } else if (FfDl.isMatch(stack)) {
                addContent(new FfDl(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FfOl(this));
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
        Element element = doc.createElement("ol");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        if (this.spacing_ != null) {
            URelaxer.setAttributePropertyByString(element, "spacing", this.spacing_);
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFfOlChoice value = (IFfOlChoice)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FfOl</code> by the File <code>file</code>.
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
     * Initializes the <code>FfOl</code>
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
     * Initializes the <code>FfOl</code> by the URL <code>url</code>.
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
     * Initializes the <code>FfOl</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FfOl</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FfOl</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>spacing</b>.
     *
     * @return String
     */
    public String getSpacing() {
        return (spacing_);
    }

    /**
     * Sets the String property <b>spacing</b>.
     *
     * @param spacing
     */
    public void setSpacing(String spacing) {
        this.spacing_ = spacing;
    }

    /**
     * Gets the IFfOlChoice property <b>content</b>.
     *
     * @return IFfOlChoice[]
     */
    public IFfOlChoice[] getContent() {
        IFfOlChoice[] array = new IFfOlChoice[content_.size()];
        return ((IFfOlChoice[])content_.toArray(array));
    }

    /**
     * Sets the IFfOlChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFfOlChoice[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Sets the IFfOlChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFfOlChoice content) {
        this.content_.clear();
        addContent(content);
    }

    /**
     * Adds the IFfOlChoice property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFfOlChoice content) {
        this.content_.add(content);
    }

    /**
     * Adds the IFfOlChoice property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFfOlChoice[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Gets number of the IFfOlChoice property <b>content</b>.
     *
     * @return int
     */
    public int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the IFfOlChoice property <b>content</b> by index.
     *
     * @param index
     * @return IFfOlChoice
     */
    public IFfOlChoice getContent(int index) {
        return ((IFfOlChoice)content_.get(index));
    }

    /**
     * Sets the IFfOlChoice property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void setContent(int index, IFfOlChoice content) {
        this.content_.set(index, content);
    }

    /**
     * Adds the IFfOlChoice property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void addContent(int index, IFfOlChoice content) {
        this.content_.add(index, content);
    }

    /**
     * Remove the IFfOlChoice property <b>content</b> by index.
     *
     * @param index
     */
    public void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the IFfOlChoice property <b>content</b> by object.
     *
     * @param content
     */
    public void removeContent(IFfOlChoice content) {
        this.content_.remove(content);
    }

    /**
     * Clear the IFfOlChoice property <b>content</b>.
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
        buffer.append("<ol");
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
        if (spacing_ != null) {
            buffer.append(" spacing=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getSpacing())));
            buffer.append("\"");
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFfOlChoice value = (IFfOlChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFfOlChoice value = (IFfOlChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</ol>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<ol");
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
        if (spacing_ != null) {
            buffer.write(" spacing=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getSpacing())));
            buffer.write("\"");
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFfOlChoice value = (IFfOlChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFfOlChoice value = (IFfOlChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</ol>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<ol");
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
        if (spacing_ != null) {
            buffer.print(" spacing=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getSpacing())));
            buffer.print("\"");
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFfOlChoice value = (IFfOlChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFfOlChoice value = (IFfOlChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</ol>");
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
    public String getSpacingAsString() {
        return (URelaxer.getString(getSpacing()));
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
    public void setSpacingByString(String string) {
        setSpacing(string);
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
     * for the <code>FfOl</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "ol")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (FfUl.isMatchHungry(target)) {
            $match$ = true;
        } else if (FfOl.isMatchHungry(target)) {
            $match$ = true;
        } else if (FfLi.isMatchHungry(target)) {
            $match$ = true;
        } else if (FfDl.isMatchHungry(target)) {
            $match$ = true;
        } else {
            return (false);
        }
        while (true) {
            if (FfUl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfOl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfLi.isMatchHungry(target)) {
                $match$ = true;
            } else if (FfDl.isMatchHungry(target)) {
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
     * is valid for the <code>FfOl</code>.
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
     * is valid for the <code>FfOl</code>.
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
