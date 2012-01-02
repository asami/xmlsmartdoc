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
 * <b>ODPFrame</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="frame" ns="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0">
 *       <attribute name="draw:layer">
 *         <data type="token"/>
 *       </attribute>
 *       <optional>
 *         <attribute name="text-style-name"> 
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <optional>
 *         <attribute name="presentation:class">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <optional>
 *       <attribute name="presentation:style-name">
 *         <data type="token"/>
 *       </attribute>
 *       </optional>
 *       <optional>
 *       <attribute name="svg:height">
 *         <data type="token"/>
 *       </attribute>
 *       </optional>
 *       <optional>
 *       <attribute name="svg:width">
 *         <data type="token"/>
 *       </attribute>
 *       </optional>
 *       <optional>
 *       <attribute name="svg:x">
 *         <data type="token"/>
 *       </attribute>
 *       </optional>
 *       <optional>
 *       <attribute name="svg:y">
 *         <data type="token"/>
 *       </attribute>
 *       </optional>
 *       <optional>
 *         <attribute name="presentation:placeholder">
 *           <data type="boolean"/>
 *         </attribute>
 *       </optional>
 *       <ref name="text-box"/>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="frame" ns="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"&gt;
 *       &lt;attribute name="draw:layer"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="text-style-name"&gt; 
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="presentation:class"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *       &lt;attribute name="presentation:style-name"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *       &lt;attribute name="svg:height"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *       &lt;attribute name="svg:width"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *       &lt;attribute name="svg:x"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *       &lt;attribute name="svg:y"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="presentation:placeholder"&gt;
 *           &lt;data type="boolean"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;ref name="text-box"/&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:19 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPFrame implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
    private String layer_;
    private String textStyleName_;
    private String classValue_;
    private String styleName_;
    private String height_;
    private String width_;
    private String x_;
    private String y_;
    private Boolean placeholder_;
    private ODPTextBox textBox_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPFrame</code>.
     *
     */
    public ODPFrame() {
        rNSContext_.declareNamespaceWeak("p1", "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
        rNSContext_.declareNamespaceWeak("p2", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        rNSContext_.declareNamespaceWeak("p3", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        rNSContext_.declareNamespaceWeak("p4", "urn:oasis:names:tc:opendocument:xmlns:svg:1.0");
        rNSContext_.declareNamespaceWeak("p5", "urn:oasis:names:tc:opendocument:xmlns:svg:1.0");
        rNSContext_.declareNamespaceWeak("p6", "urn:oasis:names:tc:opendocument:xmlns:svg:1.0");
        rNSContext_.declareNamespaceWeak("p7", "urn:oasis:names:tc:opendocument:xmlns:svg:1.0");
        rNSContext_.declareNamespaceWeak("p8", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        layer_ = "";
    }

    /**
     * Creates a <code>ODPFrame</code>.
     *
     * @param source
     */
    public ODPFrame(ODPFrame source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPFrame</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPFrame(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPFrame</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPFrame(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPFrame</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPFrame(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPFrame</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPFrame(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPFrame</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPFrame(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPFrame</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPFrame(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPFrame</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPFrame(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPFrame</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPFrame(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPFrame</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPFrame(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPFrame</code> by the ODPFrame <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPFrame source) {
        int size;
        layer_ = source.layer_;
        textStyleName_ = source.textStyleName_;
        classValue_ = source.classValue_;
        styleName_ = source.styleName_;
        height_ = source.height_;
        width_ = source.width_;
        x_ = source.x_;
        y_ = source.y_;
        placeholder_ = source.placeholder_;
        if (source.textBox_ != null) {
            setTextBox((ODPTextBox)source.getTextBox().clone());
        }
    }

    /**
     * Initializes the <code>ODPFrame</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPFrame</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPFrame</code> by the Stack <code>stack</code>
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
        textStyleName_ = URelaxer.getAttributePropertyAsString(element, "text-style-name");
        classValue_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "class");
        styleName_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name");
        height_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "height");
        width_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "width");
        x_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "x");
        y_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:svg:1.0", "y");
        placeholder_ = URelaxer2.getAttributePropertyAsBooleanObject(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "placeholder");
        setTextBox(new ODPTextBox(stack));
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPFrame((ODPFrame)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "frame");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.layer_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "layer", this.layer_, rNSContext_);
        }
        if (this.textStyleName_ != null) {
            URelaxer.setAttributePropertyByString(element, "text-style-name", this.textStyleName_);
        }
        if (this.classValue_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "class", this.classValue_, rNSContext_);
        }
        if (this.styleName_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name", this.styleName_, rNSContext_);
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
        if (this.placeholder_ != null) {
            URelaxer2.setAttributePropertyByBoolean(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "placeholder", this.placeholder_, rNSContext_);
        }
        this.textBox_.makeElement(element);
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPFrame</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPFrame</code>
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
     * Initializes the <code>ODPFrame</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPFrame</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPFrame</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPFrame</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>textStyleName</b>.
     *
     * @return String
     */
    public String getTextStyleName() {
        return (textStyleName_);
    }

    /**
     * Sets the String property <b>textStyleName</b>.
     *
     * @param textStyleName
     */
    public void setTextStyleName(String textStyleName) {
        this.textStyleName_ = textStyleName;
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
     * Gets the boolean property <b>placeholder</b>.
     *
     * @return boolean
     */
    public boolean getPlaceholder() {
        if (placeholder_ == null) {
            return(false);
        }
        return (placeholder_.booleanValue());
    }

    /**
     * Gets the boolean property <b>placeholder</b>.
     *
     * @param placeholder
     * @return boolean
     */
    public boolean getPlaceholder(boolean placeholder) {
        if (placeholder_ == null) {
            return(placeholder);
        }
        return (this.placeholder_.booleanValue());
    }

    /**
     * Gets the boolean property <b>placeholder</b>.
     *
     * @return Boolean
     */
    public Boolean getPlaceholderAsBoolean() {
        return (placeholder_);
    }

    /**
     * Check the boolean property <b>placeholder</b>.
     *
     * @return boolean
     */
    public boolean checkPlaceholder() {
        return (placeholder_ != null);
    }

    /**
     * Sets the boolean property <b>placeholder</b>.
     *
     * @param placeholder
     */
    public void setPlaceholder(boolean placeholder) {
        this.placeholder_ = new Boolean(placeholder);
    }

    /**
     * Sets the boolean property <b>placeholder</b>.
     *
     * @param placeholder
     */
    public void setPlaceholder(Boolean placeholder) {
        this.placeholder_ = placeholder;
    }

    /**
     * Gets the ODPTextBox property <b>textBox</b>.
     *
     * @return ODPTextBox
     */
    public ODPTextBox getTextBox() {
        return (textBox_);
    }

    /**
     * Sets the ODPTextBox property <b>textBox</b>.
     *
     * @param textBox
     */
    public void setTextBox(ODPTextBox textBox) {
        this.textBox_ = textBox;
        if (textBox != null) {
            textBox.rSetParentRNode(this);
        }
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
        URelaxer.makeQName(prefix, "frame", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (layer_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "layer", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getLayer())));
            buffer.append("\"");
        }
        if (textStyleName_ != null) {
            buffer.append(" ");
            buffer.append("text-style-name");
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getTextStyleName())));
            buffer.append("\"");
        }
        if (classValue_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "class", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getClassValue())));
            buffer.append("\"");
        }
        if (styleName_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
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
        if (placeholder_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "placeholder", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.getString(getPlaceholder()));
            buffer.append("\"");
        }
        buffer.append(">");
        textBox_.makeTextElement(buffer);
        buffer.append("</");
        URelaxer.makeQName(prefix, "frame", buffer);
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
        URelaxer.makeQName(prefix, "frame", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (layer_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "layer", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getLayer())));
            buffer.write("\"");
        }
        if (textStyleName_ != null) {
            buffer.write(" ");
            buffer.write("text-style-name");
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getTextStyleName())));
            buffer.write("\"");
        }
        if (classValue_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "class", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getClassValue())));
            buffer.write("\"");
        }
        if (styleName_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
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
        if (placeholder_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "placeholder", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.getString(getPlaceholder()));
            buffer.write("\"");
        }
        buffer.write(">");
        textBox_.makeTextElement(buffer);
        buffer.write("</");
        URelaxer.makeQName(prefix, "frame", buffer);
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
        URelaxer.makeQName(prefix, "frame", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (layer_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "layer", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getLayer())));
            buffer.print("\"");
        }
        if (textStyleName_ != null) {
            buffer.print(" ");
            buffer.print("text-style-name");
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getTextStyleName())));
            buffer.print("\"");
        }
        if (classValue_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "class", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getClassValue())));
            buffer.print("\"");
        }
        if (styleName_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
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
        if (placeholder_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "placeholder", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.getString(getPlaceholder()));
            buffer.print("\"");
        }
        buffer.print(">");
        textBox_.makeTextElement(buffer);
        buffer.print("</");
        URelaxer.makeQName(prefix, "frame", buffer);
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
    public String getTextStyleNameAsString() {
        return (URelaxer.getString(getTextStyleName()));
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
    public String getStyleNameAsString() {
        return (URelaxer.getString(getStyleName()));
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
     * Gets the property value as String.
     *
     * @return String
     */
    public String getPlaceholderAsString() {
        return (URelaxer.getString(getPlaceholder()));
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
    public void setTextStyleNameByString(String string) {
        setTextStyleName(string);
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
    public void setStyleNameByString(String string) {
        setStyleName(string);
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
     * Sets the property value by String.
     *
     * @param string
     */
    public void setPlaceholderByString(String string) {
        setPlaceholder(new Boolean(string).booleanValue());
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
        if (textBox_ != null) {
            classNodes.add(textBox_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>ODPFrame</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "frame")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "layer")) {
            return (false);
        }
        $match$ = true;
        if (!ODPTextBox.isMatchHungry(target)) {
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
     * is valid for the <code>ODPFrame</code>.
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
     * is valid for the <code>ODPFrame</code>.
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
