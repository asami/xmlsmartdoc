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
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.AsamiOffice.io.UFile;

/**
 * CopyFileVisitor
 *
 * @since   Oct.  2, 2003
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class CopyFileVisitor extends ParcelNodeVisitorBase {
    private File targetDir_;
    private IParcelNodeFilter filter_;
    private Map nameVariables_;

    public CopyFileVisitor(File targetDir) {
        targetDir_ = targetDir;
        filter_ = null;
    }

    public CopyFileVisitor(File targetDir, IParcelNodeFilter filter) {
        targetDir_ = targetDir;
        filter_ = filter;
    }

    public void setNameVariable(Map nameVariables) {
        nameVariables_ = nameVariables;
    }

    public boolean enter(IParcelNode node) throws ParcelException {
        InputStream in = null;
        try {
            if (filter_ != null) {
                if (!filter_.accept(node)) {
                    return (true);
                }
            }
            IContent contents = node.getContent();
            if (contents == null) {
                return (true);
            }
            String pathname = UParcel.getPathname(node, nameVariables_);
            File target = new File(targetDir_, pathname);
            in = contents.getInputStream();
            UFile.createFile(target, in);
            return (true);
        } catch (IOException e) {
            throw (new ParcelException(e));
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ee) {
                }
            }
        }
    }

    public void leave(IParcelNode node) {
    }
}
