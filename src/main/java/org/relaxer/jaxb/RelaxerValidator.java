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

package org.relaxer.jaxb;

import javax.xml.bind.PropertyException;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.Validator;
import javax.xml.bind.helpers.DefaultValidationEventHandler;

/**
 * RelaxerValidator
 *
 * @since   Feb. 17, 2003
 * @version Feb.  2, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RelaxerValidator implements Validator {
    private RelaxerJaxbContext context_;
    private ValidationEventHandler handler_;

    public RelaxerValidator(RelaxerJaxbContext context) {
        context_ = context;
        handler_ = new DefaultValidationEventHandler();
    }

    public void setEventHandler(ValidationEventHandler handler) {
        handler_ = handler;
    }

    public ValidationEventHandler getEventHandler() {
        return (handler_);
    }

    public boolean validate(Object o) {
        throw (new UnsupportedOperationException());
    }

    public boolean validateRoot(Object o) {
        throw (new UnsupportedOperationException());
    }

    public Object getProperty(String arg0) throws PropertyException {
        throw (new PropertyException("No properties supported."));
    }

    public void setProperty(String arg0, Object arg1)
        throws PropertyException {
        throw (new PropertyException("No properties supported."));
    }
}
