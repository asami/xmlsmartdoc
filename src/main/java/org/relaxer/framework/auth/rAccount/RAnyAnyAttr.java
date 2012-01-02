package org.relaxer.framework.auth.rAccount;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import org.w3c.dom.*;

/**
 * <b>RAnyAnyAttr</b> is generated from account.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <attribute>
 *   <anyName/>
 * </attribute>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;attribute&gt;
 *   &lt;anyName/&gt;
 * &lt;/attribute&gt;
 * </pre>
 *
 * @version account.rng (Tue Sep 09 05:58:15 GMT+09:00 2003)
 * @author  Relaxer 1.0rc3b (http://www.relaxer.org)
 */
public class RAnyAnyAttr implements java.io.Serializable, Cloneable, IRNSContainer, IRNode, IRAnyMixed, IRAnyMixedChoice {
    private static RNameClassNS $nameClass$ = new RNameClassNS("<anyName></anyName>", "http://www.relaxer.org/xmlns/framework/account");
    private String $namespaceUri$ = "";
    private String $localName$ = "attribute";
    private RNSContext rNSContext_ = new RNSContext(this, "http://www.relaxer.org/xmlns/framework/account");
    private String content_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>RAnyAnyAttr</code>.
     *
     */
    public RAnyAnyAttr() {
    }

    /**
     * Creates a <code>RAnyAnyAttr</code>.
     *
     * @param source
     */
    public RAnyAnyAttr(RAnyAnyAttr source) {
        setup(source);
    }

    /**
     * Creates a <code>RAnyAnyAttr</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public RAnyAnyAttr(RStack stack) {
        setup(stack);
    }

    /**
     * Initializes the <code>RAnyAnyAttr</code> by the RAnyAnyAttr <code>source</code>.
     *
     * @param source
     */
    public void setup(RAnyAnyAttr source) {
        int size;
        setContent(source.getContent());
    }

    /**
     * Initializes the <code>RAnyAnyAttr</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public void setup(RStack stack) {
        String[] result = $nameClass$.getAttributeHungry(stack);
        $namespaceUri$ = result[0];
        $localName$ = result[1];
        String value = result[2];
        setContent(value.toString());
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new RAnyAnyAttr(this));
    }

    /**
     * Creates a DOM representation of the object.
     * Result is appended to the Node <code>parent</code>.
     *
     * @param parent
     */
    public void makeElement(Node parent) {
        Document doc = parent.getOwnerDocument();
        Element element = (Element)parent;
        String prefix = rNSContext_.getPrefixByUri($namespaceUri$);
        element.setAttributeNS($namespaceUri$, URelaxer.getQName(prefix, $localName$), URelaxer.getString(getContent()));
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
     * Gets the String property <b>content</b>.
     *
     * @return String
     */
    public final String getContent() {
        return (content_);
    }

    /**
     * Sets the String property <b>content</b>.
     *
     * @param content
     */
    public final void setContent(String content) {
        this.content_ = content;
    }

    /**
     * Makes an XML text representation.
     *
     * @return String
     */
    public String makeTextDocument() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(URelaxer.escapeCharData(URelaxer.getString(getContent())));
        return (new String(buffer));
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(StringBuffer buffer) {
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(StringBuffer buffer) {
        String prefix = rNSContext_.getPrefixByUri($namespaceUri$);
        buffer.append(" ");
        URelaxer.makeQName(prefix, $localName$, buffer);
        buffer.append("=\"");
        buffer.append(URelaxer.escapeCharData(URelaxer.getString(getContent())));
        buffer.append("\"");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextAttribute(Writer buffer) throws IOException {
        String prefix = rNSContext_.getPrefixByUri($namespaceUri$);
        buffer.write(" ");
        URelaxer.makeQName(prefix, $localName$, buffer);
        buffer.write("=\"");
        buffer.write(URelaxer.escapeCharData(URelaxer.getString(getContent())));
        buffer.write("\"");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(PrintWriter buffer) {
        String prefix = rNSContext_.getPrefixByUri($namespaceUri$);
        buffer.print(" ");
        URelaxer.makeQName(prefix, $localName$, buffer);
        buffer.print("=\"");
        buffer.print(URelaxer.escapeCharData(URelaxer.getString(getContent())));
        buffer.print("\"");
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getContentAsString() {
        return (URelaxer.getString(getContent()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setContentByString(String string) {
        setContent(string);
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
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>RAnyAnyAttr</code>.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return boolean
     */
    public static boolean isMatch(RStack stack) {
        return (isMatchHungry(stack.makeClone()));
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>RAnyAnyAttr</code>.
     * This method consumes the stack contents during matching operation.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return boolean
     */
    public static boolean isMatchHungry(RStack stack) {
        RStack target = stack;
        boolean $match$ = false;
        Element element = stack.peekElement();
        if (!$nameClass$.isMatchAttributeHungry(target)) {
            return (false);
        }
        $match$ = true;
        return ($match$);
    }
}
