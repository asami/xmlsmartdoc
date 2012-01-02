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
 * <b>ODPGraphicProperties</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="graphic-properties" ns="urn:oasis:names:tc:opendocument:xmlns:style:1.0">
 *       <optional>
 *         <attribute name="style:protect">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <optional>
 *         <attribute name="auto-grow-height"> 
 *           <data type="boolean"/>
 *         </attribute>
 *       </optional>
 *       <optional>
 *         <attribute name="draw:fill-color">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <optional>
 *         <attribute name="fo:min-height">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="graphic-properties" ns="urn:oasis:names:tc:opendocument:xmlns:style:1.0"&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="style:protect"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="auto-grow-height"&gt; 
 *           &lt;data type="boolean"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="draw:fill-color"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="fo:min-height"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:20 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPGraphicProperties implements java.io.Serializable, Cloneable, IRNSContainer, IRNode, IODPStyleChoice {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
    private String protect_;
    private Boolean autoGrowHeight_;
    private String fillColor_;
    private String minHeight_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPGraphicProperties</code>.
     *
     */
    public ODPGraphicProperties() {
        rNSContext_.declareNamespaceWeak("p1", "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
        rNSContext_.declareNamespaceWeak("p2", "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
        rNSContext_.declareNamespaceWeak("p3", "http://www.w3.org/1999/XSL/Format");
    }

    /**
     * Creates a <code>ODPGraphicProperties</code>.
     *
     * @param source
     */
    public ODPGraphicProperties(ODPGraphicProperties source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPGraphicProperties</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPGraphicProperties(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPGraphicProperties</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPGraphicProperties(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPGraphicProperties</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPGraphicProperties(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPGraphicProperties</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPGraphicProperties(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPGraphicProperties</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPGraphicProperties(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPGraphicProperties</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPGraphicProperties(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPGraphicProperties</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPGraphicProperties(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPGraphicProperties</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPGraphicProperties(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPGraphicProperties</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPGraphicProperties(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPGraphicProperties</code> by the ODPGraphicProperties <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPGraphicProperties source) {
        int size;
        protect_ = source.protect_;
        autoGrowHeight_ = source.autoGrowHeight_;
        fillColor_ = source.fillColor_;
        minHeight_ = source.minHeight_;
    }

    /**
     * Initializes the <code>ODPGraphicProperties</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPGraphicProperties</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPGraphicProperties</code> by the Stack <code>stack</code>
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
        protect_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "protect");
        autoGrowHeight_ = URelaxer.getAttributePropertyAsBooleanObject(element, "auto-grow-height");
        fillColor_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "fill-color");
        minHeight_ = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1999/XSL/Format", "min-height");
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPGraphicProperties((ODPGraphicProperties)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "graphic-properties");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.protect_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "protect", this.protect_, rNSContext_);
        }
        if (this.autoGrowHeight_ != null) {
            URelaxer.setAttributePropertyByBoolean(element, "auto-grow-height", this.autoGrowHeight_);
        }
        if (this.fillColor_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "fill-color", this.fillColor_, rNSContext_);
        }
        if (this.minHeight_ != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1999/XSL/Format", "min-height", this.minHeight_, rNSContext_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPGraphicProperties</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPGraphicProperties</code>
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
     * Initializes the <code>ODPGraphicProperties</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPGraphicProperties</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPGraphicProperties</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPGraphicProperties</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>protect</b>.
     *
     * @return String
     */
    public String getProtect() {
        return (protect_);
    }

    /**
     * Sets the String property <b>protect</b>.
     *
     * @param protect
     */
    public void setProtect(String protect) {
        this.protect_ = protect;
    }

    /**
     * Gets the boolean property <b>autoGrowHeight</b>.
     *
     * @return boolean
     */
    public boolean getAutoGrowHeight() {
        if (autoGrowHeight_ == null) {
            return(false);
        }
        return (autoGrowHeight_.booleanValue());
    }

    /**
     * Gets the boolean property <b>autoGrowHeight</b>.
     *
     * @param autoGrowHeight
     * @return boolean
     */
    public boolean getAutoGrowHeight(boolean autoGrowHeight) {
        if (autoGrowHeight_ == null) {
            return(autoGrowHeight);
        }
        return (this.autoGrowHeight_.booleanValue());
    }

    /**
     * Gets the boolean property <b>autoGrowHeight</b>.
     *
     * @return Boolean
     */
    public Boolean getAutoGrowHeightAsBoolean() {
        return (autoGrowHeight_);
    }

    /**
     * Check the boolean property <b>autoGrowHeight</b>.
     *
     * @return boolean
     */
    public boolean checkAutoGrowHeight() {
        return (autoGrowHeight_ != null);
    }

    /**
     * Sets the boolean property <b>autoGrowHeight</b>.
     *
     * @param autoGrowHeight
     */
    public void setAutoGrowHeight(boolean autoGrowHeight) {
        this.autoGrowHeight_ = new Boolean(autoGrowHeight);
    }

    /**
     * Sets the boolean property <b>autoGrowHeight</b>.
     *
     * @param autoGrowHeight
     */
    public void setAutoGrowHeight(Boolean autoGrowHeight) {
        this.autoGrowHeight_ = autoGrowHeight;
    }

    /**
     * Gets the String property <b>fillColor</b>.
     *
     * @return String
     */
    public String getFillColor() {
        return (fillColor_);
    }

    /**
     * Sets the String property <b>fillColor</b>.
     *
     * @param fillColor
     */
    public void setFillColor(String fillColor) {
        this.fillColor_ = fillColor;
    }

    /**
     * Gets the String property <b>minHeight</b>.
     *
     * @return String
     */
    public String getMinHeight() {
        return (minHeight_);
    }

    /**
     * Sets the String property <b>minHeight</b>.
     *
     * @param minHeight
     */
    public void setMinHeight(String minHeight) {
        this.minHeight_ = minHeight;
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
        URelaxer.makeQName(prefix, "graphic-properties", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (protect_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "protect", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getProtect())));
            buffer.append("\"");
        }
        if (autoGrowHeight_ != null) {
            buffer.append(" ");
            buffer.append("auto-grow-height");
            buffer.append("=\"");
            buffer.append(URelaxer.getString(getAutoGrowHeight()));
            buffer.append("\"");
        }
        if (fillColor_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "fill-color", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getFillColor())));
            buffer.append("\"");
        }
        if (minHeight_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("http://www.w3.org/1999/XSL/Format", "min-height", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getMinHeight())));
            buffer.append("\"");
        }
        buffer.append(">");
        buffer.append("</");
        URelaxer.makeQName(prefix, "graphic-properties", buffer);
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
        URelaxer.makeQName(prefix, "graphic-properties", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (protect_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "protect", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getProtect())));
            buffer.write("\"");
        }
        if (autoGrowHeight_ != null) {
            buffer.write(" ");
            buffer.write("auto-grow-height");
            buffer.write("=\"");
            buffer.write(URelaxer.getString(getAutoGrowHeight()));
            buffer.write("\"");
        }
        if (fillColor_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "fill-color", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getFillColor())));
            buffer.write("\"");
        }
        if (minHeight_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("http://www.w3.org/1999/XSL/Format", "min-height", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getMinHeight())));
            buffer.write("\"");
        }
        buffer.write(">");
        buffer.write("</");
        URelaxer.makeQName(prefix, "graphic-properties", buffer);
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
        URelaxer.makeQName(prefix, "graphic-properties", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (protect_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "protect", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getProtect())));
            buffer.print("\"");
        }
        if (autoGrowHeight_ != null) {
            buffer.print(" ");
            buffer.print("auto-grow-height");
            buffer.print("=\"");
            buffer.print(URelaxer.getString(getAutoGrowHeight()));
            buffer.print("\"");
        }
        if (fillColor_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "fill-color", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getFillColor())));
            buffer.print("\"");
        }
        if (minHeight_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("http://www.w3.org/1999/XSL/Format", "min-height", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getMinHeight())));
            buffer.print("\"");
        }
        buffer.print(">");
        buffer.print("</");
        URelaxer.makeQName(prefix, "graphic-properties", buffer);
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
    public String getProtectAsString() {
        return (URelaxer.getString(getProtect()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getAutoGrowHeightAsString() {
        return (URelaxer.getString(getAutoGrowHeight()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getFillColorAsString() {
        return (URelaxer.getString(getFillColor()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getMinHeightAsString() {
        return (URelaxer.getString(getMinHeight()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setProtectByString(String string) {
        setProtect(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setAutoGrowHeightByString(String string) {
        setAutoGrowHeight(new Boolean(string).booleanValue());
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setFillColorByString(String string) {
        setFillColor(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setMinHeightByString(String string) {
        setMinHeight(string);
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
     * for the <code>ODPGraphicProperties</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "graphic-properties")) {
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
     * is valid for the <code>ODPGraphicProperties</code>.
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
     * is valid for the <code>ODPGraphicProperties</code>.
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
