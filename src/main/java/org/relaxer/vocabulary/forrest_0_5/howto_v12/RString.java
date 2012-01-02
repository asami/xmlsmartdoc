/*
 * The Relaxer artifact
 * Copyright (c) 2000-2004, ASAMI Tomoharu, All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer. 
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.relaxer.vocabulary.forrest_0_5.howto_v12;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import org.w3c.dom.*;

/**
 * <b>RString</b> is a text container class which is used for mixed.
 *
 * @version howto_v12.rng 1.0 (Wed Mar 03 11:15:34 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class RString implements java.io.Serializable, Cloneable, IFhTitleMixed, IFhLinkContentMixMixed, IFhContentMixMixed, IFhSubtitleMixed, IFhFlowMixed {
    private Object value_;
    private boolean cdata_;

    /**
     * Creates a <code>RString</code>.
     *
     */
    public RString() {
    }

    /**
     * Creates a <code>RString</code> by the String <code>text</code>.
     *
     * @param text
     */
    public RString(String text) {
        value_ = text;
    }

    /**
     * Creates a <code>RString</code> by the DOM node <code>node</code>.
     *
     * @param node
     */
    public RString(org.w3c.dom.Node node) {
        value_ = node;
    }

    /**
     * Creates a <code>RString</code> by the Object <code>object</code>.
     *
     * @param object
     */
    public RString(Object object) {
        value_ = object;
    }

    /**
     * Creates a <code>RString</code> by the Rstring <code>source</code>.
     *
     * @param source
     */
    public RString(RString source) {
        this(source.getContent());
    }

    /**
     * Creates a <code>RString</code> by the Stack <code>stack</code>.
     * This constructor is supposed to be used internallyby the Relaxer system.
     *
     * @param stack
     */
    public RString(RStack stack) {
        setup(stack);
    }

    /**
     * Initializes the <code>RString</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internallyby the Relaxer system.
     *
     * @param stack
     */
    public void setup(RStack stack) {
        value_ = stack.pop().toString();
    }

    /**
     * Creates a DOM representation of the object.
     * Result is appended to the Node <code>parent</code>.
     *
     * @param node
     */
    public void makeElement(Node node) {
        Document doc = node.getOwnerDocument();
        if (value_ instanceof org.w3c.dom.Node) {
            node.appendChild(doc.importNode((Node)value_, true));
        } else if (value_ != null) {
            if (cdata_) {
                node.appendChild(doc.createCDATASection(value_.toString()));
            } else {
                node.appendChild(doc.createTextNode(value_.toString()));
            }
        }
    }

    /**
     * Gets the text.
     *
     * @return String
     */
    public String getText() {
        if (value_ instanceof String) {
            return ((String)value_);
        } else {
            return (null);
        }
    }

    /**
     * Sets the text.
     *
     * @param text
     */
    public void setText(String text) {
        value_ = text;
    }

    /**
     * Gets the DOM node.
     *
     * @return org.w3c.dom.Node
     */
    public org.w3c.dom.Node getNode() {
        if (value_ instanceof org.w3c.dom.Node) {
            return ((org.w3c.dom.Node)value_);
        } else {
            return (null);
        }
    }

    /**
     * Sets the DOM node.
     *
     * @param node
     */
    public void setNode(org.w3c.dom.Node node) {
        value_ = node;
    }

    /**
     * Gets the object.
     *
     * @return Object
     */
    public Object getObject() {
        if (value_ instanceof String || value_ instanceof org.w3c.dom.Node) {
            return (null);
        } else {
            return (value_);
        }
    }

    /**
     * Sets the DOM node.
     *
     * @param object
     */
    public void setObject(Object object) {
        value_ = object;
    }

    /**
     * Gets the content.
     *
     * @return Object
     */
    public Object getContent() {
        return (value_);
    }

    /**
     * Sets the content.
     *
     * @param value
     */
    public void setContent(Object value) {
        value_ = value;
    }

    /**
     * Checks whether cdata or not.
     *
     * @return boolean
     */
    public boolean isCdata() {
        return (cdata_);
    }

    /**
     * Sets wheter cdata or not.
     *
     * @param cdata
     */
    public void setCdata(boolean cdata) {
        cdata_ = cdata;
    }

    /**
     * Gets the text content as String.
     *
     * @return String
     */
    public String getContentAsString() {
        if (value_ == null) {;
            return (null);
        } else if (value_ instanceof org.w3c.dom.Node) {
            return (URelaxer.node2String4Data((Node)value_));
        } else {
            return (value_.toString());
        }
    }

    /**
     * Gets the String.
     *
     * @return String
     */
    public String toString() {
        return (getContentAsString());
    }

    /**
     * Clones the String.
     *
     * @return Object
     */
    public Object clone() {
        return (new RString(this));
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(StringBuffer buffer) {
        if (value_ instanceof org.w3c.dom.Node) {
            buffer.append(URelaxer.node2String4Data((Node)value_));
        } else {
            if (cdata_) {
                buffer.append("<![CDATA[");
                buffer.append(value_.toString());
                buffer.append("]]>");
            } else {
                buffer.append(URelaxer.escapeCharData(value_.toString()));
            }
        }
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        if (value_ instanceof org.w3c.dom.Node) {
            buffer.write(URelaxer.node2String4Data((Node)value_));
        } else {
            if (cdata_) {
                buffer.write("<![CDATA[");
                buffer.write(value_.toString());
                buffer.write("]]>");
            } else {
                buffer.write(URelaxer.escapeCharData(value_.toString()));
            }
        }
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        if (value_ instanceof org.w3c.dom.Node) {
            buffer.print(URelaxer.node2String4Data((Node)value_));
        } else {
            if (cdata_) {
                buffer.print("<![CDATA[");
                buffer.print(value_.toString());
                buffer.print("]]>");
            } else {
                buffer.print(URelaxer.escapeCharData(value_.toString()));
            }
        }
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(StringBuffer buffer) {
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextAttribute(Writer buffer) throws IOException {
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(PrintWriter buffer) {
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>RString</code>.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return boolean
     */
    public static boolean isMatch(RStack stack) {
        return (stack.peek() instanceof String);
    }
}
