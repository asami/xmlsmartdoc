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
 * <b>TSInvokeObject</b> is generated from testScript.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="invoke">
 *   <attribute name="class">
 *     <data type="token"/>
 *   </attribute>
 *   <attribute name="method">
 *     <data type="token"/>
 *   </attribute>
 *   <zeroOrMore>
 *     <ref name="in"/>
 *   </zeroOrMore>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;element name="invoke"&gt;
 *   &lt;attribute name="class"&gt;
 *     &lt;data type="token"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;attribute name="method"&gt;
 *     &lt;data type="token"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;zeroOrMore&gt;
 *     &lt;ref name="in"/&gt;
 *   &lt;/zeroOrMore&gt;
 * &lt;/element&gt;
 * </pre>
 *
 * @version testScript.rng (Mon Sep 29 12:19:24 JST 2003)
 * @author  Relaxer 1.0b (http://www.relaxer.org)
 */
public class TSInvokeObject implements java.io.Serializable, Cloneable, IREvaluatable, IRNode, ITSExpressionMixed, ITSExpressionMixedChoice {
    private String classValue_;
    private String method_;
    // List<TSIn>
    private java.util.List in_ = new java.util.ArrayList();
    private IRNode parentRNode_;

    /**
     * Creates a <code>TSInvokeObject</code>.
     *
     */
    public TSInvokeObject() {
        classValue_ = "";
        method_ = "";
    }

    /**
     * Creates a <code>TSInvokeObject</code>.
     *
     * @param source
     */
    public TSInvokeObject(TSInvokeObject source) {
        setup(source);
    }

    /**
     * Creates a <code>TSInvokeObject</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public TSInvokeObject(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>TSInvokeObject</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public TSInvokeObject(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>TSInvokeObject</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public TSInvokeObject(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>TSInvokeObject</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSInvokeObject(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>TSInvokeObject</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSInvokeObject(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>TSInvokeObject</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSInvokeObject(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>TSInvokeObject</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSInvokeObject(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>TSInvokeObject</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSInvokeObject(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>TSInvokeObject</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSInvokeObject(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>TSInvokeObject</code> by the TSInvokeObject <code>source</code>.
     *
     * @param source
     */
    public void setup(TSInvokeObject source) {
        int size;
        setClassValue(source.getClassValue());
        setMethod(source.getMethod());
        this.in_.clear();
        size = source.in_.size();
        for (int i = 0;i < size;i++) {
            addIn((TSIn)source.getIn(i).clone());
        }
    }

    /**
     * Initializes the <code>TSInvokeObject</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>TSInvokeObject</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>TSInvokeObject</code> by the Stack <code>stack</code>
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
        classValue_ = URelaxer.getAttributePropertyAsString(element, "class");
        method_ = URelaxer.getAttributePropertyAsString(element, "method");
        in_.clear();
        while (true) {
            if (TSIn.isMatch(stack)) {
                addIn(factory.createTSIn(stack));
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
        return (factory.createTSInvokeObject(this));
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
        Element element = doc.createElement("invoke");
        int size;
        if (this.classValue_ != null) {
            URelaxer.setAttributePropertyByString(element, "class", this.classValue_);
        }
        if (this.method_ != null) {
            URelaxer.setAttributePropertyByString(element, "method", this.method_);
        }
        size = this.in_.size();
        for (int i = 0;i < size;i++) {
            TSIn value = (TSIn)this.in_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>TSInvokeObject</code> by the File <code>file</code>.
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
     * Initializes the <code>TSInvokeObject</code>
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
     * Initializes the <code>TSInvokeObject</code> by the URL <code>url</code>.
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
     * Initializes the <code>TSInvokeObject</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>TSInvokeObject</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>TSInvokeObject</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>classValue</b>.
     *
     * @return String
     */
    public final String getClassValue() {
        return (classValue_);
    }

    /**
     * Sets the String property <b>classValue</b>.
     *
     * @param classValue
     */
    public final void setClassValue(String classValue) {
        this.classValue_ = classValue;
    }

    /**
     * Gets the String property <b>method</b>.
     *
     * @return String
     */
    public final String getMethod() {
        return (method_);
    }

    /**
     * Sets the String property <b>method</b>.
     *
     * @param method
     */
    public final void setMethod(String method) {
        this.method_ = method;
    }

    /**
     * Gets the TSIn property <b>in</b>.
     *
     * @return TSIn[]
     */
    public final TSIn[] getIn() {
        TSIn[] array = new TSIn[in_.size()];
        return ((TSIn[])in_.toArray(array));
    }

    /**
     * Sets the TSIn property <b>in</b>.
     *
     * @param in
     */
    public final void setIn(TSIn[] in) {
        this.in_.clear();
        for (int i = 0;i < in.length;i++) {
            addIn(in[i]);
        }
        for (int i = 0;i < in.length;i++) {
            in[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the TSIn property <b>in</b>.
     *
     * @param in
     */
    public final void setIn(TSIn in) {
        this.in_.clear();
        addIn(in);
        if (in != null) {
            in.rSetParentRNode(this);
        }
    }

    /**
     * Adds the TSIn property <b>in</b>.
     *
     * @param in
     */
    public final void addIn(TSIn in) {
        this.in_.add(in);
        if (in != null) {
            in.rSetParentRNode(this);
        }
    }

    /**
     * Adds the TSIn property <b>in</b>.
     *
     * @param in
     */
    public final void addIn(TSIn[] in) {
        for (int i = 0;i < in.length;i++) {
            addIn(in[i]);
        }
        for (int i = 0;i < in.length;i++) {
            in[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the TSIn property <b>in</b>.
     *
     * @return int
     */
    public final int sizeIn() {
        return (in_.size());
    }

    /**
     * Gets the TSIn property <b>in</b> by index.
     *
     * @param index
     * @return TSIn
     */
    public final TSIn getIn(int index) {
        return ((TSIn)in_.get(index));
    }

    /**
     * Sets the TSIn property <b>in</b> by index.
     *
     * @param index
     * @param in
     */
    public final void setIn(int index, TSIn in) {
        this.in_.set(index, in);
        if (in != null) {
            in.rSetParentRNode(this);
        }
    }

    /**
     * Adds the TSIn property <b>in</b> by index.
     *
     * @param index
     * @param in
     */
    public final void addIn(int index, TSIn in) {
        this.in_.add(index, in);
        if (in != null) {
            in.rSetParentRNode(this);
        }
    }

    /**
     * Remove the TSIn property <b>in</b> by index.
     *
     * @param index
     */
    public final void removeIn(int index) {
        this.in_.remove(index);
    }

    /**
     * Remove the TSIn property <b>in</b> by object.
     *
     * @param in
     */
    public final void removeIn(TSIn in) {
        this.in_.remove(in);
    }

    /**
     * Clear the TSIn property <b>in</b>.
     *
     */
    public final void clearIn() {
        this.in_.clear();
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
        buffer.append("<invoke");
        if (classValue_ != null) {
            buffer.append(" class=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getClassValue())));
            buffer.append("\"");
        }
        if (method_ != null) {
            buffer.append(" method=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getMethod())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.in_.size();
        for (int i = 0;i < size;i++) {
            TSIn value = (TSIn)this.in_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</invoke>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<invoke");
        if (classValue_ != null) {
            buffer.write(" class=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getClassValue())));
            buffer.write("\"");
        }
        if (method_ != null) {
            buffer.write(" method=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getMethod())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.in_.size();
        for (int i = 0;i < size;i++) {
            TSIn value = (TSIn)this.in_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</invoke>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<invoke");
        if (classValue_ != null) {
            buffer.print(" class=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getClassValue())));
            buffer.print("\"");
        }
        if (method_ != null) {
            buffer.print(" method=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getMethod())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.in_.size();
        for (int i = 0;i < size;i++) {
            TSIn value = (TSIn)this.in_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</invoke>");
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
     * Gets the property value as String.
     *
     * @return String
     */
    public String getClassValueAsString() {
        return (URelaxer.getString(getClassValue()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getMethodAsString() {
        return (URelaxer.getString(getMethod()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setClassValueByString(String string) {
        setClassValue(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setMethodByString(String string) {
        setMethod(string);
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
        classNodes.addAll(in_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>TSInvokeObject</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "invoke")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "class")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer.hasAttributeHungry(target, "method")) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!TSIn.isMatchHungry(target)) {
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
     * is valid for the <code>TSInvokeObject</code>.
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
     * is valid for the <code>TSInvokeObject</code>.
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
