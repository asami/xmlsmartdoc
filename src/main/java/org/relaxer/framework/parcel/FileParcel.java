/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
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

import java.io.File;

/**
 * FileParcel
 *
 * @since   Oct. 22, 2003
 * @version Jan.  7, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FileParcel extends AbstractParcel {
    public FileParcel(File file) {
        _init(new FileParcelNode(file));
    }

    public FileParcel(String filename) {
        _init(new FileParcelNode(filename));
    }

    protected IParcelNode _makeNode(IParcelNode parent, String name) {
        return (new FileParcelNode((FileParcelNode)parent, name));
    }

    protected final FileParcelNode _getRootFile() {
        return ((FileParcelNode)_getRoot());
    }

    public void commit() {
        _getRootFile().commit();
    }

    public void abort() {
        _getRootFile().abort();
    }

    public void remove() {
        // TODO Auto-generated method stub
    }
}
