/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@AsamiOffice.com)
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
package com.AsamiOffice.xml;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.AsamiOffice.text.UString;

/**
 * UXML
 *
 * @since   Jul.  1, 1998
 * @version Apr.  9, 2004
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public final class UXML {
    public static String escapeAscii(String text) {
        if (isAsciiText(text)) {
            return (text);
        }
        StringBuffer buffer = new StringBuffer();
        int size = text.length();
        for (int i = 0; i < size; i++) {
            char c = text.charAt(i);
            if (UString.isAscii(c)) {
                buffer.append(c);
            } else {
                buffer.append("&#");
                buffer.append(Integer.toHexString(c));
                buffer.append(";");
            }
        }
        return (new String(buffer));
    }

    public static boolean isAsciiText(String text) {
        int size = text.length();
        for (int i = 0; i < size; i++) {
            char c = text.charAt(i);
            if (!UString.isAscii(c)) {
                return (false);
            }
        }
        return (true);
    }

/*
    public static Element findElement(Document doc, String tag) {
        Element element = doc.getDocumentElement();
        if (tag.equals(element.getTagName())) {
            return (element);
        }
        return (findElement(element, tag));
    }

    public static Element findElement(Element element, String tag) {
        NodeList nodes = element.getChildNodes();
        int nNodes = nodes.getLength();
        for (int i = 0; i < nNodes; i++) {
            Node child = nodes.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element)child;
                if (tag.equals(e.getTagName())) {
                    return (e);
                }
                Element result = findElement(e, tag);
                if (result != null) {
                    return (result);
                }
            }
        }
        return (null);
    }

    public static String findData(Document doc, String tag) {
        return (findData(doc.getDocumentElement(), tag));
    }

    public static String findData(Element element, String tag) {
        Element e = findElement(element, tag);
        if (e == null) {
            return (null);
        } else {
            return (UDOM.getTextValue(e));
        }
    }
    public static String element2Data(Element element) {
        return (element2Text(element).trim());
    }

    public static String element2Text(Element element) {
        return (node2Text(element));
    }

    public static String nodes2Text(Node[] nodes) {
        StringBuffer buffer = new StringBuffer();
        int nNodes = nodes.length;
        for (int i = 0; i < nNodes; i++) {
            node2Text(nodes[i], buffer);
        }
        return (new String(buffer));
    }

    public static String node2Text(Node node) {
        StringBuffer buffer = new StringBuffer();
        node2Text(node, buffer);
        return (new String(buffer));
    }

    public static void node2Text(Node node, StringBuffer buffer) {
        switch (node.getNodeType()) {

            case Node.DOCUMENT_NODE :
            case Node.ELEMENT_NODE :
                NodeList nodes = node.getChildNodes();
                int nNodes = nodes.getLength();
                for (int i = 0; i < nNodes; i++) {
                    node2Text(nodes.item(i), buffer);
                }
                break;
            case Node.ATTRIBUTE_NODE :
                throw (new UnsupportedOperationException("not supported yet"));
            case Node.COMMENT_NODE :
                throw (new UnsupportedOperationException("not supported yet"));
            case Node.TEXT_NODE :
                Text text = (Text)node;
                buffer.append(text.getData());
                break;
            default :
                throw (new UnsupportedOperationException("not supported yet"));
        }
    }
*/
    public static boolean hasXMLDeclaration(URL url) throws IOException {
        String encoding = guessXMLEncoding(url);
        BufferedReader reader = null;
        try {
            reader =
                new BufferedReader(
                    new InputStreamReader(url.openStream(), encoding));
            String line = reader.readLine();
            if (line == null) {
                return (false);
            }
            if (line.trim().indexOf("<?xml") != -1) {
                return (true);
            } else {
                return (false);
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static String guessXMLEncoding(URL url) throws IOException {
        DataInputStream in = null;
        try {
            in = new DataInputStream(url.openStream());
            byte[] buffer = new byte[4];
            if (in.read(buffer) != 4) {
                return (null);
            }
            if (buffer[0] == 0xfe && buffer[1] == 0xff) {
                return ("UCS-16"); // big-endian
            } else if (buffer[0] == 0xff && buffer[1] == 0xfe) {
                return ("UCS-16"); // little-endian
            } else if (
                buffer[0] == 0x00
                    && buffer[1] == 0x00
                    && buffer[2] == 0x00
                    && buffer[3] == 0x3c) {

                return ("UCS-4"); // 1234
            } else if (
                buffer[0] == 0x3c
                    && buffer[1] == 0x00
                    && buffer[2] == 0x00
                    && buffer[3] == 0x00) {

                return ("UCS-4"); // 4321
            } else if (
                buffer[0] == 0x00
                    && buffer[1] == 0x00
                    && buffer[2] == 0x3c
                    && buffer[3] == 0x00) {

                return ("UCS-4"); // 2143
            } else if (
                buffer[0] == 0x00
                    && buffer[1] == 0x3c
                    && buffer[2] == 0x00
                    && buffer[3] == 0x00) {

                return ("UCS-4"); // 3412
            } else if (
                buffer[0] == 0x00
                    && buffer[1] == 0x3c
                    && buffer[2] == 0x00
                    && buffer[3] == 0x3f) {

                return ("UTF-16"); // error
            } else if (
                buffer[0] == 0x00
                    && buffer[1] == 0x3f
                    && buffer[2] == 0x00
                    && buffer[3] == 0x3c) {

                return ("UTF-16"); // error
            } else if (
                buffer[0] == 0x3c
                    && buffer[1] == 0x3f
                    && buffer[2] == 0x78
                    && buffer[3] == 0x6d) {

                return ("us-ascii"); // includes UTF-8, Shift_JIS, EUC-JP
            } else if (
                buffer[0] == 0x4c
                    && buffer[1] == 0x6f
                    && buffer[2] == 0xA7
                    && buffer[3] == 0x94) {

                return ("EBCDIC");
            } else {
                return ("UTF-8");
            }
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public static boolean isXmlSpace(char c) {
        return (c == ' ' || c == '\t' || c == '\n' || c == '\r'); // TODO
    }
}
