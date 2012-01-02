package com.AsamiOffice.xml.sax;

import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

/**
 * AbstractFilterHandler
 *
 * @since   Feb. 20, 2001
 * @version Apr. 19, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public abstract class AbstractFilterHandler implements IFilterHandler {
    private EntityResolver resolver_;
    private DTDHandler dtd_;
    private ContentHandler content_;
    private ErrorHandler error_;

    protected AbstractFilterHandler() {
	DefaultHandler handler = new DefaultHandler();
	resolver_ = handler;
	dtd_ = handler;
	content_ = handler;
	error_ = handler;
    }

    public void setFilterHandler(IFilterHandler handler) {
	setEntityResolver(handler);
	setDTDHandler(handler);
	setContentHandler(handler);
	setErrorHandler(handler);
    }

    public void setEntityResolver(EntityResolver resolver) {
	resolver_ = resolver;
    }

    public EntityResolver getEntityResolver() {
	return (resolver_);
    }

    public void setDTDHandler(DTDHandler dtd) {
	dtd_ = dtd;
    }

    public DTDHandler getDTDHandler() {
	return (dtd_);
    }

    public void setContentHandler(ContentHandler content) {
	content_ = content;
    }

    public ContentHandler getContentHandler() {
	return (content_);
    }

    public void setErrorHandler(ErrorHandler error) {
	error_ = error;
    }

    public ErrorHandler getErrorHandler() {
	return (error_);
    }

    public InputSource resolveEntity(String publicId, String systemId)
	throws SAXException, IOException {

	return (resolver_.resolveEntity(publicId, systemId));
    }

    public void notationDecl(String name, String publicId, String systemId)
	throws SAXException {

	dtd_.notationDecl(name, publicId, systemId);
    }

    public void unparsedEntityDecl(
	String name,
	String publicId,
	String systemId,
	String notationName
    ) throws SAXException {
	dtd_.unparsedEntityDecl(name, publicId, systemId, notationName);
    }

    public void setDocumentLocator(Locator locator) {
	content_.setDocumentLocator(locator);
    }

    public void startDocument() throws SAXException {
	content_.startDocument();
    }

    public void endDocument() throws SAXException {
	content_.endDocument();
    }

    public void startPrefixMapping(String prefix, String uri) 
	throws SAXException {

	content_.startPrefixMapping(prefix, uri);
    }

    public void endPrefixMapping(String prefix) throws SAXException {
	content_.endPrefixMapping(prefix);
    }

    public void startElement(
	String uri,
	String localName,
	String qName,
	Attributes attributes
    ) throws SAXException {
	content_.startElement(uri, localName, qName, attributes);
    }

    public void endElement(String uri, String localName, String qName)
	throws SAXException {

	content_.endElement(uri, localName, qName);
    }

    public void characters(char ch[], int start, int length)
	throws SAXException {

	content_.characters(ch, start, length);
    }

    public void ignorableWhitespace(char ch[], int start, int length)
	throws SAXException {

	content_.ignorableWhitespace(ch, start, length);
    }

    public void processingInstruction(String target, String data)
	throws SAXException {

	content_.processingInstruction(target, data);
    }

    public void skippedEntity(String name) throws SAXException {
	content_.skippedEntity(name);
    }

    public void warning(SAXParseException e) throws SAXException {
	error_.warning(e);
    }

    public void error(SAXParseException e) throws SAXException {
	error_.error(e);
    }

    public void fatalError(SAXParseException e) throws SAXException {
	error_.fatalError(e);
    }
}
