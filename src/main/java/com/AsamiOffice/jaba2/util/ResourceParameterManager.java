package com.AsamiOffice.jaba2.util;

import java.util.*;

/**
 * ResourceParameterManager
 *
 * @since   Feb. 13, 1998
 * @version Aug. 15, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class ResourceParameterManager implements ParameterManager {
    protected ResourceBundle resource_;

    public ResourceParameterManager(String prefix, String name)
	throws MissingResourceException{

	_init(ResourceBundle.getBundle(name));
    }

    public ResourceParameterManager(String prefix, String name, Locale locale)
	throws MissingResourceException {

	_init(ResourceBundle.getBundle(name));
    }

    private void _init(ResourceBundle resource) {
	resource_ = resource;
    }

    public ResourceBundle getResourceBundle() {
	return (resource_);
    }

    public boolean isParameter(String key) {
	try {
	    return (resource_.getObject(key) != null);
	} catch (MissingResourceException e) {
	    return (false);
	}
    }

    public Object getParameter(String key) {
	try {
	    return (resource_.getObject(key));
	} catch (MissingResourceException e) {
	    return (null);
	}
    }

    public Enumeration getKeys() {
	return (resource_.getKeys());
    }
}
