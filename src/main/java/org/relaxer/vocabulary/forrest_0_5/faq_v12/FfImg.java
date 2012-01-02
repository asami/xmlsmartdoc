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
 * <b>FfImg</b> is generated from faq_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="img">
 *             <ref name="img.attlist"/>
 *             <empty/>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="img"&gt;
 *             &lt;ref name="img.attlist"/&gt;
 *             &lt;empty/&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version faq_v12.rng (Wed Mar 03 11:15:14 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FfImg implements java.io.Serializable, Cloneable, IFfTitleMixed, IFfTitleMixedChoice, IFfLinkContentMixMixed, IFfLinkContentMixMixedChoice, IFfContentMixMixed, IFfContentMixMixedChoice, IFfFlowMixed, IFfFlowMixedChoice, IFfQuestionMixed, IFfQuestionMixedChoice {
    public static final String ISMAP_ISMAP = "ismap";

    private String src_;
    private String alt_;
    private String height_;
    private String width_;
    private String usemap_;
    private String ismap_;
    private String id_;
    private String xmlLang_;

    /**
     * Creates a <code>FfImg</code>.
     *
     */
    public FfImg() {
        src_ = "";
        alt_ = "";
    }

    /**
     * Creates a <code>FfImg</code>.
     *
     * @param source
     */
    public FfImg(FfImg source) {
        setup(source);
    }

    /**
     * Creates a <code>FfImg</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FfImg(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FfImg</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FfImg(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FfImg</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FfImg(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FfImg</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfImg(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FfImg</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfImg(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FfImg</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfImg(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FfImg</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfImg(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FfImg</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfImg(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FfImg</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FfImg(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FfImg</code> by the FfImg <code>source</code>.
     *
     * @param source
     */
    public void setup(FfImg source) {
        int size;
        setSrc(source.getSrc());
        setAlt(source.getAlt());
        setHeight(source.getHeight());
        setWidth(source.getWidth());
        setUsemap(source.getUsemap());
        setIsmap(source.getIsmap());
        setId(source.getId());
        setXmlLang(source.getXmlLang());
    }

    /**
     * Initializes the <code>FfImg</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FfImg</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FfImg</code> by the Stack <code>stack</code>
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
        src_ = URelaxer.getAttributePropertyAsString(element, "src");
        alt_ = URelaxer.getAttributePropertyAsString(element, "alt");
        height_ = URelaxer.getAttributePropertyAsString(element, "height");
        width_ = URelaxer.getAttributePropertyAsString(element, "width");
        usemap_ = URelaxer.getAttributePropertyAsString(element, "usemap");
        ismap_ = URelaxer.getAttributePropertyAsString(element, "ismap");
        id_ = URelaxer.getAttributePropertyAsString(element, "id");
        xmlLang_ = URelaxer.getAttributePropertyAsString(element, "xml:lang");
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FfImg(this));
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
        Element element = doc.createElement("img");
        int size;
        if (this.src_ != null) {
            URelaxer.setAttributePropertyByString(element, "src", this.src_);
        }
        if (this.alt_ != null) {
            URelaxer.setAttributePropertyByString(element, "alt", this.alt_);
        }
        if (this.height_ != null) {
            URelaxer.setAttributePropertyByString(element, "height", this.height_);
        }
        if (this.width_ != null) {
            URelaxer.setAttributePropertyByString(element, "width", this.width_);
        }
        if (this.usemap_ != null) {
            URelaxer.setAttributePropertyByString(element, "usemap", this.usemap_);
        }
        if (this.ismap_ != null) {
            URelaxer.setAttributePropertyByString(element, "ismap", this.ismap_);
        }
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FfImg</code> by the File <code>file</code>.
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
     * Initializes the <code>FfImg</code>
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
     * Initializes the <code>FfImg</code> by the URL <code>url</code>.
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
     * Initializes the <code>FfImg</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FfImg</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FfImg</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>src</b>.
     *
     * @return String
     */
    public String getSrc() {
        return (src_);
    }

    /**
     * Sets the String property <b>src</b>.
     *
     * @param src
     */
    public void setSrc(String src) {
        this.src_ = src;
    }

    /**
     * Gets the String property <b>alt</b>.
     *
     * @return String
     */
    public String getAlt() {
        return (alt_);
    }

    /**
     * Sets the String property <b>alt</b>.
     *
     * @param alt
     */
    public void setAlt(String alt) {
        this.alt_ = alt;
    }

    /**
     * Gets the String property <b>height</b>.
     *
     * @return String
     */
    public String getHeight() {
        return (height_);
    }

    /**
     * Sets the String property <b>height</b>.
     *
     * @param height
     */
    public void setHeight(String height) {
        this.height_ = height;
    }

    /**
     * Gets the String property <b>width</b>.
     *
     * @return String
     */
    public String getWidth() {
        return (width_);
    }

    /**
     * Sets the String property <b>width</b>.
     *
     * @param width
     */
    public void setWidth(String width) {
        this.width_ = width;
    }

    /**
     * Gets the String property <b>usemap</b>.
     *
     * @return String
     */
    public String getUsemap() {
        return (usemap_);
    }

    /**
     * Sets the String property <b>usemap</b>.
     *
     * @param usemap
     */
    public void setUsemap(String usemap) {
        this.usemap_ = usemap;
    }

    /**
     * Gets the String property <b>ismap</b>.
     *
     * @return String
     */
    public String getIsmap() {
        return (ismap_);
    }

    /**
     * Sets the String property <b>ismap</b>.
     *
     * @param ismap
     */
    public void setIsmap(String ismap) {
        this.ismap_ = ismap;
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
        buffer.append("<img");
        if (src_ != null) {
            buffer.append(" src=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getSrc())));
            buffer.append("\"");
        }
        if (alt_ != null) {
            buffer.append(" alt=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getAlt())));
            buffer.append("\"");
        }
        if (height_ != null) {
            buffer.append(" height=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getHeight())));
            buffer.append("\"");
        }
        if (width_ != null) {
            buffer.append(" width=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getWidth())));
            buffer.append("\"");
        }
        if (usemap_ != null) {
            buffer.append(" usemap=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getUsemap())));
            buffer.append("\"");
        }
        if (ismap_ != null) {
            buffer.append(" ismap=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getIsmap())));
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
        buffer.append(">");
        buffer.append("</img>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<img");
        if (src_ != null) {
            buffer.write(" src=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getSrc())));
            buffer.write("\"");
        }
        if (alt_ != null) {
            buffer.write(" alt=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getAlt())));
            buffer.write("\"");
        }
        if (height_ != null) {
            buffer.write(" height=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getHeight())));
            buffer.write("\"");
        }
        if (width_ != null) {
            buffer.write(" width=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getWidth())));
            buffer.write("\"");
        }
        if (usemap_ != null) {
            buffer.write(" usemap=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getUsemap())));
            buffer.write("\"");
        }
        if (ismap_ != null) {
            buffer.write(" ismap=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getIsmap())));
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
        buffer.write(">");
        buffer.write("</img>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<img");
        if (src_ != null) {
            buffer.print(" src=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getSrc())));
            buffer.print("\"");
        }
        if (alt_ != null) {
            buffer.print(" alt=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getAlt())));
            buffer.print("\"");
        }
        if (height_ != null) {
            buffer.print(" height=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getHeight())));
            buffer.print("\"");
        }
        if (width_ != null) {
            buffer.print(" width=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getWidth())));
            buffer.print("\"");
        }
        if (usemap_ != null) {
            buffer.print(" usemap=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getUsemap())));
            buffer.print("\"");
        }
        if (ismap_ != null) {
            buffer.print(" ismap=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getIsmap())));
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
        buffer.print(">");
        buffer.print("</img>");
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
    public String getSrcAsString() {
        return (URelaxer.getString(getSrc()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getAltAsString() {
        return (URelaxer.getString(getAlt()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getHeightAsString() {
        return (URelaxer.getString(getHeight()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getWidthAsString() {
        return (URelaxer.getString(getWidth()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getUsemapAsString() {
        return (URelaxer.getString(getUsemap()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getIsmapAsString() {
        return (URelaxer.getString(getIsmap()));
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
    public void setSrcByString(String string) {
        setSrc(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setAltByString(String string) {
        setAlt(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setHeightByString(String string) {
        setHeight(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setWidthByString(String string) {
        setWidth(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setUsemapByString(String string) {
        setUsemap(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setIsmapByString(String string) {
        setIsmap(string);
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
     * for the <code>FfImg</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "img")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "src")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer.hasAttributeHungry(target, "alt")) {
            return (false);
        }
        $match$ = true;
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FfImg</code>.
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
     * is valid for the <code>FfImg</code>.
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
