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
 * IRModelContext
 *
 * @since   Aug.  2, 2005
 * @version Sep. 23, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRModelContext {
    IRFrameworkLogger getLogger();
    IRFrameworkMessager getMessager();
    IRFrameworkReporter getReporter();
    String getTextEncoding();
    String getNewLine();
    DocumentBuilder getDocumentBuilder();
    SAXParser getSAXParser();
    XMLReader getXMLReader();
    //
    boolean isTextSuffix(String suffix);
    boolean isTextContent(IRModelContent content);
    boolean isXmlSuffix(String suffix);
    boolean maybeXmlSuffix(String suffix);
    boolean isXmlContent(IRModelContent content);
    //
    IRModel mount(IRModelNode content) throws RModelException;
// candidate:    IRModel mount(IRModelContent content, IRModelContext context) throws RModelException;
    // Lifycycle
    void openModel(IRModel model); // XXX
    void commitModel(IRModel model);
    void abortModel(IRModel model);
    void closeModel(IRModel model);
    void createModel(IRModel model);
    void destroyModel(IRModel model);
    //
    Object getCache(Object owner, String usage);
    void addCache(Object owner, String usage, Object data);
    void clearCache(Object owner);
    //
    void commit();
    void abort();
    //
    void dispose();
}
