package org.relaxer.framework.runtime.model.datasource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import org.relaxer.framework.runtime.model.context.IRModelContext;


/**
 * StringDataSource
 *
 * @since   Aug. 12, 2005
 * @version Aug. 16, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class StringDataSource extends AbstractRDataSource {
    private final String string_;
    transient private byte[] bytes_ = null;

    public StringDataSource(String string, IRModelContext context) {
        super(context);
        string_ = string;
    }

    protected boolean _isExist() throws IOException {
        return true;
    }

    protected InputStream _openInputStream() throws IOException {
        if (bytes_ == null) {
            bytes_  = string_.getBytes(_context.getTextEncoding());
        }
        return new ByteArrayInputStream(bytes_);
    }

    protected Reader _openReader() throws IOException {
        return new StringReader(string_);
    }
}
