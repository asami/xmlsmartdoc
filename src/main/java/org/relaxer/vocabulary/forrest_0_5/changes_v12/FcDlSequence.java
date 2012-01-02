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
package org.relaxer.vocabulary.forrest_0_5.changes_v12;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import org.w3c.dom.*;

/**
 * <b>FcDlSequence</b> is generated from changes_v12.rng by Relaxer.
 *
 * @version changes_v12.rng (Wed Mar 03 11:14:25 JST 2004)
 * @author  Relaxer 1.1b (http://www.relaxer.org)
 */
public class FcDlSequence implements java.io.Serializable, Cloneable {
    private FcDt dt_;
    private FcDd dd_;

    /**
     * Creates a <code>FcDlSequence</code>.
     *
     */
    public FcDlSequence() {
    }

    /**
     * Creates a <code>FcDlSequence</code>.
     *
     * @param source
     */
    public FcDlSequence(FcDlSequence source) {
        setup(source);
    }

    /**
     * Creates a <code>FcDlSequence</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public FcDlSequence(RStack stack) {
        setup(stack);
    }

    /**
     * Initializes the <code>FcDlSequence</code> by the FcDlSequence <code>source</code>.
     *
     * @param source
     */
    public void setup(FcDlSequence source) {
        int size;
        if (source.dt_ != null) {
            setDt((FcDt)source.getDt().clone());
        }
        if (source.dd_ != null) {
            setDd((FcDd)source.getDd().clone());
        }
    }

    /**
     * Initializes the <code>FcDlSequence</code> by the Stack <code>stack</code>
     * that contains Elements.
     * This constructor is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     */
    public void setup(RStack stack) {
        Element element = stack.getContextElement();
        setDt(new FcDt(stack));
        setDd(new FcDd(stack));
    }

    /**
     * @return Object
     */
    public Object clone() {
        return (new FcDlSequence(this));
    }

    /**
     * Creates a DOM representation of the object.
     * Result is appended to the Node <code>parent</code>.
     *
     * @param parent
     */
    public void makeElement(Node parent) {
        Document doc = parent.getOwnerDocument();
        Element element = (Element)parent;
        int size;
        this.dt_.makeElement(element);
        this.dd_.makeElement(element);
    }

    /**
     * Gets the FcDt property <b>dt</b>.
     *
     * @return FcDt
     */
    public FcDt getDt() {
        return (dt_);
    }

    /**
     * Sets the FcDt property <b>dt</b>.
     *
     * @param dt
     */
    public void setDt(FcDt dt) {
        this.dt_ = dt;
    }

    /**
     * Gets the FcDd property <b>dd</b>.
     *
     * @return FcDd
     */
    public FcDd getDd() {
        return (dd_);
    }

    /**
     * Sets the FcDd property <b>dd</b>.
     *
     * @param dd
     */
    public void setDd(FcDd dd) {
        this.dd_ = dd;
    }

    /**
     * Makes an XML text representation.
     *
     * @return String
     */
    public String makeTextDocument() {
        StringBuffer buffer = new StringBuffer();
        makeTextElement(buffer);
        return (new String(buffer));
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(StringBuffer buffer) {
        int size;
        dt_.makeTextElement(buffer);
        dd_.makeTextElement(buffer);
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextElement(Writer buffer) throws IOException {
        int size;
        dt_.makeTextElement(buffer);
        dd_.makeTextElement(buffer);
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextElement(PrintWriter buffer) {
        int size;
        dt_.makeTextElement(buffer);
        dd_.makeTextElement(buffer);
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(StringBuffer buffer) {
        int size;
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     * @exception IOException
     */
    public void makeTextAttribute(Writer buffer) throws IOException {
        int size;
    }

    /**
     * Makes an XML text representation.
     *
     * @param buffer
     */
    public void makeTextAttribute(PrintWriter buffer) {
        int size;
    }

    /**
     * Returns a String representation of this object.
     * While this method informs as XML format representaion, 
     *  it's purpose is just information, not making 
     * a rigid XML documentation.
     *
     * @return String
     */
    public String toString() {
        try {
            return (makeTextDocument());
        } catch (Exception e) {
            return (super.toString());
        }
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FcDlSequence</code>.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return boolean
     */
    public static boolean isMatch(RStack stack) {
        return (isMatchHungry(stack.makeClone()));
    }

    /**
     * Tests if elements contained in a Stack <code>stack</code>
     * is valid for the <code>FcDlSequence</code>.
     * This method consumes the stack contents during matching operation.
     * This mehtod is supposed to be used internally
     * by the Relaxer system.
     *
     * @param stack
     * @return boolean
     */
    public static boolean isMatchHungry(RStack stack) {
        RStack target = stack;
        boolean $match$ = false;
        Element element = stack.peekElement();
        Element child;
        if (!FcDt.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        if (!FcDd.isMatchHungry(target)) {
            return (false);
        }
        $match$ = true;
        return ($match$);
    }
}
