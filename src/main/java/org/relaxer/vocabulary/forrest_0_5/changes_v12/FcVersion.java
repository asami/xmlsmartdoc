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
 * <b>FcVersion</b> is generated from changes_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="version">
 *             <ref name="version.attlist"/>
 *             <ref name="text"/>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="version"&gt;
 *             &lt;ref name="version.attlist"/&gt;
 *             &lt;ref name="text"/&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version changes_v12.rng (Wed Mar 03 11:14:24 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FcVersion implements java.io.Serializable, Cloneable {
    private String content_;
    private String id_;
    private String xmlLang_;
    private String major_;
    private String minor_;
    private String fix_;
    private String tag_;

    /**
     * Creates a <code>FcVersion</code>.
     *
     */
    public FcVersion() {
    }

    /**
     * Creates a <code>FcVersion</code>.
     *
     * @param source
     */
    public FcVersion(FcVersion source) {
        setup(source);
    }

    /**
     * Creates a <code>FcVersion</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FcVersion(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FcVersion</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FcVersion(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FcVersion</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FcVersion(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FcVersion</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcVersion(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FcVersion</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcVersion(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FcVersion</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcVersion(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FcVersion</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcVersion(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FcVersion</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcVersion(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FcVersion</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcVersion(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FcVersion</code> by the FcVersion <code>source</code>.
     *
     * @param source
     */
    public void setup(FcVersion source) {
        int size;
        setContent(source.getContent());
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        setMajor(source.getMajor());
        setMinor(source.getMinor());
        setFix(source.getFix());
        setTag(source.getTag());
    }

    /**
     * Initializes the <code>FcVersion</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FcVersion</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FcVersion</code> by the Stack <code>stack</code>
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
        content_ = URelaxer.getElementPropertyAsString(element);
        id_ = URelaxer.getAttributePropertyAsString(element, "id");
        xmlLang_ = URelaxer.getAttributePropertyAsString(element, "xml:lang");
        major_ = URelaxer.getAttributePropertyAsString(element, "major");
        minor_ = URelaxer.getAttributePropertyAsString(element, "minor");
        fix_ = URelaxer.getAttributePropertyAsString(element, "fix");
        tag_ = URelaxer.getAttributePropertyAsString(element, "tag");
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FcVersion(this));
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
        Element element = doc.createElement("version");
        URelaxer.setElementPropertyByString(element, this.content_);
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        if (this.major_ != null) {
            URelaxer.setAttributePropertyByString(element, "major", this.major_);
        }
        if (this.minor_ != null) {
            URelaxer.setAttributePropertyByString(element, "minor", this.minor_);
        }
        if (this.fix_ != null) {
            URelaxer.setAttributePropertyByString(element, "fix", this.fix_);
        }
        if (this.tag_ != null) {
            URelaxer.setAttributePropertyByString(element, "tag", this.tag_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FcVersion</code> by the File <code>file</code>.
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
     * Initializes the <code>FcVersion</code>
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
     * Initializes the <code>FcVersion</code> by the URL <code>url</code>.
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
     * Initializes the <code>FcVersion</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FcVersion</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FcVersion</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>content</b>.
     *
     * @return String
     */
    public String getContent() {
        return (content_);
    }

    /**
     * Sets the String property <b>content</b>.
     *
     * @param content
     */
    public void setContent(String content) {
        this.content_ = content;
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
     * Gets the String property <b>major</b>.
     *
     * @return String
     */
    public String getMajor() {
        return (major_);
    }

    /**
     * Sets the String property <b>major</b>.
     *
     * @param major
     */
    public void setMajor(String major) {
        this.major_ = major;
    }

    /**
     * Gets the String property <b>minor</b>.
     *
     * @return String
     */
    public String getMinor() {
        return (minor_);
    }

    /**
     * Sets the String property <b>minor</b>.
     *
     * @param minor
     */
    public void setMinor(String minor) {
        this.minor_ = minor;
    }

    /**
     * Gets the String property <b>fix</b>.
     *
     * @return String
     */
    public String getFix() {
        return (fix_);
    }

    /**
     * Sets the String property <b>fix</b>.
     *
     * @param fix
     */
    public void setFix(String fix) {
        this.fix_ = fix;
    }

    /**
     * Gets the String property <b>tag</b>.
     *
     * @return String
     */
    public String getTag() {
        return (tag_);
    }

    /**
     * Sets the String property <b>tag</b>.
     *
     * @param tag
     */
    public void setTag(String tag) {
        this.tag_ = tag;
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
        buffer.append("<version");
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
        if (major_ != null) {
            buffer.append(" major=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getMajor())));
            buffer.append("\"");
        }
        if (minor_ != null) {
            buffer.append(" minor=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getMinor())));
            buffer.append("\"");
        }
        if (fix_ != null) {
            buffer.append(" fix=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getFix())));
            buffer.append("\"");
        }
        if (tag_ != null) {
            buffer.append(" tag=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getTag())));
            buffer.append("\"");
        }
        buffer.append(">");
        buffer.append(URelaxer.escapeCharData(URelaxer.getString(getContent())));
        buffer.append("</version>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<version");
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
        if (major_ != null) {
            buffer.write(" major=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getMajor())));
            buffer.write("\"");
        }
        if (minor_ != null) {
            buffer.write(" minor=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getMinor())));
            buffer.write("\"");
        }
        if (fix_ != null) {
            buffer.write(" fix=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getFix())));
            buffer.write("\"");
        }
        if (tag_ != null) {
            buffer.write(" tag=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getTag())));
            buffer.write("\"");
        }
        buffer.write(">");
        buffer.write(URelaxer.escapeCharData(URelaxer.getString(getContent())));
        buffer.write("</version>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<version");
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
        if (major_ != null) {
            buffer.print(" major=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getMajor())));
            buffer.print("\"");
        }
        if (minor_ != null) {
            buffer.print(" minor=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getMinor())));
            buffer.print("\"");
        }
        if (fix_ != null) {
            buffer.print(" fix=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getFix())));
            buffer.print("\"");
        }
        if (tag_ != null) {
            buffer.print(" tag=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getTag())));
            buffer.print("\"");
        }
        buffer.print(">");
        buffer.print(URelaxer.escapeCharData(URelaxer.getString(getContent())));
        buffer.print("</version>");
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
    public String getContentAsString() {
        return (URelaxer.getString(getContent()));
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
    public String getMajorAsString() {
        return (URelaxer.getString(getMajor()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getMinorAsString() {
        return (URelaxer.getString(getMinor()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getFixAsString() {
        return (URelaxer.getString(getFix()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getTagAsString() {
        return (URelaxer.getString(getTag()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setContentByString(String string) {
        setContent(string);
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
    public void setMajorByString(String string) {
        setMajor(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setMinorByString(String string) {
        setMinor(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setFixByString(String string) {
        setFix(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setTagByString(String string) {
        setTag(string);
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
     * for the <code>FcVersion</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "version")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FcVersion</code>.
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
     * is valid for the <code>FcVersion</code>.
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
