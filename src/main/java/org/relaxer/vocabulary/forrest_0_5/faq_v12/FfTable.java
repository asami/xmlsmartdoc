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
 * <b>FfTable</b> is generated from faq_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="table">
 *             <ref name="table.attlist"/>
 *             <optional>
 *                 <ref name="caption"/>
 *             </optional>
 *             <oneOrMore>
 *                 <ref name="tr"/>
 *             </oneOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="table"&gt;
 *             &lt;ref name="table.attlist"/&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="caption"/&gt;
 *             &lt;/optional&gt;
 *             &lt;oneOrMore&gt;
 *                 &lt;ref name="tr"/&gt;
 *             &lt;/oneOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version faq_v12.rng (Wed Mar 03 11:15:15 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FfTable implements java.io.Serializable, Cloneable, IFfFlowMixed, IFfFlowMixedChoice, IFfSectionChoice, IFfBodyChoice {
    private String id_;
    private String xmlLang_;
    private FfCaption caption_;
    // List<FfTr>
    private java.util.List tr_ = new java.util.ArrayList();

    /**
     * Creates a <code>FfTable</code>.
     *
     */
    public FfTable() {
    }

    /**
     * Creates a <code>FfTable</code>.
     *
     * @param source
     */
    public FfTable(FfTable source) {
        setup(source);
    }

    /**
     * Creates a <code>FfTable</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FfTable(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FfTable</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FfTable(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FfTable</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FfTable(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FfTable</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfTable(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FfTable</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfTable(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FfTable</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfTable(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FfTable</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfTable(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FfTable</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfTable(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FfTable</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfTable(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FfTable</code> by the FfTable <code>source</code>.
     *
     * @param source
     */
    public void setup(FfTable source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        if (source.caption_ != null) {
            setCaption((FfCaption)source.getCaption().clone());
        }
        this.tr_.clear();
        size = source.tr_.size();
        for (int i = 0;i < size;i++) {
            addTr((FfTr)source.getTr(i).clone());
        }
    }

    /**
     * Initializes the <code>FfTable</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FfTable</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FfTable</code> by the Stack <code>stack</code>
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
        if (FfCaption.isMatch(stack)) {
            setCaption(new FfCaption(stack));
        }
        tr_.clear();
        while (true) {
            if (FfTr.isMatch(stack)) {
                addTr(new FfTr(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FfTable(this));
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
        Element element = doc.createElement("table");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        if (this.caption_ != null) {
            this.caption_.makeElement(element);
        }
        size = this.tr_.size();
        for (int i = 0;i < size;i++) {
            FfTr value = (FfTr)this.tr_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FfTable</code> by the File <code>file</code>.
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
     * Initializes the <code>FfTable</code>
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
     * Initializes the <code>FfTable</code> by the URL <code>url</code>.
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
     * Initializes the <code>FfTable</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FfTable</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FfTable</code> by the Reader <code>reader</code>.
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
     * Gets the FfCaption property <b>caption</b>.
     *
     * @return FfCaption
     */
    public FfCaption getCaption() {
        return (caption_);
    }

    /**
     * Sets the FfCaption property <b>caption</b>.
     *
     * @param caption
     */
    public void setCaption(FfCaption caption) {
        this.caption_ = caption;
    }

    /**
     * Gets the FfTr property <b>tr</b>.
     *
     * @return FfTr[]
     */
    public FfTr[] getTr() {
        FfTr[] array = new FfTr[tr_.size()];
        return ((FfTr[])tr_.toArray(array));
    }

    /**
     * Sets the FfTr property <b>tr</b>.
     *
     * @param tr
     */
    public void setTr(FfTr[] tr) {
        this.tr_.clear();
        for (int i = 0;i < tr.length;i++) {
            addTr(tr[i]);
        }
    }

    /**
     * Sets the FfTr property <b>tr</b>.
     *
     * @param tr
     */
    public void setTr(FfTr tr) {
        this.tr_.clear();
        addTr(tr);
    }

    /**
     * Adds the FfTr property <b>tr</b>.
     *
     * @param tr
     */
    public void addTr(FfTr tr) {
        this.tr_.add(tr);
    }

    /**
     * Adds the FfTr property <b>tr</b>.
     *
     * @param tr
     */
    public void addTr(FfTr[] tr) {
        for (int i = 0;i < tr.length;i++) {
            addTr(tr[i]);
        }
    }

    /**
     * Gets number of the FfTr property <b>tr</b>.
     *
     * @return int
     */
    public int sizeTr() {
        return (tr_.size());
    }

    /**
     * Gets the FfTr property <b>tr</b> by index.
     *
     * @param index
     * @return FfTr
     */
    public FfTr getTr(int index) {
        return ((FfTr)tr_.get(index));
    }

    /**
     * Sets the FfTr property <b>tr</b> by index.
     *
     * @param index
     * @param tr
     */
    public void setTr(int index, FfTr tr) {
        this.tr_.set(index, tr);
    }

    /**
     * Adds the FfTr property <b>tr</b> by index.
     *
     * @param index
     * @param tr
     */
    public void addTr(int index, FfTr tr) {
        this.tr_.add(index, tr);
    }

    /**
     * Remove the FfTr property <b>tr</b> by index.
     *
     * @param index
     */
    public void removeTr(int index) {
        this.tr_.remove(index);
    }

    /**
     * Remove the FfTr property <b>tr</b> by object.
     *
     * @param tr
     */
    public void removeTr(FfTr tr) {
        this.tr_.remove(tr);
    }

    /**
     * Clear the FfTr property <b>tr</b>.
     *
     */
    public void clearTr() {
        this.tr_.clear();
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
        buffer.append("<table");
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
        buffer.append(">");
        if (caption_ != null) {
            caption_.makeTextElement(buffer);
        }
        size = this.tr_.size();
        for (int i = 0;i < size;i++) {
            FfTr value = (FfTr)this.tr_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</table>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<table");
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
        buffer.write(">");
        if (caption_ != null) {
            caption_.makeTextElement(buffer);
        }
        size = this.tr_.size();
        for (int i = 0;i < size;i++) {
            FfTr value = (FfTr)this.tr_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</table>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<table");
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
        buffer.print(">");
        if (caption_ != null) {
            caption_.makeTextElement(buffer);
        }
        size = this.tr_.size();
        for (int i = 0;i < size;i++) {
            FfTr value = (FfTr)this.tr_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</table>");
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
     * for the <code>FfTable</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "table")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (FfCaption.isMatchHungry(target)) {
        }
        if (!FfTr.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!FfTr.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FfTable</code>.
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
     * is valid for the <code>FfTable</code>.
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
