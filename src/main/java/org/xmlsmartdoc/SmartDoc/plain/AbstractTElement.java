/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998,1999  ASAMI, Tomoharu (tasami@ibm.net)
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

package org.xmlsmartdoc.SmartDoc.plain;

import com.AsamiOffice.jaba2.text.cui.CBox;
import com.AsamiOffice.jaba2.text.cui.CGap;
import com.AsamiOffice.jaba2.text.cui.CPanel;
import com.AsamiOffice.jaba2.xml.pdom.PElement;

/**
 * AbstractTElement
 * 
 * @since   Oct.  8, 1999
 * @version Nov. 25, 2006
 * @author ASAMI, Tomoharu (asami@xmlsmartdoc.org)
 */
public abstract class AbstractTElement extends PElement implements TElement {
    protected int indent_ = 0;

    protected AbstractTElement() {
        super("telement");
    }

    public AbstractTElement(String name) {
        super(name);
    }

    public TNode[] getChildren() {
        TNode[] nodes = new TNode[children_.size()];
        return ((TNode[])children_.toArray(nodes));
    }

    public int getTotalIndent() {
        int length = indent_;
        TElement element = this;
        while ((element = (TElement)element.getParentNode()) != null) {
            length += element.getIndent();
        }
        return (length);
    }

    public int getIndent() {
        return (indent_);
    }

    public void setIndent(int indent) {
        indent_ = indent;
    }

    public void normalize() {
    }

    public void format(StringBuffer buffer) {
        int pgap;
        int ngap;
        TNode[] nodes = getChildren();
        if (nodes.length > 0) {
            TNode node = nodes[0];
            node.format(buffer);
            pgap = node.getBottomGap();
            for (int i = 1; i < nodes.length; i++) {
                node = nodes[i];
                ngap = node.getTopGap();
                _embedGap(pgap, ngap, buffer);
                node.format(buffer);
                pgap = node.getBottomGap();
            }
        }
    }

    public void format(CPanel cnode) {
        StringBuffer buffer = null;
        TNode[] nodes = getChildren();
        if (nodes.length == 0) {
            return;
        }
        int pgap;
        int ngap;
        TNode node = nodes[0];
        if (node instanceof TText) {
            if (buffer == null) {
                buffer = new StringBuffer();
            }
            node.format(buffer);
            pgap = 0;
        } else { // including TParagraph
/*
            if (buffer != null) {
                CBox box = new CBox(new String(buffer));
                cnode.append(box);
                buffer = null;
            }
*/
            node.format(cnode);
            pgap = node.getBottomGap();
        }
        for (int i = 1; i < nodes.length; i++) {
            node = nodes[i];
            ngap = node.getTopGap();
            int gap = Math.max(ngap, pgap);
            if (gap > 0) {
                if (buffer != null) {
                    CBox box = new CBox(buffer.toString());
                    cnode.append(box);
                    buffer = null;
                }
                if (_isFormatGap()) {
                    cnode.append(new CGap(gap));
                }
            }
            if (node instanceof TText) {
                if (buffer == null) {
                    buffer = new StringBuffer();
                }
                node.format(buffer);
            } else { // including TParagraph
                if (buffer != null) {
                    CBox box = new CBox(new String(buffer));
                    cnode.append(box);
                    buffer = null;
                }
                node.format(cnode);
            }
            pgap = node.getBottomGap();
        }
        if (buffer != null) {
            CBox box = new CBox(new String(buffer));
            cnode.append(box);
        }
    }

    protected boolean _isFormatGap() {
        return true;
    }

    public void format0(CPanel cnode) {
        int pgap;
        int ngap;
        TNode[] tnodes = getChildren();
        if (tnodes.length > 0) {
            TNode tnode = tnodes[0];
            tnode.format(cnode);
            pgap = tnode.getBottomGap();
            for (int i = 1; i < tnodes.length; i++) {
                tnode = tnodes[i];
                ngap = tnode.getTopGap();
                int gap = Math.max(ngap, pgap);
                if (gap > 0) {
                    cnode.append(new CGap(gap));
                }
                tnode.format(cnode);
                pgap = tnode.getBottomGap();
            }
        }
    }

    protected void _embedGap(int pgap, int ngap, StringBuffer buffer) {
        int gap = Math.max(pgap, ngap);
        while (gap-- > 0) {
            buffer.append("\n");
        }
    }

    public String format() {
        StringBuffer buffer = new StringBuffer();
        format(buffer);
        return (new String(buffer));
    }

    public int getTopGap() {
        TNode node = (TNode)getFirstChild();
        if (node == null) {
            return (0);
        }
        return (node.getTopGap());
    }

    public int getBottomGap() {
        TNode node = (TNode)getLastChild();
        if (node == null) {
            return (0);
        }
        return (node.getBottomGap());
    }

    protected void _indent(StringBuffer buffer) {
        int length = getTotalIndent();
        for (int i = 0; i < length; i++) {
            buffer.append(" ");
        }
    }

    protected void _indentParent(StringBuffer buffer) {
        TElement element = (TElement)getParentNode();
        if (element == null) {
            return;
        }
        int length = element.getTotalIndent();
        for (int i = 0; i < length; i++) {
            buffer.append(" ");
        }
    }
}
