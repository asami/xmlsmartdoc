/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
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

package org.xmlsmartdoc.goldenport.selecters;

import org.w3c.dom.Element;
import org.xmlsmartdoc.goldenport.selecter.AbstractSelecter;

/**
 * AllSelecter
 *
 * @since   Jul.  8, 2002
 * @version Apr.  8, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class AllSelecter extends AbstractSelecter {
    public boolean isMatch(Element element) {
	   return (true);
    }
    
    private static AllSelecter singleton_ = null;
    
    public static AllSelecter getSingleton() {
        if (singleton_ == null) {
            singleton_ = new AllSelecter();
        }
        return (singleton_);
    }
}
