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
package org.relaxer.framework.parcel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * CollectionMaker
 *
 * @since   Oct.  2, 2003
 * @version Oct.  2, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class CollectionMaker extends ParcelNodeVisitorBase {
    private List list_ = new ArrayList();

    /**
     * @return
     */
    public Collection getCollection() {
        return (list_);
    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.parcel.IParcelNodeVisitor#enter(org.relaxer.framework.parcel.IParcelNode)
     */
    public boolean enter(IParcelNode node) {
        IContent contents = node.getContent();
        if (contents != null) {
            list_.add(contents.getSource());
        }
        return (true);
    }

    /* (non-Javadoc)
     * @see org.relaxer.framework.parcel.IParcelNodeVisitor#leave(org.relaxer.framework.parcel.IParcelNode)
     */
    public void leave(IParcelNode node) {
    }
}
