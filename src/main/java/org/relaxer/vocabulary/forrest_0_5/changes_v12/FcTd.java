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
 * <b>FcTd</b> is generated from changes_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="td">
 *             <ref name="td.attlist"/>
 *             <zeroOrMore>
 *                 <ref name="flow"/>
 *             </zeroOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="td"&gt;
 *             &lt;ref name="td.attlist"/&gt;
 *             &lt;zeroOrMore&gt;
 *                 &lt;ref name="flow"/&gt;
 *             &lt;/zeroOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version changes_v12.rng (Wed Mar 03 11:14:25 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FcTd implements java.io.Serializable, Cloneable, IFcTrChoice {
    private String id_;
    private String xmlLang_;
    private String colspan_;
    private String rowspan_;
    // List<IFcFlowMixed>
    private java.util.List content_ = new java.util.ArrayList();

    /**
     * Creates a <code>FcTd</code>.
     *
     */
    public FcTd() {
    }

    /**
     * Creates a <code>FcTd</code>.
     *
     * @param source
     */
    public FcTd(FcTd source) {
        setup(source);
    }

    /**
     * Creates a <code>FcTd</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FcTd(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FcTd</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FcTd(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FcTd</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FcTd(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FcTd</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcTd(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FcTd</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcTd(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FcTd</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcTd(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FcTd</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcTd(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FcTd</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcTd(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FcTd</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcTd(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FcTd</code> by the FcTd <code>source</code>.
     *
     * @param source
     */
    public void setup(FcTd source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        setColspan(source.getColspan());
        setRowspan(source.getRowspan());
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((IFcFlowMixed)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>FcTd</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FcTd</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FcTd</code> by the Stack <code>stack</code>
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
        colspan_ = URelaxer.getAttributePropertyAsString(element, "colspan");
        rowspan_ = URelaxer.getAttributePropertyAsString(element, "rowspan");
        this.content_.clear();
        while (true) {
            if (RString.isMatch(stack)) {
                addContent(new RString(stack));
            } else if (FcFigure.isMatch(stack)) {
                addContent(new FcFigure(stack));
            } else if (FcImg.isMatch(stack)) {
                addContent(new FcImg(stack));
            } else if (FcIcon.isMatch(stack)) {
                addContent(new FcIcon(stack));
            } else if (FcLink.isMatch(stack)) {
                addContent(new FcLink(stack));
            } else if (FcJump.isMatch(stack)) {
                addContent(new FcJump(stack));
            } else if (FcFork.isMatch(stack)) {
                addContent(new FcFork(stack));
            } else if (FcP.isMatch(stack)) {
                addContent(new FcP(stack));
            } else if (FcSource.isMatch(stack)) {
                addContent(new FcSource(stack));
            } else if (FcNote.isMatch(stack)) {
                addContent(new FcNote(stack));
            } else if (FcWarning.isMatch(stack)) {
                addContent(new FcWarning(stack));
            } else if (FcOl.isMatch(stack)) {
                addContent(new FcOl(stack));
            } else if (FcUl.isMatch(stack)) {
                addContent(new FcUl(stack));
            } else if (FcFixme.isMatch(stack)) {
                addContent(new FcFixme(stack));
            } else if (FcTable.isMatch(stack)) {
                addContent(new FcTable(stack));
            } else if (FcAcronym.isMatch(stack)) {
                addContent(new FcAcronym(stack));
            } else if (FcDl.isMatch(stack)) {
                addContent(new FcDl(stack));
            } else if (FcStrong.isMatch(stack)) {
                addContent(new FcStrong(stack));
            } else if (FcEm.isMatch(stack)) {
                addContent(new FcEm(stack));
            } else if (FcCode.isMatch(stack)) {
                addContent(new FcCode(stack));
            } else if (FcSub.isMatch(stack)) {
                addContent(new FcSub(stack));
            } else if (FcSup.isMatch(stack)) {
                addContent(new FcSup(stack));
            } else if (FcBr.isMatch(stack)) {
                addContent(new FcBr(stack));
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
        return (new FcTd(this));
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
        Element element = doc.createElement("td");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        if (this.colspan_ != null) {
            URelaxer.setAttributePropertyByString(element, "colspan", this.colspan_);
        }
        if (this.rowspan_ != null) {
            URelaxer.setAttributePropertyByString(element, "rowspan", this.rowspan_);
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFcFlowMixed value = (IFcFlowMixed)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FcTd</code> by the File <code>file</code>.
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
     * Initializes the <code>FcTd</code>
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
     * Initializes the <code>FcTd</code> by the URL <code>url</code>.
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
     * Initializes the <code>FcTd</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FcTd</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FcTd</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>colspan</b>.
     *
     * @return String
     */
    public String getColspan() {
        return (colspan_);
    }

    /**
     * Sets the String property <b>colspan</b>.
     *
     * @param colspan
     */
    public void setColspan(String colspan) {
        this.colspan_ = colspan;
    }

    /**
     * Gets the String property <b>rowspan</b>.
     *
     * @return String
     */
    public String getRowspan() {
        return (rowspan_);
    }

    /**
     * Sets the String property <b>rowspan</b>.
     *
     * @param rowspan
     */
    public void setRowspan(String rowspan) {
        this.rowspan_ = rowspan;
    }

    /**
     * Gets the IFcFlowMixed property <b>content</b>.
     *
     * @return IFcFlowMixed[]
     */
    public IFcFlowMixed[] getContent() {
        IFcFlowMixed[] array = new IFcFlowMixed[content_.size()];
        return ((IFcFlowMixed[])content_.toArray(array));
    }

    /**
     * Sets the IFcFlowMixed property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFcFlowMixed[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Sets the IFcFlowMixed property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IFcFlowMixed content) {
        this.content_.clear();
        addContent(content);
    }

    /**
     * Adds the IFcFlowMixed property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFcFlowMixed content) {
        this.content_.add(content);
    }

    /**
     * Adds the IFcFlowMixed property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IFcFlowMixed[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
    }

    /**
     * Gets number of the IFcFlowMixed property <b>content</b>.
     *
     * @return int
     */
    public int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the IFcFlowMixed property <b>content</b> by index.
     *
     * @param index
     * @return IFcFlowMixed
     */
    public IFcFlowMixed getContent(int index) {
        return ((IFcFlowMixed)content_.get(index));
    }

    /**
     * Sets the IFcFlowMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void setContent(int index, IFcFlowMixed content) {
        this.content_.set(index, content);
    }

    /**
     * Adds the IFcFlowMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void addContent(int index, IFcFlowMixed content) {
        this.content_.add(index, content);
    }

    /**
     * Remove the IFcFlowMixed property <b>content</b> by index.
     *
     * @param index
     */
    public void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the IFcFlowMixed property <b>content</b> by object.
     *
     * @param content
     */
    public void removeContent(IFcFlowMixed content) {
        this.content_.remove(content);
    }

    /**
     * Clear the IFcFlowMixed property <b>content</b>.
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
        buffer.append("<td");
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
        if (colspan_ != null) {
            buffer.append(" colspan=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getColspan())));
            buffer.append("\"");
        }
        if (rowspan_ != null) {
            buffer.append(" rowspan=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getRowspan())));
            buffer.append("\"");
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFcFlowMixed value = (IFcFlowMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFcFlowMixed value = (IFcFlowMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</td>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<td");
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
        if (colspan_ != null) {
            buffer.write(" colspan=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getColspan())));
            buffer.write("\"");
        }
        if (rowspan_ != null) {
            buffer.write(" rowspan=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getRowspan())));
            buffer.write("\"");
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFcFlowMixed value = (IFcFlowMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFcFlowMixed value = (IFcFlowMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</td>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<td");
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
        if (colspan_ != null) {
            buffer.print(" colspan=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getColspan())));
            buffer.print("\"");
        }
        if (rowspan_ != null) {
            buffer.print(" rowspan=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getRowspan())));
            buffer.print("\"");
        }
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFcFlowMixed value = (IFcFlowMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IFcFlowMixed value = (IFcFlowMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</td>");
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
    public String getColspanAsString() {
        return (URelaxer.getString(getColspan()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getRowspanAsString() {
        return (URelaxer.getString(getRowspan()));
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
    public void setColspanByString(String string) {
        setColspan(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setRowspanByString(String string) {
        setRowspan(string);
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
     * for the <code>FcTd</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "td")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (RString.isMatch(target)) {
            $match$ = true;
        }
        while (true) {
            if (FcFigure.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcImg.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcIcon.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcLink.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcJump.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcFork.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcP.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcSource.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcNote.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcWarning.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcOl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcUl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcFixme.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcTable.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcAcronym.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcDl.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcStrong.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcEm.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcCode.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcSub.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcSup.isMatchHungry(target)) {
                $match$ = true;
            } else if (FcBr.isMatchHungry(target)) {
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
     * is valid for the <code>FcTd</code>.
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
     * is valid for the <code>FcTd</code>.
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
