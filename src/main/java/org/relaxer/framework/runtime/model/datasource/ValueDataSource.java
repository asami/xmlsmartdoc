package org.relaxer.framework.runtime.model.datasource;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.relaxer.framework.runtime.model.content.IRModelContent;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.xml.sax.InputSource;

/**
 * ValueDataSource
 *
 * @since   Aug. 13, 2005
 * @version Aug. 16, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ValueDataSource extends AbstractRDataSource {
    public ValueDataSource(IRModelContent content, IRModelContext context) {
        super(context);
        // XXX : content...
    }

    protected boolean _isExist() throws IOException {
        return true;
    }

    public InputSource _getInputSource() throws IOException {
        throw new UnsupportedOperationException();
    }

    public Reader _getReader() throws IOException {
        throw new UnsupportedOperationException();
    }

    public InputStream _getInputStream() throws IOException {
        throw new UnsupportedOperationException();
    }
}
