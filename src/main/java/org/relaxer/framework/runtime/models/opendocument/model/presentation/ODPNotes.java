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
 * <b>ODPNotes</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="notes" ns="urn:oasis:names:tc:opendocument:xmlns:presentation:1.0">
 *       <attribute name="presentation:style-name">
 *         <data type="token"/>
 *       </attribute>
 *       <ref name="page-thumbnail"/>
 *       <ref name="frame"/>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="notes" ns="urn:oasis:names:tc:opendocument:xmlns:presentation:1.0"&gt;
 *       &lt;attribute name="presentation:style-name"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;ref name="page-thumbnail"/&gt;
 *       &lt;ref name="frame"/&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:19 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPNotes implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
    private String styleName_;
    private ODPPageThumbnail pageThumbnail_;
    private ODPFrame frame_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPNotes</code>.
     *
     */
    public ODPNotes() {
        rNSContext_.declareNamespaceWeak("p1", "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        styleName_ = "";
    }

    /**
     * Creates a <code>ODPNotes</code>.
     *
     * @param source
     */
    public ODPNotes(ODPNotes source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPNotes</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPNotes(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPNotes</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPNotes(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPNotes</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPNotes(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPNotes</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPNotes(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPNotes</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPNotes(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPNotes</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPNotes(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPNotes</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPNotes(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPNotes</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPNotes(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPNotes</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPNotes(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPNotes</code> by the ODPNotes <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPNotes source) {
        int size;
        styleName_ = source.styleName_;
        if (source.pageThumbnail_ != null) {
            setPageThumbnail((ODPPageThumbnail)source.getPageThumbnail().clone());
        }
        if (source.frame_ != null) {
            setFrame((ODPFrame)source.getFrame().clone());
        }
    }

    /**
     * Initializes the <code>ODPNotes</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPNotes</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPNotes</code> by the Stack <code>stack</code>
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
        styleName_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name");
        setPageThumbnail(new ODPPageThumbnail(stack));
        setFrame(new ODPFrame(stack));
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPNotes((ODPNotes)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "notes");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.styleName_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name", this.styleName_, rNSContext_);
        }
        this.pageThumbnail_.makeElement(element);
        this.frame_.makeElement(element);
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPNotes</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPNotes</code>
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
     * Initializes the <code>ODPNotes</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPNotes</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPNotes</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPNotes</code> by the Reader <code>reader</code>.
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
     * Gets the ODPPageThumbnail property <b>pageThumbnail</b>.
     *
     * @return ODPPageThumbnail
     */
    public ODPPageThumbnail getPageThumbnail() {
        return (pageThumbnail_);
    }

    /**
     * Sets the ODPPageThumbnail property <b>pageThumbnail</b>.
     *
     * @param pageThumbnail
     */
    public void setPageThumbnail(ODPPageThumbnail pageThumbnail) {
        this.pageThumbnail_ = pageThumbnail;
        if (pageThumbnail != null) {
            pageThumbnail.rSetParentRNode(this);
        }
    }

    /**
     * Gets the ODPFrame property <b>frame</b>.
     *
     * @return ODPFrame
     */
    public ODPFrame getFrame() {
        return (frame_);
    }

    /**
     * Sets the ODPFrame property <b>frame</b>.
     *
     * @param frame
     */
    public void setFrame(ODPFrame frame) {
        this.frame_ = frame;
        if (frame != null) {
            frame.rSetParentRNode(this);
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
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        buffer.append("<");
        URelaxer.makeQName(prefix, "notes", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (styleName_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
            buffer.append("\"");
        }
        buffer.append(">");
        pageThumbnail_.makeTextElement(buffer);
        frame_.makeTextElement(buffer);
        buffer.append("</");
        URelaxer.makeQName(prefix, "notes", buffer);
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
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        buffer.write("<");
        URelaxer.makeQName(prefix, "notes", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (styleName_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
            buffer.write("\"");
        }
        buffer.write(">");
        pageThumbnail_.makeTextElement(buffer);
        frame_.makeTextElement(buffer);
        buffer.write("</");
        URelaxer.makeQName(prefix, "notes", buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0");
        buffer.print("<");
        URelaxer.makeQName(prefix, "notes", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (styleName_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
            buffer.print("\"");
        }
        buffer.print(">");
        pageThumbnail_.makeTextElement(buffer);
        frame_.makeTextElement(buffer);
        buffer.print("</");
        URelaxer.makeQName(prefix, "notes", buffer);
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
        if (pageThumbnail_ != null) {
            classNodes.add(pageThumbnail_);
        }
        if (frame_ != null) {
            classNodes.add(frame_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>ODPNotes</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "notes")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:presentation:1.0", "style-name")) {
            return (false);
        }
        $match$ = true;
        if (!ODPPageThumbnail.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        if (!ODPFrame.isMatchHungry(target)) {
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
     * is valid for the <code>ODPNotes</code>.
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
     * is valid for the <code>ODPNotes</code>.
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
