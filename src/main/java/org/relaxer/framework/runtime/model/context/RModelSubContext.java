package org.relaxer.framework.runtime.model.context;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.SAXParser;

import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.framework.runtime.messager.IRFrameworkMessager;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.reporter.IRFrameworkReporter;
import org.xml.sax.XMLReader;

/**
 * RModelSubContext
 *
 * @since   Aug.  3, 2005
 * @version Sep. 23, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RModelSubContext extends AbstractRModelContext {
    private final IRModelContext _parent;
    private String textEncoding_ = null;
    private String newLine_ = null;
    private DocumentBuilder builder_ = null;
    private SAXParser saxParser_ = null;
    private XMLReader xmlReader_ = null;

    public RModelSubContext(IRModelContext context) {
        _parent = context;
    }

    public IRFrameworkLogger getLogger() {
        return _parent.getLogger();
    }

    public IRFrameworkMessager getMessager() {
        return _parent.getMessager();
    }

    public IRFrameworkReporter getReporter() {
        return _parent.getReporter();
    }

    public String getTextEncoding() {
        if (textEncoding_ != null) {
            return textEncoding_;
        }
        return _parent.getTextEncoding();
    }

    public String getNewLine() {
        if (newLine_ != null) {
            return newLine_;
        }
        return _parent.getNewLine();
    }

    public DocumentBuilder getDocumentBuilder() {
        if (builder_ != null) {
            return builder_;
        }
        return _parent.getDocumentBuilder();
    }

    public SAXParser getSAXParser() {
        if (saxParser_ != null) {
            return saxParser_;
        }
        return _parent.getSAXParser();
    }

    public XMLReader getXMLReader() {
        if (xmlReader_ != null) {
            return xmlReader_;
        }
        return _parent.getXMLReader();
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

    public IRModel mount(IRModelNode node, IRModelContent content) throws RModelException {
        IRModel model = _parent.mount(node);
        if (model != null) {
            return model;
        }
        return super.mount(node);
    }

    public void setTextEncoding(String encoding) {
        textEncoding_ = encoding;
    }

    public void setNewLine(String newLine) {
        newLine_  = newLine;
    }
    
    public final void setDocumentBuilder(DocumentBuilder builder) {
        builder_ = builder;
    }
    
    public final void setXMLReader(XMLReader parser) {
        xmlReader_ = parser;
    }
}
