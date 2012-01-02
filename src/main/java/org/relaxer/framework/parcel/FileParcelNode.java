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

import com.AsamiOffice.io.UFile;

/**
 * FileParcelNode
 *
 * @since   Jan.  3, 2004
 * @version Jan.  3, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FileParcelNode extends AbstractParcelNode {
    private File file_;
    private boolean dirty_ = false;

    public FileParcelNode(File file) {
        file_ = file;
    }

    public FileParcelNode(String filename) {
        this(new File(filename));
    }

    public FileParcelNode(FileParcelNode parent, String name) {
        file_ = new File(parent.file_, name);
        init_();
    }

    private void init_() {
        if (file_.exists()) {
            if (file_.isDirectory()) {
                super.setContent(new DirectoryContent(file_));
            } else {
                super.setContent(new FileContent(file_));
            }
            File[] children = file_.listFiles();
            for (int i = 0;i < children.length;i++) {
                File child = children[i];
                addChild(new FileParcelNode(child));
            }
        }
    }

    public void setContent(IContent content) {
        dirty_ = true;
        super.setContent(content);
    }

    public void commit() {
        if (dirty_) {
            commitFile_();
        }
        IParcelNode[] children = getChildren();
        for (int i = 0;i < children.length;i++) {
            IParcelNode child = children[i];
            if (child instanceof FileParcelNode) {
                ((FileParcelNode)child).commit();
            }
        }
    }
    
    private void commitFile_() {
        InputStream in = null;
        try {
            in = getContent().getInputStream();
            UFile.createFile(file_, in);
        } catch (IOException e) {
            // TODO
            throw (new InternalError());
        } catch (ParcelException e) {
            // TODO
            throw (new InternalError());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ee) {
                }
            }
        }
    }

    public void abort() {
        if (dirty_) {
            super.setContent(null);
        }
        IParcelNode[] children = getChildren();
        for (int i = 0;i < children.length;i++) {
            IParcelNode child = children[i];
            if (child instanceof FileParcelNode) {
                ((FileParcelNode)child).abort();
            }
        }
    }
}
