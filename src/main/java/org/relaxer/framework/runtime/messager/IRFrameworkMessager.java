package org.relaxer.framework.runtime.messager;

/**
 * IRFrameworkMessager
 *
 * @since   Aug. 27, 2005
 * @version Nov. 23, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRFrameworkMessager {
    void message(String message);
    
    /*
    void fatal();
    void error();
    void warning();
    void info();
    void config();
    void debug();
    */
}
