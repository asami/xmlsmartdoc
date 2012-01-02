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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AbstractParcelNode
 *
 * @since   Oct.  1, 2003
 * @version Dec. 17, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractParcelNode implements IParcelNode {
    private String name_;
    private IContent content_;
    private Map properties_ = new HashMap();
    private List children_ = new ArrayList();
    private IParcelNode parent_;

    protected AbstractParcelNode() {
        name_ = null;
    }

    protected AbstractParcelNode(String name) {
        name_ = name;
    }

    public String getName() {
        return (name_);
    }

    public IContent getContent() {
        return (content_);
    }

    public Object getProperty(String key) {
        return (properties_.get(key));
    }

    public void setContent(IContent content) {
        content_ = content;
    }

    public void setProperty(String key, Object value) {
        properties_.put(key, value);
    }

    public IParcelNode getChild(String name) {
        Object[] children = children_.toArray();
        for (int i = 0;i < children.length;i++) {
            IParcelNode child = (IParcelNode)children[i];
            if (name.equals(child.getName())) {
                return (child);
            }
        }
        return (null);
    }

    public IParcelNode[] getChildren() {
        IParcelNode[] children = new IParcelNode[children_.size()];
        return ((IParcelNode[])children_.toArray(children));
    }

    public int sizeChildren() {
        return (children_.size());
    }

    public void addChild(IParcelNode child) {
        children_.add(child);
        if (child instanceof AbstractParcelNode) {
            ((AbstractParcelNode)child).parent_ = this;
        }
    }

    public IParcelNode getParent() {
        return (parent_);
    }
}
