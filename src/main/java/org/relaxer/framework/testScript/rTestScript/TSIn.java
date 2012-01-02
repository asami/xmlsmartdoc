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
 * <b>TSIn</b> is generated from testScript.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="in">
 *   <ref name="valueExpression"/>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;element name="in"&gt;
 *   &lt;ref name="valueExpression"/&gt;
 * &lt;/element&gt;
 * </pre>
 *
 * @version testScript.rng (Mon Sep 29 12:19:24 JST 2003)
 * @author  Relaxer 1.0b (http://www.relaxer.org)
 */
public class TSIn implements java.io.Serializable, Cloneable, IREvaluatable, IRNode {
    private ITSValueExpressionChoice valueExpression_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>TSIn</code>.
     *
     */
    public TSIn() {
    }

    /**
     * Creates a <code>TSIn</code>.
     *
     * @param source
     */
    public TSIn(TSIn source) {
        setup(source);
    }

    /**
     * Creates a <code>TSIn</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public TSIn(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>TSIn</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public TSIn(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>TSIn</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public TSIn(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>TSIn</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSIn(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>TSIn</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSIn(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>TSIn</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSIn(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>TSIn</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSIn(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>TSIn</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSIn(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>TSIn</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSIn(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>TSIn</code> by the TSIn <code>source</code>.
     *
     * @param source
     */
    public void setup(TSIn source) {
        int size;
        setValueExpression((ITSValueExpressionChoice)source.getValueExpression().clone());
    }

    /**
     * Initializes the <code>TSIn</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>TSIn</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>TSIn</code> by the Stack <code>stack</code>
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
        if (TSValueExpressionValue.isMatch(stack)) {
            setValueExpression(factory.createTSValueExpressionValue(stack));
        } else if (TSExpression.isMatch(stack)) {
            setValueExpression(factory.createTSExpression(stack));
        } else if (TSValueElement.isMatch(stack)) {
            setValueExpression(factory.createTSValueElement(stack));
        } else {
            throw (new IllegalArgumentException());
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        ITestScriptFactory factory = TestScriptFactory.getFactory();
        return (factory.createTSIn(this));
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
        Element element = doc.createElement("in");
        int size;
        this.valueExpression_.makeElement(element);
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>TSIn</code> by the File <code>file</code>.
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
     * Initializes the <code>TSIn</code>
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
     * Initializes the <code>TSIn</code> by the URL <code>url</code>.
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
     * Initializes the <code>TSIn</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>TSIn</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>TSIn</code> by the Reader <code>reader</code>.
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
     * Gets the ITSValueExpressionChoice property <b>valueExpression</b>.
     *
     * @return ITSValueExpressionChoice
     */
    public final ITSValueExpressionChoice getValueExpression() {
        return (valueExpression_);
    }

    /**
     * Sets the ITSValueExpressionChoice property <b>valueExpression</b>.
     *
     * @param valueExpression
     */
    public final void setValueExpression(ITSValueExpressionChoice valueExpression) {
        this.valueExpression_ = valueExpression;
        if (valueExpression != null) {
            valueExpression.rSetParentRNode(this);
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
        buffer.append("<in");
        valueExpression_.makeTextAttribute(buffer);
        buffer.append(">");
        valueExpression_.makeTextElement(buffer);
        buffer.append("</in>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<in");
        valueExpression_.makeTextAttribute(buffer);
        buffer.write(">");
        valueExpression_.makeTextElement(buffer);
        buffer.write("</in>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<in");
        valueExpression_.makeTextAttribute(buffer);
        buffer.print(">");
        valueExpression_.makeTextElement(buffer);
        buffer.print("</in>");
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
        if (valueExpression_ != null) {
            classNodes.add(valueExpression_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>TSIn</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "in")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (TSValueExpressionValue.isMatchHungry(target)) {
            $match$ = true;
        } else if (TSExpression.isMatchHungry(target)) {
            $match$ = true;
        } else if (TSValueElement.isMatchHungry(target)) {
            $match$ = true;
        } else {
            return (false);
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>TSIn</code>.
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
     * is valid for the <code>TSIn</code>.
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
