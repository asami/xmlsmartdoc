/*
 * The Relaxer artifact
 * Copyright (c) 2000-2004, ASAMI Tomoharu, All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer. 
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.relaxer.vocabulary.forrest_0_5.todo_v12;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>FtTodo</b> is generated from todo_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="todo">
 *             <ref name="todo.attlist"/>
 *             <optional>
 *                 <ref name="title"/>
 *             </optional>
 *             <optional>
 *                 <ref name="devs"/>
 *             </optional>
 *             <oneOrMore>
 *                 <ref name="actions"/>
 *             </oneOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="todo"&gt;
 *             &lt;ref name="todo.attlist"/&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="title"/&gt;
 *             &lt;/optional&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="devs"/&gt;
 *             &lt;/optional&gt;
 *             &lt;oneOrMore&gt;
 *                 &lt;ref name="actions"/&gt;
 *             &lt;/oneOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version todo_v12.rng (Wed Mar 03 11:15:51 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FtTodo implements java.io.Serializable, Cloneable {
    private String id_;
    private String xmlLang_;
    private FtTitle title_;
    private FtDevs devs_;
    // List<FtActions>
    private java.util.List actions_ = new java.util.ArrayList();

    /**
     * Creates a <code>FtTodo</code>.
     *
     */
    public FtTodo() {
    }

    /**
     * Creates a <code>FtTodo</code>.
     *
     * @param source
     */
    public FtTodo(FtTodo source) {
        setup(source);
    }

    /**
     * Creates a <code>FtTodo</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FtTodo(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FtTodo</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FtTodo(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FtTodo</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FtTodo(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FtTodo</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtTodo(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FtTodo</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtTodo(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FtTodo</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtTodo(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FtTodo</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtTodo(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FtTodo</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtTodo(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FtTodo</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtTodo(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FtTodo</code> by the FtTodo <code>source</code>.
     *
     * @param source
     */
    public void setup(FtTodo source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        if (source.title_ != null) {
            setTitle((FtTitle)source.getTitle().clone());
        }
        if (source.devs_ != null) {
            setDevs((FtDevs)source.getDevs().clone());
        }
        this.actions_.clear();
        size = source.actions_.size();
        for (int i = 0;i < size;i++) {
            addActions((FtActions)source.getActions(i).clone());
        }
    }

    /**
     * Initializes the <code>FtTodo</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FtTodo</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FtTodo</code> by the Stack <code>stack</code>
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
        id_ = URelaxer.getAttributePropertyAsString(element, "id");
        xmlLang_ = URelaxer.getAttributePropertyAsString(element, "xml:lang");
        if (FtTitle.isMatch(stack)) {
            setTitle(new FtTitle(stack));
        }
        if (FtDevs.isMatch(stack)) {
            setDevs(new FtDevs(stack));
        }
        actions_.clear();
        while (true) {
            if (FtActions.isMatch(stack)) {
                addActions(new FtActions(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FtTodo(this));
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
        Element element = doc.createElement("todo");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        if (this.title_ != null) {
            this.title_.makeElement(element);
        }
        if (this.devs_ != null) {
            this.devs_.makeElement(element);
        }
        size = this.actions_.size();
        for (int i = 0;i < size;i++) {
            FtActions value = (FtActions)this.actions_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FtTodo</code> by the File <code>file</code>.
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
     * Initializes the <code>FtTodo</code>
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
     * Initializes the <code>FtTodo</code> by the URL <code>url</code>.
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
     * Initializes the <code>FtTodo</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FtTodo</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FtTodo</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>id</b>.
     *
     * @return String
     */
    public String getId() {
        return (id_);
    }

    /**
     * Sets the String property <b>id</b>.
     *
     * @param id
     */
    public void setId(String id) {
        this.id_ = id;
    }

    /**
     * Gets the String property <b>xmlLang</b>.
     *
     * @return String
     */
    public String getXmlLang() {
        return (xmlLang_);
    }

    /**
     * Sets the String property <b>xmlLang</b>.
     *
     * @param xmlLang
     */
    public void setXmlLang(String xmlLang) {
        this.xmlLang_ = xmlLang;
    }

    /**
     * Gets the FtTitle property <b>title</b>.
     *
     * @return FtTitle
     */
    public FtTitle getTitle() {
        return (title_);
    }

    /**
     * Sets the FtTitle property <b>title</b>.
     *
     * @param title
     */
    public void setTitle(FtTitle title) {
        this.title_ = title;
    }

    /**
     * Gets the FtDevs property <b>devs</b>.
     *
     * @return FtDevs
     */
    public FtDevs getDevs() {
        return (devs_);
    }

    /**
     * Sets the FtDevs property <b>devs</b>.
     *
     * @param devs
     */
    public void setDevs(FtDevs devs) {
        this.devs_ = devs;
    }

    /**
     * Gets the FtActions property <b>actions</b>.
     *
     * @return FtActions[]
     */
    public FtActions[] getActions() {
        FtActions[] array = new FtActions[actions_.size()];
        return ((FtActions[])actions_.toArray(array));
    }

    /**
     * Sets the FtActions property <b>actions</b>.
     *
     * @param actions
     */
    public void setActions(FtActions[] actions) {
        this.actions_.clear();
        for (int i = 0;i < actions.length;i++) {
            addActions(actions[i]);
        }
    }

    /**
     * Sets the FtActions property <b>actions</b>.
     *
     * @param actions
     */
    public void setActions(FtActions actions) {
        this.actions_.clear();
        addActions(actions);
    }

    /**
     * Adds the FtActions property <b>actions</b>.
     *
     * @param actions
     */
    public void addActions(FtActions actions) {
        this.actions_.add(actions);
    }

    /**
     * Adds the FtActions property <b>actions</b>.
     *
     * @param actions
     */
    public void addActions(FtActions[] actions) {
        for (int i = 0;i < actions.length;i++) {
            addActions(actions[i]);
        }
    }

    /**
     * Gets number of the FtActions property <b>actions</b>.
     *
     * @return int
     */
    public int sizeActions() {
        return (actions_.size());
    }

    /**
     * Gets the FtActions property <b>actions</b> by index.
     *
     * @param index
     * @return FtActions
     */
    public FtActions getActions(int index) {
        return ((FtActions)actions_.get(index));
    }

    /**
     * Sets the FtActions property <b>actions</b> by index.
     *
     * @param index
     * @param actions
     */
    public void setActions(int index, FtActions actions) {
        this.actions_.set(index, actions);
    }

    /**
     * Adds the FtActions property <b>actions</b> by index.
     *
     * @param index
     * @param actions
     */
    public void addActions(int index, FtActions actions) {
        this.actions_.add(index, actions);
    }

    /**
     * Remove the FtActions property <b>actions</b> by index.
     *
     * @param index
     */
    public void removeActions(int index) {
        this.actions_.remove(index);
    }

    /**
     * Remove the FtActions property <b>actions</b> by object.
     *
     * @param actions
     */
    public void removeActions(FtActions actions) {
        this.actions_.remove(actions);
    }

    /**
     * Clear the FtActions property <b>actions</b>.
     *
     */
    public void clearActions() {
        this.actions_.clear();
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
        buffer.append("<todo");
        if (id_ != null) {
            buffer.append(" id=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getId())));
            buffer.append("\"");
        }
        if (xmlLang_ != null) {
            buffer.append(" xml:lang=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getXmlLang())));
            buffer.append("\"");
        }
        buffer.append(">");
        if (title_ != null) {
            title_.makeTextElement(buffer);
        }
        if (devs_ != null) {
            devs_.makeTextElement(buffer);
        }
        size = this.actions_.size();
        for (int i = 0;i < size;i++) {
            FtActions value = (FtActions)this.actions_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</todo>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<todo");
        if (id_ != null) {
            buffer.write(" id=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getId())));
            buffer.write("\"");
        }
        if (xmlLang_ != null) {
            buffer.write(" xml:lang=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getXmlLang())));
            buffer.write("\"");
        }
        buffer.write(">");
        if (title_ != null) {
            title_.makeTextElement(buffer);
        }
        if (devs_ != null) {
            devs_.makeTextElement(buffer);
        }
        size = this.actions_.size();
        for (int i = 0;i < size;i++) {
            FtActions value = (FtActions)this.actions_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</todo>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<todo");
        if (id_ != null) {
            buffer.print(" id=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getId())));
            buffer.print("\"");
        }
        if (xmlLang_ != null) {
            buffer.print(" xml:lang=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getXmlLang())));
            buffer.print("\"");
        }
        buffer.print(">");
        if (title_ != null) {
            title_.makeTextElement(buffer);
        }
        if (devs_ != null) {
            devs_.makeTextElement(buffer);
        }
        size = this.actions_.size();
        for (int i = 0;i < size;i++) {
            FtActions value = (FtActions)this.actions_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</todo>");
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
    public String getXmlLangAsString() {
        return (URelaxer.getString(getXmlLang()));
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setIdByString(String string) {
        setId(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setXmlLangByString(String string) {
        setXmlLang(string);
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
     * for the <code>FtTodo</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "todo")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (FtTitle.isMatchHungry(target)) {
        }
        if (FtDevs.isMatchHungry(target)) {
        }
        if (!FtActions.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!FtActions.isMatchHungry(target)) {
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
     * is valid for the <code>FtTodo</code>.
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
     * is valid for the <code>FtTodo</code>.
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
