/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

package com.AsamiOffice.jaba2.xml.pdom;

import java.io.IOException;
import java.net.URL;

/**
 * PDOMFactory is a Factory to generate PDOM objects from a DOM parser.
 *
 * @since   Apr. 24, 1998
 * @version Oct. 17, 2003
 + @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public interface PDOMFactory {
    public PDocument generateDoc(URL url) throws IOException;
//    public PDocumentType generateDTD(URL url) throws IOException;
    public PDocument generateDoc(String text);
//    public PDocumentType generateDTD(String text);
}
