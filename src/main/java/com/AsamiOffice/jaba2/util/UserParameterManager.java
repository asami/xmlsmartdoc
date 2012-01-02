package com.AsamiOffice.jaba2.util;

import java.util.*;
import java.io.*;

/**
 * UserParameterManager
 *
 * @since   Feb. 13, 1998
 * @version Dec.  7, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class UserParameterManager implements ParameterManager {
    protected Properties properties_ = null;

    public UserParameterManager(String prefix) {
	_init(".defaults.properties");
    }

    public UserParameterManager(String prefix, String filename) {
	_init(filename);
    }

    private void _init(String filename) {
	File file = new File(filename);
	if (!file.isAbsolute()) {
	    String home = System.getProperty("user.home");
	    if (home == null) {
		return;
	    }
	    file = new File(home, file.getPath());
	}
	InputStream in = null;
	try {
	    in = new BufferedInputStream(new FileInputStream(file));
	    properties_ = new Properties();
	    properties_.load(in);
	} catch (FileNotFoundException e) {
	} catch (IOException e) {
	} finally {
	    try {
		if (in != null) {
		    in.close();
		}
	    } catch (IOException e) {
	    }
	}
    }

    public boolean isParameter(String key) {
	if (properties_ != null) {
	    return (properties_.keySet().contains(key));
	} else {
	    return (false);
	}
    }

    public Object getParameter(String key) {
	if (properties_ != null) {
	    return (properties_.get(key));
	} else {
	    return (null);
	}
    }

    public Enumeration getKeys() {
	if (properties_ != null) {
	    return (properties_.keys());
	} else {
	    return (new Enumeration() {
		public boolean hasMoreElements() {
		    return (false);
		}

		public Object nextElement() {
		    return (null);
		}
	    });
	}
    }
}
