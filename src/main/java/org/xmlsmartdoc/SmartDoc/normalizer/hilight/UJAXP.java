package org.xmlsmartdoc.SmartDoc.normalizer.hilight;

import java.util.*;
import java.lang.reflect.*;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;

/**
 * UJAXP
 *
 * @since   Feb. 20, 2000
 * @version Sep. 11, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public final class UJAXP {
    public final static int FLAG_NONE = 0x00;
    public final static int FLAG_VALIDATION = 0x01;
    public final static int FLAG_NAMESPACE_AWARE = 0x02;
    public final static int FLAG_WHITESPACE = 0x04;
    public final static int FLAG_EXPAND_ENTITY_REF = 0x08;
    public final static int FLAG_IGNORE_COMMENTS = 0x10;
    public final static int FLAG_COALESCING = 0x20;

    private static ErrorHandler errorHandler;
    private static EntityResolver entityResolver;
    private static Map entityMap;

    public static Document getDocument(File file, int flags)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(file.toURL(), flags));
    }

    public static Document getDocument(String uri, int flags)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(uri, flags, getErrorHandler()));
    }

    public static Document getDocument(URL url, int flags)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(url, flags, getErrorHandler()));
    }

    public static Document getDocument(InputStream in, int flags)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(in, flags, getErrorHandler()));
    }

    public static Document getDocument(InputSource is, int flags)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(is, flags, getErrorHandler()));
    }

    public static Document getDocument(Reader reader, int flags)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(reader, flags, getErrorHandler()));
    }

    public static Document getDocument(
	File file,
	int flags,
	ErrorHandler handler
    ) throws IOException, SAXException, ParserConfigurationException {
	return (getDocument(file.toURL(), flags, handler));
    }

    public static Document getDocument(
	String uri,
	int flags,
	ErrorHandler handler
    ) throws IOException, SAXException, ParserConfigurationException {
	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
	_setup(factory, flags);
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(adjustURI(uri));
        return (doc);
    }

    public static Document getDocument(
	URL url,
	int flags,
	ErrorHandler handler
    ) throws IOException, SAXException, ParserConfigurationException {
	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
	_setup(factory, flags);
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(url.toString());
        return (doc);
    }

    public static Document getDocument(
	InputStream in,
	int flags,
	ErrorHandler handler
    ) throws IOException, SAXException, ParserConfigurationException {
	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
	_setup(factory, flags);
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(in);
        return (doc);
    }

    public static Document getDocument(
	InputSource is,
	int flags,
	ErrorHandler handler
    ) throws IOException, SAXException, ParserConfigurationException {
	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
	_setup(factory, flags);
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(is);
        return (doc);
    }

    public static Document getDocument(
	Reader reader,
	int flags,
	ErrorHandler handler
    ) throws IOException, SAXException, ParserConfigurationException {
	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
	_setup(factory, flags);
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(new InputSource(reader));
        return (doc);
    }

    private static void _setup(DocumentBuilderFactory factory, int flags) {
	if ((flags & FLAG_VALIDATION) != 0) {
	    factory.setValidating(true);
	}
	if ((flags & FLAG_NAMESPACE_AWARE) != 0) {
	    factory.setNamespaceAware(true);
	}
    }

    //
    public static Document getDocument(File file)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(file.toURL()));
    }

    public static Document getDocument(String uri)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(uri, getErrorHandler()));
    }

    public static Document getDocument(URL url)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(url, getErrorHandler()));
    }

    public static Document getDocument(InputStream in)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(in, getErrorHandler()));
    }

    public static Document getDocument(InputSource is)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(is, getErrorHandler()));
    }

    public static Document getDocument(Reader reader)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(reader, getErrorHandler()));
    }

    public static Document getDocument(File file, ErrorHandler handler)
	throws IOException, SAXException, ParserConfigurationException {

	return (getDocument(file.toURL(), handler));
    }

    public static Document getDocument(String uri, ErrorHandler handler)
	throws IOException, SAXException, ParserConfigurationException {

	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(adjustURI(uri));
        return (doc);
    }

    public static Document getDocument(URL url, ErrorHandler handler)
	throws IOException, SAXException, ParserConfigurationException {

	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(url.toString());
        return (doc);
    }

    public static Document getDocument(InputStream in, ErrorHandler handler)
	throws IOException, SAXException, ParserConfigurationException {

	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(in);
        return (doc);
    }

    public static Document getDocument(InputSource is, ErrorHandler handler)
	throws IOException, SAXException, ParserConfigurationException {

	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(is);
        return (doc);
    }

    public static Document getDocument(Reader reader, ErrorHandler handler)
	throws IOException, SAXException, ParserConfigurationException {

	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(new InputSource(reader));
        return (doc);
    }

    public static Document getValidDocument(File file)
	throws IOException, SAXException, ParserConfigurationException {

	return (getValidDocument(file.toURL()));
    }

    public static Document getValidDocument(String uri)
	throws IOException, SAXException, ParserConfigurationException {

	return (getValidDocument(uri, getErrorHandler()));
    }

    public static Document getValidDocument(URL url)
	throws IOException, SAXException, ParserConfigurationException {

	return (getValidDocument(url, getErrorHandler()));
    }

    public static Document getValidDocument(InputStream in)
	throws IOException, SAXException, ParserConfigurationException {

	return (getValidDocument(in, getErrorHandler()));
    }

    public static Document getValidDocument(InputSource is)
	throws IOException, SAXException, ParserConfigurationException {

	return (getValidDocument(is, getErrorHandler()));
    }

    public static Document getValidDocument(Reader reader)
	throws IOException, SAXException, ParserConfigurationException {

	return (getValidDocument(reader, getErrorHandler()));
    }

    public static Document getValidDocument(File file, ErrorHandler handler)
	throws IOException, SAXException, ParserConfigurationException {

	return (getValidDocument(file.toURL(), handler));
    }

    public static Document getValidDocument(
	String uri,
	ErrorHandler handler
    ) throws IOException, SAXException, ParserConfigurationException {
	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(adjustURI(uri));
        return (doc);
    }

    public static Document getValidDocument(
	URL url,
	ErrorHandler handler
    ) throws IOException, SAXException, ParserConfigurationException {
	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(url.toString());
        return (doc);
    }

    public static Document getValidDocument(
	InputStream in,
	ErrorHandler handler
    ) throws IOException, SAXException, ParserConfigurationException {
	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(in);
        return (doc);
    }

    public static Document getValidDocument(
	InputSource is,
	ErrorHandler handler
    ) throws IOException, SAXException, ParserConfigurationException {
	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(is);
        return (doc);
    }

    public static Document getValidDocument(
	Reader reader,
	ErrorHandler handler
    ) throws IOException, SAXException, ParserConfigurationException {
	if (handler == null) {
	    handler = getErrorHandler();
	}
        DocumentBuilderFactory factory
            = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
        Document doc = builder.parse(new InputSource(reader));
        return (doc);
    }

    public static Document makeDocument()
	throws ParserConfigurationException {

	return (makeDocument(getErrorHandler()));
    }

    public static Document makeDocument(ErrorHandler handler)
	throws ParserConfigurationException {

	DocumentBuilderFactory factory
	    = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	builder.setErrorHandler(handler);
	builder.setEntityResolver(getEntityResolver());
	Document doc = builder.newDocument();
	return (doc);
    }

    public static ErrorHandler getErrorHandler() {
	if (errorHandler == null) {
	    errorHandler = new DefaultErrorHandler();
	}
	return (errorHandler);
    }

    public static EntityResolver getEntityResolver() {
	if (entityResolver == null) {
	    entityResolver = new DefaultEntityResolver();
	}
	return (entityResolver);
    }

    static class DefaultErrorHandler implements ErrorHandler {
	public void error(SAXParseException e) {
	    System.err.print("error : ");
	    System.err.println(e.getMessage());
	}

	public void fatalError(SAXParseException e) {
	    System.err.print("fatal error : ");
	    System.err.println(e.getMessage());
	}

	public void warning(SAXParseException e) {
	    System.err.print("warning : ");
	    System.err.println(e.getMessage());
	}
    }

    static class DefaultEntityResolver implements EntityResolver {
	public InputSource resolveEntity(
	    String publicId,
	    String systemId
	) {
	    if (!systemId.endsWith(".dtd")) {
		URL url = getEntityResource(systemId);
		if (url != null) {
		    return (new InputSource(url.toExternalForm()));
		} else {
		    return (null);
		}
	    }
	    if (canAccess(systemId)) {
		return (new InputSource(systemId));
	    } else {
		URL url = getEntityResource(systemId);
		if (url != null) {
		    return (new InputSource(url.toExternalForm()));
		} else {
		    StringReader reader = new StringReader("");
		    return (new InputSource(reader));
		}
	    }
	}
    }

    static String adjustURI(String uri) {
	try {
	    URL url = makeURL(uri);
	    return (url.toExternalForm());
	} catch (MalformedURLException e) {
	    return (uri);
	}
    }

    static URL makeURL(String uri) throws MalformedURLException {
	try {
	    return (new URL(uri));
	} catch (MalformedURLException e) {
	    return (new File(uri).toURL());
	}
    }

    static boolean canAccess(String uri) {
	try {
	    URL url = makeURL(uri);
	    if ("file".equals(url.getProtocol())) {
		String fileName = url.getFile();
		return (new File(fileName).exists());
	    }
	    return (false);	// skip http uri
	} catch (IOException e) {
	    return (false);
	}
    }

    public static void setErrorHandler(ErrorHandler handler) {
	errorHandler = handler;
    }

    public static void setEntityResolver(EntityResolver resolver) {
	entityResolver = resolver;
    }

    public static void setEntityResource(String systemId, URL resource) {
	if (entityMap == null) {
	    entityMap = new HashMap();
	}
	entityMap.put(systemId, resource);
    }

    public static URL getEntityResource(String systemId) {
	if (entityMap == null) {
	    return (null);
	} else {
	    return ((URL)entityMap.get(systemId));
	}
    }

    // test driver
    public static void main(String[] args) throws Exception {
	String className = args[0];
	File file = new File(args[1]);
	Class clazz = Class.forName(className);
	Method setupMethod = clazz.getMethod(
	    "setup",
	    new Class[] { File.class }
	);
	Method makeMethod = clazz.getMethod(
	    "makeDocument",
	    new Class[0]
	);
	Object object = clazz.newInstance();
	setupMethod.invoke(object, new Object[] { file });
	Document doc = (Document)makeMethod.invoke(object, new Object[0]);
	System.out.println(URelaxer.doc2String4Data(doc));
    }
}
