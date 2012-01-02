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
 * <b>TSTest</b> is generated from testScript.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="test">
 *   <optional>
 *     <attribute name="id">
 *       <data type="int"/>
 *     </attribute>
 *   </optional>
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
 *   <ref name="body"/>
 *   <optional>
 *     <element name="teardown">
 *       <empty/>
 *     </element>
 *   </optional>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;element name="test"&gt;
 *   &lt;optional&gt;
 *     &lt;attribute name="id"&gt;
 *       &lt;data type="int"/&gt;
 *     &lt;/attribute&gt;
 *   &lt;/optional&gt;
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
 *   &lt;ref name="body"/&gt;
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
public class TSTest implements java.io.Serializable, Cloneable, IREvaluatable, IRNode {
    private Integer id_;
    private String description_;
    private String setup_;
    private TSBody body_;
    private String teardown_;
    private IRNode parentRNode_;

    /**
     * Creates a <code>TSTest</code>.
     *
     */
    public TSTest() {
    }

    /**
     * Creates a <code>TSTest</code>.
     *
     * @param source
     */
    public TSTest(TSTest source) {
        setup(source);
    }

    /**
     * Creates a <code>TSTest</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public TSTest(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>TSTest</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public TSTest(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>TSTest</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public TSTest(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>TSTest</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSTest(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>TSTest</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSTest(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>TSTest</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSTest(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>TSTest</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSTest(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>TSTest</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSTest(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>TSTest</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public TSTest(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>TSTest</code> by the TSTest <code>source</code>.
     *
     * @param source
     */
    public void setup(TSTest source) {
        int size;
        setId(source.getId());
        setDescription(source.getDescription());
        setSetup(source.getSetup());
        setBody((TSBody)source.getBody().clone());
        setTeardown(source.getTeardown());
    }

    /**
     * Initializes the <code>TSTest</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>TSTest</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>TSTest</code> by the Stack <code>stack</code>
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
        id_ = URelaxer.getAttributePropertyAsIntObject(element, "id");
        description_ = URelaxer.getElementPropertyAsStringByStack(stack, "description");
        setup_ = URelaxer.getElementPropertyAsStringByStack(stack, "setup");
        setBody(factory.createTSBody(stack));
        teardown_ = URelaxer.getElementPropertyAsStringByStack(stack, "teardown");
    }

    /**
     * @return Object
     */
    public Object clone() {
        ITestScriptFactory factory = TestScriptFactory.getFactory();
        return (factory.createTSTest(this));
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
        Element element = doc.createElement("test");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByInt(element, "id", this.id_);
        }
        if (this.description_ != null) {
            URelaxer.setElementPropertyByString(element, "description", this.description_);
        }
        if (this.setup_ != null) {
            URelaxer.setElementPropertyByString(element, "setup", this.setup_);
        }
        this.body_.makeElement(element);
        if (this.teardown_ != null) {
            URelaxer.setElementPropertyByString(element, "teardown", this.teardown_);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>TSTest</code> by the File <code>file</code>.
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
     * Initializes the <code>TSTest</code>
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
     * Initializes the <code>TSTest</code> by the URL <code>url</code>.
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
     * Initializes the <code>TSTest</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>TSTest</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>TSTest</code> by the Reader <code>reader</code>.
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
     * Gets the int property <b>id</b>.
     *
     * @return int
     */
    public int getId() {
        if (id_ == null) {
            return(-1);
        }
        return (id_.intValue());
    }

    /**
     * Gets the int property <b>id</b>.
     *
     * @param id
     * @return int
     */
    public int getId(int id) {
        if (id_ == null) {
            return(id);
        }
        return (this.id_.intValue());
    }

    /**
     * Gets the int property <b>id</b>.
     *
     * @return Integer
     */
    public Integer getIdAsInteger() {
        return (id_);
    }

    /**
     * Check the int property <b>id</b>.
     *
     * @return boolean
     */
    public boolean checkId() {
        return (id_ != null);
    }

    /**
     * Sets the int property <b>id</b>.
     *
     * @param id
     */
    public void setId(int id) {
        this.id_ = new Integer(id);
    }

    /**
     * Sets the int property <b>id</b>.
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id_ = id;
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
     * Gets the TSBody property <b>body</b>.
     *
     * @return TSBody
     */
    public final TSBody getBody() {
        return (body_);
    }

    /**
     * Sets the TSBody property <b>body</b>.
     *
     * @param body
     */
    public final void setBody(TSBody body) {
        this.body_ = body;
        if (body != null) {
            body.rSetParentRNode(this);
        }
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
        buffer.append("<test");
        if (id_ != null) {
            buffer.append(" id=\"");
            buffer.append(URelaxer.getString(getId()));
            buffer.append("\"");
        }
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
        body_.makeTextElement(buffer);
        if (teardown_ != null) {
            buffer.append("<teardown>");
            buffer.append(URelaxer.escapeCharData(URelaxer.getString(getTeardown())));
            buffer.append("</teardown>");
        }
        buffer.append("</test>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<test");
        if (id_ != null) {
            buffer.write(" id=\"");
            buffer.write(URelaxer.getString(getId()));
            buffer.write("\"");
        }
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
        body_.makeTextElement(buffer);
        if (teardown_ != null) {
            buffer.write("<teardown>");
            buffer.write(URelaxer.escapeCharData(URelaxer.getString(getTeardown())));
            buffer.write("</teardown>");
        }
        buffer.write("</test>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<test");
        if (id_ != null) {
            buffer.print(" id=\"");
            buffer.print(URelaxer.getString(getId()));
            buffer.print("\"");
        }
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
        body_.makeTextElement(buffer);
        if (teardown_ != null) {
            buffer.print("<teardown>");
            buffer.print(URelaxer.escapeCharData(URelaxer.getString(getTeardown())));
            buffer.print("</teardown>");
        }
        buffer.print("</test>");
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
    public String getIdAsString() {
        return (URelaxer.getString(getId()));
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
    public void setIdByString(String string) {
        setId(Integer.parseInt(string));
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
        if (body_ != null) {
            classNodes.add(body_);
        }
        IRNode[] nodes = new IRNode[classNodes.size()];
        return ((IRNode[])classNodes.toArray(nodes));
    }

    /**
     * Tests if a Element <code>element</code> is valid
     * for the <code>TSTest</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "test")) {
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
        if (!TSBody.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
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
     * is valid for the <code>TSTest</code>.
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
     * is valid for the <code>TSTest</code>.
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
