package org.relaxer.framework.runtime.models.html;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * HtmlTableBuilder
 *
 * @since   Sep.  3, 2005
 * @version Sep. 14, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class HtmlTableBuilder extends DefaultHandler {
    private final List tables_ = new ArrayList();
    private HtmlTable current_ = null;

    public void startDocument() throws SAXException {
    }

    public void endDocument() throws SAXException {
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    public void endPrefixMapping(String prefix) throws SAXException {
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        localName = getLocalName_(localName, qName);
        if (isTagTable_(uri, localName)) {
            current_ = new HtmlTable();
        } else if (current_ != null) {
            if (isTagTHead_(uri, localName)) {
                current_.enterHead();
            } else if (isTagTFoot_(uri, localName)) {
                current_.enterFoot();
            } else if (isTagTBody_(uri, localName)) {
                current_.enterBody();
            } else if (isTagTr_(uri, localName)) {
                current_.enterRecord();
            } else if (isTagTh_(uri, localName)) {
                current_.enterHeader();
            } else if (isTagTd_(uri, localName)) {
                current_.enterData();
            }
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        localName = getLocalName_(localName, qName);
        if (isTagTable_(uri, localName)) {
            current_.end();
            tables_.add(current_);
            current_ = null;
        } else if (isTagTHead_(uri, localName)) {
            current_.leaveHead();
        } else if (isTagTFoot_(uri, localName)) {
            current_.leaveFoot();
        } else if (isTagTBody_(uri, localName)) {
            current_.leaveBody();
        } else if (isTagTr_(uri, localName)) {
            current_.leaveRecord();
        } else if (isTagTh_(uri, localName)) {
            current_.leaveHeader();
        } else if (isTagTd_(uri, localName)) {
            current_.leaveData();
        }
    }

    private boolean isTagTable_(String uri, String localName) {
        return "table".equals(localName);
    }

    private boolean isTagTHead_(String uri, String localName) {
        return "thead".equals(localName);
    }

    private boolean isTagTFoot_(String uri, String localName) {
        return "tfoot".equals(localName);
    }

    private boolean isTagTBody_(String uri, String localName) {
        return "tbody".equals(localName);
    }

    private boolean isTagTr_(String uri, String localName) {
        return "tr".equals(localName);
    }

    private boolean isTagTh_(String uri, String localName) {
        return "th".equals(localName);
    }

    private boolean isTagTd_(String uri, String localName) {
        return "td".equals(localName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (current_ != null) {
            current_.addText(ch, start, length);
        }
    }

    private String getLocalName_(String localName, String qName) {
        String name = localName;
        if (name == null) {
            name = qName;
        }
        return name.toLowerCase();
    }

    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    public HtmlTable getHtmlTable() {
        return (HtmlTable)tables_.get(0);
    }
}
