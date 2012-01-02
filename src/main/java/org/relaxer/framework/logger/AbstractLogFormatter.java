/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.framework.logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.*;

/**
 * AbstractLogFormatter
 *
 * @since   Jan. 19, 2003
 * @version Mar.  4, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractLogFormatter implements IRFrameworkLogFormatter {
    private ResourceBundle localizer_;

    public void setup(Properties properties) {
    }

    protected void _format(String message, Writer writer) throws IOException {
        writer.write(getMessage_(message));
    }

    protected void _format(String message, Throwable e, Writer writer)
        throws IOException {
        writer.write(getMessage_(message));
        _formatExceptionSummary(e, writer);
    }

    protected void _format(String message, Object arg, Writer writer)
      throws IOException {
        writer.write(getMessage_(message, arg));
    }

    protected void _format(
        String message,
        Object arg,
        Throwable e,
        Writer writer
    ) throws IOException {
        writer.write(getMessage_(message, arg));
        _formatExceptionSummary(e, writer);
    }

    protected void _format(
        String message,
        Object arg1,
        Object arg2,
        Writer writer
    ) throws IOException {
        writer.write(getMessage_(message, arg1, arg2));
    }

    protected void _format(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException {
        writer.write(getMessage_(message, arg1, arg2));
        _formatExceptionSummary(e, writer);
    }

    protected void _format(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException {
        writer.write(getMessage_(message, arg1, arg2, arg3));
    }

    protected void _format(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException {
        writer.write(getMessage_(message, arg1, arg2, arg3));
        _formatExceptionSummary(e, writer);
    }

    protected void _format(
        String message,
        Object[] args,
        Writer writer
    ) throws IOException {
        writer.write(getMessage_(message, args));
    }

    protected void _format(
        String message,
        Object[] args,
        Throwable e,
        Writer writer
    ) throws IOException {
        writer.write(getMessage_(message, args));
        _formatExceptionSummary(e, writer);
    }

    protected void _formatExceptionSummary(Throwable e, Writer writer)
        throws IOException {
        writer.write(" Exception is [" + e.getClass() + "(" + e.getMessage() + ")]");
    }

    protected void _formatExceptionDetail(Throwable e, Writer writer) {
        PrintWriter output;
        if (writer instanceof PrintWriter) {
            output = (PrintWriter)writer;
        } else {
            output = new PrintWriter(writer);
        }
        e.printStackTrace(output);
        output.flush();
    }

    private String getMessage_(String message) {
        return (getLocalizedFormatPattern_(message));
    }

    private String getMessage_(String message, Object arg1) {
        Object[] args = new Object[] { arg1 };
        return (getMessageFormat_(message).format(args));
    }

    private String getMessage_(String message, Object arg1, Object arg2) {
        Object[] args = new Object[] { arg1, arg2 };
        return (getMessageFormat_(message).format(args));
    }

    private String getMessage_(
        String message,
        Object arg1,
        Object arg2,
        Object arg3
    ) {
        Object[] args = new Object[] { arg1, arg2, arg3 };
        return (getMessageFormat_(message).format(args));
    }

    private String getMessage_(String message, Object[] args) {
        return (getMessageFormat_(message).format(args));
    }

    private MessageFormat getMessageFormat_(String message) {
        message = getLocalizedFormatPattern_(message);
        return (new MessageFormat(message));
//        Locale locale = Locale.getDefault(); // TODO
//        return (new MessageFormat(message, locale)); 1.4
    }
    
    private String getLocalizedFormatPattern_(String message) {
        if (localizer_ != null) {
            try {
                message = localizer_.getString(message);
            } catch (MissingResourceException e) {
                // TODO warning
            }
        }
        return (message);
    }

    protected void _printClassMethod(Object object, String method, Writer writer) throws IOException {
        writer.write(object.getClass().getName());
        writer.write(".");
        writer.write(method);
    }

    protected void _printTime(Writer writer) throws IOException {
        writer.write(ULogger.getCurrentDateTimeString());
        writer.write(" ");
    }

    protected void _printNewline(Writer wtier) throws IOException {
        wtier.write('\n');
    }
}
