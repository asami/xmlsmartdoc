package org.xmlsmartdoc.SmartDoc.mathml.rParts;

import org.w3c.dom.*;

/**
 * <b>MMroot</b> is generated by Relaxer based on MathML.rlx.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <elementRule role="mroot">
 *   <choice occurs="*">
 *     <ref label="mi"/>
 *     <ref label="mn"/>
 *     <ref label="mo"/>
 *     <ref label="mtext"/>
 *     <ref label="ms"/>
 *     <ref label="mspace"/>
 *     <ref label="mprescripts"/>
 *     <ref label="none"/>
 *     <ref label="mrow"/>
 *     <ref label="mfrac"/>
 *     <ref label="msqrt"/>
 *     <ref label="mroot"/>
 *     <ref label="mstyle"/>
 *     <ref label="merror"/>
 *     <ref label="mpadded"/>
 *     <ref label="mphantom"/>
 *     <ref label="mfenced"/>
 *     <ref label="msub"/>
 *     <ref label="msup"/>
 *     <ref label="msubsup"/>
 *     <ref label="munder"/>
 *     <ref label="mover"/>
 *     <ref label="munderover"/>
 *     <ref label="mmultiscripts"/>
 *     <ref label="mtable"/>
 *     <ref label="mtr"/>
 *     <ref label="mtd"/>
 *     <ref label="maligngroup"/>
 *     <ref label="malignmark"/>
 *     <ref label="maction"/>
 *     <ref label="ci"/>
 *     <ref label="cn"/>
 *     <ref label="apply"/>
 *     <ref label="fn"/>
 *     <ref label="lambda"/>
 *     <ref label="reln"/>
 *     <ref label="interval"/>
 *     <ref label="list"/>
 *     <ref label="matrix"/>
 *     <ref label="matrixrow"/>
 *     <ref label="set"/>
 *     <ref label="vector"/>
 *     <ref label="semantics"/>
 *   </choice>
 * </elementRule>
 * 
 * <tag name="mroot">
 *   <attribute name="class" type="string"/>
 *   <attribute name="style" type="string"/>
 *   <attribute name="id" type="ID"/>
 *   <attribute name="other" type="string"/>
 * </tag>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;elementRule role="mroot"&gt;
 *   &lt;choice occurs="*"&gt;
 *     &lt;ref label="mi"/&gt;
 *     &lt;ref label="mn"/&gt;
 *     &lt;ref label="mo"/&gt;
 *     &lt;ref label="mtext"/&gt;
 *     &lt;ref label="ms"/&gt;
 *     &lt;ref label="mspace"/&gt;
 *     &lt;ref label="mprescripts"/&gt;
 *     &lt;ref label="none"/&gt;
 *     &lt;ref label="mrow"/&gt;
 *     &lt;ref label="mfrac"/&gt;
 *     &lt;ref label="msqrt"/&gt;
 *     &lt;ref label="mroot"/&gt;
 *     &lt;ref label="mstyle"/&gt;
 *     &lt;ref label="merror"/&gt;
 *     &lt;ref label="mpadded"/&gt;
 *     &lt;ref label="mphantom"/&gt;
 *     &lt;ref label="mfenced"/&gt;
 *     &lt;ref label="msub"/&gt;
 *     &lt;ref label="msup"/&gt;
 *     &lt;ref label="msubsup"/&gt;
 *     &lt;ref label="munder"/&gt;
 *     &lt;ref label="mover"/&gt;
 *     &lt;ref label="munderover"/&gt;
 *     &lt;ref label="mmultiscripts"/&gt;
 *     &lt;ref label="mtable"/&gt;
 *     &lt;ref label="mtr"/&gt;
 *     &lt;ref label="mtd"/&gt;
 *     &lt;ref label="maligngroup"/&gt;
 *     &lt;ref label="malignmark"/&gt;
 *     &lt;ref label="maction"/&gt;
 *     &lt;ref label="ci"/&gt;
 *     &lt;ref label="cn"/&gt;
 *     &lt;ref label="apply"/&gt;
 *     &lt;ref label="fn"/&gt;
 *     &lt;ref label="lambda"/&gt;
 *     &lt;ref label="reln"/&gt;
 *     &lt;ref label="interval"/&gt;
 *     &lt;ref label="list"/&gt;
 *     &lt;ref label="matrix"/&gt;
 *     &lt;ref label="matrixrow"/&gt;
 *     &lt;ref label="set"/&gt;
 *     &lt;ref label="vector"/&gt;
 *     &lt;ref label="semantics"/&gt;
 *   &lt;/choice&gt;
 * &lt;/elementRule&gt;
 * &lt;tag name="mroot"&gt;
 *   &lt;attribute name="class" type="string"/&gt;
 *   &lt;attribute name="style" type="string"/&gt;
 *   &lt;attribute name="id" type="ID"/&gt;
 *   &lt;attribute name="other" type="string"/&gt;
 * &lt;/tag&gt;
 * </pre>
 *
 * @version MathML.rlx 1.0 (Sat Sep 09 10:48:42 JST 2000)
 * @author  Relaxer 0.11b (by ASAMI@Yokohama)
 */
public class MMroot implements java.io.Serializable, IMMrootContent, IMMstyleContent, IMMerrorContent, IMMpaddedContent, IMMphantomContent, IMMfencedContent, IMMsubContent, IMMsupContent, IMMsubsupContent, IMMunderContent, IMMoverContent, IMMunderoverContent, IMMmultiscriptsContent, IMMtableContent, IMMtrContent, IMMtdContent, IMMactionContent, IMCiPCDATA, IMCnPCDATA, IMFnContent, IMLogbaseContent, IMDegreeContent, IMBvarContent, IMUplimitContent, IMLowlimitContent, IMVectorContent, IMSetContent, IMMatrixrowContent, IMMatrixContent, IMListContent, IMIntervalContent, IMAnnotationXmlContent, IMSemanticsContent, IMDeclareContent, IMConditionContent, IMLambdaContent, IMRelnContent, IMApplyContent, IRVisitable, IRNode, IMMsqrtContent, IMMfracContent, IMMrowContent, IMMathContent {
    private String classValue;
    private String style;
    private String id;
    private String other;
    // List<IMMrootContent>
    private java.util.List content = new java.util.ArrayList();
    private IRNode parentRNode;

    /**
     * Creates a <code>MMroot</code>.
     *
     */
    public MMroot() {
    }

    /**
     * Creates a <code>MMroot</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public MMroot(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>MMroot</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public MMroot(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>MMroot</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public MMroot(Element element) {
        setup(element);
    }

    /**
     * Initializes the <code>MMroot</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>MMroot</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>MMroot</code> by the Stack <code>stack</code>
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
        classValue = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "class");
        style = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "style");
        id = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "id");
        other = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "other");
        content.clear();
        while (!stack.isEmptyElement()) {
            if (MMi.isMatch(stack)) {
                addContent(new MMi(stack));
            } else if (MMn.isMatch(stack)) {
                addContent(new MMn(stack));
            } else if (MMo.isMatch(stack)) {
                addContent(new MMo(stack));
            } else if (MMtext.isMatch(stack)) {
                addContent(new MMtext(stack));
            } else if (MMs.isMatch(stack)) {
                addContent(new MMs(stack));
            } else if (MMspace.isMatch(stack)) {
                addContent(new MMspace(stack));
            } else if (MMprescripts.isMatch(stack)) {
                addContent(new MMprescripts(stack));
            } else if (MNone.isMatch(stack)) {
                addContent(new MNone(stack));
            } else if (MMrow.isMatch(stack)) {
                addContent(new MMrow(stack));
            } else if (MMfrac.isMatch(stack)) {
                addContent(new MMfrac(stack));
            } else if (MMsqrt.isMatch(stack)) {
                addContent(new MMsqrt(stack));
            } else if (MMroot.isMatch(stack)) {
                addContent(new MMroot(stack));
            } else if (MMstyle.isMatch(stack)) {
                addContent(new MMstyle(stack));
            } else if (MMerror.isMatch(stack)) {
                addContent(new MMerror(stack));
            } else if (MMpadded.isMatch(stack)) {
                addContent(new MMpadded(stack));
            } else if (MMphantom.isMatch(stack)) {
                addContent(new MMphantom(stack));
            } else if (MMfenced.isMatch(stack)) {
                addContent(new MMfenced(stack));
            } else if (MMsub.isMatch(stack)) {
                addContent(new MMsub(stack));
            } else if (MMsup.isMatch(stack)) {
                addContent(new MMsup(stack));
            } else if (MMsubsup.isMatch(stack)) {
                addContent(new MMsubsup(stack));
            } else if (MMunder.isMatch(stack)) {
                addContent(new MMunder(stack));
            } else if (MMover.isMatch(stack)) {
                addContent(new MMover(stack));
            } else if (MMunderover.isMatch(stack)) {
                addContent(new MMunderover(stack));
            } else if (MMmultiscripts.isMatch(stack)) {
                addContent(new MMmultiscripts(stack));
            } else if (MMtable.isMatch(stack)) {
                addContent(new MMtable(stack));
            } else if (MMtr.isMatch(stack)) {
                addContent(new MMtr(stack));
            } else if (MMtd.isMatch(stack)) {
                addContent(new MMtd(stack));
            } else if (MMaligngroup.isMatch(stack)) {
                addContent(new MMaligngroup(stack));
            } else if (MMalignmark.isMatch(stack)) {
                addContent(new MMalignmark(stack));
            } else if (MMaction.isMatch(stack)) {
                addContent(new MMaction(stack));
            } else if (MCi.isMatch(stack)) {
                addContent(new MCi(stack));
            } else if (MCn.isMatch(stack)) {
                addContent(new MCn(stack));
            } else if (MApply.isMatch(stack)) {
                addContent(new MApply(stack));
            } else if (MFn.isMatch(stack)) {
                addContent(new MFn(stack));
            } else if (MLambda.isMatch(stack)) {
                addContent(new MLambda(stack));
            } else if (MReln.isMatch(stack)) {
                addContent(new MReln(stack));
            } else if (MInterval.isMatch(stack)) {
                addContent(new MInterval(stack));
            } else if (MList.isMatch(stack)) {
                addContent(new MList(stack));
            } else if (MMatrix.isMatch(stack)) {
                addContent(new MMatrix(stack));
            } else if (MMatrixrow.isMatch(stack)) {
                addContent(new MMatrixrow(stack));
            } else if (MSet.isMatch(stack)) {
                addContent(new MSet(stack));
            } else if (MVector.isMatch(stack)) {
                addContent(new MVector(stack));
            } else if (MSemantics.isMatch(stack)) {
                addContent(new MSemantics(stack));
            } else {
                break;
            }
        }
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
        Element element = doc.createElement("mroot");
        int size;
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
        size = content.size();
        for (int i = 0;i < size;i++) {
            IMMrootContent value = (IMMrootContent)this.content.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
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
     * Gets the IMMrootContent property <b>content</b>.
     *
     * @return IMMrootContent[]
     */
    public final IMMrootContent[] getContent() {
        IMMrootContent[] array = new IMMrootContent[content.size()];
        return ((IMMrootContent[])content.toArray(array));
    }

    /**
     * Sets the IMMrootContent property <b>content</b>.
     *
     * @param content
     */
    public final void setContent(IMMrootContent[] content) {
        this.content.clear();
        this.content.addAll(java.util.Arrays.asList(content));
        for (int i = 0;i < content.length;i++) {
            content[i].setParentRNode(this);
        }
    }

    /**
     * Sets the IMMrootContent property <b>content</b>.
     *
     * @param content
     */
    public final void setContent(IMMrootContent content) {
        this.content.clear();
        this.content.add(content);
        content.setParentRNode(this);
    }

    /**
     * Adds the IMMrootContent property <b>content</b>.
     *
     * @param content
     */
    public final void addContent(IMMrootContent content) {
        this.content.add(content);
        content.setParentRNode(this);
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
        classNodes.addAll(content);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>MMroot</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.w3.org/1998/Math/MathML", "mroot")) {
            return (false);
        }
        RStack target = new RStack(element);
        Element child;
        while (!target.isEmptyElement()) {
            if (MMi.isMatchHungry(target)) {
            } else if (MMn.isMatchHungry(target)) {
            } else if (MMo.isMatchHungry(target)) {
            } else if (MMtext.isMatchHungry(target)) {
            } else if (MMs.isMatchHungry(target)) {
            } else if (MMspace.isMatchHungry(target)) {
            } else if (MMprescripts.isMatchHungry(target)) {
            } else if (MNone.isMatchHungry(target)) {
            } else if (MMrow.isMatchHungry(target)) {
            } else if (MMfrac.isMatchHungry(target)) {
            } else if (MMsqrt.isMatchHungry(target)) {
            } else if (MMroot.isMatchHungry(target)) {
            } else if (MMstyle.isMatchHungry(target)) {
            } else if (MMerror.isMatchHungry(target)) {
            } else if (MMpadded.isMatchHungry(target)) {
            } else if (MMphantom.isMatchHungry(target)) {
            } else if (MMfenced.isMatchHungry(target)) {
            } else if (MMsub.isMatchHungry(target)) {
            } else if (MMsup.isMatchHungry(target)) {
            } else if (MMsubsup.isMatchHungry(target)) {
            } else if (MMunder.isMatchHungry(target)) {
            } else if (MMover.isMatchHungry(target)) {
            } else if (MMunderover.isMatchHungry(target)) {
            } else if (MMmultiscripts.isMatchHungry(target)) {
            } else if (MMtable.isMatchHungry(target)) {
            } else if (MMtr.isMatchHungry(target)) {
            } else if (MMtd.isMatchHungry(target)) {
            } else if (MMaligngroup.isMatchHungry(target)) {
            } else if (MMalignmark.isMatchHungry(target)) {
            } else if (MMaction.isMatchHungry(target)) {
            } else if (MCi.isMatchHungry(target)) {
            } else if (MCn.isMatchHungry(target)) {
            } else if (MApply.isMatchHungry(target)) {
            } else if (MFn.isMatchHungry(target)) {
            } else if (MLambda.isMatchHungry(target)) {
            } else if (MReln.isMatchHungry(target)) {
            } else if (MInterval.isMatchHungry(target)) {
            } else if (MList.isMatchHungry(target)) {
            } else if (MMatrix.isMatchHungry(target)) {
            } else if (MMatrixrow.isMatchHungry(target)) {
            } else if (MSet.isMatchHungry(target)) {
            } else if (MVector.isMatchHungry(target)) {
            } else if (MSemantics.isMatchHungry(target)) {
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
     * is valid for the <code>MMroot</code>.
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
     * is valid for the <code>MMroot</code>.
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
