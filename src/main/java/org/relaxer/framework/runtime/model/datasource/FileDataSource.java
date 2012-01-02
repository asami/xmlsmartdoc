package org.relaxer.framework.runtime.model.datasource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.xml.sax.InputSource;

import com.AsamiOffice.text.UString;

/**
 * FileDataSource
 *
 * @since   Aug. 12, 2005
 * @version Aug. 21, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FileDataSource extends AbstractRDataSource {
    private final File file_;

    public FileDataSource(File file, IRModelContext context) {
        super(context);
        file_ = file;
    }

    protected boolean _isExist() throws IOException {
        return file_.exists();
    }

    protected InputSource _getInputSource() {
        return new InputSource(file_.getAbsolutePath());
    }

    protected void _create() throws IOException {
        file_.createNewFile();
    }

    protected InputStream _openInputStream() throws IOException {
        return new FileInputStream(file_);
    }

    protected OutputStream _openOutputStream() throws IOException {
        return new FileOutputStream(file_);
    }

    protected Reader _openReader() throws IOException {
        InputStream in = null;
        try {
            in = new FileInputStream(file_);
            return new InputStreamReader(in, getTextEncoding());
        } catch (IOException e) {
            if (in != null) {
                in.close();
            }
            throw e;
        }
    }

    protected Writer _openWriter() throws IOException {
        OutputStream out = null;
        try {
            out = new FileOutputStream(file_);
            return new OutputStreamWriter(out, getTextEncoding());
        } catch (IOException e) {
            if (out != null) {
                out.close();
            }
            throw e;
        }
    }

    protected String _getSuffix() {
        return UString.getSuffix(file_.toString());
    }

    protected File _getFile() {
        return file_;
    }
}
