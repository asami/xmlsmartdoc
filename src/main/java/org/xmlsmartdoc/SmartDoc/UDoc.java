/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2005  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc;

import java.io.IOException;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.util.UException;

import org.apache.oro.text.perl.Perl5Util;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.AsamiOffice.util.D2Array;
import com.AsamiOffice.util.ULocale;
import com.AsamiOffice.xml.UXMLMaker;

/**
 * UDoc
 *
 * @since   Nov. 14, 1998
 * @version May.  5, 2005
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public final class UDoc {
    public static Content[] list2Contents(List list) {
        Content[] contents = new Content[list.size()];
        list.toArray(contents);
        return (contents);
    }

    public static Container getRoot(Content content) {
        for (;;) {
            Container container = content.getParent();
            if (container == null) {
                break;
            }
            content = container;
        }
        return ((Container)content);
    }

    /**
     * make raw text embeded in tag.
     * does not treat children elements.
     */
    public static String makeInlineText(Container container) {
        return (makeInlineText(container.getContents()));
    }

    public static String makeInlineText(Content[] contents) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof CharBlock) {
                buffer.append(((CharBlock)content).getText());
            }
        }
        return (
            UString.trimEmptyLines(
                UString.makeCanonicalString(new String(buffer))
            )
        );
    }

    /**
     * distill text recursively
     */
    public static String distillText(Container container) {
        return (distillText(container.getContents()));
    }

    public static String distillText(Content[] contents) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            distillText(content, buffer);
        }
        return (new String(buffer));
    }

    public static void distillText(Content content, StringBuffer buffer) {
        if (content instanceof CharBlock) {
            buffer.append(((CharBlock)content).getText());
        } else if (content instanceof Container) {
            Content[] contents = ((Container)content).getContents();
            for (int i = 0;i < contents.length;i++) {
                distillText(contents[i], buffer);
            }
        }
    }   

    public static void selectFormat(Container container, String[] formats) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            String format = content.getFormat();
            if (isAvailableFormat(format, formats)) {
                if (content instanceof Container) {
                    selectFormat((Container)content, formats);
                }
            } else {
                container.removeContent(content);
            }
        }
    }

    public static boolean isAvailableFormat(String lhs, String[] rhs) {
        if (lhs == null) {
            return (true);
        }
        for (int i = 0;i < rhs.length;i++) {
            if (lhs.equals(rhs[i])) {
                return (true);
            }
        }
        return (false);
    }

    public static boolean isAvailableFormat(String[] lhs, String[] rhs) {
        if (lhs == null) {
            return (true);
        }
        for (int i = 0;i < lhs.length;i++) {
            if (isAvailableFormat(lhs[i], rhs)) {
                return (true);
            }
        }
        return (false);
    }

    public static boolean isActiveContent(
        Content content,
        DocContext context
    ) {
        // format
        String targetFormat = context.getFormat();
        String format = content.getFormat();
        if (format != null && targetFormat != null) {
            String[] formats;        // XXX : more generic
            if ("latex2e".equals(targetFormat)) {
                formats = new String[] { "latex2e", "latex" };
            } else if ("html4".equals(targetFormat)) {
                formats = new String[] { "html4", "html" };
            } else {
                formats = new String[] { targetFormat };
            }
            if (!UString.compareTokens(format, formats)) {
                return (false);
            }
        }
        // locale
        Locale locale = content.getLocale();
        Locale targetLocale = context.getLocale();
        if (locale != null && targetLocale != null) {
            if (!locale.equals(targetLocale)) {
                return (false);
            }
        }
        // key
        String key = content.getKey();
        String regex = context.getKey();
        if (key != null && regex != null) {
            Perl5Util util = new Perl5Util();
            if (!util.match("#" + regex + "#m", key)) {
                return (false);
            }
        }
        return (true);
    }

    public static Locale getDisplayLocale(Content content) {
        String lang = content.getLanguage();
        if (lang != null) {
            return (ULocale.makeLocale(lang));
        }
        Locale locale = content.getLocale();
        if (locale != null) {
            return (locale);
        }
        return (Locale.getDefault());
    }

    public static void copyAttr(Content from, Content to) {
        to.lang_ = from.lang_;
        to.id_ = from.id_;
        to.clazz_ = from.clazz_;
        to.style_ = from.style_;
        to.format_ = from.format_;
        to.locale_ = from.locale_;
        to.src_ = from.src_;
        to.title_ = from.title_;
    }

    public static Content[] makeContents(Object object) {
        if (object instanceof Node) {
            return (new Content[] {
                new CharBlock(UXMLMaker.getXMLText((Node)object))
            });
        } else if (object instanceof Content) {
            return (new Content[] { (Content)object });
        } else if (object instanceof Content[]) {
            return ((Content[])object);
        } else {
            return (new Content[] {
                new CharBlock(object.toString())
            });
        }
    }

    public static Content[] makeContentsSmartDoc(Object object) {
        if (object instanceof String) {
            String text = "<div>" + (String)object + "</div>";
            try {
                SmartDocModel model = SmartDocContext.getContext().getModel();
                DocumentBuilderFactory factory
                    = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                InputSource is = new InputSource(new StringReader(text));
                Document doc = builder.parse(is);
                Content[] contents = model.buildContents(
                    doc.getDocumentElement()
                );
                return (contents);
            } catch (ParserConfigurationException e) {
                return (_makeErrorContents(e.getMessage()));
            } catch (SAXException e) {
                return (_makeErrorContents(e.getMessage()));
            } catch (IOException e) {
                return (_makeErrorContents(e.getMessage()));
            }
        } else if (object instanceof Node) {
            return (makeContentsSmartDoc((Node)object));
        } else if (object instanceof Content) {
            return (new Content[] { (Content)object });
        } else if (object instanceof Content[]) {
            return ((Content[])object);
        } else {
            return (_makeErrorContents(object.toString()));
        }
    }

    private static Content[] _makeErrorContents(String message) {
        return (
            new Content[] {
                new CharBlock(message)
            }
        );
    }

    public static Content[] makeContentsSmartDoc(Node node) {
        SmartDocModel model = SmartDocContext.getContext().getModel();
        Element dummy = node.getOwnerDocument().createElement("div");
        dummy.appendChild(node);
        Content[] contents = model.buildContents(dummy);
        return (contents);
    }

    public static Content[] makeContentsFromException(Exception e) {
        return (new Content[] { new CharBlock(UException.getDetailInfo(e)) });
    }

    public static Content[] importSmartDoc(
        Document xml,
        Content content,
        DocContext context,
        SmartDocModel model
    ) throws IOException {
        Doc doc = model.build(xml, context);
        doc = model.expand(doc, context);
        importDocTitle(doc, content);
        Body body = doc.getBody();
        if (body == null) {
            return (null);
        }
        Content[] result = body.getContents();
        for (int i = 0;i < result.length;i++) {
            result[i].setDocContext(context);
        }
        return (result);
    }

    public static void importDocTitle(Doc doc, Content content) {
        Head head = doc.getHead();
        if (head != null) {
            Content[] headContents = head.getContents();
            for (int i = 0;i < headContents.length;i++) {
                Content hContent = headContents[i];
                if (hContent instanceof Title) {
                    setTitleIfPossible(content, (Title)hContent);
                }
            }
        }
    }

    public static void setTitleIfPossible(Content content, Title title) {
        Locale locale = title.getLocale();
        if (content instanceof TitledBlock) {
            TitledBlock block = (TitledBlock)content;
            if (locale != null) {
                if (!isMacroTitle_(block, title, locale)) {
                    if (block.getTitleNode(locale) == null) {
                        block.setTitle(title, locale);
                    }
                }
            } else {
                if (!isMacroTitle_(block, title, null)) {
                    if (block.getTitleNode() == null) {
                        block.setTitle(title);
                    }
                }
            }
        } else {
            // content.setTitle(title.getText()); // XXX
        }
    }

    private static boolean isMacroTitle_(
        TitledBlock block,
        Title title,
        Locale locale
    ) {
        Content[] children = block.getContents();
        for (int i = 0;i < children.length;i++) {
            Content child = children[i];
            if (child instanceof MacroTitle &&
                ((locale == null && child.getLocale() == null) ||
                 locale.equals(child.getLocale()))
            ) { // TODO more precisely locale selection
                return (true);
            }
        }
        return (false);
    }

    public static Table resultSet2Table(ResultSet rs) throws SQLException {
        ResultSetMetaData metadata = rs.getMetaData();
        THead thead = d2Array2THead(resultSetMetaData2D2Array(metadata));
        TBody tbody = resultSet2TBody(rs);
        Table table = new Table();
        table.addContent(thead);
        table.addContent(tbody);
        return (table);
    }

    public static Content[] resultSet2THeadTBody(
        ResultSet rs
    ) throws SQLException {
        ResultSetMetaData metadata = rs.getMetaData();
        THead thead = d2Array2THead(resultSetMetaData2D2Array(metadata));
        TBody tbody = resultSet2TBody(rs);
        return (new Content[] { thead, tbody });
    }

    public static THead resultSet2THead(ResultSet rs) throws SQLException {
        return (d2Array2THead(resultSet2D2Array(rs)));
    }

    public static TFoot resultSet2TFoot(ResultSet rs) throws SQLException {
        return (d2Array2TFoot(resultSet2D2Array(rs)));
    }

    public static TBody resultSet2TBody(ResultSet rs) throws SQLException {
        return (d2Array2TBody(resultSet2D2Array(rs)));
    }

    public static Content[] resultSet2TrTh(ResultSet rs) throws SQLException {
        return (d2Array2TrTh(resultSet2D2Array(rs)));
    }

    public static Content[] resultSet2TrTd(ResultSet rs) throws SQLException {
        return (d2Array2TrTd(resultSet2D2Array(rs)));
    }

    public static Content[] resultSet2Tds(ResultSet rs) throws SQLException {
        return (d2Array2Tds(resultSet2D2Array(rs)));
    }

    public static D2Array resultSetMetaData2D2Array(
        ResultSetMetaData metadata
    ) throws SQLException {
        int width = metadata.getColumnCount();
        D2Array array = new D2Array();
        for (int i = 0;i < width;i++) {
            array.put(i, 0, metadata.getColumnLabel(i + 1));
        }
        return (array);
    }

    public static D2Array resultSet2D2Array(ResultSet rs) throws SQLException {
        D2Array array = new D2Array();
        ResultSetMetaData metadata = rs.getMetaData();
        int width = metadata.getColumnCount();
        int y = 0;
        while (rs.next()) {
            for (int x = 0;x < width;x++) {
                array.put(x, y, rs.getString(x + 1));
            }
            y++;
        }
        return (array);
    }

    public static Table d2Array2Table(D2Array body) {
        TBody tbody = d2Array2TBody(body);
        Table table = new Table();
        table.addContent(tbody);
        return (table);
    }

    public static THead d2Array2THead(D2Array head) {
        THead thead = new THead();
        thead.addContents(d2Array2TrTh(head));
        return (thead);
    }

    public static TFoot d2Array2TFoot(D2Array foot) {
        TFoot tfoot = new TFoot();
        tfoot.addContents(d2Array2TrTh(foot));
        return (tfoot);
    }

    public static TBody d2Array2TBody(D2Array body) {
        TBody tbody = new TBody();
        tbody.addContents(d2Array2TrTd(body));
        return (tbody);
    }

    public static Content[] d2Array2Tr(
        D2Array d2array,
        Content content
    ) {
        if (isAncestor(content, THead.class) ||
            isAncestor(content, TFoot.class)) {

            return (d2Array2TrTh(d2array));
        } else if (isAncestor(content, TBody.class)) {
            return (d2Array2TrTd(d2array));
        } else {
            return (d2Array2TrTd(d2array));
        }
    }

    public static Content[] d2Array2TrTh(D2Array d2array) {
        List list = new ArrayList();
        int width = d2array.getWidth();
        int height = d2array.getHeight();
        for (int y = 0;y < height;y++) {
            Tr tr = new Tr();
            for (int x = 0;x < width;x++) {
                Object data = d2array.get(x, y);
                Th th;
                if (data != null) {
                    th = new Th(data.toString());
                } else {
                    th = new Th();
                }
                tr.addContent(th);
            }
            list.add(tr);
        }
        Content[] contents = new Content[list.size()];
        return ((Content[])list.toArray(contents));
    }

    public static Content[] d2Array2TrTd(D2Array d2array) {
        List list = new ArrayList();
        int width = d2array.getWidth();
        int height = d2array.getHeight();
        for (int y = 0;y < height;y++) {
            Tr tr = new Tr();
            for (int x = 0;x < width;x++) {
                Object data = d2array.get(x, y);
                Td td;
                if (data != null) {
                    td = new Td(data.toString());
                } else {
                    td = new Td();
                }
                tr.addContent(td);
            }
            list.add(tr);
        }
        Content[] contents = new Content[list.size()];
        return ((Content[])list.toArray(contents));
    }

    public static Content[] d2Array2Tds(D2Array d2array) {
        int width = d2array.getWidth();
        Content[] contents = new Content[width];
        for (int x = 0;x < width;x++) {
            Object data = d2array.get(x, 0);
            Td td;
            if (data != null) {
                td = new Td(data.toString());
            } else {
                td = new Td();
            }
            contents[x] = td;
        }
        return (contents);
    }

    public static Content[] table2Tr(
        TableModel model,
        Content content
    ) {
        if (isAncestor(content, THead.class) ||
            isAncestor(content, TFoot.class)) {

            return (table2TrTh(model));
        } else if (isAncestor(content, TBody.class)) {
            return (table2TrTd(model));
        } else {
            return (table2TrTd(model));
        }
    }

    public static Content[] table2TrTh(TableModel model) {
        List list = new ArrayList();
        int width = model.getColumnCount();
        int height = model.getRowCount();
        for (int y = 0;y < height;y++) {
            Tr tr = new Tr();
            for (int x = 0;x < width;x++) {
                Object data = model.getValueAt(y, x);
                Th th;
                if (data != null) {
                    th = new Th(data.toString());
                } else {
                    th = new Th();
                }
                tr.addContent(th);
            }
            list.add(tr);
        }
        Content[] contents = new Content[list.size()];
        return ((Content[])list.toArray(contents));
    }

    public static Content[] table2TrTd(TableModel model) {
        List list = new ArrayList();
        int width = model.getColumnCount();
        int height = model.getRowCount();
        for (int y = 0;y < height;y++) {
            Tr tr = new Tr();
            for (int x = 0;x < width;x++) {
                Object data = model.getValueAt(y, x);
                Td td;
                if (data != null) {
                    td = new Td(data.toString());
                } else {
                    td = new Td();
                }
                tr.addContent(td);
            }
            list.add(tr);
        }
        Content[] contents = new Content[list.size()];
        return ((Content[])list.toArray(contents));
    }

    public static TOCNode getTOCTree(Container container) {
        TOCNode root;
        if (container instanceof Part ||
            container instanceof Chapter ||
            container instanceof Section ||
            container instanceof SubSection ||
            container instanceof SubSubSection ||
            container instanceof Bibliography) {

            root = new TOCNode((TitledBlock)container);
        } else {
            root = new TOCNode();
        }
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof Container) {
                getTOCTree((Container)content, root);
            }
        }
        return (root);
    }

    public static void getTOCTree(Container container, TOCNode current) {
        if (container instanceof Part ||
            container instanceof Chapter ||
            container instanceof Section ||
            container instanceof SubSection ||
            container instanceof SubSubSection ||
            container instanceof Bibliography) {

            TOCNode heading = new TOCNode((TitledBlock)container);
            current.add(heading);
            current = heading;
        }
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof Container) {
                getTOCTree((Container)content, current);
            }
        }
    }

    public static TitledBlock[] getHeadingPath(Content content) {
        List list = new ArrayList();
        while (content != null) {
            if (content instanceof TitledBlock &&
                !(content instanceof Appendix)) {
                list.add(content);
            }
            content = content.getParent();
        }
        TitledBlock[] path = new TitledBlock[list.size()];
        int j = path.length - 1;
        for (int i = 0;i < path.length;i++) {
            path[j--] = (TitledBlock)list.get(i);
        }
        return (path);
    }

    public static TitledBlock[] getHeadings(Container container) {
        List list = new ArrayList();
        getHeadings(container, list);
        TitledBlock[] headings = new TitledBlock[list.size()];
        return ((TitledBlock[])list.toArray(headings));
    }

    public static void getHeadings(Container container, List list) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof TitledBlock &&
                !(content instanceof Appendix)) {
                list.add(content);
            }
            if (content instanceof Container) {
                getHeadings((Container)content, list);
            }
        }
    }

    public static Section[] getSections(Container container) {
        List list = new ArrayList();
        getSections(container, list);
        Section[] sections = new Section[list.size()];
        return ((Section[])list.toArray(sections));
    }

    public static void getSections(Container container, List list) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof Section) {
                list.add(content);
            } else if (content instanceof Container) {
                getSections((Container)content, list);
            }
        }
    }

    public static boolean isAncestor(Content content, Class type) {
        for (Content current = content;
             current != null;
             current = current.getParent()) {

            if (type.isInstance(current)) {
                return (true);
            }
        }
        return (false);
    }

    public static String getAbsoluteId(Content content) {
        DocContext context = content.getDocContext();
        if ("true".equals(content.getAttribute("id.absolute"))) {
            return (content.getID());
        }
        return (context.getID() + "_" + content.getID());
//        String id = content.getExplicitID();
//        if (id != null) {
//            return (id);
//        }
//        return ("id_" + content.getID() + "_");
    }
    
    public static String getAbsoluteIdref(Content content) {
        DocContext context = content.getDocContext();
        if ("true".equals(content.getAttribute("id.absolute"))) {
            return (content.getID());
        }
        return (context.getID() + "_" + content.getIdref());
    }

    public static String getParentTitledBlockNo(Content content) {
        TitledBlock block = getParentTitledBlock(content);
        if (block == null) {
            return (null);
        }
        return (getTitleNo(block));
    }

    public static String getTitleNo(Content content) {
        return (getTitleNo(content, "-"));
    }

    public static String getTitleNo(Content content, String delimiter) {
        if (!(content instanceof TitledBlock)) {
            throw (new InternalError());
        }
        TitledBlock titled = (TitledBlock)content;
        if (!titled.isSequencable()) {
            return ("");
        }
        if (titled instanceof Part) {
            if (isAppendixChild_(titled)) {
                return (makeAppendixNumber_(titled.getSeqNumber()));
            } else {
                return (Integer.toString(titled.getSeqNumber()));
            }
        }
        List list = new ArrayList();
        for (Content current = content;
             current != null;
             current = current.getParent()) {

            if (current instanceof Part) {
                break;
            }
            if (current instanceof TitledBlock) {
                TitledBlock title = (TitledBlock)current;
                int number = title.getSeqNumber();
                if (number > 0) {
                    if (isAppendixChild_(title)) {
                        list.add(makeAppendixNumber_(number));
                    } else {
                        list.add(new Integer(number));
                    }
                }
            }
        }
        StringBuffer buffer = new StringBuffer();
        int size = list.size();
        if (size == 0) {
            return (null);
        }
        buffer.append(list.get(size - 1));
        for (int i = size - 2;i >= 0;i--) {
            buffer.append(delimiter);
            buffer.append(list.get(i));
        }
        return (new String(buffer));
    }

    private static boolean isAppendixChild_(TitledBlock content) {
        for (Content current = content.getParent();
             current != null;
             current = current.getParent()) {
             
             if (current instanceof Appendix) {
                 return (true);
             }
             if (current instanceof TitledBlock) {
                 return (false);
             }
        }
        return (false);
    }

    private static String makeAppendixNumber_(int number) {
        switch (number) {
          case 1:
            return ("A");
          case 2:
            return ("B");
          case 3:
            return ("C");
          case 4:
            return ("D");
          case 5:
            return ("E");
          case 6:
            return ("F");
          case 7:
            return ("G");
          case 8:
            return ("H");
          case 9:
            return ("I");
          case 10:
            return ("J");
          case 11:
            return ("K");
          case 12:
            return ("L");
          case 13:
            return ("M");
          case 14:
            return ("N");
          case 15:
            return ("O");
          case 16:
            return ("P");
          case 17:
            return ("Q");
          case 18:
            return ("R");
          case 19:
            return ("S");
          case 20:
            return ("T");
          case 21:
            return ("U");
          case 22:
            return ("V");
          case 23:
            return ("W");
          case 24:
            return ("X");
          case 25:
            return ("Y");
          case 26:
            return ("Z");
          default:
            return (Integer.toString(number));
        }
    }

    public static TitledBlock getParentTitledBlock(Content content) {
        for (Content current = content;
             current != null;
             current = current.getParent()) {

            if (current instanceof TitledBlock) {
                return ((TitledBlock)current);
            }
        }
        return (null);
    }

    public static Chapter getParentChapter(Content content) {
        for (Content current = content;
             current != null;
             current = current.getParent()) {

            if (current instanceof Chapter) {
                return ((Chapter)current);
            }
        }
        return (null);
    }

    public static Appendix getParentAppendix(Content content) {
        for (Content current = content;
             current != null;
             current = current.getParent()) {

            if (current instanceof Appendix) {
                return ((Appendix)current);
            }
        }
        return (null);
    }

    public static String getSequenceNumberBasedSubSubSection(Content content) {
        SequenceNumber number = content.getSequenceNumber();
        if (number == null) {
            return (null);
        }
        TitledBlock titledBlock = getParentTitledBlock(content);
        int noInBlock = 0;
        String blockNumber = "";
        if (titledBlock instanceof Chapter) {
            noInBlock = number.getNumberInChapter();
            blockNumber = getTitleNo(titledBlock, ".");
        } else if (titledBlock instanceof Section) {
            noInBlock = number.getNumberInSection();
            blockNumber = getTitleNo(titledBlock, ".");
        } else if (titledBlock instanceof SubSection) {
            noInBlock = number.getNumberInSubSection();
            blockNumber = getTitleNo(titledBlock, ".");
        } else if (titledBlock instanceof SubSubSection) {
            noInBlock = number.getNumberInSubSubSection();
            blockNumber = getTitleNo(titledBlock, ".");
        }
        if (noInBlock == 0) {
            noInBlock = number.getNumberInDoc();
            blockNumber = "";
        } else {
            blockNumber = blockNumber + ".";
        }
        return (blockNumber + noInBlock);
    }

    public static String getSequenceNumberBasedChapter(Content content) {
        SequenceNumber number = content.getSequenceNumber();
        if (number == null) {
            return (null);
        }
        Chapter chapter = getParentChapter(content);
        int noInBlock = 0;
        String blockNumber = "";
        if (chapter != null) {
            noInBlock = number.getNumberInChapter();
            blockNumber = getTitleNo(chapter, ".") + ".";
        } else {
            Appendix appendix = getParentAppendix(content);
            if (appendix != null) {
                noInBlock = number.getNumberInAppendix();
                blockNumber = getTitleNo(chapter, ".") + ".";
            } else {
                noInBlock = number.getNumberInDoc();
                blockNumber = "";
            }
        }
        return (blockNumber + noInBlock);
    }

    public static String getSequenceNumberLabel(Content link) {
        if (link instanceof ImageFigure) {
            return (getSequenceNumberBasedChapter(link));
        } else if (link instanceof Table) {
            return (getSequenceNumberBasedChapter(link));
        } else if (link instanceof Console) {
            return (getSequenceNumberBasedChapter(link));
        } else if (link instanceof Program) {
            return (getSequenceNumberBasedChapter(link));
        } else if (link instanceof Part) {
            return (getTitleNo(link, "."));
        } else if (link instanceof Chapter) {
            return (getTitleNo(link, "."));
        } else if (link instanceof Section) {
            return (getTitleNo(link, "."));
        } else if (link instanceof SubSection) {
            return (getTitleNo(link, "."));
        } else if (link instanceof SubSubSection) {
            return (getTitleNo(link, "."));
        } else if (link instanceof Equation) {
            return (getSequenceNumberBasedChapter(link));
        } else if (link instanceof Bibitem) {
            return (getSequenceNumberBasedSubSubSection(link));
        } else if (link instanceof Note) {
            Note note = (Note)link;
            return (Integer.toString(note.getNumber()));
        } else {
            return (null);
        }
    }

    public static String getFilenamePostString(Doc doc) {
        Locale locale = doc.getDocContext().getLocale();
        if (locale == null) {
            return ("");
        } else {
            Locale masterLocale = 
                SmartDocContext.getContext().getConfig().getMasterLocale();
            if (locale.equals(masterLocale)) {
                return ("");
            } else {
                return ("_" + locale.toString());
            }
        }
    }

    public static Content[] cloneContents(Content[] contents) {
        Content[] result = new Content[contents.length];
        for (int i = 0;i < result.length;i++) {
            result[i] = contents[i].deepClone();
        }
        return (result);
    }

    public static String getDocTitle(Content content) {
        Doc doc = content.getDoc();
        Head head = doc.getHead();
        Title title = head.getDocTitle();
        return (title.getText());
    }

    public static String getAuthor(Content content) {
        Doc doc = content.getDoc();
        Head head = doc.getHead();
        return (head.getAuthor());
    }

    public static String getShortSummary(Content content) {
        Doc doc = content.getDoc();
        Head head = doc.getHead();
        Summary summary = head.getSummary();
        if (summary == null) {
            return (null);
        }
        return (summary.getTitle());
    }

    public static String getSummary(Content content) {
        Doc doc = content.getDoc();
        Head head = doc.getHead();
        Summary summary = head.getSummary();
        if (summary == null) {
            return (null);
        }
        return (distillText(summary));
    }

    public static String adjustStringInContext(
        String text,
        Content content
    ) {
        Content child = content;
        for (;;) {
            Container parent = child.getParent();
            if (parent instanceof Doc) {
                break;
            }
            if (parent.getContent(0) != child) {
                return (text);
            }
            if (parent instanceof Sentence) {
                break;
            }
            child = parent;
        }
        return (makeTitleString(text));
    }

    public static String makeTitleString(String text) {
        if (text == null) {
            throw (new InternalError());
        }
        if (text.length() == 0) {
            return (text);
        }
        if (Character.isTitleCase(text.charAt(0))) {
            return (text);
        }
        char[] chars = text.toCharArray();
        chars[0] = Character.toTitleCase(chars[0]);
        return (new String(chars));
    }

    public static String makePrefixSuffixLabel(
        Content link,
        String[] parts
    ) {
        StringBuffer buffer = new StringBuffer();
        if (parts[0] != null && parts[0].length() > 0) {
            buffer.append(parts[0]);
            if (USmartDoc.isWordSeparateLang(parts[0].charAt(0))) {
                buffer.append(" ");
            }
        }
        String number = getSequenceNumberLabel(link);
        if (number != null) {
            buffer.append(number);
        }
        if (parts[1] != null) {
            buffer.append(parts[1]);
        }
        return (new String(buffer));
    }

    public static void traverse(
        Content content,
        ISmartDocVisitor visitor
    ) {
        if (!content.enter(visitor)) {
            return;
        }
        if (content instanceof Container) {
            Container container = (Container)content;
            Content[] children = container.getContents();
            for (int i = 0;i < children.length;i++) {
                traverse(children[i], visitor);
            }
        }
        content.leave(visitor);
    }

    public static Content[] getContentsByPath(Content content, String path) {
        if (path.equals(".")) {
            return (new Content[] { content.deepClone() });
        } else if (path.equals("*")) {
            return (getContentsFromChildren(content, path));
        } else if (path.startsWith("@")) {
            return (getContentsByAttribute(content, path.substring(1)));
        } else {
            throw (new UnsupportedOperationException());
        }
    }

    public static Content[] getContentsFromChildren(
        Content content,
        String path
    ) {
        if (content instanceof Container) {
            Container container = (Container)content.deepClone();
            return (container.getContents());
        } else {
            return (null);
        }
    }        

    public static Content[] getContentsByAttribute(
        Content content,
        String attr
    ) {
        return (new Content[] { new CharBlock(content.getAttribute(attr)) });
    }

    public static boolean isFirstParagraph(Paragraph p) {
        Container parent = p.getParent();
        if (parent instanceof TitledBlock) {
            Content[] contents = parent.getContents();
            for (int i = 0;i < contents.length;i++) {
                Content content = contents[i];
                if (content instanceof Paragraph) {
                    if (content == p) {
                        return (true);
                    } else {
                        return (false);
                    }
                }
            }
            throw (new InternalError());
        } else {
            return (false);
        }
    }

    public static boolean isJaStyleFirstParagraph(Paragraph p) {
        if (!isFirstParagraph(p)) {
            return (false);
        }
        return (isJaStyleParagraph(p));
    }

    public static boolean isJaStyleParagraph(Paragraph p) {
        String language = p.getLanguage();
        if (language == null) {
            return (false);
        }
        return (language.startsWith("ja"));
    }
}
