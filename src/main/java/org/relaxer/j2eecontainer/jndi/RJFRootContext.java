/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.j2eecontainer.jndi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.*;

import org.relaxer.j2eecontainer.J2eeContainer;
import org.relaxer.j2eecontainer.jndi.rConfig.*;

import com.AsamiOffice.text.UString;

/**
 * RJFRootContext
 *
 * @since   May.  2, 2003
 * @version Dec. 13, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RJFRootContext extends AbstractRJFContext {
    CProvider provider_;

    public RJFRootContext(
        CProvider provider,
        J2eeContainer container
    ) {
        super(container);
        provider_ = normalize_(provider);
//        root_.rSetProperty("j2eefw", this);
    }

    public Object lookup(Name name) throws NamingException {
        int size = name.size();
        if (size == 0) {
            return (null);
        }
        String component = name.get(0);
        int index = component.indexOf(":");
        if (index != -1) {
            String provider = component.substring(0, index);
            if (!provider.equals(provider_.getName())) {
                return (null);
            }
            component = component.substring(index + 1);
        }
        ICChildrenChoice node = _retreive(provider_.getChildren(), component);
        if (node == null) {
            return (null);
        }
        if (size == 1) {
            return (_makeNode(node));
        }
        CContext context;
        if (node instanceof CContext) {
            context = (CContext)node;
        } else {
            return (null); // XXX
        }
        for (int i = 1; i < size - 1; i++) {
            component = name.get(i);
            node = _retreive(context, component);
            if (node == null) {
                return (null);
            }
            if (!(node instanceof CContext)) {
                return (null); // XXX
            }
            context = (CContext)node;
        }
        String leaf = name.get(size - 1);
        node = _retreive(context, leaf);
        if (node == null) {
            return (null);
        } else {
            return (_makeNode(node));
        }
    }

    public void bind(Name name, Object obj) throws NamingException {
    }

    public void rebind(Name name, Object obj) throws NamingException {
    }

    public void unbind(Name name) throws NamingException {
    }

    public void rename(Name oldName, Name newName) throws NamingException {
    }

    public NamingEnumeration list(Name name) throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public NamingEnumeration listBindings(Name name) throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public void destroySubcontext(Name name) throws NamingException {
    }

    public Context createSubcontext(Name name) throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public Object lookupLink(Name name) throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public NameParser getNameParser(Name name) throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public Name composeName(Name name, Name prefix) throws NamingException {
        throw (new UnsupportedOperationException());
    }
    
    private CProvider normalize_(CProvider sProvider) {
        CProvider nProvider = new CProvider();
        nProvider.setName(sProvider.getName());
        ICChildrenChoice[] children = sProvider.getChildren();
        Entry[] entries = collectEntries_(children);
        for (int i = 0; i < entries.length; i++) {
            addEntry_(nProvider, entries[i]);
        }
        container_.config("Root context:" + nProvider);
        return (nProvider);
    }

    private Entry[] collectEntries_(ICChildrenChoice[] children) {
        List entries = new ArrayList();
        collectEntries_(children, new ArrayList(), entries);
        Entry[] result = new Entry[entries.size()];
        return ((Entry[])entries.toArray(result));
    }

    private void collectEntries_(
        ICChildrenChoice[] children,
        List path,
        List entries
    ) {
        for (int i = 0; i < children.length; i++) {
            ICChildrenChoice child = children[i];
            if (child instanceof CContext) {
                CContext context = (CContext)child;
                String name = context.getName();
                List newPath = new ArrayList(path);
                String[] names = UString.getTokens(name, "/");
                for (int j = 0; j < names.length; j++) {
                    newPath.add(names[j]);
                }
                collectEntries_(context.getChildren(), newPath, entries);
            } else {
                Entry entry = new Entry();
                entry.path = new ArrayList(path);
                entry.leaf = child;
                entries.add(entry);
            }
        }
    }
    
    private void addEntry_(CProvider provider, Entry entry) {
        CContext target = getTargetContext_(
            provider, 
            new LinkedList(entry.path)
        );
        if (target != null) {
            target.addChildren((ICChildrenChoice)entry.leaf.clone());
        } else {
            provider.addChildren((ICChildrenChoice)entry.leaf.clone());
        }
    }

    private CContext getTargetContext_(
        CProvider provider,
        LinkedList path
    ) {
        ICChildrenChoice[] children = provider.getChildren();
        if (path.isEmpty()) {
            return (null);
        }
        String name = (String)path.removeFirst();
        for (int i = 0; i < children.length; i++) {
            ICChildrenChoice child = children[i];
            if (child instanceof CContext) {
                if (name.equals(child.getName())) {
                    return (getTargetContext_((CContext)child, path));
                }
            } else {
                throw (new InternalError());
            }
        }
        CContext context = new CContext();
        context.setName(name);
        provider.addChildren(context);
        while (!path.isEmpty()) {
            name = (String)path.removeFirst();
            CContext childContext = new CContext();
            childContext.setName(name);
            context.addChildren(childContext);
            context = childContext;
        }
        return (context);
    }

    private CContext getTargetContext_(
        CContext parent,
        LinkedList path
    ) {
        if (path.isEmpty()) {
            return (parent);
        }
        ICChildrenChoice[] children = parent.getChildren();
        String name = (String)path.removeFirst();
        for (int i = 0; i < children.length; i++) {
            ICChildrenChoice child = children[i];
            if (child instanceof CContext) {
                if (name.equals(child.getName())) {
                    return (getTargetContext_((CContext)child, path));
                }
            } else {
                throw (new InternalError());
            }
        }
        CContext context = new CContext();
        context.setName(name);
        parent.addChildren(context);
        while (!path.isEmpty()) {
            name = (String)path.removeFirst();
            CContext childContext = new CContext();
            childContext.setName(name);
            context.addChildren(childContext);
            context = childContext;
        }
        return (context);
    }

    static class Entry {
        List path = new ArrayList();
        ICChildrenChoice leaf;
    }
}
