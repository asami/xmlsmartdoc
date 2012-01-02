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
 * <b>ODPAutomaticStyles</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="automatic-styles">
 *       <oneOrMore>
 *         <ref name="style"/>
 *       </oneOrMore>
 *       <oneOrMore>
 *         <ref name="list-style"/>
 *       </oneOrMore>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="automatic-styles"&gt;
 *       &lt;oneOrMore&gt;
 *         &lt;ref name="style"/&gt;
 *       &lt;/oneOrMore&gt;
 *       &lt;oneOrMore&gt;
 *         &lt;ref name="list-style"/&gt;
 *       &lt;/oneOrMore&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:19 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPAutomaticStyles implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:office:1.0");
    // List<ODPStyle>
    private java.util.List style_ = new java.util.ArrayList();
    // List<ODPListStyle>
    private java.util.List listStyle_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPAutomaticStyles</code>.
     *
     */
    public ODPAutomaticStyles() {
    }

    /**
     * Creates a <code>ODPAutomaticStyles</code>.
     *
     * @param source
     */
    public ODPAutomaticStyles(ODPAutomaticStyles source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPAutomaticStyles</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPAutomaticStyles(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPAutomaticStyles</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPAutomaticStyles(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPAutomaticStyles</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPAutomaticStyles(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPAutomaticStyles</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPAutomaticStyles(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPAutomaticStyles</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPAutomaticStyles(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPAutomaticStyles</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPAutomaticStyles(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPAutomaticStyles</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPAutomaticStyles(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPAutomaticStyles</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPAutomaticStyles(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPAutomaticStyles</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPAutomaticStyles(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPAutomaticStyles</code> by the ODPAutomaticStyles <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPAutomaticStyles source) {
        int size;
        this.style_.clear();
        size = source.style_.size();
        for (int i = 0;i < size;i++) {
            addStyle((ODPStyle)source.getStyle(i).clone());
        }
        this.listStyle_.clear();
        size = source.listStyle_.size();
        for (int i = 0;i < size;i++) {
            addListStyle((ODPListStyle)source.getListStyle(i).clone());
        }
    }

    /**
     * Initializes the <code>ODPAutomaticStyles</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPAutomaticStyles</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPAutomaticStyles</code> by the Stack <code>stack</code>
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
        style_.clear();
        while (true) {
            if (ODPStyle.isMatch(stack)) {
                addStyle(new ODPStyle(stack));
            } else {
                break;
            }
        }
        listStyle_.clear();
        while (true) {
            if (ODPListStyle.isMatch(stack)) {
                addListStyle(new ODPListStyle(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPAutomaticStyles((ODPAutomaticStyles)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:office:1.0", "automatic-styles");
        rNSContext_.setupNamespace(element);
        int size;
        size = this.style_.size();
        for (int i = 0;i < size;i++) {
            ODPStyle value = (ODPStyle)this.style_.get(i);
            value.makeElement(element);
        }
        size = this.listStyle_.size();
        for (int i = 0;i < size;i++) {
            ODPListStyle value = (ODPListStyle)this.listStyle_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPAutomaticStyles</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPAutomaticStyles</code>
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
     * Initializes the <code>ODPAutomaticStyles</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPAutomaticStyles</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPAutomaticStyles</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPAutomaticStyles</code> by the Reader <code>reader</code>.
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
     * Gets the ODPStyle property <b>style</b>.
     *
     * @return ODPStyle[]
     */
    public ODPStyle[] getStyle() {
        ODPStyle[] array = new ODPStyle[style_.size()];
        return ((ODPStyle[])style_.toArray(array));
    }

    /**
     * Sets the ODPStyle property <b>style</b>.
     *
     * @param style
     */
    public void setStyle(ODPStyle[] style) {
        this.style_.clear();
        for (int i = 0;i < style.length;i++) {
            addStyle(style[i]);
        }
        for (int i = 0;i < style.length;i++) {
            style[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the ODPStyle property <b>style</b>.
     *
     * @param style
     */
    public void setStyle(ODPStyle style) {
        this.style_.clear();
        addStyle(style);
        if (style != null) {
            style.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPStyle property <b>style</b>.
     *
     * @param style
     */
    public void addStyle(ODPStyle style) {
        this.style_.add(style);
        if (style != null) {
            style.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPStyle property <b>style</b>.
     *
     * @param style
     */
    public void addStyle(ODPStyle[] style) {
        for (int i = 0;i < style.length;i++) {
            addStyle(style[i]);
        }
        for (int i = 0;i < style.length;i++) {
            style[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the ODPStyle property <b>style</b>.
     *
     * @return int
     */
    public int sizeStyle() {
        return (style_.size());
    }

    /**
     * Gets the ODPStyle property <b>style</b> by index.
     *
     * @param index
     * @return ODPStyle
     */
    public ODPStyle getStyle(int index) {
        return ((ODPStyle)style_.get(index));
    }

    /**
     * Sets the ODPStyle property <b>style</b> by index.
     *
     * @param index
     * @param style
     */
    public void setStyle(int index, ODPStyle style) {
        this.style_.set(index, style);
        if (style != null) {
            style.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPStyle property <b>style</b> by index.
     *
     * @param index
     * @param style
     */
    public void addStyle(int index, ODPStyle style) {
        this.style_.add(index, style);
        if (style != null) {
            style.rSetParentRNode(this);
        }
    }

    /**
     * Remove the ODPStyle property <b>style</b> by index.
     *
     * @param index
     */
    public void removeStyle(int index) {
        this.style_.remove(index);
    }

    /**
     * Remove the ODPStyle property <b>style</b> by object.
     *
     * @param style
     */
    public void removeStyle(ODPStyle style) {
        this.style_.remove(style);
    }

    /**
     * Clear the ODPStyle property <b>style</b>.
     *
     */
    public void clearStyle() {
        this.style_.clear();
    }

    /**
     * Gets the ODPListStyle property <b>listStyle</b>.
     *
     * @return ODPListStyle[]
     */
    public ODPListStyle[] getListStyle() {
        ODPListStyle[] array = new ODPListStyle[listStyle_.size()];
        return ((ODPListStyle[])listStyle_.toArray(array));
    }

    /**
     * Sets the ODPListStyle property <b>listStyle</b>.
     *
     * @param listStyle
     */
    public void setListStyle(ODPListStyle[] listStyle) {
        this.listStyle_.clear();
        for (int i = 0;i < listStyle.length;i++) {
            addListStyle(listStyle[i]);
        }
        for (int i = 0;i < listStyle.length;i++) {
            listStyle[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the ODPListStyle property <b>listStyle</b>.
     *
     * @param listStyle
     */
    public void setListStyle(ODPListStyle listStyle) {
        this.listStyle_.clear();
        addListStyle(listStyle);
        if (listStyle != null) {
            listStyle.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPListStyle property <b>listStyle</b>.
     *
     * @param listStyle
     */
    public void addListStyle(ODPListStyle listStyle) {
        this.listStyle_.add(listStyle);
        if (listStyle != null) {
            listStyle.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPListStyle property <b>listStyle</b>.
     *
     * @param listStyle
     */
    public void addListStyle(ODPListStyle[] listStyle) {
        for (int i = 0;i < listStyle.length;i++) {
            addListStyle(listStyle[i]);
        }
        for (int i = 0;i < listStyle.length;i++) {
            listStyle[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the ODPListStyle property <b>listStyle</b>.
     *
     * @return int
     */
    public int sizeListStyle() {
        return (listStyle_.size());
    }

    /**
     * Gets the ODPListStyle property <b>listStyle</b> by index.
     *
     * @param index
     * @return ODPListStyle
     */
    public ODPListStyle getListStyle(int index) {
        return ((ODPListStyle)listStyle_.get(index));
    }

    /**
     * Sets the ODPListStyle property <b>listStyle</b> by index.
     *
     * @param index
     * @param listStyle
     */
    public void setListStyle(int index, ODPListStyle listStyle) {
        this.listStyle_.set(index, listStyle);
        if (listStyle != null) {
            listStyle.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPListStyle property <b>listStyle</b> by index.
     *
     * @param index
     * @param listStyle
     */
    public void addListStyle(int index, ODPListStyle listStyle) {
        this.listStyle_.add(index, listStyle);
        if (listStyle != null) {
            listStyle.rSetParentRNode(this);
        }
    }

    /**
     * Remove the ODPListStyle property <b>listStyle</b> by index.
     *
     * @param index
     */
    public void removeListStyle(int index) {
        this.listStyle_.remove(index);
    }

    /**
     * Remove the ODPListStyle property <b>listStyle</b> by object.
     *
     * @param listStyle
     */
    public void removeListStyle(ODPListStyle listStyle) {
        this.listStyle_.remove(listStyle);
    }

    /**
     * Clear the ODPListStyle property <b>listStyle</b>.
     *
     */
    public void clearListStyle() {
        this.listStyle_.clear();
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
        URelaxer.makeQName(prefix, "automatic-styles", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.append(">");
        size = this.style_.size();
        for (int i = 0;i < size;i++) {
            ODPStyle value = (ODPStyle)this.style_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.listStyle_.size();
        for (int i = 0;i < size;i++) {
            ODPListStyle value = (ODPListStyle)this.listStyle_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "automatic-styles", buffer);
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
        URelaxer.makeQName(prefix, "automatic-styles", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.write(">");
        size = this.style_.size();
        for (int i = 0;i < size;i++) {
            ODPStyle value = (ODPStyle)this.style_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.listStyle_.size();
        for (int i = 0;i < size;i++) {
            ODPListStyle value = (ODPListStyle)this.listStyle_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "automatic-styles", buffer);
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
        URelaxer.makeQName(prefix, "automatic-styles", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.print(">");
        size = this.style_.size();
        for (int i = 0;i < size;i++) {
            ODPStyle value = (ODPStyle)this.style_.get(i);
            value.makeTextElement(buffer);
        }
        size = this.listStyle_.size();
        for (int i = 0;i < size;i++) {
            ODPListStyle value = (ODPListStyle)this.listStyle_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "automatic-styles", buffer);
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
        classNodes.addAll(style_);
        classNodes.addAll(listStyle_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>ODPAutomaticStyles</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:office:1.0", "automatic-styles")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!ODPStyle.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!ODPStyle.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (!ODPListStyle.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!ODPListStyle.isMatchHungry(target)) {
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
     * is valid for the <code>ODPAutomaticStyles</code>.
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
     * is valid for the <code>ODPAutomaticStyles</code>.
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
