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
package org.relaxer.vocabulary.forrest_0_5.howto_v12;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * <b>FhHowto</b> is generated from howto_v12.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="howto">
 *             <ref name="howto.attlist"/>
 *             <ref name="header"/>
 *             <optional>
 *                 <ref name="audience"/>
 *             </optional>
 *             <optional>
 *                 <ref name="purpose"/>
 *             </optional>
 *             <optional>
 *                 <ref name="prerequisites"/>
 *             </optional>
 *             <ref name="steps"/>
 *             <optional>
 *                 <ref name="extension"/>
 *             </optional>
 *             <optional>
 *                 <ref name="faqs"/>
 *             </optional>
 *             <optional>
 *                 <ref name="tips"/>
 *             </optional>
 *             <optional>
 *                 <ref name="references"/>
 *             </optional>
 *             <optional>
 *                 <ref name="feedback"/>
 *             </optional>
 *         </element>-->
 * <!-- for javadoc -->
 * <pre> &lt;element name="howto"&gt;
 *             &lt;ref name="howto.attlist"/&gt;
 *             &lt;ref name="header"/&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="audience"/&gt;
 *             &lt;/optional&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="purpose"/&gt;
 *             &lt;/optional&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="prerequisites"/&gt;
 *             &lt;/optional&gt;
 *             &lt;ref name="steps"/&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="extension"/&gt;
 *             &lt;/optional&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="faqs"/&gt;
 *             &lt;/optional&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="tips"/&gt;
 *             &lt;/optional&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="references"/&gt;
 *             &lt;/optional&gt;
 *             &lt;optional&gt;
 *                 &lt;ref name="feedback"/&gt;
 *             &lt;/optional&gt;
 *         &lt;/element&gt;</pre>
 *
 * @version howto_v12.rng (Wed Mar 03 11:15:34 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FhHowto implements java.io.Serializable, Cloneable {
    private String id_;
    private String xmlLang_;
    private FhHeader header_;
    private FhAudience audience_;
    private FhPurpose purpose_;
    private FhPrerequisites prerequisites_;
    private FhSteps steps_;
    private FhExtension extension_;
    private FhFaqs faqs_;
    private FhTips tips_;
    private FhReferences references_;
    private FhFeedback feedback_;

    /**
     * Creates a <code>FhHowto</code>.
     *
     */
    public FhHowto() {
    }

    /**
     * Creates a <code>FhHowto</code>.
     *
     * @param source
     */
    public FhHowto(FhHowto source) {
        setup(source);
    }

    /**
     * Creates a <code>FhHowto</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FhHowto(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FhHowto</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FhHowto(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FhHowto</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FhHowto(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FhHowto</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhHowto(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FhHowto</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhHowto(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FhHowto</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhHowto(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FhHowto</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhHowto(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FhHowto</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhHowto(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FhHowto</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FhHowto(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FhHowto</code> by the FhHowto <code>source</code>.
     *
     * @param source
     */
    public void setup(FhHowto source) {
        int size;
        setId(source.getId());
        setXmlLang(source.getXmlLang());
        if (source.header_ != null) {
            setHeader((FhHeader)source.getHeader().clone());
        }
        if (source.audience_ != null) {
            setAudience((FhAudience)source.getAudience().clone());
        }
        if (source.purpose_ != null) {
            setPurpose((FhPurpose)source.getPurpose().clone());
        }
        if (source.prerequisites_ != null) {
            setPrerequisites((FhPrerequisites)source.getPrerequisites().clone());
        }
        if (source.steps_ != null) {
            setSteps((FhSteps)source.getSteps().clone());
        }
        if (source.extension_ != null) {
            setExtension((FhExtension)source.getExtension().clone());
        }
        if (source.faqs_ != null) {
            setFaqs((FhFaqs)source.getFaqs().clone());
        }
        if (source.tips_ != null) {
            setTips((FhTips)source.getTips().clone());
        }
        if (source.references_ != null) {
            setReferences((FhReferences)source.getReferences().clone());
        }
        if (source.feedback_ != null) {
            setFeedback((FhFeedback)source.getFeedback().clone());
        }
    }

    /**
     * Initializes the <code>FhHowto</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FhHowto</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FhHowto</code> by the Stack <code>stack</code>
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
        setHeader(new FhHeader(stack));
        if (FhAudience.isMatch(stack)) {
            setAudience(new FhAudience(stack));
        }
        if (FhPurpose.isMatch(stack)) {
            setPurpose(new FhPurpose(stack));
        }
        if (FhPrerequisites.isMatch(stack)) {
            setPrerequisites(new FhPrerequisites(stack));
        }
        setSteps(new FhSteps(stack));
        if (FhExtension.isMatch(stack)) {
            setExtension(new FhExtension(stack));
        }
        if (FhFaqs.isMatch(stack)) {
            setFaqs(new FhFaqs(stack));
        }
        if (FhTips.isMatch(stack)) {
            setTips(new FhTips(stack));
        }
        if (FhReferences.isMatch(stack)) {
            setReferences(new FhReferences(stack));
        }
        if (FhFeedback.isMatch(stack)) {
            setFeedback(new FhFeedback(stack));
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FhHowto(this));
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
        Element element = doc.createElement("howto");
        int size;
        if (this.id_ != null) {
            URelaxer.setAttributePropertyByString(element, "id", this.id_);
        }
        if (this.xmlLang_ != null) {
            URelaxer.setAttributePropertyByString(element, "xml:lang", this.xmlLang_);
        }
        this.header_.makeElement(element);
        if (this.audience_ != null) {
            this.audience_.makeElement(element);
        }
        if (this.purpose_ != null) {
            this.purpose_.makeElement(element);
        }
        if (this.prerequisites_ != null) {
            this.prerequisites_.makeElement(element);
        }
        this.steps_.makeElement(element);
        if (this.extension_ != null) {
            this.extension_.makeElement(element);
        }
        if (this.faqs_ != null) {
            this.faqs_.makeElement(element);
        }
        if (this.tips_ != null) {
            this.tips_.makeElement(element);
        }
        if (this.references_ != null) {
            this.references_.makeElement(element);
        }
        if (this.feedback_ != null) {
            this.feedback_.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FhHowto</code> by the File <code>file</code>.
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
     * Initializes the <code>FhHowto</code>
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
     * Initializes the <code>FhHowto</code> by the URL <code>url</code>.
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
     * Initializes the <code>FhHowto</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FhHowto</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FhHowto</code> by the Reader <code>reader</code>.
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
     * Gets the FhHeader property <b>header</b>.
     *
     * @return FhHeader
     */
    public FhHeader getHeader() {
        return (header_);
    }

    /**
     * Sets the FhHeader property <b>header</b>.
     *
     * @param header
     */
    public void setHeader(FhHeader header) {
        this.header_ = header;
    }

    /**
     * Gets the FhAudience property <b>audience</b>.
     *
     * @return FhAudience
     */
    public FhAudience getAudience() {
        return (audience_);
    }

    /**
     * Sets the FhAudience property <b>audience</b>.
     *
     * @param audience
     */
    public void setAudience(FhAudience audience) {
        this.audience_ = audience;
    }

    /**
     * Gets the FhPurpose property <b>purpose</b>.
     *
     * @return FhPurpose
     */
    public FhPurpose getPurpose() {
        return (purpose_);
    }

    /**
     * Sets the FhPurpose property <b>purpose</b>.
     *
     * @param purpose
     */
    public void setPurpose(FhPurpose purpose) {
        this.purpose_ = purpose;
    }

    /**
     * Gets the FhPrerequisites property <b>prerequisites</b>.
     *
     * @return FhPrerequisites
     */
    public FhPrerequisites getPrerequisites() {
        return (prerequisites_);
    }

    /**
     * Sets the FhPrerequisites property <b>prerequisites</b>.
     *
     * @param prerequisites
     */
    public void setPrerequisites(FhPrerequisites prerequisites) {
        this.prerequisites_ = prerequisites;
    }

    /**
     * Gets the FhSteps property <b>steps</b>.
     *
     * @return FhSteps
     */
    public FhSteps getSteps() {
        return (steps_);
    }

    /**
     * Sets the FhSteps property <b>steps</b>.
     *
     * @param steps
     */
    public void setSteps(FhSteps steps) {
        this.steps_ = steps;
    }

    /**
     * Gets the FhExtension property <b>extension</b>.
     *
     * @return FhExtension
     */
    public FhExtension getExtension() {
        return (extension_);
    }

    /**
     * Sets the FhExtension property <b>extension</b>.
     *
     * @param extension
     */
    public void setExtension(FhExtension extension) {
        this.extension_ = extension;
    }

    /**
     * Gets the FhFaqs property <b>faqs</b>.
     *
     * @return FhFaqs
     */
    public FhFaqs getFaqs() {
        return (faqs_);
    }

    /**
     * Sets the FhFaqs property <b>faqs</b>.
     *
     * @param faqs
     */
    public void setFaqs(FhFaqs faqs) {
        this.faqs_ = faqs;
    }

    /**
     * Gets the FhTips property <b>tips</b>.
     *
     * @return FhTips
     */
    public FhTips getTips() {
        return (tips_);
    }

    /**
     * Sets the FhTips property <b>tips</b>.
     *
     * @param tips
     */
    public void setTips(FhTips tips) {
        this.tips_ = tips;
    }

    /**
     * Gets the FhReferences property <b>references</b>.
     *
     * @return FhReferences
     */
    public FhReferences getReferences() {
        return (references_);
    }

    /**
     * Sets the FhReferences property <b>references</b>.
     *
     * @param references
     */
    public void setReferences(FhReferences references) {
        this.references_ = references;
    }

    /**
     * Gets the FhFeedback property <b>feedback</b>.
     *
     * @return FhFeedback
     */
    public FhFeedback getFeedback() {
        return (feedback_);
    }

    /**
     * Sets the FhFeedback property <b>feedback</b>.
     *
     * @param feedback
     */
    public void setFeedback(FhFeedback feedback) {
        this.feedback_ = feedback;
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
        buffer.append("<howto");
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
        header_.makeTextElement(buffer);
        if (audience_ != null) {
            audience_.makeTextElement(buffer);
        }
        if (purpose_ != null) {
            purpose_.makeTextElement(buffer);
        }
        if (prerequisites_ != null) {
            prerequisites_.makeTextElement(buffer);
        }
        steps_.makeTextElement(buffer);
        if (extension_ != null) {
            extension_.makeTextElement(buffer);
        }
        if (faqs_ != null) {
            faqs_.makeTextElement(buffer);
        }
        if (tips_ != null) {
            tips_.makeTextElement(buffer);
        }
        if (references_ != null) {
            references_.makeTextElement(buffer);
        }
        if (feedback_ != null) {
            feedback_.makeTextElement(buffer);
        }
        buffer.append("</howto>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<howto");
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
        header_.makeTextElement(buffer);
        if (audience_ != null) {
            audience_.makeTextElement(buffer);
        }
        if (purpose_ != null) {
            purpose_.makeTextElement(buffer);
        }
        if (prerequisites_ != null) {
            prerequisites_.makeTextElement(buffer);
        }
        steps_.makeTextElement(buffer);
        if (extension_ != null) {
            extension_.makeTextElement(buffer);
        }
        if (faqs_ != null) {
            faqs_.makeTextElement(buffer);
        }
        if (tips_ != null) {
            tips_.makeTextElement(buffer);
        }
        if (references_ != null) {
            references_.makeTextElement(buffer);
        }
        if (feedback_ != null) {
            feedback_.makeTextElement(buffer);
        }
        buffer.write("</howto>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<howto");
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
        header_.makeTextElement(buffer);
        if (audience_ != null) {
            audience_.makeTextElement(buffer);
        }
        if (purpose_ != null) {
            purpose_.makeTextElement(buffer);
        }
        if (prerequisites_ != null) {
            prerequisites_.makeTextElement(buffer);
        }
        steps_.makeTextElement(buffer);
        if (extension_ != null) {
            extension_.makeTextElement(buffer);
        }
        if (faqs_ != null) {
            faqs_.makeTextElement(buffer);
        }
        if (tips_ != null) {
            tips_.makeTextElement(buffer);
        }
        if (references_ != null) {
            references_.makeTextElement(buffer);
        }
        if (feedback_ != null) {
            feedback_.makeTextElement(buffer);
        }
        buffer.print("</howto>");
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
     * for the <code>FhHowto</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "howto")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        if (!FhHeader.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        if (FhAudience.isMatchHungry(target)) {
        }
        if (FhPurpose.isMatchHungry(target)) {
        }
        if (FhPrerequisites.isMatchHungry(target)) {
        }
        if (!FhSteps.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        if (FhExtension.isMatchHungry(target)) {
        }
        if (FhFaqs.isMatchHungry(target)) {
        }
        if (FhTips.isMatchHungry(target)) {
        }
        if (FhReferences.isMatchHungry(target)) {
        }
        if (FhFeedback.isMatchHungry(target)) {
        }
        if (!target.isEmptyElement()) {
            return (false);
        }
        return (true);
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FhHowto</code>.
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
     * is valid for the <code>FhHowto</code>.
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
