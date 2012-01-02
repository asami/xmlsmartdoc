package org.relaxer.framework.runtime.messager;

/**
 * StderrMessager
 *
 * @since   Aug. 27, 2005
 * @version Nov. 23, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class StderrMessager extends AbstractRMessager {
    public void message(String message) {
        System.err.println(message);
    }
}
