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
package org.relaxer.framework.runtime.models.opendocument.model.presentation;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>ODPPageThumbnail</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="page-thumbnail" ns="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0">
 *       <attribute name="draw:layer">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="draw:page-number">
 *         <data type="int"/>
 *       </attribute>
 *       <attribute name="presentation:style-name">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="presentation:class">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="svg:height">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="svg:width">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="svg:x">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="svg:y">
 *         <data type="token"/>
 *       </attribute>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="page-thumbnail" ns="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"&gt;
 *       &lt;attribute name="draw:layer"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="draw:page-number"&gt;
 *         &lt;data type="int"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="presentation:style-name"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="presentation:class"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="svg:height"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="svg:width"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="svg:x"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="svg:y"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:19 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPPageThumbnail implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
    private String layer_;
    private int pageNumber_;
    private String styleName_;
    private String classValue_;
    private String height_;
    private String width_;
    private String x_;
    private String y_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPPageThumbnail</code>.
     *
     */
    public ODPPageThumbnail() {
        rNSContext_.declareNamespaceWeak("p1", "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
        rNSContext_.declareNamespaceWeak("p2", "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
        rNSContext_.declareNamespaceWeak("p3", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        rNSContext_.declareNamespaceWeak("p4", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        rNSContext_.declareNamespaceWeak("p5", "urn:oasis:names:tc:opendocument:xmlns:svg:1.0");
        rNSContext_.declareNamespaceWeak("p6", "urn:oasis:names:tc:opendocument:xmlns:svg:1.0");
        rNSContext_.declareNamespaceWeak("p7", "urn:oasis:names:tc:opendocument:xmlns:svg:1.0");
        rNSContext_.declareNamespaceWeak("p8", "urn:oasis:names:tc:opendocument:xmlns:svg:1.0");
        layer_ = "";
        styleName_ = "";
        classValue_ = "";
        height_ = "";
        width_ = "";
        x_ = "";
        y_ = "";
    }

    /**
     * Creates a <code>ODPPageThumbnail</code>.
     *
     * @param source
     */
    public ODPPageThumbnail(ODPPageThumbnail source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPPageThumbnail</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPPageThumbnail(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPPageThumbnail</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPPageThumbnail(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPPageThumbnail</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPPageThumbnail(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPPageThumbnail</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPageThumbnail(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPPageThumbnail</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPageThumbnail(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPPageThumbnail</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPageThumbnail(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPPageThumbnail</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPageThumbnail(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPPageThumbnail</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPageThumbnail(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPPageThumbnail</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPageThumbnail(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPPageThumbnail</code> by the ODPPageThumbnail <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPPageThumbnail source) {
        int size;
        layer_ = source.layer_;
        pageNumber_ = source.pageNumber_;
        styleName_ = source.styleName_;
        classValue_ = source.classValue_;
        height_ = source.height_;
        width_ = source.width_;
        x_ = source.x_;
        y_ = source.y_;
    }

    /**
     * Initializes the <code>ODPPageThumbnail</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPPageThumbnail</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPPageThumbnail</code> by the Stack <code>stack</code>
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
        rNSContext_.declareNamespace(element);
        layer_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "layer");
        pageNumber_ = URelaxer2.getAttributePropertyAsInt(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "page-number");
        styleName_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name");
        classValue_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "class");
        height_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "height");
        width_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "width");
        x_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "x");
        y_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "y");
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPPageThumbnail((ODPPageThumbnail)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "page-thumbnail");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.layer_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "layer", this.layer_, rNSContext_);
        }
        URelaxer2.setAttributePropertyByInt(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "page-number", this.pageNumber_, rNSContext_);
        if (this.styleName_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name", this.styleName_, rNSContext_);
        }
        if (this.classValue_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "class", this.classValue_, rNSContext_);
        }
        if (this.height_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "height", this.height_, rNSContext_);
        }
        if (this.width_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "width", this.width_, rNSContext_);
        }
        if (this.x_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "x", this.x_, rNSContext_);
        }
        if (this.y_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "y", this.y_, rNSContext_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPPageThumbnail</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPPageThumbnail</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(uri, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>ODPPageThumbnail</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(url, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>ODPPageThumbnail</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(in, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>ODPPageThumbnail</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(is, UJAXP.FLAG_NAMESPACE_AWARE));
    }

    /**
     * Initializes the <code>ODPPageThumbnail</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(reader, UJAXP.FLAG_NAMESPACE_AWARE));
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
     * Gets the RNSContext property <b>RNSContext</b>.
     *
     * @return RNSContext
     */
    public RNSContext rGetRNSContext() {
        return (rNSContext_);
    }

    /**
     * Sets the RNSContext property <b>RNSContext</b>.
     *
     * @param rNSContext
     */
    public void rSetRNSContext(RNSContext rNSContext) {
        this.rNSContext_ = rNSContext;
    }

    /**
     * Gets the String property <b>layer</b>.
     *
     * @return String
     */
    public String getLayer() {
        return (layer_);
    }

    /**
     * Sets the String property <b>layer</b>.
     *
     * @param layer
     */
    public void setLayer(String layer) {
        this.layer_ = layer;
    }

    /**
     * Gets the int property <b>pageNumber</b>.
     *
     * @return int
     */
    public int getPageNumber() {
        return (pageNumber_);
    }

    /**
     * Sets the int property <b>pageNumber</b>.
     *
     * @param pageNumber
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber_ = pageNumber;
    }

    /**
     * Gets the int property <b>pageNumber</b>.
     *
     * @return Integer
     */
    public Integer getPageNumberAsInteger() {
        return (new Integer(pageNumber_));
    }

    /**
     * Sets the int property <b>pageNumber</b>.
     *
     * @param pageNumber
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber_ = pageNumber.intValue();
    }

    /**
     * Gets the String property <b>styleName</b>.
     *
     * @return String
     */
    public String getStyleName() {
        return (styleName_);
    }

    /**
     * Sets the String property <b>styleName</b>.
     *
     * @param styleName
     */
    public void setStyleName(String styleName) {
        this.styleName_ = styleName;
    }

    /**
     * Gets the String property <b>classValue</b>.
     *
     * @return String
     */
    public String getClassValue() {
        return (classValue_);
    }

    /**
     * Sets the String property <b>classValue</b>.
     *
     * @param classValue
     */
    public void setClassValue(String classValue) {
        this.classValue_ = classValue;
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
     * Gets the String property <b>x</b>.
     *
     * @return String
     */
    public String getX() {
        return (x_);
    }

    /**
     * Sets the String property <b>x</b>.
     *
     * @param x
     */
    public void setX(String x) {
        this.x_ = x;
    }

    /**
     * Gets the String property <b>y</b>.
     *
     * @return String
     */
    public String getY() {
        return (y_);
    }

    /**
     * Sets the String property <b>y</b>.
     *
     * @param y
     */
    public void setY(String y) {
        this.y_ = y;
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
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
        buffer.append("<");
        URelaxer.makeQName(prefix, "page-thumbnail", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (layer_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "layer", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getLayer())));
            buffer.append("\"");
        }
        buffer.append(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "page-number", buffer);
        buffer.append("=\"");
        buffer.append(URelaxer.getString(getPageNumber()));
        buffer.append("\"");
        if (styleName_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
            buffer.append("\"");
        }
        if (classValue_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "class", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getClassValue())));
            buffer.append("\"");
        }
        if (height_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "height", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getHeight())));
            buffer.append("\"");
        }
        if (width_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "width", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getWidth())));
            buffer.append("\"");
        }
        if (x_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "x", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getX())));
            buffer.append("\"");
        }
        if (y_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "y", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getY())));
            buffer.append("\"");
        }
        buffer.append(">");
        buffer.append("</");
        URelaxer.makeQName(prefix, "page-thumbnail", buffer);
        buffer.append(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
        buffer.write("<");
        URelaxer.makeQName(prefix, "page-thumbnail", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (layer_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "layer", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getLayer())));
            buffer.write("\"");
        }
        buffer.write(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "page-number", buffer);
        buffer.write("=\"");
        buffer.write(URelaxer.getString(getPageNumber()));
        buffer.write("\"");
        if (styleName_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
            buffer.write("\"");
        }
        if (classValue_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "class", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getClassValue())));
            buffer.write("\"");
        }
        if (height_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "height", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getHeight())));
            buffer.write("\"");
        }
        if (width_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "width", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getWidth())));
            buffer.write("\"");
        }
        if (x_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "x", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getX())));
            buffer.write("\"");
        }
        if (y_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "y", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getY())));
            buffer.write("\"");
        }
        buffer.write(">");
        buffer.write("</");
        URelaxer.makeQName(prefix, "page-thumbnail", buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
        buffer.print("<");
        URelaxer.makeQName(prefix, "page-thumbnail", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (layer_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "layer", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getLayer())));
            buffer.print("\"");
        }
        buffer.print(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "page-number", buffer);
        buffer.print("=\"");
        buffer.print(URelaxer.getString(getPageNumber()));
        buffer.print("\"");
        if (styleName_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
            buffer.print("\"");
        }
        if (classValue_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "class", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getClassValue())));
            buffer.print("\"");
        }
        if (height_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "height", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getHeight())));
            buffer.print("\"");
        }
        if (width_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "width", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getWidth())));
            buffer.print("\"");
        }
        if (x_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "x", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getX())));
            buffer.print("\"");
        }
        if (y_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "y", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getY())));
            buffer.print("\"");
        }
        buffer.print(">");
        buffer.print("</");
        URelaxer.makeQName(prefix, "page-thumbnail", buffer);
        buffer.print(">");
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
    public String getLayerAsString() {
        return (URelaxer.getString(getLayer()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getPageNumberAsString() {
        return (URelaxer.getString(getPageNumber()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getStyleNameAsString() {
        return (URelaxer.getString(getStyleName()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getClassValueAsString() {
        return (URelaxer.getString(getClassValue()));
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
    public String getXAsString() {
        return (URelaxer.getString(getX()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getYAsString() {
        return (URelaxer.getString(getY()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setLayerByString(String string) {
        setLayer(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setPageNumberByString(String string) {
        setPageNumber(Integer.parseInt(string));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setStyleNameByString(String string) {
        setStyleName(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setClassValueByString(String string) {
        setClassValue(string);
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
    public void setXByString(String string) {
        setX(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setYByString(String string) {
        setY(string);
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
     * Gets the IRNode property <b>parentRNode</b>.
     *
     * @return IRNode
     */
    public IRNode rGetParentRNode() {
        return (parentRNode_);
    }

    /**
     * Sets the IRNode property <b>parentRNode</b>.
     *
     * @param parentRNode
     */
    public void rSetParentRNode(IRNode parentRNode) {
        this.parentRNode_ = parentRNode;
    }

    /**
     * Gets child RNodes.
     *
     * @return IRNode[]
     */
    public IRNode[] rGetRNodes() {
        java.util.List classNodes = new java.util.ArrayList();
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>ODPPageThumbnail</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "page-thumbnail")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "layer")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "page-number")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "class")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "height")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "width")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "x")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "y")) {
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
     * is valid for the <code>ODPPageThumbnail</code>.
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
     * is valid for the <code>ODPPageThumbnail</code>.
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
