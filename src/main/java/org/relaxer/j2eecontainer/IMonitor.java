/*
 * Created on 2003/12/08
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.relaxer.j2eecontainer;

/**
 * IMonitor
 *
 * @since   Dec.  8, 2003
 * @version Dec. 18, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IMonitor {

    ClassLoader getClassLoader();

    void error(String string, Throwable e);

    void warning(String string, Throwable e);

    void info(String message);

    void config(String message);
}
