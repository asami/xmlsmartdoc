package com.AsamiOffice.jaba2.util;

import java.util.*;

/**
 * ParameterManager
 *
 * @since   Feb. 13, 1998
 * @version Dec.  7, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public interface ParameterManager {
    public boolean isParameter(String key);
    public Object getParameter(String key);
    public Enumeration getKeys();
}
