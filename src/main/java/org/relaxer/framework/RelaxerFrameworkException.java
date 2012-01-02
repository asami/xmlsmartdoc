/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.framework;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

/**
 * RelaxerFrameworkException
 *
 * @since   Oct.  6, 2003
 * @version Feb. 13, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RelaxerFrameworkException extends RemoteException {
    public RelaxerFrameworkException() {
        this("InternalError");
    }

    public RelaxerFrameworkException(String message) {
        super(message);
    }

    public RelaxerFrameworkException(Throwable e) {
        super(e.getMessage(), e); // RemoteException 
    }

    public RelaxerFrameworkException(String message, Throwable e) {
        super(message, e); // RemoteException
    }

    public Throwable rGetRealCause() {
        Throwable cause = getCause();
        if (cause == null || cause == this) {
            return (this);
        }
        for (;;) {
            Throwable target;
            if (cause instanceof InvocationTargetException) {
                target = ((InvocationTargetException)cause).getTargetException();
            } else {
                try {
                    target = cause.getCause();
                } catch (Exception e) { // NoSuchMethodException
                    target = null;
                }
            }
            if (target == null) {
                return (cause);
            }
            cause = target;
        }
    }

    public Exception rGetRealCauseException() {
        Throwable cause = rGetRealCause();
        if (cause instanceof Exception) {
            return ((Exception)cause);
        } else {
            return (this);
        }
    }
}
