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

import java.beans.Beans;
import java.io.IOException;
import java.util.*;
import javax.naming.*;

import org.relaxer.j2eecontainer.J2eeContainer;
import org.relaxer.j2eecontainer.jndi.rConfig.*;

import com.AsamiOffice.io.UIO;

/**
 * AbstractRJFContext
 *
 * @since   May.  2, 2003
 * @version Dec. 13, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractRJFContext implements Context {
    protected final J2eeContainer container_;

    protected AbstractRJFContext(J2eeContainer container) {
        container_ = container;
    }

    public Object lookup(String name) throws NamingException {
        return (lookup(_makeName(name)));
    }

    public void bind(String name, Object obj) throws NamingException {
        bind(_makeName(name), obj);
    }

    public void rebind(String name, Object obj) throws NamingException {
        rebind(_makeName(name), obj);
    }

    public void unbind(String name) throws NamingException {
        unbind(_makeName(name));
    }

    public void rename(String oldName, String newName) throws NamingException {
        rename(_makeName(oldName), _makeName(newName));
    }

    public NamingEnumeration list(String name) throws NamingException {
        return (list(_makeName(name)));
    }

    public NamingEnumeration listBindings(String name) throws NamingException {
        return (listBindings(_makeName(name)));
    }

    public void destroySubcontext(String name) throws NamingException {
        destroySubcontext(_makeName(name));
    }

    public Context createSubcontext(String name) throws NamingException {
        return (createSubcontext(_makeName(name)));
    }

    public Object lookupLink(String name) throws NamingException {
        return (lookupLink(_makeName(name)));
    }

    public NameParser getNameParser(String name) throws NamingException {
        return (getNameParser(_makeName(name)));
    }

    public String composeName(String name, String prefix)
        throws NamingException {

        return (composeName(_makeName(name), _makeName(prefix)).toString());
    }

    public Object addToEnvironment(String propName, Object propVal)
        throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public Object removeFromEnvironment(String propName)
        throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public Hashtable getEnvironment() throws NamingException {
        throw (new UnsupportedOperationException());
    }

    public void close() throws NamingException {
    }

    public String getNameInNamespace() throws NamingException {
        throw (new UnsupportedOperationException());
    }

    protected final Object _retreive(CContext context, Name name) throws NamingException {
        int size = name.size();
        for (int i = 0; i < size - 1; i++) {
            String component = name.get(i);
            ICChildrenChoice node = _retreive(context, component);
            if (node == null) {
                return (null);
            }
            if (!(node instanceof CContext)) {
                return (null);
            }
            context = (CContext)node;
        }
        String leaf = name.get(size - 1);
        return (_makeNode(_retreive(context, leaf)));
    }

    protected final Object _makeNode(Object node) throws NamingException {
        if (node instanceof CContext) {
            CContext context = (CContext)node;
            RJFContext targetContext =
                (RJFContext)context.rGetProperty("j2eefw");
            if (targetContext == null) {
                targetContext = new RJFContext((CContext)node, container_);
            }
            return (targetContext);
        } else if (node instanceof CDataSource) {
            return (new RJFDataSource((CDataSource)node, container_));
        } else if (node instanceof CBean) {
            try {
                return (makeBean_((CBean)node));
            } catch (IOException e) {
                throw (new NamingException(e.getMessage()));
            } catch (ClassNotFoundException e) {
                throw (new NamingException(e.getMessage()));
            }
        } else {
            throw (new InternalError(node.toString()));
        }
    }

    private Object makeBean_(CBean bean) throws IOException, ClassNotFoundException {
        String javaClass = bean.getJavaClass();
        Object target = getObjectJ2eeContainer_(javaClass);
        if (target == null) {
            String classpath = bean.getClasspath();
            ClassLoader loader;
            if (classpath != null) {
                loader = UIO.makeClasspathClassLoader(classpath);
            } else {
                loader = bean.getClass().getClassLoader();
            }
            target = Beans.instantiate(loader, javaClass);
        }
        CBeanInit init = bean.getBeanInit();
        return (target);
    }

    /**
     * @param javaClass
     * @return
     */
    private Object getObjectJ2eeContainer_(String javaClass) {
        ClassLoader loader = container_.getDefaultClassLoader();
        if (loader == null) {
            return (null);
        }
        try {
            return (Beans.instantiate(loader, javaClass));
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return (null);
    }

    protected final ICChildrenChoice _retreive(
        CContext context,
        String component) {
        return (_retreive(context.getChildren(), component));
    }

    protected final ICChildrenChoice _retreive(
        ICChildrenChoice[] children,
        String component) {
        for (int i = 0; i < children.length; i++) {
            ICChildrenChoice child = children[i];
            if (component.equals(child.getName())) {
                return (child);
            }
        }
        return (null);
    }

    protected final Name _makeName(String name) throws InvalidNameException {
        Properties syntax = new Properties();
        syntax.setProperty("jndi.syntax.direction", "left_to_right");
        syntax.setProperty("jndi.syntax.separator", "/");
        //	syntax.setProperty("jndi.syntax.escape");
        syntax.setProperty("jndi.syntax.ignorecase", "false");
        syntax.setProperty("jndi.syntax.trimblanks", "false");
        //	syntax.setProperty("jndi.syntax.beginquote");
        //	syntax.setProperty("jndi.syntax.endquote");
        //	syntax.setProperty("jndi.syntax.separator.ava");
        //	syntax.setProperty("jndi.syntax.separator.typeval");
        return (new CompoundName(name, syntax));
    }
}
