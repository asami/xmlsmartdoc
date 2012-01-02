/*
 * org.xmlsmartdoc.goldenport
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.xmlsmartdoc.goldenport.filters;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.xmlsmartdoc.goldenport.engine.GoldenportException;
import org.xmlsmartdoc.goldenport.engine.PortContext;
import org.xmlsmartdoc.goldenport.engine.PortNodeList;
import org.xmlsmartdoc.goldenport.filter.AbstractFilter;

/**
 * LocaleFilter
 *
 * @since   Apr.  4, 2004
 * @version Apr. 10, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class LocaleFilter extends AbstractFilter {
    private boolean isRemoveLocaleAttribute_ = false;
    private String localeAttributeName_;
    private String localeAttributeNamespace_;
    private String targetLocale_;

    public void setup(Element element) {
        localeAttributeName_ = getProperty("locale-attribute-name", "locale");
        localeAttributeNamespace_ = getProperty("locale-attribute-ns");
        targetLocale_ = getProperty("locale");
        isRemoveLocaleAttribute_
            = getBooleanProperty("remove-locale-attribute", true);
    }

    public int startElement(
        Element element,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        Attr attr = getLocaleAttribute_(element);
        if (attr == null) {
            return (super.startElement(element, context, result));
        } else {
            if (isMatch_(attr.getValue())) {
                return (super.startElement(element, context, result));
            } else {
                return (EVAL_DONE);
            }
        }
    }

    public void endElement(
        Element element,
        PortNodeList halfResult,
        PortContext context,
        PortNodeList result
    ) throws GoldenportException {
        super.endElement(element, halfResult, context, result);
        if (isRemoveLocaleAttribute_) {
            Element resultElement = result.getElement();
            if (localeAttributeNamespace_ != null) {
                resultElement.removeAttributeNS(
                    localeAttributeNamespace_,
                    localeAttributeName_
                );
            } else {
                resultElement.removeAttribute(localeAttributeName_);
            }
        }
    }

    private Attr getLocaleAttribute_(Element element) {
        if (localeAttributeNamespace_ != null) {
            return (
                element.getAttributeNodeNS(
                    localeAttributeNamespace_,
                    localeAttributeName_
                )
            );
        } else {
            return (
                element.getAttributeNode(localeAttributeName_)
            );
        }
    }

    private boolean isMatch_(String value) {
        return (targetLocale_.equals(value)); // TODO
    }
}
