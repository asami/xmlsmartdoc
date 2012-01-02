/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.datatype;

/**
 * RelaxerObjectDatatype
 *
 * @since   2004/02/10
 * @version 2004/02/10
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RelaxerObjectDatatype extends AbstractDatatype {
    private final Class type_;

    public RelaxerObjectDatatype(String name, Class type) {
        super(name);
        type_ = type;
    }

    public Class getJavaClass() {
        return (type_);
    }
}
