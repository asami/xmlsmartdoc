package org.relaxer.framework.testScript.rTestScript;

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
