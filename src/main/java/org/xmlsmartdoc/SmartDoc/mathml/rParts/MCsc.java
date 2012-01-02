package org.xmlsmartdoc.SmartDoc.mathml.rParts;

import org.w3c.dom.*;

/**
 * <b>MCsc</b> is generated by Relaxer based on MathML.rlx.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <elementRule role="csc">
 *   <empty/>
 * </elementRule>
 * 
 * <tag name="csc">
 *   <attribute name="definitionURL" type="string"/>
 *   <attribute name="class" type="string"/>
 *   <attribute name="style" type="string"/>
 *   <attribute name="id" type="ID"/>
 *   <attribute name="other" type="string"/>
 * </tag>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;elementRule role="csc"&gt;
 *   &lt;empty/&gt;
 * &lt;/elementRule&gt;
 * &lt;tag name="csc"&gt;
 *   &lt;attribute name="definitionURL" type="string"/&gt;
 *   &lt;attribute name="class" type="string"/&gt;
 *   &lt;attribute name="style" type="string"/&gt;
 *   &lt;attribute name="id" type="ID"/&gt;
 *   &lt;attribute name="other" type="string"/&gt;
 * &lt;/tag&gt;
 * </pre>
 *
 * @version MathML.rlx 1.0 (Sat Sep 09 10:48:47 JST 2000)
 * @author  Relaxer 0.11b (by ASAMI@Yokohama)
 */
public class MCsc implements java.io.Serializable, IRVisitable, IRNode, IMLogbaseContent, IMFnContent, IMDegreeContent, IMBvarContent, IMUplimitContent, IMLowlimitContent, IMVectorContent, IMSetContent, IMMatrixrowContent, IMMatrixContent, IMListContent, IMIntervalContent, IMAnnotationXmlContent, IMSemanticsContent, IMDeclareContent, IMConditionContent, IMLambdaContent, IMRelnContent, IMApplyContent {
    private String definitionURL;
    private String classValue;
    private String style;
    private String id;
    private String other;
    private IRNode parentRNode;

    /**
     * Creates a <code>MCsc</code>.
     *
     */
    public MCsc() {
    }

    /**
     * Creates a <code>MCsc</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public MCsc(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>MCsc</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public MCsc(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>MCsc</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public MCsc(Element element) {
        setup(element);
    }

    /**
     * Initializes the <code>MCsc</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>MCsc</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>MCsc</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public void setup(RStack stack) {
        setup(stack.popElement());
    }

    /**
     * @param element
     */
    private void init(Element element) {
        RStack stack = new RStack(element);
        definitionURL = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "definitionURL");
        classValue = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "class");
        style = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "style");
        id = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "id");
        other = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "other");
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
        Element element = doc.createElement("csc");
        int size;
        if (definitionURL != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "definitionURL", definitionURL);
        }
        if (classValue != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "class", classValue);
        }
        if (style != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "style", style);
        }
        if (id != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "id", id);
        }
        if (other != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "other", other);
        }
        parent.appendChild(element);
    }

    /**
     * Gets the String property <b>definitionURL</b>.
     *
     * @return String
     */
    public final String getDefinitionURL() {
        return (definitionURL);
    }

    /**
     * Sets the String property <b>definitionURL</b>.
     *
     * @param definitionURL
     */
    public final void setDefinitionURL(String definitionURL) {
        this.definitionURL = definitionURL;
    }

    /**
     * Gets the String property <b>classValue</b>.
     *
     * @return String
     */
    public final String getClassValue() {
        return (classValue);
    }

    /**
     * Sets the String property <b>classValue</b>.
     *
     * @param classValue
     */
    public final void setClassValue(String classValue) {
        this.classValue = classValue;
    }

    /**
     * Gets the String property <b>style</b>.
     *
     * @return String
     */
    public final String getStyle() {
        return (style);
    }

    /**
     * Sets the String property <b>style</b>.
     *
     * @param style
     */
    public final void setStyle(String style) {
        this.style = style;
    }

    /**
     * Gets the String property <b>id</b>.
     *
     * @return String
     */
    public final String getId() {
        return (id);
    }

    /**
     * Sets the String property <b>id</b>.
     *
     * @param id
     */
    public final void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the String property <b>other</b>.
     *
     * @return String
     */
    public final String getOther() {
        return (other);
    }

    /**
     * Sets the String property <b>other</b>.
     *
     * @param other
     */
    public final void setOther(String other) {
        this.other = other;
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
     * Gets child RNodes.
     *
     * @return IRNode[]
     */
    public IRNode[] getRNodes() {
        java.util.List classNodes = new java.util.ArrayList();
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>MCsc</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.w3.org/1998/Math/MathML", "csc")) {
            return (false);
        }
        RStack target = new RStack(element);
        Element child;
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>MCsc</code>.
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
     * is valid for the <code>MCsc</code>.
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
