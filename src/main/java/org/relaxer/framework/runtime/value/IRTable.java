package org.relaxer.framework.runtime.value;

/**
 * IRTable
 *
 * @since   Oct. 17, 2005
 * @version Oct. 29, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRTable {
    int getWidth();
    int getHeight();
    Object get(int x, int y);
}
