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
 * <b>FhDocument</b> is generated from howto_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="document">
 *             <ref name="document.attlist"/>
 *             <ref name="header"/>
 *             <ref name="body"/>
 *             <optional>
 *                 <ref name="footer"/>
 *             </optional>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="document"&gt;
 *             &lt;ref name="document.attlist"/&gt;
 *             &lt;ref name="header"/&gt;
 *             &lt;ref name="body"/&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="footer"/&gt;
 *             &lt;/optional&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version howto_v12.rng (Wed Mar 03 11:15:33 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FhDocument implements java.io.Serializable, Cloneable {
    private String id_;
    private String xmlLang_;
    private FhHeader header_;
    private FhBody body_;
    private FhFooter footer_;

    /**
     * Creates a <code>FhDocument</code>.
     *
     */
    public FhDocument() {
    }

    /**
     * Creates a <code>FhDocument</code>.
     *
     * @param source
     */
    public FhDocument(FhDocument source) {
        setup(source);
    }

    /**
     * Creates a <code>FhDocument</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FhDocument(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FhDocument</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FhDocument(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FhDocument</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FhDocument(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FhDocument</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhDocument(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FhDocument</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhDocument(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FhDocument</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhDocument(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FhDocument</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhDocument(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FhDocument</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhDocument(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FhDocument</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhDocument(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FhDocument</code> by the FhDocument <code>source</code>.
     *
     * @param source
     */
    public void setup(FhDocument source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        if (source.header_ != null) {
            setHeader((FhHeader)source.getHeader().clone());
        }
        if (source.body_ != null) {
            setBody((FhBody)source.getBody().clone());
        }
        if (source.footer_ != null) {
            setFooter((FhFooter)source.getFooter().clone());
        }
    }

    /**
     * Initializes the <code>FhDocument</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FhDocument</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FhDocument</code> by the Stack <code>stack</code>
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
        setHeader(new FhHeader(stack));
        setBody(new FhBody(stack));
        if (FhFooter.isMatch(stack)) {
            setFooter(new FhFooter(stack));
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FhDocument(this));
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
        Element element = doc.createElement("document");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        this.header_.makeElement(element);
        this.body_.makeElement(element);
        if (this.footer_ != null) {
            this.footer_.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FhDocument</code> by the File <code>file</code>.
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
     * Initializes the <code>FhDocument</code>
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
     * Initializes the <code>FhDocument</code> by the URL <code>url</code>.
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
     * Initializes the <code>FhDocument</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FhDocument</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FhDocument</code> by the Reader <code>reader</code>.
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
     * Gets the FhHeader property <b>header</b>.
     *
     * @return FhHeader
     */
    public FhHeader getHeader() {
        return (header_);
    }

    /**
     * Sets the FhHeader property <b>header</b>.
     *
     * @param header
     */
    public void setHeader(FhHeader header) {
        this.header_ = header;
    }

    /**
     * Gets the FhBody property <b>body</b>.
     *
     * @return FhBody
     */
    public FhBody getBody() {
        return (body_);
    }

    /**
     * Sets the FhBody property <b>body</b>.
     *
     * @param body
     */
    public void setBody(FhBody body) {
        this.body_ = body;
    }

    /**
     * Gets the FhFooter property <b>footer</b>.
     *
     * @return FhFooter
     */
    public FhFooter getFooter() {
        return (footer_);
    }

    /**
     * Sets the FhFooter property <b>footer</b>.
     *
     * @param footer
     */
    public void setFooter(FhFooter footer) {
        this.footer_ = footer;
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
        buffer.append("<document");
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
        header_.makeTextElement(buffer);
        body_.makeTextElement(buffer);
        if (footer_ != null) {
            footer_.makeTextElement(buffer);
        }
        buffer.append("</document>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<document");
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
        header_.makeTextElement(buffer);
        body_.makeTextElement(buffer);
        if (footer_ != null) {
            footer_.makeTextElement(buffer);
        }
        buffer.write("</document>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<document");
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
        header_.makeTextElement(buffer);
        body_.makeTextElement(buffer);
        if (footer_ != null) {
            footer_.makeTextElement(buffer);
        }
        buffer.print("</document>");
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
     * for the <code>FhDocument</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "document")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!FhHeader.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        if (!FhBody.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        if (FhFooter.isMatchHungry(target)) {
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FhDocument</code>.
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
     * is valid for the <code>FhDocument</code>.
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
