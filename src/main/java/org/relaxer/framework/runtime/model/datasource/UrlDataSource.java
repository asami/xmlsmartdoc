package org.relaxer.framework.runtime.model.datasource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.xml.sax.InputSource;

/**
 * UrlDataSource
 *
 * @since   Aug. 13, 2005
 * @version Aug. 21, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class UrlDataSource extends AbstractRDataSource {
    private final URL url_;

    public UrlDataSource(URL url, IRModelContext context) {
        super(context);
        url_ = url;
    }

    public UrlDataSource(URL url, Params params, IRModelContext context) {
        super(context);
        url_ = url;
    }

    public static class Params extends AbstractRDataSource.Params {
    }

    protected InputSource _getInputSource() throws IOException {
        return new InputSource(url_.toExternalForm());
    }

    protected InputStream _openInputStream() throws IOException {
        return url_.openStream();
    }

    protected Reader _openReader() throws IOException {
        String encoding = getTextEncoding();
        return new InputStreamReader(openInputStream(), encoding);
    }
    
    protected URL _getURL() {
        return url_;
    }
}
