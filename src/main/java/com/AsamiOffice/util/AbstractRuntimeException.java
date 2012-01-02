/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

package com.AsamiOffice.util;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * AbstractRuntimeException
 *
 * @since   Apr. 19, 2001
 * @version Jun. 30, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public abstract class AbstractRuntimeException extends RuntimeException {
    private Exception cause_ = null;

    protected AbstractRuntimeException() {
    }

    protected AbstractRuntimeException(String message) {
        super(message);
    }

    protected AbstractRuntimeException(Exception e) {
        super(e.getMessage());
        cause_ = e;
    }

    protected AbstractRuntimeException(String message, Exception e) {
        super(message);
        cause_ = e;
    }

    public Exception getException() {
        if (cause_ != null) {
            return (cause_);
        } else {
            return (this);
        }
    }

    public Exception getCauseException() {
        return (cause_);
    }

    public void printStackTrace() {
        printStackTrace(new PrintWriter(System.err, true));
    }

    public void printStackTrace(PrintStream out) {
        printStackTrace(new PrintWriter(out));
    }

    public void printStackTrace(PrintWriter writer) {
        if (writer == null) {
            writer = new PrintWriter(System.err, true);
        }
        super.printStackTrace(writer);
        if (cause_ != null) {
            writer.println();
            writer.println("StackTrace of Original Exception:");
            cause_.printStackTrace(writer);
        }
    }
}
