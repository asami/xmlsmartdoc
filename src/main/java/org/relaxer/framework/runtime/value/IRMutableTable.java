package org.relaxer.framework.runtime.value;

/**
 * IRMutableTable
 *
 * @since   Oct. 18, 2005
 * @version Oct. 30, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRMutableTable extends IRTable {
    Object put(int x, int y, Object value);
    Object remove(int x, int y);
}
