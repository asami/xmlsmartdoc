/*
 * The JabaJaba class library
 *  Copyright (C) 1997-1999  ASAMI, Tomoharu (tasami@ibm.net)
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

import java.util.*;
import java.io.IOException;
import java.net.URL;
import org.w3c.dom.*;

/**
 * PDOM is a DOM object to persist.
 *
 * @since   Apr. 24, 1998
 * @version Sep. 15, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class PDOM {
    protected static PDOMFactory factory_ = new JAXPPDOMFactory();
    protected boolean feature_ = false;

    public Document createDocument(String type) {
	return (new PDocument(type));
    }

    public boolean hasFeature(String feature) {
	return (feature_);
    }

    public static Document generateDocument(URL url) throws IOException {
	return (factory_.generateDoc(url));
    }

    public static Document generateDocument(String text) {
	return (factory_.generateDoc(text));
    }
}
