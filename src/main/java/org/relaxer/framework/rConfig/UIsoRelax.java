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
package org.relaxer.framework.rConfig;

import java.lang.reflect.*;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;
import org.iso_relax.verifier.VerifierConfigurationException;
import org.iso_relax.verifier.VerifierFactory;
import org.iso_relax.verifier.Verifier;
import org.iso_relax.verifier.VerifierHandler;
import org.iso_relax.verifier.VerifierFilter;

/**
 * UIsoRelax
 *
 * @since   Apr. 11, 2001
 * @version Feb. 17, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class UIsoRelax {
    public static boolean verifyElementByResource(
        String name,
        Element element
    ) throws IOException, SAXException, VerifierConfigurationException {
        return (
            verifyElementByResource(name, element, UJAXP.getErrorHandler())
        );
    }

    public static boolean verifyElementByResource(
        String name,
        Element element,
        ErrorHandler handler
    ) throws IOException, SAXException, VerifierConfigurationException {
        return (verifyByResource(name, element, handler));
    }

    public static Document getVerifiedDocument(
        String relax,
        File file,
        int flags
    ) throws
        IOException,
        SAXException,
        ParserConfigurationException,
        VerifierConfigurationException {

        return (getVerifiedDocument(relax, file.toURL(), flags));
    }

    public static Document getVerifiedDocument(
        String relax,
        String uri,
        int flags
    ) throws
        IOException,
        SAXException,
        ParserConfigurationException,
        VerifierConfigurationException {

        return (
            getVerifiedDocument(relax, uri, flags, UJAXP.getErrorHandler())
        );
    }

    public static Document getVerifiedDocument(
        String relax,
        URL url,
        int flags
    ) throws
        IOException,
        SAXException,
        ParserConfigurationException,
        VerifierConfigurationException {

        return (
            getVerifiedDocument(relax, url, flags, UJAXP.getErrorHandler())
        );
    }

    public static Document getVerifiedDocument(
        String relax,
        InputStream in,
        int flags
    ) throws
        IOException,
        SAXException,
        ParserConfigurationException,
        VerifierConfigurationException {

        return (
            getVerifiedDocument(relax, in, flags, UJAXP.getErrorHandler())
        );
    }

    public static Document getVerifiedDocument(
        String relax,
        InputSource is,
        int flags
    ) throws
        IOException,
        SAXException,
        ParserConfigurationException,
        VerifierConfigurationException {

        return (
            getVerifiedDocument(relax, is, flags, UJAXP.getErrorHandler())
        );
    }

    public static Document getVerifiedDocument(
        String relax,
        Reader reader,
        int flags
    ) throws
        IOException,
        SAXException,
        ParserConfigurationException,
        VerifierConfigurationException {

        return (
            getVerifiedDocument(relax, reader, flags, UJAXP.getErrorHandler())
        );
    }

    public static Document getVerifiedDocument(
        String relax,
        File file,
        int flags,
        ErrorHandler handler
    ) throws
        IOException,
        SAXException,
        ParserConfigurationException,
        VerifierConfigurationException {

        return (getVerifiedDocument(relax, file.toURL(), flags, handler));
    }

    public static Document getVerifiedDocument(
        String relax,
        String uri,
        int flags,
        ErrorHandler handler
    ) throws
        IOException,
        SAXException,
        ParserConfigurationException,
        VerifierConfigurationException {

        Document doc = UJAXP.getDocument(uri, flags, handler);
        verifyByResource(relax, doc, handler);
        return (doc);
    }

    public static Document getVerifiedDocument(
        String relax,
        URL url,
        int flags,
        ErrorHandler handler
    ) throws
        IOException,
        SAXException,
        ParserConfigurationException,
        VerifierConfigurationException {

        Document doc = UJAXP.getDocument(url, flags, handler);
        verifyByResource(relax, doc, handler);
        return (doc);
    }

    public static Document getVerifiedDocument(
        String relax,
        InputStream in,
        int flags,
        ErrorHandler handler
    ) throws
        IOException,
        SAXException,
        ParserConfigurationException,
        VerifierConfigurationException {

        Document doc = UJAXP.getDocument(in, flags, handler);
        verifyByResource(relax, doc, handler);
        return (doc);
    }

    public static Document getVerifiedDocument(
        String relax,
        InputSource is,
        int flags,
        ErrorHandler handler
    ) throws
        IOException,
        SAXException,
        ParserConfigurationException,
        VerifierConfigurationException {

        Document doc = UJAXP.getDocument(is, flags, handler);
        verifyByResource(relax, doc, handler);
        return (doc);
    }

    public static Document getVerifiedDocument(
        String relax,
        Reader reader,
        int flags,
        ErrorHandler handler
    ) throws
        IOException,
        SAXException,
        ParserConfigurationException,
        VerifierConfigurationException {

        Document doc = UJAXP.getDocument(reader, flags, handler);
        verifyByResource(relax, doc, handler);
        return (doc);
    }

    public static boolean verifyByResource(
        String name,
        Node node,
        ErrorHandler handler
    ) throws VerifierConfigurationException, SAXException, IOException {
        URL url = UIsoRelax.class.getResource(name);
        if (url == null) {
            throw (new VerifierConfigurationException(
                name + " is not installed as a resource."));
        }
        return (verify(url.toExternalForm(), node, handler));
    }

    public static boolean verifyByResource(
        String name,
        String uri,
        ErrorHandler handler
    ) throws VerifierConfigurationException, SAXException, IOException {
        URL url = UIsoRelax.class.getResource(name);
        if (url == null) {
            throw (new VerifierConfigurationException(
                name + " is not installed as a resource."));
        }
        return (verify(url.toExternalForm(), uri, handler));
    }

    public static boolean verifyByResource(
        String name,
        URL url,
        ErrorHandler handler
    ) throws VerifierConfigurationException, SAXException, IOException {
        URL rUrl = UIsoRelax.class.getResource(name);
        if (rUrl == null) {
            throw (new VerifierConfigurationException(
                name + " is not installed as a resource."));
        }
        return (verify(rUrl.toExternalForm(), url, handler));
    }

    public static boolean verifyByResource(
        String name,
        InputStream in,
        ErrorHandler handler
    ) throws VerifierConfigurationException, SAXException, IOException {
        URL url = UIsoRelax.class.getResource(name);
        if (url == null) {
            throw (new VerifierConfigurationException(
                name + " is not installed as a resource."));
        }
        return (verify(url.toExternalForm(), in, handler));
    }

    public static boolean verifyByResource(
        String name,
        InputSource is,
        ErrorHandler handler
    ) throws VerifierConfigurationException, SAXException, IOException {
        URL url = UIsoRelax.class.getResource(name);
        if (url == null) {
            throw (new VerifierConfigurationException(
                name + " is not installed as a resource."));
        }
        return (verify(url.toExternalForm(), is, handler));
    }

    public static boolean verifyByResource(
        String name,
        Reader reader,
        ErrorHandler handler
    ) throws VerifierConfigurationException, SAXException, IOException {
        URL url = UIsoRelax.class.getResource(name);
        if (url == null) {
            throw (new VerifierConfigurationException(
                name + " is not installed as a resource."));
        }
        return (verify(url.toExternalForm(), reader, handler));
    }

    public static boolean verify(
        String relax,
        String uri,
        ErrorHandler handler
    ) throws VerifierConfigurationException, SAXException, IOException {
        Verifier verifier = _getVerifier(relax);
        verifier.setErrorHandler(handler);
        return (verifier.verify(uri));
    }

    public static boolean verify(
        String relax,
        URL url,
        ErrorHandler handler
    ) throws VerifierConfigurationException, SAXException, IOException {
        Verifier verifier = _getVerifier(relax);
        verifier.setErrorHandler(handler);
        return (verifier.verify(url.toExternalForm()));
    }

    public static boolean verify(
        String relax,
        InputStream in,
        ErrorHandler handler
    ) throws VerifierConfigurationException, SAXException, IOException {
        InputSource is = new InputSource(in);
        return (verify(relax, is, handler));
    }

    public static boolean verify(
        String relax,
        InputSource is,
        ErrorHandler handler
    ) throws VerifierConfigurationException, SAXException, IOException {
        Verifier verifier = _getVerifier(relax);
        verifier.setErrorHandler(handler);
        return (verifier.verify(is));
    }

    public static boolean verify(
        String relax,
        Reader reader,
        ErrorHandler handler
    ) throws VerifierConfigurationException, SAXException, IOException {
        InputSource is = new InputSource(reader);
        return (verify(relax, is, handler));
    }

    public static boolean verify(
        String relax,
        Node node,
        ErrorHandler handler
    ) throws VerifierConfigurationException, SAXException, IOException {
        Verifier verifier = _getVerifier(relax);
        verifier.setErrorHandler(handler);
        return (verifier.verify(node));
    }

    private static Verifier _getVerifier(String relax)
        throws VerifierConfigurationException, SAXException, IOException {

        VerifierFactory factory;
        if (relax.endsWith(".rng")) {
            factory = VerifierFactory.newInstance("http://relaxng.org/ns/structure/1.0");
        } else if (relax.endsWith(".rxm")) {
            factory = VerifierFactory.newInstance("http://www.xml.gr.jp/xmlns/relaxCore");
        } else if (relax.endsWith(".rxg")) {
            factory = VerifierFactory.newInstance("http://www.xml.gr.jp/xmlns/relaxNamespace");
        } else if (relax.endsWith(".dtd")) {
            factory = VerifierFactory.newInstance();
        } else if (relax.endsWith(".xsd")) {
            factory = VerifierFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        } else {
            factory = VerifierFactory.newInstance();
        }
        return (factory.newVerifier(relax));
    }
}
