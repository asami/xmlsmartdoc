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

package org.xmlsmartdoc.SmartDoc.adapter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlsmartdoc.SmartDoc.Body;
import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.Doc;
import org.xmlsmartdoc.SmartDoc.DocContext;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocContext;
import org.xmlsmartdoc.SmartDoc.SmartDocModel;
import org.xmlsmartdoc.SmartDoc.SmartDocWarningException;
import org.xmlsmartdoc.SmartDoc.UDoc;
import org.xmlsmartdoc.SmartDoc.USmartDoc;
import com.AsamiOffice.jaba2.xml.IProcessor;

import org.w3c.dom.Document;

/**
 * SDocAdapter
 *
 * @since   May. 12, 1999
 * @version Oct. 19, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SDocAdapter extends AbstractAdapter {
    // AbstractAdapter
    protected Content[] _expand(
        String[] srcs,
        String param,
        Content content,
        Content[] contents,
        DocContext context
    ) {
        String src = srcs[0];
        if (src == null) {
            return (new Content[0]);
        }
        String encoding = content.getEncoding();
        try {
            URL url = USmartDoc.makeURL(src, context);
//            context = context.makeSubContext(
//                USmartDoc.makeDirectoryContext(url.toExternalForm())
//            );
            context = context.makeSubContext(
                USmartDoc.makeDirectoryContext(src)
            );
            SmartDocConfig config = SmartDocContext.getContext().getConfig();
            IProcessor processor = config.getXMLProcessor();
/*
            Parser parser = new Parser(url.toString());
            StringBuffer buffer = new StringBuffer();
            buffer.append("<?xml version='1.0' ?>\n");
            Reader reader;
            if (encoding != null) {
                reader = new BufferedReader(
                    new InputStreamReader(url.openStream(), encoding)
                );
            } else {
                reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
                );
            }
            int c;
            while ((c = reader.read()) != -1) {
                buffer.append((char)c);
            }
            reader.close();
            Document xml = parser.readStream(
                new StringReader(new String(buffer))
            );
*/
            Document xml = processor.parseDocument(url);
            if (xml == null || xml.getDocumentElement() == null) {
                USmartDoc.error("XML syntax error");
            }
            SmartDocModel model = SmartDocContext.getContext().getModel();
            Doc doc = model.build(xml, context);
            doc = model.expand(doc, context);
            UDoc.importDocTitle(doc, content);
//            Head head = doc.getHead();
            Body body = doc.getBody();
/*
            if (head != null) {
                Content[] headContents = head.getContents();
                for (int i = 0;i < headContents.length;i++) {
                    Content hContent = headContents[i];
                    if (hContent instanceof Title) {
                        Title title = (Title)hContent;
                        Locale locale = title.getLocale();
                        if (content instanceof TitledBlock) {
                            if (locale != null) {
                                ((TitledBlock)content).setTitle(title, locale);
                            } else {
                                ((TitledBlock)content).setTitle(title);
                            }
                        } else {
                            content.setTitle(title.getText()); // XXX
                        }
                    }
                }
            }
*/
            if (body == null) {
                return (null);
            }
            List list = new ArrayList();
            for (int i = 0;i < contents.length;i++) {
                list.add(contents[i]);
            }
            Content[] sdocContents = body.getContents();
            for (int i = 0;i < sdocContents.length;i++) {
                sdocContents[i].setDocContext(context);
                list.add(sdocContents[i]);
            }
            Content[] result = new Content[list.size()];
            return ((Content[])list.toArray(result));
        } catch (MalformedURLException e) {
            throw (new SmartDocWarningException(e));
        } catch (IOException e) {
            throw (new SmartDocWarningException(e));
        }
    }
}
