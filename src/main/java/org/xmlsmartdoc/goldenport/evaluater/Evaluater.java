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

package org.xmlsmartdoc.goldenport.evaluater;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlsmartdoc.goldenport.engine.AbstractPort;
import org.xmlsmartdoc.goldenport.engine.GoldenportException;
import org.xmlsmartdoc.goldenport.engine.PortContext;
import org.xmlsmartdoc.goldenport.engine.PortNodeList;
import org.xmlsmartdoc.goldenport.evaluater.patterns.*;
import org.xmlsmartdoc.goldenport.selecters.AllSelecter;

/**
 * Evaluater
 *
 * @since   Jul.  6, 2002
 * @version Apr. 11, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
 */
public class Evaluater extends AbstractPort {
    private EvaluaterContext rootContext_;

    public Evaluater() {
        setSelecter(AllSelecter.getSingleton());
        rootContext_ = new EvaluaterContext();
//        rootContext_.addDefine("goldenport", new GoldenportSubrPattern());
//        rootContext_.addDefine("define", new DefineSubrPattern());
        rootContext_.addDefine("copy-of", new CopyOfSubrPattern());
        rootContext_.addDefine("text", new TextSubrPattern());
        rootContext_.addDefine("and", new AndFexprPattern());
        rootContext_.addDefine("or", new OrFexprPattern());
    }

    public Evaluater(Node doc) {
        this();
        rootContext_.setup(doc);
    }
    
    public Evaluater(Node[] docs) {
        this();
        rootContext_.setup(docs);
    }

    public int startElement(
        Element element,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        String name = element.getLocalName();
        if (UEvaluater.isGoldenportDefineSet(element)) {
            return (EVAL_DONE);
        }
        EvaluaterContext ec
            = (EvaluaterContext)context.getProperty("evaluater");
        ec = new EvaluaterContext(ec);
        ec.setup(element);
        context.setProperty("evaluater", ec);
        Atom atom = getAtom_(name, ec);
        if (atom != null) {
            return (atom.startElement(element, context, result));
        } else {
            result.setup(element);
            return (EVAL_CHILDREN);
        }
    }

    public void endElement(
        Element element,
        PortNodeList children,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        String name = element.getLocalName();
        EvaluaterContext ec
            = (EvaluaterContext)context.getProperty("evaluater");
        Atom atom = getAtom_(name, ec);
        if (atom != null) {
            atom.endElement(element, children, context, result);
        } else {
            result.setup(children);
        }
        context.setProperty("evaluater", ec.getParent());
    }

    private Atom getAtom_(String name, EvaluaterContext ec) {
        Atom atom = ec.getAtom(name);
        if (atom != null) {
            return (atom);
        }
        return (rootContext_.getAtom(name));
    }
}
