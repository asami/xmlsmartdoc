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
 * <b>ODPDrawingPageProperties</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="drawing-page-properties" ns="urn:oasis:names:tc:opendocument:xmlns:style:1.0">
 *       <optional>
 *         <attribute name="presentation:background-objects-visible">
 *           <data type="boolean"/>
 *         </attribute>
 *       </optional>
 *       <optional>
 *         <attribute name="presentation:background-visible">
 *           <data type="boolean"/>
 *         </attribute>
 *       </optional>
 *       <attribute name="presentation:display-date-time">
 *         <data type="boolean"/>
 *       </attribute>
 *       <attribute name="presentation:display-footer">
 *         <data type="boolean"/>
 *       </attribute>
 *       <attribute name="presentation:display-page-number">
 *         <data type="boolean"/>
 *       </attribute>
 *       <optional>
 *         <attribute name="presentation:display-header">
 *           <data type="boolean"/>
 *         </attribute>
 *       </optional>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="drawing-page-properties" ns="urn:oasis:names:tc:opendocument:xmlns:style:1.0"&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="presentation:background-objects-visible"&gt;
 *           &lt;data type="boolean"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="presentation:background-visible"&gt;
 *           &lt;data type="boolean"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;attribute name="presentation:display-date-time"&gt;
 *         &lt;data type="boolean"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="presentation:display-footer"&gt;
 *         &lt;data type="boolean"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="presentation:display-page-number"&gt;
 *         &lt;data type="boolean"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="presentation:display-header"&gt;
 *           &lt;data type="boolean"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:20 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPDrawingPageProperties implements java.io.Serializable, Cloneable, IRNSContainer, IRNode, IODPStyleChoice {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
    private Boolean backgroundObjectsVisible_;
    private Boolean backgroundVisible_;
    private boolean displayDateTime_;
    private boolean displayFooter_;
    private boolean displayPageNumber_;
    private Boolean displayHeader_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPDrawingPageProperties</code>.
     *
     */
    public ODPDrawingPageProperties() {
        rNSContext_.declareNamespaceWeak("p1", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        rNSContext_.declareNamespaceWeak("p2", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        rNSContext_.declareNamespaceWeak("p3", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        rNSContext_.declareNamespaceWeak("p4", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        rNSContext_.declareNamespaceWeak("p5", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        rNSContext_.declareNamespaceWeak("p6", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
    }

    /**
     * Creates a <code>ODPDrawingPageProperties</code>.
     *
     * @param source
     */
    public ODPDrawingPageProperties(ODPDrawingPageProperties source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPDrawingPageProperties</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPDrawingPageProperties(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPDrawingPageProperties</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPDrawingPageProperties(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPDrawingPageProperties</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPDrawingPageProperties(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPDrawingPageProperties</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPDrawingPageProperties(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPDrawingPageProperties</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPDrawingPageProperties(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPDrawingPageProperties</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPDrawingPageProperties(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPDrawingPageProperties</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPDrawingPageProperties(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPDrawingPageProperties</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPDrawingPageProperties(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPDrawingPageProperties</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPDrawingPageProperties(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPDrawingPageProperties</code> by the ODPDrawingPageProperties <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPDrawingPageProperties source) {
        int size;
        backgroundObjectsVisible_ = source.backgroundObjectsVisible_;
        backgroundVisible_ = source.backgroundVisible_;
        displayDateTime_ = source.displayDateTime_;
        displayFooter_ = source.displayFooter_;
        displayPageNumber_ = source.displayPageNumber_;
        displayHeader_ = source.displayHeader_;
    }

    /**
     * Initializes the <code>ODPDrawingPageProperties</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPDrawingPageProperties</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPDrawingPageProperties</code> by the Stack <code>stack</code>
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
        backgroundObjectsVisible_ = URelaxer2.getAttributePropertyAsBooleanObject(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "background-objects-visible");
        backgroundVisible_ = URelaxer2.getAttributePropertyAsBooleanObject(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "background-visible");
        displayDateTime_ = URelaxer2.getAttributePropertyAsBoolean(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-date-time");
        displayFooter_ = URelaxer2.getAttributePropertyAsBoolean(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-footer");
        displayPageNumber_ = URelaxer2.getAttributePropertyAsBoolean(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-page-number");
        displayHeader_ = URelaxer2.getAttributePropertyAsBooleanObject(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-header");
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPDrawingPageProperties((ODPDrawingPageProperties)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "drawing-page-properties");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.backgroundObjectsVisible_ != null) {
            URelaxer2.setAttributePropertyByBoolean(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "background-objects-visible", this.backgroundObjectsVisible_, rNSContext_);
        }
        if (this.backgroundVisible_ != null) {
            URelaxer2.setAttributePropertyByBoolean(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "background-visible", this.backgroundVisible_, rNSContext_);
        }
        URelaxer2.setAttributePropertyByBoolean(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-date-time", this.displayDateTime_, rNSContext_);
        URelaxer2.setAttributePropertyByBoolean(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-footer", this.displayFooter_, rNSContext_);
        URelaxer2.setAttributePropertyByBoolean(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-page-number", this.displayPageNumber_, rNSContext_);
        if (this.displayHeader_ != null) {
            URelaxer2.setAttributePropertyByBoolean(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-header", this.displayHeader_, rNSContext_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPDrawingPageProperties</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPDrawingPageProperties</code>
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
     * Initializes the <code>ODPDrawingPageProperties</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPDrawingPageProperties</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPDrawingPageProperties</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPDrawingPageProperties</code> by the Reader <code>reader</code>.
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
     * Gets the boolean property <b>backgroundObjectsVisible</b>.
     *
     * @return boolean
     */
    public boolean getBackgroundObjectsVisible() {
        if (backgroundObjectsVisible_ == null) {
            return(false);
        }
        return (backgroundObjectsVisible_.booleanValue());
    }

    /**
     * Gets the boolean property <b>backgroundObjectsVisible</b>.
     *
     * @param backgroundObjectsVisible
     * @return boolean
     */
    public boolean getBackgroundObjectsVisible(boolean backgroundObjectsVisible) {
        if (backgroundObjectsVisible_ == null) {
            return(backgroundObjectsVisible);
        }
        return (this.backgroundObjectsVisible_.booleanValue());
    }

    /**
     * Gets the boolean property <b>backgroundObjectsVisible</b>.
     *
     * @return Boolean
     */
    public Boolean getBackgroundObjectsVisibleAsBoolean() {
        return (backgroundObjectsVisible_);
    }

    /**
     * Check the boolean property <b>backgroundObjectsVisible</b>.
     *
     * @return boolean
     */
    public boolean checkBackgroundObjectsVisible() {
        return (backgroundObjectsVisible_ != null);
    }

    /**
     * Sets the boolean property <b>backgroundObjectsVisible</b>.
     *
     * @param backgroundObjectsVisible
     */
    public void setBackgroundObjectsVisible(boolean backgroundObjectsVisible) {
        this.backgroundObjectsVisible_ = new Boolean(backgroundObjectsVisible);
    }

    /**
     * Sets the boolean property <b>backgroundObjectsVisible</b>.
     *
     * @param backgroundObjectsVisible
     */
    public void setBackgroundObjectsVisible(Boolean backgroundObjectsVisible) {
        this.backgroundObjectsVisible_ = backgroundObjectsVisible;
    }

    /**
     * Gets the boolean property <b>backgroundVisible</b>.
     *
     * @return boolean
     */
    public boolean getBackgroundVisible() {
        if (backgroundVisible_ == null) {
            return(false);
        }
        return (backgroundVisible_.booleanValue());
    }

    /**
     * Gets the boolean property <b>backgroundVisible</b>.
     *
     * @param backgroundVisible
     * @return boolean
     */
    public boolean getBackgroundVisible(boolean backgroundVisible) {
        if (backgroundVisible_ == null) {
            return(backgroundVisible);
        }
        return (this.backgroundVisible_.booleanValue());
    }

    /**
     * Gets the boolean property <b>backgroundVisible</b>.
     *
     * @return Boolean
     */
    public Boolean getBackgroundVisibleAsBoolean() {
        return (backgroundVisible_);
    }

    /**
     * Check the boolean property <b>backgroundVisible</b>.
     *
     * @return boolean
     */
    public boolean checkBackgroundVisible() {
        return (backgroundVisible_ != null);
    }

    /**
     * Sets the boolean property <b>backgroundVisible</b>.
     *
     * @param backgroundVisible
     */
    public void setBackgroundVisible(boolean backgroundVisible) {
        this.backgroundVisible_ = new Boolean(backgroundVisible);
    }

    /**
     * Sets the boolean property <b>backgroundVisible</b>.
     *
     * @param backgroundVisible
     */
    public void setBackgroundVisible(Boolean backgroundVisible) {
        this.backgroundVisible_ = backgroundVisible;
    }

    /**
     * Gets the boolean property <b>displayDateTime</b>.
     *
     * @return boolean
     */
    public boolean getDisplayDateTime() {
        return (displayDateTime_);
    }

    /**
     * Sets the boolean property <b>displayDateTime</b>.
     *
     * @param displayDateTime
     */
    public void setDisplayDateTime(boolean displayDateTime) {
        this.displayDateTime_ = displayDateTime;
    }

    /**
     * Gets the boolean property <b>displayDateTime</b>.
     *
     * @return Boolean
     */
    public Boolean getDisplayDateTimeAsBoolean() {
        return (new Boolean(displayDateTime_));
    }

    /**
     * Sets the boolean property <b>displayDateTime</b>.
     *
     * @param displayDateTime
     */
    public void setDisplayDateTime(Boolean displayDateTime) {
        this.displayDateTime_ = displayDateTime.booleanValue();
    }

    /**
     * Gets the boolean property <b>displayFooter</b>.
     *
     * @return boolean
     */
    public boolean getDisplayFooter() {
        return (displayFooter_);
    }

    /**
     * Sets the boolean property <b>displayFooter</b>.
     *
     * @param displayFooter
     */
    public void setDisplayFooter(boolean displayFooter) {
        this.displayFooter_ = displayFooter;
    }

    /**
     * Gets the boolean property <b>displayFooter</b>.
     *
     * @return Boolean
     */
    public Boolean getDisplayFooterAsBoolean() {
        return (new Boolean(displayFooter_));
    }

    /**
     * Sets the boolean property <b>displayFooter</b>.
     *
     * @param displayFooter
     */
    public void setDisplayFooter(Boolean displayFooter) {
        this.displayFooter_ = displayFooter.booleanValue();
    }

    /**
     * Gets the boolean property <b>displayPageNumber</b>.
     *
     * @return boolean
     */
    public boolean getDisplayPageNumber() {
        return (displayPageNumber_);
    }

    /**
     * Sets the boolean property <b>displayPageNumber</b>.
     *
     * @param displayPageNumber
     */
    public void setDisplayPageNumber(boolean displayPageNumber) {
        this.displayPageNumber_ = displayPageNumber;
    }

    /**
     * Gets the boolean property <b>displayPageNumber</b>.
     *
     * @return Boolean
     */
    public Boolean getDisplayPageNumberAsBoolean() {
        return (new Boolean(displayPageNumber_));
    }

    /**
     * Sets the boolean property <b>displayPageNumber</b>.
     *
     * @param displayPageNumber
     */
    public void setDisplayPageNumber(Boolean displayPageNumber) {
        this.displayPageNumber_ = displayPageNumber.booleanValue();
    }

    /**
     * Gets the boolean property <b>displayHeader</b>.
     *
     * @return boolean
     */
    public boolean getDisplayHeader() {
        if (displayHeader_ == null) {
            return(false);
        }
        return (displayHeader_.booleanValue());
    }

    /**
     * Gets the boolean property <b>displayHeader</b>.
     *
     * @param displayHeader
     * @return boolean
     */
    public boolean getDisplayHeader(boolean displayHeader) {
        if (displayHeader_ == null) {
            return(displayHeader);
        }
        return (this.displayHeader_.booleanValue());
    }

    /**
     * Gets the boolean property <b>displayHeader</b>.
     *
     * @return Boolean
     */
    public Boolean getDisplayHeaderAsBoolean() {
        return (displayHeader_);
    }

    /**
     * Check the boolean property <b>displayHeader</b>.
     *
     * @return boolean
     */
    public boolean checkDisplayHeader() {
        return (displayHeader_ != null);
    }

    /**
     * Sets the boolean property <b>displayHeader</b>.
     *
     * @param displayHeader
     */
    public void setDisplayHeader(boolean displayHeader) {
        this.displayHeader_ = new Boolean(displayHeader);
    }

    /**
     * Sets the boolean property <b>displayHeader</b>.
     *
     * @param displayHeader
     */
    public void setDisplayHeader(Boolean displayHeader) {
        this.displayHeader_ = displayHeader;
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
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:style:1.0");
        buffer.append("<");
        URelaxer.makeQName(prefix, "drawing-page-properties", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (backgroundObjectsVisible_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "background-objects-visible", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.getString(getBackgroundObjectsVisible()));
            buffer.append("\"");
        }
        if (backgroundVisible_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "background-visible", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.getString(getBackgroundVisible()));
            buffer.append("\"");
        }
        buffer.append(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-date-time", buffer);
        buffer.append("=\"");
        buffer.append(URelaxer.getString(getDisplayDateTime()));
        buffer.append("\"");
        buffer.append(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-footer", buffer);
        buffer.append("=\"");
        buffer.append(URelaxer.getString(getDisplayFooter()));
        buffer.append("\"");
        buffer.append(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-page-number", buffer);
        buffer.append("=\"");
        buffer.append(URelaxer.getString(getDisplayPageNumber()));
        buffer.append("\"");
        if (displayHeader_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-header", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.getString(getDisplayHeader()));
            buffer.append("\"");
        }
        buffer.append(">");
        buffer.append("</");
        URelaxer.makeQName(prefix, "drawing-page-properties", buffer);
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
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:style:1.0");
        buffer.write("<");
        URelaxer.makeQName(prefix, "drawing-page-properties", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (backgroundObjectsVisible_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "background-objects-visible", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.getString(getBackgroundObjectsVisible()));
            buffer.write("\"");
        }
        if (backgroundVisible_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "background-visible", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.getString(getBackgroundVisible()));
            buffer.write("\"");
        }
        buffer.write(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-date-time", buffer);
        buffer.write("=\"");
        buffer.write(URelaxer.getString(getDisplayDateTime()));
        buffer.write("\"");
        buffer.write(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-footer", buffer);
        buffer.write("=\"");
        buffer.write(URelaxer.getString(getDisplayFooter()));
        buffer.write("\"");
        buffer.write(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-page-number", buffer);
        buffer.write("=\"");
        buffer.write(URelaxer.getString(getDisplayPageNumber()));
        buffer.write("\"");
        if (displayHeader_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-header", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.getString(getDisplayHeader()));
            buffer.write("\"");
        }
        buffer.write(">");
        buffer.write("</");
        URelaxer.makeQName(prefix, "drawing-page-properties", buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:style:1.0");
        buffer.print("<");
        URelaxer.makeQName(prefix, "drawing-page-properties", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (backgroundObjectsVisible_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "background-objects-visible", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.getString(getBackgroundObjectsVisible()));
            buffer.print("\"");
        }
        if (backgroundVisible_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "background-visible", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.getString(getBackgroundVisible()));
            buffer.print("\"");
        }
        buffer.print(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-date-time", buffer);
        buffer.print("=\"");
        buffer.print(URelaxer.getString(getDisplayDateTime()));
        buffer.print("\"");
        buffer.print(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-footer", buffer);
        buffer.print("=\"");
        buffer.print(URelaxer.getString(getDisplayFooter()));
        buffer.print("\"");
        buffer.print(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-page-number", buffer);
        buffer.print("=\"");
        buffer.print(URelaxer.getString(getDisplayPageNumber()));
        buffer.print("\"");
        if (displayHeader_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-header", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.getString(getDisplayHeader()));
            buffer.print("\"");
        }
        buffer.print(">");
        buffer.print("</");
        URelaxer.makeQName(prefix, "drawing-page-properties", buffer);
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
    public String getBackgroundObjectsVisibleAsString() {
        return (URelaxer.getString(getBackgroundObjectsVisible()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getBackgroundVisibleAsString() {
        return (URelaxer.getString(getBackgroundVisible()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getDisplayDateTimeAsString() {
        return (URelaxer.getString(getDisplayDateTime()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getDisplayFooterAsString() {
        return (URelaxer.getString(getDisplayFooter()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getDisplayPageNumberAsString() {
        return (URelaxer.getString(getDisplayPageNumber()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getDisplayHeaderAsString() {
        return (URelaxer.getString(getDisplayHeader()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setBackgroundObjectsVisibleByString(String string) {
        setBackgroundObjectsVisible(new Boolean(string).booleanValue());
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setBackgroundVisibleByString(String string) {
        setBackgroundVisible(new Boolean(string).booleanValue());
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setDisplayDateTimeByString(String string) {
        setDisplayDateTime(new Boolean(string).booleanValue());
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setDisplayFooterByString(String string) {
        setDisplayFooter(new Boolean(string).booleanValue());
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setDisplayPageNumberByString(String string) {
        setDisplayPageNumber(new Boolean(string).booleanValue());
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setDisplayHeaderByString(String string) {
        setDisplayHeader(new Boolean(string).booleanValue());
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
     * for the <code>ODPDrawingPageProperties</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "drawing-page-properties")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-date-time")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-footer")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "display-page-number")) {
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
     * is valid for the <code>ODPDrawingPageProperties</code>.
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
     * is valid for the <code>ODPDrawingPageProperties</code>.
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
