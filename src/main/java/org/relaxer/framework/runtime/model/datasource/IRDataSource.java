package org.relaxer.framework.runtime.model.datasource;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

import org.w3c.dom.Document;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * IRDataSource
 *
 * @since   Aug. 12, 2005
 * @version Aug. 20, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRDataSource {
    boolean isExist() throws IOException;
    void create() throws IOException;
    InputStream openInputStream() throws IOException;
    OutputStream openOutputStream() throws IOException;
    Reader openReader() throws IOException;
    Writer openWriter() throws IOException;
    //
    BufferedInputStream openBufferedInputStream() throws IOException;
    BufferedOutputStream openBufferedOutputStream() throws IOException;
    BufferedReader openBufferedReader() throws IOException;
    BufferedWriter openBufferedWriter() throws IOException;
    //
    InputSource getInputSource() throws IOException;
    File getFile() throws IOException;
    URL getURL() throws IOException;
    Document getDocument() throws SAXException, IOException;
    void parse(ContentHandler handler) throws IOException, SAXException;
    void parse(DefaultHandler handler) throws IOException, SAXException;
    //
    String getTextEncoding();
    String getSuffix() throws IOException;
}
