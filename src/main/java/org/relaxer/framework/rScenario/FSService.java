package org.relaxer.framework.rScenario;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>FSService</b> is generated from scenario.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="service">
 *   <attribute name="name">
 *     <data type="token"/>
 *   </attribute>
 *   <zeroOrMore>
 *     <ref name="in"/>
 *   </zeroOrMore>
 *   <ref name="out"/>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;element name="service"&gt;
 *   &lt;attribute name="name"&gt;
 *     &lt;data type="token"/&gt;
 *   &lt;/attribute&gt;
 *   &lt;zeroOrMore&gt;
 *     &lt;ref name="in"/&gt;
 *   &lt;/zeroOrMore&gt;
 *   &lt;ref name="out"/&gt;
 * &lt;/element&gt;
 * </pre>
 *
 * @version scenario.rng (Mon Aug 04 17:07:37 JST 2003)
 * @author  Relaxer 1.0rc3b (http://www.relaxer.org)
 */
public class FSService implements java.io.Serializable, Cloneable, IFSEventChoice {
    private String name_;
    // List<FSIn>
    private java.util.List in_ = new java.util.ArrayList();
    private FSOut out_;

    /**
     * Creates a <code>FSService</code>.
     *
     */
    public FSService() {
        name_ = "";
    }

    /**
     * Creates a <code>FSService</code>.
     *
     * @param source
     */
    public FSService(FSService source) {
        setup(source);
    }

    /**
     * Creates a <code>FSService</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FSService(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FSService</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FSService(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FSService</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FSService(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FSService</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FSService(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FSService</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FSService(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FSService</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FSService(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FSService</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FSService(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FSService</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FSService(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FSService</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FSService(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FSService</code> by the FSService <code>source</code>.
     *
     * @param source
     */
    public void setup(FSService source) {
        int size;
        setName(source.getName());
        this.in_.clear();
        size = source.in_.size();
        for (int i = 0;i < size;i++) {
            addIn((FSIn)source.getIn(i).clone());
        }
        setOut((FSOut)source.getOut().clone());
    }

    /**
     * Initializes the <code>FSService</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FSService</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FSService</code> by the Stack <code>stack</code>
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
        RStack stack = new RStack(element);
        name_ = URelaxer.getAttributePropertyAsString(element, "name");
        in_.clear();
        while (true) {
            if (FSIn.isMatch(stack)) {
                addIn(new FSIn(stack));
            } else {
                break;
            }
        }
        setOut(new FSOut(stack));
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FSService(this));
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
        Element element = doc.createElement("service");
        int size;
        if (this.name_ != null) {
            URelaxer.setAttributePropertyByString(element, "name", this.name_);
        }
        size = this.in_.size();
        for (int i = 0;i < size;i++) {
            FSIn value = (FSIn)this.in_.get(i);
            value.makeElement(element);
        }
        this.out_.makeElement(element);
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FSService</code> by the File <code>file</code>.
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
     * Initializes the <code>FSService</code>
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
     * Initializes the <code>FSService</code> by the URL <code>url</code>.
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
     * Initializes the <code>FSService</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FSService</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FSService</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>name</b>.
     *
     * @return String
     */
    public final String getName() {
        return (name_);
    }

    /**
     * Sets the String property <b>name</b>.
     *
     * @param name
     */
    public final void setName(String name) {
        this.name_ = name;
    }

    /**
     * Gets the FSIn property <b>in</b>.
     *
     * @return FSIn[]
     */
    public final FSIn[] getIn() {
        FSIn[] array = new FSIn[in_.size()];
        return ((FSIn[])in_.toArray(array));
    }

    /**
     * Sets the FSIn property <b>in</b>.
     *
     * @param in
     */
    public final void setIn(FSIn[] in) {
        this.in_.clear();
        for (int i = 0;i < in.length;i++) {
            addIn(in[i]);
        }
    }

    /**
     * Sets the FSIn property <b>in</b>.
     *
     * @param in
     */
    public final void setIn(FSIn in) {
        this.in_.clear();
        addIn(in);
    }

    /**
     * Adds the FSIn property <b>in</b>.
     *
     * @param in
     */
    public final void addIn(FSIn in) {
        this.in_.add(in);
    }

    /**
     * Adds the FSIn property <b>in</b>.
     *
     * @param in
     */
    public final void addIn(FSIn[] in) {
        for (int i = 0;i < in.length;i++) {
            addIn(in[i]);
        }
    }

    /**
     * Gets number of the FSIn property <b>in</b>.
     *
     * @return int
     */
    public final int sizeIn() {
        return (in_.size());
    }

    /**
     * Gets the FSIn property <b>in</b> by index.
     *
     * @param index
     * @return FSIn
     */
    public final FSIn getIn(int index) {
        return ((FSIn)in_.get(index));
    }

    /**
     * Sets the FSIn property <b>in</b> by index.
     *
     * @param index
     * @param in
     */
    public final void setIn(int index, FSIn in) {
        this.in_.set(index, in);
    }

    /**
     * Adds the FSIn property <b>in</b> by index.
     *
     * @param index
     * @param in
     */
    public final void addIn(int index, FSIn in) {
        this.in_.add(index, in);
    }

    /**
     * Remove the FSIn property <b>in</b> by index.
     *
     * @param index
     */
    public final void removeIn(int index) {
        this.in_.remove(index);
    }

    /**
     * Remove the FSIn property <b>in</b> by object.
     *
     * @param in
     */
    public final void removeIn(FSIn in) {
        this.in_.remove(in);
    }

    /**
     * Clear the FSIn property <b>in</b>.
     *
     */
    public final void clearIn() {
        this.in_.clear();
    }

    /**
     * Gets the FSOut property <b>out</b>.
     *
     * @return FSOut
     */
    public final FSOut getOut() {
        return (out_);
    }

    /**
     * Sets the FSOut property <b>out</b>.
     *
     * @param out
     */
    public final void setOut(FSOut out) {
        this.out_ = out;
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
        buffer.append("<service");
        if (name_ != null) {
            buffer.append(" name=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.in_.size();
        for (int i = 0;i < size;i++) {
            FSIn value = (FSIn)this.in_.get(i);
            value.makeTextElement(buffer);
        }
        out_.makeTextElement(buffer);
        buffer.append("</service>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<service");
        if (name_ != null) {
            buffer.write(" name=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.in_.size();
        for (int i = 0;i < size;i++) {
            FSIn value = (FSIn)this.in_.get(i);
            value.makeTextElement(buffer);
        }
        out_.makeTextElement(buffer);
        buffer.write("</service>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<service");
        if (name_ != null) {
            buffer.print(" name=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getName())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.in_.size();
        for (int i = 0;i < size;i++) {
            FSIn value = (FSIn)this.in_.get(i);
            value.makeTextElement(buffer);
        }
        out_.makeTextElement(buffer);
        buffer.print("</service>");
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
    public String getNameAsString() {
        return (URelaxer.getString(getName()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setNameByString(String string) {
        setName(string);
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
     * Tests if a Element <code>element</code> is valid
     * for the <code>FSService</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "service")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "name")) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!FSIn.isMatchHungry(target)) {
                break;
            }
            $match$ = true;
        }
        if (!FSOut.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FSService</code>.
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
     * is valid for the <code>FSService</code>.
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
