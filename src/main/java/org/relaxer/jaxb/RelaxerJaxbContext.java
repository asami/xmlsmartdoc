/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
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

import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.bind.*;

/**
 * RelaxerJaxbContext
 *
 * @since   Feb. 17, 2003
 * @version Jun.  3, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RelaxerJaxbContext extends JAXBContext {
    private Object factory_;

    public RelaxerJaxbContext(Object factory) {
	factory_ = factory;
    }

    public Unmarshaller createUnmarshaller() throws JAXBException {
	try {
	    return (new RelaxerUnmarshaller(this));
	} catch (ParserConfigurationException e) {
	    throw (new JAXBException(e.getMessage(), e));
	}
    }

    public Marshaller createMarshaller() throws JAXBException {
	return (new RelaxerMarshaller(this));
    }

    public Validator createValidator() {
	return (new RelaxerValidator(this));
    }

    public void setRelaxerFactory(Object factory) {
	factory_ = factory;
    }

    public Object getRelaxerFactory() {
	return (factory_);
    }
}
