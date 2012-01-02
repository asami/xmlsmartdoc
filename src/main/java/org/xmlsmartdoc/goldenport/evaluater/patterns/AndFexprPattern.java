/*
 * GoldenPort
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

package org.xmlsmartdoc.goldenport.evaluater.patterns;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlsmartdoc.goldenport.engine.GoldenportException;
import org.xmlsmartdoc.goldenport.engine.IPortConstants;
import org.xmlsmartdoc.goldenport.engine.PortContext;
import org.xmlsmartdoc.goldenport.engine.PortEngine;
import org.xmlsmartdoc.goldenport.engine.PortNodeList;
import org.xmlsmartdoc.goldenport.evaluater.pattern.*;

import com.AsamiOffice.xml.UDOM;

/**
 * AndFexprPattern
 *
 * @since   Jul.  7, 2002
 * @version Apr. 10, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class AndFexprPattern extends FexprPattern {
    public int startElement(
        Element element,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        PortEngine engine = context.getEngine();
        Element[] children = UDOM.getElements(element);
        for (int i = 0; i < children.length; i++) {
            Node child = engine.eval(children[i], context);
            if (child != null) {
                result.addChild(child);
            }
        }
        return (IPortConstants.EVAL_DONE);
    }
}
