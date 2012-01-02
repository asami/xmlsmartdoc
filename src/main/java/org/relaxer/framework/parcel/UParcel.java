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

import java.util.Map;
import java.util.Stack;

import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.ArrayMap;

/**
 * UParcel
 *
 * @since   Oct.  2, 2003
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class UParcel {
    public static void traverse(IParcelNode node, IParcelNodeVisitor visitor)
        throws ParcelException {
        if (visitor.enter(node)) {
            IParcelNode[] children = node.getChildren();
            for (int i = 0;i < children.length;i++) {
                traverse(children[i], visitor);
            }
            visitor.leave(node);
        }
    }
    
    public static String getPathname(IParcelNode node) {
        return (makePathname(node, "/"));
    }

    public static String getPathname(IParcelNode node, Map nameVariables) {
        return (makePathname(node, "/", nameVariables));
    }

    public static String makeKey(IParcelNode node) {
        return (makePathname(node, "."));
    }

    public static String makePathname(IParcelNode node, String delimiter) {
        return (makePathname(node, delimiter, new ArrayMap()));
    }

    public static String makePathname(
        IParcelNode node, 
        String delimiter,
        Map nameVariables
    ) {
        Object[] entries = nameVariables.entrySet().toArray();
        if (node == null) {
            throw (new IllegalArgumentException());
        }
        Stack stack = new Stack();
        do {
            String name = node.getName();
            if (name != null) {
                for (int i = 0; i < entries.length; i++) {
                    Map.Entry entry = (Map.Entry)entries[i];
                    String varName = (String)entry.getKey();
                    name = UString.replace(
                        name, 
                        "${" + varName + "}",
                        entry.getValue().toString()
                    );
                }
                stack.push(name);
            } 
            node = node.getParent();
        } while (node != null);
        StringBuffer buffer = new StringBuffer();
        if (!stack.isEmpty()) {
            buffer.append((String)stack.pop());
        }
        while (!stack.isEmpty()) {
             buffer.append(delimiter);
            buffer.append((String)stack.pop());
        }
        return (new String(buffer));
    }
}
