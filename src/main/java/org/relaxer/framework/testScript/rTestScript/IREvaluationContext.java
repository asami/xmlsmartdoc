package org.relaxer.framework.testScript.rTestScript;

/**
 * IREvaluationContext
 *
 * @since   Jan. 13, 2002
 * @version Aug. 31, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IREvaluationContext {
    IREvaluationContext newContext();
    void setProperty(Object value);
    public Object getProperty();
    public void setProperty(String key, Object value);
    public Object getProperty(String key);
    public void setSlot(String key, Object value);
    public Object getSlot(String key);
}
