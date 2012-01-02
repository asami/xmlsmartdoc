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
 * <b>TSTestcase</b> is generated from testScript.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="testcase">
 *   <optional>
 *     <element name="description">
 *       <empty/>
 *     </element>
 *   </optional>
 *   <optional>
 *     <element name="setup">
 *       <empty/>
 *     </element>
 *   </optional>
 *   <zeroOrMore>
 *     <ref name="test"/>
 *   </zeroOrMore>
 *   <optional>
 *     <element name="teardown">
 *       <empty/>
 *     </element>
 *   </optional>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;element name="testcase"&gt;
 *   &lt;optional&gt;
 *     &lt;element name="description"&gt;
 *       &lt;empty/&gt;
 *     &lt;/element&gt;
 *   &lt;/optional&gt;
 *   &lt;optional&gt;
 *     &lt;element name="setup"&gt;
 *       &lt;empty/&gt;
 *     &lt;/element&gt;
 *   &lt;/optional&gt;
 *   &lt;zeroOrMore&gt;
 *     &lt;ref name="test"/&gt;
 *   &lt;/zeroOrMore&gt;
 *   &lt;optional&gt;
 *     &lt;element name="teardown"&gt;
 *       &lt;empty/&gt;
 *     &lt;/element&gt;
 *   &lt;/optional&gt;
 * &lt;/element&gt;
 * </pre>
 *
 * @version testScript.rng (Mon Sep 29 12:19:24 JST 2003)
 * @author  Relaxer 1.0b (http://www.relaxer.org)
 */
public class TSTestcase implements java.io.Serializable, Cloneable, IREvaluatable, IRNode {
    private String description_;
    private String setup_;
    // List<TSTest>
    private java.util.List test_ = new java.util.ArrayList();
    private String teardown_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>TSTestcase</code>.
     *
     */
    public TSTestcase() {
    }

    /**
     * Creates a <code>TSTestcase</code>.
     *
     * @param source
     */
    public TSTestcase(TSTestcase source) {
        setup(source);
    }

    /**
     * Creates a <code>TSTestcase</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public TSTestcase(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>TSTestcase</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public TSTestcase(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>TSTestcase</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public TSTestcase(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>TSTestcase</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSTestcase(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>TSTestcase</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSTestcase(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>TSTestcase</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSTestcase(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>TSTestcase</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSTestcase(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>TSTestcase</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSTestcase(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>TSTestcase</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSTestcase(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>TSTestcase</code> by the TSTestcase <code>source</code>.
     *
     * @param source
     */
    public void setup(TSTestcase source) {
        int size;
        setDescription(source.getDescription());
        setSetup(source.getSetup());
        this.test_.clear();
        size = source.test_.size();
        for (int i = 0;i < size;i++) {
            addTest((TSTest)source.getTest(i).clone());
        }
        setTeardown(source.getTeardown());
    }

    /**
     * Initializes the <code>TSTestcase</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>TSTestcase</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>TSTestcase</code> by the Stack <code>stack</code>
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
        description_ = URelaxer.getElementPropertyAsStringByStack(stack, "description");
        setup_ = URelaxer.getElementPropertyAsStringByStack(stack, "setup");
        test_.clear();
        while (true) {
            if (TSTest.isMatch(stack)) {
                addTest(factory.createTSTest(stack));
            } else {
                break;
            }
        }
        teardown_ = URelaxer.getElementPropertyAsStringByStack(stack, "teardown");
    }

    /**
     * @return Object
     */
    public Object clone() {
        ITestScriptFactory factory = TestScriptFactory.getFactory();
        return (factory.createTSTestcase(this));
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
        Element element = doc.createElement("testcase");
        int size;
        if (this.description_ != null) {
            URelaxer.setElementPropertyByString(element, "description", this.description_);
        }
        if (this.setup_ != null) {
            URelaxer.setElementPropertyByString(element, "setup", this.setup_);
        }
        size = this.test_.size();
        for (int i = 0;i < size;i++) {
            TSTest value = (TSTest)this.test_.get(i);
            value.makeElement(element);
        }
        if (this.teardown_ != null) {
            URelaxer.setElementPropertyByString(element, "teardown", this.teardown_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>TSTestcase</code> by the File <code>file</code>.
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
     * Initializes the <code>TSTestcase</code>
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
     * Initializes the <code>TSTestcase</code> by the URL <code>url</code>.
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
     * Initializes the <code>TSTestcase</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>TSTestcase</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>TSTestcase</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>description</b>.
     *
     * @return String
     */
    public final String getDescription() {
        return (description_);
    }

    /**
     * Sets the String property <b>description</b>.
     *
     * @param description
     */
    public final void setDescription(String description) {
        this.description_ = description;
    }

    /**
     * Gets the String property <b>setup</b>.
     *
     * @return String
     */
    public final String getSetup() {
        return (setup_);
    }

    /**
     * Sets the String property <b>setup</b>.
     *
     * @param setup
     */
    public final void setSetup(String setup) {
        this.setup_ = setup;
    }

    /**
     * Gets the TSTest property <b>test</b>.
     *
     * @return TSTest[]
     */
    public final TSTest[] getTest() {
        TSTest[] array = new TSTest[test_.size()];
        return ((TSTest[])test_.toArray(array));
    }

    /**
     * Sets the TSTest property <b>test</b>.
     *
     * @param test
     */
    public final void setTest(TSTest[] test) {
        this.test_.clear();
        for (int i = 0;i < test.length;i++) {
            addTest(test[i]);
        }
        for (int i = 0;i < test.length;i++) {
            test[i].rSetParentRNode(this);
        }
    }

    /**
     * Sets the TSTest property <b>test</b>.
     *
     * @param test
     */
    public final void setTest(TSTest test) {
        this.test_.clear();
        addTest(test);
        if (test != null) {
            test.rSetParentRNode(this);
        }
    }

    /**
     * Adds the TSTest property <b>test</b>.
     *
     * @param test
     */
    public final void addTest(TSTest test) {
        this.test_.add(test);
        if (test != null) {
            test.rSetParentRNode(this);
        }
    }

    /**
     * Adds the TSTest property <b>test</b>.
     *
     * @param test
     */
    public final void addTest(TSTest[] test) {
        for (int i = 0;i < test.length;i++) {
            addTest(test[i]);
        }
        for (int i = 0;i < test.length;i++) {
            test[i].rSetParentRNode(this);
        }
    }

    /**
     * Gets number of the TSTest property <b>test</b>.
     *
     * @return int
     */
    public final int sizeTest() {
        return (test_.size());
    }

    /**
     * Gets the TSTest property <b>test</b> by index.
     *
     * @param index
     * @return TSTest
     */
    public final TSTest getTest(int index) {
        return ((TSTest)test_.get(index));
    }

    /**
     * Sets the TSTest property <b>test</b> by index.
     *
     * @param index
     * @param test
     */
    public final void setTest(int index, TSTest test) {
        this.test_.set(index, test);
        if (test != null) {
            test.rSetParentRNode(this);
        }
    }

    /**
     * Adds the TSTest property <b>test</b> by index.
     *
     * @param index
     * @param test
     */
    public final void addTest(int index, TSTest test) {
        this.test_.add(index, test);
        if (test != null) {
            test.rSetParentRNode(this);
        }
    }

    /**
     * Remove the TSTest property <b>test</b> by index.
     *
     * @param index
     */
    public final void removeTest(int index) {
        this.test_.remove(index);
    }

    /**
     * Remove the TSTest property <b>test</b> by object.
     *
     * @param test
     */
    public final void removeTest(TSTest test) {
        this.test_.remove(test);
    }

    /**
     * Clear the TSTest property <b>test</b>.
     *
     */
    public final void clearTest() {
        this.test_.clear();
    }

    /**
     * Gets the String property <b>teardown</b>.
     *
     * @return String
     */
    public final String getTeardown() {
        return (teardown_);
    }

    /**
     * Sets the String property <b>teardown</b>.
     *
     * @param teardown
     */
    public final void setTeardown(String teardown) {
        this.teardown_ = teardown;
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
        buffer.append("<testcase");
        buffer.append(">");
        if (description_ != null) {
            buffer.append("<description>");
            buffer.append(URelaxer.escapeCharData(URelaxer.getString(getDescription())));
            buffer.append("</description>");
        }
        if (setup_ != null) {
            buffer.append("<setup>");
            buffer.append(URelaxer.escapeCharData(URelaxer.getString(getSetup())));
            buffer.append("</setup>");
        }
        size = this.test_.size();
        for (int i = 0;i < size;i++) {
            TSTest value = (TSTest)this.test_.get(i);
            value.makeTextElement(buffer);
        }
        if (teardown_ != null) {
            buffer.append("<teardown>");
            buffer.append(URelaxer.escapeCharData(URelaxer.getString(getTeardown())));
            buffer.append("</teardown>");
        }
        buffer.append("</testcase>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<testcase");
        buffer.write(">");
        if (description_ != null) {
            buffer.write("<description>");
            buffer.write(URelaxer.escapeCharData(URelaxer.getString(getDescription())));
            buffer.write("</description>");
        }
        if (setup_ != null) {
            buffer.write("<setup>");
            buffer.write(URelaxer.escapeCharData(URelaxer.getString(getSetup())));
            buffer.write("</setup>");
        }
        size = this.test_.size();
        for (int i = 0;i < size;i++) {
            TSTest value = (TSTest)this.test_.get(i);
            value.makeTextElement(buffer);
        }
        if (teardown_ != null) {
            buffer.write("<teardown>");
            buffer.write(URelaxer.escapeCharData(URelaxer.getString(getTeardown())));
            buffer.write("</teardown>");
        }
        buffer.write("</testcase>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<testcase");
        buffer.print(">");
        if (description_ != null) {
            buffer.print("<description>");
            buffer.print(URelaxer.escapeCharData(URelaxer.getString(getDescription())));
            buffer.print("</description>");
        }
        if (setup_ != null) {
            buffer.print("<setup>");
            buffer.print(URelaxer.escapeCharData(URelaxer.getString(getSetup())));
            buffer.print("</setup>");
        }
        size = this.test_.size();
        for (int i = 0;i < size;i++) {
            TSTest value = (TSTest)this.test_.get(i);
            value.makeTextElement(buffer);
        }
        if (teardown_ != null) {
            buffer.print("<teardown>");
            buffer.print(URelaxer.escapeCharData(URelaxer.getString(getTeardown())));
            buffer.print("</teardown>");
        }
        buffer.print("</testcase>");
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
    public String getDescriptionAsString() {
        return (URelaxer.getString(getDescription()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getSetupAsString() {
        return (URelaxer.getString(getSetup()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getTeardownAsString() {
        return (URelaxer.getString(getTeardown()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setDescriptionByString(String string) {
        setDescription(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setSetupByString(String string) {
        setSetup(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setTeardownByString(String string) {
        setTeardown(string);
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
        classNodes.addAll(test_);
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>TSTestcase</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "testcase")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer.isTargetElement(child, "description")) {
                target.popElement();
            }
        }
        $match$ = true;
        child = target.peekElement();
        if (child != null) {
            if (URelaxer.isTargetElement(child, "setup")) {
                target.popElement();
            }
        }
        $match$ = true;
        while (true) {
            if (!TSTest.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        child = target.peekElement();
        if (child != null) {
            if (URelaxer.isTargetElement(child, "teardown")) {
                target.popElement();
            }
        }
        $match$ = true;
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>TSTestcase</code>.
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
     * is valid for the <code>TSTestcase</code>.
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
