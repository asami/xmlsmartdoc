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
 * <b>ODPPresentation</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="presentation">
 *       <oneOrMore>
 *         <ref name="page"/>
 *       </oneOrMore>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="presentation"&gt;
 *       &lt;oneOrMore&gt;
 *         &lt;ref name="page"/&gt;
 *       &lt;/oneOrMore&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:19 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPPresentation implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:office:1.0");
    // List<ODPPage>
    private java.util.List page_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPPresentation</code>.
     *
     */
    public ODPPresentation() {
    }

    /**
     * Creates a <code>ODPPresentation</code>.
     *
     * @param source
     */
    public ODPPresentation(ODPPresentation source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPPresentation</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPPresentation(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPPresentation</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPPresentation(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPPresentation</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPPresentation(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPPresentation</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPresentation(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPPresentation</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPresentation(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPPresentation</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPresentation(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPPresentation</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPresentation(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPPresentation</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPresentation(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPPresentation</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPresentation(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPPresentation</code> by the ODPPresentation <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPPresentation source) {
        int size;
        this.page_.clear();
        size = source.page_.size();
        for (int i = 0;i < size;i++) {
            addPage((ODPPage)source.getPage(i).clone());
        }
    }

    /**
     * Initializes the <code>ODPPresentation</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPPresentation</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPPresentation</code> by the Stack <code>stack</code>
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
        page_.clear();
        while (true) {
            if (ODPPage.isMatch(stack)) {
                addPage(new ODPPage(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPPresentation((ODPPresentation)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:office:1.0", "presentation");
        rNSContext_.setupNamespace(element);
        int size;
        size = this.page_.size();
        for (int i = 0;i < size;i++) {
            ODPPage value = (ODPPage)this.page_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPPresentation</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPPresentation</code>
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
     * Initializes the <code>ODPPresentation</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPPresentation</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPPresentation</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPPresentation</code> by the Reader <code>reader</code>.
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
     * Gets the ODPPage property <b>page</b>.
     *
     * @return ODPPage[]
     */
    public ODPPage[] getPage() {
        ODPPage[] array = new ODPPage[page_.size()];
        return ((ODPPage[])page_.toArray(array));
    }

    /**
     * Sets the ODPPage property <b>page</b>.
     *
     * @param page
     */
    public void setPage(ODPPage[] page) {
        this.page_.clear();
        for (int i = 0;i < page.length;i++) {
            addPage(page[i]);
        }
        for (int i = 0;i < page.length;i++) {
            page[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the ODPPage property <b>page</b>.
     *
     * @param page
     */
    public void setPage(ODPPage page) {
        this.page_.clear();
        addPage(page);
        if (page != null) {
            page.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPPage property <b>page</b>.
     *
     * @param page
     */
    public void addPage(ODPPage page) {
        this.page_.add(page);
        if (page != null) {
            page.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPPage property <b>page</b>.
     *
     * @param page
     */
    public void addPage(ODPPage[] page) {
        for (int i = 0;i < page.length;i++) {
            addPage(page[i]);
        }
        for (int i = 0;i < page.length;i++) {
            page[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the ODPPage property <b>page</b>.
     *
     * @return int
     */
    public int sizePage() {
        return (page_.size());
    }

    /**
     * Gets the ODPPage property <b>page</b> by index.
     *
     * @param index
     * @return ODPPage
     */
    public ODPPage getPage(int index) {
        return ((ODPPage)page_.get(index));
    }

    /**
     * Sets the ODPPage property <b>page</b> by index.
     *
     * @param index
     * @param page
     */
    public void setPage(int index, ODPPage page) {
        this.page_.set(index, page);
        if (page != null) {
            page.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPPage property <b>page</b> by index.
     *
     * @param index
     * @param page
     */
    public void addPage(int index, ODPPage page) {
        this.page_.add(index, page);
        if (page != null) {
            page.rSetParentRNode(this);
        }
    }

    /**
     * Remove the ODPPage property <b>page</b> by index.
     *
     * @param index
     */
    public void removePage(int index) {
        this.page_.remove(index);
    }

    /**
     * Remove the ODPPage property <b>page</b> by object.
     *
     * @param page
     */
    public void removePage(ODPPage page) {
        this.page_.remove(page);
    }

    /**
     * Clear the ODPPage property <b>page</b>.
     *
     */
    public void clearPage() {
        this.page_.clear();
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
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:office:1.0");
        buffer.append("<");
        URelaxer.makeQName(prefix, "presentation", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.append(">");
        size = this.page_.size();
        for (int i = 0;i < size;i++) {
            ODPPage value = (ODPPage)this.page_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "presentation", buffer);
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
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:office:1.0");
        buffer.write("<");
        URelaxer.makeQName(prefix, "presentation", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.write(">");
        size = this.page_.size();
        for (int i = 0;i < size;i++) {
            ODPPage value = (ODPPage)this.page_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "presentation", buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:office:1.0");
        buffer.print("<");
        URelaxer.makeQName(prefix, "presentation", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.print(">");
        size = this.page_.size();
        for (int i = 0;i < size;i++) {
            ODPPage value = (ODPPage)this.page_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "presentation", buffer);
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
        classNodes.addAll(page_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>ODPPresentation</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:office:1.0", "presentation")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!ODPPage.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!ODPPage.isMatchHungry(target)) {
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
     * is valid for the <code>ODPPresentation</code>.
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
     * is valid for the <code>ODPPresentation</code>.
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
