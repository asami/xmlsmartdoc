/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.AsamiOffice.jaba2.j2fw.J2Monitor;
import com.AsamiOffice.text.UString;

import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.AsamiOffice.io.UFile;
import com.AsamiOffice.io.UURL;

/**
 * USmartDoc
 *
 * @since   Nov.  1, 1998
 * @version Mar. 15, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public final class USmartDoc {
    private static boolean debug__ = false;

    public static void setDebug(boolean debug) {
        debug__ = debug;
    }

    public static boolean hasPolicy(String policies, String policy) {
        if (policies == null) {
            return (false);
        }
        return (policies.indexOf(policy) != -1);
    }

    public static String getAlloc(String policy) {
        String alloc;
        if (policy == null) {
            alloc = "whole";
        } else if ("whole".equals(policy)) {
            alloc = "whole";
        } else if ("part".equals(policy)) {
            alloc = "part";
        } else if ("chapter".equals(policy)) {
            alloc = "chapter";
        } else if ("section".equals(policy)) {
            alloc = "section";
        } else if ("subsection".equals(policy)) {
            alloc = "subsection";
        } else if ("subsubsection".equals(policy)) {
            alloc = "subsubsection";
        } else {
            throw (new InternalError(policy));
        }
        return (alloc);
    }

    // XXX : UCUI
    public static boolean isWordSeparateLang(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub.equals(Character.UnicodeBlock.BASIC_LATIN) ||
            ub.equals(Character.UnicodeBlock.LATIN_1_SUPPLEMENT) ||
            ub.equals(Character.UnicodeBlock.LATIN_EXTENDED_A) ||
            ub.equals(Character.UnicodeBlock.LATIN_EXTENDED_B)) {

            return (true);
        } else {
            return (false);
        }
    }   

    public static boolean isWordSeparate(String before, String after) {
        if (before.length() == 0) {
            return (false);
        }
        if (after.length() == 0) {
            return (false);
        }
        return (
            isWordSeparateLang(before.charAt(before.length() - 1)) &&
            isWordSeparateLang(before.charAt(0))
        );
    }

    public static void embedNewline(StringBuffer buffer) {
        buffer.append("\n");        // normalization
    }

    public static String getString(Element element) {
        return (_getRawString(element).trim());
    }

    public static String importText(String src, DocContext context) {
        try {
            URL url = makeURL(src, context);
            return (UString.makeCanonicalStringFromURL(url));
        } catch (MalformedURLException e) {
            warning("can not access : " + src);
        } catch (IOException e) {
            warning("can not access : " + src);
        }
        throw (new InternalError());
    }

    public static String importText(
        String src,
        String encoding,
        DocContext context
    ) {
        try {
            URL url = makeURL(src, context);
            return (UString.makeCanonicalStringFromURL(url, encoding));
        } catch (MalformedURLException e) {
            warning("can not access : " + src);
        } catch (IOException e) {
            warning("can not access : " + src);
        }
        throw (new InternalError());
    }

    public static URL makeURL(String uri, DocContext context)
        throws MalformedURLException {

        try {
            URL url = new URL(uri);
            return (url);
        } catch (MalformedURLException e) {
            String base = context.getBaseDirectory();
            String revisedUri = makeURLName(uri, base);
            try {
                URL url = new URL(revisedUri);
                return (url);
            } catch (MalformedURLException ee) {
                return (new File(revisedUri).toURL());
            }
        }
    }

    public static String makeURLName(String uri, DocContext context) {
        return (makeURLName(uri, context.getBaseDirectory()));
    }

    public static String makeURLName(String uri, String base) {
        if (base == null) {
            try {
                return (new File(uri).toURL().toExternalForm());
            } catch (MalformedURLException e) {
            }
        }
        if (base.endsWith("/")) {
            return (base + uri);
        } else {
            return (base + "/" + uri);
        }
    }

    public static String makeDirectoryContext(String uri) {
        return (UString.getContainerPathname(uri));
    }

    public static String importText(String src) {
        String text = null;
        try {
            URL url = UURL.getURLFromFileOrURLName(src);
            String[] lines = UString.makeStringListFromURL(url);
            StringBuffer buffer = new StringBuffer();
            for (int i = 0;i < lines.length;i++) {
                String line = lines[i];
                buffer.append(line);
                embedNewline(buffer);
            }
            text = new String(buffer);
        } catch (MalformedURLException e) {
            warning("can not access : " + src);
        } catch (IOException e) {
            warning("can not access : " + src);
        }
        return (text);
    }

    public static String importText(String src, String encoding) {
        String text = null;
        try {
            URL url = UURL.getURLFromFileOrURLName(src);
            text = UString.makeStringFromURL(url, encoding);
        } catch (MalformedURLException e) {
            warning("can not access : " + src);
        } catch (IOException e) {
            warning("can not access : " + src);
        }
        return (text);
    }

    public static String expandTab(String string) {
        StringBuffer buffer = new StringBuffer();
        int size = string.length();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            if (c == '\t') {
                buffer.append("        ");
            } else {
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }

/*
    public static String[] makeStringList(String string) {
        // 0 : init
        // 1 : after cr
        // 2 : after lf
        // 3 : after crlf
        // 4 : after normal
        int status = 0;
        List list = new ArrayList();
        int size = string.length();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i < size;i++) {
            char c = string.charAt(i);
            switch (status) {

            case 0:
                if (c == '\r') {
                    status = 1;
                } else if (c == '\n') {
                    status = 2;
                } else {
                    buffer.append(c);
                    status = 4;
                }
                break;
            case 1:
                if (c == '\r') {
                    list.add(new String(buffer));
                    buffer = new StringBuffer();
                    status = 1;
                } else if (c == '\n') {
                    status = 3;
                } else {
                    list.add(new String(buffer));
                    buffer = new StringBuffer();
                    buffer.append(c);
                    status = 4;
                }
                break;
            case 2:
                if (c == '\r') {
                    // illegal sequence
                    status = 1;
                    throw (new InternalError("debug"));
                } else if (c == '\n') {
                    list.add(new String(buffer));
                    buffer = new StringBuffer();
                    status = 2;
                } else {
                    list.add(new String(buffer));
                    buffer = new StringBuffer();
                    buffer.append(c);
                    status = 4;
                }
                break;
            case 3:
                if (c == '\r') {
                    list.add(new String(buffer));
                    buffer = new StringBuffer();
                    status = 1;
                } else if (c == '\n') {
                    // illegal sequence
                    status = 2;
                    throw (new InternalError("debug"));
                } else {
                    list.add(new String(buffer));
                    buffer = new StringBuffer();
                    buffer.append(c);
                    status = 4;
                }
                break;
            case 4:
                if (c == '\r') {
                    status = 1;
                } else if (c == '\n') {
                    status = 2;
                } else {
                    buffer.append(c);
                    status = 4;
                }
                break;
            default:
                throw (new InternalError());
            }
        }
        if (status != 0) {
            list.add(new String(buffer));
        }
        String[] strings = new String[list.size()];
        return ((String[])list.toArray(strings));
    }
*/

    /**
     * @deprecated
     */
    // XXX : trim?
    protected static void _getString(Element element, StringBuffer buffer) {
        NodeList list = element.getChildNodes();
        int size = list.getLength();
        for (int i = 0;i < size;i++) {
            Node node = list.item(i);
            switch (node.getNodeType()) {

            case Node.ELEMENT_NODE:
                _getString(element, buffer);
                break;
            case Node.TEXT_NODE:
                buffer.append(((Text)node).getData());
                break;
            }
        }
    }

    /**
     * @deprecated
     */
    protected static String _getRawString(Element element) {
        StringBuffer buffer = new StringBuffer();
        NodeList list = element.getChildNodes();
        int size = list.getLength();
        for (int i = 0;i < size;i++) {
            Node node = list.item(i);
            switch (node.getNodeType()) {

            case Node.ELEMENT_NODE:
                _getString((Element)node, buffer);
                break;
            case Node.TEXT_NODE:
                buffer.append(((Text)node).getData());
                break;
            case Node.CDATA_SECTION_NODE:
                throw (new UnsupportedOperationException("cdata"));
            case Node.ENTITY_REFERENCE_NODE:
                _getString((EntityReference)node, buffer);
                break;
            case Node.ENTITY_NODE:
                throw (new UnsupportedOperationException("entity"));
            }
        }
        return (new String(buffer));
    }

    /**
     * @deprecated
     */
    protected static String _getString(EntityReference eref) {
        StringBuffer buffer = new StringBuffer();
        _getString(eref, buffer);
        return (new String(buffer));
    }

    /**
     * @deprecated
     */
    protected static void _getString(
        EntityReference eref,
        StringBuffer buffer
    ) {
        NodeList list = eref.getChildNodes();
        int size = list.getLength();
        for (int i = 0;i < size;i++) {
            Node node = list.item(i);
            switch (node.getNodeType()) {

            case Node.TEXT_NODE:
                buffer.append(((Text)node).getData());
                break;
            default:
                throw (new InternalError("bad node = " + node.getNodeType()));
            }
        }
    }

    /**
     * @deprecated
     */
    protected void _distillText(Container container, StringBuffer buffer) {
        Content[] contents = container.getContents();
        for (int i = 0;i < contents.length;i++) {
            Content content = contents[i];
            if (content instanceof CharBlock) {
                buffer.append(((CharBlock)content).getText());
            }
        }
    }

    public static String getImageFilename(
        String[] srcs,
        String[] candidates
    ) {
System.out.println("getImageFilename is used...");
        if (candidates == null) {
            return (null);
        }
        for (int i = 0;i < srcs.length;i++) {
            String src = srcs[i];
            for (int j = 0;j < candidates.length;j++) {
                String suffix = UString.getSuffix(src);
                if (suffix != null) {
                    if (suffix.equals(candidates[j])) {
                        return (src);
                    }
                } else {
                    String file = src + "." + candidates[j];
                    if (UFile.isExist(file)) {
                        return (file);
                    }
                }
            }
        }
        return (null);
    }

    public static String getImageFilename(
        String[] srcs,
        String[] candidates,
        DocContext context
    ) {
        if (candidates == null) {
            return (null);
        }
        for (int i = 0;i < srcs.length;i++) {
            String src = srcs[i];
            String srcFileName = getImageFilename(srcs[i], context);
            for (int j = 0;j < candidates.length;j++) {
                String suffix = UString.getSuffix(src);
                String candidate = candidates[j];
                if (suffix != null) {
                    if (suffix.equals(candidate)) {
                        return (src);
                    }
                } else {
                    String file = srcFileName + "." + candidate;
                    if (UFile.isExist(file)) {
                        return (src + "." + candidate);
                    }
                }
            }
        }
        return (null);
    }

    public static String getImageFilename(String src, DocContext context) {
        String subContext = context.getSubContextAgainstRootXmlBase();
        if (subContext == null || "".equals(subContext)) {
            return (src);
        }
        if (subContext.endsWith("/")) {
            return (subContext + src);
        } else {
            return (subContext + "/" + src);
        }
    }

    public static void info(String message) {
        J2Monitor monitor = SmartDocContext.getContext().getMonitor();
        monitor.info(message);
    }

    public static void warningMessage(String message) {
        J2Monitor monitor = SmartDocContext.getContext().getMonitor();
        monitor.warning(message);
    }

    public static void warning(String message)
        throws SmartDocWarningException {

        J2Monitor monitor = SmartDocContext.getContext().getMonitor();
        monitor.warning(message);
        if (debug__) {
            throw (new InternalError(message));
        } else {
            throw (new SmartDocWarningException(message));
        }
    }

    public static void error(String message)
        throws SmartDocErrorException {

        J2Monitor monitor = SmartDocContext.getContext().getMonitor();
        monitor.error(message);
        if (debug__) {
            throw (new InternalError(message));
        } else {
            throw (new SmartDocErrorException(message));        
        }    
    }

    public static void traceEnter(AbstractSmartDocGenerator generator, Content content) {
        info(generator.getName() + "[Enter]" + getTraceString(content));
    }

    public static void traceLeave(AbstractSmartDocGenerator generator, Content content) {
        info(generator.getName() + "[Leave]" + getTraceString(content));
    }
    
    public static String getTraceString(Content content) {
        if (content instanceof Part) {
            Part part = (Part)content;
            return ("part:" + part.getTitle());
        } else if (content instanceof Chapter) {
            Chapter chapter = (Chapter)content;
            return ("chapter:" + chapter.getTitle());
        } else if (content instanceof Section) {
            Section section = (Section)content;
            return ("section:" + section.getTitle());
        } else if (content instanceof SubSection) {
            SubSection subsection = (SubSection)content;
            return ("subsection:" + subsection.getTitle());
        } else if (content instanceof SubSubSection) {
            SubSubSection subsubsection = (SubSubSection)content;
            return ("subsubsection:" + subsubsection.getTitle());
        } else if (content instanceof Table) {
            Table table = (Table)content;
            return ("table:" + table.getTitle());
        } else {
            return (content.toString());
        }
    }
}
