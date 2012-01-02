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
package org.xmlsmartdoc.goldenport.macro;

import java.io.*;
import java.net.URL;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.xmlsmartdoc.goldenport.lib.*;

/**
 * IMacroFactory is generated by Relaxer based on macro.rng.
 *
 * @version macro.rng 1.0 (Fri Jul 29 11:55:15 JST 2005)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public interface IMacroFactory {
    /**
     * Gets a Class of <code>GmMacro</code>.
     *
     * @return Class
     */
    Class getGmMacroClass();

    /**
     * Sets a <b>errorHandler</b>.
     *
     * @param errorHandler
     */
    void setErrorHandler(org.xml.sax.ErrorHandler errorHandler);

    /**
     * Gets a <b>errorHandler</b>.
     *
     * @return org.xml.sax.ErrorHandler
     */
    org.xml.sax.ErrorHandler getErrorHandler();

    /**
     * Sets a <b>entityResolver</b>.
     *
     * @param entityResolver
     */
    void setEntityResolver(org.xml.sax.EntityResolver entityResolver);

    /**
     * Gets a <b>entityResolver</b>.
     *
     * @return org.xml.sax.EntityResolver
     */
    org.xml.sax.EntityResolver getEntityResolver();

    /**
     * Sets a <b>baseUri</b>.
     *
     * @param baseUri
     */
    void setBaseUri(String baseUri);

    /**
     * Gets a <b>baseUri</b>.
     *
     * @return String
     */
    String getBaseUri();

    /**
     * Creates a <code>Object</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return Object
     */
    Object create(File file) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>Object</code> by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return Object
     */
    Object create(String uri) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>Object</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return Object
     */
    Object create(URL url) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>Object</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return Object
     */
    Object create(InputStream in) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>Object</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return Object
     */
    Object create(InputSource is) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>Object</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return Object
     */
    Object create(Reader reader) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>Object</code> by the Object <code>source</code>.
     *
     * @param source
     * @return Object
     */
    Object create(Object source);

    /**
     * Creates a <code>Object</code> by the Document <code>dom</code>.
     *
     * @param doc
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return Object
     */
    Object create(Document doc) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>Object</code> by the Element <code>element</code>.
     *
     * @param element
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return Object
     */
    Object create(Element element) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>GmMacro</code> by the File <code>file</code>.
     *
     * @param file
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return GmMacro
     */
    GmMacro createGmMacro(File file) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>GmMacro</code>
     * by the String representation of URI <code>uri</code>.
     *
     * @param uri
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return GmMacro
     */
    GmMacro createGmMacro(String uri) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>GmMacro</code> by the URL <code>url</code>.
     *
     * @param url
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return GmMacro
     */
    GmMacro createGmMacro(URL url) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>GmMacro</code> by the InputStream <code>in</code>.
     *
     * @param in
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return GmMacro
     */
    GmMacro createGmMacro(InputStream in) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>GmMacro</code> by the InputSource <code>is</code>.
     *
     * @param is
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return GmMacro
     */
    GmMacro createGmMacro(InputSource is) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>GmMacro</code> by the Reader <code>reader</code>.
     *
     * @param reader
     * @exception IOException
     * @exception SAXException
     * @exception ParserConfigurationException
     * @return GmMacro
     */
    GmMacro createGmMacro(Reader reader) throws IOException, SAXException, ParserConfigurationException;

    /**
     * Creates a <code>GmMacro</code>.
     *
     * @return GmMacro
     */
    GmMacro createGmMacro();

    /**
     * Creates a <code>GmMacro</code> by the GmMacro <code>source</code>.
     *
     * @param source
     * @return GmMacro
     */
    GmMacro createGmMacro(GmMacro source);

    /**
     * Creates a <code>GmMacro</code> by the Document <code>doc</code>.
     *
     * @param doc
     * @return GmMacro
     */
    GmMacro createGmMacro(Document doc);

    /**
     * Creates a <code>GmMacro</code> by the Element <code>element</code>.
     *
     * @param element
     * @return GmMacro
     */
    GmMacro createGmMacro(Element element);

    /**
     * Creates a <code>GmMacro</code> by the Stack <code>stack</code>.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return GmMacro
     */
    GmMacro createGmMacro(RStack stack);
}
