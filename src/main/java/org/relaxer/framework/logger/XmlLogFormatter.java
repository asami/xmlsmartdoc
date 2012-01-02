/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
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

import java.io.*;

/**
 * XmlLogFormatter
 *
 * @since   Jan. 19, 2003
 * @version Mar. 14, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class XmlLogFormatter extends AbstractLogFormatter {
    public void log(String message, Writer writer) throws IOException {
        _printLogPrologue(writer);
        _printMessage(message, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    // fatal
    public void fatal(String message, Writer writer) throws IOException {
        _printLogPrologue("fatal", writer);
        _printMessage(message, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void fatal(String message, Throwable e, Writer writer)
        throws IOException {
        _printLogPrologue("fatal", writer);
        _printMessage(message, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void fatal(String message, Object arg, Writer writer)
        throws IOException {
        _printLogPrologue("fatal", writer);
        _printMessage(message, arg, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void fatal(String message, Object arg, Throwable e, Writer writer)
        throws IOException {
        _printLogPrologue("fatal", writer);
        _printMessage(message, arg, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void fatal(String message, Object arg1, Object arg2, Writer writer)
        throws IOException {
        _printLogPrologue("fatal", writer);
        _printMessage(message, arg1, arg2, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void fatal(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("fatal", writer);
        _printMessage(message, arg1, arg2, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void fatal(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException {
        _printLogPrologue("fatal", writer);
        _printMessage(message, arg1, arg2, arg3, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void fatal(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("fatal", writer);
        _printMessage(message, arg1, arg2, arg3, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void fatal(String message, String[] args, Writer writer)
        throws IOException {
        _printLogPrologue("fatal", writer);
        _printMessage(message, args, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void fatal(
        String message,
        String[] args,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("fatal", writer);
        _printMessage(message, args, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    // error
    public void error(String message, Writer writer) throws IOException {
        _printLogPrologue("error", writer);
        _printMessage(message, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void error(String message, Throwable e, Writer writer)
        throws IOException {
        _printLogPrologue("error", writer);
        _printMessage(message, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void error(String message, Object arg, Writer writer)
        throws IOException {
        _printLogPrologue("error", writer);
        _printMessage(message, arg, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void error(String message, Object arg, Throwable e, Writer writer)
        throws IOException {
        _printLogPrologue("error", writer);
        _printMessage(message, arg, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void error(String message, Object arg1, Object arg2, Writer writer)
        throws IOException {
        _printLogPrologue("error", writer);
        _printMessage(message, arg1, arg2, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void error(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("error", writer);
        _printMessage(message, arg1, arg2, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void error(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException {
        _printLogPrologue("error", writer);
        _printMessage(message, arg1, arg2, arg3, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void error(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("error", writer);
        _printMessage(message, arg1, arg2, arg3, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void error(String message, String[] args, Writer writer)
        throws IOException {
        _printLogPrologue("error", writer);
        _printMessage(message, args, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void error(
        String message,
        String[] args,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("error", writer);
        _printMessage(message, args, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    // warning
    public void warning(String message, Writer writer) throws IOException {
        _printLogPrologue("warning", writer);
        _printMessage(message, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void warning(String message, Throwable e, Writer writer)
        throws IOException {
        _printLogPrologue("warning", writer);
        _printMessage(message, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void warning(String message, Object arg, Writer writer)
        throws IOException {
        _printLogPrologue("warning", writer);
        _printMessage(message, arg, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void warning(String message, Object arg, Throwable e, Writer writer)
        throws IOException {
        _printLogPrologue("warning", writer);
        _printMessage(message, arg, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void warning(String message, Object arg1, Object arg2, Writer writer)
        throws IOException {
        _printLogPrologue("warning", writer);
        _printMessage(message, arg1, arg2, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void warning(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("warning", writer);
        _printMessage(message, arg1, arg2, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void warning(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException {
        _printLogPrologue("warning", writer);
        _printMessage(message, arg1, arg2, arg3, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void warning(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("warning", writer);
        _printMessage(message, arg1, arg2, arg3, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void warning(String message, String[] args, Writer writer)
        throws IOException {
        _printLogPrologue("warning", writer);
        _printMessage(message, args, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void warning(
        String message,
        String[] args,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("warning", writer);
        _printMessage(message, args, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    // info
    public void info(String message, Writer writer) throws IOException {
        _printLogPrologue("info", writer);
        _printMessage(message, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void info(String message, Throwable e, Writer writer)
        throws IOException {
        _printLogPrologue("info", writer);
        _printMessage(message, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void info(String message, Object arg, Writer writer)
        throws IOException {
        _printLogPrologue("info", writer);
        _printMessage(message, arg, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void info(String message, Object arg, Throwable e, Writer writer)
        throws IOException {
        _printLogPrologue("info", writer);
        _printMessage(message, arg, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void info(String message, Object arg1, Object arg2, Writer writer)
        throws IOException {
        _printLogPrologue("info", writer);
        _printMessage(message, arg1, arg2, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void info(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("info", writer);
        _printMessage(message, arg1, arg2, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void info(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException {
        _printLogPrologue("info", writer);
        _printMessage(message, arg1, arg2, arg3, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void info(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("info", writer);
        _printMessage(message, arg1, arg2, arg3, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void info(String message, String[] args, Writer writer)
        throws IOException {
        _printLogPrologue("info", writer);
        _printMessage(message, args, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void info(
        String message,
        String[] args,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("info", writer);
        _printMessage(message, args, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    // config
    public void config(String message, Writer writer) throws IOException {
        _printLogPrologue("config", writer);
        _printMessage(message, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void config(String message, Throwable e, Writer writer)
        throws IOException {
        _printLogPrologue("config", writer);
        _printMessage(message, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void config(String message, Object arg, Writer writer)
        throws IOException {
        _printLogPrologue("config", writer);
        _printMessage(message, arg, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void config(String message, Object arg, Throwable e, Writer writer)
        throws IOException {
        _printLogPrologue("config", writer);
        _printMessage(message, arg, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void config(String message, Object arg1, Object arg2, Writer writer)
        throws IOException {
        _printLogPrologue("config", writer);
        _printMessage(message, arg1, arg2, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void config(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("config", writer);
        _printMessage(message, arg1, arg2, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void config(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException {
        _printLogPrologue("config", writer);
        _printMessage(message, arg1, arg2, arg3, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void config(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("config", writer);
        _printMessage(message, arg1, arg2, arg3, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void config(String message, String[] args, Writer writer)
        throws IOException {
        _printLogPrologue("config", writer);
        _printMessage(message, args, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void config(
        String message,
        String[] args,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("config", writer);
        _printMessage(message, args, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    // entering
    public void entering(Object object, String method, Writer writer)
        throws IOException {
        _printLogPrologue(writer);
        printTime_(writer);
        _printClassMethod(object, method, writer);
        writer.write("()");
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void entering(
        Object object,
        String method,
        Object arg,
        Writer writer
    ) throws IOException {
        printTime_(writer);
        _printClassMethod(object, method, writer);
        writer.write("(");
        writer.write(arg.toString());
        writer.write(")");
        _printNewline(writer);
        writer.flush();
    }

    public void entering(
        Object object,
        String method,
        Object arg1,
        Object arg2,
        Writer writer
    ) throws IOException {
        printTime_(writer);
        _printClassMethod(object, method, writer);
        writer.write("(");
        writer.write(arg1.toString());
        writer.write(", ");
        writer.write(arg2.toString());
        writer.write(")");
        _printNewline(writer);
        writer.flush();
    }

    public void entering(
        Object object,
        String method,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException {
        printTime_(writer);
        _printClassMethod(object, method, writer);
        writer.write("(");
        writer.write(arg1.toString());
        writer.write(", ");
        writer.write(arg2.toString());
        writer.write(", ");
        writer.write(arg3.toString());
        writer.write(")");
        _printNewline(writer);
        writer.flush();
    }

    public void entering(
        Object object,
        String method,
        Object[] args,
        Writer writer
    ) throws IOException {
        printTime_(writer);
        _printClassMethod(object, method, writer);
        writer.write("(");
        if (args.length > 0) {
            writer.write(args[0].toString());
            for (int i = 1; i < args.length; i++) {
                writer.write(", ");
                writer.write(args[i].toString());
            }
        }
    }

    // exiting
    public void exiting(Object object, String method, Writer writer)
        throws IOException {
        printTime_(writer);
        _printClassMethod(object, method, writer);
        writer.write("-->void");
        _printNewline(writer);
        writer.flush();
    }

    public void exiting(
        Object object,
        String method,
        Object result,
        Writer writer
    )
        throws IOException {
        printTime_(writer);
        _printClassMethod(object, method, writer);
        writer.write("-->");
        writer.write(result.toString());
        _printNewline(writer);
        writer.flush();
    }

    public void exiting(
        Object object,
        String method,
        Throwable e,
        Writer writer
    ) throws IOException {
        printTime_(writer);
        _printClassMethod(object, method, writer);
        writer.write("-->");
        writer.write(e.getMessage());
        _printNewline(writer);
        writer.flush();
    }

    // error
    public void debug(String message, Writer writer) throws IOException {
        _printLogPrologue("debug", writer);
        _printMessage(message, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void debug(String message, Throwable e, Writer writer)
        throws IOException {
        _printLogPrologue("debug", writer);
        _printMessage(message, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void debug(String message, Object arg, Writer writer)
        throws IOException {
        _printLogPrologue("debug", writer);
        _printMessage(message, arg, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void debug(String message, Object arg, Throwable e, Writer writer)
        throws IOException {
        _printLogPrologue("debug", writer);
        _printMessage(message, arg, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void debug(String message, Object arg1, Object arg2, Writer writer)
        throws IOException {
        _printLogPrologue("debug", writer);
        _printMessage(message, arg1, arg2, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void debug(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("debug", writer);
        _printMessage(message, arg1, arg2, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void debug(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException {
        _printLogPrologue("debug", writer);
        _printMessage(message, arg1, arg2, arg3, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void debug(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("debug", writer);
        _printMessage(message, arg1, arg2, arg3, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void debug(String message, String[] args, Writer writer)
        throws IOException {
        _printLogPrologue("debug", writer);
        _printMessage(message, args, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    public void debug(
        String message,
        String[] args,
        Throwable e,
        Writer writer
    ) throws IOException {
        _printLogPrologue("debug", writer);
        _printMessage(message, args, e, writer);
        _printLogEpilogue(writer);
        _printNewline(writer);
        writer.flush();
    }

    //
    private void _printLogPrologue(Writer writer) throws IOException {
        writer.write("<log");
        printTime_(writer);
        writer.write(">");
    }

    private void _printLogPrologue(String kind, Writer writer)
        throws IOException {
        writer.write("<log");
        printTime_(writer);
        writer.write(" kind=\"");
        writer.write(kind);
        writer.write("\"");
        writer.write(">");
    }

    private void _printMessage(String message, Writer writer)
        throws IOException {
        _format(message, writer);
    }

    private void _printMessage(String message, Throwable e, Writer writer)
        throws IOException {
        writer.write("<message>");
        _format(message, writer);
        writer.write("</message>");
        _printException(e, writer);
    }

    private void _printMessage(String message, Object arg, Writer writer) throws IOException {
        writer.write("<message>");
        _format(message, arg, writer);
        writer.write("</message>");
    }

    private void _printMessage(
        String message,
        Object arg,
        Throwable e,
        Writer writer
    ) throws IOException {
        writer.write("<message>");
        _format(message, arg, writer);
        writer.write("</message>");
        _printException(e, writer);
    }

    private void _printMessage(
        String message,
        Object arg1,
        Object arg2,
        Writer writer
    ) throws IOException {
        writer.write("<message>");
        _format(message, arg1, arg2, writer);
        writer.write("</message>");
    }

    private void _printMessage(
        String message,
        Object arg1,
        Object arg2,
        Throwable e,
        Writer writer
    ) throws IOException {
        writer.write("<message>");
        _format(message, arg1, arg2, writer);
        writer.write("</message>");
        _printException(e, writer);
        
    }

    private void _printMessage(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Writer writer
    ) throws IOException {
        writer.write("<message>");
        _format(message, arg1, arg2, arg3, writer);
        writer.write("</message>");
    }

    private void _printMessage(
        String message,
        Object arg1,
        Object arg2,
        Object arg3,
        Throwable e,
        Writer writer
    ) throws IOException {
        writer.write("<message>");
        _format(message, arg1, arg2, arg3, writer);
        writer.write("</message>");
        _printException(e, writer);
    }

    private void _printMessage(
        String message,
        Object[] args,
        Writer writer
    ) throws IOException {
        writer.write("<message>");
        _format(message, args, writer);
        writer.write("</message>");
    }

    private void _printMessage(
        String message,
        Object[] args,
        Throwable e,
        Writer writer
    ) throws IOException {
        writer.write("<message>");
        _format(message, args, writer);
        writer.write("</message>");
        _printException(e, writer);
    }

    private void _printException(Throwable e, Writer writer) throws IOException {
        writer.write("<exception>");
        writer.write(e.toString()); // TODO
        writer.write("</exception>");
    }

    private void _printLogEpilogue(Writer writer) throws IOException {
        writer.write("</log>");
    }

    private void printTime_(Writer writer) throws IOException {
        writer.write(" dateTime=\"");
        writer.write(ULogger.getCurrentDateTimeString());
        writer.write("\"");
    }
}
