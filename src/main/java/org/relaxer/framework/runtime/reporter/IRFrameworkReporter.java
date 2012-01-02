package org.relaxer.framework.runtime.reporter;

import java.io.Writer;

import org.relaxer.framework.RelaxerFrameworkException;


/**
 * IRFrameworkReporter
 *
 * @since   Aug. 27, 2005
 * @version Aug. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRFrameworkReporter {
    void addRecord(ReportRecord report);
    ReportRecord[] getRecords();
    void write(Writer write) throws RelaxerFrameworkException;
/*
    void fatal();
    void error();
    void warning();
    void info();
    void config();
    void debug();
*/
}
