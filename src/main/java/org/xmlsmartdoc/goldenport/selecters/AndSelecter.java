/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
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
import org.xmlsmartdoc.goldenport.selecter.ISelecter;

/**
 * AndSelecter
 *
 * @since   Jul.  8, 2002
 * @version Apr.  6, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class AndSelecter extends AbstractSelecter {
    private ISelecter[] selecters_;

    public AndSelecter(ISelecter[] selecters) {
        selecters_ = selecters;
    }

    public boolean isMatch(Element element) {
        for (int i = 0; i < selecters_.length; i++) {
            ISelecter selecter = selecters_[i];
            if (!selecter.isMatch(element)) {
                return (false);
            }
        }
        return (true);
    }
}
