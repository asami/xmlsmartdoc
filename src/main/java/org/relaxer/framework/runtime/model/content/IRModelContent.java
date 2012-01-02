/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.runtime.model.content;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;
import org.w3c.dom.Document;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;

/**
 * IRModelContent
 *
 * @since   Oct.  1, 2003
 * @version Sep. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRModelContent {
    boolean isBroken();
    Exception getException();
    //
    void open() throws RModelException;
    void close() throws RModelException;
    //
    boolean isSame(IRModelContent content) throws RModelException;
    // value
    boolean isValue();
    Object getValue();
    // binary
    boolean isBinary();

    /**
     * Gets a hint of the content size.
     * 
     * @return content size or -1. 
     * -1 means content does not have a lightweight way to get the content size. 
     */
    long getHintSize();

    /**
     * Gets a content size.
     * The getSize method may be heavyweight 
     * because the method may load the entire contents into memory 
     * to get the content size.
     * 
     * @return content size;
     * @throws RModelException
     */
    long getSize() throws RModelException;
    InputStream openInputStream() throws RModelException;
//    InputStream getInputStream(String encoding) throws RModelException;
    byte[] getBinary() throws RModelException;
//    byte[] getBinary(String encoding) throws RModelException;

    /**
     * The writeBinary methods does not close the OutputStream out.
     * 
     * @param out
     * @throws RModelException
     */
    void writeBinary(OutputStream out) throws RModelException;

    // text
    boolean isText();
    Reader openReader() throws RModelException;
    String getText() throws RModelException;

    /**
     * The writeText method does not close the Writer writer.
     * 
     * @param writer
     * @throws RModelException
     */
    void writeText(Writer writer) throws RModelException;

    // XML
    boolean isXml();
    Document getDocument() throws RModelException;
    void parse(ContentHandler handler) throws RModelException;
    void parse(DefaultHandler handler) throws RModelException;
    String getRootNamespace() throws RModelException;
    String getRootLocalName() throws RModelException;
    // Source
    Object getSource();
    // DataSource
    IRDataSource getDataSource() throws RModelException;
    String getSuffix() throws RModelException;
}
