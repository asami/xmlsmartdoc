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
 * <b>ODPDocumentContent</b> is generated from presentation.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="document-content">
 *       <optional>
 *         <attribute name="office:version">
 *           <data type="string"/>
 *         </attribute>
 *       </optional>
 *       <optional>
 *         <element name="scripts">
 *           <empty/>
 *         </element>
 *       </optional>
 *       <optional>
 *         <ref name="automatic-styles"/>
 *       </optional>
 *       <ref name="body"/>
 *     </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="document-content"&gt;
 *       &lt;optional&gt;
 *         &lt;attribute name="office:version"&gt;
 *           &lt;data type="string"/&gt;
 *         &lt;/attribute&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;element name="scripts"&gt;
 *           &lt;empty/&gt;
 *         &lt;/element&gt;
 *       &lt;/optional&gt;
 *       &lt;optional&gt;
 *         &lt;ref name="automatic-styles"/&gt;
 *       &lt;/optional&gt;
 *       &lt;ref name="body"/&gt;
 *     &lt;/element&gt;</pre>
 *
 * @version presentation.rng (Fri Sep 02 05:58:19 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class ODPDocumentContent implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "urn:oasis:names:tc:opendocument:xmlns:office:1.0");
    private String version_;
    private String scripts_;
    private ODPAutomaticStyles automaticStyles_;
    private ODPBody body_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>ODPDocumentContent</code>.
     *
     */
    public ODPDocumentContent() {
        rNSContext_.declareNamespaceWeak("p1", "urn:oasis:names:tc:opendocument:xmlns:office:1.0");
    }

    /**
     * Creates a <code>ODPDocumentContent</code>.
     *
     * @param source
     */
    public ODPDocumentContent(ODPDocumentContent source) {
        setup(source);
    }

    /**
     * Creates a <code>ODPDocumentContent</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public ODPDocumentContent(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>ODPDocumentContent</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public ODPDocumentContent(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>ODPDocumentContent</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public ODPDocumentContent(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>ODPDocumentContent</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPDocumentContent(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>ODPDocumentContent</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPDocumentContent(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>ODPDocumentContent</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPDocumentContent(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>ODPDocumentContent</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPDocumentContent(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>ODPDocumentContent</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPDocumentContent(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>ODPDocumentContent</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public ODPDocumentContent(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>ODPDocumentContent</code> by the ODPDocumentContent <code>source</code>.
     *
     * @param source
     */
    public void setup(ODPDocumentContent source) {
        int size;
        version_ = source.version_;
        scripts_ = source.scripts_;
        if (source.automaticStyles_ != null) {
            setAutomaticStyles((ODPAutomaticStyles)source.getAutomaticStyles().clone());
        }
        if (source.body_ != null) {
            setBody((ODPBody)source.getBody().clone());
        }
    }

    /**
     * Initializes the <code>ODPDocumentContent</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>ODPDocumentContent</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>ODPDocumentContent</code> by the Stack <code>stack</code>
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
        version_ = URelaxer2.getAttributePropertyAsString(element, "urn:oasis:names:tc:opendocument:xmlns:office:1.0", "version");
        scripts_ = URelaxer2.getElementPropertyAsStringByStack(stack, "urn:oasis:names:tc:opendocument:xmlns:office:1.0", "scripts");
        if (ODPAutomaticStyles.isMatch(stack)) {
            setAutomaticStyles(new ODPAutomaticStyles(stack));
        }
        setBody(new ODPBody(stack));
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new ODPDocumentContent((ODPDocumentContent)this));
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
        Element element = doc.createElementNS("urn:oasis:names:tc:opendocument:xmlns:office:1.0", "document-content");
        rNSContext_.setupNamespace(element);
        int size;
        if (this.version_ != null) {
            URelaxer2.setAttributePropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:office:1.0", "version", this.version_, rNSContext_);
        }
        if (this.scripts_ != null) {
            URelaxer2.setElementPropertyByString(element, "urn:oasis:names:tc:opendocument:xmlns:office:1.0", "scripts", this.scripts_, rNSContext_);
        }
        if (this.automaticStyles_ != null) {
            this.automaticStyles_.makeElement(element);
        }
        this.body_.makeElement(element);
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>ODPDocumentContent</code> by the File <code>file</code>.
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
     * Initializes the <code>ODPDocumentContent</code>
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
     * Initializes the <code>ODPDocumentContent</code> by the URL <code>url</code>.
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
     * Initializes the <code>ODPDocumentContent</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>ODPDocumentContent</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>ODPDocumentContent</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>version</b>.
     *
     * @return String
     */
    public String getVersion() {
        return (version_);
    }

    /**
     * Sets the String property <b>version</b>.
     *
     * @param version
     */
    public void setVersion(String version) {
        this.version_ = version;
    }

    /**
     * Gets the String property <b>scripts</b>.
     *
     * @return String
     */
    public String getScripts() {
        return (scripts_);
    }

    /**
     * Sets the String property <b>scripts</b>.
     *
     * @param scripts
     */
    public void setScripts(String scripts) {
        this.scripts_ = scripts;
    }

    /**
     * Gets the ODPAutomaticStyles property <b>automaticStyles</b>.
     *
     * @return ODPAutomaticStyles
     */
    public ODPAutomaticStyles getAutomaticStyles() {
        return (automaticStyles_);
    }

    /**
     * Sets the ODPAutomaticStyles property <b>automaticStyles</b>.
     *
     * @param automaticStyles
     */
    public void setAutomaticStyles(ODPAutomaticStyles automaticStyles) {
        this.automaticStyles_ = automaticStyles;
        if (automaticStyles != null) {
            automaticStyles.rSetParentRNode(this);
        }
    }

    /**
     * Gets the ODPBody property <b>body</b>.
     *
     * @return ODPBody
     */
    public ODPBody getBody() {
        return (body_);
    }

    /**
     * Sets the ODPBody property <b>body</b>.
     *
     * @param body
     */
    public void setBody(ODPBody body) {
        this.body_ = body;
        if (body != null) {
            body.rSetParentRNode(this);
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
        String prefix = rNSContext_.getPrefixByUri("urn:oasis:names:tc:opendocument:xmlns:office:1.0");
        buffer.append("<");
        URelaxer.makeQName(prefix, "document-content", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (version_ != null) {
            buffer.append(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:office:1.0", "version", buffer);
            buffer.append("=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getVersion())));
            buffer.append("\"");
        }
        buffer.append(">");
        if (scripts_ != null) {
            buffer.append("<");
            URelaxer.makeQName(prefix, "scripts", buffer);
            buffer.append(">");
            buffer.append(URelaxer.escapeCharData(URelaxer.getString(getScripts())));
            buffer.append("</");
            URelaxer.makeQName(prefix, "scripts", buffer);
            buffer.append(">");
        }
        if (automaticStyles_ != null) {
            automaticStyles_.makeTextElement(buffer);
        }
        body_.makeTextElement(buffer);
        buffer.append("</");
        URelaxer.makeQName(prefix, "document-content", buffer);
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
        URelaxer.makeQName(prefix, "document-content", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (version_ != null) {
            buffer.write(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:office:1.0", "version", buffer);
            buffer.write("=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getVersion())));
            buffer.write("\"");
        }
        buffer.write(">");
        if (scripts_ != null) {
            buffer.write("<");
            URelaxer.makeQName(prefix, "scripts", buffer);
            buffer.write(">");
            buffer.write(URelaxer.escapeCharData(URelaxer.getString(getScripts())));
            buffer.write("</");
            URelaxer.makeQName(prefix, "scripts", buffer);
            buffer.write(">");
        }
        if (automaticStyles_ != null) {
            automaticStyles_.makeTextElement(buffer);
        }
        body_.makeTextElement(buffer);
        buffer.write("</");
        URelaxer.makeQName(prefix, "document-content", buffer);
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
        URelaxer.makeQName(prefix, "document-content", buffer);
        rNSContext_.makeNSMappings(buffer);
        if (version_ != null) {
            buffer.print(" ");
            rNSContext_.makeQName("urn:oasis:names:tc:opendocument:xmlns:office:1.0", "version", buffer);
            buffer.print("=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getVersion())));
            buffer.print("\"");
        }
        buffer.print(">");
        if (scripts_ != null) {
            buffer.print("<");
            URelaxer.makeQName(prefix, "scripts", buffer);
            buffer.print(">");
            buffer.print(URelaxer.escapeCharData(URelaxer.getString(getScripts())));
            buffer.print("</");
            URelaxer.makeQName(prefix, "scripts", buffer);
            buffer.print(">");
        }
        if (automaticStyles_ != null) {
            automaticStyles_.makeTextElement(buffer);
        }
        body_.makeTextElement(buffer);
        buffer.print("</");
        URelaxer.makeQName(prefix, "document-content", buffer);
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
    public String getVersionAsString() {
        return (URelaxer.getString(getVersion()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getScriptsAsString() {
        return (URelaxer.getString(getScripts()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setVersionByString(String string) {
        setVersion(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setScriptsByString(String string) {
        setScripts(string);
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
        if (automaticStyles_ != null) {
            classNodes.add(automaticStyles_);
        }
        if (body_ != null) {
            classNodes.add(body_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>ODPDocumentContent</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "urn:oasis:names:tc:opendocument:xmlns:office:1.0", "document-content")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer2.isTargetElement(child, "urn:oasis:names:tc:opendocument:xmlns:office:1.0", "scripts")) {
                target.popElement();
            }
        }
        $match$ = true;
        if (ODPAutomaticStyles.isMatchHungry(target)) {
        }
        if (!ODPBody.isMatchHungry(target)) {
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
     * is valid for the <code>ODPDocumentContent</code>.
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
     * is valid for the <code>ODPDocumentContent</code>.
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
