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

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.AsamiOffice.text.UString;

/**
 * RFrameworkLoggerFactory
 *
 * @since   Dec. 13, 2003
 * @version Dec. 18, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RFrameworkLoggerFactory {
    public RFrameworkLoggerFactory() {
    }

    public IRFrameworkLogger getLogger(String settings) {
        if (settings == null || "".equals(settings)) {
            return (getDefaultLogger_());
        }
        String[] tokens = UString.getTokens(settings,";");
        Entry[] entries = getEntries_(tokens);
        if (entries.length == 0) {
            return (getDefaultLogger_());
        } else if (entries.length == 1) {
            return (getLogger_(entries[0]));
        } else {
            List loggers = new ArrayList();            
            for (int i = 0; i < entries.length; i++) {
                Entry entry = entries[i];
                loggers.add(getLogger_(entry));
            }
            return (new MulticastLogger(loggers));
        }
    }

    private IRFrameworkLogger getDefaultLogger_() {
        return (new StdoutLogger());
    }

    private IRFrameworkLogger getLogger_(Entry entry) {
        IRFrameworkLogger logger;
        if ("none".equals(entry.name)) {
            logger = new NullLogger();
        } else if ("stdout".equals(entry.name)) {
            logger = new StdoutLogger();
        } else if ("stderr".equals(entry.name)) {
            logger = new StderrLogger();
        } else if ("file".equals(entry.name)) {
            logger = new FileLogger();
        } else if ("j2se14".equals(entry.name)) {
            logger = new J2se14Logger();
        } else if ("log4j".equals(entry.name)) {
            logger = new Log4jLogger();
        } else if ("commons".equals(entry.name)) {
            logger = new CommonsLogger();
        } else {
            logger = new StdoutLogger();
            logger.warning("Illegal logger name:" + entry.name);
        }
        logger.setup(new Properties());
        setupLevel_(entry, logger);
        setupFormatter_(entry, logger);
        return (logger);
    }

    /**
     * @param entry
     * @param logger
     */
    private void setupLevel_(Entry entry, IRFrameworkLogger logger) {
        if (entry.level == null) {
            return;
        }
        if ("fatal".equals(entry.level)) {
            logger.setLevel(IRFrameworkLogger.LOG_FATAL);
        } else if ("error".equals(entry.level)) {
            logger.setLevel(IRFrameworkLogger.LOG_ERROR);
        } else if ("warning".equals(entry.level)) {
            logger.setLevel(IRFrameworkLogger.LOG_WARNING);
        } else if ("info".equals(entry.level)) {
            logger.setLevel(IRFrameworkLogger.LOG_INFO);
        } else if ("config".equals(entry.level)) {
            logger.setLevel(IRFrameworkLogger.LOG_CONFIG);
        } else if ("trace".equals(entry.level)) {
            logger.setLevel(IRFrameworkLogger.LOG_TRACE);
        } else if ("debug".equals(entry.level)) {
            logger.setLevel(IRFrameworkLogger.LOG_DEBUG);
        } else {
            logger.warning("Illegal log level name: " + entry.level);
        }
    }

    private void setupFormatter_(Entry entry, IRFrameworkLogger logger) {
        if (entry.formatter == null) {
            return;
        }
        if ("plain".equals(entry.formatter)) {
            logger.setFormatter(new PlainLogFormatter());
        } else if ("xml".equals(entry.formatter)) {
            logger.setFormatter(new XmlLogFormatter());
        } else {
            logger.warning("Illegal log formatter name: " + entry.formatter);
        }
    }

    /**
     * @param tokens
     * @return
     */
    private Entry[] getEntries_(String[] tokens) {
        List list = new ArrayList();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            getEntry_(token, list);
        }
        Entry[] result = new Entry[list.size()];
        return ((Entry[])list.toArray(result));
    }

    /**
     * @param token
     * @return
     */
    private void getEntry_(String token, List list) {
        int index = token.indexOf(":");
        if (index == -1) {
            Entry entry = new Entry();
            entry.level = token;
            entry.name = "stdout";
            list.add(entry);
        } else {
            String level = token.substring(0, index);
            String[] loggers 
                = UString.getTokens(token.substring(index + 1), ",");
            for (int i = 0; i < loggers.length; i++) {
                String logger = loggers[i];
                Entry entry = new Entry();
                entry.level = level;
                int index2 = logger.indexOf("/");
                if (index2 == -1) {
                    entry.name = logger;
                } else {
                    entry.name = logger.substring(0, index2);
                    entry.formatter = logger.substring(index2 + 1);
                }
                list.add(entry);
            }
        }
    }

    static class Entry {
        String name;
        String level;
        String formatter;
    }
}
