package org.relaxer.framework.runtime.reporter;


/**
 * NullReporter
 *
 * @since   Aug. 27, 2005
 * @version Aug. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class NullReporter extends AbstractRReporter {
    public void addRecord(ReportRecord report) {
    }

    public ReportRecord[] getRecords() {
        return new ReportRecord[0];
    }
}
