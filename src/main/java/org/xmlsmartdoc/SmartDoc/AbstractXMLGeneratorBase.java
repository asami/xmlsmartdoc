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

package org.xmlsmartdoc.SmartDoc;

import java.util.Locale;

import org.xmlsmartdoc.SmartDoc.html4.UHTML4;

import org.w3c.dom.Element;

import com.AsamiOffice.xml.UXMLMaker;

/**
 * AbstractXMLGeneratorBase
 *
 * @since   May.  7, 1999
 * @version May.  9, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class AbstractXMLGeneratorBase
    extends AbstractStringBufferSmartDocGeneratorBase {

    protected void _makeExternalElement(
        ExternalElement external,
        StringBuffer buffer
    ) {
        Element element = external.getElement();
        String namespaceURI = element.getNamespaceURI();
        if (namespaceURI != null) {
            if ("http://www.xmlsmartdoc.org/xmlns/goldenport".equals(namespaceURI) ||
                "http://www.relaxer.org/xmlns/goldenport".equals(namespaceURI)) {
                return;
            }
        }
        buffer.append(UXMLMaker.getXMLText(element));
        _info("external element : " + UXMLMaker.getXMLText(element));
    }

    // AbstractGeneratorBase
    protected String _escape(String string) {
        if (string == null) {
            return ("");
        }
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            switch (c) {

            case '<':
                buffer.append("&lt;");
                break;
            case '>':
                buffer.append("&gt;");
                break;
            case '&':
                buffer.append("&amp;");
                break;
            case '"':
                buffer.append("&quot;");
                break;
            default:
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

    protected String _getID(Content content) {
        if (config_.isIdGlobal()) {
            String id = content.getExplicitID();
            if (id != null) {
                return (id);
            }            
        }
        return (UDoc.getAbsoluteId(content));
    }

    protected void _makeInlineTag(
        String tagname,
        Content content,
        StringBuffer buffer
    ) {
        _embedTagPrologue(tagname, content, buffer);
        _makeString(content, buffer);
        _embedTagEpilogue(tagname, buffer);
    }

    protected void _makeInlineBlockTag(
        String tagname,
        Content content,
        StringBuffer buffer
    ) {
        _embedTagPrologue(tagname, content, buffer);
        _makeString(content, buffer);
        _embedTagEpilogue(tagname, buffer);
        buffer.append("\n");
    }

    protected void _makeBlockTag(
        String tagname,
        Content content,
        StringBuffer buffer
    ) {
        _embedTagPrologue(tagname, content, buffer);
        buffer.append("\n");
        _makeText(content, buffer);
        _embedTagEpilogue(tagname, buffer);
        buffer.append("\n");
    }

    protected void _embedTagPrologue(
        String tagname,
        Content content,
        StringBuffer buffer
    ) {
        String id = _getID(content);
        String clazz = content.getClazz();
        CSSStyle style = content.getStyle();
        String lang = content.getExplicitLanguage();
        String space = content.getExplicitSpace();
        Locale locale = content.getExplicitLocale();

        buffer.append("<");
        buffer.append(tagname);
        if (content.hasReferer()) {
            _embedAttr("id", id, buffer);
        }
        if (clazz != null) {
            _embedAttr("class", clazz, buffer);
        }
        if (style != null) {
            _embedAttr("style", style.getText(), buffer);
        }
        if (lang != null) {
            _embedAttr("xml:lang", UHTML4.getHTML4Lang(lang), buffer); // XXX
/*
        } else {
            if (locale != null) {
                _embedAttr(
                    "lang",
                    UHTML4.getHTML4Lang(locale.toString()), // XXX
                    buffer
                );
            }
*/
        }
        if (space != null) {
            _embedAttr("xml:space", space, buffer);
        }
        buffer.append(">");
    }

    protected void _embedAttrAppend(
        String name,
        String value,
        StringBuffer buffer
    ) {
        buffer.deleteCharAt(buffer.length() - 1); // ">"
        buffer.append(" ");
        buffer.append(name);
        buffer.append("=\"");
        buffer.append(_escape(value));
        buffer.append("\"");
        buffer.append(">");
    }

    protected void _embedXhtmlTagCloseAppend(
        StringBuffer buffer
    ) {
        buffer.deleteCharAt(buffer.length() - 1); // ">"
        buffer.append(" />");
    }

    protected void _embedTagEpilogue(String tagname, StringBuffer buffer) {
        buffer.append("</");
        buffer.append(tagname);
        buffer.append(">");
    }

    protected void _embedAttr(String name, String value, StringBuffer buffer) {
        buffer.append(" ");
        buffer.append(name);
        buffer.append("=\"");
        buffer.append(_escape(value));
        buffer.append("\"");
    }

    protected void _embedAttr(String name, int value, StringBuffer buffer) {
        buffer.append(" ");
        buffer.append(name);
        buffer.append("=\"");
        buffer.append(value);
        buffer.append("\"");
    }
}
