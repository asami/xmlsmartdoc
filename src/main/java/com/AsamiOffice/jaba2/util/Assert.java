/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1998  ASAMI, Tomoharu (tasami@ibm.net)
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

/**
 * Assert is a utility class for assertion facility.
 * Assert is used to implement invariant, pre-condition, post-condition.
 *
 * @since   Mar. 24, 1998
 * @version Apr. 15, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class Assert {
    /**
     * Do check whether the cond is true or false.
     * If the cond is false, InternalError exception is raised.
     *
     * @param cond  assertion condition
     */
    public static final void check(boolean cond) {
	if (cond == false) {
	    throw (new InternalError());
	}
    }

    /**
     * Do check whether the cond is true or false.
     * If the cond is false, InternalError exception is raised.
     * The message is set up to the information of InternalError.
     *
     * @param cond  assertion condition
     * @param message  message for assertion
     */
    public static final void check(boolean cond, String message) {
	if (cond == false) {
	    throw (new InternalError(message));
	}
    }

    /**
     * Do check whether the cond is true or false.
     * If the cond is false, InternalError exception is raised.
     * The obj is set up to the information of InternalError.
     *
     * @param cond  assertion condition
     * @param obj  object for assertion
     */
    public static final void check(boolean cond, Object obj) {
	if (cond == false) {
	    throw (new InternalError(obj.toString()));
	}
    }

    /**
     * Do check whether the cond is true or false.
     * If the cond is false, InternalError exception is raised.
     * The obj and the message is set up to the information of InternalError.
     *
     * @param cond  assertion condition
     * @param obj  object for assertion
     * @param message  message for assertion
     */
    public static final void check(boolean cond, Object obj, String message) {
	if (cond == false) {
	    throw (new InternalError(obj.toString() + " : " + message));
	}
    }

    /**
     * If preCond is true, do check whether the cond is true or false.
     * If the cond is false, InternalError exception is raised.
     * The message is set up to the information of InternalError.
     *
     * @param preCond  pre-condition to assert
     * @param cond  assertion condition
     */
    public static final void checkCond(
	boolean preCond,
	boolean cond
    ) {
	if (preCond) {
	    if (cond == false) {
		throw (new InternalError());
	    }
	}
    }

    /**
     * If preCond is true, do check whether the cond is true or false.
     * If the cond is false, InternalError exception is raised.
     * The message is set up to the information of InternalError.
     *
     * @param preCond  pre-condition to assert
     * @param cond  assertion condition
     * @param message  message for assertion
     */
    public static final void checkCond(
	boolean preCond,
	boolean cond,
	String message
    ) {
	if (preCond) {
	    if (cond == false) {
		throw (new InternalError(message));
	    }
	}
    }

    /**
     * If preCond is true, do check whether the cond is true or false.
     * If the cond is false, InternalError exception is raised.
     * The obj is set up to the information of InternalError.
     *
     * @param preCond  pre-condition to assert
     * @param cond  assertion condition
     * @param obj  object for assertion
     */
    public static final void checkCond(
	boolean preCond,
	boolean cond,
	Object obj
    ) {
	if (preCond) {
	    if (cond == false) {
		throw (new InternalError(obj.toString()));
	    }
	}
    }

    /**
     * If preCond is true, do check whether the cond is true or false.
     * If the cond is false, InternalError exception is raised.
     * The obj and the message is set up to the information of InternalError.
     *
     * @param preCond  pre-condition to assert
     * @param cond  assertion condition
     * @param obj  object for assertion
     * @param message  message for assertion
     */
    public static final void checkCond(
	boolean preCond,
	boolean cond,
	Object obj,
	String message
    ) {
	if (preCond) {
	    if (cond == false) {
		throw (new InternalError(obj.toString() + " : " + message));
	    }
	}
    }

    /**
     * Do check whether the var is null.
     * If the var is null, InternalError exception is raised.
     *
     * @param var  variable to assert
     */
    // not null
    public static final void notNull(Object var) {
	if (var == null) {
	    throw (new InternalError());
	}
    }

    /**
     * Do check whether the var is null.
     * If the var is null, InternalError exception is raised.
     * The message is set up to the information of InternalError.
     *
     * @param var  variable to assert
     * @param message  message for assertion
     */
    // not null
    public static final void notNull(Object var, String message) {
	if (var == null) {
	    throw (new InternalError(message));
	}
    }

    /**
     * Do check whether the var is null.
     * If the var is null, InternalError exception is raised.
     * The obj is set up to the information of InternalError.
     *
     * @param var  variable to assert
     * @param message  message for assertion
     */
    public static final void notNull(Object var, Object obj) {
	if (var == null) {
	    throw (new InternalError(obj.toString()));
	}
    }

    /**
     * Do check whether the var is null.
     * If the var is null, InternalError exception is raised.
     * The obj and the message is set up to the information of InternalError.
     *
     * @param var  variable to assert
     * @param obj  object for assertion
     * @param message  message for assertion
     */
    public static final void notNull(Object var, Object obj, String message) {
	if (var == null) {
	    throw (new InternalError(obj.toString() + " : " + message));
	}
    }

    /**
     * Do check whether the cond is true or false.
     * If the cond is false, IllegalArgumentException is raised.
     *
     * @param cond  assertion condition
     */
    public static final void argument(boolean cond) {
	if (cond == false) {
	    throw (new IllegalArgumentException());
	}
    }

    /**
     * Do check whether the cond is true or false.
     * If the cond is false, IllegalArgumentException is raised.
     * The obj is set up to the information of InternalError.
     *
     * @param cond  assertion condition
     * @param object  object for assertion
     */
    public static final void argument(boolean cond, Object object) {
	if (cond == false) {
	    throw (new IllegalArgumentException(object.toString()));
	}
    }

    /**
     * Do check whether the cond is true or false.
     * If the cond is false, IllegalArgumentException is raised.
     * The message is set up to the information of InternalError.
     *
     * @param cond  assertion condition
     * @param message  message for assertion
     */
    public static final void argument(boolean cond, String message) {
	if (cond == false) {
	    throw (new IllegalArgumentException(message));
	}
    }

    /**
     * Do check whether the cond is true or false.
     * If the cond is false, IllegalArgumentException is raised.
     * The object and the message is set up to the information of
     * InternalError.
     *
     * @param cond  assertion condition
     * @param message  message for assertion
     */
    public static final void argument(
	boolean cond,
	Object object,
	String message
    ) {
	if (cond == false) {
	    throw (new IllegalArgumentException(
		object.toString() + ":" + message
	    ));
	}
    }
}
