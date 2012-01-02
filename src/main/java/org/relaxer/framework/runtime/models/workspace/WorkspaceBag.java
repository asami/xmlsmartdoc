package org.relaxer.framework.runtime.models.workspace;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * WorkspaceBag
 *
 * @since   Aug. 16, 2005
 * @version Aug. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class WorkspaceBag {
    private int onMemorySize_ = 8192;
    int count_ = 0;
    byte[] buffer_ = new byte[onMemorySize_];
    File file_ = null;
    OutputStream out_ = null;

    class WorkspaceBagOutputStream extends OutputStream { 
        public void write(int b) throws IOException {
            if (count_ == onMemorySize_) {
                file_ = File.createTempFile("relaxer-framework", "bak");
                file_.deleteOnExit();
                out_ = new BufferedOutputStream(new FileOutputStream(file_)); // XXX : error
                out_.write(buffer_);
                buffer_ = null;
            }
            if (out_ != null) {
                out_.write(b);
            } else {
                buffer_[count_] = (byte)b;
            }
            count_++;
        }
    
        public void flush() throws IOException {
            if (out_ != null) {
                out_.flush();
            }
        }
    
        public void close() throws IOException {
            if (out_ != null) {
                out_.close();
                out_ = null;
            }
        }
    }
    
    public void dispose() throws IOException {
        buffer_ = null;
        if (file_ != null) {
            file_.delete();
            file_ = null;
        }
    }

    public InputStream openInputStream() throws IOException {
        if (buffer_ != null) {
            ByteArrayInputStream in = new ByteArrayInputStream(buffer_, 0, count_);
            return in;
        } else {
            return new FileInputStream(file_);
        }
    }

    public OutputStream openOutputStream() {
        return new WorkspaceBagOutputStream();
    }

    public BufferedWriter openBufferedWriter() throws IOException {
        return new BufferedWriter(new OutputStreamWriter(openOutputStream(), "UTF-8"));
    }

    public long getSize() {
        return count_;
    }
}
