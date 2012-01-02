/*
 * org.xmlsmartdoc.goldenport
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.xmlsmartdoc.goldenport.evaluater;

import org.w3c.dom.Element;
import org.xmlsmartdoc.goldenport.engine.IPortConstants;

/**
 * UEvaluater
 *
 * @since   2004/04/09
 * @version 2004/04/09
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class UEvaluater implements IPortConstants {
    private static String OLD_PORT_NS = "http://www.relaxer.org/xmlns/goldenport";

    public static boolean isGoldenportNode(Element element) {
        String ns = element.getNamespaceURI();
        return (PORT_NS.equals(ns) ||
                OLD_PORT_NS.equals(ns)); 
    }

    public static boolean isGoldenportDefineSet(Element element) {
        if (!isGoldenportNode(element)) {
            return (false);
        }
        if ("goldenport".equals(element.getLocalName())) {
            return (true);
        }
        if ("macro".equals(element.getLocalName())) { // compatibility
            return (true);
        }
        return (false);
    }
}
