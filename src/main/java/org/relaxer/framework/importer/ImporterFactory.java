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
package org.relaxer.framework.importer;

import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * ImporterFactory
 *
 * @since   Oct.  2, 2003
 * @version Aug.  9, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ImporterFactory {
    private IRModelContext context_;

    public static ImporterFactory newInstance(IRModelContext context) {
        return (new ImporterFactory(context));
    }
    
    public ImporterFactory(IRModelContext context) {
        context_ = context;
    }

    public IImporter getImporter(String name) {
        return (new DefaultImporter(context_));        
    }
}
