/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2005  ASAMI, Tomoharu (asami@relaxer.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package org.relaxer.framework.runtime.model.content;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;

import org.relaxer.framework.RelaxerFrameworkErrorException;
import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.datasource.IRDataSource;
import org.relaxer.framework.runtime.model.datasource.NullDataSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.AsamiOffice.io.UIO;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.xml.XmlChecker;
import com.AsamiOffice.xml.sax.DOMSAXProducer;

/**
 * AbstractContents
 *
 * @since   Oct.  1, 2003
 * @version Jan. 24, 2006
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRModelContent implements IRModelContent {
    private static final String CACHE_BINARY = "BINARY";
    private static final String CACHE_TEXT = "TEXT";
    private static final String CACHE_DOCUMENT = "DOCUMENT";
    protected final IRModelContext _context;
    protected final IRDataSource _dataSource;
//    protected IRModel _mountedModel = null;
    private Exception exception_ = null;
    private int openCount_ = 0;
/*
    transient private byte[] binary_ = null;
    transient private String text_ = null;
    transient private Document doc_ = null;
*/
    transient private XmlInfo xmlInfo_ = null;

    protected AbstractRModelContent(IRModelContext context) {
        this(NullDataSource.getDataSource(), context);
    }

    protected AbstractRModelContent(IRDataSource ds, IRModelContext context) {
        _context = context;
        _dataSource = ds;
    }

    public final boolean isBroken() {
        return exception_ == null;
    }

    public final Exception getException() {
        return exception_;
    }

    public final void open() throws RModelException {
        if (openCount_++ == 0) {
            _open();
        }
    }

    protected void _open() throws RModelException {
    }

    public final void close() throws RModelException {
        if (--openCount_ == 0) {
            _close();
            _context.clearCache(this);
/*
            binary_ = null;
            text_ = null;
            doc_ = null;
*/
        }
    }

    protected void _close() throws RModelException {
    }

    public final InputStream openInputStream() throws RModelException {
        byte[] binary = (byte[])_context.getCache(this, CACHE_BINARY); 
        if (binary != null) {
            return new ByteArrayInputStream(binary);
        }
        InputStream in = _openInputStream();
        if (in != null) {
            return in;
        }
        try {
            return _dataSource.openInputStream();
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    protected InputStream _openInputStream() throws RModelException {
        return null;
    }

    /*
    public InputStream getInputStream(String encoding) throws RModelException {
        return (getInputStream());
    }
*/
    public final long getHintSize() {
        long size = _getSize();
        if (size >= 0) {
            return size;
        }
        return -1;
    }

    public final long getSize() throws RModelException {
        long size = _getSize();
        if (size >= 0) {
            return size;
        }
        byte[] binary = ensureBinary_();
        return binary.length;
    }

    protected long _getSize() {
        return -1;
    }

    public final byte[] getBinary() throws RModelException {
        return ensureBinary_();
    }
    
    private byte[] ensureBinary_() throws RModelException {
        byte[] binary = getBinaryCache_();
        if (binary != null) {
            return binary;
        }
        binary = _getBinary();
        if (binary != null) {
            addBinaryCache_(binary);
            return binary;
        }
        InputStream in = null;
        try {
            in = openInputStream();
            binary = UIO.stream2Bytes(in);
            addBinaryCache_(binary);
            return binary;
        } catch (IOException e) {
            throw (new RModelException(e));
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private void addBinaryCache_(byte[] binary) {
        _context.addCache(this, CACHE_BINARY, binary);
    }

    private byte[] getBinaryCache_() {
        return (byte[])_context.getCache(this, CACHE_BINARY);
    }

/*
    public byte[] getBinary(String encoding) throws RModelException {
        InputStream in = null;
        try {
            in = getInputStream(encoding);
            return (UIO.stream2Bytes(in));
        } catch (UnsupportedEncodingException e) {
            throw (new RModelException(e));
        } catch (IOException e) {
            throw (new RModelException(e));
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }
*/

    protected byte[] _getBinary() throws RModelException {
        return null;
    }

    public final Reader openReader() throws RModelException {
        try {
            return _dataSource.openReader();
        } catch (IOException e) {
            throw (new RModelException(e));
        }
/*
        try {
            return (new InputStreamReader(getInputStream(), _encoding));
        } catch (UnsupportedEncodingException e) {
            throw (new RModelException(e));
        }
*/
    }

    public final void writeBinary(OutputStream out) throws RModelException {
        byte[] binary = getBinaryCache_();
        if (binary != null) {
            writeBinary_(out, binary);
        } else {
            writeInputStream_(out);
        }
    }

    private void writeBinary_(OutputStream out, byte[] binary) throws RModelException {
        try {
            out.write(binary);
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

    private void writeInputStream_(OutputStream out) throws RModelException {
        InputStream in = null;
        byte[] buffer = new byte[8192];
        try {
            in = openInputStream();
            for(;;) {
                int size = in.read(buffer);
                if (size <= 0) {
                    break;
                }
                out.write(buffer, 0, size);
            }
        } catch (IOException e) {
            throw new RModelException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public final boolean isText() {
        Boolean isText = _isText();
        if (isText != null) {
            return isText.booleanValue();
        }
        try {
            if (_context.isTextSuffix(_dataSource.getSuffix())) {
                return true;
            }
            if (_context.isTextContent(this));
            return true;
        } catch (RModelException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    protected Boolean _isText() {
        return null;
    }

    public final String getText() throws RModelException {
        return ensureText_();
/*        
        InputStream in = null;
        try {
            in = getInputStream();
            return (UIO.stream2String(in, data_encoding));
        } catch (UnsupportedEncodingException e) {
            throw (new RModelException(e));
        } catch (IOException e) {
            throw (new RModelException(e));
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
*/
    }

    private String ensureText_() throws RModelException {
        String text = getTextCache_();
        if (text != null) {
            return text;
        }
        text = _getText();
        if (text != null) {
            addTextCache_(text);
            return text;
        }
        Reader reader = null;
        try {
            reader = openReader();
            text = UString.makeStringFromReader(reader);
            addTextCache_(text);
            return text;
        } catch (IOException e) {
            throw new RModelException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private void addTextCache_(String text) {
        _context.addCache(this, CACHE_TEXT, text);
    }

    private String getTextCache_() {
        return (String)_context.getCache(this, CACHE_TEXT);
    }

    protected String _getText() throws RModelException {
        return null;
    }

    public final void writeText(Writer writer) throws RModelException {
        // XXX
        throw new RelaxerFrameworkErrorException();
    }

    public final boolean isXml() {
        Boolean isXml = _isXml();
        if (isXml != null) {
            return isXml.booleanValue();
        }
        try {
            String suffix = _dataSource.getSuffix();
            if (_context.isXmlSuffix(suffix)) {
                return true;
            }
            if (_context.maybeXmlSuffix(suffix)) {
                ensureXml_();
                if (xmlInfo_ != null) {
                    return true;
                }
            }
            return false;
        } catch (RModelException e) {
            exception_ = e;
            return false;
        } catch (IOException e) {
            exception_ = e;
            return false;
        }
    }

    protected Boolean _isXml() {
        return null;
    }

/*
    public Document getDocument() throws RModelException {
        DocumentBuilder builder = _context.getDocumentBuilder();
        try {
            return builder.parse(getInputStream());
        } catch (SAXException e) {
            throw new RModelException(e);
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }
*/

    public Document getDocument() throws RModelException {
        return ensureDocument_();
    }

    private Document ensureDocument_() throws RModelException {
        Document doc = getDocumentCache_();
        if (doc != null) {
            return doc;
        }
        DocumentBuilder builder = _context.getDocumentBuilder();
        try {
            doc = builder.parse(_dataSource.getInputSource());
            addDocumentCache_(doc);
            return doc;
        } catch (SAXException e) {
            exception_ = e;
            throw new RModelException(e);
        } catch (IOException e) {
            exception_ = e;
            throw new RModelException(e);
        }
    }

    private void addDocumentCache_(Document doc) {
        _context.addCache(this, CACHE_DOCUMENT, doc);
    }

    private Document getDocumentCache_() {
        return (Document)_context.getCache(this, CACHE_DOCUMENT);
    }

    private void ensureXml_() throws RModelException {
        if (xmlInfo_ != null) {
            return;
        }
        Document doc = getDocumentCache_();
        if (doc != null) {
            Element root = doc.getDocumentElement();
            xmlInfo_ = new XmlInfo();
            xmlInfo_.rootNamespace = root.getNamespaceURI();
            xmlInfo_.rootLocalName = root.getLocalName();
            xmlInfo_.rootQName = root.getTagName();
        }
        XmlChecker checker = new XmlChecker(_context.getXMLReader());
        try {
            if (checker.check(getDataSource().getInputSource())) {
                xmlInfo_ = new XmlInfo();
                xmlInfo_.rootNamespace = checker.getNamespace();
                xmlInfo_.rootLocalName = checker.getLocalName();
                xmlInfo_.rootQName = checker.getQName();
            } else {
                throw new RModelException("invaild xml");
            }
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }


/*
    public Document getDocument() throws RModelException {
        InputStream in = null;
        try {
            in = getInputStream();
            // TODO Use context
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return (builder.parse(in));
        } catch (IOException e) {
            throw (new RModelException(e));
        } catch (ParserConfigurationException e) {
            throw (new RModelException(e));
		} catch (SAXException e) {
            throw (new RModelException(e));
		} finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }
*/

    public final void parse(ContentHandler handler) throws RModelException {
        Document doc = getDocumentCache_();
        try {
            if (doc != null) { // TODO publicId, systemId
                DOMSAXProducer producer = new DOMSAXProducer(doc);
                producer.makeEvent(handler);
            } else {
                IRDataSource ds = getDataSource();
                ds.parse(handler);
            }
        } catch (IOException e) {
            throw new RModelException(e);
        } catch (SAXException e) {
            throw new RModelException(e);
        }
    }

    public final void parse(DefaultHandler handler) throws RModelException {
        Document doc = getDocumentCache_();
        try {
            if (doc != null) { // TODO publicId, systemId
                DOMSAXProducer producer = new DOMSAXProducer(doc);
                producer.setContentHandler(handler);
                producer.setDTDHandler(handler);
                producer.setEntityResolver(handler);
                producer.setErrorHandler(handler);
                producer.makeEvent(handler);
            } else {
                IRDataSource ds = getDataSource();
                ds.parse(handler);
            }
        } catch (IOException e) {
            throw new RModelException(e);
        } catch (SAXException e) {
            throw new RModelException(e);
        }
    }

    public String getRootNamespace() throws RModelException {
        ensureXml_();
        return xmlInfo_.rootNamespace;
    }

    public String getRootLocalName() throws RModelException {
        ensureXml_();
        return xmlInfo_.rootLocalName;
    }

    //
    public final boolean isSame(IRModelContent content) throws RModelException {
        if (content instanceof AbstractRModelContent) {
            AbstractRModelContent buddy = (AbstractRModelContent)content;
            long lhsSize = getHintSize();
            long rhsSize = buddy.getHintSize();
            if (lhsSize != -1 && rhsSize != -1) {
                if (lhsSize != rhsSize) {
                    return (false);
                }
            }
        }
        InputStream lhs = null;
        InputStream rhs = null;
        try {
            lhs = openInputStream();        
            rhs = content.openInputStream();
            byte[] lhsBuffer = new byte[8192];
            byte[] rhsBuffer = new byte[8192];
            for (;;) {
                int lhsSize = lhs.read(lhsBuffer);
                int rhsSize = rhs.read(rhsBuffer);
                if (lhsSize != rhsSize) {
                    return (false);
                }
                if (lhsSize == -1) {
                    return (true);
                }
                for (int i = 0;i < lhsSize;i++) {
                    if (lhsBuffer[i] != rhsBuffer[i]) {
                        return (false);
                    }
                }
            }
        } catch (IOException e) {
            throw (new RModelException(e));
        } finally {
            if (rhs != null) {
                try {
                    rhs.close();
                } catch (IOException e1) {
                }
            }
            if (lhs != null) {
                try {
                    lhs.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public IRDataSource getDataSource() throws RModelException {
        return _dataSource;
    }

    public String getSuffix() throws RModelException {
        try {
            return _dataSource.getSuffix();
        } catch (IOException e) {
            throw new RModelException(e);
        }
    }

/*
    public void mount() throws RModelException {
        if (_mountedModel != null) {
            return;
        }
    }

    public boolean isMounted() throws RModelException {
        return _mountedModel != null;
    }

    public boolean isModel() {
        if (_mountedModel == null) {
            return false;
        }
        return true;
    }

    public IRModel getModel() throws RModelException {
        return _mountedModel;
    }
*/
    static class XmlInfo {
        String rootNamespace;
        String rootLocalName;
        String rootQName;
    }
}
