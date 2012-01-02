package org.relaxer.framework.runtime.model.context;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.SAXParser;

import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.framework.runtime.RContainerContext;
import org.relaxer.framework.runtime.messager.IRFrameworkMessager;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.reporter.IRFrameworkReporter;
import org.xml.sax.XMLReader;

/**
 * RModelContext
 *
 * @since   Aug.  2, 2005
 * @version Sep. 23, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RModelContext extends AbstractRModelContext {
    private final RContainerContext containerContext_;
    private DocumentBuilder builder_ = null;
    private SAXParser saxParser_ = null;
    private XMLReader xmlReader_ = null;
    private String textEncoding_ = null;
    private String newLine_ = null;

    public RModelContext(RContainerContext containerContext) {
        containerContext_ = containerContext;
    }

    public IRFrameworkLogger getLogger() {
        return containerContext_.getLogger();
    }

    public IRFrameworkMessager getMessager() {
        return containerContext_.getMessager();
    }

    public IRFrameworkReporter getReporter() {
        return containerContext_.getReporter();
    }

    public String getTextEncoding() {
        if (textEncoding_ != null) {
            return textEncoding_;
        }
        return containerContext_.getTextEncoding();
    }
    
    public String getNewLine() {
        if (newLine_ != null) {
            return newLine_;
        }
        return containerContext_.getNewLine();
    }
    
    public DocumentBuilder getDocumentBuilder() {
        if (builder_ != null) {
            return builder_;
        }
        return containerContext_.getDocumentBuilder();
    }

    public SAXParser getSAXParser() {
        if (saxParser_ != null) {
            return saxParser_;
        }
        return containerContext_.getSAXParser();
    }
    
    public XMLReader getXMLReader() {
        if (xmlReader_ != null) {
            return xmlReader_;
        }
        return containerContext_.getXMLReader();
    }

    public void openModel(IRModel model) {
        // XXX
    }

    public void commitModel(IRModel model) {
        // XXX
    }

    public void abortModel(IRModel model) {
        // XXX
    }

    public void closeModel(IRModel model) {
        // XXX
    }

    public void createModel(IRModel model) {
        // XXX
    }

    public void destroyModel(IRModel model) {
        // XXX
    }
    
    //
    public void setDocumentBuilder(DocumentBuilder builder) {
        builder_ = builder;
    }
    
    public void setTextEncoding(String encoding) {
        textEncoding_ = encoding;
    }

    public void setNewLine(String newLine) {
        newLine_ = newLine;
    }
}
