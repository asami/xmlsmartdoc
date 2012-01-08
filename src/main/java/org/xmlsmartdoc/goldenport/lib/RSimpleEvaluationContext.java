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
package org.xmlsmartdoc.goldenport.lib;

import java.util.*;

/**
 * RSimpleEvaluationContext
 *
 * @since   Jan. 13, 2002
 * @version Aug. 31, 2002
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RSimpleEvaluationContext
    implements IREvaluationContext, Cloneable {

    private RSimpleEvaluationContext parent_ = null;
    private Object property_;
    private Map properties_ = new HashMap();
    private Map slots_ = new HashMap();

    public IREvaluationContext newContext() {
        RSimpleEvaluationContext newContext
            = (RSimpleEvaluationContext)clone();
        newContext._setParent(this);
        return (newContext);
    }

    protected void _setParent(RSimpleEvaluationContext parent) {
        parent_ = parent;
    }

    public void setProperty(Object value) {
        property_ = value;
    }

    public Object getProperty() {
        return (property_);
    }

    public void setProperty(String key, Object value) {
        properties_.put(key, value);
    }

    public Object getProperty(String key) {
        return (properties_.get(key));
    }

    public void setSlot(String key, Object value) {
        slots_.put(key, value);
    }

    public Object getSlot(String key) {
        if (slots_.containsKey(key)) {
            return (slots_.get(key));
        } else if (parent_ != null) {
            return (parent_.getSlot(key));
        } else {
            return (null);
        }
    }

    public Object clone() {
        try {
            return (super.clone());
        } catch (CloneNotSupportedException e) {
            throw (new InternalError());
        }
    }
}
