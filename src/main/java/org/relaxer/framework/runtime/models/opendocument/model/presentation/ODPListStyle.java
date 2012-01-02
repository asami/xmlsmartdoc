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
 * <b>ODPListStyle</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="list-style" ns="urn:oasis:names:tc:opendocument:xmlns:text:1.0">
 *       <attribute name="style:name">
 *         <data type="token"/>
 *       </attribute>
 *       <oneOrMore>
 *         <ref name="list-level-style-bullet"/>
 *       </oneOrMore>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="list-style" ns="urn:oasis:names:tc:opendocument:xmlns:text:1.0"&gt;
 *       &lt;attribute name="style:name"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;oneOrMore&gt;
 *         &lt;ref name="list-level-style-bullet"/&gt;
 *       &lt;/oneOrMore&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:19 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPListStyle implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:text:1.0");
    private String name_;
    // List<ODPListLevelStyleBullet>
    private java.util.List listLevelStyleBullet_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPListStyle</code>.
     *
     */
    public ODPListStyle() {
        rNSContext_.declareNamespaceWeak("p1", "urn:oasis:names:tc:opendocument:xmlns:style:1.0");
        name_ = "";
    }

    /**
     * Creates a <code>ODPListStyle</code>.
     *
     * @param source
     */
    public ODPListStyle(ODPListStyle source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPListStyle</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPListStyle(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPListStyle</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPListStyle(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPListStyle</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPListStyle(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPListStyle</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListStyle(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPListStyle</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListStyle(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPListStyle</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListStyle(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPListStyle</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListStyle(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPListStyle</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListStyle(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPListStyle</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPListStyle(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPListStyle</code> by the ODPListStyle <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPListStyle source) {
        int size;
        name_ = source.name_;
        this.listLevelStyleBullet_.clear();
        size = source.listLevelStyleBullet_.size();
        for (int i = 0;i < size;i++) {
            addListLevelStyleBullet((ODPListLevelStyleBullet)source.getListLevelStyleBullet(i).clone());
        }
    }

    /**
     * Initializes the <code>ODPListStyle</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPListStyle</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPListStyle</code> by the Stack <code>stack</code>
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
        name_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "name");
        listLevelStyleBullet_.clear();
        while (true) {
            if (ODPListLevelStyleBullet.isMatch(stack)) {
                addListLevelStyleBullet(new ODPListLevelStyleBullet(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPListStyle((ODPListStyle)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "list-style");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.name_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "name", this.name_, rNSContext_);
        }
        size = this.listLevelStyleBullet_.size();
        for (int i = 0;i < size;i++) {
            ODPListLevelStyleBullet value = (ODPListLevelStyleBullet)this.listLevelStyleBullet_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPListStyle</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPListStyle</code>
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
     * Initializes the <code>ODPListStyle</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPListStyle</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPListStyle</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPListStyle</code> by the Reader <code>reader</code>.
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
     * Gets the ODPListLevelStyleBullet property <b>listLevelStyleBullet</b>.
     *
     * @return ODPListLevelStyleBullet[]
     */
    public ODPListLevelStyleBullet[] getListLevelStyleBullet() {
        ODPListLevelStyleBullet[] array = new ODPListLevelStyleBullet[listLevelStyleBullet_.size()];
        return ((ODPListLevelStyleBullet[])listLevelStyleBullet_.toArray(array));
    }

    /**
     * Sets the ODPListLevelStyleBullet property <b>listLevelStyleBullet</b>.
     *
     * @param listLevelStyleBullet
     */
    public void setListLevelStyleBullet(ODPListLevelStyleBullet[] listLevelStyleBullet) {
        this.listLevelStyleBullet_.clear();
        for (int i = 0;i < listLevelStyleBullet.length;i++) {
            addListLevelStyleBullet(listLevelStyleBullet[i]);
        }
        for (int i = 0;i < listLevelStyleBullet.length;i++) {
            listLevelStyleBullet[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the ODPListLevelStyleBullet property <b>listLevelStyleBullet</b>.
     *
     * @param listLevelStyleBullet
     */
    public void setListLevelStyleBullet(ODPListLevelStyleBullet listLevelStyleBullet) {
        this.listLevelStyleBullet_.clear();
        addListLevelStyleBullet(listLevelStyleBullet);
        if (listLevelStyleBullet != null) {
            listLevelStyleBullet.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPListLevelStyleBullet property <b>listLevelStyleBullet</b>.
     *
     * @param listLevelStyleBullet
     */
    public void addListLevelStyleBullet(ODPListLevelStyleBullet listLevelStyleBullet) {
        this.listLevelStyleBullet_.add(listLevelStyleBullet);
        if (listLevelStyleBullet != null) {
            listLevelStyleBullet.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPListLevelStyleBullet property <b>listLevelStyleBullet</b>.
     *
     * @param listLevelStyleBullet
     */
    public void addListLevelStyleBullet(ODPListLevelStyleBullet[] listLevelStyleBullet) {
        for (int i = 0;i < listLevelStyleBullet.length;i++) {
            addListLevelStyleBullet(listLevelStyleBullet[i]);
        }
        for (int i = 0;i < listLevelStyleBullet.length;i++) {
            listLevelStyleBullet[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the ODPListLevelStyleBullet property <b>listLevelStyleBullet</b>.
     *
     * @return int
     */
    public int sizeListLevelStyleBullet() {
        return (listLevelStyleBullet_.size());
    }

    /**
     * Gets the ODPListLevelStyleBullet property <b>listLevelStyleBullet</b> by index.
     *
     * @param index
     * @return ODPListLevelStyleBullet
     */
    public ODPListLevelStyleBullet getListLevelStyleBullet(int index) {
        return ((ODPListLevelStyleBullet)listLevelStyleBullet_.get(index));
    }

    /**
     * Sets the ODPListLevelStyleBullet property <b>listLevelStyleBullet</b> by index.
     *
     * @param index
     * @param listLevelStyleBullet
     */
    public void setListLevelStyleBullet(int index, ODPListLevelStyleBullet listLevelStyleBullet) {
        this.listLevelStyleBullet_.set(index, listLevelStyleBullet);
        if (listLevelStyleBullet != null) {
            listLevelStyleBullet.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPListLevelStyleBullet property <b>listLevelStyleBullet</b> by index.
     *
     * @param index
     * @param listLevelStyleBullet
     */
    public void addListLevelStyleBullet(int index, ODPListLevelStyleBullet listLevelStyleBullet) {
        this.listLevelStyleBullet_.add(index, listLevelStyleBullet);
        if (listLevelStyleBullet != null) {
            listLevelStyleBullet.rSetParentRNode(this);
        }
    }

    /**
     * Remove the ODPListLevelStyleBullet property <b>listLevelStyleBullet</b> by index.
     *
     * @param index
     */
    public void removeListLevelStyleBullet(int index) {
        this.listLevelStyleBullet_.remove(index);
    }

    /**
     * Remove the ODPListLevelStyleBullet property <b>listLevelStyleBullet</b> by object.
     *
     * @param listLevelStyleBullet
     */
    public void removeListLevelStyleBullet(ODPListLevelStyleBullet listLevelStyleBullet) {
        this.listLevelStyleBullet_.remove(listLevelStyleBullet);
    }

    /**
     * Clear the ODPListLevelStyleBullet property <b>listLevelStyleBullet</b>.
     *
     */
    public void clearListLevelStyleBullet() {
        this.listLevelStyleBullet_.clear();
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
        URelaxer.makeQName(prefix, "list-style", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.listLevelStyleBullet_.size();
        for (int i = 0;i < size;i++) {
            ODPListLevelStyleBullet value = (ODPListLevelStyleBullet)this.listLevelStyleBullet_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "list-style", buffer);
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
        URelaxer.makeQName(prefix, "list-style", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.listLevelStyleBullet_.size();
        for (int i = 0;i < size;i++) {
            ODPListLevelStyleBullet value = (ODPListLevelStyleBullet)this.listLevelStyleBullet_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "list-style", buffer);
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
        URelaxer.makeQName(prefix, "list-style", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (name_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:style:1.0", "name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.listLevelStyleBullet_.size();
        for (int i = 0;i < size;i++) {
            ODPListLevelStyleBullet value = (ODPListLevelStyleBullet)this.listLevelStyleBullet_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "list-style", buffer);
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
    public String getNameAsString() {
        return (URelaxer.getString(getName()));
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
        classNodes.addAll(listLevelStyleBullet_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>ODPListStyle</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "list-style")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:style:1.0", "name")) {
            return (false);
        }
        $match$ = true;
        if (!ODPListLevelStyleBullet.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!ODPListLevelStyleBullet.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>ODPListStyle</code>.
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
     * is valid for the <code>ODPListStyle</code>.
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
