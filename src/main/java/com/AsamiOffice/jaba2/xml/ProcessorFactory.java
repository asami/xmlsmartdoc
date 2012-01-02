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

package com.AsamiOffice.jaba2.xml;

import java.io.*;
import com.AsamiOffice.jaba2.util.*;
import com.AsamiOffice.jaba2.xml.processor.JAXPProcessor;

/**
 * ProcessorFactory
 *
 * @since   Jul. 28, 1999
 * @version Jun. 10, 2005
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class ProcessorFactory extends ExtensibleFactory {
    protected static ProcessorFactory factory__;
    private static IProcessor processor__ = null;

    public static void setProcessor(IProcessor processor) {
        processor__ = processor;
    }

    public static IProcessor getProcessor() {
        if (processor__ != null) {
            return (processor__);
        } else {
            return (new JAXPProcessor());
        }
    }

    public static IProcessor getProcessor(String name) {
        if (factory__ == null) {
            factory__ = new ProcessorFactory();
        }
        return (factory__._getProcessor(name));
    }

    public static ProcessorFactory getFactory() {
        return (factory__);
    }

    protected ProcessorFactory() {
        try {
            _setup(
                getClass().getResource(
                    "/com/AsamiOffice/jaba2/xml/Processor.xml"
                )
            );
        } catch (IOException e) {
            throw (new InternalError());
        }
    }

    private IProcessor _getProcessor() {
        return (new JAXPProcessor());
    }

    private IProcessor _getProcessor(String name) {
        IProcessor processor = (IProcessor)getTargetObject(name);
        if (processor != null) {
            return processor;
        } else {
            // TODO warning
            return _getProcessor();
        }
    }
}
