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
 * <b>ODPListLevelStyleBullet</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="list-level-style-bullet" ns="urn:oasis:names:tc:opendocument:xmlns:text:1.0">
 *       <attribute name="text:bullet-char">
 *         <data type="token"/>
 *       </attribute>
 *       <attribute name="text:level">
 *         <data type="int"/>
 *       </attribute>
 *       <optional>
 *         <ref name="list-level-properties"/>
 *       </optional>
 *       <ref name="text-properties"/>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="list-level-style-bullet" ns="urn:oasis:names:tc:opendocument:xmlns:text:1.0"&gt;
 *       &lt;attribute name="text:bullet-char"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="text:level"&gt;
 *         &lt;data type="int"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;optional&gt;
 *         &lt;ref name="list-level-properties"/&gt;
 *       &lt;/optional&gt;
 *       &lt;ref name="text-properties"/&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:19 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPListLevelStyleBullet implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:text:1.0");
    private String bulletChar_;
    private int level_;
    private ODPListLevelProperties listLevelProperties_;
    private ODPTextProperties textProperties_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPListLevelStyleBullet</code>.
     *
     */
    public ODPListLevelStyleBullet() {
        rNSContext_.declareNamespaceWeak("p1", "urn:oasis:names:tc:opendocument:xmlns:text:1.0");
        rNSContext_.declareNamespaceWeak("p2", "urn:oasis:names:tc:opendocument:xmlns:text:1.0");
        bulletChar_ = "";
    }

    /**
     * Creates a <code>ODPListLevelStyleBullet</code>.
     *
     * @param source
     */
    public ODPListLevelStyleBullet(ODPListLevelStyleBullet source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPListLevelStyleBullet</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPListLevelStyleBullet(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPListLevelStyleBullet</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPListLevelStyleBullet(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPListLevelStyleBullet</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPListLevelStyleBullet(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPListLevelStyleBullet</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListLevelStyleBullet(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPListLevelStyleBullet</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListLevelStyleBullet(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPListLevelStyleBullet</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListLevelStyleBullet(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPListLevelStyleBullet</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListLevelStyleBullet(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPListLevelStyleBullet</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListLevelStyleBullet(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPListLevelStyleBullet</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListLevelStyleBullet(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPListLevelStyleBullet</code> by the ODPListLevelStyleBullet <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPListLevelStyleBullet source) {
        int size;
        bulletChar_ = source.bulletChar_;
        level_ = source.level_;
        if (source.listLevelProperties_ != null) {
            setListLevelProperties((ODPListLevelProperties)source.getListLevelProperties().clone());
        }
        if (source.textProperties_ != null) {
            setTextProperties((ODPTextProperties)source.getTextProperties().clone());
        }
    }

    /**
     * Initializes the <code>ODPListLevelStyleBullet</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPListLevelStyleBullet</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPListLevelStyleBullet</code> by the Stack <code>stack</code>
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
        bulletChar_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "bullet-char");
        level_ = URelaxer2.getAttributePropertyAsInt(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "level");
        if (ODPListLevelProperties.isMatch(stack)) {
            setListLevelProperties(new ODPListLevelProperties(stack));
        }
        setTextProperties(new ODPTextProperties(stack));
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPListLevelStyleBullet((ODPListLevelStyleBullet)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "list-level-style-bullet");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.bulletChar_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "bullet-char", this.bulletChar_, rNSContext_);
        }
        URelaxer2.setAttributePropertyByInt(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "level", this.level_, rNSContext_);
        if (this.listLevelProperties_ != null) {
            this.listLevelProperties_.makeElement(element);
        }
        this.textProperties_.makeElement(element);
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPListLevelStyleBullet</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPListLevelStyleBullet</code>
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
     * Initializes the <code>ODPListLevelStyleBullet</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPListLevelStyleBullet</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPListLevelStyleBullet</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPListLevelStyleBullet</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>bulletChar</b>.
     *
     * @return String
     */
    public String getBulletChar() {
        return (bulletChar_);
    }

    /**
     * Sets the String property <b>bulletChar</b>.
     *
     * @param bulletChar
     */
    public void setBulletChar(String bulletChar) {
        this.bulletChar_ = bulletChar;
    }

    /**
     * Gets the int property <b>level</b>.
     *
     * @return int
     */
    public int getLevel() {
        return (level_);
    }

    /**
     * Sets the int property <b>level</b>.
     *
     * @param level
     */
    public void setLevel(int level) {
        this.level_ = level;
    }

    /**
     * Gets the int property <b>level</b>.
     *
     * @return Integer
     */
    public Integer getLevelAsInteger() {
        return (new Integer(level_));
    }

    /**
     * Sets the int property <b>level</b>.
     *
     * @param level
     */
    public void setLevel(Integer level) {
        this.level_ = level.intValue();
    }

    /**
     * Gets the ODPListLevelProperties property <b>listLevelProperties</b>.
     *
     * @return ODPListLevelProperties
     */
    public ODPListLevelProperties getListLevelProperties() {
        return (listLevelProperties_);
    }

    /**
     * Sets the ODPListLevelProperties property <b>listLevelProperties</b>.
     *
     * @param listLevelProperties
     */
    public void setListLevelProperties(ODPListLevelProperties listLevelProperties) {
        this.listLevelProperties_ = listLevelProperties;
        if (listLevelProperties != null) {
            listLevelProperties.rSetParentRNode(this);
        }
    }

    /**
     * Gets the ODPTextProperties property <b>textProperties</b>.
     *
     * @return ODPTextProperties
     */
    public ODPTextProperties getTextProperties() {
        return (textProperties_);
    }

    /**
     * Sets the ODPTextProperties property <b>textProperties</b>.
     *
     * @param textProperties
     */
    public void setTextProperties(ODPTextProperties textProperties) {
        this.textProperties_ = textProperties;
        if (textProperties != null) {
            textProperties.rSetParentRNode(this);
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
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:text:1.0");
        buffer.append("<");
        URelaxer.makeQName(prefix, "list-level-style-bullet", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (bulletChar_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "bullet-char", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getBulletChar())));
            buffer.append("\"");
        }
        buffer.append(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "level", buffer);
        buffer.append("=\"");
        buffer.append(URelaxer.getString(getLevel()));
        buffer.append("\"");
        buffer.append(">");
        if (listLevelProperties_ != null) {
            listLevelProperties_.makeTextElement(buffer);
        }
        textProperties_.makeTextElement(buffer);
        buffer.append("</");
        URelaxer.makeQName(prefix, "list-level-style-bullet", buffer);
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
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:text:1.0");
        buffer.write("<");
        URelaxer.makeQName(prefix, "list-level-style-bullet", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (bulletChar_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "bullet-char", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getBulletChar())));
            buffer.write("\"");
        }
        buffer.write(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "level", buffer);
        buffer.write("=\"");
        buffer.write(URelaxer.getString(getLevel()));
        buffer.write("\"");
        buffer.write(">");
        if (listLevelProperties_ != null) {
            listLevelProperties_.makeTextElement(buffer);
        }
        textProperties_.makeTextElement(buffer);
        buffer.write("</");
        URelaxer.makeQName(prefix, "list-level-style-bullet", buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:text:1.0");
        buffer.print("<");
        URelaxer.makeQName(prefix, "list-level-style-bullet", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (bulletChar_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "bullet-char", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getBulletChar())));
            buffer.print("\"");
        }
        buffer.print(" ");
        rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "level", buffer);
        buffer.print("=\"");
        buffer.print(URelaxer.getString(getLevel()));
        buffer.print("\"");
        buffer.print(">");
        if (listLevelProperties_ != null) {
            listLevelProperties_.makeTextElement(buffer);
        }
        textProperties_.makeTextElement(buffer);
        buffer.print("</");
        URelaxer.makeQName(prefix, "list-level-style-bullet", buffer);
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
    public String getBulletCharAsString() {
        return (URelaxer.getString(getBulletChar()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getLevelAsString() {
        return (URelaxer.getString(getLevel()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setBulletCharByString(String string) {
        setBulletChar(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setLevelByString(String string) {
        setLevel(Integer.parseInt(string));
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
        if (listLevelProperties_ != null) {
            classNodes.add(listLevelProperties_);
        }
        if (textProperties_ != null) {
            classNodes.add(textProperties_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>ODPListLevelStyleBullet</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "list-level-style-bullet")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "bullet-char")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "level")) {
            return (false);
        }
        $match$ = true;
        if (ODPListLevelProperties.isMatchHungry(target)) {
        }
        if (!ODPTextProperties.isMatchHungry(target)) {
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
     * is valid for the <code>ODPListLevelStyleBullet</code>.
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
     * is valid for the <code>ODPListLevelStyleBullet</code>.
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
