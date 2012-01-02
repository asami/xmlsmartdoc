/*
 * org.xmlsmartdoc.goldenport
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.xmlsmartdoc.goldenport.engine;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/**
 * AbstractPortMakder
 *
 * @since   2004/04/12
 * @version 2004/04/12
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public abstract class AbstractPortMakder implements IPortConstants {
    protected IPort _port;
    protected Element _element;
    protected PortContext _context;
    protected PortNodeList _halfResult;
    protected PortNodeList _result;
    
    public AbstractPortMakder(
        IPort port, 
        Element element, 
        PortNodeList halfResult, 
        PortContext context, 
        PortNodeList result
    ) {
        _port = port;
        _element = element;
        _halfResult = halfResult;
        _result = result;
    }

    protected AbstractPortMakder(IPort port) {
    }

    public final void setElement(Element element) {
        _element = element;
    }
    
    public final Element getElement() {
        return (_element); 
    }
    
    public final void setHalfResult(PortNodeList halfResult) {
        _halfResult = halfResult;
    }
    
    public final PortNodeList getHalfResult() {
        return (_halfResult);
    }

    public final void setContext(PortContext context) {
        _context = context;
    }
    
    public final PortContext getContext() {
        return (_context);
    }

    public final void setResult(PortNodeList result) {
        _result = result;
    }
    
    public final PortNodeList getResult() {
        return (_result);
    }

    public String getProperty(String name) {
        return (_port.getProperty(name));
    }

    public String getAdjustedProperty(String name) {
        if (_element != null) {
            Attr attr = _element.getAttributeNode(name);
            if (attr != null) {
                return (attr.getNodeValue());
            }
        }
        return (getProperty(name));
    }
}
