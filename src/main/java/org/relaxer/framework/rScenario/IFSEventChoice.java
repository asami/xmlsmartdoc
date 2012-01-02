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
 * <b>IFSEventChoice</b> is generated from scenario.rng by Relaxer.
 * Concrete classes of the interface are FSService, FSProperty, FSScene and FSSystem.
 *
 * @version scenario.rng (Mon Aug 04 17:07:37 JST 2003)
 * @author  Relaxer 1.0rc3b (http://www.relaxer.org)
 */
public interface IFSEventChoice {
    /**
     * Creates a DOM representation of the object.
     * Result is appended to the Node <code>parent</code>.
     *
     * @param parent
     */
    void makeElement(Node parent);

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    void makeTextElement(StringBuffer buffer);

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    void makeTextElement(Writer buffer) throws IOException;

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    void makeTextElement(PrintWriter buffer);

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    void makeTextAttribute(StringBuffer buffer);

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    void makeTextAttribute(Writer buffer) throws IOException;

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    void makeTextAttribute(PrintWriter buffer);

    /**
     * @param doc
     */
    void setup(Document doc);

    /**
     * @param element
     */
    void setup(Element element);

    /**
     * @param stack
     */
    void setup(RStack stack);

    /**
     * @return Object
     */
    Object clone();

    /**
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    void setup(File file) throws IOException, SAXException, ParserConfigurationException;

    /**
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    void setup(String uri) throws IOException, SAXException, ParserConfigurationException;

    /**
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    void setup(URL url) throws IOException, SAXException, ParserConfigurationException;

    /**
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    void setup(InputStream in) throws IOException, SAXException, ParserConfigurationException;

    /**
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    void setup(InputSource is) throws IOException, SAXException, ParserConfigurationException;

    /**
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    void setup(Reader reader) throws IOException, SAXException, ParserConfigurationException;

    /**
     * @exception ParserConfigurationException
     * @return Document
     */
    Document makeDocument() throws ParserConfigurationException;

    /**
     * @return String
     */
    String getName();

    /**
     * @param name
     */
    void setName(String name);

    /**
     * @return String
     */
    String makeTextDocument();

    /**
     * @return String
     */
    String getNameAsString();

    /**
     * @param string
     */
    void setNameByString(String string);

    /**
     * @return String
     */
    String toString();
}
