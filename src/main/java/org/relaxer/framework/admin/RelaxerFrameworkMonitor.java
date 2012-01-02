/*
 * Created on 2003/12/11
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.relaxer.framework.admin;

import org.relaxer.framework.RelaxerFramework;
import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.j2eecontainer.IMonitor;

/**
 * RelaxerFramework
 *
 * @since   Dec. 11, 2003
 * @version Dec. 18, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RelaxerFrameworkMonitor implements IMonitor {
    private RelaxerFramework framework_;

    public RelaxerFrameworkMonitor(RelaxerFramework framework) {
        framework_ = framework;
    }

    public ClassLoader getClassLoader() {
        return (framework_.getClassLoader());
    }

    public void error(String message, Throwable e) {
        IRFrameworkLogger logger = framework_.getLogger();
        logger.config(message, e);
    }

    public void warning(String message, Throwable e) {
        IRFrameworkLogger logger = framework_.getLogger();
        logger.config(message, e);
    }

    public void info(String message) {
        IRFrameworkLogger logger = framework_.getLogger();
        logger.info(message);
    }

    public void config(String message) {
        IRFrameworkLogger logger = framework_.getLogger();
        logger.config(message);
    }
}
