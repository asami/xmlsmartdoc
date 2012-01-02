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
package org.relaxer.vocabulary.forrest_0_5.changes_v12;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>FcRelease</b> is generated from changes_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="release">
 *             <ref name="release.attlist"/>
 *             <oneOrMore>
 *                 <ref name="action"/>
 *             </oneOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="release"&gt;
 *             &lt;ref name="release.attlist"/&gt;
 *             &lt;oneOrMore&gt;
 *                 &lt;ref name="action"/&gt;
 *             &lt;/oneOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version changes_v12.rng (Wed Mar 03 11:14:25 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FcRelease implements java.io.Serializable, Cloneable {
    private String id_;
    private String xmlLang_;
    private String version_;
    private String date_;
    // List<FcAction>
    private java.util.List action_ = new java.util.ArrayList();

    /**
     * Creates a <code>FcRelease</code>.
     *
     */
    public FcRelease() {
        version_ = "";
        date_ = "";
    }

    /**
     * Creates a <code>FcRelease</code>.
     *
     * @param source
     */
    public FcRelease(FcRelease source) {
        setup(source);
    }

    /**
     * Creates a <code>FcRelease</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FcRelease(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FcRelease</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FcRelease(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FcRelease</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FcRelease(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FcRelease</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcRelease(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FcRelease</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcRelease(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FcRelease</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcRelease(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FcRelease</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcRelease(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FcRelease</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcRelease(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FcRelease</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcRelease(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FcRelease</code> by the FcRelease <code>source</code>.
     *
     * @param source
     */
    public void setup(FcRelease source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        setVersion(source.getVersion());
        setDate(source.getDate());
        this.action_.clear();
        size = source.action_.size();
        for (int i = 0;i < size;i++) {
            addAction((FcAction)source.getAction(i).clone());
        }
    }

    /**
     * Initializes the <code>FcRelease</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FcRelease</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FcRelease</code> by the Stack <code>stack</code>
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
        version_ = URelaxer.getAttributePropertyAsString(element, "version");
        date_ = URelaxer.getAttributePropertyAsString(element, "date");
        action_.clear();
        while (true) {
            if (FcAction.isMatch(stack)) {
                addAction(new FcAction(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FcRelease(this));
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
        Element element = doc.createElement("release");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        if (this.version_ != null) {
            URelaxer.setAttributePropertyByString(element, "version", this.version_);
        }
        if (this.date_ != null) {
            URelaxer.setAttributePropertyByString(element, "date", this.date_);
        }
        size = this.action_.size();
        for (int i = 0;i < size;i++) {
            FcAction value = (FcAction)this.action_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FcRelease</code> by the File <code>file</code>.
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
     * Initializes the <code>FcRelease</code>
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
     * Initializes the <code>FcRelease</code> by the URL <code>url</code>.
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
     * Initializes the <code>FcRelease</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FcRelease</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FcRelease</code> by the Reader <code>reader</code>.
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
     * Gets the String property <b>version</b>.
     *
     * @return String
     */
    public String getVersion() {
        return (version_);
    }

    /**
     * Sets the String property <b>version</b>.
     *
     * @param version
     */
    public void setVersion(String version) {
        this.version_ = version;
    }

    /**
     * Gets the String property <b>date</b>.
     *
     * @return String
     */
    public String getDate() {
        return (date_);
    }

    /**
     * Sets the String property <b>date</b>.
     *
     * @param date
     */
    public void setDate(String date) {
        this.date_ = date;
    }

    /**
     * Gets the FcAction property <b>action</b>.
     *
     * @return FcAction[]
     */
    public FcAction[] getAction() {
        FcAction[] array = new FcAction[action_.size()];
        return ((FcAction[])action_.toArray(array));
    }

    /**
     * Sets the FcAction property <b>action</b>.
     *
     * @param action
     */
    public void setAction(FcAction[] action) {
        this.action_.clear();
        for (int i = 0;i < action.length;i++) {
            addAction(action[i]);
        }
    }

    /**
     * Sets the FcAction property <b>action</b>.
     *
     * @param action
     */
    public void setAction(FcAction action) {
        this.action_.clear();
        addAction(action);
    }

    /**
     * Adds the FcAction property <b>action</b>.
     *
     * @param action
     */
    public void addAction(FcAction action) {
        this.action_.add(action);
    }

    /**
     * Adds the FcAction property <b>action</b>.
     *
     * @param action
     */
    public void addAction(FcAction[] action) {
        for (int i = 0;i < action.length;i++) {
            addAction(action[i]);
        }
    }

    /**
     * Gets number of the FcAction property <b>action</b>.
     *
     * @return int
     */
    public int sizeAction() {
        return (action_.size());
    }

    /**
     * Gets the FcAction property <b>action</b> by index.
     *
     * @param index
     * @return FcAction
     */
    public FcAction getAction(int index) {
        return ((FcAction)action_.get(index));
    }

    /**
     * Sets the FcAction property <b>action</b> by index.
     *
     * @param index
     * @param action
     */
    public void setAction(int index, FcAction action) {
        this.action_.set(index, action);
    }

    /**
     * Adds the FcAction property <b>action</b> by index.
     *
     * @param index
     * @param action
     */
    public void addAction(int index, FcAction action) {
        this.action_.add(index, action);
    }

    /**
     * Remove the FcAction property <b>action</b> by index.
     *
     * @param index
     */
    public void removeAction(int index) {
        this.action_.remove(index);
    }

    /**
     * Remove the FcAction property <b>action</b> by object.
     *
     * @param action
     */
    public void removeAction(FcAction action) {
        this.action_.remove(action);
    }

    /**
     * Clear the FcAction property <b>action</b>.
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
        buffer.append("<release");
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
        if (version_ != null) {
            buffer.append(" version=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getVersion())));
            buffer.append("\"");
        }
        if (date_ != null) {
            buffer.append(" date=\"");
            buffer.append(URelaxer.escapeAttrQuot(URelaxer.getString(getDate())));
            buffer.append("\"");
        }
        buffer.append(">");
        size = this.action_.size();
        for (int i = 0;i < size;i++) {
            FcAction value = (FcAction)this.action_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</release>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<release");
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
        if (version_ != null) {
            buffer.write(" version=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getVersion())));
            buffer.write("\"");
        }
        if (date_ != null) {
            buffer.write(" date=\"");
            buffer.write(URelaxer.escapeAttrQuot(URelaxer.getString(getDate())));
            buffer.write("\"");
        }
        buffer.write(">");
        size = this.action_.size();
        for (int i = 0;i < size;i++) {
            FcAction value = (FcAction)this.action_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</release>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<release");
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
        if (version_ != null) {
            buffer.print(" version=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getVersion())));
            buffer.print("\"");
        }
        if (date_ != null) {
            buffer.print(" date=\"");
            buffer.print(URelaxer.escapeAttrQuot(URelaxer.getString(getDate())));
            buffer.print("\"");
        }
        buffer.print(">");
        size = this.action_.size();
        for (int i = 0;i < size;i++) {
            FcAction value = (FcAction)this.action_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</release>");
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
    public String getVersionAsString() {
        return (URelaxer.getString(getVersion()));
    }

    /**
     * Gets the property value as String.
     *
     * @return String
     */
    public String getDateAsString() {
        return (URelaxer.getString(getDate()));
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
    public void setVersionByString(String string) {
        setVersion(string);
    }

    /**
     * Sets the property value by String.
     *
     * @param string
     */
    public void setDateByString(String string) {
        setDate(string);
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
     * for the <code>FcRelease</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "release")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!URelaxer.hasAttributeHungry(target, "version")) {
            return (false);
        }
        $match$ = true;
        if (!URelaxer.hasAttributeHungry(target, "date")) {
            return (false);
        }
        $match$ = true;
        if (!FcAction.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!FcAction.isMatchHungry(target)) {
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
     * is valid for the <code>FcRelease</code>.
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
     * is valid for the <code>FcRelease</code>.
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
