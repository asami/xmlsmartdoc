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
 * <b>RSSubject</b> is generated from session.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="subject">
 *   <ref name="principal"/>
 *   <zeroOrMore>
 *     <ref name="other"/>
 *   </zeroOrMore>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;element name="subject"&gt;
 *   &lt;ref name="principal"/&gt;
 *   &lt;zeroOrMore&gt;
 *     &lt;ref name="other"/&gt;
 *   &lt;/zeroOrMore&gt;
 * &lt;/element&gt;
 * </pre>
 *
 * @version session.rng (Tue Sep 09 06:58:49 GMT+09:00 2003)
 * @author  Relaxer 1.0rc3b (http://www.relaxer.org)
 */
public class RSSubject implements java.io.Serializable, Cloneable, IRNSContainer, IRNode {
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework/session");
    private RSPrincipal principal_;
    // List<RSOtherAnyElement>
    private java.util.List otherAnyElement_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>RSSubject</code>.
     *
     */
    public RSSubject() {
    }

    /**
     * Creates a <code>RSSubject</code>.
     *
     * @param source
     */
    public RSSubject(RSSubject source) {
        setup(source);
    }

    /**
     * Creates a <code>RSSubject</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public RSSubject(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>RSSubject</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public RSSubject(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>RSSubject</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public RSSubject(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>RSSubject</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RSSubject(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>RSSubject</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RSSubject(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>RSSubject</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RSSubject(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>RSSubject</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RSSubject(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>RSSubject</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RSSubject(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>RSSubject</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public RSSubject(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>RSSubject</code> by the RSSubject <code>source</code>.
     *
     * @param source
     */
    public void setup(RSSubject source) {
        int size;
        setPrincipal((RSPrincipal)source.getPrincipal().clone());
        this.otherAnyElement_.clear();
        size = source.otherAnyElement_.size();
        for (int i = 0;i < size;i++) {
            addOtherAnyElement((RSOtherAnyElement)source.getOtherAnyElement(i).clone());
        }
    }

    /**
     * Initializes the <code>RSSubject</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>RSSubject</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>RSSubject</code> by the Stack <code>stack</code>
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
        setPrincipal(new RSPrincipal(stack));
        otherAnyElement_.clear();
        while (true) {
            if (RSOtherAnyElement.isMatch(stack)) {
                addOtherAnyElement(new RSOtherAnyElement(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new RSSubject(this));
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
        Element element = doc.createElementNS("http://www.relaxer.org/xmlns/framework/session", "subject");
        rNSContext_.setupNamespace(element);
        int size;
        this.principal_.makeElement(element);
        size = this.otherAnyElement_.size();
        for (int i = 0;i < size;i++) {
            RSOtherAnyElement value = (RSOtherAnyElement)this.otherAnyElement_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>RSSubject</code> by the File <code>file</code>.
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
     * Initializes the <code>RSSubject</code>
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
     * Initializes the <code>RSSubject</code> by the URL <code>url</code>.
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
     * Initializes the <code>RSSubject</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>RSSubject</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>RSSubject</code> by the Reader <code>reader</code>.
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
     * Gets the RSPrincipal property <b>principal</b>.
     *
     * @return RSPrincipal
     */
    public final RSPrincipal getPrincipal() {
        return (principal_);
    }

    /**
     * Sets the RSPrincipal property <b>principal</b>.
     *
     * @param principal
     */
    public final void setPrincipal(RSPrincipal principal) {
        this.principal_ = principal;
        if (principal != null) {
            principal.rSetParentRNode(this);
        }
    }

    /**
     * Gets the RSOtherAnyElement property <b>otherAnyElement</b>.
     *
     * @return RSOtherAnyElement[]
     */
    public final RSOtherAnyElement[] getOtherAnyElement() {
        RSOtherAnyElement[] array = new RSOtherAnyElement[otherAnyElement_.size()];
        return ((RSOtherAnyElement[])otherAnyElement_.toArray(array));
    }

    /**
     * Sets the RSOtherAnyElement property <b>otherAnyElement</b>.
     *
     * @param otherAnyElement
     */
    public final void setOtherAnyElement(RSOtherAnyElement[] otherAnyElement) {
        this.otherAnyElement_.clear();
        for (int i = 0;i < otherAnyElement.length;i++) {
            addOtherAnyElement(otherAnyElement[i]);
        }
        for (int i = 0;i < otherAnyElement.length;i++) {
            otherAnyElement[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the RSOtherAnyElement property <b>otherAnyElement</b>.
     *
     * @param otherAnyElement
     */
    public final void setOtherAnyElement(RSOtherAnyElement otherAnyElement) {
        this.otherAnyElement_.clear();
        addOtherAnyElement(otherAnyElement);
        if (otherAnyElement != null) {
            otherAnyElement.rSetParentRNode(this);
        }
    }

    /**
     * Adds the RSOtherAnyElement property <b>otherAnyElement</b>.
     *
     * @param otherAnyElement
     */
    public final void addOtherAnyElement(RSOtherAnyElement otherAnyElement) {
        this.otherAnyElement_.add(otherAnyElement);
        if (otherAnyElement != null) {
            otherAnyElement.rSetParentRNode(this);
        }
    }

    /**
     * Adds the RSOtherAnyElement property <b>otherAnyElement</b>.
     *
     * @param otherAnyElement
     */
    public final void addOtherAnyElement(RSOtherAnyElement[] otherAnyElement) {
        for (int i = 0;i < otherAnyElement.length;i++) {
            addOtherAnyElement(otherAnyElement[i]);
        }
        for (int i = 0;i < otherAnyElement.length;i++) {
            otherAnyElement[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the RSOtherAnyElement property <b>otherAnyElement</b>.
     *
     * @return int
     */
    public final int sizeOtherAnyElement() {
        return (otherAnyElement_.size());
    }

    /**
     * Gets the RSOtherAnyElement property <b>otherAnyElement</b> by index.
     *
     * @param index
     * @return RSOtherAnyElement
     */
    public final RSOtherAnyElement getOtherAnyElement(int index) {
        return ((RSOtherAnyElement)otherAnyElement_.get(index));
    }

    /**
     * Sets the RSOtherAnyElement property <b>otherAnyElement</b> by index.
     *
     * @param index
     * @param otherAnyElement
     */
    public final void setOtherAnyElement(int index, RSOtherAnyElement otherAnyElement) {
        this.otherAnyElement_.set(index, otherAnyElement);
        if (otherAnyElement != null) {
            otherAnyElement.rSetParentRNode(this);
        }
    }

    /**
     * Adds the RSOtherAnyElement property <b>otherAnyElement</b> by index.
     *
     * @param index
     * @param otherAnyElement
     */
    public final void addOtherAnyElement(int index, RSOtherAnyElement otherAnyElement) {
        this.otherAnyElement_.add(index, otherAnyElement);
        if (otherAnyElement != null) {
            otherAnyElement.rSetParentRNode(this);
        }
    }

    /**
     * Remove the RSOtherAnyElement property <b>otherAnyElement</b> by index.
     *
     * @param index
     */
    public final void removeOtherAnyElement(int index) {
        this.otherAnyElement_.remove(index);
    }

    /**
     * Remove the RSOtherAnyElement property <b>otherAnyElement</b> by object.
     *
     * @param otherAnyElement
     */
    public final void removeOtherAnyElement(RSOtherAnyElement otherAnyElement) {
        this.otherAnyElement_.remove(otherAnyElement);
    }

    /**
     * Clear the RSOtherAnyElement property <b>otherAnyElement</b>.
     *
     */
    public final void clearOtherAnyElement() {
        this.otherAnyElement_.clear();
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
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/session");
        buffer.append("<");
        URelaxer.makeQName(prefix, "subject", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.append(">");
        principal_.makeTextElement(buffer);
        size = this.otherAnyElement_.size();
        for (int i = 0;i < size;i++) {
            RSOtherAnyElement value = (RSOtherAnyElement)this.otherAnyElement_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</");
        URelaxer.makeQName(prefix, "subject", buffer);
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
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/session");
        buffer.write("<");
        URelaxer.makeQName(prefix, "subject", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.write(">");
        principal_.makeTextElement(buffer);
        size = this.otherAnyElement_.size();
        for (int i = 0;i < size;i++) {
            RSOtherAnyElement value = (RSOtherAnyElement)this.otherAnyElement_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</");
        URelaxer.makeQName(prefix, "subject", buffer);
        buffer.write(">");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        String prefix = rNSContext_.getPrefixByUri("http://www.relaxer.org/xmlns/framework/session");
        buffer.print("<");
        URelaxer.makeQName(prefix, "subject", buffer);
        rNSContext_.makeNSMappings(buffer);
        buffer.print(">");
        principal_.makeTextElement(buffer);
        size = this.otherAnyElement_.size();
        for (int i = 0;i < size;i++) {
            RSOtherAnyElement value = (RSOtherAnyElement)this.otherAnyElement_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</");
        URelaxer.makeQName(prefix, "subject", buffer);
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
        classNodes.add(principal_);
        classNodes.addAll(otherAnyElement_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>RSSubject</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.relaxer.org/xmlns/framework/session", "subject")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!RSPrincipal.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!RSOtherAnyElement.isMatchHungry(target)) {
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
     * is valid for the <code>RSSubject</code>.
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
     * is valid for the <code>RSSubject</code>.
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
