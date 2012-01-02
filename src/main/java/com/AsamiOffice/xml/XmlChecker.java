package com.AsamiOffice.xml;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.AsamiOffice.xml.sax.StopErrorHandler;

/**
 * XmlChecker
 *
 * @since   Sep. 15, 2005
 * @version Sep. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class XmlChecker {
    private final XMLReader reader_;
    private String uri_;
    private String localName_;
    private String qName_;

    public XmlChecker(XMLReader reader) {
        reader_ = reader;
        reader_.setErrorHandler(new StopErrorHandler());
    }

    public boolean check(InputSource inputSource) {
        reader_.setContentHandler(new FirstElementContentHandler());
        try {
            reader_.parse(inputSource);
        } catch (StopSignal e) {
            return true;
        } catch (IOException e) {
            return false;
        } catch (SAXException e) {
            return false;
        }
        return false;
    }

    public final String getQName() {
        return qName_;
    }

    public final String getLocalName() {
        return localName_;
    }

    public final String getNamespace() {
        return uri_;
    }
    
    class FirstElementContentHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            uri_ = uri;
            localName_ = localName;
            qName_ = qName;
            throw new StopSignal();
        }
    }

    static class StopSignal extends SAXException {
        private static final long serialVersionUID = 4927404505321916158L;
    }
}
