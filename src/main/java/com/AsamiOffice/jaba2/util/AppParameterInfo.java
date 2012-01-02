package com.AsamiOffice.jaba2.util;

import java.util.*;
import java.io.*;

/**
 * AppParameterInfo
 *
 * @since   Feb. 13, 1998
 * @version Oct. 19, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class AppParameterInfo extends ParameterInfo {
    public AppParameterInfo(String prefix, String[] args) {
	super(
	    prefix,
	    new ParameterManager[] {
	        new CommandParameterManager(prefix, args),
		new FileParameterManager(prefix, args),
		new UserParameterManager(prefix)
	    }
	);
    }

    public AppParameterInfo(String prefix, String[] args, String resource) {
	super(
	    prefix,
	    new ParameterManager[] {
	        new CommandParameterManager(prefix, args),
		new FileParameterManager(prefix, args),
		new UserParameterManager(prefix),
		new ResourceParameterManager(prefix, resource)
	    }
	);
    }

    public AppParameterInfo(
	String prefix,
	String[] args,
	String resource,
	File file
    ) throws IOException {
	super(
	    prefix,
	    new ParameterManager[] {
	        new CommandParameterManager(prefix, args),
		new FileParameterManager(prefix, args, file),
		new UserParameterManager(prefix),
		new ResourceParameterManager(prefix, resource)
	    }
	);
    }

    public AppParameterInfo(
	String prefix,
	String[] args,
	String resource,
	Locale locale
    ) {
	super(
	    prefix,
	    new ParameterManager[] {
	        new CommandParameterManager(prefix, args),
		new FileParameterManager(prefix, args),
		new UserParameterManager(prefix),
		new ResourceParameterManager(prefix, resource, locale)
	    }
	);
    }

    public AppParameterInfo(
	String prefix,
	String[] args,
	String resource,
	File file,
	Locale locale
    ) throws IOException {
	super(
	    prefix,
	    new ParameterManager[] {
	        new CommandParameterManager(prefix, args),
		new FileParameterManager(prefix, args, file),
		new UserParameterManager(prefix),
		new ResourceParameterManager(prefix, resource, locale),
	    }
	);
    }

    // test driver
    public static void main(String[] args) {
	if (args.length == 0) {
	    args = new String[] {
	        "arg0",
		"-optionX",
		"arg1",
		"-optionY:100",
		"arg2",
		"-path.optionZ:OK"
	    };
	}
	ParameterInfo info = new AppParameterInfo("test", args);
	Iterator keys = info.getKeys();
	while (keys.hasNext()) {
	    String key = (String)keys.next();
	    System.out.println(key + ":" + info.getParameter(key));
	}
	Object[] arguments = info.getArguments();
	for (int i = 0;i < arguments.length;i++) {
	    System.out.println("argument(" + (i + 1) + ") = " + arguments[i]);
	}
	System.out.println(info.getParameterAsString("path.optionZ"));
    }
}
