/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc;

import java.io.*;
import com.AsamiOffice.jaba2.util.ExtensibleFactory;
import org.xmlsmartdoc.SmartDoc.adapter.*;

/**
 * AdapterFactory
 *
 * @since   May. 11, 1999
 * @version Oct. 22, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public final class AdapterFactory extends ExtensibleFactory {
    protected static AdapterFactory factory__ = new AdapterFactory();

    public static AdapterFactory getFactory() {
        return (factory__);
    }

    protected AdapterFactory() {
        try {
            _setup(getClass().getResource(
                "/org/xmlsmartdoc/SmartDoc/Adapter.xml"
            ));
        } catch (IOException e) {
            throw (new SmartDocErrorException(e));
        }
    }

    public IAdapter getAdapter(String name) {
        if ("none".equals(name)) {
            return (null);
        }
        IAdapter adapter = (IAdapter)getTargetObject(name);
        if (adapter == null) {
            USmartDoc.warning("invalid adapter: " + name);
            return (null);
        }
        return (adapter);
    }

    public IAdapter[] getDefaultAdapters(Content content) {
        IAdapter adapter = getDefaultAdapter(content);
        if (adapter == null) {
            return (null);
        }
        return (new IAdapter[] { adapter } );
    }

    public IAdapter getDefaultAdapter(Content content) {
        if (content instanceof Table) {
            return (getAdapter("csv"));
        } else if (content instanceof THead) {
            return (getAdapter("csv"));
        } else if (content instanceof TFoot) {
            return (getAdapter("csv"));
        } else if (content instanceof TBody) {
            return (getAdapter("csv"));
        } else if (content instanceof Tr) {
            return (null);
        } else if (content instanceof Col) {
            return (null);
        } else if (content instanceof Img) {
            return (getAdapter("autoimage"));
        } else if (content instanceof ImageFigure) {
            return (getAdapter("autoimage"));
        } else if (content instanceof Pre) {
            return (getAdapter("text"));
        } else if (content instanceof Program) {
            return (getAdapter("text"));
        } else if (content instanceof Console) {
            return (getAdapter("text"));
        } else if (content instanceof Native) {
            return (getAdapter("text"));
        } else if (content instanceof Macro) {
            return (getAdapter("macro"));
        } else {
            switch (content.getEntityType()) {

            case Content.ENTITY_BLOCK:
                return (getAdapter("sdoc"));
            case Content.ENTITY_INLINE:
                return (getAdapter("sdoc"));
            case Content.ENTITY_CONTAINER:
                return (getAdapter("sdoc"));
            case Content.ENTITY_CONTROL:
                return (null);
            default:
                throw (new InternalError());
            }
        }
    }
}
