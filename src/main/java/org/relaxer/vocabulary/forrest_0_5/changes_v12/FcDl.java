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
 * <b>FcDl</b> is generated from changes_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="dl">
 *             <ref name="dl.attlist"/>
 *             <oneOrMore>
 *                 <ref name="dt"/>
 *                 <ref name="dd"/>
 *             </oneOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="dl"&gt;
 *             &lt;ref name="dl.attlist"/&gt;
 *             &lt;oneOrMore&gt;
 *                 &lt;ref name="dt"/&gt;
 *                 &lt;ref name="dd"/&gt;
 *             &lt;/oneOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version changes_v12.rng (Wed Mar 03 11:14:25 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FcDl implements java.io.Serializable, Cloneable, IFcFlowMixed, IFcFlowMixedChoice, IFcUlChoice, IFcOlChoice, IFcSectionChoice, IFcBodyChoice {
    private String id_;
    private String xmlLang_;
    // List<FcDlSequence>
    private java.util.List dlSequence_ = new java.util.ArrayList();

    /**
     * Creates a <code>FcDl</code>.
     *
     */
    public FcDl() {
    }

    /**
     * Creates a <code>FcDl</code>.
     *
     * @param source
     */
    public FcDl(FcDl source) {
        setup(source);
    }

    /**
     * Creates a <code>FcDl</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FcDl(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FcDl</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FcDl(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FcDl</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FcDl(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FcDl</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcDl(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FcDl</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcDl(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FcDl</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcDl(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FcDl</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcDl(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FcDl</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcDl(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FcDl</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcDl(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FcDl</code> by the FcDl <code>source</code>.
     *
     * @param source
     */
    public void setup(FcDl source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        this.dlSequence_.clear();
        size = source.dlSequence_.size();
        for (int i = 0;i < size;i++) {
            addDlSequence((FcDlSequence)source.getDlSequence(i).clone());
        }
    }

    /**
     * Initializes the <code>FcDl</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FcDl</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FcDl</code> by the Stack <code>stack</code>
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
        dlSequence_.clear();
        while (true) {
            if (FcDlSequence.isMatch(stack)) {
                FcDlSequence node = new FcDlSequence(stack);
                addDlSequence(node);
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FcDl(this));
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
        Element element = doc.createElement("dl");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        size = this.dlSequence_.size();
        for (int i = 0;i < size;i++) {
            FcDlSequence value = (FcDlSequence)this.dlSequence_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FcDl</code> by the File <code>file</code>.
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
     * Initializes the <code>FcDl</code>
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
     * Initializes the <code>FcDl</code> by the URL <code>url</code>.
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
     * Initializes the <code>FcDl</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FcDl</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FcDl</code> by the Reader <code>reader</code>.
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
     * Gets the FcDlSequence property <b>dlSequence</b>.
     *
     * @return FcDlSequence[]
     */
    public FcDlSequence[] getDlSequence() {
        FcDlSequence[] array = new FcDlSequence[dlSequence_.size()];
        return ((FcDlSequence[])dlSequence_.toArray(array));
    }

    /**
     * Sets the FcDlSequence property <b>dlSequence</b>.
     *
     * @param dlSequence
     */
    public void setDlSequence(FcDlSequence[] dlSequence) {
        this.dlSequence_.clear();
        for (int i = 0;i < dlSequence.length;i++) {
            addDlSequence(dlSequence[i]);
        }
    }

    /**
     * Sets the FcDlSequence property <b>dlSequence</b>.
     *
     * @param dlSequence
     */
    public void setDlSequence(FcDlSequence dlSequence) {
        this.dlSequence_.clear();
        addDlSequence(dlSequence);
    }

    /**
     * Adds the FcDlSequence property <b>dlSequence</b>.
     *
     * @param dlSequence
     */
    public void addDlSequence(FcDlSequence dlSequence) {
        this.dlSequence_.add(dlSequence);
    }

    /**
     * Adds the FcDlSequence property <b>dlSequence</b>.
     *
     * @param dlSequence
     */
    public void addDlSequence(FcDlSequence[] dlSequence) {
        for (int i = 0;i < dlSequence.length;i++) {
            addDlSequence(dlSequence[i]);
        }
    }

    /**
     * Gets number of the FcDlSequence property <b>dlSequence</b>.
     *
     * @return int
     */
    public int sizeDlSequence() {
        return (dlSequence_.size());
    }

    /**
     * Gets the FcDlSequence property <b>dlSequence</b> by index.
     *
     * @param index
     * @return FcDlSequence
     */
    public FcDlSequence getDlSequence(int index) {
        return ((FcDlSequence)dlSequence_.get(index));
    }

    /**
     * Sets the FcDlSequence property <b>dlSequence</b> by index.
     *
     * @param index
     * @param dlSequence
     */
    public void setDlSequence(int index, FcDlSequence dlSequence) {
        this.dlSequence_.set(index, dlSequence);
    }

    /**
     * Adds the FcDlSequence property <b>dlSequence</b> by index.
     *
     * @param index
     * @param dlSequence
     */
    public void addDlSequence(int index, FcDlSequence dlSequence) {
        this.dlSequence_.add(index, dlSequence);
    }

    /**
     * Remove the FcDlSequence property <b>dlSequence</b> by index.
     *
     * @param index
     */
    public void removeDlSequence(int index) {
        this.dlSequence_.remove(index);
    }

    /**
     * Remove the FcDlSequence property <b>dlSequence</b> by object.
     *
     * @param dlSequence
     */
    public void removeDlSequence(FcDlSequence dlSequence) {
        this.dlSequence_.remove(dlSequence);
    }

    /**
     * Clear the FcDlSequence property <b>dlSequence</b>.
     *
     */
    public void clearDlSequence() {
        this.dlSequence_.clear();
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
        buffer.append("<dl");
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
        size = this.dlSequence_.size();
        for (int i = 0;i < size;i++) {
            FcDlSequence value = (FcDlSequence)this.dlSequence_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</dl>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<dl");
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
        size = this.dlSequence_.size();
        for (int i = 0;i < size;i++) {
            FcDlSequence value = (FcDlSequence)this.dlSequence_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</dl>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<dl");
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
        size = this.dlSequence_.size();
        for (int i = 0;i < size;i++) {
            FcDlSequence value = (FcDlSequence)this.dlSequence_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</dl>");
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
     * for the <code>FcDl</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "dl")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!FcDlSequence.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!FcDlSequence.isMatchHungry(target)) {
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
     * is valid for the <code>FcDl</code>.
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
     * is valid for the <code>FcDl</code>.
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
