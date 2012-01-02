package org.relaxer.framework.runtime.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * XmlModelMatcher
 *
 * @since   Aug. 18, 2005
 * @version Aug. 18, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class XmlModelMatcher implements ContentHandler {
    private boolean isRootMatch_ = false;
    private Set existsRequiredElements_ = new HashSet();
    private boolean isRequiredElementsMatch_ = false;
    //
    private MatcherElement root_ = null;
    // List<Matcherelement>
    private List requiredElements_ = new ArrayList();
    private int nRequireElements_;
    //
    private boolean beforeRoot_ = true;

    public static class MatcherElement {
        public final String ns;
        public final String name;

        public MatcherElement(String ns, String name) {
            this.ns = ns;
            this.name = name;
        }

        public boolean isMatch(String uri, String localName, String qName, Attributes atts) {
            if (this.ns != null) {
                if (uri == null) {
                    uri = "";
                }
                if (!this.ns.equals(uri)) {
                    return false;
                }
            }
            if (this.name != null) {
                if (!this.name.equals(localName)) {
                    return false;
                }
            }
            return true;
        }
    }

    public XmlModelMatcher() {
    }

    public void setRootElement(String ns, String name) {
        root_ = new MatcherElement(ns, name);
    }

    public void addRequiredElement(String ns, String name) {
        requiredElements_.add(new MatcherElement(ns, name));
    }

    public boolean isMatch() {
        return isRootMatch_ & (requiredElements_.size() == existsRequiredElements_.size()); 
    }

    //
    public void setDocumentLocator(Locator locator) {
    }

    public void startDocument() throws SAXException {
        nRequireElements_ = requiredElements_.size();
    }

    public void endDocument() throws SAXException {
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    public void endPrefixMapping(String prefix) throws SAXException {
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (beforeRoot_) {
            if (root_ != null) {
                isRootMatch_ = root_.isMatch(uri, localName, qName, atts);
            } else {
                isRootMatch_ = root_.isMatch(uri, localName, qName, atts);
            }
            beforeRoot_ = false;
        }
        if (!isRequiredElementsMatch_) {
            Object[] elements = requiredElements_.toArray();
            for (int i = 0;i < elements.length;i++) {
                MatcherElement element = (MatcherElement)elements[i];
                if (element.isMatch(uri, localName, qName, atts)) {
                    existsRequiredElements_.add(element);
                }
            }
            if (nRequireElements_ == existsRequiredElements_.size()) {
                isRequiredElementsMatch_ = true;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
    }

    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    public void processingInstruction(String target, String data) throws SAXException {
    }

    public void skippedEntity(String name) throws SAXException {
    }
}
