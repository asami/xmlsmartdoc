/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.xhtml;

import org.xmlsmartdoc.SmartDoc.AbstractXMLGeneratorBase;
import org.xmlsmartdoc.SmartDoc.CSSStyle;
import org.xmlsmartdoc.SmartDoc.Container;
import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.Doc;
import org.xmlsmartdoc.SmartDoc.Head;
import org.xmlsmartdoc.SmartDoc.TOCNode;
import org.xmlsmartdoc.SmartDoc.Table;
import org.xmlsmartdoc.SmartDoc.Td;
import org.xmlsmartdoc.SmartDoc.Th;
import org.xmlsmartdoc.SmartDoc.Title;
import org.xmlsmartdoc.SmartDoc.TitledBlock;
import org.xmlsmartdoc.SmartDoc.TrContent;
import org.xmlsmartdoc.SmartDoc.UDoc;
import org.xmlsmartdoc.SmartDoc.xhtml.handler.SimpleXHTMLIndicatorHandler;

import com.AsamiOffice.util.D2Array;

/**
 * AbstractXHTMLGeneratorBase
 *
 * @since   May.  7, 1999
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class AbstractXHTMLGeneratorBase
    extends AbstractXMLGeneratorBase {

    public static final String PREV_ID ="doc_prev_page_";
    public static final String NEXT_ID ="doc_next_page_";

    protected IXHTMLDynamicHandler dynamic_;
    protected IXHTMLIndicatorHandler indicator_;

    protected AbstractXHTMLGeneratorBase() {
        indicator_ = new SimpleXHTMLIndicatorHandler();
    }

    protected void _setIndicatorHandler(IXHTMLIndicatorHandler handler) {
        indicator_ = handler;
    }

    protected void _setDynamicHandler(IXHTMLDynamicHandler handler) {
        dynamic_ = handler;
    }

    protected void _makeIndicatorTop(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        Pointer[] prevnext = _getPrevNextAsPointer(container);
        if (prevnext[0] != null) {
            StringBuffer temp = new StringBuffer(prevnext[0].prologue);
            temp.setCharAt(temp.length() - 1, ' ');
            temp.append("id=\"");
            temp.append(PREV_ID);
            temp.append("\">");
            prevnext[0].prologue = new String(temp);
        }
        if (prevnext[1] != null) {
            StringBuffer temp = new StringBuffer(prevnext[1].prologue);
            temp.setCharAt(temp.length() - 1, ' ');
            temp.append("id=\"");
            temp.append(NEXT_ID);
            temp.append("\">");
            prevnext[1].prologue = new String(temp);
        }
        if (prevnext[0] != null || prevnext[1] != null) {
            buffer.append(
                indicator_.getTopIndicator(
                    _getPointer(container),
                    _getPathAsPointer(container),
                    prevnext[0],
                    prevnext[1]
                )
            );
        }
    }

    protected void _makeIndicatorBottom(
        Head head,
        Container container,
        StringBuffer buffer
    ) {
        Pointer[] prevnext = _getPrevNextAsPointer(container);
        if (prevnext[0] != null || prevnext[1] != null) {
            buffer.append(
                indicator_.getBottomIndicator(
                    _getPointer(container),
                    _getPathAsPointer(container),
                    prevnext[0],
                    prevnext[1]
                )
            );
        }
    }

    protected void _makeTOCNodes(Container container, StringBuffer buffer) {
        _makeTOCNodes(container, false, buffer);
    }

    protected void _makeTOCNodes(
        Container container,
        boolean withNumber,
        StringBuffer buffer
    ) {
        _makeTOCNodes(container, withNumber, false, buffer);
    }

    protected void _makeTOCNodes(
        Container container,
        boolean withNumber,
        boolean isXhtml,
        StringBuffer buffer
    ) {
        TOCNode node = container.getTOCTree();
        TitledBlock heading = node.getHeading();
        String rootFile = getLogicalFile(container);
        heading = null;                // XXX
        if (heading != null) {
            Title title = heading.getTitleNode();
            String id = _getID(heading);
            String file = getLogicalFile(heading);
            buffer.append("<ul>\n");
            buffer.append("<li> ");
            String link;
            link = file + "#" + id; // XXX
            if (title != null) {
                _embedRefTag(link, title, buffer);
            } else {
                // XXX : worning
            }
            buffer.append("\n");
            _makeTOCNodes(node, rootFile, 1, withNumber, isXhtml, buffer);
            if (isXhtml) {
                buffer.append("</li>\n");
            }
            buffer.append("</ul>\n");
        } else {
            _makeTOCNodes(node, rootFile, 1, withNumber, isXhtml, buffer);
        }
    }

    protected void _makeTOCNodes(
        TOCNode node,
        String rootFile,
        int depth,
        boolean withNumber,
        boolean isXhtml,
        StringBuffer buffer
    ) {
        int size = node.getChildCount();
        if (size == 0) {
            return;
        }
        if (dynamic_ != null && depth > 1) {
            String attr = dynamic_.getEvent("expandhide");
            if (attr != null) {
                buffer.append("<ul ");
                buffer.append(attr);
                buffer.append(">");
            } else {
                buffer.append("<ul>\n");
            }
        } else {
            buffer.append("<ul>\n");
        }
        for (int i = 0;i < size;i++) {
            TOCNode child = (TOCNode)node.getChildAt(i);
            TitledBlock heading = child.getHeading();
            Title title = heading.getTitleNode();
            String number;
            if (withNumber) {
                number = UDoc.getTitleNo(heading, ".");
                if (number != null) {
                    number = number + "  ";
                } else {
                    number = "";
                }
            } else {
                number = "";
            }
            String id = _getID(heading);
            String file = getLogicalFile(heading);
            if (file.equals(rootFile)) {
                file = "";
            }
            buffer.append("<li> ");
            String link;
            link = file + "#" + id;
            if (title != null) {
                _embedRefTag(link, number, title, buffer);
            } else {
                // XXX : warning
            }
            if (dynamic_ != null && child.getChildCount() > 0) {
                String toggle = dynamic_.getToggle();
                if (toggle != null) {
                    buffer.append(" ");
                    buffer.append(toggle);
                }
            }
            buffer.append("\n");
            _makeTOCNodes(
                child,
                rootFile,
                depth + 1,
                withNumber,
                isXhtml,
                buffer
            );
            if (isXhtml) {
                buffer.append("</li>\n");
            }
        }
        buffer.append("</ul>\n");
    }

    protected void _embedTableData(
        D2Array data,
        Table table,
        StringBuffer buffer
    ) {
        int width = data.getWidth();
        int height = data.getHeight();
        for (int y = 0;y < height;y++) {
            buffer.append("<tr");
            if ((y % 2) == 0) {
                buffer.append(" class=\"even\"");
            } else {
                buffer.append(" class=\"odd\"");
            }
            buffer.append(">\n");
            for (int x = 0;x < width;x++) {
                TrContent content = (TrContent)data.get(x, y);
                if (content == null) {
                    continue;
                }
                String tag;
                if (content instanceof Th) {
                    tag = "th";
                } else if (content instanceof Td) {
                    tag = "td";
                } else {
                    throw (new InternalError());
                }
                String clazz = _getCellClass(content, table, x, y);
                CSSStyle style = _getCellStyle(content, table, x, y);
                int rowspan = content.getRowSpan();
                int colspan = content.getColSpan();
                String align = _getCellAlign(content, table, x, y);
                buffer.append("<");
                buffer.append(tag);
                if (clazz != null) {
                    buffer.append(" class=\"");
                    buffer.append(clazz);
                    buffer.append("\"");
                }
                if (style != null) {
                    _embedAttr("style", style.getText(), buffer);
                }
                if (rowspan != 1) {
                    _embedAttr("rowspan", rowspan, buffer);
                }
                if (colspan != 1) {
                    _embedAttr("colspan", colspan, buffer);
                }
                if (align != null) {
                    _embedAttr("align", align, buffer);
                }
                buffer.append(">");
                _makeString(content, buffer);
                buffer.append("</");
                buffer.append(tag);
                buffer.append(">\n");
            }
            buffer.append("</tr>\n");
        }
    }

    protected String _getCellClass(
        TrContent cell,
        Table table,
        int x,
        int y
    ) {
        String clazz = cell.getClazz();
        if (clazz != null) {
            return (clazz);
        }
        if (table != null) {
            return (table.getClazz(x, y));
        } else {
            return (null);
        }
    }

    protected CSSStyle _getCellStyle(
        TrContent cell,
        Table table,
        int x,
        int y
    ) {
        return (cell.getStyle());
    }

    protected String _getCellAlign(
        TrContent cell,
        Table table,
        int x,
        int y
    ) {
        return (cell.getAlign());
    }

    protected void _embedRefTag(
        String href,
        String content,
        StringBuffer buffer
    ) {
        _embedRefTagPrologue(href, buffer);
        buffer.append(_escape(content));
        _embedRefTagEpilogue(buffer);
    }

    protected void _embedRefTag(
        String href,
        Content content,
        StringBuffer buffer
    ) {
        _embedRefTagPrologue(href, content, buffer);
        _makeString(content, buffer);
        _embedRefTagEpilogue(buffer);
    }

    protected void _embedRefTag(
        String href,
        String prefix,
        Content content,
        StringBuffer buffer
    ) {
        _embedRefTagPrologue(href, content, buffer);
        buffer.append(prefix);
        _makeString(content, buffer);
        _embedRefTagEpilogue(buffer);
    }

    protected void _embedRefTagPrologue(String href, StringBuffer buffer) {
        String type;
        if (href.charAt(0) == '#') {
            type = "selflink";
        } else if (href.startsWith("http:")) {
            type = "externallink";
        } else {
            type = "hyperlink";
        }
        buffer.append("<a href=\"");
        buffer.append(_escape(href));
        buffer.append("\"");
        if (type.equals("externallink")){
            _embedRefTagPrologueExternalLinkAttributes(href, buffer);
        }
        if (dynamic_ != null) {
            String script = dynamic_.getEvent(type);
            if (script != null) {
                buffer.append(" ");
                buffer.append(script);
            }
        }
        buffer.append(">");
    }

    protected void _embedRefTagPrologue(
        String href,
        Content content,
        StringBuffer buffer
    ) {
        String type;
        if (href.charAt(0) == '#') {
            type = "selflink";
        } else if (href.startsWith("http:")) {
            type = "externallink";
        } else {
            type = "hyperlink";
        }
        _embedTagPrologue("a", content, buffer);
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append(" href=\"");
        buffer.append(_escape(href));
        buffer.append("\"");
        if (type.equals("externallink")){
            _embedRefTagPrologueExternalLinkAttributes(href, buffer);
        }
        if (dynamic_ != null) {
            String script = dynamic_.getEvent(type);
            if (script != null) {
                buffer.append(" ");
                buffer.append(script);
            }
        }
        buffer.append(">");
    }

    protected void _embedRefTagPrologueExternalLinkAttributes(
        String href,
        StringBuffer buffer
    ) {
        buffer.append(" target=\"_top\"");
    }

    protected void _embedRefTagEpilogue(StringBuffer buffer) {
        buffer.append("</a>");
    }

    protected Pointer _getPointer(Content content) {
        Pointer pointer = new Pointer();
        pointer.content = content;
        String file = getLogicalFile(content);
        String link;
        if (content instanceof Doc) { // XXX : more generic
            Doc doc = (Doc)content;
            Head head = doc.getHead();
            pointer.title = "";
            if (head != null) {
                Title title = head.getDocTitle();
                if (title != null) {
                    pointer.title = title.getText();
                }
            }
            link = file;
        } else {
            pointer.title = content.getTitle();
            link = file + "#" + _getID(content);
        }
        StringBuffer buffer = new StringBuffer();
        _embedRefTagPrologue(link, buffer);
        pointer.prologue = new String(buffer);
        buffer = new StringBuffer();
        _embedRefTagEpilogue(buffer);
        pointer.epilogue = new String(buffer);
        return (pointer);
    }

    protected Pointer _getPointerFile(Content content) {
        Pointer pointer = new Pointer();
        pointer.content = content;
        String link = getLogicalFile(content);
        StringBuffer buffer = new StringBuffer();
        _embedRefTagPrologue(link, buffer);
        pointer.prologue = new String(buffer);
        buffer = new StringBuffer();
        _embedRefTagEpilogue(buffer);
        pointer.epilogue = new String(buffer);
        return (pointer);
    }

    protected Pointer[] _getPathAsPointer(Content content) {
        Doc doc = (Doc)UDoc.getRoot(content);
        TitledBlock[] path = UDoc.getHeadingPath(content);
        Pointer[] pointers = new Pointer[path.length + 1];
        pointers[0] = _getPointer(doc);
        for (int i = 0;i < path.length;i++) {
            pointers[i + 1] = _getPointer(path[i]);
        }
        return (pointers);
    }

    protected Pointer[] _getPrevNextAsPointer(Content content) {
        Content[] pair = _getPrevNext(content);
        Pointer[] pointers = new Pointer[2];
        if (pair[0] != null) {
            pointers[0] = _getPointerFile(pair[0]);
        }
        if (pair[1] != null) {
            pointers[1] = _getPointerFile(pair[1]);
        }
        return (pointers);
    }

    protected Content[] _getPrevNext(Content content) {
        Doc doc = (Doc)UDoc.getRoot(content);
        TitledBlock[] headings = UDoc.getHeadings(doc);
        if (headings.length == 0) {
            return (new Content[] { null, null } );
        }
        String currentFile = getLogicalFile(content);
        String rootFile = getLogicalFile(doc);
        String prevFile = null;
        String nextFile = null;
        Content prev = null;
        Content next = null;
        for (int i = 0;i < headings.length;i++) {
            if (headings[i] == content) {
                if (i > 0) {
                    for (int j = i - 1;j >= 0;j--) {
                        prevFile = getLogicalFile(headings[j]);
                        if (!prevFile.equals(currentFile)) {
                            prev = headings[j];
                            break;
                        }
                    }
                    if (prevFile.equals(currentFile)) {
                        prevFile = rootFile;
                        prev = doc;
                    }
                } else {
                    prevFile = rootFile;
                    prev = doc;
                }
                if (i < headings.length - 1) {
                    for (int j = i + 1;j < headings.length;j++) {
                        nextFile = getLogicalFile(headings[j]);
                        if (!nextFile.equals(currentFile)) {
                            next = headings[j];
                            break;
                        }
                    }
                    if (nextFile.equals(currentFile)){
                        nextFile = null;
                        next = null;
                    }
                }
                break;
            }
        }
        if (prevFile == null && nextFile == null) {
            nextFile = getLogicalFile(headings[0]);
            next = headings[0];
        }
        return (new Content[] { prev, next });
    }
}
