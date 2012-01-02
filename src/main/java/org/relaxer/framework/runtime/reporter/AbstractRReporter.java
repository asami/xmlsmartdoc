package org.relaxer.framework.runtime.reporter;

import java.io.IOException;
import java.io.Writer;

import org.relaxer.framework.RelaxerFrameworkException;

/**
 * AbstractRFrameworkReporter
 *
 * @since   Aug. 27, 2005
 * @version Aug. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRReporter implements IRFrameworkReporter {
    public void write(Writer writer) throws RelaxerFrameworkException {
        try {
            ReportRecord[] records = getRecords();
            writer.write("<report xmlns=\"http://www.relaxer.org/xmlns/report\">");
            for (int i = 0;i < records.length;i++) {
                records[i].write(writer);
            }
            writer.write("</report>");
            writer.flush();
        } catch (IOException e) {
            throw new RelaxerFrameworkException(e);
        }
    }
}
