/*
 * org.xmlsmartdoc.goldenport
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.xmlsmartdoc.goldenport.adapters;

import org.w3c.dom.Element;
import org.xmlsmartdoc.goldenport.adapter.AbstractAdapter;
import org.xmlsmartdoc.goldenport.engine.GoldenportException;
import org.xmlsmartdoc.goldenport.engine.PortContext;
import org.xmlsmartdoc.goldenport.engine.PortNodeList;
import org.xmlsmartdoc.goldenport.selecters.NamespaceSelecter;

/**
 * WhatsNewAdapter
 *
 * @since   Apr.  9, 2004
 * @version Apr. 13, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class WhatsNewAdapter extends AbstractAdapter {
    public WhatsNewAdapter() {
        setSelecter(new NamespaceSelecter(WhatsNewMaker.WHATSNEW_NS));
    }

    public void endElement(
        Element element,
        PortNodeList halfResult,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        String name = element.getLocalName();
        if (!WhatsNewMaker.ELEMENT_WHATSNEW.equals(name)) {
            return;
        }
        WhatsNewMaker maker = new WhatsNewMaker(
            this, 
            element, 
            halfResult, 
            context, 
            result
        );
        maker.setElement(element);
        maker.setContext(context);
        maker.setResult(result);
        maker.make();
    }
}
