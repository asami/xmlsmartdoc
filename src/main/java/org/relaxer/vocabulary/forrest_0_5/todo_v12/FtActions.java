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
 * <b>FtActions</b> is generated from todo_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="actions">
 *             <ref name="actions.attlist"/>
 *             <oneOrMore>
 *                 <ref name="action"/>
 *             </oneOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="actions"&gt;
 *             &lt;ref name="actions.attlist"/&gt;
 *             &lt;oneOrMore&gt;
 *                 &lt;ref name="action"/&gt;
 *             &lt;/oneOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version todo_v12.rng (Wed Mar 03 11:15:51 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FtActions implements java.io.Serializable, Cloneable {
    private String id_;
    private String xmlLang_;
    private String priority_;
    // List<FtAction>
    private java.util.List action_ = new java.util.ArrayList();

    /**
     * Creates a <code>FtActions</code>.
     *
     */
    public FtActions() {
    }

    /**
     * Creates a <code>FtActions</code>.
     *
     * @param source
     */
    public FtActions(FtActions source) {
        setup(source);
    }

    /**
     * Creates a <code>FtActions</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FtActions(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FtActions</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FtActions(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FtActions</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FtActions(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FtActions</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtActions(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FtActions</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtActions(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FtActions</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtActions(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FtActions</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtActions(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FtActions</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtActions(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FtActions</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FtActions(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FtActions</code> by the FtActions <code>source</code>.
     *
     * @param source
     */
    public void setup(FtActions source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        setPriority(source.getPriority());
        this.action_.clear();
        size = source.action_.size();
        for (int i = 0;i < size;i++) {
            addAction((FtAction)source.getAction(i).clone());
        }
    }

    /**
     * Initializes the <code>FtActions</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FtActions</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FtActions</code> by the Stack <code>stack</code>
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
        priority_ = URelaxer.getAttributePropertyAsString(element, "priority");
        action_.clear();
        while (true) {
            if (FtAction.isMatch(stack)) {
                addAction(new FtAction(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FtActions(this));
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
        Element element = doc.createElement("actions");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        if (this.priority_ != null) {
            URelaxer.setAttributePropertyByString(element, "priority", this.priority_);
        }
        size = this.action_.size();
        for (int i = 0;i < size;i++) {
            FtAction value = (FtAction)this.action_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FtActions</code> by the File <code>file</code>.
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
     * Initializes the <code>FtActions</code>
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
     * Initializes the <code>FtActions</code> by the URL <code>url</code>.
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
     * Initializes the <code>FtActions</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FtActions</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FtActions</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>priority</b>.
     *
     * @return String
     */
    public String getPriority() {
        return (priority_);
    }

    /**
     * Sets the String property <b>priority</b>.
     *
     * @param priority
     */
    public void setPriority(String priority) {
        this.priority_ = priority;
    }

    /**
     * Gets the FtAction property <b>action</b>.
     *
     * @return FtAction[]
     */
    public FtAction[] getAction() {
        FtAction[] array = new FtAction[action_.size()];
        return ((FtAction[])action_.toArray(array));
    }

    /**
     * Sets the FtAction property <b>action</b>.
     *
     * @param action
     */
    public void setAction(FtAction[] action) {
        this.action_.clear();
        for (int i = 0;i < action.length;i++) {
            addAction(action[i]);
        }
    }

    /**
     * Sets the FtAction property <b>action</b>.
     *
     * @param action
     */
    public void setAction(FtAction action) {
        this.action_.clear();
        addAction(action);
    }

    /**
     * Adds the FtAction property <b>action</b>.
     *
     * @param action
     */
    public void addAction(FtAction action) {
        this.action_.add(action);
    }

    /**
     * Adds the FtAction property <b>action</b>.
     *
     * @param action
     */
    public void addAction(FtAction[] action) {
        for (int i = 0;i < action.length;i++) {
            addAction(action[i]);
        }
    }

    /**
     * Gets number of the FtAction property <b>action</b>.
     *
     * @return int
     */
    public int sizeAction() {
        return (action_.size());
    }

    /**
     * Gets the FtAction property <b>action</b> by index.
     *
     * @param index
     * @return FtAction
     */
    public FtAction getAction(int index) {
        return ((FtAction)action_.get(index));
    }

    /**
     * Sets the FtAction property <b>action</b> by index.
     *
     * @param index
     * @param action
     */
    public void setAction(int index, FtAction action) {
        this.action_.set(index, action);
    }

    /**
     * Adds the FtAction property <b>action</b> by index.
     *
     * @param index
     * @param action
     */
    public void addAction(int index, FtAction action) {
        this.action_.add(index, action);
    }

    /**
     * Remove the FtAction property <b>action</b> by index.
     *
     * @param index
     */
    public void removeAction(int index) {
        this.action_.remove(index);
    }

    /**
     * Remove the FtAction property <b>action</b> by object.
     *
     * @param action
     */
    public void removeAction(FtAction action) {
        this.action_.remove(action);
    }

    /**
     * Clear the FtAction property <b>action</b>.
     *
     */
    public void clearAction() {
        this.action_.clear();
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
        buffer.append("<actions");
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
        if (priority_ != null) {
            buffer.append(" priority=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getPriority())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.action_.size();
        for (int i = 0;i < size;i++) {
            FtAction value = (FtAction)this.action_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</actions>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<actions");
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
        if (priority_ != null) {
            buffer.write(" priority=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getPriority())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.action_.size();
        for (int i = 0;i < size;i++) {
            FtAction value = (FtAction)this.action_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</actions>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<actions");
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
        if (priority_ != null) {
            buffer.print(" priority=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getPriority())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.action_.size();
        for (int i = 0;i < size;i++) {
            FtAction value = (FtAction)this.action_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</actions>");
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
     * Gets the property value as String.
     *
     * @return String
     */
    public String getPriorityAsString() {
        return (URelaxer.getString(getPriority()));
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
     * Sets the property value by String.
     *
     * @param string
     */
    public void setPriorityByString(String string) {
        setPriority(string);
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
     * for the <code>FtActions</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "actions")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!FtAction.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!FtAction.isMatchHungry(target)) {
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
     * is valid for the <code>FtActions</code>.
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
     * is valid for the <code>FtActions</code>.
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
