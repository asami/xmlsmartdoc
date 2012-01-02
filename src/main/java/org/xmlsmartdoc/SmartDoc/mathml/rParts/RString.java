package org.xmlsmartdoc.SmartDoc.mathml.rParts;

import org.w3c.dom.*;

/**
 * <b>RString</b> is a text container class which is used for mixed.
 *
 * @version MathML.rlx 1.0 (Sat Sep 09 10:49:00 JST 2000)
 * @author  Relaxer 0.11b (by ASAMI@Yokohama)
 */
public class RString implements java.io.Serializable, IMMiPCDATA, IMMnPCDATA, IMMoPCDATA, IMMtextPCDATA, IMMsPCDATA, IMCiPCDATA, IMCnPCDATA, IRVisitable, IRNode {
    private String text;
    private IRNode parentRNode;

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
     * Gets the String.
     *
     * @return String
     */
    public String toString() {
        return (text);
    }

    /**
     * Accepts the Visitor for enter behavior.
     *
     * @param visitor
     */
    public void enter(IRVisitor visitor) {
        visitor.enter(this);
    }

    /**
     * Accepts the Visitor for leave behavior.
     *
     * @param visitor
     */
    public void leave(IRVisitor visitor) {
        visitor.leave(this);
    }

    /**
     * Gets the IRNode property <b>parentRNode</b>.
     *
     * @return IRNode
     */
    public final IRNode getParentRNode() {
        return (parentRNode);
    }

    /**
     * Sets the IRNode property <b>parentRNode</b>.
     *
     * @param parentRNode
     */
    public final void setParentRNode(IRNode parentRNode) {
        this.parentRNode = parentRNode;
    }

    /**
     * @return IRNode[]
     */
    public IRNode[] getRNodes() {
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
