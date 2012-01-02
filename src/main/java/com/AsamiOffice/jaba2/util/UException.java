/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@asamiOffice.com)
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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Utilites for system dependent operations
 *
 * @since   Jul. 13, 2000
 * @version Dec. 27, 2003
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public final class UException {
    public static String getDetailInfo(Exception e) {
        StringWriter buffer = new StringWriter();
        PrintWriter writer = new PrintWriter(buffer);
        e.printStackTrace(writer);
        return (buffer.toString());
    }

    public static IOException makeIOException(String message) {
        return (new IOException(message));
    }

    public static IllegalArgumentException makeIllegalArgumentException(
        Throwable e
    ) {
        if (e instanceof IllegalArgumentException) {
            return ((IllegalArgumentException)e);
        } else if (e instanceof InvocationTargetException) {
            InvocationTargetException ite = (InvocationTargetException)e;
            Throwable targetException = ite.getTargetException();
            if (targetException == null) {
                return (new IllegalArgumentException(makeMessage(ite)));
            } else if (targetException instanceof IllegalArgumentException) {
                return ((IllegalArgumentException)targetException);
            } else {
                return (
                    new IllegalArgumentException(makeMessage(targetException))
                );
            }
        } else {
            return (new IllegalArgumentException(makeMessage(e)));
        }
    }

    public static IOException makeIOException(Throwable e) {
        if (e instanceof IOException) {
            return ((IOException)e);
        } else if (e instanceof InvocationTargetException) {
            InvocationTargetException ite = (InvocationTargetException)e;
            Throwable targetException = ite.getTargetException();
            if (targetException == null) {
                return (new IOException(makeMessage(ite)));
            } else if (targetException instanceof IOException) {
                return ((IOException)targetException);
            } else {
                return (new IOException(makeMessage(targetException)));
            }
        } else {
            return (new IOException(makeMessage(e)));
        }
    }

    public static RemoteException makeRemoteException(Throwable e) {
        if (e instanceof RemoteException) {
            return ((RemoteException)e);
        } else if (e instanceof InvocationTargetException) {
            InvocationTargetException ite = (InvocationTargetException)e;
            Throwable targetException = ite.getTargetException();
            if (targetException == null) {
                return (new RemoteException(makeMessage(ite)));
            } else if (targetException instanceof RemoteException) {
                return ((RemoteException)targetException);
            } else {
                return (
                    new RemoteException(
                        makeMessage(targetException),
                        targetException
                    )
                );
            }
        } else {
            return (new RemoteException(makeMessage(e)));
        }
    }

    public static SQLException makeSQLException(Throwable e) {
        if (e instanceof SQLException) {
            return ((SQLException)e);
        } else if (e instanceof InvocationTargetException) {
            InvocationTargetException ite = (InvocationTargetException)e;
            Throwable targetException = ite.getTargetException();
            if (targetException == null) {
                return (new SQLException(makeMessage(ite)));
            } else if (targetException instanceof SQLException) {
                return ((SQLException)targetException);
            } else {
                return (new SQLException(makeMessage(targetException)));
            }
        } else {
            return (new SQLException(makeMessage(e)));
        }
    }
/*
    public static JspTagException makeJspTagException(Throwable e) {
        if (e instanceof JspTagException) {
            return ((JspTagException)e);
        } else if (e instanceof InvocationTargetException) {
            InvocationTargetException ite = (InvocationTargetException)e;
            Throwable targetException = ite.getTargetException();
            if (targetException == null) {
                return (new JspTagException(makeMessage(ite)));
            } else if (targetException instanceof JspTagException) {
                return ((JspTagException)targetException);
            } else {
                return (new JspTagException(makeMessage(targetException)));
            }
        } else {
            return (new JspTagException(makeMessage(e)));
        }
    }

    public static JspTagException makeJspTagException(
        String message,
        Throwable e
    ) {
        if (e instanceof InvocationTargetException) {
            InvocationTargetException ite = (InvocationTargetException)e;
            Throwable targetException = ite.getTargetException();
            if (targetException == null) {
                return (new JspTagException(makeMessage(message, ite)));
            } else if (targetException instanceof JspTagException) {
                return ((JspTagException)targetException);
            } else {
                return (
                    new JspTagException(makeMessage(message, targetException))
                );
            }
        } else {
            return (new JspTagException(makeMessage(message, e)));
        }
    }
*/
    public static String makeMessage(Throwable e) {
        String em = e.getMessage();
        if (em == null) {
            em = "";
        }
        return ("[" + e.getClass().getName() + "] " + em);
    }

    public static String makeMessage(String message, Throwable e) {
        String em = e.getMessage();
        if (em == null) {
            em = "";
        }
        return (message + " [" + e.getClass().getName() + "] " + em);
    }
}
