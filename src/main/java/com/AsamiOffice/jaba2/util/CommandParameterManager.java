/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2002  ASAMI, Tomoharu (asami@AsamiOffice.com)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package com.AsamiOffice.jaba2.util;

import java.util.*;

/**
 * CommandParameterManager
 *
 * @since   Feb. 13, 1998
 * @version May. 26, 2002
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public class CommandParameterManager implements ParameterManager {
    protected Hashtable properties_ = new Hashtable();

    public CommandParameterManager(String prefix, String[] args) {
	ParseArg pa = new ParseArg();
	for (int i = 0;i < args.length;i++) {
	    pa.setToken(args[i]);
	}
	pa.endToken();
	Dictionary options = pa.getOptions();
	Enumeration keys = options.keys();
	while (keys.hasMoreElements()) {
	    String key = (String)keys.nextElement();
	    properties_.put(key, options.get(key));
	}
	Vector vector = pa.getArgs();
	for (int i = 0;i < vector.size();i++) {
	    properties_.put(ParameterInfo.ARG_PREFIX + i,
			    vector.elementAt(i));
	}
    }

    public boolean isParameter(String key) {
	return (properties_.keySet().contains(key));
    }

    public Object getParameter(String key) {
	return (properties_.get(key));
    }

    public Enumeration getKeys() {
	return (properties_.keys());
    }

    class ParseArg {
	void setToken(String token) {
	    if (token.charAt(0) == '-') {
		int index = token.indexOf(":");
		if (index == -1) {
		    options_.put(token.substring(1), "");
		} else {
		    options_.put(
			token.substring(1, index),
			token.substring(index + 1)
		    );
		}
/*
		StringTokenizer st = new StringTokenizer(token, ":");
		if (st.countTokens() == 1) {
		    options_.put(st.nextToken().substring(1), "");
		} else {
		    options_.put(
			st.nextToken().substring(1),
			st.nextToken()
		    );
		}
*/
	    } else {
		args_.addElement(token);
	    }
	}

	void endToken() {
	}

	Vector getArgs() {
	    return (args_);
	}

	Dictionary getOptions() {
	    return (options_);
	}

	Hashtable options_ = new Hashtable();
	Vector args_ = new Vector();
    }

    class ParseArg0 {
	final int INIT = 1;
	final int KEY = 2;

	void setToken(String token) {
	    switch (status_) {

	    case INIT:
		if (token.charAt(0) == '-') {
		    key_ = token.substring(1);
		    status_ = KEY;
		} else {
		    args_.addElement(token);
		}
		break;
	    case KEY:
		if (token.charAt(0) == '-') {
		    options_.put(key_, "");
		    String key = token.substring(1);
		    status_ = KEY;
		} else {
		    options_.put(key_, token);
		    status_ = INIT;
		}
		break;
	    default:
		throw (new InternalError("Invalid status"));
	    }
	}

	void endToken() {
	    if (status_ == KEY) {
		options_.put(key_, "");
	    }
	}

	Vector getArgs() {
	    return (args_);
	}

	Dictionary getOptions() {
	    return (options_);
	}

	String key_;
	int status_ = INIT;
	Hashtable options_ = new Hashtable();
	Vector args_ = new Vector();
    }
}
