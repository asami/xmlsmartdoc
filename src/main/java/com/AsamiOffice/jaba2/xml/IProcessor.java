/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2000  ASAMI, Tomoharu (asami@zeomtech.com)
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

package com.AsamiOffice.jaba2.xml;

import java.io.IOException;
import java.net.URL;
import org.xml.sax.ErrorHandler;
import org.xml.sax.EntityResolver;
import org.w3c.dom.Document;

/**
 * IProcessor
 *
 * @since   Jul. 28, 1999
 * @version Aug. 15, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public interface IProcessor {
    Document parseDocument(URL url) throws IOException;
    Document parseDocumentByText(String text) throws IOException;
    Document parseValidDocument(URL url) throws IOException;
    Document parseValidDocumentByText(String text) throws IOException;
    Document newDocument();
    void setErrorHandler(ErrorHandler handler);
    void setEntityResolver(EntityResolver resolver);
}
