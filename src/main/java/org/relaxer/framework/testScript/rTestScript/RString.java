package org.relaxer.framework.testScript.rTestScript;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import org.w3c.dom.*;

/**
 * <b>RString</b> is a text container class which is used for mixed.
 *
 * @version testScript.rng 1.0 (Mon Sep 29 12:19:24 JST 2003)
 * @author  Relaxer 1.0b (http://www.relaxer.org)
 */
public class RString implements java.io.Serializable, Cloneable, ITSExpressionMixed, ITSValueElementMixed, ITSAnyMixed, IREvaluatable, IRNode {
    private String text;
    private IRNode parentRNode_;

    /**
     * Creates a <code>RString</code>.
     *
     */
    public RString() {
    }

    /**
     * Creates a <code>RString</code> by the String <code>text</code>.
     *
     * @param text
     */
    public RString(String text) {
        this.text = text;
    }

    /**
     * Creates a <code>RString</code> by the Rstring <code>source</code>.
     *
     * @param source
     */
    public RString(RString source) {
        this(source.getContent());
    }

    /**
     * Creates a <code>RString</code> by the Stack <code>stack</code>.
     * This constructor is supposed to be used internallyby the Relaxer system.
     *
     * @param stack
     */
    public RString(RStack stack) {
        setup(stack);
    }

    /**
     * Initializes the <code>RString</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internallyby the Relaxer system.
     *
     * @param stack
     */
    public void setup(RStack stack) {
        text = stack.pop().toString();
    }

    /**
     * Creates a DOM representation of the object.
     * Result is appended to the Node <code>parent</code>.
     *
     * @param node
     */
    public void makeElement(Node node) {
        Document doc = node.getOwnerDocument();
        node.appendChild(doc.createTextNode(text));
    }

    /**
     * Gets the text.
     *
     * @return String
     */
    public String getText() {
        return (text);
    }

    /**
     * Sets the text.
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the text content.
     *
     * @return String
     */
    public String getContent() {
        return (text);
    }

    /**
     * Sets the text content.
     *
     * @param text
     */
    public void setContent(String text) {
        this.text = text;
    }

    /**
     * Gets the text content as String.
     *
     * @return String
     */
    public String getContentAsString() {
        return (text);
    }

    /**
     * Gets the String.
     *
     * @return String
     */
    public String toString() {
        return (text);
    }

    /**
     * Clones the String.
     *
     * @return Object
     */
    public Object clone() {
        return (new RString(this));
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(StringBuffer buffer) {
        buffer.append(URelaxer.escapeCharData(text));
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        buffer.write(URelaxer.escapeCharData(text));
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        buffer.print(URelaxer.escapeCharData(text));
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
     * Evaluates the node.
     *
     * @exception REvaluationException
     * @return Object
     */
    public Object eval() throws REvaluationException {
        return (getText());
    }

    /**
     * Evaluates the node with the evaluation context.
     *
     * @param context
     * @exception REvaluationException
     * @return Object
     */
    public Object eval(IREvaluationContext context) throws REvaluationException {
        return (getText());
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
        if (params == null) {
            return (null);
        }if (params.length == 0) {
            return (null);
        }if (params[0] instanceof String) {
            return (params[0]);
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i < params.length;i++) {
            buffer.append(params[i].toString());
        }
        return (new String(buffer));
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
     * @return IRNode[]
     */
    public IRNode[] rGetRNodes() {
        return (new IRNode[0]);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>RString</code>.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return boolean
     */
    public static boolean isMatch(RStack stack) {
        return (stack.peek() instanceof String);
    }
}
