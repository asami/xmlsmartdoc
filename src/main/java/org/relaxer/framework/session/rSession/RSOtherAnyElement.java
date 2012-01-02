package org.relaxer.framework.session.rSession;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>RSOtherAnyElement</b> is generated from session.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element>
 *   <anyName>
 *     <except>
 *       <nsName/>
 *     </except>
 *   </anyName>
 *   <zeroOrMore>
 *     <choice>
 *       <attribute>
 *         <anyName/>
 *       </attribute>
 *       <text/>
 *       <ref name="any"/>
 *     </choice>
 *   </zeroOrMore>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;element&gt;
 *   &lt;anyName&gt;
 *     &lt;except&gt;
 *       &lt;nsName/&gt;
 *     &lt;/except&gt;
 *   &lt;/anyName&gt;
 *   &lt;zeroOrMore&gt;
 *     &lt;choice&gt;
 *       &lt;attribute&gt;
 *         &lt;anyName/&gt;
 *       &lt;/attribute&gt;
 *       &lt;text/&gt;
 *       &lt;ref name="any"/&gt;
 *     &lt;/choice&gt;
 *   &lt;/zeroOrMore&gt;
 * &lt;/element&gt;
 * </pre>
 *
 * @version session.rng (Tue Sep 09 06:58:49 GMT+09:00 2003)
 * @author  Relaxer 1.0rc3b (http://www.relaxer.org)
 */
public class RSOtherAnyElement implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private static RNameClassNS $nameClass$ = new RNameClassNS("<anyName><except><nsName></nsName></except></anyName>", "http://www.relaxer.org/xmlns/framework/session");
    private String $namespaceUri$ = "";
    private String $localName$ = "otherAnyElement";
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework/session");
    // List<IRSOtherAnyElementMixed>
    private java.util.List content_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>RSOtherAnyElement</code>.
     *
     */
    public RSOtherAnyElement() {
    }

    /**
     * Creates a <code>RSOtherAnyElement</code>.
     *
     * @param source
     */
    public RSOtherAnyElement(RSOtherAnyElement source) {
        setup(source);
    }

    /**
     * Creates a <code>RSOtherAnyElement</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public RSOtherAnyElement(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>RSOtherAnyElement</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public RSOtherAnyElement(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>RSOtherAnyElement</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public RSOtherAnyElement(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>RSOtherAnyElement</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RSOtherAnyElement(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>RSOtherAnyElement</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RSOtherAnyElement(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>RSOtherAnyElement</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RSOtherAnyElement(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>RSOtherAnyElement</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RSOtherAnyElement(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>RSOtherAnyElement</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RSOtherAnyElement(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>RSOtherAnyElement</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RSOtherAnyElement(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>RSOtherAnyElement</code> by the RSOtherAnyElement <code>source</code>.
     *
     * @param source
     */
    public void setup(RSOtherAnyElement source) {
        int size;
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((IRSOtherAnyElementMixed)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>RSOtherAnyElement</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>RSOtherAnyElement</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>RSOtherAnyElement</code> by the Stack <code>stack</code>
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
        $namespaceUri$ = element.getNamespaceURI();
        $localName$ = element.getLocalName();
        this.content_.clear();
        while (true) {
            if (RString.isMatch(stack)) {
                addContent(new RString(stack));
            } else if (RSOtherAnyElementAnyAttr.isMatch(stack)) {
                addContent(new RSOtherAnyElementAnyAttr(stack));
            } else if (RSAny.isMatch(stack)) {
                addContent(new RSAny(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new RSOtherAnyElement(this));
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
        Element element = doc.createElementNS($namespaceUri$, $localName$);
        rNSContext_.setupNamespace(element);
        int size;
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IRSOtherAnyElementMixed value = (IRSOtherAnyElementMixed)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>RSOtherAnyElement</code> by the File <code>file</code>.
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
     * Initializes the <code>RSOtherAnyElement</code>
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
     * Initializes the <code>RSOtherAnyElement</code> by the URL <code>url</code>.
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
     * Initializes the <code>RSOtherAnyElement</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>RSOtherAnyElement</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>RSOtherAnyElement</code> by the Reader <code>reader</code>.
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
     * Sets a mixed content by <code>String</code>.
     *
     * @param text
     */
    public void setContent(String text) {
        setContent(new RString(text));
    }

    /**
     * Sets a mixed content by <code>String</code>.
     *
     * @param text
     */
    public void setContentByString(String text) {
        setContent(new RString(text));
    }

    /**
     * Gets the RNSContext property <b>RNSContext</b>.
     *
     * @return RNSContext
     */
    public final RNSContext rGetRNSContext() {
        return (rNSContext_);
    }

    /**
     * Sets the RNSContext property <b>RNSContext</b>.
     *
     * @param rNSContext
     */
    public final void rSetRNSContext(RNSContext rNSContext) {
        this.rNSContext_ = rNSContext;
    }

    /**
     * Gets the IRSOtherAnyElementMixed property <b>content</b>.
     *
     * @return IRSOtherAnyElementMixed[]
     */
    public final IRSOtherAnyElementMixed[] getContent() {
        IRSOtherAnyElementMixed[] array = new IRSOtherAnyElementMixed[content_.size()];
        return ((IRSOtherAnyElementMixed[])content_.toArray(array));
    }

    /**
     * Sets the IRSOtherAnyElementMixed property <b>content</b>.
     *
     * @param content
     */
    public final void setContent(IRSOtherAnyElementMixed[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
        for (int i = 0;i < content.length;i++) {
            content[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the IRSOtherAnyElementMixed property <b>content</b>.
     *
     * @param content
     */
    public final void setContent(IRSOtherAnyElementMixed content) {
        this.content_.clear();
        addContent(content);
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IRSOtherAnyElementMixed property <b>content</b>.
     *
     * @param content
     */
    public final void addContent(IRSOtherAnyElementMixed content) {
        this.content_.add(content);
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IRSOtherAnyElementMixed property <b>content</b>.
     *
     * @param content
     */
    public final void addContent(IRSOtherAnyElementMixed[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
        for (int i = 0;i < content.length;i++) {
            content[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the IRSOtherAnyElementMixed property <b>content</b>.
     *
     * @return int
     */
    public final int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the IRSOtherAnyElementMixed property <b>content</b> by index.
     *
     * @param index
     * @return IRSOtherAnyElementMixed
     */
    public final IRSOtherAnyElementMixed getContent(int index) {
        return ((IRSOtherAnyElementMixed)content_.get(index));
    }

    /**
     * Sets the IRSOtherAnyElementMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public final void setContent(int index, IRSOtherAnyElementMixed content) {
        this.content_.set(index, content);
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Adds the IRSOtherAnyElementMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public final void addContent(int index, IRSOtherAnyElementMixed content) {
        this.content_.add(index, content);
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Remove the IRSOtherAnyElementMixed property <b>content</b> by index.
     *
     * @param index
     */
    public final void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the IRSOtherAnyElementMixed property <b>content</b> by object.
     *
     * @param content
     */
    public final void removeContent(IRSOtherAnyElementMixed content) {
        this.content_.remove(content);
    }

    /**
     * Clear the IRSOtherAnyElementMixed property <b>content</b>.
     *
     */
    public final void clearContent() {
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
        String prefix = rNSContext_.getPrefixByUri($namespaceUri$);
        buffer.append("<");
        URelaxer.makeQName(prefix, $localName$, buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IRSOtherAnyElementMixed value = (IRSOtherAnyElementMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IRSOtherAnyElementMixed value = (IRSOtherAnyElementMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, $localName$, buffer);
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
        String prefix = rNSContext_.getPrefixByUri($namespaceUri$);
        buffer.write("<");
        URelaxer.makeQName(prefix, $localName$, buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IRSOtherAnyElementMixed value = (IRSOtherAnyElementMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IRSOtherAnyElementMixed value = (IRSOtherAnyElementMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, $localName$, buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri($namespaceUri$);
        buffer.print("<");
        URelaxer.makeQName(prefix, $localName$, buffer);
        rNSContext_.makeNSMappings(buffer);
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IRSOtherAnyElementMixed value = (IRSOtherAnyElementMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            IRSOtherAnyElementMixed value = (IRSOtherAnyElementMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, $localName$, buffer);
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
    public final IRNode rGetParentRNode() {
        return (parentRNode_);
    }

    /**
     * Sets the IRNode property <b>parentRNode</b>.
     *
     * @param parentRNode
     */
    public final void rSetParentRNode(IRNode parentRNode) {
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
     * for the <code>RSOtherAnyElement</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!$nameClass$.isMatchElement(element)) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        while (true) {
            if (RSOtherAnyElementAnyAttr.isMatchHungry(target)) {
                $match$ = true;
            } else if (RSAny.isMatchHungry(target)) {
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
     * is valid for the <code>RSOtherAnyElement</code>.
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
     * is valid for the <code>RSOtherAnyElement</code>.
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
