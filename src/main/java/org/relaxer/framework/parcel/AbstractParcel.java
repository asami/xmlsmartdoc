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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * AbstractParcel
 *
 * @since   Oct.  1, 2003
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractParcel implements IParcel {
    private IParcelNode root_;
    private Map nameVariables_ = new HashMap();

    protected void _init(IParcelNode root) {
        root_ = root;
    }

    public void close() {
        root_ = null;
    }

    protected boolean _isAlive() {
        return (root_ != null);
    }

    protected void _assertInvariants() {
        if (!_isAlive()) {
            throw (new IllegalStateException());
        }
    }

    protected final IParcelNode _getRoot() {
        _assertInvariants();
        return (root_);
    }

    public Collection getCollection() throws ParcelException {
        _assertInvariants();
        CollectionMaker maker = new CollectionMaker();
        UParcel.traverse(root_, maker);
        return (maker.getCollection());
    }

    public Map getMap() throws ParcelException {
        _assertInvariants();
        MapMaker maker = new MapMaker();
        UParcel.traverse(root_, maker);
        return (maker.getMap());
    }

    public IRTable getTable() {
        _assertInvariants();
        return (new ParcelTable(root_));
    }

    public IRTree getTree() {
        _assertInvariants();
        return (new ParcelTree(root_));
    }

    public IContent[] getContents() throws ParcelException {
        _assertInvariants();
        ContentsMaker maker = new ContentsMaker();
        UParcel.traverse(root_, maker);
        return (maker.getContents());
    }

    public Object getProperty(String path, String key) {
        _assertInvariants();
        IParcelNode target = _findNode(path);
        if (target == null) {
            return (null);
        }
        return (target.getProperty(key));
    }

    public void setProperty(String path, String key, Object value) {
        _assertInvariants();
        IParcelNode target = _getNode(path);
        target.setProperty(key, value);
    }

    public IContent getContent(String path) {
        _assertInvariants();
        IParcelNode target = _findNode(path);
        if (target == null) {
            return (null);
        }
        return (target.getContent());
    }

    public void setContent(String path, IContent contents) {
        _assertInvariants();
        IParcelNode target = _getNode(path);
        target.setContent(contents);
    }

    public void setTextContents(String path, Object object) {
        setContent(path, new StringContent(object.toString()));
    }

    public void setNameVariable(String name, String value) {
        nameVariables_.put(name, value);
    }

    public Object getProperty(String key) {
        _assertInvariants();
        return (root_.getProperty(key));
    }

    public void setProperty(String key, Object value) {
        _assertInvariants();
        root_.setProperty(key, value);
    }

    protected final IParcelNode _findNode(String path) {
        String[] paths = getPath_(path);
        IParcelNode current;
        int index = 0;
        if ("/".equals(paths[index])) {
            current = root_;
            index++; 
        } else {
            return (null);
//            throw (new UnsupportedOperationException());
        }
        while (index < paths.length) {
            current = current.getChild(paths[index++]);
            if (current == null) {
                return (null);
            }
        }
        return (current);
    }

    protected final IParcelNode _getNode(String path) {
        String[] paths = getPath_(path);
        IParcelNode current;
        int index = 0;
        if ("/".equals(paths[index])) {
            current = root_;
            index++; 
        } else {
            current = root_;
        }
        while (index < paths.length) {
            String name = paths[index];
            IParcelNode child = current.getChild(name);
            if (child == null) {
                child = _makeNode(current, name);
                current.addChild(child);
                current = child;
            }
            index++;
        }
        return (current);
    }

    protected IParcelNode _makeNode(
        IParcelNode parent,
        String name
    ) {
        return (new LightWeightParcelNode(name));
    }

    private String[] getPath_(String path) {
        List list = new ArrayList();
        int index = 0;
        if (path.startsWith("/")) {
            list.add("/");
            index++;
        }
        int next;
        while ((next = path.indexOf("/", index)) != -1) {
            list.add(path.substring(index, next));
            index = next + 1;
        }
        if (index < path.length()) {
            list.add(path.substring(index));
        }
        String[] result = new String[list.size()];
        return ((String[])list.toArray(result));
    }

    public void copyFiles(File dir, IParcelNodeFilter filter)
        throws ParcelException {
        CopyFileVisitor copyer = new CopyFileVisitor(dir, filter);
        copyer.setNameVariable(nameVariables_);
        UParcel.traverse(root_, copyer);
    }

    public void copyFiles(File dir) throws ParcelException {
        CopyFileVisitor copyer = new CopyFileVisitor(dir);
        copyer.setNameVariable(nameVariables_);
        UParcel.traverse(root_, copyer);
    }

    public void moveFiles(File dir, IParcelNodeFilter filter)
        throws ParcelException {
        MoveFileVisitor mover = new MoveFileVisitor(dir, filter);
        mover.setNameVariable(nameVariables_);
        UParcel.traverse(root_, mover);
    }

    public void moveFiles(File dir) throws ParcelException {
        MoveFileVisitor mover = new MoveFileVisitor(dir);
        mover.setNameVariable(nameVariables_);
        UParcel.traverse(root_, mover);
    }
}
