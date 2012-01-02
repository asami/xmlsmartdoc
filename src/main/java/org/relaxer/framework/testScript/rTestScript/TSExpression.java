package org.relaxer.framework.testScript.rTestScript;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import org.w3c.dom.*;

/**
 * <b>TSExpression</b> is generated from testScript.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <define name="expression">
 *   <choice>
 *     <text/>
 *     <ref name="invoke-object"/>
 *     <ref name="invoke-service"/>
 *     <ref name="assert"/>
 *     <ref name="assert-return"/>
 *     <ref name="assert-exception"/>
 *   </choice>
 * </define>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;define name="expression"&gt;
 *   &lt;choice&gt;
 *     &lt;text/&gt;
 *     &lt;ref name="invoke-object"/&gt;
 *     &lt;ref name="invoke-service"/&gt;
 *     &lt;ref name="assert"/&gt;
 *     &lt;ref name="assert-return"/&gt;
 *     &lt;ref name="assert-exception"/&gt;
 *   &lt;/choice&gt;
 * &lt;/define&gt;
 * </pre>
 *
 * @version testScript.rng (Mon Sep 29 12:19:24 JST 2003)
 * @author  Relaxer 1.0b (http://www.relaxer.org)
 */
public class TSExpression implements java.io.Serializable, Cloneable, IREvaluatable, IRNode, ITSValueExpressionChoice {
    private ITSExpressionMixed content_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>TSExpression</code>.
     *
     */
    public TSExpression() {
    }

    /**
     * Creates a <code>TSExpression</code>.
     *
     * @param source
     */
    public TSExpression(TSExpression source) {
        setup(source);
    }

    /**
     * Creates a <code>TSExpression</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public TSExpression(RStack stack) {
        setup(stack);
    }

    /**
     * Initializes the <code>TSExpression</code> by the TSExpression <code>source</code>.
     *
     * @param source
     */
    public void setup(TSExpression source) {
        int size;
        setContent((ITSExpressionMixed)source.getContent().clone());
    }

    /**
     * Initializes the <code>TSExpression</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public void setup(RStack stack) {
        Element element = stack.getContextElement();
        ITestScriptFactory factory = TestScriptFactory.getFactory();
        if (RString.isMatch(stack)) {
            setContent(factory.createRString(stack));
        } else if (TSInvokeObject.isMatch(stack)) {
            setContent(factory.createTSInvokeObject(stack));
        } else if (TSInvokeService.isMatch(stack)) {
            setContent(factory.createTSInvokeService(stack));
        } else if (TSAssert.isMatch(stack)) {
            setContent(factory.createTSAssert(stack));
        } else if (TSAssertReturn.isMatch(stack)) {
            setContent(factory.createTSAssertReturn(stack));
        } else if (TSAssertException.isMatch(stack)) {
            setContent(factory.createTSAssertException(stack));
        } else {
        // XXX
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        ITestScriptFactory factory = TestScriptFactory.getFactory();
        return (factory.createTSExpression(this));
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
        int size;
        if (content_ != null) {
            content_.makeElement(element);
        }
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
     * @return ITSExpressionMixed
     */
    public final ITSExpressionMixed getContent() {
        return (content_);
    }

    /**
     * Sets the ITSExpressionMixed property <b>content</b>.
     *
     * @param content
     */
    public final void setContent(ITSExpressionMixed content) {
        this.content_ = content;
        if (content != null) {
            content.rSetParentRNode(this);
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
        content_.makeTextElement(buffer);
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        content_.makeTextElement(buffer);
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        content_.makeTextElement(buffer);
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(StringBuffer buffer) {
        int size;
        content_.makeTextAttribute(buffer);
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextAttribute(Writer buffer) throws IOException {
        int size;
        content_.makeTextAttribute(buffer);
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(PrintWriter buffer) {
        int size;
        content_.makeTextAttribute(buffer);
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
        if (content_ != null) {
            classNodes.add(content_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>TSExpression</code>.
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
     * is valid for the <code>TSExpression</code>.
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
        Element child;
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
            return (false);
        }
        return ($match$);
    }
}
