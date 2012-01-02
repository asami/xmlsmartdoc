package org.relaxer.framework.xexpr;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.NamespaceSupport;

/**
 * XExprMakerContentHandler
 *
 * @since   Sep. 17, 2005
 * @version Sep. 20, 2005
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class XExprMakerContentHandler implements ContentHandler {
    private final NamespaceSupport context_;
    private Writer writer_;
    private StringBuffer buffer_;

    public XExprMakerContentHandler() {
        context_ = new NamespaceSupport();
        writer_ = new CharArrayWriter();
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void startDocument() throws SAXException {
    }

    public void endDocument() throws SAXException {
    }

    public void startPrefixMapping(String prefix, String uri)
            throws SAXException {
        context_.pushContext();
        context_.declarePrefix(prefix, uri);
    }

    public void endPrefixMapping(String prefix) throws SAXException {
        context_.popContext();
    }

    public void startElement(String uri, String localName, String qName,
            Attributes atts) throws SAXException {
        try {
            append_(" (");
            append_(qName);
            int nAttrs = atts.getLength(); 
            if (nAttrs > 0) {
                append_(" (");
                for (int i = 0;i < nAttrs;i++) {
                    append_('(');
                    append_(atts.getQName(i));
                    append_('.');
                    append_('"');
                    append_(atts.getValue(i));
                    append_('"');
                    append_(')');
                }
                append_(")");
            }
        } catch (IOException e) {
            throw new SAXException(e);
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        try {
            if (buffer_ != null) {
                append_(" \"");
                append_(buffer_.toString());
                append_('"');
                buffer_ = null;
            }
            append_(')');
        } catch (IOException e) {
            throw new SAXException(e);
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (buffer_ == null) {
            buffer_ = new StringBuffer();
        }
        buffer_.append(ch, start, length);
    }

    public void ignorableWhitespace(char[] ch, int start, int length)
            throws SAXException {
    }

    public void processingInstruction(String target, String data)
            throws SAXException {
    }

    public void skippedEntity(String name) throws SAXException {
    }

    private void append_(int c) throws IOException {
        writer_.write(c);
    }
    
    private void append_(String string) throws IOException {
        writer_.write(string);
    }

    public String getText() {
        return writer_.toString();
    }
}
