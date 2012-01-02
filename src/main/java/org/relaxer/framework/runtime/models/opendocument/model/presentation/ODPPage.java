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
 * <b>ODPPage</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="page" ns="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0">
 *       <optional>
 *         <attribute name="draw:master-page-name">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <attribute name="draw:name">
 *         <data type="token"/>
 *       </attribute>
 *       <optional>
 *         <attribute name="draw:style-name">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <optional>
 *         <attribute name="draw:presentation-page-layout-name">
 *           <data type="token"/>
 *         </attribute>
 *       </optional>
 *       <zeroOrMore>
 *         <ref name="frame"/>
 *       </zeroOrMore>
 *       <optional>
 *         <ref name="notes"/>
 *       </optional>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="page" ns="urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="draw:master-page-name"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;attribute name="draw:name"&gt;
 *         &lt;data type="token"/&gt;
 *       &lt;/attribute&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="draw:style-name"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="draw:presentation-page-layout-name"&gt;
 *           &lt;data type="token"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;zeroOrMore&gt;
 *         &lt;ref name="frame"/&gt;
 *       &lt;/zeroOrMore&gt;
 *       &lt;optional&gt;
 *         &lt;ref name="notes"/&gt;
 *       &lt;/optional&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:19 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPPage implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
    private String masterPageName_;
    private String name_;
    private String styleName_;
    private String presentationPageLayoutName_;
    // List<ODPFrame>
    private java.util.List frame_ = new java.util.ArrayList();
    private ODPNotes notes_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPPage</code>.
     *
     */
    public ODPPage() {
        rNSContext_.declareNamespaceWeak("p1", "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
        rNSContext_.declareNamespaceWeak("p2", "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
        rNSContext_.declareNamespaceWeak("p3", "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
        rNSContext_.declareNamespaceWeak("p4", "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
        name_ = "";
    }

    /**
     * Creates a <code>ODPPage</code>.
     *
     * @param source
     */
    public ODPPage(ODPPage source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPPage</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPPage(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPPage</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPPage(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPPage</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPPage(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPPage</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPage(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPPage</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPage(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPPage</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPage(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPPage</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPage(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPPage</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPage(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPPage</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPPage(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPPage</code> by the ODPPage <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPPage source) {
        int size;
        masterPageName_ = source.masterPageName_;
        name_ = source.name_;
        styleName_ = source.styleName_;
        presentationPageLayoutName_ = source.presentationPageLayoutName_;
        this.frame_.clear();
        size = source.frame_.size();
        for (int i = 0;i < size;i++) {
            addFrame((ODPFrame)source.getFrame(i).clone());
        }
        if (source.notes_ != null) {
            setNotes((ODPNotes)source.getNotes().clone());
        }
    }

    /**
     * Initializes the <code>ODPPage</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPPage</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPPage</code> by the Stack <code>stack</code>
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
        masterPageName_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "master-page-name");
        name_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "name");
        styleName_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "style-name");
        presentationPageLayoutName_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "presentation-page-layout-name");
        frame_.clear();
        while (true) {
            if (ODPFrame.isMatch(stack)) {
                addFrame(new ODPFrame(stack));
            } else {
                break;
            }
        }
        if (ODPNotes.isMatch(stack)) {
            setNotes(new ODPNotes(stack));
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPPage((ODPPage)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "page");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.masterPageName_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "master-page-name", this.masterPageName_, rNSContext_);
        }
        if (this.name_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "name", this.name_, rNSContext_);
        }
        if (this.styleName_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "style-name", this.styleName_, rNSContext_);
        }
        if (this.presentationPageLayoutName_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "presentation-page-layout-name", this.presentationPageLayoutName_, rNSContext_);
        }
        size = this.frame_.size();
        for (int i = 0;i < size;i++) {
            ODPFrame value = (ODPFrame)this.frame_.get(i);
            value.makeElement(element);
        }
        if (this.notes_ != null) {
            this.notes_.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPPage</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPPage</code>
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
     * Initializes the <code>ODPPage</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPPage</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPPage</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPPage</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>masterPageName</b>.
     *
     * @return String
     */
    public String getMasterPageName() {
        return (masterPageName_);
    }

    /**
     * Sets the String property <b>masterPageName</b>.
     *
     * @param masterPageName
     */
    public void setMasterPageName(String masterPageName) {
        this.masterPageName_ = masterPageName;
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
     * Gets the String property <b>presentationPageLayoutName</b>.
     *
     * @return String
     */
    public String getPresentationPageLayoutName() {
        return (presentationPageLayoutName_);
    }

    /**
     * Sets the String property <b>presentationPageLayoutName</b>.
     *
     * @param presentationPageLayoutName
     */
    public void setPresentationPageLayoutName(String presentationPageLayoutName) {
        this.presentationPageLayoutName_ = presentationPageLayoutName;
    }

    /**
     * Gets the ODPFrame property <b>frame</b>.
     *
     * @return ODPFrame[]
     */
    public ODPFrame[] getFrame() {
        ODPFrame[] array = new ODPFrame[frame_.size()];
        return ((ODPFrame[])frame_.toArray(array));
    }

    /**
     * Sets the ODPFrame property <b>frame</b>.
     *
     * @param frame
     */
    public void setFrame(ODPFrame[] frame) {
        this.frame_.clear();
        for (int i = 0;i < frame.length;i++) {
            addFrame(frame[i]);
        }
        for (int i = 0;i < frame.length;i++) {
            frame[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the ODPFrame property <b>frame</b>.
     *
     * @param frame
     */
    public void setFrame(ODPFrame frame) {
        this.frame_.clear();
        addFrame(frame);
        if (frame != null) {
            frame.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPFrame property <b>frame</b>.
     *
     * @param frame
     */
    public void addFrame(ODPFrame frame) {
        this.frame_.add(frame);
        if (frame != null) {
            frame.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPFrame property <b>frame</b>.
     *
     * @param frame
     */
    public void addFrame(ODPFrame[] frame) {
        for (int i = 0;i < frame.length;i++) {
            addFrame(frame[i]);
        }
        for (int i = 0;i < frame.length;i++) {
            frame[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the ODPFrame property <b>frame</b>.
     *
     * @return int
     */
    public int sizeFrame() {
        return (frame_.size());
    }

    /**
     * Gets the ODPFrame property <b>frame</b> by index.
     *
     * @param index
     * @return ODPFrame
     */
    public ODPFrame getFrame(int index) {
        return ((ODPFrame)frame_.get(index));
    }

    /**
     * Sets the ODPFrame property <b>frame</b> by index.
     *
     * @param index
     * @param frame
     */
    public void setFrame(int index, ODPFrame frame) {
        this.frame_.set(index, frame);
        if (frame != null) {
            frame.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ODPFrame property <b>frame</b> by index.
     *
     * @param index
     * @param frame
     */
    public void addFrame(int index, ODPFrame frame) {
        this.frame_.add(index, frame);
        if (frame != null) {
            frame.rSetParentRNode(this);
        }
    }

    /**
     * Remove the ODPFrame property <b>frame</b> by index.
     *
     * @param index
     */
    public void removeFrame(int index) {
        this.frame_.remove(index);
    }

    /**
     * Remove the ODPFrame property <b>frame</b> by object.
     *
     * @param frame
     */
    public void removeFrame(ODPFrame frame) {
        this.frame_.remove(frame);
    }

    /**
     * Clear the ODPFrame property <b>frame</b>.
     *
     */
    public void clearFrame() {
        this.frame_.clear();
    }

    /**
     * Gets the ODPNotes property <b>notes</b>.
     *
     * @return ODPNotes
     */
    public ODPNotes getNotes() {
        return (notes_);
    }

    /**
     * Sets the ODPNotes property <b>notes</b>.
     *
     * @param notes
     */
    public void setNotes(ODPNotes notes) {
        this.notes_ = notes;
        if (notes != null) {
            notes.rSetParentRNode(this);
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
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0");
        buffer.append("<");
        URelaxer.makeQName(prefix, "page", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (masterPageName_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "master-page-name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getMasterPageName())));
            buffer.append("\"");
        }
        if (name_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
        if (styleName_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "style-name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
            buffer.append("\"");
        }
        if (presentationPageLayoutName_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "presentation-page-layout-name", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getPresentationPageLayoutName())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.frame_.size();
        for (int i = 0;i < size;i++) {
            ODPFrame value = (ODPFrame)this.frame_.get(i);
            value.makeTextElement(buffer);
        }
        if (notes_ != null) {
            notes_.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "page", buffer);
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
        URelaxer.makeQName(prefix, "page", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (masterPageName_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "master-page-name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getMasterPageName())));
            buffer.write("\"");
        }
        if (name_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
        if (styleName_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "style-name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
            buffer.write("\"");
        }
        if (presentationPageLayoutName_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "presentation-page-layout-name", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getPresentationPageLayoutName())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.frame_.size();
        for (int i = 0;i < size;i++) {
            ODPFrame value = (ODPFrame)this.frame_.get(i);
            value.makeTextElement(buffer);
        }
        if (notes_ != null) {
            notes_.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "page", buffer);
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
        URelaxer.makeQName(prefix, "page", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (masterPageName_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "master-page-name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getMasterPageName())));
            buffer.print("\"");
        }
        if (name_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
        if (styleName_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "style-name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getStyleName())));
            buffer.print("\"");
        }
        if (presentationPageLayoutName_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "presentation-page-layout-name", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getPresentationPageLayoutName())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.frame_.size();
        for (int i = 0;i < size;i++) {
            ODPFrame value = (ODPFrame)this.frame_.get(i);
            value.makeTextElement(buffer);
        }
        if (notes_ != null) {
            notes_.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "page", buffer);
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
    public String getMasterPageNameAsString() {
        return (URelaxer.getString(getMasterPageName()));
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
    public String getStyleNameAsString() {
        return (URelaxer.getString(getStyleName()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getPresentationPageLayoutNameAsString() {
        return (URelaxer.getString(getPresentationPageLayoutName()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setMasterPageNameByString(String string) {
        setMasterPageName(string);
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
    public void setStyleNameByString(String string) {
        setStyleName(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setPresentationPageLayoutNameByString(String string) {
        setPresentationPageLayoutName(string);
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
        classNodes.addAll(frame_);
        if (notes_ != null) {
            classNodes.add(notes_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>ODPPage</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "page")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer2.hasAttributeHungry(target, "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0", "name")) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!ODPFrame.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (ODPNotes.isMatchHungry(target)) {
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>ODPPage</code>.
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
     * is valid for the <code>ODPPage</code>.
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
