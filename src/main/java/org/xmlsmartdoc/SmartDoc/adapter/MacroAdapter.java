/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2002  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.DocContext;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocContext;
import org.xmlsmartdoc.SmartDoc.SmartDocModel;
import org.xmlsmartdoc.SmartDoc.SmartDocWarningException;
import org.xmlsmartdoc.SmartDoc.USmartDoc;
import com.AsamiOffice.jaba2.xml.IProcessor;

import org.w3c.dom.Document;

/**
 * MacroAdapter
 *
 * @since   Feb. 12, 2001
 * @version Oct. 19, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class MacroAdapter extends AbstractAdapter {
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
            context = context.makeSubContext(
                USmartDoc.makeDirectoryContext(src)
            );
            SmartDocConfig config = SmartDocContext.getContext().getConfig();
            IProcessor processor = config.getXMLProcessor();
            Document xml = processor.parseDocument(url);
            if (xml == null || xml.getDocumentElement() == null) {
                USmartDoc.error("XML syntax error");
            }
            SmartDocModel model = SmartDocContext.getContext().getModel();
            return (model.buildMacroContents(xml.getDocumentElement()));
        } catch (MalformedURLException e) {
            throw (new SmartDocWarningException(e));
        } catch (IOException e) {
            throw (new SmartDocWarningException(e));
        }
    }
}
