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
import java.util.List;

/**
 * CollectionMaker
 *
 * @since   Dec. 17, 2003
 * @version Dec. 17, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ContentsMaker extends ParcelNodeVisitorBase {
    private List list_ = new ArrayList();

    public IContent[] getContents() {
        IContent[] contents = new IContent[list_.size()];
        return ((IContent[])list_.toArray(contents));
    }

    public boolean enter(IParcelNode node) {
        IContent contents = node.getContent();
        if (contents != null) {
            list_.add(contents);
        }
        return (true);
    }

    public void leave(IParcelNode node) {
    }
}
