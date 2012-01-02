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
 * <b>ODPStyle</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="style" ns="urn:oasis:names:tc:opendocument:xmlns:style:1.0">
 *       <attribute name="style:family">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="style:name">
 *         <data type="token"/>
 *       </attribute>
 *       <optional>
 *         <attribute name="style:parent-style-name">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <optional>
 *         <attribute name="style:list-style-name">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <choice>
 *         <ref name="drawing-page-properties"/>
 *         <ref name="graphic-properties"/>
 *         <ref name="paragraph-properties"/>
 *       </choice>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="style" ns="urn:oasis:names:tc:opendocument:xmlns:style:1.0"&gt;
 *       &lt;attribute name="style:family"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="style:name"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="style:parent-style-name"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="style:list-style-name"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;choice&gt;
 *         &lt;ref name="drawing-page-properties"/&gt;
 *         &lt;ref name="graphic-properties"/&gt;
 *         &lt;ref name="paragraph-properties"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:20 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPStyle implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
    private String family_;
    private String name_;
    private String parentStyleName_;
    private String listStyleName_;
    private IODPStyleChoice content_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPStyle</code>.
     *
     */
    public ODPStyle() {
        rNSContext_.declareNamespaceWeak("p1", "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
        rNSContext_.declareNamespaceWeak("p2", "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
        rNSContext_.declareNamespaceWeak("p3", "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
        rNSContext_.declareNamespaceWeak("p4", "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
        family_ = "";
        name_ = "";
    }

    /**
     * Creates a <code>ODPStyle</code>.
     *
     * @param source
     */
    public ODPStyle(ODPStyle source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPStyle</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPStyle(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPStyle</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPStyle(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPStyle</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPStyle(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPStyle</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPStyle(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPStyle</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPStyle(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPStyle</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPStyle(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPStyle</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPStyle(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPStyle</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPStyle(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPStyle</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPStyle(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPStyle</code> by the ODPStyle <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPStyle source) {
        int size;
        family_ = source.family_;
        name_ = source.name_;
        parentStyleName_ = source.parentStyleName_;
        listStyleName_ = source.listStyleName_;
        if (source.content_ != null) {
            setContent((IODPStyleChoice)source.getContent().clone());
        }
    }

    /**
     * Initializes the <code>ODPStyle</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPStyle</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPStyle</code> by the Stack <code>stack</code>
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
        family_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "family");
        name_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "name");
        parentStyleName_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "parent-style-name");
        listStyleName_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "list-style-name");
        if (ODPDrawingPageProperties.isMatch(stack)) {
            setContent(new ODPDrawingPageProperties(stack));
        } else if (ODPGraphicProperties.isMatch(stack)) {
            setContent(new ODPGraphicProperties(stack));
        } else if (ODPParagraphProperties.isMatch(stack)) {
            setContent(new ODPParagraphProperties(stack));
        } else {
            throw (new IllegalArgumentException());
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPStyle((ODPStyle)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "style");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.family_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "family", this.family_, rNSContext_);
        }
        if (this.name_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "name", this.name_, rNSContext_);
        }
        if (this.parentStyleName_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "parent-style-name", this.parentStyleName_, rNSContext_);
        }
        if (this.listStyleName_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "list-style-name", this.listStyleName_, rNSContext_);
        }
        this.content_.makeElement(element);
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPStyle</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPStyle</code>
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
     * Initializes the <code>ODPStyle</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPStyle</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPStyle</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPStyle</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>family</b>.
     *
     * @return String
     */
    public String getFamily() {
        return (family_);
    }

    /**
     * Sets the String property <b>family</b>.
     *
     * @param family
     */
    public void setFamily(String family) {
        this.family_ = family;
    }

    /**
     * Gets the String property <b>name</b>.
     *
     * @return String
     */
    public String getName() {
        return (name_);
    }

    /**
     * Sets the String property <b>name</b>.
     *
     * @param name
     */
    public void setName(String name) {
        this.name_ = name;
    }

    /**
     * Gets the String property <b>parentStyleName</b>.
     *
     * @return String
     */
    public String getParentStyleName() {
        return (parentStyleName_);
    }

    /**
     * Sets the String property <b>parentStyleName</b>.
     *
     * @param parentStyleName
     */
    public void setParentStyleName(String parentStyleName) {
        this.parentStyleName_ = parentStyleName;
    }

    /**
     * Gets the String property <b>listStyleName</b>.
     *
     * @return String
     */
    public String getListStyleName() {
        return (listStyleName_);
    }

    /**
     * Sets the String property <b>listStyleName</b>.
     *
     * @param listStyleName
     */
    public void setListStyleName(String listStyleName) {
        this.listStyleName_ = listStyleName;
    }

    /**
     * Gets the IODPStyleChoice property <b>content</b>.
     *
     * @return IODPStyleChoice
     */
    public IODPStyleChoice getContent() {
        return (content_);
    }

    /**
     * Sets the IODPStyleChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IODPStyleChoice content) {
        this.content_ = content;
        if (content != null) {
            content.rSetParentRNode(this);
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
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:style:1.0");
        buffer.append("<");
        URelaxer.makeQName(prefix, "style", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (family_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "family", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getFamily())));
            buffer.append("\"");
        }
        if (name_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
        if (parentStyleName_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "parent-style-name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getParentStyleName())));
            buffer.append("\"");
        }
        if (listStyleName_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "list-style-name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getListStyleName())));
            buffer.append("\"");
        }
        content_.makeTextAttribute(buffer);
        buffer.append(">");
        content_.makeTextElement(buffer);
        buffer.append("</");
        URelaxer.makeQName(prefix, "style", buffer);
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
        URelaxer.makeQName(prefix, "style", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (family_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "family", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getFamily())));
            buffer.write("\"");
        }
        if (name_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
        if (parentStyleName_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "parent-style-name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getParentStyleName())));
            buffer.write("\"");
        }
        if (listStyleName_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "list-style-name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getListStyleName())));
            buffer.write("\"");
        }
        content_.makeTextAttribute(buffer);
        buffer.write(">");
        content_.makeTextElement(buffer);
        buffer.write("</");
        URelaxer.makeQName(prefix, "style", buffer);
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
        URelaxer.makeQName(prefix, "style", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (family_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "family", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getFamily())));
            buffer.print("\"");
        }
        if (name_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
        if (parentStyleName_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "parent-style-name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getParentStyleName())));
            buffer.print("\"");
        }
        if (listStyleName_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "list-style-name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getListStyleName())));
            buffer.print("\"");
        }
        content_.makeTextAttribute(buffer);
        buffer.print(">");
        content_.makeTextElement(buffer);
        buffer.print("</");
        URelaxer.makeQName(prefix, "style", buffer);
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
    public String getFamilyAsString() {
        return (URelaxer.getString(getFamily()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getNameAsString() {
        return (URelaxer.getString(getName()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getParentStyleNameAsString() {
        return (URelaxer.getString(getParentStyleName()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getListStyleNameAsString() {
        return (URelaxer.getString(getListStyleName()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setFamilyByString(String string) {
        setFamily(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setNameByString(String string) {
        setName(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setParentStyleNameByString(String string) {
        setParentStyleName(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setListStyleNameByString(String string) {
        setListStyleName(string);
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
        if (content_ != null) {
            classNodes.add(content_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>ODPStyle</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "style")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "family")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "name")) {
            return (false);
        }
        $match$ = true;
        if (ODPDrawingPageProperties.isMatchHungry(target)) {
            $match$ = true;
        } else if (ODPGraphicProperties.isMatchHungry(target)) {
            $match$ = true;
        } else if (ODPParagraphProperties.isMatchHungry(target)) {
            $match$ = true;
        } else {
            return (false);
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>ODPStyle</code>.
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
     * is valid for the <code>ODPStyle</code>.
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
