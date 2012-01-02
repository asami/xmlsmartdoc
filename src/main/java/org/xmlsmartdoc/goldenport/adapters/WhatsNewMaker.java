/*
 * org.xmlsmartdoc.goldenport
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
package org.xmlsmartdoc.goldenport.adapters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlsmartdoc.goldenport.engine.AbstractPortMakder;
import org.xmlsmartdoc.goldenport.engine.GoldenportErrorException;
import org.xmlsmartdoc.goldenport.engine.GoldenportException;
import org.xmlsmartdoc.goldenport.engine.IPort;
import org.xmlsmartdoc.goldenport.engine.PortContext;
import org.xmlsmartdoc.goldenport.engine.PortNodeList;

import com.AsamiOffice.io.UURL;
import com.AsamiOffice.text.UString;

/**
 * WhatsNewMaker
 *
 * @since   Apr. 12, 2004
 * @version May. 22, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class WhatsNewMaker extends AbstractPortMakder {
    public static final String WHATSNEW_NS = "http://www.xmlsmartdoc.org/xmlns/goldenport/whatsnew";
    public static final String ELEMENT_WHATSNEW = "whatsnew";
    private static final String ATTRIBUTE_SRC = "src";
    private static final String ATTRIBUTE_BASE_DATE = "base-date";
    private static final String ATTRIBUTE_PERIOD = "period";
    private static final String ATTRIBUTE_TABLE = "table";
    private static final String ATTRIBUTE_LINK = "link";
    private static final String ELEMENT_HISTORY = "history";
    private static final String ATTRIBUTE_TYPE = "type";
    private static final String ATTRIBUTE_DATE = "date";
    //
    private static final String ELEMENT_UL = "ul";    
    private static final String ELEMENT_LI = "li";
    private static final String ELEMENT_A = "a";
    private static final String ATTRIBUTE_HREF = "href";
    private static final String ELEMENT_TABLE = "table";
    private static final String ATTRIBUTE_TITLE = "title";
    private static final String ELEMENT_TBODY = "tbody";
    private static final String ELEMENT_TR = "tr";
    private static final String ELEMENT_TD = "td";
    private static final long ONE_SECOND = 1000; 
    private static final long ONE_MINUTE  = 60 * ONE_SECOND; 
    private static final long ONE_HOUR = 60 * ONE_MINUTE; 
    private static final long ONE_DAY = 24 * ONE_HOUR; 
    private static final long ONE_MONTH = 30 * ONE_DAY; 
    private static final long ONE_YEAR = 365; 

    private String baseDate_;
    private String period_;
    private String widePeriod_;
    private int minimumNumber_ = 5;
    private String table_;
    private String link_;
    private boolean debug_ = false;

    public WhatsNewMaker(
        IPort port,
        Element element,
        PortNodeList halfResult,
        PortContext context,
        PortNodeList result
    ) {
        super(port, element, halfResult, context, result);
        baseDate_ = getAdjustedProperty(ATTRIBUTE_BASE_DATE);
        period_ = getAdjustedProperty(ATTRIBUTE_PERIOD);
        table_ = getAdjustedProperty(ATTRIBUTE_TABLE);
        link_ = getAdjustedProperty(ATTRIBUTE_LINK);
    }
    
    public void setBaseDate(String text) {
        baseDate_ = text;
    }
    
    public void setPeriod(String text) {
        period_ = text;
    }
    
    public void setTable(String text) {
        table_ = text;
    }
    
    public void minumumBnumber(int number) {
        minimumNumber_ = number;
    }

    public void make() throws GoldenportException {
        try {
            List targets = new ArrayList();
            File dir = getTargetDirectory(ATTRIBUTE_SRC);
            collectTargets_(dir, targets);
            List histories = new ArrayList();
            collectHistory_(targets, histories);
            filterHistory_(histories);
            sortHistory_(histories);
            listHistory_(histories);
            makeWhatsNew_(histories);
        } catch (SAXException e) {
            throw (make_error_(e));
        } catch (IOException e) {
            throw (make_error_(e));
        }
    }

    private GoldenportException make_error_(Exception e) {
        return (new GoldenportException("WhatsNewMaker", e));
    }

    private void collectTargets_(File dir, List targets) {
        File[] files = dir.listFiles();
        log_("wn:directory = " + dir.getAbsolutePath());
        if (files == null) {
            return;
        }
        for (int i = 0;i < files.length;i++) {
            File file = files[i];
            if (file.isDirectory()) {
                collectTargets_(file, targets);
            } else {
                if (file.getName().endsWith(".sdoc")) {
                    targets.add(file);
                    log_("wn:target = " + file.getAbsolutePath());
                }
            }
        }
    }

    private void log_(String message) {
        if (debug_) {
            System.out.println(message);
        }
    }

    private void collectHistory_(List targets, List list)
      throws SAXException, IOException {
        Object[] array = targets.toArray();
        for (int i = 0;i < array.length;i++) {
            File file = (File)array[i];
            collectHistory_(file, _context, list);
        }
    }

    private void collectHistory_(
        File file,
        PortContext context,
        List list
    ) throws SAXException, IOException {
        log_("wn:target = " + file.getAbsolutePath());
        DocumentBuilder builder = context.getDocumentBuilder();
        Document doc = builder.parse(file);
        Element root = doc.getDocumentElement();
        NodeList elements = getElements_(doc, WHATSNEW_NS, ELEMENT_HISTORY);
        int size = elements.getLength();
        for (int i = 0;i < size;i++) {
            Element element = (Element)elements.item(i);
            String path = getPath_(file, context);
            String type = element.getAttribute(ATTRIBUTE_TYPE);
            String date = element.getAttribute(ATTRIBUTE_DATE);
            History history = new History(path, type, date, element);
            log_("wn:History = " + history);
            list.add(history);
        }
    }

    private String getPath_(File file, PortContext context) {
        String filePathName = file.getAbsoluteFile().toString();
        File baseDir = context.getBaseDirectory().getAbsoluteFile();
        String baseDirPathName = baseDir.toString();
        String[] filePath = UString.getTokens(filePathName, "/\\");
        String[] baseDirPath = UString.getTokens(baseDirPathName, "/\\");
        int index = findCommonPath_(filePath, baseDirPath);
        StringBuffer sb = new StringBuffer();
        int backs = baseDirPath.length - index;
        if (backs < 0) {
            throw (new GoldenportErrorException());
        }
        while (backs-- > 0) {
            sb.append("../");
        }
        if (index < filePath.length) {
            sb.append(filePath[index]);
        }
        for (int i = index + 1;i < filePath.length;i++) {
            sb.append("/");
            sb.append(filePath[i]);
        }
        return (new String(sb));
    }

    private int findCommonPath_(String[] filePath, String[] baseDirPath) {
        int length = Math.min(filePath.length, baseDirPath.length);
        for (int i = 0;i < length;i++) {
             if (!filePath[i].equals(baseDirPath[i])) {
                 return (i);
             }
        }
        return (length);
    }

    private NodeList getElements_(Document doc, String ns, String name) {
        if (ns == null) {
            return (doc.getElementsByTagName(name));
        } else {
            return (doc.getElementsByTagNameNS(ns, name));
        }
    }

    private void filterHistory_(List histories) 
      throws GoldenportException {
        try {
            long start = getFilterStart_();
            long end = getEnd_();
            Object[] array = histories.toArray();
            histories.clear();
            for (int i = 0; i < array.length; i++) {
                History history = (History)array[i];
                long target = getTime_(history.date);
                if (start <= target && target < end) {
                    histories.add(history);
                } 
            }
        } catch (IllegalArgumentException e) {
            throw (new GoldenportException("", e));
        }
    }
    
    private long getFilterStart_()
        throws IllegalArgumentException, NumberFormatException {
          long base;
          if (baseDate_ != null) {
              base = getTime_(baseDate_);
          } else {
              base = System.currentTimeMillis(); 
          }
          long period;
          if (widePeriod_ != null) {
              period = getWidePeriod_();
          } else {
              period = ONE_MONTH * 6;
          }
          return (base - period);
    }

    private long getStart_()
      throws IllegalArgumentException, NumberFormatException {
        long base;
        if (baseDate_ != null) {
            base = getTime_(baseDate_);
        } else {
            base = System.currentTimeMillis(); 
        }
        long period;
        if (period_ != null) {
            period = getPeriod_();
        } else {
            period = ONE_MONTH;
        }
        return (base - period);
    }

    private long getEnd_()
      throws IllegalArgumentException, NumberFormatException {
        if (baseDate_ == null) {
            return (System.currentTimeMillis());
        } else {
            return (getTime_(baseDate_) + ONE_DAY);
        }
    }

    private long getPeriod_() 
    throws IllegalArgumentException, NumberFormatException {
          int number = getNumber_(period_);
          String mark = getMark_(period_);
          return getPeriod_(number, mark);
    }

    private long getWidePeriod_()
      throws IllegalArgumentException, NumberFormatException {
        int number = getNumber_(widePeriod_);
        String mark = getMark_(widePeriod_);
        return getPeriod_(number, mark);
    }

    private long getPeriod_(int number, String mark) {
        if ("D".equals(mark)) {
            return (number * ONE_DAY);
        } else if ("M".equals(mark)) {
            return (number * ONE_MONTH); // TODO
        } else if ("Y".equals(mark)) {
            return (number * ONE_YEAR); // TODO
        } else {
            throw (new IllegalArgumentException(mark));
        }
    }

    private int getNumber_(String period) throws NumberFormatException {
        String text = period.substring(0, period.length() - 1);
        text = text.substring(1);
        return (Integer.parseInt(text));
    }

    private String getMark_(String period) {
        return (period.substring(period.length() - 1));
    }

    private long getTime_(String text) {
        Date date = Date.valueOf(text);
        return (date.getTime());
    }

    private void sortHistory_(List histories) {
        if (debug_) {
            log_("wn:beforeSort");
            dumpHistory_(histories);
        }
        Collections.sort(
            histories, 
            new Comparator() {
                public int compare(Object lhs, Object rhs) {
                    History lh = (History)lhs;
                    History rh = (History)rhs;
                    long ldate = getTime_(lh.date);
                    long rdate = getTime_(rh.date);
                    long result = ldate - rdate;
                    if (result == 0) {
                        return (0);
                    } else if (result > 0) {
                        return (1);
                    } else {
                        return (-1);
                    }
/*
System.out.println((ldate - rdate) + ":" + ((int)(ldate - rdate)));
                    return ((int)(ldate - rdate));
*/
                }
            }
        );
        Collections.reverse(histories);
        if (debug_) {
            log_("wn:afterSort");
            dumpHistory_(histories);
        }
    }

    private void dumpHistory_(List histories) {
        Object[] array = histories.toArray();
        for (int i = 0;i < array.length;i++) {
            log_("wn:" + array[i]);
        }
    }

    private void listHistory_(List histories) 
      throws GoldenportException {
        try {
            long start = getStart_();
            long end = getEnd_();
            Object[] array = histories.toArray();
            if (array.length <= minimumNumber_) {
                return;
            }
            histories.clear();
            for (int i = 0; i < minimumNumber_; i++) {
                History history = (History)array[i];
                histories.add(history);
            }
            for (int i = minimumNumber_;i < array.length;i++) {
                History history = (History)array[i];
                long target = getTime_(history.date);
                if (!(start <= target && target < end)) {
                    break;
                } 
                histories.add(history);
            }
        } catch (IllegalArgumentException e) {
            throw (new GoldenportException("", e));
        }
    }

    private void makeWhatsNew_(List histories) {
        if (histories.size() == 0) {
            return;
        }
        Document doc = _result.getFactoryDocument();
        String ns = _element.getNamespaceURI();
        _result.setNamespace(ns);
        if ("true".equals(table_)) {
            makeWhatsNewTable_(histories);
        } else {
            makeWhatsNewUl_(histories);
        }
    }
    
    private void makeWhatsNewTable_(List histories) {
        Element table = _result.createElement(ELEMENT_TABLE);
        table.setAttribute(ATTRIBUTE_TITLE, "What's New");
        _result.setElement(table);
        Element tbody = _result.addElement(ELEMENT_TBODY);
        Object[] array = histories.toArray();
        for (int i = 0;i < array.length;i++) {
            History whatsNew = (History)array[i];
            makeWhatsNewTable_(whatsNew, tbody);
        }
    }

    private void makeWhatsNewTable_(History history, Element tbody) {
        Element tr = _result.addElement(tbody, ELEMENT_TR);
        Element td = _result.addElement(tr, ELEMENT_TD);
        _result.addString(td, getMonthDay_(history));
        _result.addString(td, "/");
        makeWhatsNewLink_(history, td);
    }

    private void makeWhatsNewLink_(History history, Element td) {
        if (!"false".equals(link_)) {
            Element a = _result.addElement(td, ELEMENT_A);
            a.setAttribute(ATTRIBUTE_HREF, adjustSuffix_(history.uri));
            _result.addChildren(a, history.content);
        } else {
            _result.addChildren(td, history.content);
        }
    }

    private void makeWhatsNewTable0_(History history, Element tbody) {
        Element tr = _result.addElement(tbody, ELEMENT_TR);
        Element td = _result.addElement(tr, ELEMENT_TD);
        _result.addString(td, getMonthDay_(history));
        td = _result.addElement(tr, ELEMENT_TD);
        Element a = _result.addElement(td, ELEMENT_A);
        a.setAttribute(ATTRIBUTE_HREF, adjustSuffix_(history.uri));
        _result.addChildren(a, history.content);
    }

    private void makeWhatsNewUl_(List histories) {
        Element ul = _result.createElement(ELEMENT_UL);
        _result.setElement(ul);
        Object[] array = histories.toArray();
        for (int i = 0;i < array.length;i++) {
            History whatsNew = (History)array[i];
            makeWhatsNewUl_(whatsNew);
        }
    }

    private void makeWhatsNewUl_(History history) {
        Element li = _result.addElement(ELEMENT_LI);
        makeWhatsNewLi_(history, li);
    }

    private void makeWhatsNewLi_(History history, Element li) {
        _result.addString(li, getMonthDay_(history));
        _result.addString(li, "/");
        makeWhatsNewLink_(history, li);
    }

    private String adjustSuffix_(String name) {
        String suffix = getProperty("suffix");
        if (suffix != null) {
            return (UString.changeSuffix(name, suffix));
        } else {
            return (suffix);
        }
    }

    private String getMonthDay_(History history) {
        return (getMonthDayISO_(history));
    }
    
    private String getMonthDayISO_(History history) {
        return (history.date);
    }

    private String getMonthDaySlash_(History history) {
        Date date = Date.valueOf(history.date);
        DateFormat format = DateFormat.getDateInstance();
        return (format.format(date));
    }

    public File getTargetDirectory(String attrName) 
      throws MalformedURLException {
        File baseDir = _context.getBaseDirectory();
        String uri = _element.getAttribute(attrName);
        if (UString.isNull(uri)) {
            return (baseDir);
        } else {
            URL url = getFile_(uri, baseDir);
            File file = UURL.getActiveFile(url);
            if (file == null) {
                throw (new UnsupportedOperationException());
            }
            if (file.isDirectory()) {
                return (file);
            } else {
                return (file.getParentFile());
            }
        }
    }

    private URL getFile_(String uri, File baseDir) 
      throws MalformedURLException {
        try {
            return (new URL(uri));
        } catch (MalformedURLException e) {
        }
        File file = new File(uri);
        if (file.isAbsolute()) {
            return (file.toURL());
        } else {
            return (new File(baseDir, uri).toURL());
        }
    }

    class History {
        String uri;
        String type; // new, update
        String date;
        Element content;
        
        public History(
            String uri, 
            String kind, 
            String date, 
            Element content
        ) {
            this.uri = uri;
            this.type = kind;
            this.date = date;
            this.content = content;
        }

        public String toString() {
            return (uri + " [" + date + "]");
        }
    }
}
