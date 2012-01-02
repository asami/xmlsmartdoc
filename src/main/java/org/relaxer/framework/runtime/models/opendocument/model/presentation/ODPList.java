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
 * <b>ODPList</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="list" ns="urn:oasis:names:tc:opendocument:xmlns:text:1.0">
 *       <optional>
 *         <attribute name="text:style-name">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <zeroOrMore>
 *         <ref name="list-item"/>
 *       </zeroOrMore>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="list" ns="urn:oasis:names:tc:opendocument:xmlns:text:1.0"&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="text:style-name"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="list-item"/&gt;
 *       &lt;/zeroOrMore&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:19 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPList implements java.io.Serializable, Cloneable, IRNSContainer, IODPListItemChoice, IRNode, IODPTextBoxChoice {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:text:1.0");
    private String styleName_;
    // List<ODPListItem>
    private java.util.List listItem_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPList</code>.
     *
     */
    public ODPList() {
        rNSContext_.declareNamespaceWeak("p1", "urn:oasis:names:tc:opendocument:xmlns:text:1.0");
    }

    /**
     * Creates a <code>ODPList</code>.
     *
     * @param source
     */
    public ODPList(ODPList source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPList</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPList(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPList</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPList(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPList</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPList(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPList</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPList(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPList</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPList(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPList</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPList(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPList</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPList(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPList</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPList(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPList</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPList(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPList</code> by the ODPList <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPList source) {
        int size;
        styleName_ = source.styleName_;
        this.listItem_.clear();
        size = source.listItem_.size();
        for (int i = 0;i < size;i++) {
            addListItem((ODPListItem)source.getListItem(i).clone());
        }
    }

    /**
     * Initializes the <code>ODPList</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPList</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPList</code> by the Stack <code>stack</code>
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
        styleName_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "style-name");
        listItem_.clear();
        while (true) {
            if (ODPListItem.isMatch(stack)) {
                addListItem(new ODPListItem(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPList((ODPList)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "list");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.styleName_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "style-name", this.styleName_, rNSContext_);
        }
        size = this.listItem_.size();
        for (int i = 0;i < size;i++) {
            ODPListItem value = (ODPListItem)this.listItem_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPList</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPList</code>
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
     * Initializes the <code>ODPList</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPList</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPList</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPList</code> by the Reader <code>reader</code>.
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
     * Gets the ODPListItem property <b>listItem</b>.
     *
     * @return ODPListItem[]
     */
    public ODPListItem[] getListItem() {
        ODPListItem[] array = new ODPListItem[listItem_.size()];
        return ((ODPListItem[])listItem_.toArray(array));
    }

    /**
     * Sets the ODPListItem property <b>listItem</b>.
     *
     * @param listItem
     */
    public void setListItem(ODPListItem[] listItem) {
        this.listItem_.clear();
        for (int i = 0;i < listItem.length;i++) {
            addListItem(listItem[i]);
        }
        for (int i = 0;i < listItem.length;i++) {
            listItem[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the ODPListItem property <b>listItem</b>.
     *
     * @param listItem
     */
    public void setListItem(ODPListItem listItem) {
        this.listItem_.clear();
        addListItem(listItem);
        if (listItem != null) {
            listItem.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPListItem property <b>listItem</b>.
     *
     * @param listItem
     */
    public void addListItem(ODPListItem listItem) {
        this.listItem_.add(listItem);
        if (listItem != null) {
            listItem.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPListItem property <b>listItem</b>.
     *
     * @param listItem
     */
    public void addListItem(ODPListItem[] listItem) {
        for (int i = 0;i < listItem.length;i++) {
            addListItem(listItem[i]);
        }
        for (int i = 0;i < listItem.length;i++) {
            listItem[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the ODPListItem property <b>listItem</b>.
     *
     * @return int
     */
    public int sizeListItem() {
        return (listItem_.size());
    }

    /**
     * Gets the ODPListItem property <b>listItem</b> by index.
     *
     * @param index
     * @return ODPListItem
     */
    public ODPListItem getListItem(int index) {
        return ((ODPListItem)listItem_.get(index));
    }

    /**
     * Sets the ODPListItem property <b>listItem</b> by index.
     *
     * @param index
     * @param listItem
     */
    public void setListItem(int index, ODPListItem listItem) {
        this.listItem_.set(index, listItem);
        if (listItem != null) {
            listItem.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPListItem property <b>listItem</b> by index.
     *
     * @param index
     * @param listItem
     */
    public void addListItem(int index, ODPListItem listItem) {
        this.listItem_.add(index, listItem);
        if (listItem != null) {
            listItem.rSetParentRNode(this);
        }
    }

    /**
     * Remove the ODPListItem property <b>listItem</b> by index.
     *
     * @param index
     */
    public void removeListItem(int index) {
        this.listItem_.remove(index);
    }

    /**
     * Remove the ODPListItem property <b>listItem</b> by object.
     *
     * @param listItem
     */
    public void removeListItem(ODPListItem listItem) {
        this.listItem_.remove(listItem);
    }

    /**
     * Clear the ODPListItem property <b>listItem</b>.
     *
     */
    public void clearListItem() {
        this.listItem_.clear();
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
        URelaxer.makeQName(prefix, "list", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (styleName_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "style-name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.listItem_.size();
        for (int i = 0;i < size;i++) {
            ODPListItem value = (ODPListItem)this.listItem_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "list", buffer);
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
        URelaxer.makeQName(prefix, "list", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (styleName_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "style-name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.listItem_.size();
        for (int i = 0;i < size;i++) {
            ODPListItem value = (ODPListItem)this.listItem_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "list", buffer);
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
        URelaxer.makeQName(prefix, "list", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (styleName_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:text:1.0", "style-name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.listItem_.size();
        for (int i = 0;i < size;i++) {
            ODPListItem value = (ODPListItem)this.listItem_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "list", buffer);
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
    public String getStyleNameAsString() {
        return (URelaxer.getString(getStyleName()));
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
        classNodes.addAll(listItem_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>ODPList</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:text:1.0", "list")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        while (true) {
            if (!ODPListItem.isMatchHungry(target)) {
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
     * is valid for the <code>ODPList</code>.
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
     * is valid for the <code>ODPList</code>.
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
