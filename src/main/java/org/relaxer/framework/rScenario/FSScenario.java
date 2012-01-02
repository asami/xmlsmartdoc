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
 * <b>FSScenario</b> is generated from scenario.rng by Relaxer.
 * This class is derived from:
 * 
 * <!-- for programmer
 * <element name="scenario">
 *   <zeroOrMore>
 *     <ref name="event"/>
 *   </zeroOrMore>
 * </element>
 * -->
 * <!-- for javadoc -->
 * <pre> &lt;element name="scenario"&gt;
 *   &lt;zeroOrMore&gt;
 *     &lt;ref name="event"/&gt;
 *   &lt;/zeroOrMore&gt;
 * &lt;/element&gt;
 * </pre>
 *
 * @version scenario.rng (Mon Aug 04 17:07:37 JST 2003)
 * @author  Relaxer 1.0rc3b (http://www.relaxer.org)
 */
public class FSScenario implements java.io.Serializable, Cloneable {
    // List<IFSEventChoice>
    private java.util.List event_ = new java.util.ArrayList();

    /**
     * Creates a <code>FSScenario</code>.
     *
     */
    public FSScenario() {
    }

    /**
     * Creates a <code>FSScenario</code>.
     *
     * @param source
     */
    public FSScenario(FSScenario source) {
        setup(source);
    }

    /**
     * Creates a <code>FSScenario</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FSScenario(RStack stack) {
        setup(stack);
    }

    /**
     * Creates a <code>FSScenario</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public FSScenario(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Creates a <code>FSScenario</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public FSScenario(Element element) {
        setup(element);
    }

    /**
     * Creates a <code>FSScenario</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FSScenario(File file) throws IOException, SAXException, ParserConfigurationException {
        setup(file);
    }

    /**
     * Creates a <code>FSScenario</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FSScenario(String uri) throws IOException, SAXException, ParserConfigurationException {
        setup(uri);
    }

    /**
     * Creates a <code>FSScenario</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FSScenario(URL url) throws IOException, SAXException, ParserConfigurationException {
        setup(url);
    }

    /**
     * Creates a <code>FSScenario</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FSScenario(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        setup(in);
    }

    /**
     * Creates a <code>FSScenario</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FSScenario(InputSource is) throws IOException, SAXException, ParserConfigurationException {
        setup(is);
    }

    /**
     * Creates a <code>FSScenario</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public FSScenario(Reader reader) throws IOException, SAXException, ParserConfigurationException {
        setup(reader);
    }

    /**
     * Initializes the <code>FSScenario</code> by the FSScenario <code>source</code>.
     *
     * @param source
     */
    public void setup(FSScenario source) {
        int size;
        this.event_.clear();
        size = source.event_.size();
        for (int i = 0;i < size;i++) {
            addEvent((IFSEventChoice)source.getEvent(i).clone());
        }
    }

    /**
     * Initializes the <code>FSScenario</code> by the Document <code>doc</code>.
     *
     * @param doc
     */
    public void setup(Document doc) {
        setup(doc.getDocumentElement());
    }

    /**
     * Initializes the <code>FSScenario</code> by the Element <code>element</code>.
     *
     * @param element
     */
    public void setup(Element element) {
        init(element);
    }

    /**
     * Initializes the <code>FSScenario</code> by the Stack <code>stack</code>
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
        event_.clear();
        while (true) {
            if (FSService.isMatch(stack)) {
                addEvent(new FSService(stack));
            } else if (FSProperty.isMatch(stack)) {
                addEvent(new FSProperty(stack));
            } else if (FSScene.isMatch(stack)) {
                addEvent(new FSScene(stack));
            } else if (FSSystem.isMatch(stack)) {
                addEvent(new FSSystem(stack));
            } else {
                break;
            }
        }
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FSScenario(this));
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
        Element element = doc.createElement("scenario");
        int size;
        size = this.event_.size();
        for (int i = 0;i < size;i++) {
            IFSEventChoice value = (IFSEventChoice)this.event_.get(i);
            value.makeElement(element);
        }
        parent.appendChild(element);
    }

    /**
     * Initializes the <code>FSScenario</code> by the File <code>file</code>.
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
     * Initializes the <code>FSScenario</code>
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
     * Initializes the <code>FSScenario</code> by the URL <code>url</code>.
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
     * Initializes the <code>FSScenario</code> by the InputStream <code>in</code>.
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
     * Initializes the <code>FSScenario</code> by the InputSource <code>is</code>.
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
     * Initializes the <code>FSScenario</code> by the Reader <code>reader</code>.
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
     * Gets the IFSEventChoice property <b>event</b>.
     *
     * @return IFSEventChoice[]
     */
    public final IFSEventChoice[] getEvent() {
        IFSEventChoice[] array = new IFSEventChoice[event_.size()];
        return ((IFSEventChoice[])event_.toArray(array));
    }

    /**
     * Sets the IFSEventChoice property <b>event</b>.
     *
     * @param event
     */
    public final void setEvent(IFSEventChoice[] event) {
        this.event_.clear();
        for (int i = 0;i < event.length;i++) {
            addEvent(event[i]);
        }
    }

    /**
     * Sets the IFSEventChoice property <b>event</b>.
     *
     * @param event
     */
    public final void setEvent(IFSEventChoice event) {
        this.event_.clear();
        addEvent(event);
    }

    /**
     * Adds the IFSEventChoice property <b>event</b>.
     *
     * @param event
     */
    public final void addEvent(IFSEventChoice event) {
        this.event_.add(event);
    }

    /**
     * Adds the IFSEventChoice property <b>event</b>.
     *
     * @param event
     */
    public final void addEvent(IFSEventChoice[] event) {
        for (int i = 0;i < event.length;i++) {
            addEvent(event[i]);
        }
    }

    /**
     * Gets number of the IFSEventChoice property <b>event</b>.
     *
     * @return int
     */
    public final int sizeEvent() {
        return (event_.size());
    }

    /**
     * Gets the IFSEventChoice property <b>event</b> by index.
     *
     * @param index
     * @return IFSEventChoice
     */
    public final IFSEventChoice getEvent(int index) {
        return ((IFSEventChoice)event_.get(index));
    }

    /**
     * Sets the IFSEventChoice property <b>event</b> by index.
     *
     * @param index
     * @param event
     */
    public final void setEvent(int index, IFSEventChoice event) {
        this.event_.set(index, event);
    }

    /**
     * Adds the IFSEventChoice property <b>event</b> by index.
     *
     * @param index
     * @param event
     */
    public final void addEvent(int index, IFSEventChoice event) {
        this.event_.add(index, event);
    }

    /**
     * Remove the IFSEventChoice property <b>event</b> by index.
     *
     * @param index
     */
    public final void removeEvent(int index) {
        this.event_.remove(index);
    }

    /**
     * Remove the IFSEventChoice property <b>event</b> by object.
     *
     * @param event
     */
    public final void removeEvent(IFSEventChoice event) {
        this.event_.remove(event);
    }

    /**
     * Clear the IFSEventChoice property <b>event</b>.
     *
     */
    public final void clearEvent() {
        this.event_.clear();
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
        buffer.append("<scenario");
        size = this.event_.size();
        for (int i = 0;i < size;i++) {
            IFSEventChoice value = (IFSEventChoice)this.event_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.append(">");
        size = this.event_.size();
        for (int i = 0;i < size;i++) {
            IFSEventChoice value = (IFSEventChoice)this.event_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.append("</scenario>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        buffer.write("<scenario");
        size = this.event_.size();
        for (int i = 0;i < size;i++) {
            IFSEventChoice value = (IFSEventChoice)this.event_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.write(">");
        size = this.event_.size();
        for (int i = 0;i < size;i++) {
            IFSEventChoice value = (IFSEventChoice)this.event_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.write("</scenario>");
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        buffer.print("<scenario");
        size = this.event_.size();
        for (int i = 0;i < size;i++) {
            IFSEventChoice value = (IFSEventChoice)this.event_.get(i);
            value.makeTextAttribute(buffer);
        }
        buffer.print(">");
        size = this.event_.size();
        for (int i = 0;i < size;i++) {
            IFSEventChoice value = (IFSEventChoice)this.event_.get(i);
            value.makeTextElement(buffer);
        }
        buffer.print("</scenario>");
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
     * for the <code>FSScenario</code>.
     *
     * @param element
     * @return boolean
     */
    public static boolean isMatch(Element element) {
        if (!URelaxer.isTargetElement(element, "scenario")) {
            return (false);
        }
        RStack target = new RStack(element);
        boolean $match$ = false;
        Element child;
        while (true) {
            if (FSService.isMatchHungry(target)) {
                $match$ = true;
            } else if (FSProperty.isMatchHungry(target)) {
                $match$ = true;
            } else if (FSScene.isMatchHungry(target)) {
                $match$ = true;
            } else if (FSSystem.isMatchHungry(target)) {
                $match$ = true;
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
     * is valid for the <code>FSScenario</code>.
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
     * is valid for the <code>FSScenario</code>.
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
