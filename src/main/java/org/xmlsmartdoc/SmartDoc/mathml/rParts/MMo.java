package org.xmlsmartdoc.SmartDoc.mathml.rParts;

import org.w3c.dom.*;

/**
 * <b>MMo</b> is generated by Relaxer based on MathML.rlx.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <elementRule role="mo">
 *   <mixed>
 *     <choice occurs="*">
 *       <ref label="malignmark"/>
 *     </choice>
 *   </mixed>
 * </elementRule>
 * 
 * <tag name="mo">
 *   <attribute name="fontsize" type="string"/>
 *   <attribute name="fontweight" type="NMTOKEN">
 *     <enumeration value="normal"/>
 *     <enumeration value="bold"/>
 *   </attribute>
 *   <attribute name="fontstyle" type="NMTOKEN">
 *     <enumeration value="normal"/>
 *     <enumeration value="italic"/>
 *   </attribute>
 *   <attribute name="fontfamily" type="string"/>
 *   <attribute name="color" type="string"/>
 *   <attribute name="form" type="NMTOKEN">
 *     <enumeration value="prefix"/>
 *     <enumeration value="infix"/>
 *     <enumeration value="postfix"/>
 *   </attribute>
 *   <attribute name="fence" type="NMTOKEN">
 *     <enumeration value="true"/>
 *     <enumeration value="false"/>
 *   </attribute>
 *   <attribute name="separator" type="NMTOKEN">
 *     <enumeration value="true"/>
 *     <enumeration value="false"/>
 *   </attribute>
 *   <attribute name="lspace" type="string"/>
 *   <attribute name="rspace" type="string"/>
 *   <attribute name="stretchy" type="NMTOKEN">
 *     <enumeration value="true"/>
 *     <enumeration value="false"/>
 *   </attribute>
 *   <attribute name="symmetric" type="NMTOKEN">
 *     <enumeration value="true"/>
 *     <enumeration value="false"/>
 *   </attribute>
 *   <attribute name="maxsize" type="string"/>
 *   <attribute name="minsize" type="string"/>
 *   <attribute name="largeop" type="NMTOKEN">
 *     <enumeration value="true"/>
 *     <enumeration value="false"/>
 *   </attribute>
 *   <attribute name="movablelimits" type="NMTOKEN">
 *     <enumeration value="true"/>
 *     <enumeration value="false"/>
 *   </attribute>
 *   <attribute name="accent" type="NMTOKEN">
 *     <enumeration value="true"/>
 *     <enumeration value="false"/>
 *   </attribute>
 *   <attribute name="class" type="string"/>
 *   <attribute name="style" type="string"/>
 *   <attribute name="id" type="ID"/>
 *   <attribute name="other" type="string"/>
 * </tag>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;elementRule role="mo"&gt;
 *   &lt;mixed&gt;
 *     &lt;choice occurs="*"&gt;
 *       &lt;ref label="malignmark"/&gt;
 *     &lt;/choice&gt;
 *   &lt;/mixed&gt;
 * &lt;/elementRule&gt;
 * &lt;tag name="mo"&gt;
 *   &lt;attribute name="fontsize" type="string"/&gt;
 *   &lt;attribute name="fontweight" type="NMTOKEN"&gt;
 *     &lt;enumeration value="normal"/&gt;
 *     &lt;enumeration value="bold"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;attribute name="fontstyle" type="NMTOKEN"&gt;
 *     &lt;enumeration value="normal"/&gt;
 *     &lt;enumeration value="italic"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;attribute name="fontfamily" type="string"/&gt;
 *   &lt;attribute name="color" type="string"/&gt;
 *   &lt;attribute name="form" type="NMTOKEN"&gt;
 *     &lt;enumeration value="prefix"/&gt;
 *     &lt;enumeration value="infix"/&gt;
 *     &lt;enumeration value="postfix"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;attribute name="fence" type="NMTOKEN"&gt;
 *     &lt;enumeration value="true"/&gt;
 *     &lt;enumeration value="false"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;attribute name="separator" type="NMTOKEN"&gt;
 *     &lt;enumeration value="true"/&gt;
 *     &lt;enumeration value="false"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;attribute name="lspace" type="string"/&gt;
 *   &lt;attribute name="rspace" type="string"/&gt;
 *   &lt;attribute name="stretchy" type="NMTOKEN"&gt;
 *     &lt;enumeration value="true"/&gt;
 *     &lt;enumeration value="false"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;attribute name="symmetric" type="NMTOKEN"&gt;
 *     &lt;enumeration value="true"/&gt;
 *     &lt;enumeration value="false"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;attribute name="maxsize" type="string"/&gt;
 *   &lt;attribute name="minsize" type="string"/&gt;
 *   &lt;attribute name="largeop" type="NMTOKEN"&gt;
 *     &lt;enumeration value="true"/&gt;
 *     &lt;enumeration value="false"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;attribute name="movablelimits" type="NMTOKEN"&gt;
 *     &lt;enumeration value="true"/&gt;
 *     &lt;enumeration value="false"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;attribute name="accent" type="NMTOKEN"&gt;
 *     &lt;enumeration value="true"/&gt;
 *     &lt;enumeration value="false"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;attribute name="class" type="string"/&gt;
 *   &lt;attribute name="style" type="string"/&gt;
 *   &lt;attribute name="id" type="ID"/&gt;
 *   &lt;attribute name="other" type="string"/&gt;
 * &lt;/tag&gt;
 * </pre>
 *
 * @version MathML.rlx 1.0 (Sat Sep 09 10:48:41 JST 2000)
 * @author  Relaxer 0.11b (by ASAMI@Yokohama)
 */
public class MMo implements java.io.Serializable, IRVisitable, IRNode, IMMathContent, IMMrowContent, IMMfracContent, IMMsqrtContent, IMMrootContent, IMMstyleContent, IMMerrorContent, IMMpaddedContent, IMMphantomContent, IMMfencedContent, IMMsubContent, IMMsupContent, IMMsubsupContent, IMMunderContent, IMMoverContent, IMMunderoverContent, IMMmultiscriptsContent, IMMtableContent, IMMtrContent, IMMtdContent, IMMactionContent, IMCiPCDATA, IMCnPCDATA, IMFnContent, IMLogbaseContent, IMDegreeContent, IMBvarContent, IMUplimitContent, IMLowlimitContent, IMVectorContent, IMSetContent, IMMatrixrowContent, IMMatrixContent, IMListContent, IMIntervalContent, IMAnnotationXmlContent, IMSemanticsContent, IMDeclareContent, IMConditionContent, IMLambdaContent, IMRelnContent, IMApplyContent {
    private String fontsize;
    private String fontweight;
    private String fontstyle;
    private String fontfamily;
    private String color;
    private String form;
    private String fence;
    private String separator;
    private String lspace;
    private String rspace;
    private String stretchy;
    private String symmetric;
    private String maxsize;
    private String minsize;
    private String largeop;
    private String movablelimits;
    private String accent;
    private String classValue;
    private String style;
    private String id;
    private String other;
    // List<IMMoPCDATA>
    private java.util.List pcdata = new java.util.ArrayList();
    private IRNode parentRNode;

    /**
     * Creates a <code>MMo</code>.
     *
     */
    public MMo() {
    }

    /**
     * Creates a <code>MMo</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public MMo(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>MMo</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public MMo(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>MMo</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public MMo(Element element) {
        setup(element);
    }

    /**
     * Sets a mixed content by <code>String</code>.
     *
     * @param text
     */
    public void setPcdata(String text) {
        setPcdata(new RString(text));
    }

    /**
     * Gets a mixed content as <code>String</code>.
     *
     * @return String
     */
    public String getPcdataAsString() {
        return (URelaxer.getStringByMixedList(pcdata));
    }

    /**
     * Initializes the <code>MMo</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>MMo</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>MMo</code> by the Stack <code>stack</code>
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
        fontsize = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "fontsize");
        fontweight = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "fontweight");
        fontstyle = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "fontstyle");
        fontfamily = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "fontfamily");
        color = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "color");
        form = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "form");
        fence = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "fence");
        separator = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "separator");
        lspace = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "lspace");
        rspace = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "rspace");
        stretchy = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "stretchy");
        symmetric = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "symmetric");
        maxsize = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "maxsize");
        minsize = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "minsize");
        largeop = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "largeop");
        movablelimits = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "movablelimits");
        accent = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "accent");
        classValue = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "class");
        style = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "style");
        id = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "id");
        other = URelaxer2.getAttributePropertyAsString(element, "http://www.w3.org/1998/Math/MathML", "other");
        pcdata.clear();
        while (!stack.isEmpty()) {
            if (RString.isMatch(stack)) {
                addPcdata(new RString(stack));
            } else if (MMalignmark.isMatch(stack)) {
                addPcdata(new MMalignmark(stack));
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
        Element element = doc.createElement("mo");
        int size;
        if (fontsize != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "fontsize", fontsize);
        }
        if (fontweight != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "fontweight", fontweight);
        }
        if (fontstyle != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "fontstyle", fontstyle);
        }
        if (fontfamily != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "fontfamily", fontfamily);
        }
        if (color != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "color", color);
        }
        if (form != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "form", form);
        }
        if (fence != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "fence", fence);
        }
        if (separator != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "separator", separator);
        }
        if (lspace != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "lspace", lspace);
        }
        if (rspace != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "rspace", rspace);
        }
        if (stretchy != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "stretchy", stretchy);
        }
        if (symmetric != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "symmetric", symmetric);
        }
        if (maxsize != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "maxsize", maxsize);
        }
        if (minsize != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "minsize", minsize);
        }
        if (largeop != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "largeop", largeop);
        }
        if (movablelimits != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "movablelimits", movablelimits);
        }
        if (accent != null) {
            URelaxer2.setAttributePropertyByString(element, "http://www.w3.org/1998/Math/MathML", "accent", accent);
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
        size = pcdata.size();
        for (int i = 0;i < size;i++) {
            IMMoPCDATA value = (IMMoPCDATA)this.pcdata.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Gets the String property <b>fontsize</b>.
     *
     * @return String
     */
    public final String getFontsize() {
        return (fontsize);
    }

    /**
     * Sets the String property <b>fontsize</b>.
     *
     * @param fontsize
     */
    public final void setFontsize(String fontsize) {
        this.fontsize = fontsize;
    }

    /**
     * Gets the String property <b>fontweight</b>.
     *
     * @return String
     */
    public final String getFontweight() {
        return (fontweight);
    }

    /**
     * Sets the String property <b>fontweight</b>.
     *
     * @param fontweight
     */
    public final void setFontweight(String fontweight) {
        this.fontweight = fontweight;
    }

    /**
     * Gets the String property <b>fontstyle</b>.
     *
     * @return String
     */
    public final String getFontstyle() {
        return (fontstyle);
    }

    /**
     * Sets the String property <b>fontstyle</b>.
     *
     * @param fontstyle
     */
    public final void setFontstyle(String fontstyle) {
        this.fontstyle = fontstyle;
    }

    /**
     * Gets the String property <b>fontfamily</b>.
     *
     * @return String
     */
    public final String getFontfamily() {
        return (fontfamily);
    }

    /**
     * Sets the String property <b>fontfamily</b>.
     *
     * @param fontfamily
     */
    public final void setFontfamily(String fontfamily) {
        this.fontfamily = fontfamily;
    }

    /**
     * Gets the String property <b>color</b>.
     *
     * @return String
     */
    public final String getColor() {
        return (color);
    }

    /**
     * Sets the String property <b>color</b>.
     *
     * @param color
     */
    public final void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the String property <b>form</b>.
     *
     * @return String
     */
    public final String getForm() {
        return (form);
    }

    /**
     * Sets the String property <b>form</b>.
     *
     * @param form
     */
    public final void setForm(String form) {
        this.form = form;
    }

    /**
     * Gets the String property <b>fence</b>.
     *
     * @return String
     */
    public final String getFence() {
        return (fence);
    }

    /**
     * Sets the String property <b>fence</b>.
     *
     * @param fence
     */
    public final void setFence(String fence) {
        this.fence = fence;
    }

    /**
     * Gets the String property <b>separator</b>.
     *
     * @return String
     */
    public final String getSeparator() {
        return (separator);
    }

    /**
     * Sets the String property <b>separator</b>.
     *
     * @param separator
     */
    public final void setSeparator(String separator) {
        this.separator = separator;
    }

    /**
     * Gets the String property <b>lspace</b>.
     *
     * @return String
     */
    public final String getLspace() {
        return (lspace);
    }

    /**
     * Sets the String property <b>lspace</b>.
     *
     * @param lspace
     */
    public final void setLspace(String lspace) {
        this.lspace = lspace;
    }

    /**
     * Gets the String property <b>rspace</b>.
     *
     * @return String
     */
    public final String getRspace() {
        return (rspace);
    }

    /**
     * Sets the String property <b>rspace</b>.
     *
     * @param rspace
     */
    public final void setRspace(String rspace) {
        this.rspace = rspace;
    }

    /**
     * Gets the String property <b>stretchy</b>.
     *
     * @return String
     */
    public final String getStretchy() {
        return (stretchy);
    }

    /**
     * Sets the String property <b>stretchy</b>.
     *
     * @param stretchy
     */
    public final void setStretchy(String stretchy) {
        this.stretchy = stretchy;
    }

    /**
     * Gets the String property <b>symmetric</b>.
     *
     * @return String
     */
    public final String getSymmetric() {
        return (symmetric);
    }

    /**
     * Sets the String property <b>symmetric</b>.
     *
     * @param symmetric
     */
    public final void setSymmetric(String symmetric) {
        this.symmetric = symmetric;
    }

    /**
     * Gets the String property <b>maxsize</b>.
     *
     * @return String
     */
    public final String getMaxsize() {
        return (maxsize);
    }

    /**
     * Sets the String property <b>maxsize</b>.
     *
     * @param maxsize
     */
    public final void setMaxsize(String maxsize) {
        this.maxsize = maxsize;
    }

    /**
     * Gets the String property <b>minsize</b>.
     *
     * @return String
     */
    public final String getMinsize() {
        return (minsize);
    }

    /**
     * Sets the String property <b>minsize</b>.
     *
     * @param minsize
     */
    public final void setMinsize(String minsize) {
        this.minsize = minsize;
    }

    /**
     * Gets the String property <b>largeop</b>.
     *
     * @return String
     */
    public final String getLargeop() {
        return (largeop);
    }

    /**
     * Sets the String property <b>largeop</b>.
     *
     * @param largeop
     */
    public final void setLargeop(String largeop) {
        this.largeop = largeop;
    }

    /**
     * Gets the String property <b>movablelimits</b>.
     *
     * @return String
     */
    public final String getMovablelimits() {
        return (movablelimits);
    }

    /**
     * Sets the String property <b>movablelimits</b>.
     *
     * @param movablelimits
     */
    public final void setMovablelimits(String movablelimits) {
        this.movablelimits = movablelimits;
    }

    /**
     * Gets the String property <b>accent</b>.
     *
     * @return String
     */
    public final String getAccent() {
        return (accent);
    }

    /**
     * Sets the String property <b>accent</b>.
     *
     * @param accent
     */
    public final void setAccent(String accent) {
        this.accent = accent;
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
     * Gets the IMMoPCDATA property <b>pcdata</b>.
     *
     * @return IMMoPCDATA[]
     */
    public final IMMoPCDATA[] getPcdata() {
        IMMoPCDATA[] array = new IMMoPCDATA[pcdata.size()];
        return ((IMMoPCDATA[])pcdata.toArray(array));
    }

    /**
     * Sets the IMMoPCDATA property <b>pcdata</b>.
     *
     * @param pcdata
     */
    public final void setPcdata(IMMoPCDATA[] pcdata) {
        this.pcdata.clear();
        this.pcdata.addAll(java.util.Arrays.asList(pcdata));
        for (int i = 0;i < pcdata.length;i++) {
            pcdata[i].setParentRNode(this);
        }
    }

    /**
     * Sets the IMMoPCDATA property <b>pcdata</b>.
     *
     * @param pcdata
     */
    public final void setPcdata(IMMoPCDATA pcdata) {
        this.pcdata.clear();
        this.pcdata.add(pcdata);
        pcdata.setParentRNode(this);
    }

    /**
     * Adds the IMMoPCDATA property <b>pcdata</b>.
     *
     * @param pcdata
     */
    public final void addPcdata(IMMoPCDATA pcdata) {
        this.pcdata.add(pcdata);
        pcdata.setParentRNode(this);
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
        classNodes.addAll(pcdata);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>MMo</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer2.isTargetElement(element, "http://www.w3.org/1998/Math/MathML", "mo")) {
            return (false);
        }
        RStack target = new RStack(element);
        Element child;
        while (!target.isEmptyElement()) {
            if (MMalignmark.isMatchHungry(target)) {
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
     * is valid for the <code>MMo</code>.
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
     * is valid for the <code>MMo</code>.
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
