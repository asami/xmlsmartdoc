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

package com.AsamiOffice.jaba2.xml.processor;

import com.AsamiOffice.jaba2.xml.IProcessor;

import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;

import com.AsamiOffice.xml.sax.SimpleErrorHandler;

/**
 * AbstractProcessor
 *
 * @since   Aug. 12, 2000
 * @version Oct. 15, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class AbstractProcessor implements IProcessor {
    private ErrorHandler errorHandler_;
    private EntityResolver entityResolver_;

    protected AbstractProcessor() {
	errorHandler_ = new SimpleErrorHandler();
    }

    public final void setErrorHandler(ErrorHandler handler) {
	errorHandler_ = handler;
    }

    public final ErrorHandler getErrorHandler() {
	return (errorHandler_);
    }

    public final void setEntityResolver(EntityResolver handler) {
	entityResolver_ = handler;
    }

    public final EntityResolver getEntityResolver() {
	return (entityResolver_);
    }
}
