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
 * <b>FcChanges</b> is generated from changes_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="changes">
 *             <ref name="changes.attlist"/>
 *             <optional>
 *                 <ref name="title"/>
 *             </optional>
 *             <optional>
 *                 <ref name="devs"/>
 *             </optional>
 *             <oneOrMore>
 *                 <ref name="release"/>
 *             </oneOrMore>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="changes"&gt;
 *             &lt;ref name="changes.attlist"/&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="title"/&gt;
 *             &lt;/optional&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="devs"/&gt;
 *             &lt;/optional&gt;
 *             &lt;oneOrMore&gt;
 *                 &lt;ref name="release"/&gt;
 *             &lt;/oneOrMore&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version changes_v12.rng (Wed Mar 03 11:14:25 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FcChanges implements java.io.Serializable, Cloneable {
    private String id_;
    private String xmlLang_;
    private FcTitle title_;
    private FcDevs devs_;
    // List<FcRelease>
    private java.util.List release_ = new java.util.ArrayList();

    /**
     * Creates a <code>FcChanges</code>.
     *
     */
    public FcChanges() {
    }

    /**
     * Creates a <code>FcChanges</code>.
     *
     * @param source
     */
    public FcChanges(FcChanges source) {
        setup(source);
    }

    /**
     * Creates a <code>FcChanges</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FcChanges(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FcChanges</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FcChanges(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FcChanges</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FcChanges(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FcChanges</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcChanges(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FcChanges</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcChanges(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FcChanges</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcChanges(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FcChanges</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcChanges(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FcChanges</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcChanges(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FcChanges</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FcChanges(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FcChanges</code> by the FcChanges <code>source</code>.
     *
     * @param source
     */
    public void setup(FcChanges source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        if (source.title_ != null) {
            setTitle((FcTitle)source.getTitle().clone());
        }
        if (source.devs_ != null) {
            setDevs((FcDevs)source.getDevs().clone());
        }
        this.release_.clear();
        size = source.release_.size();
        for (int i = 0;i < size;i++) {
            addRelease((FcRelease)source.getRelease(i).clone());
        }
    }

    /**
     * Initializes the <code>FcChanges</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FcChanges</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FcChanges</code> by the Stack <code>stack</code>
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
        if (FcTitle.isMatch(stack)) {
            setTitle(new FcTitle(stack));
        }
        if (FcDevs.isMatch(stack)) {
            setDevs(new FcDevs(stack));
        }
        release_.clear();
        while (true) {
            if (FcRelease.isMatch(stack)) {
                addRelease(new FcRelease(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FcChanges(this));
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
        Element element = doc.createElement("changes");
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
        size = this.release_.size();
        for (int i = 0;i < size;i++) {
            FcRelease value = (FcRelease)this.release_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FcChanges</code> by the File <code>file</code>.
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
     * Initializes the <code>FcChanges</code>
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
     * Initializes the <code>FcChanges</code> by the URL <code>url</code>.
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
     * Initializes the <code>FcChanges</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FcChanges</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FcChanges</code> by the Reader <code>reader</code>.
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
     * Gets the FcTitle property <b>title</b>.
     *
     * @return FcTitle
     */
    public FcTitle getTitle() {
        return (title_);
    }

    /**
     * Sets the FcTitle property <b>title</b>.
     *
     * @param title
     */
    public void setTitle(FcTitle title) {
        this.title_ = title;
    }

    /**
     * Gets the FcDevs property <b>devs</b>.
     *
     * @return FcDevs
     */
    public FcDevs getDevs() {
        return (devs_);
    }

    /**
     * Sets the FcDevs property <b>devs</b>.
     *
     * @param devs
     */
    public void setDevs(FcDevs devs) {
        this.devs_ = devs;
    }

    /**
     * Gets the FcRelease property <b>release</b>.
     *
     * @return FcRelease[]
     */
    public FcRelease[] getRelease() {
        FcRelease[] array = new FcRelease[release_.size()];
        return ((FcRelease[])release_.toArray(array));
    }

    /**
     * Sets the FcRelease property <b>release</b>.
     *
     * @param release
     */
    public void setRelease(FcRelease[] release) {
        this.release_.clear();
        for (int i = 0;i < release.length;i++) {
            addRelease(release[i]);
        }
    }

    /**
     * Sets the FcRelease property <b>release</b>.
     *
     * @param release
     */
    public void setRelease(FcRelease release) {
        this.release_.clear();
        addRelease(release);
    }

    /**
     * Adds the FcRelease property <b>release</b>.
     *
     * @param release
     */
    public void addRelease(FcRelease release) {
        this.release_.add(release);
    }

    /**
     * Adds the FcRelease property <b>release</b>.
     *
     * @param release
     */
    public void addRelease(FcRelease[] release) {
        for (int i = 0;i < release.length;i++) {
            addRelease(release[i]);
        }
    }

    /**
     * Gets number of the FcRelease property <b>release</b>.
     *
     * @return int
     */
    public int sizeRelease() {
        return (release_.size());
    }

    /**
     * Gets the FcRelease property <b>release</b> by index.
     *
     * @param index
     * @return FcRelease
     */
    public FcRelease getRelease(int index) {
        return ((FcRelease)release_.get(index));
    }

    /**
     * Sets the FcRelease property <b>release</b> by index.
     *
     * @param index
     * @param release
     */
    public void setRelease(int index, FcRelease release) {
        this.release_.set(index, release);
    }

    /**
     * Adds the FcRelease property <b>release</b> by index.
     *
     * @param index
     * @param release
     */
    public void addRelease(int index, FcRelease release) {
        this.release_.add(index, release);
    }

    /**
     * Remove the FcRelease property <b>release</b> by index.
     *
     * @param index
     */
    public void removeRelease(int index) {
        this.release_.remove(index);
    }

    /**
     * Remove the FcRelease property <b>release</b> by object.
     *
     * @param release
     */
    public void removeRelease(FcRelease release) {
        this.release_.remove(release);
    }

    /**
     * Clear the FcRelease property <b>release</b>.
     *
     */
    public void clearRelease() {
        this.release_.clear();
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
        buffer.append("<changes");
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
        size = this.release_.size();
        for (int i = 0;i < size;i++) {
            FcRelease value = (FcRelease)this.release_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</changes>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<changes");
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
        size = this.release_.size();
        for (int i = 0;i < size;i++) {
            FcRelease value = (FcRelease)this.release_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</changes>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<changes");
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
        size = this.release_.size();
        for (int i = 0;i < size;i++) {
            FcRelease value = (FcRelease)this.release_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</changes>");
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
     * for the <code>FcChanges</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "changes")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (FcTitle.isMatchHungry(target)) {
        }
        if (FcDevs.isMatchHungry(target)) {
        }
        if (!FcRelease.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        while (true) {
            if (!FcRelease.isMatchHungry(target)) {
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
     * is valid for the <code>FcChanges</code>.
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
     * is valid for the <code>FcChanges</code>.
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
