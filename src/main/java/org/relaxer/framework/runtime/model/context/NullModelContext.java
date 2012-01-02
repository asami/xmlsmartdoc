package org.relaxer.framework.runtime.model.context;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.SAXParser;

import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.framework.logger.NullLogger;
import org.relaxer.framework.runtime.messager.IRFrameworkMessager;
import org.relaxer.framework.runtime.messager.NullMessager;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.IRModelNode;
import org.relaxer.framework.runtime.reporter.IRFrameworkReporter;
import org.relaxer.framework.runtime.reporter.NullReporter;
import org.xml.sax.XMLReader;

/**
 * NullModelContext
 *
 * @since   Aug.  9, 2005
 * @version Sep. 23, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class NullModelContext extends AbstractRModelContext {
    private NullModelContext() {
    }

    public String getTextEncoding() {
        return "UTF-8";
    }

    public String getNewLine() {
        return "\n";
    }

    public IRFrameworkLogger getLogger() {
        return new NullLogger();
    }

    public IRFrameworkMessager getMessager() {
        return new NullMessager();
    }

    public IRFrameworkReporter getReporter() {
        return new NullReporter();
    }

    public IRModel mount(IRModelNode node) {
        return null;
    }

    public DocumentBuilder getDocumentBuilder() {
        return null; // TODO
    }

    public SAXParser getSAXParser() {
        return null;
    }

    public XMLReader getXMLReader() {
        return null; // TODO
    }

    public void openModel(IRModel model) {
    }

    public void commitModel(IRModel model) {
    }

    public void abortModel(IRModel model) {
    }

    public void closeModel(IRModel model) {
    }

    public void createModel(IRModel model) {
    }

    public void destroyModel(IRModel model) {
    }

    //
    private static IRModelContext shared__;

    public static IRModelContext getContext() {
        if (shared__ == null) {
            shared__ = new NullModelContext();
        }
        return shared__;
    }
}
