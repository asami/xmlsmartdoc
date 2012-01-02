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
 * <b>ODPTextProperties</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="text-properties" ns="urn:oasis:names:tc:opendocument:xmlns:style:1.0">
 *       <attribute name="fo:font-family">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="fo:font-size">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="style:use-window-font-color">
 *         <data type="boolean"/>
 *       </attribute>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="text-properties" ns="urn:oasis:names:tc:opendocument:xmlns:style:1.0"&gt;
 *       &lt;attribute name="fo:font-family"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="fo:font-size"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="style:use-window-font-color"&gt;
 *         &lt;data type="boolean"/&gt;
 *       &lt;/attribute&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:20 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPTextProperties implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
    private String fontFamily_;
    private String fontSize_;
    private boolean useWindowFontColor_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPTextProperties</code>.
     *
     */
    public ODPTextProperties() {
        rNSContext_.declareNamespaceWeak("p1", "http://www.w3.org/1999/XSL/Format");
        rNSContext_.declareNamespaceWeak("p2", "http://www.w3.org/1999/XSL/Format");
        rNSContext_.declareNamespaceWeak("p3", "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
        fontFamily_ = "";
        fontSize_ = "";
    }

    /**
     * Creates a <code>ODPTextProperties</code>.
     *
     * @param source
     */
    public ODPTextProperties(ODPTextProperties source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPTextProperties</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPTextProperties(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPTextProperties</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPTextProperties(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPTextProperties</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPTextProperties(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPTextProperties</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPTextProperties(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPTextProperties</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPTextProperties(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPTextProperties</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPTextProperties(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPTextProperties</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPTextProperties(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPTextProperties</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPTextProperties(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPTextProperties</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPTextProperties(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPTextProperties</code> by the ODPTextProperties <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPTextProperties source) {
        int size;
        fontFamily_ = source.fontFamily_;
        fontSize_ = source.fontSize_;
        useWindowFontColor_ = source.useWindowFontColor_;
    }

    /**
     * Initializes the <code>ODPTextProperties</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPTextProperties</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPTextProperties</code> by the Stack <code>stack</code>
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
        fontFamily_ = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1999/XSL/Format", "font-family");
        fontSize_ = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1999/XSL/Format", "font-size");
        useWindowFontColor_ = URelaxer2.getAttributePropertyAsBoolean(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "use-window-font-color");
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPTextProperties((ODPTextProperties)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "text-properties");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.fontFamily_ != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1999/XSL/Format", "font-family", this.fontFamily_, rNSContext_);
        }
        if (this.fontSize_ != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1999/XSL/Format", "font-size", this.fontSize_, rNSContext_);
        }
        URelaxer2.setAttributePropertyByBoolean(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "use-window-font-color", this.useWindowFontColor_, rNSContext_);
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPTextProperties</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPTextProperties</code>
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
     * Initializes the <code>ODPTextProperties</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPTextProperties</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPTextProperties</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPTextProperties</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>fontFamily</b>.
     *
     * @return String
     */
    public String getFontFamily() {
        return (fontFamily_);
    }

    /**
     * Sets the String property <b>fontFamily</b>.
     *
     * @param fontFamily
     */
    public void setFontFamily(String fontFamily) {
        this.fontFamily_ = fontFamily;
    }

    /**
     * Gets the String property <b>fontSize</b>.
     *
     * @return String
     */
    public String getFontSize() {
        return (fontSize_);
    }

    /**
     * Sets the String property <b>fontSize</b>.
     *
     * @param fontSize
     */
    public void setFontSize(String fontSize) {
        this.fontSize_ = fontSize;
    }

    /**
     * Gets the boolean property <b>useWindowFontColor</b>.
     *
     * @return boolean
     */
    public boolean getUseWindowFontColor() {
        return (useWindowFontColor_);
    }

    /**
     * Sets the boolean property <b>useWindowFontColor</b>.
     *
     * @param useWindowFontColor
     */
    public void setUseWindowFontColor(boolean useWindowFontColor) {
        this.useWindowFontColor_ = useWindowFontColor;
    }

    /**
     * Gets the boolean property <b>useWindowFontColor</b>.
     *
     * @return Boolean
     */
    public Boolean getUseWindowFontColorAsBoolean() {
        return (new Boolean(useWindowFontColor_));
    }

    /**
     * Sets the boolean property <b>useWindowFontColor</b>.
     *
     * @param useWindowFontColor
     */
    public void setUseWindowFontColor(Boolean useWindowFontColor) {
        this.useWindowFontColor_ = useWindowFontColor.booleanValue();
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
        URelaxer.makeQName(prefix, "text-properties", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (fontFamily_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("http://www.w3.org/1999/XSL/Format", "font-family", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getFontFamily())));
            buffer.append("\"");
        }
        if (fontSize_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("http://www.w3.org/1999/XSL/Format", "font-size", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getFontSize())));
            buffer.append("\"");
        }
        buffer.append(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "use-window-font-color", buffer);
        buffer.append("=\"");
        buffer.append(URelaxer.getString(getUseWindowFontColor()));
        buffer.append("\"");
        buffer.append(">");
        buffer.append("</");
        URelaxer.makeQName(prefix, "text-properties", buffer);
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
        URelaxer.makeQName(prefix, "text-properties", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (fontFamily_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("http://www.w3.org/1999/XSL/Format", "font-family", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getFontFamily())));
            buffer.write("\"");
        }
        if (fontSize_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("http://www.w3.org/1999/XSL/Format", "font-size", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getFontSize())));
            buffer.write("\"");
        }
        buffer.write(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "use-window-font-color", buffer);
        buffer.write("=\"");
        buffer.write(URelaxer.getString(getUseWindowFontColor()));
        buffer.write("\"");
        buffer.write(">");
        buffer.write("</");
        URelaxer.makeQName(prefix, "text-properties", buffer);
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
        URelaxer.makeQName(prefix, "text-properties", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (fontFamily_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("http://www.w3.org/1999/XSL/Format", "font-family", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getFontFamily())));
            buffer.print("\"");
        }
        if (fontSize_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("http://www.w3.org/1999/XSL/Format", "font-size", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getFontSize())));
            buffer.print("\"");
        }
        buffer.print(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "use-window-font-color", buffer);
        buffer.print("=\"");
        buffer.print(URelaxer.getString(getUseWindowFontColor()));
        buffer.print("\"");
        buffer.print(">");
        buffer.print("</");
        URelaxer.makeQName(prefix, "text-properties", buffer);
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
    public String getFontFamilyAsString() {
        return (URelaxer.getString(getFontFamily()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getFontSizeAsString() {
        return (URelaxer.getString(getFontSize()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getUseWindowFontColorAsString() {
        return (URelaxer.getString(getUseWindowFontColor()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setFontFamilyByString(String string) {
        setFontFamily(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setFontSizeByString(String string) {
        setFontSize(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setUseWindowFontColorByString(String string) {
        setUseWindowFontColor(new Boolean(string).booleanValue());
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
     * for the <code>ODPTextProperties</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "text-properties")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer2.hasAttributeHungry(target, "http://www.w3.org/1999/XSL/Format", "font-family")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "http://www.w3.org/1999/XSL/Format", "font-size")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "use-window-font-color")) {
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
     * is valid for the <code>ODPTextProperties</code>.
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
     * is valid for the <code>ODPTextProperties</code>.
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
