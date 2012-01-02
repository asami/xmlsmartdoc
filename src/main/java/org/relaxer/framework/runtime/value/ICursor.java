package org.relaxer.framework.runtime.value;

/**
 * ICursor
 *
 * @since   Nov. 22, 2005
 * @version Nov. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface ICursor {
    void add(Object object);
    void enter();
    void leave();
}
