package org.relaxer.framework.testScript.rTestScript;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>TSBody</b> is generated from testScript.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="body">
 *   <zeroOrMore>
 *     <ref name="expression"/>
 *   </zeroOrMore>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;element name="body"&gt;
 *   &lt;zeroOrMore&gt;
 *     &lt;ref name="expression"/&gt;
 *   &lt;/zeroOrMore&gt;
 * &lt;/element&gt;
 * </pre>
 *
 * @version testScript.rng (Mon Sep 29 12:19:24 JST 2003)
 * @author  Relaxer 1.0b (http://www.relaxer.org)
 */
public class TSBody implements java.io.Serializable, Cloneable, IREvaluatable, IRNode {
    // List<ITSExpressionMixed>
    private java.util.List content_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>TSBody</code>.
     *
     */
    public TSBody() {
    }

    /**
     * Creates a <code>TSBody</code>.
     *
     * @param source
     */
    public TSBody(TSBody source) {
        setup(source);
    }

    /**
     * Creates a <code>TSBody</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public TSBody(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>TSBody</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public TSBody(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>TSBody</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public TSBody(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>TSBody</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSBody(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>TSBody</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSBody(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>TSBody</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSBody(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>TSBody</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSBody(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>TSBody</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSBody(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>TSBody</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSBody(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>TSBody</code> by the TSBody <code>source</code>.
     *
     * @param source
     */
    public void setup(TSBody source) {
        int size;
        this.content_.clear();
        size = source.content_.size();
        for (int i = 0;i < size;i++) {
            addContent((ITSExpressionMixed)source.getContent(i).clone());
        }
    }

    /**
     * Initializes the <code>TSBody</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>TSBody</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>TSBody</code> by the Stack <code>stack</code>
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
        ITestScriptFactory factory = TestScriptFactory.getFactory();
        RStack stack = new RStack(element);
        this.content_.clear();
        while (true) {
            if (RString.isMatch(stack)) {
                addContent(factory.createRString(stack));
            } else if (TSInvokeObject.isMatch(stack)) {
                addContent(factory.createTSInvokeObject(stack));
            } else if (TSInvokeService.isMatch(stack)) {
                addContent(factory.createTSInvokeService(stack));
            } else if (TSAssert.isMatch(stack)) {
                addContent(factory.createTSAssert(stack));
            } else if (TSAssertReturn.isMatch(stack)) {
                addContent(factory.createTSAssertReturn(stack));
            } else if (TSAssertException.isMatch(stack)) {
                addContent(factory.createTSAssertException(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        ITestScriptFactory factory = TestScriptFactory.getFactory();
        return (factory.createTSBody(this));
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
        Element element = doc.createElement("body");
        int size;
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            ITSExpressionMixed value = (ITSExpressionMixed)this.content_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>TSBody</code> by the File <code>file</code>.
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
     * Initializes the <code>TSBody</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(uri, UJAXP.FLAG_NONE));
    }

    /**
     * Initializes the <code>TSBody</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(url, UJAXP.FLAG_NONE));
    }

    /**
     * Initializes the <code>TSBody</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(in, UJAXP.FLAG_NONE));
    }

    /**
     * Initializes the <code>TSBody</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(is, UJAXP.FLAG_NONE));
    }

    /**
     * Initializes the <code>TSBody</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public void setup(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(UJAXP.getDocument(reader, UJAXP.FLAG_NONE));
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
     * Gets the ITSExpressionMixed property <b>content</b>.
     *
     * @return ITSExpressionMixed[]
     */
    public final ITSExpressionMixed[] getContent() {
        ITSExpressionMixed[] array = new ITSExpressionMixed[content_.size()];
        return ((ITSExpressionMixed[])content_.toArray(array));
    }

    /**
     * Sets the ITSExpressionMixed property <b>content</b>.
     *
     * @param content
     */
    public final void setContent(ITSExpressionMixed[] content) {
        this.content_.clear();
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
        for (int i = 0;i < content.length;i++) {
            content[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the ITSExpressionMixed property <b>content</b>.
     *
     * @param content
     */
    public final void setContent(ITSExpressionMixed content) {
        this.content_.clear();
        addContent(content);
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ITSExpressionMixed property <b>content</b>.
     *
     * @param content
     */
    public final void addContent(ITSExpressionMixed content) {
        this.content_.add(content);
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ITSExpressionMixed property <b>content</b>.
     *
     * @param content
     */
    public final void addContent(ITSExpressionMixed[] content) {
        for (int i = 0;i < content.length;i++) {
            addContent(content[i]);
        }
        for (int i = 0;i < content.length;i++) {
            content[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the ITSExpressionMixed property <b>content</b>.
     *
     * @return int
     */
    public final int sizeContent() {
        return (content_.size());
    }

    /**
     * Gets the ITSExpressionMixed property <b>content</b> by index.
     *
     * @param index
     * @return ITSExpressionMixed
     */
    public final ITSExpressionMixed getContent(int index) {
        return ((ITSExpressionMixed)content_.get(index));
    }

    /**
     * Sets the ITSExpressionMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public final void setContent(int index, ITSExpressionMixed content) {
        this.content_.set(index, content);
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Adds the ITSExpressionMixed property <b>content</b> by index.
     *
     * @param index
     * @param content
     */
    public final void addContent(int index, ITSExpressionMixed content) {
        this.content_.add(index, content);
        if (content != null) {
            content.rSetParentRNode(this);
        }
    }

    /**
     * Remove the ITSExpressionMixed property <b>content</b> by index.
     *
     * @param index
     */
    public final void removeContent(int index) {
        this.content_.remove(index);
    }

    /**
     * Remove the ITSExpressionMixed property <b>content</b> by object.
     *
     * @param content
     */
    public final void removeContent(ITSExpressionMixed content) {
        this.content_.remove(content);
    }

    /**
     * Clear the ITSExpressionMixed property <b>content</b>.
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
        buffer.append("<body");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            ITSExpressionMixed value = (ITSExpressionMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            ITSExpressionMixed value = (ITSExpressionMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</body>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<body");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            ITSExpressionMixed value = (ITSExpressionMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            ITSExpressionMixed value = (ITSExpressionMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</body>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<body");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            ITSExpressionMixed value = (ITSExpressionMixed)this.content_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.content_.size();
        for (int i = 0;i < size;i++) {
            ITSExpressionMixed value = (ITSExpressionMixed)this.content_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</body>");
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
     * Evaluates the node.
     *
     * @exception REvaluationException
     * @return Object
     */
    public Object eval() throws REvaluationException {
        return (eval(new RSimpleEvaluationContext()));
    }

    /**
     * Evaluates the node with the evaluation context.
     *
     * @param context
     * @exception REvaluationException
     * @return Object
     */
    public Object eval(IREvaluationContext context) throws REvaluationException {
        IRNode[] children = rGetRNodes();
        Object[] params = new Object[children.length];
        for (int i = 0;i < children.length;i++) {
            IRNode child = children[i];
            if (child instanceof IREvaluatable) {
                params[i] = ((IREvaluatable)child).eval(context);
            } else {
                params[i] = child;
            }
        }
        return (eval(params, context));
    }

    /**
     * Evaluates against the params.
     *
     * @param params
     * @param context
     * @exception REvaluationException
     * @return Object
     */
    public Object eval(Object[] params, IREvaluationContext context) throws REvaluationException {
        return (this);
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
     * for the <code>TSBody</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "body")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        while (true) {
            if (TSInvokeObject.isMatchHungry(target)) {
                $match$ = true;
            } else if (TSInvokeService.isMatchHungry(target)) {
                $match$ = true;
            } else if (TSAssert.isMatchHungry(target)) {
                $match$ = true;
            } else if (TSAssertReturn.isMatchHungry(target)) {
                $match$ = true;
            } else if (TSAssertException.isMatchHungry(target)) {
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
     * is valid for the <code>TSBody</code>.
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
     * is valid for the <code>TSBody</code>.
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
