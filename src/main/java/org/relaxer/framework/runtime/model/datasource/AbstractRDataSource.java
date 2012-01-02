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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.SAXParser;

import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.w3c.dom.Document;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.AsamiOffice.io.UURL;


/**
 * AbstractRDataSource
 *
 * @since   Aug. 12, 2005
 * @version Aug. 20, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRDataSource implements IRDataSource {
    protected final IRModelContext _context;
    protected final String _encoding; 

    protected AbstractRDataSource(IRModelContext context) {
        _context = context;
        _encoding = null;
    }

    protected AbstractRDataSource(Params params, IRModelContext context) {
        _context = context;
        _encoding = params.encoding;
    }

    public static class Params {
        public String encoding;
    }

    public final String getSuffix() throws IOException {
        return _getSuffix();
    }

    protected String _getSuffix() {
        return null;
    }

    public final String getTextEncoding() {
        String encoding = _getTextEncoding();
        if (encoding != null) {
            return encoding;
        }
        if (_encoding != null) {
            return _encoding;
        }
        encoding = _context.getTextEncoding();
        if (encoding != null) {
            return encoding;
        }
        return ("UTF-8");
    }

    protected String _getTextEncoding() {
        return null;
    }

    public final boolean isExist() throws IOException {
        return _isExist();
    }

    protected boolean _isExist() throws IOException {
        InputStream in = null;
        try {
            in = openInputStream();
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public final void create() throws IOException {
        _create();
    }

    protected void _create() throws IOException {
        throw new IOException("XXX");
    }

    public final InputStream openInputStream() throws IOException {
        return _openInputStream();
    }

    protected InputStream _openInputStream() throws IOException {
        return null;
    }

    public final OutputStream openOutputStream() throws IOException {
        return _openOutputStream();
    }

    protected OutputStream _openOutputStream() throws IOException {
        return null;
    }

    public final Reader openReader() throws IOException {
        return _openReader();
    }

    protected Reader _openReader() throws IOException {
        return null;
    }

    public final Writer openWriter() throws IOException {
        return _openWriter();
    }

    protected Writer _openWriter() throws IOException {
        return null;
    }

    public final BufferedInputStream openBufferedInputStream() throws IOException {
        InputStream in = null;
        try {
            in = openInputStream();
            return new BufferedInputStream(in);
        } catch (IOException e) {
            if (in != null) {
                in.close();
            }
            throw e;
        }
    }

    public final BufferedOutputStream openBufferedOutputStream() throws IOException {
        OutputStream out = null;
        try {
            out = openOutputStream();
            return new BufferedOutputStream(out);
        } catch (IOException e) {
            if (out != null) {
                out.close();
            }
            throw e;
        }
    }

    public final BufferedReader openBufferedReader() throws IOException {
        Reader in = null;
        try {
            in = openReader();
            return new BufferedReader(in);
        } catch (IOException e) {
            if (in != null) {
                in.close();
            }
            throw e;
        }
    }

    public final BufferedWriter openBufferedWriter() throws IOException {
        Writer out = null;
        try {
            out = openWriter();
            return new BufferedWriter(out);
        } catch (IOException e) {
            if (out != null) {
                out.close();
            }
            throw e;
        }
    }

    public final InputSource getInputSource() throws IOException {
        InputSource is = _getInputSource();
        if (is != null) {
            return is;
        }
        return new InputSource(openInputStream());
    }

    protected InputSource _getInputSource() throws IOException {
        return null;
    }

    public final File getFile() throws IOException {
        File file = _getFile();
        if (file == null) {
            URL url = _getURL();
            if (url != null) {
                file = UURL.getActiveFile(url);
            }
        }
        return file;
    }

    protected File _getFile() {
        return null;
    }

    public final URL getURL() throws IOException {
        URL url = _getURL();
        if (url == null) {
            File file = _getFile();
            if (file != null) {
                return file.toURL();
            }
        }
        return url;
    }

    protected URL _getURL() {
        return null;
    }

    public final Document getDocument() throws SAXException, IOException {
        DocumentBuilder builder = _context.getDocumentBuilder();
        return builder.parse(getInputSource());
    }

    public void parse(ContentHandler handler) throws IOException, SAXException {
        XMLReader xmlReader = _context.getXMLReader();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(getInputSource());
    }

    public void parse(DefaultHandler handler) throws IOException, SAXException {
        SAXParser saxParser = _context.getSAXParser();
        saxParser.parse(getInputSource(), handler);
    }
}
