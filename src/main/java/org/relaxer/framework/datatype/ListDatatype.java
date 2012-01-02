/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.datatype;

import java.lang.reflect.Array;
import java.util.List;

import org.w3c.dom.Node;

import com.AsamiOffice.text.UString;

/**
 * ListDatatype
 *
 * @since   Jan.  6, 2004
 * @version Jan.  6, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ListDatatype extends AbstractDatatype {
    private IDatatype componentDatatype_;
    public ListDatatype(String name, IDatatype datatype) {
        super(name);        
        componentDatatype_ = datatype;
    }

    public Class getJavaClass() {
        Object array = Array.newInstance(
        componentDatatype_.getJavaClass(),
            0
        );
        return (array.getClass());
    }

    public boolean isValid(String text) {
        String[] list = UString.getTokens(text, " \n\r");
        for (int i = 0;i < list.length;i++) {
            if (!componentDatatype_.isValid(list[i])) {
                return (false);
            }
        }
        return (true);
    }

    public boolean isValid(Node xml) {
        String text = _convertText(xml);
        if (text == null) {
            return (false);
        }
        return (isValid(text));
    }

    public boolean isValid(Object object) {
        if (object instanceof Object[]) {
            Object[] array = (Object[])object;
            return (isValid_(array));
        } else if (object instanceof List) {
            List list = (List)object;
            return (isValid_(list.toArray()));
        } else {
            return (false);
        }
    }

    private boolean isValid_(Object[] array) {
        for (int i = 0;i < array.length;i++) {
            if (!componentDatatype_.isValid(array[i])) {
                return (false);
            }
        }
        return (true);
    }

    public String getTextByObject(Object object) {
        if (object instanceof Object[]) {
            Object[] array = (Object[])object;
            return (getTextByObject_(array));
        } else if (object instanceof List) {
            List list = (List)object;
            return (getTextByObject_(list.toArray()));
        } else {
            return (componentDatatype_.getTextByObject(object));
        }
    }
    
    private String getTextByObject_(Object[] array) {
        StringBuffer sb = new StringBuffer();
        sb.append(componentDatatype_.getTextByObject(array[0]));
        for (int i = 1;i < array.length;i++) {
            sb.append(" ");
            sb.append(componentDatatype_.getTextByObject(array[i]));
        }
        return (new String(sb));
    }

    public Object getObjectByText(String text) {
        String[] list = UString.getTokens(" \n\r");
        Object[] array = (Object[])Array.newInstance(
            componentDatatype_.getJavaClass(),
            list.length
        );
        for (int i = 0;i < list.length;i++) {
            array[i] = componentDatatype_.getObjectByText(list[i]);
        }
        return (array);
    }
}
