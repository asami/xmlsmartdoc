package org.relaxer.framework.auth.rAccount;

import java.util.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import org.w3c.dom.*;

/**
 * RDomBuilder (SAX2/DOM2)
 *
 * @since   Sep.  1, 2003
 * @version Sep.  1, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RDomBuilder extends DefaultHandler {
    private Document doc_;
    private Element element_;
    private Stack stack_ = new Stack();
    private StringBuffer buffer_;
    private int depth_;

    public RDomBuilder(Element element) {
        doc_ = element.getOwnerDocument();
        element_ = element;
    }

    public void startDocument() {
        buffer_ = new StringBuffer();
        depth_ = 0;
    }

    public void endDocument() {
        _makeString();
    }

    public void startElement(
        String uri,
        String localName,
        String qName,
        Attributes atts
    ) {
        if (depth_++ == 0) {
            return;
        }
        _makeString();
        Element parent = element_;
        Element child = doc_.createElementNS(uri, qName);
        int size = atts.getLength();
        for (int i = 0;i < size;i++) {
            String attrUri = atts.getURI(i);
            if (attrUri != null) {
                child.setAttributeNS(
                    attrUri,
                    atts.getQName(i),
                    atts.getValue(i)
                );
            } else {
                child.setAttribute(atts.getQName(i), atts.getValue(i));
            }
        }
        parent.appendChild(child);
        stack_.push(parent);
        element_ = child;
    }

    public void endElement(
        String uri,
        String localName,
        String qName
    ) {
        if (--depth_ > 0) {
            _makeString();
            element_ = (Element)stack_.pop();
        }
    }

    public void characters(char ch[], int start, int length) {
        if (buffer_ != null) {
            buffer_.append(ch, start, length);
        }
    }

    private void _makeString() {
        if (buffer_ != null && buffer_.length() > 0) {
            element_.appendChild(
                doc_.createTextNode(new String(buffer_))
            );
        }
        buffer_ = new StringBuffer();
    }

    public void warning(SAXParseException e) {
        e.printStackTrace();
    }

    public void error(SAXParseException e) {
        e.printStackTrace();
    }

    public void fatalError(SAXParseException e) {
        e.printStackTrace();
    }
}
