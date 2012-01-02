package org.relaxer.framework.runtime.reporter;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.relaxer.framework.RelaxerFrameworkErrorException;

import com.AsamiOffice.text.I18nText;
import com.AsamiOffice.util.ArrayMap;

/**
 * ReportRecord
 *
 * @since   Aug. 29, 2005
 * @version Aug. 31, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ReportRecord {
    public Date dateTime;
    public I18nText level;
    public I18nText when;
    public I18nText who;
    public I18nText what;
    public I18nText where;
    public I18nText why;
    public I18nText how;
    public ArrayMap properties = new ArrayMap();

    public ReportRecord() {
        dateTime = new Date();
    }

    public String toString() {
        StringWriter writer = null;
        try {
            writer = new StringWriter();
            write(writer);
            return writer.toString();
        } catch (IOException e) {
            throw new RelaxerFrameworkErrorException(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public void setLevel(String message) {
        if (message == null) {
            level = null;
        } else {
            level = new I18nText(message);
        }
    }

    public void setWhen(String message) {
        if (message == null) {
            when = null;
        } else {
            when = new I18nText(message);
        }
    }

    public void setWhat(String message) {
        if (message == null) {
            what = null;
        } else {
            what = new I18nText(message);
        }
    }

    public void setWhere(String message) {
        if (message == null) {
            where = null;
        } else {
            where = new I18nText(message);
        }
    }

    public void setWhy(String message) {
        if (message == null) {
            why = null;
        } else {
            why = new I18nText(message);
        }
    }

    public void write(Writer writer) throws IOException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        writer.write("<item");
        writer.write(" date-time=\"");
        writer.write(formatter.format(dateTime));
        writer.write("\"");
        if (level != null) {
            writer.write(" level=\"");
            writer.write(level.toString());
            writer.write("\"");
        }
        writer.write(">");
        if (when != null) {
            writer.write("<when>");
            writer.write(when.toString());
            writer.write("</when>");
        }
        if (who != null) {
            writer.write("<who>");
            writer.write(who.toString());
            writer.write("</who>");
        }
        if (what != null) {
            writer.write("<what>");
            writer.write(what.toString());
            writer.write("</what>");
        }
        if (where != null) {
            writer.write("<where>");
            writer.write(where.toString());
            writer.write("</where>");
        }
        if (why != null) {
            writer.write("<why>");
            writer.write(why.toString());
            writer.write("</why>");
        }
        if (how != null) {
            writer.write("<how>");
            writer.write(how.toString());
            writer.write("</how>");
        }
        Set entrySet = properties.entrySet();
        Object[] entries = entrySet.toArray();
        for (int i = 0;i < entries.length;i++) {
            Map.Entry entry = (Entry)entries[i];
            Object key = entry.getKey();
            Object value = entry.getValue(); 
            writer.write("<property key=\"");
            if (key != null) {
                writer.write(key.toString());
            }
            writer.write("\">");
            if (value != null) {
                writer.write(value.toString());
            }
            writer.write("</property>");
        }
        writer.write("</item>");
    }
}
