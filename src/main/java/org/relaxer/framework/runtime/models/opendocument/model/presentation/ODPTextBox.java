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
 * <b>ODPTextBox</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="text-box" ns="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0">
 *       <oneOrMore>
 *         <choice>
 *           <ref name="p"/>
 *           <ref name="list"/>
 *         </choice>
 *       </oneOrMore>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="text-box" ns="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"&gt;
 *       &lt;oneOrMore&gt;
 *         &lt;choice&gt;
 *           &lt;ref name="p"/&gt;
 *           &lt;ref name="list"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/oneOrMore&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:19 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPTextBox implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
    // List<IODPTextBoxChoice>
    private java.util.List content_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPTextBox</code>.
     *
     */
    public ODPTextBox() {
    }

    /**
     * Creates a <code>ODPTextBox</code>.
     *
     * @param source
     */
    public ODPTextBox(ODPTextBox source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPTextBox</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPTextBox(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPTextBox</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPTextBox(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPTextBox</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPTextBox(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPTextBox</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPTextBox(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPTextBox</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPTextBox(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPTextBox</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPTextBox(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPTextBox</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPTextBox(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPTextBox</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPTextBox(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPTextBox</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPTextBox(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPTextBox</code> by the ODPTextBox <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPTextBox source) {
        int size;
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((IODPTextBoxChoice)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>ODPTextBox</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPTextBox</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPTextBox</code> by the Stack <code>stack</code>
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
        content_.clear();
        while (true) {
            if (ODPList.isMatch(stack)) {
                addContent(new ODPList(stack));
            } else if (ODPP.isMatch(stack)) {
                addContent(new ODPP(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPTextBox((ODPTextBox)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "text-box");
        rNSContext_.setupNamespace(element);
        int size;
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IODPTextBoxChoice value = (IODPTextBoxChoice)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPTextBox</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPTextBox</code>
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
     * Initializes the <code>ODPTextBox</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPTextBox</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPTextBox</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPTextBox</code> by the Reader <code>reader</code>.
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
     * Gets the IODPTextBoxChoice property <b>content</b>.
     *
     * @return IODPTextBoxChoice[]
     */
    public IODPTextBoxChoice[] getContent() {
        IODPTextBoxChoice[] array = new IODPTextBoxChoice[content_.size()];
        return ((IODPTextBoxChoice[])content_.toArray(array));
    }

    /**
     * Sets the IODPTextBoxChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IODPTextBoxChoice[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
        for (int i = 0;i < content.length;i++) {
            content[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the IODPTextBoxChoice property <b>content</b>.
     *
     * @param content
     */
    public void setContent(IODPTextBoxChoice content) {
        this.content_.clear();
        addContent(content);
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IODPTextBoxChoice property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IODPTextBoxChoice content) {
        this.content_.add(content);
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IODPTextBoxChoice property <b>content</b>.
     *
     * @param content
     */
    public void addContent(IODPTextBoxChoice[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
        for (int i = 0;i < content.length;i++) {
            content[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the IODPTextBoxChoice property <b>content</b>.
     *
     * @return int
     */
    public int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the IODPTextBoxChoice property <b>content</b> by index.
     *
     * @param index
     * @return IODPTextBoxChoice
     */
    public IODPTextBoxChoice getContent(int index) {
        return ((IODPTextBoxChoice)content_.get(index));
    }

    /**
     * Sets the IODPTextBoxChoice property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void setContent(int index, IODPTextBoxChoice content) {
        this.content_.set(index, content);
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IODPTextBoxChoice property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public void addContent(int index, IODPTextBoxChoice content) {
        this.content_.add(index, content);
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Remove the IODPTextBoxChoice property <b>content</b> by index.
     *
     * @param index
     */
    public void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the IODPTextBoxChoice property <b>content</b> by object.
     *
     * @param content
     */
    public void removeContent(IODPTextBoxChoice content) {
        this.content_.remove(content);
    }

    /**
     * Clear the IODPTextBoxChoice property <b>content</b>.
     *
     */
    public void clearContent() {
        this.content_.clear();
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
        URelaxer.makeQName(prefix, "text-box", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IODPTextBoxChoice value = (IODPTextBoxChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IODPTextBoxChoice value = (IODPTextBoxChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "text-box", buffer);
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
        URelaxer.makeQName(prefix, "text-box", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IODPTextBoxChoice value = (IODPTextBoxChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IODPTextBoxChoice value = (IODPTextBoxChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "text-box", buffer);
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
        URelaxer.makeQName(prefix, "text-box", buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IODPTextBoxChoice value = (IODPTextBoxChoice)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IODPTextBoxChoice value = (IODPTextBoxChoice)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "text-box", buffer);
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
        classNodes.addAll(content_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>ODPTextBox</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "text-box")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (ODPList.isMatchHungry(target)) {
            $match$ = true;
        } else if (ODPP.isMatchHungry(target)) {
            $match$ = true;
        } else {
            return (false);
        }
        while (true) {
            if (ODPList.isMatchHungry(target)) {
                $match$ = true;
            } else if (ODPP.isMatchHungry(target)) {
                $match$ = true;
            } else {
                break;
            }
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>ODPTextBox</code>.
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
     * is valid for the <code>ODPTextBox</code>.
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
