package org.relaxer.framework.runtime.reporter;

import java.util.ArrayList;
import java.util.List;

/**
 * TextReporter
 *
 * @since   Aug. 27, 2005
 * @version Aug. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class PlainReporter extends AbstractRReporter {
    private List report_ = new ArrayList();

    public void addRecord(ReportRecord report) {
        report_.add(report);
    }

    public ReportRecord[] getRecords() {
        return (ReportRecord[])report_.toArray(new ReportRecord[report_.size()]);
    }
}
