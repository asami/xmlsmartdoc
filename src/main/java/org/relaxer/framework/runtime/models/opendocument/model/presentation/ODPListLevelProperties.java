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
 * <b>ODPListLevelProperties</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="list-level-properties" ns="urn:oasis:names:tc:opendocument:xmlns:style:1.0">
 *       <attribute name="text:min-label-width">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="text:space-before">
 *         <data type="token"/>
 *       </attribute>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="list-level-properties" ns="urn:oasis:names:tc:opendocument:xmlns:style:1.0"&gt;
 *       &lt;attribute name="text:min-label-width"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="text:space-before"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:20 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPListLevelProperties implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
    private String minLabelWidth_;
    private String spaceBefore_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPListLevelProperties</code>.
     *
     */
    public ODPListLevelProperties() {
        rNSContext_.declareNamespaceWeak("p1", "urn:oasis:names:tc:opendocument:xmlns:text:1.0");
        rNSContext_.declareNamespaceWeak("p2", "urn:oasis:names:tc:opendocument:xmlns:text:1.0");
        minLabelWidth_ = "";
        spaceBefore_ = "";
    }

    /**
     * Creates a <code>ODPListLevelProperties</code>.
     *
     * @param source
     */
    public ODPListLevelProperties(ODPListLevelProperties source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPListLevelProperties</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPListLevelProperties(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPListLevelProperties</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPListLevelProperties(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPListLevelProperties</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPListLevelProperties(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPListLevelProperties</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListLevelProperties(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPListLevelProperties</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListLevelProperties(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPListLevelProperties</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListLevelProperties(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPListLevelProperties</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListLevelProperties(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPListLevelProperties</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListLevelProperties(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPListLevelProperties</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListLevelProperties(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPListLevelProperties</code> by the ODPListLevelProperties <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPListLevelProperties source) {
        int size;
        minLabelWidth_ = source.minLabelWidth_;
        spaceBefore_ = source.spaceBefore_;
    }

    /**
     * Initializes the <code>ODPListLevelProperties</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPListLevelProperties</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPListLevelProperties</code> by the Stack <code>stack</code>
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
        minLabelWidth_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "min-label-width");
        spaceBefore_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "space-before");
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPListLevelProperties((ODPListLevelProperties)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "list-level-properties");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.minLabelWidth_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "min-label-width", this.minLabelWidth_, rNSContext_);
        }
        if (this.spaceBefore_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "space-before", this.spaceBefore_, rNSContext_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPListLevelProperties</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPListLevelProperties</code>
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
     * Initializes the <code>ODPListLevelProperties</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPListLevelProperties</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPListLevelProperties</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPListLevelProperties</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>minLabelWidth</b>.
     *
     * @return String
     */
    public String getMinLabelWidth() {
        return (minLabelWidth_);
    }

    /**
     * Sets the String property <b>minLabelWidth</b>.
     *
     * @param minLabelWidth
     */
    public void setMinLabelWidth(String minLabelWidth) {
        this.minLabelWidth_ = minLabelWidth;
    }

    /**
     * Gets the String property <b>spaceBefore</b>.
     *
     * @return String
     */
    public String getSpaceBefore() {
        return (spaceBefore_);
    }

    /**
     * Sets the String property <b>spaceBefore</b>.
     *
     * @param spaceBefore
     */
    public void setSpaceBefore(String spaceBefore) {
        this.spaceBefore_ = spaceBefore;
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
        URelaxer.makeQName(prefix, "list-level-properties", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (minLabelWidth_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "min-label-width", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getMinLabelWidth())));
            buffer.append("\"");
        }
        if (spaceBefore_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "space-before", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getSpaceBefore())));
            buffer.append("\"");
        }
        buffer.append(">");
        buffer.append("</");
        URelaxer.makeQName(prefix, "list-level-properties", buffer);
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
        URelaxer.makeQName(prefix, "list-level-properties", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (minLabelWidth_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "min-label-width", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getMinLabelWidth())));
            buffer.write("\"");
        }
        if (spaceBefore_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "space-before", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getSpaceBefore())));
            buffer.write("\"");
        }
        buffer.write(">");
        buffer.write("</");
        URelaxer.makeQName(prefix, "list-level-properties", buffer);
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
        URelaxer.makeQName(prefix, "list-level-properties", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (minLabelWidth_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "min-label-width", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getMinLabelWidth())));
            buffer.print("\"");
        }
        if (spaceBefore_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "space-before", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getSpaceBefore())));
            buffer.print("\"");
        }
        buffer.print(">");
        buffer.print("</");
        URelaxer.makeQName(prefix, "list-level-properties", buffer);
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
    public String getMinLabelWidthAsString() {
        return (URelaxer.getString(getMinLabelWidth()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getSpaceBeforeAsString() {
        return (URelaxer.getString(getSpaceBefore()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setMinLabelWidthByString(String string) {
        setMinLabelWidth(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setSpaceBeforeByString(String string) {
        setSpaceBefore(string);
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
     * for the <code>ODPListLevelProperties</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "list-level-properties")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "min-label-width")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "space-before")) {
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
     * is valid for the <code>ODPListLevelProperties</code>.
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
     * is valid for the <code>ODPListLevelProperties</code>.
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
