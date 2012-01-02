/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package com.AsamiOffice.jaba2.j2fw.generator;

import java.io.IOException;

import org.w3c.dom.Node;

import com.AsamiOffice.xml.UXMLMaker;

/**
 * XMLArtifact
 *
 * @since   Sep.  5, 1999
 * @version Oct. 15, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class XMLArtifact extends GeneratorArtifact {
    protected Node node_;
    protected String encoding_ = "UTF-8";

    public XMLArtifact(String name, Node node) {
        super(name);
        node_ = node;
    }

    public XMLArtifact(String name, Node node, String encoding) {
        super(name);
        node_ = node;
        encoding_ = encoding;
    }

    public byte[] getBytes() throws IOException {
        String text = UXMLMaker.getXMLVisualText(node_, encoding_);
        return (text.getBytes(encoding_));
    }

    public String getEncoding() {
        return (encoding_);
    }

    public Node getNode() {
        return (node_);
    }
}
